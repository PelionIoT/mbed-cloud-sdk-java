# ServerCredentialsApi

All URIs are relative to *http://api.us-east-1.mbedcloud.com*

Method | HTTP request | Description
------------- | ------------- | -------------
[**v3ServerCredentialsBootstrapGet**](ServerCredentialsApi.md#v3ServerCredentialsBootstrapGet) | **GET** v3/server-credentials/bootstrap | Fetch bootstrap server credentials.
[**v3ServerCredentialsLwm2mGet**](ServerCredentialsApi.md#v3ServerCredentialsLwm2mGet) | **GET** v3/server-credentials/lwm2m | Fetch LWM2M server credentials.


<a name="v3ServerCredentialsBootstrapGet"></a>
# **v3ServerCredentialsBootstrapGet**
> ServerCredentialsResponseData v3ServerCredentialsBootstrapGet(authorization)

Fetch bootstrap server credentials.

This REST API is intended to be used by customers to fetch bootstrap server credentials that they need to use with their clients to connect to bootstrap server. 

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.internal.connectorca.ApiClient;
//import com.arm.mbed.cloud.sdk.internal.connectorca.ApiException;
//import com.arm.mbed.cloud.sdk.internal.connectorca.Configuration;
//import com.arm.mbed.cloud.sdk.internal.connectorca.auth.*;
//import com.arm.mbed.cloud.sdk.internal.connectorca.api.ServerCredentialsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

ServerCredentialsApi apiInstance = new ServerCredentialsApi();
String authorization = "authorization_example"; // String | Bearer {Access Token}. 
try {
    ServerCredentialsResponseData result = apiInstance.v3ServerCredentialsBootstrapGet(authorization);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ServerCredentialsApi#v3ServerCredentialsBootstrapGet");
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
//import com.arm.mbed.cloud.sdk.internal.connectorca.ApiClient;
//import com.arm.mbed.cloud.sdk.internal.connectorca.ApiException;
//import com.arm.mbed.cloud.sdk.internal.connectorca.Configuration;
//import com.arm.mbed.cloud.sdk.internal.connectorca.auth.*;
//import com.arm.mbed.cloud.sdk.internal.connectorca.api.ServerCredentialsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

ServerCredentialsApi apiInstance = new ServerCredentialsApi();
String authorization = "authorization_example"; // String | Bearer {Access Token}. 
try {
    ServerCredentialsResponseData result = apiInstance.v3ServerCredentialsLwm2mGet(authorization);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ServerCredentialsApi#v3ServerCredentialsLwm2mGet");
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

