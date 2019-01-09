# AggregatorAccountAdminApi

All URIs are relative to *https://api.us-east-1.mbedcloud.com*

Method | HTTP request | Description
------------- | ------------- | -------------
[**addAccountApiKeyToGroups**](AggregatorAccountAdminApi.md#addAccountApiKeyToGroups) | **POST** v3/accounts/{account_id}/api-keys/{apikey_id}/groups | Add API key to a list of groups.
[**addAccountCertificate**](AggregatorAccountAdminApi.md#addAccountCertificate) | **POST** v3/accounts/{account_id}/trusted-certificates | Upload new trusted certificate.
[**addAccountUserToGroups**](AggregatorAccountAdminApi.md#addAccountUserToGroups) | **POST** v3/accounts/{account_id}/users/{user_id}/groups | Add user to a list of groups.
[**addSubjectsToAccountGroup**](AggregatorAccountAdminApi.md#addSubjectsToAccountGroup) | **POST** v3/accounts/{account_id}/policy-groups/{group_id} | Add members to a group.
[**bulkSetAccountDarkColors**](AggregatorAccountAdminApi.md#bulkSetAccountDarkColors) | **PUT** v3/accounts/{account_id}/branding-colors/dark | Updates an array of branding colors in the dark theme.
[**bulkSetAccountLightColors**](AggregatorAccountAdminApi.md#bulkSetAccountLightColors) | **PUT** v3/accounts/{account_id}/branding-colors/light | Updates an array of branding colors in the light theme.
[**clearAccountDarkImage**](AggregatorAccountAdminApi.md#clearAccountDarkImage) | **POST** v3/accounts/{account_id}/branding-images/dark/{reference}/clear | Revert an image to default in the dark theme.
[**clearAccountLightImage**](AggregatorAccountAdminApi.md#clearAccountLightImage) | **POST** v3/accounts/{account_id}/branding-images/light/{reference}/clear | Revert an image to default in the light theme.
[**createAccount**](AggregatorAccountAdminApi.md#createAccount) | **POST** v3/accounts | Create a new account.
[**createAccountApiKey**](AggregatorAccountAdminApi.md#createAccountApiKey) | **POST** v3/accounts/{account_id}/api-keys | Create a new API key.
[**createAccountGroup**](AggregatorAccountAdminApi.md#createAccountGroup) | **POST** v3/accounts/{account_id}/policy-groups | Create a new group.
[**createAccountIdentityProvider**](AggregatorAccountAdminApi.md#createAccountIdentityProvider) | **POST** v3/accounts/{account_id}/identity-providers | Create a new identity provider.
[**createAccountInvitation**](AggregatorAccountAdminApi.md#createAccountInvitation) | **POST** v3/accounts/{account_id}/user-invitations | Create a user invitation.
[**createAccountUser**](AggregatorAccountAdminApi.md#createAccountUser) | **POST** v3/accounts/{account_id}/users | Create a new user.
[**deleteAccountApiKey**](AggregatorAccountAdminApi.md#deleteAccountApiKey) | **DELETE** v3/accounts/{account_id}/api-keys/{apikey_id} | Delete the API key.
[**deleteAccountCertificate**](AggregatorAccountAdminApi.md#deleteAccountCertificate) | **DELETE** v3/accounts/{account_id}/trusted-certificates/{cert_id} | Delete trusted certificate by ID.
[**deleteAccountGroup**](AggregatorAccountAdminApi.md#deleteAccountGroup) | **DELETE** v3/accounts/{account_id}/policy-groups/{group_id} | Delete a group.
[**deleteAccountIdentityProvider**](AggregatorAccountAdminApi.md#deleteAccountIdentityProvider) | **DELETE** v3/accounts/{account_id}/identity-providers/{identity_provider_id} | Delete an identity provider by ID.
[**deleteAccountInvitation**](AggregatorAccountAdminApi.md#deleteAccountInvitation) | **DELETE** v3/accounts/{account_id}/user-invitations/{invitation_id} | Delete a user invitation.
[**deleteAccountUser**](AggregatorAccountAdminApi.md#deleteAccountUser) | **DELETE** v3/accounts/{account_id}/users/{user_id} | Delete a user.
[**generateAccountSpCertificate**](AggregatorAccountAdminApi.md#generateAccountSpCertificate) | **POST** v3/accounts/{account_id}/identity-providers/{identity_provider_id}/generate-sp-certificate | Generate a new service provider certificate.
[**getAccountApiKey**](AggregatorAccountAdminApi.md#getAccountApiKey) | **GET** v3/accounts/{account_id}/api-keys/{apikey_id} | Get API key details.
[**getAccountCertificate**](AggregatorAccountAdminApi.md#getAccountCertificate) | **GET** v3/accounts/{account_id}/trusted-certificates/{cert_id} | Get trusted certificate by ID.
[**getAccountDarkColor**](AggregatorAccountAdminApi.md#getAccountDarkColor) | **GET** v3/accounts/{account_id}/branding-colors/dark/{reference} | Get branding color of the dark theme.
[**getAccountDarkColors**](AggregatorAccountAdminApi.md#getAccountDarkColors) | **GET** v3/accounts/{account_id}/branding-colors/dark | Get branding colors of the dark theme.
[**getAccountDarkImageData**](AggregatorAccountAdminApi.md#getAccountDarkImageData) | **GET** v3/accounts/{account_id}/branding-images/dark/{reference} | Get metadata of an image in the dark theme.
[**getAccountGroupSummary**](AggregatorAccountAdminApi.md#getAccountGroupSummary) | **GET** v3/accounts/{account_id}/policy-groups/{group_id} | Get group information.
[**getAccountIdentityProvider**](AggregatorAccountAdminApi.md#getAccountIdentityProvider) | **GET** v3/accounts/{account_id}/identity-providers/{identity_provider_id} | Get identity provider by ID.
[**getAccountInfo**](AggregatorAccountAdminApi.md#getAccountInfo) | **GET** v3/accounts/{account_id} | Get account info.
[**getAccountInvitation**](AggregatorAccountAdminApi.md#getAccountInvitation) | **GET** v3/accounts/{account_id}/user-invitations/{invitation_id} | Details of a user invitation.
[**getAccountLightColor**](AggregatorAccountAdminApi.md#getAccountLightColor) | **GET** v3/accounts/{account_id}/branding-colors/light/{reference} | Get branding color of the light theme.
[**getAccountLightColors**](AggregatorAccountAdminApi.md#getAccountLightColors) | **GET** v3/accounts/{account_id}/branding-colors/light | Get branding colors of the light theme.
[**getAccountLightImageData**](AggregatorAccountAdminApi.md#getAccountLightImageData) | **GET** v3/accounts/{account_id}/branding-images/light/{reference} | Get metadata of an image in the light theme.
[**getAccountNofificationEntries**](AggregatorAccountAdminApi.md#getAccountNofificationEntries) | **GET** v3/accounts/{account_id}/notifications | Get the notification events of an account.
[**getAccountUser**](AggregatorAccountAdminApi.md#getAccountUser) | **GET** v3/accounts/{account_id}/users/{user_id} | Details of the user.
[**getAllAccountApiKeys**](AggregatorAccountAdminApi.md#getAllAccountApiKeys) | **GET** v3/accounts/{account_id}/api-keys | Get all API keys.
[**getAllAccountCertificates**](AggregatorAccountAdminApi.md#getAllAccountCertificates) | **GET** v3/accounts/{account_id}/trusted-certificates | Get all trusted certificates.
[**getAllAccountDarkImageData**](AggregatorAccountAdminApi.md#getAllAccountDarkImageData) | **GET** v3/accounts/{account_id}/branding-images/dark | Get metadata of all images in the dark theme.
[**getAllAccountGroups**](AggregatorAccountAdminApi.md#getAllAccountGroups) | **GET** v3/accounts/{account_id}/policy-groups | Get all group information.
[**getAllAccountIdentityProviders**](AggregatorAccountAdminApi.md#getAllAccountIdentityProviders) | **GET** v3/accounts/{account_id}/identity-providers | Get all identity providers.
[**getAllAccountInvitations**](AggregatorAccountAdminApi.md#getAllAccountInvitations) | **GET** v3/accounts/{account_id}/user-invitations | Get the details of all the user invitations.
[**getAllAccountLightImageData**](AggregatorAccountAdminApi.md#getAllAccountLightImageData) | **GET** v3/accounts/{account_id}/branding-images/light | Get metadata of all images in the light theme.
[**getAllAccountUsers**](AggregatorAccountAdminApi.md#getAllAccountUsers) | **GET** v3/accounts/{account_id}/users | Get all user details.
[**getAllAccounts**](AggregatorAccountAdminApi.md#getAllAccounts) | **GET** v3/accounts | Get all accounts.
[**getApiKeysOfAccountGroup**](AggregatorAccountAdminApi.md#getApiKeysOfAccountGroup) | **GET** v3/accounts/{account_id}/policy-groups/{group_id}/api-keys | Get API keys of a group.
[**getGroupsOfAccountApikey**](AggregatorAccountAdminApi.md#getGroupsOfAccountApikey) | **GET** v3/accounts/{account_id}/api-keys/{apikey_id}/groups | Get groups of the API key.
[**getGroupsOfAccountUser**](AggregatorAccountAdminApi.md#getGroupsOfAccountUser) | **GET** v3/accounts/{account_id}/users/{user_id}/groups | Get groups of the user.
[**getUsersOfAccountGroup**](AggregatorAccountAdminApi.md#getUsersOfAccountGroup) | **GET** v3/accounts/{account_id}/policy-groups/{group_id}/users | Get users of a group.
[**removeAccountApiKeyFromGroups**](AggregatorAccountAdminApi.md#removeAccountApiKeyFromGroups) | **DELETE** v3/accounts/{account_id}/api-keys/{apikey_id}/groups | Remove API key from groups.
[**removeAccountUserFromGroups**](AggregatorAccountAdminApi.md#removeAccountUserFromGroups) | **DELETE** v3/accounts/{account_id}/users/{user_id}/groups | Remove user from groups.
[**removeApiKeysFromAccountGroup**](AggregatorAccountAdminApi.md#removeApiKeysFromAccountGroup) | **DELETE** v3/accounts/{account_id}/policy-groups/{group_id}/api-keys | Remove API keys from a group.
[**removeUsersFromAccountGroup**](AggregatorAccountAdminApi.md#removeUsersFromAccountGroup) | **DELETE** v3/accounts/{account_id}/policy-groups/{group_id}/users | Remove users from a group.
[**resetAccountApiKeySecret**](AggregatorAccountAdminApi.md#resetAccountApiKeySecret) | **POST** v3/accounts/{account_id}/api-keys/{apikey_id}/reset-secret | Reset the secret key.
[**resetAccountDarkColor**](AggregatorAccountAdminApi.md#resetAccountDarkColor) | **DELETE** v3/accounts/{account_id}/branding-colors/dark/{reference} | Reset branding color to default.
[**resetAccountLightColor**](AggregatorAccountAdminApi.md#resetAccountLightColor) | **DELETE** v3/accounts/{account_id}/branding-colors/light/{reference} | Reset branding color to default.
[**setAccountDarkColor**](AggregatorAccountAdminApi.md#setAccountDarkColor) | **PUT** v3/accounts/{account_id}/branding-colors/dark/{reference} | Updates a branding color in the dark theme.
[**setAccountLightColor**](AggregatorAccountAdminApi.md#setAccountLightColor) | **PUT** v3/accounts/{account_id}/branding-colors/light/{reference} | Updates a branding color in the light theme.
[**updateAccount**](AggregatorAccountAdminApi.md#updateAccount) | **PUT** v3/accounts/{account_id} | Update attributes of an existing account.
[**updateAccountApiKey**](AggregatorAccountAdminApi.md#updateAccountApiKey) | **PUT** v3/accounts/{account_id}/api-keys/{apikey_id} | Update API key details.
[**updateAccountCertificate**](AggregatorAccountAdminApi.md#updateAccountCertificate) | **PUT** v3/accounts/{account_id}/trusted-certificates/{cert_id} | Update trusted certificate.
[**updateAccountGroupName**](AggregatorAccountAdminApi.md#updateAccountGroupName) | **PUT** v3/accounts/{account_id}/policy-groups/{group_id} | Update the group name.
[**updateAccountIdentityProvider**](AggregatorAccountAdminApi.md#updateAccountIdentityProvider) | **PUT** v3/accounts/{account_id}/identity-providers/{identity_provider_id} | Update an existing identity provider.
[**updateAccountUser**](AggregatorAccountAdminApi.md#updateAccountUser) | **PUT** v3/accounts/{account_id}/users/{user_id} | Update user details.
[**uploadAccountDarkImage**](AggregatorAccountAdminApi.md#uploadAccountDarkImage) | **POST** v3/accounts/{account_id}/branding-images/dark/{reference}/upload | Upload an image in the dark theme.
[**uploadAccountLightImage**](AggregatorAccountAdminApi.md#uploadAccountLightImage) | **POST** v3/accounts/{account_id}/branding-images/light/{reference}/upload | Upload an image in the light theme.
[**validateAccountUserEmail**](AggregatorAccountAdminApi.md#validateAccountUserEmail) | **POST** v3/accounts/{account_id}/users/{user_id}/validate-email | Validate the user email.


<a name="addAccountApiKeyToGroups"></a>
# **addAccountApiKeyToGroups**
> UpdatedResponse addAccountApiKeyToGroups(accountId, apikeyId, body)

Add API key to a list of groups.

An endpoint for adding API key to groups.  **Example usage:** &#x60;curl -X POST https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/api-keys/{apikey_id}/groups -d &#39;[\&quot;0162056a9a1586f30242590700000000\&quot;,\&quot;0117056a9a1586f30242590700000000\&quot;]&#39; -H &#39;content-type: application/json&#39; -H &#39;Authorization: Bearer API_KEY&#39;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.AggregatorAccountAdminApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

AggregatorAccountAdminApi apiInstance = new AggregatorAccountAdminApi();
String accountId = "accountId_example"; // String | Account ID.
String apikeyId = "apikeyId_example"; // String | The ID of the API key to be added to the group.
List<String> body = Arrays.asList(new List<String>()); // List<String> | A list of IDs of the groups to be updated.
try {
    UpdatedResponse result = apiInstance.addAccountApiKeyToGroups(accountId, apikeyId, body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AggregatorAccountAdminApi#addAccountApiKeyToGroups");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **accountId** | **String**| Account ID. |
 **apikeyId** | **String**| The ID of the API key to be added to the group. |
 **body** | **List&lt;String&gt;**| A list of IDs of the groups to be updated. |

### Return type

[**UpdatedResponse**](UpdatedResponse.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="addAccountCertificate"></a>
# **addAccountCertificate**
> TrustedCertificateResp addAccountCertificate(accountId, body)

Upload new trusted certificate.

An endpoint for uploading new trusted certificates.  **Example usage:** &#x60;curl -X POST https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/trusted-certificates -d {\&quot;name\&quot;: \&quot;myCert1\&quot;, \&quot;description\&quot;: \&quot;very important cert\&quot;, \&quot;certificate\&quot;: \&quot;certificate_data\&quot;, \&quot;service\&quot;: \&quot;lwm2m\&quot;} -H &#39;content-type: application/json&#39; -H &#39;Authorization: Bearer API_KEY&#39;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.AggregatorAccountAdminApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

AggregatorAccountAdminApi apiInstance = new AggregatorAccountAdminApi();
String accountId = "accountId_example"; // String | Account ID.
TrustedCertificateReq body = new TrustedCertificateReq(); // TrustedCertificateReq | A trusted certificate object with attributes, signature is optional.
try {
    TrustedCertificateResp result = apiInstance.addAccountCertificate(accountId, body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AggregatorAccountAdminApi#addAccountCertificate");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **accountId** | **String**| Account ID. |
 **body** | [**TrustedCertificateReq**](TrustedCertificateReq.md)| A trusted certificate object with attributes, signature is optional. |

### Return type

[**TrustedCertificateResp**](TrustedCertificateResp.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="addAccountUserToGroups"></a>
# **addAccountUserToGroups**
> UpdatedResponse addAccountUserToGroups(accountId, userId, body)

Add user to a list of groups.

An endpoint for adding user to groups.  **Example usage:** &#x60;curl -X POST https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/users/{user_id}/groups -d &#39;[\&quot;0162056a9a1586f30242590700000000\&quot;,\&quot;0117056a9a1586f30242590700000000\&quot;]&#39; -H &#39;content-type: application/json&#39; -H &#39;Authorization: Bearer API_KEY&#39;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.AggregatorAccountAdminApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

AggregatorAccountAdminApi apiInstance = new AggregatorAccountAdminApi();
String accountId = "accountId_example"; // String | Account ID.
String userId = "userId_example"; // String | The ID of the user to be added to the group.
List<String> body = Arrays.asList(new List<String>()); // List<String> | A list of IDs of the groups to be updated.
try {
    UpdatedResponse result = apiInstance.addAccountUserToGroups(accountId, userId, body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AggregatorAccountAdminApi#addAccountUserToGroups");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **accountId** | **String**| Account ID. |
 **userId** | **String**| The ID of the user to be added to the group. |
 **body** | **List&lt;String&gt;**| A list of IDs of the groups to be updated. |

### Return type

[**UpdatedResponse**](UpdatedResponse.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="addSubjectsToAccountGroup"></a>
# **addSubjectsToAccountGroup**
> UpdatedResponse addSubjectsToAccountGroup(accountId, groupId, body)

Add members to a group.

An endpoint for adding users and API keys to groups.  **Example usage:** &#x60;curl -X POST https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/policy-groups/{group_id} -d &#39;{\&quot;users\&quot;: [\&quot;0162056a9a1586f30242590700000000\&quot;,\&quot;0117056a9a1586f30242590700000000\&quot;]}&#39; -H &#39;content-type: application/json&#39; -H &#39;Authorization: Bearer API_KEY&#39;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.AggregatorAccountAdminApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

AggregatorAccountAdminApi apiInstance = new AggregatorAccountAdminApi();
String accountId = "accountId_example"; // String | Account ID.
String groupId = "groupId_example"; // String | The ID of the group to be updated.
SubjectList body = new SubjectList(); // SubjectList | A list of users and API keys to be added to the group.
try {
    UpdatedResponse result = apiInstance.addSubjectsToAccountGroup(accountId, groupId, body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AggregatorAccountAdminApi#addSubjectsToAccountGroup");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **accountId** | **String**| Account ID. |
 **groupId** | **String**| The ID of the group to be updated. |
 **body** | [**SubjectList**](SubjectList.md)| A list of users and API keys to be added to the group. |

### Return type

[**UpdatedResponse**](UpdatedResponse.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="bulkSetAccountDarkColors"></a>
# **bulkSetAccountDarkColors**
> Void bulkSetAccountDarkColors(accountId, body)

Updates an array of branding colors in the dark theme.

An endpoint for updating an array of branding colors in the dark theme.   **Example usage:** &#x60;curl -X PUT https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id)/branding-colors/dark &#39;[{ \&quot;reference\&quot;: \&quot;primary\&quot;,    \&quot;color\&quot;: \&quot;#f3f93e\&quot; }]&#39; -H &#39;content-type: application/json&#39; -H &#39;Authorization: Bearer API_KEY&#39;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.AggregatorAccountAdminApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

AggregatorAccountAdminApi apiInstance = new AggregatorAccountAdminApi();
String accountId = "accountId_example"; // String | Account ID.
List<BrandingColor> body = Arrays.asList(new BrandingColor()); // List<BrandingColor> | List of branding colors.
try {
    Void result = apiInstance.bulkSetAccountDarkColors(accountId, body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AggregatorAccountAdminApi#bulkSetAccountDarkColors");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **accountId** | **String**| Account ID. |
 **body** | [**List&lt;BrandingColor&gt;**](BrandingColor.md)| List of branding colors. |

### Return type

[**Void**](.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="bulkSetAccountLightColors"></a>
# **bulkSetAccountLightColors**
> Void bulkSetAccountLightColors(accountId, body)

Updates an array of branding colors in the light theme.

An endpoint for updating an array of branding colors in the light theme.   **Example usage:** &#x60;curl -X PUT https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id)/branding-colors/light &#39;[{ \&quot;reference\&quot;: \&quot;primary\&quot;,    \&quot;color\&quot;: \&quot;purple\&quot; }]&#39; -H &#39;content-type: application/json&#39; -H &#39;Authorization: Bearer API_KEY&#39;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.AggregatorAccountAdminApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

AggregatorAccountAdminApi apiInstance = new AggregatorAccountAdminApi();
String accountId = "accountId_example"; // String | Account ID.
List<BrandingColor> body = Arrays.asList(new BrandingColor()); // List<BrandingColor> | List of branding colors.
try {
    Void result = apiInstance.bulkSetAccountLightColors(accountId, body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AggregatorAccountAdminApi#bulkSetAccountLightColors");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **accountId** | **String**| Account ID. |
 **body** | [**List&lt;BrandingColor&gt;**](BrandingColor.md)| List of branding colors. |

### Return type

[**Void**](.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="clearAccountDarkImage"></a>
# **clearAccountDarkImage**
> Void clearAccountDarkImage(accountId, reference)

Revert an image to default in the dark theme.

An endpoint for reverting an account branding image to default in the dark theme.   **Example usage:** &#x60;curl -X POST https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/branding-images/dark/{reference}/clear -H &#39;Authorization: Bearer API_KEY&#39;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.AggregatorAccountAdminApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

AggregatorAccountAdminApi apiInstance = new AggregatorAccountAdminApi();
String accountId = "accountId_example"; // String | Account ID.
String reference = "reference_example"; // String | Name of the branding images (icon or picture).
try {
    Void result = apiInstance.clearAccountDarkImage(accountId, reference);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AggregatorAccountAdminApi#clearAccountDarkImage");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **accountId** | **String**| Account ID. |
 **reference** | **String**| Name of the branding images (icon or picture). | [enum: brand_logo_portrait, brand_logo_square, brand_logo_landscape, brand_logo_email, desktop_background_landscape, desktop_background_square, desktop_background_portrait, carousel_image_portrait_0, carousel_image_portrait_1, carousel_image_portrait_2, carousel_image_portrait_3, carousel_image_portrait_4, carousel_image_portrait_5, carousel_image_portrait_6, carousel_image_portrait_7, carousel_image_portrait_8, carousel_image_portrait_9, carousel_image_square_0, carousel_image_square_1, carousel_image_square_2, carousel_image_square_3, carousel_image_square_4, carousel_image_square_5, carousel_image_square_6, carousel_image_square_7, carousel_image_square_8, carousel_image_square_9, carousel_image_landscape_0, carousel_image_landscape_1, carousel_image_landscape_2, carousel_image_landscape_3, carousel_image_landscape_4, carousel_image_landscape_5, carousel_image_landscape_6, carousel_image_landscape_7, carousel_image_landscape_8, carousel_image_landscape_9]

### Return type

[**Void**](.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="clearAccountLightImage"></a>
# **clearAccountLightImage**
> Void clearAccountLightImage(accountId, reference)

Revert an image to default in the light theme.

An endpoint for reverting an account branding image to default in the light theme.   **Example usage:** &#x60;curl -X POST https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/branding-images/light/{reference}/clear -H &#39;Authorization: Bearer API_KEY&#39;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.AggregatorAccountAdminApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

AggregatorAccountAdminApi apiInstance = new AggregatorAccountAdminApi();
String accountId = "accountId_example"; // String | Account ID.
String reference = "reference_example"; // String | Name of the branding images (icon or picture).
try {
    Void result = apiInstance.clearAccountLightImage(accountId, reference);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AggregatorAccountAdminApi#clearAccountLightImage");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **accountId** | **String**| Account ID. |
 **reference** | **String**| Name of the branding images (icon or picture). | [enum: brand_logo_portrait, brand_logo_square, brand_logo_landscape, brand_logo_email, desktop_background_landscape, desktop_background_square, desktop_background_portrait, carousel_image_portrait_0, carousel_image_portrait_1, carousel_image_portrait_2, carousel_image_portrait_3, carousel_image_portrait_4, carousel_image_portrait_5, carousel_image_portrait_6, carousel_image_portrait_7, carousel_image_portrait_8, carousel_image_portrait_9, carousel_image_square_0, carousel_image_square_1, carousel_image_square_2, carousel_image_square_3, carousel_image_square_4, carousel_image_square_5, carousel_image_square_6, carousel_image_square_7, carousel_image_square_8, carousel_image_square_9, carousel_image_landscape_0, carousel_image_landscape_1, carousel_image_landscape_2, carousel_image_landscape_3, carousel_image_landscape_4, carousel_image_landscape_5, carousel_image_landscape_6, carousel_image_landscape_7, carousel_image_landscape_8, carousel_image_landscape_9]

### Return type

[**Void**](.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="createAccount"></a>
# **createAccount**
> AccountInfo createAccount(body, action)

Create a new account.

An endpoint for creating a new account.  **Example usage:** &#x60;curl -X POST https://api.us-east-1.mbedcloud.com/v3/accounts -d &#39;{\&quot;display_name\&quot;: \&quot;MyAccount1\&quot;, \&quot;admin_name\&quot;: \&quot;accountAdmin1\&quot;, \&quot;email\&quot;: \&quot;example_admin@myaccount.info\&quot;, \&quot;country\&quot;: \&quot;United Kingdom\&quot;, \&quot;end_market\&quot;: \&quot;Smart City\&quot;, \&quot;address_line1\&quot;: \&quot;110 Fulbourn Rd\&quot;, \&quot;city\&quot;: \&quot;Cambridge\&quot;, \&quot;contact\&quot;: \&quot;J. Doe\&quot;, \&quot;company\&quot;: \&quot;Arm\&quot;}&#39; -H &#39;content-type: application/json&#39; -H &#39;Authorization: Bearer API_KEY&#39;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.AggregatorAccountAdminApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

AggregatorAccountAdminApi apiInstance = new AggregatorAccountAdminApi();
AccountCreationReq body = new AccountCreationReq(); // AccountCreationReq | Details of the account to be created.
String action = "create"; // String | Action, either 'create' or 'enroll'. <ul><li>'create' creates the account where its admin user has ACTIVE status if admin_password was defined in the request, or RESET status if no admin_password was defined. If the user already exists, its status is not modified. </li><li>'enroll' creates the account where its admin user has ENROLLING status. If the user already exists, its status is not modified. Email to finish the enrollment or to notify the existing user about the new account is sent to the admin_email defined in the request. </li></ul>
try {
    AccountInfo result = apiInstance.createAccount(body, action);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AggregatorAccountAdminApi#createAccount");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**AccountCreationReq**](AccountCreationReq.md)| Details of the account to be created. |
 **action** | **String**| Action, either &#39;create&#39; or &#39;enroll&#39;. &lt;ul&gt;&lt;li&gt;&#39;create&#39; creates the account where its admin user has ACTIVE status if admin_password was defined in the request, or RESET status if no admin_password was defined. If the user already exists, its status is not modified. &lt;/li&gt;&lt;li&gt;&#39;enroll&#39; creates the account where its admin user has ENROLLING status. If the user already exists, its status is not modified. Email to finish the enrollment or to notify the existing user about the new account is sent to the admin_email defined in the request. &lt;/li&gt;&lt;/ul&gt; | [optional] [default to create]

### Return type

[**AccountInfo**](AccountInfo.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="createAccountApiKey"></a>
# **createAccountApiKey**
> ApiKeyInfoResp createAccountApiKey(accountId, body)

Create a new API key.

An endpoint for creating a new API key. There is no default value for the owner ID and it must be from the same account where the new API key is created.  **Example usage:** &#x60;curl -X POST https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/api-keys -d &#39;{\&quot;name\&quot;: \&quot;MyKey1\&quot;}&#39; -H &#39;content-type: application/json&#39; -H &#39;Authorization: Bearer API_KEY&#39;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.AggregatorAccountAdminApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

AggregatorAccountAdminApi apiInstance = new AggregatorAccountAdminApi();
String accountId = "accountId_example"; // String | Account ID.
ApiKeyInfoReq body = new ApiKeyInfoReq(); // ApiKeyInfoReq | Details of the API key to be created.
try {
    ApiKeyInfoResp result = apiInstance.createAccountApiKey(accountId, body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AggregatorAccountAdminApi#createAccountApiKey");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **accountId** | **String**| Account ID. |
 **body** | [**ApiKeyInfoReq**](ApiKeyInfoReq.md)| Details of the API key to be created. |

### Return type

[**ApiKeyInfoResp**](ApiKeyInfoResp.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="createAccountGroup"></a>
# **createAccountGroup**
> GroupSummary createAccountGroup(accountId, body)

Create a new group.

An endpoint for creating a new group.  **Example usage:** &#x60;curl -X POST https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/policy-groups -d &#39;{\&quot;name\&quot;: \&quot;MyGroup1\&quot;}&#39; -H &#39;content-type: application/json&#39; -H &#39;Authorization: Bearer API_KEY&#39;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.AggregatorAccountAdminApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

AggregatorAccountAdminApi apiInstance = new AggregatorAccountAdminApi();
String accountId = "accountId_example"; // String | Account ID.
GroupCreationInfo body = new GroupCreationInfo(); // GroupCreationInfo | Details of the group to be created.
try {
    GroupSummary result = apiInstance.createAccountGroup(accountId, body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AggregatorAccountAdminApi#createAccountGroup");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **accountId** | **String**| Account ID. |
 **body** | [**GroupCreationInfo**](GroupCreationInfo.md)| Details of the group to be created. |

### Return type

[**GroupSummary**](GroupSummary.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="createAccountIdentityProvider"></a>
# **createAccountIdentityProvider**
> IdentityProviderInfo createAccountIdentityProvider(accountId, body)

Create a new identity provider.

An endpoint for creating a new identity provider.

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.AggregatorAccountAdminApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

AggregatorAccountAdminApi apiInstance = new AggregatorAccountAdminApi();
String accountId = "accountId_example"; // String | Account ID.
IdentityProviderCreationReq body = new IdentityProviderCreationReq(); // IdentityProviderCreationReq | Details of the identity provider to be created.
try {
    IdentityProviderInfo result = apiInstance.createAccountIdentityProvider(accountId, body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AggregatorAccountAdminApi#createAccountIdentityProvider");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **accountId** | **String**| Account ID. |
 **body** | [**IdentityProviderCreationReq**](IdentityProviderCreationReq.md)| Details of the identity provider to be created. |

### Return type

[**IdentityProviderInfo**](IdentityProviderInfo.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="createAccountInvitation"></a>
# **createAccountInvitation**
> UserInvitationResp createAccountInvitation(accountId, body)

Create a user invitation.

An endpoint for inviting a new or an existing user to join the account.  **Example usage:** &#x60;curl -X POST https://api.us-east-1.mbedcloud.com/v3/accouns/{account_id}/user-invitations -d {\&quot;email\&quot;: \&quot;myemail@company.com\&quot;} -H &#39;content-type: application/json&#39; -H &#39;Authorization: Bearer API_KEY&#39;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.AggregatorAccountAdminApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

AggregatorAccountAdminApi apiInstance = new AggregatorAccountAdminApi();
String accountId = "accountId_example"; // String | Account ID.
UserInvitationReq body = new UserInvitationReq(); // UserInvitationReq | A user invitation object with attributes.
try {
    UserInvitationResp result = apiInstance.createAccountInvitation(accountId, body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AggregatorAccountAdminApi#createAccountInvitation");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **accountId** | **String**| Account ID. |
 **body** | [**UserInvitationReq**](UserInvitationReq.md)| A user invitation object with attributes. |

### Return type

[**UserInvitationResp**](UserInvitationResp.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="createAccountUser"></a>
# **createAccountUser**
> UserInfoResp createAccountUser(accountId, body, action)

Create a new user.

An endpoint for creating or inviting a new user to the account. In case of invitation email address is used only, other attributes are set in the 2nd step.  **Example usage:** &#x60;curl -X POST https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/users -d {\&quot;email\&quot;: \&quot;myemail@company.com\&quot;} -H &#39;content-type: application/json&#39; -H &#39;Authorization: Bearer API_KEY&#39;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.AggregatorAccountAdminApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

AggregatorAccountAdminApi apiInstance = new AggregatorAccountAdminApi();
String accountId = "accountId_example"; // String | Account ID.
UserInfoReq body = new UserInfoReq(); // UserInfoReq | A user object with attributes.
String action = "create"; // String | Create or invite user.
try {
    UserInfoResp result = apiInstance.createAccountUser(accountId, body, action);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AggregatorAccountAdminApi#createAccountUser");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **accountId** | **String**| Account ID. |
 **body** | [**UserInfoReq**](UserInfoReq.md)| A user object with attributes. |
 **action** | **String**| Create or invite user. | [optional] [default to create]

### Return type

[**UserInfoResp**](UserInfoResp.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="deleteAccountApiKey"></a>
# **deleteAccountApiKey**
> Void deleteAccountApiKey(accountId, apikeyId)

Delete the API key.

An endpoint for deleting an API key.  **Example usage:** &#x60;curl -X DELETE https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/api-keys/{apikey_id} -H &#39;Authorization: Bearer API_KEY&#39;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.AggregatorAccountAdminApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

AggregatorAccountAdminApi apiInstance = new AggregatorAccountAdminApi();
String accountId = "accountId_example"; // String | Account ID.
String apikeyId = "apikeyId_example"; // String | The ID of the API key to be deleted.
try {
    Void result = apiInstance.deleteAccountApiKey(accountId, apikeyId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AggregatorAccountAdminApi#deleteAccountApiKey");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **accountId** | **String**| Account ID. |
 **apikeyId** | **String**| The ID of the API key to be deleted. |

### Return type

[**Void**](.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="deleteAccountCertificate"></a>
# **deleteAccountCertificate**
> Void deleteAccountCertificate(accountId, certId)

Delete trusted certificate by ID.

An endpoint for deleting the trusted certificate.  **Example usage:** &#x60;curl -X DELETE https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/trusted-certificates/{cert_id} -H &#39;Authorization: Bearer API_KEY&#39;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.AggregatorAccountAdminApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

AggregatorAccountAdminApi apiInstance = new AggregatorAccountAdminApi();
String accountId = "accountId_example"; // String | Account ID.
String certId = "certId_example"; // String | The ID of the trusted certificate to be deleted.
try {
    Void result = apiInstance.deleteAccountCertificate(accountId, certId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AggregatorAccountAdminApi#deleteAccountCertificate");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **accountId** | **String**| Account ID. |
 **certId** | **String**| The ID of the trusted certificate to be deleted. |

### Return type

[**Void**](.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="deleteAccountGroup"></a>
# **deleteAccountGroup**
> Void deleteAccountGroup(accountId, groupId)

Delete a group.

An endpoint for deleting a group.  **Example usage:** &#x60;curl -X DELETE https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/policy-groups/{group_id} -H &#39;Authorization: Bearer API_KEY&#39;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.AggregatorAccountAdminApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

AggregatorAccountAdminApi apiInstance = new AggregatorAccountAdminApi();
String accountId = "accountId_example"; // String | Account ID.
String groupId = "groupId_example"; // String | The ID of the group to be deleted.
try {
    Void result = apiInstance.deleteAccountGroup(accountId, groupId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AggregatorAccountAdminApi#deleteAccountGroup");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **accountId** | **String**| Account ID. |
 **groupId** | **String**| The ID of the group to be deleted. |

### Return type

[**Void**](.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="deleteAccountIdentityProvider"></a>
# **deleteAccountIdentityProvider**
> Void deleteAccountIdentityProvider(accountId, identityProviderId)

Delete an identity provider by ID.

An endpoint for deleting an identity provider by ID.

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.AggregatorAccountAdminApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

AggregatorAccountAdminApi apiInstance = new AggregatorAccountAdminApi();
String accountId = "accountId_example"; // String | Account ID.
String identityProviderId = "identityProviderId_example"; // String | The ID of the identity provider to be deleted.
try {
    Void result = apiInstance.deleteAccountIdentityProvider(accountId, identityProviderId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AggregatorAccountAdminApi#deleteAccountIdentityProvider");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **accountId** | **String**| Account ID. |
 **identityProviderId** | **String**| The ID of the identity provider to be deleted. |

### Return type

[**Void**](.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="deleteAccountInvitation"></a>
# **deleteAccountInvitation**
> Void deleteAccountInvitation(accountId, invitationId)

Delete a user invitation.

An endpoint for deleting an active user invitation which has been sent for a new or an existing user to join the account.  **Example usage:** &#x60;curl -X DELETE https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/user-invitations/{invitation_id} -H &#39;Authorization: Bearer API_KEY&#39;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.AggregatorAccountAdminApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

AggregatorAccountAdminApi apiInstance = new AggregatorAccountAdminApi();
String accountId = "accountId_example"; // String | Account ID.
String invitationId = "invitationId_example"; // String | The ID of the invitation to be deleted.
try {
    Void result = apiInstance.deleteAccountInvitation(accountId, invitationId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AggregatorAccountAdminApi#deleteAccountInvitation");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **accountId** | **String**| Account ID. |
 **invitationId** | **String**| The ID of the invitation to be deleted. |

### Return type

[**Void**](.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="deleteAccountUser"></a>
# **deleteAccountUser**
> Void deleteAccountUser(accountId, userId)

Delete a user.

An endpoint for deleting a user.  **Example usage:** &#x60;curl -X DELETE https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/users/{user_id} -H &#39;Authorization: Bearer API_KEY&#39;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.AggregatorAccountAdminApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

AggregatorAccountAdminApi apiInstance = new AggregatorAccountAdminApi();
String accountId = "accountId_example"; // String | Account ID.
String userId = "userId_example"; // String | The ID of the user to be deleted.
try {
    Void result = apiInstance.deleteAccountUser(accountId, userId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AggregatorAccountAdminApi#deleteAccountUser");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **accountId** | **String**| Account ID. |
 **userId** | **String**| The ID of the user to be deleted. |

### Return type

[**Void**](.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="generateAccountSpCertificate"></a>
# **generateAccountSpCertificate**
> IdentityProviderInfo generateAccountSpCertificate(accountId, identityProviderId, body)

Generate a new service provider certificate.

An endpoint for generating a new service provider certificate.

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.AggregatorAccountAdminApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

AggregatorAccountAdminApi apiInstance = new AggregatorAccountAdminApi();
String accountId = "accountId_example"; // String | Account ID.
String identityProviderId = "identityProviderId_example"; // String | The ID of the identity provider to which the certificate should be generated for.
CertificateGenerationReq body = new CertificateGenerationReq(); // CertificateGenerationReq | Details of the service provider certificate to be generated.
try {
    IdentityProviderInfo result = apiInstance.generateAccountSpCertificate(accountId, identityProviderId, body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AggregatorAccountAdminApi#generateAccountSpCertificate");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **accountId** | **String**| Account ID. |
 **identityProviderId** | **String**| The ID of the identity provider to which the certificate should be generated for. |
 **body** | [**CertificateGenerationReq**](CertificateGenerationReq.md)| Details of the service provider certificate to be generated. |

### Return type

[**IdentityProviderInfo**](IdentityProviderInfo.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getAccountApiKey"></a>
# **getAccountApiKey**
> ApiKeyInfoResp getAccountApiKey(accountId, apikeyId)

Get API key details.

An endpoint for retrieving API key details.  **Example usage:** &#x60;curl https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/api-keys/{apikey_id} -H &#39;Authorization: Bearer API_KEY&#39;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.AggregatorAccountAdminApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

AggregatorAccountAdminApi apiInstance = new AggregatorAccountAdminApi();
String accountId = "accountId_example"; // String | Account ID.
String apikeyId = "apikeyId_example"; // String | The ID of the API key to be retrieved.
try {
    ApiKeyInfoResp result = apiInstance.getAccountApiKey(accountId, apikeyId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AggregatorAccountAdminApi#getAccountApiKey");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **accountId** | **String**| Account ID. |
 **apikeyId** | **String**| The ID of the API key to be retrieved. |

### Return type

[**ApiKeyInfoResp**](ApiKeyInfoResp.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getAccountCertificate"></a>
# **getAccountCertificate**
> TrustedCertificateResp getAccountCertificate(accountId, certId)

Get trusted certificate by ID.

An endpoint for retrieving a trusted certificate by ID.  **Example usage:** &#x60;curl https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/trusted-certificates/{cert_id} -H &#39;Authorization: Bearer API_KEY&#39;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.AggregatorAccountAdminApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

AggregatorAccountAdminApi apiInstance = new AggregatorAccountAdminApi();
String accountId = "accountId_example"; // String | Account ID.
String certId = "certId_example"; // String | The ID of the trusted certificate to be retrieved.
try {
    TrustedCertificateResp result = apiInstance.getAccountCertificate(accountId, certId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AggregatorAccountAdminApi#getAccountCertificate");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **accountId** | **String**| Account ID. |
 **certId** | **String**| The ID of the trusted certificate to be retrieved. |

### Return type

[**TrustedCertificateResp**](TrustedCertificateResp.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getAccountDarkColor"></a>
# **getAccountDarkColor**
> BrandingColor getAccountDarkColor(accountId, reference)

Get branding color of the dark theme.

Returns the requested branding color of the dark theme.   **Example usage:** &#x60;curl https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/branding-colors/dark/{reference} -H &#39;Authorization: Bearer API_KEY&#39;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.AggregatorAccountAdminApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

AggregatorAccountAdminApi apiInstance = new AggregatorAccountAdminApi();
String accountId = "accountId_example"; // String | Account ID.
String reference = "reference_example"; // String | The name of the branding color.
try {
    BrandingColor result = apiInstance.getAccountDarkColor(accountId, reference);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AggregatorAccountAdminApi#getAccountDarkColor");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **accountId** | **String**| Account ID. |
 **reference** | **String**| The name of the branding color. | [enum: error_color, primary, secondary, success_color, warning_color, canvas_background, canvas_background_font_color, workspace_background, workspace_background_font_color, info_color, info_font_color, primary_font_color, secondary_font_color, error_font_color, success_font_color, warning_font_color]

### Return type

[**BrandingColor**](BrandingColor.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getAccountDarkColors"></a>
# **getAccountDarkColors**
> BrandingColorList getAccountDarkColors(accountId)

Get branding colors of the dark theme.

Returns the branding colors of the dark theme.   **Example usage:** &#x60;curl https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/branding-colors/dark -H &#39;Authorization: Bearer API_KEY&#39;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.AggregatorAccountAdminApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

AggregatorAccountAdminApi apiInstance = new AggregatorAccountAdminApi();
String accountId = "accountId_example"; // String | Account ID.
try {
    BrandingColorList result = apiInstance.getAccountDarkColors(accountId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AggregatorAccountAdminApi#getAccountDarkColors");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **accountId** | **String**| Account ID. |

### Return type

[**BrandingColorList**](BrandingColorList.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getAccountDarkImageData"></a>
# **getAccountDarkImageData**
> BrandingImage getAccountDarkImageData(accountId, reference)

Get metadata of an image in the dark theme.

An endpoint for getting metadata of one account branding image in the dark theme.   **Example usage:** &#x60;curl https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/branding-images/dark/{reference} -H &#39;Authorization: Bearer API_KEY&#39;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.AggregatorAccountAdminApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

AggregatorAccountAdminApi apiInstance = new AggregatorAccountAdminApi();
String accountId = "accountId_example"; // String | Account ID.
String reference = "reference_example"; // String | Name of the branding images (icon or picture).
try {
    BrandingImage result = apiInstance.getAccountDarkImageData(accountId, reference);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AggregatorAccountAdminApi#getAccountDarkImageData");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **accountId** | **String**| Account ID. |
 **reference** | **String**| Name of the branding images (icon or picture). | [enum: brand_logo_portrait, brand_logo_square, brand_logo_landscape, brand_logo_email, desktop_background_landscape, desktop_background_square, desktop_background_portrait, carousel_image_portrait_0, carousel_image_portrait_1, carousel_image_portrait_2, carousel_image_portrait_3, carousel_image_portrait_4, carousel_image_portrait_5, carousel_image_portrait_6, carousel_image_portrait_7, carousel_image_portrait_8, carousel_image_portrait_9, carousel_image_square_0, carousel_image_square_1, carousel_image_square_2, carousel_image_square_3, carousel_image_square_4, carousel_image_square_5, carousel_image_square_6, carousel_image_square_7, carousel_image_square_8, carousel_image_square_9, carousel_image_landscape_0, carousel_image_landscape_1, carousel_image_landscape_2, carousel_image_landscape_3, carousel_image_landscape_4, carousel_image_landscape_5, carousel_image_landscape_6, carousel_image_landscape_7, carousel_image_landscape_8, carousel_image_landscape_9]

### Return type

[**BrandingImage**](BrandingImage.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getAccountGroupSummary"></a>
# **getAccountGroupSummary**
> GroupSummary getAccountGroupSummary(accountId, groupId)

Get group information.

An endpoint for getting general information about the group.  **Example usage:** &#x60;curl https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/policy-groups/{group_id} -H &#39;Authorization: Bearer API_KEY&#39;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.AggregatorAccountAdminApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

AggregatorAccountAdminApi apiInstance = new AggregatorAccountAdminApi();
String accountId = "accountId_example"; // String | Account ID.
String groupId = "groupId_example"; // String | The ID of the group to be retrieved.
try {
    GroupSummary result = apiInstance.getAccountGroupSummary(accountId, groupId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AggregatorAccountAdminApi#getAccountGroupSummary");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **accountId** | **String**| Account ID. |
 **groupId** | **String**| The ID of the group to be retrieved. |

### Return type

[**GroupSummary**](GroupSummary.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getAccountIdentityProvider"></a>
# **getAccountIdentityProvider**
> IdentityProviderInfo getAccountIdentityProvider(accountId, identityProviderId)

Get identity provider by ID.

An endpoint for retrieving an identity provider by ID.

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.AggregatorAccountAdminApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

AggregatorAccountAdminApi apiInstance = new AggregatorAccountAdminApi();
String accountId = "accountId_example"; // String | Account ID.
String identityProviderId = "identityProviderId_example"; // String | The ID of the identity provider to be retrieved.
try {
    IdentityProviderInfo result = apiInstance.getAccountIdentityProvider(accountId, identityProviderId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AggregatorAccountAdminApi#getAccountIdentityProvider");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **accountId** | **String**| Account ID. |
 **identityProviderId** | **String**| The ID of the identity provider to be retrieved. |

### Return type

[**IdentityProviderInfo**](IdentityProviderInfo.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getAccountInfo"></a>
# **getAccountInfo**
> AccountInfo getAccountInfo(accountId, include, properties)

Get account info.

Returns detailed information about the account.  **Example usage:** &#x60;curl https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id} -H &#39;Authorization: Bearer API_KEY&#39;&#x60;.

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.AggregatorAccountAdminApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

AggregatorAccountAdminApi apiInstance = new AggregatorAccountAdminApi();
String accountId = "accountId_example"; // String | The ID of the account to be fetched.
String include = "include_example"; // String | Comma separated additional data to return. Currently supported: limits, policies, sub_accounts
String properties = "properties_example"; // String | Property name to be returned from account specific properties.
try {
    AccountInfo result = apiInstance.getAccountInfo(accountId, include, properties);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AggregatorAccountAdminApi#getAccountInfo");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **accountId** | **String**| The ID of the account to be fetched. |
 **include** | **String**| Comma separated additional data to return. Currently supported: limits, policies, sub_accounts | [optional]
 **properties** | **String**| Property name to be returned from account specific properties. | [optional]

### Return type

[**AccountInfo**](AccountInfo.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getAccountInvitation"></a>
# **getAccountInvitation**
> UserInvitationResp getAccountInvitation(accountId, invitationId)

Details of a user invitation.

An endpoint for retrieving the details of an active user invitation sent for a new or an existing user to join the account.  **Example usage:** &#x60;curl https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/user-invitations/{invitation_id} -H &#39;Authorization: Bearer API_KEY&#39;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.AggregatorAccountAdminApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

AggregatorAccountAdminApi apiInstance = new AggregatorAccountAdminApi();
String accountId = "accountId_example"; // String | Account ID.
String invitationId = "invitationId_example"; // String | The ID of the invitation to be retrieved.
try {
    UserInvitationResp result = apiInstance.getAccountInvitation(accountId, invitationId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AggregatorAccountAdminApi#getAccountInvitation");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **accountId** | **String**| Account ID. |
 **invitationId** | **String**| The ID of the invitation to be retrieved. |

### Return type

[**UserInvitationResp**](UserInvitationResp.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getAccountLightColor"></a>
# **getAccountLightColor**
> BrandingColor getAccountLightColor(accountId, reference)

Get branding color of the light theme.

Returns the requested branding color of the light theme.   **Example usage:** &#x60;curl https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/branding-colors/light/{reference} -H &#39;Authorization: Bearer API_KEY&#39;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.AggregatorAccountAdminApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

AggregatorAccountAdminApi apiInstance = new AggregatorAccountAdminApi();
String accountId = "accountId_example"; // String | Account ID.
String reference = "reference_example"; // String | The name of the branding color.
try {
    BrandingColor result = apiInstance.getAccountLightColor(accountId, reference);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AggregatorAccountAdminApi#getAccountLightColor");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **accountId** | **String**| Account ID. |
 **reference** | **String**| The name of the branding color. | [enum: error_color, primary, secondary, success_color, warning_color, canvas_background, canvas_background_font_color, workspace_background, workspace_background_font_color, info_color, info_font_color, primary_font_color, secondary_font_color, error_font_color, success_font_color, warning_font_color]

### Return type

[**BrandingColor**](BrandingColor.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getAccountLightColors"></a>
# **getAccountLightColors**
> BrandingColorList getAccountLightColors(accountId)

Get branding colors of the light theme.

Returns the branding colors of the light theme.   **Example usage:** &#x60;curl https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/branding-colors/light -H &#39;Authorization: Bearer API_KEY&#39;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.AggregatorAccountAdminApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

AggregatorAccountAdminApi apiInstance = new AggregatorAccountAdminApi();
String accountId = "accountId_example"; // String | Account ID.
try {
    BrandingColorList result = apiInstance.getAccountLightColors(accountId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AggregatorAccountAdminApi#getAccountLightColors");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **accountId** | **String**| Account ID. |

### Return type

[**BrandingColorList**](BrandingColorList.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getAccountLightImageData"></a>
# **getAccountLightImageData**
> BrandingImage getAccountLightImageData(accountId, reference)

Get metadata of an image in the light theme.

An endpoint for getting metadata of one account branding image in the light theme.   **Example usage:** &#x60;curl https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/branding-images/light/{reference} -H &#39;Authorization: Bearer API_KEY&#39;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.AggregatorAccountAdminApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

AggregatorAccountAdminApi apiInstance = new AggregatorAccountAdminApi();
String accountId = "accountId_example"; // String | Account ID.
String reference = "reference_example"; // String | Name of the branding images (icon or picture).
try {
    BrandingImage result = apiInstance.getAccountLightImageData(accountId, reference);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AggregatorAccountAdminApi#getAccountLightImageData");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **accountId** | **String**| Account ID. |
 **reference** | **String**| Name of the branding images (icon or picture). | [enum: brand_logo_portrait, brand_logo_square, brand_logo_landscape, brand_logo_email, desktop_background_landscape, desktop_background_square, desktop_background_portrait, carousel_image_portrait_0, carousel_image_portrait_1, carousel_image_portrait_2, carousel_image_portrait_3, carousel_image_portrait_4, carousel_image_portrait_5, carousel_image_portrait_6, carousel_image_portrait_7, carousel_image_portrait_8, carousel_image_portrait_9, carousel_image_square_0, carousel_image_square_1, carousel_image_square_2, carousel_image_square_3, carousel_image_square_4, carousel_image_square_5, carousel_image_square_6, carousel_image_square_7, carousel_image_square_8, carousel_image_square_9, carousel_image_landscape_0, carousel_image_landscape_1, carousel_image_landscape_2, carousel_image_landscape_3, carousel_image_landscape_4, carousel_image_landscape_5, carousel_image_landscape_6, carousel_image_landscape_7, carousel_image_landscape_8, carousel_image_landscape_9]

### Return type

[**BrandingImage**](BrandingImage.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getAccountNofificationEntries"></a>
# **getAccountNofificationEntries**
> NotificationEntryList getAccountNofificationEntries(accountId, limit, after, order)

Get the notification events of an account.

Endpoint for retrieving notifications.

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.AggregatorAccountAdminApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

AggregatorAccountAdminApi apiInstance = new AggregatorAccountAdminApi();
String accountId = "accountId_example"; // String | Account ID.
Integer limit = 50; // Integer | The number of results to return (2-1000), default is 50.
String after = "after_example"; // String | The entity ID to fetch after the given one.
String order = "ASC"; // String | The order of the records based on creation time, ASC or DESC; by default ASC
try {
    NotificationEntryList result = apiInstance.getAccountNofificationEntries(accountId, limit, after, order);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AggregatorAccountAdminApi#getAccountNofificationEntries");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **accountId** | **String**| Account ID. |
 **limit** | **Integer**| The number of results to return (2-1000), default is 50. | [optional] [default to 50]
 **after** | **String**| The entity ID to fetch after the given one. | [optional]
 **order** | **String**| The order of the records based on creation time, ASC or DESC; by default ASC | [optional] [default to ASC]

### Return type

[**NotificationEntryList**](NotificationEntryList.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getAccountUser"></a>
# **getAccountUser**
> UserInfoResp getAccountUser(accountId, userId)

Details of the user.

An endpoint for retrieving details of the user.  **Example usage:** &#x60;curl https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/users/{user_id} -H &#39;Authorization: Bearer API_KEY&#39;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.AggregatorAccountAdminApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

AggregatorAccountAdminApi apiInstance = new AggregatorAccountAdminApi();
String accountId = "accountId_example"; // String | Account ID.
String userId = "userId_example"; // String | The ID of the user to be retrieved.
try {
    UserInfoResp result = apiInstance.getAccountUser(accountId, userId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AggregatorAccountAdminApi#getAccountUser");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **accountId** | **String**| Account ID. |
 **userId** | **String**| The ID of the user to be retrieved. |

### Return type

[**UserInfoResp**](UserInfoResp.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getAllAccountApiKeys"></a>
# **getAllAccountApiKeys**
> ApiKeyInfoRespList getAllAccountApiKeys(accountId, limit, after, order, include, keyEq, ownerEq)

Get all API keys.

An endpoint for retrieving the API keys in an array, optionally filtered by the owner.  **Example usage:** &#x60;curl https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/api-keys -H &#39;Authorization: Bearer API_KEY&#39;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.AggregatorAccountAdminApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

AggregatorAccountAdminApi apiInstance = new AggregatorAccountAdminApi();
String accountId = "accountId_example"; // String | Account ID.
Integer limit = 50; // Integer | The number of results to return (2-1000), default is 50.
String after = "after_example"; // String | The entity ID to fetch after the given one.
String order = "ASC"; // String | The order of the records based on creation time, ASC or DESC; by default ASC
String include = "include_example"; // String | Comma separated additional data to return. Currently supported: total_count
String keyEq = "keyEq_example"; // String | API key filter. Do not include the private part of the API key (the last 32 characters).
String ownerEq = "ownerEq_example"; // String | Owner name filter.
try {
    ApiKeyInfoRespList result = apiInstance.getAllAccountApiKeys(accountId, limit, after, order, include, keyEq, ownerEq);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AggregatorAccountAdminApi#getAllAccountApiKeys");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **accountId** | **String**| Account ID. |
 **limit** | **Integer**| The number of results to return (2-1000), default is 50. | [optional] [default to 50]
 **after** | **String**| The entity ID to fetch after the given one. | [optional]
 **order** | **String**| The order of the records based on creation time, ASC or DESC; by default ASC | [optional] [default to ASC]
 **include** | **String**| Comma separated additional data to return. Currently supported: total_count | [optional]
 **keyEq** | **String**| API key filter. Do not include the private part of the API key (the last 32 characters). | [optional]
 **ownerEq** | **String**| Owner name filter. | [optional]

### Return type

[**ApiKeyInfoRespList**](ApiKeyInfoRespList.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getAllAccountCertificates"></a>
# **getAllAccountCertificates**
> TrustedCertificateRespList getAllAccountCertificates(accountId, limit, after, order, include, nameEq, serviceEq, expireEq, deviceExecutionModeEq, deviceExecutionModeNeq, ownerEq, enrollmentModeEq, statusEq, issuerLike, subjectLike)

Get all trusted certificates.

An endpoint for retrieving trusted certificates in an array.  **Example usage:** &#x60;curl https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/trusted-certificates -H &#39;Authorization: Bearer API_KEY&#39;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.AggregatorAccountAdminApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

AggregatorAccountAdminApi apiInstance = new AggregatorAccountAdminApi();
String accountId = "accountId_example"; // String | Account ID.
Integer limit = 50; // Integer | The number of results to return (2-1000), default is 50.
String after = "after_example"; // String | The entity ID to fetch after the given one.
String order = "ASC"; // String | The order of the records based on creation time, ASC or DESC; by default ASC
String include = "include_example"; // String | Comma separated additional data to return. Currently supported: total_count
String nameEq = "nameEq_example"; // String | Filter for certificate name
String serviceEq = "serviceEq_example"; // String | Filter for service
Integer expireEq = 56; // Integer | Filter for expire
Integer deviceExecutionModeEq = 56; // Integer | Filter for developer certificates
Integer deviceExecutionModeNeq = 56; // Integer | Filter for not developer certificates
String ownerEq = "ownerEq_example"; // String | Owner name filter
Boolean enrollmentModeEq = true; // Boolean | Enrollment mode filter
String statusEq = "statusEq_example"; // String | Filter for certificate status
String issuerLike = "issuerLike_example"; // String | Filter for issuer. Finds all matches where the filter value is a case insensitive substring of the result. Example: issuer__like=cn=iss matches CN=issuer.
String subjectLike = "subjectLike_example"; // String | Filter for subject. Finds all matches where the filter value is a case insensitive substring of the result. Example: subject__like=cn=su matches CN=subject.
try {
    TrustedCertificateRespList result = apiInstance.getAllAccountCertificates(accountId, limit, after, order, include, nameEq, serviceEq, expireEq, deviceExecutionModeEq, deviceExecutionModeNeq, ownerEq, enrollmentModeEq, statusEq, issuerLike, subjectLike);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AggregatorAccountAdminApi#getAllAccountCertificates");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **accountId** | **String**| Account ID. |
 **limit** | **Integer**| The number of results to return (2-1000), default is 50. | [optional] [default to 50]
 **after** | **String**| The entity ID to fetch after the given one. | [optional]
 **order** | **String**| The order of the records based on creation time, ASC or DESC; by default ASC | [optional] [default to ASC]
 **include** | **String**| Comma separated additional data to return. Currently supported: total_count | [optional]
 **nameEq** | **String**| Filter for certificate name | [optional]
 **serviceEq** | **String**| Filter for service | [optional]
 **expireEq** | **Integer**| Filter for expire | [optional]
 **deviceExecutionModeEq** | **Integer**| Filter for developer certificates | [optional]
 **deviceExecutionModeNeq** | **Integer**| Filter for not developer certificates | [optional]
 **ownerEq** | **String**| Owner name filter | [optional]
 **enrollmentModeEq** | **Boolean**| Enrollment mode filter | [optional]
 **statusEq** | **String**| Filter for certificate status | [optional]
 **issuerLike** | **String**| Filter for issuer. Finds all matches where the filter value is a case insensitive substring of the result. Example: issuer__like&#x3D;cn&#x3D;iss matches CN&#x3D;issuer. | [optional]
 **subjectLike** | **String**| Filter for subject. Finds all matches where the filter value is a case insensitive substring of the result. Example: subject__like&#x3D;cn&#x3D;su matches CN&#x3D;subject. | [optional]

### Return type

[**TrustedCertificateRespList**](TrustedCertificateRespList.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getAllAccountDarkImageData"></a>
# **getAllAccountDarkImageData**
> BrandingImageList getAllAccountDarkImageData(accountId)

Get metadata of all images in the dark theme.

Returns the metadata of all branding images in the dark theme.   **Example usage:** &#x60;curl https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/branding-images/dark -H &#39;Authorization: Bearer API_KEY&#39;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.AggregatorAccountAdminApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

AggregatorAccountAdminApi apiInstance = new AggregatorAccountAdminApi();
String accountId = "accountId_example"; // String | Account ID.
try {
    BrandingImageList result = apiInstance.getAllAccountDarkImageData(accountId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AggregatorAccountAdminApi#getAllAccountDarkImageData");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **accountId** | **String**| Account ID. |

### Return type

[**BrandingImageList**](BrandingImageList.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getAllAccountGroups"></a>
# **getAllAccountGroups**
> GroupSummaryList getAllAccountGroups(accountId, limit, after, order, include, nameEq)

Get all group information.

An endpoint for retrieving all group information.  **Example usage:** &#x60;curl https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/policy-groups -H &#39;Authorization: Bearer API_KEY&#39;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.AggregatorAccountAdminApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

AggregatorAccountAdminApi apiInstance = new AggregatorAccountAdminApi();
String accountId = "accountId_example"; // String | Account ID.
Integer limit = 50; // Integer | The number of results to return (2-1000), default is 50.
String after = "after_example"; // String | The entity ID to fetch after the given one.
String order = "ASC"; // String | The order of the records based on creation time, ASC or DESC; by default ASC
String include = "include_example"; // String | Comma separated additional data to return. Currently supported: total_count
String nameEq = "nameEq_example"; // String | Filter for group name
try {
    GroupSummaryList result = apiInstance.getAllAccountGroups(accountId, limit, after, order, include, nameEq);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AggregatorAccountAdminApi#getAllAccountGroups");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **accountId** | **String**| Account ID. |
 **limit** | **Integer**| The number of results to return (2-1000), default is 50. | [optional] [default to 50]
 **after** | **String**| The entity ID to fetch after the given one. | [optional]
 **order** | **String**| The order of the records based on creation time, ASC or DESC; by default ASC | [optional] [default to ASC]
 **include** | **String**| Comma separated additional data to return. Currently supported: total_count | [optional]
 **nameEq** | **String**| Filter for group name | [optional]

### Return type

[**GroupSummaryList**](GroupSummaryList.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getAllAccountIdentityProviders"></a>
# **getAllAccountIdentityProviders**
> IdentityProviderList getAllAccountIdentityProviders(accountId, limit, after, order, include)

Get all identity providers.

An endpoint for retrieving identity providers in an array.

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.AggregatorAccountAdminApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

AggregatorAccountAdminApi apiInstance = new AggregatorAccountAdminApi();
String accountId = "accountId_example"; // String | Account ID.
Integer limit = 50; // Integer | The number of results to return (2-1000), default is 50.
String after = "after_example"; // String | The entity ID to fetch after the given one.
String order = "ASC"; // String | The order of the records based on creation time, ASC or DESC; default ASC.
String include = "include_example"; // String | Comma separated additional data to return. Currently supported: total_count.
try {
    IdentityProviderList result = apiInstance.getAllAccountIdentityProviders(accountId, limit, after, order, include);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AggregatorAccountAdminApi#getAllAccountIdentityProviders");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **accountId** | **String**| Account ID. |
 **limit** | **Integer**| The number of results to return (2-1000), default is 50. | [optional] [default to 50]
 **after** | **String**| The entity ID to fetch after the given one. | [optional]
 **order** | **String**| The order of the records based on creation time, ASC or DESC; default ASC. | [optional] [default to ASC]
 **include** | **String**| Comma separated additional data to return. Currently supported: total_count. | [optional]

### Return type

[**IdentityProviderList**](IdentityProviderList.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getAllAccountInvitations"></a>
# **getAllAccountInvitations**
> UserInvitationRespList getAllAccountInvitations(accountId, limit, after, order, loginProfileEq)

Get the details of all the user invitations.

An endpoint for retrieving the details of all the active user invitations sent for new or existing users to join the account.  **Example usage:** &#x60;curl https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/user-invitations -H &#39;Authorization: Bearer API_KEY&#39;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.AggregatorAccountAdminApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

AggregatorAccountAdminApi apiInstance = new AggregatorAccountAdminApi();
String accountId = "accountId_example"; // String | Account ID.
Integer limit = 50; // Integer | The number of results to return (2-1000), default is 50.
String after = "after_example"; // String | The entity ID to fetch after the given one.
String order = "ASC"; // String | The order of the records based on creation time, ASC or DESC; by default ASC
String loginProfileEq = "loginProfileEq_example"; // String | Filter for getting user invitations by a specified login profile.
try {
    UserInvitationRespList result = apiInstance.getAllAccountInvitations(accountId, limit, after, order, loginProfileEq);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AggregatorAccountAdminApi#getAllAccountInvitations");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **accountId** | **String**| Account ID. |
 **limit** | **Integer**| The number of results to return (2-1000), default is 50. | [optional] [default to 50]
 **after** | **String**| The entity ID to fetch after the given one. | [optional]
 **order** | **String**| The order of the records based on creation time, ASC or DESC; by default ASC | [optional] [default to ASC]
 **loginProfileEq** | **String**| Filter for getting user invitations by a specified login profile. | [optional]

### Return type

[**UserInvitationRespList**](UserInvitationRespList.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getAllAccountLightImageData"></a>
# **getAllAccountLightImageData**
> BrandingImageList getAllAccountLightImageData(accountId)

Get metadata of all images in the light theme.

Returns the metadata of all branding images in the light theme.   **Example usage:** &#x60;curl https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/branding-images/light -H &#39;Authorization: Bearer API_KEY&#39;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.AggregatorAccountAdminApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

AggregatorAccountAdminApi apiInstance = new AggregatorAccountAdminApi();
String accountId = "accountId_example"; // String | Account ID.
try {
    BrandingImageList result = apiInstance.getAllAccountLightImageData(accountId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AggregatorAccountAdminApi#getAllAccountLightImageData");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **accountId** | **String**| Account ID. |

### Return type

[**BrandingImageList**](BrandingImageList.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getAllAccountUsers"></a>
# **getAllAccountUsers**
> UserInfoRespList getAllAccountUsers(accountId, limit, after, order, include, emailEq, statusEq, statusIn, statusNin, loginProfileEq)

Get all user details.

An endpoint for retrieving details of all users.  **Example usage:** &#x60;curl https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/users -H &#39;Authorization: Bearer API_KEY&#39;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.AggregatorAccountAdminApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

AggregatorAccountAdminApi apiInstance = new AggregatorAccountAdminApi();
String accountId = "accountId_example"; // String | Account ID.
Integer limit = 50; // Integer | The number of results to return (2-1000), default is 50.
String after = "after_example"; // String | The entity ID to fetch after the given one.
String order = "ASC"; // String | The order of the records based on creation time, ASC or DESC; by default ASC
String include = "include_example"; // String | Comma separated additional data to return. Currently supported: total_count
String emailEq = "emailEq_example"; // String | Filter for email address
String statusEq = "statusEq_example"; // String | Filter for status
String statusIn = "statusIn_example"; // String | An optional filter for getting users with a specified set of statuses.
String statusNin = "statusNin_example"; // String | An optional filter for excluding users with a specified set of statuses.
String loginProfileEq = "loginProfileEq_example"; // String | An optional filter for getting users with a specified login profile.
try {
    UserInfoRespList result = apiInstance.getAllAccountUsers(accountId, limit, after, order, include, emailEq, statusEq, statusIn, statusNin, loginProfileEq);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AggregatorAccountAdminApi#getAllAccountUsers");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **accountId** | **String**| Account ID. |
 **limit** | **Integer**| The number of results to return (2-1000), default is 50. | [optional] [default to 50]
 **after** | **String**| The entity ID to fetch after the given one. | [optional]
 **order** | **String**| The order of the records based on creation time, ASC or DESC; by default ASC | [optional] [default to ASC]
 **include** | **String**| Comma separated additional data to return. Currently supported: total_count | [optional]
 **emailEq** | **String**| Filter for email address | [optional]
 **statusEq** | **String**| Filter for status | [optional]
 **statusIn** | **String**| An optional filter for getting users with a specified set of statuses. | [optional]
 **statusNin** | **String**| An optional filter for excluding users with a specified set of statuses. | [optional]
 **loginProfileEq** | **String**| An optional filter for getting users with a specified login profile. | [optional]

### Return type

[**UserInfoRespList**](UserInfoRespList.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getAllAccounts"></a>
# **getAllAccounts**
> AccountInfoList getAllAccounts(statusEq, statusIn, statusNin, tierEq, parentEq, endMarketEq, countryLike, limit, after, order, include, format, properties)

Get all accounts.

Returns an array of account objects, optionally filtered by status and tier level.  **Example usage:** &#x60;curl https://api.us-east-1.mbedcloud.com/v3/accounts -H &#39;Authorization: Bearer API_KEY&#39;&#x60;.

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.AggregatorAccountAdminApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

AggregatorAccountAdminApi apiInstance = new AggregatorAccountAdminApi();
String statusEq = "statusEq_example"; // String | An optional filter for account status, ENROLLING, ACTIVE, RESTRICTED or SUSPENDED.
String statusIn = "statusIn_example"; // String | An optional filter for getting accounts with a specified set of statuses.
String statusNin = "statusNin_example"; // String | An optional filter for excluding accounts with a specified set of statuses.
String tierEq = "tierEq_example"; // String | An optional filter for tier level, must be 0, 1, 2, 98, 99 or omitted.
String parentEq = "parentEq_example"; // String | An optional filter for parent account ID.
String endMarketEq = "endMarketEq_example"; // String | An optional filter for account end market.
String countryLike = "countryLike_example"; // String | An optional filter for account country. Finds all matches where the filter value is a case insensitive substring of the result. Example: country__like=LAND matches Ireland.
Integer limit = 1000; // Integer | The number of results to return (2-1000), default is 1000.
String after = "after_example"; // String | The entity ID to fetch after the given one.
String order = "ASC"; // String | The order of the records based on creation time, ASC or DESC. Default value is ASC
String include = "include_example"; // String | Comma separated additional data to return. Currently supported: limits, policies, sub_accounts
String format = "format_example"; // String | Format information for the response to the query, supported: format=breakdown.
String properties = "properties_example"; // String | Property name to be returned from account specific properties.
try {
    AccountInfoList result = apiInstance.getAllAccounts(statusEq, statusIn, statusNin, tierEq, parentEq, endMarketEq, countryLike, limit, after, order, include, format, properties);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AggregatorAccountAdminApi#getAllAccounts");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **statusEq** | **String**| An optional filter for account status, ENROLLING, ACTIVE, RESTRICTED or SUSPENDED. | [optional]
 **statusIn** | **String**| An optional filter for getting accounts with a specified set of statuses. | [optional]
 **statusNin** | **String**| An optional filter for excluding accounts with a specified set of statuses. | [optional]
 **tierEq** | **String**| An optional filter for tier level, must be 0, 1, 2, 98, 99 or omitted. | [optional]
 **parentEq** | **String**| An optional filter for parent account ID. | [optional]
 **endMarketEq** | **String**| An optional filter for account end market. | [optional]
 **countryLike** | **String**| An optional filter for account country. Finds all matches where the filter value is a case insensitive substring of the result. Example: country__like&#x3D;LAND matches Ireland. | [optional]
 **limit** | **Integer**| The number of results to return (2-1000), default is 1000. | [optional] [default to 1000]
 **after** | **String**| The entity ID to fetch after the given one. | [optional]
 **order** | **String**| The order of the records based on creation time, ASC or DESC. Default value is ASC | [optional] [default to ASC]
 **include** | **String**| Comma separated additional data to return. Currently supported: limits, policies, sub_accounts | [optional]
 **format** | **String**| Format information for the response to the query, supported: format&#x3D;breakdown. | [optional]
 **properties** | **String**| Property name to be returned from account specific properties. | [optional]

### Return type

[**AccountInfoList**](AccountInfoList.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getApiKeysOfAccountGroup"></a>
# **getApiKeysOfAccountGroup**
> ApiKeyInfoRespList getApiKeysOfAccountGroup(accountId, groupId, limit, after, order, include)

Get API keys of a group.

An endpoint for listing the API keys of the group with details.  **Example usage:** &#x60;curl https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/policy-groups/{group_id}/api-keys -H &#39;Authorization: Bearer API_KEY&#39;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.AggregatorAccountAdminApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

AggregatorAccountAdminApi apiInstance = new AggregatorAccountAdminApi();
String accountId = "accountId_example"; // String | Account ID.
String groupId = "groupId_example"; // String | The ID of the group whose API keys are retrieved.
Integer limit = 50; // Integer | The number of results to return (2-1000), default is 50.
String after = "after_example"; // String | The entity ID to fetch after the given one.
String order = "ASC"; // String | The order of the records based on creation time, ASC or DESC; by default ASC
String include = "include_example"; // String | Comma separated additional data to return. Currently supported: total_count
try {
    ApiKeyInfoRespList result = apiInstance.getApiKeysOfAccountGroup(accountId, groupId, limit, after, order, include);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AggregatorAccountAdminApi#getApiKeysOfAccountGroup");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **accountId** | **String**| Account ID. |
 **groupId** | **String**| The ID of the group whose API keys are retrieved. |
 **limit** | **Integer**| The number of results to return (2-1000), default is 50. | [optional] [default to 50]
 **after** | **String**| The entity ID to fetch after the given one. | [optional]
 **order** | **String**| The order of the records based on creation time, ASC or DESC; by default ASC | [optional] [default to ASC]
 **include** | **String**| Comma separated additional data to return. Currently supported: total_count | [optional]

### Return type

[**ApiKeyInfoRespList**](ApiKeyInfoRespList.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getGroupsOfAccountApikey"></a>
# **getGroupsOfAccountApikey**
> GroupSummaryList getGroupsOfAccountApikey(accountId, apikeyId, limit, after, order, include)

Get groups of the API key.

An endpoint for retrieving groups of the API key.  **Example usage:** &#x60;curl https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/api-keys/{apikey_id}/groups -H &#39;Authorization: Bearer API_KEY&#39;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.AggregatorAccountAdminApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

AggregatorAccountAdminApi apiInstance = new AggregatorAccountAdminApi();
String accountId = "accountId_example"; // String | Account ID.
String apikeyId = "apikeyId_example"; // String | The ID of the API key whose details are retrieved.
Integer limit = 50; // Integer | The number of results to return (2-1000), default is 50.
String after = "after_example"; // String | The entity ID to fetch after the given one.
String order = "ASC"; // String | The order of the records based on creation time, ASC or DESC; by default ASC
String include = "include_example"; // String | Comma separated additional data to return. Currently supported: total_count
try {
    GroupSummaryList result = apiInstance.getGroupsOfAccountApikey(accountId, apikeyId, limit, after, order, include);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AggregatorAccountAdminApi#getGroupsOfAccountApikey");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **accountId** | **String**| Account ID. |
 **apikeyId** | **String**| The ID of the API key whose details are retrieved. |
 **limit** | **Integer**| The number of results to return (2-1000), default is 50. | [optional] [default to 50]
 **after** | **String**| The entity ID to fetch after the given one. | [optional]
 **order** | **String**| The order of the records based on creation time, ASC or DESC; by default ASC | [optional] [default to ASC]
 **include** | **String**| Comma separated additional data to return. Currently supported: total_count | [optional]

### Return type

[**GroupSummaryList**](GroupSummaryList.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getGroupsOfAccountUser"></a>
# **getGroupsOfAccountUser**
> GroupSummaryList getGroupsOfAccountUser(accountId, userId, limit, after, order, include)

Get groups of the user.

An endpoint for retrieving groups of the user.  **Example usage:** &#x60;curl https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/users/{user_id}/groups -H &#39;Authorization: Bearer API_KEY&#39;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.AggregatorAccountAdminApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

AggregatorAccountAdminApi apiInstance = new AggregatorAccountAdminApi();
String accountId = "accountId_example"; // String | Account ID.
String userId = "userId_example"; // String | The ID of the user whose details are retrieved.
Integer limit = 50; // Integer | The number of results to return (2-1000), default is 50.
String after = "after_example"; // String | The entity ID to fetch after the given one.
String order = "ASC"; // String | The order of the records based on creation time, ASC or DESC; by default ASC
String include = "include_example"; // String | Comma separated additional data to return. Currently supported: total_count
try {
    GroupSummaryList result = apiInstance.getGroupsOfAccountUser(accountId, userId, limit, after, order, include);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AggregatorAccountAdminApi#getGroupsOfAccountUser");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **accountId** | **String**| Account ID. |
 **userId** | **String**| The ID of the user whose details are retrieved. |
 **limit** | **Integer**| The number of results to return (2-1000), default is 50. | [optional] [default to 50]
 **after** | **String**| The entity ID to fetch after the given one. | [optional]
 **order** | **String**| The order of the records based on creation time, ASC or DESC; by default ASC | [optional] [default to ASC]
 **include** | **String**| Comma separated additional data to return. Currently supported: total_count | [optional]

### Return type

[**GroupSummaryList**](GroupSummaryList.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getUsersOfAccountGroup"></a>
# **getUsersOfAccountGroup**
> UserInfoRespList getUsersOfAccountGroup(accountId, groupId, limit, after, order, include, statusEq, statusIn, statusNin)

Get users of a group.

An endpoint for listing users of the group with details.  **Example usage:** &#x60;curl https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/policy-groups/{group_id}/users -H &#39;Authorization: Bearer API_KEY&#39;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.AggregatorAccountAdminApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

AggregatorAccountAdminApi apiInstance = new AggregatorAccountAdminApi();
String accountId = "accountId_example"; // String | Account ID.
String groupId = "groupId_example"; // String | The ID of the group whose users are retrieved.
Integer limit = 50; // Integer | The number of results to return (2-1000), default is 50.
String after = "after_example"; // String | The entity ID to fetch after the given one.
String order = "ASC"; // String | The order of the records based on creation time, ASC or DESC; by default ASC
String include = "include_example"; // String | Comma separated additional data to return. Currently supported: total_count
String statusEq = "statusEq_example"; // String | An optional filter for getting users by status.
String statusIn = "statusIn_example"; // String | An optional filter for getting users with a specified set of statuses.
String statusNin = "statusNin_example"; // String | An optional filter for excluding users with a specified set of statuses.
try {
    UserInfoRespList result = apiInstance.getUsersOfAccountGroup(accountId, groupId, limit, after, order, include, statusEq, statusIn, statusNin);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AggregatorAccountAdminApi#getUsersOfAccountGroup");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **accountId** | **String**| Account ID. |
 **groupId** | **String**| The ID of the group whose users are retrieved. |
 **limit** | **Integer**| The number of results to return (2-1000), default is 50. | [optional] [default to 50]
 **after** | **String**| The entity ID to fetch after the given one. | [optional]
 **order** | **String**| The order of the records based on creation time, ASC or DESC; by default ASC | [optional] [default to ASC]
 **include** | **String**| Comma separated additional data to return. Currently supported: total_count | [optional]
 **statusEq** | **String**| An optional filter for getting users by status. | [optional]
 **statusIn** | **String**| An optional filter for getting users with a specified set of statuses. | [optional]
 **statusNin** | **String**| An optional filter for excluding users with a specified set of statuses. | [optional]

### Return type

[**UserInfoRespList**](UserInfoRespList.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="removeAccountApiKeyFromGroups"></a>
# **removeAccountApiKeyFromGroups**
> UpdatedResponse removeAccountApiKeyFromGroups(accountId, apikeyId, body)

Remove API key from groups.

An endpoint for removing API key from groups.  **Example usage:** &#x60;curl -X DELETE https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/api-keys/{apikey_id}/groups -d &#39;[\&quot;0162056a9a1586f30242590700000000\&quot;,\&quot;0117056a9a1586f30242590700000000\&quot;]&#39; -H &#39;content-type: application/json&#39; -H &#39;Authorization: Bearer API_KEY&#39;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.AggregatorAccountAdminApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

AggregatorAccountAdminApi apiInstance = new AggregatorAccountAdminApi();
String accountId = "accountId_example"; // String | Account ID.
String apikeyId = "apikeyId_example"; // String | The ID of the API key to be removed from the group.
List<String> body = Arrays.asList(new List<String>()); // List<String> | A list of IDs of the groups to be updated.
try {
    UpdatedResponse result = apiInstance.removeAccountApiKeyFromGroups(accountId, apikeyId, body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AggregatorAccountAdminApi#removeAccountApiKeyFromGroups");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **accountId** | **String**| Account ID. |
 **apikeyId** | **String**| The ID of the API key to be removed from the group. |
 **body** | **List&lt;String&gt;**| A list of IDs of the groups to be updated. |

### Return type

[**UpdatedResponse**](UpdatedResponse.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="removeAccountUserFromGroups"></a>
# **removeAccountUserFromGroups**
> UpdatedResponse removeAccountUserFromGroups(accountId, userId, body)

Remove user from groups.

An endpoint for removing user from groups.  **Example usage:** &#x60;curl -X DELETE https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/users/{user_id}/groups -d &#39;[\&quot;0162056a9a1586f30242590700000000\&quot;,\&quot;0117056a9a1586f30242590700000000\&quot;]&#39; -H &#39;content-type: application/json&#39; -H &#39;Authorization: Bearer API_KEY&#39;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.AggregatorAccountAdminApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

AggregatorAccountAdminApi apiInstance = new AggregatorAccountAdminApi();
String accountId = "accountId_example"; // String | Account ID.
String userId = "userId_example"; // String | The ID of the user to be removed from the group.
List<String> body = Arrays.asList(new List<String>()); // List<String> | A list of IDs of the groups to be updated.
try {
    UpdatedResponse result = apiInstance.removeAccountUserFromGroups(accountId, userId, body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AggregatorAccountAdminApi#removeAccountUserFromGroups");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **accountId** | **String**| Account ID. |
 **userId** | **String**| The ID of the user to be removed from the group. |
 **body** | **List&lt;String&gt;**| A list of IDs of the groups to be updated. |

### Return type

[**UpdatedResponse**](UpdatedResponse.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="removeApiKeysFromAccountGroup"></a>
# **removeApiKeysFromAccountGroup**
> UpdatedResponse removeApiKeysFromAccountGroup(accountId, groupId, body)

Remove API keys from a group.

An endpoint for removing API keys from groups.  **Example usage:** &#x60;curl -X DELETE https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/policy-groups/{group_id}/api-keys -d &#39;{\&quot;apikeys\&quot;: [\&quot;0162056a9a1586f30242590700000000\&quot;,\&quot;0117056a9a1586f30242590700000000\&quot;]}&#39; -H &#39;content-type: application/json&#39; -H &#39;Authorization: Bearer API_KEY&#39;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.AggregatorAccountAdminApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

AggregatorAccountAdminApi apiInstance = new AggregatorAccountAdminApi();
String accountId = "accountId_example"; // String | Account ID.
String groupId = "groupId_example"; // String | The ID of the group from which the API keys are to be removed.
SubjectList body = new SubjectList(); // SubjectList | A list of API keys to be removed from the group.
try {
    UpdatedResponse result = apiInstance.removeApiKeysFromAccountGroup(accountId, groupId, body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AggregatorAccountAdminApi#removeApiKeysFromAccountGroup");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **accountId** | **String**| Account ID. |
 **groupId** | **String**| The ID of the group from which the API keys are to be removed. |
 **body** | [**SubjectList**](SubjectList.md)| A list of API keys to be removed from the group. |

### Return type

[**UpdatedResponse**](UpdatedResponse.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="removeUsersFromAccountGroup"></a>
# **removeUsersFromAccountGroup**
> UpdatedResponse removeUsersFromAccountGroup(accountId, groupId, body)

Remove users from a group.

An endpoint for removing users from groups.  **Example usage:** &#x60;curl -X DELETE https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/policy-groups/{group_id}/users -d &#39;{\&quot;users\&quot;: [\&quot;0162056a9a1586f30242590700000000\&quot;,\&quot;0117056a9a1586f30242590700000000\&quot;]}&#39; -H &#39;content-type: application/json&#39; -H &#39;Authorization: Bearer API_KEY&#39;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.AggregatorAccountAdminApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

AggregatorAccountAdminApi apiInstance = new AggregatorAccountAdminApi();
String accountId = "accountId_example"; // String | Account ID.
String groupId = "groupId_example"; // String | The ID of the group from which the users are to be removed.
SubjectList body = new SubjectList(); // SubjectList | A list of users to be removed from the group.
try {
    UpdatedResponse result = apiInstance.removeUsersFromAccountGroup(accountId, groupId, body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AggregatorAccountAdminApi#removeUsersFromAccountGroup");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **accountId** | **String**| Account ID. |
 **groupId** | **String**| The ID of the group from which the users are to be removed. |
 **body** | [**SubjectList**](SubjectList.md)| A list of users to be removed from the group. |

### Return type

[**UpdatedResponse**](UpdatedResponse.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="resetAccountApiKeySecret"></a>
# **resetAccountApiKeySecret**
> ApiKeyInfoResp resetAccountApiKeySecret(accountId, apikeyId)

Reset the secret key.

An endpoint for resetting the secret key of the API key.  **Example usage:** &#x60;curl -X POST https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/api-keys/{apikey_id}/reset-secret -H &#39;Authorization: Bearer API_KEY&#39;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.AggregatorAccountAdminApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

AggregatorAccountAdminApi apiInstance = new AggregatorAccountAdminApi();
String accountId = "accountId_example"; // String | Account ID.
String apikeyId = "apikeyId_example"; // String | The ID of the API key to be reset.
try {
    ApiKeyInfoResp result = apiInstance.resetAccountApiKeySecret(accountId, apikeyId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AggregatorAccountAdminApi#resetAccountApiKeySecret");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **accountId** | **String**| Account ID. |
 **apikeyId** | **String**| The ID of the API key to be reset. |

### Return type

[**ApiKeyInfoResp**](ApiKeyInfoResp.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="resetAccountDarkColor"></a>
# **resetAccountDarkColor**
> BrandingColor resetAccountDarkColor(accountId, reference)

Reset branding color to default.

Resets the branding color to its default in the dark theme.   **Example usage:** &#x60;curl -X DELETE https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/branding-colors/light/{reference} -H &#39;Authorization: Bearer API_KEY&#39;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.AggregatorAccountAdminApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

AggregatorAccountAdminApi apiInstance = new AggregatorAccountAdminApi();
String accountId = "accountId_example"; // String | Account ID.
String reference = "reference_example"; // String | The name of the branding color.
try {
    BrandingColor result = apiInstance.resetAccountDarkColor(accountId, reference);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AggregatorAccountAdminApi#resetAccountDarkColor");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **accountId** | **String**| Account ID. |
 **reference** | **String**| The name of the branding color. | [enum: error_color, primary, secondary, success_color, warning_color, canvas_background, canvas_background_font_color, workspace_background, workspace_background_font_color, info_color, info_font_color, primary_font_color, secondary_font_color, error_font_color, success_font_color, warning_font_color]

### Return type

[**BrandingColor**](BrandingColor.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="resetAccountLightColor"></a>
# **resetAccountLightColor**
> BrandingColor resetAccountLightColor(accountId, reference)

Reset branding color to default.

Resets the branding color to its default in the light theme.   **Example usage:** &#x60;curl -X DELETE https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/branding-colors/light/{reference} -H &#39;Authorization: Bearer API_KEY&#39;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.AggregatorAccountAdminApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

AggregatorAccountAdminApi apiInstance = new AggregatorAccountAdminApi();
String accountId = "accountId_example"; // String | Account ID.
String reference = "reference_example"; // String | The name of the branding color.
try {
    BrandingColor result = apiInstance.resetAccountLightColor(accountId, reference);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AggregatorAccountAdminApi#resetAccountLightColor");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **accountId** | **String**| Account ID. |
 **reference** | **String**| The name of the branding color. | [enum: error_color, primary, secondary, success_color, warning_color, canvas_background, canvas_background_font_color, workspace_background, workspace_background_font_color, info_color, info_font_color, primary_font_color, secondary_font_color, error_font_color, success_font_color, warning_font_color]

### Return type

[**BrandingColor**](BrandingColor.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="setAccountDarkColor"></a>
# **setAccountDarkColor**
> BrandingColor setAccountDarkColor(accountId, reference, body)

Updates a branding color in the dark theme.

An endpoint for updating a branding color in the dark theme.   **Example usage:** &#x60;curl -X PUT https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id)/branding-colors/dark/primary -d &#39;{ \&quot;color\&quot;: \&quot;#f3f93e\&quot; }&#39; -H &#39;content-type: application/json&#39; -H &#39;Authorization: Bearer API_KEY&#39;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.AggregatorAccountAdminApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

AggregatorAccountAdminApi apiInstance = new AggregatorAccountAdminApi();
String accountId = "accountId_example"; // String | Account ID.
String reference = "reference_example"; // String | The name of the branding color.
BrandingColor body = new BrandingColor(); // BrandingColor | The branding color.
try {
    BrandingColor result = apiInstance.setAccountDarkColor(accountId, reference, body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AggregatorAccountAdminApi#setAccountDarkColor");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **accountId** | **String**| Account ID. |
 **reference** | **String**| The name of the branding color. | [enum: error_color, primary, secondary, success_color, warning_color, canvas_background, canvas_background_font_color, workspace_background, workspace_background_font_color, info_color, info_font_color, primary_font_color, secondary_font_color, error_font_color, success_font_color, warning_font_color]
 **body** | [**BrandingColor**](BrandingColor.md)| The branding color. |

### Return type

[**BrandingColor**](BrandingColor.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="setAccountLightColor"></a>
# **setAccountLightColor**
> BrandingColor setAccountLightColor(accountId, reference, body)

Updates a branding color in the light theme.

An endpoint for updating a branding color in the light theme.   **Example usage:** &#x60;curl -X PUT https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id)/branding-colors/light/primary -d &#39;{ \&quot;color\&quot;: \&quot;purple\&quot; }&#39; -H &#39;content-type: application/json&#39; -H &#39;Authorization: Bearer API_KEY&#39;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.AggregatorAccountAdminApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

AggregatorAccountAdminApi apiInstance = new AggregatorAccountAdminApi();
String accountId = "accountId_example"; // String | Account ID.
String reference = "reference_example"; // String | The name of the branding color.
BrandingColor body = new BrandingColor(); // BrandingColor | The branding color.
try {
    BrandingColor result = apiInstance.setAccountLightColor(accountId, reference, body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AggregatorAccountAdminApi#setAccountLightColor");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **accountId** | **String**| Account ID. |
 **reference** | **String**| The name of the branding color. | [enum: error_color, primary, secondary, success_color, warning_color, canvas_background, canvas_background_font_color, workspace_background, workspace_background_font_color, info_color, info_font_color, primary_font_color, secondary_font_color, error_font_color, success_font_color, warning_font_color]
 **body** | [**BrandingColor**](BrandingColor.md)| The branding color. |

### Return type

[**BrandingColor**](BrandingColor.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="updateAccount"></a>
# **updateAccount**
> AccountInfo updateAccount(accountId, body)

Update attributes of an existing account.

An endpoint for updating an account.  **Example usage:** &#x60;curl -X PUT https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id} -d &#39;{\&quot;phone_number\&quot;: \&quot;12345678\&quot;}&#39; -H &#39;content-type: application/json&#39; -H &#39;Authorization: Bearer API_KEY&#39;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.AggregatorAccountAdminApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

AggregatorAccountAdminApi apiInstance = new AggregatorAccountAdminApi();
String accountId = "accountId_example"; // String | The ID of the account to be updated.
AccountUpdateRootReq body = new AccountUpdateRootReq(); // AccountUpdateRootReq | Details of the account to be updated.
try {
    AccountInfo result = apiInstance.updateAccount(accountId, body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AggregatorAccountAdminApi#updateAccount");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **accountId** | **String**| The ID of the account to be updated. |
 **body** | [**AccountUpdateRootReq**](AccountUpdateRootReq.md)| Details of the account to be updated. |

### Return type

[**AccountInfo**](AccountInfo.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="updateAccountApiKey"></a>
# **updateAccountApiKey**
> ApiKeyInfoResp updateAccountApiKey(accountId, apikeyId, body)

Update API key details.

An endpoint for updating API key details.  **Example usage:** &#x60;curl -X PUT https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/api-keys/{apikey_id} -d &#39;{\&quot;name\&quot;: \&quot;TestApiKey25\&quot;}&#39; -H &#39;content-type: application/json&#39; -H &#39;Authorization: Bearer API_KEY&#39;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.AggregatorAccountAdminApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

AggregatorAccountAdminApi apiInstance = new AggregatorAccountAdminApi();
String accountId = "accountId_example"; // String | Account ID.
String apikeyId = "apikeyId_example"; // String | The ID of the API key to be updated.
ApiKeyUpdateReq body = new ApiKeyUpdateReq(); // ApiKeyUpdateReq | New API key attributes to be stored.
try {
    ApiKeyInfoResp result = apiInstance.updateAccountApiKey(accountId, apikeyId, body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AggregatorAccountAdminApi#updateAccountApiKey");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **accountId** | **String**| Account ID. |
 **apikeyId** | **String**| The ID of the API key to be updated. |
 **body** | [**ApiKeyUpdateReq**](ApiKeyUpdateReq.md)| New API key attributes to be stored. |

### Return type

[**ApiKeyInfoResp**](ApiKeyInfoResp.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="updateAccountCertificate"></a>
# **updateAccountCertificate**
> TrustedCertificateResp updateAccountCertificate(accountId, certId, body)

Update trusted certificate.

An endpoint for updating existing trusted certificates.  **Example usage:** &#x60;curl -X PUT https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/trusted-certificates/{cert_id} -d {\&quot;description\&quot;: \&quot;very important cert\&quot;} -H &#39;content-type: application/json&#39; -H &#39;Authorization: Bearer API_KEY&#39;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.AggregatorAccountAdminApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

AggregatorAccountAdminApi apiInstance = new AggregatorAccountAdminApi();
String accountId = "accountId_example"; // String | Account ID.
String certId = "certId_example"; // String | The ID of the trusted certificate to be updated.
TrustedCertificateUpdateReq body = new TrustedCertificateUpdateReq(); // TrustedCertificateUpdateReq | A trusted certificate object with attributes.
try {
    TrustedCertificateResp result = apiInstance.updateAccountCertificate(accountId, certId, body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AggregatorAccountAdminApi#updateAccountCertificate");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **accountId** | **String**| Account ID. |
 **certId** | **String**| The ID of the trusted certificate to be updated. |
 **body** | [**TrustedCertificateUpdateReq**](TrustedCertificateUpdateReq.md)| A trusted certificate object with attributes. |

### Return type

[**TrustedCertificateResp**](TrustedCertificateResp.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="updateAccountGroupName"></a>
# **updateAccountGroupName**
> UpdatedResponse updateAccountGroupName(accountId, groupId, body)

Update the group name.

An endpoint for updating a group name.  **Example usage:** &#x60;curl -X PUT https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/policy-groups/{group_id}/ -d &#39;{\&quot;name\&quot;: \&quot;TestGroup2\&quot;}&#39; -H &#39;content-type: application/json&#39; -H &#39;Authorization: Bearer API_KEY&#39;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.AggregatorAccountAdminApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

AggregatorAccountAdminApi apiInstance = new AggregatorAccountAdminApi();
String accountId = "accountId_example"; // String | Account ID.
String groupId = "groupId_example"; // String | The ID of the group to be updated.
GroupUpdateInfo body = new GroupUpdateInfo(); // GroupUpdateInfo | Details of the group to be created.
try {
    UpdatedResponse result = apiInstance.updateAccountGroupName(accountId, groupId, body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AggregatorAccountAdminApi#updateAccountGroupName");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **accountId** | **String**| Account ID. |
 **groupId** | **String**| The ID of the group to be updated. |
 **body** | [**GroupUpdateInfo**](GroupUpdateInfo.md)| Details of the group to be created. |

### Return type

[**UpdatedResponse**](UpdatedResponse.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="updateAccountIdentityProvider"></a>
# **updateAccountIdentityProvider**
> IdentityProviderInfo updateAccountIdentityProvider(accountId, identityProviderId, body)

Update an existing identity provider.

An endpoint for updating an existing identity provider.

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.AggregatorAccountAdminApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

AggregatorAccountAdminApi apiInstance = new AggregatorAccountAdminApi();
String accountId = "accountId_example"; // String | Account ID.
String identityProviderId = "identityProviderId_example"; // String | The ID of the identity provider to be updated.
IdentityProviderUpdateReq body = new IdentityProviderUpdateReq(); // IdentityProviderUpdateReq | Details of the identity provider to be updated.
try {
    IdentityProviderInfo result = apiInstance.updateAccountIdentityProvider(accountId, identityProviderId, body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AggregatorAccountAdminApi#updateAccountIdentityProvider");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **accountId** | **String**| Account ID. |
 **identityProviderId** | **String**| The ID of the identity provider to be updated. |
 **body** | [**IdentityProviderUpdateReq**](IdentityProviderUpdateReq.md)| Details of the identity provider to be updated. |

### Return type

[**IdentityProviderInfo**](IdentityProviderInfo.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="updateAccountUser"></a>
# **updateAccountUser**
> UserInfoResp updateAccountUser(accountId, userId, body)

Update user details.

An endpoint for updating user details.  **Example usage:** &#x60;curl -X PUT https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/users/{user_id} -d &#39;{\&quot;username\&quot;: \&quot;myusername\&quot;}&#39; -H &#39;content-type: application/json&#39; -H &#39;Authorization: Bearer API_KEY&#39;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.AggregatorAccountAdminApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

AggregatorAccountAdminApi apiInstance = new AggregatorAccountAdminApi();
String accountId = "accountId_example"; // String | Account ID.
String userId = "userId_example"; // String | The ID of the user to be updated.
UserUpdateReq body = new UserUpdateReq(); // UserUpdateReq | A user object with attributes.
try {
    UserInfoResp result = apiInstance.updateAccountUser(accountId, userId, body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AggregatorAccountAdminApi#updateAccountUser");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **accountId** | **String**| Account ID. |
 **userId** | **String**| The ID of the user to be updated. |
 **body** | [**UserUpdateReq**](UserUpdateReq.md)| A user object with attributes. |

### Return type

[**UserInfoResp**](UserInfoResp.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="uploadAccountDarkImage"></a>
# **uploadAccountDarkImage**
> BrandingImage uploadAccountDarkImage(accountId, reference, body)

Upload an image in the dark theme.

An endpoint for uploading a new account branding image in the dark theme in PNG or JPEG format.   **Example usage:** &#x60;curl -X POST https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/branding-images/dark/{reference}/upload -H &#39;content-type: image/png&#39; -H &#39;Authorization: Bearer API_KEY&#39; --data-binary &#39;myimage.png&#39;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.AggregatorAccountAdminApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

AggregatorAccountAdminApi apiInstance = new AggregatorAccountAdminApi();
String accountId = "accountId_example"; // String | Account ID.
String reference = "reference_example"; // String | Name of the branding images (icon or picture).
String body = "body_example"; // String | The image in PNG or JPEG format.
try {
    BrandingImage result = apiInstance.uploadAccountDarkImage(accountId, reference, body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AggregatorAccountAdminApi#uploadAccountDarkImage");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **accountId** | **String**| Account ID. |
 **reference** | **String**| Name of the branding images (icon or picture). | [enum: brand_logo_portrait, brand_logo_square, brand_logo_landscape, brand_logo_email, desktop_background_landscape, desktop_background_square, desktop_background_portrait, carousel_image_portrait_0, carousel_image_portrait_1, carousel_image_portrait_2, carousel_image_portrait_3, carousel_image_portrait_4, carousel_image_portrait_5, carousel_image_portrait_6, carousel_image_portrait_7, carousel_image_portrait_8, carousel_image_portrait_9, carousel_image_square_0, carousel_image_square_1, carousel_image_square_2, carousel_image_square_3, carousel_image_square_4, carousel_image_square_5, carousel_image_square_6, carousel_image_square_7, carousel_image_square_8, carousel_image_square_9, carousel_image_landscape_0, carousel_image_landscape_1, carousel_image_landscape_2, carousel_image_landscape_3, carousel_image_landscape_4, carousel_image_landscape_5, carousel_image_landscape_6, carousel_image_landscape_7, carousel_image_landscape_8, carousel_image_landscape_9]
 **body** | [**String**](String.md)| The image in PNG or JPEG format. |

### Return type

[**BrandingImage**](BrandingImage.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: image/png, image/jpeg
 - **Accept**: application/json

<a name="uploadAccountLightImage"></a>
# **uploadAccountLightImage**
> BrandingImage uploadAccountLightImage(accountId, reference, body)

Upload an image in the light theme.

An endpoint for uploading a new account branding image in the light theme in PNG or JPEG format.   **Example usage:** &#x60;curl -X POST https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/branding-images/light/{reference}/upload -H &#39;content-type: image/png&#39; -H &#39;Authorization: Bearer API_KEY&#39; --data-binary &#39;myimage.png&#39;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.AggregatorAccountAdminApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

AggregatorAccountAdminApi apiInstance = new AggregatorAccountAdminApi();
String accountId = "accountId_example"; // String | Account ID.
String reference = "reference_example"; // String | Name of the branding images (icon or picture).
String body = "body_example"; // String | The image in PNG or JPEG format.
try {
    BrandingImage result = apiInstance.uploadAccountLightImage(accountId, reference, body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AggregatorAccountAdminApi#uploadAccountLightImage");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **accountId** | **String**| Account ID. |
 **reference** | **String**| Name of the branding images (icon or picture). | [enum: brand_logo_portrait, brand_logo_square, brand_logo_landscape, brand_logo_email, desktop_background_landscape, desktop_background_square, desktop_background_portrait, carousel_image_portrait_0, carousel_image_portrait_1, carousel_image_portrait_2, carousel_image_portrait_3, carousel_image_portrait_4, carousel_image_portrait_5, carousel_image_portrait_6, carousel_image_portrait_7, carousel_image_portrait_8, carousel_image_portrait_9, carousel_image_square_0, carousel_image_square_1, carousel_image_square_2, carousel_image_square_3, carousel_image_square_4, carousel_image_square_5, carousel_image_square_6, carousel_image_square_7, carousel_image_square_8, carousel_image_square_9, carousel_image_landscape_0, carousel_image_landscape_1, carousel_image_landscape_2, carousel_image_landscape_3, carousel_image_landscape_4, carousel_image_landscape_5, carousel_image_landscape_6, carousel_image_landscape_7, carousel_image_landscape_8, carousel_image_landscape_9]
 **body** | [**String**](String.md)| The image in PNG or JPEG format. |

### Return type

[**BrandingImage**](BrandingImage.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: image/png, image/jpeg
 - **Accept**: application/json

<a name="validateAccountUserEmail"></a>
# **validateAccountUserEmail**
> Void validateAccountUserEmail(accountId, userId)

Validate the user email.

An endpoint for validating the user email.  **Example usage:** &#x60;curl -X POST https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/users/{user_id}/validate-email -H &#39;Authorization: Bearer API_KEY&#39;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.AggregatorAccountAdminApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

AggregatorAccountAdminApi apiInstance = new AggregatorAccountAdminApi();
String accountId = "accountId_example"; // String | Account ID.
String userId = "userId_example"; // String | The ID of the user whose email is validated.
try {
    Void result = apiInstance.validateAccountUserEmail(accountId, userId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AggregatorAccountAdminApi#validateAccountUserEmail");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **accountId** | **String**| Account ID. |
 **userId** | **String**| The ID of the user whose email is validated. |

### Return type

[**Void**](.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

