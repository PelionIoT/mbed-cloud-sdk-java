# DefaultApi

All URIs are relative to *https://api.us-east-1.mbedcloud.com*

Method | HTTP request | Description
------------- | ------------- | -------------
[**downloadAgreement**](DefaultApi.md#downloadAgreement) | **GET** downloads/agreements/{agreement-id} | Download agreement as a document.
[**headDownloads**](DefaultApi.md#headDownloads) | **HEAD** downloads/agreements | The heartbeat method for this API.
[**isAlive**](DefaultApi.md#isAlive) | **GET** alive | Get alive status


<a name="downloadAgreement"></a>
# **downloadAgreement**
> Void downloadAgreement(agreementId)

Download agreement as a document.

Endpoint for download limits by account ID.

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.internal.ApiClient;
//import com.arm.mbed.cloud.sdk.internal.ApiException;
//import com.arm.mbed.cloud.sdk.internal.Configuration;
//import com.arm.mbed.cloud.sdk.internal.auth.*;
//import com.arm.mbed.cloud.sdk.internal.iam.api.DefaultApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

DefaultApi apiInstance = new DefaultApi();
String agreementId = "agreementId_example"; // String | The ID of the agreement to be returned.
try {
    Void result = apiInstance.downloadAgreement(agreementId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#downloadAgreement");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **agreementId** | **String**| The ID of the agreement to be returned. |

### Return type

[**Void**](.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="headDownloads"></a>
# **headDownloads**
> Void headDownloads()

The heartbeat method for this API.



### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.internal.ApiClient;
//import com.arm.mbed.cloud.sdk.internal.ApiException;
//import com.arm.mbed.cloud.sdk.internal.Configuration;
//import com.arm.mbed.cloud.sdk.internal.auth.*;
//import com.arm.mbed.cloud.sdk.internal.iam.api.DefaultApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

DefaultApi apiInstance = new DefaultApi();
try {
    Void result = apiInstance.headDownloads();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#headDownloads");
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

<a name="isAlive"></a>
# **isAlive**
> Void isAlive(deepalive)

Get alive status



### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.internal.ApiClient;
//import com.arm.mbed.cloud.sdk.internal.ApiException;
//import com.arm.mbed.cloud.sdk.internal.Configuration;
//import com.arm.mbed.cloud.sdk.internal.auth.*;
//import com.arm.mbed.cloud.sdk.internal.iam.api.DefaultApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

DefaultApi apiInstance = new DefaultApi();
Boolean deepalive = true; // Boolean | An optional parameter for getting deep aliveness. Must be true or false.
try {
    Void result = apiInstance.isAlive(deepalive);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#isAlive");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **deepalive** | **Boolean**| An optional parameter for getting deep aliveness. Must be true or false. | [optional]

### Return type

[**Void**](.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

