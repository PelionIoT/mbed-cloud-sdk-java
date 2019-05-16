# DeviceSecurityDeveloperClassCertificatesApi

All URIs are relative to *https://api.us-east-1.mbedcloud.com*

Method | HTTP request | Description
------------- | ------------- | -------------
[**createDeveloperCertificate**](DeviceSecurityDeveloperClassCertificatesApi.md#createDeveloperCertificate) | **POST** v3/developer-certificates | Create a new developer certificate to connect to the bootstrap server.
[**getDeveloperCertificate**](DeviceSecurityDeveloperClassCertificatesApi.md#getDeveloperCertificate) | **GET** v3/developer-certificates/{developerCertificateId} | Fetch an existing developer certificate to connect to the bootstrap server.


<a name="createDeveloperCertificate"></a>
# **createDeveloperCertificate**
> DeveloperCertificateResponseData createDeveloperCertificate(body)

Create a new developer certificate to connect to the bootstrap server.

Create a developer certificate (a certificate that can be flashed to multiple devices to connect to the bootstrap server).  **Note:** The number of developer certificates allowed per account is limited. Please see [Using your own certificate authority](../provisioning-process/using-CA.html).  **Example:** &#x60;&#x60;&#x60; curl -X POST http://api.us-east-1.mbedcloud.com/v3/developer-certificates \\ -H \&quot;Authorization: Bearer &lt;api_key&gt;\&quot; \\ -H \&quot;content-type: application/json\&quot; \\ -d { \&quot;name\&quot;: \&quot;&lt;certificate_name&gt;\&quot;, \&quot;description\&quot;: \&quot;&lt;certificate_description&gt;\&quot; } &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.DeviceSecurityDeveloperClassCertificatesApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

DeviceSecurityDeveloperClassCertificatesApi apiInstance = new DeviceSecurityDeveloperClassCertificatesApi();
DeveloperCertificateRequestData body = new DeveloperCertificateRequestData(); // DeveloperCertificateRequestData | 
try {
    DeveloperCertificateResponseData result = apiInstance.createDeveloperCertificate(body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DeviceSecurityDeveloperClassCertificatesApi#createDeveloperCertificate");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**DeveloperCertificateRequestData**](DeveloperCertificateRequestData.md)|  |

### Return type

[**DeveloperCertificateResponseData**](DeveloperCertificateResponseData.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getDeveloperCertificate"></a>
# **getDeveloperCertificate**
> DeveloperCertificateResponseData getDeveloperCertificate(developerCertificateId)

Fetch an existing developer certificate to connect to the bootstrap server.

Return an existing developer certificate (a certificate that can be flashed to multiple devices to connect to bootstrap server).  **Example:** &#x60;&#x60;&#x60; curl -X GET http://api.us-east-1.mbedcloud.com/v3/developer-certificates/THE_CERTIFICATE_ID \\ -H \&quot;Authorization: Bearer &lt;api_key&gt;\&quot; &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.DeviceSecurityDeveloperClassCertificatesApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

DeviceSecurityDeveloperClassCertificatesApi apiInstance = new DeviceSecurityDeveloperClassCertificatesApi();
String developerCertificateId = "developerCertificateId_example"; // String | A unique identifier for the developer certificate.
try {
    DeveloperCertificateResponseData result = apiInstance.getDeveloperCertificate(developerCertificateId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DeviceSecurityDeveloperClassCertificatesApi#getDeveloperCertificate");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **developerCertificateId** | **String**| A unique identifier for the developer certificate. |

### Return type

[**DeveloperCertificateResponseData**](DeveloperCertificateResponseData.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

