
# ApiKeyUpdateReq

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**groups** | **List&lt;String&gt;** | A list of group IDs this API key belongs to. Only an administrator can update the group membership of an API key. |  [optional]
**name** | **String** | The display name for the API key. |  [optional]
**owner** | **String** | The owner of this API key. Only an administrator can update the owner of an API key. |  [optional]
**status** | [**StatusEnum**](#StatusEnum) | The status of the API key. Only the owner of the API key or an administrator can update the status of an API key. |  [optional]


<a name="StatusEnum"></a>
## Enum: StatusEnum
Name | Value
---- | -----
ACTIVE | &quot;ACTIVE&quot;
INACTIVE | &quot;INACTIVE&quot;



