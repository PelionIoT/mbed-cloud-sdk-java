
# UpdateCampaignPostRequest

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**approvalRequired** | **Boolean** |  |  [optional]
**autostop** | **Boolean** |  |  [optional]
**autostopSuccessPercent** | [**BigDecimal**](BigDecimal.md) |  |  [optional]
**campaignStrategy** | [**CampaignStrategyEnum**](#CampaignStrategyEnum) | How the campaign adds devices. A &#x60;one-shot&#x60; campaign does not add new devices after it has started. A &#x60;continuous&#x60; campaign means that devices may be added to the campaign after it has started. The default is &#x60;one-shot&#x60;. |  [optional]
**description** | **String** | An optional description of the campaign. |  [optional]
**deviceFilter** | **String** | The filter for the devices the campaign is targeted at. | 
**name** | **String** | The name for this campaign. |  [optional]
**rootManifestId** | **String** |  |  [optional]


<a name="CampaignStrategyEnum"></a>
## Enum: CampaignStrategyEnum
Name | Value
---- | -----
ONE_SHOT | &quot;one-shot&quot;
CONTINUOUS | &quot;continuous&quot;



