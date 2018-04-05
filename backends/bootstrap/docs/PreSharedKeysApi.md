# PreSharedKeysApi

All URIs are relative to *https://api.us-east-1.mbedcloud.com*

Method | HTTP request | Description
------------- | ------------- | -------------
[**deleteAPreSharedKey**](PreSharedKeysApi.md#deleteAPreSharedKey) | **DELETE** v2/device-shared-keys/{endpoint_name} | Remove a pre-shared key.
[**getAPreSharedKey**](PreSharedKeysApi.md#getAPreSharedKey) | **GET** v2/device-shared-keys/{endpoint_name} | Get a pre-shared key.
[**uploadAPreSharedKey**](PreSharedKeysApi.md#uploadAPreSharedKey) | **POST** v2/device-shared-keys | Upload a pre-shared key to Mbed Cloud.


<a name="deleteAPreSharedKey"></a>
# **deleteAPreSharedKey**
> Void deleteAPreSharedKey(endpointName)

Remove a pre-shared key.

Remove a pre-shared key.

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.internal.bootstrap.ApiClient;
//import com.arm.mbed.cloud.sdk.internal.bootstrap.ApiException;
//import com.arm.mbed.cloud.sdk.internal.bootstrap.Configuration;
//import com.arm.mbed.cloud.sdk.internal.bootstrap.auth.*;
//import com.arm.mbed.cloud.sdk.internal.bootstrap.api.PreSharedKeysApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

PreSharedKeysApi apiInstance = new PreSharedKeysApi();
String endpointName = "endpointName_example"; // String | The endpoint name. A unique identifier of the pre-shared key. [Reserved characters](https://en.wikipedia.org/wiki/Percent-encoding#Percent-encoding_reserved_characters) must be percent-encoded.
try {
    Void result = apiInstance.deleteAPreSharedKey(endpointName);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling PreSharedKeysApi#deleteAPreSharedKey");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **endpointName** | **String**| The endpoint name. A unique identifier of the pre-shared key. [Reserved characters](https://en.wikipedia.org/wiki/Percent-encoding#Percent-encoding_reserved_characters) must be percent-encoded. |

### Return type

[**Void**](.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="getAPreSharedKey"></a>
# **getAPreSharedKey**
> PreSharedKeyWithoutSecret getAPreSharedKey(endpointName)

Get a pre-shared key.

Check if a pre-shared key for an endpoint exists or not. The response does not contain the secret itself. 

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.internal.bootstrap.ApiClient;
//import com.arm.mbed.cloud.sdk.internal.bootstrap.ApiException;
//import com.arm.mbed.cloud.sdk.internal.bootstrap.Configuration;
//import com.arm.mbed.cloud.sdk.internal.bootstrap.auth.*;
//import com.arm.mbed.cloud.sdk.internal.bootstrap.api.PreSharedKeysApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

PreSharedKeysApi apiInstance = new PreSharedKeysApi();
String endpointName = "endpointName_example"; // String | The endpoint name. A unique identifier of the pre-shared key. [Reserved characters](https://en.wikipedia.org/wiki/Percent-encoding#Percent-encoding_reserved_characters) must be percent-encoded.
try {
    PreSharedKeyWithoutSecret result = apiInstance.getAPreSharedKey(endpointName);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling PreSharedKeysApi#getAPreSharedKey");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **endpointName** | **String**| The endpoint name. A unique identifier of the pre-shared key. [Reserved characters](https://en.wikipedia.org/wiki/Percent-encoding#Percent-encoding_reserved_characters) must be percent-encoded. |

### Return type

[**PreSharedKeyWithoutSecret**](PreSharedKeyWithoutSecret.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="uploadAPreSharedKey"></a>
# **uploadAPreSharedKey**
> Void uploadAPreSharedKey(body)

Upload a pre-shared key to Mbed Cloud.

Upload a pre-shared key (PSK) for an endpoint to allow it to bootstrap. The existing key will not be overwritten but needs to be deleted first in case of re-setting PSK for an endpoint.  **Note**: The PSK APIs are available only to accounts that have this feature enabled.  &#x60;&#x60;&#x60; Example payloads: {\&quot;endpoint_name\&quot;: \&quot;myEndpoint\&quot;, \&quot;secret_hex\&quot;: \&quot;4a4a4a4a4a4a4a4a4a4a4a4a4a4a4a4a\&quot; } {\&quot;endpoint_name\&quot;: \&quot;myEndpoint\&quot;, \&quot;secret_hex\&quot;: \&quot;0x4a4a4a4a4a4a4a4a4a4a4a4a4a4a4a4a\&quot; } &#x60;&#x60;&#x60; 

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.internal.bootstrap.ApiClient;
//import com.arm.mbed.cloud.sdk.internal.bootstrap.ApiException;
//import com.arm.mbed.cloud.sdk.internal.bootstrap.Configuration;
//import com.arm.mbed.cloud.sdk.internal.bootstrap.auth.*;
//import com.arm.mbed.cloud.sdk.internal.bootstrap.api.PreSharedKeysApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

PreSharedKeysApi apiInstance = new PreSharedKeysApi();
PreSharedKey body = new PreSharedKey(); // PreSharedKey | Pre-shared key to be uploaded.
try {
    Void result = apiInstance.uploadAPreSharedKey(body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling PreSharedKeysApi#uploadAPreSharedKey");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**PreSharedKey**](PreSharedKey.md)| Pre-shared key to be uploaded. |

### Return type

[**Void**](.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

