package CF.DomainManagerPackage;

/**
* CF/DomainManagerPackage/UnregisterErrorHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from CF.idl
* Monday, May 4, 2009 2:19:35 PM EDT
*/

public final class UnregisterErrorHolder implements org.omg.CORBA.portable.Streamable
{
  public CF.DomainManagerPackage.UnregisterError value = null;

  public UnregisterErrorHolder ()
  {
  }

  public UnregisterErrorHolder (CF.DomainManagerPackage.UnregisterError initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = CF.DomainManagerPackage.UnregisterErrorHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    CF.DomainManagerPackage.UnregisterErrorHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return CF.DomainManagerPackage.UnregisterErrorHelper.type ();
  }

}
