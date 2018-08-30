# EndpointsApi

All URIs are relative to *https://api.us-east-1.mbedcloud.com*

Method | HTTP request | Description
------------- | ------------- | -------------
[**getConnectedEndpoints**](EndpointsApi.md#getConnectedEndpoints) | **GET** v2/endpoints | (DEPRECATED) List registered endpoints. The number of returned endpoints is currently limited to 200.
[**getEndpointResources**](EndpointsApi.md#getEndpointResources) | **GET** v2/endpoints/{device-id} | List the resources on an endpoint


<a name="getConnectedEndpoints"></a>
# **getConnectedEndpoints**
> List&lt;Endpoint&gt; getConnectedEndpoints(type)

(DEPRECATED) List registered endpoints. The number of returned endpoints is currently limited to 200.

Endpoints are physical devices having valid registration to Device Management. All devices regardless of registration status can be requested from Device Directory API [&#39;/v3/devices/&#x60;](/docs/current/service-api-references/device-directory.html).  **Note:** This endpoint is deprecated and will be removed 1Q/18. You should use the Device Directory API [&#x60;/v3/devices/&#x60;](/docs/current/service-api-references/device-directory.html). To list only the registered devices, use filter &#x60;/v3/devices/?filter&#x3D;state%3Dregistered&#x60;.  **Example usage:**      curl -X GET https://api.us-east-1.mbedcloud.com/v2/endpoints -H &#39;authorization: Bearer {api-key}&#39; 

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.internal.mds.ApiClient;
//import com.arm.mbed.cloud.sdk.internal.mds.ApiException;
//import com.arm.mbed.cloud.sdk.internal.mds.Configuration;
//import com.arm.mbed.cloud.sdk.internal.mds.auth.*;
//import com.arm.mbed.cloud.sdk.internal.mds.api.EndpointsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

EndpointsApi apiInstance = new EndpointsApi();
String type = "type_example"; // String | Filter endpoints by endpoint-type.
try {
    List<Endpoint> result = apiInstance.getConnectedEndpoints(type);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling EndpointsApi#getConnectedEndpoints");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **type** | **String**| Filter endpoints by endpoint-type. | [optional]

### Return type

[**List&lt;Endpoint&gt;**](Endpoint.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getEndpointResources"></a>
# **getEndpointResources**
> List&lt;Resource&gt; getEndpointResources(deviceId)

List the resources on an endpoint

The list of resources is cached by Device Management Connect, so this call does not create a message to the device.  **Example usage:**      curl -X GET https://api.us-east-1.mbedcloud.com/v2/endpoints/{device-id} -H &#39;authorization: Bearer {api-key}&#39; 

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.internal.mds.ApiClient;
//import com.arm.mbed.cloud.sdk.internal.mds.ApiException;
//import com.arm.mbed.cloud.sdk.internal.mds.Configuration;
//import com.arm.mbed.cloud.sdk.internal.mds.auth.*;
//import com.arm.mbed.cloud.sdk.internal.mds.api.EndpointsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

EndpointsApi apiInstance = new EndpointsApi();
String deviceId = "deviceId_example"; // String | A unique device ID for an endpoint. Note that the ID needs to be an exact match. You cannot use wildcards here. 
try {
    List<Resource> result = apiInstance.getEndpointResources(deviceId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling EndpointsApi#getEndpointResources");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **deviceId** | **String**| A unique device ID for an endpoint. Note that the ID needs to be an exact match. You cannot use wildcards here.  |

### Return type

[**List&lt;Resource&gt;**](Resource.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

