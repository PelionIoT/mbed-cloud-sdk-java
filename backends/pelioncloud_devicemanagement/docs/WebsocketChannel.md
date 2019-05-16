
# WebsocketChannel

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**queueSize** | **Integer** | Number of events in the channel&#39;s event queue waiting to be delivered. |  [optional]
**status** | [**StatusEnum**](#StatusEnum) | Channel status is &#39;connected&#39; when the channel has an active WebSocket bound to it. The state is &#39;disconnected&#39; when either the channel or the WebSocket bound to it is closed. |  [optional]


<a name="StatusEnum"></a>
## Enum: StatusEnum
Name | Value
---- | -----
CONNECTED | &quot;connected&quot;
DISCONNECTED | &quot;disconnected&quot;



