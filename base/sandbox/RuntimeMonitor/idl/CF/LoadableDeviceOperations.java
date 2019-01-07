package CF;


/**
* CF/LoadableDeviceOperations.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from CF.idl
* Monday, May 4, 2009 2:19:35 PM EDT
*/


/* This interface extends the Device interface by adding
         software loading and unloading behavior to a Device.  */
public interface LoadableDeviceOperations  extends CF.DeviceOperations
{

  /* The load operation provides the mechanism for loading software
               on a specific device.  The loaded software may be subsequently
               executed on the Device, if the Device is an ExecutableDevice. */
  void load (CF.FileSystem fs, String fileName, CF.LoadableDevicePackage.LoadType loadKind) throws CF.DevicePackage.InvalidState, CF.LoadableDevicePackage.InvalidLoadKind, CF.InvalidFileName, CF.LoadableDevicePackage.LoadFail;

  /* The unload operation provides the mechanism to unload software
               that is currently loaded. */
  void unload (String fileName) throws CF.DevicePackage.InvalidState, CF.InvalidFileName;
} // interface LoadableDeviceOperations
