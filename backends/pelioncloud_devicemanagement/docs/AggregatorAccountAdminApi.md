# AggregatorAccountAdminApi

All URIs are relative to *https://api.us-east-1.mbedcloud.com*

Method | HTTP request | Description
------------- | ------------- | -------------
[**getAccountNofificationEntry**](AggregatorAccountAdminApi.md#getAccountNofificationEntry) | **GET** v3/accounts/{account_id}/notifications/{notification_id} | Get a notification event of an account.


<a name="getAccountNofificationEntry"></a>
# **getAccountNofificationEntry**
> NotificationEntry getAccountNofificationEntry(accountId, notificationId)

Get a notification event of an account.

An endpoint for retrieving notification event details of an account.

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.AggregatorAccountAdminApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

AggregatorAccountAdminApi apiInstance = new AggregatorAccountAdminApi();
String accountId = "accountId_example"; // String | The ID of the account for which this notification should be retrieved.
String notificationId = "notificationId_example"; // String | The ID of the notification entry to be retrieved.
try {
    NotificationEntry result = apiInstance.getAccountNofificationEntry(accountId, notificationId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AggregatorAccountAdminApi#getAccountNofificationEntry");
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

