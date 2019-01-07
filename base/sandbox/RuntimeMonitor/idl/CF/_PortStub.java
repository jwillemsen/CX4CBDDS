package CF;


/**
* CF/_PortStub.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from CF.idl
* Monday, May 4, 2009 2:19:35 PM EDT
*/


/* This interface provides operations for managing associations between
         ports.  An application defines a specific Port type by specifying an
         interface that inherits the Port interface. */
public class _PortStub extends org.omg.CORBA.portable.ObjectImpl implements CF.Port
{


  /* The connectPort operation makes a connection to the component
               identified by the input parameters. The connectPort operation
               establishes only half of the association; therefore two calls
               are required to create a two-way association.  A port may
               support several connections. */
  public void connectPort (org.omg.CORBA.Object connection, String connectionId) throws CF.PortPackage.InvalidPort, CF.PortPackage.OccupiedPort
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("connectPort", true);
                org.omg.CORBA.ObjectHelper.write ($out, connection);
                $out.write_string (connectionId);
                $in = _invoke ($out);
                return;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                if (_id.equals ("IDL:CF/Port/InvalidPort:1.0"))
                    throw CF.PortPackage.InvalidPortHelper.read ($in);
                else if (_id.equals ("IDL:CF/Port/OccupiedPort:1.0"))
                    throw CF.PortPackage.OccupiedPortHelper.read ($in);
                else
                    throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                connectPort (connection, connectionId        );
            } finally {
                _releaseReply ($in);
            }
  } // connectPort


  /* The disconnectPort operation breaks the connection to
               the component identified by the input parameters. */
  public void disconnectPort (String connectionId) throws CF.PortPackage.InvalidPort
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("disconnectPort", true);
                $out.write_string (connectionId);
                $in = _invoke ($out);
                return;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                if (_id.equals ("IDL:CF/Port/InvalidPort:1.0"))
                    throw CF.PortPackage.InvalidPortHelper.read ($in);
                else
                    throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                disconnectPort (connectionId        );
            } finally {
                _releaseReply ($in);
            }
  } // disconnectPort

  // Type-specific CORBA::Object operations
  private static String[] __ids = {
    "IDL:CF/Port:1.0"};

  public String[] _ids ()
  {
    return (String[])__ids.clone ();
  }

  private void readObject (java.io.ObjectInputStream s) throws java.io.IOException
  {
     String str = s.readUTF ();
     String[] args = null;
     java.util.Properties props = null;
     org.omg.CORBA.Object obj = org.omg.CORBA.ORB.init (args, props).string_to_object (str);
     org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl) obj)._get_delegate ();
     _set_delegate (delegate);
  }

  private void writeObject (java.io.ObjectOutputStream s) throws java.io.IOException
  {
     String[] args = null;
     java.util.Properties props = null;
     String str = org.omg.CORBA.ORB.init (args, props).object_to_string (this);
     s.writeUTF (str);
  }
} // class _PortStub
