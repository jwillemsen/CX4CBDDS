package CF.ExecutableDevicePackage;

/**
* CF/ExecutableDevicePackage/InvalidParametersHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from CF.idl
* Monday, May 4, 2009 2:19:35 PM EDT
*/

public final class InvalidParametersHolder implements org.omg.CORBA.portable.Streamable
{
  public CF.ExecutableDevicePackage.InvalidParameters value = null;

  public InvalidParametersHolder ()
  {
  }

  public InvalidParametersHolder (CF.ExecutableDevicePackage.InvalidParameters initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = CF.ExecutableDevicePackage.InvalidParametersHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    CF.ExecutableDevicePackage.InvalidParametersHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return CF.ExecutableDevicePackage.InvalidParametersHelper.type ();
  }

}
