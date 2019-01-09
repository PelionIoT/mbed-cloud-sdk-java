
# UpdatedResponse

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**code** | **Integer** | Response code. | 
**id** | **String** | Entity ID. | 
**message** | **String** | A human readable message with detailed info. | 
**object** | [**ObjectEnum**](#ObjectEnum) | Entity name: &#39;user&#39;, &#39;api-key&#39;, &#39;group&#39;, &#39;policy&#39; or &#39;account&#39;. | 
**requestId** | **String** | Request ID. | 
**type** | [**TypeEnum**](#TypeEnum) | Response type: success. | 


<a name="ObjectEnum"></a>
## Enum: ObjectEnum
Name | Value
---- | -----
USER | &quot;user&quot;
API_KEY | &quot;api-key&quot;
GROUP | &quot;group&quot;
POLICY | &quot;policy&quot;
ACCOUNT | &quot;account&quot;


<a name="TypeEnum"></a>
## Enum: TypeEnum
Name | Value
---- | -----
SUCCESS | &quot;success&quot;



