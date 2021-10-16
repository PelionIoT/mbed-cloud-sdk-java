
# AccountUpdateRootReq

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**addressLine1** | **String** | Postal address line 1. Required for commercial accounts only. |  [optional]
**addressLine2** | **String** | Postal address line 2. |  [optional]
**aliases** | **List&lt;String&gt;** | An array of aliases for the tenant account ID. The aliases must be globally unique. |  [optional]
**businessModel** | [**BusinessModel**](BusinessModel.md) |  |  [optional]
**city** | **String** | The city part of the postal address. Required for commercial accounts only. |  [optional]
**company** | **String** | The name of the company used in billing. Required for commercial accounts only. |  [optional]
**contact** | **String** | The name of the contact person for this account. Required for commercial accounts only. |  [optional]
**contractNumber** | **String** | Contract number of the customer. An administrator can set this property on tenant accounts only. |  [optional]
**country** | **String** | The country part of the postal address. Required for commercial accounts only. |  [optional]
**customFields** | **Map&lt;String, String&gt;** | Account&#39;s custom properties as key-value pairs. |  [optional]
**customerNumber** | **String** | Customer number of the customer. An administrator can set this property on tenant accounts only. |  [optional]
**displayName** | **String** | The display name for the tenant account. |  [optional]
**email** | **String** | The company email address for this account. Required for commercial accounts only. |  [optional]
**endMarket** | **String** | The end market for this account. |  [optional]
**expirationWarningThreshold** | **Integer** | Indicates how many days before account expiration a notification email is sent. |  [optional]
**idleTimeout** | **Integer** | The reference token expiration time in minutes for this account. Between 1 and 120 minutes. |  [optional]
**mfaStatus** | [**MfaStatusEnum**](#MfaStatusEnum) | The enforcement status of setting up the multi-factor authentication. &#39;Enforced&#39; means that setting up the MFA is required after login. &#39;Optional&#39; means that the MFA is not required. |  [optional]
**notificationEmails** | **List&lt;String&gt;** | A list of notification email addresses. |  [optional]
**passwordPolicy** | [**PasswordPolicy**](PasswordPolicy.md) | Password policy for this account. |  [optional]
**passwordRecoveryExpiration** | **Integer** | Indicates for how many minutes a password recovery email is valid. |  [optional]
**phoneNumber** | **String** | The phone number of a representative of the company. |  [optional]
**postalCode** | **String** | The postal code part of the postal address. |  [optional]
**salesContact** | **String** | Email address of the sales contact. |  [optional]
**state** | **String** | The state part of the postal address. |  [optional]


<a name="MfaStatusEnum"></a>
## Enum: MfaStatusEnum
Name | Value
---- | -----
ENFORCED | &quot;enforced&quot;
OPTIONAL | &quot;optional&quot;



