# ResourcesApi

All URIs are relative to *https://api.us-east-1.mbedcloud.com*

Method | HTTP request | Description
------------- | ------------- | -------------
[**v2EndpointsDeviceIdResourcePathDelete**](ResourcesApi.md#v2EndpointsDeviceIdResourcePathDelete) | **DELETE** v2/endpoints/{device-id}/{resourcePath} | Delete a resource
[**v2EndpointsDeviceIdResourcePathGet**](ResourcesApi.md#v2EndpointsDeviceIdResourcePathGet) | **GET** v2/endpoints/{device-id}/{resourcePath} | Read from a resource
[**v2EndpointsDeviceIdResourcePathPost**](ResourcesApi.md#v2EndpointsDeviceIdResourcePathPost) | **POST** v2/endpoints/{device-id}/{resourcePath} | Execute a function on a Resource or create new Object instance
[**v2EndpointsDeviceIdResourcePathPut**](ResourcesApi.md#v2EndpointsDeviceIdResourcePathPut) | **PUT** v2/endpoints/{device-id}/{resourcePath} | Write to a resource or use write-attributes for a resource


<a name="v2EndpointsDeviceIdResourcePathDelete"></a>
# **v2EndpointsDeviceIdResourcePathDelete**
> AsyncID v2EndpointsDeviceIdResourcePathDelete(deviceId, resourcePath, noResp)

Delete a resource

A request to delete a resource must be handled by both Mbed Cloud Client and Mbed Cloud Connect. The resource is not deleted from Mbed Cloud Connect until the request is handled by Mbed Cloud Client.  All resource APIs are asynchronous. These APIs respond only if the device is turned on and connected to Mbed Cloud Connect and there is an active notification channel.  **Example usage:**      curl -X DELETE \\       https://api.us-east-1.mbedcloud.com/v2/endpoints/{device-id}/{resourcePath} \\       -H &#39;authorization: Bearer {api-key}&#39; 

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.internal.ApiClient;
//import com.arm.mbed.cloud.sdk.internal.ApiException;
//import com.arm.mbed.cloud.sdk.internal.Configuration;
//import com.arm.mbed.cloud.sdk.internal.auth.*;
//import com.arm.mbed.cloud.sdk.internal.mds.api.ResourcesApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

ResourcesApi apiInstance = new ResourcesApi();
String deviceId = "deviceId_example"; // String | A unique Mbed Cloud device ID for the endpoint. Note that the ID must be an exact match. You cannot use wildcards here. 
String resourcePath = "resourcePath_example"; // String | The URL of the resource. 
Boolean noResp = true; // Boolean | <br/><br/><b>Non-confirmable requests</b><br/>  All resource APIs have the parameter noResp. If you make a request with `noResp=true`, Mbed Cloud Connect makes a CoAP non-confirmable request to the device. Such requests are not guaranteed to arrive in the device, and you do not get back an async-response-id.  If calls with this parameter enabled succeed, they return with the status code `204 No Content`. If the underlying protocol does not support non-confirmable requests, or if the endpoint is registered in queue mode, the response is status code `409 Conflict`. 
try {
    AsyncID result = apiInstance.v2EndpointsDeviceIdResourcePathDelete(deviceId, resourcePath, noResp);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ResourcesApi#v2EndpointsDeviceIdResourcePathDelete");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **deviceId** | **String**| A unique Mbed Cloud device ID for the endpoint. Note that the ID must be an exact match. You cannot use wildcards here.  |
 **resourcePath** | **String**| The URL of the resource.  |
 **noResp** | **Boolean**| &lt;br/&gt;&lt;br/&gt;&lt;b&gt;Non-confirmable requests&lt;/b&gt;&lt;br/&gt;  All resource APIs have the parameter noResp. If you make a request with &#x60;noResp&#x3D;true&#x60;, Mbed Cloud Connect makes a CoAP non-confirmable request to the device. Such requests are not guaranteed to arrive in the device, and you do not get back an async-response-id.  If calls with this parameter enabled succeed, they return with the status code &#x60;204 No Content&#x60;. If the underlying protocol does not support non-confirmable requests, or if the endpoint is registered in queue mode, the response is status code &#x60;409 Conflict&#x60;.  | [optional]

### Return type

[**AsyncID**](AsyncID.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="v2EndpointsDeviceIdResourcePathGet"></a>
# **v2EndpointsDeviceIdResourcePathGet**
> Void v2EndpointsDeviceIdResourcePathGet(deviceId, resourcePath, cacheOnly, noResp)

Read from a resource

Requests the resource value and when the response is available, an &#x60;AsyncIDResponse&#x60; json object is received in the notification channel. The preferred way to get resource values is to use [subscribe](/docs/v1.2/service-api-references/connect-api.html#v2-notification-callback) and [callback](/docs/v1.2/service-api-references/connect-api.html#v2-notification-callback) methods. See more about [reading from a resource](/docs/v1.2/collecting/handling-resources-from-a-web-application.html#the-read-operation).  All resource APIs are asynchronous. These APIs only respond if the device is turned on and connected to Mbed Cloud Connect.  Please refer to [Lightweigth Machine to Machine Technical specification](http://www.openmobilealliance.org/release/LightweightM2M/V1_0-20170208-A/OMA-TS-LightweightM2M-V1_0-20170208-A.pdf) for more inforamtion.  **Example usage:**      curl -X GET \\       https://api.us-east-1.mbedcloud.com/v2/endpoints/{device-id}/{resourcePath} \\       -H &#39;authorization: Bearer {api-key}&#39;        

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.internal.ApiClient;
//import com.arm.mbed.cloud.sdk.internal.ApiException;
//import com.arm.mbed.cloud.sdk.internal.Configuration;
//import com.arm.mbed.cloud.sdk.internal.auth.*;
//import com.arm.mbed.cloud.sdk.internal.mds.api.ResourcesApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

ResourcesApi apiInstance = new ResourcesApi();
String deviceId = "deviceId_example"; // String | Unique Mbed Cloud device ID for the endpoint. Note that the ID needs to be an exact match. You cannot use wildcards here. 
String resourcePath = "resourcePath_example"; // String | The URL of the resource. 
Boolean cacheOnly = true; // Boolean | If true, the response comes only from the cache. Default: false. Mbed Cloud Connect caches the received resource values for the time of [max_age](/docs/v1.2/collecting/working-with-the-resources.html#working-with-the-server-cache) defined in the client side. 
Boolean noResp = true; // Boolean | <br/><br/><b>Non-confirmable requests</b><br/>  All resource APIs have the parameter `noResp`. If a request is made with `noResp=true`, Mbed Cloud Connect makes a CoAP  non-confirmable request to the device. Such requests are not guaranteed to arrive in the device, and you do not get back  an async-response-id.  If calls with this parameter enabled succeed, they return with the status code `204 No Content`. If the underlying protocol  does not support non-confirmable requests, or if the endpoint is registered in queue mode, the response is status code  `409 Conflict`. 
try {
    Void result = apiInstance.v2EndpointsDeviceIdResourcePathGet(deviceId, resourcePath, cacheOnly, noResp);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ResourcesApi#v2EndpointsDeviceIdResourcePathGet");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **deviceId** | **String**| Unique Mbed Cloud device ID for the endpoint. Note that the ID needs to be an exact match. You cannot use wildcards here.  |
 **resourcePath** | **String**| The URL of the resource.  |
 **cacheOnly** | **Boolean**| If true, the response comes only from the cache. Default: false. Mbed Cloud Connect caches the received resource values for the time of [max_age](/docs/v1.2/collecting/working-with-the-resources.html#working-with-the-server-cache) defined in the client side.  | [optional]
 **noResp** | **Boolean**| &lt;br/&gt;&lt;br/&gt;&lt;b&gt;Non-confirmable requests&lt;/b&gt;&lt;br/&gt;  All resource APIs have the parameter &#x60;noResp&#x60;. If a request is made with &#x60;noResp&#x3D;true&#x60;, Mbed Cloud Connect makes a CoAP  non-confirmable request to the device. Such requests are not guaranteed to arrive in the device, and you do not get back  an async-response-id.  If calls with this parameter enabled succeed, they return with the status code &#x60;204 No Content&#x60;. If the underlying protocol  does not support non-confirmable requests, or if the endpoint is registered in queue mode, the response is status code  &#x60;409 Conflict&#x60;.  | [optional]

### Return type

[**Void**](.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="v2EndpointsDeviceIdResourcePathPost"></a>
# **v2EndpointsDeviceIdResourcePathPost**
> AsyncID v2EndpointsDeviceIdResourcePathPost(deviceId, resourcePath, resourceFunction, noResp)

Execute a function on a Resource or create new Object instance

With this API, you can [execute a function](/docs/v1.2/collecting/handling-resources-from-a-web-application.html#the-execute-operation)  on an existing resource and create new Object instance to the device. The resource-path does not have to exist - it can be  created by the call. The maximum length of resource-path is 255 characters.  All resource APIs are asynchronous. These APIs respond only if the device is turned on and connected to Mbed Cloud Connect and there is an active notification channel.  **Example usage:**  This example resets the min and max values of the [temperature sensor](http://www.openmobilealliance.org/tech/profiles/lwm2m/3303.xml) instance 0 by executing the Resource 5605 &#39;Reset Min and Max Measured Values&#39;.          curl -X POST \\       https://api.us-east-1.mbedcloud.com/v2/endpoints/{device-id}/3303/0/5605 \\       -H &#39;authorization: Bearer {api-key}&#39; 

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.internal.ApiClient;
//import com.arm.mbed.cloud.sdk.internal.ApiException;
//import com.arm.mbed.cloud.sdk.internal.Configuration;
//import com.arm.mbed.cloud.sdk.internal.auth.*;
//import com.arm.mbed.cloud.sdk.internal.mds.api.ResourcesApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

ResourcesApi apiInstance = new ResourcesApi();
String deviceId = "deviceId_example"; // String | A unique Mbed Cloud device ID for the endpoint. Note that the ID must be an exact match. You cannot use wildcards here. 
String resourcePath = "resourcePath_example"; // String | The URL of the resource.
String resourceFunction = "resourceFunction_example"; // String | This value is not needed. Most of the time resources do not accept a function but they have their own functions predefined. You can use this to trigger them.  If a function is included, the body of this request is passed as a char* to the function in Mbed Cloud Client. 
Boolean noResp = true; // Boolean | <br/><br/><b>Non-confirmable requests</b><br/>  All resource APIs have the parameter noResp. If you make a request with `noResp=true`, Mbed Cloud Connect makes a CoAP non-confirmable request to the device. Such requests are not guaranteed to arrive in the device, and you do not get back an async-response-id.  If calls with this parameter enabled succeed, they return with the status code `204 No Content`. If the underlying protocol does not support non-confirmable requests, or if the endpoint is registered in queue mode, the response is status code `409 Conflict`. 
try {
    AsyncID result = apiInstance.v2EndpointsDeviceIdResourcePathPost(deviceId, resourcePath, resourceFunction, noResp);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ResourcesApi#v2EndpointsDeviceIdResourcePathPost");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **deviceId** | **String**| A unique Mbed Cloud device ID for the endpoint. Note that the ID must be an exact match. You cannot use wildcards here.  |
 **resourcePath** | **String**| The URL of the resource. |
 **resourceFunction** | **String**| This value is not needed. Most of the time resources do not accept a function but they have their own functions predefined. You can use this to trigger them.  If a function is included, the body of this request is passed as a char* to the function in Mbed Cloud Client.  | [optional]
 **noResp** | **Boolean**| &lt;br/&gt;&lt;br/&gt;&lt;b&gt;Non-confirmable requests&lt;/b&gt;&lt;br/&gt;  All resource APIs have the parameter noResp. If you make a request with &#x60;noResp&#x3D;true&#x60;, Mbed Cloud Connect makes a CoAP non-confirmable request to the device. Such requests are not guaranteed to arrive in the device, and you do not get back an async-response-id.  If calls with this parameter enabled succeed, they return with the status code &#x60;204 No Content&#x60;. If the underlying protocol does not support non-confirmable requests, or if the endpoint is registered in queue mode, the response is status code &#x60;409 Conflict&#x60;.  | [optional]

### Return type

[**AsyncID**](AsyncID.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: text/plain, application/xml, application/octet-stream, application/exi, application/json, application/link-format, application/senml+json, application/nanoservice-tlv, application/vnd.oma.lwm2m+text, application/vnd.oma.lwm2m+opaq, application/vnd.oma.lwm2m+tlvapplication/vnd.oma.lwm2m+json, 
 - **Accept**: Not defined

<a name="v2EndpointsDeviceIdResourcePathPut"></a>
# **v2EndpointsDeviceIdResourcePathPut**
> AsyncID v2EndpointsDeviceIdResourcePathPut(deviceId, resourcePath, resourceValue, noResp)

Write to a resource or use write-attributes for a resource

With this API, you can [write a new value to existing resources](/docs/v1.2/collecting/handling-resources-from-a-web-application.html#the-write-operation) or [use the write-attributes](/docs/v1.2/collecting/subscribing-to-resource-changes-from-a-web-application.html#notification-rules) for a resource.  This API can also be used to transfer files to the device. Mbed Cloud Connect LwM2M server implements the Option 1 from RFC7959. The maximum block size is 1024 bytes. The block size versus transferred file size is something to note in low quality networks. The customer application needs to know what type of file is transferred (for example txt) and the payload can be encrypted by the customer. The maximum size of payload is 1048576 bytes.  All resource APIs are asynchronous. These APIs respond only if the device is turned on and connected to Mbed Cloud Connect and there is an active notification channel.  **Example usage:**  This example sets the alarm on a buzzer. The command writes the [Buzzer](http://www.openmobilealliance.org/tech/profiles/lwm2m/3338.xml) instance 0, \&quot;On/Off\&quot; boolean resource to &#39;1&#39;.      curl -X PUT \\       https://api.us-east-1.mbedcloud.com/v2/endpoints/{device-id}/3338/0/5850 \\       -H &#39;authorization: Bearer {api-key}&#39; -d &#39;1&#39; 

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.internal.ApiClient;
//import com.arm.mbed.cloud.sdk.internal.ApiException;
//import com.arm.mbed.cloud.sdk.internal.Configuration;
//import com.arm.mbed.cloud.sdk.internal.auth.*;
//import com.arm.mbed.cloud.sdk.internal.mds.api.ResourcesApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

ResourcesApi apiInstance = new ResourcesApi();
String deviceId = "deviceId_example"; // String | A unique Mbed Cloud device ID for the endpoint. Note that the ID must be an exact match. You cannot use wildcards here. 
String resourcePath = "resourcePath_example"; // String | Resource URL.
String resourceValue = "resourceValue_example"; // String | The value to be set to the resource. 
Boolean noResp = true; // Boolean | <br/><br/><b>Non-confirmable requests</b><br/>  All resource APIs have the parameter noResp. If you make a request with `noResp=true`, Mbed Cloud Connect makes a CoAP non-confirmable request to the device. Such requests are not guaranteed to arrive in the device, and you do not get back an async-response-id.  If calls with this parameter enabled succeed, they return with the status code `204 No Content`. If the underlying protocol does not support non-confirmable requests, or if the endpoint is registered in queue mode, the response is status code `409 Conflict`. 
try {
    AsyncID result = apiInstance.v2EndpointsDeviceIdResourcePathPut(deviceId, resourcePath, resourceValue, noResp);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ResourcesApi#v2EndpointsDeviceIdResourcePathPut");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **deviceId** | **String**| A unique Mbed Cloud device ID for the endpoint. Note that the ID must be an exact match. You cannot use wildcards here.  |
 **resourcePath** | **String**| Resource URL. |
 **resourceValue** | **String**| The value to be set to the resource.  |
 **noResp** | **Boolean**| &lt;br/&gt;&lt;br/&gt;&lt;b&gt;Non-confirmable requests&lt;/b&gt;&lt;br/&gt;  All resource APIs have the parameter noResp. If you make a request with &#x60;noResp&#x3D;true&#x60;, Mbed Cloud Connect makes a CoAP non-confirmable request to the device. Such requests are not guaranteed to arrive in the device, and you do not get back an async-response-id.  If calls with this parameter enabled succeed, they return with the status code &#x60;204 No Content&#x60;. If the underlying protocol does not support non-confirmable requests, or if the endpoint is registered in queue mode, the response is status code &#x60;409 Conflict&#x60;.  | [optional]

### Return type

[**AsyncID**](AsyncID.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: text/plain, application/xml, application/octet-stream, application/exi, application/json, application/link-format, application/senml+json, application/nanoservice-tlv, application/vnd.oma.lwm2m+text, application/vnd.oma.lwm2m+opaq, application/vnd.oma.lwm2m+tlvapplication/vnd.oma.lwm2m+json, 
 - **Accept**: Not defined

