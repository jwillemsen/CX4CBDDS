package CF.DomainManagerPackage;


/**
* CF/DomainManagerPackage/ApplicationInstallationError.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from CF.idl
* Monday, May 4, 2009 2:19:35 PM EDT
*/

public final class ApplicationInstallationError extends org.omg.CORBA.UserException
{
  public CF.ErrorNumberType errorNumber = null;
  public String msg = null;

  public ApplicationInstallationError ()
  {
    super(ApplicationInstallationErrorHelper.id());
  } // ctor

  public ApplicationInstallationError (CF.ErrorNumberType _errorNumber, String _msg)
  {
    super(ApplicationInstallationErrorHelper.id());
    errorNumber = _errorNumber;
    msg = _msg;
  } // ctor


  public ApplicationInstallationError (String $reason, CF.ErrorNumberType _errorNumber, String _msg)
  {
    super(ApplicationInstallationErrorHelper.id() + "  " + $reason);
    errorNumber = _errorNumber;
    msg = _msg;
  } // ctor

} // class ApplicationInstallationError
