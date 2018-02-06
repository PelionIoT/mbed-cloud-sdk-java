
# GroupSummary

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**userCount** | **Integer** | The number of users in this group. | 
**accountId** | **String** | The UUID of the account this group belongs to. | 
**createdAt** | [**DateTime**](DateTime.md) | Creation UTC time RFC3339. |  [optional]
**object** | [**ObjectEnum**](#ObjectEnum) | Entity name: always &#39;group&#39; | 
**updatedAt** | [**DateTime**](DateTime.md) | Last update UTC time RFC3339. |  [optional]
**etag** | **String** | API resource entity version. | 
**apikeyCount** | **Integer** | The number of API keys in this group. | 
**id** | **String** | The UUID of the group. | 
**name** | **String** | The name of the group. | 


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



