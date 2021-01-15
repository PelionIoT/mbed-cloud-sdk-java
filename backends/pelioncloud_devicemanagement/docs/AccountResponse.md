
# AccountResponse

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**alias** | **String** | Alias of the account. |  [optional]
**displayName** | **String** | The display name for the account. |  [optional]
**id** | **String** | The UUID of the account. |  [optional]
**loginProfiles** | [**List&lt;LoginProfile&gt;**](LoginProfile.md) | A list of login profiles for the user in the account. |  [optional]
**parentId** | **String** | The UUID of the parent account, if it has any. |  [optional]
**status** | [**StatusEnum**](#StatusEnum) | The status of the account. |  [optional]


<a name="StatusEnum"></a>
## Enum: StatusEnum
Name | Value
---- | -----
ENROLLING | &quot;ENROLLING&quot;
ACTIVE | &quot;ACTIVE&quot;
RESTRICTED | &quot;RESTRICTED&quot;
SUSPENDED | &quot;SUSPENDED&quot;



