
# AccountUpdateRootReq

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**endMarket** | **String** | The end market for this account, not longer than 100 characters. |  [optional]
**passwordPolicy** | [**PasswordPolicy**](PasswordPolicy.md) | Password policy for this account. |  [optional]
**salesContact** | **String** | Email address of the sales contact. |  [optional]
**email** | **String** | The company email address for this account, not longer than 254 characters. Required for commercial accounts only. |  [optional]
**postalCode** | **String** | The postal code part of the postal address, not longer than 100 characters. |  [optional]
**accountProperties** | [**Map&lt;String, Map&lt;String, String&gt;&gt;**](Map.md) | Properties for this account. |  [optional]
**aliases** | **List&lt;String&gt;** | An array of aliases, not more than 10. An alias is not shorter than 8 and not longer than 100 characters. |  [optional]
**addressLine2** | **String** | Postal address line 2, not longer than 100 characters. |  [optional]
**city** | **String** | The city part of the postal address, not longer than 100 characters. Required for commercial accounts only. |  [optional]
**addressLine1** | **String** | Postal address line 1, not longer than 100 characters. Required for commercial accounts only. |  [optional]
**displayName** | **String** | The display name for the account, not longer than 100 characters. |  [optional]
**mfaStatus** | [**MfaStatusEnum**](#MfaStatusEnum) | The enforcement status of setting up the multi-factor authentication. &#39;Enforced&#39; means that setting up the MFA is required after login. &#39;Optional&#39; means that the MFA is not required. |  [optional]
**state** | **String** | The state part of the postal address, not longer than 100 characters. |  [optional]
**contractNumber** | **String** | Contract number of the customer. |  [optional]
**phoneNumber** | **String** | The phone number of a representative of the company, not longer than 100 characters. |  [optional]
**company** | **String** | The name of the company, not longer than 100 characters. Required for commercial accounts only. |  [optional]
**idleTimeout** | **String** | The reference token expiration time in minutes for this account. Between 1 and 120 minutes. |  [optional]
**country** | **String** | The country part of the postal address, not longer than 100 characters. Required for commercial accounts only. |  [optional]
**customerNumber** | **String** | Customer number of the customer. |  [optional]
**expirationWarningThreshold** | **String** | Indicates how many days before the account expiration a notification email should be sent. |  [optional]
**contact** | **String** | The name of the contact person for this account, not longer than 100 characters. Required for commercial accounts only. |  [optional]
**notificationEmails** | **List&lt;String&gt;** | A list of notification email addresses. |  [optional]


<a name="MfaStatusEnum"></a>
## Enum: MfaStatusEnum
Name | Value
---- | -----
ENFORCED | &quot;enforced&quot;
OPTIONAL | &quot;optional&quot;



