# TenantAccountsEmailNotificationLogsApi

All URIs are relative to *https://api.us-east-1.mbedcloud.com*

Method | HTTP request | Description
------------- | ------------- | -------------
[**getAccountNofificationEntries**](TenantAccountsEmailNotificationLogsApi.md#getAccountNofificationEntries) | **GET** v3/accounts/{account_id}/notifications | Get the notification events of an account.


<a name="getAccountNofificationEntries"></a>
# **getAccountNofificationEntries**
> NotificationEntryList getAccountNofificationEntries(accountId, limit, after, order)

Get the notification events of an account.

Retrieve notifications.

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.TenantAccountsEmailNotificationLogsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

TenantAccountsEmailNotificationLogsApi apiInstance = new TenantAccountsEmailNotificationLogsApi();
String accountId = "accountId_example"; // String | Account ID.
Integer limit = 50; // Integer | The number of results to return (2-1000). Default 50.
String after = "after_example"; // String | The entity ID to fetch after the given one.
String order = "ASC"; // String | Record order based on creation time. Acceptable values: ASC, DESC. Default: ASC.
try {
    NotificationEntryList result = apiInstance.getAccountNofificationEntries(accountId, limit, after, order);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TenantAccountsEmailNotificationLogsApi#getAccountNofificationEntries");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **accountId** | **String**| Account ID. |
 **limit** | **Integer**| The number of results to return (2-1000). Default 50. | [optional] [default to 50]
 **after** | **String**| The entity ID to fetch after the given one. | [optional]
 **order** | **String**| Record order based on creation time. Acceptable values: ASC, DESC. Default: ASC. | [optional] [default to ASC]

### Return type

[**NotificationEntryList**](NotificationEntryList.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

