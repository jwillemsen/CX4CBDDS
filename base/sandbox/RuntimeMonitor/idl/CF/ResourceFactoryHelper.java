package CF;


/**
* CF/ResourceFactoryHelper.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from CF.idl
* Monday, May 4, 2009 2:19:35 PM EDT
*/


/* A ResourceFactory can be used to create and tear down a Resource. */
abstract public class ResourceFactoryHelper
{
  private static String  _id = "IDL:CF/ResourceFactory:1.0";

  public static void insert (org.omg.CORBA.Any a, CF.ResourceFactory that)
  {
    org.omg.CORBA.portable.OutputStream out = a.create_output_stream ();
    a.type (type ());
    write (out, that);
    a.read_value (out.create_input_stream (), type ());
  }

  public static CF.ResourceFactory extract (org.omg.CORBA.Any a)
  {
    return read (a.create_input_stream ());
  }

  private static org.omg.CORBA.TypeCode __typeCode = null;
  synchronized public static org.omg.CORBA.TypeCode type ()
  {
    if (__typeCode == null)
    {
      __typeCode = org.omg.CORBA.ORB.init ().create_interface_tc (CF.ResourceFactoryHelper.id (), "ResourceFactory");
    }
    return __typeCode;
  }

  public static String id ()
  {
    return _id;
  }

  public static CF.ResourceFactory read (org.omg.CORBA.portable.InputStream istream)
  {
    return narrow (istream.read_Object (_ResourceFactoryStub.class));
  }

  public static void write (org.omg.CORBA.portable.OutputStream ostream, CF.ResourceFactory value)
  {
    ostream.write_Object ((org.omg.CORBA.Object) value);
  }

  public static CF.ResourceFactory narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof CF.ResourceFactory)
      return (CF.ResourceFactory)obj;
    else if (!obj._is_a (id ()))
      throw new org.omg.CORBA.BAD_PARAM ();
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      CF._ResourceFactoryStub stub = new CF._ResourceFactoryStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

  public static CF.ResourceFactory unchecked_narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof CF.ResourceFactory)
      return (CF.ResourceFactory)obj;
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      CF._ResourceFactoryStub stub = new CF._ResourceFactoryStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

}
