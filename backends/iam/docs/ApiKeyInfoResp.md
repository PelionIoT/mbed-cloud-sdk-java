
# ApiKeyInfoResp

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**createdAt** | [**DateTime**](DateTime.md) | Creation UTC time RFC3339. |  [optional]
**creationTime** | **Long** | The timestamp of the API key creation in the storage, in milliseconds. |  [optional]
**etag** | **String** | API resource entity version. | 
**groups** | **List&lt;String&gt;** | A list of group IDs this API key belongs to. |  [optional]
**id** | **String** | The UUID of the API key. | 
**key** | **String** | The API key. | 
**lastLoginTime** | **Long** | The timestamp of the latest API key usage, in milliseconds. |  [optional]
**name** | **String** | The display name for the API key. | 
**object** | [**ObjectEnum**](#ObjectEnum) | Entity name: always &#39;api-key&#39; | 
**owner** | **String** | The owner of this API key, who is the creator by default. |  [optional]
**status** | [**StatusEnum**](#StatusEnum) | The status of the API key. |  [optional]
**updatedAt** | [**DateTime**](DateTime.md) | Last update UTC time RFC3339. |  [optional]


<a name="ObjectEnum"></a>
## Enum: ObjectEnum
Name | Value
---- | -----
KEY | &quot;api-key&quot;


<a name="StatusEnum"></a>
## Enum: StatusEnum
Name | Value
---- | -----
ACTIVE | &quot;ACTIVE&quot;
INACTIVE | &quot;INACTIVE&quot;



