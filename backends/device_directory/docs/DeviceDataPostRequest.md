
# DeviceDataPostRequest

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**bootstrapExpirationDate** | [**DateTime**](DateTime.md) | Expiration date of the certificate used to connect to bootstrap server. |  [optional]
**bootstrappedTimestamp** | [**DateTime**](DateTime.md) | Timestamp of when the device last went through the bootstrap process. |  [optional]
**connectorExpirationDate** | [**DateTime**](DateTime.md) | Expiration date of the certificate used to connect to the lwm2m server. |  [optional]
**mechanism** | [**MechanismEnum**](#MechanismEnum) | The ID of the channel used to communicate with the device. |  [optional]
**deviceClass** | **String** | An id representing the model and hardware revision of the device. |  [optional]
**endpointName** | **String** | The endpoint name given to the device. |  [optional]
**autoUpdate** | **Boolean** | DEPRECATED Mark this device for auto firmware update. |  [optional]
**hostGateway** | **String** | The endpoint_name of the host gateway, if appropriate. |  [optional]
**deviceExecutionMode** | **Integer** | Defines the type of certificate used. |  [optional]
**customAttributes** | **Object** | Up to 5 custom JSON attributes |  [optional]
**state** | [**StateEnum**](#StateEnum) | The current state of the device. |  [optional]
**serialNumber** | **String** | The serial number of the device. |  [optional]
**firmwareChecksum** | **String** | The SHA256 checksum of the current firmware image. |  [optional]
**vendorId** | **String** | The device vendor ID. |  [optional]
**description** | **String** | The description of the device. |  [optional]
**deployedState** | [**DeployedStateEnum**](#DeployedStateEnum) | DEPRECATED The state of the device&#39;s deployment. |  [optional]
**object** | **String** | The API resource entity. |  [optional]
**endpointType** | **String** | The endpoint type of the device - e.g. if the device is a gateway. |  [optional]
**deployment** | **String** | DEPRECATED The last deployment used on the device. |  [optional]
**mechanismUrl** | **String** | The address of the connector to use. |  [optional]
**trustLevel** | **Integer** | The device trust level. |  [optional]
**name** | **String** | The name of the device. |  [optional]
**deviceKey** | **String** | Fingerprint of the device certificate. | 
**manifest** | **String** | DEPRECATED The URL for the current device manifest. |  [optional]
**caId** | **String** | ID of the issuer of the certificate. | 


<a name="MechanismEnum"></a>
## Enum: MechanismEnum
Name | Value
---- | -----
CONNECTOR | &quot;connector&quot;
DIRECT | &quot;direct&quot;


<a name="StateEnum"></a>
## Enum: StateEnum
Name | Value
---- | -----
UNENROLLED | &quot;unenrolled&quot;
CLOUD_ENROLLING | &quot;cloud_enrolling&quot;
BOOTSTRAPPED | &quot;bootstrapped&quot;
REGISTERED | &quot;registered&quot;
DEREGISTERED | &quot;deregistered&quot;


<a name="DeployedStateEnum"></a>
## Enum: DeployedStateEnum
Name | Value
---- | -----
DEVELOPMENT | &quot;development&quot;
PRODUCTION | &quot;production&quot;



