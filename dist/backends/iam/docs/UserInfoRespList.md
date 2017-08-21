
# UserInfoRespList

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**after** | **String** | The entity ID to fetch after the given one. |  [optional]
**hasMore** | **Boolean** | Flag indicating whether there is more results. | 
**totalCount** | **Integer** | The total number or records, if requested. It might be returned also for small lists. | 
**object** | [**ObjectEnum**](#ObjectEnum) | Entity name: always &#39;list&#39; | 
**limit** | **Integer** | The number of results to return, (range: 2-1000), or equals to &#x60;total_count&#x60; | 
**data** | [**List&lt;UserInfoResp&gt;**](UserInfoResp.md) | A list of entities. | 
**order** | [**OrderEnum**](#OrderEnum) | The order of the records to return. Available values: ASC, DESC; by default ASC. |  [optional]


<a name="ObjectEnum"></a>
## Enum: ObjectEnum
Name | Value
---- | -----
USER | &quot;user&quot;
API_KEY | &quot;api-key&quot;
GROUP | &quot;group&quot;
ACCOUNT | &quot;account&quot;
ACCOUNT_TEMPLATE | &quot;account-template&quot;
TRUSTED_CERT | &quot;trusted-cert&quot;
LIST | &quot;list&quot;
ERROR | &quot;error&quot;


<a name="OrderEnum"></a>
## Enum: OrderEnum
Name | Value
---- | -----
ASC | &quot;ASC&quot;
DESC | &quot;DESC&quot;


