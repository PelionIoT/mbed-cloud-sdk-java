# ManufacturingFactoryConfiguratorUtilityFcuApi

All URIs are relative to *https://api.us-east-1.mbedcloud.com*

Method | HTTP request | Description
------------- | ------------- | -------------
[**downloadFactoryTool**](ManufacturingFactoryConfiguratorUtilityFcuApi.md#downloadFactoryTool) | **GET** downloads/fcu/factory_configurator_utility.zip | Download the Factory Configurator Utility archive.
[**getFactoryToolInfo**](ManufacturingFactoryConfiguratorUtilityFcuApi.md#getFactoryToolInfo) | **GET** downloads/fcu/info | Download information about the Factory Configurator Utility archive.
[**getFactoryToolReleaseNotes**](ManufacturingFactoryConfiguratorUtilityFcuApi.md#getFactoryToolReleaseNotes) | **GET** downloads/fcu/release_notes | Download Factory Configurator Utility release notes.


<a name="downloadFactoryTool"></a>
# **downloadFactoryTool**
> Void downloadFactoryTool()

Download the Factory Configurator Utility archive.

Downloads the Factory Configurator Utility (FCU) archive .zip file for the account ID associated with the access token. &lt;br&gt; **Example:** &lt;br&gt; &#x60;&#x60;&#x60; curl -X GET https://api.us-east-1.mbedcloud.com/downloads/fcu/factory_configurator_utility.zip \\ -H &#39;Authorization: Bearer &lt;access_key&gt;&#39; &#x60;&#x60;&#x60; 

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.ManufacturingFactoryConfiguratorUtilityFcuApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

ManufacturingFactoryConfiguratorUtilityFcuApi apiInstance = new ManufacturingFactoryConfiguratorUtilityFcuApi();
try {
    Void result = apiInstance.downloadFactoryTool();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ManufacturingFactoryConfiguratorUtilityFcuApi#downloadFactoryTool");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**Void**](.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/zip

<a name="getFactoryToolInfo"></a>
# **getFactoryToolInfo**
> ArchiveInfoResponse getFactoryToolInfo()

Download information about the Factory Configurator Utility archive.

Returns information about the Factory Configurator Utility (FCU) archive. &lt;br&gt; **Example:** &lt;br&gt; &#x60;&#x60;&#x60; curl -X GET https://api.us-east-1.mbedcloud.com/downloads/fcu/inf \\ -H &#39;Authorization: Bearer &lt;access_key&gt;&#39;  &#x60;&#x60;&#x60; 

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.ManufacturingFactoryConfiguratorUtilityFcuApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

ManufacturingFactoryConfiguratorUtilityFcuApi apiInstance = new ManufacturingFactoryConfiguratorUtilityFcuApi();
try {
    ArchiveInfoResponse result = apiInstance.getFactoryToolInfo();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ManufacturingFactoryConfiguratorUtilityFcuApi#getFactoryToolInfo");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**ArchiveInfoResponse**](ArchiveInfoResponse.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getFactoryToolReleaseNotes"></a>
# **getFactoryToolReleaseNotes**
> Void getFactoryToolReleaseNotes()

Download Factory Configurator Utility release notes.

Downloads the Factory Configurator Utility (FCU) release notes. &lt;br&gt; **Example:** &lt;br&gt; &#x60;&#x60;&#x60; curl -X GET https://api.us-east-1.mbedcloud.com/downloads/fcu/release_notes \\ -H &#39;Authorization: Bearer &lt;access_key&gt;&#39; &#x60;&#x60;&#x60; 

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.ManufacturingFactoryConfiguratorUtilityFcuApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

ManufacturingFactoryConfiguratorUtilityFcuApi apiInstance = new ManufacturingFactoryConfiguratorUtilityFcuApi();
try {
    Void result = apiInstance.getFactoryToolReleaseNotes();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ManufacturingFactoryConfiguratorUtilityFcuApi#getFactoryToolReleaseNotes");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**Void**](.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: text/markdown ; charset=UTF-8, application/json

