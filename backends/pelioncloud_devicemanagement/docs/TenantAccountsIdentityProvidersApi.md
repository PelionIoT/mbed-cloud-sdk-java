# TenantAccountsIdentityProvidersApi

All URIs are relative to *https://api.us-east-1.mbedcloud.com*

Method | HTTP request | Description
------------- | ------------- | -------------
[**createAccountIdentityProvider**](TenantAccountsIdentityProvidersApi.md#createAccountIdentityProvider) | **POST** v3/accounts/{account_id}/identity-providers | Create a new identity provider.
[**deleteAccountIdentityProvider**](TenantAccountsIdentityProvidersApi.md#deleteAccountIdentityProvider) | **DELETE** v3/accounts/{account_id}/identity-providers/{identity_provider_id} | Delete an identity provider by ID.
[**deleteAccountSpCertificate**](TenantAccountsIdentityProvidersApi.md#deleteAccountSpCertificate) | **POST** v3/accounts/{account_id}/identity-providers/{identity_provider_id}/delete-sp-certificate | Delete the service provider certificate.
[**generateAccountSpCertificate**](TenantAccountsIdentityProvidersApi.md#generateAccountSpCertificate) | **POST** v3/accounts/{account_id}/identity-providers/{identity_provider_id}/generate-sp-certificate | Generate a new service provider certificate.
[**getAccountIdentityProvider**](TenantAccountsIdentityProvidersApi.md#getAccountIdentityProvider) | **GET** v3/accounts/{account_id}/identity-providers/{identity_provider_id} | Retrieve identity provider by ID.
[**getAllAccountIdentityProviders**](TenantAccountsIdentityProvidersApi.md#getAllAccountIdentityProviders) | **GET** v3/accounts/{account_id}/identity-providers | Get all identity providers.
[**refreshAccountJwks**](TenantAccountsIdentityProvidersApi.md#refreshAccountJwks) | **POST** v3/accounts/{account_id}/identity-providers/{identity_provider_id}/refresh-jwks | Refreshes the OIDC signing keys.
[**updateAccountIdentityProvider**](TenantAccountsIdentityProvidersApi.md#updateAccountIdentityProvider) | **PUT** v3/accounts/{account_id}/identity-providers/{identity_provider_id} | Update an existing identity provider.


<a name="createAccountIdentityProvider"></a>
# **createAccountIdentityProvider**
> IdentityProviderInfo createAccountIdentityProvider(accountId, body, discovery)

Create a new identity provider.

Create a new identity provider.

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.TenantAccountsIdentityProvidersApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

TenantAccountsIdentityProvidersApi apiInstance = new TenantAccountsIdentityProvidersApi();
String accountId = "accountId_example"; // String | Account ID.
IdentityProviderCreationReq body = new IdentityProviderCreationReq(); // IdentityProviderCreationReq | Details of the identity provider to create.
Boolean discovery = true; // Boolean | Indicates that the OpenID Connect endpoints and keys should be set using the OpenID Connect Discovery mechanism. The following parameters are set automatically: * authorization_endpoint * token_endpoint * userinfo_endpoint * revocation_endpoint * jwks_uri * keys
try {
    IdentityProviderInfo result = apiInstance.createAccountIdentityProvider(accountId, body, discovery);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TenantAccountsIdentityProvidersApi#createAccountIdentityProvider");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **accountId** | **String**| Account ID. |
 **body** | [**IdentityProviderCreationReq**](IdentityProviderCreationReq.md)| Details of the identity provider to create. |
 **discovery** | **Boolean**| Indicates that the OpenID Connect endpoints and keys should be set using the OpenID Connect Discovery mechanism. The following parameters are set automatically: * authorization_endpoint * token_endpoint * userinfo_endpoint * revocation_endpoint * jwks_uri * keys | [optional]

### Return type

[**IdentityProviderInfo**](IdentityProviderInfo.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="deleteAccountIdentityProvider"></a>
# **deleteAccountIdentityProvider**
> Void deleteAccountIdentityProvider(accountId, identityProviderId)

Delete an identity provider by ID.

Delete an identity provider by ID.

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.TenantAccountsIdentityProvidersApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

TenantAccountsIdentityProvidersApi apiInstance = new TenantAccountsIdentityProvidersApi();
String accountId = "accountId_example"; // String | Account ID.
String identityProviderId = "identityProviderId_example"; // String | The ID of the identity provider to delete.
try {
    Void result = apiInstance.deleteAccountIdentityProvider(accountId, identityProviderId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TenantAccountsIdentityProvidersApi#deleteAccountIdentityProvider");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **accountId** | **String**| Account ID. |
 **identityProviderId** | **String**| The ID of the identity provider to delete. |

### Return type

[**Void**](.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="deleteAccountSpCertificate"></a>
# **deleteAccountSpCertificate**
> IdentityProviderInfo deleteAccountSpCertificate(accountId, identityProviderId)

Delete the service provider certificate.

Delete a service provider certificate.

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.TenantAccountsIdentityProvidersApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

TenantAccountsIdentityProvidersApi apiInstance = new TenantAccountsIdentityProvidersApi();
String accountId = "accountId_example"; // String | Account ID.
String identityProviderId = "identityProviderId_example"; // String | The ID of the identity provider whose certificate should be deleted.
try {
    IdentityProviderInfo result = apiInstance.deleteAccountSpCertificate(accountId, identityProviderId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TenantAccountsIdentityProvidersApi#deleteAccountSpCertificate");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **accountId** | **String**| Account ID. |
 **identityProviderId** | **String**| The ID of the identity provider whose certificate should be deleted. |

### Return type

[**IdentityProviderInfo**](IdentityProviderInfo.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="generateAccountSpCertificate"></a>
# **generateAccountSpCertificate**
> IdentityProviderInfo generateAccountSpCertificate(accountId, identityProviderId, body)

Generate a new service provider certificate.

Generate a new service provider certificate.

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.TenantAccountsIdentityProvidersApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

TenantAccountsIdentityProvidersApi apiInstance = new TenantAccountsIdentityProvidersApi();
String accountId = "accountId_example"; // String | Account ID.
String identityProviderId = "identityProviderId_example"; // String | The ID of the identity provider for which to generate a certificate.
CertificateGenerationReq body = new CertificateGenerationReq(); // CertificateGenerationReq | Details of the service provider certificate to be generated.
try {
    IdentityProviderInfo result = apiInstance.generateAccountSpCertificate(accountId, identityProviderId, body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TenantAccountsIdentityProvidersApi#generateAccountSpCertificate");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **accountId** | **String**| Account ID. |
 **identityProviderId** | **String**| The ID of the identity provider for which to generate a certificate. |
 **body** | [**CertificateGenerationReq**](CertificateGenerationReq.md)| Details of the service provider certificate to be generated. |

### Return type

[**IdentityProviderInfo**](IdentityProviderInfo.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getAccountIdentityProvider"></a>
# **getAccountIdentityProvider**
> IdentityProviderInfo getAccountIdentityProvider(accountId, identityProviderId)

Retrieve identity provider by ID.

Manage identity providers of a tenant account.

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.TenantAccountsIdentityProvidersApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

TenantAccountsIdentityProvidersApi apiInstance = new TenantAccountsIdentityProvidersApi();
String accountId = "accountId_example"; // String | Account ID.
String identityProviderId = "identityProviderId_example"; // String | The ID of the identity provider to retrieve.
try {
    IdentityProviderInfo result = apiInstance.getAccountIdentityProvider(accountId, identityProviderId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TenantAccountsIdentityProvidersApi#getAccountIdentityProvider");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **accountId** | **String**| Account ID. |
 **identityProviderId** | **String**| The ID of the identity provider to retrieve. |

### Return type

[**IdentityProviderInfo**](IdentityProviderInfo.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getAllAccountIdentityProviders"></a>
# **getAllAccountIdentityProviders**
> IdentityProviderList getAllAccountIdentityProviders(accountId, limit, after, order, include)

Get all identity providers.

Retrieve identity providers in an array.

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.TenantAccountsIdentityProvidersApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

TenantAccountsIdentityProvidersApi apiInstance = new TenantAccountsIdentityProvidersApi();
String accountId = "accountId_example"; // String | Account ID.
Integer limit = 50; // Integer | The number of results to return (2-1000). Default 50.
String after = "after_example"; // String | The entity ID to fetch after the given one.
String order = "ASC"; // String | Record order based on creation time. Acceptable values: ASC, DESC. Default: ASC.
String include = "include_example"; // String | Comma-separated additional data to return. Currently supported: total_count.
try {
    IdentityProviderList result = apiInstance.getAllAccountIdentityProviders(accountId, limit, after, order, include);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TenantAccountsIdentityProvidersApi#getAllAccountIdentityProviders");
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

### Return type

[**IdentityProviderList**](IdentityProviderList.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="refreshAccountJwks"></a>
# **refreshAccountJwks**
> IdentityProviderInfo refreshAccountJwks(accountId, identityProviderId)

Refreshes the OIDC signing keys.

Refreshes an OIDC IdP&#39;s signing keys.

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.TenantAccountsIdentityProvidersApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

TenantAccountsIdentityProvidersApi apiInstance = new TenantAccountsIdentityProvidersApi();
String accountId = "accountId_example"; // String | The ID of the account to be managed.
String identityProviderId = "identityProviderId_example"; // String | The ID of the identity provider for which to refresh the signing keys.
try {
    IdentityProviderInfo result = apiInstance.refreshAccountJwks(accountId, identityProviderId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TenantAccountsIdentityProvidersApi#refreshAccountJwks");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **accountId** | **String**| The ID of the account to be managed. |
 **identityProviderId** | **String**| The ID of the identity provider for which to refresh the signing keys. |

### Return type

[**IdentityProviderInfo**](IdentityProviderInfo.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="updateAccountIdentityProvider"></a>
# **updateAccountIdentityProvider**
> IdentityProviderInfo updateAccountIdentityProvider(accountId, identityProviderId, body, discovery)

Update an existing identity provider.

Update an existing identity provider.

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.TenantAccountsIdentityProvidersApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

TenantAccountsIdentityProvidersApi apiInstance = new TenantAccountsIdentityProvidersApi();
String accountId = "accountId_example"; // String | Account ID.
String identityProviderId = "identityProviderId_example"; // String | The ID of the identity provider to update.
IdentityProviderUpdateReq body = new IdentityProviderUpdateReq(); // IdentityProviderUpdateReq | Details of the identity provider to update.
Boolean discovery = true; // Boolean | Indicates that the OpenID Connect endpoints and keys should be set using the OpenID Connect Discovery mechanism. The following parameters are set automatically: * authorization_endpoint * token_endpoint * userinfo_endpoint * revocation_endpoint * jwks_uri * keys
try {
    IdentityProviderInfo result = apiInstance.updateAccountIdentityProvider(accountId, identityProviderId, body, discovery);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TenantAccountsIdentityProvidersApi#updateAccountIdentityProvider");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **accountId** | **String**| Account ID. |
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

