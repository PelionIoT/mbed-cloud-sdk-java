# PreSharedKeysApi

All URIs are relative to *https://api.us-east-1.mbedcloud.com*

Method | HTTP request | Description
------------- | ------------- | -------------
[**deletePreSharedKey**](PreSharedKeysApi.md#deletePreSharedKey) | **DELETE** v2/device-shared-keys/{endpoint_name} | Remove a pre-shared key.
[**getPreSharedKey**](PreSharedKeysApi.md#getPreSharedKey) | **GET** v2/device-shared-keys/{endpoint_name} | Get a pre-shared key.
[**listPreSharedKeys**](PreSharedKeysApi.md#listPreSharedKeys) | **GET** v2/device-shared-keys | List pre-shared keys.
[**uploadPreSharedKey**](PreSharedKeysApi.md#uploadPreSharedKey) | **POST** v2/device-shared-keys | Upload a pre-shared key to Pelion Device Management.


<a name="deletePreSharedKey"></a>
# **deletePreSharedKey**
> Void deletePreSharedKey(endpointName)

Remove a pre-shared key.

Remove a pre-shared key.  **Example usage:**  &#x60;&#x60;&#x60; curl -H \&quot;authorization: Bearer ${API_TOKEN}\&quot; -X DELETE https://api.us-east-1.mbedcloud.com/v2/device-shared-keys/my-endpoint-0001 &#x60;&#x60;&#x60; 

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.internal.connectorbootstrap.ApiClient;
//import com.arm.mbed.cloud.sdk.internal.connectorbootstrap.ApiException;
//import com.arm.mbed.cloud.sdk.internal.connectorbootstrap.Configuration;
//import com.arm.mbed.cloud.sdk.internal.connectorbootstrap.auth.*;
//import com.arm.mbed.cloud.sdk.internal.connectorbootstrap.api.PreSharedKeysApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

PreSharedKeysApi apiInstance = new PreSharedKeysApi();
String endpointName = "endpointName_example"; // String | The unique endpoint identifier that this pre-shared key applies to. [Reserved characters](https://en.wikipedia.org/wiki/Percent-encoding#Percent-encoding_reserved_characters) must be percent-encoded.
try {
    Void result = apiInstance.deletePreSharedKey(endpointName);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling PreSharedKeysApi#deletePreSharedKey");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **endpointName** | **String**| The unique endpoint identifier that this pre-shared key applies to. [Reserved characters](https://en.wikipedia.org/wiki/Percent-encoding#Percent-encoding_reserved_characters) must be percent-encoded. |

### Return type

[**Void**](.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="getPreSharedKey"></a>
# **getPreSharedKey**
> PreSharedKeyWithoutSecret getPreSharedKey(endpointName)

Get a pre-shared key.

Check if a pre-shared key for an endpoint exists or not. The response does not contain the secret itself.  **Example usage:**  &#x60;&#x60;&#x60; curl -H \&quot;authorization: Bearer ${API_TOKEN}\&quot; https://api.us-east-1.mbedcloud.com/v2/device-shared-keys/my-endpoint-0001 &#x60;&#x60;&#x60; 

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.internal.connectorbootstrap.ApiClient;
//import com.arm.mbed.cloud.sdk.internal.connectorbootstrap.ApiException;
//import com.arm.mbed.cloud.sdk.internal.connectorbootstrap.Configuration;
//import com.arm.mbed.cloud.sdk.internal.connectorbootstrap.auth.*;
//import com.arm.mbed.cloud.sdk.internal.connectorbootstrap.api.PreSharedKeysApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

PreSharedKeysApi apiInstance = new PreSharedKeysApi();
String endpointName = "endpointName_example"; // String | The unique endpoint identifier that this pre-shared key applies to. [Reserved characters](https://en.wikipedia.org/wiki/Percent-encoding#Percent-encoding_reserved_characters) must be percent-encoded.
try {
    PreSharedKeyWithoutSecret result = apiInstance.getPreSharedKey(endpointName);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling PreSharedKeysApi#getPreSharedKey");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **endpointName** | **String**| The unique endpoint identifier that this pre-shared key applies to. [Reserved characters](https://en.wikipedia.org/wiki/Percent-encoding#Percent-encoding_reserved_characters) must be percent-encoded. |

### Return type

[**PreSharedKeyWithoutSecret**](PreSharedKeyWithoutSecret.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="listPreSharedKeys"></a>
# **listPreSharedKeys**
> ListOfPreSharedKeysWithoutSecret listPreSharedKeys(limit, after)

List pre-shared keys.

List pre-shared keys with pagination and default page size of 50 entries.  **Example usage:**  &#x60;&#x60;&#x60; curl -H \&quot;authorization: Bearer ${API_TOKEN}\&quot; https://api.us-east-1.mbedcloud.com/v2/device-shared-keys &#x60;&#x60;&#x60; 

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.internal.connectorbootstrap.ApiClient;
//import com.arm.mbed.cloud.sdk.internal.connectorbootstrap.ApiException;
//import com.arm.mbed.cloud.sdk.internal.connectorbootstrap.Configuration;
//import com.arm.mbed.cloud.sdk.internal.connectorbootstrap.auth.*;
//import com.arm.mbed.cloud.sdk.internal.connectorbootstrap.api.PreSharedKeysApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

PreSharedKeysApi apiInstance = new PreSharedKeysApi();
Integer limit = 56; // Integer | The number of entries per page
String after = "after_example"; // String | An offset token for fetching a specific page. Provided by the server.
try {
    ListOfPreSharedKeysWithoutSecret result = apiInstance.listPreSharedKeys(limit, after);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling PreSharedKeysApi#listPreSharedKeys");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **limit** | **Integer**| The number of entries per page | [optional]
 **after** | **String**| An offset token for fetching a specific page. Provided by the server. | [optional]

### Return type

[**ListOfPreSharedKeysWithoutSecret**](ListOfPreSharedKeysWithoutSecret.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="uploadPreSharedKey"></a>
# **uploadPreSharedKey**
> Void uploadPreSharedKey(body)

Upload a pre-shared key to Pelion Device Management.

Upload a pre-shared key (PSK) for an endpoint to allow it to bootstrap. The existing key will not be overwritten but needs to be deleted first in case of re-setting PSK for an endpoint.  **Note**: The PSK APIs are available only to accounts that have this feature enabled.  **Example usage:**  &#x60;&#x60;&#x60; curl -H \&quot;authorization: Bearer ${API_TOKEN}\&quot; -H \&quot;content-type: application/json\&quot; -X POST https://api.us-east-1.mbedcloud.com/v2/device-shared-keys \\      -d &#39;{\&quot;endpoint_name\&quot;: \&quot;my-endpoint-0001\&quot;, \&quot;secret_hex\&quot;: \&quot;4a4a4a4a4a4a4a4a4a4a4a4a4a4a4a4a\&quot; }&#39; &#x60;&#x60;&#x60; 

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.internal.connectorbootstrap.ApiClient;
//import com.arm.mbed.cloud.sdk.internal.connectorbootstrap.ApiException;
//import com.arm.mbed.cloud.sdk.internal.connectorbootstrap.Configuration;
//import com.arm.mbed.cloud.sdk.internal.connectorbootstrap.auth.*;
//import com.arm.mbed.cloud.sdk.internal.connectorbootstrap.api.PreSharedKeysApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

PreSharedKeysApi apiInstance = new PreSharedKeysApi();
PreSharedKey body = new PreSharedKey(); // PreSharedKey | Pre-shared key to be uploaded.
try {
    Void result = apiInstance.uploadPreSharedKey(body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling PreSharedKeysApi#uploadPreSharedKey");
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

