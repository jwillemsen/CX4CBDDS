package CF.DevicePackage;


/**
* CF/DevicePackage/UsageType.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from CF.idl
* Monday, May 4, 2009 2:19:35 PM EDT
*/


/* This enumeration type defines the Device's usage states. */
public class UsageType implements org.omg.CORBA.portable.IDLEntity
{
  private        int __value;
  private static int __size = 3;
  private static CF.DevicePackage.UsageType[] __array = new CF.DevicePackage.UsageType [__size];

  public static final int _IDLE = 0;
  public static final CF.DevicePackage.UsageType IDLE = new CF.DevicePackage.UsageType(_IDLE);
  public static final int _ACTIVE = 1;
  public static final CF.DevicePackage.UsageType ACTIVE = new CF.DevicePackage.UsageType(_ACTIVE);
  public static final int _BUSY = 2;
  public static final CF.DevicePackage.UsageType BUSY = new CF.DevicePackage.UsageType(_BUSY);

  public int value ()
  {
    return __value;
  }

  public static CF.DevicePackage.UsageType from_int (int value)
  {
    if (value >= 0 && value < __size)
      return __array[value];
    else
      throw new org.omg.CORBA.BAD_PARAM ();
  }

  protected UsageType (int value)
  {
    __value = value;
    __array[__value] = this;
  }
} // class UsageType
