
# CampaignDeviceMetadataPage

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**after** | **String** | The entity ID to fetch after the given one |  [optional]
**hasMore** | **Boolean** | Flag indicating whether there are more results |  [optional]
**totalCount** | **Integer** | The total number or records, if requested. It might be returned also for small lists. |  [optional]
**object** | **String** | Entity name: always &#39;list&#39; |  [optional]
**limit** | **Integer** | The number of results to return, (range: 2-1000), or equals to total_count |  [optional]
**data** | [**List&lt;CampaignDeviceMetadata&gt;**](CampaignDeviceMetadata.md) | A list of entities |  [optional]
**order** | [**OrderEnum**](#OrderEnum) | The order of the records to return. Acceptable values: ASC, DESC. Default: ASC |  [optional]


<a name="OrderEnum"></a>
## Enum: OrderEnum
Name | Value
---- | -----
ASC | &quot;ASC&quot;
DESC | &quot;DESC&quot;



