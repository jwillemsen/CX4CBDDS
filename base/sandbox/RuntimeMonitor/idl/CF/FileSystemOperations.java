package CF;


/**
* CF/FileSystemOperations.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from CF.idl
* Monday, May 4, 2009 2:19:34 PM EDT
*/


/* The FileSystem interface defines the CORBA operations to enable
         remote access to a physical file system.  */
public interface FileSystemOperations 
{

  /* The remove operation removes the file with the given filename. */
  void remove (String fileName) throws CF.FileException, CF.InvalidFileName;

  /* The copy operation copies the source file with the specified
               sourceFileName to the destination file with the specified
               destinationFileName. */
  void copy (String sourceFileName, String destinationFileName) throws CF.InvalidFileName, CF.FileException;

  /* The exists operation checks to see if a file exists based on
               the filename parameter. */
  boolean exists (String fileName) throws CF.InvalidFileName;

  /* The list operation provides the ability to obtain a list of files
               along with their information in the file system according to
               a given search pattern. */
  CF.FileSystemPackage.FileInformationType[] list (String pattern) throws CF.FileException, CF.InvalidFileName;

  /* The create operation creates a new File based upon the provided
               file name and returns a File to the opened file. */
  CF.File create (String fileName) throws CF.InvalidFileName, CF.FileException;

  /* The open operation opens a file for reading or writing based upon
               the input fileName. */
  CF.File open (String fileName, boolean read_Only) throws CF.InvalidFileName, CF.FileException;

  /* The mkdir operation creates a file system directory based on the
               directoryName given. */
  void mkdir (String directoryName) throws CF.InvalidFileName, CF.FileException;

  /* The rmdir operation removes a file system directory based on the
               directoryName given. */
  void rmdir (String directoryName) throws CF.InvalidFileName, CF.FileException;

  /* The query operation returns file system information to the 
               calling client based upon the given fileSystemProperties' ID. */
  void query (CF.PropertiesHolder fileSystemProperties) throws CF.FileSystemPackage.UnknownFileSystemProperties;
} // interface FileSystemOperations
