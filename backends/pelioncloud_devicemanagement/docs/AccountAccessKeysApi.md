# AccountAccessKeysApi

All URIs are relative to *https://api.us-east-1.mbedcloud.com*

Method | HTTP request | Description
------------- | ------------- | -------------
[**getAccessKey**](AccountAccessKeysApi.md#getAccessKey) | **GET** v3/access-keys/{access_key_id} | Get access key.
[**getAllAccessKeys**](AccountAccessKeysApi.md#getAllAccessKeys) | **GET** v3/access-keys | Get all access keys.


<a name="getAccessKey"></a>
# **getAccessKey**
> AccessKey getAccessKey(accessKeyId)

Get access key.

Retrieve details of an access key. &lt;b&gt;Note:&lt;/b&gt; This endpoint is restricted to administrators.  **Example:** &#x60;&#x60;&#x60; curl -X GET https://api.us-east-1.mbedcloud.com/v3/access-keys/{access_key_id} \\ -H &#39;Authorization: Bearer &lt;access_key&gt;&#39; &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.AccountAccessKeysApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

AccountAccessKeysApi apiInstance = new AccountAccessKeysApi();
String accessKeyId = "accessKeyId_example"; // String | The ID of the access key to retrieve.
try {
    AccessKey result = apiInstance.getAccessKey(accessKeyId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AccountAccessKeysApi#getAccessKey");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **accessKeyId** | **String**| The ID of the access key to retrieve. |

### Return type

[**AccessKey**](AccessKey.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getAllAccessKeys"></a>
# **getAllAccessKeys**
> AccessKeyList getAllAccessKeys(limit, after, order, include, statusEq, applicationIdEq)

Get all access keys.

Retrieve an array of access keys. &lt;b&gt;Note:&lt;/b&gt; This endpoint is restricted to administrators.  **Example:** &#x60;&#x60;&#x60; curl -X GET https://api.us-east-1.mbedcloud.com/v3/access-keys \\ -H &#39;Authorization: Bearer &lt;access_key&gt;&#39; &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.AccountAccessKeysApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

AccountAccessKeysApi apiInstance = new AccountAccessKeysApi();
Integer limit = 50; // Integer | The number of results to return (2-1000). Default 50.
String after = "after_example"; // String | The entity ID to retrieve after the given one.
String order = "ASC"; // String | Record order based on creation. Acceptable values: ASC, DESC. Default: ASC.
String include = "include_example"; // String | Comma-separated additional data to return. Currently supported: total_count.
String statusEq = "statusEq_example"; // String | Status filter.
String applicationIdEq = "applicationIdEq_example"; // String | Application filter.
try {
    AccessKeyList result = apiInstance.getAllAccessKeys(limit, after, order, include, statusEq, applicationIdEq);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AccountAccessKeysApi#getAllAccessKeys");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **limit** | **Integer**| The number of results to return (2-1000). Default 50. | [optional] [default to 50]
 **after** | **String**| The entity ID to retrieve after the given one. | [optional]
 **order** | **String**| Record order based on creation. Acceptable values: ASC, DESC. Default: ASC. | [optional] [default to ASC]
 **include** | **String**| Comma-separated additional data to return. Currently supported: total_count. | [optional]
 **statusEq** | **String**| Status filter. | [optional]
 **applicationIdEq** | **String**| Application filter. | [optional]

### Return type

[**AccessKeyList**](AccessKeyList.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

