# AccountIdentityProvidersApi

All URIs are relative to *https://api.us-east-1.mbedcloud.com*

Method | HTTP request | Description
------------- | ------------- | -------------
[**createIdentityProvider**](AccountIdentityProvidersApi.md#createIdentityProvider) | **POST** v3/identity-providers | Create a new identity provider.
[**deleteIdentityProvider**](AccountIdentityProvidersApi.md#deleteIdentityProvider) | **DELETE** v3/identity-providers/{identity_provider_id} | Delete an identity provider by ID.
[**deleteSpCertificate**](AccountIdentityProvidersApi.md#deleteSpCertificate) | **POST** v3/identity-providers/{identity_provider_id}/delete-sp-certificate | Delete the service provider certificate.
[**generateSpCertificate**](AccountIdentityProvidersApi.md#generateSpCertificate) | **POST** v3/identity-providers/{identity_provider_id}/generate-sp-certificate | Generate a new service provider certificate.
[**getAllIdentityProviders**](AccountIdentityProvidersApi.md#getAllIdentityProviders) | **GET** v3/identity-providers | Get all identity providers.
[**getIdentityProvider**](AccountIdentityProvidersApi.md#getIdentityProvider) | **GET** v3/identity-providers/{identity_provider_id} | Get identity provider by ID.
[**refreshJwks**](AccountIdentityProvidersApi.md#refreshJwks) | **POST** v3/identity-providers/{identity_provider_id}/refresh-jwks | Refreshes the OIDC signing keys.
[**updateIdentityProvider**](AccountIdentityProvidersApi.md#updateIdentityProvider) | **PUT** v3/identity-providers/{identity_provider_id} | Update an existing identity provider.


<a name="createIdentityProvider"></a>
# **createIdentityProvider**
> IdentityProviderInfo createIdentityProvider(body, discovery)

Create a new identity provider.

Create a new identity provider.

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.AccountIdentityProvidersApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

AccountIdentityProvidersApi apiInstance = new AccountIdentityProvidersApi();
IdentityProviderCreationReq body = new IdentityProviderCreationReq(); // IdentityProviderCreationReq | Details of the identity provider to create.
Boolean discovery = true; // Boolean | Indicates that the OpenID Connect endpoints and keys should be set using the OpenID Connect Discovery mechanism. The following parameters are set automatically: * authorization_endpoint * token_endpoint * userinfo_endpoint * revocation_endpoint * jwks_uri * keys
try {
    IdentityProviderInfo result = apiInstance.createIdentityProvider(body, discovery);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AccountIdentityProvidersApi#createIdentityProvider");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**IdentityProviderCreationReq**](IdentityProviderCreationReq.md)| Details of the identity provider to create. |
 **discovery** | **Boolean**| Indicates that the OpenID Connect endpoints and keys should be set using the OpenID Connect Discovery mechanism. The following parameters are set automatically: * authorization_endpoint * token_endpoint * userinfo_endpoint * revocation_endpoint * jwks_uri * keys | [optional]

### Return type

[**IdentityProviderInfo**](IdentityProviderInfo.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="deleteIdentityProvider"></a>
# **deleteIdentityProvider**
> Void deleteIdentityProvider(identityProviderId)

Delete an identity provider by ID.

Delete an identity provider by ID.

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.AccountIdentityProvidersApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

AccountIdentityProvidersApi apiInstance = new AccountIdentityProvidersApi();
String identityProviderId = "identityProviderId_example"; // String | The ID of the identity provider to delete.
try {
    Void result = apiInstance.deleteIdentityProvider(identityProviderId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AccountIdentityProvidersApi#deleteIdentityProvider");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **identityProviderId** | **String**| The ID of the identity provider to delete. |

### Return type

[**Void**](.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="deleteSpCertificate"></a>
# **deleteSpCertificate**
> IdentityProviderInfo deleteSpCertificate(identityProviderId)

Delete the service provider certificate.

Delete a service provider certificate.

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.AccountIdentityProvidersApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

AccountIdentityProvidersApi apiInstance = new AccountIdentityProvidersApi();
String identityProviderId = "identityProviderId_example"; // String | The ID of the identity provider.
try {
    IdentityProviderInfo result = apiInstance.deleteSpCertificate(identityProviderId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AccountIdentityProvidersApi#deleteSpCertificate");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **identityProviderId** | **String**| The ID of the identity provider. |

### Return type

[**IdentityProviderInfo**](IdentityProviderInfo.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="generateSpCertificate"></a>
# **generateSpCertificate**
> IdentityProviderInfo generateSpCertificate(identityProviderId, body)

Generate a new service provider certificate.

Generate a new service provider certificate.

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.AccountIdentityProvidersApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

AccountIdentityProvidersApi apiInstance = new AccountIdentityProvidersApi();
String identityProviderId = "identityProviderId_example"; // String | The ID of the identity provider to generate a certificate for.
CertificateGenerationReq body = new CertificateGenerationReq(); // CertificateGenerationReq | Details of the service provider certificate to generate.
try {
    IdentityProviderInfo result = apiInstance.generateSpCertificate(identityProviderId, body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AccountIdentityProvidersApi#generateSpCertificate");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **identityProviderId** | **String**| The ID of the identity provider to generate a certificate for. |
 **body** | [**CertificateGenerationReq**](CertificateGenerationReq.md)| Details of the service provider certificate to generate. | [optional]

### Return type

[**IdentityProviderInfo**](IdentityProviderInfo.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getAllIdentityProviders"></a>
# **getAllIdentityProviders**
> IdentityProviderList getAllIdentityProviders(limit, after, order, include)

Get all identity providers.

Retrieve identity providers in an array.

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.AccountIdentityProvidersApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

AccountIdentityProvidersApi apiInstance = new AccountIdentityProvidersApi();
Integer limit = 50; // Integer | The number of results to return (2-1000). Default 50.
String after = "after_example"; // String | The entity ID to fetch after the given one.
String order = "ASC"; // String | Record order based on creation time. Acceptable values: ASC, DESC. Default: ASC.
String include = "include_example"; // String | Comma-separated additional data to return. Currently supported: total_count.
try {
    IdentityProviderList result = apiInstance.getAllIdentityProviders(limit, after, order, include);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AccountIdentityProvidersApi#getAllIdentityProviders");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **limit** | **Integer**| The number of results to return (2-1000). Default 50. | [optional] [default to 50]
 **after** | **String**| The entity ID to fetch after the given one. | [optional]
 **order** | **String**| Record order based on creation time. Acceptable values: ASC, DESC. Default: ASC. | [optional] [default to ASC]
 **include** | **String**| Comma-separated additional data to return. Currently supported: total_count. | [optional]

### Return type

[**IdentityProviderList**](IdentityProviderList.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getIdentityProvider"></a>
# **getIdentityProvider**
> IdentityProviderInfo getIdentityProvider(identityProviderId)

Get identity provider by ID.

Retrieve by ID.

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.AccountIdentityProvidersApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

AccountIdentityProvidersApi apiInstance = new AccountIdentityProvidersApi();
String identityProviderId = "identityProviderId_example"; // String | The ID of the identity provider to retrieve.
try {
    IdentityProviderInfo result = apiInstance.getIdentityProvider(identityProviderId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AccountIdentityProvidersApi#getIdentityProvider");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **identityProviderId** | **String**| The ID of the identity provider to retrieve. |

### Return type

[**IdentityProviderInfo**](IdentityProviderInfo.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="refreshJwks"></a>
# **refreshJwks**
> IdentityProviderInfo refreshJwks(identityProviderId)

Refreshes the OIDC signing keys.

Refreshes an OIDC IdP&#39;s signing keys.

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.AccountIdentityProvidersApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

AccountIdentityProvidersApi apiInstance = new AccountIdentityProvidersApi();
String identityProviderId = "identityProviderId_example"; // String | The ID of the identity provider for which to refresh the signing keys.
try {
    IdentityProviderInfo result = apiInstance.refreshJwks(identityProviderId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AccountIdentityProvidersApi#refreshJwks");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **identityProviderId** | **String**| The ID of the identity provider for which to refresh the signing keys. |

### Return type

[**IdentityProviderInfo**](IdentityProviderInfo.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="updateIdentityProvider"></a>
# **updateIdentityProvider**
> IdentityProviderInfo updateIdentityProvider(identityProviderId, body, discovery)

Update an existing identity provider.

Update an existing identity provider.

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.AccountIdentityProvidersApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

AccountIdentityProvidersApi apiInstance = new AccountIdentityProvidersApi();
String identityProviderId = "identityProviderId_example"; // String | The ID of the identity provider to update.
IdentityProviderUpdateReq body = new IdentityProviderUpdateReq(); // IdentityProviderUpdateReq | Details of the identity provider to update.
Boolean discovery = true; // Boolean | Indicates that the OpenID Connect endpoints and keys should be set using the OpenID Connect Discovery mechanism. The following parameters are set automatically: * authorization_endpoint * token_endpoint * userinfo_endpoint * revocation_endpoint * jwks_uri * keys
try {
    IdentityProviderInfo result = apiInstance.updateIdentityProvider(identityProviderId, body, discovery);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AccountIdentityProvidersApi#updateIdentityProvider");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **identityProviderId** | **String**| The ID of the identity provider to update. |
 **body** | [**IdentityProviderUpdateReq**](IdentityProviderUpdateReq.md)| Details of the identity provider to update. |
 **discovery** | **Boolean**| Indicates that the OpenID Connect endpoints and keys should be set using the OpenID Connect Discovery mechanism. The following parameters are set automatically: * authorization_endpoint * token_endpoint * userinfo_endpoint * revocation_endpoint * jwks_uri * keys | [optional]

### Return type

[**IdentityProviderInfo**](IdentityProviderInfo.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

