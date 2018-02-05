# ExternalApiApi

All URIs are relative to *http://api.us-east-1.mbedcloud.com*

Method | HTTP request | Description
------------- | ------------- | -------------
[**v3DeveloperCertificatesMuuidGet**](ExternalApiApi.md#v3DeveloperCertificatesMuuidGet) | **GET** v3/developer-certificates/{muuid} | Fetch an existing developer certificate to connect to the bootstrap server.
[**v3DeveloperCertificatesPost**](ExternalApiApi.md#v3DeveloperCertificatesPost) | **POST** v3/developer-certificates | Create a new developer certificate to connect to the bootstrap server.
[**v3ServerCredentialsBootstrapGet**](ExternalApiApi.md#v3ServerCredentialsBootstrapGet) | **GET** v3/server-credentials/bootstrap | Fetch bootstrap server credentials.
[**v3ServerCredentialsLwm2mGet**](ExternalApiApi.md#v3ServerCredentialsLwm2mGet) | **GET** v3/server-credentials/lwm2m | Fetch LWM2M server credentials.


<a name="v3DeveloperCertificatesMuuidGet"></a>
# **v3DeveloperCertificatesMuuidGet**
> DeveloperCertificateResponseData v3DeveloperCertificatesMuuidGet(muuid, authorization)

Fetch an existing developer certificate to connect to the bootstrap server.

This REST API is intended to be used by customers to fetch an existing developer certificate (a certificate that can be flashed into multiple devices to connect to bootstrap server). 

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.internal.ApiClient;
//import com.arm.mbed.cloud.sdk.internal.ApiException;
//import com.arm.mbed.cloud.sdk.internal.Configuration;
//import com.arm.mbed.cloud.sdk.internal.auth.*;
//import com.arm.mbed.cloud.sdk.internal.connectorca.api.ExternalApiApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

ExternalApiApi apiInstance = new ExternalApiApi();
String muuid = "muuid_example"; // String | A unique identifier for the developer certificate. 
String authorization = "authorization_example"; // String | Bearer {Access Token}. 
try {
    DeveloperCertificateResponseData result = apiInstance.v3DeveloperCertificatesMuuidGet(muuid, authorization);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ExternalApiApi#v3DeveloperCertificatesMuuidGet");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **muuid** | **String**| A unique identifier for the developer certificate.  |
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
//import com.arm.mbed.cloud.sdk.internal.connectorca.api.ExternalApiApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

ExternalApiApi apiInstance = new ExternalApiApi();
String authorization = "authorization_example"; // String | Bearer {Access Token}. 
DeveloperCertificateRequestData body = new DeveloperCertificateRequestData(); // DeveloperCertificateRequestData | 
try {
    DeveloperCertificateResponseData result = apiInstance.v3DeveloperCertificatesPost(authorization, body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ExternalApiApi#v3DeveloperCertificatesPost");
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

<a name="v3ServerCredentialsBootstrapGet"></a>
# **v3ServerCredentialsBootstrapGet**
> ServerCredentialsResponseData v3ServerCredentialsBootstrapGet(authorization)

Fetch bootstrap server credentials.

This REST API is intended to be used by customers to fetch bootstrap server credentials that they need to use with their clients to connect to bootstrap server. 

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.internal.ApiClient;
//import com.arm.mbed.cloud.sdk.internal.ApiException;
//import com.arm.mbed.cloud.sdk.internal.Configuration;
//import com.arm.mbed.cloud.sdk.internal.auth.*;
//import com.arm.mbed.cloud.sdk.internal.connectorca.api.ExternalApiApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

ExternalApiApi apiInstance = new ExternalApiApi();
String authorization = "authorization_example"; // String | Bearer {Access Token}. 
try {
    ServerCredentialsResponseData result = apiInstance.v3ServerCredentialsBootstrapGet(authorization);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ExternalApiApi#v3ServerCredentialsBootstrapGet");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **authorization** | **String**| Bearer {Access Token}.  |

### Return type

[**ServerCredentialsResponseData**](ServerCredentialsResponseData.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="v3ServerCredentialsLwm2mGet"></a>
# **v3ServerCredentialsLwm2mGet**
> ServerCredentialsResponseData v3ServerCredentialsLwm2mGet(authorization)

Fetch LWM2M server credentials.

This REST API is intended to be used by customers to fetch LWM2M server credentials that they need to use with their clients to connect to LWM2M server. 

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.internal.ApiClient;
//import com.arm.mbed.cloud.sdk.internal.ApiException;
//import com.arm.mbed.cloud.sdk.internal.Configuration;
//import com.arm.mbed.cloud.sdk.internal.auth.*;
//import com.arm.mbed.cloud.sdk.internal.connectorca.api.ExternalApiApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

ExternalApiApi apiInstance = new ExternalApiApi();
String authorization = "authorization_example"; // String | Bearer {Access Token}. 
try {
    ServerCredentialsResponseData result = apiInstance.v3ServerCredentialsLwm2mGet(authorization);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ExternalApiApi#v3ServerCredentialsLwm2mGet");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **authorization** | **String**| Bearer {Access Token}.  |

### Return type

[**ServerCredentialsResponseData**](ServerCredentialsResponseData.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

