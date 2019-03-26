# AccountAdminApi

All URIs are relative to *https://api.us-east-1.mbedcloud.com*

Method | HTTP request | Description
------------- | ------------- | -------------
[**addApiKeyToGroups**](AccountAdminApi.md#addApiKeyToGroups) | **POST** v3/api-keys/{apikey_id}/groups | Add API key to a list of groups.
[**addCertificate**](AccountAdminApi.md#addCertificate) | **POST** v3/trusted-certificates | Upload a new trusted certificate.
[**addSubjectsToGroup**](AccountAdminApi.md#addSubjectsToGroup) | **POST** v3/policy-groups/{group_id} | Add members to a group.
[**addUserToGroups**](AccountAdminApi.md#addUserToGroups) | **POST** v3/users/{user_id}/groups | Add user to a list of groups.
[**bulkSetDarkColors**](AccountAdminApi.md#bulkSetDarkColors) | **PUT** v3/branding-colors/dark | Updates an array of branding colors in the dark theme.
[**bulkSetLightColors**](AccountAdminApi.md#bulkSetLightColors) | **PUT** v3/branding-colors/light | Updates an array of branding colors in the light theme.
[**clearDarkImage**](AccountAdminApi.md#clearDarkImage) | **POST** v3/branding-images/dark/{reference}/clear | Revert an image to default in the dark theme.
[**clearLightImage**](AccountAdminApi.md#clearLightImage) | **POST** v3/branding-images/light/{reference}/clear | Revert an image to default in the light theme.
[**createGroup**](AccountAdminApi.md#createGroup) | **POST** v3/policy-groups | Create a new group.
[**createIdentityProvider**](AccountAdminApi.md#createIdentityProvider) | **POST** v3/identity-providers | Create a new identity provider.
[**createInvitation**](AccountAdminApi.md#createInvitation) | **POST** v3/user-invitations | Create a user invitation.
[**createUser**](AccountAdminApi.md#createUser) | **POST** v3/users | Create a new user.
[**deleteGroup**](AccountAdminApi.md#deleteGroup) | **DELETE** v3/policy-groups/{group_id} | Delete a group.
[**deleteIdentityProvider**](AccountAdminApi.md#deleteIdentityProvider) | **DELETE** v3/identity-providers/{identity_provider_id} | Delete an identity provider by ID.
[**deleteInvitation**](AccountAdminApi.md#deleteInvitation) | **DELETE** v3/user-invitations/{invitation_id} | Delete a user invitation.
[**deleteSpCertificate**](AccountAdminApi.md#deleteSpCertificate) | **POST** v3/identity-providers/{identity_provider_id}/delete-sp-certificate | Delete the service provider certificate.
[**deleteUser**](AccountAdminApi.md#deleteUser) | **DELETE** v3/users/{user_id} | Delete a user.
[**generateSpCertificate**](AccountAdminApi.md#generateSpCertificate) | **POST** v3/identity-providers/{identity_provider_id}/generate-sp-certificate | Generate a new service provider certificate.
[**getAllIdentityProviders**](AccountAdminApi.md#getAllIdentityProviders) | **GET** v3/identity-providers | Get all identity providers.
[**getAllInvitations**](AccountAdminApi.md#getAllInvitations) | **GET** v3/user-invitations | Get the details of all the user invitations.
[**getAllUsers**](AccountAdminApi.md#getAllUsers) | **GET** v3/users | Get the details of all users.
[**getGroupsOfApikey**](AccountAdminApi.md#getGroupsOfApikey) | **GET** v3/api-keys/{apikey_id}/groups | Get groups of the API key.
[**getGroupsOfUser**](AccountAdminApi.md#getGroupsOfUser) | **GET** v3/users/{user_id}/groups | Get groups of the user.
[**getIdentityProvider**](AccountAdminApi.md#getIdentityProvider) | **GET** v3/identity-providers/{identity_provider_id} | Get identity provider by ID.
[**getInvitation**](AccountAdminApi.md#getInvitation) | **GET** v3/user-invitations/{invitation_id} | Details of a user invitation.
[**getNofificationEntries**](AccountAdminApi.md#getNofificationEntries) | **GET** v3/accounts/me/notifications | Get the notification events of an account.
[**getUser**](AccountAdminApi.md#getUser) | **GET** v3/users/{user_id} | Details of a user.
[**getUsersOfGroup**](AccountAdminApi.md#getUsersOfGroup) | **GET** v3/policy-groups/{group_id}/users | Get users of a group.
[**removeApiKeyFromGroups**](AccountAdminApi.md#removeApiKeyFromGroups) | **DELETE** v3/api-keys/{apikey_id}/groups | Remove API key from groups.
[**removeUserFromGroups**](AccountAdminApi.md#removeUserFromGroups) | **DELETE** v3/users/{user_id}/groups | Remove user from groups.
[**removeUsersFromGroup**](AccountAdminApi.md#removeUsersFromGroup) | **DELETE** v3/policy-groups/{group_id}/users | Remove users from a group.
[**resetDarkColor**](AccountAdminApi.md#resetDarkColor) | **DELETE** v3/branding-colors/dark/{reference} | Reset branding color to default.
[**resetLightColor**](AccountAdminApi.md#resetLightColor) | **DELETE** v3/branding-colors/light/{reference} | Reset branding color to default.
[**setDarkColor**](AccountAdminApi.md#setDarkColor) | **PUT** v3/branding-colors/dark/{reference} | Updates a branding color in the dark theme.
[**setLightColor**](AccountAdminApi.md#setLightColor) | **PUT** v3/branding-colors/light/{reference} | Updates a branding color in the light theme.
[**updateGroupName**](AccountAdminApi.md#updateGroupName) | **PUT** v3/policy-groups/{group_id} | Update the group name.
[**updateIdentityProvider**](AccountAdminApi.md#updateIdentityProvider) | **PUT** v3/identity-providers/{identity_provider_id} | Update an existing identity provider.
[**updateMyAccount**](AccountAdminApi.md#updateMyAccount) | **PUT** v3/accounts/me | Updates attributes of the account.
[**updateUser**](AccountAdminApi.md#updateUser) | **PUT** v3/users/{user_id} | Update user details.
[**uploadDarkImage**](AccountAdminApi.md#uploadDarkImage) | **POST** v3/branding-images/dark/{reference}/upload | Upload an image in the dark theme.
[**uploadDarkImageMultipart**](AccountAdminApi.md#uploadDarkImageMultipart) | **POST** v3/branding-images/dark/{reference}/upload-multipart | Upload an image in the dark theme.
[**uploadLightImage**](AccountAdminApi.md#uploadLightImage) | **POST** v3/branding-images/light/{reference}/upload | Upload an image in the light theme.
[**uploadLightImageMultipart**](AccountAdminApi.md#uploadLightImageMultipart) | **POST** v3/branding-images/light/{reference}/upload-multipart | Upload an image in the light theme.


<a name="addApiKeyToGroups"></a>
# **addApiKeyToGroups**
> UpdatedResponse addApiKeyToGroups(apikeyId, body)

Add API key to a list of groups.

An endpoint for adding API key to groups.  **Example usage:** &#x60;curl -X POST https://api.us-east-1.mbedcloud.com/v3/api-keys/{apikey_id}/groups -d &#39;[\&quot;0162056a9a1586f30242590700000000\&quot;,\&quot;0117056a9a1586f30242590700000000\&quot;]&#39; -H &#39;content-type: application/json&#39; -H &#39;Authorization: Bearer API_KEY&#39;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.AccountAdminApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

AccountAdminApi apiInstance = new AccountAdminApi();
String apikeyId = "apikeyId_example"; // String | The ID of the API key to be added to the group.
List<String> body = Arrays.asList(new List<String>()); // List<String> | A list of IDs of the groups to be updated.
try {
    UpdatedResponse result = apiInstance.addApiKeyToGroups(apikeyId, body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AccountAdminApi#addApiKeyToGroups");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **apikeyId** | **String**| The ID of the API key to be added to the group. |
 **body** | **List&lt;String&gt;**| A list of IDs of the groups to be updated. |

### Return type

[**UpdatedResponse**](UpdatedResponse.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="addCertificate"></a>
# **addCertificate**
> TrustedCertificateResp addCertificate(body)

Upload a new trusted certificate.

An endpoint for uploading new trusted certificates.  **Example usage:** &#x60;curl -X POST https://api.us-east-1.mbedcloud.com/v3/trusted-certificates -d {\&quot;name\&quot;: \&quot;myCert1\&quot;, \&quot;description\&quot;: \&quot;very important cert\&quot;, \&quot;certificate\&quot;: \&quot;certificate_data\&quot;, \&quot;service\&quot;: \&quot;lwm2m\&quot;} -H &#39;content-type: application/json&#39; -H &#39;Authorization: Bearer API_KEY&#39;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.AccountAdminApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

AccountAdminApi apiInstance = new AccountAdminApi();
TrustedCertificateReq body = new TrustedCertificateReq(); // TrustedCertificateReq | A trusted certificate object with attributes.
try {
    TrustedCertificateResp result = apiInstance.addCertificate(body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AccountAdminApi#addCertificate");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**TrustedCertificateReq**](TrustedCertificateReq.md)| A trusted certificate object with attributes. |

### Return type

[**TrustedCertificateResp**](TrustedCertificateResp.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="addSubjectsToGroup"></a>
# **addSubjectsToGroup**
> UpdatedResponse addSubjectsToGroup(groupId, body)

Add members to a group.

An endpoint for adding users and API keys to a group.  **Example usage:** &#x60;curl -X POST https://api.us-east-1.mbedcloud.com/v3/policy-groups/{group_id} -d &#39;{\&quot;users\&quot;: [\&quot;0162056a9a1586f30242590700000000\&quot;,\&quot;0117056a9a1586f30242590700000000\&quot;]}&#39; -H &#39;content-type: application/json&#39; -H &#39;Authorization: Bearer API_KEY&#39;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.AccountAdminApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

AccountAdminApi apiInstance = new AccountAdminApi();
String groupId = "groupId_example"; // String | The ID of the group to be updated.
SubjectList body = new SubjectList(); // SubjectList | A list of users and API keys to be added to the group.
try {
    UpdatedResponse result = apiInstance.addSubjectsToGroup(groupId, body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AccountAdminApi#addSubjectsToGroup");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **groupId** | **String**| The ID of the group to be updated. |
 **body** | [**SubjectList**](SubjectList.md)| A list of users and API keys to be added to the group. |

### Return type

[**UpdatedResponse**](UpdatedResponse.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="addUserToGroups"></a>
# **addUserToGroups**
> UpdatedResponse addUserToGroups(userId, body)

Add user to a list of groups.

An endpoint for adding user to groups.  **Example usage:** &#x60;curl -X POST https://api.us-east-1.mbedcloud.com/v3/users/{user_id}/groups -d &#39;[\&quot;0162056a9a1586f30242590700000000\&quot;,\&quot;0117056a9a1586f30242590700000000\&quot;]&#39; -H &#39;content-type: application/json&#39; -H &#39;Authorization: Bearer API_KEY&#39;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.AccountAdminApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

AccountAdminApi apiInstance = new AccountAdminApi();
String userId = "userId_example"; // String | The ID of the user to be added to the group.
List<String> body = Arrays.asList(new List<String>()); // List<String> | A list of IDs of the groups to be updated.
try {
    UpdatedResponse result = apiInstance.addUserToGroups(userId, body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AccountAdminApi#addUserToGroups");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **userId** | **String**| The ID of the user to be added to the group. |
 **body** | **List&lt;String&gt;**| A list of IDs of the groups to be updated. |

### Return type

[**UpdatedResponse**](UpdatedResponse.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="bulkSetDarkColors"></a>
# **bulkSetDarkColors**
> Void bulkSetDarkColors(body)

Updates an array of branding colors in the dark theme.

An endpoint for updating an array of branding colors in the dark theme.  **Example usage:** &#x60;curl -X PUT https://api.us-east-1.mbedcloud.com/v3/branding-colors/dark &#39;[{ \&quot;reference\&quot;: \&quot;primary\&quot;,    \&quot;color\&quot;: \&quot;#f3f93e\&quot; }]&#39; -H &#39;content-type: application/json&#39; -H &#39;Authorization: Bearer API_KEY&#39;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.AccountAdminApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

AccountAdminApi apiInstance = new AccountAdminApi();
List<BrandingColor> body = Arrays.asList(new BrandingColor()); // List<BrandingColor> | List of branding colors.
try {
    Void result = apiInstance.bulkSetDarkColors(body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AccountAdminApi#bulkSetDarkColors");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**List&lt;BrandingColor&gt;**](BrandingColor.md)| List of branding colors. |

### Return type

[**Void**](.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="bulkSetLightColors"></a>
# **bulkSetLightColors**
> Void bulkSetLightColors(body)

Updates an array of branding colors in the light theme.

An endpoint for updating an array of branding colors in the light theme.  **Example usage:** &#x60;curl -X PUT https://api.us-east-1.mbedcloud.com/v3/branding-colors/light &#39;[{ \&quot;reference\&quot;: \&quot;primary\&quot;,    \&quot;color\&quot;: \&quot;purple\&quot; }]&#39; -H &#39;content-type: application/json&#39; -H &#39;Authorization: Bearer API_KEY&#39;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.AccountAdminApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

AccountAdminApi apiInstance = new AccountAdminApi();
List<BrandingColor> body = Arrays.asList(new BrandingColor()); // List<BrandingColor> | List of branding colors.
try {
    Void result = apiInstance.bulkSetLightColors(body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AccountAdminApi#bulkSetLightColors");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**List&lt;BrandingColor&gt;**](BrandingColor.md)| List of branding colors. |

### Return type

[**Void**](.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="clearDarkImage"></a>
# **clearDarkImage**
> Void clearDarkImage(reference)

Revert an image to default in the dark theme.

An endpoint for reverting an account branding image to default in the dark theme.  **Example usage:** &#x60;curl -X POST https://api.us-east-1.mbedcloud.com/v3/branding-images/dark/{reference}/clear -H &#39;Authorization: Bearer API_KEY&#39;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.AccountAdminApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

AccountAdminApi apiInstance = new AccountAdminApi();
String reference = "reference_example"; // String | Name of the branding images (icon or picture).
try {
    Void result = apiInstance.clearDarkImage(reference);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AccountAdminApi#clearDarkImage");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **reference** | **String**| Name of the branding images (icon or picture). | [enum: brand_logo_portrait, brand_logo_square, brand_logo_landscape, brand_logo_email, desktop_background_landscape, desktop_background_square, desktop_background_portrait, carousel_image_portrait_0, carousel_image_portrait_1, carousel_image_portrait_2, carousel_image_portrait_3, carousel_image_portrait_4, carousel_image_portrait_5, carousel_image_portrait_6, carousel_image_portrait_7, carousel_image_portrait_8, carousel_image_portrait_9, carousel_image_square_0, carousel_image_square_1, carousel_image_square_2, carousel_image_square_3, carousel_image_square_4, carousel_image_square_5, carousel_image_square_6, carousel_image_square_7, carousel_image_square_8, carousel_image_square_9, carousel_image_landscape_0, carousel_image_landscape_1, carousel_image_landscape_2, carousel_image_landscape_3, carousel_image_landscape_4, carousel_image_landscape_5, carousel_image_landscape_6, carousel_image_landscape_7, carousel_image_landscape_8, carousel_image_landscape_9]

### Return type

[**Void**](.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="clearLightImage"></a>
# **clearLightImage**
> Void clearLightImage(reference)

Revert an image to default in the light theme.

An endpoint for reverting an account branding image to default in the light theme.  **Example usage:** &#x60;curl -X POST https://api.us-east-1.mbedcloud.com/v3/branding-images/light/{reference}/clear -H &#39;Authorization: Bearer API_KEY&#39;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.AccountAdminApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

AccountAdminApi apiInstance = new AccountAdminApi();
String reference = "reference_example"; // String | Name of the branding images (icon or picture).
try {
    Void result = apiInstance.clearLightImage(reference);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AccountAdminApi#clearLightImage");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **reference** | **String**| Name of the branding images (icon or picture). | [enum: brand_logo_portrait, brand_logo_square, brand_logo_landscape, brand_logo_email, desktop_background_landscape, desktop_background_square, desktop_background_portrait, carousel_image_portrait_0, carousel_image_portrait_1, carousel_image_portrait_2, carousel_image_portrait_3, carousel_image_portrait_4, carousel_image_portrait_5, carousel_image_portrait_6, carousel_image_portrait_7, carousel_image_portrait_8, carousel_image_portrait_9, carousel_image_square_0, carousel_image_square_1, carousel_image_square_2, carousel_image_square_3, carousel_image_square_4, carousel_image_square_5, carousel_image_square_6, carousel_image_square_7, carousel_image_square_8, carousel_image_square_9, carousel_image_landscape_0, carousel_image_landscape_1, carousel_image_landscape_2, carousel_image_landscape_3, carousel_image_landscape_4, carousel_image_landscape_5, carousel_image_landscape_6, carousel_image_landscape_7, carousel_image_landscape_8, carousel_image_landscape_9]

### Return type

[**Void**](.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="createGroup"></a>
# **createGroup**
> GroupSummary createGroup(body)

Create a new group.

An endpoint for creating a new group.  **Example usage:** &#x60;curl -X POST https://api.us-east-1.mbedcloud.com/v3/policy-groups -d &#39;{\&quot;name\&quot;: \&quot;MyGroup1\&quot;}&#39; -H &#39;content-type: application/json&#39; -H &#39;Authorization: Bearer API_KEY&#39;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.AccountAdminApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

AccountAdminApi apiInstance = new AccountAdminApi();
GroupCreationInfo body = new GroupCreationInfo(); // GroupCreationInfo | Details of the group to be created.
try {
    GroupSummary result = apiInstance.createGroup(body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AccountAdminApi#createGroup");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**GroupCreationInfo**](GroupCreationInfo.md)| Details of the group to be created. |

### Return type

[**GroupSummary**](GroupSummary.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="createIdentityProvider"></a>
# **createIdentityProvider**
> IdentityProviderInfo createIdentityProvider(body)

Create a new identity provider.

An endpoint for creating a new identity provider.

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.AccountAdminApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

AccountAdminApi apiInstance = new AccountAdminApi();
IdentityProviderCreationReq body = new IdentityProviderCreationReq(); // IdentityProviderCreationReq | Details of the identity provider to be created.
try {
    IdentityProviderInfo result = apiInstance.createIdentityProvider(body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AccountAdminApi#createIdentityProvider");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**IdentityProviderCreationReq**](IdentityProviderCreationReq.md)| Details of the identity provider to be created. |

### Return type

[**IdentityProviderInfo**](IdentityProviderInfo.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="createInvitation"></a>
# **createInvitation**
> UserInvitationResp createInvitation(body)

Create a user invitation.

An endpoint for inviting a new or an existing user to join the account.  **Example usage:** &#x60;curl -X POST https://api.us-east-1.mbedcloud.com/v3/user-invitations -d {\&quot;email\&quot;: \&quot;myemail@company.com\&quot;} -H &#39;content-type: application/json&#39; -H &#39;Authorization: Bearer API_KEY&#39;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.AccountAdminApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

AccountAdminApi apiInstance = new AccountAdminApi();
UserInvitationReq body = new UserInvitationReq(); // UserInvitationReq | A user invitation object with attributes.
try {
    UserInvitationResp result = apiInstance.createInvitation(body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AccountAdminApi#createInvitation");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**UserInvitationReq**](UserInvitationReq.md)| A user invitation object with attributes. |

### Return type

[**UserInvitationResp**](UserInvitationResp.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="createUser"></a>
# **createUser**
> UserInfoResp createUser(body, action)

Create a new user.

An endpoint for creating or inviting a new user to the account. In case of invitation email address is used only, other attributes are set in the 2nd step.  **Example usage:** &#x60;curl -X POST https://api.us-east-1.mbedcloud.com/v3/users?action&#x3D;invite -d {\&quot;email\&quot;: \&quot;myemail@company.com\&quot;} -H &#39;content-type: application/json&#39; -H &#39;Authorization: Bearer API_KEY&#39;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.AccountAdminApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

AccountAdminApi apiInstance = new AccountAdminApi();
UserInfoReq body = new UserInfoReq(); // UserInfoReq | A user object with attributes.
String action = "create"; // String | Action, either 'create' or 'invite'.
try {
    UserInfoResp result = apiInstance.createUser(body, action);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AccountAdminApi#createUser");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**UserInfoReq**](UserInfoReq.md)| A user object with attributes. |
 **action** | **String**| Action, either &#39;create&#39; or &#39;invite&#39;. | [optional] [default to create]

### Return type

[**UserInfoResp**](UserInfoResp.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="deleteGroup"></a>
# **deleteGroup**
> Void deleteGroup(groupId)

Delete a group.

An endpoint for deleting a group.  **Example usage:** &#x60;curl -X DELETE https://api.us-east-1.mbedcloud.com/v3/policy-groups/{group_id} -H &#39;Authorization: Bearer API_KEY&#39;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.AccountAdminApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

AccountAdminApi apiInstance = new AccountAdminApi();
String groupId = "groupId_example"; // String | The ID of the group to be deleted.
try {
    Void result = apiInstance.deleteGroup(groupId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AccountAdminApi#deleteGroup");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **groupId** | **String**| The ID of the group to be deleted. |

### Return type

[**Void**](.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="deleteIdentityProvider"></a>
# **deleteIdentityProvider**
> Void deleteIdentityProvider(identityProviderId)

Delete an identity provider by ID.

An endpoint for deleting an identity provider by ID.

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.AccountAdminApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

AccountAdminApi apiInstance = new AccountAdminApi();
String identityProviderId = "identityProviderId_example"; // String | The ID of the identity provider to be deleted.
try {
    Void result = apiInstance.deleteIdentityProvider(identityProviderId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AccountAdminApi#deleteIdentityProvider");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **identityProviderId** | **String**| The ID of the identity provider to be deleted. |

### Return type

[**Void**](.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="deleteInvitation"></a>
# **deleteInvitation**
> Void deleteInvitation(invitationId)

Delete a user invitation.

An endpoint for deleting an active user invitation which has been sent for a new or an existing user to join the account.  **Example usage:** &#x60;curl -X DELETE https://api.us-east-1.mbedcloud.com/v3/user-invitations/{invitation_id} -H &#39;Authorization: Bearer API_KEY&#39;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.AccountAdminApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

AccountAdminApi apiInstance = new AccountAdminApi();
String invitationId = "invitationId_example"; // String | The ID of the invitation to be deleted.
try {
    Void result = apiInstance.deleteInvitation(invitationId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AccountAdminApi#deleteInvitation");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **invitationId** | **String**| The ID of the invitation to be deleted. |

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

An endpoint for deleting the service provider certificate.

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.AccountAdminApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

AccountAdminApi apiInstance = new AccountAdminApi();
String identityProviderId = "identityProviderId_example"; // String | The ID of the identity provider to which the certificate should be deleted.
try {
    IdentityProviderInfo result = apiInstance.deleteSpCertificate(identityProviderId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AccountAdminApi#deleteSpCertificate");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **identityProviderId** | **String**| The ID of the identity provider to which the certificate should be deleted. |

### Return type

[**IdentityProviderInfo**](IdentityProviderInfo.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="deleteUser"></a>
# **deleteUser**
> Void deleteUser(userId)

Delete a user.

An endpoint for deleting a user.  **Example usage:** &#x60;curl -X DELETE https://api.us-east-1.mbedcloud.com/v3/users/{user_id} -H &#39;Authorization: Bearer API_KEY&#39;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.AccountAdminApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

AccountAdminApi apiInstance = new AccountAdminApi();
String userId = "userId_example"; // String | The ID of the user to be deleted.
try {
    Void result = apiInstance.deleteUser(userId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AccountAdminApi#deleteUser");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **userId** | **String**| The ID of the user to be deleted. |

### Return type

[**Void**](.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="generateSpCertificate"></a>
# **generateSpCertificate**
> IdentityProviderInfo generateSpCertificate(identityProviderId, body)

Generate a new service provider certificate.

An endpoint for generating a new service provider certificate.

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.AccountAdminApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

AccountAdminApi apiInstance = new AccountAdminApi();
String identityProviderId = "identityProviderId_example"; // String | The ID of the identity provider to which the certificate should be generated for.
CertificateGenerationReq body = new CertificateGenerationReq(); // CertificateGenerationReq | Details of the service provider certificate to be generated.
try {
    IdentityProviderInfo result = apiInstance.generateSpCertificate(identityProviderId, body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AccountAdminApi#generateSpCertificate");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **identityProviderId** | **String**| The ID of the identity provider to which the certificate should be generated for. |
 **body** | [**CertificateGenerationReq**](CertificateGenerationReq.md)| Details of the service provider certificate to be generated. | [optional]

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

An endpoint for retrieving identity providers in an array.

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.AccountAdminApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

AccountAdminApi apiInstance = new AccountAdminApi();
Integer limit = 50; // Integer | The number of results to return (2-1000), default is 50.
String after = "after_example"; // String | The entity ID to fetch after the given one.
String order = "ASC"; // String | The order of the records based on creation time, ASC or DESC; default ASC.
String include = "include_example"; // String | Comma separated additional data to return. Currently supported: total_count.
try {
    IdentityProviderList result = apiInstance.getAllIdentityProviders(limit, after, order, include);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AccountAdminApi#getAllIdentityProviders");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
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

<a name="getAllInvitations"></a>
# **getAllInvitations**
> UserInvitationRespList getAllInvitations(limit, after, order, loginProfileEq)

Get the details of all the user invitations.

An endpoint for retrieving the details of all the active user invitations sent for new or existing users to join the account.  **Example usage:** &#x60;curl https://api.us-east-1.mbedcloud.com/v3/user-invitations -H &#39;Authorization: Bearer API_KEY&#39;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.AccountAdminApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

AccountAdminApi apiInstance = new AccountAdminApi();
Integer limit = 50; // Integer | The number of results to return (2-1000), default is 50.
String after = "after_example"; // String | The entity ID to fetch after the given one.
String order = "ASC"; // String | The order of the records based on creation time, ASC or DESC; by default ASC
String loginProfileEq = "loginProfileEq_example"; // String | Filter for getting user invitations by a specified login profile.
try {
    UserInvitationRespList result = apiInstance.getAllInvitations(limit, after, order, loginProfileEq);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AccountAdminApi#getAllInvitations");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
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

<a name="getAllUsers"></a>
# **getAllUsers**
> UserInfoRespList getAllUsers(limit, after, order, include, emailEq, statusEq, statusIn, statusNin, loginProfileEq)

Get the details of all users.

An endpoint for retrieving the details of all users.  **Example usage:** &#x60;curl https://api.us-east-1.mbedcloud.com/v3/users -H &#39;Authorization: Bearer API_KEY&#39;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.AccountAdminApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

AccountAdminApi apiInstance = new AccountAdminApi();
Integer limit = 50; // Integer | The number of results to return (2-1000), default is 50.
String after = "after_example"; // String | The entity ID to fetch after the given one.
String order = "ASC"; // String | The order of the records based on creation time, ASC or DESC; by default ASC
String include = "include_example"; // String | Comma separated additional data to return. Currently supported: total_count
String emailEq = "emailEq_example"; // String | Filter for email address
String statusEq = "statusEq_example"; // String | Filter for status, for example active or reset
String statusIn = "statusIn_example"; // String | An optional filter for getting users with a specified set of statuses.
String statusNin = "statusNin_example"; // String | An optional filter for excluding users with a specified set of statuses.
String loginProfileEq = "loginProfileEq_example"; // String | An optional filter for getting users with a specified login profile.
try {
    UserInfoRespList result = apiInstance.getAllUsers(limit, after, order, include, emailEq, statusEq, statusIn, statusNin, loginProfileEq);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AccountAdminApi#getAllUsers");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **limit** | **Integer**| The number of results to return (2-1000), default is 50. | [optional] [default to 50]
 **after** | **String**| The entity ID to fetch after the given one. | [optional]
 **order** | **String**| The order of the records based on creation time, ASC or DESC; by default ASC | [optional] [default to ASC]
 **include** | **String**| Comma separated additional data to return. Currently supported: total_count | [optional]
 **emailEq** | **String**| Filter for email address | [optional]
 **statusEq** | **String**| Filter for status, for example active or reset | [optional]
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

<a name="getGroupsOfApikey"></a>
# **getGroupsOfApikey**
> GroupSummaryList getGroupsOfApikey(apikeyId, limit, after, order, include)

Get groups of the API key.

An endpoint for retrieving groups of the API key.  **Example usage:** &#x60;curl https://api.us-east-1.mbedcloud.com/v3/api-keys/{apikey_id}/groups -H &#39;Authorization: Bearer API_KEY&#39;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.AccountAdminApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

AccountAdminApi apiInstance = new AccountAdminApi();
String apikeyId = "apikeyId_example"; // String | The ID of the API key whose details are retrieved.
Integer limit = 50; // Integer | The number of results to return (2-1000), default is 50.
String after = "after_example"; // String | The entity ID to fetch after the given one.
String order = "ASC"; // String | The order of the records based on creation time, ASC or DESC; by default ASC
String include = "include_example"; // String | Comma separated additional data to return. Currently supported: total_count
try {
    GroupSummaryList result = apiInstance.getGroupsOfApikey(apikeyId, limit, after, order, include);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AccountAdminApi#getGroupsOfApikey");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
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

<a name="getGroupsOfUser"></a>
# **getGroupsOfUser**
> GroupSummaryList getGroupsOfUser(userId, limit, after, order, include)

Get groups of the user.

An endpoint for retrieving groups of the user.  **Example usage:** &#x60;curl https://api.us-east-1.mbedcloud.com/v3/users/{user_id}/groups -H &#39;Authorization: Bearer API_KEY&#39;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.AccountAdminApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

AccountAdminApi apiInstance = new AccountAdminApi();
String userId = "userId_example"; // String | The ID of the user whose details are retrieved.
Integer limit = 50; // Integer | The number of results to return (2-1000), default is 50.
String after = "after_example"; // String | The entity ID to fetch after the given one.
String order = "ASC"; // String | The order of the records based on creation time, ASC or DESC; by default ASC
String include = "include_example"; // String | Comma separated additional data to return. Currently supported: total_count
try {
    GroupSummaryList result = apiInstance.getGroupsOfUser(userId, limit, after, order, include);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AccountAdminApi#getGroupsOfUser");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
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

<a name="getIdentityProvider"></a>
# **getIdentityProvider**
> IdentityProviderInfo getIdentityProvider(identityProviderId)

Get identity provider by ID.

An endpoint for retrieving an identity provider by ID.

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.AccountAdminApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

AccountAdminApi apiInstance = new AccountAdminApi();
String identityProviderId = "identityProviderId_example"; // String | The ID of the identity provider to be retrieved.
try {
    IdentityProviderInfo result = apiInstance.getIdentityProvider(identityProviderId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AccountAdminApi#getIdentityProvider");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **identityProviderId** | **String**| The ID of the identity provider to be retrieved. |

### Return type

[**IdentityProviderInfo**](IdentityProviderInfo.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getInvitation"></a>
# **getInvitation**
> UserInvitationResp getInvitation(invitationId)

Details of a user invitation.

An endpoint for retrieving the details of an active user invitation sent for a new or an existing user to join the account.  **Example usage:** &#x60;curl https://api.us-east-1.mbedcloud.com/v3/user-invitations/{invitation_id} -H &#39;Authorization: Bearer API_KEY&#39;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.AccountAdminApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

AccountAdminApi apiInstance = new AccountAdminApi();
String invitationId = "invitationId_example"; // String | The ID of the invitation to be retrieved.
try {
    UserInvitationResp result = apiInstance.getInvitation(invitationId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AccountAdminApi#getInvitation");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **invitationId** | **String**| The ID of the invitation to be retrieved. |

### Return type

[**UserInvitationResp**](UserInvitationResp.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getNofificationEntries"></a>
# **getNofificationEntries**
> NotificationEntryList getNofificationEntries(limit, after, order)

Get the notification events of an account.

Endpoint for retrieving notifications.

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.AccountAdminApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

AccountAdminApi apiInstance = new AccountAdminApi();
Integer limit = 50; // Integer | The number of results to return (2-1000), default is 50.
String after = "after_example"; // String | The entity ID to fetch after the given one.
String order = "ASC"; // String | The order of the records based on creation time, ASC or DESC; by default ASC
try {
    NotificationEntryList result = apiInstance.getNofificationEntries(limit, after, order);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AccountAdminApi#getNofificationEntries");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
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

<a name="getUser"></a>
# **getUser**
> UserInfoResp getUser(userId)

Details of a user.

An endpoint for retrieving the details of a user.  **Example usage:** &#x60;curl https://api.us-east-1.mbedcloud.com/v3/users/{user_id} -H &#39;Authorization: Bearer API_KEY&#39;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.AccountAdminApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

AccountAdminApi apiInstance = new AccountAdminApi();
String userId = "userId_example"; // String | The ID of the user whose details are retrieved.
try {
    UserInfoResp result = apiInstance.getUser(userId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AccountAdminApi#getUser");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **userId** | **String**| The ID of the user whose details are retrieved. |

### Return type

[**UserInfoResp**](UserInfoResp.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getUsersOfGroup"></a>
# **getUsersOfGroup**
> UserInfoRespList getUsersOfGroup(groupId, limit, after, order, include, statusEq, statusIn, statusNin)

Get users of a group.

An endpoint for listing the users of a group with details.  **Example usage:** &#x60;curl https://api.us-east-1.mbedcloud.com/v3/policy-groups/{group_id}/users -H &#39;Authorization: Bearer API_KEY&#39;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.AccountAdminApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

AccountAdminApi apiInstance = new AccountAdminApi();
String groupId = "groupId_example"; // String | The ID of the group whose users are retrieved.
Integer limit = 50; // Integer | The number of results to return (2-1000), default is 50.
String after = "after_example"; // String | The entity ID to fetch after the given one.
String order = "ASC"; // String | The order of the records based on creation time, ASC or DESC; by default ASC
String include = "include_example"; // String | Comma separated additional data to return. Currently supported: total_count
String statusEq = "statusEq_example"; // String | An optional filter for getting users by status.
String statusIn = "statusIn_example"; // String | An optional filter for getting users with a specified set of statuses.
String statusNin = "statusNin_example"; // String | An optional filter for excluding users with a specified set of statuses.
try {
    UserInfoRespList result = apiInstance.getUsersOfGroup(groupId, limit, after, order, include, statusEq, statusIn, statusNin);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AccountAdminApi#getUsersOfGroup");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
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

<a name="removeApiKeyFromGroups"></a>
# **removeApiKeyFromGroups**
> UpdatedResponse removeApiKeyFromGroups(apikeyId, body)

Remove API key from groups.

An endpoint for removing API key from groups.  **Example usage:** &#x60;curl -X DELETE https://api.us-east-1.mbedcloud.com/v3/api-keys/{apikey_id}/groups -d &#39;[\&quot;0162056a9a1586f30242590700000000\&quot;,\&quot;0117056a9a1586f30242590700000000\&quot;]&#39; -H &#39;content-type: application/json&#39; -H &#39;Authorization: Bearer API_KEY&#39;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.AccountAdminApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

AccountAdminApi apiInstance = new AccountAdminApi();
String apikeyId = "apikeyId_example"; // String | The ID of the API key to be removed from the group.
List<String> body = Arrays.asList(new List<String>()); // List<String> | A list of IDs of the groups to be updated.
try {
    UpdatedResponse result = apiInstance.removeApiKeyFromGroups(apikeyId, body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AccountAdminApi#removeApiKeyFromGroups");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **apikeyId** | **String**| The ID of the API key to be removed from the group. |
 **body** | **List&lt;String&gt;**| A list of IDs of the groups to be updated. |

### Return type

[**UpdatedResponse**](UpdatedResponse.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="removeUserFromGroups"></a>
# **removeUserFromGroups**
> UpdatedResponse removeUserFromGroups(userId, body)

Remove user from groups.

An endpoint for removing user from groups.  **Example usage:** &#x60;curl -X DELETE https://api.us-east-1.mbedcloud.com/v3/users/{user_id}/groups -d &#39;[\&quot;0162056a9a1586f30242590700000000\&quot;,\&quot;0117056a9a1586f30242590700000000\&quot;]&#39; -H &#39;content-type: application/json&#39; -H &#39;Authorization: Bearer API_KEY&#39;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.AccountAdminApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

AccountAdminApi apiInstance = new AccountAdminApi();
String userId = "userId_example"; // String | The ID of the user to be removed from the group.
List<String> body = Arrays.asList(new List<String>()); // List<String> | A list of IDs of the groups to be updated.
try {
    UpdatedResponse result = apiInstance.removeUserFromGroups(userId, body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AccountAdminApi#removeUserFromGroups");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **userId** | **String**| The ID of the user to be removed from the group. |
 **body** | **List&lt;String&gt;**| A list of IDs of the groups to be updated. |

### Return type

[**UpdatedResponse**](UpdatedResponse.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="removeUsersFromGroup"></a>
# **removeUsersFromGroup**
> UpdatedResponse removeUsersFromGroup(groupId, body)

Remove users from a group.

An endpoint for removing users from groups.  **Example usage:** &#x60;curl -X DELETE https://api.us-east-1.mbedcloud.com/v3/policy-groups/{group_id}/users -d &#39;[\&quot;0162056a9a1586f30242590700000000\&quot;,\&quot;0117056a9a1586f30242590700000000\&quot;]&#39; -H &#39;content-type: application/json&#39; -H &#39;Authorization: Bearer API_KEY&#39;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.AccountAdminApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

AccountAdminApi apiInstance = new AccountAdminApi();
String groupId = "groupId_example"; // String | The ID of the group whose users are removed.
SubjectList body = new SubjectList(); // SubjectList | A list of users to be removed from the group.
try {
    UpdatedResponse result = apiInstance.removeUsersFromGroup(groupId, body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AccountAdminApi#removeUsersFromGroup");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **groupId** | **String**| The ID of the group whose users are removed. |
 **body** | [**SubjectList**](SubjectList.md)| A list of users to be removed from the group. |

### Return type

[**UpdatedResponse**](UpdatedResponse.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="resetDarkColor"></a>
# **resetDarkColor**
> BrandingColor resetDarkColor(reference)

Reset branding color to default.

Resets the branding color to its default in the dark theme.  **Example usage:** &#x60;curl -X DELETE https://api.us-east-1.mbedcloud.com/v3/branding-colors/light/{reference} -H &#39;Authorization: Bearer API_KEY&#39;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.AccountAdminApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

AccountAdminApi apiInstance = new AccountAdminApi();
String reference = "reference_example"; // String | The name of the branding color.
try {
    BrandingColor result = apiInstance.resetDarkColor(reference);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AccountAdminApi#resetDarkColor");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **reference** | **String**| The name of the branding color. | [enum: error_color, primary, secondary, success_color, warning_color, canvas_background, canvas_background_font_color, workspace_background, workspace_background_font_color, info_color, info_font_color, primary_font_color, secondary_font_color, error_font_color, success_font_color, warning_font_color]

### Return type

[**BrandingColor**](BrandingColor.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="resetLightColor"></a>
# **resetLightColor**
> BrandingColor resetLightColor(reference)

Reset branding color to default.

Resets the branding color to its default in the light theme.  **Example usage:** &#x60;curl -X DELETE https://api.us-east-1.mbedcloud.com/v3/branding-colors/light/{reference} -H &#39;Authorization: Bearer API_KEY&#39;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.AccountAdminApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

AccountAdminApi apiInstance = new AccountAdminApi();
String reference = "reference_example"; // String | The name of the branding color.
try {
    BrandingColor result = apiInstance.resetLightColor(reference);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AccountAdminApi#resetLightColor");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **reference** | **String**| The name of the branding color. | [enum: error_color, primary, secondary, success_color, warning_color, canvas_background, canvas_background_font_color, workspace_background, workspace_background_font_color, info_color, info_font_color, primary_font_color, secondary_font_color, error_font_color, success_font_color, warning_font_color]

### Return type

[**BrandingColor**](BrandingColor.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="setDarkColor"></a>
# **setDarkColor**
> BrandingColor setDarkColor(reference, body)

Updates a branding color in the dark theme.

An endpoint for updating a branding color in the dark theme.  **Example usage:** &#x60;curl -X PUT https://api.us-east-1.mbedcloud.com/v3/branding-colors/dark/primary -d &#39;{ \&quot;color\&quot;: \&quot;#f3f93e\&quot; }&#39; -H &#39;content-type: application/json&#39; -H &#39;Authorization: Bearer API_KEY&#39;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.AccountAdminApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

AccountAdminApi apiInstance = new AccountAdminApi();
String reference = "reference_example"; // String | The name of the branding color.
BrandingColor body = new BrandingColor(); // BrandingColor | The branding color.
try {
    BrandingColor result = apiInstance.setDarkColor(reference, body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AccountAdminApi#setDarkColor");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **reference** | **String**| The name of the branding color. | [enum: error_color, primary, secondary, success_color, warning_color, canvas_background, canvas_background_font_color, workspace_background, workspace_background_font_color, info_color, info_font_color, primary_font_color, secondary_font_color, error_font_color, success_font_color, warning_font_color]
 **body** | [**BrandingColor**](BrandingColor.md)| The branding color. |

### Return type

[**BrandingColor**](BrandingColor.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="setLightColor"></a>
# **setLightColor**
> BrandingColor setLightColor(reference, body)

Updates a branding color in the light theme.

An endpoint for updating a branding color in the light theme.  **Example usage:** &#x60;curl -X PUT https://api.us-east-1.mbedcloud.com/v3/branding-colors/light/primary -d &#39;{ \&quot;color\&quot;: \&quot;purple\&quot; }&#39; -H &#39;content-type: application/json&#39; -H &#39;Authorization: Bearer API_KEY&#39;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.AccountAdminApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

AccountAdminApi apiInstance = new AccountAdminApi();
String reference = "reference_example"; // String | The name of the branding color.
BrandingColor body = new BrandingColor(); // BrandingColor | The branding color.
try {
    BrandingColor result = apiInstance.setLightColor(reference, body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AccountAdminApi#setLightColor");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **reference** | **String**| The name of the branding color. | [enum: error_color, primary, secondary, success_color, warning_color, canvas_background, canvas_background_font_color, workspace_background, workspace_background_font_color, info_color, info_font_color, primary_font_color, secondary_font_color, error_font_color, success_font_color, warning_font_color]
 **body** | [**BrandingColor**](BrandingColor.md)| The branding color. |

### Return type

[**BrandingColor**](BrandingColor.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="updateGroupName"></a>
# **updateGroupName**
> UpdatedResponse updateGroupName(groupId, body)

Update the group name.

An endpoint for updating a group name.  **Example usage:** &#x60;curl -X PUT https://api.us-east-1.mbedcloud.com/v3/policy-groups/{group_id} -d &#39;{\&quot;name\&quot;: \&quot;TestGroup2\&quot;}&#39; -H &#39;content-type: application/json&#39; -H &#39;Authorization: Bearer API_KEY&#39;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.AccountAdminApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

AccountAdminApi apiInstance = new AccountAdminApi();
String groupId = "groupId_example"; // String | The ID of the group to be updated.
GroupUpdateInfo body = new GroupUpdateInfo(); // GroupUpdateInfo | Details of the group to be created.
try {
    UpdatedResponse result = apiInstance.updateGroupName(groupId, body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AccountAdminApi#updateGroupName");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **groupId** | **String**| The ID of the group to be updated. |
 **body** | [**GroupUpdateInfo**](GroupUpdateInfo.md)| Details of the group to be created. |

### Return type

[**UpdatedResponse**](UpdatedResponse.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="updateIdentityProvider"></a>
# **updateIdentityProvider**
> IdentityProviderInfo updateIdentityProvider(identityProviderId, body)

Update an existing identity provider.

An endpoint for updating an existing identity provider.

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.AccountAdminApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

AccountAdminApi apiInstance = new AccountAdminApi();
String identityProviderId = "identityProviderId_example"; // String | The ID of the identity provider to be updated.
IdentityProviderUpdateReq body = new IdentityProviderUpdateReq(); // IdentityProviderUpdateReq | Details of the identity provider to be updated.
try {
    IdentityProviderInfo result = apiInstance.updateIdentityProvider(identityProviderId, body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AccountAdminApi#updateIdentityProvider");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **identityProviderId** | **String**| The ID of the identity provider to be updated. |
 **body** | [**IdentityProviderUpdateReq**](IdentityProviderUpdateReq.md)| Details of the identity provider to be updated. |

### Return type

[**IdentityProviderInfo**](IdentityProviderInfo.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="updateMyAccount"></a>
# **updateMyAccount**
> AccountInfo updateMyAccount(body)

Updates attributes of the account.

An endpoint for updating the account.  **Example usage:** &#x60;curl -X PUT https://api.us-east-1.mbedcloud.com/v3/accounts/me -d &#39;{\&quot;phone_number\&quot;: \&quot;12345678\&quot;}&#39; -H &#39;content-type: application/json&#39; -H &#39;Authorization: Bearer API_KEY&#39;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.AccountAdminApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

AccountAdminApi apiInstance = new AccountAdminApi();
AccountUpdateReq body = new AccountUpdateReq(); // AccountUpdateReq | Details of the account to be updated.
try {
    AccountInfo result = apiInstance.updateMyAccount(body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AccountAdminApi#updateMyAccount");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**AccountUpdateReq**](AccountUpdateReq.md)| Details of the account to be updated. |

### Return type

[**AccountInfo**](AccountInfo.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="updateUser"></a>
# **updateUser**
> UserInfoResp updateUser(userId, body)

Update user details.

An endpoint for updating user details.  **Example usage:** &#x60;curl -X PUT https://api.us-east-1.mbedcloud.com/v3/users/{user_id} -d &#39;{\&quot;username\&quot;: \&quot;myusername\&quot;}&#39; -H &#39;content-type: application/json&#39; -H &#39;Authorization: Bearer API_KEY&#39;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.AccountAdminApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

AccountAdminApi apiInstance = new AccountAdminApi();
String userId = "userId_example"; // String | The ID of the user whose details are updated.
UserUpdateReq body = new UserUpdateReq(); // UserUpdateReq | A user object with attributes.
try {
    UserInfoResp result = apiInstance.updateUser(userId, body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AccountAdminApi#updateUser");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **userId** | **String**| The ID of the user whose details are updated. |
 **body** | [**UserUpdateReq**](UserUpdateReq.md)| A user object with attributes. |

### Return type

[**UserInfoResp**](UserInfoResp.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="uploadDarkImage"></a>
# **uploadDarkImage**
> BrandingImage uploadDarkImage(reference, body)

Upload an image in the dark theme.

An endpoint for uploading a new account branding image in the dark theme in PNG or JPEG format.  **Example usage:** &#x60;curl -X POST https://api.us-east-1.mbedcloud.com/v3/branding-images/dark/{reference}/upload -H &#39;content-type: image/png&#39; -H &#39;Authorization: Bearer API_KEY&#39; --data-binary &#39;@myimage.png&#39;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.AccountAdminApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

AccountAdminApi apiInstance = new AccountAdminApi();
String reference = "reference_example"; // String | Name of the branding images (icon or picture).
String body = "body_example"; // String | The image in PNG or JPEG format.
try {
    BrandingImage result = apiInstance.uploadDarkImage(reference, body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AccountAdminApi#uploadDarkImage");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **reference** | **String**| Name of the branding images (icon or picture). | [enum: brand_logo_portrait, brand_logo_square, brand_logo_landscape, brand_logo_email, desktop_background_landscape, desktop_background_square, desktop_background_portrait, carousel_image_portrait_0, carousel_image_portrait_1, carousel_image_portrait_2, carousel_image_portrait_3, carousel_image_portrait_4, carousel_image_portrait_5, carousel_image_portrait_6, carousel_image_portrait_7, carousel_image_portrait_8, carousel_image_portrait_9, carousel_image_square_0, carousel_image_square_1, carousel_image_square_2, carousel_image_square_3, carousel_image_square_4, carousel_image_square_5, carousel_image_square_6, carousel_image_square_7, carousel_image_square_8, carousel_image_square_9, carousel_image_landscape_0, carousel_image_landscape_1, carousel_image_landscape_2, carousel_image_landscape_3, carousel_image_landscape_4, carousel_image_landscape_5, carousel_image_landscape_6, carousel_image_landscape_7, carousel_image_landscape_8, carousel_image_landscape_9]
 **body** | [**String**](String.md)| The image in PNG or JPEG format. |

### Return type

[**BrandingImage**](BrandingImage.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: image/png, image/jpeg
 - **Accept**: application/json

<a name="uploadDarkImageMultipart"></a>
# **uploadDarkImageMultipart**
> BrandingImage uploadDarkImageMultipart(reference, image)

Upload an image in the dark theme.

An endpoint for uploading a new account branding image as form data in the dark theme in PNG or JPEG format.

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.AccountAdminApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

AccountAdminApi apiInstance = new AccountAdminApi();
String reference = "reference_example"; // String | Name of the branding images (icon or picture).
File image = new File("/path/to/file.txt"); // File | The image in PNG or JPEG format as multipart form data.
try {
    BrandingImage result = apiInstance.uploadDarkImageMultipart(reference, image);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AccountAdminApi#uploadDarkImageMultipart");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **reference** | **String**| Name of the branding images (icon or picture). | [enum: brand_logo_portrait, brand_logo_square, brand_logo_landscape, brand_logo_email, desktop_background_landscape, desktop_background_square, desktop_background_portrait, carousel_image_portrait_0, carousel_image_portrait_1, carousel_image_portrait_2, carousel_image_portrait_3, carousel_image_portrait_4, carousel_image_portrait_5, carousel_image_portrait_6, carousel_image_portrait_7, carousel_image_portrait_8, carousel_image_portrait_9, carousel_image_square_0, carousel_image_square_1, carousel_image_square_2, carousel_image_square_3, carousel_image_square_4, carousel_image_square_5, carousel_image_square_6, carousel_image_square_7, carousel_image_square_8, carousel_image_square_9, carousel_image_landscape_0, carousel_image_landscape_1, carousel_image_landscape_2, carousel_image_landscape_3, carousel_image_landscape_4, carousel_image_landscape_5, carousel_image_landscape_6, carousel_image_landscape_7, carousel_image_landscape_8, carousel_image_landscape_9]
 **image** | **File**| The image in PNG or JPEG format as multipart form data. |

### Return type

[**BrandingImage**](BrandingImage.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: multipart/form-data
 - **Accept**: application/json

<a name="uploadLightImage"></a>
# **uploadLightImage**
> BrandingImage uploadLightImage(reference, body)

Upload an image in the light theme.

An endpoint for uploading a new account branding image in the light theme in PNG or JPEG format.  **Example usage:** &#x60;curl -X POST https://api.us-east-1.mbedcloud.com/v3/branding-images/light/{reference}/upload -H &#39;content-type: image/png&#39; -H &#39;Authorization: Bearer API_KEY&#39; --data-binary &#39;@myimage.png&#39;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.AccountAdminApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

AccountAdminApi apiInstance = new AccountAdminApi();
String reference = "reference_example"; // String | Name of the branding images (icon or picture).
String body = "body_example"; // String | The image in PNG or JPEG format.
try {
    BrandingImage result = apiInstance.uploadLightImage(reference, body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AccountAdminApi#uploadLightImage");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **reference** | **String**| Name of the branding images (icon or picture). | [enum: brand_logo_portrait, brand_logo_square, brand_logo_landscape, brand_logo_email, desktop_background_landscape, desktop_background_square, desktop_background_portrait, carousel_image_portrait_0, carousel_image_portrait_1, carousel_image_portrait_2, carousel_image_portrait_3, carousel_image_portrait_4, carousel_image_portrait_5, carousel_image_portrait_6, carousel_image_portrait_7, carousel_image_portrait_8, carousel_image_portrait_9, carousel_image_square_0, carousel_image_square_1, carousel_image_square_2, carousel_image_square_3, carousel_image_square_4, carousel_image_square_5, carousel_image_square_6, carousel_image_square_7, carousel_image_square_8, carousel_image_square_9, carousel_image_landscape_0, carousel_image_landscape_1, carousel_image_landscape_2, carousel_image_landscape_3, carousel_image_landscape_4, carousel_image_landscape_5, carousel_image_landscape_6, carousel_image_landscape_7, carousel_image_landscape_8, carousel_image_landscape_9]
 **body** | [**String**](String.md)| The image in PNG or JPEG format. |

### Return type

[**BrandingImage**](BrandingImage.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: image/png, image/jpeg
 - **Accept**: application/json

<a name="uploadLightImageMultipart"></a>
# **uploadLightImageMultipart**
> BrandingImage uploadLightImageMultipart(reference, image)

Upload an image in the light theme.

An endpoint for uploading a new account branding image as form data in the light theme in PNG or JPEG format.

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.AccountAdminApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

AccountAdminApi apiInstance = new AccountAdminApi();
String reference = "reference_example"; // String | Name of the branding images (icon or picture).
File image = new File("/path/to/file.txt"); // File | The image in PNG or JPEG format as multipart form data.
try {
    BrandingImage result = apiInstance.uploadLightImageMultipart(reference, image);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AccountAdminApi#uploadLightImageMultipart");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **reference** | **String**| Name of the branding images (icon or picture). | [enum: brand_logo_portrait, brand_logo_square, brand_logo_landscape, brand_logo_email, desktop_background_landscape, desktop_background_square, desktop_background_portrait, carousel_image_portrait_0, carousel_image_portrait_1, carousel_image_portrait_2, carousel_image_portrait_3, carousel_image_portrait_4, carousel_image_portrait_5, carousel_image_portrait_6, carousel_image_portrait_7, carousel_image_portrait_8, carousel_image_portrait_9, carousel_image_square_0, carousel_image_square_1, carousel_image_square_2, carousel_image_square_3, carousel_image_square_4, carousel_image_square_5, carousel_image_square_6, carousel_image_square_7, carousel_image_square_8, carousel_image_square_9, carousel_image_landscape_0, carousel_image_landscape_1, carousel_image_landscape_2, carousel_image_landscape_3, carousel_image_landscape_4, carousel_image_landscape_5, carousel_image_landscape_6, carousel_image_landscape_7, carousel_image_landscape_8, carousel_image_landscape_9]
 **image** | **File**| The image in PNG or JPEG format as multipart form data. |

### Return type

[**BrandingImage**](BrandingImage.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: multipart/form-data
 - **Accept**: application/json

