
# UpdateCampaignPostRequest

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**approvalRequired** | **Boolean** |  |  [optional]
**autostop** | **Boolean** |  |  [optional]
**autostopSuccessPercent** | [**BigDecimal**](BigDecimal.md) |  |  [optional]
**campaignStrategy** | [**CampaignStrategyEnum**](#CampaignStrategyEnum) | How the campaign adds devices. A &#x60;one-shot&#x60; campaign does not add new devices after it has started. A &#x60;continuous&#x60; campaign means that devices may be added to the campaign after it has started. The default is &#x60;one-shot&#x60;. |  [optional]
**description** | **String** | An optional description of the campaign. |  [optional]
**deviceFilter** | **String** | The filter for the devices the campaign targets. Refer to this using the filter ID. | 
**name** | **String** | The name for this campaign. |  [optional]
**rootManifestId** | **String** |  |  [optional]
**state** | [**StateEnum**](#StateEnum) | DEPRECATED: The state of the campaign (use phase instead) |  [optional]
**when** | [**DateTime**](DateTime.md) | The scheduled start time for the update campaign. Not in use. |  [optional]


<a name="CampaignStrategyEnum"></a>
## Enum: CampaignStrategyEnum
Name | Value
---- | -----
ONE_SHOT | &quot;one-shot&quot;
CONTINUOUS | &quot;continuous&quot;


<a name="StateEnum"></a>
## Enum: StateEnum
Name | Value
---- | -----
DRAFT | &quot;draft&quot;
SCHEDULED | &quot;scheduled&quot;



