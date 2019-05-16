
# AccountUpdateReq

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**addressLine1** | **String** | Postal address line 1. Required for commercial accounts only. |  [optional]
**addressLine2** | **String** | Postal address line 2. |  [optional]
**aliases** | **List&lt;String&gt;** | An array of aliases. |  [optional]
**city** | **String** | The city part of the postal address. Required for commercial accounts only. |  [optional]
**company** | **String** | The name of the company. Required for commercial accounts only. |  [optional]
**contact** | **String** | The name of the contact person for this account. Required for commercial accounts only. |  [optional]
**country** | **String** | The country part of the postal address. Required for commercial accounts only. |  [optional]
**customFields** | **Map&lt;String, String&gt;** | Account&#39;s custom properties as key-value pairs. |  [optional]
**displayName** | **String** | The display name for the account. |  [optional]
**email** | **String** | The company email address for this account. Required for commercial accounts only. |  [optional]
**endMarket** | **String** | The end market for this account. |  [optional]
**expirationWarningThreshold** | **Integer** | Indicates how many days before account expiration a notification email is sent. |  [optional]
**idleTimeout** | **Integer** | Reference token expiration time in minutes. |  [optional]
**mfaStatus** | [**MfaStatusEnum**](#MfaStatusEnum) | The enforcement status of multi-factor authentication, either &#x60;enforced&#x60; or &#x60;optional&#x60;. |  [optional]
**notificationEmails** | **List&lt;String&gt;** | A list of notification email addresses. |  [optional]
**passwordPolicy** | [**PasswordPolicy**](PasswordPolicy.md) | Password policy for this account. |  [optional]
**passwordRecoveryExpiration** | **Integer** | Indicates for how many minutes a password recovery email is valid. |  [optional]
**phoneNumber** | **String** | The phone number of a representative of the company. |  [optional]
**postalCode** | **String** | The postal code part of the postal address. |  [optional]
**state** | **String** | The state part of the postal address. |  [optional]


<a name="MfaStatusEnum"></a>
## Enum: MfaStatusEnum
Name | Value
---- | -----
ENFORCED | &quot;enforced&quot;
OPTIONAL | &quot;optional&quot;



