# SecurityAndIdentitySecureDeviceAccessApi

All URIs are relative to *https://api.us-east-1.mbedcloud.com*

Method | HTTP request | Description
------------- | ------------- | -------------
[**createAceAuthToken**](SecurityAndIdentitySecureDeviceAccessApi.md#createAceAuthToken) | **POST** /ace-auth/token | Get an access token to use with a device.
[**createTrustAnchor**](SecurityAndIdentitySecureDeviceAccessApi.md#createTrustAnchor) | **POST** /v3/trust-anchors | Create a new trust anchor for the account.
[**deleteTrustAnchor**](SecurityAndIdentitySecureDeviceAccessApi.md#deleteTrustAnchor) | **DELETE** /v3/trust-anchors/{trust_anchor_id} | Delete a trust anchor.
[**getTrustAnchors**](SecurityAndIdentitySecureDeviceAccessApi.md#getTrustAnchors) | **GET** /v3/trust-anchors | Get the account&#39;s trust anchor used to sign the access token.
[**updateTrustAnchor**](SecurityAndIdentitySecureDeviceAccessApi.md#updateTrustAnchor) | **PUT** /v3/trust-anchors/{trust_anchor_id} | Update trust anchor attributes (description).


<a name="createAceAuthToken"></a>
# **createAceAuthToken**
> TokenResponse createAceAuthToken(body)

Get an access token to use with a device.

Generate a signed CWT (CBOR Web Token). The SDA Android SDK uses this API to gain access to perform actions on the devices specified in the audience (aud). &lt;br&gt; Authorized for roles: Service, ServiceAdministrator &lt;br&gt; **Usage example:** &#x60;&#x60;&#x60; curl -X POST https://api.us-east-1.mbedcloud.com/ace-auth/token \\ -H &#39;Authorization: &lt;valid JWT&gt;&#39; \\ -H &#39;content-type: application/json;charset&#x3D;UTF-8&#39; \\ -d &#39;{   \&quot;grant_type\&quot;:\&quot;client_credentials\&quot;,   \&quot;aud\&quot;:[\&quot;id:f90b1017e52f4c70ad92684e802c9249\&quot;,\&quot;ep:dev1\&quot;],   \&quot;scope\&quot;:\&quot;turn-led-on\&quot;,   \&quot;cnf\&quot;:\&quot;-----BEGIN PUBLIC KEY-----MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ...XwIDAQAB-----END PUBLIC KEY-----\&quot; }&#39; &#x60;&#x60;&#x60; 

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.SecurityAndIdentitySecureDeviceAccessApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

SecurityAndIdentitySecureDeviceAccessApi apiInstance = new SecurityAndIdentitySecureDeviceAccessApi();
TokenRequest body = new TokenRequest(); // TokenRequest | Create access token request.
try {
    TokenResponse result = apiInstance.createAceAuthToken(body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling SecurityAndIdentitySecureDeviceAccessApi#createAceAuthToken");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**TokenRequest**](TokenRequest.md)| Create access token request. |

### Return type

[**TokenResponse**](TokenResponse.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="createTrustAnchor"></a>
# **createTrustAnchor**
> CreateTrustAnchorResponse createTrustAnchor(body)

Create a new trust anchor for the account.

Create a trust anchor key pair and return the public key and creation time. Each account can have one trust anchor only. This API fails if a trust anchor already exists for the account. &lt;br&gt; Authorized for roles: Service, ServiceAdministrator &lt;br&gt; **Usage example:** &#x60;&#x60;&#x60; curl -X POST https://api.us-east-1.mbedcloud.com/v3/trust-anchors \\ -H &#39;Authorization: &lt;valid JWT&gt;&#39; \\ -H &#39;content-type: application/json;charset&#x3D;UTF-8&#39; \\ -d &#39;{   \&quot;description\&quot;: \&quot;Trust anchor for room lighting controller.\&quot; }&#39; &#x60;&#x60;&#x60; 

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.SecurityAndIdentitySecureDeviceAccessApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

SecurityAndIdentitySecureDeviceAccessApi apiInstance = new SecurityAndIdentitySecureDeviceAccessApi();
CreateTrustAnchorRequest body = new CreateTrustAnchorRequest(); // CreateTrustAnchorRequest | Request a new trust anchor.
try {
    CreateTrustAnchorResponse result = apiInstance.createTrustAnchor(body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling SecurityAndIdentitySecureDeviceAccessApi#createTrustAnchor");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**CreateTrustAnchorRequest**](CreateTrustAnchorRequest.md)| Request a new trust anchor. |

### Return type

[**CreateTrustAnchorResponse**](CreateTrustAnchorResponse.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="deleteTrustAnchor"></a>
# **deleteTrustAnchor**
> Void deleteTrustAnchor(trustAnchorId)

Delete a trust anchor.

Delete the specified trust anchor. Unrecoverable. &lt;br&gt; Authorized for roles: Service, ServiceAdministrator &lt;br&gt; **Usage example:** &#x60;&#x60;&#x60; curl -X DELETE https://api.us-east-1.mbedcloud.com/v3/trust-anchors/8e0a9494cc95b750ec6c81464eb06725 \\ -H &#39;Authorization: &lt;valid JWT&gt;&#39; \\ &#x60;&#x60;&#x60; 

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.SecurityAndIdentitySecureDeviceAccessApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

SecurityAndIdentitySecureDeviceAccessApi apiInstance = new SecurityAndIdentitySecureDeviceAccessApi();
String trustAnchorId = "trustAnchorId_example"; // String | The id of the trust anchor to be deleted
try {
    Void result = apiInstance.deleteTrustAnchor(trustAnchorId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling SecurityAndIdentitySecureDeviceAccessApi#deleteTrustAnchor");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **trustAnchorId** | **String**| The id of the trust anchor to be deleted |

### Return type

[**Void**](.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getTrustAnchors"></a>
# **getTrustAnchors**
> GetTrustAnchorsResponse getTrustAnchors(limit, order, after, include)

Get the account&#39;s trust anchor used to sign the access token.

Get all trust anchors that match the account ID specified in the JWT. &lt;br&gt; Authorized for roles: Service, ServiceAdministrator &lt;br&gt; **Usage example:** &#x60;&#x60;&#x60; curl -X GET https://api.us-east-1.mbedcloud.com/v3/trust-anchors \\ -H &#39;Authorization: &lt;valid JWT&gt;&#39; &#x60;&#x60;&#x60; 

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.SecurityAndIdentitySecureDeviceAccessApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

SecurityAndIdentitySecureDeviceAccessApi apiInstance = new SecurityAndIdentitySecureDeviceAccessApi();
Integer limit = 56; // Integer | Indicates how many objects to retrieve in the page. The minimum limit is 2 and the maximum is 1000. Limit values outside of this range are set to the closest limit.
String order = "order_example"; // String | Indicates how to order the entries based on when they were created. `ASC` by default.
String after = "after_example"; // String | The ID of the item after which to retrieve the next page.
String include = "include_example"; // String | Comma-separated list of data fields to return. Currently supported: `total_count`.
try {
    GetTrustAnchorsResponse result = apiInstance.getTrustAnchors(limit, order, after, include);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling SecurityAndIdentitySecureDeviceAccessApi#getTrustAnchors");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **limit** | **Integer**| Indicates how many objects to retrieve in the page. The minimum limit is 2 and the maximum is 1000. Limit values outside of this range are set to the closest limit. | [optional]
 **order** | **String**| Indicates how to order the entries based on when they were created. &#x60;ASC&#x60; by default. | [optional] [enum: ASC, DESC]
 **after** | **String**| The ID of the item after which to retrieve the next page. | [optional]
 **include** | **String**| Comma-separated list of data fields to return. Currently supported: &#x60;total_count&#x60;. | [optional]

### Return type

[**GetTrustAnchorsResponse**](GetTrustAnchorsResponse.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="updateTrustAnchor"></a>
# **updateTrustAnchor**
> UpdateTrustAnchorResponse updateTrustAnchor(trustAnchorId, body)

Update trust anchor attributes (description).

Updates a trust anchor description attribute. &lt;br&gt; Authorized for roles: Service, ServiceAdministrator &lt;br&gt; **Usage example:** &#x60;&#x60;&#x60; curl -X PUT https://api.us-east-1.mbedcloud.com/v3/trust-anchors/8e0a9494cc95b750ec6c81464eb06725 \\ -H &#39;Authorization: &lt;valid JWT&gt;&#39; \\ -H &#39;content-type: application/json;charset&#x3D;UTF-8&#39; \\ -d &#39;{   \&quot;description\&quot;: \&quot;Trust anchor for ambient light module\&quot; }&#39; &#x60;&#x60;&#x60; 

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.SecurityAndIdentitySecureDeviceAccessApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

SecurityAndIdentitySecureDeviceAccessApi apiInstance = new SecurityAndIdentitySecureDeviceAccessApi();
String trustAnchorId = "trustAnchorId_example"; // String | The id of the trust anchor to be updated
UpdateTrustAnchorRequest body = new UpdateTrustAnchorRequest(); // UpdateTrustAnchorRequest | Update trust anchor request.
try {
    UpdateTrustAnchorResponse result = apiInstance.updateTrustAnchor(trustAnchorId, body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling SecurityAndIdentitySecureDeviceAccessApi#updateTrustAnchor");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **trustAnchorId** | **String**| The id of the trust anchor to be updated |
 **body** | [**UpdateTrustAnchorRequest**](UpdateTrustAnchorRequest.md)| Update trust anchor request. |

### Return type

[**UpdateTrustAnchorResponse**](UpdateTrustAnchorResponse.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

