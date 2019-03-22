
# DeviceDataPutRequest

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**autoUpdate** | **Boolean** | DEPRECATED: Mark this device for automatic firmware update. |  [optional]
**caId** | **String** | The certificate issuer&#39;s ID. |  [optional]
**customAttributes** | **Map&lt;String, String&gt;** | Up to five custom key-value attributes. Note that keys cannot begin with a number. Both keys and values are limited to 128 characters. Updating this field replaces existing contents. |  [optional]
**description** | **String** | The description of the device. |  [optional]
**deviceKey** | **String** | The fingerprint of the device certificate. |  [optional]
**endpointName** | **String** | The endpoint name given to the device. |  [optional]
**endpointType** | **String** | The endpoint type of the device. For example, the device is a gateway. |  [optional]
**groups** | **List&lt;String&gt;** | An array containing an ID of each group this device belongs to. |  [optional]
**hostGateway** | **String** | The &#x60;endpoint_name&#x60; of the host gateway, if appropriate. |  [optional]
**name** | **String** | The name of the device. |  [optional]
**object** | **String** | The API resource entity. |  [optional]



