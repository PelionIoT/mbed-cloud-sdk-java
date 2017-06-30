# DefaultApi

All URIs are relative to *https://api.us-east-1.mbedcloud.com*

Method | HTTP request | Description
------------- | ------------- | -------------
[**v2NotificationCallbackDelete**](DefaultApi.md#v2NotificationCallbackDelete) | **DELETE** v2/notification/callback | Delete callback URL
[**v2NotificationCallbackGet**](DefaultApi.md#v2NotificationCallbackGet) | **GET** v2/notification/callback | Check callback URL


<a name="v2NotificationCallbackDelete"></a>
# **v2NotificationCallbackDelete**
> Void v2NotificationCallbackDelete()

Delete callback URL

Deletes the callback URL.

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.internal.ApiClient;
//import com.arm.mbed.cloud.sdk.internal.ApiException;
//import com.arm.mbed.cloud.sdk.internal.Configuration;
//import com.arm.mbed.cloud.sdk.internal.auth.*;
//import com.arm.mbed.cloud.sdk.internal.api.DefaultApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

DefaultApi apiInstance = new DefaultApi();
try {
    Void result = apiInstance.v2NotificationCallbackDelete();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#v2NotificationCallbackDelete");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**Void**](.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="v2NotificationCallbackGet"></a>
# **v2NotificationCallbackGet**
> Webhook v2NotificationCallbackGet()

Check callback URL

Shows the current callback URL if it exists.

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.internal.ApiClient;
//import com.arm.mbed.cloud.sdk.internal.ApiException;
//import com.arm.mbed.cloud.sdk.internal.Configuration;
//import com.arm.mbed.cloud.sdk.internal.auth.*;
//import com.arm.mbed.cloud.sdk.internal.api.DefaultApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

DefaultApi apiInstance = new DefaultApi();
try {
    Webhook result = apiInstance.v2NotificationCallbackGet();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#v2NotificationCallbackGet");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**Webhook**](Webhook.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

