# TenantAccountsLimitationsApi

All URIs are relative to *https://api.us-east-1.mbedcloud.com*

Method | HTTP request | Description
------------- | ------------- | -------------
[**aggregatorGetAccountLimitation**](TenantAccountsLimitationsApi.md#aggregatorGetAccountLimitation) | **GET** v3/accounts/{account_id}/limitations/{limitation_id} | Get a limitation of an account.
[**aggregatorGetAccountLimitations**](TenantAccountsLimitationsApi.md#aggregatorGetAccountLimitations) | **GET** v3/accounts/{account_id}/limitations | Get all limitations of an account.


<a name="aggregatorGetAccountLimitation"></a>
# **aggregatorGetAccountLimitation**
> AccountLimitation aggregatorGetAccountLimitation(accountId, limitationId)

Get a limitation of an account.

An endpoint for retrieving a limitation of an account.

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.TenantAccountsLimitationsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

TenantAccountsLimitationsApi apiInstance = new TenantAccountsLimitationsApi();
String accountId = "accountId_example"; // String | The ID of the account.
String limitationId = "limitationId_example"; // String | The ID of the limitation to be fetched.
try {
    AccountLimitation result = apiInstance.aggregatorGetAccountLimitation(accountId, limitationId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TenantAccountsLimitationsApi#aggregatorGetAccountLimitation");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **accountId** | **String**| The ID of the account. |
 **limitationId** | **String**| The ID of the limitation to be fetched. |

### Return type

[**AccountLimitation**](AccountLimitation.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="aggregatorGetAccountLimitations"></a>
# **aggregatorGetAccountLimitations**
> AccountLimitationList aggregatorGetAccountLimitations(accountId, inheritedEq)

Get all limitations of an account.

An endpoint for retrieving all limitations of an account.

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.TenantAccountsLimitationsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

TenantAccountsLimitationsApi apiInstance = new TenantAccountsLimitationsApi();
String accountId = "accountId_example"; // String | The ID of the account.
String inheritedEq = "inheritedEq_example"; // String | Filter for finding account limitations by inheritance. True returns also inherited limitations. False returns only non-inherited ones.
try {
    AccountLimitationList result = apiInstance.aggregatorGetAccountLimitations(accountId, inheritedEq);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TenantAccountsLimitationsApi#aggregatorGetAccountLimitations");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **accountId** | **String**| The ID of the account. |
 **inheritedEq** | **String**| Filter for finding account limitations by inheritance. True returns also inherited limitations. False returns only non-inherited ones. | [optional]

### Return type

[**AccountLimitationList**](AccountLimitationList.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

