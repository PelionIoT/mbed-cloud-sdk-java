# CertificateIssuersActivationApi

All URIs are relative to *https://api.us-east-1.mbedcloud.com*

Method | HTTP request | Description
------------- | ------------- | -------------
[**createCertificateIssuerConfig**](CertificateIssuersActivationApi.md#createCertificateIssuerConfig) | **POST** v3/certificate-issuer-configurations | Create certificate issuer configuration.
[**deleteCertificateIssuerConfigByID**](CertificateIssuersActivationApi.md#deleteCertificateIssuerConfigByID) | **DELETE** v3/certificate-issuer-configurations/{certificate-issuer-configuration-id} | Delete certificate issuer configuration.
[**getCertificateIssuerConfig**](CertificateIssuersActivationApi.md#getCertificateIssuerConfig) | **GET** v3/certificate-issuer-configurations/lwm2m | Get certificate issuer configuration.
[**getCertificateIssuerConfigByID**](CertificateIssuersActivationApi.md#getCertificateIssuerConfigByID) | **GET** v3/certificate-issuer-configurations/{certificate-issuer-configuration-id} | Get certificate issuer configuration.
[**getCertificateIssuerConfigs**](CertificateIssuersActivationApi.md#getCertificateIssuerConfigs) | **GET** v3/certificate-issuer-configurations | Get certificate issuer configurations.
[**updateCertificateIssuerConfig**](CertificateIssuersActivationApi.md#updateCertificateIssuerConfig) | **PUT** v3/certificate-issuer-configurations/lwm2m | Update certificate issuer configuration.
[**updateCertificateIssuerConfigByID**](CertificateIssuersActivationApi.md#updateCertificateIssuerConfigByID) | **PUT** v3/certificate-issuer-configurations/{certificate-issuer-configuration-id} | Update certificate issuer configuration.


<a name="createCertificateIssuerConfig"></a>
# **createCertificateIssuerConfig**
> CertificateIssuerConfigResponse createCertificateIssuerConfig(createCertificateIssuerConfig)

Create certificate issuer configuration.

Configure the certificate issuer to be used when creating the device custom certificates. &lt;br&gt; **Example usage:**  &#x60;&#x60;&#x60; curl -X POST \\ -H &#39;authorization: &lt;valid access token&gt;&#39; \\ -H &#39;content-type: application/json;charset&#x3D;UTF-8&#39; \\ https://api.us-east-1.mbedcloud.com/v3/certificate-issuer-configurations \\ -d &#39;{   \&quot;reference\&quot;: \&quot;customer.dlms\&quot;,   \&quot;certificate_issuer_id\&quot;: \&quot;01621a36719d507b9d48a91b00000000\&quot; }&#39; &#x60;&#x60;&#x60; 

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
CreateCertificateIssuerConfig createCertificateIssuerConfig = new CreateCertificateIssuerConfig(); // CreateCertificateIssuerConfig | Certificate issuer configuration request
try {
    CertificateIssuerConfigResponse result = apiInstance.createCertificateIssuerConfig(createCertificateIssuerConfig);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling CertificateIssuersActivationApi#createCertificateIssuerConfig");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **createCertificateIssuerConfig** | [**CreateCertificateIssuerConfig**](CreateCertificateIssuerConfig.md)| Certificate issuer configuration request |

### Return type

[**CertificateIssuerConfigResponse**](CertificateIssuerConfigResponse.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: application/json; charset=utf-8
 - **Accept**: application/json; charset=utf-8

<a name="deleteCertificateIssuerConfigByID"></a>
# **deleteCertificateIssuerConfigByID**
> Void deleteCertificateIssuerConfigByID(certificateIssuerConfigurationId)

Delete certificate issuer configuration.

Delete the configured certificate issuer configuration. You can only delete the configurations of custom certificates. 

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
String certificateIssuerConfigurationId = "certificateIssuerConfigurationId_example"; // String | The ID of the certificate issuer configuration. 
try {
    Void result = apiInstance.deleteCertificateIssuerConfigByID(certificateIssuerConfigurationId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling CertificateIssuersActivationApi#deleteCertificateIssuerConfigByID");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **certificateIssuerConfigurationId** | **String**| The ID of the certificate issuer configuration.  |

### Return type

[**Void**](.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: application/json; charset=utf-8
 - **Accept**: application/json; charset=utf-8

<a name="getCertificateIssuerConfig"></a>
# **getCertificateIssuerConfig**
> CertificateIssuerConfigResponse getCertificateIssuerConfig()

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
try {
    CertificateIssuerConfigResponse result = apiInstance.getCertificateIssuerConfig();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling CertificateIssuersActivationApi#getCertificateIssuerConfig");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**CertificateIssuerConfigResponse**](CertificateIssuerConfigResponse.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: application/json; charset=utf-8
 - **Accept**: application/json; charset=utf-8

<a name="getCertificateIssuerConfigByID"></a>
# **getCertificateIssuerConfigByID**
> CertificateIssuerConfigResponse getCertificateIssuerConfigByID(certificateIssuerConfigurationId)

Get certificate issuer configuration.

Provides the configured certificate issuer. 

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
String certificateIssuerConfigurationId = "certificateIssuerConfigurationId_example"; // String | The ID of the certificate issuer configuration. 
try {
    CertificateIssuerConfigResponse result = apiInstance.getCertificateIssuerConfigByID(certificateIssuerConfigurationId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling CertificateIssuersActivationApi#getCertificateIssuerConfigByID");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **certificateIssuerConfigurationId** | **String**| The ID of the certificate issuer configuration.  |

### Return type

[**CertificateIssuerConfigResponse**](CertificateIssuerConfigResponse.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: application/json; charset=utf-8
 - **Accept**: application/json; charset=utf-8

<a name="getCertificateIssuerConfigs"></a>
# **getCertificateIssuerConfigs**
> CertificateIssuerConfigListResponse getCertificateIssuerConfigs(referenceEq)

Get certificate issuer configurations.

Get certificate issuer configurations, optionally filtered by reference. &lt;br&gt; **Example usage:**  &#x60;&#x60;&#x60; curl \\ -H &#39;authorization: &lt;valid access token&gt;&#39; \\ -H &#39;content-type: application/json;charset&#x3D;UTF-8&#39; \\ https://api.us-east-1.mbedcloud.com/v3/certificate-issuer-configurations \\ &#x60;&#x60;&#x60; &#x60;&#x60;&#x60; curl \\ -H &#39;authorization: &lt;valid access token&gt;&#39; \\ -H &#39;content-type: application/json;charset&#x3D;UTF-8&#39; \\ https://api.us-east-1.mbedcloud.com/v3/certificate-issuer-configurations?reference__eq&#x3D;dlms \\ &#x60;&#x60;&#x60; 

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
String referenceEq = "referenceEq_example"; // String | The certificate name to which the certificate issuer configuration applies.
try {
    CertificateIssuerConfigListResponse result = apiInstance.getCertificateIssuerConfigs(referenceEq);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling CertificateIssuersActivationApi#getCertificateIssuerConfigs");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **referenceEq** | **String**| The certificate name to which the certificate issuer configuration applies. | [optional]

### Return type

[**CertificateIssuerConfigListResponse**](CertificateIssuerConfigListResponse.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: application/json; charset=utf-8
 - **Accept**: application/json; charset=utf-8

<a name="updateCertificateIssuerConfig"></a>
# **updateCertificateIssuerConfig**
> CertificateIssuerConfigResponse updateCertificateIssuerConfig(certificateIssuerConfigRequest)

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
CertificateIssuerConfigRequest certificateIssuerConfigRequest = new CertificateIssuerConfigRequest(); // CertificateIssuerConfigRequest | Certificate Issuer Configuration Request
try {
    CertificateIssuerConfigResponse result = apiInstance.updateCertificateIssuerConfig(certificateIssuerConfigRequest);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling CertificateIssuersActivationApi#updateCertificateIssuerConfig");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **certificateIssuerConfigRequest** | [**CertificateIssuerConfigRequest**](CertificateIssuerConfigRequest.md)| Certificate Issuer Configuration Request |

### Return type

[**CertificateIssuerConfigResponse**](CertificateIssuerConfigResponse.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: application/json; charset=utf-8
 - **Accept**: application/json; charset=utf-8

<a name="updateCertificateIssuerConfigByID"></a>
# **updateCertificateIssuerConfigByID**
> CertificateIssuerConfigResponse updateCertificateIssuerConfigByID(certificateIssuerConfigurationId, certificateIssuerConfigRequest)

Update certificate issuer configuration.

Update the configured certificate issuer configuration. 

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
String certificateIssuerConfigurationId = "certificateIssuerConfigurationId_example"; // String | The ID of the certificate issuer configuration. 
CertificateIssuerConfigRequest certificateIssuerConfigRequest = new CertificateIssuerConfigRequest(); // CertificateIssuerConfigRequest | Certificate issuer configuration request
try {
    CertificateIssuerConfigResponse result = apiInstance.updateCertificateIssuerConfigByID(certificateIssuerConfigurationId, certificateIssuerConfigRequest);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling CertificateIssuersActivationApi#updateCertificateIssuerConfigByID");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **certificateIssuerConfigurationId** | **String**| The ID of the certificate issuer configuration.  |
 **certificateIssuerConfigRequest** | [**CertificateIssuerConfigRequest**](CertificateIssuerConfigRequest.md)| Certificate issuer configuration request |

### Return type

[**CertificateIssuerConfigResponse**](CertificateIssuerConfigResponse.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: application/json; charset=utf-8
 - **Accept**: application/json; charset=utf-8

