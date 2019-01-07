package CF;


/**
* CF/AggregateDeviceOperations.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from CF.idl
* Monday, May 4, 2009 2:19:34 PM EDT
*/


/* The AggregateDevice interface provides aggregate behavior that can be
         used to add and remove Devices from a parent device.  This interface
         can be provided via inheritance or as a "provides port". Child devices
         use this interface to add or remove themselves from parent device when
         being created or torn-down. */
public interface AggregateDeviceOperations 
{

  /* The readonly devices attribute contains a list of devices that
               have been added to this device or a sequence length of zero if
               the device has no aggregation relationships with other devices. */
  CF.Device[] devices ();

  /* The addDevice operation provides the mechanism to associate
               a device with another device. */
  void addDevice (CF.Device associatedDevice) throws CF.InvalidObjectReference;

  /* The removeDevice operation provides the mechanism to disassociate
               a device from another device. */
  void removeDevice (CF.Device associatedDevice) throws CF.InvalidObjectReference;
} // interface AggregateDeviceOperations
