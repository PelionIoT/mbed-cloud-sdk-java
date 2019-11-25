
# UpdateCampaign

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**activeAt** | [**DateTime**](DateTime.md) | The time the campaign entered the active state. |  [optional]
**approvalRequired** | **Boolean** | Flag indicating whether approval is needed to start the campaign. |  [optional]
**archivedAt** | [**DateTime**](DateTime.md) | The time the campaign was archived. |  [optional]
**autostop** | **Boolean** | Flag indicating whether the campaign should be auto-stopped on reaching a threshold. |  [optional]
**autostopReason** | **String** | Text description of why a campaign failed to start or why a campaign stopped. |  [optional]
**autostopSuccessPercent** | **Double** | Percent of successful device updates to auto stop the campaign. |  [optional]
**campaignStrategy** | [**CampaignStrategyEnum**](#CampaignStrategyEnum) | How the campaign adds devices. A &#x60;one-shot&#x60; campaign does not add new devices after it has started. A &#x60;continuous&#x60; campaign means that devices may be added to the campaign after it has started. The default is &#x60;one-shot&#x60;. |  [optional]
**createdAt** | [**DateTime**](DateTime.md) | The time the entity was created. |  [optional]
**description** | **String** | An optional description of the campaign. |  [optional]
**deviceFilter** | **String** | The filter for the devices the campaign is targeting at. |  [optional]
**etag** | **String** | API resource entity version. |  [optional]
**finished** | [**DateTime**](DateTime.md) | The time the campaign finished. |  [optional]
**id** | **String** | The campaign ID. |  [optional]
**name** | **String** | The campaign name. |  [optional]
**object** | **String** | Entity name: always &#39;update-campaign&#39;. |  [optional]
**phase** | [**PhaseEnum**](#PhaseEnum) | The phase of the campaign. |  [optional]
**rootManifestId** | **String** | The ID of the manifest that will be sent to the device as part of the campaign. |  [optional]
**rootManifestUrl** | **String** | The URL for the manifest that will be sent to the device as part of the campaign. |  [optional]
**startedAt** | [**DateTime**](DateTime.md) | The time the campaign was started. |  [optional]
**startingAt** | [**DateTime**](DateTime.md) | The time the campaign will be started. |  [optional]
**state** | [**StateEnum**](#StateEnum) | The state of the campaign. |  [optional]
**stoppedAt** | [**DateTime**](DateTime.md) | The time the campaign was stopped. |  [optional]
**stoppingAt** | [**DateTime**](DateTime.md) | The time the campaign will be stopped. |  [optional]
**updatedAt** | [**DateTime**](DateTime.md) | The time the entity was updated. |  [optional]
**when** | [**DateTime**](DateTime.md) | The scheduled start time for the campaign. The campaign will start within 1 minute when then start time has elapsed. |  [optional]


<a name="CampaignStrategyEnum"></a>
## Enum: CampaignStrategyEnum
Name | Value
---- | -----
ONE_SHOT | &quot;one-shot&quot;
CONTINUOUS | &quot;continuous&quot;


<a name="PhaseEnum"></a>
## Enum: PhaseEnum
Name | Value
---- | -----
DRAFT | &quot;draft&quot;
AWAITING_APPROVAL | &quot;awaiting_approval&quot;
TIMED | &quot;timed&quot;
STARTING | &quot;starting&quot;
ACTIVE | &quot;active&quot;
STOPPING | &quot;stopping&quot;
STOPPED | &quot;stopped&quot;
DELETED | &quot;deleted&quot;
ARCHIVED | &quot;archived&quot;


<a name="StateEnum"></a>
## Enum: StateEnum
Name | Value
---- | -----
DRAFT | &quot;draft&quot;
SCHEDULED | &quot;scheduled&quot;
ALLOCATINGQUOTA | &quot;allocatingquota&quot;
ALLOCATEDQUOTA | &quot;allocatedquota&quot;
QUOTAALLOCATIONFAILED | &quot;quotaallocationfailed&quot;
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



