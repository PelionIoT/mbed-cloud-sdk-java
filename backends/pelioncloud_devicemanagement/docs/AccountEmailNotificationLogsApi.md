# AccountEmailNotificationLogsApi

All URIs are relative to *https://api.us-east-1.mbedcloud.com*

Method | HTTP request | Description
------------- | ------------- | -------------
[**getNofificationEntries**](AccountEmailNotificationLogsApi.md#getNofificationEntries) | **GET** v3/accounts/me/notifications | Get logs of email notifications.
[**getNofificationEntry**](AccountEmailNotificationLogsApi.md#getNofificationEntry) | **GET** v3/accounts/me/notifications/{notification_id} | Get an email notification.


<a name="getNofificationEntries"></a>
# **getNofificationEntries**
> NotificationEntryList getNofificationEntries(limit, after, order)

Get logs of email notifications.

Retrieve an array of email notification logs.

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.AccountEmailNotificationLogsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

AccountEmailNotificationLogsApi apiInstance = new AccountEmailNotificationLogsApi();
Integer limit = 50; // Integer | The number of results to return (2-1000). Default 50.
String after = "after_example"; // String | The entity ID to retrieve after the given one.
String order = "ASC"; // String | Record order based on creation. Acceptable values: ASC, DESC. Default: ASC.
try {
    NotificationEntryList result = apiInstance.getNofificationEntries(limit, after, order);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AccountEmailNotificationLogsApi#getNofificationEntries");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
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

<a name="getNofificationEntry"></a>
# **getNofificationEntry**
> NotificationEntry getNofificationEntry(notificationId)

Get an email notification.

Retrieve an email notification log entry.

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.AccountEmailNotificationLogsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

AccountEmailNotificationLogsApi apiInstance = new AccountEmailNotificationLogsApi();
String notificationId = "notificationId_example"; // String | The ID of the log entry to be retrieved.
try {
    NotificationEntry result = apiInstance.getNofificationEntry(notificationId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AccountEmailNotificationLogsApi#getNofificationEntry");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **notificationId** | **String**| The ID of the log entry to be retrieved. |

### Return type

[**NotificationEntry**](NotificationEntry.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

