
# UpdateCampaign

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**description** | **String** | The optional description of the campaign |  [optional]
**rootManifestId** | **String** |  |  [optional]
**createdAt** | [**DateTime**](DateTime.md) | The time the update campaign was created |  [optional]
**object** | **String** | The API resource entity |  [optional]
**when** | [**DateTime**](DateTime.md) | The scheduled start time for the update campaign |  [optional]
**updatedAt** | [**DateTime**](DateTime.md) | The time the object was updated |  [optional]
**state** | [**StateEnum**](#StateEnum) | The state of the campaign |  [optional]
**etag** | **String** | The entity instance signature |  [optional]
**finished** | [**DateTime**](DateTime.md) | The campaign finish timestamp |  [optional]
**rootManifestUrl** | **String** |  |  [optional]
**phase** | [**PhaseEnum**](#PhaseEnum) | The phase of the campaign |  [optional]
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
ALLOCATINGQUOTA | &quot;allocatingquota&quot;
ALLOCATEDQUOTA | &quot;allocatedquota&quot;
INSUFFICIENTQUOTA | &quot;insufficientquota&quot;
CHECKINGMANIFEST | &quot;checkingmanifest&quot;
CHECKEDMANIFEST | &quot;checkedmanifest&quot;
DEVICEFETCH | &quot;devicefetch&quot;
DEVICECOPY | &quot;devicecopy&quot;
DEVICECHECK | &quot;devicecheck&quot;
PUBLISHING | &quot;publishing&quot;
DEPLOYING | &quot;deploying&quot;
DEPLOYED | &quot;deployed&quot;
MANIFESTREMOVED | &quot;manifestremoved&quot;
EXPIRED | &quot;expired&quot;
STOPPING | &quot;stopping&quot;
AUTOSTOPPED | &quot;autostopped&quot;
USERSTOPPED | &quot;userstopped&quot;
CONFLICT | &quot;conflict&quot;


<a name="PhaseEnum"></a>
## Enum: PhaseEnum
Name | Value
---- | -----
DRAFT | &quot;draft&quot;
SETUP | &quot;setup&quot;
AWAITING_APPROVAL | &quot;awaiting_approval&quot;
TIMED | &quot;timed&quot;
STARTING | &quot;starting&quot;
ACTIVE | &quot;active&quot;
STOPPING | &quot;stopping&quot;
STOPPED | &quot;stopped&quot;
ARCHIVED | &quot;archived&quot;



