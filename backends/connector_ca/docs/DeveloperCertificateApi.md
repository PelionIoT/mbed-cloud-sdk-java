# DeveloperCertificateApi

All URIs are relative to *http://api.mbedcloud.com*

Method | HTTP request | Description
------------- | ------------- | -------------
[**v3DeveloperCertificatesIdGet**](DeveloperCertificateApi.md#v3DeveloperCertificatesIdGet) | **GET** v3/developer-certificates/{id} | Fetch an existing developer certificate to connect to the bootstrap server.
[**v3DeveloperCertificatesPost**](DeveloperCertificateApi.md#v3DeveloperCertificatesPost) | **POST** v3/developer-certificates | Create a new developer certificate to connect to the bootstrap server.


<a name="v3DeveloperCertificatesIdGet"></a>
# **v3DeveloperCertificatesIdGet**
> DeveloperCertificateResponseData v3DeveloperCertificatesIdGet(id, authorization)

Fetch an existing developer certificate to connect to the bootstrap server.

This REST API is intended to be used by customers to fetch an existing developer certificate (a certificate that can be flashed into multiple devices to connect to bootstrap server). 

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.internal.ApiClient;
//import com.arm.mbed.cloud.sdk.internal.ApiException;
//import com.arm.mbed.cloud.sdk.internal.Configuration;
//import com.arm.mbed.cloud.sdk.internal.auth.*;
//import com.arm.mbed.cloud.sdk.internal.connectorca.api.DeveloperCertificateApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

DeveloperCertificateApi apiInstance = new DeveloperCertificateApi();
String id = "id_example"; // String | A unique identifier for the developer certificate. 
String authorization = "authorization_example"; // String | Bearer {Access Token}. 
try {
    DeveloperCertificateResponseData result = apiInstance.v3DeveloperCertificatesIdGet(id, authorization);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DeveloperCertificateApi#v3DeveloperCertificatesIdGet");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| A unique identifier for the developer certificate.  |
 **authorization** | **String**| Bearer {Access Token}.  |

### Return type

[**DeveloperCertificateResponseData**](DeveloperCertificateResponseData.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="v3DeveloperCertificatesPost"></a>
# **v3DeveloperCertificatesPost**
> DeveloperCertificateResponseData v3DeveloperCertificatesPost(authorization, body)

Create a new developer certificate to connect to the bootstrap server.

This REST API is intended to be used by customers to get a developer certificate (a certificate that can be flashed into multiple devices to connect to bootstrap server).  Limitations:    - One developer certificate allows up to 100 devices to connect to bootstrap server.   - Only 10 developer certificates are allowed per account. 

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.internal.ApiClient;
//import com.arm.mbed.cloud.sdk.internal.ApiException;
//import com.arm.mbed.cloud.sdk.internal.Configuration;
//import com.arm.mbed.cloud.sdk.internal.auth.*;
//import com.arm.mbed.cloud.sdk.internal.connectorca.api.DeveloperCertificateApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

DeveloperCertificateApi apiInstance = new DeveloperCertificateApi();
String authorization = "authorization_example"; // String | Bearer {Access Token}. 
DeveloperCertificateRequestData body = new DeveloperCertificateRequestData(); // DeveloperCertificateRequestData | 
try {
    DeveloperCertificateResponseData result = apiInstance.v3DeveloperCertificatesPost(authorization, body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DeveloperCertificateApi#v3DeveloperCertificatesPost");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **authorization** | **String**| Bearer {Access Token}.  |
 **body** | [**DeveloperCertificateRequestData**](DeveloperCertificateRequestData.md)|  |

### Return type

[**DeveloperCertificateResponseData**](DeveloperCertificateResponseData.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

