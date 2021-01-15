# SecurityAndIdentityServerCredentialsApi

All URIs are relative to *https://api.us-east-1.mbedcloud.com*

Method | HTTP request | Description
------------- | ------------- | -------------
[**getAllServerCredentials**](SecurityAndIdentityServerCredentialsApi.md#getAllServerCredentials) | **GET** v3/server-credentials | Fetch all (Bootstrap and LwM2M) server credentials.
[**getBootstrapServerCredentials**](SecurityAndIdentityServerCredentialsApi.md#getBootstrapServerCredentials) | **GET** v3/server-credentials/bootstrap | Fetch bootstrap server credentials.
[**getL2M2MServerCredentials**](SecurityAndIdentityServerCredentialsApi.md#getL2M2MServerCredentials) | **GET** v3/server-credentials/lwm2m | Fetch LwM2M server credentials.


<a name="getAllServerCredentials"></a>
# **getAllServerCredentials**
> AllServerCredentialsResponseData getAllServerCredentials()

Fetch all (Bootstrap and LwM2M) server credentials.

Return all (bootstrap and LwM2M) server credentials for client to connect to bootstrap or LwM2M server.  **Example:** &#x60;&#x60;&#x60; curl -X GET http://api.us-east-1.mbedcloud.com/v3/server-credentials \\ -H \&quot;Authorization: Bearer &lt;access_key&gt;\&quot; &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.SecurityAndIdentityServerCredentialsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

SecurityAndIdentityServerCredentialsApi apiInstance = new SecurityAndIdentityServerCredentialsApi();
try {
    AllServerCredentialsResponseData result = apiInstance.getAllServerCredentials();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling SecurityAndIdentityServerCredentialsApi#getAllServerCredentials");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**AllServerCredentialsResponseData**](AllServerCredentialsResponseData.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getBootstrapServerCredentials"></a>
# **getBootstrapServerCredentials**
> ServerCredentialsResponseData getBootstrapServerCredentials()

Fetch bootstrap server credentials.

Return bootstrap server credentials for client to connect to bootstrap server.  **Example:** &#x60;&#x60;&#x60; curl -X GET http://api.us-east-1.mbedcloud.com/v3/server-credentials/bootstrap \\ -H \&quot;Authorization: Bearer &lt;access_key&gt;\&quot; &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.SecurityAndIdentityServerCredentialsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

SecurityAndIdentityServerCredentialsApi apiInstance = new SecurityAndIdentityServerCredentialsApi();
try {
    ServerCredentialsResponseData result = apiInstance.getBootstrapServerCredentials();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling SecurityAndIdentityServerCredentialsApi#getBootstrapServerCredentials");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**ServerCredentialsResponseData**](ServerCredentialsResponseData.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getL2M2MServerCredentials"></a>
# **getL2M2MServerCredentials**
> ServerCredentialsResponseData getL2M2MServerCredentials()

Fetch LwM2M server credentials.

Return LwM2M server credentials for client to connect to LwM2M server.  **Example:** &#x60;&#x60;&#x60; curl -X GET http://api.us-east-1.mbedcloud.com/v3/server-credentials/lwm2m \\ -H \&quot;Authorization: Bearer &lt;access_key&gt;\&quot; &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.SecurityAndIdentityServerCredentialsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

SecurityAndIdentityServerCredentialsApi apiInstance = new SecurityAndIdentityServerCredentialsApi();
try {
    ServerCredentialsResponseData result = apiInstance.getL2M2MServerCredentials();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling SecurityAndIdentityServerCredentialsApi#getL2M2MServerCredentials");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**ServerCredentialsResponseData**](ServerCredentialsResponseData.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

