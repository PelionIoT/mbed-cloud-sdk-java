
# SerializationConfigData

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**cfg** | **Object** | Serialization configuration object according to configuration type. |  [optional]
**maxChunkSize** | **Integer** | Maximum number of messages in NotificationMessage container delivered in one request. Default is 10000. Using a very low value for high troughput applications may cause lag in notification delivery, as a new chunk is sent only after the previous one has been acknowledged. Using a high value is recommended and safe, as chunks are sent quickly after notifications are received from devices. See [notification sending logic](../integrate-web-app/event-notification.html#notification-sending-logic) for more details. |  [optional]
**type** | [**TypeEnum**](#TypeEnum) | Serialization type: v2 - specified in NotificationMessage. | 


<a name="TypeEnum"></a>
## Enum: TypeEnum
Name | Value
---- | -----
V2 | &quot;v2&quot;



