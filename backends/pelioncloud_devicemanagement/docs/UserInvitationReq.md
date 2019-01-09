
# UserInvitationReq

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**email** | **String** | The email address, not longer than 254 characters. | 
**groups** | **List&lt;String&gt;** | A list of IDs of the groups this user has been invited to. |  [optional]
**loginProfiles** | [**List&lt;LoginProfile&gt;**](LoginProfile.md) | A list of login profiles for the user. Specified as the identity providers the user should be associated with. Only the ID attribute of the login profile should be set in the request object. The list cannot be empty. A limit of 100 profiles. |  [optional]
**validForDays** | **Integer** | Specifies how many days the invitation will be valid for. The default is 30 days. Value should be between 1 and 100 days. |  [optional]



