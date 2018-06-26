
# ForbiddenErrorResponse

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**code** | **Integer** | Response code. Always set to 403. | 
**message** | **String** | A human readable message with detailed info. | 
**object** | [**ObjectEnum**](#ObjectEnum) | Always set to &#39;error&#39;. | 
**requestId** | **String** | Request ID | 
**type** | [**TypeEnum**](#TypeEnum) | Error type. Always set to &#39;forbidden&#39;. | 


<a name="ObjectEnum"></a>
## Enum: ObjectEnum
Name | Value
---- | -----
ERROR | &quot;error&quot;


<a name="TypeEnum"></a>
## Enum: TypeEnum
Name | Value
---- | -----
FORBIDDEN | &quot;forbidden&quot;



