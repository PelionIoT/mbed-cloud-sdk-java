
# EventTypeSummaryList

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**after** | **String** | The entity ID to fetch after the given one |  [optional]
**data** | [**List&lt;EventTypeSummary&gt;**](EventTypeSummary.md) |  |  [optional]
**hasMore** | **Boolean** | A flag indicating whether there are more results |  [optional]
**limit** | **Integer** | The number of results to return, (range: 2-1000), or equals to total_count |  [optional]
**object** | **String** | The entity name: always &#39;list&#39; |  [optional]
**order** | [**OrderEnum**](#OrderEnum) | The order of the records to return. Acceptable values: ASC, DESC. Default: ASC |  [optional]
**totalCount** | **Integer** | The total number or records, if requested. It may be returned also for small lists. |  [optional]


<a name="OrderEnum"></a>
## Enum: OrderEnum
Name | Value
---- | -----
ASC | &quot;ASC&quot;
DESC | &quot;DESC&quot;



