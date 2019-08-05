# DeviceRequestsApi

All URIs are relative to *https://api.us-east-1.mbedcloud.com*

Method | HTTP request | Description
------------- | ------------- | -------------
[**createAsyncRequest**](DeviceRequestsApi.md#createAsyncRequest) | **POST** v2/device-requests/{device-id} | Send an async request to device


<a name="createAsyncRequest"></a>
# **createAsyncRequest**
> Void createAsyncRequest(deviceId, asyncId, body, retry, expirySeconds)

Send an async request to device

This API provides an interface to asynchronously call methods on a device.  The &#x60;async-id&#x60; is provided by the client, enabling the client to track the end-to-end flow with an identifier that is relevant to the end application. For example, a web application&#39;s session ID along with the device ID and the resource path could be used as the &#x60;async-id&#x60;. This also avoids any race conditions with [the notification channel](/docs/current/integrate-web-app/event-notification.html). All responses are sent through the currently configured notification channel as an **AsyncIDResponse**.  For &#x60;GET&#x60; methods, values may be fetched from an internal cache, instead of contacting the device.  The server queues requests if it cannot reach the device at the time of the request. The queue is limited to 20 requests. The queueing behaviour is affected by the &#x60;retry&#x60; and the &#x60;expiry-seconds&#x60; parameters. If the device is not reached, or the device fails to respond when the request is made, the server queues the request and retries within the given expiry period the next time the device contacts the server. The requests from the queue are delivered in the order of insertion, one at a time, and not concurrently.  One delivery attempt consist from protocol specific retrasmission logic, where is multiple trasmissions. In case of CoAP, the retrasmissions exponential backoff 2, 4, 8, 16 to 64 seconds, taking total over 2 minutes. If the device does not respond within this two-minute period, delivery fails, and the request is put back in the queue so long as the retry count is less than its maximum.  For a queue-mode device, the request delivery is not attempted immediately, but only when the device next time contacts the server.  If retries are exhausted or the expiry time has passed, then the server discards the request and sends an error in **AsyncIDResponse**. The retries could be exhausted, for example, if the device periodically contacts the server and receives the request from the queue, but then fails to respond back to the server.  On the other hand, the device might lose its network connectivity, and the requests in the queue might expire and get discarded before the device regains the connectivity.  See also /v2/endpoints/{device-id}/{resourcePath}.  You can write [Notification Rules](../connecting/resource-change-webapp.html#notification-rules) for a resource with PUT command. Please see example of the payload below. &#x60;&#x60;&#x60; { \&quot;method\&quot;: \&quot;PUT\&quot;, \&quot;uri\&quot;: \&quot;/5/0/1?lt&#x3D;10&amp;gt&#x3D;60&amp;pmax&#x3D;120\&quot; } &#x60;&#x60;&#x60;  &#x60;&#x60;&#x60; Example URIs: POST /v2/device-requests/015f2fa34d310000000000010030036c?async-id&#x3D;123e4567-e89b-12d3-a456-426655440000 POST /v2/device-requests/015f2fa34d310000000000010030036c?async-id&#x3D;123e4567-e89b-12d3-a456-426655440000&amp;retry&#x3D;2&amp;expiry-seconds&#x3D;7200  Example payload to read value from resource /5/0/1: { \&quot;method\&quot;: \&quot;GET\&quot;, \&quot;uri\&quot;: \&quot;/5/0/1\&quot; }  Example payload to set notification rules for resource /5/0/1: { \&quot;method\&quot;: \&quot;PUT\&quot;, \&quot;uri\&quot;: \&quot;/5/0/1?lt&#x3D;10&amp;gt&#x3D;60&amp;pmax&#x3D;120\&quot; }  Example payload to write value \&quot;value1\&quot; to resource /5/0/1: { \&quot;method\&quot;: \&quot;PUT\&quot;, \&quot;uri\&quot;: \&quot;/5/0/1%20?k1&#x3D;v1&amp;k2&#x3D;v2%22\&quot;, \&quot;accept\&quot;: \&quot;text/plain\&quot;, \&quot;content-type\&quot;: \&quot;text/plain\&quot;, \&quot;payload-b64\&quot;: \&quot;dmFsdWUxCg&#x3D;&#x3D;\&quot; }  Immediate response: 202 Accepted  Examples of AsyncIDResponse, delivered via the notification channel: { \&quot;async-responses\&quot;: [ { \&quot;id\&quot;: \&quot;123e4567-e89b-12d3-a456-426655440000\&quot;, \&quot;status\&quot;: 200, \&quot;payload\&quot;: \&quot;dmFsdWUxCg&#x3D;&#x3D;\&quot;, \&quot;ct\&quot;: \&quot;text/plain\&quot;, \&quot;max-age\&quot;: 600 } ] } { \&quot;async-responses\&quot;: [ { \&quot;id\&quot;: \&quot;123e4567-e89b-12d3-a456-426655440000\&quot;, \&quot;status\&quot;: 504, \&quot;error\&quot;: \&quot;TIMEOUT\&quot; } ] } &#x60;&#x60;&#x60; 

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.DeviceRequestsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

DeviceRequestsApi apiInstance = new DeviceRequestsApi();
String deviceId = "deviceId_example"; // String | The device ID generated by Device Management.
String asyncId = "asyncId_example"; // String | The client-generated ID for matching the correct response delivered by notification.
DeviceRequest body = new DeviceRequest(); // DeviceRequest | Device request to send.
Integer retry = 56; // Integer | The count of retry transmissions of the request to the device, after initial transmission. For example, retry of two means three delivery attempts in total. If retries are exhausted, the request is discarded and an error is delivered in the AsyncIDResponse. Default value of retry is 0 for a non-queue-mode device and 2 for a queue-mode device.
Integer expirySeconds = 56; // Integer | The time period during which the delivery is attempted, in seconds. If the device is not reachable within this period, the request is discarded and an error is delivered in the AsyncIDResponse. Default value of expiry-seconds is 2 hours for a non-queue-mode device and 3 days for a queue-mode device.
try {
    Void result = apiInstance.createAsyncRequest(deviceId, asyncId, body, retry, expirySeconds);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DeviceRequestsApi#createAsyncRequest");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **deviceId** | **String**| The device ID generated by Device Management. |
 **asyncId** | **String**| The client-generated ID for matching the correct response delivered by notification. |
 **body** | [**DeviceRequest**](DeviceRequest.md)| Device request to send. |
 **retry** | **Integer**| The count of retry transmissions of the request to the device, after initial transmission. For example, retry of two means three delivery attempts in total. If retries are exhausted, the request is discarded and an error is delivered in the AsyncIDResponse. Default value of retry is 0 for a non-queue-mode device and 2 for a queue-mode device. | [optional]
 **expirySeconds** | **Integer**| The time period during which the delivery is attempted, in seconds. If the device is not reachable within this period, the request is discarded and an error is delivered in the AsyncIDResponse. Default value of expiry-seconds is 2 hours for a non-queue-mode device and 3 days for a queue-mode device. | [optional]

### Return type

[**Void**](.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

