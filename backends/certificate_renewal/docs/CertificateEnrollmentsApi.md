# CertificateEnrollmentsApi

All URIs are relative to *https://api.us-east-1.mbedcloud.com*

Method | HTTP request | Description
------------- | ------------- | -------------
[**getCertificateEnrollment**](CertificateEnrollmentsApi.md#getCertificateEnrollment) | **GET** v3/certificate-enrollments/{certificate-enrollment-id} | Get a certificate enrollment by ID.
[**getCertificateEnrollments**](CertificateEnrollmentsApi.md#getCertificateEnrollments) | **GET** v3/certificate-enrollments | Get certificate enrollments list.


<a name="getCertificateEnrollment"></a>
# **getCertificateEnrollment**
> CertificateEnrollment getCertificateEnrollment(certificateEnrollmentId)

Get a certificate enrollment by ID.

Get a certificate enrollment by ID.  **Example usage:**  &#x60;&#x60;&#x60; curl -H &#39;authorization: Bearer &lt;valid access token&gt;&#39; https://api.us-east-1.mbedcloud.com/v3/certificate-enrollments/01612df56f3b0a580a010fc700000000 &#x60;&#x60;&#x60; 

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.internal.certificaterenewal.ApiClient;
//import com.arm.mbed.cloud.sdk.internal.certificaterenewal.ApiException;
//import com.arm.mbed.cloud.sdk.internal.certificaterenewal.Configuration;
//import com.arm.mbed.cloud.sdk.internal.certificaterenewal.auth.*;
//import com.arm.mbed.cloud.sdk.internal.certificaterenewal.api.CertificateEnrollmentsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

CertificateEnrollmentsApi apiInstance = new CertificateEnrollmentsApi();
String certificateEnrollmentId = "certificateEnrollmentId_example"; // String | The ID of the certificate enrollment. 
try {
    CertificateEnrollment result = apiInstance.getCertificateEnrollment(certificateEnrollmentId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling CertificateEnrollmentsApi#getCertificateEnrollment");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **certificateEnrollmentId** | **String**| The ID of the certificate enrollment.  |

### Return type

[**CertificateEnrollment**](CertificateEnrollment.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json; charset=utf-8

<a name="getCertificateEnrollments"></a>
# **getCertificateEnrollments**
> CertificateEnrollmentListResponse getCertificateEnrollments(deviceIdEq)

Get certificate enrollments list.

Get certificate enrollments, optionally filtered by device ID.  **Example usage:**  &#x60;&#x60;&#x60; curl -H &#39;authorization: Bearer &lt;valid access token&gt;&#39; https://api.us-east-1.mbedcloud.com/v3/certificate-enrollments &#x60;&#x60;&#x60; &#x60;&#x60;&#x60; curl -H &#39;authorization: Bearer &lt;valid access token&gt;&#39; https://api.us-east-1.mbedcloud.com/v3/certificate-enrollments?device_id__eq&#x3D;01612df56f3b0a580a010fc700000000 &#x60;&#x60;&#x60; 

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.internal.certificaterenewal.ApiClient;
//import com.arm.mbed.cloud.sdk.internal.certificaterenewal.ApiException;
//import com.arm.mbed.cloud.sdk.internal.certificaterenewal.Configuration;
//import com.arm.mbed.cloud.sdk.internal.certificaterenewal.auth.*;
//import com.arm.mbed.cloud.sdk.internal.certificaterenewal.api.CertificateEnrollmentsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

CertificateEnrollmentsApi apiInstance = new CertificateEnrollmentsApi();
String deviceIdEq = "deviceIdEq_example"; // String | The device ID. 
try {
    CertificateEnrollmentListResponse result = apiInstance.getCertificateEnrollments(deviceIdEq);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling CertificateEnrollmentsApi#getCertificateEnrollments");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **deviceIdEq** | **String**| The device ID.  | [optional]

### Return type

[**CertificateEnrollmentListResponse**](CertificateEnrollmentListResponse.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json; charset=utf-8

