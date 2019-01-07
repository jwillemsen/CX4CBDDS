package CF;


/**
* CF/DomainManagerOperations.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from CF.idl
* Monday, May 4, 2009 2:19:35 PM EDT
*/


/* The DomainManager interface is for the control and configuration
         of the radio domain. */
public interface DomainManagerOperations  extends CF.PropertySetOperations
{

  /* The readonly domainManagerProfile attribute contains
               a profile element with a file reference to the DomainManager
               Configuration Descriptor (DMD) profile. */
  String domainManagerProfile ();

  /* The deviceManagers attribute is read-only containing a sequence 
               of registered DeviceManagers in the domain. */
  CF.DeviceManager[] deviceManagers ();

  /* The applications attribute contains a list of Applications that 
  		     have been instantiatedin the domain. */
  CF.Application[] applications ();

  /* The readonly applicationFactories attribute contains a list with
               one ApplicationFactory per application (SAD file and associated
               files) successfully installed. */
  CF.ApplicationFactory[] applicationFactories ();

  /* The readonly fileMgr attribute contains the DomainManager's
               FileManager. */
  CF.FileManager fileMgr ();

  /* The readonly identifier attribute contains a unique identifier
               for a DomainManager instance. The identifier is identical to 
               the domainmanagerconfiguration element id attribute of the
               DomainManager's Descriptor (DMD) file.  */
  String identifier ();

  /* The registerDevice operation is used to register a Device for
               a specific DeviceManager in the DomainManager's Domain Profile. */
  void registerDevice (CF.Device registeringDevice, CF.DeviceManager registeredDeviceMgr) throws CF.InvalidObjectReference, CF.InvalidProfile, CF.DomainManagerPackage.DeviceManagerNotRegistered, CF.DomainManagerPackage.RegisterError;

  /* The registerDeviceManager operation is used to register
                a DeviceManager, its Device(s), and its Services. */
  void registerDeviceManager (CF.DeviceManager deviceMgr) throws CF.InvalidObjectReference, CF.InvalidProfile, CF.DomainManagerPackage.RegisterError;

  /* The unregisterDeviceManager operation is used to unregister
               a DeviceManager component from the DomainManager's Domain Profile.
               A DeviceManager may be unregistered during run-time for dynamic
               extraction or maintenance of the DeviceManager. */
  void unregisterDeviceManager (CF.DeviceManager deviceMgr) throws CF.InvalidObjectReference, CF.DomainManagerPackage.UnregisterError;

  /* The unregisterDevice operation is used to remove a device entry
               from the DomainManager for a specific DeviceManager. */
  void unregisterDevice (CF.Device unregisteringDevice) throws CF.InvalidObjectReference, CF.DomainManagerPackage.UnregisterError;

  /* The installApplication operation is used to register new
               application software in the DomainManager's Domain Profile. */
  void installApplication (String profileFileName) throws CF.InvalidProfile, CF.InvalidFileName, CF.DomainManagerPackage.ApplicationInstallationError, CF.DomainManagerPackage.ApplicationAlreadyInstalled;

  /* The uninstallApplication operation is used to uninstall 
               an application and its associated ApplicationFactory from
               the DomainManager. */
  void uninstallApplication (String applicationId) throws CF.DomainManagerPackage.InvalidIdentifier, CF.DomainManagerPackage.ApplicationUninstallationError;

  /* The registerService operation is used to register a service 
               for a specific DeviceManager with the DomainManager. */
  void registerService (org.omg.CORBA.Object registeringService, CF.DeviceManager registeredDeviceMgr, String name) throws CF.InvalidObjectReference, CF.DomainManagerPackage.DeviceManagerNotRegistered, CF.DomainManagerPackage.RegisterError;

  /* The unregisterService operation is used to remove a service entry
               from the DomainManager for a specific DeviceManager. */
  void unregisterService (org.omg.CORBA.Object unregisteringService, String name) throws CF.InvalidObjectReference, CF.DomainManagerPackage.UnregisterError;

  /* The registerWithEventChannel operation is used to connect
               a consumer to a domain's event channel. */
  void registerWithEventChannel (org.omg.CORBA.Object registeringObject, String registeringId, String eventChannelName) throws CF.InvalidObjectReference, CF.DomainManagerPackage.InvalidEventChannelName, CF.DomainManagerPackage.AlreadyConnected;

  /* The unregisterFromEventChannel operation is used to disconnect
               a consumer from a domain's event channel. */
  void unregisterFromEventChannel (String unregisteringId, String eventChannelName) throws CF.DomainManagerPackage.InvalidEventChannelName, CF.DomainManagerPackage.NotConnected;
} // interface DomainManagerOperations
