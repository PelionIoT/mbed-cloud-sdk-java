
# EndpointData

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**ep** | **String** | Unique Device Management device ID. |  [optional]
**ept** | **String** | Endpoint type. |  [optional]
**originalEp** | **String** | If device registration is initiated with a self-provided endpoint name, Device Management provides a new device ID for subsequent use. The new platform-provided Device ID is forwarded as the &#39;ep&#39; property and the original self-provided one as the optional &#39;original-ep&#39; property in a registration notification. The name and ID can then be mapped accordingly. Device Management saves the original endpoint name in the Device Directory for future device registrations so you don&#39;t need to do mapping again. |  [optional]
**q** | **Boolean** | Queue mode (default value is false). |  [optional]
**resources** | [**List&lt;ResourcesData&gt;**](ResourcesData.md) |  |  [optional]



