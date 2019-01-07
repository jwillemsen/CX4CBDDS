#include "oeExecutableDeviceEnvironment.h"

// GetProcessId function prototype
bool SpawnProcess(int argc, char** argv, unsigned long ulStackSize,
		unsigned long ulPriority, CF::ExecutableDevice::ProcessID_Type& id, ExecInfoList& execInfoList, std::string &strErr)
{
	id = -1;

	// verify the file is loaded before it is executed.
	struct stat st;
	if (stat (argv[0], &st) != 0)
	{
		strErr = "File does not exist.";
		return false;
	}

	pid_t pid = rtpSpawn (argv[0], (const char **)argv, (const char **)environ, ulPriority, ulStackSize, RTP_LOADED_WAIT, 0);

	if (pid == ERROR)
	{
		strErr = "Failed to spawn RTP.";
		return false;
	}
	id = (CF::ExecutableDevice::ProcessID_Type) pid;
	return true;
}

bool KillProcess(CF::ExecutableDevice::ProcessID_Type id, ExecInfoList& execInfoList, std::string &strErr)
{
	int status = kill((pid_t) id, SIGTERM); // 0 is returned on success

	if (status) {
		strErr = "Could not send SIGTERM signal";
		return false;
	}

	pid_t nRet = waitpid((pid_t) id, &status, WNOHANG); // Check if process is terminated

	if (nRet == -1) {
		strErr = "Process did not change state";
		return false;
	}

	return true;
}

OEFileInfo * FindFile (const char * filename, FileList& fileList)
{
	return fileList.find (filename);
}

void FileList::add (std::string filename, std::string localFilename, CF::LoadableDevice::LoadType type)
{
	OEFileInfo * fileInfo = new OEFileInfo (filename, localFilename, type);

	if (head) {
		tail->next = fileInfo;
		tail = fileInfo;
	}
	else {
		head = tail = fileInfo;
	}
}

bool FileList::remove (std::string filename)
{
	OEFileInfo *prev = NULL;

	for (OEFileInfo *temp = head; temp; prev = temp, temp = temp->next) {
		if (filename.compare (temp->strFilename) == 0) {
			if (prev) {
				prev->next = temp->next;
				if (temp->next == NULL) {
					tail = prev;
				}
			}
			else {
				head = temp->next;
				if (temp->next == NULL) {
					tail = NULL;
				}
			}
			delete temp;
			return true;
		}
	}
	return false;
}

OEFileInfo * FileList::find (std::string filename)
{
	for (OEFileInfo * fileInfo = head; fileInfo; fileInfo = fileInfo->next) {
		if (filename.compare (fileInfo->strFilename) == 0) {
			return fileInfo;
		}
	}
	return NULL;
}

bool LoadFile(CF::FileSystem_ptr fs, const char *fileName, std::string deviceId, CF::LoadableDevice::LoadType loadKind, FileList& fileList, std::string& strErr OE_ENV_ARGN)
{
	FILE *pTmpFile = 0;
	CF::File_var pCurFile;
	int iNumRead = 0;
	int iBufLen = 32768;
	CF::OctetSequence_var buffer;
	std::string strTmpPath = "tmp/";

	struct stat st;
	if( stat( strTmpPath.c_str(), &st)) { // directory does not exist, returns 0 on success
		if( mkdir(strTmpPath.c_str(), S_IRWXU | S_IRWXG | S_IROTH | S_IXOTH)) { // failed, returns 0 on success
			strErr = "LoadFile failed to create directory";
			return false;
		}
	}
	
	size_t found=deviceId.find(":");
	if( found != std::string::npos) {
		deviceId = deviceId.replace(deviceId.find(":"), 1, "_");
	}
	std::string path = strTmpPath + deviceId + "/" ;
	
	if( stat( path.c_str(), &st) ) {
		if( mkdir( path.c_str(), S_IRWXU | S_IRWXG | S_IROTH | S_IXOTH )) {
			strErr = "LoadFile failed to create subdirectory";
			return FALSE;
		}
	}

	// strip path information if it exists
	const char * filestr = strrchr(fileName,'/');
	if(filestr == NULL)
	{
		path += fileName;
	}
	else
	{
		path += filestr + 1;
	}

	pTmpFile = fopen( path.c_str(), "wb");

	if(!pTmpFile)
	{
		strErr = "Could not open temporary file.";
		return false;
	}

	pCurFile = fs->open(fileName, 1 OE_ENV_VARN);
	OE_CHECK_ENV_RETURN(false);

	if(CORBA::is_nil(pCurFile))
	{
		strErr = "Could not open the passed-in fileName.";
		fclose(pTmpFile);
		return false;
	}

	do
	{
		OE_TRY_LABEL(A)
		{
			pCurFile->read(buffer, iBufLen OE_ENV_VARN);
			OE_CHECK_ENV_LABEL(A);
		}
		OE_CATCH(CF::File::IOException, e)
		{
			strErr = "Could not read from the passed-in fileName.";
			fclose(pTmpFile);

			OE_TRY_LABEL(B)
			{
				pCurFile->close(OE_ENV_VAR1);
				OE_CHECK_ENV_LABEL(B);
			}
			OE_CATCH_ANY
			{
				// Ignore exception
			}
			OE_END_TRY

			OE_THROW_RETURN(e, false);
		}
		OE_END_TRY

		iNumRead = buffer->length();
		fwrite((void*)buffer->get_buffer(), sizeof(CORBA::Octet), iNumRead, pTmpFile);
	}
	while(iNumRead> 0);

	fclose(pTmpFile);
	pCurFile->close(OE_ENV_VAR1);
	OE_CHECK_ENV_RETURN(false);

	if(chmod(path.c_str(), S_IRWXU | S_IRWXG | S_IROTH | S_IWOTH) < 0)
	{
		return false;
	}
	
	fileList.add (fileName, path, loadKind);

	return true;
}

bool UnloadFile(const char *fileName, FileList& fileList, std::string& strErr)
{
	int result = 0;
	int i= 0;

	OEFileInfo *file = FindFile (fileName, fileList);

	if (file == NULL)
	{
		strErr = "UnloadFile failed to find passed-in fileName";
		return false;
	}

	do
	{
		if( result)
		{
			sleep(1);
		}
		result = remove( file->strLocalFilename.c_str()); // 0 == success
		++i;
	}
	while( result && (i < 3));

	if( result) // could not delete file
	{
		strErr = "UnloadFile failed to delete file";
		return false;
	}

	size_t found = file->strLocalFilename .rfind( "/" );
	if( found != std::string::npos)
	{
		std::string path = file->strLocalFilename.substr( 0, found );
		// rmdir() only removes a directory that is empty.
		rmdir( path.c_str() );
		rmdir("tmp/");
	}

	// Erase file from list
	fileList.remove (fileName);

	return true;
}

// End-Of-File
//------------------------------------------------------------------------------
