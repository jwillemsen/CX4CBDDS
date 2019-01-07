package CF.LifeCyclePackage;


/**
* CF/LifeCyclePackage/ReleaseErrorHelper.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from CF.idl
* Monday, May 4, 2009 2:19:35 PM EDT
*/

abstract public class ReleaseErrorHelper
{
  private static String  _id = "IDL:CF/LifeCycle/ReleaseError:1.0";

  public static void insert (org.omg.CORBA.Any a, CF.LifeCyclePackage.ReleaseError that)
  {
    org.omg.CORBA.portable.OutputStream out = a.create_output_stream ();
    a.type (type ());
    write (out, that);
    a.read_value (out.create_input_stream (), type ());
  }

  public static CF.LifeCyclePackage.ReleaseError extract (org.omg.CORBA.Any a)
  {
    return read (a.create_input_stream ());
  }

  private static org.omg.CORBA.TypeCode __typeCode = null;
  private static boolean __active = false;
  synchronized public static org.omg.CORBA.TypeCode type ()
  {
    if (__typeCode == null)
    {
      synchronized (org.omg.CORBA.TypeCode.class)
      {
        if (__typeCode == null)
        {
          if (__active)
          {
            return org.omg.CORBA.ORB.init().create_recursive_tc ( _id );
          }
          __active = true;
          org.omg.CORBA.StructMember[] _members0 = new org.omg.CORBA.StructMember [1];
          org.omg.CORBA.TypeCode _tcOf_members0 = null;
          _tcOf_members0 = org.omg.CORBA.ORB.init ().create_string_tc (0);
          _tcOf_members0 = org.omg.CORBA.ORB.init ().create_sequence_tc (0, _tcOf_members0);
          _tcOf_members0 = org.omg.CORBA.ORB.init ().create_alias_tc (CF.StringSequenceHelper.id (), "StringSequence", _tcOf_members0);
          _members0[0] = new org.omg.CORBA.StructMember (
            "errorMessages",
            _tcOf_members0,
            null);
          __typeCode = org.omg.CORBA.ORB.init ().create_exception_tc (CF.LifeCyclePackage.ReleaseErrorHelper.id (), "ReleaseError", _members0);
          __active = false;
        }
      }
    }
    return __typeCode;
  }

  public static String id ()
  {
    return _id;
  }

  public static CF.LifeCyclePackage.ReleaseError read (org.omg.CORBA.portable.InputStream istream)
  {
    CF.LifeCyclePackage.ReleaseError value = new CF.LifeCyclePackage.ReleaseError ();
    // read and discard the repository ID
    istream.read_string ();
    value.errorMessages = CF.StringSequenceHelper.read (istream);
    return value;
  }

  public static void write (org.omg.CORBA.portable.OutputStream ostream, CF.LifeCyclePackage.ReleaseError value)
  {
    // write the repository ID
    ostream.write_string (id ());
    CF.StringSequenceHelper.write (ostream, value.errorMessages);
  }

}
