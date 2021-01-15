
# DeviceData

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**accountId** | **String** | The ID of the associated account. |  [optional]
**autoUpdate** | **Boolean** | DEPRECATED: Mark this device for automatic firmware update. |  [optional]
**bootstrapExpirationDate** | [**LocalDate**](LocalDate.md) | The expiration date of the certificate used to connect to bootstrap server. |  [optional]
**bootstrappedTimestamp** | [**DateTime**](DateTime.md) | The timestamp of the device&#39;s most recent bootstrap process. |  [optional]
**caId** | **String** | The certificate issuer&#39;s ID. |  [optional]
**componentAttributes** | **Map&lt;String, String&gt;** | Up to ten custom key-value attributes. Note that keys cannot begin with a number. Both keys and values are limited to 128 characters. Updating this field replaces existing contents. |  [optional]
**connectorExpirationDate** | [**LocalDate**](LocalDate.md) | The expiration date of the certificate used to connect to LwM2M server. |  [optional]
**createdAt** | [**DateTime**](DateTime.md) | The timestamp of when the device was created in the device directory. |  [optional]
**customAttributes** | **Map&lt;String, String&gt;** | Up to five custom key-value attributes. Note that keys cannot begin with a number. Both keys and values are limited to 128 characters. Updating this field replaces existing contents. |  [optional]
**deployedState** | [**DeployedStateEnum**](#DeployedStateEnum) | DEPRECATED: The state of the device&#39;s deployment. |  [optional]
**deployment** | **String** | DEPRECATED: The last deployment used on the device. |  [optional]
**description** | **String** | The description of the device. |  [optional]
**deviceClass** | **String** | An ID representing the model and hardware revision of the device. |  [optional]
**deviceExecutionMode** | **Integer** | The execution mode from the certificate of the device. Defaults to inheriting from host_gateway device. Permitted values:   - 0 - Unspecified execution mode (default if host_gateway invalid or not set). The device firmware uses a certificate that is not identified as a developer or production certificate.   - 1 - Development device. The device firmware uses a developer certificate to communicate with Device Management.   - 5 - Production device. The device firmware uses a factory-generated certificate to communicate with Device Management. |  [optional]
**deviceKey** | **String** | The fingerprint of the device certificate. |  [optional]
**endpointName** | **String** | The endpoint name given to the device. The endpoint_name is from the device certificate and is set by factory tool. |  [optional]
**endpointType** | **String** | The endpoint type of the device. For example, the device is a gateway. |  [optional]
**enrolmentListTimestamp** | [**DateTime**](DateTime.md) | The claim date/time. |  [optional]
**etag** | [**DateTime**](DateTime.md) | The entity instance signature. |  [optional]
**firmwareChecksum** | **String** | The SHA256 checksum of the current firmware image. |  [optional]
**groups** | **List&lt;String&gt;** | An array containing an ID of each group this device belongs to. |  [optional]
**hostGateway** | **String** | The ID of the host gateway, if appropriate. A device behind Edge has this host_gateway set. |  [optional]
**id** | **String** | The ID of the device. The device ID is used across all Device Management APIs. |  [optional]
**issuerFingerprint** | **String** | SHA256 fingerprint of the certificate used to validate the signature of the device certificate. |  [optional]
**lastOperatorSuspendedCategory** | **String** | The reference of the block category. |  [optional]
**lastOperatorSuspendedDescription** | **String** | The most recent description why the device was suspended or returned to service. |  [optional]
**lastOperatorSuspendedUpdatedAt** | [**DateTime**](DateTime.md) | The timestamp of the most recent suspension activity. |  [optional]
**lastSystemSuspendedCategory** | **String** | The reference of the block category. |  [optional]
**lastSystemSuspendedDescription** | **String** | The most recent description of why the device was blocked or unblocked by the system. |  [optional]
**lastSystemSuspendedUpdatedAt** | [**DateTime**](DateTime.md) | The timestamp of the most recent system block activity. |  [optional]
**lifecycleStatus** | [**LifecycleStatusEnum**](#LifecycleStatusEnum) | The lifecycle status of the device. * Enabled: The device is allowed to connect to Pelion Device Management. * Blocked: The device is prevented from connecting to Pelion Device Management. Device can be, for example, &#39;suspended&#39;. |  [optional]
**manifest** | **String** | DEPRECATED: The URL for the current device manifest. |  [optional]
**manifestTimestamp** | [**DateTime**](DateTime.md) | The timestamp of the current manifest version. |  [optional]
**mechanism** | [**MechanismEnum**](#MechanismEnum) | NOT USED: The ID of the channel used to communicate with the device. |  [optional]
**mechanismUrl** | **String** | NOT USED: The address of the connector to use. |  [optional]
**name** | **String** | The name given by the web application for the device. Device itself provides only the endpoint_name. |  [optional]
**netId** | **String** | Private network identifier. Used to group nodes connected to a specific border router. |  [optional]
**object** | **String** | The API resource entity. |  [optional]
**operatorSuspended** | **Boolean** | Device has been suspended by operator. |  [optional]
**serialNumber** | **String** | The [serial number](https://developer.pelion.com/docs/device-management-provision/latest/provisioning-info/lwm2m-device-object.html#serial-number) of the device. The serial number is injected by the factory tool during manufacturing. |  [optional]
**state** | [**StateEnum**](#StateEnum) | The current state of the device. * Unenrolled: The device has been created, but has not yet bootstrapped or connected to Device Management. * Cloud_enrolling: The device is bootstrapping for the first time. This state is set only while bootstrapping is in progress. For example, an external CA gives an error, and the device tries to bootstrap again after few seconds. * Bootstrapped: The device has bootstrapped, and has credentials to connect to Device Management. * Registered: The device has registered with Pelion Device Management. [Device commands](https://developer.pelion.com/docs/device-management-api/connect/) can be queued. The device sends events for [subscribed](https://developer.pelion.com/docs/device-management/current/resources/handle-resource-webapp.html) resources. * Deregistered: The device has requested deregistration, or its registration has expired. |  [optional]
**systemSuspended** | **Boolean** | Is the device suspended by the system? |  [optional]
**updatedAt** | [**DateTime**](DateTime.md) | The time this data object was updated. |  [optional]
**vendorId** | **String** | The device vendor ID. |  [optional]


<a name="DeployedStateEnum"></a>
## Enum: DeployedStateEnum
Name | Value
---- | -----
DEVELOPMENT | &quot;development&quot;
PRODUCTION | &quot;production&quot;


<a name="LifecycleStatusEnum"></a>
## Enum: LifecycleStatusEnum
Name | Value
---- | -----
ENABLED | &quot;enabled&quot;
BLOCKED | &quot;blocked&quot;


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



