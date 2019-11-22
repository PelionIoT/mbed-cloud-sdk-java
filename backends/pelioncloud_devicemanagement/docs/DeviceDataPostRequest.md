
# DeviceDataPostRequest

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**autoUpdate** | **Boolean** | DEPRECATED: Mark this device for automatic firmware update. |  [optional]
**bootstrapExpirationDate** | [**LocalDate**](LocalDate.md) | The expiration date of the certificate used to connect to bootstrap server. |  [optional]
**caId** | **String** | The certificate issuer&#39;s ID. |  [optional]
**connectorExpirationDate** | [**LocalDate**](LocalDate.md) | The expiration date of the certificate used to connect to the LwM2M server. |  [optional]
**customAttributes** | **Map&lt;String, String&gt;** | Up to five custom key-value attributes. Note that keys cannot begin with a number. Both keys and values are limited to 128 characters. Updating this field replaces existing contents. |  [optional]
**deployment** | **String** | DEPRECATED: The last deployment used on the device. |  [optional]
**description** | **String** | The description of the device. |  [optional]
**deviceClass** | **String** | An ID representing the model and hardware revision of the device. |  [optional]
**deviceExecutionMode** | **Integer** | The execution mode from the certificate of the device. Defaults to inheriting from host_gateway device. Permitted values:   - 0 - Unspecified execution mode (default if host_gateway invalid or not set). The device firmware uses a certificate that is not identified as a developer or production certificate.   - 1 - Development device. The device firmware uses a developer certificate to communicate with Device Management.   - 5 - Production device. The device firmware uses a factory-generated certificate to communicate with Device Management. |  [optional]
**deviceKey** | **String** | The fingerprint of the device certificate. |  [optional]
**endpointName** | **String** | The endpoint name given to the device. |  [optional]
**endpointType** | **String** | The endpoint type of the device. For example, the device is a gateway. |  [optional]
**hostGateway** | **String** | The ID of the host gateway, if appropriate. |  [optional]
**issuerFingerprint** | **String** | SHA256 fingerprint of the certificate used to validate the signature of the device certificate. |  [optional]
**manifest** | **String** | DEPRECATED: The URL for the current device manifest. |  [optional]
**mechanism** | [**MechanismEnum**](#MechanismEnum) | The ID of the channel used to communicate with the device. |  [optional]
**mechanismUrl** | **String** | The address of the connector to use. |  [optional]
**name** | **String** | The name of the device. |  [optional]
**serialNumber** | **String** | The serial number of the device. |  [optional]
**state** | [**StateEnum**](#StateEnum) | The current state of the device. |  [optional]
**vendorId** | **String** | The device vendor ID. |  [optional]


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



