package CF;


/**
* CF/FileManagerHelper.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from CF.idl
* Monday, May 4, 2009 2:19:35 PM EDT
*/


/* Multiple, distributed FileSystems may be accessed through
         a FileManager. The FileManager interface appears to be a single
         FileSystem although the actual file storage may span multiple
         physical file systems. */
abstract public class FileManagerHelper
{
  private static String  _id = "IDL:CF/FileManager:1.0";

  public static void insert (org.omg.CORBA.Any a, CF.FileManager that)
  {
    org.omg.CORBA.portable.OutputStream out = a.create_output_stream ();
    a.type (type ());
    write (out, that);
    a.read_value (out.create_input_stream (), type ());
  }

  public static CF.FileManager extract (org.omg.CORBA.Any a)
  {
    return read (a.create_input_stream ());
  }

  private static org.omg.CORBA.TypeCode __typeCode = null;
  synchronized public static org.omg.CORBA.TypeCode type ()
  {
    if (__typeCode == null)
    {
      __typeCode = org.omg.CORBA.ORB.init ().create_interface_tc (CF.FileManagerHelper.id (), "FileManager");
    }
    return __typeCode;
  }

  public static String id ()
  {
    return _id;
  }

  public static CF.FileManager read (org.omg.CORBA.portable.InputStream istream)
  {
    return narrow (istream.read_Object (_FileManagerStub.class));
  }

  public static void write (org.omg.CORBA.portable.OutputStream ostream, CF.FileManager value)
  {
    ostream.write_Object ((org.omg.CORBA.Object) value);
  }

  public static CF.FileManager narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof CF.FileManager)
      return (CF.FileManager)obj;
    else if (!obj._is_a (id ()))
      throw new org.omg.CORBA.BAD_PARAM ();
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      CF._FileManagerStub stub = new CF._FileManagerStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

  public static CF.FileManager unchecked_narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof CF.FileManager)
      return (CF.FileManager)obj;
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      CF._FileManagerStub stub = new CF._FileManagerStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

}
