# CertificateRenewalApi

All URIs are relative to *https://api.us-east-1.mbedcloud.com*

Method | HTTP request | Description
------------- | ------------- | -------------
[**requestCertificateRenewal**](CertificateRenewalApi.md#requestCertificateRenewal) | **POST** v3/devices/{device-id}/certificates/{certificate-name}/renew | Request certificate renewal.


<a name="requestCertificateRenewal"></a>
# **requestCertificateRenewal**
> CertificateEnrollment requestCertificateRenewal(deviceId, certificateName)

Request certificate renewal.

Request a certificate renewal.  **Example usage:**  &#x60;&#x60;&#x60; curl -X POST -H &#39;authorization: Bearer &lt;valid access token&gt;&#39; -H &#39;content-length: 0&#39; https://api.us-east-1.mbedcloud.com/v3/devices/01612df56f3b0a580a010fc700000000/certificates/customer.dlms/renew &#x60;&#x60;&#x60; 

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.internal.certificaterenewal.ApiClient;
//import com.arm.mbed.cloud.sdk.internal.certificaterenewal.ApiException;
//import com.arm.mbed.cloud.sdk.internal.certificaterenewal.Configuration;
//import com.arm.mbed.cloud.sdk.internal.certificaterenewal.auth.*;
//import com.arm.mbed.cloud.sdk.internal.certificaterenewal.api.CertificateRenewalApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

CertificateRenewalApi apiInstance = new CertificateRenewalApi();
String deviceId = "deviceId_example"; // String | The device ID.
String certificateName = "certificateName_example"; // String | The certificate name.
try {
    CertificateEnrollment result = apiInstance.requestCertificateRenewal(deviceId, certificateName);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling CertificateRenewalApi#requestCertificateRenewal");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **deviceId** | **String**| The device ID. |
 **certificateName** | **String**| The certificate name. |

### Return type

[**CertificateEnrollment**](CertificateEnrollment.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json; charset=utf-8

