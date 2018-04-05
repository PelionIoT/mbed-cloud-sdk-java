
# CampaignDeviceMetadata

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**campaign** | **String** | The device&#39;s campaign ID |  [optional]
**createdAt** | [**DateTime**](DateTime.md) | The time the campaign was created |  [optional]
**deploymentState** | [**DeploymentStateEnum**](#DeploymentStateEnum) | The state of the update campaign on the device |  [optional]
**description** | **String** | Description |  [optional]
**deviceId** | **String** | The device ID |  [optional]
**etag** | **String** | API resource entity version |  [optional]
**id** | **String** | The metadata record ID |  [optional]
**mechanism** | **String** | How the firmware is delivered (connector or direct) |  [optional]
**mechanismUrl** | **String** | The Cloud Connect URL |  [optional]
**name** | **String** | The record name |  [optional]
**object** | **String** | Entity name: always &#39;update-campaign-device-metadata&#39; |  [optional]
**updatedAt** | [**DateTime**](DateTime.md) | This time this record was modified in the database format: date-time |  [optional]


<a name="DeploymentStateEnum"></a>
## Enum: DeploymentStateEnum
Name | Value
---- | -----
PENDING | &quot;pending&quot;
UPDATED_CONNECTOR_CHANNEL | &quot;updated_connector_channel&quot;
FAILED_CONNECTOR_CHANNEL_UPDATE | &quot;failed_connector_channel_update&quot;
DEPLOYED | &quot;deployed&quot;
MANIFESTREMOVED | &quot;manifestremoved&quot;
DEREGISTERED | &quot;deregistered&quot;



