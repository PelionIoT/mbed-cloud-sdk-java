# SubscriptionsApi

All URIs are relative to *https://api.us-east-1.mbedcloud.com*

Method | HTTP request | Description
------------- | ------------- | -------------
[**addResourceSubscription**](SubscriptionsApi.md#addResourceSubscription) | **PUT** v2/subscriptions/{device-id}/{resourcePath} | Subscribe to a resource path
[**checkResourceSubscription**](SubscriptionsApi.md#checkResourceSubscription) | **GET** v2/subscriptions/{device-id}/{resourcePath} | Read subscription status
[**deleteEndpointSubscriptions**](SubscriptionsApi.md#deleteEndpointSubscriptions) | **DELETE** v2/subscriptions/{device-id} | Delete subscriptions from an endpoint
[**deletePreSubscriptions**](SubscriptionsApi.md#deletePreSubscriptions) | **DELETE** v2/subscriptions | Remove pre-subscriptions
[**deleteResourceSubscription**](SubscriptionsApi.md#deleteResourceSubscription) | **DELETE** v2/subscriptions/{device-id}/{resourcePath} | Remove a subscription
[**getEndpointSubscriptions**](SubscriptionsApi.md#getEndpointSubscriptions) | **GET** v2/subscriptions/{device-id} | Read endpoints subscriptions
[**getPreSubscriptions**](SubscriptionsApi.md#getPreSubscriptions) | **GET** v2/subscriptions | Get pre-subscriptions
[**updatePreSubscriptions**](SubscriptionsApi.md#updatePreSubscriptions) | **PUT** v2/subscriptions | Set pre-subscriptions


<a name="addResourceSubscription"></a>
# **addResourceSubscription**
> Void addResourceSubscription(deviceId, resourcePath)

Subscribe to a resource path

The Device Management Connect eventing model consists of observable resources.  This means that endpoints can deliver updated resource content, periodically or with a more sophisticated solution-dependent logic. The OMA LwM2M resource model including objects, object instances, resources and resource instances is also supported.  Applications can subscribe to objects, object instances or individual resources to make the device to provide value change notifications to Device Management Connect service. An application needs to call a &#x60;/notification/callback&#x60; method to get Device Management Connect to push notifications of the resource changes.  **Notification rules**  A web application can place dynamic observation rules for individual Object Instances and Resources to define when the device sends observations. More information in [Notification rules](/docs/current/connecting/resource-change-webapp.html).  All manual subscriptions are removed during a full device registration and applications need to re-subscribe at that point. To avoid this, you can use &#x60;/subscriptions&#x60; to set a pre-subscription.  **Example usage:**      curl -X PUT \\       https://api.us-east-1.mbedcloud.com/v2/subscriptions/{device-id}/{resourcePath} \\       -H &#39;authorization: Bearer {api-key}&#39; 

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.SubscriptionsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

SubscriptionsApi apiInstance = new SubscriptionsApi();
String deviceId = "deviceId_example"; // String | A unique Device Management device ID for the endpoint. Note that the ID must be an exact match. You cannot use wildcards here. 
String resourcePath = "resourcePath_example"; // String | The URL of the resource. 
try {
    Void result = apiInstance.addResourceSubscription(deviceId, resourcePath);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling SubscriptionsApi#addResourceSubscription");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **deviceId** | **String**| A unique Device Management device ID for the endpoint. Note that the ID must be an exact match. You cannot use wildcards here.  |
 **resourcePath** | **String**| The URL of the resource.  |

### Return type

[**Void**](.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="checkResourceSubscription"></a>
# **checkResourceSubscription**
> Void checkResourceSubscription(deviceId, resourcePath)

Read subscription status

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.SubscriptionsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

SubscriptionsApi apiInstance = new SubscriptionsApi();
String deviceId = "deviceId_example"; // String | A unique Device Management device ID for the endpoint. Note that the ID must be an exact match. You cannot use wildcards here. 
String resourcePath = "resourcePath_example"; // String | The URL of the resource. 
try {
    Void result = apiInstance.checkResourceSubscription(deviceId, resourcePath);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling SubscriptionsApi#checkResourceSubscription");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **deviceId** | **String**| A unique Device Management device ID for the endpoint. Note that the ID must be an exact match. You cannot use wildcards here.  |
 **resourcePath** | **String**| The URL of the resource.  |

### Return type

[**Void**](.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="deleteEndpointSubscriptions"></a>
# **deleteEndpointSubscriptions**
> Void deleteEndpointSubscriptions(deviceId)

Delete subscriptions from an endpoint

Deletes all resource subscriptions in a single endpoint.  **Example usage:**      curl -X DELETE \\       https://api.us-east-1.mbedcloud.com/v2/subscriptions/{device-id} \\       -H &#39;authorization: Bearer {api-key}&#39; 

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.SubscriptionsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

SubscriptionsApi apiInstance = new SubscriptionsApi();
String deviceId = "deviceId_example"; // String | A unique Device Management device ID for the endpoint. Note that the ID must be an exact match. You cannot use wildcards here. 
try {
    Void result = apiInstance.deleteEndpointSubscriptions(deviceId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling SubscriptionsApi#deleteEndpointSubscriptions");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **deviceId** | **String**| A unique Device Management device ID for the endpoint. Note that the ID must be an exact match. You cannot use wildcards here.  |

### Return type

[**Void**](.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="deletePreSubscriptions"></a>
# **deletePreSubscriptions**
> Void deletePreSubscriptions()

Remove pre-subscriptions

Removes pre-subscriptions.  **Example usage:**      curl -X DELETE https://api.us-east-1.mbedcloud.com/v2/subscriptions -H &#39;authorization: Bearer {api-key}&#39; 

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.SubscriptionsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

SubscriptionsApi apiInstance = new SubscriptionsApi();
try {
    Void result = apiInstance.deletePreSubscriptions();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling SubscriptionsApi#deletePreSubscriptions");
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

<a name="deleteResourceSubscription"></a>
# **deleteResourceSubscription**
> Void deleteResourceSubscription(deviceId, resourcePath)

Remove a subscription

To remove an existing subscription from a resource path.  **Example usage:**      curl -X DELETE \\       https://api.us-east-1.mbedcloud.com/v2/subscriptions/{device-id}/{resourcePath} \\       -H &#39;authorization: Bearer {api-key}&#39; 

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.SubscriptionsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

SubscriptionsApi apiInstance = new SubscriptionsApi();
String deviceId = "deviceId_example"; // String | A unique Device Management device ID for the endpoint. Note that the ID must be an exact match. You cannot use wildcards here. 
String resourcePath = "resourcePath_example"; // String | The URL of the resource. 
try {
    Void result = apiInstance.deleteResourceSubscription(deviceId, resourcePath);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling SubscriptionsApi#deleteResourceSubscription");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **deviceId** | **String**| A unique Device Management device ID for the endpoint. Note that the ID must be an exact match. You cannot use wildcards here.  |
 **resourcePath** | **String**| The URL of the resource.  |

### Return type

[**Void**](.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getEndpointSubscriptions"></a>
# **getEndpointSubscriptions**
> String getEndpointSubscriptions(deviceId)

Read endpoints subscriptions

Lists all subscribed resources from a single endpoint.  **Example usage:**      curl -X GET \\       https://api.us-east-1.mbedcloud.com/v2/subscriptions/{device-id} \\       -H &#39;authorization: Bearer {api-key}&#39; 

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.SubscriptionsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

SubscriptionsApi apiInstance = new SubscriptionsApi();
String deviceId = "deviceId_example"; // String | A unique Device Management device ID for the endpoint. Note that ID must be an exact match. You cannot use wildcards here. 
try {
    String result = apiInstance.getEndpointSubscriptions(deviceId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling SubscriptionsApi#getEndpointSubscriptions");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **deviceId** | **String**| A unique Device Management device ID for the endpoint. Note that ID must be an exact match. You cannot use wildcards here.  |

### Return type

**String**

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: text/uri-list

<a name="getPreSubscriptions"></a>
# **getPreSubscriptions**
> PresubscriptionArray getPreSubscriptions()

Get pre-subscriptions

You can retrieve the pre-subscription data with the GET operation. The server returns with the same JSON structure as described above. If there are no pre-subscribed resources, it returns with an empty array.  **Example usage:**      curl -X GET https://api.us-east-1.mbedcloud.com/v2/subscriptions -H &#39;authorization: Bearer {api-key}&#39; 

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.SubscriptionsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

SubscriptionsApi apiInstance = new SubscriptionsApi();
try {
    PresubscriptionArray result = apiInstance.getPreSubscriptions();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling SubscriptionsApi#getPreSubscriptions");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**PresubscriptionArray**](PresubscriptionArray.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="updatePreSubscriptions"></a>
# **updatePreSubscriptions**
> Void updatePreSubscriptions(presubsription)

Set pre-subscriptions

Pre-subscription is a set of rules and patterns put by the application. When an endpoint registers and its ID, type and registered resources match the pre-subscription data, Device Management Connect sends subscription requests to the device automatically. The pattern may include the endpoint ID (optionally having an &#x60;*&#x60; character at the end), endpoint type, a list of resources or expressions with an &#x60;*&#x60; character at the end. Subscriptions based on pre-subscriptions are done when device registers or does register update. To remove the pre-subscription data, put an empty array as a rule.  **Notification rules**  A web application can place dynamic observation rules for individual Object Instances and Resources to define when the device sends observations. More information in [Notification rules](/docs/current/connecting/resource-change-webapp.html).  **Limits**:  - The maximum length of the endpoint name and endpoint type is 64 characters. - The maximum length of the resource path is 128 characters. - You can listen to 256 separate resource paths. - The maximum number of pre-subscription entries is 1024.  **Example request:**  &#x60;&#x60;&#x60; curl -X PUT \\   https://api.us-east-1.mbedcloud.com/v2/subscriptions \\   -H &#39;authorization: Bearer {api-key}&#39; \\   -H &#39;content-type: application/json&#39; \\   -d &#39;[          {            \&quot;endpoint-name\&quot;: \&quot;node-001\&quot;,            \&quot;resource-path\&quot;: [\&quot;/dev\&quot;]          },          {            \&quot;endpoint-type\&quot;: \&quot;Light\&quot;,            \&quot;resource-path\&quot;: [\&quot;/sen/_*\&quot;]          },          {            \&quot;endpoint-name\&quot;: \&quot;node*\&quot;          },          {            \&quot;endpoint-type\&quot;: \&quot;Sensor\&quot;          },          {            \&quot;resource-path\&quot;: [\&quot;/dev/temp\&quot;,\&quot;/dev/hum\&quot;]          }       ]&#39; &#x60;&#x60;&#x60;  - Subscribe to &#x60;/dev&#x60; resource of endpoint named &#x60;node-001&#x60;. - Subscribe to &#x60;Light&#x60; type of endpoints and their resources prefixed with &#x60;/sen/&#x60;. - Subscribe to all observable resources of endpoint names prefixed with &#x60;node&#x60;. - Subscribe to all observable resources of &#x60;Sensor&#x60; type endpoints. - Subscribe to &#x60;/dev/temp&#x60; and &#x60;/dev/hum&#x60; resources of all endpoints.  **Note**: For efficiency reasons, you should use resource path patterns in the pre-subscription data. This prevents the notification flow from unwanted resources. 

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.SubscriptionsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

SubscriptionsApi apiInstance = new SubscriptionsApi();
PresubscriptionArray presubsription = new PresubscriptionArray(); // PresubscriptionArray | Array of pre-subscriptions.
try {
    Void result = apiInstance.updatePreSubscriptions(presubsription);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling SubscriptionsApi#updatePreSubscriptions");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **presubsription** | [**PresubscriptionArray**](PresubscriptionArray.md)| Array of pre-subscriptions. |

### Return type

[**Void**](.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: text/plain

