
# CampaignDeviceMetadata

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**description** | **String** | Description |  [optional]
**campaign** | **String** | The ID of the campaign the device is in |  [optional]
**createdAt** | [**DateTime**](DateTime.md) | The time the campaign was created |  [optional]
**object** | **String** | Entity name: always &#39;update-campaign-device-metadata&#39; |  [optional]
**updatedAt** | [**DateTime**](DateTime.md) | This time this record was modified in the database format: date-time |  [optional]
**mechanism** | **String** | The mechanism used to deliver the firmware (connector or direct) |  [optional]
**name** | **String** | The name of the record |  [optional]
**etag** | **String** | API resource entity version |  [optional]
**mechanismUrl** | **String** | The URL of cloud connect used |  [optional]
**deploymentState** | [**DeploymentStateEnum**](#DeploymentStateEnum) | The state of the update campaign on the device |  [optional]
**id** | **String** | The ID of the metadata record |  [optional]
**deviceId** | **String** | The ID of the device |  [optional]


<a name="DeploymentStateEnum"></a>
## Enum: DeploymentStateEnum
Name | Value
---- | -----
PENDING | &quot;pending&quot;
UPDATED_CONNECTOR_CHANNEL | &quot;updated_connector_channel&quot;
FAILED_CONNECTOR_CHANNEL_UPDATE | &quot;failed_connector_channel_update&quot;
DEPLOYED | &quot;deployed&quot;
MANIFESTREMOVED | &quot;manifestremoved&quot;



