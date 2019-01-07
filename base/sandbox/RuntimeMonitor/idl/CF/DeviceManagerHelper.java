package CF;


/**
* CF/DeviceManagerHelper.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from CF.idl
* Monday, May 4, 2009 2:19:35 PM EDT
*/


/* The DeviceManager interface is used to manage a set of
         logical Devices and services. */
abstract public class DeviceManagerHelper
{
  private static String  _id = "IDL:CF/DeviceManager:1.0";

  public static void insert (org.omg.CORBA.Any a, CF.DeviceManager that)
  {
    org.omg.CORBA.portable.OutputStream out = a.create_output_stream ();
    a.type (type ());
    write (out, that);
    a.read_value (out.create_input_stream (), type ());
  }

  public static CF.DeviceManager extract (org.omg.CORBA.Any a)
  {
    return read (a.create_input_stream ());
  }

  private static org.omg.CORBA.TypeCode __typeCode = null;
  synchronized public static org.omg.CORBA.TypeCode type ()
  {
    if (__typeCode == null)
    {
      __typeCode = org.omg.CORBA.ORB.init ().create_interface_tc (CF.DeviceManagerHelper.id (), "DeviceManager");
    }
    return __typeCode;
  }

  public static String id ()
  {
    return _id;
  }

  public static CF.DeviceManager read (org.omg.CORBA.portable.InputStream istream)
  {
    return narrow (istream.read_Object (_DeviceManagerStub.class));
  }

  public static void write (org.omg.CORBA.portable.OutputStream ostream, CF.DeviceManager value)
  {
    ostream.write_Object ((org.omg.CORBA.Object) value);
  }

  public static CF.DeviceManager narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof CF.DeviceManager)
      return (CF.DeviceManager)obj;
    else if (!obj._is_a (id ()))
      throw new org.omg.CORBA.BAD_PARAM ();
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      CF._DeviceManagerStub stub = new CF._DeviceManagerStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

  public static CF.DeviceManager unchecked_narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof CF.DeviceManager)
      return (CF.DeviceManager)obj;
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      CF._DeviceManagerStub stub = new CF._DeviceManagerStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

}
