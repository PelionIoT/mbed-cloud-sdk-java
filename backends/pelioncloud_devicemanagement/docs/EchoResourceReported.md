
# EchoResourceReported

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**contentType** | **String** | Content type of the reported resource value. |  [optional]
**expiresAt** | [**DateTime**](DateTime.md) | The time after which the reported value is not valid, calculated based on the max-age of the resource value the device reported. |  [optional]
**reportedAt** | [**DateTime**](DateTime.md) | The time the last value was reported. |  [optional]
**value** | **byte[]** | The reported value in base64 encoded format. |  [optional]



