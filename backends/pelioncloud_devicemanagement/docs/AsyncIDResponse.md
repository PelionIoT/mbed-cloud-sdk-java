
# AsyncIDResponse

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**ct** | **String** | The content type. |  [optional]
**error** | **String** | An optional error message describing the error. Please refer to status listing above.  |  [optional]
**id** | **String** | The unique ID of the asynchronous response. |  [optional]
**maxAge** | **String** | Determines how long this value stays valid in the cache, in seconds. 0 means that the value is not stored in the cache. |  [optional]
**payload** | **String** | Requested data, base64 encoded. |  [optional]
**status** | **Integer** |  States whether sending a command to the device succeeded or failed.&lt;br/&gt; |Code|Description| |-|-| |**200**| Operation succeeded. The playload contains result of the operation from the device. | |**404**| Endpoint does not have requested resource. | |**412**| Precondition failed and operation was not executed. Device responded with 4.12 CoAP response code.| |**413**| Request entity is too large and could not be delivered to the device. | |**415**| Endpoint does not support media type. | |**429**| Expired request was removed from queue (REQUEST_EXPIRED), device requested deregistration (DEVICE_REMOVED_REGISTRATION), or device was suspended (DEVICE_BLOCKED). | |**502**| Request to the device failed and retry count exceeded. Last retry failed to establish TCP or TLS connection to endpoint. | |**503**| Request to the device failed and retry count exceeded. Last retry failed because endpoint is currently unavailable (NOT_CONNECTED). | |**504**| Request to the device failed and retry count exceeded. Last retry failed, as device did not respond in the time of protocol-specific retransmission logic (TIMEOUT). | &lt;br/&gt;  |  [optional]



