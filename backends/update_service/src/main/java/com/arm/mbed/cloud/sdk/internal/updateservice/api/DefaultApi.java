package com.arm.mbed.cloud.sdk.internal.updateservice.api;

import com.arm.mbed.cloud.sdk.internal.CollectionFormats.*;



import retrofit2.Call;
import retrofit2.http.*;

import okhttp3.RequestBody;

import com.arm.mbed.cloud.sdk.internal.updateservice.model.CampaignDeviceMetadata;
import com.arm.mbed.cloud.sdk.internal.updateservice.model.CampaignDeviceMetadataPage;
import java.io.File;
import com.arm.mbed.cloud.sdk.internal.updateservice.model.FirmwareImage;
import com.arm.mbed.cloud.sdk.internal.updateservice.model.FirmwareImagePage;
import com.arm.mbed.cloud.sdk.internal.updateservice.model.FirmwareManifest;
import com.arm.mbed.cloud.sdk.internal.updateservice.model.FirmwareManifestPage;
import com.arm.mbed.cloud.sdk.internal.updateservice.model.UpdateCampaign;
import com.arm.mbed.cloud.sdk.internal.updateservice.model.UpdateCampaignPage;
import com.arm.mbed.cloud.sdk.internal.updateservice.model.UpdateCampaignPatchRequest;
import com.arm.mbed.cloud.sdk.internal.updateservice.model.UpdateCampaignPostRequest;
import com.arm.mbed.cloud.sdk.internal.updateservice.model.UpdateCampaignPutRequest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public interface DefaultApi {
  /**
   * 
   * Create firmware image.
   * @param datafile The firmware image file to upload (required)
   * @param name The name of the firmware image (required)
   * @param description The description of the firmware image (optional)
   * @return Call&lt;FirmwareImage&gt;
   */
  @retrofit2.http.Multipart
  @POST("v3/firmware-images/")
  Call<FirmwareImage> firmwareImageCreate(
    @retrofit2.http.Part("datafile\"; filename=\"datafile") RequestBody datafile, @retrofit2.http.Part("name") String name, @retrofit2.http.Part("description") String description
  );

  /**
   * 
   * Delete firmware image.
   * @param imageId The firmware image ID (required)
   * @return Call&lt;Void&gt;
   */
  @DELETE("v3/firmware-images/{image_id}/")
  Call<Void> firmwareImageDestroy(
    @retrofit2.http.Path(value = "image_id", encoded = true) String imageId
  );

  /**
   * 
   * List all firmware images.
   * @param limit How many firmware images to retrieve (optional)
   * @param order ASC or DESC (optional)
   * @param after The ID of the the item after which to retrieve the next page (optional)
   * @param filter URL-encoded query string parameter to filter returned data. The results are paginated into groups of 50.  &lt;br/&gt; ?filter&#x3D;{URL-encoded query string} &lt;br/&gt;  The query string is made up of key-value pairs separated by ampersands. For example, this query: key1&#x3D;value1&amp;key2&#x3D;value2&amp;key3&#x3D;value3  would be URL-encoded as: ?filter&#x3D;key1%3Dvalue1%26key2%3Dvalue2%26key3%3Dvalue3 &lt;br/&gt;  The examples below show the queries in *unencoded* form.&lt;br/&gt;  &lt;br/&gt;**Filtering by campaign properties** state&#x3D;[draft|scheduled|devicefectch|devicecopy|publishing|deploying|deployed|manifestremoved|expired]  &lt;br/&gt; root_manifest_id&#x3D;43217771234242e594ddb433816c498a  &lt;br/&gt;**Filtering on date-time fields**  Date-time fields should be specified in UTC RFC3339 format, &#x60;YYYY-MM-DDThh:mm:ss.msZ&#x60;. There are three permitted variations:  * UTC RFC3339 with milliseconds. Example: &#x60;2016-11-30T16:25:12.1234Z&#x60; * UTC RFC3339 without milliseconds. Example: &#x60;2016-11-30T16:25:12Z&#x60; * UTC RFC3339 shortened without milliseconds and punctuation. Example: &#x60;20161130T162512Z&#x60;  Date-time filtering supports three operators:  * equality * greater than or equal to by appending &#x60;__gte&#x60; to the field name * less than or equal to by appending &#x60;__lte&#x60; to the field name  {field name}[|__lte|__gte]&#x3D;{UTC RFC3339 date-time} &lt;br/&gt;  Time ranges may be specified by including both the &#x60;__gte&#x60; and &#x60;__lte&#x60; forms in the filter. For example:  created_at__gte&#x3D;2016-11-30T16:25:12.1234Z&amp;created_at__lte&#x3D;2016-12-30T00:00:00Z  &lt;br/&gt;**Filtering on multiple fields**  Example: state&#x3D;deployed&amp;created_at__gte&#x3D;2016-11-30T16:25:12.1234Z&amp;created_at__lte&#x3D;2016-12-30T00:00:00Z  The example after URL encoding: ?filter&#x3D;state%3Ddeployed%26created_at__gte%3D2016-11-30T16%3A25%3A12.1234Z%26created_at__lte%3D2016-11-30T00%3A00%3A00Z (optional)
   * @param include Comma-separated list of data fields to return. Currently supported: total_count (optional)
   * @return Call&lt;FirmwareImagePage&gt;
   */
  @GET("v3/firmware-images/")
  Call<FirmwareImagePage> firmwareImageList(
    @retrofit2.http.Query("limit") Integer limit, @retrofit2.http.Query("order") String order, @retrofit2.http.Query("after") String after, @retrofit2.http.Query("filter") String filter, @retrofit2.http.Query("include") String include
  );

  /**
   * 
   * Retrieve firmware image.
   * @param imageId The firmware image ID (required)
   * @return Call&lt;FirmwareImage&gt;
   */
  @GET("v3/firmware-images/{image_id}/")
  Call<FirmwareImage> firmwareImageRetrieve(
    @retrofit2.http.Path(value = "image_id", encoded = true) String imageId
  );

  /**
   * 
   * Create firmware manifest.
   * @param datafile The manifest file to create. The API gateway enforces the account-specific file size. (required)
   * @param name The name of the firmware manifest (required)
   * @param description The description of the firmware manifest (optional)
   * @return Call&lt;FirmwareManifest&gt;
   */
  @retrofit2.http.Multipart
  @POST("v3/firmware-manifests/")
  Call<FirmwareManifest> firmwareManifestCreate(
    @retrofit2.http.Part("datafile\"; filename=\"datafile") RequestBody datafile, @retrofit2.http.Part("name") String name, @retrofit2.http.Part("description") String description
  );

  /**
   * 
   * Delete firmware manifest.
   * @param manifestId The firmware manifest ID (required)
   * @return Call&lt;Void&gt;
   */
  @DELETE("v3/firmware-manifests/{manifest_id}/")
  Call<Void> firmwareManifestDestroy(
    @retrofit2.http.Path(value = "manifest_id", encoded = true) String manifestId
  );

  /**
   * 
   * List firmware manifests.
   * @param limit How many firmware manifests to retrieve (optional)
   * @param order ASC or DESC (optional)
   * @param after The ID of the the item after which to retrieve the next page. (optional)
   * @param filter URL-encoded query string parameter to filter returned data  &lt;br/&gt; ?filter&#x3D;{URL-encoded query string} &lt;br/&gt;  The query string is made up of key-value pairs separated by ampersands. For example, this query: key1&#x3D;value1&amp;key2&#x3D;value2&amp;key3&#x3D;value3  would be URL-encoded as: ?filter&#x3D;key1%3Dvalue1%26key2%3Dvalue2%26key3%3Dvalue3 &lt;br/&gt;  The examples below show the queries in *unencoded* form.&lt;br/&gt;  &lt;br/&gt;**Filtering by campaign properties** state&#x3D;[draft|scheduled|devicefectch|devicecopy|publishing|deploying|deployed|manifestremoved|expired]  &lt;br/&gt; root_manifest_id&#x3D;43217771234242e594ddb433816c498a  &lt;br/&gt;**Filtering on date-time fields**  Date-time fields should be specified in UTC RFC3339 format, &#x60;YYYY-MM-DDThh:mm:ss.msZ&#x60;. There are three permitted variations:  * UTC RFC3339 with milliseconds. Example: &#x60;2016-11-30T16:25:12.1234Z&#x60; * UTC RFC3339 without milliseconds. Example: &#x60;2016-11-30T16:25:12Z&#x60; * UTC RFC3339 shortened without milliseconds and punctuation. Example: &#x60;20161130T162512Z&#x60;  Date-time filtering supports three operators:  * equality * greater than or equal to by appending &#x60;__gte&#x60; to the field name * less than or equal to by appending &#x60;__lte&#x60; to the field name  {field name}[|__lte|__gte]&#x3D;{UTC RFC3339 date-time} &lt;br/&gt;  Time ranges may be specified by including both the &#x60;__gte&#x60; and &#x60;__lte&#x60; forms in the filter. For example:  created_at__gte&#x3D;2016-11-30T16:25:12.1234Z&amp;created_at__lte&#x3D;2016-12-30T00:00:00Z  &lt;br/&gt;**Filtering on multiple fields**  Example: state&#x3D;deployed&amp;created_at__gte&#x3D;2016-11-30T16:25:12.1234Z&amp;created_at__lte&#x3D;2016-12-30T00:00:00Z  The example after URL encoding: ?filter&#x3D;state%3Ddeployed%26created_at__gte%3D2016-11-30T16%3A25%3A12.1234Z%26created_at__lte%3D2016-11-30T00%3A00%3A00Z (optional)
   * @param include Comma-separated list of data fields to return. Currently supported: total_count (optional)
   * @return Call&lt;FirmwareManifestPage&gt;
   */
  @GET("v3/firmware-manifests/")
  Call<FirmwareManifestPage> firmwareManifestList(
    @retrofit2.http.Query("limit") Integer limit, @retrofit2.http.Query("order") String order, @retrofit2.http.Query("after") String after, @retrofit2.http.Query("filter") String filter, @retrofit2.http.Query("include") String include
  );

  /**
   * 
   * Retrieve firmware manifest.
   * @param manifestId The firmware manifest ID (required)
   * @return Call&lt;FirmwareManifest&gt;
   */
  @GET("v3/firmware-manifests/{manifest_id}/")
  Call<FirmwareManifest> firmwareManifestRetrieve(
    @retrofit2.http.Path(value = "manifest_id", encoded = true) String manifestId
  );

  /**
   * 
   * Create an update campaign.
   * @param campaign Update campaign (required)
   * @return Call&lt;UpdateCampaign&gt;
   */
  @POST("v3/update-campaigns/")
  Call<UpdateCampaign> updateCampaignCreate(
    @retrofit2.http.Body UpdateCampaignPostRequest campaign
  );

  /**
   * 
   * Delete an update campaign.
   * @param campaignId The ID of the update campaign (required)
   * @return Call&lt;Void&gt;
   */
  @DELETE("v3/update-campaigns/{campaign_id}/")
  Call<Void> updateCampaignDestroy(
    @retrofit2.http.Path(value = "campaign_id", encoded = true) String campaignId
  );

  /**
   * 
   * Get update campaigns for devices specified by a filter.
   * @param limit How many update campaigns to retrieve (optional)
   * @param order The order of the records. Acceptable values: ASC, DESC. Default: ASC (optional)
   * @param after The ID of the the item after which to retrieve the next page (optional)
   * @param filter URL-encoded query string parameter to filter returned data  &lt;br/&gt;             ?filter&#x3D;{URL-encoded query string} &lt;br/&gt;  The query string is made up of key-value pairs separated by ampersands. For example, this query: key1&#x3D;value1&amp;key2&#x3D;value2&amp;key3&#x3D;value3  would be URL-encoded as: ?filter&#x3D;key1%3Dvalue1%26key2%3Dvalue2%26key3%3Dvalue3 &lt;br/&gt;  The examples below show the queries in *unencoded* form.&lt;br/&gt;  &lt;br/&gt;**Filtering by campaign properties** state&#x3D;[draft|scheduled|devicefectch|devicecopy|publishing|deploying|deployed|manifestremoved|expired]  &lt;br/&gt; root_manifest_id&#x3D;43217771234242e594ddb433816c498a  &lt;br/&gt;**Filtering on date-time fields**  Date-time fields should be specified in UTC RFC3339 format, &#x60;YYYY-MM-DDThh:mm:ss.msZ&#x60;. There are three permitted variations:  * UTC RFC3339 with milliseconds. Example: &#x60;2016-11-30T16:25:12.1234Z&#x60; * UTC RFC3339 without milliseconds. Example: &#x60;2016-11-30T16:25:12Z&#x60; * UTC RFC3339 shortened without milliseconds and punctuation. Example: &#x60;20161130T162512Z&#x60;  Date-time filtering supports three operators:  * equality * greater than or equal to by appending &#x60;__gte&#x60; to the field name * less than or equal to by appending &#x60;__lte&#x60; to the field name  {field name}[|__lte|__gte]&#x3D;{UTC RFC3339 date-time} &lt;br/&gt;  Time ranges may be specified by including both the &#x60;__gte&#x60; and &#x60;__lte&#x60; forms in the filter. For example:  created_at__gte&#x3D;2016-11-30T16:25:12.1234Z&amp;created_at__lte&#x3D;2016-12-30T00:00:00Z  &lt;br/&gt;**Filtering on multiple fields**  Example: state&#x3D;deployed&amp;created_at__gte&#x3D;2016-11-30T16:25:12.1234Z&amp;created_at__lte&#x3D;2016-12-30T00:00:00Z  The example after URL encoding: ?filter&#x3D;state%3Ddeployed%26created_at__gte%3D2016-11-30T16%3A25%3A12.1234Z%26created_at__lte%3D2016-11-30T00%3A00%3A00Z (optional)
   * @param include Comma-separated list of data fields to return. Currently supported: total_count (optional)
   * @return Call&lt;UpdateCampaignPage&gt;
   */
  @GET("v3/update-campaigns/")
  Call<UpdateCampaignPage> updateCampaignList(
    @retrofit2.http.Query("limit") Integer limit, @retrofit2.http.Query("order") String order, @retrofit2.http.Query("after") String after, @retrofit2.http.Query("filter") String filter, @retrofit2.http.Query("include") String include
  );

  /**
   * 
   * Modify a subset of an update campaign&#39;s fields.
   * @param campaignId  (required)
   * @param campaign Update campaign (required)
   * @return Call&lt;UpdateCampaign&gt;
   */
  @PATCH("v3/update-campaigns/{campaign_id}/")
  Call<UpdateCampaign> updateCampaignPartialUpdate(
    @retrofit2.http.Path(value = "campaign_id", encoded = true) String campaignId, @retrofit2.http.Body UpdateCampaignPatchRequest campaign
  );

  /**
   * 
   * Get an update campaign.
   * @param campaignId The campaign ID (required)
   * @return Call&lt;UpdateCampaign&gt;
   */
  @GET("v3/update-campaigns/{campaign_id}/")
  Call<UpdateCampaign> updateCampaignRetrieve(
    @retrofit2.http.Path(value = "campaign_id", encoded = true) String campaignId
  );

  /**
   * 
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
   * 
   * Get update campaign metadata.
   * @param campaignId The update campaign ID (required)
   * @param campaignDeviceMetadataId The campaign device metadata ID (required)
   * @return Call&lt;CampaignDeviceMetadata&gt;
   */
  @GET("v3/update-campaigns/{campaign_id}/campaign-device-metadata/{campaign_device_metadata_id}/")
  Call<CampaignDeviceMetadata> v3UpdateCampaignsCampaignIdCampaignDeviceMetadataCampaignDeviceMetadataIdGet(
    @retrofit2.http.Path(value = "campaign_id", encoded = true) String campaignId, @retrofit2.http.Path(value = "campaign_device_metadata_id", encoded = true) String campaignDeviceMetadataId
  );

  /**
   * 
   * Get campaign device metadata.
   * @param campaignId The update campaign ID (required)
   * @param limit How many objects to retrieve in the page (optional)
   * @param order ASC or DESC (optional)
   * @param after The ID of the the item after which to retrieve the next page (optional)
   * @param include Comma-separated list of data fields to return. Currently supported: total_count (optional)
   * @return Call&lt;CampaignDeviceMetadataPage&gt;
   */
  @GET("v3/update-campaigns/{campaign_id}/campaign-device-metadata/")
  Call<CampaignDeviceMetadataPage> v3UpdateCampaignsCampaignIdCampaignDeviceMetadataGet(
    @retrofit2.http.Path(value = "campaign_id", encoded = true) String campaignId, @retrofit2.http.Query("limit") Integer limit, @retrofit2.http.Query("order") String order, @retrofit2.http.Query("after") String after, @retrofit2.http.Query("include") String include
  );

}
