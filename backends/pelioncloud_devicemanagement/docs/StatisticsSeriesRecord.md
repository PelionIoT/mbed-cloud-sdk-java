
# StatisticsSeriesRecord

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**activeDevices** | **Integer** |  | 
**deviceToPelionMessages** | [**DeviceToPelionMessagesCounter**](DeviceToPelionMessagesCounter.md) |  |  [optional]
**firmwareUpdates** | **Integer** |  | 
**id** | **String** | Metric ID. | 
**object** | [**ObjectEnum**](#ObjectEnum) | Always &#x60;billing-statistics&#x60;. | 
**pelionToDeviceMessages** | [**PelionToDeviceMessagesCounter**](PelionToDeviceMessagesCounter.md) |  |  [optional]
**pelionToWebappNotifications** | **Integer** |  |  [optional]
**restApiRequestsWithApiKeyToken** | **Integer** |  |  [optional]
**restApiRequestsWithUserToken** | **Integer** |  |  [optional]
**sdaTokens** | **Integer** |  | 
**timestamp** | [**DateTime**](DateTime.md) | The start of the interval for which the data is aggregated, in RFC3339 date-time format with millisecond accuracy and UTC time zone. Each interval includes data for the time greater than or equal to the timestamp and less than the next interval&#39;s starting. | 


<a name="ObjectEnum"></a>
## Enum: ObjectEnum
Name | Value
---- | -----
STATISTICS | &quot;billing-statistics&quot;



