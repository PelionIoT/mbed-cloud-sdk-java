
# UpdatedResponse

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**code** | **Integer** | Response code. | 
**object** | [**ObjectEnum**](#ObjectEnum) | Entity name: &#39;user&#39;, &#39;apikey&#39;, &#39;group&#39;, &#39;policy&#39; or &#39;account&#39;. | 
**requestId** | **String** | Request ID. | 
**message** | **String** | A human readable message with detailed info. | 
**type** | [**TypeEnum**](#TypeEnum) | Response type: success. | 
**id** | **String** | Entity ID. | 


<a name="ObjectEnum"></a>
## Enum: ObjectEnum
Name | Value
---- | -----
USER | &quot;user&quot;
API_KEY | &quot;api-key&quot;
GROUP | &quot;group&quot;
ACCOUNT | &quot;account&quot;
ACCOUNT_TEMPLATE | &quot;account-template&quot;
TRUSTED_CERT | &quot;trusted-cert&quot;
LIST | &quot;list&quot;
ERROR | &quot;error&quot;
POLICY | &quot;policy&quot;
IDENTITY_PROVIDER | &quot;identity-provider&quot;
USER_SESSION | &quot;user-session&quot;


<a name="TypeEnum"></a>
## Enum: TypeEnum
Name | Value
---- | -----
SUCCESS | &quot;success&quot;



