# DeviceUpdateCampaignsApi

All URIs are relative to *https://api.us-east-1.mbedcloud.com*

Method | HTTP request | Description
------------- | ------------- | -------------
[**updateCampaignArchive**](DeviceUpdateCampaignsApi.md#updateCampaignArchive) | **POST** v3/update-campaigns/{campaign_id}/archive | Archive a campaign.
[**updateCampaignCreate**](DeviceUpdateCampaignsApi.md#updateCampaignCreate) | **POST** v3/update-campaigns | Create a campaign
[**updateCampaignDestroy**](DeviceUpdateCampaignsApi.md#updateCampaignDestroy) | **DELETE** v3/update-campaigns/{campaign_id} | Delete a campaign
[**updateCampaignEventTypesList**](DeviceUpdateCampaignsApi.md#updateCampaignEventTypesList) | **GET** v3/update-campaigns/{campaign_id}/statistics/{summary_status_id}/event_types | Get a list of events grouped by summary
[**updateCampaignEventTypesRetrieve**](DeviceUpdateCampaignsApi.md#updateCampaignEventTypesRetrieve) | **GET** v3/update-campaigns/{campaign_id}/statistics/{summary_status_id}/event_types/{event_type_id} | Get an event type for a campaign
[**updateCampaignList**](DeviceUpdateCampaignsApi.md#updateCampaignList) | **GET** v3/update-campaigns | List all campaigns
[**updateCampaignMetadataList**](DeviceUpdateCampaignsApi.md#updateCampaignMetadataList) | **GET** v3/update-campaigns/{campaign_id}/campaign-device-metadata | List all campaign device metadata
[**updateCampaignMetadataRetrieve**](DeviceUpdateCampaignsApi.md#updateCampaignMetadataRetrieve) | **GET** v3/update-campaigns/{campaign_id}/campaign-device-metadata/{campaign_device_metadata_id} | Get a campaign device metadata
[**updateCampaignMetrics**](DeviceUpdateCampaignsApi.md#updateCampaignMetrics) | **GET** v3/update-campaigns/{campaign_id}/metrics | Get campaign metrics
[**updateCampaignRetrieve**](DeviceUpdateCampaignsApi.md#updateCampaignRetrieve) | **GET** v3/update-campaigns/{campaign_id} | Get a campaign.
[**updateCampaignStart**](DeviceUpdateCampaignsApi.md#updateCampaignStart) | **POST** v3/update-campaigns/{campaign_id}/start | Start a campaign.
[**updateCampaignStatisticsList**](DeviceUpdateCampaignsApi.md#updateCampaignStatisticsList) | **GET** v3/update-campaigns/{campaign_id}/statistics | Get statistics for a campaign
[**updateCampaignStatisticsRetrieve**](DeviceUpdateCampaignsApi.md#updateCampaignStatisticsRetrieve) | **GET** v3/update-campaigns/{campaign_id}/statistics/{summary_status_id} | Get a status summary
[**updateCampaignStop**](DeviceUpdateCampaignsApi.md#updateCampaignStop) | **POST** v3/update-campaigns/{campaign_id}/stop | Stop a campaign.
[**updateCampaignUpdate**](DeviceUpdateCampaignsApi.md#updateCampaignUpdate) | **PUT** v3/update-campaigns/{campaign_id} | Modify a campaign


<a name="updateCampaignArchive"></a>
# **updateCampaignArchive**
> Void updateCampaignArchive(campaignId)

Archive a campaign.

Archive a campaign. &lt;br&gt; **Usage example:** &#x60;&#x60;&#x60; curl -X POST https://api.us-east-1.mbedcloud.com/v3/update-campaigns/016e83ddc649000000000001001000b8/archive \\ -H &#39;Authorization: Bearer &lt;api_key&gt;&#39; &#x60;&#x60;&#x60; 

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.DeviceUpdateCampaignsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

DeviceUpdateCampaignsApi apiInstance = new DeviceUpdateCampaignsApi();
String campaignId = "campaignId_example"; // String | The campaign ID.
try {
    Void result = apiInstance.updateCampaignArchive(campaignId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DeviceUpdateCampaignsApi#updateCampaignArchive");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **campaignId** | **String**| The campaign ID. |

### Return type

[**Void**](.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="updateCampaignCreate"></a>
# **updateCampaignCreate**
> UpdateCampaign updateCampaignCreate(campaign)

Create a campaign

Create an update campaign.  To include a filter for targeted devices, refer to the filter using &#x60;&lt;filter_id&gt;&#x60; in the message body. &lt;br&gt; **Usage example:** &#x60;&#x60;&#x60; curl -X POST https://api.us-east-1.mbedcloud.com/v3/update-campaigns \\ -H &#39;Authorization: Bearer &lt;api_key&gt;&#39; \\ -H &#39;content-type: application/json;charset&#x3D;UTF-8&#39; \\ -d &#39;{   \&quot;campaign_strategy\&quot;: \&quot;one-shot\&quot;,   \&quot;description\&quot;: \&quot;Campaign is for ...\&quot;,   \&quot;device_filter\&quot;: \&quot;&lt;filter_id&gt;\&quot;,   \&quot;name\&quot;: \&quot;campaign\&quot;,   \&quot;root_manifest_id\&quot;: \&quot;56780000000000a5b70000000000bd98\&quot; }&#39; &#x60;&#x60;&#x60; 

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.DeviceUpdateCampaignsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

DeviceUpdateCampaignsApi apiInstance = new DeviceUpdateCampaignsApi();
UpdateCampaignPostRequest campaign = new UpdateCampaignPostRequest(); // UpdateCampaignPostRequest | Update campaign.
try {
    UpdateCampaign result = apiInstance.updateCampaignCreate(campaign);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DeviceUpdateCampaignsApi#updateCampaignCreate");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **campaign** | [**UpdateCampaignPostRequest**](UpdateCampaignPostRequest.md)| Update campaign. |

### Return type

[**UpdateCampaign**](UpdateCampaign.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="updateCampaignDestroy"></a>
# **updateCampaignDestroy**
> Void updateCampaignDestroy(campaignId)

Delete a campaign

Delete an update campaign. &lt;br&gt; **Usage example:** &#x60;&#x60;&#x60; curl -X DELETE https://api.us-east-1.mbedcloud.com/v3/update-campaigns/1123457f9012ab567890120000789012 \\ -H &#39;Authorization: Bearer &lt;api_key&gt;&#39; &#x60;&#x60;&#x60; 

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.DeviceUpdateCampaignsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

DeviceUpdateCampaignsApi apiInstance = new DeviceUpdateCampaignsApi();
String campaignId = "campaignId_example"; // String | The campaign ID.
try {
    Void result = apiInstance.updateCampaignDestroy(campaignId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DeviceUpdateCampaignsApi#updateCampaignDestroy");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **campaignId** | **String**| The campaign ID. |

### Return type

[**Void**](.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="updateCampaignEventTypesList"></a>
# **updateCampaignEventTypesList**
> EventTypeList updateCampaignEventTypesList(campaignId, summaryStatusId)

Get a list of events grouped by summary

Get a list of events grouped by summary. &lt;br&gt; **Usage example:** &#x60;&#x60;&#x60; curl -X GET https://api.us-east-1.mbedcloud.com/v3/update-campaigns/12345678901234567890123456789012/statistics/skipped/event_types \\ -H &#39;Authorization: Bearer &lt;api_key&gt;&#39; &#x60;&#x60;&#x60; 

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.DeviceUpdateCampaignsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

DeviceUpdateCampaignsApi apiInstance = new DeviceUpdateCampaignsApi();
String campaignId = "campaignId_example"; // String | The campaign ID.
String summaryStatusId = "summaryStatusId_example"; // String | The summary status. For example, fail.
try {
    EventTypeList result = apiInstance.updateCampaignEventTypesList(campaignId, summaryStatusId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DeviceUpdateCampaignsApi#updateCampaignEventTypesList");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **campaignId** | **String**| The campaign ID. |
 **summaryStatusId** | **String**| The summary status. For example, fail. | [enum: fail, success, info, skipped]

### Return type

[**EventTypeList**](EventTypeList.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="updateCampaignEventTypesRetrieve"></a>
# **updateCampaignEventTypesRetrieve**
> EventType updateCampaignEventTypesRetrieve(campaignId, summaryStatusId, eventTypeId)

Get an event type for a campaign

Get the count for a specific event type, for example, succeeded, failed or skipped. &lt;br&gt; **Usage example:** &#x60;&#x60;&#x60; curl -X GET https://api.us-east-1.mbedcloud.com/v3/update-campaigns/12345678901234567890123456789012/statistics/success/event_types/sys_112 \\ -H &#39;Authorization: Bearer &lt;api_key&gt;&#39; &#x60;&#x60;&#x60; 

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.DeviceUpdateCampaignsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

DeviceUpdateCampaignsApi apiInstance = new DeviceUpdateCampaignsApi();
String campaignId = "campaignId_example"; // String | The campaign ID.
String summaryStatusId = "summaryStatusId_example"; // String | The summary status. For example, fail.
String eventTypeId = "eventTypeId_example"; // String | The event type parameter. Event types are grouped into the four values of the summary_status, i.e. fail, success, info and skipped. success: SYS_112, UPD4_OK_M1, UPD1_OK_1, UPD4_OK_100, UPD2_OK_19, UPD2_OK_1, UPD2_OK_18 fail: UPD4_FAIL_508, UPD4_FAIL_217, UPD4_FAIL_305, UPD4_FAIL_405, UPD4_FAIL_511, UPD4_FAIL_220, UPD1_FAIL_6, UPD4_FAIL_302, UPD2_FAIL_11, UPD4_FAIL_219, SYS_103, UPD4_FAIL_407, UPD4_FAIL_224, SYS_111, UPD4_FAIL_210, UPD4_FAIL_306, UPD2_FAIL_14, UPD4_FAIL_221, UPD4_FAIL_315, UPD4_FAIL_403, UPD2_FAIL_12, UPD4_FAIL_207, UPD4_FAIL_215, UPD4_FAIL_504, UPD2_FAIL_3, UPD4_FAIL_103, UPD2_FAIL_16, UPD2_FAIL_6, UPD4_FAIL_101, UPD4_FAIL_202, UPD4_FAIL_313, UPD4_FAIL_209, UPD4_FAIL_301, UPD2_FAIL_4, SYS_123, UPD4_FAIL_314, UPD4_FAIL_205, UPD4_FAIL_212, UPD4_FAIL_311, UPD4_FAIL_304, UPD4_FAIL_223, UPD4_FAIL_226, UPD1_FAIL_2, UPD4_FAIL_203, UPD4_FAIL_507, UPD4_FAIL_402, UPD4_FAIL_204, UPD4_FAIL_510, UPD1_FAIL_7, UPD4_FAIL_218, UPD1_FAIL_8, UPD2_FAIL_5, UPD4_FAIL_201, UPD4_FAIL_213, UPD4_FAIL_400, UPD2_FAIL_17, UPD4_FAIL_310, UPD4_FAIL_206, UPD4_FAIL_102, UPD2_FAIL_7, UPD1_FAIL_9, UPD4_FAIL_22, UPD4_FAIL_502, UPD4_FAIL_211, UPD1_FAIL_4, UPD1_FAIL_3, UPD4_FAIL_409, UPD4_FAIL_408, UPD4_FAIL_200, SYS_104, UPD2_FAIL_10, UPD2_FAIL_15, UPD4_FAIL_216, UPD4_FAIL_214, UPD4_FAIL_308, UPD4_FAIL_401, UPD1_FAIL_5, UPD2_FAIL_13, UPD4_FAIL_208, UPD2_FAIL_2, UPD4_FAIL_312, UPD4_FAIL_509, UPD4_FAIL_303, UPD4_FAIL_512, UPD2_FAIL_9, UPD4_FAIL_316, UPD4_FAIL_506, SYS_101, UPD4_FAIL_309, UPD4_FAIL_307, UPD4_FAIL_404, UPD4_FAIL_503, UPD4_FAIL_225, UPD4_FAIL_300, UPD4_FAIL_500, UPD4_FAIL_505, UPD4_FAIL_406, UPD4_FAIL_222, UPD4_FAIL_501, UPD2_FAIL_8, SYS_124 info: UPD1_STATE_0, UPD2_REPORT_HASH, UPD1_REPORT_HASH, UPD2_STATE_5, UPD2_STATE_0, UPD2_STATE_4, UPD2_STATE_3, SYS_107, SYS_105, SYS_106, UPD1_REPORT_VERSION, UPD1_STATE_2, SYS_116, SYS_108, SYS_100, UPD2_STATE_8, UPD2_STATE_7, SYS_120, UPD2_STATE_1, SYS_113, UPD2_STATE_6, UPD2_REPORT_VERSION, SYS_115, UPD2_STATE_2, SYS_114, UPD1_STATE_3, UPD1_STATE_1, SYS_125 skipped: SYS_121, SYS_118, SYS_122, SYS_110, SYS_117 
try {
    EventType result = apiInstance.updateCampaignEventTypesRetrieve(campaignId, summaryStatusId, eventTypeId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DeviceUpdateCampaignsApi#updateCampaignEventTypesRetrieve");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **campaignId** | **String**| The campaign ID. |
 **summaryStatusId** | **String**| The summary status. For example, fail. | [enum: fail, success, info, skipped]
 **eventTypeId** | **String**| The event type parameter. Event types are grouped into the four values of the summary_status, i.e. fail, success, info and skipped. success: SYS_112, UPD4_OK_M1, UPD1_OK_1, UPD4_OK_100, UPD2_OK_19, UPD2_OK_1, UPD2_OK_18 fail: UPD4_FAIL_508, UPD4_FAIL_217, UPD4_FAIL_305, UPD4_FAIL_405, UPD4_FAIL_511, UPD4_FAIL_220, UPD1_FAIL_6, UPD4_FAIL_302, UPD2_FAIL_11, UPD4_FAIL_219, SYS_103, UPD4_FAIL_407, UPD4_FAIL_224, SYS_111, UPD4_FAIL_210, UPD4_FAIL_306, UPD2_FAIL_14, UPD4_FAIL_221, UPD4_FAIL_315, UPD4_FAIL_403, UPD2_FAIL_12, UPD4_FAIL_207, UPD4_FAIL_215, UPD4_FAIL_504, UPD2_FAIL_3, UPD4_FAIL_103, UPD2_FAIL_16, UPD2_FAIL_6, UPD4_FAIL_101, UPD4_FAIL_202, UPD4_FAIL_313, UPD4_FAIL_209, UPD4_FAIL_301, UPD2_FAIL_4, SYS_123, UPD4_FAIL_314, UPD4_FAIL_205, UPD4_FAIL_212, UPD4_FAIL_311, UPD4_FAIL_304, UPD4_FAIL_223, UPD4_FAIL_226, UPD1_FAIL_2, UPD4_FAIL_203, UPD4_FAIL_507, UPD4_FAIL_402, UPD4_FAIL_204, UPD4_FAIL_510, UPD1_FAIL_7, UPD4_FAIL_218, UPD1_FAIL_8, UPD2_FAIL_5, UPD4_FAIL_201, UPD4_FAIL_213, UPD4_FAIL_400, UPD2_FAIL_17, UPD4_FAIL_310, UPD4_FAIL_206, UPD4_FAIL_102, UPD2_FAIL_7, UPD1_FAIL_9, UPD4_FAIL_22, UPD4_FAIL_502, UPD4_FAIL_211, UPD1_FAIL_4, UPD1_FAIL_3, UPD4_FAIL_409, UPD4_FAIL_408, UPD4_FAIL_200, SYS_104, UPD2_FAIL_10, UPD2_FAIL_15, UPD4_FAIL_216, UPD4_FAIL_214, UPD4_FAIL_308, UPD4_FAIL_401, UPD1_FAIL_5, UPD2_FAIL_13, UPD4_FAIL_208, UPD2_FAIL_2, UPD4_FAIL_312, UPD4_FAIL_509, UPD4_FAIL_303, UPD4_FAIL_512, UPD2_FAIL_9, UPD4_FAIL_316, UPD4_FAIL_506, SYS_101, UPD4_FAIL_309, UPD4_FAIL_307, UPD4_FAIL_404, UPD4_FAIL_503, UPD4_FAIL_225, UPD4_FAIL_300, UPD4_FAIL_500, UPD4_FAIL_505, UPD4_FAIL_406, UPD4_FAIL_222, UPD4_FAIL_501, UPD2_FAIL_8, SYS_124 info: UPD1_STATE_0, UPD2_REPORT_HASH, UPD1_REPORT_HASH, UPD2_STATE_5, UPD2_STATE_0, UPD2_STATE_4, UPD2_STATE_3, SYS_107, SYS_105, SYS_106, UPD1_REPORT_VERSION, UPD1_STATE_2, SYS_116, SYS_108, SYS_100, UPD2_STATE_8, UPD2_STATE_7, SYS_120, UPD2_STATE_1, SYS_113, UPD2_STATE_6, UPD2_REPORT_VERSION, SYS_115, UPD2_STATE_2, SYS_114, UPD1_STATE_3, UPD1_STATE_1, SYS_125 skipped: SYS_121, SYS_118, SYS_122, SYS_110, SYS_117  |

### Return type

[**EventType**](EventType.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="updateCampaignList"></a>
# **updateCampaignList**
> UpdateCampaignPage updateCampaignList(limit, order, after, include, filter, createdAtIn, createdAtNin, createdAtLte, createdAtGte, descriptionEq, descriptionNeq, descriptionIn, descriptionNin, deviceFilterEq, deviceFilterNeq, deviceFilterIn, deviceFilterNin, finishedIn, finishedNin, finishedLte, finishedGte, idEq, idNeq, idIn, idNin, nameEq, nameNeq, nameIn, nameNin, rootManifestIdEq, rootManifestIdNeq, rootManifestIdIn, rootManifestIdNin, startedAtIn, startedAtNin, startedAtLte, startedAtGte, stateEq, stateNeq, stateIn, stateNin, updatedAtIn, updatedAtNin, updatedAtLte, updatedAtGte, whenIn, whenNin, whenLte, whenGte)

List all campaigns

Get update campaigns for devices specified by a filter. &lt;br&gt; **Usage example:** &#x60;&#x60;&#x60; curl -X GET https://api.us-east-1.mbedcloud.com/v3/update-campaigns \\ -H &#39;Authorization: Bearer &lt;api_key&gt;&#39; &#x60;&#x60;&#x60; 

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.DeviceUpdateCampaignsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

DeviceUpdateCampaignsApi apiInstance = new DeviceUpdateCampaignsApi();
Integer limit = 56; // Integer | How many objects to retrieve in the page. The minimum limit is 2 and the maximum is 1000. Limit values outside of this range are set to the closest limit.
String order = "order_example"; // String | The order of the records. Acceptable values: ASC, DESC. Default: ASC.
String after = "after_example"; // String | The ID of the item after which to retrieve the next page.
String include = "include_example"; // String | A comma-separated list of data fields to return. Currently supported: total_count.
String filter = "filter_example"; // String | URL-encoded query string parameter to filter returned data  `?filter={URL-encoded query string}`   ###### Filterable fields:  The below table lists all the fields that can be filtered on with certain filters:  <table>   <thead>     <tr>       <th>Field</th>       <th>= / __eq / __neq</th>       <th>__in /  __nin</th>       <th>__lte / __gte</th>     <tr>   <thead>   <tbody>     <tr>       <td>created_at</td>       <td>✓</td>       <td>✓</td>       <td>✓</td>     </tr>     <tr>       <td>description</td>       <td>✓</td>       <td>✓</td>       <td>&nbsp;</td>     </tr>     <tr>       <td>device_filter</td>       <td>✓</td>       <td>✓</td>       <td>&nbsp;</td>     </tr>     <tr>       <td>etag</td>       <td>✓</td>       <td>✓</td>       <td>✓</td>     </tr>     <tr>       <td>finished</td>       <td>✓</td>       <td>✓</td>       <td>✓</td>     </tr>     <tr>       <td>id</td>       <td>✓</td>       <td>✓</td>       <td>&nbsp;</td>     </tr>     <tr>       <td>name</td>       <td>✓</td>       <td>✓</td>       <td>&nbsp;</td>     </tr>     <tr>       <td>root_manifest_id</td>       <td>✓</td>       <td>✓</td>       <td>&nbsp;</td>     </tr>     <tr>       <td>started_at</td>       <td>✓</td>       <td>✓</td>       <td>✓</td>     </tr>     <tr>       <td>state</td>       <td>✓</td>       <td>✓</td>       <td>&nbsp;</td>     </tr>     <tr>       <td>updated_at</td>       <td>✓</td>       <td>✓</td>       <td>✓</td>     </tr>     <tr>       <td>when</td>       <td>✓</td>       <td>✓</td>       <td>✓</td>     </tr>   </tbody> </table> &nbsp;  The query string is made up of key-value pairs separated by ampersands. For example, this query: `key1__eq=value1&key2__eq=value2&key3__eq=value3`  would be URL-encoded as: `?filter=key1__eq%3Dvalue1%26key2__eq%3Dvalue2%26key3__eq%3Dvalue3`   **Filtering by campaign properties** `state__eq=[draft|scheduled|devicefectch|devicecopy|publishing|deploying|deployed|manifestremoved|expired]`  `root_manifest_id__eq=43217771234242e594ddb433816c498a`  **Filtering on date-time fields**  Date-time fields should be specified in UTC RFC3339 format, `YYYY-MM-DDThh:mm:ss.msZ`. There are three permitted variations:  * UTC RFC3339 with milliseconds. Example: `2016-11-30T16:25:12.1234Z` * UTC RFC3339 without milliseconds. Example: `2016-11-30T16:25:12Z` * UTC RFC3339 shortened without milliseconds and punctuation. Example: `20161130T162512Z`  Date-time filtering supports three operators:  * equality by appending `__eq` to the field name * greater than or equal to by appending `__gte` to the field name * less than or equal to by appending `__lte` to the field name  `{field name}[|__eq|__lte|__gte]={UTC RFC3339 date-time}`  Time ranges may be specified by including both the `__gte` and `__lte` forms in the filter. For example:  `created_at__gte=2016-11-30T16:25:12.1234Z&created_at__lte=2016-12-30T00:00:00Z`  **Filtering on multiple fields**  `state__eq=deployed&created_at__gte=2016-11-30T16:25:12.1234Z&created_at__lte=2016-12-30T00:00:00Z`  **Filtering with filter operators**  String field filtering supports the following operators:  * equality: `__eq` * non-equality: `__neq` * in : `__in` * not in: `__nin`  For `__in` and `__nin` filters list of parameters must be comma-separated:  `name__in=fw-image1,fw-image2`
String createdAtIn = "createdAtIn_example"; // String | in filter for the \"created_at\" field
String createdAtNin = "createdAtNin_example"; // String | nin filter for the \"created_at\" field
DateTime createdAtLte = new DateTime(); // DateTime | lte filter for the \"created_at\" field
DateTime createdAtGte = new DateTime(); // DateTime | gte filter for the \"created_at\" field
String descriptionEq = "descriptionEq_example"; // String | eq filter for the \"description\" field
String descriptionNeq = "descriptionNeq_example"; // String | neq filter for the \"description\" field
String descriptionIn = "descriptionIn_example"; // String | in filter for the \"description\" field
String descriptionNin = "descriptionNin_example"; // String | nin filter for the \"description\" field
String deviceFilterEq = "deviceFilterEq_example"; // String | eq filter for the \"device_filter\" field
String deviceFilterNeq = "deviceFilterNeq_example"; // String | neq filter for the \"device_filter\" field
String deviceFilterIn = "deviceFilterIn_example"; // String | in filter for the \"device_filter\" field
String deviceFilterNin = "deviceFilterNin_example"; // String | nin filter for the \"device_filter\" field
String finishedIn = "finishedIn_example"; // String | in filter for the \"finished\" field
String finishedNin = "finishedNin_example"; // String | nin filter for the \"finished\" field
DateTime finishedLte = new DateTime(); // DateTime | lte filter for the \"finished\" field
DateTime finishedGte = new DateTime(); // DateTime | gte filter for the \"finished\" field
String idEq = "idEq_example"; // String | eq filter for the \"id\" field
String idNeq = "idNeq_example"; // String | neq filter for the \"id\" field
String idIn = "idIn_example"; // String | in filter for the \"id\" field
String idNin = "idNin_example"; // String | nin filter for the \"id\" field
String nameEq = "nameEq_example"; // String | eq filter for the \"name\" field
String nameNeq = "nameNeq_example"; // String | neq filter for the \"name\" field
String nameIn = "nameIn_example"; // String | in filter for the \"name\" field
String nameNin = "nameNin_example"; // String | nin filter for the \"name\" field
String rootManifestIdEq = "rootManifestIdEq_example"; // String | eq filter for the \"root_manifest_id\" field
String rootManifestIdNeq = "rootManifestIdNeq_example"; // String | neq filter for the \"root_manifest_id\" field
String rootManifestIdIn = "rootManifestIdIn_example"; // String | in filter for the \"root_manifest_id\" field
String rootManifestIdNin = "rootManifestIdNin_example"; // String | nin filter for the \"root_manifest_id\" field
String startedAtIn = "startedAtIn_example"; // String | in filter for the \"started_at\" field
String startedAtNin = "startedAtNin_example"; // String | nin filter for the \"started_at\" field
DateTime startedAtLte = new DateTime(); // DateTime | lte filter for the \"started_at\" field
DateTime startedAtGte = new DateTime(); // DateTime | gte filter for the \"started_at\" field
String stateEq = "stateEq_example"; // String | eq filter for the \"state\" field
String stateNeq = "stateNeq_example"; // String | neq filter for the \"state\" field
String stateIn = "stateIn_example"; // String | in filter for the \"state\" field
String stateNin = "stateNin_example"; // String | nin filter for the \"state\" field
String updatedAtIn = "updatedAtIn_example"; // String | in filter for the \"updated_at\" field
String updatedAtNin = "updatedAtNin_example"; // String | nin filter for the \"updated_at\" field
DateTime updatedAtLte = new DateTime(); // DateTime | lte filter for the \"updated_at\" field
DateTime updatedAtGte = new DateTime(); // DateTime | gte filter for the \"updated_at\" field
String whenIn = "whenIn_example"; // String | in filter for the \"when\" field
String whenNin = "whenNin_example"; // String | nin filter for the \"when\" field
DateTime whenLte = new DateTime(); // DateTime | lte filter for the \"when\" field
DateTime whenGte = new DateTime(); // DateTime | gte filter for the \"when\" field
try {
    UpdateCampaignPage result = apiInstance.updateCampaignList(limit, order, after, include, filter, createdAtIn, createdAtNin, createdAtLte, createdAtGte, descriptionEq, descriptionNeq, descriptionIn, descriptionNin, deviceFilterEq, deviceFilterNeq, deviceFilterIn, deviceFilterNin, finishedIn, finishedNin, finishedLte, finishedGte, idEq, idNeq, idIn, idNin, nameEq, nameNeq, nameIn, nameNin, rootManifestIdEq, rootManifestIdNeq, rootManifestIdIn, rootManifestIdNin, startedAtIn, startedAtNin, startedAtLte, startedAtGte, stateEq, stateNeq, stateIn, stateNin, updatedAtIn, updatedAtNin, updatedAtLte, updatedAtGte, whenIn, whenNin, whenLte, whenGte);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DeviceUpdateCampaignsApi#updateCampaignList");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **limit** | **Integer**| How many objects to retrieve in the page. The minimum limit is 2 and the maximum is 1000. Limit values outside of this range are set to the closest limit. | [optional]
 **order** | **String**| The order of the records. Acceptable values: ASC, DESC. Default: ASC. | [optional]
 **after** | **String**| The ID of the item after which to retrieve the next page. | [optional]
 **include** | **String**| A comma-separated list of data fields to return. Currently supported: total_count. | [optional]
 **filter** | **String**| URL-encoded query string parameter to filter returned data  &#x60;?filter&#x3D;{URL-encoded query string}&#x60;   ###### Filterable fields:  The below table lists all the fields that can be filtered on with certain filters:  &lt;table&gt;   &lt;thead&gt;     &lt;tr&gt;       &lt;th&gt;Field&lt;/th&gt;       &lt;th&gt;&#x3D; / __eq / __neq&lt;/th&gt;       &lt;th&gt;__in /  __nin&lt;/th&gt;       &lt;th&gt;__lte / __gte&lt;/th&gt;     &lt;tr&gt;   &lt;thead&gt;   &lt;tbody&gt;     &lt;tr&gt;       &lt;td&gt;created_at&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;     &lt;/tr&gt;     &lt;tr&gt;       &lt;td&gt;description&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;&amp;nbsp;&lt;/td&gt;     &lt;/tr&gt;     &lt;tr&gt;       &lt;td&gt;device_filter&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;&amp;nbsp;&lt;/td&gt;     &lt;/tr&gt;     &lt;tr&gt;       &lt;td&gt;etag&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;     &lt;/tr&gt;     &lt;tr&gt;       &lt;td&gt;finished&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;     &lt;/tr&gt;     &lt;tr&gt;       &lt;td&gt;id&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;&amp;nbsp;&lt;/td&gt;     &lt;/tr&gt;     &lt;tr&gt;       &lt;td&gt;name&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;&amp;nbsp;&lt;/td&gt;     &lt;/tr&gt;     &lt;tr&gt;       &lt;td&gt;root_manifest_id&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;&amp;nbsp;&lt;/td&gt;     &lt;/tr&gt;     &lt;tr&gt;       &lt;td&gt;started_at&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;     &lt;/tr&gt;     &lt;tr&gt;       &lt;td&gt;state&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;&amp;nbsp;&lt;/td&gt;     &lt;/tr&gt;     &lt;tr&gt;       &lt;td&gt;updated_at&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;     &lt;/tr&gt;     &lt;tr&gt;       &lt;td&gt;when&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;     &lt;/tr&gt;   &lt;/tbody&gt; &lt;/table&gt; &amp;nbsp;  The query string is made up of key-value pairs separated by ampersands. For example, this query: &#x60;key1__eq&#x3D;value1&amp;key2__eq&#x3D;value2&amp;key3__eq&#x3D;value3&#x60;  would be URL-encoded as: &#x60;?filter&#x3D;key1__eq%3Dvalue1%26key2__eq%3Dvalue2%26key3__eq%3Dvalue3&#x60;   **Filtering by campaign properties** &#x60;state__eq&#x3D;[draft|scheduled|devicefectch|devicecopy|publishing|deploying|deployed|manifestremoved|expired]&#x60;  &#x60;root_manifest_id__eq&#x3D;43217771234242e594ddb433816c498a&#x60;  **Filtering on date-time fields**  Date-time fields should be specified in UTC RFC3339 format, &#x60;YYYY-MM-DDThh:mm:ss.msZ&#x60;. There are three permitted variations:  * UTC RFC3339 with milliseconds. Example: &#x60;2016-11-30T16:25:12.1234Z&#x60; * UTC RFC3339 without milliseconds. Example: &#x60;2016-11-30T16:25:12Z&#x60; * UTC RFC3339 shortened without milliseconds and punctuation. Example: &#x60;20161130T162512Z&#x60;  Date-time filtering supports three operators:  * equality by appending &#x60;__eq&#x60; to the field name * greater than or equal to by appending &#x60;__gte&#x60; to the field name * less than or equal to by appending &#x60;__lte&#x60; to the field name  &#x60;{field name}[|__eq|__lte|__gte]&#x3D;{UTC RFC3339 date-time}&#x60;  Time ranges may be specified by including both the &#x60;__gte&#x60; and &#x60;__lte&#x60; forms in the filter. For example:  &#x60;created_at__gte&#x3D;2016-11-30T16:25:12.1234Z&amp;created_at__lte&#x3D;2016-12-30T00:00:00Z&#x60;  **Filtering on multiple fields**  &#x60;state__eq&#x3D;deployed&amp;created_at__gte&#x3D;2016-11-30T16:25:12.1234Z&amp;created_at__lte&#x3D;2016-12-30T00:00:00Z&#x60;  **Filtering with filter operators**  String field filtering supports the following operators:  * equality: &#x60;__eq&#x60; * non-equality: &#x60;__neq&#x60; * in : &#x60;__in&#x60; * not in: &#x60;__nin&#x60;  For &#x60;__in&#x60; and &#x60;__nin&#x60; filters list of parameters must be comma-separated:  &#x60;name__in&#x3D;fw-image1,fw-image2&#x60; | [optional]
 **createdAtIn** | **String**| in filter for the \&quot;created_at\&quot; field | [optional]
 **createdAtNin** | **String**| nin filter for the \&quot;created_at\&quot; field | [optional]
 **createdAtLte** | **DateTime**| lte filter for the \&quot;created_at\&quot; field | [optional]
 **createdAtGte** | **DateTime**| gte filter for the \&quot;created_at\&quot; field | [optional]
 **descriptionEq** | **String**| eq filter for the \&quot;description\&quot; field | [optional]
 **descriptionNeq** | **String**| neq filter for the \&quot;description\&quot; field | [optional]
 **descriptionIn** | **String**| in filter for the \&quot;description\&quot; field | [optional]
 **descriptionNin** | **String**| nin filter for the \&quot;description\&quot; field | [optional]
 **deviceFilterEq** | **String**| eq filter for the \&quot;device_filter\&quot; field | [optional]
 **deviceFilterNeq** | **String**| neq filter for the \&quot;device_filter\&quot; field | [optional]
 **deviceFilterIn** | **String**| in filter for the \&quot;device_filter\&quot; field | [optional]
 **deviceFilterNin** | **String**| nin filter for the \&quot;device_filter\&quot; field | [optional]
 **finishedIn** | **String**| in filter for the \&quot;finished\&quot; field | [optional]
 **finishedNin** | **String**| nin filter for the \&quot;finished\&quot; field | [optional]
 **finishedLte** | **DateTime**| lte filter for the \&quot;finished\&quot; field | [optional]
 **finishedGte** | **DateTime**| gte filter for the \&quot;finished\&quot; field | [optional]
 **idEq** | **String**| eq filter for the \&quot;id\&quot; field | [optional]
 **idNeq** | **String**| neq filter for the \&quot;id\&quot; field | [optional]
 **idIn** | **String**| in filter for the \&quot;id\&quot; field | [optional]
 **idNin** | **String**| nin filter for the \&quot;id\&quot; field | [optional]
 **nameEq** | **String**| eq filter for the \&quot;name\&quot; field | [optional]
 **nameNeq** | **String**| neq filter for the \&quot;name\&quot; field | [optional]
 **nameIn** | **String**| in filter for the \&quot;name\&quot; field | [optional]
 **nameNin** | **String**| nin filter for the \&quot;name\&quot; field | [optional]
 **rootManifestIdEq** | **String**| eq filter for the \&quot;root_manifest_id\&quot; field | [optional]
 **rootManifestIdNeq** | **String**| neq filter for the \&quot;root_manifest_id\&quot; field | [optional]
 **rootManifestIdIn** | **String**| in filter for the \&quot;root_manifest_id\&quot; field | [optional]
 **rootManifestIdNin** | **String**| nin filter for the \&quot;root_manifest_id\&quot; field | [optional]
 **startedAtIn** | **String**| in filter for the \&quot;started_at\&quot; field | [optional]
 **startedAtNin** | **String**| nin filter for the \&quot;started_at\&quot; field | [optional]
 **startedAtLte** | **DateTime**| lte filter for the \&quot;started_at\&quot; field | [optional]
 **startedAtGte** | **DateTime**| gte filter for the \&quot;started_at\&quot; field | [optional]
 **stateEq** | **String**| eq filter for the \&quot;state\&quot; field | [optional]
 **stateNeq** | **String**| neq filter for the \&quot;state\&quot; field | [optional]
 **stateIn** | **String**| in filter for the \&quot;state\&quot; field | [optional]
 **stateNin** | **String**| nin filter for the \&quot;state\&quot; field | [optional]
 **updatedAtIn** | **String**| in filter for the \&quot;updated_at\&quot; field | [optional]
 **updatedAtNin** | **String**| nin filter for the \&quot;updated_at\&quot; field | [optional]
 **updatedAtLte** | **DateTime**| lte filter for the \&quot;updated_at\&quot; field | [optional]
 **updatedAtGte** | **DateTime**| gte filter for the \&quot;updated_at\&quot; field | [optional]
 **whenIn** | **String**| in filter for the \&quot;when\&quot; field | [optional]
 **whenNin** | **String**| nin filter for the \&quot;when\&quot; field | [optional]
 **whenLte** | **DateTime**| lte filter for the \&quot;when\&quot; field | [optional]
 **whenGte** | **DateTime**| gte filter for the \&quot;when\&quot; field | [optional]

### Return type

[**UpdateCampaignPage**](UpdateCampaignPage.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="updateCampaignMetadataList"></a>
# **updateCampaignMetadataList**
> CampaignDeviceMetadataPage updateCampaignMetadataList(campaignId, limit, order, after, include)

List all campaign device metadata

Get metadata for all devices in a campaign. &lt;br&gt; **Usage example:** &#x60;&#x60;&#x60; curl -X GET https://api.us-east-1.mbedcloud.com/v3/update-campaigns/11234567f9012ab56790120000789012/campaign-device-metadata \\ -H &#39;Authorization: Bearer &lt;api_key&gt;&#39; &#x60;&#x60;&#x60; 

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.DeviceUpdateCampaignsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

DeviceUpdateCampaignsApi apiInstance = new DeviceUpdateCampaignsApi();
String campaignId = "campaignId_example"; // String | The campaign ID.
Integer limit = 56; // Integer | How many objects to retrieve in the page. The minimum limit is 2 and the maximum is 1000. Limit values outside of this range are set to the closest limit.
String order = "order_example"; // String | ASC or DESC.
String after = "after_example"; // String | The ID of the item after which to retrieve the next page.
String include = "include_example"; // String | A comma-separated list of data fields to return. Currently supported: total_count.
try {
    CampaignDeviceMetadataPage result = apiInstance.updateCampaignMetadataList(campaignId, limit, order, after, include);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DeviceUpdateCampaignsApi#updateCampaignMetadataList");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **campaignId** | **String**| The campaign ID. |
 **limit** | **Integer**| How many objects to retrieve in the page. The minimum limit is 2 and the maximum is 1000. Limit values outside of this range are set to the closest limit. | [optional]
 **order** | **String**| ASC or DESC. | [optional]
 **after** | **String**| The ID of the item after which to retrieve the next page. | [optional]
 **include** | **String**| A comma-separated list of data fields to return. Currently supported: total_count. | [optional]

### Return type

[**CampaignDeviceMetadataPage**](CampaignDeviceMetadataPage.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="updateCampaignMetadataRetrieve"></a>
# **updateCampaignMetadataRetrieve**
> CampaignDeviceMetadata updateCampaignMetadataRetrieve(campaignId, campaignDeviceMetadataId)

Get a campaign device metadata

Get update campaign metadata for a specific device. &lt;br&gt; **Usage example:** &#x60;&#x60;&#x60; curl -X GET https://api.us-east-1.mbedcloud.com/v3/update-campaigns/5d645eaec2315a89900000655cd94fa8/campaign-device-metadata/016e83ddc645000000000001001000f6 \\ -H &#39;Authorization: Bearer &lt;api_key&gt;&#39; &#x60;&#x60;&#x60; 

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.DeviceUpdateCampaignsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

DeviceUpdateCampaignsApi apiInstance = new DeviceUpdateCampaignsApi();
String campaignId = "campaignId_example"; // String | The campaign ID.
String campaignDeviceMetadataId = "campaignDeviceMetadataId_example"; // String | The campaign device metadata ID.
try {
    CampaignDeviceMetadata result = apiInstance.updateCampaignMetadataRetrieve(campaignId, campaignDeviceMetadataId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DeviceUpdateCampaignsApi#updateCampaignMetadataRetrieve");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **campaignId** | **String**| The campaign ID. |
 **campaignDeviceMetadataId** | **String**| The campaign device metadata ID. |

### Return type

[**CampaignDeviceMetadata**](CampaignDeviceMetadata.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="updateCampaignMetrics"></a>
# **updateCampaignMetrics**
> CampaignMetrics updateCampaignMetrics(campaignId)

Get campaign metrics

Get [information](https://developer.pelion.com/docs/device-management/current/updating-firmware/campaign-metrics-in-portal.html) for a campaign based on **SUCCESS**, **FAIL**, or **SKIPPED** criteria for each device. &lt;br&gt; **Usage example:** &#x60;&#x60;&#x60; curl -X GET https://api.us-east-1.mbedcloud.com/v3/update-campaigns/1123467f9012ab567890120000789012/metrics \\ -H &#39;Authorization: Bearer &lt;api_key&gt;&#39; &#x60;&#x60;&#x60; 

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.DeviceUpdateCampaignsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

DeviceUpdateCampaignsApi apiInstance = new DeviceUpdateCampaignsApi();
String campaignId = "campaignId_example"; // String | The campaign ID.
try {
    CampaignMetrics result = apiInstance.updateCampaignMetrics(campaignId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DeviceUpdateCampaignsApi#updateCampaignMetrics");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **campaignId** | **String**| The campaign ID. |

### Return type

[**CampaignMetrics**](CampaignMetrics.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="updateCampaignRetrieve"></a>
# **updateCampaignRetrieve**
> UpdateCampaign updateCampaignRetrieve(campaignId)

Get a campaign.

Get an update campaign. &lt;br&gt; **Usage example:** &#x60;&#x60;&#x60; curl -X GET https://api.us-east-1.mbedcloud.com/v3/update-campaigns/11234567f9012ab56890120000789012 \\ -H &#39;Authorization: Bearer &lt;api_key&gt;&#39; &#x60;&#x60;&#x60; 

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.DeviceUpdateCampaignsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

DeviceUpdateCampaignsApi apiInstance = new DeviceUpdateCampaignsApi();
String campaignId = "campaignId_example"; // String | The campaign ID.
try {
    UpdateCampaign result = apiInstance.updateCampaignRetrieve(campaignId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DeviceUpdateCampaignsApi#updateCampaignRetrieve");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **campaignId** | **String**| The campaign ID. |

### Return type

[**UpdateCampaign**](UpdateCampaign.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="updateCampaignStart"></a>
# **updateCampaignStart**
> Void updateCampaignStart(campaignId)

Start a campaign.

Start a campaign. &lt;br&gt; **Usage example:** &#x60;&#x60;&#x60; curl -X POST https://api.us-east-1.mbedcloud.com/v3/update-campaigns/5d645eaec2315a8900002e655cd94fa8/start \\ -H &#39;Authorization: Bearer &lt;api_key&gt;&#39; &#x60;&#x60;&#x60; 

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.DeviceUpdateCampaignsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

DeviceUpdateCampaignsApi apiInstance = new DeviceUpdateCampaignsApi();
String campaignId = "campaignId_example"; // String | The campaign ID.
try {
    Void result = apiInstance.updateCampaignStart(campaignId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DeviceUpdateCampaignsApi#updateCampaignStart");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **campaignId** | **String**| The campaign ID. |

### Return type

[**Void**](.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="updateCampaignStatisticsList"></a>
# **updateCampaignStatisticsList**
> EventTypeSummaryList updateCampaignStatisticsList(campaignId)

Get statistics for a campaign

Get a list of statistics for a campaign, including the number of devices reporting specific event codes. &lt;br&gt; **Usage example:** &#x60;&#x60;&#x60; curl -X GET https://api.us-east-1.mbedcloud.com/v3/update-campaigns/11234567f9012ab56780120000789012/statistics \\ -H &#39;Authorization: Bearer &lt;api_key&gt;&#39; &#x60;&#x60;&#x60; 

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.DeviceUpdateCampaignsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

DeviceUpdateCampaignsApi apiInstance = new DeviceUpdateCampaignsApi();
String campaignId = "campaignId_example"; // String | The campaign ID.
try {
    EventTypeSummaryList result = apiInstance.updateCampaignStatisticsList(campaignId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DeviceUpdateCampaignsApi#updateCampaignStatisticsList");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **campaignId** | **String**| The campaign ID. |

### Return type

[**EventTypeSummaryList**](EventTypeSummaryList.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="updateCampaignStatisticsRetrieve"></a>
# **updateCampaignStatisticsRetrieve**
> EventTypeSummary updateCampaignStatisticsRetrieve(campaignId, summaryStatusId)

Get a status summary

Get the count of successfully updated, skipped, and failed devices. &lt;br&gt; **Usage example:** &#x60;&#x60;&#x60; curl https://api.us-east-1.mbedcloud.com/v3/update-campaigns/12345678901234567890123456789012/statistics/fail \\ -H &#39;Authorization: Bearer &lt;api_key&gt;&#39; &#x60;&#x60;&#x60; 

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.DeviceUpdateCampaignsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

DeviceUpdateCampaignsApi apiInstance = new DeviceUpdateCampaignsApi();
String campaignId = "campaignId_example"; // String | The campaign ID.
String summaryStatusId = "summaryStatusId_example"; // String | The summary status. For example, fail.
try {
    EventTypeSummary result = apiInstance.updateCampaignStatisticsRetrieve(campaignId, summaryStatusId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DeviceUpdateCampaignsApi#updateCampaignStatisticsRetrieve");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **campaignId** | **String**| The campaign ID. |
 **summaryStatusId** | **String**| The summary status. For example, fail. | [enum: fail, success, info, skipped]

### Return type

[**EventTypeSummary**](EventTypeSummary.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="updateCampaignStop"></a>
# **updateCampaignStop**
> Void updateCampaignStop(campaignId)

Stop a campaign.

Stop a campaign. Stopping is a process that requires the campaign go through several [phases](https://developer.pelion.com/docs/device-management/current/updating-firmware/device-management-update-using-the-apis.html). &lt;br&gt; **Usage example:** &#x60;&#x60;&#x60; curl -X POST https://api.us-east-1.mbedcloud.com/v3/update-campaigns/016e83ddc645000000000001001000b5/stop \\ -H &#39;Authorization: Bearer &lt;api_key&gt;&#39; &#x60;&#x60;&#x60; 

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.DeviceUpdateCampaignsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

DeviceUpdateCampaignsApi apiInstance = new DeviceUpdateCampaignsApi();
String campaignId = "campaignId_example"; // String | The campaign ID.
try {
    Void result = apiInstance.updateCampaignStop(campaignId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DeviceUpdateCampaignsApi#updateCampaignStop");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **campaignId** | **String**| The campaign ID. |

### Return type

[**Void**](.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="updateCampaignUpdate"></a>
# **updateCampaignUpdate**
> UpdateCampaign updateCampaignUpdate(campaignId, campaign)

Modify a campaign

Modify an update campaign. &lt;br&gt; **Usage example:** &#x60;&#x60;&#x60; curl -X PUT https://api.us-east-1.mbedcloud.com/v3/update-campaigns/1123007f9012ab567890120000789012 \\ -H &#39;Authorization: Bearer &lt;api_key&gt;&#39; \\ d &#39;{   \&quot;description\&quot;: \&quot;Campaign is for ...\&quot;,   \&quot;device_filter\&quot;: \&quot;123400000000000000000000000ae45\&quot;,   \&quot;name\&quot;: \&quot;campaign\&quot;,   \&quot;root_manifest_id\&quot;: \&quot;5678000000000000000000000000bd98\&quot;, }&#39; &#x60;&#x60;&#x60; 

### Example
```java
// Import classes:
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiException;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.Configuration;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.auth.*;
//import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.DeviceUpdateCampaignsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

DeviceUpdateCampaignsApi apiInstance = new DeviceUpdateCampaignsApi();
String campaignId = "campaignId_example"; // String | The campaign ID.
UpdateCampaignPutRequest campaign = new UpdateCampaignPutRequest(); // UpdateCampaignPutRequest | Update campaign.
try {
    UpdateCampaign result = apiInstance.updateCampaignUpdate(campaignId, campaign);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DeviceUpdateCampaignsApi#updateCampaignUpdate");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **campaignId** | **String**| The campaign ID. |
 **campaign** | [**UpdateCampaignPutRequest**](UpdateCampaignPutRequest.md)| Update campaign. |

### Return type

[**UpdateCampaign**](UpdateCampaign.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

