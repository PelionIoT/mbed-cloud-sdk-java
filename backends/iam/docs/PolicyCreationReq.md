
# PolicyCreationReq

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**status** | [**StatusEnum**](#StatusEnum) | The status of this policy. |  [optional]
**validUntil** | [**DateTime**](DateTime.md) | Specifies the date and time until the policy is valid in UTC time RFC3339. E.g. &#39;2018-02-05T09:43:44Z&#39; |  [optional]
**grantExpiresIn** | **Integer** | Specifies the value in seconds for how long an authorization result is valid. |  [optional]
**name** | **String** | The name of this policy, must be unique and not longer than 100 character. | 
**errorMessage** | **String** | Custom error message returned when this policy matches with not allowed result. |  [optional]
**notResources** | **List&lt;String&gt;** | List of not_resources in urn:mbed-cloud:{resource-type}:{resource-name} format, not more than 100. |  [optional]
**actions** | **Map&lt;String, Boolean&gt;** | List of actions as key-pairs of &#39;{action}&#39;: &#39;true&#39; or &#39;false&#39;, not more than 100. For enabling all actions use { &#39;*&#39;: true }. |  [optional]
**notConditions** | **List&lt;String&gt;** | List of not_conditions in urn:mbed-cloud:{resource-type}:{resource-name} format, not more than 100. |  [optional]
**validFrom** | [**DateTime**](DateTime.md) | Specifies the date and time when the policy will become valid in UTC time RFC3339. E.g. &#39;2018-02-05T09:43:44Z&#39; |  [optional]
**users** | **List&lt;String&gt;** | List of user IDs this policy is attached to, not more than 100. |  [optional]
**groups** | **List&lt;String&gt;** | List of group IDs this policy is attached to, not more than 100. |  [optional]
**tag** | **String** | Policy tag that can be used for various purposes to be able to distinguish between policies. Not longer than 100 characters. |  [optional]
**notActions** | **List&lt;String&gt;** | List of not_actions, not more than 100. |  [optional]
**apikeys** | **List&lt;String&gt;** | List of API key IDs this policy is attached to, not more than 100. |  [optional]
**conditions** | **List&lt;String&gt;** | List of conditions in urn:mbed-cloud:{resource-type}:{resource-name} format, not more than 100. |  [optional]
**resources** | **List&lt;String&gt;** | List of resources in urn:mbed-cloud:{resource-type}:{resource-name} format, not more than 100. |  [optional]
**description** | **String** | The description of this policy, not longer than 500 character. |  [optional]


<a name="StatusEnum"></a>
## Enum: StatusEnum
Name | Value
---- | -----
ACTIVE | &quot;ACTIVE&quot;
INACTIVE | &quot;INACTIVE&quot;



