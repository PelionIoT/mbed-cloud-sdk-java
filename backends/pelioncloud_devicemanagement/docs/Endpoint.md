
# Endpoint

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**name** | **String** | Unique Device Management Device ID representing the endpoint. |  [optional]
**q** | **Boolean** | Determines whether the device is in queue mode.  **Queue mode**  When an endpoint is in queue mode, messages sent to the endpoint do not wake up the physical device. The messages are queued and delivered when the device wakes up and connects to Device Management Connect. You can also use the queue mode when the device is behind an NAT and cannot be reached directly by Device Management Connect. |  [optional]
**status** | **String** | Deprecated and the value is always ACTIVE. Only used for API backwards compatibility reasons. |  [optional]
**type** | **String** | Type of endpoint. (Free text) |  [optional]



