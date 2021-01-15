# TenantAccountsEmailNotificationLogsApi

All URIs are relative to *https://api.us-east-1.mbedcloud.com*

Method | HTTP request | Description
------------- | ------------- | -------------
[**getAccountNofificationEntries**](TenantAccountsEmailNotificationLogsApi.md#getAccountNofificationEntries) | **GET** v3/accounts/{account_id}/notifications | Get email notifications.
[**getAccountNofificationEntry**](TenantAccountsEmailNotificationLogsApi.md#getAccountNofificationEntry) | **GET** v3/accounts/{account_id}/notifications/{notification_id} | Get an email notification.


<a name="getAccountNofificationEntries"></a>
# **getAccountNofificationEntries**
> NotificationEntryList getAccountNofificationEntries(accountId, limit, after, order)

Get email notifications.

Retrieve an array of email notification logs. &lt;b&gt;Note:&lt;/b&gt; This endpoint is restricted to administrators.

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
String after = "after_example"; // String | The entity ID to retrieve after the given one.
String order = "ASC"; // String | Record order based on creation. Acceptable values: ASC, DESC. Default: ASC.
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
 **after** | **String**| The entity ID to retrieve after the given one. | [optional]
 **order** | **String**| Record order based on creation. Acceptable values: ASC, DESC. Default: ASC. | [optional] [default to ASC]

### Return type

[**NotificationEntryList**](NotificationEntryList.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getAccountNofificationEntry"></a>
# **getAccountNofificationEntry**
> NotificationEntry getAccountNofificationEntry(accountId, notificationId)

Get an email notification.

Retrieve an email notifications log entry. &lt;b&gt;Note:&lt;/b&gt; This endpoint is restricted to administrators.

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
String accountId = "accountId_example"; // String | The ID of the account for which this notification should be retrieved.
String notificationId = "notificationId_example"; // String | The ID of the notification entry to be retrieved.
try {
    NotificationEntry result = apiInstance.getAccountNofificationEntry(accountId, notificationId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TenantAccountsEmailNotificationLogsApi#getAccountNofificationEntry");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **accountId** | **String**| The ID of the account for which this notification should be retrieved. |
 **notificationId** | **String**| The ID of the notification entry to be retrieved. |

### Return type

[**NotificationEntry**](NotificationEntry.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

