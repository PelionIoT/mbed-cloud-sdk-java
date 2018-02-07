
# GroupSummary

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**lastUpdateTime** | **Long** | A timestamp of the latest group update, in milliseconds. |  [optional]
**userCount** | **Integer** | The number of users in this group. | 
**name** | **String** | The name of the group. | 
**createdAt** | [**DateTime**](DateTime.md) | Creation UTC time RFC3339. |  [optional]
**object** | [**ObjectEnum**](#ObjectEnum) | Entity name: always &#39;group&#39; | 
**creationTime** | **Long** | A timestamp of the group creation in the storage, in milliseconds. |  [optional]
**etag** | **String** | API resource entity version. | 
**apikeyCount** | **Integer** | The number of API keys in this group. | 
**id** | **String** | The UUID of the group. | 
**accountId** | **String** | The UUID of the account this group belongs to. | 


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



