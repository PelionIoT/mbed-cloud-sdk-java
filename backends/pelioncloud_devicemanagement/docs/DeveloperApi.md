# DeveloperApi

All URIs are relative to *https://api.us-east-1.mbedcloud.com*

Method | HTTP request | Description
------------- | ------------- | -------------
[**addMyApiKeyToGroups**](DeveloperApi.md#addMyApiKeyToGroups) | **POST** v3/api-keys/me/groups | Add API key to a list of groups.
[**createApiKey**](DeveloperApi.md#createApiKey) | **POST** v3/api-keys | Create a new API key.
[**deleteApiKey**](DeveloperApi.md#deleteApiKey) | **DELETE** v3/api-keys/{apikey_id} | Delete API key.
[**deleteCertificate**](DeveloperApi.md#deleteCertificate) | **DELETE** v3/trusted-certificates/{cert_id} | Delete a trusted certificate by ID.
[**getAllApiKeys**](DeveloperApi.md#getAllApiKeys) | **GET** v3/api-keys | Get all API keys
[**getAllCertificates**](DeveloperApi.md#getAllCertificates) | **GET** v3/trusted-certificates | Get all trusted certificates.
[**getAllDarkImageData**](DeveloperApi.md#getAllDarkImageData) | **GET** v3/branding-images/dark | Get metadata of all images in the dark theme.
[**getAllGroups**](DeveloperApi.md#getAllGroups) | **GET** v3/policy-groups | Get all group information.
[**getAllLightImageData**](DeveloperApi.md#getAllLightImageData) | **GET** v3/branding-images/light | Get metadata of all images in the light theme.
[**getApiKey**](DeveloperApi.md#getApiKey) | **GET** v3/api-keys/{apikey_id} | Get API key details.
[**getApiKeysOfGroup**](DeveloperApi.md#getApiKeysOfGroup) | **GET** v3/policy-groups/{group_id}/api-keys | Get the API keys of a group.
[**getCertificate**](DeveloperApi.md#getCertificate) | **GET** v3/trusted-certificates/{cert_id} | Get trusted certificate by ID.
[**getDarkColor**](DeveloperApi.md#getDarkColor) | **GET** v3/branding-colors/dark/{reference} | Get branding color of the dark theme.
[**getDarkColors**](DeveloperApi.md#getDarkColors) | **GET** v3/branding-colors/dark | Get branding colors of the dark theme.
[**getDarkImageData**](DeveloperApi.md#getDarkImageData) | **GET** v3/branding-images/dark/{reference} | Get metadata of an image in the dark theme.
[**getGroupSummary**](DeveloperApi.md#getGroupSummary) | **GET** v3/policy-groups/{group_id} | Get group information.
[**getGroupsOfMyApiKey**](DeveloperApi.md#getGroupsOfMyApiKey) | **GET** v3/api-keys/me/groups | Get groups of the API key.
[**getLightColor**](DeveloperApi.md#getLightColor) | **GET** v3/branding-colors/light/{reference} | Get branding color of the light theme.
[**getLightColors**](DeveloperApi.md#getLightColors) | **GET** v3/branding-colors/light | Get branding colors of the light theme.
[**getLightImageData**](DeveloperApi.md#getLightImageData) | **GET** v3/branding-images/light/{reference} | Get metadata of an image in the light theme.
[**getMyAccountInfo**](DeveloperApi.md#getMyAccountInfo) | **GET** v3/accounts/me | Get account info.
[**getMyApiKey**](DeveloperApi.md#getMyApiKey) | **GET** v3/api-keys/me | Get API key details.
[**getMyUser**](DeveloperApi.md#getMyUser) | **GET** v3/users/me | Details of the current user.
[**removeApiKeysFromGroup**](DeveloperApi.md#removeApiKeysFromGroup) | **DELETE** v3/policy-groups/{group_id}/api-keys | Remove API keys from a group.
[**removeMyApiKeyFromGroups**](DeveloperApi.md#removeMyApiKeyFromGroups) | **DELETE** v3/api-keys/me/groups | Remove API key from groups.
[**updateApiKey**](DeveloperApi.md#updateApiKey) | **PUT** v3/api-keys/{apikey_id} | Update API key details.
[**updateCertificate**](DeveloperApi.md#updateCertificate) | **PUT** v3/trusted-certificates/{cert_id} | Update trusted certificate.
[**updateMyApiKey**](DeveloperApi.md#updateMyApiKey) | **PUT** v3/api-keys/me | Update API key details.


<a name="addMyApiKeyToGroups"></a>
# **addMyApiKeyToGroups**
> UpdatedResponse addMyApiKeyToGroups(body)

Add API key to a list of groups.

An endpoint for adding API key to groups.  **Example usage:** &#x60;curl -X POST https://api.us-east-1.mbedcloud.com/v3/api-keys/me/groups -d &#39;[\&quot;0162056a9a1586f30242590700000000\&quot;,\&quot;0117056a9a1586f30242590700000000\&quot;]&#39; -H &#39;content-type: application/json&#39; -H &#39;Authorization: Bearer API_KEY&#39;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.DeveloperApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

DeveloperApi apiInstance = new DeveloperApi();
List<String> body = Arrays.asList(new List<String>()); // List<String> | A list of IDs of the groups to be updated.
try {
    UpdatedResponse result = apiInstance.addMyApiKeyToGroups(body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DeveloperApi#addMyApiKeyToGroups");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | **List&lt;String&gt;**| A list of IDs of the groups to be updated. |

### Return type

[**UpdatedResponse**](UpdatedResponse.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="createApiKey"></a>
# **createApiKey**
> ApiKeyInfoResp createApiKey(body)

Create a new API key.

An endpoint for creating a new API key.  **Example usage:** &#x60;curl -X POST https://api.us-east-1.mbedcloud.com/v3/api-keys -d &#39;{\&quot;name\&quot;: \&quot;MyKey1\&quot;}&#39; -H &#39;content-type: application/json&#39; -H &#39;Authorization: Bearer API_KEY&#39;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.DeveloperApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

DeveloperApi apiInstance = new DeveloperApi();
ApiKeyInfoReq body = new ApiKeyInfoReq(); // ApiKeyInfoReq | The details of the API key to be created.
try {
    ApiKeyInfoResp result = apiInstance.createApiKey(body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DeveloperApi#createApiKey");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**ApiKeyInfoReq**](ApiKeyInfoReq.md)| The details of the API key to be created. |

### Return type

[**ApiKeyInfoResp**](ApiKeyInfoResp.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="deleteApiKey"></a>
# **deleteApiKey**
> Void deleteApiKey(apikeyId)

Delete API key.

An endpoint for deleting the API key.  **Example usage:** &#x60;curl -X DELETE https://api.us-east-1.mbedcloud.com/v3/api-keys/{apikey_id} -H &#39;Authorization: Bearer API_KEY&#39;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.DeveloperApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

DeveloperApi apiInstance = new DeveloperApi();
String apikeyId = "apikeyId_example"; // String | The ID of the API key to be deleted.
try {
    Void result = apiInstance.deleteApiKey(apikeyId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DeveloperApi#deleteApiKey");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **apikeyId** | **String**| The ID of the API key to be deleted. |

### Return type

[**Void**](.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="deleteCertificate"></a>
# **deleteCertificate**
> Void deleteCertificate(certId)

Delete a trusted certificate by ID.

An endpoint for deleting a trusted certificate.  **Example usage:** &#x60;curl -X DELETE https://api.us-east-1.mbedcloud.com/v3/trusted-certificates/{cert_id} -H &#39;Authorization: Bearer API_KEY&#39;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.DeveloperApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

DeveloperApi apiInstance = new DeveloperApi();
String certId = "certId_example"; // String | The ID of the trusted certificate to be deleted.
try {
    Void result = apiInstance.deleteCertificate(certId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DeveloperApi#deleteCertificate");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **certId** | **String**| The ID of the trusted certificate to be deleted. |

### Return type

[**Void**](.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getAllApiKeys"></a>
# **getAllApiKeys**
> ApiKeyInfoRespList getAllApiKeys(limit, after, order, include, keyEq, ownerEq)

Get all API keys

An endpoint for retrieving API keys in an array, optionally filtered by the owner.  **Example usage:** &#x60;curl https://api.us-east-1.mbedcloud.com/v3/api-keys -H &#39;Authorization: Bearer API_KEY&#39;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.DeveloperApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

DeveloperApi apiInstance = new DeveloperApi();
Integer limit = 50; // Integer | The number of results to return (2-1000), default is 50.
String after = "after_example"; // String | The entity ID to fetch after the given one.
String order = "ASC"; // String | The order of the records based on creation time, ASC or DESC; by default ASC
String include = "include_example"; // String | Comma separated additional data to return. Currently supported: total_count
String keyEq = "keyEq_example"; // String | API key filter. Do not include the private part of the API key (the last 32 characters).
String ownerEq = "ownerEq_example"; // String | Owner name filter.
try {
    ApiKeyInfoRespList result = apiInstance.getAllApiKeys(limit, after, order, include, keyEq, ownerEq);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DeveloperApi#getAllApiKeys");
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
 **keyEq** | **String**| API key filter. Do not include the private part of the API key (the last 32 characters). | [optional]
 **ownerEq** | **String**| Owner name filter. | [optional]

### Return type

[**ApiKeyInfoRespList**](ApiKeyInfoRespList.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getAllCertificates"></a>
# **getAllCertificates**
> TrustedCertificateRespList getAllCertificates(limit, after, order, include, nameEq, serviceEq, expireEq, deviceExecutionModeEq, deviceExecutionModeNeq, ownerEq, enrollmentModeEq, statusEq, issuerLike, subjectLike, validEq)

Get all trusted certificates.

An endpoint for retrieving trusted certificates in an array.  **Example usage:** &#x60;curl https://api.us-east-1.mbedcloud.com/v3/trusted-certificates -H &#39;Authorization: Bearer API_KEY&#39;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.DeveloperApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

DeveloperApi apiInstance = new DeveloperApi();
Integer limit = 50; // Integer | The number of results to return (2-1000), default is 50.
String after = "after_example"; // String | The entity ID to fetch after the given one.
String order = "ASC"; // String | The order of the records based on creation time, ASC or DESC; by default ASC
String include = "include_example"; // String | Comma separated additional data to return. Currently supported: total_count
String nameEq = "nameEq_example"; // String | Filter for certificate name
String serviceEq = "serviceEq_example"; // String | Service filter, either lwm2m or bootstrap
Integer expireEq = 56; // Integer | Expire filter in days
Integer deviceExecutionModeEq = 56; // Integer | Device execution mode, as 1 for developer certificates or as another natural integer value
Integer deviceExecutionModeNeq = 56; // Integer | Device execution mode not equals filter
String ownerEq = "ownerEq_example"; // String | Owner name filter
Boolean enrollmentModeEq = true; // Boolean | Enrollment mode filter
String statusEq = "statusEq_example"; // String | Filter for certificate status
String issuerLike = "issuerLike_example"; // String | Issuer filter. Finds all matches where the filter value is a case insensitive substring of the result. Example: issuer__like=cn=iss matches CN=issuer.
String subjectLike = "subjectLike_example"; // String | Subject filter. Finds all matches where the filter value is a case insensitive substring of the result. Example: subject__like=cn=su matches CN=subject.
Boolean validEq = true; // Boolean | Filter for finding certificates by validity. True returns certificates which are not yet expired. False returns certificates which have expired.
try {
    TrustedCertificateRespList result = apiInstance.getAllCertificates(limit, after, order, include, nameEq, serviceEq, expireEq, deviceExecutionModeEq, deviceExecutionModeNeq, ownerEq, enrollmentModeEq, statusEq, issuerLike, subjectLike, validEq);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DeveloperApi#getAllCertificates");
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
 **nameEq** | **String**| Filter for certificate name | [optional]
 **serviceEq** | **String**| Service filter, either lwm2m or bootstrap | [optional]
 **expireEq** | **Integer**| Expire filter in days | [optional]
 **deviceExecutionModeEq** | **Integer**| Device execution mode, as 1 for developer certificates or as another natural integer value | [optional]
 **deviceExecutionModeNeq** | **Integer**| Device execution mode not equals filter | [optional]
 **ownerEq** | **String**| Owner name filter | [optional]
 **enrollmentModeEq** | **Boolean**| Enrollment mode filter | [optional]
 **statusEq** | **String**| Filter for certificate status | [optional]
 **issuerLike** | **String**| Issuer filter. Finds all matches where the filter value is a case insensitive substring of the result. Example: issuer__like&#x3D;cn&#x3D;iss matches CN&#x3D;issuer. | [optional]
 **subjectLike** | **String**| Subject filter. Finds all matches where the filter value is a case insensitive substring of the result. Example: subject__like&#x3D;cn&#x3D;su matches CN&#x3D;subject. | [optional]
 **validEq** | **Boolean**| Filter for finding certificates by validity. True returns certificates which are not yet expired. False returns certificates which have expired. | [optional]

### Return type

[**TrustedCertificateRespList**](TrustedCertificateRespList.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getAllDarkImageData"></a>
# **getAllDarkImageData**
> BrandingImageList getAllDarkImageData()

Get metadata of all images in the dark theme.

Returns the metadata of all branding images in the dark theme.  **Example usage:** &#x60;curl https://api.us-east-1.mbedcloud.com/v3/branding-images/dark -H &#39;Authorization: Bearer API_KEY&#39;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.DeveloperApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

DeveloperApi apiInstance = new DeveloperApi();
try {
    BrandingImageList result = apiInstance.getAllDarkImageData();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DeveloperApi#getAllDarkImageData");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**BrandingImageList**](BrandingImageList.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getAllGroups"></a>
# **getAllGroups**
> GroupSummaryList getAllGroups(limit, after, order, include, nameEq)

Get all group information.

An endpoint for retrieving all group information.  **Example usage:** &#x60;curl https://api.us-east-1.mbedcloud.com/v3/policy-groups -H &#39;Authorization: Bearer API_KEY&#39;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.DeveloperApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

DeveloperApi apiInstance = new DeveloperApi();
Integer limit = 50; // Integer | The number of results to return (2-1000), default is 50.
String after = "after_example"; // String | The entity ID to fetch after the given one.
String order = "ASC"; // String | The order of the records based on creation time, ASC or DESC; by default ASC
String include = "include_example"; // String | Comma separated additional data to return. Currently supported: total_count
String nameEq = "nameEq_example"; // String | Filter for group name
try {
    GroupSummaryList result = apiInstance.getAllGroups(limit, after, order, include, nameEq);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DeveloperApi#getAllGroups");
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
 **nameEq** | **String**| Filter for group name | [optional]

### Return type

[**GroupSummaryList**](GroupSummaryList.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getAllLightImageData"></a>
# **getAllLightImageData**
> BrandingImageList getAllLightImageData()

Get metadata of all images in the light theme.

Returns the metadata of all branding images in the light theme.  **Example usage:** &#x60;curl https://api.us-east-1.mbedcloud.com/v3/branding-images/light -H &#39;Authorization: Bearer API_KEY&#39;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.DeveloperApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

DeveloperApi apiInstance = new DeveloperApi();
try {
    BrandingImageList result = apiInstance.getAllLightImageData();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DeveloperApi#getAllLightImageData");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**BrandingImageList**](BrandingImageList.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getApiKey"></a>
# **getApiKey**
> ApiKeyInfoResp getApiKey(apikeyId)

Get API key details.

An endpoint for retrieving API key details.  **Example usage:** &#x60;curl https://api.us-east-1.mbedcloud.com/v3/api-keys/{apikey_id} -H &#39;Authorization: Bearer API_KEY&#39;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.DeveloperApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

DeveloperApi apiInstance = new DeveloperApi();
String apikeyId = "apikeyId_example"; // String | The ID of the API key to be retrieved.
try {
    ApiKeyInfoResp result = apiInstance.getApiKey(apikeyId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DeveloperApi#getApiKey");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **apikeyId** | **String**| The ID of the API key to be retrieved. |

### Return type

[**ApiKeyInfoResp**](ApiKeyInfoResp.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getApiKeysOfGroup"></a>
# **getApiKeysOfGroup**
> ApiKeyInfoRespList getApiKeysOfGroup(groupId, limit, after, order, include)

Get the API keys of a group.

An endpoint for listing the API keys of the group with details.  **Example usage:** &#x60;curl https://api.us-east-1.mbedcloud.com/v3/policy-groups/{group_id}/api-keys -H &#39;Authorization: Bearer API_KEY&#39;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.DeveloperApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

DeveloperApi apiInstance = new DeveloperApi();
String groupId = "groupId_example"; // String | The ID of the group whose API keys are retrieved.
Integer limit = 50; // Integer | The number of results to return (2-1000), default is 50.
String after = "after_example"; // String | The entity ID to fetch after the given one.
String order = "ASC"; // String | The order of the records based on creation time, ASC or DESC; by default ASC
String include = "include_example"; // String | Comma separated additional data to return. Currently supported: total_count
try {
    ApiKeyInfoRespList result = apiInstance.getApiKeysOfGroup(groupId, limit, after, order, include);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DeveloperApi#getApiKeysOfGroup");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
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

<a name="getCertificate"></a>
# **getCertificate**
> TrustedCertificateResp getCertificate(certId)

Get trusted certificate by ID.

An endpoint for retrieving a trusted certificate by ID.  **Example usage:** &#x60;curl https://api.us-east-1.mbedcloud.com/v3/trusted-certificates/{cert_id} -H &#39;Authorization: Bearer API_KEY&#39;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.DeveloperApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

DeveloperApi apiInstance = new DeveloperApi();
String certId = "certId_example"; // String | The ID of the trusted certificate to be retrieved.
try {
    TrustedCertificateResp result = apiInstance.getCertificate(certId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DeveloperApi#getCertificate");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **certId** | **String**| The ID of the trusted certificate to be retrieved. |

### Return type

[**TrustedCertificateResp**](TrustedCertificateResp.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getDarkColor"></a>
# **getDarkColor**
> BrandingColor getDarkColor(reference)

Get branding color of the dark theme.

Returns the requested branding color of the dark theme.  **Example usage:** &#x60;curl https://api.us-east-1.mbedcloud.com/v3/branding-colors/dark/{reference} -H &#39;Authorization: Bearer API_KEY&#39;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.DeveloperApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

DeveloperApi apiInstance = new DeveloperApi();
String reference = "reference_example"; // String | The name of the branding color.
try {
    BrandingColor result = apiInstance.getDarkColor(reference);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DeveloperApi#getDarkColor");
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

<a name="getDarkColors"></a>
# **getDarkColors**
> BrandingColorList getDarkColors()

Get branding colors of the dark theme.

Returns the branding colors of the dark theme.  **Example usage:** &#x60;curl https://api.us-east-1.mbedcloud.com/v3/branding-colors/dark -H &#39;Authorization: Bearer API_KEY&#39;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.DeveloperApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

DeveloperApi apiInstance = new DeveloperApi();
try {
    BrandingColorList result = apiInstance.getDarkColors();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DeveloperApi#getDarkColors");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**BrandingColorList**](BrandingColorList.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getDarkImageData"></a>
# **getDarkImageData**
> BrandingImage getDarkImageData(reference)

Get metadata of an image in the dark theme.

An endpoint for getting metadata of one account branding image in the dark theme.  **Example usage:** &#x60;curl https://api.us-east-1.mbedcloud.com/v3/branding-images/dark/{reference} -H &#39;Authorization: Bearer API_KEY&#39;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.DeveloperApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

DeveloperApi apiInstance = new DeveloperApi();
String reference = "reference_example"; // String | Name of the branding images (icon or picture).
try {
    BrandingImage result = apiInstance.getDarkImageData(reference);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DeveloperApi#getDarkImageData");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **reference** | **String**| Name of the branding images (icon or picture). | [enum: brand_logo_portrait, brand_logo_square, brand_logo_landscape, brand_logo_email, desktop_background_landscape, desktop_background_square, desktop_background_portrait, carousel_image_portrait_0, carousel_image_portrait_1, carousel_image_portrait_2, carousel_image_portrait_3, carousel_image_portrait_4, carousel_image_portrait_5, carousel_image_portrait_6, carousel_image_portrait_7, carousel_image_portrait_8, carousel_image_portrait_9, carousel_image_square_0, carousel_image_square_1, carousel_image_square_2, carousel_image_square_3, carousel_image_square_4, carousel_image_square_5, carousel_image_square_6, carousel_image_square_7, carousel_image_square_8, carousel_image_square_9, carousel_image_landscape_0, carousel_image_landscape_1, carousel_image_landscape_2, carousel_image_landscape_3, carousel_image_landscape_4, carousel_image_landscape_5, carousel_image_landscape_6, carousel_image_landscape_7, carousel_image_landscape_8, carousel_image_landscape_9]

### Return type

[**BrandingImage**](BrandingImage.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getGroupSummary"></a>
# **getGroupSummary**
> GroupSummary getGroupSummary(groupId)

Get group information.

An endpoint for getting general information about the group.  **Example usage:** &#x60;curl https://api.us-east-1.mbedcloud.com/v3/policy-groups/{group_id} -H &#39;Authorization: Bearer API_KEY&#39;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.DeveloperApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

DeveloperApi apiInstance = new DeveloperApi();
String groupId = "groupId_example"; // String | The ID of the group to be retrieved.
try {
    GroupSummary result = apiInstance.getGroupSummary(groupId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DeveloperApi#getGroupSummary");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **groupId** | **String**| The ID of the group to be retrieved. |

### Return type

[**GroupSummary**](GroupSummary.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getGroupsOfMyApiKey"></a>
# **getGroupsOfMyApiKey**
> GroupSummaryList getGroupsOfMyApiKey(limit, after, order, include)

Get groups of the API key.

An endpoint for retrieving groups of the API key.  **Example usage:** &#x60;curl https://api.us-east-1.mbedcloud.com/v3/api-keys/me/groups -H &#39;Authorization: Bearer API_KEY&#39;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.DeveloperApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

DeveloperApi apiInstance = new DeveloperApi();
Integer limit = 50; // Integer | The number of results to return (2-1000), default is 50.
String after = "after_example"; // String | The entity ID to fetch after the given one.
String order = "ASC"; // String | The order of the records based on creation time, ASC or DESC; by default ASC
String include = "include_example"; // String | Comma separated additional data to return. Currently supported: total_count
try {
    GroupSummaryList result = apiInstance.getGroupsOfMyApiKey(limit, after, order, include);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DeveloperApi#getGroupsOfMyApiKey");
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

### Return type

[**GroupSummaryList**](GroupSummaryList.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getLightColor"></a>
# **getLightColor**
> BrandingColor getLightColor(reference)

Get branding color of the light theme.

Returns the requested branding color of the light theme.  **Example usage:** &#x60;curl https://api.us-east-1.mbedcloud.com/v3/branding-colors/light/{reference} -H &#39;Authorization: Bearer API_KEY&#39;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.DeveloperApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

DeveloperApi apiInstance = new DeveloperApi();
String reference = "reference_example"; // String | The name of the branding color.
try {
    BrandingColor result = apiInstance.getLightColor(reference);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DeveloperApi#getLightColor");
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

<a name="getLightColors"></a>
# **getLightColors**
> BrandingColorList getLightColors()

Get branding colors of the light theme.

Returns the branding colors of the light theme.  **Example usage:** &#x60;curl https://api.us-east-1.mbedcloud.com/v3/branding-colors/light -H &#39;Authorization: Bearer API_KEY&#39;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.DeveloperApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

DeveloperApi apiInstance = new DeveloperApi();
try {
    BrandingColorList result = apiInstance.getLightColors();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DeveloperApi#getLightColors");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**BrandingColorList**](BrandingColorList.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getLightImageData"></a>
# **getLightImageData**
> BrandingImage getLightImageData(reference)

Get metadata of an image in the light theme.

An endpoint for getting metadata of one account branding image in the light theme.  **Example usage:** &#x60;curl https://api.us-east-1.mbedcloud.com/v3/branding-images/light/{reference} -H &#39;Authorization: Bearer API_KEY&#39;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.DeveloperApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

DeveloperApi apiInstance = new DeveloperApi();
String reference = "reference_example"; // String | Name of the branding images (icon or picture).
try {
    BrandingImage result = apiInstance.getLightImageData(reference);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DeveloperApi#getLightImageData");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **reference** | **String**| Name of the branding images (icon or picture). | [enum: brand_logo_portrait, brand_logo_square, brand_logo_landscape, brand_logo_email, desktop_background_landscape, desktop_background_square, desktop_background_portrait, carousel_image_portrait_0, carousel_image_portrait_1, carousel_image_portrait_2, carousel_image_portrait_3, carousel_image_portrait_4, carousel_image_portrait_5, carousel_image_portrait_6, carousel_image_portrait_7, carousel_image_portrait_8, carousel_image_portrait_9, carousel_image_square_0, carousel_image_square_1, carousel_image_square_2, carousel_image_square_3, carousel_image_square_4, carousel_image_square_5, carousel_image_square_6, carousel_image_square_7, carousel_image_square_8, carousel_image_square_9, carousel_image_landscape_0, carousel_image_landscape_1, carousel_image_landscape_2, carousel_image_landscape_3, carousel_image_landscape_4, carousel_image_landscape_5, carousel_image_landscape_6, carousel_image_landscape_7, carousel_image_landscape_8, carousel_image_landscape_9]

### Return type

[**BrandingImage**](BrandingImage.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getMyAccountInfo"></a>
# **getMyAccountInfo**
> AccountInfo getMyAccountInfo(include, properties)

Get account info.

Returns detailed information about the account.  **Example usage:** &#x60;curl https://api.us-east-1.mbedcloud.com/v3/accounts/me?include&#x3D;policies -H &#39;Authorization: Bearer API_KEY&#39;&#x60;.

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.DeveloperApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

DeveloperApi apiInstance = new DeveloperApi();
String include = "include_example"; // String | Comma separated additional data to return. Currently supported: limits, policies, sub_accounts.
String properties = "properties_example"; // String | Property name to be returned from account specific properties.
try {
    AccountInfo result = apiInstance.getMyAccountInfo(include, properties);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DeveloperApi#getMyAccountInfo");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **include** | **String**| Comma separated additional data to return. Currently supported: limits, policies, sub_accounts. | [optional]
 **properties** | **String**| Property name to be returned from account specific properties. | [optional]

### Return type

[**AccountInfo**](AccountInfo.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getMyApiKey"></a>
# **getMyApiKey**
> ApiKeyInfoResp getMyApiKey()

Get API key details.

An endpoint for retrieving API key details.  **Example usage:** &#x60;curl https://api.us-east-1.mbedcloud.com/v3/api-keys/me -H &#39;Authorization: Bearer API_KEY&#39;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.DeveloperApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

DeveloperApi apiInstance = new DeveloperApi();
try {
    ApiKeyInfoResp result = apiInstance.getMyApiKey();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DeveloperApi#getMyApiKey");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**ApiKeyInfoResp**](ApiKeyInfoResp.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getMyUser"></a>
# **getMyUser**
> UserInfoResp getMyUser(scratchCodes, properties, include)

Details of the current user.

An endpoint for retrieving the details of the logged in user.

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.DeveloperApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

DeveloperApi apiInstance = new DeveloperApi();
String scratchCodes = "scratchCodes_example"; // String | Request to regenerate new emergency scratch codes.
String properties = "properties_example"; // String | Request to return account specific user property values according to the given property name.
String include = "include_example"; // String | Comma separated additional data to return. Currently supported: active_sessions
try {
    UserInfoResp result = apiInstance.getMyUser(scratchCodes, properties, include);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DeveloperApi#getMyUser");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **scratchCodes** | **String**| Request to regenerate new emergency scratch codes. | [optional]
 **properties** | **String**| Request to return account specific user property values according to the given property name. | [optional]
 **include** | **String**| Comma separated additional data to return. Currently supported: active_sessions | [optional]

### Return type

[**UserInfoResp**](UserInfoResp.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="removeApiKeysFromGroup"></a>
# **removeApiKeysFromGroup**
> UpdatedResponse removeApiKeysFromGroup(groupId, body)

Remove API keys from a group.

An endpoint for removing API keys from groups.  **Example usage:** &#x60;curl -X DELETE https://api.us-east-1.mbedcloud.com/v3/policy-groups/{group_id}/api-keys -d &#39;[\&quot;0162056a9a1586f30242590700000000\&quot;,\&quot;0117056a9a1586f30242590700000000\&quot;]&#39; -H &#39;content-type: application/json&#39; -H &#39;Authorization: Bearer API_KEY&#39;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.DeveloperApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

DeveloperApi apiInstance = new DeveloperApi();
String groupId = "groupId_example"; // String | The ID of the group whose API keys are removed.
SubjectList body = new SubjectList(); // SubjectList | A list of API keys to be removed from the group.
try {
    UpdatedResponse result = apiInstance.removeApiKeysFromGroup(groupId, body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DeveloperApi#removeApiKeysFromGroup");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **groupId** | **String**| The ID of the group whose API keys are removed. |
 **body** | [**SubjectList**](SubjectList.md)| A list of API keys to be removed from the group. |

### Return type

[**UpdatedResponse**](UpdatedResponse.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="removeMyApiKeyFromGroups"></a>
# **removeMyApiKeyFromGroups**
> UpdatedResponse removeMyApiKeyFromGroups(body)

Remove API key from groups.

An endpoint for removing API key from groups.  **Example usage:** &#x60;curl -X DELETE https://api.us-east-1.mbedcloud.com/v3/api-keys/me/groups -d &#39;[\&quot;0162056a9a1586f30242590700000000\&quot;,\&quot;0117056a9a1586f30242590700000000\&quot;]&#39; -H &#39;content-type: application/json&#39; -H &#39;Authorization: Bearer API_KEY&#39;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.DeveloperApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

DeveloperApi apiInstance = new DeveloperApi();
List<String> body = Arrays.asList(new List<String>()); // List<String> | A list of IDs of the groups to be updated.
try {
    UpdatedResponse result = apiInstance.removeMyApiKeyFromGroups(body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DeveloperApi#removeMyApiKeyFromGroups");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | **List&lt;String&gt;**| A list of IDs of the groups to be updated. |

### Return type

[**UpdatedResponse**](UpdatedResponse.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="updateApiKey"></a>
# **updateApiKey**
> ApiKeyInfoResp updateApiKey(apikeyId, body)

Update API key details.

An endpoint for updating API key details.  **Example usage:** &#x60;curl -X PUT https://api.us-east-1.mbedcloud.com/v3/api-keys/{apikey_id} -d &#39;{\&quot;name\&quot;: \&quot;TestApiKey25\&quot;}&#39; -H &#39;content-type: application/json&#39; -H &#39;Authorization: Bearer API_KEY&#39;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.DeveloperApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

DeveloperApi apiInstance = new DeveloperApi();
String apikeyId = "apikeyId_example"; // String | The ID of the API key to be updated.
ApiKeyUpdateReq body = new ApiKeyUpdateReq(); // ApiKeyUpdateReq | New API key attributes to be stored.
try {
    ApiKeyInfoResp result = apiInstance.updateApiKey(apikeyId, body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DeveloperApi#updateApiKey");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **apikeyId** | **String**| The ID of the API key to be updated. |
 **body** | [**ApiKeyUpdateReq**](ApiKeyUpdateReq.md)| New API key attributes to be stored. |

### Return type

[**ApiKeyInfoResp**](ApiKeyInfoResp.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="updateCertificate"></a>
# **updateCertificate**
> TrustedCertificateResp updateCertificate(certId, body)

Update trusted certificate.

An endpoint for updating existing trusted certificates.  **Example usage:** &#x60;curl -X PUT https://api.us-east-1.mbedcloud.com/v3/trusted-certificates/{cert_id} -d {\&quot;description\&quot;: \&quot;very important cert\&quot;} -H &#39;content-type: application/json&#39; -H &#39;Authorization: Bearer API_KEY&#39;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.DeveloperApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

DeveloperApi apiInstance = new DeveloperApi();
String certId = "certId_example"; // String | The ID of the trusted certificate to be updated.
TrustedCertificateUpdateReq body = new TrustedCertificateUpdateReq(); // TrustedCertificateUpdateReq | A trusted certificate object with attributes.
try {
    TrustedCertificateResp result = apiInstance.updateCertificate(certId, body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DeveloperApi#updateCertificate");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **certId** | **String**| The ID of the trusted certificate to be updated. |
 **body** | [**TrustedCertificateUpdateReq**](TrustedCertificateUpdateReq.md)| A trusted certificate object with attributes. |

### Return type

[**TrustedCertificateResp**](TrustedCertificateResp.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="updateMyApiKey"></a>
# **updateMyApiKey**
> ApiKeyInfoResp updateMyApiKey(body)

Update API key details.

An endpoint for updating API key details.  **Example usage:** &#x60;curl -X PUT https://api.us-east-1.mbedcloud.com/v3/api-keys/me -d &#39;{\&quot;name\&quot;: \&quot;TestApiKey25\&quot;}&#39; -H &#39;content-type: application/json&#39; -H &#39;Authorization: Bearer API_KEY&#39;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.DeveloperApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

DeveloperApi apiInstance = new DeveloperApi();
ApiKeyUpdateReq body = new ApiKeyUpdateReq(); // ApiKeyUpdateReq | New API key attributes to be stored.
try {
    ApiKeyInfoResp result = apiInstance.updateMyApiKey(body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DeveloperApi#updateMyApiKey");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**ApiKeyUpdateReq**](ApiKeyUpdateReq.md)| New API key attributes to be stored. |

### Return type

[**ApiKeyInfoResp**](ApiKeyInfoResp.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

