
# ApiKeyInfoReq

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**groups** | **List&lt;String&gt;** | A list of group IDs this API key belongs to. Adding an API key to the &#39;Administrators&#39; group is restricted to administrators. |  [optional]
**name** | **String** | The display name for the API key. | 
**owner** | **String** | The owner of this API key. Only an administrator can set the owner of an API key. |  [optional]
**status** | [**StatusEnum**](#StatusEnum) | The status of the API key. Only an administrator can set the status of an API key. |  [optional]


<a name="StatusEnum"></a>
## Enum: StatusEnum
Name | Value
---- | -----
ACTIVE | &quot;ACTIVE&quot;
INACTIVE | &quot;INACTIVE&quot;



