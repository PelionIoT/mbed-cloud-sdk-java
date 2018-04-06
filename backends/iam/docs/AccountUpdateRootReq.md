
# AccountUpdateRootReq

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**accountProperties** | [**Map&lt;String, Map&lt;String, String&gt;&gt;**](Map.md) | Properties for this account. |  [optional]
**addressLine1** | **String** | Postal address line 1, not longer than 100 characters. Required for commercial accounts only. |  [optional]
**addressLine2** | **String** | Postal address line 2, not longer than 100 characters. |  [optional]
**aliases** | **List&lt;String&gt;** | An array of aliases, not more than 10. An alias is not shorter than 8 and not longer than 100 characters. |  [optional]
**city** | **String** | The city part of the postal address, not longer than 100 characters. Required for commercial accounts only. |  [optional]
**company** | **String** | The name of the company, not longer than 100 characters. Required for commercial accounts only. |  [optional]
**contact** | **String** | The name of the contact person for this account, not longer than 100 characters. Required for commercial accounts only. |  [optional]
**contractNumber** | **String** | Contract number of the customer. |  [optional]
**country** | **String** | The country part of the postal address, not longer than 100 characters. Required for commercial accounts only. |  [optional]
**customerNumber** | **String** | Customer number of the customer. |  [optional]
**displayName** | **String** | The display name for the account, not longer than 100 characters. |  [optional]
**email** | **String** | The company email address for this account, not longer than 254 characters. Required for commercial accounts only. |  [optional]
**endMarket** | **String** | The end market for this account, not longer than 100 characters. |  [optional]
**expirationWarningThreshold** | **String** | Indicates how many days before account expiration a notification email should be sent. Valid values are: 1-180. |  [optional]
**idleTimeout** | **String** | The reference token expiration time in minutes for this account. Between 1 and 120 minutes. |  [optional]
**mfaStatus** | [**MfaStatusEnum**](#MfaStatusEnum) | The enforcement status of setting up the multi-factor authentication. &#39;Enforced&#39; means that setting up the MFA is required after login. &#39;Optional&#39; means that the MFA is not required. |  [optional]
**notificationEmails** | **List&lt;String&gt;** | A list of notification email addresses. |  [optional]
**passwordPolicy** | [**PasswordPolicy**](PasswordPolicy.md) | Password policy for this account. |  [optional]
**phoneNumber** | **String** | The phone number of a representative of the company, not longer than 100 characters. |  [optional]
**postalCode** | **String** | The postal code part of the postal address, not longer than 100 characters. |  [optional]
**salesContact** | **String** | Email address of the sales contact. |  [optional]
**state** | **String** | The state part of the postal address, not longer than 100 characters. |  [optional]


<a name="MfaStatusEnum"></a>
## Enum: MfaStatusEnum
Name | Value
---- | -----
ENFORCED | &quot;enforced&quot;
OPTIONAL | &quot;optional&quot;



