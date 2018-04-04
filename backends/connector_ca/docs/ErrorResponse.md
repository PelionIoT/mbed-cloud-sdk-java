
# ErrorResponse

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**code** | [**CodeEnum**](#CodeEnum) | Response code. |  [optional]
**fields** | [**List&lt;Field&gt;**](Field.md) | Failed input fields during request object validation. |  [optional]
**message** | **String** | A human readable message with detailed info. |  [optional]
**object** | [**ObjectEnum**](#ObjectEnum) | Entity name, always &#39;error&#39;. |  [optional]
**requestId** | **String** | Request ID (muuid). |  [optional]
**type** | [**TypeEnum**](#TypeEnum) | Error type. |  [optional]


<a name="CodeEnum"></a>
## Enum: CodeEnum
Name | Value
---- | -----
NUMBER_400 | 400
NUMBER_401 | 401
NUMBER_404 | 404


<a name="ObjectEnum"></a>
## Enum: ObjectEnum
Name | Value
---- | -----
ERROR | &quot;error&quot;


<a name="TypeEnum"></a>
## Enum: TypeEnum
Name | Value
---- | -----
VALIDATION_ERROR | &quot;validation_error&quot;
INVALID_TOKEN | &quot;invalid_token&quot;
INVALID_APIKEY | &quot;invalid_apikey&quot;
REAUTH_REQUIRED | &quot;reauth_required&quot;
ACCESS_DENIED | &quot;access_denied&quot;
ACCOUNT_LIMIT_EXCEEDED | &quot;account_limit_exceeded&quot;
NOT_FOUND | &quot;not_found&quot;
METHOD_NOT_SUPPORTED | &quot;method_not_supported&quot;
NOT_ACCEPTABLE | &quot;not_acceptable&quot;
DUPLICATE | &quot;duplicate&quot;
PRECONDITION_FAILED | &quot;precondition_failed&quot;
UNSUPPORTED_MEDIA_TYPE | &quot;unsupported_media_type&quot;
RATE_LIMIT_EXCEEDED | &quot;rate_limit_exceeded&quot;
INTERNAL_SERVER_ERROR | &quot;internal_server_error&quot;
SYSTEM_UNAVAILABLE | &quot;system_unavailable&quot;



