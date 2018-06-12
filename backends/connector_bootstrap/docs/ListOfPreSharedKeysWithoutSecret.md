
# ListOfPreSharedKeysWithoutSecret

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**after** | **String** | An offset token for current page. |  [optional]
**continuationMarker** | **String** | An offset token for fetching the next page. Note that exactly the same limit needs to be used on the request for fetching the subsequent pages. |  [optional]
**data** | [**List&lt;PreSharedKeyWithoutSecret&gt;**](PreSharedKeyWithoutSecret.md) | Array of the pre-shared key entries. The array is empty if there are no pre-shared keys. | 
**hasMore** | **Boolean** | Are there more results available. | 
**limit** | **Integer** | The value of limit query parameter from the request, or default if not specified. | 
**object** | **String** | The type of this API object is a \&quot;list\&quot;. | 
**order** | **String** | The creation time based order of the entries. | 



