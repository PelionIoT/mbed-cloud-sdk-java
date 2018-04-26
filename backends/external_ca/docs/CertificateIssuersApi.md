# CertificateIssuersApi

All URIs are relative to *https://api.us-east-1.mbedcloud.com*

Method | HTTP request | Description
------------- | ------------- | -------------
[**createCertificateIssuer**](CertificateIssuersApi.md#createCertificateIssuer) | **POST** v3/certificate-issuers | Create certificate issuer.
[**deleteCertificateIssuer**](CertificateIssuersApi.md#deleteCertificateIssuer) | **DELETE** v3/certificate-issuers/{certificate-issuer-id} | Delete certificate issuer.
[**getCertificateIssuer**](CertificateIssuersApi.md#getCertificateIssuer) | **GET** v3/certificate-issuers/{certificate-issuer-id} | Get certificate issuer by ID.
[**getCertificateIssuers**](CertificateIssuersApi.md#getCertificateIssuers) | **GET** v3/certificate-issuers | Get certificate issuers list.
[**updateCertificateIssuer**](CertificateIssuersApi.md#updateCertificateIssuer) | **PUT** v3/certificate-issuers/{certificate-issuer-id} | Update certificate issuer.
[**verifyCertificateIssuer**](CertificateIssuersApi.md#verifyCertificateIssuer) | **POST** v3/certificate-issuers/{certificate-issuer-id}/verify | Verify certificate issuer.


<a name="createCertificateIssuer"></a>
# **createCertificateIssuer**
> CertificateIssuerInfo createCertificateIssuer(authorization, certificateIssuerRequest)

Create certificate issuer.

Create a certificate issuer. The maximum number of issuers is limited to 20 per account. Multiple certificate issuers of the same issuer type can be created, provided they have a different name. This allows verification of the certificate issuer configuration before activating it. &lt;br&gt; **Example usage:**  &#x60;&#x60;&#x60; curl -X POST \\ -H &#39;authorization: Bearer &lt;valid access token&gt;&#39; \\ -H &#39;content-type: application/json;charset&#x3D;UTF-8&#39; \\ https://api.us-east-1.mbedcloud.com/v3/certificate-issuers \\ -d &#39;{   \&quot;issuer_type\&quot;: \&quot;GLOBAL_SIGN\&quot;,   \&quot;name\&quot;: \&quot;GS Issuer\&quot;,   \&quot;description\&quot;: \&quot;Sample GlobalSign certificate issuer\&quot;,   \&quot;issuer_attributes\&quot;: null,   \&quot;issuer_credentials\&quot;: {       \&quot;api_key\&quot;: \&quot;e510e289e6cd8947\&quot;,       \&quot;api_secret\&quot;: \&quot;a477a8393d17a55ecb2ba6a61f58feb84770b621\&quot;,       \&quot;client_certificate\&quot;: \&quot;-----BEGIN CERTIFICATE-----MIIC7zCCAdegAwIBAgIJANTlU4x5S74VMA0GCSqGSIb3DQEBCwUAMA4xDDAKBgNVBAoMA0FybTAeFw0xODAzMTExMzE5MTFaFw0xOTAzMTExMzE5MTFaMA4xDDAKBgNVBAoMA0FybTCCASIwDQYJKoZIhvcNAQEBBQADggEPADCCAQoCggEBAJWLStsVMJULZtxdieK9qocM4ymDXMaAusmd9TZLzBgznKQe/CW2yxyA8C8K5e6MmvMYGeKDd4Lkw/ezOj2OsUj2xzNIltUxpGi/GhsNYiN/khNJa/Y1SllLoihJAPm/xbMywOBRu/dM88PiJsNZccOk0I8DYvvyAs9wCTkbKLnfHygl98DCRqXw7nBCplU6F03qpUd/4BUtMtugyqt7yboGH+4YewnUh4Yh4QNOJIvE93Ob++eKjO3pIOYEhQmUxzOLaLNuWXlv2l1WuN281hUP4XBcV8mCzRQfTBBDYTWt+5BEWoLOUkXjW0Um6EAaN3usph1IKDEH6Ia5VHP4Pj0CAwEAAaNQME4wHQYDVR0OBBYEFLsfYZxFcQTjPJKYMjHI2In316fmMB8GA1UdIwQYMBaAFLsfYZxFcQTjPJKYMjHI2In316fmMAwGA1UdEwQFMAMBAf8wDQYJKoZIhvcNAQELBQADggEBAFl08GFsIkkUs6M7QgCWmsnwP6PtD8V87wM1GAqQQlOOeztaeRR2TEOeYiKRZQugYszJ/FVfVp4ggqzepJMn6UZ42j5nmSJs+6t79i23QAzX1zNQ354lr/t7kt3fMdhuL3AP0oZGzdy+EnXXiWeAD22UwzvVmLt38ypJIl+pmTsx9jJy4PN7yoRgtP9k+50m3X6oDxVruehC/JPSeTvEhqyLW3fLcG6IoJMX3vIwfO9uXbFJumTowQeViNJJ9duWvD2KBXn/muOOBe97TPuvAms1gOtMmmPT9/jpo9b4+NsfFiAN6bMici81aIKZzLC+lLGOUmR2fFJyM5OsVLxKsko&#x3D;-----END CERTIFICATE-----\&quot;,         \&quot;private_key\&quot;:\&quot;-----BEGIN RSA PRIVATE KEY-----\\nProc-Type: 4,ENCRYPTED\\nDEK-Info: DES-EDE3-CBC,CCAC26A4133947CB\\n\\np3KJ4FI3wcz3I0MtiLkrznkjWFvprVmoNywySUGb5IqZViJZqCMEsyU9a9iDsSfP\\nZ07cg9GviV21WYIPSxZOQrpy1g1VWILzFnH+J6z8dSH4mxXh0PwdOzYgAeqkrIVM\\nJ7KRm6t222dZFjjXK3eEcLmBLGo29XwVJxKHx+l4++gU1LZmeHZR5M8fJ4jejUly\\n7sqzPlmRF0N3I4lwKVj+PfQTVz43QoCnpxOjuSEL4liBrc2agY2xH1O0PFyHimz9\\n3XM9HR/iuPHW0N2D+NPjXlWKacerupH9d4i9IYIagzB+HTgej8limdo03GmmxcZ6\\nYNa58n5yQSaqu0TPRU9DsrKeGjadHTlZQGdzfq1SWsROCnHLrXFKE2ozIG3+hxA5\\nujBF/QWpX5+inXUwDJhBxp8isHbPEnBEUUd6ZRzCTjvN0jaUti5B9yFhO2G6mbE8\\nCvhyzQK8oJqsjZXnlcpPf95LP+9XbcCDjLSIaWJstzXO9tPiv6+x1MVWmivtRHcC\\nSTzpx8jAGCiG6ejLqWB87ZXiZm7ujlCBheHSf5RHwNHhUvoP2JEYalDDRxjcDMSx\\n4uV42Np4yJlIQEDlGHcBlXoL7vEukFpuWgkYdpcZy/Ou9qz8mXrpLcu8C8MhLmSC\\nixGoR5iRhV7cxoHLyuCzj87eYEA73Xu238DQorSEEuiVFnLzQ2+PJMs4qoI14q/L\\notlBDz+Ko6DrU/EZROYmiqMkLKXR2sx9zNAJwPYRs6nSH08tZ3dwqzZbgtP3Wazi\\nhLWHt5/En7wQRA5a+/dDEHXSoLvvSQ9jvhclhWf+eCYuq2eH+g54oyJGRSY+8GV7\\nujhLxkzl/3OZdhZPWoz4U13KpbSTcNWu5Y7oGDoabw19UbvqmLf1PJkpDH/tQgzB\\nxYtsLBRUcofpYoeIiIxfAA4do5WilJc8xqrGhkE4WcHfY24HXAiOvsjbxV+BRprX\\n1jtgJpV/9nJESMap+8PxipGUFRGjB83/uwJaa6mLftEKflX8i4MZ+HnqraXERsqA\\nWRUcDHIWmFfpzIB3iNuxawVvPH8NdCSPmQ9qTb8Cozl0AuOK2E9S+ke8oiYQScWR\\nLdu+zhej7GjuQ9R+Ub+wPWqvOA5qLXejqnCexVScDUuN+z9JWM3N2FG1MwxhAzhP\\ndEfoQHoBn6uyOmrVGP6fosV3chqhPoec42KeOAm1xDvx692isaIy1jPgIyPxeqhm\\n2Tw4E+02R7dlP8Ljf7JzfLm4oKpWHWlcHeqg24x6lY/wXU1RBcWaTa0AQUwoGm2m\\nIQCPfIqOEv/QC2HpO7SVCYkl65KwR0oTd1AzYxdxEq3xHQbh69EL0FGZPVxVCPI+\\nhEAyifKy1/tm3l91Rf/kGpHY7nIQKCXH49tmFwix8gke2nZJmRgX7/zAdMOAKeKH\\nAaIl4nQtv14EbaasMgnn9qgaDYnWzaReEob2QlQ/WYlTor61+KFpGtcf9jAkgudT\\n2op+4CF7wT2+aTXdtkVWfmv++iB8GnlqZdxLvyG1cTYjjYHVFbMSWQnxzQqiE2ms\\nQgp+byjWCumpsWTMdTO+d9NkDOo80vDpaRxEgebmhJ0MbX+eFjBgVg&#x3D;&#x3D;\\n-----END RSA PRIVATE KEY-----\&quot;,       \&quot;passphrase\&quot;: \&quot;helloworld\&quot;   } }&#39; &#x60;&#x60;&#x60; 

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.internal.externalca.ApiClient;
//import com.arm.mbed.cloud.sdk.internal.externalca.ApiException;
//import com.arm.mbed.cloud.sdk.internal.externalca.Configuration;
//import com.arm.mbed.cloud.sdk.internal.externalca.auth.*;
//import com.arm.mbed.cloud.sdk.internal.externalca.api.CertificateIssuersApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

CertificateIssuersApi apiInstance = new CertificateIssuersApi();
String authorization = "authorization_example"; // String | Bearer {token}
CertificateIssuerRequest certificateIssuerRequest = new CertificateIssuerRequest(); // CertificateIssuerRequest | Certificate issuer request.
try {
    CertificateIssuerInfo result = apiInstance.createCertificateIssuer(authorization, certificateIssuerRequest);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling CertificateIssuersApi#createCertificateIssuer");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **authorization** | **String**| Bearer {token} |
 **certificateIssuerRequest** | [**CertificateIssuerRequest**](CertificateIssuerRequest.md)| Certificate issuer request. |

### Return type

[**CertificateIssuerInfo**](CertificateIssuerInfo.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: application/json;charset=UTF-8
 - **Accept**: application/json;charset=UTF-8

<a name="deleteCertificateIssuer"></a>
# **deleteCertificateIssuer**
> Void deleteCertificateIssuer(certificateIssuerId, authorization)

Delete certificate issuer.

Delete a certificate issuer by ID. &lt;br&gt; **Example usage:**  &#x60;&#x60;&#x60; curl -X DELETE \\ -H &#39;authorization: &lt;valid access token&gt;&#39; \\ https://api.us-east-1.mbedcloud.com/v3/certificate-issuers/0162155dc77d507b9d48a91b00000000 &#x60;&#x60;&#x60; 

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.internal.externalca.ApiClient;
//import com.arm.mbed.cloud.sdk.internal.externalca.ApiException;
//import com.arm.mbed.cloud.sdk.internal.externalca.Configuration;
//import com.arm.mbed.cloud.sdk.internal.externalca.auth.*;
//import com.arm.mbed.cloud.sdk.internal.externalca.api.CertificateIssuersApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

CertificateIssuersApi apiInstance = new CertificateIssuersApi();
String certificateIssuerId = "certificateIssuerId_example"; // String | Certificate issuer ID. <br> The ID of the certificate issuer. An active certificate issuer may not be deleted. 
String authorization = "authorization_example"; // String | Bearer {token}
try {
    Void result = apiInstance.deleteCertificateIssuer(certificateIssuerId, authorization);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling CertificateIssuersApi#deleteCertificateIssuer");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **certificateIssuerId** | **String**| Certificate issuer ID. &lt;br&gt; The ID of the certificate issuer. An active certificate issuer may not be deleted.  |
 **authorization** | **String**| Bearer {token} |

### Return type

[**Void**](.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: */*

<a name="getCertificateIssuer"></a>
# **getCertificateIssuer**
> CertificateIssuerInfo getCertificateIssuer(certificateIssuerId, authorization)

Get certificate issuer by ID.

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.internal.externalca.ApiClient;
//import com.arm.mbed.cloud.sdk.internal.externalca.ApiException;
//import com.arm.mbed.cloud.sdk.internal.externalca.Configuration;
//import com.arm.mbed.cloud.sdk.internal.externalca.auth.*;
//import com.arm.mbed.cloud.sdk.internal.externalca.api.CertificateIssuersApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

CertificateIssuersApi apiInstance = new CertificateIssuersApi();
String certificateIssuerId = "certificateIssuerId_example"; // String | Certificate issuer ID. The ID of the certificate issuer. 
String authorization = "authorization_example"; // String | Bearer {token}
try {
    CertificateIssuerInfo result = apiInstance.getCertificateIssuer(certificateIssuerId, authorization);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling CertificateIssuersApi#getCertificateIssuer");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **certificateIssuerId** | **String**| Certificate issuer ID. The ID of the certificate issuer.  |
 **authorization** | **String**| Bearer {token} |

### Return type

[**CertificateIssuerInfo**](CertificateIssuerInfo.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: application/json;charset=UTF-8
 - **Accept**: application/json;charset=UTF-8

<a name="getCertificateIssuers"></a>
# **getCertificateIssuers**
> CertificateIssuerInfoListResponse getCertificateIssuers(authorization)

Get certificate issuers list.

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.internal.externalca.ApiClient;
//import com.arm.mbed.cloud.sdk.internal.externalca.ApiException;
//import com.arm.mbed.cloud.sdk.internal.externalca.Configuration;
//import com.arm.mbed.cloud.sdk.internal.externalca.auth.*;
//import com.arm.mbed.cloud.sdk.internal.externalca.api.CertificateIssuersApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

CertificateIssuersApi apiInstance = new CertificateIssuersApi();
String authorization = "authorization_example"; // String | Bearer {token}
try {
    CertificateIssuerInfoListResponse result = apiInstance.getCertificateIssuers(authorization);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling CertificateIssuersApi#getCertificateIssuers");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **authorization** | **String**| Bearer {token} |

### Return type

[**CertificateIssuerInfoListResponse**](CertificateIssuerInfoListResponse.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json;charset=UTF-8

<a name="updateCertificateIssuer"></a>
# **updateCertificateIssuer**
> CertificateIssuerInfo updateCertificateIssuer(certificateIssuerId, authorization, certificateIssuerUpdateRequest)

Update certificate issuer.

Update a certificate issuer. &lt;br&gt; **Example usage:**  &#x60;&#x60;&#x60; curl -X PUT \\ -H &#39;authorization: &lt;valid access token&gt;&#39; \\ -H &#39;content-type: application/json;charset&#x3D;UTF-8&#39; \\ https://api.us-east-1.mbedcloud.com/v3/certificate-issuers/01621560be51507b9d48a91b00000000 \\ -d &#39;{   \&quot;description\&quot;: \&quot;Sample GlobalSign certificate issuer - updated.\&quot;,   \&quot;name\&quot;: \&quot;GlobalSign Issuer\&quot; }&#39; &#x60;&#x60;&#x60; 

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.internal.externalca.ApiClient;
//import com.arm.mbed.cloud.sdk.internal.externalca.ApiException;
//import com.arm.mbed.cloud.sdk.internal.externalca.Configuration;
//import com.arm.mbed.cloud.sdk.internal.externalca.auth.*;
//import com.arm.mbed.cloud.sdk.internal.externalca.api.CertificateIssuersApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

CertificateIssuersApi apiInstance = new CertificateIssuersApi();
String certificateIssuerId = "certificateIssuerId_example"; // String | Certificate issuer ID. <br> The ID of the certificate issuer. 
String authorization = "authorization_example"; // String | Bearer {token}
CertificateIssuerUpdateRequest certificateIssuerUpdateRequest = new CertificateIssuerUpdateRequest(); // CertificateIssuerUpdateRequest | Certificate issuer update request.
try {
    CertificateIssuerInfo result = apiInstance.updateCertificateIssuer(certificateIssuerId, authorization, certificateIssuerUpdateRequest);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling CertificateIssuersApi#updateCertificateIssuer");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **certificateIssuerId** | **String**| Certificate issuer ID. &lt;br&gt; The ID of the certificate issuer.  |
 **authorization** | **String**| Bearer {token} |
 **certificateIssuerUpdateRequest** | [**CertificateIssuerUpdateRequest**](CertificateIssuerUpdateRequest.md)| Certificate issuer update request. |

### Return type

[**CertificateIssuerInfo**](CertificateIssuerInfo.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: application/json;charset=UTF-8
 - **Accept**: application/json;charset=UTF-8

<a name="verifyCertificateIssuer"></a>
# **verifyCertificateIssuer**
> CertificateIssuerVerifyResponse verifyCertificateIssuer(certificateIssuerId, authorization)

Verify certificate issuer.

A utility API that can be used to validate the user configuration before activating a certificate issuer. Verifies that the certificate issuer is accessible and can be used to generate certificates by Arm Mbed Cloud. &lt;br&gt; **Note:** The API requests the 3rd party CA to sign a test certificate. For some 3rd party CAs, this operation may make use of the account quota. &lt;br&gt; **Example usage:**  &#x60;&#x60;&#x60; curl -X POST \\ -H &#39;authorization: &lt;valid access token&gt;&#39; \\ -H &#39;content-type: application/json;charset&#x3D;UTF-8&#39; \\ https://api.us-east-1.mbedcloud.com/v3/certificate-issuers/01621a36719d507b9d48a91b00000000/verify &#x60;&#x60;&#x60; 

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.internal.externalca.ApiClient;
//import com.arm.mbed.cloud.sdk.internal.externalca.ApiException;
//import com.arm.mbed.cloud.sdk.internal.externalca.Configuration;
//import com.arm.mbed.cloud.sdk.internal.externalca.auth.*;
//import com.arm.mbed.cloud.sdk.internal.externalca.api.CertificateIssuersApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

CertificateIssuersApi apiInstance = new CertificateIssuersApi();
String certificateIssuerId = "certificateIssuerId_example"; // String | Certificate issuer ID. <br> The ID of the certificate issuer. 
String authorization = "authorization_example"; // String | Bearer {token}
try {
    CertificateIssuerVerifyResponse result = apiInstance.verifyCertificateIssuer(certificateIssuerId, authorization);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling CertificateIssuersApi#verifyCertificateIssuer");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **certificateIssuerId** | **String**| Certificate issuer ID. &lt;br&gt; The ID of the certificate issuer.  |
 **authorization** | **String**| Bearer {token} |

### Return type

[**CertificateIssuerVerifyResponse**](CertificateIssuerVerifyResponse.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: application/json;charset=UTF-8
 - **Accept**: application/json;charset=UTF-8

