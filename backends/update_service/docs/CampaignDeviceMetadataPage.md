
# CampaignDeviceMetadataPage

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**after** | **String** | The entity ID to fetch after the given one |  [optional]
**data** | [**List&lt;CampaignDeviceMetadata&gt;**](CampaignDeviceMetadata.md) | A list of entities |  [optional]
**hasMore** | **Boolean** | A flag indicating whether there are more results |  [optional]
**limit** | **Integer** | How many objects to retrieve in the page. The minimum limit is 2 and the maximum is 1000. Limit values outside of this range are set to the closest limit. |  [optional]
**object** | **String** | The entity name: always &#39;list&#39; |  [optional]
**order** | [**OrderEnum**](#OrderEnum) | The order of the records to return. Acceptable values: ASC, DESC. Default: ASC |  [optional]
**totalCount** | **Integer** | The total number or records, if requested. It may be returned also for small lists. |  [optional]


<a name="OrderEnum"></a>
## Enum: OrderEnum
Name | Value
---- | -----
ASC | &quot;ASC&quot;
DESC | &quot;DESC&quot;



