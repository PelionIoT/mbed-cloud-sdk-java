
# PolicyUpdateReq

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**status** | [**StatusEnum**](#StatusEnum) | The new status of this policy. |  [optional]
**validFrom** | [**DateTime**](DateTime.md) | Specifies the date and time when the policy will become valid in UTC time RFC3339. E.g. &#39;2018-02-05T09:43:44Z&#39; |  [optional]
**errorMessage** | **String** | Custom error message returned when this policy matches with not allowed result. |  [optional]
**description** | **String** | The new description of this policy, not longer than 500 character. |  [optional]
**validUntil** | [**DateTime**](DateTime.md) | Specifies the date and time until the policy is valid in UTC time RFC3339. E.g. &#39;2018-02-05T09:43:44Z&#39; |  [optional]
**grantExpiresIn** | **Integer** | Specifies the value in seconds for how long an authorization result is valid. |  [optional]
**notResources** | **List&lt;String&gt;** | New list of not_resources in urn:mbed-cloud:{resource-type}:{resource-name} format, not more than 100. Previous list will be overwritten. |  [optional]
**actions** | **Map&lt;String, Boolean&gt;** | New list of actions as key-pairs of &#39;{action}&#39;: &#39;true&#39; or &#39;false&#39;, not more than 100. For enabling all actions use { &#39;*&#39;: true }. Previous list will be overwritten. |  [optional]
**notConditions** | **List&lt;String&gt;** | New list of not_conditions in urn:mbed-cloud:{resource-type}:{resource-name} format, not more than 100. Previous list will be overwritten. |  [optional]
**tag** | **String** | New policy tag that can be used for various purposes to be able to distinguish between policies. Not longer than 100 characters. |  [optional]
**users** | **List&lt;String&gt;** | New list of user IDs this policy is attached to, not more than 100. Previous list will be overwritten. |  [optional]
**groups** | **List&lt;String&gt;** | New list of group IDs this policy is attached to, not more than 100. Previous list will be overwritten. |  [optional]
**notActions** | **List&lt;String&gt;** | New list of not_actions, not more than 100. Previous list will be overwritten. |  [optional]
**apikeys** | **List&lt;String&gt;** | New list of API key IDs this policy is attached to, not more than 100. Previous list will be overwritten. |  [optional]
**conditions** | **List&lt;String&gt;** | New list of conditions in urn:mbed-cloud:{resource-type}:{resource-name} format, not more than 100. Previous list will be overwritten. |  [optional]
**resources** | **List&lt;String&gt;** | New list of resources in urn:mbed-cloud:{resource-type}:{resource-name} format, not more than 100. Previous list will be overwritten. |  [optional]
**name** | **String** | The new name of this policy, must be unique and not longer than 100 character. |  [optional]


<a name="StatusEnum"></a>
## Enum: StatusEnum
Name | Value
---- | -----
ACTIVE | &quot;ACTIVE&quot;
INACTIVE | &quot;INACTIVE&quot;



