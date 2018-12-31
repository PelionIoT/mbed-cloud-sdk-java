
# ApiKeyUpdateReq

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**groups** | **List&lt;String&gt;** | A list of group IDs this API key belongs to. |  [optional]
**name** | **String** | The display name for the API key, not longer than 100 characters. | 
**owner** | **String** | The owner of this API key. |  [optional]
**status** | [**StatusEnum**](#StatusEnum) | The status of the API key. |  [optional]


<a name="StatusEnum"></a>
## Enum: StatusEnum
Name | Value
---- | -----
ACTIVE | &quot;ACTIVE&quot;
INACTIVE | &quot;INACTIVE&quot;



