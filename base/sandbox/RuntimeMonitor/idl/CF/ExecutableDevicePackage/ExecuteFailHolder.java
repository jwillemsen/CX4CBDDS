package CF.ExecutableDevicePackage;

/**
* CF/ExecutableDevicePackage/ExecuteFailHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from CF.idl
* Monday, May 4, 2009 2:19:35 PM EDT
*/

public final class ExecuteFailHolder implements org.omg.CORBA.portable.Streamable
{
  public CF.ExecutableDevicePackage.ExecuteFail value = null;

  public ExecuteFailHolder ()
  {
  }

  public ExecuteFailHolder (CF.ExecutableDevicePackage.ExecuteFail initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = CF.ExecutableDevicePackage.ExecuteFailHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    CF.ExecutableDevicePackage.ExecuteFailHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return CF.ExecutableDevicePackage.ExecuteFailHelper.type ();
  }

}
