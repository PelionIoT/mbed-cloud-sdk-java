
# DeviceData

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**bootstrapExpirationDate** | [**DateTime**](DateTime.md) | The expiration date of the certificate used to connect to bootstrap server. |  [optional]
**bootstrappedTimestamp** | [**DateTime**](DateTime.md) | The timestamp of the device&#39;s most recent bootstrap process. |  [optional]
**connectorExpirationDate** | [**DateTime**](DateTime.md) | The expiration date of the certificate used to connect to LWM2M server. |  [optional]
**updatedAt** | [**DateTime**](DateTime.md) | The time the object was updated. |  [optional]
**caId** | **String** | The certificate issuer&#39;s ID. |  [optional]
**deviceClass** | **String** | An ID representing the model and hardware revision of the device. |  [optional]
**id** | **String** | The ID of the device. The device ID is used to manage a device across all Mbed Cloud APIs. |  [optional]
**accountId** | **String** | The ID of the associated account. |  [optional]
**endpointName** | **String** | The endpoint name given to the device. |  [optional]
**autoUpdate** | **Boolean** | DEPRECATED: Mark this device for automatic firmware update. |  [optional]
**hostGateway** | **String** | The &#x60;endpoint_name&#x60; of the host gateway, if appropriate. |  [optional]
**deviceExecutionMode** | **Integer** | The certificate type. |  [optional]
**mechanism** | [**MechanismEnum**](#MechanismEnum) | The ID of the channel used to communicate with the device. |  [optional]
**state** | [**StateEnum**](#StateEnum) | The current state of the device. |  [optional]
**etag** | [**DateTime**](DateTime.md) | The entity instance signature. |  [optional]
**serialNumber** | **String** | The serial number of the device. |  [optional]
**firmwareChecksum** | **String** | The SHA256 checksum of the current firmware image. |  [optional]
**manifestTimestamp** | [**DateTime**](DateTime.md) | The timestamp of the current manifest version. |  [optional]
**vendorId** | **String** | The device vendor ID. |  [optional]
**description** | **String** | The description of the device. |  [optional]
**deployedState** | [**DeployedStateEnum**](#DeployedStateEnum) | DEPRECATED: The state of the device&#39;s deployment. |  [optional]
**object** | **String** | The API resource entity. |  [optional]
**endpointType** | **String** | The endpoint type of the device. For example, the device is a gateway. |  [optional]
**deployment** | **String** | DEPRECATED: The last deployment used on the device. |  [optional]
**mechanismUrl** | **String** | The address of the connector to use. |  [optional]
**trustLevel** | **Integer** | The device trust level. |  [optional]
**name** | **String** | The name of the device. |  [optional]
**deviceKey** | **String** | The fingerprint of the device certificate. |  [optional]
**createdAt** | [**DateTime**](DateTime.md) | The timestamp of when the device was created in the device directory. |  [optional]
**manifest** | **String** | DEPRECATED: The URL for the current device manifest. |  [optional]
**customAttributes** | **Map&lt;String, String&gt;** | Up to five custom key-value attributes. |  [optional]


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



