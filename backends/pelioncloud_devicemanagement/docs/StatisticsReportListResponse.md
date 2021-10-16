
# StatisticsReportListResponse

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**after** | **String** | An offset token for the current page. |  [optional]
**data** | [**List&lt;StatisticsReportResponse&gt;**](StatisticsReportResponse.md) | List of manufacturing statistics. |  [optional]
**end** | [**DateTime**](DateTime.md) |  |  [optional]
**hasMore** | **Boolean** | Indicates whether additional results are available. |  [optional]
**limit** | **Integer** | The number of results to return (2-1000). Values outside of this range are set to the closest limit. |  [optional]
**object** | **String** | The API object type. The object type of this API is \&quot;list\&quot;. |  [optional]
**order** | **String** | Record order based on record identifier. |  [optional]
**start** | [**DateTime**](DateTime.md) |  |  [optional]
**totalCount** | **Integer** |  |  [optional]



