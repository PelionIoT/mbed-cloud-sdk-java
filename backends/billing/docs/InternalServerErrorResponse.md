
# InternalServerErrorResponse

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**code** | **Integer** | Response code. Always set to 500. | 
**message** | **String** | A human readable message with detailed info. | 
**object** | [**ObjectEnum**](#ObjectEnum) | Always set to &#39;error&#39;. | 
**requestId** | **String** | Request ID | 
**type** | [**TypeEnum**](#TypeEnum) | Error type. Always set to &#39;internal_error&#39;. | 


<a name="ObjectEnum"></a>
## Enum: ObjectEnum
Name | Value
---- | -----
ERROR | &quot;error&quot;


<a name="TypeEnum"></a>
## Enum: TypeEnum
Name | Value
---- | -----
ERROR | &quot;internal_error&quot;



