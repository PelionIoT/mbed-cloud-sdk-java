# EdgeProxyApi

All URIs are relative to *https://api.us-east-1.mbedcloud.com*

Method | HTTP request | Description
------------- | ------------- | -------------
[**communicateWithGatewayBasedServices**](EdgeProxyApi.md#communicateWithGatewayBasedServices) | **GET** v3preview1/devices/{id}/services/{address}/connection | Establish a tunnel connection to connected devices.


<a name="communicateWithGatewayBasedServices"></a>
# **communicateWithGatewayBasedServices**
> Void communicateWithGatewayBasedServices(connection, upgrade, secWebSocketVersion, secWebSocketKey, id, address, origin)

Establish a tunnel connection to connected devices.

This WebSocket-based API for clients establishes connections to services on connected gateways. &lt;br&gt; Establish WebSocket connections to the edge-proxy service. After you establish a Websocket connection, the Edge proxy sends data between cloud- and gateway-based services. &lt;br&gt; All communication is byte-based. 

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.EdgeProxyApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

EdgeProxyApi apiInstance = new EdgeProxyApi();
String connection = "Upgrade"; // String | The websocket connection header. Must be 'Upgrade'.
String upgrade = "websocket"; // String | The protocol upgrade header. Must be 'websocket'.
Integer secWebSocketVersion = 13; // Integer | WebSocket version of the protocol. Must be 13.
byte[] secWebSocketKey = B; // byte[] | The value of this header field must be a nonce consisting of a randomly selected 16-byte value that has been base64-encoded (see this section from RFC6455 - https://tools.ietf.org/html/rfc6455#section-11.3.1). The nonce must be selected randomly for each connection. An example is \"dGhlIHNhbXBsZSBub25jZQ==\".
String id = "id_example"; // String | The Device ID.
String address = "address_example"; // String | The address of the TCP service listening on a specific port on the gateway. If a TCP service is listening on localhost with port 5000 and is ready to accept incoming traffic,  the value of this parameter should be `localhost:5000`.
String origin = "origin_example"; // String | Originating host of the request.
try {
    Void result = apiInstance.communicateWithGatewayBasedServices(connection, upgrade, secWebSocketVersion, secWebSocketKey, id, address, origin);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling EdgeProxyApi#communicateWithGatewayBasedServices");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **connection** | **String**| The websocket connection header. Must be &#39;Upgrade&#39;. | [default to Upgrade]
 **upgrade** | **String**| The protocol upgrade header. Must be &#39;websocket&#39;. | [default to websocket]
 **secWebSocketVersion** | **Integer**| WebSocket version of the protocol. Must be 13. | [default to 13]
 **secWebSocketKey** | **byte[]**| The value of this header field must be a nonce consisting of a randomly selected 16-byte value that has been base64-encoded (see this section from RFC6455 - https://tools.ietf.org/html/rfc6455#section-11.3.1). The nonce must be selected randomly for each connection. An example is \&quot;dGhlIHNhbXBsZSBub25jZQ&#x3D;&#x3D;\&quot;. |
 **id** | **String**| The Device ID. |
 **address** | **String**| The address of the TCP service listening on a specific port on the gateway. If a TCP service is listening on localhost with port 5000 and is ready to accept incoming traffic,  the value of this parameter should be &#x60;localhost:5000&#x60;. |
 **origin** | **String**| Originating host of the request. | [optional]

### Return type

[**Void**](.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

