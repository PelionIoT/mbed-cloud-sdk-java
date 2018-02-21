
# PolicyInfo

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**validUntil** | [**DateTime**](DateTime.md) | Specifies the date and time until the policy is valid. |  [optional]
**errorMessage** | **String** | Custom error message returned when this policy matches with not allowed result. |  [optional]
**updatedAt** | [**DateTime**](DateTime.md) | Last update UTC time RFC3339. | 
**actions** | **Map&lt;String, Boolean&gt;** | List of actions. | 
**tag** | **String** | Policy tag that can be used for various purposes to be able to distinguish between policies. |  [optional]
**apikeys** | **List&lt;String&gt;** | List of API key IDs this policy is attached to. |  [optional]
**id** | **String** | Entity ID. | 
**accountId** | **String** | The UUID of the account. | 
**validFrom** | [**DateTime**](DateTime.md) | Specifies the date and time when the policy will become valid. |  [optional]
**description** | **String** | The description of this policy. |  [optional]
**etag** | **String** | API resource entity version. | 
**conditions** | **List&lt;String&gt;** | List of conditions. | 
**resources** | **List&lt;String&gt;** | List of resources. | 
**status** | [**StatusEnum**](#StatusEnum) | The status of this policy. | 
**users** | **List&lt;String&gt;** | List of user IDs this policy is attached to. |  [optional]
**object** | [**ObjectEnum**](#ObjectEnum) | Entity name: always &#39;policy&#39; | 
**groups** | **List&lt;String&gt;** | List of group IDs this policy is attached to. |  [optional]
**notActions** | **List&lt;String&gt;** | List of not_actions. | 
**notResources** | **List&lt;String&gt;** | List of not_resources. | 
**name** | **String** | The name of this policy. | 
**createdAt** | [**DateTime**](DateTime.md) | Creation UTC time RFC3339. |  [optional]
**grantExpiresIn** | **Integer** | Specifies the value in seconds for how long an authorization result is valid. |  [optional]
**notConditions** | **List&lt;String&gt;** | List of not_conditions. | 


<a name="StatusEnum"></a>
## Enum: StatusEnum
Name | Value
---- | -----
ACTIVE | &quot;ACTIVE&quot;
INACTIVE | &quot;INACTIVE&quot;


<a name="ObjectEnum"></a>
## Enum: ObjectEnum
Name | Value
---- | -----
POLICY | &quot;policy&quot;



