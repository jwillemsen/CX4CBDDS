package CF.DevicePackage;

/**
* CF/DevicePackage/AdminTypeHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from CF.idl
* Monday, May 4, 2009 2:19:35 PM EDT
*/


/* This enumeration type defines a Device's administrative states.
             The administrative state indicates the permission to use or
             prohibition against using the Device.  */
public final class AdminTypeHolder implements org.omg.CORBA.portable.Streamable
{
  public CF.DevicePackage.AdminType value = null;

  public AdminTypeHolder ()
  {
  }

  public AdminTypeHolder (CF.DevicePackage.AdminType initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = CF.DevicePackage.AdminTypeHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    CF.DevicePackage.AdminTypeHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return CF.DevicePackage.AdminTypeHelper.type ();
  }

}
