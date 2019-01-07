package CF;


/**
* CF/PropertiesHelper.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from CF.idl
* Monday, May 4, 2009 2:19:34 PM EDT
*/


/* The Properties is a CORBA IDL unbounded sequence of CF DataType(s),
         which can be used in defining a sequence of name and value pairs. */
abstract public class PropertiesHelper
{
  private static String  _id = "IDL:CF/Properties:1.0";

  public static void insert (org.omg.CORBA.Any a, CF.DataType[] that)
  {
    org.omg.CORBA.portable.OutputStream out = a.create_output_stream ();
    a.type (type ());
    write (out, that);
    a.read_value (out.create_input_stream (), type ());
  }

  public static CF.DataType[] extract (org.omg.CORBA.Any a)
  {
    return read (a.create_input_stream ());
  }

  private static org.omg.CORBA.TypeCode __typeCode = null;
  synchronized public static org.omg.CORBA.TypeCode type ()
  {
    if (__typeCode == null)
    {
      __typeCode = CF.DataTypeHelper.type ();
      __typeCode = org.omg.CORBA.ORB.init ().create_sequence_tc (0, __typeCode);
      __typeCode = org.omg.CORBA.ORB.init ().create_alias_tc (CF.PropertiesHelper.id (), "Properties", __typeCode);
    }
    return __typeCode;
  }

  public static String id ()
  {
    return _id;
  }

  public static CF.DataType[] read (org.omg.CORBA.portable.InputStream istream)
  {
    CF.DataType value[] = null;
    int _len0 = istream.read_long ();
    value = new CF.DataType[_len0];
    for (int _o1 = 0;_o1 < value.length; ++_o1)
      value[_o1] = CF.DataTypeHelper.read (istream);
    return value;
  }

  public static void write (org.omg.CORBA.portable.OutputStream ostream, CF.DataType[] value)
  {
    ostream.write_long (value.length);
    for (int _i0 = 0;_i0 < value.length; ++_i0)
      CF.DataTypeHelper.write (ostream, value[_i0]);
  }

}
