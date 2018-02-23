
# AccountInfo

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**endMarket** | **String** | Account end market. | 
**status** | [**StatusEnum**](#StatusEnum) | The status of the account. | 
**passwordPolicy** | [**PasswordPolicy**](PasswordPolicy.md) | The password policy for this account. |  [optional]
**salesContact** | **String** | Email address of the sales contact. |  [optional]
**updatedAt** | [**DateTime**](DateTime.md) | Last update UTC time RFC3339. |  [optional]
**postalCode** | **String** | The postal code part of the postal address. |  [optional]
**accountProperties** | [**Map&lt;String, Map&lt;String, String&gt;&gt;**](Map.md) | Account specific custom properties. |  [optional]
**customerNumber** | **String** | Customer number of the customer. |  [optional]
**id** | **String** | Account ID. | 
**aliases** | **List&lt;String&gt;** | An array of aliases. | 
**addressLine2** | **String** | Postal address line 2. |  [optional]
**city** | **String** | The city part of the postal address. |  [optional]
**addressLine1** | **String** | Postal address line 1. |  [optional]
**displayName** | **String** | The display name for the account. |  [optional]
**mfaStatus** | [**MfaStatusEnum**](#MfaStatusEnum) | The enforcement status of the multi-factor authentication, either &#39;enforced&#39; or &#39;optional&#39;. |  [optional]
**parentId** | **String** | The ID of the parent account, if it has any. |  [optional]
**state** | **String** | The state part of the postal address. |  [optional]
**etag** | **String** | API resource entity version. | 
**email** | **String** | The company email address for this account. |  [optional]
**phoneNumber** | **String** | The phone number of a representative of the company. |  [optional]
**referenceNote** | **String** | A reference note for updating the status of the account |  [optional]
**company** | **String** | The name of the company. |  [optional]
**object** | [**ObjectEnum**](#ObjectEnum) | Entity name: always &#39;account&#39; | 
**reason** | **String** | A reason note for updating the status of the account |  [optional]
**upgradedAt** | [**DateTime**](DateTime.md) | Time when upgraded to commercial account in UTC format RFC3339. |  [optional]
**tier** | **String** | The tier level of the account; &#39;0&#39;: free tier, &#39;1&#39;: commercial account, &#39;2&#39;: partner tier. Other values are reserved for the future. | 
**subAccounts** | [**List&lt;AccountInfo&gt;**](AccountInfo.md) | List of sub accounts. |  [optional]
**limits** | **Map&lt;String, String&gt;** | List of limits as key-value pairs if requested. |  [optional]
**country** | **String** | The country part of the postal address. |  [optional]
**createdAt** | [**DateTime**](DateTime.md) | Creation UTC time RFC3339. |  [optional]
**idleTimeout** | **String** | The reference token expiration time in minutes for this account. |  [optional]
**contractNumber** | **String** | Contract number of the customer. |  [optional]
**expirationWarningThreshold** | **String** | Indicates how many days (1-180) before account expiration a notification email should be sent. |  [optional]
**contact** | **String** | The name of the contact person for this account. |  [optional]
**policies** | [**List&lt;FeaturePolicy&gt;**](FeaturePolicy.md) | List of policies if requested. |  [optional]
**notificationEmails** | **List&lt;String&gt;** | A list of notification email addresses. |  [optional]
**templateId** | **String** | Account template ID. |  [optional]


<a name="StatusEnum"></a>
## Enum: StatusEnum
Name | Value
---- | -----
ENROLLING | &quot;ENROLLING&quot;
ACTIVE | &quot;ACTIVE&quot;
RESTRICTED | &quot;RESTRICTED&quot;
SUSPENDED | &quot;SUSPENDED&quot;


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



