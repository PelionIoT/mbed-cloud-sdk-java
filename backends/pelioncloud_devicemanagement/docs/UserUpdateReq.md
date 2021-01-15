
# UserUpdateReq

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**address** | **String** | Address. |  [optional]
**email** | **String** | The email address. Not allowed to update other user&#39;s email address. |  [optional]
**fullName** | **String** | The full name of the user. |  [optional]
**groups** | **List&lt;String&gt;** | A list of group IDs this user belongs to. Can be updated by the Account Admin only. |  [optional]
**isGtcAccepted** | **Boolean** | A flag indicating that the user has accepted General Terms and Conditions. |  [optional]
**isMarketingAccepted** | **Boolean** | A flag indicating that the user has consented to receive marketing information. |  [optional]
**isTotpEnabled** | **Boolean** | A flag indicating whether two-factor authentication (TOTP) is enabled. An account administrator can disable it, but cannot enable it for other users. |  [optional]
**loginProfiles** | [**List&lt;LoginProfile&gt;**](LoginProfile.md) | &#39;A list of login profiles for the user, specified as identity providers associated with the user. Only the ID attribute of the login profile should be set in the request object. The list cannot be empty. Only an account admin may update login profiles.&#39; |  [optional]
**phoneNumber** | **String** | Phone number. |  [optional]
**status** | [**StatusEnum**](#StatusEnum) | The status of the user. ENROLLING indicates that the user is in the middle of the enrollment process. INVITED means that the user has not accepted the invitation request. RESET means that the password must be changed immediately. INACTIVE users are locked out and not permitted to use the system. Can be changed by the Aggregator Admin only. |  [optional]
**username** | **String** | A username. |  [optional]


<a name="StatusEnum"></a>
## Enum: StatusEnum
Name | Value
---- | -----
ENROLLING | &quot;ENROLLING&quot;
INVITED | &quot;INVITED&quot;
ACTIVE | &quot;ACTIVE&quot;
RESET | &quot;RESET&quot;
INACTIVE | &quot;INACTIVE&quot;



