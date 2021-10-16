# AccountEntitlementLimitationsApi

All URIs are relative to *https://api.us-east-1.mbedcloud.com*

Method | HTTP request | Description
------------- | ------------- | -------------
[**getAccountLimitation**](AccountEntitlementLimitationsApi.md#getAccountLimitation) | **GET** v3/limitations/{limitation_id} | Get an entitlement limitation.
[**getAccountLimitations**](AccountEntitlementLimitationsApi.md#getAccountLimitations) | **GET** v3/limitations | Get entitlement limitations.


<a name="getAccountLimitation"></a>
# **getAccountLimitation**
> AccountLimitation getAccountLimitation(limitationId)

Get an entitlement limitation.

Retrieve an entitlement limitation.

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.AccountEntitlementLimitationsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

AccountEntitlementLimitationsApi apiInstance = new AccountEntitlementLimitationsApi();
String limitationId = "limitationId_example"; // String | The ID of the limitation to be fetched.
try {
    AccountLimitation result = apiInstance.getAccountLimitation(limitationId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AccountEntitlementLimitationsApi#getAccountLimitation");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **limitationId** | **String**| The ID of the limitation to be fetched. |

### Return type

[**AccountLimitation**](AccountLimitation.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getAccountLimitations"></a>
# **getAccountLimitations**
> AccountLimitationList getAccountLimitations(inheritedEq)

Get entitlement limitations.

Retrieve an array of entitlement limitations.

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.AccountEntitlementLimitationsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

AccountEntitlementLimitationsApi apiInstance = new AccountEntitlementLimitationsApi();
String inheritedEq = "inheritedEq_example"; // String | Filter for finding account limitations by inheritance. True returns also inherited limitations. False returns only non-inherited ones.
try {
    AccountLimitationList result = apiInstance.getAccountLimitations(inheritedEq);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AccountEntitlementLimitationsApi#getAccountLimitations");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **inheritedEq** | **String**| Filter for finding account limitations by inheritance. True returns also inherited limitations. False returns only non-inherited ones. | [optional]

### Return type

[**AccountLimitationList**](AccountLimitationList.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

