
# ReportNotFoundErrorResponse

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**code** | **Integer** | Response code. Always set to 404. | 
**message** | **String** | A human-readable message with detailed info. | 
**object** | [**ObjectEnum**](#ObjectEnum) | Always set to &#x60;error&#x60;. | 
**requestId** | **String** | Request ID | 
**type** | [**TypeEnum**](#TypeEnum) | Error type. Always set to &#x60;report_not_found&#x60;. | 


<a name="ObjectEnum"></a>
## Enum: ObjectEnum
Name | Value
---- | -----
ERROR | &quot;error&quot;


<a name="TypeEnum"></a>
## Enum: TypeEnum
Name | Value
---- | -----
FOUND | &quot;report_not_found&quot;



