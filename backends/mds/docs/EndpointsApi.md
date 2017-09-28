# EndpointsApi

All URIs are relative to *https://api.us-east-1.mbedcloud.com*

Method | HTTP request | Description
------------- | ------------- | -------------
[**v2EndpointsDeviceIdGet**](EndpointsApi.md#v2EndpointsDeviceIdGet) | **GET** v2/endpoints/{device-id} | List the resources on an endpoint
[**v2EndpointsGet**](EndpointsApi.md#v2EndpointsGet) | **GET** v2/endpoints | (DEPRECATED) List registered endpoints. The number of returned endpoints is currently limited to 200.


<a name="v2EndpointsDeviceIdGet"></a>
# **v2EndpointsDeviceIdGet**
> List&lt;Resource&gt; v2EndpointsDeviceIdGet(deviceId)

List the resources on an endpoint

The list of resources is cached by mbed Cloud Connect, so this call does not create a message to the device.  **Example usage:**      curl -X GET https://api.us-east-1.mbedcloud.com/v2/endpoints/{device-id} -H &#39;authorization: Bearer {api-key}&#39;      

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.internal.ApiClient;
//import com.arm.mbed.cloud.sdk.internal.ApiException;
//import com.arm.mbed.cloud.sdk.internal.Configuration;
//import com.arm.mbed.cloud.sdk.internal.auth.*;
//import com.arm.mbed.cloud.sdk.internal.mds.api.EndpointsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

EndpointsApi apiInstance = new EndpointsApi();
String deviceId = "deviceId_example"; // String | A unique mbed Cloud device ID for an endpoint. Note that the ID needs to be an exact match. You cannot use wildcards here. 
try {
    List<Resource> result = apiInstance.v2EndpointsDeviceIdGet(deviceId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling EndpointsApi#v2EndpointsDeviceIdGet");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **deviceId** | **String**| A unique mbed Cloud device ID for an endpoint. Note that the ID needs to be an exact match. You cannot use wildcards here.  |

### Return type

[**List&lt;Resource&gt;**](Resource.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json, application/link-format

<a name="v2EndpointsGet"></a>
# **v2EndpointsGet**
> List&lt;Endpoint&gt; v2EndpointsGet(type)

(DEPRECATED) List registered endpoints. The number of returned endpoints is currently limited to 200.

Endpoints are physical devices having valid registration to mbed Cloud Connect. All devices regardless of registration status can be requested from Device Directory API [&#39;/v3/devices/&#x60;](/docs/v1.2/api-references/device-directory-api.html#v3-devices).  **Note:** This endpoint is deprecated and will be removed 1Q/18. You should use the Device Directory API [&#x60;/v3/devices/&#x60;](/docs/v1.2/api-references/device-directory-api.html#v3-devices). To list only the registered devices, use filter &#x60;/v3/devices/?filter&#x3D;state%3Dregistered&#x60;.  **Example usage:**      curl -X GET https://api.us-east-1.mbedcloud.com/v2/endpoints -H &#39;authorization: Bearer {api-key}&#39;      

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.internal.ApiClient;
//import com.arm.mbed.cloud.sdk.internal.ApiException;
//import com.arm.mbed.cloud.sdk.internal.Configuration;
//import com.arm.mbed.cloud.sdk.internal.auth.*;
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
    List<Endpoint> result = apiInstance.v2EndpointsGet(type);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling EndpointsApi#v2EndpointsGet");
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
 - **Accept**: application/json, application/link-format

