package LogService.LogPackage;


/**
* LogService/LogPackage/AvailabilityStatusType.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from LogService.idl
* Monday, May 4, 2009 2:19:36 PM EDT
*/

public final class AvailabilityStatusType implements org.omg.CORBA.portable.IDLEntity
{
  public boolean offDuty = false;
  public boolean logFull = false;

  public AvailabilityStatusType ()
  {
  } // ctor

  public AvailabilityStatusType (boolean _offDuty, boolean _logFull)
  {
    offDuty = _offDuty;
    logFull = _logFull;
  } // ctor

} // class AvailabilityStatusType
