# TenantDeviceSecurityCertificatesApi

All URIs are relative to *https://api.us-east-1.mbedcloud.com*

Method | HTTP request | Description
------------- | ------------- | -------------
[**addAccountCertificate**](TenantDeviceSecurityCertificatesApi.md#addAccountCertificate) | **POST** v3/accounts/{account_id}/trusted-certificates | Upload new trusted certificate.
[**deleteAccountCertificate**](TenantDeviceSecurityCertificatesApi.md#deleteAccountCertificate) | **DELETE** v3/accounts/{account_id}/trusted-certificates/{cert_id} | Delete trusted certificate by ID.
[**getAccountCertificate**](TenantDeviceSecurityCertificatesApi.md#getAccountCertificate) | **GET** v3/accounts/{account_id}/trusted-certificates/{cert_id} | Get trusted certificate by ID.
[**getAllAccountCertificates**](TenantDeviceSecurityCertificatesApi.md#getAllAccountCertificates) | **GET** v3/accounts/{account_id}/trusted-certificates | Get all trusted certificates.
[**updateAccountCertificate**](TenantDeviceSecurityCertificatesApi.md#updateAccountCertificate) | **PUT** v3/accounts/{account_id}/trusted-certificates/{cert_id} | Update trusted certificate.


<a name="addAccountCertificate"></a>
# **addAccountCertificate**
> TrustedCertificateResp addAccountCertificate(accountId, body)

Upload new trusted certificate.

Upload new trusted certificates.  **Example:** &#x60;&#x60;&#x60; curl -X POST https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/trusted-certificates \\ -H &#39;Authorization: Bearer &lt;api_key&gt;&#39; \\ -H &#39;content-type: application/json&#39; \\ -d {\&quot;name\&quot;: \&quot;myCert1\&quot;, \&quot;description\&quot;: \&quot;very important cert\&quot;, \&quot;certificate\&quot;: \&quot;certificate_data\&quot;, \&quot;service\&quot;: \&quot;lwm2m\&quot;} &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.TenantDeviceSecurityCertificatesApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

TenantDeviceSecurityCertificatesApi apiInstance = new TenantDeviceSecurityCertificatesApi();
String accountId = "accountId_example"; // String | Account ID.
TrustedCertificateReq body = new TrustedCertificateReq(); // TrustedCertificateReq | A trusted certificate object with attributes. Signature is optional.
try {
    TrustedCertificateResp result = apiInstance.addAccountCertificate(accountId, body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TenantDeviceSecurityCertificatesApi#addAccountCertificate");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **accountId** | **String**| Account ID. |
 **body** | [**TrustedCertificateReq**](TrustedCertificateReq.md)| A trusted certificate object with attributes. Signature is optional. |

### Return type

[**TrustedCertificateResp**](TrustedCertificateResp.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="deleteAccountCertificate"></a>
# **deleteAccountCertificate**
> Void deleteAccountCertificate(accountId, certId)

Delete trusted certificate by ID.

Delete the trusted certificate.  **Example:** &#x60;&#x60;&#x60; curl -X DELETE https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/trusted-certificates/{cert_id} \\ -H &#39;Authorization: Bearer &lt;api_key&gt;&#39; &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.TenantDeviceSecurityCertificatesApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

TenantDeviceSecurityCertificatesApi apiInstance = new TenantDeviceSecurityCertificatesApi();
String accountId = "accountId_example"; // String | Account ID.
String certId = "certId_example"; // String | The ID of the trusted certificate to delete.
try {
    Void result = apiInstance.deleteAccountCertificate(accountId, certId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TenantDeviceSecurityCertificatesApi#deleteAccountCertificate");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **accountId** | **String**| Account ID. |
 **certId** | **String**| The ID of the trusted certificate to delete. |

### Return type

[**Void**](.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getAccountCertificate"></a>
# **getAccountCertificate**
> TrustedCertificateResp getAccountCertificate(accountId, certId)

Get trusted certificate by ID.

Retrieve a trusted certificate by ID.  **Example:** &#x60;&#x60;&#x60; curl -X GET https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/trusted-certificates/{cert_id} \\ -H &#39;Authorization: Bearer &lt;api_key&gt;&#39; &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.TenantDeviceSecurityCertificatesApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

TenantDeviceSecurityCertificatesApi apiInstance = new TenantDeviceSecurityCertificatesApi();
String accountId = "accountId_example"; // String | Account ID.
String certId = "certId_example"; // String | The ID of the trusted certificate to retrieve.
try {
    TrustedCertificateResp result = apiInstance.getAccountCertificate(accountId, certId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TenantDeviceSecurityCertificatesApi#getAccountCertificate");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **accountId** | **String**| Account ID. |
 **certId** | **String**| The ID of the trusted certificate to retrieve. |

### Return type

[**TrustedCertificateResp**](TrustedCertificateResp.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getAllAccountCertificates"></a>
# **getAllAccountCertificates**
> TrustedCertificateRespList getAllAccountCertificates(accountId, limit, after, order, include, nameEq, serviceEq, expireEq, deviceExecutionModeEq, deviceExecutionModeNeq, ownerEq, enrollmentModeEq, statusEq, issuerLike, subjectLike, validEq)

Get all trusted certificates.

Retrieve trusted certificates in an array.  **Example:** &#x60;&#x60;&#x60; curl -X GET https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/trusted-certificates \\ -H &#39;Authorization: Bearer &lt;api_key&gt;&#39; &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.TenantDeviceSecurityCertificatesApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

TenantDeviceSecurityCertificatesApi apiInstance = new TenantDeviceSecurityCertificatesApi();
String accountId = "accountId_example"; // String | Account ID.
Integer limit = 50; // Integer | The number of results to return (2-1000). Default 50.
String after = "after_example"; // String | The entity ID to fetch after the given one.
String order = "ASC"; // String | Record order based on creation time. Acceptable values: ASC, DESC. Default: ASC.
String include = "include_example"; // String | Comma-separated additional data to return. Currently supported: total_count.
String nameEq = "nameEq_example"; // String | Filter for certificate name.
String serviceEq = "serviceEq_example"; // String | Filter for service.
Integer expireEq = 56; // Integer | Filter for expire.
Integer deviceExecutionModeEq = 56; // Integer | Filter for developer certificates.
Integer deviceExecutionModeNeq = 56; // Integer | Filter for not developer certificates.
String ownerEq = "ownerEq_example"; // String | Owner name filter.
Boolean enrollmentModeEq = true; // Boolean | Enrollment mode filter.
String statusEq = "statusEq_example"; // String | Filter for certificate status.
String issuerLike = "issuerLike_example"; // String | Filter for issuer. Finds all matches where the filter value is a case-insensitive substring of the result. Example: issuer__like=cn=iss matches CN=issuer.
String subjectLike = "subjectLike_example"; // String | Filter for subject. Finds all matches where the filter value is a case-insensitive substring of the result. Example: subject__like=cn=su matches CN=subject.
Boolean validEq = true; // Boolean | Filter for finding certificates by validity. True returns certificates which are not yet expired. False returns certificates which have expired.
try {
    TrustedCertificateRespList result = apiInstance.getAllAccountCertificates(accountId, limit, after, order, include, nameEq, serviceEq, expireEq, deviceExecutionModeEq, deviceExecutionModeNeq, ownerEq, enrollmentModeEq, statusEq, issuerLike, subjectLike, validEq);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TenantDeviceSecurityCertificatesApi#getAllAccountCertificates");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **accountId** | **String**| Account ID. |
 **limit** | **Integer**| The number of results to return (2-1000). Default 50. | [optional] [default to 50]
 **after** | **String**| The entity ID to fetch after the given one. | [optional]
 **order** | **String**| Record order based on creation time. Acceptable values: ASC, DESC. Default: ASC. | [optional] [default to ASC]
 **include** | **String**| Comma-separated additional data to return. Currently supported: total_count. | [optional]
 **nameEq** | **String**| Filter for certificate name. | [optional]
 **serviceEq** | **String**| Filter for service. | [optional]
 **expireEq** | **Integer**| Filter for expire. | [optional]
 **deviceExecutionModeEq** | **Integer**| Filter for developer certificates. | [optional]
 **deviceExecutionModeNeq** | **Integer**| Filter for not developer certificates. | [optional]
 **ownerEq** | **String**| Owner name filter. | [optional]
 **enrollmentModeEq** | **Boolean**| Enrollment mode filter. | [optional]
 **statusEq** | **String**| Filter for certificate status. | [optional]
 **issuerLike** | **String**| Filter for issuer. Finds all matches where the filter value is a case-insensitive substring of the result. Example: issuer__like&#x3D;cn&#x3D;iss matches CN&#x3D;issuer. | [optional]
 **subjectLike** | **String**| Filter for subject. Finds all matches where the filter value is a case-insensitive substring of the result. Example: subject__like&#x3D;cn&#x3D;su matches CN&#x3D;subject. | [optional]
 **validEq** | **Boolean**| Filter for finding certificates by validity. True returns certificates which are not yet expired. False returns certificates which have expired. | [optional]

### Return type

[**TrustedCertificateRespList**](TrustedCertificateRespList.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="updateAccountCertificate"></a>
# **updateAccountCertificate**
> TrustedCertificateResp updateAccountCertificate(accountId, certId, body)

Update trusted certificate.

Update existing trusted certificates.  **Example:** &#x60;&#x60;&#x60; curl -X PUT https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/trusted-certificates/{cert_id} \\  -H &#39;Authorization: Bearer &lt;api_key&gt;&#39; \\  -H &#39;content-type: application/json&#39; \\  -d {\&quot;description\&quot;: \&quot;very important cert\&quot;}  &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.TenantDeviceSecurityCertificatesApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

TenantDeviceSecurityCertificatesApi apiInstance = new TenantDeviceSecurityCertificatesApi();
String accountId = "accountId_example"; // String | Account ID.
String certId = "certId_example"; // String | The ID of the trusted certificate to update.
TrustedCertificateUpdateReq body = new TrustedCertificateUpdateReq(); // TrustedCertificateUpdateReq | A trusted certificate object with attributes.
try {
    TrustedCertificateResp result = apiInstance.updateAccountCertificate(accountId, certId, body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TenantDeviceSecurityCertificatesApi#updateAccountCertificate");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **accountId** | **String**| Account ID. |
 **certId** | **String**| The ID of the trusted certificate to update. |
 **body** | [**TrustedCertificateUpdateReq**](TrustedCertificateUpdateReq.md)| A trusted certificate object with attributes. |

### Return type

[**TrustedCertificateResp**](TrustedCertificateResp.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

