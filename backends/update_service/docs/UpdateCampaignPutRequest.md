
# UpdateCampaignPutRequest

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**description** | **String** | An optional description of the campaign | 
**rootManifestId** | **String** |  | 
**object** | **String** | The API resource entity | 
**when** | [**DateTime**](DateTime.md) | The scheduled start time for the update campaign | 
**state** | [**StateEnum**](#StateEnum) | The state of the campaign | 
**deviceFilter** | **String** | The filter for the devices the campaign will target | 
**name** | **String** | The campaign&#39;s name | 


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



