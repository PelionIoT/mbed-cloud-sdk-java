package com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api;

import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.CollectionFormats.*;

import retrofit2.Call;
import retrofit2.http.*;

import okhttp3.MultipartBody;

import org.joda.time.DateTime;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.FirmwareImage;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.FirmwareImagePage;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.UploadChunkInfo;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.UploadChunkInfoPage;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.UploadJob;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.UploadJob1;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.UploadJobPage;

public interface DeviceUpdateFirmwareImagesApi {
    /**
     * Create an image Create a firmware image. &lt;br&gt; **Usage example:** &#x60;&#x60;&#x60; curl -X POST
     * https://api.us-east-1.mbedcloud.com/v3/firmware-images \\ -H &#39;Authorization: &lt;valid access token&gt;&#39;
     * \\ -H &#39;Content-Type: multipart/form-data&#39; \\ -F
     * &#39;datafile&#x3D;@myimage.bin;type&#x3D;application/octet-stream&#39; -F &#39;description&#x3D;bla bla&#39; \\
     * -F &#39;name&#x3D;My Linux Image&#39; &#x60;&#x60;&#x60;
     * 
     * @param datafile
     *            The firmware image file to upload. (required)
     * @param description
     *            The description of the firmware image. (optional)
     * @param name
     *            The name of the firmware image. (optional)
     * @return Call&lt;FirmwareImage&gt;
     */
    @retrofit2.http.Multipart
    @POST("v3/firmware-images")
    Call<FirmwareImage> firmwareImageCreate(@retrofit2.http.Part() MultipartBody.Part datafile,
                                            @retrofit2.http.Part("description") String description,
                                            @retrofit2.http.Part("name") String name);

    /**
     * Delete an image Delete a firmware image. &lt;br&gt; **Usage example:** &#x60;&#x60;&#x60; curl -X DELETE
     * https://api.us-east-1.mbedcloud.com/v3/firmware-images/12345678901234567890123456789012 \\ -H &#39;Authorization:
     * &lt;valid access token&gt;&#39; &#x60;&#x60;&#x60;
     * 
     * @param imageId
     *            The firmware image ID. (required)
     * @return Call&lt;Void&gt;
     */
    @DELETE("v3/firmware-images/{image_id}")
    Call<Void> firmwareImageDestroy(@retrofit2.http.Path(value = "image_id", encoded = true) String imageId);

    /**
     * List all images List all firmware images. &lt;br&gt; **Usage example:** &#x60;&#x60;&#x60; curl -X GET
     * https://api.us-east-1.mbedcloud.com/v3/firmware-images \\ -H &#39;Authorization: &lt;valid access token&gt;&#39;
     * &#x60;&#x60;&#x60;
     * 
     * @param limit
     *            How many objects to retrieve in the page. The minimum limit is 2 and the maximum is 1000. Limit values
     *            outside of this range are set to the closest limit. (optional)
     * @param order
     *            ASC or DESC. (optional)
     * @param after
     *            The ID of the item after which to retrieve the next page. (optional)
     * @param include
     *            A comma-separated list of data fields to return. Currently supported: total_count. (optional)
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
    @GET("v3/firmware-images")
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
     * Get an image. Retrieve a firmware image. &lt;br&gt; **Usage example:** &#x60;&#x60;&#x60; curl -X GET
     * https://api.us-east-1.mbedcloud.com/v3/firmware-images/12345678901234567890123456789012 \\ -H &#39;Authorization:
     * &lt;valid access token&gt;&#39; &#x60;&#x60;&#x60;
     * 
     * @param imageId
     *            The firmware image ID (required)
     * @return Call&lt;FirmwareImage&gt;
     */
    @GET("v3/firmware-images/{image_id}")
    Call<FirmwareImage> firmwareImageRetrieve(@retrofit2.http.Path(value = "image_id", encoded = true) String imageId);

    /**
     * Append a chunk to an upload job Append a chunk to an upload job. To finish a job, upload a zero-length chunk.
     * &lt;br&gt; **Usage example:** &#x60;&#x60;&#x60; curl -X POST
     * https://api.us-east-1.mbedcloud.com/v3/firmware-images/upload-jobs/12345678901234567890123456789012/chunks \\ -H
     * &#39;Authorization: &lt;valid access token&gt;&#39; \\ -H &#39;Content-MD5:
     * Q2h1Y2sgSW51ZwDIAXR5IQ&#x3D;&#x3D;&#39; \\ -H &#39;Content-Type: binary/octet-stream&#39; \\ -H
     * &#39;Content-Length: 999&#39; \\ -d &#39;{
     * \&quot;IGh0dHBzOi8vYXBpLnVzLWVhc3QtMS5tYmVkY2xvdWQuY29tLy92My9maXJtd2FyZS1pbWFnZXMvdXBsb2FkLWpvYnMve3VwbG9hZF9qb2JfaWR9W5rcw&#x3D;&#x3D;\&quot;
     * }&#39; &#x60;&#x60;&#x60;
     * 
     * @param contentMD5
     *            The base64-encoded binary digest of the body (chunk data). (required)
     * @param contentLength
     *            (required)
     * @param uploadJobId
     *            The upload job ID. (required)
     * @param chunk
     *            Chunk. (optional)
     * @return Call&lt;UploadChunkInfo&gt;
     */
    @Headers({ "Content-Type:application/octet-stream" })
    @POST("v3/firmware-images/upload-jobs/{upload_job_id}/chunks")
    Call<UploadChunkInfo>
        uploadJobChunkCreate(@retrofit2.http.Header("Content-MD5") byte[] contentMD5,
                             @retrofit2.http.Header("Content-Length") Integer contentLength,
                             @retrofit2.http.Path(value = "upload_job_id", encoded = true) String uploadJobId,
                             @retrofit2.http.Body byte[] chunk);

    /**
     * List all metadata for uploaded chunks List all metadata for uploaded chunks. &lt;br&gt; **Usage example:**
     * &#x60;&#x60;&#x60; curl -X GET
     * https://api.us-east-1.mbedcloud.com/v3/firmware-images/upload-jobs/12345678901234567890123456789012/chunks \\ -H
     * &#39;Authorization: &lt;valid access token&gt;&#39; &#x60;&#x60;&#x60;
     * 
     * @param uploadJobId
     *            The upload job ID. (required)
     * @param limit
     *            How many objects to retrieve in the page. The minimum limit is 2 and the maximum is 1000. Limit values
     *            outside of this range are set to the closest limit. (optional)
     * @param order
     *            ASC or DESC. (optional)
     * @param after
     *            The ID of the item after which to retrieve the next page. (optional)
     * @param include
     *            A comma-separated list of data fields to return. Currently supported: total_count. (optional)
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
     * Get metadata about a chunk Get metadata about a chunk. &lt;br&gt; **Usage example:** &#x60;&#x60;&#x60; curl -X
     * GET
     * https://api.us-east-1.mbedcloud.com/v3/firmware-images/upload-jobs/12345678901234567890123456789012/chunks/12345678901234567890123456789012
     * \\ -H &#39;Authorization: &lt;valid access token&gt;&#39; &#x60;&#x60;&#x60;
     * 
     * @param uploadJobId
     *            The upload job ID. (required)
     * @param chunkId
     *            Chunk. (required)
     * @return Call&lt;UploadChunkInfo&gt;
     */
    @GET("v3/firmware-images/upload-jobs/{upload_job_id}/chunks/{chunk_id}")
    Call<UploadChunkInfo>
        uploadJobChunkRetreive(@retrofit2.http.Path(value = "upload_job_id", encoded = true) String uploadJobId,
                               @retrofit2.http.Path(value = "chunk_id", encoded = true) String chunkId);

    /**
     * Create a new upload job. Create a new upload job &lt;br&gt; **Usage example:** &#x60;&#x60;&#x60; curl -X POST
     * https://api.us-east-1.mbedcloud.com/v3/firmware-images/upload-jobs \\ -H &#39;Authorization: &lt;valid access
     * token&gt;&#39; \\ -H &#39;content-type: application/json;charset&#x3D;UTF-8&#39; \\ -d &#39;{ \&quot;name\&quot;:
     * \&quot;New Linux update\&quot;, \&quot;description\&quot;: \&quot;New Linux update for my devices\&quot; }&#39;
     * &#x60;&#x60;&#x60;
     * 
     * @param uploadJob
     *            Upload job. (required)
     * @return Call&lt;UploadJob&gt;
     */
    @POST("v3/firmware-images/upload-jobs")
    Call<UploadJob> uploadJobCreate(@retrofit2.http.Body UploadJob uploadJob);

    /**
     * Delete an upload job Delete an upload job. &lt;br&gt; **Usage example:** &#x60;&#x60;&#x60; curl -X DELETE
     * https://api.us-east-1.mbedcloud.com/v3/firmware-images/upload-jobs/12345678901234567890123456789012 \\ -H
     * &#39;Authorization: &lt;valid access token&gt;&#39; &#x60;&#x60;&#x60;
     * 
     * @param uploadJobId
     *            The upload job ID. (required)
     * @return Call&lt;Void&gt;
     */
    @DELETE("v3/firmware-images/upload-jobs/{upload_job_id}")
    Call<Void> uploadJobDelete(@retrofit2.http.Path(value = "upload_job_id", encoded = true) String uploadJobId);

    /**
     * Get all upload jobs Get all upload jobs. &lt;br&gt; **Usage example:** &#x60;&#x60;&#x60; curl -X GET
     * https://api.us-east-1.mbedcloud.com/v3/firmware-images/upload-jobs \\ -H &#39;Authorization: &lt;valid access
     * token&gt;&#39; &#x60;&#x60;&#x60;
     * 
     * @param limit
     *            How many objects to retrieve in the page. The minimum limit is 2 and the maximum is 1000. Limit values
     *            outside of this range are set to the closest limit. (optional)
     * @param order
     *            ASC or DESC. (optional)
     * @param after
     *            The ID of the item after which to retrieve the next page. (optional)
     * @param include
     *            A comma-separated list of data fields to return. Currently supported: total_count. (optional)
     * @param filter
     *            URL-encoded query string parameter to filter returned data. &#x60;?filter&#x3D;{URL-encoded query
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
     * Retrieve information for an upload job Get an upload job. &lt;br&gt; **Usage example:** &#x60;&#x60;&#x60; curl
     * -X GET https://api.us-east-1.mbedcloud.com/v3/firmware-images/upload-jobs/12345678901234567890123456789012 \\ -H
     * &#39;Authorization: &lt;valid access token&gt;&#39; &#x60;&#x60;&#x60;
     * 
     * @param uploadJobId
     *            The upload job ID. (required)
     * @return Call&lt;UploadJob&gt;
     */
    @GET("v3/firmware-images/upload-jobs/{upload_job_id}")
    Call<UploadJob> uploadJobRetrieve(@retrofit2.http.Path(value = "upload_job_id", encoded = true) String uploadJobId);

    /**
     * Update an upload job Update an upload job. &lt;br&gt; **Usage example:** &#x60;&#x60;&#x60; curl -X PUT
     * https://api.us-east-1.mbedcloud.com/v3/firmware-images/upload-jobs/12345678901234567890123456789012 \\ -H
     * &#39;Authorization: &lt;valid access token&gt;&#39; \\ -d &#39;{ \&quot;name\&quot;: \&quot;New Linux
     * update\&quot;, \&quot;description\&quot;: \&quot;New Linux update for my class XX devices\&quot; }&#39;
     * &#x60;&#x60;&#x60;
     * 
     * @param uploadJobId
     *            The upload job ID. (required)
     * @param uploadJob
     *            Upload job. (required)
     * @return Call&lt;UploadJob&gt;
     */
    @PUT("v3/firmware-images/upload-jobs/{upload_job_id}")
    Call<UploadJob> uploadJobUpdate(@retrofit2.http.Path(value = "upload_job_id", encoded = true) String uploadJobId,
                                    @retrofit2.http.Body UploadJob1 uploadJob);

}
