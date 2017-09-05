
# UpdateCampaign

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**description** | **String** | The optional description of the campaign |  [optional]
**rootManifestId** | **String** |  |  [optional]
**createdAt** | [**DateTime**](DateTime.md) | The time the update campaign was created |  [optional]
**object** | **String** | The API resource entity |  [optional]
**when** | [**DateTime**](DateTime.md) | The scheduled start time for the update campaign |  [optional]
**state** | [**StateEnum**](#StateEnum) | The state of the campaign |  [optional]
**finished** | [**DateTime**](DateTime.md) | The campaign finish timestamp |  [optional]
**etag** | **String** | The entity instance signature |  [optional]
**rootManifestUrl** | **String** |  |  [optional]
**startedAt** | [**DateTime**](DateTime.md) |  |  [optional]
**id** | **String** | The campaign ID |  [optional]
**deviceFilter** | **String** | The filter for the devices the campaign will target |  [optional]
**name** | **String** | The campaign name |  [optional]


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



