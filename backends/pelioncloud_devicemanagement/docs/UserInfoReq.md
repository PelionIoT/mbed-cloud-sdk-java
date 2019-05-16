
# UserInfoReq

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**address** | **String** | Address. |  [optional]
**email** | **String** | The email address. | 
**fullName** | **String** | The full name of the user. |  [optional]
**groups** | **List&lt;String&gt;** | A list of IDs of the groups this user belongs to. |  [optional]
**isGtcAccepted** | **Boolean** | A flag indicating that the user has accepted General Terms and Conditions. |  [optional]
**isMarketingAccepted** | **Boolean** | A flag indicating that the user has consented to receive marketing information. |  [optional]
**loginProfiles** | [**List&lt;LoginProfile&gt;**](LoginProfile.md) | A list of login profiles for the user. Specified as the identity providers the user should be associated with. Only the ID attribute of the login profile should be set in the request object. |  [optional]
**password** | **String** | The password for a new user. Generated when not present in the request. |  [optional]
**phoneNumber** | **String** | Phone number. |  [optional]
**username** | **String** | A username. |  [optional]



