
# DenialAttemptsResponse

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**after** | **String** | An offset token for current page. |  [optional]
**data** | [**List&lt;BlackListedDeviceData&gt;**](BlackListedDeviceData.md) |  |  [optional]
**hasMore** | **Boolean** | Are there more results available. |  [optional]
**limit** | **Integer** | How many objects to retrieve in the page. The minimum limit is 2 and the maximum is 1000. Limit values outside of this range are set to the closest limit. |  [optional]
**object** | **String** | The type of this API object is a \&quot;list\&quot;. |  [optional]
**order** | [**OrderEnum**](#OrderEnum) | The creation time based order of the entries. |  [optional]
**totalCount** | **Integer** |  |  [optional]


<a name="OrderEnum"></a>
## Enum: OrderEnum
Name | Value
---- | -----
ASC | &quot;ASC&quot;
DESC | &quot;DESC&quot;



