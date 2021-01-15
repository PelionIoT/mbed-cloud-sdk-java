
# ServicePackageQuotaHistoryResponse

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**after** | **String** | ID after which to fetch quota history. |  [optional]
**data** | [**List&lt;ServicePackageQuotaHistoryItem&gt;**](ServicePackageQuotaHistoryItem.md) | List of history items. Empty list if no entries are available. | 
**hasMore** | **Boolean** | If there is next available quota history paged response to fetch. | 
**limit** | **Integer** | Maximum number of quota history entries in one paged response. | 
**object** | [**ObjectEnum**](#ObjectEnum) | Always set to &#x60;service-package-quota-history&#x60;. | 
**order** | **String** | History item record order based on creation time. | 
**totalCount** | **Integer** | Sum of all quota history entries that should be returned. | 


<a name="ObjectEnum"></a>
## Enum: ObjectEnum
Name | Value
---- | -----
HISTORY | &quot;service-package-quota-history&quot;



