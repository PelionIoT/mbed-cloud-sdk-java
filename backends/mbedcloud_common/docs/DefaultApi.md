# DefaultApi

All URIs are relative to *https://api.us-east-1.mbedcloud.com*

Method | HTTP request | Description
------------- | ------------- | -------------
[**test**](DefaultApi.md#test) | **GET**  | 


<a name="test"></a>
# **test**
> Void test()



### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.internal.mbedcloudcommon.ApiClient;
//import com.arm.mbed.cloud.sdk.internal.mbedcloudcommon.ApiException;
//import com.arm.mbed.cloud.sdk.internal.mbedcloudcommon.Configuration;
//import com.arm.mbed.cloud.sdk.internal.mbedcloudcommon.auth.*;
//import com.arm.mbed.cloud.sdk.internal.mbedcloudcommon.api.DefaultApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

DefaultApi apiInstance = new DefaultApi();
try {
    Void result = apiInstance.test();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#test");
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

