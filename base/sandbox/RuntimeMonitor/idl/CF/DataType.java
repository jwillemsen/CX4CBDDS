package CF;


/**
* CF/DataType.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from CF.idl
* Monday, May 4, 2009 2:19:34 PM EDT
*/

public final class DataType implements org.omg.CORBA.portable.IDLEntity
{

  /* The id attribute indicates the kind of value and type. The id can
  		   be an UUID string, an integer string, or a name identifier. */
  public String id = null;

  /* The value attribute can be any static IDL type or CORBA basic type
             */
  public org.omg.CORBA.Any value = null;

  public DataType ()
  {
  } // ctor

  public DataType (String _id, org.omg.CORBA.Any _value)
  {
    id = _id;
    value = _value;
  } // ctor

} // class DataType
