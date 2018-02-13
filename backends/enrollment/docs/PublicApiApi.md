# PublicApiApi

All URIs are relative to *http://api.mbedcloud.com*

Method | HTTP request | Description
------------- | ------------- | -------------
[**v3DeviceEnrollmentsGet**](PublicApiApi.md#v3DeviceEnrollmentsGet) | **GET** v3/device-enrollments | Get enrollment list.
[**v3DeviceEnrollmentsPost**](PublicApiApi.md#v3DeviceEnrollmentsPost) | **POST** v3/device-enrollments | Place an enrollment claim for one or several devices.
[**v3DeviceEnrollmentsidDelete**](PublicApiApi.md#v3DeviceEnrollmentsidDelete) | **DELETE** v3/device-enrollments/:id | Delete an enrollment by ID.
[**v3DeviceEnrollmentsidGet**](PublicApiApi.md#v3DeviceEnrollmentsidGet) | **GET** v3/device-enrollments/:id | Get details of an enrollment by ID.


<a name="v3DeviceEnrollmentsGet"></a>
# **v3DeviceEnrollmentsGet**
> EnrollmentIdentities v3DeviceEnrollmentsGet(limit, after, order)

Get enrollment list.

Provides a list of pending and claimed enrollments. Example usage: 

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.internal.ApiClient;
//import com.arm.mbed.cloud.sdk.internal.ApiException;
//import com.arm.mbed.cloud.sdk.internal.Configuration;
//import com.arm.mbed.cloud.sdk.internal.auth.*;
//import com.arm.mbed.cloud.sdk.internal.enrollment.api.PublicApiApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

PublicApiApi apiInstance = new PublicApiApi();
Integer limit = 56; // Integer | Number of results to be returned. Between 2 and 1000, inclusive.
String after = "after_example"; // String | Entity ID to fetch after.
String order = "ASC"; // String | ASC or DESC
try {
    EnrollmentIdentities result = apiInstance.v3DeviceEnrollmentsGet(limit, after, order);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling PublicApiApi#v3DeviceEnrollmentsGet");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **limit** | **Integer**| Number of results to be returned. Between 2 and 1000, inclusive. | [optional]
 **after** | **String**| Entity ID to fetch after. | [optional]
 **order** | **String**| ASC or DESC | [optional] [default to ASC] [enum: ASC, DESC]

### Return type

[**EnrollmentIdentities**](EnrollmentIdentities.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="v3DeviceEnrollmentsPost"></a>
# **v3DeviceEnrollmentsPost**
> EnrollmentIdentity v3DeviceEnrollmentsPost(enrollmentIdentity)

Place an enrollment claim for one or several devices.

When the device connects to the bootstrap server and provides the enrollment ID, it will be assigned to your account. 

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.internal.ApiClient;
//import com.arm.mbed.cloud.sdk.internal.ApiException;
//import com.arm.mbed.cloud.sdk.internal.Configuration;
//import com.arm.mbed.cloud.sdk.internal.auth.*;
//import com.arm.mbed.cloud.sdk.internal.enrollment.api.PublicApiApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

PublicApiApi apiInstance = new PublicApiApi();
EnrollmentId enrollmentIdentity = new EnrollmentId(); // EnrollmentId | 
try {
    EnrollmentIdentity result = apiInstance.v3DeviceEnrollmentsPost(enrollmentIdentity);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling PublicApiApi#v3DeviceEnrollmentsPost");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **enrollmentIdentity** | [**EnrollmentId**](EnrollmentId.md)|  |

### Return type

[**EnrollmentIdentity**](EnrollmentIdentity.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="v3DeviceEnrollmentsidDelete"></a>
# **v3DeviceEnrollmentsidDelete**
> Void v3DeviceEnrollmentsidDelete()

Delete an enrollment by ID.

To free a device from your account you can delete the enrollment claim. To bypass the device ownership, you need to delete the enrollment and do a factory reset for the device. For more information on the ownership trasfer, see [https://github.com/ARMmbed/mbed_Cloud_Docs/blob/restructure/Docs/provisioning/generic_instructions/device-ownership.md#transferring-ownership-using-first-to-claim](TODO put the right link).

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.internal.ApiClient;
//import com.arm.mbed.cloud.sdk.internal.ApiException;
//import com.arm.mbed.cloud.sdk.internal.Configuration;
//import com.arm.mbed.cloud.sdk.internal.auth.*;
//import com.arm.mbed.cloud.sdk.internal.enrollment.api.PublicApiApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

PublicApiApi apiInstance = new PublicApiApi();
try {
    Void result = apiInstance.v3DeviceEnrollmentsidDelete();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling PublicApiApi#v3DeviceEnrollmentsidDelete");
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

<a name="v3DeviceEnrollmentsidGet"></a>
# **v3DeviceEnrollmentsidGet**
> EnrollmentIdentity v3DeviceEnrollmentsidGet()

Get details of an enrollment by ID.

To check the enrollment info in detail, for example claming date and expiration date.

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.internal.ApiClient;
//import com.arm.mbed.cloud.sdk.internal.ApiException;
//import com.arm.mbed.cloud.sdk.internal.Configuration;
//import com.arm.mbed.cloud.sdk.internal.auth.*;
//import com.arm.mbed.cloud.sdk.internal.enrollment.api.PublicApiApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

PublicApiApi apiInstance = new PublicApiApi();
try {
    EnrollmentIdentity result = apiInstance.v3DeviceEnrollmentsidGet();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling PublicApiApi#v3DeviceEnrollmentsidGet");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**EnrollmentIdentity**](EnrollmentIdentity.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

