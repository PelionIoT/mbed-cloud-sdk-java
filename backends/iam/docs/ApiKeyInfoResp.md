
# ApiKeyInfoResp

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**groups** | **List&lt;String&gt;** | A list of group IDs this API key belongs to. |  [optional]
**status** | [**StatusEnum**](#StatusEnum) | The status of the API key. |  [optional]
**name** | **String** | The display name for the API key. | 
**createdAt** | [**DateTime**](DateTime.md) | Creation UTC time RFC3339. |  [optional]
**object** | [**ObjectEnum**](#ObjectEnum) | Entity name: always &#39;api-key&#39; | 
**creationTime** | **Long** | The timestamp of the API key creation in the storage, in milliseconds. |  [optional]
**etag** | **String** | API resource entity version. | 
**key** | **String** | The API key. | 
**owner** | **String** | The owner of this API key. |  [optional]
**id** | **String** | The UUID of the API key. | 
**lastLoginTime** | **Long** | The timestamp of the latest API key usage, in milliseconds. |  [optional]


<a name="StatusEnum"></a>
## Enum: StatusEnum
Name | Value
---- | -----
ACTIVE | &quot;ACTIVE&quot;
INACTIVE | &quot;INACTIVE&quot;


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



