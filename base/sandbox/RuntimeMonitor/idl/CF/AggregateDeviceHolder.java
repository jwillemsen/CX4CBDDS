package CF;

/**
* CF/AggregateDeviceHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from CF.idl
* Monday, May 4, 2009 2:19:34 PM EDT
*/


/* The AggregateDevice interface provides aggregate behavior that can be
         used to add and remove Devices from a parent device.  This interface
         can be provided via inheritance or as a "provides port". Child devices
         use this interface to add or remove themselves from parent device when
         being created or torn-down. */
public final class AggregateDeviceHolder implements org.omg.CORBA.portable.Streamable
{
  public CF.AggregateDevice value = null;

  public AggregateDeviceHolder ()
  {
  }

  public AggregateDeviceHolder (CF.AggregateDevice initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = CF.AggregateDeviceHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    CF.AggregateDeviceHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return CF.AggregateDeviceHelper.type ();
  }

}
