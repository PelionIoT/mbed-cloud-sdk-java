# NotificationsApi

All URIs are relative to *https://api.us-east-1.mbedcloud.com*

Method | HTTP request | Description
------------- | ------------- | -------------
[**connectWebsocket**](NotificationsApi.md#connectWebsocket) | **GET** v2/notification/websocket-connect | Open the websocket.
[**deleteLongPollChannel**](NotificationsApi.md#deleteLongPollChannel) | **DELETE** v2/notification/pull | Delete notification Long Poll channel
[**deleteWebsocket**](NotificationsApi.md#deleteWebsocket) | **DELETE** v2/notification/websocket | Delete websocket channel.
[**deregisterWebhook**](NotificationsApi.md#deregisterWebhook) | **DELETE** v2/notification/callback | Delete callback URL
[**getWebhook**](NotificationsApi.md#getWebhook) | **GET** v2/notification/callback | Check callback URL
[**getWebsocket**](NotificationsApi.md#getWebsocket) | **GET** v2/notification/websocket | Get websocket channel information.
[**longPollNotifications**](NotificationsApi.md#longPollNotifications) | **GET** v2/notification/pull | Get notifications using Long Poll
[**registerWebhook**](NotificationsApi.md#registerWebhook) | **PUT** v2/notification/callback | Register a callback URL
[**registerWebsocket**](NotificationsApi.md#registerWebsocket) | **PUT** v2/notification/websocket | Register a websocket channel


<a name="connectWebsocket"></a>
# **connectWebsocket**
> Void connectWebsocket(connection, upgrade, secWebSocketProtocol)

Open the websocket.

 A websocket channel can have only one active websocket connection at a time. If a websocket connection for a channel exists and a new connection to the same channel is made the connection is accepted and the older connection will be closed.&lt;br/&gt; Once the socket has been opened, it may be closed with one of the following status codes&lt;br/&gt; **1000**: Socket closed by the client. **1001**: Going away. set when another socket was opened on the used channel, or if the channel was deleted with a REST call, or if the server is shutting down. **1006**: Abnormal loss of connection. This code is never set by the service. **1008**: Policy violation. Set when the API key is missing or invalid. **1011**: Unexpected condition. Socket will be closed with this status at an attempt to open a socket to an unexisting channel (without a prior REST PUT). This code is also used to indicate closing socket for any other unexpected condition in the server. 

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.NotificationsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

NotificationsApi apiInstance = new NotificationsApi();
String connection = "Upgrade"; // String | 
String upgrade = "websocket"; // String | 
String secWebSocketProtocol = "secWebSocketProtocol_example"; // String | ApiKey must be present in the `Sec-WebSocket-Protocol` header `\"Sec-WebSocket-Protocol\":\"wss,pelion_ak_{api_key}\"` Refer to the notification service documentation for examples of usage. 
try {
    Void result = apiInstance.connectWebsocket(connection, upgrade, secWebSocketProtocol);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling NotificationsApi#connectWebsocket");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **connection** | **String**|  | [default to Upgrade]
 **upgrade** | **String**|  | [default to websocket]
 **secWebSocketProtocol** | **String**| ApiKey must be present in the &#x60;Sec-WebSocket-Protocol&#x60; header &#x60;\&quot;Sec-WebSocket-Protocol\&quot;:\&quot;wss,pelion_ak_{api_key}\&quot;&#x60; Refer to the notification service documentation for examples of usage.  |

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

Delete notification Long Poll channel

To delete a notification Long Poll channel. This is required to change the channel from Long Poll to another type. You should not make a GET &#x60;/v2/notification/pull&#x60; call for 2 minutes after channel was deleted, because it can implicitly recreate the pull channel. You can also have some random responses with payload or 410 GONE with \&quot;CHANNEL_DELETED\&quot; as a payload or 200/204 until the old channel is purged.  **Example usage:**     curl -X DELETE https://api.us-east-1.mbedcloud.com/v2/notification/pull -H &#39;authorization: Bearer {api-key}&#39; 

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.NotificationsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

NotificationsApi apiInstance = new NotificationsApi();
try {
    Void result = apiInstance.deleteLongPollChannel();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling NotificationsApi#deleteLongPollChannel");
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

To delete a notification websocket channel bound to the API key. This is required to change the channel from websocket to another type.  **Example usage:**      curl -X DELETE https://api.us-east-1.mbedcloud.com/v2/notification/websocket -H &#39;authorization: Bearer {api-key}&#39; 

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.NotificationsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

NotificationsApi apiInstance = new NotificationsApi();
try {
    Void result = apiInstance.deleteWebsocket();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling NotificationsApi#deleteWebsocket");
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

Delete callback URL

Deletes the callback URL.  **Example usage:**      curl -X DELETE https://api.us-east-1.mbedcloud.com/v2/notification/callback -H &#39;authorization: Bearer {api-key}&#39; 

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.NotificationsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

NotificationsApi apiInstance = new NotificationsApi();
try {
    Void result = apiInstance.deregisterWebhook();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling NotificationsApi#deregisterWebhook");
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

<a name="getWebhook"></a>
# **getWebhook**
> Webhook getWebhook()

Check callback URL

Shows the current callback URL if it exists.  **Example usage:**      curl -X GET https://api.us-east-1.mbedcloud.com/v2/notification/callback -H &#39;authorization: Bearer {api-key}&#39; 

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.NotificationsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

NotificationsApi apiInstance = new NotificationsApi();
try {
    Webhook result = apiInstance.getWebhook();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling NotificationsApi#getWebhook");
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

Returns 200 with websocket connection status if websocket channel exists.  **Example usage:**      curl -X GET https://api.us-east-1.mbedcloud.com/v2/notification/websocket -H &#39;authorization: Bearer {api-key}&#39; 

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.NotificationsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

NotificationsApi apiInstance = new NotificationsApi();
try {
    WebsocketChannel result = apiInstance.getWebsocket();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling NotificationsApi#getWebsocket");
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

In this case, notifications are delivered through HTTP long poll requests. The HTTP request is kept open until an event notification or a batch of event notifications are delivered to the client or the request times out (response code 204). In both cases, the client should open a new polling connection after the previous one closes. Only a single long polling connection per API key can be ongoing at any given time. You must have a persistent connection (Connection keep-alive header in the request) to avoid excess TLS handshakes.  The pull channel is implicitly created by the first GET call to &#x60;/v2/notification/pull&#x60;. It is refreshed on each GET call. If the channel is not polled for a long time (10 minutes) - it expires and will be deleted. This means that no notifications will stay in the queue between polls. A channel can be also deleted explicitly by a DELETE call.  **Note:** If you cannot have a public facing callback URL, for example when developing on your local machine, you can use long polling to check for new messages. However, **long polling is deprecated** and will likely be replaced in future. It is meant only for experimentation and not for commercial usage. The proper method to receive notifications is a **notification callback**. There can only be one notification channel per API key at a time in Device Management Connect. If a notification channel of other type already exists for the API key, you need to delete it before creating a long poll notification channel.  **Example usage:**      curl -X GET https://api.us-east-1.mbedcloud.com/v2/notification/pull -H &#39;authorization: Bearer {api-key}&#39; 

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.NotificationsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

NotificationsApi apiInstance = new NotificationsApi();
try {
    NotificationMessage result = apiInstance.longPollNotifications();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling NotificationsApi#longPollNotifications");
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

Register a callback URL

Register a URL to which the server should deliver notifications of the subscribed resource changes. To get notifications pushed, you also need to place the subscriptions. The maximum length of the URL, header keys and values, all combined, is 400 characters. Notifications are delivered as PUT messages to the HTTP server defined by the client with a subscription server message. The given URL should be accessible and respond to the PUT request with response code of 200 or 204. Device Management Connect tests the callback URL with an empty payload when the URL is registered. For more information on notification messages, see [NotificationMessage](#NotificationMessage).  **Optional headers in a callback message:**  You can set optional headers to a callback in a **Webhook** object. Device Management Connect will include the header and key pairs to the notification messages send them to callback URL. As the callback URL&#39;s are API key specific also the headers are.  One possible use for the additional headers is to check the origin of a PUT request and also distinguish the application (API key) to which the notification belongs to.  **Note**: Only one callback URL per an API key can be active. If you register a new URL while another one is already active, it replaces the active one. There can be only one notification channel at a time. If another type of channel is already present, you need to delete it before setting the callback URL.  **Expiration of a callback URL:**  A callback can expire when Device Management cannot deliver a notification due to a connection timeout or an error response (4xx or 5xx). After each delivery failure, Device Management sets an exponential back off time and makes a retry attempt after that. The first retry delay is 1 second, then 2s, 4s, 8s, ..., 2min, 2min. The maximum retry delay is 2 minutes. The callback URL will be removed if all retries fail within 24 hours. More about [notification sending logic](/docs/current/integrate-web-app/event-notification.html#notification-sending-logic).  **Supported callback URL protocols:**  Currently, only HTTP and HTTPS protocols are supported.  **HTTPS callback URLs:**  When delivering a notification to an HTTPS based callback URL, Device Management Connect will present a valid client certificate to identify itself. The certificate is signed by a trusted certificate authorithy (GlobalSign) with a Common Name (CN) set to notifications.mbedcloud.com.  **Example usage:**  This example command shows how to set your callback URL and API key. It also sets an optional header authorization. When Device Management Connect calls your callback URL, the call contains the authorization header with the defined value.      curl -X PUT \\       https://api.us-east-1.mbedcloud.com/v2/notification/callback \\       -H &#39;authorization: Bearer {api-key}&#39; \\       -H &#39;content-type: application/json&#39; \\       -d &#39;{       \&quot;url\&quot;: \&quot;{callback-url}\&quot;,       \&quot;headers\&quot;: {\&quot;authorization\&quot; : \&quot;f4b93d6e-4652-4874-82e4-41a3ced0cd56\&quot;}       }&#39; 

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.NotificationsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

NotificationsApi apiInstance = new NotificationsApi();
Webhook webhook = new Webhook(); // Webhook | A json object that contains the optional headers and the URL to which the notifications need to be sent. 
try {
    Void result = apiInstance.registerWebhook(webhook);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling NotificationsApi#registerWebhook");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **webhook** | [**Webhook**](Webhook.md)| A json object that contains the optional headers and the URL to which the notifications need to be sent.  |

### Return type

[**Void**](.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="registerWebsocket"></a>
# **registerWebsocket**
> WebsocketChannel registerWebsocket()

Register a websocket channel

Register (or update) a channel which will use websocket connection to deliver notifications. The websocket channel should be opened by client using &#x60;/v2/notification/websocket-connect&#x60; endpoint. To get notifications pushed, you also need to place the subscriptions. For more information on notification messages, see [NotificationMessage](#NotificationMessage).  A websocket channel can have only one active websocket connection at a time. If a websocket connection for a channel exists and a new connection to the same channel is made the connection is accepted and the older connection will be closed.  **Expiration of a websocket:**  A websocket channel will be expired if the channel does not have an opened websocket connection for 24 hour period. Channel expiration means the channel will be deleted and any undelivered notifications stored in its internal queue will be removed. As long as the channel has an opened websocket connection or time between successive websocket connections is less than 24 hours, the channel is considered active, notifications are stored in its internal queue and delivered when a websocket connection is active. A channel can be also deleted explicitly by a DELETE call.  More about [notification sending logic](/docs/current/integrate-web-app/event-notification.html#notification-sending-logic).  **Example usage:**      curl -X PUT https://api.us-east-1.mbedcloud.com/v2/notification/websocket -H &#39;authorization: Bearer {api-key}&#39; 

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.NotificationsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

NotificationsApi apiInstance = new NotificationsApi();
try {
    WebsocketChannel result = apiInstance.registerWebsocket();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling NotificationsApi#registerWebsocket");
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

 - **Content-Type**: application/json
 - **Accept**: application/json

