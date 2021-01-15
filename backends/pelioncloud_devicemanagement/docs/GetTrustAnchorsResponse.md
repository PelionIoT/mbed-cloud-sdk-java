
# GetTrustAnchorsResponse

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**after** | **String** | An offset token for the current page. |  [optional]
**data** | [**List&lt;TrustAnchorResponse&gt;**](TrustAnchorResponse.md) | The list of trust anchors of the account. |  [optional]
**hasMore** | **Boolean** | Indicates whether additional results are available. |  [optional]
**limit** | **Integer** | Indicates how many objects to retrieve in the page. The minimum limit is 2 and the maximum is 1000. Limit values outside of this range are set to the closest limit. |  [optional]
**object** | **String** | The type of this API object is a &#x60;list&#x60;. |  [optional]
**order** | [**OrderEnum**](#OrderEnum) | Indicates how to order the entries based on when they were created. |  [optional]
**totalCount** | **Integer** |  |  [optional]


<a name="OrderEnum"></a>
## Enum: OrderEnum
Name | Value
---- | -----
ASC | &quot;ASC&quot;
DESC | &quot;DESC&quot;



