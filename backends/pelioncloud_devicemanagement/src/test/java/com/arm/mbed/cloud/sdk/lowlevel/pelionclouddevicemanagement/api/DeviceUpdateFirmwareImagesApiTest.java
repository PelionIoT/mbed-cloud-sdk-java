package com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api;

import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
import org.joda.time.DateTime;
import java.io.File;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.UploadJob;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.UploadJob1;
import org.junit.Before;
import org.junit.Test;

/**
 * API tests for DeviceUpdateFirmwareImagesApi
 */
public class DeviceUpdateFirmwareImagesApiTest {

    private DeviceUpdateFirmwareImagesApi api;

    @Before
    public void setup() {
        api = new ApiClient().createService(DeviceUpdateFirmwareImagesApi.class);
    }

    /**
     * Create an image
     *
     * Create a firmware image. &lt;br&gt; **Usage example:** &#x60;&#x60;&#x60; curl -X POST
     * https://api.us-east-1.mbedcloud.com/v3/firmware-images \\ -H &#39;Authorization: &lt;valid access token&gt;&#39;
     * \\ -H &#39;Content-Type: multipart/form-data&#39; \\ -F
     * &#39;datafile&#x3D;@myimage.bin;type&#x3D;application/octet-stream&#39; -F &#39;description&#x3D;bla bla&#39; \\
     * -F &#39;name&#x3D;My Linux Image&#39; &#x60;&#x60;&#x60;
     */
    @Test
    public void firmwareImageCreateTest() {
        File datafile = null;
        String description = null;
        String name = null;
        // FirmwareImage response = api.firmwareImageCreate(datafile, description, name);

        // TODO: test validations
    }

    /**
     * Delete an image
     *
     * Delete a firmware image. &lt;br&gt; **Usage example:** &#x60;&#x60;&#x60; curl -X DELETE
     * https://api.us-east-1.mbedcloud.com/v3/firmware-images/12345678901234567890123456789012 \\ -H &#39;Authorization:
     * &lt;valid access token&gt;&#39; &#x60;&#x60;&#x60;
     */
    @Test
    public void firmwareImageDestroyTest() {
        String imageId = null;
        // Void response = api.firmwareImageDestroy(imageId);

        // TODO: test validations
    }

    /**
     * List all images
     *
     * List all firmware images. &lt;br&gt; **Usage example:** &#x60;&#x60;&#x60; curl -X GET
     * https://api.us-east-1.mbedcloud.com/v3/firmware-images \\ -H &#39;Authorization: &lt;valid access token&gt;&#39;
     * &#x60;&#x60;&#x60;
     */
    @Test
    public void firmwareImageListTest() {
        Integer limit = null;
        String order = null;
        String after = null;
        String include = null;
        String filter = null;
        String createdAtIn = null;
        String createdAtNin = null;
        DateTime createdAtLte = null;
        DateTime createdAtGte = null;
        String datafileEq = null;
        String datafileNeq = null;
        String datafileIn = null;
        String datafileNin = null;
        String datafileChecksumEq = null;
        String datafileChecksumNeq = null;
        String datafileChecksumIn = null;
        String datafileChecksumNin = null;
        Long datafileSizeEq = null;
        Long datafileSizeNeq = null;
        String datafileSizeIn = null;
        String datafileSizeNin = null;
        String descriptionEq = null;
        String descriptionNeq = null;
        String descriptionIn = null;
        String descriptionNin = null;
        String idEq = null;
        String idNeq = null;
        String idIn = null;
        String idNin = null;
        String nameEq = null;
        String nameNeq = null;
        String nameIn = null;
        String nameNin = null;
        String updatedAtIn = null;
        String updatedAtNin = null;
        DateTime updatedAtLte = null;
        DateTime updatedAtGte = null;
        // FirmwareImagePage response = api.firmwareImageList(limit, order, after, include, filter, createdAtIn,
        // createdAtNin, createdAtLte, createdAtGte, datafileEq, datafileNeq, datafileIn, datafileNin,
        // datafileChecksumEq, datafileChecksumNeq, datafileChecksumIn, datafileChecksumNin, datafileSizeEq,
        // datafileSizeNeq, datafileSizeIn, datafileSizeNin, descriptionEq, descriptionNeq, descriptionIn,
        // descriptionNin, idEq, idNeq, idIn, idNin, nameEq, nameNeq, nameIn, nameNin, updatedAtIn, updatedAtNin,
        // updatedAtLte, updatedAtGte);

        // TODO: test validations
    }

    /**
     * Get an image.
     *
     * Retrieve a firmware image. &lt;br&gt; **Usage example:** &#x60;&#x60;&#x60; curl -X GET
     * https://api.us-east-1.mbedcloud.com/v3/firmware-images/12345678901234567890123456789012 \\ -H &#39;Authorization:
     * &lt;valid access token&gt;&#39; &#x60;&#x60;&#x60;
     */
    @Test
    public void firmwareImageRetrieveTest() {
        String imageId = null;
        // FirmwareImage response = api.firmwareImageRetrieve(imageId);

        // TODO: test validations
    }

    /**
     * Append a chunk to an upload job
     *
     * Append a chunk to an upload job. To finish a job, upload a zero-length chunk. &lt;br&gt; **Usage example:**
     * &#x60;&#x60;&#x60; curl -X POST
     * https://api.us-east-1.mbedcloud.com/v3/firmware-images/upload-jobs/12345678901234567890123456789012/chunks \\ -H
     * &#39;Authorization: &lt;valid access token&gt;&#39; \\ -H &#39;Content-MD5:
     * Q2h1Y2sgSW51ZwDIAXR5IQ&#x3D;&#x3D;&#39; \\ -H &#39;Content-Type: binary/octet-stream&#39; \\ -H
     * &#39;Content-Length: 999&#39; \\ -d &#39;{
     * \&quot;IGh0dHBzOi8vYXBpLnVzLWVhc3QtMS5tYmVkY2xvdWQuY29tLy92My9maXJtd2FyZS1pbWFnZXMvdXBsb2FkLWpvYnMve3VwbG9hZF9qb2JfaWR9W5rcw&#x3D;&#x3D;\&quot;
     * }&#39; &#x60;&#x60;&#x60;
     */
    @Test
    public void uploadJobChunkCreateTest() {
        byte[] contentMD5 = null;
        Integer contentLength = null;
        String uploadJobId = null;
        byte[] chunk = null;
        // UploadChunkInfo response = api.uploadJobChunkCreate(contentMD5, contentLength, uploadJobId, chunk);

        // TODO: test validations
    }

    /**
     * List all metadata for uploaded chunks
     *
     * List all metadata for uploaded chunks. &lt;br&gt; **Usage example:** &#x60;&#x60;&#x60; curl -X GET
     * https://api.us-east-1.mbedcloud.com/v3/firmware-images/upload-jobs/12345678901234567890123456789012/chunks \\ -H
     * &#39;Authorization: &lt;valid access token&gt;&#39; &#x60;&#x60;&#x60;
     */
    @Test
    public void uploadJobChunkListTest() {
        String uploadJobId = null;
        Integer limit = null;
        String order = null;
        String after = null;
        String include = null;
        String filter = null;
        String createdAtIn = null;
        String createdAtNin = null;
        DateTime createdAtLte = null;
        DateTime createdAtGte = null;
        Integer idEq = null;
        Integer idNeq = null;
        String idIn = null;
        String idNin = null;
        String updatedAtIn = null;
        String updatedAtNin = null;
        DateTime updatedAtLte = null;
        DateTime updatedAtGte = null;
        String hashEq = null;
        String hashNeq = null;
        String hashIn = null;
        String hashNin = null;
        Integer lengthEq = null;
        Integer lengthNeq = null;
        String lengthIn = null;
        String lengthNin = null;
        Integer lengthLte = null;
        Integer lengthGte = null;
        // UploadChunkInfoPage response = api.uploadJobChunkList(uploadJobId, limit, order, after, include, filter,
        // createdAtIn, createdAtNin, createdAtLte, createdAtGte, idEq, idNeq, idIn, idNin, updatedAtIn, updatedAtNin,
        // updatedAtLte, updatedAtGte, hashEq, hashNeq, hashIn, hashNin, lengthEq, lengthNeq, lengthIn, lengthNin,
        // lengthLte, lengthGte);

        // TODO: test validations
    }

    /**
     * Get metadata about a chunk
     *
     * Get metadata about a chunk. &lt;br&gt; **Usage example:** &#x60;&#x60;&#x60; curl -X GET
     * https://api.us-east-1.mbedcloud.com/v3/firmware-images/upload-jobs/12345678901234567890123456789012/chunks/12345678901234567890123456789012
     * \\ -H &#39;Authorization: &lt;valid access token&gt;&#39; &#x60;&#x60;&#x60;
     */
    @Test
    public void uploadJobChunkRetreiveTest() {
        String uploadJobId = null;
        String chunkId = null;
        // UploadChunkInfo response = api.uploadJobChunkRetreive(uploadJobId, chunkId);

        // TODO: test validations
    }

    /**
     * Create a new upload job.
     *
     * Create a new upload job &lt;br&gt; **Usage example:** &#x60;&#x60;&#x60; curl -X POST
     * https://api.us-east-1.mbedcloud.com/v3/firmware-images/upload-jobs \\ -H &#39;Authorization: &lt;valid access
     * token&gt;&#39; \\ -H &#39;content-type: application/json;charset&#x3D;UTF-8&#39; \\ -d &#39;{ \&quot;name\&quot;:
     * \&quot;New Linux update\&quot;, \&quot;description\&quot;: \&quot;New Linux update for my devices\&quot; }&#39;
     * &#x60;&#x60;&#x60;
     */
    @Test
    public void uploadJobCreateTest() {
        UploadJob uploadJob = null;
        // UploadJob response = api.uploadJobCreate(uploadJob);

        // TODO: test validations
    }

    /**
     * Delete an upload job
     *
     * Delete an upload job. &lt;br&gt; **Usage example:** &#x60;&#x60;&#x60; curl -X DELETE
     * https://api.us-east-1.mbedcloud.com/v3/firmware-images/upload-jobs/12345678901234567890123456789012 \\ -H
     * &#39;Authorization: &lt;valid access token&gt;&#39; &#x60;&#x60;&#x60;
     */
    @Test
    public void uploadJobDeleteTest() {
        String uploadJobId = null;
        // Void response = api.uploadJobDelete(uploadJobId);

        // TODO: test validations
    }

    /**
     * Get all upload jobs
     *
     * Get all upload jobs. &lt;br&gt; **Usage example:** &#x60;&#x60;&#x60; curl -X GET
     * https://api.us-east-1.mbedcloud.com/v3/firmware-images/upload-jobs \\ -H &#39;Authorization: &lt;valid access
     * token&gt;&#39; &#x60;&#x60;&#x60;
     */
    @Test
    public void uploadJobListTest() {
        Integer limit = null;
        String order = null;
        String after = null;
        String include = null;
        String filter = null;
        String updatedAtIn = null;
        String updatedAtNin = null;
        DateTime updatedAtLte = null;
        DateTime updatedAtGte = null;
        String nameEq = null;
        String nameNeq = null;
        String nameIn = null;
        String nameNin = null;
        String createdAtIn = null;
        String createdAtNin = null;
        DateTime createdAtLte = null;
        DateTime createdAtGte = null;
        String descriptionEq = null;
        String descriptionNeq = null;
        String descriptionIn = null;
        String descriptionNin = null;
        String idEq = null;
        String idNeq = null;
        String idIn = null;
        String idNin = null;
        Boolean completeEq = null;
        Boolean completeNeq = null;
        String statusEq = null;
        String statusNeq = null;
        String statusIn = null;
        String statusNin = null;
        // UploadJobPage response = api.uploadJobList(limit, order, after, include, filter, updatedAtIn, updatedAtNin,
        // updatedAtLte, updatedAtGte, nameEq, nameNeq, nameIn, nameNin, createdAtIn, createdAtNin, createdAtLte,
        // createdAtGte, descriptionEq, descriptionNeq, descriptionIn, descriptionNin, idEq, idNeq, idIn, idNin,
        // completeEq, completeNeq, statusEq, statusNeq, statusIn, statusNin);

        // TODO: test validations
    }

    /**
     * Retrieve information for an upload job
     *
     * Get an upload job. &lt;br&gt; **Usage example:** &#x60;&#x60;&#x60; curl -X GET
     * https://api.us-east-1.mbedcloud.com/v3/firmware-images/upload-jobs/12345678901234567890123456789012 \\ -H
     * &#39;Authorization: &lt;valid access token&gt;&#39; &#x60;&#x60;&#x60;
     */
    @Test
    public void uploadJobRetrieveTest() {
        String uploadJobId = null;
        // UploadJob response = api.uploadJobRetrieve(uploadJobId);

        // TODO: test validations
    }

    /**
     * Update an upload job
     *
     * Update an upload job. &lt;br&gt; **Usage example:** &#x60;&#x60;&#x60; curl -X PUT
     * https://api.us-east-1.mbedcloud.com/v3/firmware-images/upload-jobs/12345678901234567890123456789012 \\ -H
     * &#39;Authorization: &lt;valid access token&gt;&#39; \\ -d &#39;{ \&quot;name\&quot;: \&quot;New Linux
     * update\&quot;, \&quot;description\&quot;: \&quot;New Linux update for my class XX devices\&quot; }&#39;
     * &#x60;&#x60;&#x60;
     */
    @Test
    public void uploadJobUpdateTest() {
        String uploadJobId = null;
        UploadJob1 uploadJob = null;
        // UploadJob response = api.uploadJobUpdate(uploadJobId, uploadJob);

        // TODO: test validations
    }
}
