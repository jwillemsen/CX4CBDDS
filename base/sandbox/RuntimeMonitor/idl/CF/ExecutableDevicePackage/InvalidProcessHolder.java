package CF.ExecutableDevicePackage;

/**
* CF/ExecutableDevicePackage/InvalidProcessHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from CF.idl
* Monday, May 4, 2009 2:19:35 PM EDT
*/

public final class InvalidProcessHolder implements org.omg.CORBA.portable.Streamable
{
  public CF.ExecutableDevicePackage.InvalidProcess value = null;

  public InvalidProcessHolder ()
  {
  }

  public InvalidProcessHolder (CF.ExecutableDevicePackage.InvalidProcess initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = CF.ExecutableDevicePackage.InvalidProcessHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    CF.ExecutableDevicePackage.InvalidProcessHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return CF.ExecutableDevicePackage.InvalidProcessHelper.type ();
  }

}
