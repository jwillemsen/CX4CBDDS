package LogService.LogPackage;


/**
* LogService/LogPackage/InvalidParam.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from LogService.idl
* Monday, May 4, 2009 2:19:36 PM EDT
*/

public final class InvalidParam extends org.omg.CORBA.UserException
{
  public String details = null;

  public InvalidParam ()
  {
    super(InvalidParamHelper.id());
  } // ctor

  public InvalidParam (String _details)
  {
    super(InvalidParamHelper.id());
    details = _details;
  } // ctor


  public InvalidParam (String $reason, String _details)
  {
    super(InvalidParamHelper.id() + "  " + $reason);
    details = _details;
  } // ctor

} // class InvalidParam
