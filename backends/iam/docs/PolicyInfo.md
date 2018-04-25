
# PolicyInfo

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**accountId** | **String** | The UUID of the account. | 
**actions** | **Map&lt;String, Boolean&gt;** | List of actions. | 
**apikeys** | **List&lt;String&gt;** | List of API key IDs this policy is attached to. |  [optional]
**conditions** | **List&lt;String&gt;** | List of conditions. | 
**createdAt** | [**DateTime**](DateTime.md) | Creation UTC time RFC3339. |  [optional]
**description** | **String** | The description of this policy. |  [optional]
**errorMessage** | **String** | Custom error message returned when this policy matches with not allowed result. |  [optional]
**etag** | **String** | API resource entity version. | 
**grantExpiresIn** | **Integer** | Specifies the value in seconds for how long an authorization result is valid. |  [optional]
**groups** | **List&lt;String&gt;** | List of group IDs this policy is attached to. |  [optional]
**id** | **String** | Entity ID. | 
**name** | **String** | The name of this policy. | 
**notActions** | **List&lt;String&gt;** | List of not_actions. | 
**notConditions** | **List&lt;String&gt;** | List of not_conditions. | 
**notResources** | **List&lt;String&gt;** | List of not_resources. | 
**object** | [**ObjectEnum**](#ObjectEnum) | Entity name: always &#39;policy&#39; | 
**resources** | **List&lt;String&gt;** | List of resources. | 
**status** | [**StatusEnum**](#StatusEnum) | The status of this policy. | 
**tag** | **String** | Policy tag that can be used for various purposes to be able to distinguish between policies. |  [optional]
**updatedAt** | [**DateTime**](DateTime.md) | Last update UTC time RFC3339. | 
**users** | **List&lt;String&gt;** | List of user IDs this policy is attached to. |  [optional]
**validFrom** | [**DateTime**](DateTime.md) | Specifies the date and time when the policy will become valid. |  [optional]
**validUntil** | [**DateTime**](DateTime.md) | Specifies the date and time until the policy is valid. |  [optional]


<a name="ObjectEnum"></a>
## Enum: ObjectEnum
Name | Value
---- | -----
POLICY | &quot;policy&quot;


<a name="StatusEnum"></a>
## Enum: StatusEnum
Name | Value
---- | -----
ACTIVE | &quot;ACTIVE&quot;
INACTIVE | &quot;INACTIVE&quot;



