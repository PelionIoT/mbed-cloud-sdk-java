# AccountProfileApi

All URIs are relative to *https://api.us-east-1.mbedcloud.com*

Method | HTTP request | Description
------------- | ------------- | -------------
[**getMyAccountInfo**](AccountProfileApi.md#getMyAccountInfo) | **GET** v3/accounts/me | Get account info.
[**updateMyAccount**](AccountProfileApi.md#updateMyAccount) | **PUT** v3/accounts/me | Updates attributes of the account.


<a name="getMyAccountInfo"></a>
# **getMyAccountInfo**
> AccountInfo getMyAccountInfo(include, properties)

Get account info.

Retrieve detailed information about the account.  **Example:** &#x60;&#x60;&#x60; curl -X GET https://api.us-east-1.mbedcloud.com/v3/accounts/me?include&#x3D;policies \\ -H &#39;Authorization: Bearer &lt;api_key&gt;&#39; &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.AccountProfileApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

AccountProfileApi apiInstance = new AccountProfileApi();
String include = "include_example"; // String | Comma-separated additional data to return. Currently supported: limits, policies, sub_accounts.
String properties = "properties_example"; // String | Property name to return from account-specific properties.
try {
    AccountInfo result = apiInstance.getMyAccountInfo(include, properties);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AccountProfileApi#getMyAccountInfo");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **include** | **String**| Comma-separated additional data to return. Currently supported: limits, policies, sub_accounts. | [optional]
 **properties** | **String**| Property name to return from account-specific properties. | [optional]

### Return type

[**AccountInfo**](AccountInfo.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="updateMyAccount"></a>
# **updateMyAccount**
> AccountInfo updateMyAccount(body)

Updates attributes of the account.

Update the account.  **Example:** &#x60;&#x60;&#x60; curl -X PUT https://api.us-east-1.mbedcloud.com/v3/accounts/me \\ -H &#39;Authorization: Bearer &lt;api_key&gt;&#39; \\ -H &#39;content-type: application/json&#39; \\ -d &#39;{\&quot;phone_number\&quot;: \&quot;12345678\&quot;}&#39; &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.AccountProfileApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

AccountProfileApi apiInstance = new AccountProfileApi();
AccountUpdateReq body = new AccountUpdateReq(); // AccountUpdateReq | Details of the account to update.
try {
    AccountInfo result = apiInstance.updateMyAccount(body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AccountProfileApi#updateMyAccount");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**AccountUpdateReq**](AccountUpdateReq.md)| Details of the account to update. |

### Return type

[**AccountInfo**](AccountInfo.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

