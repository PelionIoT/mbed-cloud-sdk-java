
# DeviceDataPutRequest

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**description** | **String** | The description of the device. |  [optional]
**endpointName** | **String** | The endpoint name given to the device. |  [optional]
**autoUpdate** | **Boolean** | DEPRECATED: Mark this device for automatic firmware update. |  [optional]
**hostGateway** | **String** | The &#x60;endpoint_name&#x60; of the host gateway, if appropriate. |  [optional]
**enrolmentListTimestamp** | [**DateTime**](DateTime.md) | The claim date/time. |  [optional]
**object** | **String** | The API resource entity. |  [optional]
**customAttributes** | **Map&lt;String, String&gt;** | Up to five custom key-value attributes. Note that keys cannot start with a number. |  [optional]
**deviceKey** | **String** | The fingerprint of the device certificate. |  [optional]
**endpointType** | **String** | The endpoint type of the device. For example, the device is a gateway. |  [optional]
**caId** | **String** | The certificate issuer&#39;s ID. |  [optional]
**name** | **String** | The name of the device. |  [optional]



