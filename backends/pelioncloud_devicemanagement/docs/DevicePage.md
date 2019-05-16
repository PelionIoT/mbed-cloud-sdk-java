
# DevicePage

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**after** | **String** | An offset token for current page. |  [optional]
**data** | [**List&lt;DeviceData&gt;**](DeviceData.md) |  |  [optional]
**hasMore** | **Boolean** | Are there more results available. |  [optional]
**limit** | **Integer** | How many objects to retrieve in the page. The minimum limit is 2 and the maximum is 1000. Limit values outside of this range are set to the closest limit. |  [optional]
**object** | **String** | The type of this API object is a \&quot;list\&quot;. |  [optional]
**order** | **String** | The order of the records based on creation time, &#x60;ASC&#x60; or &#x60;DESC&#x60;; by default &#x60;ASC&#x60;. |  [optional]
**totalCount** | **Integer** |  |  [optional]



