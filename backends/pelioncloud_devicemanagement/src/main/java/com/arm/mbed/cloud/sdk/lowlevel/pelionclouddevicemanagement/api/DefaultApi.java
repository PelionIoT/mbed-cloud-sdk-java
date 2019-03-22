package com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api;

import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.CollectionFormats.*;

import retrofit2.Call;
import retrofit2.http.*;

import okhttp3.MultipartBody;

import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.BillingReportRawDataResponse;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.BrandingColor;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.BrandingColorList;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.BrandingImage;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.BrandingImageList;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.CampaignDeviceMetadata;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.CampaignDeviceMetadataPage;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.CampaignMetrics;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.DeviceData;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.DeviceDataPostRequest;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.DeviceDataPutRequest;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.DeviceEventData;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.DeviceEventPage;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.DeviceGroup;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.DeviceGroupManipulation;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.DeviceGroupPage;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.DevicePage;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.DeviceQuery;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.DeviceQueryPage;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.DeviceQueryPostPutRequest;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.EventType;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.EventTypeList;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.EventTypeSummary;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.EventTypeSummaryList;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.FirmwareImage;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.FirmwareImagePage;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.FirmwareManifest;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.FirmwareManifestPage;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.Group;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.Group1;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.ReportResponse;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.ServicePackageQuota;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.ServicePackageQuotaHistoryResponse;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.ServicePackagesResponse;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.UpdateCampaign;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.UpdateCampaignPage;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.UpdateCampaignPostRequest;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.UpdateCampaignPutRequest;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.UploadChunkInfo;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.UploadChunkInfoPage;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.UploadJob;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.UploadJob1;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.UploadJobPage;

public interface DefaultApi {
    /**
     * Create a device Create a new device.
     * 
     * @param device
     *            (required)
     * @return Call&lt;DeviceData&gt;
     */
    @POST("v3/devices/")
    Call<DeviceData> deviceCreate(@retrofit2.http.Body DeviceDataPostRequest device);

    /**
     * Delete a device. Delete device. Only available for devices with a developer certificate. Attempts to delete a
     * device with a production certicate will return a 400 response.
     * 
     * @param id
     *            (required)
     * @return Call&lt;Void&gt;
     */
    @DELETE("v3/devices/{id}/")
    Call<Void> deviceDestroy(@retrofit2.http.Path(value = "id", encoded = true) String id);

    /**
     * List all device events. List all device events for an account.
     * 
     * @param limit
     *            How many objects to retrieve in the page. The minimum limit is 2 and the maximum is 1000. Limit values
     *            outside of this range are set to the closest limit. (optional)
     * @param order
     *            The order of the records based on creation time, &#x60;ASC&#x60; or &#x60;DESC&#x60;; by default
     *            &#x60;ASC&#x60;. (optional)
     * @param after
     *            The ID of The item after which to retrieve the next page. (optional)
     * @param include
     *            Comma-separated list of data fields to return. Currently supported: &#x60;total_count&#x60; (optional)
     * @param filter
     *            URL encoded query string parameter to filter returned data. ##### Filtering
     *            &#x60;&#x60;&#x60;?filter&#x3D;{URL encoded query string}&#x60;&#x60;&#x60; The query string is made
     *            up of key/value pairs separated by ampersands. So for a query of
     *            &#x60;&#x60;&#x60;key1&#x3D;value1&amp;key2&#x3D;value2&amp;key3&#x3D;value3&#x60;&#x60;&#x60; this
     *            would be encoded as follows:
     *            &#x60;&#x60;&#x60;?filter&#x3D;key1%3Dvalue1%26key2%3Dvalue2%26key3%3Dvalue3&#x60;&#x60;&#x60; ######
     *            Filterable fields: The below table lists all the fields that can be filtered on with certain filters:
     *            &lt;table&gt; &lt;thead&gt; &lt;tr&gt; &lt;th&gt;Field&lt;/th&gt; &lt;th&gt;&#x3D; / __eq /
     *            __neq&lt;/th&gt; &lt;th&gt;__in / __nin&lt;/th&gt; &lt;th&gt;__lte / __gte&lt;/th&gt; &lt;tr&gt;
     *            &lt;thead&gt; &lt;tbody&gt; &lt;tr&gt; &lt;td&gt;date_time&lt;/td&gt; &lt;td&gt;✓&lt;/td&gt;
     *            &lt;td&gt;✓&lt;/td&gt; &lt;td&gt;✓&lt;/td&gt; &lt;/tr&gt; &lt;tr&gt;
     *            &lt;td&gt;description&lt;/td&gt; &lt;td&gt;✓&lt;/td&gt; &lt;td&gt;✓&lt;/td&gt;
     *            &lt;td&gt;&amp;nbsp;&lt;/td&gt; &lt;/tr&gt; &lt;tr&gt; &lt;td&gt;id&lt;/td&gt;
     *            &lt;td&gt;✓&lt;/td&gt; &lt;td&gt;✓&lt;/td&gt; &lt;td&gt;&amp;nbsp;&lt;/td&gt; &lt;/tr&gt;
     *            &lt;tr&gt; &lt;td&gt;device_id&lt;/td&gt; &lt;td&gt;✓&lt;/td&gt; &lt;td&gt;✓&lt;/td&gt;
     *            &lt;td&gt;&amp;nbsp;&lt;/td&gt; &lt;/tr&gt; &lt;tr&gt; &lt;td&gt;event_type&lt;/td&gt;
     *            &lt;td&gt;✓&lt;/td&gt; &lt;td&gt;✓&lt;/td&gt; &lt;td&gt;&amp;nbsp;&lt;/td&gt; &lt;/tr&gt;
     *            &lt;tr&gt; &lt;td&gt;state_change&lt;/td&gt; &lt;td&gt;✓&lt;/td&gt; &lt;td&gt;✓&lt;/td&gt;
     *            &lt;td&gt;&amp;nbsp;&lt;/td&gt; &lt;/tr&gt; &lt;/tbody&gt; &lt;/table&gt; &amp;nbsp; The examples
     *            below show the queries in *unencoded* form. ###### By id:
     *            &#x60;&#x60;&#x60;id&#x3D;{id}&#x60;&#x60;&#x60; ###### By state change:
     *            &#x60;&#x60;&#x60;state_change&#x3D;[True|False]&#x60;&#x60;&#x60; ###### By event type:
     *            &#x60;&#x60;&#x60;event_type&#x3D;{value}&#x60;&#x60;&#x60; ###### On date-time fields: Date-time
     *            fields should be specified in UTC RFC3339 format
     *            &#x60;&#x60;&#x60;YYYY-MM-DDThh:mm:ss.msZ&#x60;&#x60;&#x60;. There are three permitted variations: *
     *            UTC RFC3339 with milliseconds e.g. 2016-11-30T16:25:12.1234Z * UTC RFC3339 without milliseconds e.g.
     *            2016-11-30T16:25:12Z * UTC RFC3339 shortened - without milliseconds and punctuation e.g.
     *            20161130T162512Z Date-time filtering supports three operators: * equality * greater than or equal to
     *            &amp;ndash; field name suffixed with &#x60;&#x60;&#x60;__gte&#x60;&#x60;&#x60; * less than or equal to
     *            &amp;ndash; field name suffixed with &#x60;&#x60;&#x60;__lte&#x60;&#x60;&#x60; Lower and upper limits
     *            to a date-time range may be specified by including both the &#x60;&#x60;&#x60;__gte&#x60;&#x60;&#x60;
     *            and &#x60;&#x60;&#x60;__lte&#x60;&#x60;&#x60; forms in the filter. &#x60;&#x60;&#x60;{field
     *            name}[|__lte|__gte]&#x3D;{UTC RFC3339 date-time}&#x60;&#x60;&#x60; ##### Multi-field example
     *            &#x60;&#x60;&#x60;id&#x3D;0158d38771f70000000000010010038c&amp;state_change&#x3D;True&amp;date_time__gte&#x3D;2016-11-30T16:25:12.1234Z&#x60;&#x60;&#x60;
     *            Encoded:
     *            &#x60;&#x60;&#x60;?filter&#x3D;id%3D0158d38771f70000000000010010038c%26state_change%3DTrue%26date_time__gte%3D2016-11-30T16%3A25%3A12.1234Z&#x60;&#x60;&#x60;
     *            ##### Filtering with filter operators String field filtering supports the following operators: *
     *            equality: &#x60;__eq&#x60; * non-equality: &#x60;__neq&#x60; * in : &#x60;__in&#x60; * not in:
     *            &#x60;__nin&#x60; For &#x60;__in&#x60; and &#x60;__nin&#x60; filters list of parameters must be
     *            comma-separated:
     *            &#x60;event_type__in&#x3D;update.device.device-created,update.device.device-updated&#x60; (optional)
     * @return Call&lt;DeviceEventPage&gt;
     */
    @GET("v3/device-events/")
    Call<DeviceEventPage>
        deviceEventList(@retrofit2.http.Query("limit") Integer limit, @retrofit2.http.Query("order") String order,
                        @retrofit2.http.Query("after") String after, @retrofit2.http.Query("include") String include,
                        @retrofit2.http.Query("filter") String filter);

    /**
     * Retrieve a device event. Retrieve a specific device event.
     * 
     * @param deviceEventId
     *            (required)
     * @return Call&lt;DeviceEventData&gt;
     */
    @GET("v3/device-events/{device_event_id}/")
    Call<DeviceEventData>
        deviceEventRetrieve(@retrofit2.http.Path(value = "device_event_id", encoded = true) String deviceEventId);

    /**
     * List all devices. List all devices.
     * 
     * @param limit
     *            How many objects to retrieve in the page. The minimum limit is 2 and the maximum is 1000. Limit values
     *            outside of this range are set to the closest limit. (optional)
     * @param order
     *            The order of the records based on creation time, &#x60;ASC&#x60; or &#x60;DESC&#x60;; by default
     *            &#x60;ASC&#x60;. (optional)
     * @param after
     *            The ID of The item after which to retrieve the next page. (optional)
     * @param include
     *            Comma-separated list of data fields to return. Currently supported: &#x60;total_count&#x60;.
     *            (optional)
     * @param filter
     *            URL encoded query string parameter to filter returned data. ##### Filtering
     *            &#x60;&#x60;&#x60;?filter&#x3D;{URL encoded query string}&#x60;&#x60;&#x60; The query string is made
     *            up of key/value pairs separated by ampersands. So for a query of
     *            &#x60;&#x60;&#x60;key1&#x3D;value1&amp;key2&#x3D;value2&amp;key3&#x3D;value3&#x60;&#x60;&#x60; this
     *            would be encoded as follows:
     *            &#x60;&#x60;&#x60;?filter&#x3D;key1%3Dvalue1%26key2%3Dvalue2%26key3%3Dvalue3&#x60;&#x60;&#x60; ######
     *            Filterable fields: The below table lists all the fields that can be filtered on with certain filters:
     *            &lt;table&gt; &lt;thead&gt; &lt;tr&gt; &lt;th&gt;Field&lt;/th&gt; &lt;th&gt;&#x3D; / __eq /
     *            __neq&lt;/th&gt; &lt;th&gt;__in / __nin&lt;/th&gt; &lt;th&gt;__lte / __gte&lt;/th&gt; &lt;tr&gt;
     *            &lt;thead&gt; &lt;tbody&gt; &lt;tr&gt; &lt;td&gt;lifecycle_status&lt;/td&gt; &lt;td&gt;✓&lt;/td&gt;
     *            &lt;td&gt;✓&lt;/td&gt; &lt;td&gt;&amp;nbsp;&lt;/td&gt; &lt;/tr&gt; &lt;tr&gt;
     *            &lt;td&gt;account_id&lt;/td&gt; &lt;td&gt;✓&lt;/td&gt; &lt;td&gt;✓&lt;/td&gt;
     *            &lt;td&gt;&amp;nbsp;&lt;/td&gt; &lt;/tr&gt; &lt;tr&gt; &lt;td&gt;auto_update&lt;/td&gt;
     *            &lt;td&gt;✓&lt;/td&gt; &lt;td&gt;✓&lt;/td&gt; &lt;td&gt;&amp;nbsp;&lt;/td&gt; &lt;/tr&gt;
     *            &lt;tr&gt; &lt;td&gt;bootstrap_expiration_date&lt;/td&gt; &lt;td&gt;✓&lt;/td&gt;
     *            &lt;td&gt;✓&lt;/td&gt; &lt;td&gt;✓&lt;/td&gt; &lt;/tr&gt; &lt;tr&gt;
     *            &lt;td&gt;bootstrapped_timestamp&lt;/td&gt; &lt;td&gt;✓&lt;/td&gt; &lt;td&gt;✓&lt;/td&gt;
     *            &lt;td&gt;✓&lt;/td&gt; &lt;/tr&gt; &lt;tr&gt; &lt;td&gt;ca_id&lt;/td&gt; &lt;td&gt;✓&lt;/td&gt;
     *            &lt;td&gt;✓&lt;/td&gt; &lt;td&gt;&amp;nbsp;&lt;/td&gt; &lt;/tr&gt; &lt;tr&gt;
     *            &lt;td&gt;connector_expiration_date&lt;/td&gt; &lt;td&gt;✓&lt;/td&gt; &lt;td&gt;✓&lt;/td&gt;
     *            &lt;td&gt;✓&lt;/td&gt; &lt;/tr&gt; &lt;tr&gt; &lt;td&gt;created_at&lt;/td&gt;
     *            &lt;td&gt;✓&lt;/td&gt; &lt;td&gt;✓&lt;/td&gt; &lt;td&gt;✓&lt;/td&gt; &lt;/tr&gt; &lt;tr&gt;
     *            &lt;td&gt;custom_attributes&lt;/td&gt; &lt;td&gt;✓&lt;/td&gt; &lt;td&gt;&amp;nbsp;&lt;/td&gt;
     *            &lt;td&gt;&amp;nbsp;&lt;/td&gt; &lt;/tr&gt; &lt;tr&gt; &lt;td&gt;deployed_state&lt;/td&gt;
     *            &lt;td&gt;✓&lt;/td&gt; &lt;td&gt;✓&lt;/td&gt; &lt;td&gt;&amp;nbsp;&lt;/td&gt; &lt;/tr&gt;
     *            &lt;tr&gt; &lt;td&gt;deployment&lt;/td&gt; &lt;td&gt;✓&lt;/td&gt; &lt;td&gt;✓&lt;/td&gt;
     *            &lt;td&gt;&amp;nbsp;&lt;/td&gt; &lt;/tr&gt; &lt;tr&gt; &lt;td&gt;description&lt;/td&gt;
     *            &lt;td&gt;✓&lt;/td&gt; &lt;td&gt;✓&lt;/td&gt; &lt;td&gt;&amp;nbsp;&lt;/td&gt; &lt;/tr&gt;
     *            &lt;tr&gt; &lt;td&gt;device_class&lt;/td&gt; &lt;td&gt;✓&lt;/td&gt; &lt;td&gt;✓&lt;/td&gt;
     *            &lt;td&gt;&amp;nbsp;&lt;/td&gt; &lt;/tr&gt; &lt;tr&gt; &lt;td&gt;device_execution_mode&lt;/td&gt;
     *            &lt;td&gt;✓&lt;/td&gt; &lt;td&gt;✓&lt;/td&gt; &lt;td&gt;&amp;nbsp;&lt;/td&gt; &lt;/tr&gt;
     *            &lt;tr&gt; &lt;td&gt;device_key&lt;/td&gt; &lt;td&gt;✓&lt;/td&gt; &lt;td&gt;✓&lt;/td&gt;
     *            &lt;td&gt;&amp;nbsp;&lt;/td&gt; &lt;/tr&gt; &lt;tr&gt; &lt;td&gt;endpoint_name&lt;/td&gt;
     *            &lt;td&gt;✓&lt;/td&gt; &lt;td&gt;✓&lt;/td&gt; &lt;td&gt;&amp;nbsp;&lt;/td&gt; &lt;/tr&gt;
     *            &lt;tr&gt; &lt;td&gt;endpoint_type&lt;/td&gt; &lt;td&gt;✓&lt;/td&gt; &lt;td&gt;✓&lt;/td&gt;
     *            &lt;td&gt;&amp;nbsp;&lt;/td&gt; &lt;/tr&gt; &lt;tr&gt; &lt;td&gt;enrolment_list_timestamp&lt;/td&gt;
     *            &lt;td&gt;✓&lt;/td&gt; &lt;td&gt;✓&lt;/td&gt; &lt;td&gt;✓&lt;/td&gt; &lt;/tr&gt; &lt;tr&gt;
     *            &lt;td&gt;etag&lt;/td&gt; &lt;td&gt;✓&lt;/td&gt; &lt;td&gt;✓&lt;/td&gt; &lt;td&gt;✓&lt;/td&gt;
     *            &lt;/tr&gt; &lt;tr&gt; &lt;td&gt;firmware_checksum&lt;/td&gt; &lt;td&gt;✓&lt;/td&gt;
     *            &lt;td&gt;✓&lt;/td&gt; &lt;td&gt;&amp;nbsp;&lt;/td&gt; &lt;/tr&gt; &lt;tr&gt;
     *            &lt;td&gt;host_gateway&lt;/td&gt; &lt;td&gt;✓&lt;/td&gt; &lt;td&gt;✓&lt;/td&gt;
     *            &lt;td&gt;&amp;nbsp;&lt;/td&gt; &lt;/tr&gt; &lt;tr&gt; &lt;td&gt;id&lt;/td&gt;
     *            &lt;td&gt;✓&lt;/td&gt; &lt;td&gt;✓&lt;/td&gt; &lt;td&gt;&amp;nbsp;&lt;/td&gt; &lt;/tr&gt;
     *            &lt;tr&gt; &lt;td&gt;manifest&lt;/td&gt; &lt;td&gt;✓&lt;/td&gt; &lt;td&gt;✓&lt;/td&gt;
     *            &lt;td&gt;&amp;nbsp;&lt;/td&gt; &lt;/tr&gt; &lt;tr&gt; &lt;td&gt;manifest_timestamp&lt;/td&gt;
     *            &lt;td&gt;✓&lt;/td&gt; &lt;td&gt;✓&lt;/td&gt; &lt;td&gt;✓&lt;/td&gt; &lt;/tr&gt; &lt;tr&gt;
     *            &lt;td&gt;mechanism&lt;/td&gt; &lt;td&gt;✓&lt;/td&gt; &lt;td&gt;✓&lt;/td&gt;
     *            &lt;td&gt;&amp;nbsp;&lt;/td&gt; &lt;/tr&gt; &lt;tr&gt; &lt;td&gt;mechanism_url&lt;/td&gt;
     *            &lt;td&gt;✓&lt;/td&gt; &lt;td&gt;✓&lt;/td&gt; &lt;td&gt;&amp;nbsp;&lt;/td&gt; &lt;/tr&gt;
     *            &lt;tr&gt; &lt;td&gt;name&lt;/td&gt; &lt;td&gt;✓&lt;/td&gt; &lt;td&gt;✓&lt;/td&gt;
     *            &lt;td&gt;&amp;nbsp;&lt;/td&gt; &lt;/tr&gt; &lt;tr&gt; &lt;td&gt;serial_number&lt;/td&gt;
     *            &lt;td&gt;✓&lt;/td&gt; &lt;td&gt;✓&lt;/td&gt; &lt;td&gt;&amp;nbsp;&lt;/td&gt; &lt;/tr&gt;
     *            &lt;tr&gt; &lt;td&gt;state&lt;/td&gt; &lt;td&gt;✓&lt;/td&gt; &lt;td&gt;✓&lt;/td&gt;
     *            &lt;td&gt;&amp;nbsp;&lt;/td&gt; &lt;/tr&gt; &lt;tr&gt; &lt;td&gt;updated_at&lt;/td&gt;
     *            &lt;td&gt;✓&lt;/td&gt; &lt;td&gt;✓&lt;/td&gt; &lt;td&gt;✓&lt;/td&gt; &lt;/tr&gt; &lt;tr&gt;
     *            &lt;td&gt;vendor_id&lt;/td&gt; &lt;td&gt;✓&lt;/td&gt; &lt;td&gt;✓&lt;/td&gt;
     *            &lt;td&gt;&amp;nbsp;&lt;/td&gt; &lt;/tr&gt; &lt;tr&gt; &lt;td&gt;issuer_fingerprint&lt;/td&gt;
     *            &lt;td&gt;✓&lt;/td&gt; &lt;td&gt;✓&lt;/td&gt; &lt;td&gt;&amp;nbsp;&lt;/td&gt; &lt;/tr&gt;
     *            &lt;tr&gt; &lt;td&gt;lifecycle_status&lt;/td&gt; &lt;td&gt;✓&lt;/td&gt; &lt;td&gt;✓&lt;/td&gt;
     *            &lt;td&gt;&amp;nbsp;&lt;/td&gt; &lt;/tr&gt; &lt;tr&gt; &lt;td&gt;operator_suspended&lt;/td&gt;
     *            &lt;td&gt;✓&lt;/td&gt; &lt;td&gt;✓&lt;/td&gt; &lt;td&gt;&amp;nbsp;&lt;/td&gt; &lt;/tr&gt;
     *            &lt;tr&gt; &lt;td&gt;last_operator_suspension_category&lt;/td&gt; &lt;td&gt;✓&lt;/td&gt;
     *            &lt;td&gt;✓&lt;/td&gt; &lt;td&gt;&amp;nbsp;&lt;/td&gt; &lt;/tr&gt; &lt;tr&gt;
     *            &lt;td&gt;last_operator_suspension_updated_at&lt;/td&gt; &lt;td&gt;✓&lt;/td&gt;
     *            &lt;td&gt;✓&lt;/td&gt; &lt;td&gt;✓&lt;/td&gt; &lt;/tr&gt; &lt;tr&gt;
     *            &lt;td&gt;system_suspended&lt;/td&gt; &lt;td&gt;✓&lt;/td&gt; &lt;td&gt;✓&lt;/td&gt;
     *            &lt;td&gt;&amp;nbsp;&lt;/td&gt; &lt;/tr&gt; &lt;tr&gt;
     *            &lt;td&gt;last_system_suspension_category&lt;/td&gt; &lt;td&gt;✓&lt;/td&gt; &lt;td&gt;✓&lt;/td&gt;
     *            &lt;td&gt;&amp;nbsp;&lt;/td&gt; &lt;/tr&gt; &lt;tr&gt;
     *            &lt;td&gt;last_system_suspension_updated_at&lt;/td&gt; &lt;td&gt;✓&lt;/td&gt;
     *            &lt;td&gt;✓&lt;/td&gt; &lt;td&gt;✓&lt;/td&gt; &lt;/tr&gt; &lt;/tbody&gt; &lt;/table&gt; &amp;nbsp;
     *            The examples below show the queries in *unencoded* form. ###### By device properties (all properties
     *            are filterable):
     *            &#x60;&#x60;&#x60;state&#x3D;[unenrolled|cloud_enrolling|bootstrapped|registered]&#x60;&#x60;&#x60;
     *            &#x60;&#x60;&#x60;device_class&#x3D;{value}&#x60;&#x60;&#x60; ###### On date-time fields: Date-time
     *            fields should be specified in UTC RFC3339 format
     *            &#x60;&#x60;&#x60;YYYY-MM-DDThh:mm:ss.msZ&#x60;&#x60;&#x60;. There are three permitted variations: *
     *            UTC RFC3339 with milliseconds e.g. 2016-11-30T16:25:12.1234Z * UTC RFC3339 without milliseconds e.g.
     *            2016-11-30T16:25:12Z * UTC RFC3339 shortened - without milliseconds and punctuation e.g.
     *            20161130T162512Z Date-time filtering supports three operators: * equality * greater than or equal to
     *            &amp;ndash; field name suffixed with &#x60;&#x60;&#x60;__gte&#x60;&#x60;&#x60; * less than or equal to
     *            &amp;ndash; field name suffixed with &#x60;&#x60;&#x60;__lte&#x60;&#x60;&#x60; Lower and upper limits
     *            to a date-time range may be specified by including both the &#x60;&#x60;&#x60;__gte&#x60;&#x60;&#x60;
     *            and &#x60;&#x60;&#x60;__lte&#x60;&#x60;&#x60; forms in the filter. &#x60;&#x60;&#x60;{field
     *            name}[|__lte|__gte]&#x3D;{UTC RFC3339 date-time}&#x60;&#x60;&#x60; ###### On device custom attributes:
     *            &#x60;&#x60;&#x60;custom_attributes__{param}&#x3D;{value}&#x60;&#x60;&#x60;
     *            &#x60;&#x60;&#x60;custom_attributes__tag&#x3D;TAG1&#x60;&#x60;&#x60; ##### Multi-field example
     *            &#x60;&#x60;&#x60;state&#x3D;bootstrapped&amp;created_at__gte&#x3D;2016-11-30T16:25:12.1234Z&amp;created_at__lte&#x3D;2016-12-30T00:00:00Z&#x60;&#x60;&#x60;
     *            Encoded:
     *            &#x60;&#x60;&#x60;?filter&#x3D;state%3Dbootstrapped%26created_at__gte%3D2016-11-30T16%3A25%3A12.1234Z%26created_at__lte%3D2016-11-30T00%3A00%3A00Z&#x60;&#x60;&#x60;
     *            ##### Filtering with filter operators String field filtering supports the following operators: *
     *            equality: &#x60;__eq&#x60; * non-equality: &#x60;__neq&#x60; * in : &#x60;__in&#x60; * not in:
     *            &#x60;__nin&#x60; For &#x60;__in&#x60; and &#x60;__nin&#x60; filters list of parameters must be
     *            comma-separated: &#x60;state__nin&#x3D;unenrolled,dergistered&#x60; (optional)
     * @return Call&lt;DevicePage&gt;
     */
    @GET("v3/devices/")
    Call<DevicePage>
        deviceList(@retrofit2.http.Query("limit") Integer limit, @retrofit2.http.Query("order") String order,
                   @retrofit2.http.Query("after") String after, @retrofit2.http.Query("include") String include,
                   @retrofit2.http.Query("filter") String filter);

    /**
     * DEPRECATED: List all device events. DEPRECATED: List all device events. Use &#x60;/v3/device-events/&#x60;
     * instead.
     * 
     * @param limit
     *            How many objects to retrieve in the page. The minimum limit is 2 and the maximum is 1000. Limit values
     *            outside of this range are set to the closest limit. (optional)
     * @param order
     *            The order of the records based on creation time, &#x60;ASC&#x60; or &#x60;DESC&#x60;; by default
     *            &#x60;ASC&#x60;. (optional)
     * @param after
     *            The ID of The item after which to retrieve the next page. (optional)
     * @param include
     *            Comma-separated list of data fields to return. Currently supported: &#x60;total_count&#x60;.
     *            (optional)
     * @param filter
     *            URL encoded query string parameter to filter returned data. ##### Filtering
     *            &#x60;&#x60;&#x60;?filter&#x3D;{URL encoded query string}&#x60;&#x60;&#x60; The query string is made
     *            up of key/value pairs separated by ampersands. So for a query of
     *            &#x60;&#x60;&#x60;key1&#x3D;value1&amp;key2&#x3D;value2&amp;key3&#x3D;value3&#x60;&#x60;&#x60; this
     *            would be encoded as follows:
     *            &#x60;&#x60;&#x60;?filter&#x3D;key1%3Dvalue1%26key2%3Dvalue2%26key3%3Dvalue3&#x60;&#x60;&#x60; ######
     *            Filterable fields: The below table lists all the fields that can be filtered on with certain filters:
     *            &lt;table&gt; &lt;thead&gt; &lt;tr&gt; &lt;th&gt;Field&lt;/th&gt; &lt;th&gt;&#x3D; / __eq /
     *            __neq&lt;/th&gt; &lt;th&gt;__in / __nin&lt;/th&gt; &lt;th&gt;__lte / __gte&lt;/th&gt; &lt;tr&gt;
     *            &lt;thead&gt; &lt;tbody&gt; &lt;tr&gt; &lt;td&gt;date_time&lt;/td&gt; &lt;td&gt;✓&lt;/td&gt;
     *            &lt;td&gt;✓&lt;/td&gt; &lt;td&gt;✓&lt;/td&gt; &lt;/tr&gt; &lt;tr&gt;
     *            &lt;td&gt;description&lt;/td&gt; &lt;td&gt;✓&lt;/td&gt; &lt;td&gt;✓&lt;/td&gt;
     *            &lt;td&gt;&amp;nbsp;&lt;/td&gt; &lt;/tr&gt; &lt;tr&gt; &lt;td&gt;id&lt;/td&gt;
     *            &lt;td&gt;✓&lt;/td&gt; &lt;td&gt;✓&lt;/td&gt; &lt;td&gt;&amp;nbsp;&lt;/td&gt; &lt;/tr&gt;
     *            &lt;tr&gt; &lt;td&gt;device_id&lt;/td&gt; &lt;td&gt;✓&lt;/td&gt; &lt;td&gt;✓&lt;/td&gt;
     *            &lt;td&gt;&amp;nbsp;&lt;/td&gt; &lt;/tr&gt; &lt;tr&gt; &lt;td&gt;event_type&lt;/td&gt;
     *            &lt;td&gt;✓&lt;/td&gt; &lt;td&gt;✓&lt;/td&gt; &lt;td&gt;&amp;nbsp;&lt;/td&gt; &lt;/tr&gt;
     *            &lt;tr&gt; &lt;td&gt;state_change&lt;/td&gt; &lt;td&gt;✓&lt;/td&gt; &lt;td&gt;✓&lt;/td&gt;
     *            &lt;td&gt;&amp;nbsp;&lt;/td&gt; &lt;/tr&gt; &lt;/tbody&gt; &lt;/table&gt; &amp;nbsp; The examples
     *            below show the queries in *unencoded* form. ###### By id:
     *            &#x60;&#x60;&#x60;id&#x3D;{id}&#x60;&#x60;&#x60; ###### By state change:
     *            &#x60;&#x60;&#x60;state_change&#x3D;[True|False]&#x60;&#x60;&#x60; ###### By event type:
     *            &#x60;&#x60;&#x60;event_type&#x3D;{value}&#x60;&#x60;&#x60; ###### On date-time fields: Date-time
     *            fields should be specified in UTC RFC3339 format
     *            &#x60;&#x60;&#x60;YYYY-MM-DDThh:mm:ss.msZ&#x60;&#x60;&#x60;. There are three permitted variations: *
     *            UTC RFC3339 with milliseconds e.g. 2016-11-30T16:25:12.1234Z * UTC RFC3339 without milliseconds e.g.
     *            2016-11-30T16:25:12Z * UTC RFC3339 shortened - without milliseconds and punctuation e.g.
     *            20161130T162512Z Date-time filtering supports three operators: * equality * greater than or equal to
     *            &amp;ndash; field name suffixed with &#x60;&#x60;&#x60;__gte&#x60;&#x60;&#x60; * less than or equal to
     *            &amp;ndash; field name suffixed with &#x60;&#x60;&#x60;__lte&#x60;&#x60;&#x60; Lower and upper limits
     *            to a date-time range may be specified by including both the &#x60;&#x60;&#x60;__gte&#x60;&#x60;&#x60;
     *            and &#x60;&#x60;&#x60;__lte&#x60;&#x60;&#x60; forms in the filter. &#x60;&#x60;&#x60;{field
     *            name}[|__lte|__gte]&#x3D;{UTC RFC3339 date-time}&#x60;&#x60;&#x60; ##### Multi-field example
     *            &#x60;&#x60;&#x60;id&#x3D;0158d38771f70000000000010010038c&amp;state_change&#x3D;True&amp;date_time__gte&#x3D;2016-11-30T16:25:12.1234Z&#x60;&#x60;&#x60;
     *            Encoded:
     *            &#x60;&#x60;&#x60;?filter&#x3D;id%3D0158d38771f70000000000010010038c%26state_change%3DTrue%26date_time__gte%3D2016-11-30T16%3A25%3A12.1234Z&#x60;&#x60;&#x60;
     *            ##### Filtering with filter operators String field filtering supports the following operators: *
     *            equality: &#x60;__eq&#x60; * non-equality: &#x60;__neq&#x60; * in : &#x60;__in&#x60; * not in:
     *            &#x60;__nin&#x60; For &#x60;__in&#x60; and &#x60;__nin&#x60; filters list of parameters must be
     *            comma-separated:
     *            &#x60;event_type__in&#x3D;update.device.device-created,update.device.device-updated&#x60; (optional)
     * @return Call&lt;DeviceEventPage&gt;
     */
    @GET("v3/devicelog/")
    Call<DeviceEventPage>
        deviceLogList(@retrofit2.http.Query("limit") Integer limit, @retrofit2.http.Query("order") String order,
                      @retrofit2.http.Query("after") String after, @retrofit2.http.Query("include") String include,
                      @retrofit2.http.Query("filter") String filter);

    /**
     * DEPRECATED: Retrieve a device event. Retrieve device event (deprecated, use /v3/device-events/{device_event_id}/
     * instead).
     * 
     * @param deviceEventId
     *            (required)
     * @return Call&lt;DeviceEventData&gt;
     */
    @GET("v3/devicelog/{device_event_id}/")
    Call<DeviceEventData>
        deviceLogRetrieve(@retrofit2.http.Path(value = "device_event_id", encoded = true) String deviceEventId);

    /**
     * Create a device query Create a new device query.
     * 
     * @param device
     *            (required)
     * @return Call&lt;DeviceQuery&gt;
     */
    @POST("v3/device-queries/")
    Call<DeviceQuery> deviceQueryCreate(@retrofit2.http.Body DeviceQueryPostPutRequest device);

    /**
     * Delete a device query Delete a device query.
     * 
     * @param queryId
     *            (required)
     * @return Call&lt;Void&gt;
     */
    @DELETE("v3/device-queries/{query_id}/")
    Call<Void> deviceQueryDestroy(@retrofit2.http.Path(value = "query_id", encoded = true) String queryId);

    /**
     * List device queries. List all device queries. The result will be paged into pages of 100.
     * 
     * @param limit
     *            How many objects to retrieve in the page. The minimum limit is 2 and the maximum is 1000. Limit values
     *            outside of this range are set to the closest limit. (optional)
     * @param order
     *            The order of the records based on creation time, &#x60;ASC&#x60; or &#x60;DESC&#x60;; by default
     *            &#x60;ASC&#x60;. (optional)
     * @param after
     *            The ID of The item after which to retrieve the next page. (optional)
     * @param include
     *            Comma-separated list of data fields to return. Currently supported: &#x60;total_count&#x60;.
     *            (optional)
     * @param filter
     *            URL encoded query string parameter to filter returned data. ##### Filtering
     *            &#x60;&#x60;&#x60;?filter&#x3D;{URL encoded query string}&#x60;&#x60;&#x60; The query string is made
     *            up of key/value pairs separated by ampersands. So for a query of
     *            &#x60;&#x60;&#x60;key1&#x3D;value1&amp;key2&#x3D;value2&amp;key3&#x3D;value3&#x60;&#x60;&#x60; this
     *            would be encoded as follows:
     *            &#x60;&#x60;&#x60;?filter&#x3D;key1%3Dvalue1%26key2%3Dvalue2%26key3%3Dvalue3&#x60;&#x60;&#x60; The
     *            below table lists all the fields that can be filtered on with certain filters: &lt;table&gt;
     *            &lt;thead&gt; &lt;tr&gt; &lt;th&gt;Field&lt;/th&gt; &lt;th&gt;&#x3D; / __eq / __neq&lt;/th&gt;
     *            &lt;th&gt;__in / __nin&lt;/th&gt; &lt;th&gt;__lte / __gte&lt;/th&gt; &lt;tr&gt; &lt;thead&gt;
     *            &lt;tbody&gt; &lt;tr&gt; &lt;td&gt;created_at&lt;/td&gt; &lt;td&gt;✓&lt;/td&gt;
     *            &lt;td&gt;✓&lt;/td&gt; &lt;td&gt;✓&lt;/td&gt; &lt;/tr&gt; &lt;tr&gt; &lt;td&gt;etag&lt;/td&gt;
     *            &lt;td&gt;✓&lt;/td&gt; &lt;td&gt;✓&lt;/td&gt; &lt;td&gt;✓&lt;/td&gt; &lt;/tr&gt; &lt;tr&gt;
     *            &lt;td&gt;id&lt;/td&gt; &lt;td&gt;✓&lt;/td&gt; &lt;td&gt;✓&lt;/td&gt;
     *            &lt;td&gt;&amp;nbsp;&lt;/td&gt; &lt;/tr&gt; &lt;tr&gt; &lt;td&gt;name&lt;/td&gt;
     *            &lt;td&gt;✓&lt;/td&gt; &lt;td&gt;✓&lt;/td&gt; &lt;td&gt;&amp;nbsp;&lt;/td&gt; &lt;/tr&gt;
     *            &lt;tr&gt; &lt;td&gt;query&lt;/td&gt; &lt;td&gt;✓&lt;/td&gt; &lt;td&gt;✓&lt;/td&gt;
     *            &lt;td&gt;&amp;nbsp;&lt;/td&gt; &lt;/tr&gt; &lt;tr&gt; &lt;td&gt;updated_at&lt;/td&gt;
     *            &lt;td&gt;✓&lt;/td&gt; &lt;td&gt;✓&lt;/td&gt; &lt;td&gt;✓&lt;/td&gt; &lt;/tr&gt; &lt;/tbody&gt;
     *            &lt;/table&gt; &amp;nbsp; The examples below show the queries in *unencoded* form. ###### By device
     *            query properties (all properties are filterable): For example:
     *            &#x60;&#x60;&#x60;description&#x3D;{value}&#x60;&#x60;&#x60; ###### On date-time fields: Date-time
     *            fields should be specified in UTC RFC3339 format
     *            &#x60;&#x60;&#x60;YYYY-MM-DDThh:mm:ss.msZ&#x60;&#x60;&#x60;. There are three permitted variations: *
     *            UTC RFC3339 with milliseconds e.g. 2016-11-30T16:25:12.1234Z * UTC RFC3339 without milliseconds e.g.
     *            2016-11-30T16:25:12Z * UTC RFC3339 shortened - without milliseconds and punctuation e.g.
     *            20161130T162512Z Date-time filtering supports three operators: * equality * greater than or equal to
     *            &amp;ndash; field name suffixed with &#x60;&#x60;&#x60;__gte&#x60;&#x60;&#x60; * less than or equal to
     *            &amp;ndash; field name suffixed with &#x60;&#x60;&#x60;__lte&#x60;&#x60;&#x60; Lower and upper limits
     *            to a date-time range may be specified by including both the &#x60;&#x60;&#x60;__gte&#x60;&#x60;&#x60;
     *            and &#x60;&#x60;&#x60;__lte&#x60;&#x60;&#x60; forms in the filter. &#x60;&#x60;&#x60;{field
     *            name}[|__lte|__gte]&#x3D;{UTC RFC3339 date-time}&#x60;&#x60;&#x60; ##### Multi-field example
     *            &#x60;&#x60;&#x60;query_id&#x3D;0158d38771f70000000000010010038c&amp;created_at__gte&#x3D;2016-11-30T16:25:12.1234Z&amp;created_at__lte&#x3D;2016-12-30T00:00:00Z&#x60;&#x60;&#x60;
     *            Encoded:
     *            &#x60;&#x60;&#x60;filter&#x3D;query_id%3D0158d38771f70000000000010010038c%26created_at__gte%3D2016-11-30T16%3A25%3A12.1234Z%26created_at__lte%3D2016-11-30T00%3A00%3A00Z&#x60;&#x60;&#x60;
     *            ##### Filtering with filter operators String field filtering supports the following operators: *
     *            equality: &#x60;__eq&#x60; * non-equality: &#x60;__neq&#x60; * in : &#x60;__in&#x60; * not in:
     *            &#x60;__nin&#x60; For &#x60;__in&#x60; and &#x60;__nin&#x60; filters list of parameters must be
     *            comma-separated: &#x60;name__nin&#x3D;query1,query2&#x60; (optional)
     * @return Call&lt;DeviceQueryPage&gt;
     */
    @GET("v3/device-queries/")
    Call<DeviceQueryPage>
        deviceQueryList(@retrofit2.http.Query("limit") Integer limit, @retrofit2.http.Query("order") String order,
                        @retrofit2.http.Query("after") String after, @retrofit2.http.Query("include") String include,
                        @retrofit2.http.Query("filter") String filter);

    /**
     * Retrieve a device query. Retrieve a specific device query.
     * 
     * @param queryId
     *            (required)
     * @return Call&lt;DeviceQuery&gt;
     */
    @GET("v3/device-queries/{query_id}/")
    Call<DeviceQuery> deviceQueryRetrieve(@retrofit2.http.Path(value = "query_id", encoded = true) String queryId);

    /**
     * Update a device query Update a specifc device query.
     * 
     * @param queryId
     *            (required)
     * @param body
     *            Device query update object. (required)
     * @return Call&lt;DeviceQuery&gt;
     */
    @PUT("v3/device-queries/{query_id}/")
    Call<DeviceQuery> deviceQueryUpdate(@retrofit2.http.Path(value = "query_id", encoded = true) String queryId,
                                        @retrofit2.http.Body DeviceQueryPostPutRequest body);

    /**
     * Get a device Retrieve information about a specific device.
     * 
     * @param id
     *            (required)
     * @return Call&lt;DeviceData&gt;
     */
    @GET("v3/devices/{id}/")
    Call<DeviceData> deviceRetrieve(@retrofit2.http.Path(value = "id", encoded = true) String id);

    /**
     * Update a device Update a specific device.
     * 
     * @param id
     *            The ID of the device. (required)
     * @param device
     *            (required)
     * @return Call&lt;DeviceData&gt;
     */
    @PUT("v3/devices/{id}/")
    Call<DeviceData> deviceUpdate(@retrofit2.http.Path(value = "id", encoded = true) String id,
                                  @retrofit2.http.Body DeviceDataPutRequest device);

    /**
     * Create an image Create a firmware image.
     * 
     * @param datafile
     *            The firmware image file to upload (required)
     * @param description
     *            The description of the firmware image (optional)
     * @param name
     *            The name of the firmware image (optional)
     * @return Call&lt;FirmwareImage&gt;
     */
    @retrofit2.http.Multipart
    @POST("v3/firmware-images/")
    Call<FirmwareImage> firmwareImageCreate(@retrofit2.http.Part() MultipartBody.Part datafile,
                                            @retrofit2.http.Part("description") String description,
                                            @retrofit2.http.Part("name") String name);

    /**
     * Delete an image Delete a firmware image.
     * 
     * @param imageId
     *            The firmware image ID (required)
     * @return Call&lt;Void&gt;
     */
    @DELETE("v3/firmware-images/{image_id}/")
    Call<Void> firmwareImageDestroy(@retrofit2.http.Path(value = "image_id", encoded = true) String imageId);

    /**
     * List all images List all firmware images.
     * 
     * @param limit
     *            How many objects to retrieve in the page. The minimum limit is 2 and the maximum is 1000. Limit values
     *            outside of this range are set to the closest limit. (optional)
     * @param order
     *            ASC or DESC (optional)
     * @param after
     *            The ID of the the item after which to retrieve the next page (optional)
     * @param include
     *            A comma-separated list of data fields to return. Currently supported: total_count (optional)
     * @param filter
     *            URL-encoded query string parameter to filter returned data &#x60;?filter&#x3D;{URL-encoded query
     *            string}&#x60; ###### Filterable fields: The table lists all the fields that can be filtered on with
     *            certain filters: &lt;table&gt; &lt;thead&gt; &lt;tr&gt; &lt;th&gt;Field&lt;/th&gt; &lt;th&gt;&#x3D; /
     *            __eq / __neq&lt;/th&gt; &lt;th&gt;__in / __nin&lt;/th&gt; &lt;th&gt;__lte / __gte&lt;/th&gt;
     *            &lt;tr&gt; &lt;thead&gt; &lt;tbody&gt; &lt;tr&gt; &lt;td&gt;created_at&lt;/td&gt;
     *            &lt;td&gt;✓&lt;/td&gt; &lt;td&gt;✓&lt;/td&gt; &lt;td&gt;✓&lt;/td&gt; &lt;/tr&gt; &lt;tr&gt;
     *            &lt;td&gt;datafile&lt;/td&gt; &lt;td&gt;✓&lt;/td&gt; &lt;td&gt;✓&lt;/td&gt;
     *            &lt;td&gt;&amp;nbsp;&lt;/td&gt; &lt;/tr&gt; &lt;tr&gt; &lt;td&gt;datafile_checksum&lt;/td&gt;
     *            &lt;td&gt;✓&lt;/td&gt; &lt;td&gt;✓&lt;/td&gt; &lt;td&gt;&amp;nbsp;&lt;/td&gt; &lt;/tr&gt;
     *            &lt;tr&gt; &lt;td&gt;datafile_size&lt;/td&gt; &lt;td&gt;✓&lt;/td&gt; &lt;td&gt;✓&lt;/td&gt;
     *            &lt;td&gt;&amp;nbsp;&lt;/td&gt; &lt;/tr&gt; &lt;tr&gt; &lt;td&gt;description&lt;/td&gt;
     *            &lt;td&gt;✓&lt;/td&gt; &lt;td&gt;✓&lt;/td&gt; &lt;td&gt;&amp;nbsp;&lt;/td&gt; &lt;/tr&gt;
     *            &lt;tr&gt; &lt;td&gt;etag&lt;/td&gt; &lt;td&gt;✓&lt;/td&gt; &lt;td&gt;✓&lt;/td&gt;
     *            &lt;td&gt;✓&lt;/td&gt; &lt;/tr&gt; &lt;tr&gt; &lt;td&gt;id&lt;/td&gt; &lt;td&gt;✓&lt;/td&gt;
     *            &lt;td&gt;✓&lt;/td&gt; &lt;td&gt;&amp;nbsp;&lt;/td&gt; &lt;/tr&gt; &lt;tr&gt;
     *            &lt;td&gt;name&lt;/td&gt; &lt;td&gt;✓&lt;/td&gt; &lt;td&gt;✓&lt;/td&gt;
     *            &lt;td&gt;&amp;nbsp;&lt;/td&gt; &lt;/tr&gt; &lt;tr&gt; &lt;td&gt;timestamp&lt;/td&gt;
     *            &lt;td&gt;✓&lt;/td&gt; &lt;td&gt;✓&lt;/td&gt; &lt;td&gt;✓&lt;/td&gt; &lt;/tr&gt; &lt;tr&gt;
     *            &lt;td&gt;updated_at&lt;/td&gt; &lt;td&gt;✓&lt;/td&gt; &lt;td&gt;✓&lt;/td&gt;
     *            &lt;td&gt;✓&lt;/td&gt; &lt;/tr&gt; &lt;/tbody&gt; &lt;/table&gt; &amp;nbsp; The query string is made
     *            up of key-value pairs separated by ampersands. For example, this query:
     *            &#x60;key1&#x3D;value1&amp;key2&#x3D;value2&amp;key3&#x3D;value3&#x60; would be URL-encoded as:
     *            &#x60;?filter&#x3D;key1__eq%3Dvalue1%26key2__eq%3Dvalue2%26key3__eq%3Dvalue3&#x60; **Filtering by
     *            properties** &#x60;name__eq&#x3D;myimage&#x60; **Filtering on date-time fields** Date-time fields
     *            should be specified in UTC RFC3339 format, &#x60;YYYY-MM-DDThh:mm:ss.msZ&#x60;. There are three
     *            permitted variations: * UTC RFC3339 with milliseconds. Example: &#x60;2016-11-30T16:25:12.1234Z&#x60;
     *            * UTC RFC3339 without milliseconds. Example: &#x60;2016-11-30T16:25:12Z&#x60; * UTC RFC3339 shortened
     *            without milliseconds and punctuation. Example: &#x60;20161130T162512Z&#x60; Date-time filtering
     *            supports three operators: * equality by appending &#x60;__eq&#x60; to the field name * greater than or
     *            equal to by appending &#x60;__gte&#x60; to the field name * less than or equal to by appending
     *            &#x60;__lte&#x60; to the field name &#x60;{field name}[|__eq|__lte|__gte]&#x3D;{UTC RFC3339
     *            date-time}&#x60; Time ranges may be specified by including both the &#x60;__gte&#x60; and
     *            &#x60;__lte&#x60; forms in the filter. For example:
     *            &#x60;created_at__gte&#x3D;2016-11-30T16:25:12.1234Z&amp;created_at__lte&#x3D;2016-12-30T00:00:00Z&#x60;
     *            **Filtering on multiple fields**
     *            &#x60;name__eq&#x3D;myimage&amp;created_at__gte&#x3D;2016-11-30T16:25:12.1234Z&amp;created_at__lte&#x3D;2016-12-30T00:00:00Z&#x60;
     *            **Filtering with filter operators** String field filtering supports the following operators: *
     *            equality: &#x60;__eq&#x60; * non-equality: &#x60;__neq&#x60; * in : &#x60;__in&#x60; * not in:
     *            &#x60;__nin&#x60; For &#x60;__in&#x60; and &#x60;__nin&#x60; filters list of parameters must be
     *            comma-separated: &#x60;name__in&#x3D;fw-image1,fw-image2&#x60; (optional)
     * @return Call&lt;FirmwareImagePage&gt;
     */
    @GET("v3/firmware-images/")
    Call<FirmwareImagePage>
        firmwareImageList(@retrofit2.http.Query("limit") Integer limit, @retrofit2.http.Query("order") String order,
                          @retrofit2.http.Query("after") String after, @retrofit2.http.Query("include") String include,
                          @retrofit2.http.Query("filter") String filter);

    /**
     * Get an image Retrieve a firmware image.
     * 
     * @param imageId
     *            The firmware image ID (required)
     * @return Call&lt;FirmwareImage&gt;
     */
    @GET("v3/firmware-images/{image_id}/")
    Call<FirmwareImage> firmwareImageRetrieve(@retrofit2.http.Path(value = "image_id", encoded = true) String imageId);

    /**
     * Upload a manifest Upload a firmware manifest. The API enforces a maximum size of manifests of 2 KB.
     * 
     * @param datafile
     *            The manifest file to create. The API gateway enforces the account-specific file size. (required)
     * @param description
     *            The description of the firmware manifest (optional)
     * @param keyTable
     *            The key table of pre-shared keys for devices (optional)
     * @param name
     *            The name of the firmware manifest (optional)
     * @return Call&lt;FirmwareManifest&gt;
     */
    @retrofit2.http.Multipart
    @POST("v3/firmware-manifests/")
    Call<FirmwareManifest> firmwareManifestCreate(@retrofit2.http.Part() MultipartBody.Part datafile,
                                                  @retrofit2.http.Part("description") String description,
                                                  @retrofit2.http.Part() MultipartBody.Part keyTable,
                                                  @retrofit2.http.Part("name") String name);

    /**
     * Delete a manifest Delete a firmware manifest.
     * 
     * @param manifestId
     *            The firmware manifest ID (required)
     * @return Call&lt;Void&gt;
     */
    @DELETE("v3/firmware-manifests/{manifest_id}/")
    Call<Void> firmwareManifestDestroy(@retrofit2.http.Path(value = "manifest_id", encoded = true) String manifestId);

    /**
     * List manifests List firmware manifests.
     * 
     * @param limit
     *            How many objects to retrieve in the page. The minimum limit is 2 and the maximum is 1000. Limit values
     *            outside of this range are set to the closest limit. (optional)
     * @param order
     *            ASC or DESC (optional)
     * @param after
     *            The ID of the the item after which to retrieve the next page (optional)
     * @param include
     *            A comma-separated list of data fields to return. Currently supported: total_count (optional)
     * @param filter
     *            URL-encoded query string parameter to filter returned data &#x60;?filter&#x3D;{URL-encoded query
     *            string}&#x60; ###### Filterable fields: The table lists all the fields that can be filtered on with
     *            certain filters: &lt;table&gt; &lt;thead&gt; &lt;tr&gt; &lt;th&gt;Field&lt;/th&gt; &lt;th&gt;&#x3D; /
     *            __eq / __neq&lt;/th&gt; &lt;th&gt;__in / __nin&lt;/th&gt; &lt;th&gt;__lte / __gte&lt;/th&gt;
     *            &lt;tr&gt; &lt;thead&gt; &lt;tbody&gt; &lt;tr&gt; &lt;td&gt;created_at&lt;/td&gt;
     *            &lt;td&gt;✓&lt;/td&gt; &lt;td&gt;✓&lt;/td&gt; &lt;td&gt;✓&lt;/td&gt; &lt;/tr&gt; &lt;tr&gt;
     *            &lt;td&gt;datafile&lt;/td&gt; &lt;td&gt;✓&lt;/td&gt; &lt;td&gt;✓&lt;/td&gt;
     *            &lt;td&gt;&amp;nbsp;&lt;/td&gt; &lt;/tr&gt; &lt;tr&gt; &lt;td&gt;datafile_size&lt;/td&gt;
     *            &lt;td&gt;✓&lt;/td&gt; &lt;td&gt;✓&lt;/td&gt; &lt;td&gt;&amp;nbsp;&lt;/td&gt; &lt;/tr&gt;
     *            &lt;tr&gt; &lt;td&gt;description&lt;/td&gt; &lt;td&gt;✓&lt;/td&gt; &lt;td&gt;✓&lt;/td&gt;
     *            &lt;td&gt;&amp;nbsp;&lt;/td&gt; &lt;/tr&gt; &lt;tr&gt; &lt;td&gt;device_class&lt;/td&gt;
     *            &lt;td&gt;✓&lt;/td&gt; &lt;td&gt;✓&lt;/td&gt; &lt;td&gt;&amp;nbsp;&lt;/td&gt; &lt;/tr&gt;
     *            &lt;tr&gt; &lt;td&gt;etag&lt;/td&gt; &lt;td&gt;✓&lt;/td&gt; &lt;td&gt;✓&lt;/td&gt;
     *            &lt;td&gt;✓&lt;/td&gt; &lt;/tr&gt; &lt;tr&gt; &lt;td&gt;id&lt;/td&gt; &lt;td&gt;✓&lt;/td&gt;
     *            &lt;td&gt;✓&lt;/td&gt; &lt;td&gt;&amp;nbsp;&lt;/td&gt; &lt;/tr&gt; &lt;tr&gt;
     *            &lt;td&gt;name&lt;/td&gt; &lt;td&gt;✓&lt;/td&gt; &lt;td&gt;✓&lt;/td&gt;
     *            &lt;td&gt;&amp;nbsp;&lt;/td&gt; &lt;/tr&gt; &lt;tr&gt; &lt;td&gt;timestamp&lt;/td&gt;
     *            &lt;td&gt;✓&lt;/td&gt; &lt;td&gt;✓&lt;/td&gt; &lt;td&gt;✓&lt;/td&gt; &lt;/tr&gt; &lt;tr&gt;
     *            &lt;td&gt;updated_at&lt;/td&gt; &lt;td&gt;✓&lt;/td&gt; &lt;td&gt;✓&lt;/td&gt;
     *            &lt;td&gt;✓&lt;/td&gt; &lt;/tr&gt; &lt;/tbody&gt; &lt;/table&gt; &amp;nbsp; The query string is made
     *            up of key-value pairs separated by ampersands. For example, this query:
     *            &#x60;key1__eq&#x3D;value1&amp;key2__eq&#x3D;value2&amp;key3__eq&#x3D;value3&#x60; would be
     *            URL-encoded as: &#x60;?filter&#x3D;key1__eq%3Dvalue1%26key2__eq%3Dvalue2%26key3__eq%3Dvalue3&#x60;
     *            **Filtering by properties** &#x60;name__eq&#x3D;mymanifest&#x60; **Filtering on date-time fields**
     *            Date-time fields should be specified in UTC RFC3339 format, &#x60;YYYY-MM-DDThh:mm:ss.msZ&#x60;. There
     *            are three permitted variations: * UTC RFC3339 with milliseconds. Example:
     *            &#x60;2016-11-30T16:25:12.1234Z&#x60; * UTC RFC3339 without milliseconds. Example:
     *            &#x60;2016-11-30T16:25:12Z&#x60; * UTC RFC3339 shortened without milliseconds and punctuation.
     *            Example: &#x60;20161130T162512Z&#x60; Date-time filtering supports three operators: * equality by
     *            appending &#x60;__eq&#x60; to the field name * greater than or equal to by appending &#x60;__gte&#x60;
     *            to the field name * less than or equal to by appending &#x60;__lte&#x60; to the field name
     *            &#x60;{field name}[|__eq|__lte|__gte]&#x3D;{UTC RFC3339 date-time}&#x60; Time ranges may be specified
     *            by including both the &#x60;__gte&#x60; and &#x60;__lte&#x60; forms in the filter. For example:
     *            &#x60;created_at__gte&#x3D;2016-11-30T16:25:12.1234Z&amp;created_at__lte&#x3D;2016-12-30T00:00:00Z&#x60;
     *            **Filtering on multiple fields**
     *            &#x60;name__eq&#x3D;mymanifest&amp;created_at__gte&#x3D;2016-11-30T16:25:12.1234Z&amp;created_at__lte&#x3D;2016-12-30T00:00:00Z&#x60;
     *            **Filtering with filter operators** String field filtering supports the following operators: *
     *            equality: &#x60;__eq&#x60; * non-equality: &#x60;__neq&#x60; * in : &#x60;__in&#x60; * not in:
     *            &#x60;__nin&#x60; For &#x60;__in&#x60; and &#x60;__nin&#x60; filters list of parameters must be
     *            comma-separated: &#x60;name__in&#x3D;fw-manifest1,fw-manifest2&#x60; (optional)
     * @return Call&lt;FirmwareManifestPage&gt;
     */
    @GET("v3/firmware-manifests/")
    Call<FirmwareManifestPage> firmwareManifestList(@retrofit2.http.Query("limit") Integer limit,
                                                    @retrofit2.http.Query("order") String order,
                                                    @retrofit2.http.Query("after") String after,
                                                    @retrofit2.http.Query("include") String include,
                                                    @retrofit2.http.Query("filter") String filter);

    /**
     * Get a manifest Retrieve a firmware manifest.
     * 
     * @param manifestId
     *            The firmware manifest ID (required)
     * @return Call&lt;FirmwareManifest&gt;
     */
    @GET("v3/firmware-manifests/{manifest_id}/")
    Call<FirmwareManifest>
        firmwareManifestRetrieve(@retrofit2.http.Path(value = "manifest_id", encoded = true) String manifestId);

    /**
     * Get billing report. Fetch the billing report generated for the currently authenticated commercial non-subtenant
     * account. Billing reports for subtenant accounts are included in their aggregator&#39;s billing report response.
     * **Example usage:** curl -X GET https://api.us-east-1.mbedcloud.com/v3/billing-report?month&#x3D;2018-07 -H
     * &#39;authorization: Bearer {api-key}&#39;
     * 
     * @param month
     *            Queried year and month of billing report. (required)
     * @return Call&lt;ReportResponse&gt;
     */
    @GET("v3/billing-report")
    Call<ReportResponse> getBillingReport(@retrofit2.http.Query("month") String month);

    /**
     * Get raw billing data of the active devices for the month. Fetch the raw billing data of the active devices for
     * the currently authenticated commercial non-subtenant account. This is supplementary data for the billing report.
     * The raw billing data of the active devices for subtenant accounts are included in their aggregator&#39;s raw
     * billing data of the active devices. The endpoint returns the URL to download the gzipped CSV file. The first line
     * is the header providing information on the active devices. For example, the ID of an active device. **Example
     * usage:** curl -X GET https://api.us-east-1.mbedcloud.com/v3/billing-report-active-devices?month&#x3D;2018-07 -H
     * &#39;authorization: Bearer {api-key}&#39;
     * 
     * @param month
     *            Queried year and month of billing report. (required)
     * @return Call&lt;BillingReportRawDataResponse&gt;
     */
    @GET("v3/billing-report-active-devices")
    Call<BillingReportRawDataResponse> getBillingReportActiveDevices(@retrofit2.http.Query("month") String month);

    /**
     * Get raw billing data of the firmware updates for the month. Fetch raw billing data of the firmware updates for
     * the currently authenticated commercial non-subtenant account. This is supplementary data for the billing report.
     * The raw billing data of the firmware updates for subtenant accounts are included in their aggregator&#39;s raw
     * billing data of the firmware updates. The endpoint returns the URL to download the gzipped CSV file. The first
     * line is the header providing information on the firmware updates. For example, the ID of an firmware update.
     * **Example usage:** curl -X GET
     * https://api.us-east-1.mbedcloud.com/v3/billing-report-firmware-updates?month&#x3D;2018-07 -H &#39;authorization:
     * Bearer {api-key}&#39;
     * 
     * @param month
     *            Queried year and month of billing report. (required)
     * @return Call&lt;BillingReportRawDataResponse&gt;
     */
    @GET("v3/billing-report-firmware-updates")
    Call<BillingReportRawDataResponse> getBillingReportFirmwareUpdates(@retrofit2.http.Query("month") String month);

    /**
     * Get branding colors of the dark theme. Returns the branding colors of the dark theme.
     * 
     * @param accountId
     *            The ID of the account whose branding colors to be fetched. (required)
     * @return Call&lt;BrandingColorList&gt;
     */
    @GET("auth/accounts/{account_id}/branding-colors/dark")
    Call<BrandingColorList>
        getLoginPageAllDarkColors(@retrofit2.http.Path(value = "account_id", encoded = true) String accountId);

    /**
     * Get metadata of all images of the dark theme. Returns the metadata of all branding images of the dark theme.
     * 
     * @param accountId
     *            The ID of the account whose branding images to be fetched. (required)
     * @return Call&lt;BrandingImageList&gt;
     */
    @GET("auth/accounts/{account_id}/branding-images/dark")
    Call<BrandingImageList>
        getLoginPageAllDarkImageData(@retrofit2.http.Path(value = "account_id", encoded = true) String accountId);

    /**
     * Get branding colors of the light theme. Returns the branding colors of the light theme.
     * 
     * @param accountId
     *            The ID of the account whose branding colors to be fetched. (required)
     * @return Call&lt;BrandingColorList&gt;
     */
    @GET("auth/accounts/{account_id}/branding-colors/light")
    Call<BrandingColorList>
        getLoginPageAllLightColors(@retrofit2.http.Path(value = "account_id", encoded = true) String accountId);

    /**
     * Get metadata of all images of the light theme. Returns the metadata of all branding images of the light theme.
     * 
     * @param accountId
     *            The ID of the account whose branding images to be fetched. (required)
     * @return Call&lt;BrandingImageList&gt;
     */
    @GET("auth/accounts/{account_id}/branding-images/light")
    Call<BrandingImageList>
        getLoginPageAllLightImageData(@retrofit2.http.Path(value = "account_id", encoded = true) String accountId);

    /**
     * Get branding color of the dark theme. Returns the requested branding color of the dark theme.
     * 
     * @param accountId
     *            The ID of the account whose branding colors to be fetched. (required)
     * @param reference
     *            The name of the branding color. (required)
     * @return Call&lt;BrandingColor&gt;
     */
    @GET("auth/accounts/{account_id}/branding-colors/dark/{reference}")
    Call<BrandingColor>
        getLoginPageDarkColor(@retrofit2.http.Path(value = "account_id", encoded = true) String accountId,
                              @retrofit2.http.Path(value = "reference", encoded = true) String reference);

    /**
     * Get metadata of an image of the dark theme. An endpoint for getting metadata of one account branding image of the
     * dark theme.
     * 
     * @param accountId
     *            The ID of the account whose branding image to be fetched. (required)
     * @param reference
     *            Name of the picture whose metadata to be fetched. (required)
     * @return Call&lt;BrandingImage&gt;
     */
    @GET("auth/accounts/{account_id}/branding-images/dark/{reference}")
    Call<BrandingImage>
        getLoginPageDarkImageData(@retrofit2.http.Path(value = "account_id", encoded = true) String accountId,
                                  @retrofit2.http.Path(value = "reference", encoded = true) String reference);

    /**
     * Get branding color of the light theme. Returns the requested branding color of the light theme.
     * 
     * @param accountId
     *            The ID of the account whose branding colors to be fetched. (required)
     * @param reference
     *            The name of the branding color. (required)
     * @return Call&lt;BrandingColor&gt;
     */
    @GET("auth/accounts/{account_id}/branding-colors/light/{reference}")
    Call<BrandingColor>
        getLoginPageLightColor(@retrofit2.http.Path(value = "account_id", encoded = true) String accountId,
                               @retrofit2.http.Path(value = "reference", encoded = true) String reference);

    /**
     * Get metadata of an image of the light theme. An endpoint for getting metadata of one account branding image of
     * the light theme.
     * 
     * @param accountId
     *            The ID of the account whose branding image to be fetched. (required)
     * @param reference
     *            Name of the picture whose metadata to be fetched. (required)
     * @return Call&lt;BrandingImage&gt;
     */
    @GET("auth/accounts/{account_id}/branding-images/light/{reference}")
    Call<BrandingImage>
        getLoginPageLightImageData(@retrofit2.http.Path(value = "account_id", encoded = true) String accountId,
                                   @retrofit2.http.Path(value = "reference", encoded = true) String reference);

    /**
     * Service package quota. Get the available firmware update quota for the currently authenticated commercial
     * account. **Example usage:** curl -X GET https://api.us-east-1.mbedcloud.com/v3/service-packages-quota -H
     * &#39;authorization: Bearer {api-key}&#39;
     * 
     * @return Call&lt;ServicePackageQuota&gt;
     */
    @GET("v3/service-packages-quota")
    Call<ServicePackageQuota> getServicePackageQuota();

    /**
     * Service package quota history. Get your quota usage history. This API is available for commercial accounts.
     * Aggregator accounts can see own and subtenant quota usage data. History data is ordered in ascending order based
     * on the added timestamp. **Example usage:** curl -X GET
     * https://api.us-east-1.mbedcloud.com/v3/service-packages-quota-history -H &#39;authorization: Bearer
     * {api-key}&#39;
     * 
     * @param limit
     *            Maximum amount of quota history entries contained in one paged response. (optional)
     * @param after
     *            To fetch after which quota history ID. The results will contain entries after specified entry.
     *            (optional)
     * @return Call&lt;ServicePackageQuotaHistoryResponse&gt;
     */
    @GET("v3/service-packages-quota-history")
    Call<ServicePackageQuotaHistoryResponse> getServicePackageQuotaHistory(@retrofit2.http.Query("limit") Integer limit,
                                                                           @retrofit2.http.Query("after") String after);

    /**
     * Get all service packages. Get information of all service packages for the currently authenticated commercial
     * account. The response is returned in descending order by service package created timestamp, listing first the
     * pending service package, then the active service package and finally the previous service packages. **Example
     * usage:** curl -X GET https://api.us-east-1.mbedcloud.com/v3/service-packages -H &#39;authorization: Bearer
     * {api-key}&#39;
     * 
     * @return Call&lt;ServicePackagesResponse&gt;
     */
    @GET("v3/service-packages")
    Call<ServicePackagesResponse> getServicePackages();

    /**
     * Create a group Create a group.
     * 
     * @param group
     *            Group (required)
     * @return Call&lt;DeviceGroup&gt;
     */
    @POST("v3/device-groups/")
    Call<DeviceGroup> groupCreate(@retrofit2.http.Body Group group);

    /**
     * Delete a group Delete a group.
     * 
     * @param deviceGroupId
     *            The ID of the group (required)
     * @return Call&lt;Void&gt;
     */
    @DELETE("v3/device-groups/{device-group-id}/")
    Call<Void> groupDelete(@retrofit2.http.Path(value = "device-group-id", encoded = true) String deviceGroupId);

    /**
     * List all groups. List all groups.
     * 
     * @param limit
     *            How many objects to retrieve in the page. The minimum limit is 2 and the maximum is 1000. Limit values
     *            outside of this range are set to the closest limit. (optional)
     * @param order
     *            The order of the records based on creation time, &#x60;ASC&#x60; or &#x60;DESC&#x60;; by default
     *            &#x60;ASC&#x60;. (optional)
     * @param after
     *            The ID of The item after which to retrieve the next page. (optional)
     * @param include
     *            Comma-separated list of data fields to return. Currently supported: &#x60;total_count&#x60;.
     *            (optional)
     * @param filter
     *            URL encoded query string parameter to filter returned data. ##### Filtering
     *            &#x60;&#x60;&#x60;?filter&#x3D;{URL encoded query string}&#x60;&#x60;&#x60; The query string is made
     *            up of key/value pairs separated by ampersands. So for a query of
     *            &#x60;&#x60;&#x60;key1&#x3D;value1&amp;key2&#x3D;value2&amp;key3&#x3D;value3&#x60;&#x60;&#x60; this
     *            would be encoded as follows:
     *            &#x60;&#x60;&#x60;?filter&#x3D;key1%3Dvalue1%26key2%3Dvalue2%26key3%3Dvalue3&#x60;&#x60;&#x60; ######
     *            Filterable fields: The table lists all the fields that can be filtered on with certain filters:
     *            &lt;table&gt; &lt;thead&gt; &lt;tr&gt; &lt;th&gt;Field&lt;/th&gt; &lt;th&gt;&#x3D; / __eq /
     *            __neq&lt;/th&gt; &lt;th&gt;__in / __nin&lt;/th&gt; &lt;th&gt;__lte / __gte&lt;/th&gt; &lt;tr&gt;
     *            &lt;thead&gt; &lt;tbody&gt; &lt;tr&gt; &lt;td&gt;id&lt;/td&gt; &lt;td&gt;✓&lt;/td&gt;
     *            &lt;td&gt;✓&lt;/td&gt; &lt;td&gt;&amp;nbsp;&lt;/td&gt; &lt;/tr&gt; &lt;tr&gt;
     *            &lt;td&gt;devices_count&lt;/td&gt; &lt;td&gt;✓&lt;/td&gt; &lt;td&gt;✓&lt;/td&gt;
     *            &lt;td&gt;✓&lt;/td&gt; &lt;/tr&gt; &lt;tr&gt; &lt;td&gt;name&lt;/td&gt; &lt;td&gt;✓&lt;/td&gt;
     *            &lt;td&gt;✓&lt;/td&gt; &lt;td&gt;&amp;nbsp;&lt;/td&gt; &lt;/tr&gt; &lt;tr&gt;
     *            &lt;td&gt;custom_attributes&lt;/td&gt; &lt;td&gt;✓&lt;/td&gt; &lt;td&gt;&amp;nbsp;&lt;/td&gt;
     *            &lt;td&gt;&amp;nbsp;&lt;/td&gt; &lt;/tr&gt; &lt;tr&gt; &lt;td&gt;created_at&lt;/td&gt;
     *            &lt;td&gt;✓&lt;/td&gt; &lt;td&gt;✓&lt;/td&gt; &lt;td&gt;✓&lt;/td&gt; &lt;/tr&gt; &lt;tr&gt;
     *            &lt;td&gt;updated_at&lt;/td&gt; &lt;td&gt;✓&lt;/td&gt; &lt;td&gt;✓&lt;/td&gt;
     *            &lt;td&gt;✓&lt;/td&gt; &lt;/tr&gt; &lt;tr&gt; &lt;td&gt;etag&lt;/td&gt; &lt;td&gt;✓&lt;/td&gt;
     *            &lt;td&gt;✓&lt;/td&gt; &lt;td&gt;✓&lt;/td&gt; &lt;/tr&gt; &lt;/tbody&gt; &lt;/table&gt; &amp;nbsp;
     *            The examples below show the queries in *unencoded* form. ###### By device group properties:
     *            &#x60;&#x60;&#x60;name__eq&#x3D;mygroup&#x60;&#x60;&#x60; ###### On date-time fields: Date-time fields
     *            should be specified in UTC RFC3339 format &#x60;&#x60;&#x60;YYYY-MM-DDThh:mm:ss.msZ&#x60;&#x60;&#x60;.
     *            There are three permitted variations: * UTC RFC3339 with milliseconds e.g. 2016-11-30T16:25:12.1234Z *
     *            UTC RFC3339 without milliseconds e.g. 2016-11-30T16:25:12Z * UTC RFC3339 shortened - without
     *            milliseconds and punctuation e.g. 20161130T162512Z Date-time filtering supports three operators: *
     *            equality * greater than or equal to &amp;ndash; field name suffixed with
     *            &#x60;&#x60;&#x60;__gte&#x60;&#x60;&#x60; * less than or equal to &amp;ndash; field name suffixed with
     *            &#x60;&#x60;&#x60;__lte&#x60;&#x60;&#x60; Lower and upper limits to a date-time range may be specified
     *            by including both the &#x60;&#x60;&#x60;__gte&#x60;&#x60;&#x60; and
     *            &#x60;&#x60;&#x60;__lte&#x60;&#x60;&#x60; forms in the filter. &#x60;&#x60;&#x60;{field
     *            name}[|__lte|__gte]&#x3D;{UTC RFC3339 date-time}&#x60;&#x60;&#x60; ###### By device group custom
     *            attributes: &#x60;&#x60;&#x60;custom_attributes__{param}&#x3D;{value}&#x60;&#x60;&#x60;
     *            &#x60;&#x60;&#x60;custom_attributes__tag&#x3D;TAG1&#x60;&#x60;&#x60; ##### Multi-field example
     *            &#x60;&#x60;&#x60;name__eq&#x3D;mygroup&amp;created_at__gte&#x3D;2016-11-30T16:25:12.1234Z&amp;created_at__lte&#x3D;2016-12-30T00:00:00Z&#x60;&#x60;&#x60;
     *            Encoded:
     *            &#x60;&#x60;&#x60;?filter&#x3D;name__eq%3Dmygroup%26created_at__gte%3D2016-11-30T16%3A25%3A12.1234Z%26created_at__lte%3D2016-12-30T00%3A00%3A00Z&#x60;&#x60;&#x60;
     *            ##### Filtering with filter operators String field filtering supports the following operators: *
     *            equality: &#x60;__eq&#x60; * non-equality: &#x60;__neq&#x60; * in : &#x60;__in&#x60; * not in:
     *            &#x60;__nin&#x60; For &#x60;__in&#x60; and &#x60;__nin&#x60; filters list of parameters must be
     *            comma-separated: &#x60;name__in&#x3D;group1,group2&#x60; (optional)
     * @return Call&lt;DeviceGroupPage&gt;
     */
    @GET("v3/device-groups/")
    Call<DeviceGroupPage>
        groupList(@retrofit2.http.Query("limit") Integer limit, @retrofit2.http.Query("order") String order,
                  @retrofit2.http.Query("after") String after, @retrofit2.http.Query("include") String include,
                  @retrofit2.http.Query("filter") String filter);

    /**
     * Add a device to a group Add one device to a group.
     * 
     * @param deviceGroupId
     *            The ID of the group. (required)
     * @param body
     *            Body of the request. (required)
     * @return Call&lt;Void&gt;
     */
    @POST("v3/device-groups/{device-group-id}/devices/add/")
    Call<Void> groupMembersAdd(@retrofit2.http.Path(value = "device-group-id", encoded = true) String deviceGroupId,
                               @retrofit2.http.Body DeviceGroupManipulation body);

    /**
     * Remove a device from a group Remove one device from a group.
     * 
     * @param deviceGroupId
     *            The ID of the group. (required)
     * @param body
     *            Body of the request. (required)
     * @return Call&lt;Void&gt;
     */
    @POST("v3/device-groups/{device-group-id}/devices/remove/")
    Call<Void> groupMembersRemove(@retrofit2.http.Path(value = "device-group-id", encoded = true) String deviceGroupId,
                                  @retrofit2.http.Body DeviceGroupManipulation body);

    /**
     * Get a page of devices Get a page of devices.
     * 
     * @param deviceGroupId
     *            (required)
     * @param limit
     *            How many objects to retrieve in the page. The minimum limit is 2 and the maximum is 1000. Limit values
     *            outside of this range are set to the closest limit. (optional)
     * @param order
     *            The order of the records based on creation time, &#x60;ASC&#x60; or &#x60;DESC&#x60;; by default
     *            &#x60;ASC&#x60;. (optional)
     * @param after
     *            The ID of The item after which to retrieve the next page. (optional)
     * @param include
     *            Comma-separated list of data fields to return. Currently supported: &#x60;total_count&#x60;.
     *            (optional)
     * @param filter
     *            URL encoded query string parameter to filter returned data. ##### Filtering
     *            &#x60;&#x60;&#x60;?filter&#x3D;{URL encoded query string}&#x60;&#x60;&#x60; The query string is made
     *            up of key/value pairs separated by ampersands. So for a query of
     *            &#x60;&#x60;&#x60;key1&#x3D;value1&amp;key2&#x3D;value2&amp;key3&#x3D;value3&#x60;&#x60;&#x60; this
     *            would be encoded as follows:
     *            &#x60;&#x60;&#x60;?filter&#x3D;key1%3Dvalue1%26key2%3Dvalue2%26key3%3Dvalue3&#x60;&#x60;&#x60; ######
     *            Filterable fields: The table lists all the fields that can be filtered on with certain filters:
     *            &lt;table&gt; &lt;thead&gt; &lt;tr&gt; &lt;th&gt;Field&lt;/th&gt; &lt;th&gt;&#x3D; / __eq /
     *            __neq&lt;/th&gt; &lt;th&gt;__in / __nin&lt;/th&gt; &lt;th&gt;__lte / __gte&lt;/th&gt; &lt;tr&gt;
     *            &lt;thead&gt; &lt;tbody&gt; &lt;tr&gt; &lt;td&gt;id&lt;/td&gt; &lt;td&gt;✓&lt;/td&gt;
     *            &lt;td&gt;✓&lt;/td&gt; &lt;td&gt;&amp;nbsp;&lt;/td&gt; &lt;/tr&gt; &lt;tr&gt;
     *            &lt;td&gt;devices_count&lt;/td&gt; &lt;td&gt;✓&lt;/td&gt; &lt;td&gt;✓&lt;/td&gt;
     *            &lt;td&gt;✓&lt;/td&gt; &lt;/tr&gt; &lt;tr&gt; &lt;td&gt;name&lt;/td&gt; &lt;td&gt;✓&lt;/td&gt;
     *            &lt;td&gt;✓&lt;/td&gt; &lt;td&gt;&amp;nbsp;&lt;/td&gt; &lt;/tr&gt; &lt;tr&gt;
     *            &lt;td&gt;description&lt;/td&gt; &lt;td&gt;✓&lt;/td&gt; &lt;td&gt;✓&lt;/td&gt;
     *            &lt;td&gt;&amp;nbsp;&lt;/td&gt; &lt;/tr&gt; &lt;tr&gt; &lt;td&gt;custom_attributes&lt;/td&gt;
     *            &lt;td&gt;✓&lt;/td&gt; &lt;td&gt;&amp;nbsp;&lt;/td&gt; &lt;td&gt;&amp;nbsp;&lt;/td&gt; &lt;/tr&gt;
     *            &lt;tr&gt; &lt;td&gt;created_at&lt;/td&gt; &lt;td&gt;✓&lt;/td&gt; &lt;td&gt;✓&lt;/td&gt;
     *            &lt;td&gt;✓&lt;/td&gt; &lt;/tr&gt; &lt;tr&gt; &lt;td&gt;updated_at&lt;/td&gt;
     *            &lt;td&gt;✓&lt;/td&gt; &lt;td&gt;✓&lt;/td&gt; &lt;td&gt;✓&lt;/td&gt; &lt;/tr&gt; &lt;tr&gt;
     *            &lt;td&gt;etag&lt;/td&gt; &lt;td&gt;✓&lt;/td&gt; &lt;td&gt;✓&lt;/td&gt; &lt;td&gt;✓&lt;/td&gt;
     *            &lt;/tr&gt; &lt;/tbody&gt; &lt;/table&gt; &amp;nbsp; The examples below show the queries in
     *            *unencoded* form. ###### By device properties (all properties are filterable):
     *            &#x60;&#x60;&#x60;state&#x3D;[unenrolled|cloud_enrolling|bootstrapped|registered]&#x60;&#x60;&#x60;
     *            &#x60;&#x60;&#x60;device_class&#x3D;{value}&#x60;&#x60;&#x60; ###### On date-time fields: Date-time
     *            fields should be specified in UTC RFC3339 format
     *            &#x60;&#x60;&#x60;YYYY-MM-DDThh:mm:ss.msZ&#x60;&#x60;&#x60;. There are three permitted variations: *
     *            UTC RFC3339 with milliseconds e.g. 2016-11-30T16:25:12.1234Z * UTC RFC3339 without milliseconds e.g.
     *            2016-11-30T16:25:12Z * UTC RFC3339 shortened - without milliseconds and punctuation e.g.
     *            20161130T162512Z Date-time filtering supports three operators: * equality * greater than or equal to
     *            &amp;ndash; field name suffixed with &#x60;&#x60;&#x60;__gte&#x60;&#x60;&#x60; * less than or equal to
     *            &amp;ndash; field name suffixed with &#x60;&#x60;&#x60;__lte&#x60;&#x60;&#x60; Lower and upper limits
     *            to a date-time range may be specified by including both the &#x60;&#x60;&#x60;__gte&#x60;&#x60;&#x60;
     *            and &#x60;&#x60;&#x60;__lte&#x60;&#x60;&#x60; forms in the filter. &#x60;&#x60;&#x60;{field
     *            name}[|__lte|__gte]&#x3D;{UTC RFC3339 date-time}&#x60;&#x60;&#x60; ###### On device custom attributes:
     *            &#x60;&#x60;&#x60;custom_attributes__{param}&#x3D;{value}&#x60;&#x60;&#x60;
     *            &#x60;&#x60;&#x60;custom_attributes__tag&#x3D;TAG1&#x60;&#x60;&#x60; ##### Multi-field example
     *            &#x60;&#x60;&#x60;state&#x3D;bootstrapped&amp;created_at__gte&#x3D;2016-11-30T16:25:12.1234Z&amp;created_at__lte&#x3D;2016-12-30T00:00:00Z&#x60;&#x60;&#x60;
     *            Encoded:
     *            &#x60;&#x60;&#x60;?filter&#x3D;state%3Dbootstrapped%26created_at__gte%3D2016-11-30T16%3A25%3A12.1234Z%26created_at__lte%3D2016-11-30T00%3A00%3A00Z&#x60;&#x60;&#x60;
     *            ##### Filtering with filter operators String field filtering supports the following operators: *
     *            equality: &#x60;__eq&#x60; * non-equality: &#x60;__neq&#x60; * in : &#x60;__in&#x60; * not in:
     *            &#x60;__nin&#x60; For &#x60;__in&#x60; and &#x60;__nin&#x60; filters list of parameters must be
     *            comma-separated: &#x60;state__nin&#x3D;unenrolled,dergistered&#x60; (optional)
     * @return Call&lt;DevicePage&gt;
     */
    @GET("v3/device-groups/{device-group-id}/devices/")
    Call<DevicePage>
        groupMembersRetrieve(@retrofit2.http.Path(value = "device-group-id", encoded = true) String deviceGroupId,
                             @retrofit2.http.Query("limit") Integer limit, @retrofit2.http.Query("order") String order,
                             @retrofit2.http.Query("after") String after,
                             @retrofit2.http.Query("include") String include,
                             @retrofit2.http.Query("filter") String filter);

    /**
     * Get a group. Get a group.
     * 
     * @param deviceGroupId
     *            The group ID (required)
     * @return Call&lt;DeviceGroup&gt;
     */
    @GET("v3/device-groups/{device-group-id}/")
    Call<DeviceGroup>
        groupRetrieve(@retrofit2.http.Path(value = "device-group-id", encoded = true) String deviceGroupId);

    /**
     * Modify the attributes of a group. Modify the attributes of a group.
     * 
     * @param deviceGroupId
     *            (required)
     * @param group
     *            Group (required)
     * @return Call&lt;DeviceGroup&gt;
     */
    @PUT("v3/device-groups/{device-group-id}/")
    Call<DeviceGroup> groupUpdate(@retrofit2.http.Path(value = "device-group-id", encoded = true) String deviceGroupId,
                                  @retrofit2.http.Body Group1 group);

    /**
     * Archive a campaign. This command will archive a campaign.
     * 
     * @param campaignId
     *            The campaign ID (required)
     * @return Call&lt;Void&gt;
     */
    @POST("v3/update-campaigns/{campaign_id}/archive")
    Call<Void> updateCampaignArchive(@retrofit2.http.Path(value = "campaign_id", encoded = true) String campaignId);

    /**
     * Create a campaign Create an update campaign.
     * 
     * @param campaign
     *            Update campaign (required)
     * @return Call&lt;UpdateCampaign&gt;
     */
    @POST("v3/update-campaigns/")
    Call<UpdateCampaign> updateCampaignCreate(@retrofit2.http.Body UpdateCampaignPostRequest campaign);

    /**
     * Delete a campaign Delete an update campaign.
     * 
     * @param campaignId
     *            The ID of the update campaign (required)
     * @return Call&lt;Void&gt;
     */
    @DELETE("v3/update-campaigns/{campaign_id}/")
    Call<Void> updateCampaignDestroy(@retrofit2.http.Path(value = "campaign_id", encoded = true) String campaignId);

    /**
     * Get a list of events grouped by summary Get a list of events grouped by summary
     * 
     * @param campaignId
     *            The campaign ID (required)
     * @param summaryStatusId
     *            The summary status. For example, fail (required)
     * @return Call&lt;EventTypeList&gt;
     */
    @GET("v3/update-campaigns/{campaign_id}/statistics/{summary_status_id}/event_types/")
    Call<EventTypeList>
        updateCampaignEventTypesList(@retrofit2.http.Path(value = "campaign_id", encoded = true) String campaignId,
                                     @retrofit2.http.Path(value = "summary_status_id",
                                                          encoded = true) String summaryStatusId);

    /**
     * Get an event type for a campaign Get an event type for a campaign
     * 
     * @param campaignId
     *            The campaign ID (required)
     * @param summaryStatusId
     *            The summary status. For example, fail (required)
     * @param eventTypeId
     *            The event type parameter. For example, UPD4_FAIL_101 (required)
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
     * List all campaigns Get update campaigns for devices specified by a filter.
     * 
     * @param limit
     *            How many objects to retrieve in the page. The minimum limit is 2 and the maximum is 1000. Limit values
     *            outside of this range are set to the closest limit. (optional)
     * @param order
     *            The order of the records. Acceptable values: ASC, DESC. Default: ASC (optional)
     * @param after
     *            The ID of the the item after which to retrieve the next page (optional)
     * @param include
     *            A comma-separated list of data fields to return. Currently supported: total_count (optional)
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
     * @return Call&lt;UpdateCampaignPage&gt;
     */
    @GET("v3/update-campaigns/")
    Call<UpdateCampaignPage>
        updateCampaignList(@retrofit2.http.Query("limit") Integer limit, @retrofit2.http.Query("order") String order,
                           @retrofit2.http.Query("after") String after, @retrofit2.http.Query("include") String include,
                           @retrofit2.http.Query("filter") String filter);

    /**
     * List all campaign device metadata Get campaign device metadata.
     * 
     * @param campaignId
     *            The update campaign ID (required)
     * @param limit
     *            How many objects to retrieve in the page. The minimum limit is 2 and the maximum is 1000. Limit values
     *            outside of this range are set to the closest limit. (optional)
     * @param order
     *            ASC or DESC (optional)
     * @param after
     *            The ID of the the item after which to retrieve the next page (optional)
     * @param include
     *            A comma-separated list of data fields to return. Currently supported: total_count (optional)
     * @return Call&lt;CampaignDeviceMetadataPage&gt;
     */
    @GET("v3/update-campaigns/{campaign_id}/campaign-device-metadata/")
    Call<CampaignDeviceMetadataPage>
        updateCampaignMetadataList(@retrofit2.http.Path(value = "campaign_id", encoded = true) String campaignId,
                                   @retrofit2.http.Query("limit") Integer limit,
                                   @retrofit2.http.Query("order") String order,
                                   @retrofit2.http.Query("after") String after,
                                   @retrofit2.http.Query("include") String include);

    /**
     * Get a campaign device metadata Get update campaign metadata.
     * 
     * @param campaignId
     *            The update campaign ID (required)
     * @param campaignDeviceMetadataId
     *            The campaign device metadata ID (required)
     * @return Call&lt;CampaignDeviceMetadata&gt;
     */
    @GET("v3/update-campaigns/{campaign_id}/campaign-device-metadata/{campaign_device_metadata_id}/")
    Call<CampaignDeviceMetadata>
        updateCampaignMetadataRetrieve(@retrofit2.http.Path(value = "campaign_id", encoded = true) String campaignId,
                                       @retrofit2.http.Path(value = "campaign_device_metadata_id",
                                                            encoded = true) String campaignDeviceMetadataId);

    /**
     * Get campaign metrics Get detailed statistics of a campaign.
     * 
     * @param campaignId
     *            The campaign ID (required)
     * @return Call&lt;CampaignMetrics&gt;
     */
    @GET("v3/update-campaigns/{campaign_id}/metrics")
    Call<CampaignMetrics>
        updateCampaignMetrics(@retrofit2.http.Path(value = "campaign_id", encoded = true) String campaignId);

    /**
     * Get a campaign. Get an update campaign.
     * 
     * @param campaignId
     *            The campaign ID (required)
     * @return Call&lt;UpdateCampaign&gt;
     */
    @GET("v3/update-campaigns/{campaign_id}/")
    Call<UpdateCampaign>
        updateCampaignRetrieve(@retrofit2.http.Path(value = "campaign_id", encoded = true) String campaignId);

    /**
     * Start a campaign. This command will begin the process of starting a campaign.
     * 
     * @param campaignId
     *            The campaign ID (required)
     * @return Call&lt;Void&gt;
     */
    @POST("v3/update-campaigns/{campaign_id}/start")
    Call<Void> updateCampaignStart(@retrofit2.http.Path(value = "campaign_id", encoded = true) String campaignId);

    /**
     * Get a list of statistics for a campaign Get a list of statistics for a campaign
     * 
     * @param campaignId
     *            The campaign ID (required)
     * @return Call&lt;EventTypeSummaryList&gt;
     */
    @GET("v3/update-campaigns/{campaign_id}/statistics/")
    Call<EventTypeSummaryList>
        updateCampaignStatisticsList(@retrofit2.http.Path(value = "campaign_id", encoded = true) String campaignId);

    /**
     * Get a summary status Get a summary status
     * 
     * @param campaignId
     *            The campaign ID (required)
     * @param summaryStatusId
     *            The summary status. For example, fail (required)
     * @return Call&lt;EventTypeSummary&gt;
     */
    @GET("v3/update-campaigns/{campaign_id}/statistics/{summary_status_id}")
    Call<EventTypeSummary>
        updateCampaignStatisticsRetrieve(@retrofit2.http.Path(value = "campaign_id", encoded = true) String campaignId,
                                         @retrofit2.http.Path(value = "summary_status_id",
                                                              encoded = true) String summaryStatusId);

    /**
     * Stop a campaign. This command will begin the process of stopping a campaign.
     * 
     * @param campaignId
     *            The campaign ID (required)
     * @return Call&lt;Void&gt;
     */
    @POST("v3/update-campaigns/{campaign_id}/stop")
    Call<Void> updateCampaignStop(@retrofit2.http.Path(value = "campaign_id", encoded = true) String campaignId);

    /**
     * Modify a campaign Modify an update campaign.
     * 
     * @param campaignId
     *            (required)
     * @param campaign
     *            Update campaign (required)
     * @return Call&lt;UpdateCampaign&gt;
     */
    @PUT("v3/update-campaigns/{campaign_id}/")
    Call<UpdateCampaign>
        updateCampaignUpdate(@retrofit2.http.Path(value = "campaign_id", encoded = true) String campaignId,
                             @retrofit2.http.Body UpdateCampaignPutRequest campaign);

    /**
     * Append a chunks to an upload job Append a chunks to an upload job. To finish a job upload a zero-length chunk.
     * 
     * @param contentMD5
     *            The base64-encoded binary digest of the body (chunk data). (required)
     * @param contentLength
     *            (required)
     * @param uploadJobId
     *            Upload job ID (required)
     * @param chunk
     *            Chunk (optional)
     * @return Call&lt;UploadChunkInfo&gt;
     */
    @Headers({ "Content-Type:binary/octet-stream" })
    @POST("v3/firmware-images/upload-jobs/{upload_job_id}/chunks")
    Call<UploadChunkInfo>
        uploadJobChunkCreate(@retrofit2.http.Header("Content-MD5") String contentMD5,
                             @retrofit2.http.Header("Content-Length") Integer contentLength,
                             @retrofit2.http.Path(value = "upload_job_id", encoded = true) String uploadJobId,
                             @retrofit2.http.Body byte[] chunk);

    /**
     * List all metadata for uploaded chunks List all metadata for uploaded chunks
     * 
     * @param uploadJobId
     *            Upload job (required)
     * @param limit
     *            How many objects to retrieve in the page. The minimum limit is 2 and the maximum is 1000. Limit values
     *            outside of this range are set to the closest limit. (optional)
     * @param order
     *            ASC or DESC (optional)
     * @param after
     *            The ID of the the item after which to retrieve the next page (optional)
     * @param include
     *            A comma-separated list of data fields to return. Currently supported: total_count (optional)
     * @param filter
     *            URL-encoded query string parameter to filter returned data &#x60;?filter&#x3D;{URL-encoded query
     *            string}&#x60; ###### Filterable fields: The table lists all the fields that can be filtered on with
     *            certain filters: &lt;table&gt; &lt;thead&gt; &lt;tr&gt; &lt;th&gt;Field&lt;/th&gt; &lt;th&gt;&#x3D; /
     *            __eq / __neq&lt;/th&gt; &lt;th&gt;__in / __nin&lt;/th&gt; &lt;th&gt;__lte / __gte&lt;/th&gt;
     *            &lt;tr&gt; &lt;thead&gt; &lt;tbody&gt; &lt;tr&gt; &lt;td&gt;created_at&lt;/td&gt;
     *            &lt;td&gt;✓&lt;/td&gt; &lt;td&gt;✓&lt;/td&gt; &lt;td&gt;✓&lt;/td&gt; &lt;/tr&gt; &lt;tr&gt;
     *            &lt;td&gt;etag&lt;/td&gt; &lt;td&gt;✓&lt;/td&gt; &lt;td&gt;✓&lt;/td&gt; &lt;td&gt;✓&lt;/td&gt;
     *            &lt;/tr&gt; &lt;tr&gt; &lt;td&gt;id&lt;/td&gt; &lt;td&gt;✓&lt;/td&gt; &lt;td&gt;✓&lt;/td&gt;
     *            &lt;td&gt;&amp;nbsp;&lt;/td&gt; &lt;/tr&gt; &lt;tr&gt; &lt;td&gt;updated_at&lt;/td&gt;
     *            &lt;td&gt;✓&lt;/td&gt; &lt;td&gt;✓&lt;/td&gt; &lt;td&gt;✓&lt;/td&gt; &lt;/tr&gt; &lt;tr&gt;
     *            &lt;td&gt;hash&lt;/td&gt; &lt;td&gt;✓&lt;/td&gt; &lt;td&gt;✓&lt;/td&gt;
     *            &lt;td&gt;&amp;nbsp;&lt;/td&gt; &lt;/tr&gt; &lt;tr&gt; &lt;td&gt;length&lt;/td&gt;
     *            &lt;td&gt;✓&lt;/td&gt; &lt;td&gt;✓&lt;/td&gt; &lt;td&gt;✓&lt;/td&gt; &lt;/tr&gt; &lt;/tbody&gt;
     *            &lt;/table&gt; &amp;nbsp; The query string is made up of key-value pairs separated by ampersands. For
     *            example, this query: &#x60;key1&#x3D;value1&amp;key2&#x3D;value2&amp;key3&#x3D;value3&#x60; would be
     *            URL-encoded as: &#x60;?filter&#x3D;key1__eq%3Dvalue1%26key2__eq%3Dvalue2%26key3__eq%3Dvalue3&#x60;
     *            **Filtering by properties** &#x60;hash__eq&#x3D;8FS70vXrq5y1VxAAssUMAg&#x3D;&#x3D;&#x60; **Filtering
     *            on date-time fields** Date-time fields should be specified in UTC RFC3339 format,
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
     *            &#x60;status__eq&#x3D;in_progress&amp;created_at__gte&#x3D;2016-11-30T16:25:12.1234Z&amp;created_at__lte&#x3D;2016-12-30T00:00:00Z&#x60;
     *            **Filtering with filter operators** String field filtering supports the following operators: *
     *            equality: &#x60;__eq&#x60; * non-equality: &#x60;__neq&#x60; * in : &#x60;__in&#x60; * not in:
     *            &#x60;__nin&#x60; For &#x60;__in&#x60; and &#x60;__nin&#x60; filters list of parameters must be
     *            comma-separated: &#x60;status__in&#x3D;in_progress,success&#x60; (optional)
     * @return Call&lt;UploadChunkInfoPage&gt;
     */
    @GET("v3/firmware-images/upload-jobs/{upload_job_id}/chunks")
    Call<UploadChunkInfoPage>
        uploadJobChunkList(@retrofit2.http.Path(value = "upload_job_id", encoded = true) String uploadJobId,
                           @retrofit2.http.Query("limit") Integer limit, @retrofit2.http.Query("order") String order,
                           @retrofit2.http.Query("after") String after, @retrofit2.http.Query("include") String include,
                           @retrofit2.http.Query("filter") String filter);

    /**
     * Get metadata about a chunk Get metadata about a chunk
     * 
     * @param uploadJobId
     *            Upload job (required)
     * @param chunkId
     *            Chunk (required)
     * @return Call&lt;UploadChunkInfo&gt;
     */
    @GET("v3/firmware-images/upload-jobs/{upload_job_id}/chunks/{chunk_id}")
    Call<UploadChunkInfo>
        uploadJobChunkRetreive(@retrofit2.http.Path(value = "upload_job_id", encoded = true) String uploadJobId,
                               @retrofit2.http.Path(value = "chunk_id", encoded = true) String chunkId);

    /**
     * Create a new upload job Create a new upload job
     * 
     * @param uploadJob
     *            Upload job (required)
     * @return Call&lt;UploadJob&gt;
     */
    @POST("v3/firmware-images/upload-jobs")
    Call<UploadJob> uploadJobCreate(@retrofit2.http.Body UploadJob uploadJob);

    /**
     * Delete an upload job Delete an upload job
     * 
     * @param uploadJobId
     *            Upload job (required)
     * @return Call&lt;Void&gt;
     */
    @DELETE("v3/firmware-images/upload-jobs/{upload_job_id}")
    Call<Void> uploadJobDelete(@retrofit2.http.Path(value = "upload_job_id", encoded = true) String uploadJobId);

    /**
     * Get all upload jobs Get all upload jobs
     * 
     * @param limit
     *            How many objects to retrieve in the page. The minimum limit is 2 and the maximum is 1000. Limit values
     *            outside of this range are set to the closest limit. (optional)
     * @param order
     *            ASC or DESC (optional)
     * @param after
     *            The ID of the the item after which to retrieve the next page (optional)
     * @param include
     *            A comma-separated list of data fields to return. Currently supported: total_count (optional)
     * @param filter
     *            URL-encoded query string parameter to filter returned data &#x60;?filter&#x3D;{URL-encoded query
     *            string}&#x60; ###### Filterable fields: The table lists all the fields that can be filtered on with
     *            certain filters: &lt;table&gt; &lt;thead&gt; &lt;tr&gt; &lt;th&gt;Field&lt;/th&gt; &lt;th&gt;&#x3D; /
     *            __eq / __neq&lt;/th&gt; &lt;th&gt;__in / __nin&lt;/th&gt; &lt;th&gt;__lte / __gte&lt;/th&gt;
     *            &lt;tr&gt; &lt;thead&gt; &lt;tbody&gt; &lt;tr&gt; &lt;td&gt;name&lt;/td&gt; &lt;td&gt;✓&lt;/td&gt;
     *            &lt;td&gt;✓&lt;/td&gt; &lt;td&gt;&amp;nbsp;&lt;/td&gt; &lt;/tr&gt; &lt;tr&gt;
     *            &lt;td&gt;description&lt;/td&gt; &lt;td&gt;✓&lt;/td&gt; &lt;td&gt;✓&lt;/td&gt;
     *            &lt;td&gt;&amp;nbsp;&lt;/td&gt; &lt;/tr&gt; &lt;tr&gt; &lt;td&gt;complete&lt;/td&gt;
     *            &lt;td&gt;✓&lt;/td&gt; &lt;td&gt;✓&lt;/td&gt; &lt;/tr&gt; &lt;tr&gt; &lt;td&gt;id&lt;/td&gt;
     *            &lt;td&gt;✓&lt;/td&gt; &lt;td&gt;✓&lt;/td&gt; &lt;td&gt;&amp;nbsp;&lt;/td&gt; &lt;/tr&gt;
     *            &lt;tr&gt; &lt;td&gt;firmware_image_id&lt;/td&gt; &lt;td&gt;✓&lt;/td&gt; &lt;td&gt;✓&lt;/td&gt;
     *            &lt;td&gt;&amp;nbsp;&lt;/td&gt; &lt;/tr&gt; &lt;tr&gt; &lt;td&gt;status&lt;/td&gt;
     *            &lt;td&gt;✓&lt;/td&gt; &lt;td&gt;✓&lt;/td&gt; &lt;td&gt;&amp;nbsp;&lt;/td&gt; &lt;/tr&gt;
     *            &lt;tr&gt; &lt;td&gt;created_at&lt;/td&gt; &lt;td&gt;✓&lt;/td&gt; &lt;td&gt;✓&lt;/td&gt;
     *            &lt;td&gt;✓&lt;/td&gt; &lt;/tr&gt; &lt;tr&gt; &lt;td&gt;etag&lt;/td&gt; &lt;td&gt;✓&lt;/td&gt;
     *            &lt;td&gt;✓&lt;/td&gt; &lt;td&gt;✓&lt;/td&gt; &lt;/tr&gt; &lt;tr&gt;
     *            &lt;td&gt;updated_at&lt;/td&gt; &lt;td&gt;✓&lt;/td&gt; &lt;td&gt;✓&lt;/td&gt;
     *            &lt;td&gt;✓&lt;/td&gt; &lt;/tr&gt; &lt;/tbody&gt; &lt;/table&gt; &amp;nbsp; The query string is made
     *            up of key-value pairs separated by ampersands. For example, this query:
     *            &#x60;key1&#x3D;value1&amp;key2&#x3D;value2&amp;key3&#x3D;value3&#x60; would be URL-encoded as:
     *            &#x60;?filter&#x3D;key1__eq%3Dvalue1%26key2__eq%3Dvalue2%26key3__eq%3Dvalue3&#x60; **Filtering by
     *            properties** &#x60;name__eq&#x3D;myimage&#x60; **Filtering on date-time fields** Date-time fields
     *            should be specified in UTC RFC3339 format, &#x60;YYYY-MM-DDThh:mm:ss.msZ&#x60;. There are three
     *            permitted variations: * UTC RFC3339 with milliseconds. Example: &#x60;2016-11-30T16:25:12.1234Z&#x60;
     *            * UTC RFC3339 without milliseconds. Example: &#x60;2016-11-30T16:25:12Z&#x60; * UTC RFC3339 shortened
     *            without milliseconds and punctuation. Example: &#x60;20161130T162512Z&#x60; Date-time filtering
     *            supports three operators: * equality by appending &#x60;__eq&#x60; to the field name * greater than or
     *            equal to by appending &#x60;__gte&#x60; to the field name * less than or equal to by appending
     *            &#x60;__lte&#x60; to the field name &#x60;{field name}[|__eq|__lte|__gte]&#x3D;{UTC RFC3339
     *            date-time}&#x60; Time ranges may be specified by including both the &#x60;__gte&#x60; and
     *            &#x60;__lte&#x60; forms in the filter. For example:
     *            &#x60;created_at__gte&#x3D;2016-11-30T16:25:12.1234Z&amp;created_at__lte&#x3D;2016-12-30T00:00:00Z&#x60;
     *            **Filtering on multiple fields**
     *            &#x60;name__eq&#x3D;myimage&amp;created_at__gte&#x3D;2016-11-30T16:25:12.1234Z&amp;created_at__lte&#x3D;2016-12-30T00:00:00Z&#x60;
     *            **Filtering with filter operators** String field filtering supports the following operators: *
     *            equality: &#x60;__eq&#x60; * non-equality: &#x60;__neq&#x60; * in : &#x60;__in&#x60; * not in:
     *            &#x60;__nin&#x60; For &#x60;__in&#x60; and &#x60;__nin&#x60; filters list of parameters must be
     *            comma-separated: &#x60;name__in&#x3D;fw-image1,fw-image2&#x60; (optional)
     * @return Call&lt;UploadJobPage&gt;
     */
    @GET("v3/firmware-images/upload-jobs")
    Call<UploadJobPage>
        uploadJobList(@retrofit2.http.Query("limit") Integer limit, @retrofit2.http.Query("order") String order,
                      @retrofit2.http.Query("after") String after, @retrofit2.http.Query("include") String include,
                      @retrofit2.http.Query("filter") String filter);

    /**
     * Get an upload job Get an upload job
     * 
     * @param uploadJobId
     *            Upload job (required)
     * @return Call&lt;UploadJob&gt;
     */
    @GET("v3/firmware-images/upload-jobs/{upload_job_id}")
    Call<UploadJob> uploadJobRetrieve(@retrofit2.http.Path(value = "upload_job_id", encoded = true) String uploadJobId);

    /**
     * Update an upload job Update an upload job
     * 
     * @param uploadJobId
     *            Upload job id (required)
     * @param uploadJob
     *            Upload job (required)
     * @return Call&lt;UploadJob&gt;
     */
    @PUT("v3/firmware-images/upload-jobs/{upload_job_id}")
    Call<UploadJob> uploadJobUpdate(@retrofit2.http.Path(value = "upload_job_id", encoded = true) String uploadJobId,
                                    @retrofit2.http.Body UploadJob1 uploadJob);

}
