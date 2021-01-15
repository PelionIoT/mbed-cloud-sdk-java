
# EchoResource

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**desired** | [**EchoResourceDesired**](EchoResourceDesired.md) |  |  [optional]
**reported** | [**EchoResourceReported**](EchoResourceReported.md) |  |  [optional]
**resourcePath** | **String** | The path of the resource. |  [optional]
**subscribed** | **Boolean** | System-level subscription status of the resource. If any of the applications has placed a subscription, the status is true. Overlapping subscriptions from multiple applications do not increase the load on the device as the server handles the multiplexing. |  [optional]



