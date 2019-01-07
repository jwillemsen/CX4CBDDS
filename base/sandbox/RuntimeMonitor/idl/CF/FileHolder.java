package CF;

/**
* CF/FileHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from CF.idl
* Monday, May 4, 2009 2:19:35 PM EDT
*/


/* The File interface provides the ability to read and write files
         residing within a distributed FileSystem.  A file
         can be thought of conceptually as a sequence of octets with
         a current filePointer describing where the next read or write
         will occur. */
public final class FileHolder implements org.omg.CORBA.portable.Streamable
{
  public CF.File value = null;

  public FileHolder ()
  {
  }

  public FileHolder (CF.File initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = CF.FileHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    CF.FileHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return CF.FileHelper.type ();
  }

}
