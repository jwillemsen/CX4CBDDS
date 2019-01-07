package CF;


/**
* CF/_FileManagerStub.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from CF.idl
* Monday, May 4, 2009 2:19:35 PM EDT
*/


/* Multiple, distributed FileSystems may be accessed through
         a FileManager. The FileManager interface appears to be a single
         FileSystem although the actual file storage may span multiple
         physical file systems. */
public class _FileManagerStub extends org.omg.CORBA.portable.ObjectImpl implements CF.FileManager
{


  /* The mount operation associates a FileSystem with a mount
  		     point (a directory name). */
  public void mount (String mountPoint, CF.FileSystem file_System) throws CF.InvalidFileName, CF.FileManagerPackage.InvalidFileSystem, CF.FileManagerPackage.MountPointAlreadyExists
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("mount", true);
                $out.write_string (mountPoint);
                CF.FileSystemHelper.write ($out, file_System);
                $in = _invoke ($out);
                return;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                if (_id.equals ("IDL:CF/InvalidFileName:1.0"))
                    throw CF.InvalidFileNameHelper.read ($in);
                else if (_id.equals ("IDL:CF/FileManager/InvalidFileSystem:1.0"))
                    throw CF.FileManagerPackage.InvalidFileSystemHelper.read ($in);
                else if (_id.equals ("IDL:CF/FileManager/MountPointAlreadyExists:1.0"))
                    throw CF.FileManagerPackage.MountPointAlreadyExistsHelper.read ($in);
                else
                    throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                mount (mountPoint, file_System        );
            } finally {
                _releaseReply ($in);
            }
  } // mount


  /* The unmount operation removes a mounted FileSystem from the
               FileManager whose mounted name matches the input mountPoint
               name. */
  public void unmount (String mountPoint) throws CF.FileManagerPackage.NonExistentMount
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("unmount", true);
                $out.write_string (mountPoint);
                $in = _invoke ($out);
                return;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                if (_id.equals ("IDL:CF/FileManager/NonExistentMount:1.0"))
                    throw CF.FileManagerPackage.NonExistentMountHelper.read ($in);
                else
                    throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                unmount (mountPoint        );
            } finally {
                _releaseReply ($in);
            }
  } // unmount


  /* The getMounts operation returns the FileManager's
               mounted FileSystems. */
  public CF.FileManagerPackage.MountType[] getMounts ()
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("getMounts", true);
                $in = _invoke ($out);
                CF.FileManagerPackage.MountType $result[] = CF.FileManagerPackage.MountSequenceHelper.read ($in);
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return getMounts (        );
            } finally {
                _releaseReply ($in);
            }
  } // getMounts


  /* The remove operation removes the file with the given filename. */
  public void remove (String fileName) throws CF.FileException, CF.InvalidFileName
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("remove", true);
                $out.write_string (fileName);
                $in = _invoke ($out);
                return;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                if (_id.equals ("IDL:CF/FileException:1.0"))
                    throw CF.FileExceptionHelper.read ($in);
                else if (_id.equals ("IDL:CF/InvalidFileName:1.0"))
                    throw CF.InvalidFileNameHelper.read ($in);
                else
                    throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                remove (fileName        );
            } finally {
                _releaseReply ($in);
            }
  } // remove


  /* The copy operation copies the source file with the specified
               sourceFileName to the destination file with the specified
               destinationFileName. */
  public void copy (String sourceFileName, String destinationFileName) throws CF.InvalidFileName, CF.FileException
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("copy", true);
                $out.write_string (sourceFileName);
                $out.write_string (destinationFileName);
                $in = _invoke ($out);
                return;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                if (_id.equals ("IDL:CF/InvalidFileName:1.0"))
                    throw CF.InvalidFileNameHelper.read ($in);
                else if (_id.equals ("IDL:CF/FileException:1.0"))
                    throw CF.FileExceptionHelper.read ($in);
                else
                    throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                copy (sourceFileName, destinationFileName        );
            } finally {
                _releaseReply ($in);
            }
  } // copy


  /* The exists operation checks to see if a file exists based on
               the filename parameter. */
  public boolean exists (String fileName) throws CF.InvalidFileName
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("exists", true);
                $out.write_string (fileName);
                $in = _invoke ($out);
                boolean $result = $in.read_boolean ();
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                if (_id.equals ("IDL:CF/InvalidFileName:1.0"))
                    throw CF.InvalidFileNameHelper.read ($in);
                else
                    throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return exists (fileName        );
            } finally {
                _releaseReply ($in);
            }
  } // exists


  /* The list operation provides the ability to obtain a list of files
               along with their information in the file system according to
               a given search pattern. */
  public CF.FileSystemPackage.FileInformationType[] list (String pattern) throws CF.FileException, CF.InvalidFileName
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("list", true);
                $out.write_string (pattern);
                $in = _invoke ($out);
                CF.FileSystemPackage.FileInformationType $result[] = CF.FileSystemPackage.FileInformationSequenceHelper.read ($in);
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                if (_id.equals ("IDL:CF/FileException:1.0"))
                    throw CF.FileExceptionHelper.read ($in);
                else if (_id.equals ("IDL:CF/InvalidFileName:1.0"))
                    throw CF.InvalidFileNameHelper.read ($in);
                else
                    throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return list (pattern        );
            } finally {
                _releaseReply ($in);
            }
  } // list


  /* The create operation creates a new File based upon the provided
               file name and returns a File to the opened file. */
  public CF.File create (String fileName) throws CF.InvalidFileName, CF.FileException
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("create", true);
                $out.write_string (fileName);
                $in = _invoke ($out);
                CF.File $result = CF.FileHelper.read ($in);
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                if (_id.equals ("IDL:CF/InvalidFileName:1.0"))
                    throw CF.InvalidFileNameHelper.read ($in);
                else if (_id.equals ("IDL:CF/FileException:1.0"))
                    throw CF.FileExceptionHelper.read ($in);
                else
                    throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return create (fileName        );
            } finally {
                _releaseReply ($in);
            }
  } // create


  /* The open operation opens a file for reading or writing based upon
               the input fileName. */
  public CF.File open (String fileName, boolean read_Only) throws CF.InvalidFileName, CF.FileException
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("open", true);
                $out.write_string (fileName);
                $out.write_boolean (read_Only);
                $in = _invoke ($out);
                CF.File $result = CF.FileHelper.read ($in);
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                if (_id.equals ("IDL:CF/InvalidFileName:1.0"))
                    throw CF.InvalidFileNameHelper.read ($in);
                else if (_id.equals ("IDL:CF/FileException:1.0"))
                    throw CF.FileExceptionHelper.read ($in);
                else
                    throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return open (fileName, read_Only        );
            } finally {
                _releaseReply ($in);
            }
  } // open


  /* The mkdir operation creates a file system directory based on the
               directoryName given. */
  public void mkdir (String directoryName) throws CF.InvalidFileName, CF.FileException
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("mkdir", true);
                $out.write_string (directoryName);
                $in = _invoke ($out);
                return;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                if (_id.equals ("IDL:CF/InvalidFileName:1.0"))
                    throw CF.InvalidFileNameHelper.read ($in);
                else if (_id.equals ("IDL:CF/FileException:1.0"))
                    throw CF.FileExceptionHelper.read ($in);
                else
                    throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                mkdir (directoryName        );
            } finally {
                _releaseReply ($in);
            }
  } // mkdir


  /* The rmdir operation removes a file system directory based on the
               directoryName given. */
  public void rmdir (String directoryName) throws CF.InvalidFileName, CF.FileException
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("rmdir", true);
                $out.write_string (directoryName);
                $in = _invoke ($out);
                return;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                if (_id.equals ("IDL:CF/InvalidFileName:1.0"))
                    throw CF.InvalidFileNameHelper.read ($in);
                else if (_id.equals ("IDL:CF/FileException:1.0"))
                    throw CF.FileExceptionHelper.read ($in);
                else
                    throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                rmdir (directoryName        );
            } finally {
                _releaseReply ($in);
            }
  } // rmdir


  /* The query operation returns file system information to the 
               calling client based upon the given fileSystemProperties' ID. */
  public void query (CF.PropertiesHolder fileSystemProperties) throws CF.FileSystemPackage.UnknownFileSystemProperties
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("query", true);
                CF.PropertiesHelper.write ($out, fileSystemProperties.value);
                $in = _invoke ($out);
                fileSystemProperties.value = CF.PropertiesHelper.read ($in);
                return;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                if (_id.equals ("IDL:CF/FileSystem/UnknownFileSystemProperties:1.0"))
                    throw CF.FileSystemPackage.UnknownFileSystemPropertiesHelper.read ($in);
                else
                    throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                query (fileSystemProperties        );
            } finally {
                _releaseReply ($in);
            }
  } // query

  // Type-specific CORBA::Object operations
  private static String[] __ids = {
    "IDL:CF/FileManager:1.0", 
    "IDL:CF/FileSystem:1.0"};

  public String[] _ids ()
  {
    return (String[])__ids.clone ();
  }

  private void readObject (java.io.ObjectInputStream s) throws java.io.IOException
  {
     String str = s.readUTF ();
     String[] args = null;
     java.util.Properties props = null;
     org.omg.CORBA.Object obj = org.omg.CORBA.ORB.init (args, props).string_to_object (str);
     org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl) obj)._get_delegate ();
     _set_delegate (delegate);
  }

  private void writeObject (java.io.ObjectOutputStream s) throws java.io.IOException
  {
     String[] args = null;
     java.util.Properties props = null;
     String str = org.omg.CORBA.ORB.init (args, props).object_to_string (this);
     s.writeUTF (str);
  }
} // class _FileManagerStub
