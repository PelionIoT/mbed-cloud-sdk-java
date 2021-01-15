
# AccessKey

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**accountId** | **String** | The ID of the account. |  [optional]
**applicationId** | **String** | The ID of the application. |  [optional]
**createdAt** | [**DateTime**](DateTime.md) | Creation UTC time RFC3339. |  [optional]
**description** | **String** | The description of the access key. |  [optional]
**etag** | **String** | API resource entity version. |  [optional]
**expiration** | [**DateTime**](DateTime.md) | Expiration time of the access key, as UTC time RFC3339. Expiration makes the access key inoperative and the status will be EXPIRED. The client using the expired access key is no longer able to use the REST API. The access key expiration does not invalidate existing configurations meaning that subscribed events will continue to flow on existing channels. |  [optional]
**id** | **String** | The ID of the access key. |  [optional]
**key** | **String** | The access key. The full key including the secret part is visible in the response for create only |  [optional]
**lastUsedAt** | [**DateTime**](DateTime.md) | The time of the latest access key usage. |  [optional]
**name** | **String** | The display name for the access key. | 
**object** | [**ObjectEnum**](#ObjectEnum) | Entity name: always &#39;access-key&#39; |  [optional]
**status** | [**StatusEnum**](#StatusEnum) | The status of the access key. ACTIVE means that the access key is operational. INACTIVE means that the access key is not operational and it prevents the clients to use the REST API. Inactivating the access key does not invalidate existing configurations meaning that subscribed events will continue to flow on existing channels. The EXPIRED status is not allowed to be set directly, it is derived from the expiration attribute. |  [optional]
**updatedAt** | [**DateTime**](DateTime.md) | Last update UTC time RFC3339. |  [optional]


<a name="ObjectEnum"></a>
## Enum: ObjectEnum
Name | Value
---- | -----
KEY | &quot;access-key&quot;


<a name="StatusEnum"></a>
## Enum: StatusEnum
Name | Value
---- | -----
ACTIVE | &quot;ACTIVE&quot;
INACTIVE | &quot;INACTIVE&quot;
EXPIRED | &quot;EXPIRED&quot;



