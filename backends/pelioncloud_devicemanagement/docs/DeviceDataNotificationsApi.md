# DeviceDataNotificationsApi

All URIs are relative to *https://api.us-east-1.mbedcloud.com*

Method | HTTP request | Description
------------- | ------------- | -------------
[**connectWebsocket**](DeviceDataNotificationsApi.md#connectWebsocket) | **GET** v2/notification/websocket-connect | Open the websocket.
[**deleteLongPollChannel**](DeviceDataNotificationsApi.md#deleteLongPollChannel) | **DELETE** v2/notification/pull | Delete notification Long Poll channel.
[**deleteWebsocket**](DeviceDataNotificationsApi.md#deleteWebsocket) | **DELETE** v2/notification/websocket | Delete websocket channel.
[**deregisterWebhook**](DeviceDataNotificationsApi.md#deregisterWebhook) | **DELETE** v2/notification/callback | Delete callback URL.
[**getChannelMetadata**](DeviceDataNotificationsApi.md#getChannelMetadata) | **GET** v2/notification/channel | Get channel metadata.
[**getWebhook**](DeviceDataNotificationsApi.md#getWebhook) | **GET** v2/notification/callback | Check callback URL.
[**getWebsocket**](DeviceDataNotificationsApi.md#getWebsocket) | **GET** v2/notification/websocket | Get websocket channel information.
[**longPollNotifications**](DeviceDataNotificationsApi.md#longPollNotifications) | **GET** v2/notification/pull | Get notifications using Long Poll
[**registerWebhook**](DeviceDataNotificationsApi.md#registerWebhook) | **PUT** v2/notification/callback | Register a callback URL.
[**registerWebsocket**](DeviceDataNotificationsApi.md#registerWebsocket) | **PUT** v2/notification/websocket | Register a websocket channel.


<a name="connectWebsocket"></a>
# **connectWebsocket**
> Void connectWebsocket(connection, upgrade, origin, secWebSocketVersion, secWebSocketKey, secWebSocketProtocol)

Open the websocket.

 A websocket channel can have only one active connection at a time. If a websocket connection for a channel exists and a new connection to the same channel is made, the connection is accepted and the older connection is closed.  A websocket client library should be used when connecting to this endpoint.  Once the socket has been opened, the server may close it with one of the following status codes.  &lt;table&gt;   &lt;thead&gt;     &lt;tr&gt;       &lt;th&gt;Code&lt;/th&gt;       &lt;th&gt;Description&lt;/th&gt;     &lt;/tr&gt;   &lt;/thead&gt;   &lt;tbody&gt;     &lt;tr&gt;       &lt;td&gt;&lt;b&gt;1000&lt;/b&gt;&lt;/td&gt;       &lt;td&gt;Socket closed normally by the client, or by the server when the channel is deleted with a REST call.&lt;/td&gt;     &lt;/tr&gt;     &lt;tr&gt;       &lt;td&gt;&lt;b&gt;1001&lt;/b&gt;&lt;/td&gt;       &lt;td&gt;Going away. Set when another socket opens on the used channel.&lt;/td&gt;     &lt;/tr&gt;     &lt;tr&gt;       &lt;td&gt;&lt;b&gt;1006&lt;/b&gt;&lt;/td&gt;       &lt;td&gt;Abnormal closure. The client should reconnect after receiving this status code. A short reconnect delay is recommended.&lt;/td&gt;     &lt;/tr&gt;     &lt;tr&gt;       &lt;td&gt;&lt;b&gt;1008&lt;/b&gt;&lt;/td&gt;       &lt;td&gt;Policy violation. Set if the access key is lost or invalidated after a successful WebSocket handshake.&lt;/td&gt;     &lt;/tr&gt;     &lt;tr&gt;       &lt;td&gt;&lt;b&gt;1011&lt;/b&gt;&lt;/td&gt;       &lt;td&gt;Unexpected condition. The socket is closed with this status in an attempt to open a socket to a nonexistent channel (without a prior PUT request). This code is also used to indicate a closing socket for any other unexpected condition in the server.&lt;/td&gt;     &lt;/tr&gt;     &lt;tr&gt;       &lt;td&gt;&lt;b&gt;1012&lt;/b&gt;&lt;/td&gt;       &lt;td&gt;Service restart. Set when the server restarts for update, maintenance, and so on. The client should reconnect after receiving this status code. A short reconnect delay is recommended.&lt;/td&gt;     &lt;/tr&gt;   &lt;/tbody&gt; &lt;/table&gt;  **Expected client behaviour:**  If the connection is closed with code 1006 or 1012, the client should try to reconnect to maintain the notification flow. The client might disconnect several times in a relatively short period, for example, during service updates. This is normal. The desired client behavior is to reconnect after each disconnect.  **Example:**  The example is meant only for testing. For production devices, use a WebSocket client library. Websocat (https://github.com/vi/websocat) is a command-line client for WebSockets, like netcat or cURL. The example command opens a new WebSocket, waits for any data sent to the socket from the server, and prints it to &#x60;stdout&#x60;.  &#x60;&#x60;&#x60; websocat wss://api.us-east-1.mbedcloud.com/v2/notification/websocket-connect \\ -H \&quot;Sec-WebSocket-Protocol:wss,pelion_ak_&lt;access_key&gt;\&quot; &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.DeviceDataNotificationsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

DeviceDataNotificationsApi apiInstance = new DeviceDataNotificationsApi();
String connection = "Upgrade"; // String | 
String upgrade = "websocket"; // String | 
String origin = "origin_example"; // String | Originating host of the request.
Integer secWebSocketVersion = 13; // Integer | WebSocket version. Must be 13.
String secWebSocketKey = "secWebSocketKey_example"; // String | The value of this header field must be a nonce consisting of a randomly selected 16-byte value that has been base64-encoded (see Section 4 of [RFC4648]). The nonce must be selected randomly for each connection.
String secWebSocketProtocol = "secWebSocketProtocol_example"; // String | Access key or user token must be present in the `Sec-WebSocket-Protocol` header **if Authorization header cannot be provided**: `Sec-WebSocket-Protocol:\"wss,pelion_ak_{access_key}\"`. Refer to the notification service documentation for examples.
try {
    Void result = apiInstance.connectWebsocket(connection, upgrade, origin, secWebSocketVersion, secWebSocketKey, secWebSocketProtocol);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DeviceDataNotificationsApi#connectWebsocket");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **connection** | **String**|  | [default to Upgrade]
 **upgrade** | **String**|  | [default to websocket]
 **origin** | **String**| Originating host of the request. |
 **secWebSocketVersion** | **Integer**| WebSocket version. Must be 13. | [default to 13]
 **secWebSocketKey** | **String**| The value of this header field must be a nonce consisting of a randomly selected 16-byte value that has been base64-encoded (see Section 4 of [RFC4648]). The nonce must be selected randomly for each connection. |
 **secWebSocketProtocol** | **String**| Access key or user token must be present in the &#x60;Sec-WebSocket-Protocol&#x60; header **if Authorization header cannot be provided**: &#x60;Sec-WebSocket-Protocol:\&quot;wss,pelion_ak_{access_key}\&quot;&#x60;. Refer to the notification service documentation for examples. | [optional]

### Return type

[**Void**](.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="deleteLongPollChannel"></a>
# **deleteLongPollChannel**
> Void deleteLongPollChannel()

Delete notification Long Poll channel.

Delete a notification Long Poll channel. This is required to change the channel from Long Poll to another type. Do not make a GET &#x60;/v2/notification/pull&#x60; call for two minutes after deleting the channel, because it can implicitly recreate the pull channel. You can also have some random responses with payload or 410 GONE with \&quot;CHANNEL_DELETED\&quot; as a payload or 200/204 until the old channel is purged.  **Example:** &#x60;&#x60;&#x60; curl -X DELETE https://api.us-east-1.mbedcloud.com/v2/notification/pull \\ -H &#39;Authorization: Bearer &lt;access_key&gt;&#39; &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.DeviceDataNotificationsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

DeviceDataNotificationsApi apiInstance = new DeviceDataNotificationsApi();
try {
    Void result = apiInstance.deleteLongPollChannel();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DeviceDataNotificationsApi#deleteLongPollChannel");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**Void**](.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="deleteWebsocket"></a>
# **deleteWebsocket**
> Void deleteWebsocket()

Delete websocket channel.

Delete a notification websocket channel bound to the application. This is required to change the channel from websocket to another type.  Deleting the websocket channel also removes the channel&#39;s notification queue. Any unsent notifications are lost when the channel is deleted. **Example:**  &#x60;&#x60;&#x60; curl -X DELETE https://api.us-east-1.mbedcloud.com/v2/notification/websocket \\ -H &#39;Authorization: Bearer &lt;access_key&gt;&#39; &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.DeviceDataNotificationsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

DeviceDataNotificationsApi apiInstance = new DeviceDataNotificationsApi();
try {
    Void result = apiInstance.deleteWebsocket();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DeviceDataNotificationsApi#deleteWebsocket");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**Void**](.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="deregisterWebhook"></a>
# **deregisterWebhook**
> Void deregisterWebhook()

Delete callback URL.

Deletes the callback URL.  Deleting the callback URL also removes the channel&#39;s notification queue. Any unsent notifications are lost when the channel is deleted.  **Example:** &#x60;&#x60;&#x60; curl -X DELETE https://api.us-east-1.mbedcloud.com/v2/notification/callback \\ -H &#39;Authorization: Bearer &lt;access_key&gt;&#39; &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.DeviceDataNotificationsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

DeviceDataNotificationsApi apiInstance = new DeviceDataNotificationsApi();
try {
    Void result = apiInstance.deregisterWebhook();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DeviceDataNotificationsApi#deregisterWebhook");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**Void**](.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getChannelMetadata"></a>
# **getChannelMetadata**
> ChannelMetadata getChannelMetadata()

Get channel metadata.

Get channel delivery mechanism.  **Example:**      curl -X GET https://api.us-east-1.mbedcloud.com/v2/notification/channel \\     -H &#39;Authorization: Bearer &lt;access_key&gt;&#39; 

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.DeviceDataNotificationsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

DeviceDataNotificationsApi apiInstance = new DeviceDataNotificationsApi();
try {
    ChannelMetadata result = apiInstance.getChannelMetadata();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DeviceDataNotificationsApi#getChannelMetadata");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**ChannelMetadata**](ChannelMetadata.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getWebhook"></a>
# **getWebhook**
> Webhook getWebhook()

Check callback URL.

Shows the current callback URL if it exists.  **Example:** &#x60;&#x60;&#x60; curl -X GET https://api.us-east-1.mbedcloud.com/v2/notification/callback \\ -H &#39;Authorization: Bearer &lt;access_key&gt;&#39; &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.DeviceDataNotificationsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

DeviceDataNotificationsApi apiInstance = new DeviceDataNotificationsApi();
try {
    Webhook result = apiInstance.getWebhook();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DeviceDataNotificationsApi#getWebhook");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**Webhook**](Webhook.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getWebsocket"></a>
# **getWebsocket**
> WebsocketChannel getWebsocket()

Get websocket channel information.

Returns 200 with websocket connection status, if websocket channel exists.  **Note**: The current version does not yet have the capability to determine the channel status and will always return status &#39;unknown&#39; and queue size &#39;-1&#39;.  **Example:**  &#x60;&#x60;&#x60; curl -X GET https://api.us-east-1.mbedcloud.com/v2/notification/websocket \\ -H &#39;Authorization: Bearer &lt;access_key&gt;&#39; &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.DeviceDataNotificationsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

DeviceDataNotificationsApi apiInstance = new DeviceDataNotificationsApi();
try {
    WebsocketChannel result = apiInstance.getWebsocket();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DeviceDataNotificationsApi#getWebsocket");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**WebsocketChannel**](WebsocketChannel.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="longPollNotifications"></a>
# **longPollNotifications**
> NotificationMessage longPollNotifications()

Get notifications using Long Poll

In this case, notifications are delivered through HTTP long poll requests. The HTTP request is kept open until one or more event notifications are delivered to the client, or the request times out (response code 204). In both cases, the client should open a new polling connection after the previous one closes. Only a single long polling connection per application can be ongoing at any given time. We recommend using a persistent connection (Connection keep-alive header in the request) to avoid excess TLS handshakes.  The pull channel is implicitly created by the first GET call to &#x60;/v2/notification/pull&#x60;. It refreshes on each GET call. If the channel is not polled for a long time (10 minutes), it expires and is deleted. This means that no notifications will stay in the queue between polls. A channel can be also be deleted explicitly with a DELETE call.  **Note:** If you cannot have a public-facing callback URL, for example, when developing on your local machine, you can use long polling to check for new messages. However, **long polling is deprecated** and will likely be replaced in the future. It is meant only for experimentation, not commercial use. The proper method to receive notifications is a **notification callback**.  There can only be one notification channel per application in Device Management Connect. If a notification channel of other type already exists for the application, delete it before creating a long poll notification channel.  **Example:** &#x60;&#x60;&#x60; curl -X GET https://api.us-east-1.mbedcloud.com/v2/notification/pull \\ -H &#39;Authorization: Bearer &lt;access_key&gt;&#39; &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.DeviceDataNotificationsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

DeviceDataNotificationsApi apiInstance = new DeviceDataNotificationsApi();
try {
    NotificationMessage result = apiInstance.longPollNotifications();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DeviceDataNotificationsApi#longPollNotifications");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**NotificationMessage**](NotificationMessage.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="registerWebhook"></a>
# **registerWebhook**
> Void registerWebhook(webhook)

Register a callback URL.

Register a URL to which the server delivers notifications of changes to the subscribed resource. To push notifications, you must first place subscriptions. The maximum length of the URL, header keys, and values, all combined, is 400 characters.  Notifications are delivered as PUT requests to the HTTP server, which the client defines with a subscription server message. The given URL must be accessible, and respond to the PUT request with a response code of 200 or 204.  Device Management Connect tests the callback URL with an empty JSON payload &#x60;{}&#x60; when the URL is registered. Callback implementation does not support URL redirection. For more information on notification messages, see [NotificationMessage](#NotificationMessage).  **Optional headers in a callback message:**  You can set optional headers to a callback in a **Webhook** object. Device Management Connect includes the header and key pairs in the notification messages send them to callback URL. The callback URLs and headers are application-specific.  One possible use for additional headers is checking the origin of a PUT request, as well as distinguishing the application to which the notification belongs.  **Note**: Only one callback URL for each application can be active. If you register a new URL while another one is active, it replaces the active one. There can be only one notification channel at a time for each application. If another type of channel is already present, you need to delete it before setting the callback URL.  **Expiration of a callback URL:**  A callback can expire when Device Management cannot deliver a notification due to a connection timeout or error response (4xx or 5xx). After each delivery failure, Device Management sets an exponential back-off time and makes a retry attempt after that. The first retry delay is 1 second, then 2s, 4s, 8s, up to a maximum delay of two minutes. The retry delay is applied when the response is received, or in case of timeout, after the timeout expires. The request timeout is 20 seconds; in the case of timeout, the first retry happens 20 + 1 seconds after the first delivery attempt, then 20 + 2 seconds, and so on. The callback URL is removed if all retries fail within 24 hours. More about [notification sending logic](https://developer.pelion.com/docs/device-management/current/integrate-web-app/event-notification.html#notification-sending-logic) in the Device Management documentation.  **Supported callback URL protocols:**  Currently, only HTTP and HTTPS protocols are supported.  **HTTPS callback URLs:**  When delivering a notification to an HTTPS-based callback URL, Device Management Connect identifies itself with a valid client certificate. The certificate is signed by a trusted certificate authority (GlobalSign), with a Common Name (CN) set to &#x60;notifications.mbedcloud.com&#x60;.  **Configuration options:**  The event notification channel provides configurations options defined in [Serialization config](#SerializationConfigObjectV2).  **Example:**  This example command shows how to set your callback URL. It also sets an optional header authorization. When Device Management Connect calls your callback URL, the call contains the authorization header with the defined value.  &#x60;&#x60;&#x60; curl -X PUT https://api.us-east-1.mbedcloud.com/v2/notification/callback \\ -H &#39;Authorization: Bearer &lt;access_key&gt;&#39; \\ -H &#39;content-type: application/json&#39; \\ -d &#39;{   \&quot;url\&quot;: \&quot;{callback-url}\&quot;,   \&quot;headers\&quot;: {\&quot;authorization\&quot;: \&quot;f4b93d6e-4652-4874-82e4-41a3ced0cd56\&quot;},   \&quot;serialization\&quot;: {\&quot;type\&quot;: \&quot;v2\&quot;, \&quot;max_chunk_size\&quot;: \&quot;100\&quot;,     \&quot;cfg\&quot;: {\&quot;deregistrations_as_object\&quot;: \&quot;true\&quot;, \&quot;include_uid\&quot;: \&quot;true\&quot;, \&quot;include_timestamp\&quot;: \&quot;true\&quot;, \&quot;include_original_ep\&quot;: \&quot;true\&quot;     }   } }&#39; &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.DeviceDataNotificationsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

DeviceDataNotificationsApi apiInstance = new DeviceDataNotificationsApi();
Webhook webhook = new Webhook(); // Webhook | A JSON object that contains the optional headers and URL where notifications are sent.
try {
    Void result = apiInstance.registerWebhook(webhook);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DeviceDataNotificationsApi#registerWebhook");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **webhook** | [**Webhook**](Webhook.md)| A JSON object that contains the optional headers and URL where notifications are sent. |

### Return type

[**Void**](.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="registerWebsocket"></a>
# **registerWebsocket**
> RegisterWebsocketChannel registerWebsocket()

Register a websocket channel.

Register (or update) a channel using websocket connection to deliver notifications. The websocket channel should be opened by client using &#x60;/v2/notification/websocket-connect&#x60; endpoint. To get notifications pushed, you must place subscriptions. For more information on notification messages, see [NotificationMessage](#NotificationMessage).  A websocket channel can have only one active websocket connection at a time. If a websocket connection for a channel exists and a new connection to the same channel is made, the connection is accepted and the older connection is closed.  **Note**: Only one websocket channel for each application can be active at a time. If you register a new websocket channel while another one is active, it replaces the previously active one. If another type of channel is already present, you need to delete it before registering a websocket channel.  **Note**: The current version does not yet have the capability to determine the channel status and will always return status &#39;unknown&#39; and queue size &#39;-1&#39;.  **Expiration of a websocket:**  A websocket channel is expired if the channel does not have an opened websocket connection for a 24-hour period. Channel expiration means the channel is deleted and any undelivered notifications stored in its internal queue is removed. As long as the channel has an opened websocket connection or time between successive websocket connections is less than 24 hours, the channel is considered active, notifications are stored in its internal queue and delivered when a websocket connection is active. A channel can be also deleted explicitly with a DELETE call.  More about [notification sending logic](https://developer.pelion.com/docs/device-management/current/integrate-web-app/event-notification.html#notification-sending-logic).  **Configuration options:**  The event notification channel provides configurations options defined in [Serialization config](#SerializationConfigObjectV2)  **Example:** &#x60;&#x60;&#x60; curl -X PUT https://api.us-east-1.mbedcloud.com/v2/notification/websocket \\ -H &#39;Authorization: Bearer &lt;access_key&gt;&#39; \\ -d &#39;{   \&quot;serialization\&quot;: {\&quot;type\&quot;: \&quot;v2\&quot;, \&quot;max_chunk_size\&quot;: \&quot;100\&quot;,     \&quot;cfg\&quot;: {\&quot;deregistrations_as_object\&quot;: \&quot;true\&quot;, \&quot;include_uid\&quot;: \&quot;true\&quot;, \&quot;include_timestamp\&quot;: \&quot;true\&quot;, \&quot;include_original_ep\&quot;: \&quot;true\&quot;     }   } } &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.DeviceDataNotificationsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

DeviceDataNotificationsApi apiInstance = new DeviceDataNotificationsApi();
try {
    RegisterWebsocketChannel result = apiInstance.registerWebsocket();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DeviceDataNotificationsApi#registerWebsocket");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**RegisterWebsocketChannel**](RegisterWebsocketChannel.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

