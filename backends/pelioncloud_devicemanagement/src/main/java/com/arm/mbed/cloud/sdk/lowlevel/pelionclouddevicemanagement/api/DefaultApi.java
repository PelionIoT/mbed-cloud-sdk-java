package com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api;

import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.CollectionFormats.*;

import retrofit2.Call;
import retrofit2.http.*;

import okhttp3.MultipartBody;

import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.BillingReportRawDataResponse;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.CampaignDeviceMetadata;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.CampaignDeviceMetadataPage;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.CampaignMetrics;
import org.joda.time.DateTime;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.EventType;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.EventTypeList;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.EventTypeSummary;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.EventTypeSummaryList;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.FirmwareImage;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.FirmwareImagePage;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.FirmwareManifest;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.FirmwareManifestPage;
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
     *            &lt;td&gt;&amp;nbsp;&lt;/td&gt; &lt;/tr&gt; &lt;tr&gt; &lt;td&gt;updated_at&lt;/td&gt;
     *            &lt;td&gt;✓&lt;/td&gt; &lt;td&gt;✓&lt;/td&gt; &lt;td&gt;✓&lt;/td&gt; &lt;/tr&gt; &lt;/tbody&gt;
     *            &lt;/table&gt; &amp;nbsp; The query string is made up of key-value pairs separated by ampersands. For
     *            example, this query: &#x60;key1&#x3D;value1&amp;key2&#x3D;value2&amp;key3&#x3D;value3&#x60; would be
     *            URL-encoded as: &#x60;?filter&#x3D;key1__eq%3Dvalue1%26key2__eq%3Dvalue2%26key3__eq%3Dvalue3&#x60;
     *            **Filtering by properties** &#x60;name__eq&#x3D;myimage&#x60; **Filtering on date-time fields**
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
     *            &#x60;name__eq&#x3D;myimage&amp;created_at__gte&#x3D;2016-11-30T16:25:12.1234Z&amp;created_at__lte&#x3D;2016-12-30T00:00:00Z&#x60;
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
     * @param datafileEq
     *            eq filter for the \&quot;datafile\&quot; field (optional)
     * @param datafileNeq
     *            neq filter for the \&quot;datafile\&quot; field (optional)
     * @param datafileIn
     *            in filter for the \&quot;datafile\&quot; field (optional)
     * @param datafileNin
     *            nin filter for the \&quot;datafile\&quot; field (optional)
     * @param datafileChecksumEq
     *            eq filter for the \&quot;datafile_checksum\&quot; field (optional)
     * @param datafileChecksumNeq
     *            neq filter for the \&quot;datafile_checksum\&quot; field (optional)
     * @param datafileChecksumIn
     *            in filter for the \&quot;datafile_checksum\&quot; field (optional)
     * @param datafileChecksumNin
     *            nin filter for the \&quot;datafile_checksum\&quot; field (optional)
     * @param datafileSizeEq
     *            eq filter for the \&quot;datafile_size\&quot; field (optional)
     * @param datafileSizeNeq
     *            neq filter for the \&quot;datafile_size\&quot; field (optional)
     * @param datafileSizeIn
     *            in filter for the \&quot;datafile_size\&quot; field (optional)
     * @param datafileSizeNin
     *            nin filter for the \&quot;datafile_size\&quot; field (optional)
     * @param descriptionEq
     *            eq filter for the \&quot;description\&quot; field (optional)
     * @param descriptionNeq
     *            neq filter for the \&quot;description\&quot; field (optional)
     * @param descriptionIn
     *            in filter for the \&quot;description\&quot; field (optional)
     * @param descriptionNin
     *            nin filter for the \&quot;description\&quot; field (optional)
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
     * @param updatedAtIn
     *            in filter for the \&quot;updated_at\&quot; field (optional)
     * @param updatedAtNin
     *            nin filter for the \&quot;updated_at\&quot; field (optional)
     * @param updatedAtLte
     *            lte filter for the \&quot;updated_at\&quot; field (optional)
     * @param updatedAtGte
     *            gte filter for the \&quot;updated_at\&quot; field (optional)
     * @return Call&lt;FirmwareImagePage&gt;
     */
    @GET("v3/firmware-images/")
    Call<FirmwareImagePage>
        firmwareImageList(@retrofit2.http.Query("limit") Integer limit, @retrofit2.http.Query("order") String order,
                          @retrofit2.http.Query("after") String after, @retrofit2.http.Query("include") String include,
                          @retrofit2.http.Query("filter") String filter,
                          @retrofit2.http.Query("created_at__in") String createdAtIn,
                          @retrofit2.http.Query("created_at__nin") String createdAtNin,
                          @retrofit2.http.Query("created_at__lte") DateTime createdAtLte,
                          @retrofit2.http.Query("created_at__gte") DateTime createdAtGte,
                          @retrofit2.http.Query("datafile__eq") String datafileEq,
                          @retrofit2.http.Query("datafile__neq") String datafileNeq,
                          @retrofit2.http.Query("datafile__in") String datafileIn,
                          @retrofit2.http.Query("datafile__nin") String datafileNin,
                          @retrofit2.http.Query("datafile_checksum__eq") String datafileChecksumEq,
                          @retrofit2.http.Query("datafile_checksum__neq") String datafileChecksumNeq,
                          @retrofit2.http.Query("datafile_checksum__in") String datafileChecksumIn,
                          @retrofit2.http.Query("datafile_checksum__nin") String datafileChecksumNin,
                          @retrofit2.http.Query("datafile_size__eq") Long datafileSizeEq,
                          @retrofit2.http.Query("datafile_size__neq") Long datafileSizeNeq,
                          @retrofit2.http.Query("datafile_size__in") String datafileSizeIn,
                          @retrofit2.http.Query("datafile_size__nin") String datafileSizeNin,
                          @retrofit2.http.Query("description__eq") String descriptionEq,
                          @retrofit2.http.Query("description__neq") String descriptionNeq,
                          @retrofit2.http.Query("description__in") String descriptionIn,
                          @retrofit2.http.Query("description__nin") String descriptionNin,
                          @retrofit2.http.Query("id__eq") String idEq, @retrofit2.http.Query("id__neq") String idNeq,
                          @retrofit2.http.Query("id__in") String idIn, @retrofit2.http.Query("id__nin") String idNin,
                          @retrofit2.http.Query("name__eq") String nameEq,
                          @retrofit2.http.Query("name__neq") String nameNeq,
                          @retrofit2.http.Query("name__in") String nameIn,
                          @retrofit2.http.Query("name__nin") String nameNin,
                          @retrofit2.http.Query("updated_at__in") String updatedAtIn,
                          @retrofit2.http.Query("updated_at__nin") String updatedAtNin,
                          @retrofit2.http.Query("updated_at__lte") DateTime updatedAtLte,
                          @retrofit2.http.Query("updated_at__gte") DateTime updatedAtGte);

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
     * @param createdAtIn
     *            in filter for the \&quot;created_at\&quot; field (optional)
     * @param createdAtNin
     *            nin filter for the \&quot;created_at\&quot; field (optional)
     * @param createdAtLte
     *            lte filter for the \&quot;created_at\&quot; field (optional)
     * @param createdAtGte
     *            gte filter for the \&quot;created_at\&quot; field (optional)
     * @param datafileEq
     *            eq filter for the \&quot;datafile\&quot; field (optional)
     * @param datafileNeq
     *            neq filter for the \&quot;datafile\&quot; field (optional)
     * @param datafileIn
     *            in filter for the \&quot;datafile\&quot; field (optional)
     * @param datafileNin
     *            nin filter for the \&quot;datafile\&quot; field (optional)
     * @param datafileSizeEq
     *            eq filter for the \&quot;datafile_size\&quot; field (optional)
     * @param datafileSizeNeq
     *            neq filter for the \&quot;datafile_size\&quot; field (optional)
     * @param datafileSizeIn
     *            in filter for the \&quot;datafile_size\&quot; field (optional)
     * @param datafileSizeNin
     *            nin filter for the \&quot;datafile_size\&quot; field (optional)
     * @param descriptionEq
     *            eq filter for the \&quot;description\&quot; field (optional)
     * @param descriptionNeq
     *            neq filter for the \&quot;description\&quot; field (optional)
     * @param descriptionIn
     *            in filter for the \&quot;description\&quot; field (optional)
     * @param descriptionNin
     *            nin filter for the \&quot;description\&quot; field (optional)
     * @param deviceClassEq
     *            eq filter for the \&quot;device_class\&quot; field (optional)
     * @param deviceClassNeq
     *            neq filter for the \&quot;device_class\&quot; field (optional)
     * @param deviceClassIn
     *            in filter for the \&quot;device_class\&quot; field (optional)
     * @param deviceClassNin
     *            nin filter for the \&quot;device_class\&quot; field (optional)
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
     * @param timestampIn
     *            in filter for the \&quot;timestamp\&quot; field (optional)
     * @param timestampNin
     *            nin filter for the \&quot;timestamp\&quot; field (optional)
     * @param timestampLte
     *            lte filter for the \&quot;timestamp\&quot; field (optional)
     * @param timestampGte
     *            gte filter for the \&quot;timestamp\&quot; field (optional)
     * @param updatedAtIn
     *            in filter for the \&quot;updated_at\&quot; field (optional)
     * @param updatedAtNin
     *            nin filter for the \&quot;updated_at\&quot; field (optional)
     * @param updatedAtLte
     *            lte filter for the \&quot;updated_at\&quot; field (optional)
     * @param updatedAtGte
     *            gte filter for the \&quot;updated_at\&quot; field (optional)
     * @return Call&lt;FirmwareManifestPage&gt;
     */
    @GET("v3/firmware-manifests/")
    Call<FirmwareManifestPage>
        firmwareManifestList(@retrofit2.http.Query("limit") Integer limit, @retrofit2.http.Query("order") String order,
                             @retrofit2.http.Query("after") String after,
                             @retrofit2.http.Query("include") String include,
                             @retrofit2.http.Query("filter") String filter,
                             @retrofit2.http.Query("created_at__in") String createdAtIn,
                             @retrofit2.http.Query("created_at__nin") String createdAtNin,
                             @retrofit2.http.Query("created_at__lte") DateTime createdAtLte,
                             @retrofit2.http.Query("created_at__gte") DateTime createdAtGte,
                             @retrofit2.http.Query("datafile__eq") String datafileEq,
                             @retrofit2.http.Query("datafile__neq") String datafileNeq,
                             @retrofit2.http.Query("datafile__in") String datafileIn,
                             @retrofit2.http.Query("datafile__nin") String datafileNin,
                             @retrofit2.http.Query("datafile_size__eq") Long datafileSizeEq,
                             @retrofit2.http.Query("datafile_size__neq") Long datafileSizeNeq,
                             @retrofit2.http.Query("datafile_size__in") String datafileSizeIn,
                             @retrofit2.http.Query("datafile_size__nin") String datafileSizeNin,
                             @retrofit2.http.Query("description__eq") String descriptionEq,
                             @retrofit2.http.Query("description__neq") String descriptionNeq,
                             @retrofit2.http.Query("description__in") String descriptionIn,
                             @retrofit2.http.Query("description__nin") String descriptionNin,
                             @retrofit2.http.Query("device_class__eq") String deviceClassEq,
                             @retrofit2.http.Query("device_class__neq") String deviceClassNeq,
                             @retrofit2.http.Query("device_class__in") String deviceClassIn,
                             @retrofit2.http.Query("device_class__nin") String deviceClassNin,
                             @retrofit2.http.Query("id__eq") String idEq, @retrofit2.http.Query("id__neq") String idNeq,
                             @retrofit2.http.Query("id__in") String idIn, @retrofit2.http.Query("id__nin") String idNin,
                             @retrofit2.http.Query("name__eq") String nameEq,
                             @retrofit2.http.Query("name__neq") String nameNeq,
                             @retrofit2.http.Query("name__in") String nameIn,
                             @retrofit2.http.Query("name__nin") String nameNin,
                             @retrofit2.http.Query("timestamp__in") String timestampIn,
                             @retrofit2.http.Query("timestamp__nin") String timestampNin,
                             @retrofit2.http.Query("timestamp__lte") DateTime timestampLte,
                             @retrofit2.http.Query("timestamp__gte") DateTime timestampGte,
                             @retrofit2.http.Query("updated_at__in") String updatedAtIn,
                             @retrofit2.http.Query("updated_at__nin") String updatedAtNin,
                             @retrofit2.http.Query("updated_at__lte") DateTime updatedAtLte,
                             @retrofit2.http.Query("updated_at__gte") DateTime updatedAtGte);

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
     * **Example:** &#x60;&#x60;&#x60; curl -X GET
     * https://api.us-east-1.mbedcloud.com/v3/billing-report?month&#x3D;2018-07 \\ -H &#39;Authorization: Bearer
     * &lt;api_key&gt;&#39; &#x60;&#x60;&#x60;
     * 
     * @param month
     *            Queried year and month of billing report. (required)
     * @return Call&lt;ReportResponse&gt;
     */
    @GET("v3/billing-report")
    Call<ReportResponse> getBillingReport(@retrofit2.http.Query("month") String month);

    /**
     * Get raw billing data of the active devices for the month. Fetch raw billing data for active devices for the
     * currently authenticated commercial non-subtenant account. This is supplementary data for the billing report. The
     * raw billing data of the active devices for subtenant accounts are included in their aggregator&#39;s raw billing
     * data of the active devices. The endpoint returns the URL to download the gzipped CSV file. The first line is the
     * header providing information on active devices, for example, the ID of an active device. **Example:**
     * &#x60;&#x60;&#x60; curl -X GET
     * https://api.us-east-1.mbedcloud.com/v3/billing-report-active-devices?month&#x3D;2018-07 \\ -H &#39;Authorization:
     * Bearer &lt;api_key&gt;&#39; &#x60;&#x60;&#x60;
     * 
     * @param month
     *            Queried year and month of billing report. (required)
     * @return Call&lt;BillingReportRawDataResponse&gt;
     */
    @GET("v3/billing-report-active-devices")
    Call<BillingReportRawDataResponse> getBillingReportActiveDevices(@retrofit2.http.Query("month") String month);

    /**
     * Get raw billing data of the firmware updates for the month. Fetch raw billing data for firmware updates for the
     * currently authenticated commercial non-subtenant account. This is supplementary data for the billing report. The
     * raw billing data of the firmware updates for subtenant accounts are included in their aggregator&#39;s raw
     * billing data of the firmware updates. The endpoint returns the URL to download the gzipped CSV file. The first
     * line is the header providing information on the firmware updates, for example, the ID of a firmware update.
     * **Example:** &#x60;&#x60;&#x60; curl -X GET
     * https://api.us-east-1.mbedcloud.com/v3/billing-report-firmware-updates?month&#x3D;2018-07 \\ -H
     * &#39;Authorization: Bearer &lt;api_key&gt;&#39; &#x60;&#x60;&#x60;
     * 
     * @param month
     *            Queried year and month of billing report. (required)
     * @return Call&lt;BillingReportRawDataResponse&gt;
     */
    @GET("v3/billing-report-firmware-updates")
    Call<BillingReportRawDataResponse> getBillingReportFirmwareUpdates(@retrofit2.http.Query("month") String month);

    /**
     * Service package quota. Get the available firmware update quota for the current authenticated commercial account.
     * **Example:** &#x60;&#x60;&#x60; curl -X GET https://api.us-east-1.mbedcloud.com/v3/service-packages-quota \\ -H
     * &#39;Authorization: Bearer &lt;api_key&gt;&#39; &#x60;&#x60;&#x60;
     * 
     * @return Call&lt;ServicePackageQuota&gt;
     */
    @GET("v3/service-packages-quota")
    Call<ServicePackageQuota> getServicePackageQuota();

    /**
     * Service package quota history. Get your quota usage history. This API is available only for commercial accounts.
     * Aggregator accounts can see their own and subtenant quota usage data. Data is in ascending order based on the
     * added timestamp. **Example:** &#x60;&#x60;&#x60; curl -X GET
     * https://api.us-east-1.mbedcloud.com/v3/service-packages-quota-history \\ -H &#39;Authorization: Bearer
     * &lt;api_key&gt;&#39; &#x60;&#x60;&#x60;
     * 
     * @param limit
     *            Maximum number of quota history entries contained in one paged response. (optional)
     * @param after
     *            Results after specified entry ID. (optional)
     * @return Call&lt;ServicePackageQuotaHistoryResponse&gt;
     */
    @GET("v3/service-packages-quota-history")
    Call<ServicePackageQuotaHistoryResponse> getServicePackageQuotaHistory(@retrofit2.http.Query("limit") Integer limit,
                                                                           @retrofit2.http.Query("after") String after);

    /**
     * Get all service packages. Get information for all service packages for the current authenticated commercial
     * account. The response is returned in descending order by service package created timestamp: first the pending
     * service package, then the active service package, then the previous service packages. **Example:**
     * &#x60;&#x60;&#x60; curl -X GET https://api.us-east-1.mbedcloud.com/v3/service-packages \\ -H &#39;Authorization:
     * Bearer &lt;api_key&gt;&#39; &#x60;&#x60;&#x60;
     * 
     * @return Call&lt;ServicePackagesResponse&gt;
     */
    @GET("v3/service-packages")
    Call<ServicePackagesResponse> getServicePackages();

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
    @GET("v3/update-campaigns/")
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
        uploadJobChunkCreate(@retrofit2.http.Header("Content-MD5") byte[] contentMD5,
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
     * @param createdAtIn
     *            in filter for the \&quot;created_at\&quot; field (optional)
     * @param createdAtNin
     *            nin filter for the \&quot;created_at\&quot; field (optional)
     * @param createdAtLte
     *            lte filter for the \&quot;created_at\&quot; field (optional)
     * @param createdAtGte
     *            gte filter for the \&quot;created_at\&quot; field (optional)
     * @param idEq
     *            eq filter for the \&quot;id\&quot; field (optional)
     * @param idNeq
     *            neq filter for the \&quot;id\&quot; field (optional)
     * @param idIn
     *            in filter for the \&quot;id\&quot; field (optional)
     * @param idNin
     *            nin filter for the \&quot;id\&quot; field (optional)
     * @param updatedAtIn
     *            in filter for the \&quot;updated_at\&quot; field (optional)
     * @param updatedAtNin
     *            nin filter for the \&quot;updated_at\&quot; field (optional)
     * @param updatedAtLte
     *            lte filter for the \&quot;updated_at\&quot; field (optional)
     * @param updatedAtGte
     *            gte filter for the \&quot;updated_at\&quot; field (optional)
     * @param hashEq
     *            eq filter for the \&quot;hash\&quot; field (optional)
     * @param hashNeq
     *            neq filter for the \&quot;hash\&quot; field (optional)
     * @param hashIn
     *            in filter for the \&quot;hash\&quot; field (optional)
     * @param hashNin
     *            nin filter for the \&quot;hash\&quot; field (optional)
     * @param lengthEq
     *            eq filter for the \&quot;length\&quot; field (optional)
     * @param lengthNeq
     *            neq filter for the \&quot;length\&quot; field (optional)
     * @param lengthIn
     *            in filter for the \&quot;length\&quot; field (optional)
     * @param lengthNin
     *            nin filter for the \&quot;length\&quot; field (optional)
     * @param lengthLte
     *            lte filter for the \&quot;length\&quot; field (optional)
     * @param lengthGte
     *            gte filter for the \&quot;length\&quot; field (optional)
     * @return Call&lt;UploadChunkInfoPage&gt;
     */
    @GET("v3/firmware-images/upload-jobs/{upload_job_id}/chunks")
    Call<UploadChunkInfoPage>
        uploadJobChunkList(@retrofit2.http.Path(value = "upload_job_id", encoded = true) String uploadJobId,
                           @retrofit2.http.Query("limit") Integer limit, @retrofit2.http.Query("order") String order,
                           @retrofit2.http.Query("after") String after, @retrofit2.http.Query("include") String include,
                           @retrofit2.http.Query("filter") String filter,
                           @retrofit2.http.Query("created_at__in") String createdAtIn,
                           @retrofit2.http.Query("created_at__nin") String createdAtNin,
                           @retrofit2.http.Query("created_at__lte") DateTime createdAtLte,
                           @retrofit2.http.Query("created_at__gte") DateTime createdAtGte,
                           @retrofit2.http.Query("id__eq") Integer idEq, @retrofit2.http.Query("id__neq") Integer idNeq,
                           @retrofit2.http.Query("id__in") String idIn, @retrofit2.http.Query("id__nin") String idNin,
                           @retrofit2.http.Query("updated_at__in") String updatedAtIn,
                           @retrofit2.http.Query("updated_at__nin") String updatedAtNin,
                           @retrofit2.http.Query("updated_at__lte") DateTime updatedAtLte,
                           @retrofit2.http.Query("updated_at__gte") DateTime updatedAtGte,
                           @retrofit2.http.Query("hash__eq") String hashEq,
                           @retrofit2.http.Query("hash__neq") String hashNeq,
                           @retrofit2.http.Query("hash__in") String hashIn,
                           @retrofit2.http.Query("hash__nin") String hashNin,
                           @retrofit2.http.Query("length__eq") Integer lengthEq,
                           @retrofit2.http.Query("length__neq") Integer lengthNeq,
                           @retrofit2.http.Query("length__in") String lengthIn,
                           @retrofit2.http.Query("length__nin") String lengthNin,
                           @retrofit2.http.Query("length__lte") Integer lengthLte,
                           @retrofit2.http.Query("length__gte") Integer lengthGte);

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
     * @param updatedAtIn
     *            in filter for the \&quot;updated_at\&quot; field (optional)
     * @param updatedAtNin
     *            nin filter for the \&quot;updated_at\&quot; field (optional)
     * @param updatedAtLte
     *            lte filter for the \&quot;updated_at\&quot; field (optional)
     * @param updatedAtGte
     *            gte filter for the \&quot;updated_at\&quot; field (optional)
     * @param nameEq
     *            eq filter for the \&quot;name\&quot; field (optional)
     * @param nameNeq
     *            neq filter for the \&quot;name\&quot; field (optional)
     * @param nameIn
     *            in filter for the \&quot;name\&quot; field (optional)
     * @param nameNin
     *            nin filter for the \&quot;name\&quot; field (optional)
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
     * @param idEq
     *            eq filter for the \&quot;id\&quot; field (optional)
     * @param idNeq
     *            neq filter for the \&quot;id\&quot; field (optional)
     * @param idIn
     *            in filter for the \&quot;id\&quot; field (optional)
     * @param idNin
     *            nin filter for the \&quot;id\&quot; field (optional)
     * @param completeEq
     *            eq filter for the \&quot;complete\&quot; field (optional)
     * @param completeNeq
     *            neq filter for the \&quot;complete\&quot; field (optional)
     * @param statusEq
     *            eq filter for the \&quot;status\&quot; field (optional)
     * @param statusNeq
     *            neq filter for the \&quot;status\&quot; field (optional)
     * @param statusIn
     *            in filter for the \&quot;status\&quot; field (optional)
     * @param statusNin
     *            nin filter for the \&quot;status\&quot; field (optional)
     * @return Call&lt;UploadJobPage&gt;
     */
    @GET("v3/firmware-images/upload-jobs")
    Call<UploadJobPage>
        uploadJobList(@retrofit2.http.Query("limit") Integer limit, @retrofit2.http.Query("order") String order,
                      @retrofit2.http.Query("after") String after, @retrofit2.http.Query("include") String include,
                      @retrofit2.http.Query("filter") String filter,
                      @retrofit2.http.Query("updated_at__in") String updatedAtIn,
                      @retrofit2.http.Query("updated_at__nin") String updatedAtNin,
                      @retrofit2.http.Query("updated_at__lte") DateTime updatedAtLte,
                      @retrofit2.http.Query("updated_at__gte") DateTime updatedAtGte,
                      @retrofit2.http.Query("name__eq") String nameEq,
                      @retrofit2.http.Query("name__neq") String nameNeq,
                      @retrofit2.http.Query("name__in") String nameIn,
                      @retrofit2.http.Query("name__nin") String nameNin,
                      @retrofit2.http.Query("created_at__in") String createdAtIn,
                      @retrofit2.http.Query("created_at__nin") String createdAtNin,
                      @retrofit2.http.Query("created_at__lte") DateTime createdAtLte,
                      @retrofit2.http.Query("created_at__gte") DateTime createdAtGte,
                      @retrofit2.http.Query("description__eq") String descriptionEq,
                      @retrofit2.http.Query("description__neq") String descriptionNeq,
                      @retrofit2.http.Query("description__in") String descriptionIn,
                      @retrofit2.http.Query("description__nin") String descriptionNin,
                      @retrofit2.http.Query("id__eq") String idEq, @retrofit2.http.Query("id__neq") String idNeq,
                      @retrofit2.http.Query("id__in") String idIn, @retrofit2.http.Query("id__nin") String idNin,
                      @retrofit2.http.Query("complete__eq") Boolean completeEq,
                      @retrofit2.http.Query("complete__neq") Boolean completeNeq,
                      @retrofit2.http.Query("status__eq") String statusEq,
                      @retrofit2.http.Query("status__neq") String statusNeq,
                      @retrofit2.http.Query("status__in") String statusIn,
                      @retrofit2.http.Query("status__nin") String statusNin);

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
