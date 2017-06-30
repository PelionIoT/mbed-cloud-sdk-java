
# UpdateCampaign

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**description** | **String** | An optional description of the campaign. | 
**rootManifestId** | **String** |  | 
**createdAt** | **String** | The time the object was created. | 
**object** | **String** | The API resource entity. | 
**when** | **String** | The timestamp at which update campaign scheduled to start. |  [optional]
**state** | [**StateEnum**](#StateEnum) | The state of the campaign. | 
**finished** | **String** | The timestamp when the update campaign finished. |  [optional]
**etag** | **String** | The entity instance signature. | 
**rootManifestUrl** | **String** |  | 
**startedAt** | [**DateTime**](DateTime.md) |  |  [optional]
**id** | **String** | The ID of the campaign. | 
**deviceFilter** | **String** | The filter for the devices the campaign will target. | 
**name** | **String** | A name for this campaign. | 


<a name="StateEnum"></a>
## Enum: StateEnum
Name | Value
---- | -----
DRAFT | &quot;draft&quot;
SCHEDULED | &quot;scheduled&quot;
DEVICEFETCH | &quot;devicefetch&quot;
DEVICECOPY | &quot;devicecopy&quot;
PUBLISHING | &quot;publishing&quot;
DEPLOYING | &quot;deploying&quot;
DEPLOYED | &quot;deployed&quot;
MANIFESTREMOVED | &quot;manifestremoved&quot;
EXPIRED | &quot;expired&quot;



