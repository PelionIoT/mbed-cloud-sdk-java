# AccountAdminApi

All URIs are relative to *https://api.us-east-1.mbedcloud.com*

Method | HTTP request | Description
------------- | ------------- | -------------
[**getNofificationEntry**](AccountAdminApi.md#getNofificationEntry) | **GET** v3/accounts/me/notifications/{notification_id} | Get notification event details.


<a name="getNofificationEntry"></a>
# **getNofificationEntry**
> NotificationEntry getNofificationEntry(notificationId)

Get notification event details.

An endpoint for retrieving notification event details.

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.AccountAdminApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

AccountAdminApi apiInstance = new AccountAdminApi();
String notificationId = "notificationId_example"; // String | The ID of the notification entry to be retrieved.
try {
    NotificationEntry result = apiInstance.getNofificationEntry(notificationId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AccountAdminApi#getNofificationEntry");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **notificationId** | **String**| The ID of the notification entry to be retrieved. |

### Return type

[**NotificationEntry**](NotificationEntry.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

