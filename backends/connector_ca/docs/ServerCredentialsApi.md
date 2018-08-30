# ServerCredentialsApi

All URIs are relative to *http://api.us-east-1.mbedcloud.com*

Method | HTTP request | Description
------------- | ------------- | -------------
[**getAllServerCredentials**](ServerCredentialsApi.md#getAllServerCredentials) | **GET** v3/server-credentials | Fetch all (Bootstrap and LwM2M) server credentials.
[**getBootstrapServerCredentials**](ServerCredentialsApi.md#getBootstrapServerCredentials) | **GET** v3/server-credentials/bootstrap | Fetch bootstrap server credentials.
[**getL2M2MServerCredentials**](ServerCredentialsApi.md#getL2M2MServerCredentials) | **GET** v3/server-credentials/lwm2m | Fetch LwM2M server credentials.


<a name="getAllServerCredentials"></a>
# **getAllServerCredentials**
> AllServerCredentialsResponseData getAllServerCredentials(authorization)

Fetch all (Bootstrap and LwM2M) server credentials.

This REST API is intended to be used by customers to fetch all (Bootstrap and LwM2M) server credentials that they will need to use with their clients to connect to bootstrap or LwM2M server.  **Example usage:** curl -X GET \&quot;http://api.us-east-1.mbedcloud.com/v3/server-credentials\&quot; -H \&quot;accept: application/json\&quot; -H \&quot;Authorization: Bearer THE_ACCESS_TOKEN\&quot; 

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
    AllServerCredentialsResponseData result = apiInstance.getAllServerCredentials(authorization);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ServerCredentialsApi#getAllServerCredentials");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **authorization** | **String**| Bearer {Access Token}.  |

### Return type

[**AllServerCredentialsResponseData**](AllServerCredentialsResponseData.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getBootstrapServerCredentials"></a>
# **getBootstrapServerCredentials**
> ServerCredentialsResponseData getBootstrapServerCredentials(authorization)

Fetch bootstrap server credentials.

This REST API is intended to be used by customers to fetch bootstrap server credentials that they will need to use with their clients to connect to bootstrap server.  **Example usage:** curl -X GET \&quot;http://api.us-east-1.mbedcloud.com/v3/server-credentials/bootstrap\&quot; -H \&quot;accept: application/json\&quot; -H \&quot;Authorization: Bearer THE_ACCESS_TOKEN\&quot; 

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
    ServerCredentialsResponseData result = apiInstance.getBootstrapServerCredentials(authorization);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ServerCredentialsApi#getBootstrapServerCredentials");
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

<a name="getL2M2MServerCredentials"></a>
# **getL2M2MServerCredentials**
> ServerCredentialsResponseData getL2M2MServerCredentials(authorization)

Fetch LwM2M server credentials.

This REST API is intended to be used by customers to fetch LwM2M server credentials that they will need to use with their clients to connect to LwM2M server.  **Example usage:** curl -X GET \&quot;http://api.us-east-1.mbedcloud.com/v3/server-credentials/lwm2m\&quot; -H \&quot;accept: application/json\&quot; -H \&quot;Authorization: Bearer THE_ACCESS_TOKEN\&quot; 

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
    ServerCredentialsResponseData result = apiInstance.getL2M2MServerCredentials(authorization);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ServerCredentialsApi#getL2M2MServerCredentials");
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

