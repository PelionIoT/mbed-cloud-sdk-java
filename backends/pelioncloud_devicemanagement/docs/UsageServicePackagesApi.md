# UsageServicePackagesApi

All URIs are relative to *https://api.us-east-1.mbedcloud.com*

Method | HTTP request | Description
------------- | ------------- | -------------
[**getServicePackageQuotaHistory**](UsageServicePackagesApi.md#getServicePackageQuotaHistory) | **GET** v3/service-packages-quota-history | Service package quota history.


<a name="getServicePackageQuotaHistory"></a>
# **getServicePackageQuotaHistory**
> ServicePackageQuotaHistoryResponse getServicePackageQuotaHistory(limit, after, order)

Service package quota history.

Get your quota usage history. This API is available only for commercial accounts. Aggregator accounts can see their own and tenant quota usage data. Data is in ascending order based on creation time.  **Example:** &#x60;&#x60;&#x60; curl -X GET https://api.us-east-1.mbedcloud.com/v3/service-packages-quota-history \\ -H &#39;Authorization: Bearer &lt;access_key&gt;&#39; &#x60;&#x60;&#x60;

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.UsageServicePackagesApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

UsageServicePackagesApi apiInstance = new UsageServicePackagesApi();
Integer limit = 56; // Integer | Maximum number of quota history entries in one paged response.
String after = "after_example"; // String | Results after specified entry ID.
String order = "order_example"; // String | Record order. Acceptable values: ASC, DESC. Default: ASC.
try {
    ServicePackageQuotaHistoryResponse result = apiInstance.getServicePackageQuotaHistory(limit, after, order);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling UsageServicePackagesApi#getServicePackageQuotaHistory");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **limit** | **Integer**| Maximum number of quota history entries in one paged response. | [optional]
 **after** | **String**| Results after specified entry ID. | [optional]
 **order** | **String**| Record order. Acceptable values: ASC, DESC. Default: ASC. | [optional] [enum: ASC, DESC]

### Return type

[**ServicePackageQuotaHistoryResponse**](ServicePackageQuotaHistoryResponse.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

