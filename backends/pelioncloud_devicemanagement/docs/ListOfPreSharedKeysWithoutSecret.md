
# ListOfPreSharedKeysWithoutSecret

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**after** | **String** | An offset token for current page. |  [optional]
**continuationMarker** | **String** | An offset token for fetching the next page. Note that exactly the same limit needs to be used on the request for fetching subsequent pages. |  [optional]
**data** | [**List&lt;PreSharedKeyWithoutSecret&gt;**](PreSharedKeyWithoutSecret.md) | Array of the PSK entries. The array is empty if there are no PSKs. | 
**hasMore** | **Boolean** | More results are available. | 
**limit** | **Integer** | The value of limit query parameter from the request, or default if not specified. | 
**object** | **String** | The type of this API object is a \&quot;list\&quot;. | 
**order** | **String** | Record order based on creation time. | 



