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

Get a certificate enrollment by ID.  **Example:**  &#x60;&#x60;&#x60; curl -X GET https://api.us-east-1.mbedcloud.com/v3/certificate-enrollments/01612df56f3b0a580a010fc700000000 \\ -H &#39;Authorization: Bearer &lt;api_key&gt;&#39; &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.CertificateEnrollmentsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

CertificateEnrollmentsApi apiInstance = new CertificateEnrollmentsApi();
String certificateEnrollmentId = "certificateEnrollmentId_example"; // String | Certificate enrollment ID.
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
 **certificateEnrollmentId** | **String**| Certificate enrollment ID. |

### Return type

[**CertificateEnrollment**](CertificateEnrollment.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getCertificateEnrollments"></a>
# **getCertificateEnrollments**
> CertificateEnrollmentListResponse getCertificateEnrollments(deviceIdEq, certificateNameEq, limit, after, order, include, enrollStatusNeq, enrollStatusEq, enrollResultNeq, enrollResultEq, createdAtLte, createdAtGte, updatedAtLte, updatedAtGte)

Get certificate enrollments list.

Get certificate enrollments list, optionally filtered.  **Examples:**  &#x60;&#x60;&#x60; curl -X GET https://api.us-east-1.mbedcloud.com/v3/certificate-enrollments \\ -H &#39;Authorization: Bearer &lt;api_key&gt;&#39; &#x60;&#x60;&#x60;  &#x60;&#x60;&#x60; curl -X GET https://api.us-east-1.mbedcloud.com/v3/certificate-enrollments?device_id__eq&#x3D;01612df56f3b0a580a010fc700000000 \\ -H &#39;Authorization: Bearer &lt;api_key&gt;&#39; &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.CertificateEnrollmentsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

CertificateEnrollmentsApi apiInstance = new CertificateEnrollmentsApi();
String deviceIdEq = "deviceIdEq_example"; // String | An optional filter for the device ID.
String certificateNameEq = "certificateNameEq_example"; // String | An optional filter for a certificate.
Integer limit = 56; // Integer | The number of results to return (2-1000).
String after = "after_example"; // String | The ID of the item after which to retrieve the next page.
String order = "order_example"; // String | The order of results.
String include = "include_example"; // String | a comma-separated list of data fields to return.
String enrollStatusNeq = "enrollStatusNeq_example"; // String | An optional filter for the non-equal certificate enrollment status.
String enrollStatusEq = "enrollStatusEq_example"; // String | An optional filter for the certificate enrollment status.
String enrollResultNeq = "enrollResultNeq_example"; // String | An optional filter for the non-equal certificate enrollment result.
String enrollResultEq = "enrollResultEq_example"; // String | An optional filter for the certificate enrollment result.
DateTime createdAtLte = new DateTime(); // DateTime | An optional filter for the date-time, less than or equal, of the certificate enrollment requests creation. Must be in RFC3339 format (for example, 2018-01-30T10:03:50.106Z).
DateTime createdAtGte = new DateTime(); // DateTime | An optional filter for the date-time, greater than or equal, of the certificate enrollment requests creation. Must be in RFC3339 format (for example, 2018-01-30T10:03:50.106Z).
DateTime updatedAtLte = new DateTime(); // DateTime | An optional filter for the date-time, less than or equal, of the certificate enrollment requests update. Must be in RFC3339 format (for example, 2018-01-30T10:03:50.106Z).
DateTime updatedAtGte = new DateTime(); // DateTime | An optional filter for the date-time, greater than or equal, of the certificate enrollment requests update. Must be in RFC3339 format (for example, 2018-01-30T10:03:50.106Z).
try {
    CertificateEnrollmentListResponse result = apiInstance.getCertificateEnrollments(deviceIdEq, certificateNameEq, limit, after, order, include, enrollStatusNeq, enrollStatusEq, enrollResultNeq, enrollResultEq, createdAtLte, createdAtGte, updatedAtLte, updatedAtGte);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling CertificateEnrollmentsApi#getCertificateEnrollments");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **deviceIdEq** | **String**| An optional filter for the device ID. | [optional]
 **certificateNameEq** | **String**| An optional filter for a certificate. | [optional]
 **limit** | **Integer**| The number of results to return (2-1000). | [optional]
 **after** | **String**| The ID of the item after which to retrieve the next page. | [optional]
 **order** | **String**| The order of results. | [optional] [enum: ASC, DESC]
 **include** | **String**| a comma-separated list of data fields to return. | [optional] [enum: total_count]
 **enrollStatusNeq** | **String**| An optional filter for the non-equal certificate enrollment status. | [optional] [enum: new, completed]
 **enrollStatusEq** | **String**| An optional filter for the certificate enrollment status. | [optional] [enum: new, completed]
 **enrollResultNeq** | **String**| An optional filter for the non-equal certificate enrollment result. | [optional]
 **enrollResultEq** | **String**| An optional filter for the certificate enrollment result. | [optional]
 **createdAtLte** | **DateTime**| An optional filter for the date-time, less than or equal, of the certificate enrollment requests creation. Must be in RFC3339 format (for example, 2018-01-30T10:03:50.106Z). | [optional]
 **createdAtGte** | **DateTime**| An optional filter for the date-time, greater than or equal, of the certificate enrollment requests creation. Must be in RFC3339 format (for example, 2018-01-30T10:03:50.106Z). | [optional]
 **updatedAtLte** | **DateTime**| An optional filter for the date-time, less than or equal, of the certificate enrollment requests update. Must be in RFC3339 format (for example, 2018-01-30T10:03:50.106Z). | [optional]
 **updatedAtGte** | **DateTime**| An optional filter for the date-time, greater than or equal, of the certificate enrollment requests update. Must be in RFC3339 format (for example, 2018-01-30T10:03:50.106Z). | [optional]

### Return type

[**CertificateEnrollmentListResponse**](CertificateEnrollmentListResponse.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

