# EnrollmentDenialsApi

All URIs are relative to *https://api.us-east-1.mbedcloud.com*

Method | HTTP request | Description
------------- | ------------- | -------------
[**getEnrollmentDenialAttempt**](EnrollmentDenialsApi.md#getEnrollmentDenialAttempt) | **GET** v3/device-enrollment-denials/{device_enrollment_denial_id} | Query for a single device by ID
[**listEnrollmentDenialAttempts**](EnrollmentDenialsApi.md#listEnrollmentDenialAttempts) | **GET** v3/device-enrollment-denials | Return list of devices which were denied to bootstrap due to being subjected to blacklisting.


<a name="getEnrollmentDenialAttempt"></a>
# **getEnrollmentDenialAttempt**
> BlackListedDeviceData getEnrollmentDenialAttempt(deviceEnrollmentDenialId)

Query for a single device by ID

Query for a single attempt to bootstrap with a blacklisted certificate by ID.  **Example usage:** &#x60;&#x60;&#x60; curl -X GET -H &#39;Authorization: Bearer &lt;valid access token&gt;&#39; \\ https://api.us-east-1.mbedcloud.com/v3/device-enrollment-denials/{device_enrollment_denial_id} &#x60;&#x60;&#x60; 

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.EnrollmentDenialsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

EnrollmentDenialsApi apiInstance = new EnrollmentDenialsApi();
String deviceEnrollmentDenialId = "deviceEnrollmentDenialId_example"; // String | id of the recorded failed bootstrap attempt
try {
    BlackListedDeviceData result = apiInstance.getEnrollmentDenialAttempt(deviceEnrollmentDenialId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling EnrollmentDenialsApi#getEnrollmentDenialAttempt");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **deviceEnrollmentDenialId** | **String**| id of the recorded failed bootstrap attempt |

### Return type

[**BlackListedDeviceData**](BlackListedDeviceData.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="listEnrollmentDenialAttempts"></a>
# **listEnrollmentDenialAttempts**
> DenialAttemptsResponse listEnrollmentDenialAttempts(trustedCertificateIdEq, endpointNameEq, after, order, limit)

Return list of devices which were denied to bootstrap due to being subjected to blacklisting.

This produces a list of failed attempts to bootstrap using a particular certificate which is blacklisted (trusted_certificate). Returned list can be filtered by endpoint name. Trusted certificate ID filter is required.  **Example usage:** &#x60;&#x60;&#x60; curl -X GET -H &#39;Authorization: Bearer &lt;valid access token&gt;&#39; \\ https://api.us-east-1.mbedcloud.com/v3/device-enrollment-denials?trusted_certificate_id__eq&#x3D;{cert-id}&amp;endpoint_name__eq&#x3D;{endpoint_name} &#x60;&#x60;&#x60; 

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.EnrollmentDenialsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

EnrollmentDenialsApi apiInstance = new EnrollmentDenialsApi();
String trustedCertificateIdEq = "trustedCertificateIdEq_example"; // String | filtering based on trusted certificate id
String endpointNameEq = "endpointNameEq_example"; // String | filtering based on endpoint name
String after = "after_example"; // String | Optional parameter for pagination. Denied device ID.
String order = "order_example"; // String | Optional parameter for pagination.
Integer limit = 56; // Integer | Optional parameter for pagination.
try {
    DenialAttemptsResponse result = apiInstance.listEnrollmentDenialAttempts(trustedCertificateIdEq, endpointNameEq, after, order, limit);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling EnrollmentDenialsApi#listEnrollmentDenialAttempts");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **trustedCertificateIdEq** | **String**| filtering based on trusted certificate id |
 **endpointNameEq** | **String**| filtering based on endpoint name | [optional]
 **after** | **String**| Optional parameter for pagination. Denied device ID. | [optional]
 **order** | **String**| Optional parameter for pagination. | [optional] [enum: ASC, DESC]
 **limit** | **Integer**| Optional parameter for pagination. | [optional]

### Return type

[**DenialAttemptsResponse**](DenialAttemptsResponse.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

