
# AccountInfo

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**addressLine1** | **String** | Postal address line 1. |  [optional]
**addressLine2** | **String** | Postal address line 2. |  [optional]
**aliases** | **List&lt;String&gt;** | An array of aliases for the tenant account ID. The aliases must be globally unique. |  [optional]
**businessModel** | [**BusinessModel**](BusinessModel.md) |  |  [optional]
**businessModelHistory** | [**List&lt;BusinessModelHistory&gt;**](BusinessModelHistory.md) | Business model history for this account. |  [optional]
**city** | **String** | The city part of the postal address. |  [optional]
**company** | **String** | The name of the company used in billing. |  [optional]
**contact** | **String** | The name of the contact person for this account. |  [optional]
**contractNumber** | **String** | Contract number of the customer. |  [optional]
**country** | **String** | The country part of the postal address. |  [optional]
**createdAt** | [**DateTime**](DateTime.md) | Creation UTC time RFC3339. |  [optional]
**customFields** | **Map&lt;String, String&gt;** | Account&#39;s custom properties as key-value pairs. |  [optional]
**customerNumber** | **String** | Customer number of the customer. |  [optional]
**displayName** | **String** | The display name for the tenant account. |  [optional]
**email** | **String** | The company email address for this account. |  [optional]
**endMarket** | **String** | Account end market. | 
**etag** | **String** | API resource entity version. | 
**expiration** | [**DateTime**](DateTime.md) | Expiration time of the account, as UTC time RFC3339. |  [optional]
**expirationWarningThreshold** | **Integer** | Indicates how many days (1-180) before account expiration a notification email is sent. |  [optional]
**id** | **String** | Account ID. | 
**idleTimeout** | **Integer** | The reference token expiration time, in minutes, for this account. |  [optional]
**limitations** | [**List&lt;AccountLimitation&gt;**](AccountLimitation.md) | List of account limitation objects. |  [optional]
**limits** | **Map&lt;String, String&gt;** | DEPRECATED: Replaced by the limitations parameter. |  [optional]
**mfaStatus** | [**MfaStatusEnum**](#MfaStatusEnum) | The enforcement status of multi-factor authentication, either &#x60;enforced&#x60; or &#x60;optional&#x60;. |  [optional]
**notificationEmails** | **List&lt;String&gt;** | A list of notification email addresses. |  [optional]
**object** | [**ObjectEnum**](#ObjectEnum) | Entity name: always &#x60;account&#x60;. | 
**parentAccount** | [**ParentAccountInfo**](ParentAccountInfo.md) | Contact details of the parent account. |  [optional]
**parentId** | **String** | The ID of the parent account, if any. |  [optional]
**passwordPolicy** | [**PasswordPolicy**](PasswordPolicy.md) | The password policy for this account. |  [optional]
**passwordRecoveryExpiration** | **Integer** | Indicates for how many minutes a password recovery email is valid. |  [optional]
**phoneNumber** | **String** | The phone number of a company representative. |  [optional]
**policies** | [**List&lt;FeaturePolicy&gt;**](FeaturePolicy.md) | List of policies if requested. |  [optional]
**postalCode** | **String** | The postal code part of the postal address. |  [optional]
**reason** | **String** | A note with the reason for account status update. |  [optional]
**referenceNote** | **String** | A reference note for updating the status of the account. |  [optional]
**salesContact** | **String** | Email address of the sales contact. |  [optional]
**state** | **String** | The state part of the postal address. |  [optional]
**status** | [**StatusEnum**](#StatusEnum) | The status of the account. | 
**subAccounts** | [**List&lt;AccountInfo&gt;**](AccountInfo.md) | List of sub accounts. Not available for developer users. |  [optional]
**templateId** | **String** | Account template ID. |  [optional]
**tier** | **String** | The tier level of the account; &#x60;0&#x60;: free tier, &#x60;1&#x60;: commercial account, &#x60;2&#x60;: partner tier. Other values are reserved for the future. | 
**tierHistory** | [**List&lt;TierHistory&gt;**](TierHistory.md) | Tier history for this account. |  [optional]
**updatedAt** | [**DateTime**](DateTime.md) | Last update UTC time RFC3339. |  [optional]
**upgradedAt** | [**DateTime**](DateTime.md) | Time when upgraded to commercial account in UTC format RFC3339. |  [optional]


<a name="MfaStatusEnum"></a>
## Enum: MfaStatusEnum
Name | Value
---- | -----
ENFORCED | &quot;enforced&quot;
OPTIONAL | &quot;optional&quot;


<a name="ObjectEnum"></a>
## Enum: ObjectEnum
Name | Value
---- | -----
ACCOUNT | &quot;account&quot;


<a name="StatusEnum"></a>
## Enum: StatusEnum
Name | Value
---- | -----
ENROLLING | &quot;ENROLLING&quot;
ACTIVE | &quot;ACTIVE&quot;
RESTRICTED | &quot;RESTRICTED&quot;
SUSPENDED | &quot;SUSPENDED&quot;



