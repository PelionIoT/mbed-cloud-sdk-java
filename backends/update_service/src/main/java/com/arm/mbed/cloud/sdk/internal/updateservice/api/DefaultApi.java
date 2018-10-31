package com.arm.mbed.cloud.sdk.internal.updateservice.api;

import com.arm.mbed.cloud.sdk.internal.updateservice.CollectionFormats.*;

import retrofit2.Call;
import retrofit2.http.*;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import okhttp3.MultipartBody;

import com.arm.mbed.cloud.sdk.internal.updateservice.model.CampaignDeviceMetadata;
import com.arm.mbed.cloud.sdk.internal.updateservice.model.CampaignDeviceMetadataPage;
import com.arm.mbed.cloud.sdk.internal.updateservice.model.CampaignMetrics;
import com.arm.mbed.cloud.sdk.internal.updateservice.model.ErrorResponse;
import java.io.File;
import com.arm.mbed.cloud.sdk.internal.updateservice.model.FirmwareImage;
import com.arm.mbed.cloud.sdk.internal.updateservice.model.FirmwareImagePage;
import com.arm.mbed.cloud.sdk.internal.updateservice.model.FirmwareManifest;
import com.arm.mbed.cloud.sdk.internal.updateservice.model.FirmwareManifestPage;
import com.arm.mbed.cloud.sdk.internal.updateservice.model.UpdateCampaign;
import com.arm.mbed.cloud.sdk.internal.updateservice.model.UpdateCampaignPage;
import com.arm.mbed.cloud.sdk.internal.updateservice.model.UpdateCampaignPostRequest;
import com.arm.mbed.cloud.sdk.internal.updateservice.model.UpdateCampaignPutRequest;
import com.arm.mbed.cloud.sdk.internal.updateservice.model.UploadChunkInfo;
import com.arm.mbed.cloud.sdk.internal.updateservice.model.UploadChunkInfoPage;
import com.arm.mbed.cloud.sdk.internal.updateservice.model.UploadJob;
import com.arm.mbed.cloud.sdk.internal.updateservice.model.UploadJob1;
import com.arm.mbed.cloud.sdk.internal.updateservice.model.UploadJobPage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface DefaultApi {
  /**
   * Create an image
   * Create a firmware image.
   * @param datafile The firmware image file to upload (required)
   * @param name The name of the firmware image (required)
   * @param description The description of the firmware image (optional)
   * @return Call&lt;FirmwareImage&gt;
   */
  @retrofit2.http.Multipart
  @POST("v3/firmware-images/")
  Call<FirmwareImage> firmwareImageCreate(
    @retrofit2.http.Part() MultipartBody.Part datafile, @retrofit2.http.Part("name") String name, @retrofit2.http.Part("description") String description
  );

  /**
   * Delete an image
   * Delete a firmware image.
   * @param imageId The firmware image ID (required)
   * @return Call&lt;Void&gt;
   */
  @DELETE("v3/firmware-images/{image_id}/")
  Call<Void> firmwareImageDestroy(
    @retrofit2.http.Path(value = "image_id", encoded = true) String imageId
  );

  /**
   * List all images
   * List all firmware images.
   * @param limit How many objects to retrieve in the page. The minimum limit is 2 and the maximum is 1000. Limit values outside of this range are set to the closest limit. (optional)
   * @param order ASC or DESC (optional)
   * @param after The ID of the the item after which to retrieve the next page (optional)
   * @param include A comma-separated list of data fields to return. Currently supported: total_count (optional)
   * @param filter URL-encoded query string parameter to filter returned data  &#x60;?filter&#x3D;{URL-encoded query string}&#x60;  ###### Filterable fields:  The table lists all the fields that can be filtered on with certain filters:  &lt;table&gt;   &lt;thead&gt;     &lt;tr&gt;       &lt;th&gt;Field&lt;/th&gt;       &lt;th&gt;&#x3D; / __eq / __neq&lt;/th&gt;       &lt;th&gt;__in /  __nin&lt;/th&gt;       &lt;th&gt;__lte / __gte&lt;/th&gt;     &lt;tr&gt;   &lt;thead&gt;   &lt;tbody&gt;     &lt;tr&gt;       &lt;td&gt;created_at&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;     &lt;/tr&gt;     &lt;tr&gt;       &lt;td&gt;datafile&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;&amp;nbsp;&lt;/td&gt;     &lt;/tr&gt;     &lt;tr&gt;       &lt;td&gt;datafile_checksum&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;&amp;nbsp;&lt;/td&gt;     &lt;/tr&gt;     &lt;tr&gt;       &lt;td&gt;datafile_size&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;&amp;nbsp;&lt;/td&gt;     &lt;/tr&gt;     &lt;tr&gt;       &lt;td&gt;description&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;&amp;nbsp;&lt;/td&gt;     &lt;/tr&gt;     &lt;tr&gt;       &lt;td&gt;etag&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;     &lt;/tr&gt;     &lt;tr&gt;       &lt;td&gt;id&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;&amp;nbsp;&lt;/td&gt;     &lt;/tr&gt;     &lt;tr&gt;       &lt;td&gt;name&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;&amp;nbsp;&lt;/td&gt;     &lt;/tr&gt;     &lt;tr&gt;       &lt;td&gt;timestamp&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;     &lt;/tr&gt;     &lt;tr&gt;       &lt;td&gt;updated_at&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;     &lt;/tr&gt;   &lt;/tbody&gt; &lt;/table&gt; &amp;nbsp;  The query string is made up of key-value pairs separated by ampersands. For example, this query: &#x60;key1&#x3D;value1&amp;key2&#x3D;value2&amp;key3&#x3D;value3&#x60;  would be URL-encoded as: &#x60;?filter&#x3D;key1__eq%3Dvalue1%26key2__eq%3Dvalue2%26key3__eq%3Dvalue3&#x60;   **Filtering by properties** &#x60;name__eq&#x3D;myimage&#x60;  **Filtering on date-time fields**  Date-time fields should be specified in UTC RFC3339 format, &#x60;YYYY-MM-DDThh:mm:ss.msZ&#x60;. There are three permitted variations:  * UTC RFC3339 with milliseconds. Example: &#x60;2016-11-30T16:25:12.1234Z&#x60; * UTC RFC3339 without milliseconds. Example: &#x60;2016-11-30T16:25:12Z&#x60; * UTC RFC3339 shortened without milliseconds and punctuation. Example: &#x60;20161130T162512Z&#x60;  Date-time filtering supports three operators:  * equality by appending &#x60;__eq&#x60; to the field name * greater than or equal to by appending &#x60;__gte&#x60; to the field name * less than or equal to by appending &#x60;__lte&#x60; to the field name  &#x60;{field name}[|__eq|__lte|__gte]&#x3D;{UTC RFC3339 date-time}&#x60;  Time ranges may be specified by including both the &#x60;__gte&#x60; and &#x60;__lte&#x60; forms in the filter. For example:  &#x60;created_at__gte&#x3D;2016-11-30T16:25:12.1234Z&amp;created_at__lte&#x3D;2016-12-30T00:00:00Z&#x60;  **Filtering on multiple fields**  &#x60;name__eq&#x3D;myimage&amp;created_at__gte&#x3D;2016-11-30T16:25:12.1234Z&amp;created_at__lte&#x3D;2016-12-30T00:00:00Z&#x60;  **Filtering with filter operators**  String field filtering supports the following operators:  * equality: &#x60;__eq&#x60; * non-equality: &#x60;__neq&#x60; * in : &#x60;__in&#x60; * not in: &#x60;__nin&#x60;  For &#x60;__in&#x60; and &#x60;__nin&#x60; filters list of parameters must be comma-separated:  &#x60;name__in&#x3D;fw-image1,fw-image2&#x60; (optional)
   * @return Call&lt;FirmwareImagePage&gt;
   */
  @GET("v3/firmware-images/")
  Call<FirmwareImagePage> firmwareImageList(
    @retrofit2.http.Query("limit") Integer limit, @retrofit2.http.Query("order") String order, @retrofit2.http.Query("after") String after, @retrofit2.http.Query("include") String include, @retrofit2.http.Query("filter") String filter
  );

  /**
   * Get an image
   * Retrieve a firmware image.
   * @param imageId The firmware image ID (required)
   * @return Call&lt;FirmwareImage&gt;
   */
  @GET("v3/firmware-images/{image_id}/")
  Call<FirmwareImage> firmwareImageRetrieve(
    @retrofit2.http.Path(value = "image_id", encoded = true) String imageId
  );

  /**
   * Upload a manifest
   * Upload a firmware manifest. The API enforces a maximum size of manifests of 2 KB.
   * @param datafile The manifest file to create. The API gateway enforces the account-specific file size. (required)
   * @param name The name of the firmware manifest (required)
   * @param description The description of the firmware manifest (optional)
   * @param keyTable The key table of pre-shared keys for devices (optional)
   * @return Call&lt;FirmwareManifest&gt;
   */
  @retrofit2.http.Multipart
  @POST("v3/firmware-manifests/")
  Call<FirmwareManifest> firmwareManifestCreate(
    @retrofit2.http.Part() MultipartBody.Part datafile, @retrofit2.http.Part("name") String name, @retrofit2.http.Part("description") String description, @retrofit2.http.Part() MultipartBody.Part keyTable
  );

  /**
   * Delete a manifest
   * Delete a firmware manifest.
   * @param manifestId The firmware manifest ID (required)
   * @return Call&lt;Void&gt;
   */
  @DELETE("v3/firmware-manifests/{manifest_id}/")
  Call<Void> firmwareManifestDestroy(
    @retrofit2.http.Path(value = "manifest_id", encoded = true) String manifestId
  );

  /**
   * List manifests
   * List firmware manifests.
   * @param limit How many objects to retrieve in the page. The minimum limit is 2 and the maximum is 1000. Limit values outside of this range are set to the closest limit. (optional)
   * @param order ASC or DESC (optional)
   * @param after The ID of the the item after which to retrieve the next page (optional)
   * @param include A comma-separated list of data fields to return. Currently supported: total_count (optional)
   * @param filter URL-encoded query string parameter to filter returned data  &#x60;?filter&#x3D;{URL-encoded query string}&#x60;  ###### Filterable fields:  The table lists all the fields that can be filtered on with certain filters:  &lt;table&gt;   &lt;thead&gt;     &lt;tr&gt;       &lt;th&gt;Field&lt;/th&gt;       &lt;th&gt;&#x3D; / __eq / __neq&lt;/th&gt;       &lt;th&gt;__in /  __nin&lt;/th&gt;       &lt;th&gt;__lte / __gte&lt;/th&gt;     &lt;tr&gt;   &lt;thead&gt;   &lt;tbody&gt;     &lt;tr&gt;       &lt;td&gt;created_at&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;     &lt;/tr&gt;     &lt;tr&gt;       &lt;td&gt;datafile&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;&amp;nbsp;&lt;/td&gt;     &lt;/tr&gt;     &lt;tr&gt;       &lt;td&gt;datafile_size&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;&amp;nbsp;&lt;/td&gt;     &lt;/tr&gt;     &lt;tr&gt;       &lt;td&gt;description&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;&amp;nbsp;&lt;/td&gt;     &lt;/tr&gt;     &lt;tr&gt;       &lt;td&gt;device_class&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;&amp;nbsp;&lt;/td&gt;     &lt;/tr&gt;     &lt;tr&gt;       &lt;td&gt;etag&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;     &lt;/tr&gt;     &lt;tr&gt;       &lt;td&gt;id&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;&amp;nbsp;&lt;/td&gt;     &lt;/tr&gt;     &lt;tr&gt;       &lt;td&gt;name&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;&amp;nbsp;&lt;/td&gt;     &lt;/tr&gt;     &lt;tr&gt;       &lt;td&gt;timestamp&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;     &lt;/tr&gt;     &lt;tr&gt;       &lt;td&gt;updated_at&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;     &lt;/tr&gt;   &lt;/tbody&gt; &lt;/table&gt; &amp;nbsp;  The query string is made up of key-value pairs separated by ampersands. For example, this query: &#x60;key1__eq&#x3D;value1&amp;key2__eq&#x3D;value2&amp;key3__eq&#x3D;value3&#x60;  would be URL-encoded as: &#x60;?filter&#x3D;key1__eq%3Dvalue1%26key2__eq%3Dvalue2%26key3__eq%3Dvalue3&#x60;   **Filtering by properties** &#x60;name__eq&#x3D;mymanifest&#x60;  **Filtering on date-time fields**  Date-time fields should be specified in UTC RFC3339 format, &#x60;YYYY-MM-DDThh:mm:ss.msZ&#x60;. There are three permitted variations:  * UTC RFC3339 with milliseconds. Example: &#x60;2016-11-30T16:25:12.1234Z&#x60; * UTC RFC3339 without milliseconds. Example: &#x60;2016-11-30T16:25:12Z&#x60; * UTC RFC3339 shortened without milliseconds and punctuation. Example: &#x60;20161130T162512Z&#x60;  Date-time filtering supports three operators:  * equality by appending &#x60;__eq&#x60; to the field name * greater than or equal to by appending &#x60;__gte&#x60; to the field name * less than or equal to by appending &#x60;__lte&#x60; to the field name  &#x60;{field name}[|__eq|__lte|__gte]&#x3D;{UTC RFC3339 date-time}&#x60;  Time ranges may be specified by including both the &#x60;__gte&#x60; and &#x60;__lte&#x60; forms in the filter. For example:  &#x60;created_at__gte&#x3D;2016-11-30T16:25:12.1234Z&amp;created_at__lte&#x3D;2016-12-30T00:00:00Z&#x60;  **Filtering on multiple fields**  &#x60;name__eq&#x3D;mymanifest&amp;created_at__gte&#x3D;2016-11-30T16:25:12.1234Z&amp;created_at__lte&#x3D;2016-12-30T00:00:00Z&#x60;  **Filtering with filter operators**  String field filtering supports the following operators:  * equality: &#x60;__eq&#x60; * non-equality: &#x60;__neq&#x60; * in : &#x60;__in&#x60; * not in: &#x60;__nin&#x60;  For &#x60;__in&#x60; and &#x60;__nin&#x60; filters list of parameters must be comma-separated:  &#x60;name__in&#x3D;fw-manifest1,fw-manifest2&#x60; (optional)
   * @return Call&lt;FirmwareManifestPage&gt;
   */
  @GET("v3/firmware-manifests/")
  Call<FirmwareManifestPage> firmwareManifestList(
    @retrofit2.http.Query("limit") Integer limit, @retrofit2.http.Query("order") String order, @retrofit2.http.Query("after") String after, @retrofit2.http.Query("include") String include, @retrofit2.http.Query("filter") String filter
  );

  /**
   * Get a manifest
   * Retrieve a firmware manifest.
   * @param manifestId The firmware manifest ID (required)
   * @return Call&lt;FirmwareManifest&gt;
   */
  @GET("v3/firmware-manifests/{manifest_id}/")
  Call<FirmwareManifest> firmwareManifestRetrieve(
    @retrofit2.http.Path(value = "manifest_id", encoded = true) String manifestId
  );

  /**
   * Archive a campaign.
   * This command will archive a campaign.
   * @param campaignId The campaign ID (required)
   * @return Call&lt;Void&gt;
   */
  @POST("v3/update-campaigns/{campaign_id}/archive")
  Call<Void> updateCampaignArchive(
    @retrofit2.http.Path(value = "campaign_id", encoded = true) String campaignId
  );

  /**
   * Create a campaign
   * Create an update campaign.
   * @param campaign Update campaign (required)
   * @return Call&lt;UpdateCampaign&gt;
   */
  @POST("v3/update-campaigns/")
  Call<UpdateCampaign> updateCampaignCreate(
    @retrofit2.http.Body UpdateCampaignPostRequest campaign
  );

  /**
   * Delete a campaign
   * Delete an update campaign.
   * @param campaignId The ID of the update campaign (required)
   * @return Call&lt;Void&gt;
   */
  @DELETE("v3/update-campaigns/{campaign_id}/")
  Call<Void> updateCampaignDestroy(
    @retrofit2.http.Path(value = "campaign_id", encoded = true) String campaignId
  );

  /**
   * List all campaigns
   * Get update campaigns for devices specified by a filter.
   * @param limit How many objects to retrieve in the page. The minimum limit is 2 and the maximum is 1000. Limit values outside of this range are set to the closest limit. (optional)
   * @param order The order of the records. Acceptable values: ASC, DESC. Default: ASC (optional)
   * @param after The ID of the the item after which to retrieve the next page (optional)
   * @param include A comma-separated list of data fields to return. Currently supported: total_count (optional)
   * @param filter URL-encoded query string parameter to filter returned data  &#x60;?filter&#x3D;{URL-encoded query string}&#x60;   ###### Filterable fields:  The below table lists all the fields that can be filtered on with certain filters:  &lt;table&gt;   &lt;thead&gt;     &lt;tr&gt;       &lt;th&gt;Field&lt;/th&gt;       &lt;th&gt;&#x3D; / __eq / __neq&lt;/th&gt;       &lt;th&gt;__in /  __nin&lt;/th&gt;       &lt;th&gt;__lte / __gte&lt;/th&gt;     &lt;tr&gt;   &lt;thead&gt;   &lt;tbody&gt;     &lt;tr&gt;       &lt;td&gt;created_at&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;     &lt;/tr&gt;     &lt;tr&gt;       &lt;td&gt;description&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;&amp;nbsp;&lt;/td&gt;     &lt;/tr&gt;     &lt;tr&gt;       &lt;td&gt;device_filter&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;&amp;nbsp;&lt;/td&gt;     &lt;/tr&gt;     &lt;tr&gt;       &lt;td&gt;etag&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;     &lt;/tr&gt;     &lt;tr&gt;       &lt;td&gt;finished&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;     &lt;/tr&gt;     &lt;tr&gt;       &lt;td&gt;id&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;&amp;nbsp;&lt;/td&gt;     &lt;/tr&gt;     &lt;tr&gt;       &lt;td&gt;name&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;&amp;nbsp;&lt;/td&gt;     &lt;/tr&gt;     &lt;tr&gt;       &lt;td&gt;root_manifest_id&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;&amp;nbsp;&lt;/td&gt;     &lt;/tr&gt;     &lt;tr&gt;       &lt;td&gt;started_at&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;     &lt;/tr&gt;     &lt;tr&gt;       &lt;td&gt;state&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;&amp;nbsp;&lt;/td&gt;     &lt;/tr&gt;     &lt;tr&gt;       &lt;td&gt;updated_at&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;     &lt;/tr&gt;     &lt;tr&gt;       &lt;td&gt;when&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;     &lt;/tr&gt;   &lt;/tbody&gt; &lt;/table&gt; &amp;nbsp;  The query string is made up of key-value pairs separated by ampersands. For example, this query: &#x60;key1__eq&#x3D;value1&amp;key2__eq&#x3D;value2&amp;key3__eq&#x3D;value3&#x60;  would be URL-encoded as: &#x60;?filter&#x3D;key1__eq%3Dvalue1%26key2__eq%3Dvalue2%26key3__eq%3Dvalue3&#x60;   **Filtering by campaign properties** &#x60;state__eq&#x3D;[draft|scheduled|devicefectch|devicecopy|publishing|deploying|deployed|manifestremoved|expired]&#x60;  &#x60;root_manifest_id__eq&#x3D;43217771234242e594ddb433816c498a&#x60;  **Filtering on date-time fields**  Date-time fields should be specified in UTC RFC3339 format, &#x60;YYYY-MM-DDThh:mm:ss.msZ&#x60;. There are three permitted variations:  * UTC RFC3339 with milliseconds. Example: &#x60;2016-11-30T16:25:12.1234Z&#x60; * UTC RFC3339 without milliseconds. Example: &#x60;2016-11-30T16:25:12Z&#x60; * UTC RFC3339 shortened without milliseconds and punctuation. Example: &#x60;20161130T162512Z&#x60;  Date-time filtering supports three operators:  * equality by appending &#x60;__eq&#x60; to the field name * greater than or equal to by appending &#x60;__gte&#x60; to the field name * less than or equal to by appending &#x60;__lte&#x60; to the field name  &#x60;{field name}[|__eq|__lte|__gte]&#x3D;{UTC RFC3339 date-time}&#x60;  Time ranges may be specified by including both the &#x60;__gte&#x60; and &#x60;__lte&#x60; forms in the filter. For example:  &#x60;created_at__gte&#x3D;2016-11-30T16:25:12.1234Z&amp;created_at__lte&#x3D;2016-12-30T00:00:00Z&#x60;  **Filtering on multiple fields**  &#x60;state__eq&#x3D;deployed&amp;created_at__gte&#x3D;2016-11-30T16:25:12.1234Z&amp;created_at__lte&#x3D;2016-12-30T00:00:00Z&#x60;  **Filtering with filter operators**  String field filtering supports the following operators:  * equality: &#x60;__eq&#x60; * non-equality: &#x60;__neq&#x60; * in : &#x60;__in&#x60; * not in: &#x60;__nin&#x60;  For &#x60;__in&#x60; and &#x60;__nin&#x60; filters list of parameters must be comma-separated:  &#x60;name__in&#x3D;fw-image1,fw-image2&#x60; (optional)
   * @return Call&lt;UpdateCampaignPage&gt;
   */
  @GET("v3/update-campaigns/")
  Call<UpdateCampaignPage> updateCampaignList(
    @retrofit2.http.Query("limit") Integer limit, @retrofit2.http.Query("order") String order, @retrofit2.http.Query("after") String after, @retrofit2.http.Query("include") String include, @retrofit2.http.Query("filter") String filter
  );

  /**
   * List all campaign device metadata
   * Get campaign device metadata.
   * @param campaignId The update campaign ID (required)
   * @param limit How many objects to retrieve in the page. The minimum limit is 2 and the maximum is 1000. Limit values outside of this range are set to the closest limit. (optional)
   * @param order ASC or DESC (optional)
   * @param after The ID of the the item after which to retrieve the next page (optional)
   * @param include A comma-separated list of data fields to return. Currently supported: total_count (optional)
   * @return Call&lt;CampaignDeviceMetadataPage&gt;
   */
  @GET("v3/update-campaigns/{campaign_id}/campaign-device-metadata/")
  Call<CampaignDeviceMetadataPage> updateCampaignMetadataList(
    @retrofit2.http.Path(value = "campaign_id", encoded = true) String campaignId, @retrofit2.http.Query("limit") Integer limit, @retrofit2.http.Query("order") String order, @retrofit2.http.Query("after") String after, @retrofit2.http.Query("include") String include
  );

  /**
   * Get a campaign device metadata
   * Get update campaign metadata.
   * @param campaignId The update campaign ID (required)
   * @param campaignDeviceMetadataId The campaign device metadata ID (required)
   * @return Call&lt;CampaignDeviceMetadata&gt;
   */
  @GET("v3/update-campaigns/{campaign_id}/campaign-device-metadata/{campaign_device_metadata_id}/")
  Call<CampaignDeviceMetadata> updateCampaignMetadataRetrieve(
    @retrofit2.http.Path(value = "campaign_id", encoded = true) String campaignId, @retrofit2.http.Path(value = "campaign_device_metadata_id", encoded = true) String campaignDeviceMetadataId
  );

  /**
   * Get campaign metrics
   * Get detailed statistics of a campaign.
   * @param campaignId The campaign ID (required)
   * @return Call&lt;CampaignMetrics&gt;
   */
  @GET("v3/update-campaigns/{campaign_id}/metrics")
  Call<CampaignMetrics> updateCampaignMetrics(
    @retrofit2.http.Path(value = "campaign_id", encoded = true) String campaignId
  );

  /**
   * Get a campaign.
   * Get an update campaign.
   * @param campaignId The campaign ID (required)
   * @return Call&lt;UpdateCampaign&gt;
   */
  @GET("v3/update-campaigns/{campaign_id}/")
  Call<UpdateCampaign> updateCampaignRetrieve(
    @retrofit2.http.Path(value = "campaign_id", encoded = true) String campaignId
  );

  /**
   * Start a campaign.
   * This command will begin the process of starting a campaign.
   * @param campaignId The campaign ID (required)
   * @return Call&lt;Void&gt;
   */
  @POST("v3/update-campaigns/{campaign_id}/start")
  Call<Void> updateCampaignStart(
    @retrofit2.http.Path(value = "campaign_id", encoded = true) String campaignId
  );

  /**
   * Stop a campaign.
   * This command will begin the process of stopping a campaign.
   * @param campaignId The campaign ID (required)
   * @return Call&lt;Void&gt;
   */
  @POST("v3/update-campaigns/{campaign_id}/stop")
  Call<Void> updateCampaignStop(
    @retrofit2.http.Path(value = "campaign_id", encoded = true) String campaignId
  );

  /**
   * Modify a campaign
   * Modify an update campaign.
   * @param campaignId  (required)
   * @param campaign Update campaign (required)
   * @return Call&lt;UpdateCampaign&gt;
   */
  @PUT("v3/update-campaigns/{campaign_id}/")
  Call<UpdateCampaign> updateCampaignUpdate(
    @retrofit2.http.Path(value = "campaign_id", encoded = true) String campaignId, @retrofit2.http.Body UpdateCampaignPutRequest campaign
  );

  /**
   * Append a chunks to an upload job
   * Append a chunks to an upload job. To finish a job upload a zero-length chunk.
   * @param contentMD5 The base64-encoded binary digest of the body (chunk data). (required)
   * @param contentLength  (required)
   * @param uploadJobId Upload job ID (required)
   * @param chunk Chunk (optional)
   * @return Call&lt;UploadChunkInfo&gt;
   */
  @Headers({
    "Content-Type:binary/octet-stream"
  })
  @POST("v3/firmware-images/upload-jobs/{upload_job_id}/chunks")
  Call<UploadChunkInfo> uploadJobChunkCreate(
    @retrofit2.http.Header("Content-MD5") String contentMD5, @retrofit2.http.Header("Content-Length") Integer contentLength, @retrofit2.http.Path(value = "upload_job_id", encoded = true) String uploadJobId, @retrofit2.http.Body byte[] chunk
  );

  /**
   * List all metadata for uploaded chunks
   * List all metadata for uploaded chunks
   * @param uploadJobId Upload job (required)
   * @param limit How many objects to retrieve in the page. The minimum limit is 2 and the maximum is 1000. Limit values outside of this range are set to the closest limit. (optional)
   * @param order ASC or DESC (optional)
   * @param after The ID of the the item after which to retrieve the next page (optional)
   * @param include A comma-separated list of data fields to return. Currently supported: total_count (optional)
   * @param filter URL-encoded query string parameter to filter returned data  &#x60;?filter&#x3D;{URL-encoded query string}&#x60;  ###### Filterable fields:  The table lists all the fields that can be filtered on with certain filters:  &lt;table&gt;   &lt;thead&gt;     &lt;tr&gt;       &lt;th&gt;Field&lt;/th&gt;       &lt;th&gt;&#x3D; / __eq / __neq&lt;/th&gt;       &lt;th&gt;__in /  __nin&lt;/th&gt;       &lt;th&gt;__lte / __gte&lt;/th&gt;     &lt;tr&gt;   &lt;thead&gt;   &lt;tbody&gt;     &lt;tr&gt;       &lt;td&gt;created_at&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;     &lt;/tr&gt;     &lt;tr&gt;       &lt;td&gt;etag&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;     &lt;/tr&gt;     &lt;tr&gt;       &lt;td&gt;id&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;&amp;nbsp;&lt;/td&gt;     &lt;/tr&gt;     &lt;tr&gt;       &lt;td&gt;updated_at&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;     &lt;/tr&gt;     &lt;tr&gt;       &lt;td&gt;hash&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;     &lt;/tr&gt;     &lt;tr&gt;       &lt;td&gt;length&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;     &lt;/tr&gt;   &lt;/tbody&gt; &lt;/table&gt; &amp;nbsp;  The query string is made up of key-value pairs separated by ampersands. For example, this query: &#x60;key1&#x3D;value1&amp;key2&#x3D;value2&amp;key3&#x3D;value3&#x60;  would be URL-encoded as: &#x60;?filter&#x3D;key1__eq%3Dvalue1%26key2__eq%3Dvalue2%26key3__eq%3Dvalue3&#x60;   **Filtering by properties** &#x60;hash__eq&#x3D;8FS70vXrq5y1VxAAssUMAg&#x3D;&#x3D;&#x60;  **Filtering on date-time fields**  Date-time fields should be specified in UTC RFC3339 format, &#x60;YYYY-MM-DDThh:mm:ss.msZ&#x60;. There are three permitted variations:  * UTC RFC3339 with milliseconds. Example: &#x60;2016-11-30T16:25:12.1234Z&#x60; * UTC RFC3339 without milliseconds. Example: &#x60;2016-11-30T16:25:12Z&#x60; * UTC RFC3339 shortened without milliseconds and punctuation. Example: &#x60;20161130T162512Z&#x60;  Date-time filtering supports three operators:  * equality by appending &#x60;__eq&#x60; to the field name * greater than or equal to by appending &#x60;__gte&#x60; to the field name * less than or equal to by appending &#x60;__lte&#x60; to the field name  &#x60;{field name}[|__eq|__lte|__gte]&#x3D;{UTC RFC3339 date-time}&#x60;  Time ranges may be specified by including both the &#x60;__gte&#x60; and &#x60;__lte&#x60; forms in the filter. For example:  &#x60;created_at__gte&#x3D;2016-11-30T16:25:12.1234Z&amp;created_at__lte&#x3D;2016-12-30T00:00:00Z&#x60;  **Filtering on multiple fields**  &#x60;status__eq&#x3D;in_progress&amp;created_at__gte&#x3D;2016-11-30T16:25:12.1234Z&amp;created_at__lte&#x3D;2016-12-30T00:00:00Z&#x60;  **Filtering with filter operators**  String field filtering supports the following operators:  * equality: &#x60;__eq&#x60; * non-equality: &#x60;__neq&#x60; * in : &#x60;__in&#x60; * not in: &#x60;__nin&#x60;  For &#x60;__in&#x60; and &#x60;__nin&#x60; filters list of parameters must be comma-separated:  &#x60;status__in&#x3D;in_progress,success&#x60; (optional)
   * @return Call&lt;UploadChunkInfoPage&gt;
   */
  @GET("v3/firmware-images/upload-jobs/{upload_job_id}/chunks")
  Call<UploadChunkInfoPage> uploadJobChunkList(
    @retrofit2.http.Path(value = "upload_job_id", encoded = true) String uploadJobId, @retrofit2.http.Query("limit") Integer limit, @retrofit2.http.Query("order") String order, @retrofit2.http.Query("after") String after, @retrofit2.http.Query("include") String include, @retrofit2.http.Query("filter") String filter
  );

  /**
   * Get metadata about a chunk
   * Get metadata about a chunk
   * @param uploadJobId Upload job (required)
   * @param chunkId Chunk (required)
   * @return Call&lt;UploadChunkInfo&gt;
   */
  @GET("v3/firmware-images/upload-jobs/{upload_job_id}/chunks/{chunk_id}")
  Call<UploadChunkInfo> uploadJobChunkRetreive(
    @retrofit2.http.Path(value = "upload_job_id", encoded = true) String uploadJobId, @retrofit2.http.Path(value = "chunk_id", encoded = true) String chunkId
  );

  /**
   * Create a new upload job
   * Create a new upload job
   * @param uploadJob Upload job (required)
   * @return Call&lt;UploadJob&gt;
   */
  @POST("v3/firmware-images/upload-jobs")
  Call<UploadJob> uploadJobCreate(
    @retrofit2.http.Body UploadJob uploadJob
  );

  /**
   * Delete an upload job
   * Delete an upload job
   * @param uploadJobId Upload job (required)
   * @return Call&lt;Void&gt;
   */
  @DELETE("v3/firmware-images/upload-jobs/{upload_job_id}")
  Call<Void> uploadJobDelete(
    @retrofit2.http.Path(value = "upload_job_id", encoded = true) String uploadJobId
  );

  /**
   * Get all upload jobs
   * Get all upload jobs
   * @param limit How many objects to retrieve in the page. The minimum limit is 2 and the maximum is 1000. Limit values outside of this range are set to the closest limit. (optional)
   * @param order ASC or DESC (optional)
   * @param after The ID of the the item after which to retrieve the next page (optional)
   * @param include A comma-separated list of data fields to return. Currently supported: total_count (optional)
   * @param filter URL-encoded query string parameter to filter returned data  &#x60;?filter&#x3D;{URL-encoded query string}&#x60;  ###### Filterable fields:  The table lists all the fields that can be filtered on with certain filters:  &lt;table&gt;   &lt;thead&gt;     &lt;tr&gt;       &lt;th&gt;Field&lt;/th&gt;       &lt;th&gt;&#x3D; / __eq / __neq&lt;/th&gt;       &lt;th&gt;__in /  __nin&lt;/th&gt;       &lt;th&gt;__lte / __gte&lt;/th&gt;     &lt;tr&gt;   &lt;thead&gt;   &lt;tbody&gt;     &lt;tr&gt;       &lt;td&gt;name&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;&amp;nbsp;&lt;/td&gt;     &lt;/tr&gt;     &lt;tr&gt;       &lt;td&gt;description&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;&amp;nbsp;&lt;/td&gt;     &lt;/tr&gt;     &lt;tr&gt;       &lt;td&gt;complete&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;     &lt;/tr&gt;     &lt;tr&gt;       &lt;td&gt;id&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;&amp;nbsp;&lt;/td&gt;     &lt;/tr&gt;     &lt;tr&gt;       &lt;td&gt;firmware_image_id&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;&amp;nbsp;&lt;/td&gt;     &lt;/tr&gt;     &lt;tr&gt;       &lt;td&gt;status&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;&amp;nbsp;&lt;/td&gt;     &lt;/tr&gt;     &lt;tr&gt;       &lt;td&gt;created_at&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;     &lt;/tr&gt;     &lt;tr&gt;       &lt;td&gt;etag&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;     &lt;/tr&gt;     &lt;tr&gt;       &lt;td&gt;updated_at&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;     &lt;/tr&gt;   &lt;/tbody&gt; &lt;/table&gt; &amp;nbsp;  The query string is made up of key-value pairs separated by ampersands. For example, this query: &#x60;key1&#x3D;value1&amp;key2&#x3D;value2&amp;key3&#x3D;value3&#x60;  would be URL-encoded as: &#x60;?filter&#x3D;key1__eq%3Dvalue1%26key2__eq%3Dvalue2%26key3__eq%3Dvalue3&#x60;   **Filtering by properties** &#x60;name__eq&#x3D;myimage&#x60;  **Filtering on date-time fields**  Date-time fields should be specified in UTC RFC3339 format, &#x60;YYYY-MM-DDThh:mm:ss.msZ&#x60;. There are three permitted variations:  * UTC RFC3339 with milliseconds. Example: &#x60;2016-11-30T16:25:12.1234Z&#x60; * UTC RFC3339 without milliseconds. Example: &#x60;2016-11-30T16:25:12Z&#x60; * UTC RFC3339 shortened without milliseconds and punctuation. Example: &#x60;20161130T162512Z&#x60;  Date-time filtering supports three operators:  * equality by appending &#x60;__eq&#x60; to the field name * greater than or equal to by appending &#x60;__gte&#x60; to the field name * less than or equal to by appending &#x60;__lte&#x60; to the field name  &#x60;{field name}[|__eq|__lte|__gte]&#x3D;{UTC RFC3339 date-time}&#x60;  Time ranges may be specified by including both the &#x60;__gte&#x60; and &#x60;__lte&#x60; forms in the filter. For example:  &#x60;created_at__gte&#x3D;2016-11-30T16:25:12.1234Z&amp;created_at__lte&#x3D;2016-12-30T00:00:00Z&#x60;  **Filtering on multiple fields**  &#x60;name__eq&#x3D;myimage&amp;created_at__gte&#x3D;2016-11-30T16:25:12.1234Z&amp;created_at__lte&#x3D;2016-12-30T00:00:00Z&#x60;  **Filtering with filter operators**  String field filtering supports the following operators:  * equality: &#x60;__eq&#x60; * non-equality: &#x60;__neq&#x60; * in : &#x60;__in&#x60; * not in: &#x60;__nin&#x60;  For &#x60;__in&#x60; and &#x60;__nin&#x60; filters list of parameters must be comma-separated:  &#x60;name__in&#x3D;fw-image1,fw-image2&#x60; (optional)
   * @return Call&lt;UploadJobPage&gt;
   */
  @GET("v3/firmware-images/upload-jobs")
  Call<UploadJobPage> uploadJobList(
    @retrofit2.http.Query("limit") Integer limit, @retrofit2.http.Query("order") String order, @retrofit2.http.Query("after") String after, @retrofit2.http.Query("include") String include, @retrofit2.http.Query("filter") String filter
  );

  /**
   * Get an upload job
   * Get an upload job
   * @param uploadJobId Upload job (required)
   * @return Call&lt;UploadJob&gt;
   */
  @GET("v3/firmware-images/upload-jobs/{upload_job_id}")
  Call<UploadJob> uploadJobRetrieve(
    @retrofit2.http.Path(value = "upload_job_id", encoded = true) String uploadJobId
  );

  /**
   * Update an upload job
   * Update an upload job
   * @param uploadJobId Upload job id (required)
   * @param uploadJob Upload job (required)
   * @return Call&lt;UploadJob&gt;
   */
  @PUT("v3/firmware-images/upload-jobs/{upload_job_id}")
  Call<UploadJob> uploadJobUpdate(
    @retrofit2.http.Path(value = "upload_job_id", encoded = true) String uploadJobId, @retrofit2.http.Body UploadJob1 uploadJob
  );

}
