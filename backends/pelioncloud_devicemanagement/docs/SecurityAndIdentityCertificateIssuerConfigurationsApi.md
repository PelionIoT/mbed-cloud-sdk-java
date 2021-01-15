# SecurityAndIdentityCertificateIssuerConfigurationsApi

All URIs are relative to *https://api.us-east-1.mbedcloud.com*

Method | HTTP request | Description
------------- | ------------- | -------------
[**createCertificateIssuerConfig**](SecurityAndIdentityCertificateIssuerConfigurationsApi.md#createCertificateIssuerConfig) | **POST** v3/certificate-issuer-configurations | Create certificate issuer configuration.
[**deleteCertificateIssuerConfigByID**](SecurityAndIdentityCertificateIssuerConfigurationsApi.md#deleteCertificateIssuerConfigByID) | **DELETE** v3/certificate-issuer-configurations/{certificate-issuer-configuration-id} | Delete certificate issuer configuration.
[**getCertificateIssuerConfig**](SecurityAndIdentityCertificateIssuerConfigurationsApi.md#getCertificateIssuerConfig) | **GET** v3/certificate-issuer-configurations/lwm2m | Get certificate issuer configuration.
[**getCertificateIssuerConfigByID**](SecurityAndIdentityCertificateIssuerConfigurationsApi.md#getCertificateIssuerConfigByID) | **GET** v3/certificate-issuer-configurations/{certificate-issuer-configuration-id} | Get certificate issuer configuration.
[**getCertificateIssuerConfigs**](SecurityAndIdentityCertificateIssuerConfigurationsApi.md#getCertificateIssuerConfigs) | **GET** v3/certificate-issuer-configurations | Get certificate issuer configurations.
[**updateCertificateIssuerConfig**](SecurityAndIdentityCertificateIssuerConfigurationsApi.md#updateCertificateIssuerConfig) | **PUT** v3/certificate-issuer-configurations/lwm2m | Update certificate issuer configuration.
[**updateCertificateIssuerConfigByID**](SecurityAndIdentityCertificateIssuerConfigurationsApi.md#updateCertificateIssuerConfigByID) | **PUT** v3/certificate-issuer-configurations/{certificate-issuer-configuration-id} | Update certificate issuer configuration.


<a name="createCertificateIssuerConfig"></a>
# **createCertificateIssuerConfig**
> CertificateIssuerConfigResponse createCertificateIssuerConfig(createCertificateIssuerConfig)

Create certificate issuer configuration.

Configure the certificate issuer to use when creating device custom certificates. &lt;br&gt; **Example:**  &#x60;&#x60;&#x60; curl -X POST https://api.us-east-1.mbedcloud.com/v3/certificate-issuer-configurations \\ -H &#39;Authorization: Bearer &lt;access_key&gt;&#39; \\ -H &#39;content-type: application/json;charset&#x3D;UTF-8&#39; \\ -d &#39;{   \&quot;reference\&quot;: \&quot;customer.dlms\&quot;,   \&quot;certificate_issuer_id\&quot;: \&quot;01621a36719d507b9d48a91b00000000\&quot; }&#39; &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.SecurityAndIdentityCertificateIssuerConfigurationsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

SecurityAndIdentityCertificateIssuerConfigurationsApi apiInstance = new SecurityAndIdentityCertificateIssuerConfigurationsApi();
CreateCertificateIssuerConfig createCertificateIssuerConfig = new CreateCertificateIssuerConfig(); // CreateCertificateIssuerConfig | Certificate issuer configuration request.
try {
    CertificateIssuerConfigResponse result = apiInstance.createCertificateIssuerConfig(createCertificateIssuerConfig);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling SecurityAndIdentityCertificateIssuerConfigurationsApi#createCertificateIssuerConfig");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **createCertificateIssuerConfig** | [**CreateCertificateIssuerConfig**](CreateCertificateIssuerConfig.md)| Certificate issuer configuration request. |

### Return type

[**CertificateIssuerConfigResponse**](CertificateIssuerConfigResponse.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="deleteCertificateIssuerConfigByID"></a>
# **deleteCertificateIssuerConfigByID**
> Void deleteCertificateIssuerConfigByID(certificateIssuerConfigurationId)

Delete certificate issuer configuration.

Delete certificate issuer configuration. You can only delete custom certificate configurations.

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.SecurityAndIdentityCertificateIssuerConfigurationsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

SecurityAndIdentityCertificateIssuerConfigurationsApi apiInstance = new SecurityAndIdentityCertificateIssuerConfigurationsApi();
String certificateIssuerConfigurationId = "certificateIssuerConfigurationId_example"; // String | Certificate issuer ID configuration.
try {
    Void result = apiInstance.deleteCertificateIssuerConfigByID(certificateIssuerConfigurationId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling SecurityAndIdentityCertificateIssuerConfigurationsApi#deleteCertificateIssuerConfigByID");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **certificateIssuerConfigurationId** | **String**| Certificate issuer ID configuration. |

### Return type

[**Void**](.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getCertificateIssuerConfig"></a>
# **getCertificateIssuerConfig**
> CertificateIssuerConfigResponse getCertificateIssuerConfig()

Get certificate issuer configuration.

Provides the configured certificate issuer used when creating device certificates for LwM2M.

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.SecurityAndIdentityCertificateIssuerConfigurationsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

SecurityAndIdentityCertificateIssuerConfigurationsApi apiInstance = new SecurityAndIdentityCertificateIssuerConfigurationsApi();
try {
    CertificateIssuerConfigResponse result = apiInstance.getCertificateIssuerConfig();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling SecurityAndIdentityCertificateIssuerConfigurationsApi#getCertificateIssuerConfig");
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

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getCertificateIssuerConfigByID"></a>
# **getCertificateIssuerConfigByID**
> CertificateIssuerConfigResponse getCertificateIssuerConfigByID(certificateIssuerConfigurationId)

Get certificate issuer configuration.

Provides the configured certificate issuer.

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.SecurityAndIdentityCertificateIssuerConfigurationsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

SecurityAndIdentityCertificateIssuerConfigurationsApi apiInstance = new SecurityAndIdentityCertificateIssuerConfigurationsApi();
String certificateIssuerConfigurationId = "certificateIssuerConfigurationId_example"; // String | Certificate issuer ID configuration.
try {
    CertificateIssuerConfigResponse result = apiInstance.getCertificateIssuerConfigByID(certificateIssuerConfigurationId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling SecurityAndIdentityCertificateIssuerConfigurationsApi#getCertificateIssuerConfigByID");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **certificateIssuerConfigurationId** | **String**| Certificate issuer ID configuration. |

### Return type

[**CertificateIssuerConfigResponse**](CertificateIssuerConfigResponse.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getCertificateIssuerConfigs"></a>
# **getCertificateIssuerConfigs**
> CertificateIssuerConfigListResponse getCertificateIssuerConfigs(limit, order, after, include, referenceEq)

Get certificate issuer configurations.

Get certificate issuer configurations, optionally filtered by reference. &lt;br&gt; **Example:** &#x60;&#x60;&#x60; curl -X GET https://api.us-east-1.mbedcloud.com/v3/certificate-issuer-configurations \\ -H &#39;Authorization: Bearer &lt;access_key&gt;&#39; \\ -H &#39;content-type: application/json;charset&#x3D;UTF-8&#39; \\ &#x60;&#x60;&#x60; &lt;br&gt; &#x60;&#x60;&#x60; curl -X GET https://api.us-east-1.mbedcloud.com/v3/certificate-issuer-configurations?reference__eq&#x3D;dlms \\ -H &#39;Authorization: Bearer &lt;access_key&gt;&#39; \\ -H &#39;content-type: application/json;charset&#x3D;UTF-8&#39; \\ &#x60;&#x60;&#x60; **Note:** This endpoint does not implement pagination, and therefore ignores list control parameters such as &#x60;limit&#x60; or &#x60;after&#x60;.

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.SecurityAndIdentityCertificateIssuerConfigurationsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

SecurityAndIdentityCertificateIssuerConfigurationsApi apiInstance = new SecurityAndIdentityCertificateIssuerConfigurationsApi();
Integer limit = 56; // Integer | The number of results to return (2-1000). Values outside of this range are set to the closest limit.
String order = "order_example"; // String | Record order. Acceptable values: ASC, DESC. Default: ASC.
String after = "after_example"; // String | The ID of the item after which to retrieve the next page.
String include = "include_example"; // String | Comma-separated list of data fields to return. Currently supported: `total_count`.
String referenceEq = "referenceEq_example"; // String | The certificate name to which the certificate issuer configuration applies.
try {
    CertificateIssuerConfigListResponse result = apiInstance.getCertificateIssuerConfigs(limit, order, after, include, referenceEq);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling SecurityAndIdentityCertificateIssuerConfigurationsApi#getCertificateIssuerConfigs");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **limit** | **Integer**| The number of results to return (2-1000). Values outside of this range are set to the closest limit. | [optional]
 **order** | **String**| Record order. Acceptable values: ASC, DESC. Default: ASC. | [optional]
 **after** | **String**| The ID of the item after which to retrieve the next page. | [optional]
 **include** | **String**| Comma-separated list of data fields to return. Currently supported: &#x60;total_count&#x60;. | [optional]
 **referenceEq** | **String**| The certificate name to which the certificate issuer configuration applies. | [optional]

### Return type

[**CertificateIssuerConfigListResponse**](CertificateIssuerConfigListResponse.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="updateCertificateIssuerConfig"></a>
# **updateCertificateIssuerConfig**
> CertificateIssuerConfigResponse updateCertificateIssuerConfig(certificateIssuerConfigRequest)

Update certificate issuer configuration.

Configure the certificate issuer used when creating device certificates for LwM2M. &lt;br&gt; **Example:**  &#x60;&#x60;&#x60; curl -X PUT https://api.us-east-1.mbedcloud.com/v3/certificate-issuer-configurations/lwm2m \\ -H &#39;Authorization: Bearer &lt;access_key&gt;&#39; \\ -H &#39;content-type: application/json;charset&#x3D;UTF-8&#39; \\ -d &#39;{   \&quot;certificate_issuer_id\&quot;: \&quot;01621a36719d507b9d48a91b00000000\&quot; }&#39; &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.SecurityAndIdentityCertificateIssuerConfigurationsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

SecurityAndIdentityCertificateIssuerConfigurationsApi apiInstance = new SecurityAndIdentityCertificateIssuerConfigurationsApi();
CertificateIssuerConfigRequest certificateIssuerConfigRequest = new CertificateIssuerConfigRequest(); // CertificateIssuerConfigRequest | Certificate Issuer Configuration Request
try {
    CertificateIssuerConfigResponse result = apiInstance.updateCertificateIssuerConfig(certificateIssuerConfigRequest);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling SecurityAndIdentityCertificateIssuerConfigurationsApi#updateCertificateIssuerConfig");
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

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="updateCertificateIssuerConfigByID"></a>
# **updateCertificateIssuerConfigByID**
> CertificateIssuerConfigResponse updateCertificateIssuerConfigByID(certificateIssuerConfigRequest, certificateIssuerConfigurationId)

Update certificate issuer configuration.

Update certificate issuer configuration.

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.SecurityAndIdentityCertificateIssuerConfigurationsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

SecurityAndIdentityCertificateIssuerConfigurationsApi apiInstance = new SecurityAndIdentityCertificateIssuerConfigurationsApi();
CertificateIssuerConfigRequest certificateIssuerConfigRequest = new CertificateIssuerConfigRequest(); // CertificateIssuerConfigRequest | Certificate issuer configuration request.
String certificateIssuerConfigurationId = "certificateIssuerConfigurationId_example"; // String | Certificate issuer ID configuration.
try {
    CertificateIssuerConfigResponse result = apiInstance.updateCertificateIssuerConfigByID(certificateIssuerConfigRequest, certificateIssuerConfigurationId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling SecurityAndIdentityCertificateIssuerConfigurationsApi#updateCertificateIssuerConfigByID");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **certificateIssuerConfigRequest** | [**CertificateIssuerConfigRequest**](CertificateIssuerConfigRequest.md)| Certificate issuer configuration request. |
 **certificateIssuerConfigurationId** | **String**| Certificate issuer ID configuration. |

### Return type

[**CertificateIssuerConfigResponse**](CertificateIssuerConfigResponse.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

