
# Log

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**accountId** | **String** | The ID of the account associated with the device. |  [optional]
**appName** | **String** | A tag indicating which application or software module produced the log message. |  [optional]
**createdAt** | [**DateTime**](DateTime.md) | RFC 3339 UTC timestamp indicating when the resource entity was created. |  [optional]
**deviceId** | **String** | Device ID. |  [optional]
**etag** | **String** | Entity instance signature, or Unix timestamp of last customer update. |  [optional]
**id** | **String** | mUUID Entity ID. Each device log has a unique ID. |  [optional]
**level** | [**LevelEnum**](#LevelEnum) | Log entry severity level. |  [optional]
**message** | **String** | Log message body. |  [optional]
**object** | **String** | Device log resource name. |  [optional]
**timestamp** | [**DateTime**](DateTime.md) | RFC 3339 UTC timestamp indicating indicating the device time the message was printed. |  [optional]
**type** | **String** | Device log type. |  [optional]


<a name="LevelEnum"></a>
## Enum: LevelEnum
Name | Value
---- | -----
DEBUG | &quot;DEBUG&quot;
TRACE | &quot;TRACE&quot;
INFO | &quot;INFO&quot;
WARNING | &quot;WARNING&quot;
ERROR | &quot;ERROR&quot;
CRITICAL | &quot;CRITICAL&quot;



