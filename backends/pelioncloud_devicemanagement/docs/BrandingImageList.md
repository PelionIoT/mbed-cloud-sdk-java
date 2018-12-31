
# BrandingImageList

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**after** | **String** | The entity ID to fetch after the given one. |  [optional]
**data** | [**List&lt;BrandingImage&gt;**](BrandingImage.md) | A list of entities. | 
**hasMore** | **Boolean** | Flag indicating whether there is more results. | 
**limit** | **Integer** | The number of results to return, (range: 2-1000), or equals to &#x60;total_count&#x60; | 
**object** | [**ObjectEnum**](#ObjectEnum) | Entity name: always &#39;list&#39; | 
**order** | [**OrderEnum**](#OrderEnum) | The order of the records to return based on creation time. Available values: ASC, DESC; by default ASC. |  [optional]
**totalCount** | **Integer** | The total number or records, if requested. It might be returned also for small lists. | 


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



