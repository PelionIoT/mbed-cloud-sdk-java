
# ServicePackageQuotaHistoryResponse

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**after** | **String** | After which quota history id this paged response is fetched. |  [optional]
**data** | [**List&lt;ServicePackageQuotaHistoryItem&gt;**](ServicePackageQuotaHistoryItem.md) | List of history items, empty list if no entries are available. | 
**hasMore** | **Boolean** | If there is next available quota history paged response to be fetched. | 
**limit** | **Integer** | Maximum amount of quota history entries contained in one paged response. | 
**object** | [**ObjectEnum**](#ObjectEnum) | Always set to &#39;service-package-quota-history&#39;. | 
**totalCount** | **Integer** | Sum of all quota history entries that should be returned | 


<a name="ObjectEnum"></a>
## Enum: ObjectEnum
Name | Value
---- | -----
HISTORY | &quot;service-package-quota-history&quot;



