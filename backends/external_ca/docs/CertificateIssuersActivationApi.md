# CertificateIssuersActivationApi

All URIs are relative to *https://api.us-east-1.mbedcloud.com*

Method | HTTP request | Description
------------- | ------------- | -------------
[**getCertificateIssuerConfigUsingGET**](CertificateIssuersActivationApi.md#getCertificateIssuerConfigUsingGET) | **GET** v3/certificate-issuer-configurations/lwm2m | Get certificate issuer configuration.
[**updateCertificateIssuerConfigUsingPUT**](CertificateIssuersActivationApi.md#updateCertificateIssuerConfigUsingPUT) | **PUT** v3/certificate-issuer-configurations/lwm2m | Update certificate issuer configuration.


<a name="getCertificateIssuerConfigUsingGET"></a>
# **getCertificateIssuerConfigUsingGET**
> CertificateIssuerConfigResponse getCertificateIssuerConfigUsingGET(authorization)

Get certificate issuer configuration.

Provides the configured certificate issuer to be used when creating device certificates for LwM2M communication.&lt;br&gt; 

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.internal.externalca.ApiClient;
//import com.arm.mbed.cloud.sdk.internal.externalca.ApiException;
//import com.arm.mbed.cloud.sdk.internal.externalca.Configuration;
//import com.arm.mbed.cloud.sdk.internal.externalca.auth.*;
//import com.arm.mbed.cloud.sdk.internal.externalca.api.CertificateIssuersActivationApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

CertificateIssuersActivationApi apiInstance = new CertificateIssuersActivationApi();
String authorization = "authorization_example"; // String | Bearer {token}
try {
    CertificateIssuerConfigResponse result = apiInstance.getCertificateIssuerConfigUsingGET(authorization);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling CertificateIssuersActivationApi#getCertificateIssuerConfigUsingGET");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **authorization** | **String**| Bearer {token} |

### Return type

[**CertificateIssuerConfigResponse**](CertificateIssuerConfigResponse.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: application/json;charset=UTF-8
 - **Accept**: application/json;charset=UTF-8

<a name="updateCertificateIssuerConfigUsingPUT"></a>
# **updateCertificateIssuerConfigUsingPUT**
> CertificateIssuerConfigResponse updateCertificateIssuerConfigUsingPUT(authorization, certificateIssuerConfigRequest)

Update certificate issuer configuration.

Configure the certificate issuer to be used when creating device certificates for LwM2M communication. &lt;br&gt; **Example usage:**  &#x60;&#x60;&#x60; curl -X PUT \\ -H &#39;authorization: &lt;valid access token&gt;&#39; \\ -H &#39;content-type: application/json;charset&#x3D;UTF-8&#39; \\ https://api.us-east-1.mbedcloud.com/v3/certificate-issuer-configurations/lwm2m \\ -d &#39;{   \&quot;certificate_issuer_id\&quot;: \&quot;01621a36719d507b9d48a91b00000000\&quot; }&#39; &#x60;&#x60;&#x60; 

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.internal.externalca.ApiClient;
//import com.arm.mbed.cloud.sdk.internal.externalca.ApiException;
//import com.arm.mbed.cloud.sdk.internal.externalca.Configuration;
//import com.arm.mbed.cloud.sdk.internal.externalca.auth.*;
//import com.arm.mbed.cloud.sdk.internal.externalca.api.CertificateIssuersActivationApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

CertificateIssuersActivationApi apiInstance = new CertificateIssuersActivationApi();
String authorization = "authorization_example"; // String | Bearer {token}
CertificateIssuerConfigRequest certificateIssuerConfigRequest = new CertificateIssuerConfigRequest(); // CertificateIssuerConfigRequest | Certificate Issuer Configuration Request
try {
    CertificateIssuerConfigResponse result = apiInstance.updateCertificateIssuerConfigUsingPUT(authorization, certificateIssuerConfigRequest);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling CertificateIssuersActivationApi#updateCertificateIssuerConfigUsingPUT");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **authorization** | **String**| Bearer {token} |
 **certificateIssuerConfigRequest** | [**CertificateIssuerConfigRequest**](CertificateIssuerConfigRequest.md)| Certificate Issuer Configuration Request |

### Return type

[**CertificateIssuerConfigResponse**](CertificateIssuerConfigResponse.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: application/json;charset=UTF-8
 - **Accept**: application/json;charset=UTF-8

