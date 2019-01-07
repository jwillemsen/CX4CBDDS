package CF.FileManagerPackage;


/**
* CF/FileManagerPackage/MountSequenceHelper.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from CF.idl
* Monday, May 4, 2009 2:19:35 PM EDT
*/


/* This type defines an unbounded sequence of mounted FileSystems. */
abstract public class MountSequenceHelper
{
  private static String  _id = "IDL:CF/FileManager/MountSequence:1.0";

  public static void insert (org.omg.CORBA.Any a, CF.FileManagerPackage.MountType[] that)
  {
    org.omg.CORBA.portable.OutputStream out = a.create_output_stream ();
    a.type (type ());
    write (out, that);
    a.read_value (out.create_input_stream (), type ());
  }

  public static CF.FileManagerPackage.MountType[] extract (org.omg.CORBA.Any a)
  {
    return read (a.create_input_stream ());
  }

  private static org.omg.CORBA.TypeCode __typeCode = null;
  synchronized public static org.omg.CORBA.TypeCode type ()
  {
    if (__typeCode == null)
    {
      __typeCode = CF.FileManagerPackage.MountTypeHelper.type ();
      __typeCode = org.omg.CORBA.ORB.init ().create_sequence_tc (0, __typeCode);
      __typeCode = org.omg.CORBA.ORB.init ().create_alias_tc (CF.FileManagerPackage.MountSequenceHelper.id (), "MountSequence", __typeCode);
    }
    return __typeCode;
  }

  public static String id ()
  {
    return _id;
  }

  public static CF.FileManagerPackage.MountType[] read (org.omg.CORBA.portable.InputStream istream)
  {
    CF.FileManagerPackage.MountType value[] = null;
    int _len0 = istream.read_long ();
    value = new CF.FileManagerPackage.MountType[_len0];
    for (int _o1 = 0;_o1 < value.length; ++_o1)
      value[_o1] = CF.FileManagerPackage.MountTypeHelper.read (istream);
    return value;
  }

  public static void write (org.omg.CORBA.portable.OutputStream ostream, CF.FileManagerPackage.MountType[] value)
  {
    ostream.write_long (value.length);
    for (int _i0 = 0;_i0 < value.length; ++_i0)
      CF.FileManagerPackage.MountTypeHelper.write (ostream, value[_i0]);
  }

}
