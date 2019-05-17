# PreSharedKeysApi

All URIs are relative to *https://api.us-east-1.mbedcloud.com*

Method | HTTP request | Description
------------- | ------------- | -------------
[**deletePreSharedKey**](PreSharedKeysApi.md#deletePreSharedKey) | **DELETE** v2/device-shared-keys/{endpoint_name} | Remove a PSK.
[**getPreSharedKey**](PreSharedKeysApi.md#getPreSharedKey) | **GET** v2/device-shared-keys/{endpoint_name} | Get a PSK.
[**listPreSharedKeys**](PreSharedKeysApi.md#listPreSharedKeys) | **GET** v2/device-shared-keys | List PSKs.
[**uploadPreSharedKey**](PreSharedKeysApi.md#uploadPreSharedKey) | **POST** v2/device-shared-keys | Upload a PSK to Pelion Device Management.


<a name="deletePreSharedKey"></a>
# **deletePreSharedKey**
> Void deletePreSharedKey(endpointName)

Remove a PSK.

Remove a PSK.  **Example:**  &#x60;&#x60;&#x60; curl -X DELETE https://api.us-east-1.mbedcloud.com/v2/device-shared-keys/my-endpoint-0001 \\ -H \&quot;Authorization: Bearer &lt;api_key&gt;\&quot; &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.PreSharedKeysApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

PreSharedKeysApi apiInstance = new PreSharedKeysApi();
String endpointName = "endpointName_example"; // String | The unique endpoint identifier that this PSK applies to. [Reserved characters](https://en.wikipedia.org/wiki/Percent-encoding#Percent-encoding_reserved_characters) must be percent-encoded.
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
 **endpointName** | **String**| The unique endpoint identifier that this PSK applies to. [Reserved characters](https://en.wikipedia.org/wiki/Percent-encoding#Percent-encoding_reserved_characters) must be percent-encoded. |

### Return type

[**Void**](.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getPreSharedKey"></a>
# **getPreSharedKey**
> PreSharedKeyWithoutSecret getPreSharedKey(endpointName)

Get a PSK.

Check if a PSK for an endpoint exists or not. The response does not contain the secret itself.  **Example:**  &#x60;&#x60;&#x60; curl -X GET https://api.us-east-1.mbedcloud.com/v2/device-shared-keys/my-endpoint-0001 \\ -H \&quot;Authorization: Bearer &lt;api_key&gt;\&quot; &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.PreSharedKeysApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

PreSharedKeysApi apiInstance = new PreSharedKeysApi();
String endpointName = "endpointName_example"; // String | The unique endpoint identifier that this PSK applies to. [Reserved characters](https://en.wikipedia.org/wiki/Percent-encoding#Percent-encoding_reserved_characters) must be percent-encoded.
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
 **endpointName** | **String**| The unique endpoint identifier that this PSK applies to. [Reserved characters](https://en.wikipedia.org/wiki/Percent-encoding#Percent-encoding_reserved_characters) must be percent-encoded. |

### Return type

[**PreSharedKeyWithoutSecret**](PreSharedKeyWithoutSecret.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="listPreSharedKeys"></a>
# **listPreSharedKeys**
> ListOfPreSharedKeysWithoutSecret listPreSharedKeys(limit, after)

List PSKs.

Retrieve pre-shared keys (PSKs) with pagination. Default page size of 50 entries.  **Example:**  &#x60;&#x60;&#x60; curl -X GET https://api.us-east-1.mbedcloud.com/v2/device-shared-keys \\ -H \&quot;Authorization: Bearer &lt;api_key&gt;\&quot; &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.PreSharedKeysApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

PreSharedKeysApi apiInstance = new PreSharedKeysApi();
Integer limit = 56; // Integer | The number of entries per page.
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
 **limit** | **Integer**| The number of entries per page. | [optional]
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

Upload a PSK to Pelion Device Management.

Upload a PSK for an endpoint to allow it to bootstrap. The existing key cannot be overwritten, but needs to be deleted first in the case of re-setting a PSK for an endpoint.  **Note**: The PSK APIs are available only to accounts that have this feature enabled.  **Example:** &#x60;&#x60;&#x60; curl -X POST https://api.us-east-1.mbedcloud.com/v2/device-shared-keys \\ -H \&quot;Authorization: Bearer &lt;api_key&gt;\&quot; \\ -H \&quot;content-type: application/json\&quot;  \\      -d &#39;{ \&quot;endpoint_name\&quot;: \&quot;my-endpoint-0001\&quot;, \&quot;secret_hex\&quot;: \&quot;4a4a4a4a4a4a4a4a4a4a4a4a4a4a4a4a\&quot; }&#39; &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.PreSharedKeysApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

PreSharedKeysApi apiInstance = new PreSharedKeysApi();
PreSharedKey body = new PreSharedKey(); // PreSharedKey | PSK to upload.
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
 **body** | [**PreSharedKey**](PreSharedKey.md)| PSK to upload. |

### Return type

[**Void**](.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

