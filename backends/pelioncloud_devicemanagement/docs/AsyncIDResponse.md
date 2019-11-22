
# AsyncIDResponse

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**ct** | **String** | The content type. |  [optional]
**error** | **String** | An optional error message describing the error. Please refer to status listing above.  |  [optional]
**id** | **String** | The unique ID of the asynchronous response. |  [optional]
**maxAge** | **String** | Determines how long this value stays valid in the cache, in seconds. 0 means that the value is not stored in the cache. |  [optional]
**payload** | **String** | Requested data, base64 encoded. |  [optional]
**status** | **Integer** |  States whether sending a command to the device succeeded or failed.  &lt;table&gt;   &lt;thead&gt;     &lt;tr&gt;       &lt;th&gt;Code&lt;/th&gt;       &lt;th&gt;Description&lt;/th&gt;     &lt;/tr&gt;   &lt;/thead&gt;   &lt;tbody&gt;     &lt;tr&gt;       &lt;td&gt;&lt;b&gt;200&lt;/b&gt;&lt;/td&gt;       &lt;td&gt;Operation succeeded. The playload contains result of the operation from the device.&lt;/td&gt;     &lt;/tr&gt;     &lt;tr&gt;       &lt;td&gt;&lt;b&gt;404&lt;/b&gt;&lt;/td&gt;       &lt;td&gt;Endpoint does not have requested resource.&lt;/td&gt;     &lt;/tr&gt;     &lt;tr&gt;       &lt;td&gt;&lt;b&gt;412&lt;/b&gt;&lt;/td&gt;       &lt;td&gt;Precondition failed and operation was not executed. Device responded with 4.12 CoAP response code.&lt;/td&gt;     &lt;/tr&gt;     &lt;tr&gt;       &lt;td&gt;&lt;b&gt;413&lt;/b&gt;&lt;/td&gt;       &lt;td&gt;Request entity is too large and could not be delivered to the device.&lt;/td&gt;     &lt;/tr&gt;     &lt;tr&gt;       &lt;td&gt;&lt;b&gt;415&lt;/b&gt;&lt;/td&gt;       &lt;td&gt;Endpoint does not support media type.&lt;/td&gt;     &lt;/tr&gt;     &lt;tr&gt;       &lt;td&gt;&lt;b&gt;429&lt;/b&gt;&lt;/td&gt;       &lt;td&gt;Expired request was removed from queue (REQUEST_EXPIRED), device requested deregistration (DEVICE_REMOVED_REGISTRATION), or device was suspended (DEVICE_BLOCKED).&lt;/td&gt;     &lt;/tr&gt;     &lt;tr&gt;       &lt;td&gt;&lt;b&gt;502&lt;/b&gt;&lt;/td&gt;       &lt;td&gt;Request to the device failed and retry count exceeded. Last retry failed to establish TCP or TLS connection to endpoint.&lt;/td&gt;     &lt;/tr&gt;     &lt;tr&gt;       &lt;td&gt;&lt;b&gt;503&lt;/b&gt;&lt;/td&gt;       &lt;td&gt;Request to the device failed and retry count exceeded. Last retry failed because endpoint is currently unavailable (NOT_CONNECTED).&lt;/td&gt;     &lt;/tr&gt;     &lt;tr&gt;       &lt;td&gt;&lt;b&gt;504&lt;/b&gt;&lt;/td&gt;       &lt;td&gt;Request to the device failed and retry count exceeded. Last retry failed, as device did not respond in the time of protocol-specific retransmission logic (TIMEOUT).&lt;/td&gt;     &lt;/tr&gt;   &lt;/tbody&gt; &lt;/table&gt;  |  [optional]



