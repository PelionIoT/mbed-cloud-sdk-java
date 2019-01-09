# DeveloperCertificateApi

All URIs are relative to *https://api.us-east-1.mbedcloud.com*

Method | HTTP request | Description
------------- | ------------- | -------------
[**createDeveloperCertificate**](DeveloperCertificateApi.md#createDeveloperCertificate) | **POST** v3/developer-certificates | Create a new developer certificate to connect to the bootstrap server.
[**getDeveloperCertificate**](DeveloperCertificateApi.md#getDeveloperCertificate) | **GET** v3/developer-certificates/{developerCertificateId} | Fetch an existing developer certificate to connect to the bootstrap server.


<a name="createDeveloperCertificate"></a>
# **createDeveloperCertificate**
> DeveloperCertificateResponseData createDeveloperCertificate(body)

Create a new developer certificate to connect to the bootstrap server.

This REST API is intended to be used by customers to get a developer certificate (a certificate that can be flashed into multiple devices to connect to bootstrap server).  **Note:** The number of developer certificates allowed per account is limited. Please see [Using your own certificate authority](/docs/current/mbed-cloud-deploy/instructions-for-factory-setup-and-device-provision.html#using-your-own-certificate-authority-with-mbed-cloud).  **Example usage:** curl -X POST \&quot;http://api.us-east-1.mbedcloud.com/v3/developer-certificates\&quot; -H \&quot;accept: application/json\&quot; -H \&quot;Authorization: Bearer THE_ACCESS_TOKEN\&quot; -H \&quot;content-type: application/json\&quot; -d \&quot;{ \\\&quot;name\\\&quot;: \\\&quot;THE_CERTIFICATE_NAME\\\&quot;, \\\&quot;description\\\&quot;: \\\&quot;THE_CERTIFICATE_DESCRIPTION\\\&quot;}\&quot; 

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.DeveloperCertificateApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

DeveloperCertificateApi apiInstance = new DeveloperCertificateApi();
DeveloperCertificateRequestData body = new DeveloperCertificateRequestData(); // DeveloperCertificateRequestData | 
try {
    DeveloperCertificateResponseData result = apiInstance.createDeveloperCertificate(body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DeveloperCertificateApi#createDeveloperCertificate");
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

This REST API is intended to be used by customers to fetch an existing developer certificate (a certificate that can be flashed into multiple devices to connect to bootstrap server).  **Example usage:** curl -X GET \&quot;http://api.us-east-1.mbedcloud.com/v3/developer-certificates/THE_CERTIFICATE_ID\&quot; -H \&quot;accept: application/json\&quot; -H \&quot;Authorization: Bearer THE_ACCESS_TOKEN\&quot; 

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.DeveloperCertificateApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

DeveloperCertificateApi apiInstance = new DeveloperCertificateApi();
String developerCertificateId = "developerCertificateId_example"; // String | A unique identifier for the developer certificate. 
try {
    DeveloperCertificateResponseData result = apiInstance.getDeveloperCertificate(developerCertificateId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DeveloperCertificateApi#getDeveloperCertificate");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **developerCertificateId** | **String**| A unique identifier for the developer certificate.  |

### Return type

[**DeveloperCertificateResponseData**](DeveloperCertificateResponseData.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

