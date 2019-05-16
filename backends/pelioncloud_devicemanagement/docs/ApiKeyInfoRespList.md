
# ApiKeyInfoRespList

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**after** | **String** | The entity ID to fetch after the given one. |  [optional]
**data** | [**List&lt;ApiKeyInfoResp&gt;**](ApiKeyInfoResp.md) | A list of entities. | 
**hasMore** | **Boolean** | Flag indicating whether there are more results. | 
**limit** | **Integer** | The number of results to return, or equal to &#x60;total_count&#x60;. | 
**object** | [**ObjectEnum**](#ObjectEnum) | Entity name: always &#x60;list&#x60;. | 
**order** | [**OrderEnum**](#OrderEnum) | The order of the records to return based on creation time. Available values: ASC, DESC; by default ASC. |  [optional]
**totalCount** | **Integer** | The total number of records, if requested. | 


<a name="ObjectEnum"></a>
## Enum: ObjectEnum
Name | Value
---- | -----
LIST | &quot;list&quot;


<a name="OrderEnum"></a>
## Enum: OrderEnum
Name | Value
---- | -----
ASC | &quot;ASC&quot;
DESC | &quot;DESC&quot;



