# EndpointsApi

All URIs are relative to *https://api.us-east-1.mbedcloud.com*

Method | HTTP request | Description
------------- | ------------- | -------------
[**getEndpointResources**](EndpointsApi.md#getEndpointResources) | **GET** v2/endpoints/{device-id} | List the resources on an endpoint.


<a name="getEndpointResources"></a>
# **getEndpointResources**
> List&lt;Resource&gt; getEndpointResources(deviceId)

List the resources on an endpoint.

Retrieves resources cached by Device Management Connect. This call does not formulate a message to the device.  **Example:** &#x60;&#x60;&#x60; curl -X GET https://api.us-east-1.mbedcloud.com/v2/endpoints/{device-id} \\ -H &#39;Authorization: Bearer &lt;api_key&gt;&#39; &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.EndpointsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

EndpointsApi apiInstance = new EndpointsApi();
String deviceId = "deviceId_example"; // String | A unique device ID for an endpoint. The ID must be an exact match. Do not use wildcards.
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
 **deviceId** | **String**| A unique device ID for an endpoint. The ID must be an exact match. Do not use wildcards. |

### Return type

[**List&lt;Resource&gt;**](Resource.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

