
# UpdateCampaignPostRequest

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**description** | **String** | An optional description of the campaign. |  [optional]
**rootManifestId** | **String** |  |  [optional]
**object** | **String** | The API resource entity. |  [optional]
**when** | **String** | The timestamp at which update campaign scheduled to start. |  [optional]
**state** | [**StateEnum**](#StateEnum) | The state of the campaign. |  [optional]
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



