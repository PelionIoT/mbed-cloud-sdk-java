package com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api;

import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.CollectionFormats.*;

import retrofit2.Call;
import retrofit2.http.*;

import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.CampaignDeviceMetadata;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.CampaignDeviceMetadataPage;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.CampaignMetrics;
import org.joda.time.DateTime;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.EventType;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.EventTypeList;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.EventTypeSummary;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.EventTypeSummaryList;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.UpdateCampaign;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.UpdateCampaignPage;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.UpdateCampaignPostRequest;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.UpdateCampaignPutRequest;

public interface DeviceUpdateCampaignsApi {
    /**
     * Archive a campaign. Archive a campaign. &lt;br&gt; **Usage example:** &#x60;&#x60;&#x60; curl -X POST
     * https://api.us-east-1.mbedcloud.com/v3/update-campaigns/016e83ddc649000000000001001000b8/archive \\ -H
     * &#39;Authorization: Bearer &lt;api_key&gt;&#39; &#x60;&#x60;&#x60;
     * 
     * @param campaignId
     *            The campaign ID. (required)
     * @return Call&lt;Void&gt;
     */
    @POST("v3/update-campaigns/{campaign_id}/archive")
    Call<Void> updateCampaignArchive(@retrofit2.http.Path(value = "campaign_id", encoded = true) String campaignId);

    /**
     * Create a campaign Create an update campaign. To include a filter for targeted devices, refer to the filter using
     * &#x60;&lt;filter_id&gt;&#x60; in the message body. &lt;br&gt; **Usage example:** &#x60;&#x60;&#x60; curl -X POST
     * https://api.us-east-1.mbedcloud.com/v3/update-campaigns \\ -H &#39;Authorization: Bearer &lt;api_key&gt;&#39; \\
     * -H &#39;content-type: application/json;charset&#x3D;UTF-8&#39; \\ -d &#39;{ \&quot;campaign_strategy\&quot;:
     * \&quot;one-shot\&quot;, \&quot;description\&quot;: \&quot;Campaign is for ...\&quot;,
     * \&quot;device_filter\&quot;: \&quot;&lt;filter_id&gt;\&quot;, \&quot;name\&quot;: \&quot;campaign\&quot;,
     * \&quot;root_manifest_id\&quot;: \&quot;56780000000000a5b70000000000bd98\&quot; }&#39; &#x60;&#x60;&#x60;
     * 
     * @param campaign
     *            Update campaign. (required)
     * @return Call&lt;UpdateCampaign&gt;
     */
    @POST("v3/update-campaigns")
    Call<UpdateCampaign> updateCampaignCreate(@retrofit2.http.Body UpdateCampaignPostRequest campaign);

    /**
     * Delete a campaign Delete an update campaign. &lt;br&gt; **Usage example:** &#x60;&#x60;&#x60; curl -X DELETE
     * https://api.us-east-1.mbedcloud.com/v3/update-campaigns/1123457f9012ab567890120000789012 \\ -H
     * &#39;Authorization: Bearer &lt;api_key&gt;&#39; &#x60;&#x60;&#x60;
     * 
     * @param campaignId
     *            The campaign ID. (required)
     * @return Call&lt;Void&gt;
     */
    @DELETE("v3/update-campaigns/{campaign_id}")
    Call<Void> updateCampaignDestroy(@retrofit2.http.Path(value = "campaign_id", encoded = true) String campaignId);

    /**
     * Get a list of events grouped by summary Get a list of events grouped by summary. &lt;br&gt; **Usage example:**
     * &#x60;&#x60;&#x60; curl -X GET
     * https://api.us-east-1.mbedcloud.com/v3/update-campaigns/12345678901234567890123456789012/statistics/skipped/event_types
     * \\ -H &#39;Authorization: Bearer &lt;api_key&gt;&#39; &#x60;&#x60;&#x60;
     * 
     * @param campaignId
     *            The campaign ID. (required)
     * @param summaryStatusId
     *            The summary status. For example, fail. (required)
     * @return Call&lt;EventTypeList&gt;
     */
    @GET("v3/update-campaigns/{campaign_id}/statistics/{summary_status_id}/event_types")
    Call<EventTypeList>
        updateCampaignEventTypesList(@retrofit2.http.Path(value = "campaign_id", encoded = true) String campaignId,
                                     @retrofit2.http.Path(value = "summary_status_id",
                                                          encoded = true) String summaryStatusId);

    /**
     * Get an event type for a campaign Get the count for a specific event type, for example, succeeded, failed or
     * skipped. &lt;br&gt; **Usage example:** &#x60;&#x60;&#x60; curl -X GET
     * https://api.us-east-1.mbedcloud.com/v3/update-campaigns/12345678901234567890123456789012/statistics/success/event_types/sys_112
     * \\ -H &#39;Authorization: Bearer &lt;api_key&gt;&#39; &#x60;&#x60;&#x60;
     * 
     * @param campaignId
     *            The campaign ID. (required)
     * @param summaryStatusId
     *            The summary status. For example, fail. (required)
     * @param eventTypeId
     *            The event type parameter. Event types are grouped into the four values of the summary_status, i.e.
     *            fail, success, info and skipped. success: SYS_112, UPD4_OK_M1, UPD1_OK_1, UPD4_OK_100, UPD2_OK_19,
     *            UPD2_OK_1, UPD2_OK_18 fail: UPD4_FAIL_508, UPD4_FAIL_217, UPD4_FAIL_305, UPD4_FAIL_405, UPD4_FAIL_511,
     *            UPD4_FAIL_220, UPD1_FAIL_6, UPD4_FAIL_302, UPD2_FAIL_11, UPD4_FAIL_219, SYS_103, UPD4_FAIL_407,
     *            UPD4_FAIL_224, SYS_111, UPD4_FAIL_210, UPD4_FAIL_306, UPD2_FAIL_14, UPD4_FAIL_221, UPD4_FAIL_315,
     *            UPD4_FAIL_403, UPD2_FAIL_12, UPD4_FAIL_207, UPD4_FAIL_215, UPD4_FAIL_504, UPD2_FAIL_3, UPD4_FAIL_103,
     *            UPD2_FAIL_16, UPD2_FAIL_6, UPD4_FAIL_101, UPD4_FAIL_202, UPD4_FAIL_313, UPD4_FAIL_209, UPD4_FAIL_301,
     *            UPD2_FAIL_4, SYS_123, UPD4_FAIL_314, UPD4_FAIL_205, UPD4_FAIL_212, UPD4_FAIL_311, UPD4_FAIL_304,
     *            UPD4_FAIL_223, UPD4_FAIL_226, UPD1_FAIL_2, UPD4_FAIL_203, UPD4_FAIL_507, UPD4_FAIL_402, UPD4_FAIL_204,
     *            UPD4_FAIL_510, UPD1_FAIL_7, UPD4_FAIL_218, UPD1_FAIL_8, UPD2_FAIL_5, UPD4_FAIL_201, UPD4_FAIL_213,
     *            UPD4_FAIL_400, UPD2_FAIL_17, UPD4_FAIL_310, UPD4_FAIL_206, UPD4_FAIL_102, UPD2_FAIL_7, UPD1_FAIL_9,
     *            UPD4_FAIL_22, UPD4_FAIL_502, UPD4_FAIL_211, UPD1_FAIL_4, UPD1_FAIL_3, UPD4_FAIL_409, UPD4_FAIL_408,
     *            UPD4_FAIL_200, SYS_104, UPD2_FAIL_10, UPD2_FAIL_15, UPD4_FAIL_216, UPD4_FAIL_214, UPD4_FAIL_308,
     *            UPD4_FAIL_401, UPD1_FAIL_5, UPD2_FAIL_13, UPD4_FAIL_208, UPD2_FAIL_2, UPD4_FAIL_312, UPD4_FAIL_509,
     *            UPD4_FAIL_303, UPD4_FAIL_512, UPD2_FAIL_9, UPD4_FAIL_316, UPD4_FAIL_506, SYS_101, UPD4_FAIL_309,
     *            UPD4_FAIL_307, UPD4_FAIL_404, UPD4_FAIL_503, UPD4_FAIL_225, UPD4_FAIL_300, UPD4_FAIL_500,
     *            UPD4_FAIL_505, UPD4_FAIL_406, UPD4_FAIL_222, UPD4_FAIL_501, UPD2_FAIL_8, SYS_124 info: UPD1_STATE_0,
     *            UPD2_REPORT_HASH, UPD1_REPORT_HASH, UPD2_STATE_5, UPD2_STATE_0, UPD2_STATE_4, UPD2_STATE_3, SYS_107,
     *            SYS_105, SYS_106, UPD1_REPORT_VERSION, UPD1_STATE_2, SYS_116, SYS_108, SYS_100, UPD2_STATE_8,
     *            UPD2_STATE_7, SYS_120, UPD2_STATE_1, SYS_113, UPD2_STATE_6, UPD2_REPORT_VERSION, SYS_115,
     *            UPD2_STATE_2, SYS_114, UPD1_STATE_3, UPD1_STATE_1, SYS_125 skipped: SYS_121, SYS_118, SYS_122,
     *            SYS_110, SYS_117 (required)
     * @return Call&lt;EventType&gt;
     */
    @GET("v3/update-campaigns/{campaign_id}/statistics/{summary_status_id}/event_types/{event_type_id}")
    Call<EventType>
        updateCampaignEventTypesRetrieve(@retrofit2.http.Path(value = "campaign_id", encoded = true) String campaignId,
                                         @retrofit2.http.Path(value = "summary_status_id",
                                                              encoded = true) String summaryStatusId,
                                         @retrofit2.http.Path(value = "event_type_id",
                                                              encoded = true) String eventTypeId);

    /**
     * List all campaigns Get update campaigns for devices specified by a filter. &lt;br&gt; **Usage example:**
     * &#x60;&#x60;&#x60; curl -X GET https://api.us-east-1.mbedcloud.com/v3/update-campaigns \\ -H &#39;Authorization:
     * Bearer &lt;api_key&gt;&#39; &#x60;&#x60;&#x60;
     * 
     * @param limit
     *            How many objects to retrieve in the page. The minimum limit is 2 and the maximum is 1000. Limit values
     *            outside of this range are set to the closest limit. (optional)
     * @param order
     *            The order of the records. Acceptable values: ASC, DESC. Default: ASC. (optional)
     * @param after
     *            The ID of the item after which to retrieve the next page. (optional)
     * @param include
     *            A comma-separated list of data fields to return. Currently supported: total_count. (optional)
     * @param filter
     *            URL-encoded query string parameter to filter returned data &#x60;?filter&#x3D;{URL-encoded query
     *            string}&#x60; ###### Filterable fields: The below table lists all the fields that can be filtered on
     *            with certain filters: &lt;table&gt; &lt;thead&gt; &lt;tr&gt; &lt;th&gt;Field&lt;/th&gt;
     *            &lt;th&gt;&#x3D; / __eq / __neq&lt;/th&gt; &lt;th&gt;__in / __nin&lt;/th&gt; &lt;th&gt;__lte /
     *            __gte&lt;/th&gt; &lt;tr&gt; &lt;thead&gt; &lt;tbody&gt; &lt;tr&gt; &lt;td&gt;created_at&lt;/td&gt;
     *            &lt;td&gt;✓&lt;/td&gt; &lt;td&gt;✓&lt;/td&gt; &lt;td&gt;✓&lt;/td&gt; &lt;/tr&gt; &lt;tr&gt;
     *            &lt;td&gt;description&lt;/td&gt; &lt;td&gt;✓&lt;/td&gt; &lt;td&gt;✓&lt;/td&gt;
     *            &lt;td&gt;&amp;nbsp;&lt;/td&gt; &lt;/tr&gt; &lt;tr&gt; &lt;td&gt;device_filter&lt;/td&gt;
     *            &lt;td&gt;✓&lt;/td&gt; &lt;td&gt;✓&lt;/td&gt; &lt;td&gt;&amp;nbsp;&lt;/td&gt; &lt;/tr&gt;
     *            &lt;tr&gt; &lt;td&gt;etag&lt;/td&gt; &lt;td&gt;✓&lt;/td&gt; &lt;td&gt;✓&lt;/td&gt;
     *            &lt;td&gt;✓&lt;/td&gt; &lt;/tr&gt; &lt;tr&gt; &lt;td&gt;finished&lt;/td&gt; &lt;td&gt;✓&lt;/td&gt;
     *            &lt;td&gt;✓&lt;/td&gt; &lt;td&gt;✓&lt;/td&gt; &lt;/tr&gt; &lt;tr&gt; &lt;td&gt;id&lt;/td&gt;
     *            &lt;td&gt;✓&lt;/td&gt; &lt;td&gt;✓&lt;/td&gt; &lt;td&gt;&amp;nbsp;&lt;/td&gt; &lt;/tr&gt;
     *            &lt;tr&gt; &lt;td&gt;name&lt;/td&gt; &lt;td&gt;✓&lt;/td&gt; &lt;td&gt;✓&lt;/td&gt;
     *            &lt;td&gt;&amp;nbsp;&lt;/td&gt; &lt;/tr&gt; &lt;tr&gt; &lt;td&gt;root_manifest_id&lt;/td&gt;
     *            &lt;td&gt;✓&lt;/td&gt; &lt;td&gt;✓&lt;/td&gt; &lt;td&gt;&amp;nbsp;&lt;/td&gt; &lt;/tr&gt;
     *            &lt;tr&gt; &lt;td&gt;started_at&lt;/td&gt; &lt;td&gt;✓&lt;/td&gt; &lt;td&gt;✓&lt;/td&gt;
     *            &lt;td&gt;✓&lt;/td&gt; &lt;/tr&gt; &lt;tr&gt; &lt;td&gt;state&lt;/td&gt; &lt;td&gt;✓&lt;/td&gt;
     *            &lt;td&gt;✓&lt;/td&gt; &lt;td&gt;&amp;nbsp;&lt;/td&gt; &lt;/tr&gt; &lt;tr&gt;
     *            &lt;td&gt;updated_at&lt;/td&gt; &lt;td&gt;✓&lt;/td&gt; &lt;td&gt;✓&lt;/td&gt;
     *            &lt;td&gt;✓&lt;/td&gt; &lt;/tr&gt; &lt;tr&gt; &lt;td&gt;when&lt;/td&gt; &lt;td&gt;✓&lt;/td&gt;
     *            &lt;td&gt;✓&lt;/td&gt; &lt;td&gt;✓&lt;/td&gt; &lt;/tr&gt; &lt;/tbody&gt; &lt;/table&gt; &amp;nbsp;
     *            The query string is made up of key-value pairs separated by ampersands. For example, this query:
     *            &#x60;key1__eq&#x3D;value1&amp;key2__eq&#x3D;value2&amp;key3__eq&#x3D;value3&#x60; would be
     *            URL-encoded as: &#x60;?filter&#x3D;key1__eq%3Dvalue1%26key2__eq%3Dvalue2%26key3__eq%3Dvalue3&#x60;
     *            **Filtering by campaign properties**
     *            &#x60;state__eq&#x3D;[draft|scheduled|devicefectch|devicecopy|publishing|deploying|deployed|manifestremoved|expired]&#x60;
     *            &#x60;root_manifest_id__eq&#x3D;43217771234242e594ddb433816c498a&#x60; **Filtering on date-time
     *            fields** Date-time fields should be specified in UTC RFC3339 format,
     *            &#x60;YYYY-MM-DDThh:mm:ss.msZ&#x60;. There are three permitted variations: * UTC RFC3339 with
     *            milliseconds. Example: &#x60;2016-11-30T16:25:12.1234Z&#x60; * UTC RFC3339 without milliseconds.
     *            Example: &#x60;2016-11-30T16:25:12Z&#x60; * UTC RFC3339 shortened without milliseconds and
     *            punctuation. Example: &#x60;20161130T162512Z&#x60; Date-time filtering supports three operators: *
     *            equality by appending &#x60;__eq&#x60; to the field name * greater than or equal to by appending
     *            &#x60;__gte&#x60; to the field name * less than or equal to by appending &#x60;__lte&#x60; to the
     *            field name &#x60;{field name}[|__eq|__lte|__gte]&#x3D;{UTC RFC3339 date-time}&#x60; Time ranges may be
     *            specified by including both the &#x60;__gte&#x60; and &#x60;__lte&#x60; forms in the filter. For
     *            example:
     *            &#x60;created_at__gte&#x3D;2016-11-30T16:25:12.1234Z&amp;created_at__lte&#x3D;2016-12-30T00:00:00Z&#x60;
     *            **Filtering on multiple fields**
     *            &#x60;state__eq&#x3D;deployed&amp;created_at__gte&#x3D;2016-11-30T16:25:12.1234Z&amp;created_at__lte&#x3D;2016-12-30T00:00:00Z&#x60;
     *            **Filtering with filter operators** String field filtering supports the following operators: *
     *            equality: &#x60;__eq&#x60; * non-equality: &#x60;__neq&#x60; * in : &#x60;__in&#x60; * not in:
     *            &#x60;__nin&#x60; For &#x60;__in&#x60; and &#x60;__nin&#x60; filters list of parameters must be
     *            comma-separated: &#x60;name__in&#x3D;fw-image1,fw-image2&#x60; (optional)
     * @param createdAtIn
     *            in filter for the \&quot;created_at\&quot; field (optional)
     * @param createdAtNin
     *            nin filter for the \&quot;created_at\&quot; field (optional)
     * @param createdAtLte
     *            lte filter for the \&quot;created_at\&quot; field (optional)
     * @param createdAtGte
     *            gte filter for the \&quot;created_at\&quot; field (optional)
     * @param descriptionEq
     *            eq filter for the \&quot;description\&quot; field (optional)
     * @param descriptionNeq
     *            neq filter for the \&quot;description\&quot; field (optional)
     * @param descriptionIn
     *            in filter for the \&quot;description\&quot; field (optional)
     * @param descriptionNin
     *            nin filter for the \&quot;description\&quot; field (optional)
     * @param deviceFilterEq
     *            eq filter for the \&quot;device_filter\&quot; field (optional)
     * @param deviceFilterNeq
     *            neq filter for the \&quot;device_filter\&quot; field (optional)
     * @param deviceFilterIn
     *            in filter for the \&quot;device_filter\&quot; field (optional)
     * @param deviceFilterNin
     *            nin filter for the \&quot;device_filter\&quot; field (optional)
     * @param finishedIn
     *            in filter for the \&quot;finished\&quot; field (optional)
     * @param finishedNin
     *            nin filter for the \&quot;finished\&quot; field (optional)
     * @param finishedLte
     *            lte filter for the \&quot;finished\&quot; field (optional)
     * @param finishedGte
     *            gte filter for the \&quot;finished\&quot; field (optional)
     * @param idEq
     *            eq filter for the \&quot;id\&quot; field (optional)
     * @param idNeq
     *            neq filter for the \&quot;id\&quot; field (optional)
     * @param idIn
     *            in filter for the \&quot;id\&quot; field (optional)
     * @param idNin
     *            nin filter for the \&quot;id\&quot; field (optional)
     * @param nameEq
     *            eq filter for the \&quot;name\&quot; field (optional)
     * @param nameNeq
     *            neq filter for the \&quot;name\&quot; field (optional)
     * @param nameIn
     *            in filter for the \&quot;name\&quot; field (optional)
     * @param nameNin
     *            nin filter for the \&quot;name\&quot; field (optional)
     * @param rootManifestIdEq
     *            eq filter for the \&quot;root_manifest_id\&quot; field (optional)
     * @param rootManifestIdNeq
     *            neq filter for the \&quot;root_manifest_id\&quot; field (optional)
     * @param rootManifestIdIn
     *            in filter for the \&quot;root_manifest_id\&quot; field (optional)
     * @param rootManifestIdNin
     *            nin filter for the \&quot;root_manifest_id\&quot; field (optional)
     * @param startedAtIn
     *            in filter for the \&quot;started_at\&quot; field (optional)
     * @param startedAtNin
     *            nin filter for the \&quot;started_at\&quot; field (optional)
     * @param startedAtLte
     *            lte filter for the \&quot;started_at\&quot; field (optional)
     * @param startedAtGte
     *            gte filter for the \&quot;started_at\&quot; field (optional)
     * @param stateEq
     *            eq filter for the \&quot;state\&quot; field (optional)
     * @param stateNeq
     *            neq filter for the \&quot;state\&quot; field (optional)
     * @param stateIn
     *            in filter for the \&quot;state\&quot; field (optional)
     * @param stateNin
     *            nin filter for the \&quot;state\&quot; field (optional)
     * @param updatedAtIn
     *            in filter for the \&quot;updated_at\&quot; field (optional)
     * @param updatedAtNin
     *            nin filter for the \&quot;updated_at\&quot; field (optional)
     * @param updatedAtLte
     *            lte filter for the \&quot;updated_at\&quot; field (optional)
     * @param updatedAtGte
     *            gte filter for the \&quot;updated_at\&quot; field (optional)
     * @param whenIn
     *            in filter for the \&quot;when\&quot; field (optional)
     * @param whenNin
     *            nin filter for the \&quot;when\&quot; field (optional)
     * @param whenLte
     *            lte filter for the \&quot;when\&quot; field (optional)
     * @param whenGte
     *            gte filter for the \&quot;when\&quot; field (optional)
     * @return Call&lt;UpdateCampaignPage&gt;
     */
    @GET("v3/update-campaigns")
    Call<UpdateCampaignPage>
        updateCampaignList(@retrofit2.http.Query("limit") Integer limit, @retrofit2.http.Query("order") String order,
                           @retrofit2.http.Query("after") String after, @retrofit2.http.Query("include") String include,
                           @retrofit2.http.Query("filter") String filter,
                           @retrofit2.http.Query("created_at__in") String createdAtIn,
                           @retrofit2.http.Query("created_at__nin") String createdAtNin,
                           @retrofit2.http.Query("created_at__lte") DateTime createdAtLte,
                           @retrofit2.http.Query("created_at__gte") DateTime createdAtGte,
                           @retrofit2.http.Query("description__eq") String descriptionEq,
                           @retrofit2.http.Query("description__neq") String descriptionNeq,
                           @retrofit2.http.Query("description__in") String descriptionIn,
                           @retrofit2.http.Query("description__nin") String descriptionNin,
                           @retrofit2.http.Query("device_filter__eq") String deviceFilterEq,
                           @retrofit2.http.Query("device_filter__neq") String deviceFilterNeq,
                           @retrofit2.http.Query("device_filter__in") String deviceFilterIn,
                           @retrofit2.http.Query("device_filter__nin") String deviceFilterNin,
                           @retrofit2.http.Query("finished__in") String finishedIn,
                           @retrofit2.http.Query("finished__nin") String finishedNin,
                           @retrofit2.http.Query("finished__lte") DateTime finishedLte,
                           @retrofit2.http.Query("finished__gte") DateTime finishedGte,
                           @retrofit2.http.Query("id__eq") String idEq, @retrofit2.http.Query("id__neq") String idNeq,
                           @retrofit2.http.Query("id__in") String idIn, @retrofit2.http.Query("id__nin") String idNin,
                           @retrofit2.http.Query("name__eq") String nameEq,
                           @retrofit2.http.Query("name__neq") String nameNeq,
                           @retrofit2.http.Query("name__in") String nameIn,
                           @retrofit2.http.Query("name__nin") String nameNin,
                           @retrofit2.http.Query("root_manifest_id__eq") String rootManifestIdEq,
                           @retrofit2.http.Query("root_manifest_id__neq") String rootManifestIdNeq,
                           @retrofit2.http.Query("root_manifest_id__in") String rootManifestIdIn,
                           @retrofit2.http.Query("root_manifest_id__nin") String rootManifestIdNin,
                           @retrofit2.http.Query("started_at__in") String startedAtIn,
                           @retrofit2.http.Query("started_at__nin") String startedAtNin,
                           @retrofit2.http.Query("started_at__lte") DateTime startedAtLte,
                           @retrofit2.http.Query("started_at__gte") DateTime startedAtGte,
                           @retrofit2.http.Query("state__eq") String stateEq,
                           @retrofit2.http.Query("state__neq") String stateNeq,
                           @retrofit2.http.Query("state__in") String stateIn,
                           @retrofit2.http.Query("state__nin") String stateNin,
                           @retrofit2.http.Query("updated_at__in") String updatedAtIn,
                           @retrofit2.http.Query("updated_at__nin") String updatedAtNin,
                           @retrofit2.http.Query("updated_at__lte") DateTime updatedAtLte,
                           @retrofit2.http.Query("updated_at__gte") DateTime updatedAtGte,
                           @retrofit2.http.Query("when__in") String whenIn,
                           @retrofit2.http.Query("when__nin") String whenNin,
                           @retrofit2.http.Query("when__lte") DateTime whenLte,
                           @retrofit2.http.Query("when__gte") DateTime whenGte);

    /**
     * List all campaign device metadata Get metadata for all devices in a campaign. &lt;br&gt; **Usage example:**
     * &#x60;&#x60;&#x60; curl -X GET
     * https://api.us-east-1.mbedcloud.com/v3/update-campaigns/11234567f9012ab56790120000789012/campaign-device-metadata
     * \\ -H &#39;Authorization: Bearer &lt;api_key&gt;&#39; &#x60;&#x60;&#x60;
     * 
     * @param campaignId
     *            The campaign ID. (required)
     * @param limit
     *            How many objects to retrieve in the page. The minimum limit is 2 and the maximum is 1000. Limit values
     *            outside of this range are set to the closest limit. (optional)
     * @param order
     *            ASC or DESC. (optional)
     * @param after
     *            The ID of the item after which to retrieve the next page. (optional)
     * @param include
     *            A comma-separated list of data fields to return. Currently supported: total_count. (optional)
     * @return Call&lt;CampaignDeviceMetadataPage&gt;
     */
    @GET("v3/update-campaigns/{campaign_id}/campaign-device-metadata")
    Call<CampaignDeviceMetadataPage>
        updateCampaignMetadataList(@retrofit2.http.Path(value = "campaign_id", encoded = true) String campaignId,
                                   @retrofit2.http.Query("limit") Integer limit,
                                   @retrofit2.http.Query("order") String order,
                                   @retrofit2.http.Query("after") String after,
                                   @retrofit2.http.Query("include") String include);

    /**
     * Get a campaign device metadata Get update campaign metadata for a specific device. &lt;br&gt; **Usage example:**
     * &#x60;&#x60;&#x60; curl -X GET
     * https://api.us-east-1.mbedcloud.com/v3/update-campaigns/5d645eaec2315a89900000655cd94fa8/campaign-device-metadata/016e83ddc645000000000001001000f6
     * \\ -H &#39;Authorization: Bearer &lt;api_key&gt;&#39; &#x60;&#x60;&#x60;
     * 
     * @param campaignId
     *            The campaign ID. (required)
     * @param campaignDeviceMetadataId
     *            The campaign device metadata ID. (required)
     * @return Call&lt;CampaignDeviceMetadata&gt;
     */
    @GET("v3/update-campaigns/{campaign_id}/campaign-device-metadata/{campaign_device_metadata_id}")
    Call<CampaignDeviceMetadata>
        updateCampaignMetadataRetrieve(@retrofit2.http.Path(value = "campaign_id", encoded = true) String campaignId,
                                       @retrofit2.http.Path(value = "campaign_device_metadata_id",
                                                            encoded = true) String campaignDeviceMetadataId);

    /**
     * Get campaign metrics Get
     * [information](https://developer.pelion.com/docs/device-management/current/updating-firmware/campaign-metrics-in-portal.html)
     * for a campaign based on **SUCCESS**, **FAIL**, or **SKIPPED** criteria for each device. &lt;br&gt; **Usage
     * example:** &#x60;&#x60;&#x60; curl -X GET
     * https://api.us-east-1.mbedcloud.com/v3/update-campaigns/1123467f9012ab567890120000789012/metrics \\ -H
     * &#39;Authorization: Bearer &lt;api_key&gt;&#39; &#x60;&#x60;&#x60;
     * 
     * @param campaignId
     *            The campaign ID. (required)
     * @return Call&lt;CampaignMetrics&gt;
     */
    @GET("v3/update-campaigns/{campaign_id}/metrics")
    Call<CampaignMetrics>
        updateCampaignMetrics(@retrofit2.http.Path(value = "campaign_id", encoded = true) String campaignId);

    /**
     * Get a campaign. Get an update campaign. &lt;br&gt; **Usage example:** &#x60;&#x60;&#x60; curl -X GET
     * https://api.us-east-1.mbedcloud.com/v3/update-campaigns/11234567f9012ab56890120000789012 \\ -H
     * &#39;Authorization: Bearer &lt;api_key&gt;&#39; &#x60;&#x60;&#x60;
     * 
     * @param campaignId
     *            The campaign ID. (required)
     * @return Call&lt;UpdateCampaign&gt;
     */
    @GET("v3/update-campaigns/{campaign_id}")
    Call<UpdateCampaign>
        updateCampaignRetrieve(@retrofit2.http.Path(value = "campaign_id", encoded = true) String campaignId);

    /**
     * Start a campaign. Start a campaign. &lt;br&gt; **Usage example:** &#x60;&#x60;&#x60; curl -X POST
     * https://api.us-east-1.mbedcloud.com/v3/update-campaigns/5d645eaec2315a8900002e655cd94fa8/start \\ -H
     * &#39;Authorization: Bearer &lt;api_key&gt;&#39; &#x60;&#x60;&#x60;
     * 
     * @param campaignId
     *            The campaign ID. (required)
     * @return Call&lt;Void&gt;
     */
    @POST("v3/update-campaigns/{campaign_id}/start")
    Call<Void> updateCampaignStart(@retrofit2.http.Path(value = "campaign_id", encoded = true) String campaignId);

    /**
     * Get statistics for a campaign Get a list of statistics for a campaign, including the number of devices reporting
     * specific event codes. &lt;br&gt; **Usage example:** &#x60;&#x60;&#x60; curl -X GET
     * https://api.us-east-1.mbedcloud.com/v3/update-campaigns/11234567f9012ab56780120000789012/statistics \\ -H
     * &#39;Authorization: Bearer &lt;api_key&gt;&#39; &#x60;&#x60;&#x60;
     * 
     * @param campaignId
     *            The campaign ID. (required)
     * @return Call&lt;EventTypeSummaryList&gt;
     */
    @GET("v3/update-campaigns/{campaign_id}/statistics")
    Call<EventTypeSummaryList>
        updateCampaignStatisticsList(@retrofit2.http.Path(value = "campaign_id", encoded = true) String campaignId);

    /**
     * Get a status summary Get the count of successfully updated, skipped, and failed devices. &lt;br&gt; **Usage
     * example:** &#x60;&#x60;&#x60; curl
     * https://api.us-east-1.mbedcloud.com/v3/update-campaigns/12345678901234567890123456789012/statistics/fail \\ -H
     * &#39;Authorization: Bearer &lt;api_key&gt;&#39; &#x60;&#x60;&#x60;
     * 
     * @param campaignId
     *            The campaign ID. (required)
     * @param summaryStatusId
     *            The summary status. For example, fail. (required)
     * @return Call&lt;EventTypeSummary&gt;
     */
    @GET("v3/update-campaigns/{campaign_id}/statistics/{summary_status_id}")
    Call<EventTypeSummary>
        updateCampaignStatisticsRetrieve(@retrofit2.http.Path(value = "campaign_id", encoded = true) String campaignId,
                                         @retrofit2.http.Path(value = "summary_status_id",
                                                              encoded = true) String summaryStatusId);

    /**
     * Stop a campaign. Stop a campaign. Stopping is a process that requires the campaign go through several
     * [phases](https://developer.pelion.com/docs/device-management/current/updating-firmware/device-management-update-using-the-apis.html).
     * &lt;br&gt; **Usage example:** &#x60;&#x60;&#x60; curl -X POST
     * https://api.us-east-1.mbedcloud.com/v3/update-campaigns/016e83ddc645000000000001001000b5/stop \\ -H
     * &#39;Authorization: Bearer &lt;api_key&gt;&#39; &#x60;&#x60;&#x60;
     * 
     * @param campaignId
     *            The campaign ID. (required)
     * @return Call&lt;Void&gt;
     */
    @POST("v3/update-campaigns/{campaign_id}/stop")
    Call<Void> updateCampaignStop(@retrofit2.http.Path(value = "campaign_id", encoded = true) String campaignId);

    /**
     * Modify a campaign Modify an update campaign. &lt;br&gt; **Usage example:** &#x60;&#x60;&#x60; curl -X PUT
     * https://api.us-east-1.mbedcloud.com/v3/update-campaigns/1123007f9012ab567890120000789012 \\ -H
     * &#39;Authorization: Bearer &lt;api_key&gt;&#39; \\ d &#39;{ \&quot;description\&quot;: \&quot;Campaign is for
     * ...\&quot;, \&quot;device_filter\&quot;: \&quot;123400000000000000000000000ae45\&quot;, \&quot;name\&quot;:
     * \&quot;campaign\&quot;, \&quot;root_manifest_id\&quot;: \&quot;5678000000000000000000000000bd98\&quot;, }&#39;
     * &#x60;&#x60;&#x60;
     * 
     * @param campaignId
     *            The campaign ID. (required)
     * @param campaign
     *            Update campaign. (required)
     * @return Call&lt;UpdateCampaign&gt;
     */
    @PUT("v3/update-campaigns/{campaign_id}")
    Call<UpdateCampaign>
        updateCampaignUpdate(@retrofit2.http.Path(value = "campaign_id", encoded = true) String campaignId,
                             @retrofit2.http.Body UpdateCampaignPutRequest campaign);

}
