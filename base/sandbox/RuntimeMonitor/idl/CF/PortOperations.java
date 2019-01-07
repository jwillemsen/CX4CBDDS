package CF;


/**
* CF/PortOperations.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from CF.idl
* Monday, May 4, 2009 2:19:35 PM EDT
*/


/* This interface provides operations for managing associations between
         ports.  An application defines a specific Port type by specifying an
         interface that inherits the Port interface. */
public interface PortOperations 
{

  /* The connectPort operation makes a connection to the component
               identified by the input parameters. The connectPort operation
               establishes only half of the association; therefore two calls
               are required to create a two-way association.  A port may
               support several connections. */
  void connectPort (org.omg.CORBA.Object connection, String connectionId) throws CF.PortPackage.InvalidPort, CF.PortPackage.OccupiedPort;

  /* The disconnectPort operation breaks the connection to
               the component identified by the input parameters. */
  void disconnectPort (String connectionId) throws CF.PortPackage.InvalidPort;
} // interface PortOperations
