# WebsocketApi

All URIs are relative to *https://api.us-east-1.mbedcloud.com*

Method | HTTP request | Description
------------- | ------------- | -------------
[**connectWebsocket**](WebsocketApi.md#connectWebsocket) | **GET** v2/notification/websocket-connect | Open the websocket.
[**deleteWebsocket**](WebsocketApi.md#deleteWebsocket) | **DELETE** v2/notification/websocket | Delete websocket channel.
[**getWebsocket**](WebsocketApi.md#getWebsocket) | **GET** v2/notification/websocket | Get websocket channel information.
[**registerWebsocket**](WebsocketApi.md#registerWebsocket) | **PUT** v2/notification/websocket | Register a websocket channel


<a name="connectWebsocket"></a>
# **connectWebsocket**
> Void connectWebsocket(connection, upgrade)

Open the websocket.

Opens the websocket connection.  A websocket channel can have only one active websocket connection at a time. If a websocket connection for a channel exists and a new connection to the same channel is made the connection is accepted and the older connection will be closed.  

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.WebsocketApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

WebsocketApi apiInstance = new WebsocketApi();
String connection = "Upgrade"; // String | 
String upgrade = "websocket"; // String | 
try {
    Void result = apiInstance.connectWebsocket(connection, upgrade);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling WebsocketApi#connectWebsocket");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **connection** | **String**|  | [default to Upgrade]
 **upgrade** | **String**|  | [default to websocket]

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

To delete a notification websocket channel bound to the API key.  This is required to change the channel from websocket to another type.  **Example usage:**      curl -X DELETE https://api.us-east-1.mbedcloud.com/v2/notification/websocket -H &#39;authorization: Bearer {api-key}&#39; 

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.WebsocketApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

WebsocketApi apiInstance = new WebsocketApi();
try {
    Void result = apiInstance.deleteWebsocket();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling WebsocketApi#deleteWebsocket");
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
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.WebsocketApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

WebsocketApi apiInstance = new WebsocketApi();
try {
    WebsocketChannel result = apiInstance.getWebsocket();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling WebsocketApi#getWebsocket");
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

<a name="registerWebsocket"></a>
# **registerWebsocket**
> WebsocketChannel registerWebsocket()

Register a websocket channel

Register (or update) a channel which will use websocket connection to deliver notifications. The websocket channel should be opened by client using &#x60;/v2/notification/websocket-connect&#x60; endpoint. To get notifications pushed, you also need to place  the subscriptions. For more information on notification messages, see [NotificationMessage](#NotificationMessage).  A websocket channel can have only one active websocket connection at a time. If a websocket connection for a channel exists and a new connection to the same channel is made the connection is accepted and the older connection will be closed.   **Expiration of a websocket:**  A websocket channel will be expired if the channel does not have an opened websocket connection for 24 hour period. Channel expiration means the channel will be deleted and any undelivered notifications stored in its internal queue will be removed. As long as the channel has an opened websocket connection or time between successive websocket connections is less than 24 hours, the channel is considered active, notifications are stored in its internal queue and delivered when a websocket connection is active. A channel can be also deleted explicitly by a DELETE call.  More about [notification sending logic](/docs/current/integrate-web-app/event-notification.html#notification-sending-logic).  **Example usage:**      curl -X PUT https://api.us-east-1.mbedcloud.com/v2/notification/websocket -H &#39;authorization: Bearer {api-key}&#39; 

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.WebsocketApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

WebsocketApi apiInstance = new WebsocketApi();
try {
    WebsocketChannel result = apiInstance.registerWebsocket();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling WebsocketApi#registerWebsocket");
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

