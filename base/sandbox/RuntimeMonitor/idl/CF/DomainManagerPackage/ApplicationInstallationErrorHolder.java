package CF.DomainManagerPackage;

/**
* CF/DomainManagerPackage/ApplicationInstallationErrorHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from CF.idl
* Monday, May 4, 2009 2:19:35 PM EDT
*/

public final class ApplicationInstallationErrorHolder implements org.omg.CORBA.portable.Streamable
{
  public CF.DomainManagerPackage.ApplicationInstallationError value = null;

  public ApplicationInstallationErrorHolder ()
  {
  }

  public ApplicationInstallationErrorHolder (CF.DomainManagerPackage.ApplicationInstallationError initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = CF.DomainManagerPackage.ApplicationInstallationErrorHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    CF.DomainManagerPackage.ApplicationInstallationErrorHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return CF.DomainManagerPackage.ApplicationInstallationErrorHelper.type ();
  }

}
