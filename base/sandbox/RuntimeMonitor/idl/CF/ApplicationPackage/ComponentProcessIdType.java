package CF.ApplicationPackage;


/**
* CF/ApplicationPackage/ComponentProcessIdType.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from CF.idl
* Monday, May 4, 2009 2:19:35 PM EDT
*/

public final class ComponentProcessIdType implements org.omg.CORBA.portable.IDLEntity
{
  public String componentId = null;
  public int processId = (int)0;

  public ComponentProcessIdType ()
  {
  } // ctor

  public ComponentProcessIdType (String _componentId, int _processId)
  {
    componentId = _componentId;
    processId = _processId;
  } // ctor

} // class ComponentProcessIdType
