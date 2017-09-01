
# AccountUpdateRootReq

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**endMarket** | **String** | The end market for this account, not longer than 100 characters. |  [optional]
**phoneNumber** | **String** | The phone number of the company, not longer than 100 characters. |  [optional]
**passwordPolicy** | [**PasswordPolicy**](PasswordPolicy.md) | Password policy for this account. |  [optional]
**postalCode** | **String** | The postal code part of the postal address, not longer than 100 characters. |  [optional]
**parentID** | **String** | The ID of the parent account, if it has any. |  [optional]
**aliases** | **List&lt;String&gt;** | An array of aliases, not more than 10. An alias is not shorter than 8 and not longer than 100 characters. |  [optional]
**addressLine2** | **String** | Postal address line 2, not longer than 100 characters. |  [optional]
**city** | **String** | The city part of the postal address, not longer than 100 characters. Required for commercial accounts only. |  [optional]
**addressLine1** | **String** | Postal address line 1, not longer than 100 characters. Required for commercial accounts only. |  [optional]
**displayName** | **String** | The display name for the account, not longer than 100 characters. |  [optional]
**state** | **String** | The state part of the postal address, not longer than 100 characters. |  [optional]
**isProvisioningAllowed** | **Boolean** | Flag (true/false) indicating whether Factory Tool is allowed to download or not. Manageable by the root admin only. |  [optional]
**email** | **String** | The company email address for this account, not longer than 100 characters. Required for commercial accounts only. |  [optional]
**status** | **String** | The status of the account. Manageable by the root admin only. |  [optional]
**company** | **String** | The name of the company, not longer than 100 characters. Required for commercial accounts only. |  [optional]
**reason** | **String** | A reason note for changing account status. Manageable by the root admin only. |  [optional]
**tier** | **String** | The tier level of the account; &#39;0&#39;: free tier, &#39;1&#39;: commercial account, &#39;2&#39;: partner account, &#39;98&#39;: internal/demo account, &#39;99&#39;: root admin team. Other values are reserved for the future. Manageable by the root admin only. |  [optional]
**limits** | **Map&lt;String, String&gt;** | List of service limits. Manageable by the root admin only. |  [optional]
**country** | **String** | The country part of the postal address, not longer than 100 characters. Required for commercial accounts only. |  [optional]
**idleTimeout** | **String** | The reference token expiration time in minutes for this account. Between 1 and 120 minutes. |  [optional]
**contact** | **String** | The name of the contact person for this account, not longer than 100 characters. Required for commercial accounts only. |  [optional]
**policies** | [**List&lt;FeaturePolicy&gt;**](FeaturePolicy.md) | List of policies. Manageable by the root admin only. |  [optional]
**templateId** | **String** | Account template ID. Manageable by the root admin only. |  [optional]



