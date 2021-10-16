
# StatisticsViewResponse

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**after** | **String** | The ID after which to fetch the statistics view. |  [optional]
**data** | [**List&lt;StatisticsSeriesRecord&gt;**](StatisticsSeriesRecord.md) | List of statistics view records. Empty list if no records are available. | 
**hasMore** | **Boolean** | Indicates whether a new statistics view response is available. | 
**limit** | **Integer** | Maximum number of statistics view records on a page. | 
**object** | [**ObjectEnum**](#ObjectEnum) | Always &#x60;list&#x60;. | 
**order** | **String** | Record order. Acceptable values: ASC, DESC. Default: ASC. | 
**totalCount** | **Long** | Sum of all statistics view records to return. Included in the response when you use the query parameter include&#x3D;total_count. |  [optional]


<a name="ObjectEnum"></a>
## Enum: ObjectEnum
Name | Value
---- | -----
LIST | &quot;list&quot;



