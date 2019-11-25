package com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api;

import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
import org.joda.time.DateTime;
import java.io.File;
import org.junit.Before;
import org.junit.Test;

/**
 * API tests for DeviceUpdateFirmwareManifestsApi
 */
public class DeviceUpdateFirmwareManifestsApiTest {

    private DeviceUpdateFirmwareManifestsApi api;

    @Before
    public void setup() {
        api = new ApiClient().createService(DeviceUpdateFirmwareManifestsApi.class);
    }

    /**
     * Upload a manifest
     *
     * Upload a firmware manifest. The API enforces a maximum manifest size of 2KB. &lt;br&gt; **Usage example:**
     * &#x60;&#x60;&#x60; curl -X POST https://api.us-east-1.mbedcloud.com/v3/firmware-manifests \\ -H
     * &#39;Authorization: &lt;valid access token&gt;&#39; \\ -H &#39;Content-Type: multipart/form-data&#39; \\ -F
     * &#39;datafile&#x3D;@myimage.bin;type&#x3D;application/octet-stream&#39; \\ -F &#39;description&#x3D;bla bla&#39;
     * \\ -F &#39;key_table&#x3D;@myKeyTable.proto;type&#x3D;&#39; \\ -F &#39;name&#x3D;My Manifest&#39;
     * &#x60;&#x60;&#x60;
     */
    @Test
    public void firmwareManifestCreateTest() {
        File datafile = null;
        String description = null;
        File keyTable = null;
        String name = null;
        // FirmwareManifest response = api.firmwareManifestCreate(datafile, description, keyTable, name);

        // TODO: test validations
    }

    /**
     * Delete a manifest
     *
     * Delete a firmware manifest. &lt;br&gt; **Usage example:** &#x60;&#x60;&#x60; curl -X DELETE
     * https://api.us-east-1.mbedcloud.com/v3/firmware-manifests/12345678901234567890123456789012 \\ -H
     * &#39;Authorization: &lt;valid access token&gt;&#39; &#x60;&#x60;&#x60;
     */
    @Test
    public void firmwareManifestDestroyTest() {
        String manifestId = null;
        // Void response = api.firmwareManifestDestroy(manifestId);

        // TODO: test validations
    }

    /**
     * List all firmware manifests.
     *
     * List all firmware manifests. &lt;br&gt; **Usage example:** &#x60;&#x60;&#x60; curl -X GET
     * https://api.us-east-1.mbedcloud.com/v3/firmware-manifests \\ -H &#39;Authorization: &lt;valid access
     * token&gt;&#39; &#x60;&#x60;&#x60;
     */
    @Test
    public void firmwareManifestListTest() {
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
        Long datafileSizeEq = null;
        Long datafileSizeNeq = null;
        String datafileSizeIn = null;
        String datafileSizeNin = null;
        String descriptionEq = null;
        String descriptionNeq = null;
        String descriptionIn = null;
        String descriptionNin = null;
        String deviceClassEq = null;
        String deviceClassNeq = null;
        String deviceClassIn = null;
        String deviceClassNin = null;
        String idEq = null;
        String idNeq = null;
        String idIn = null;
        String idNin = null;
        String nameEq = null;
        String nameNeq = null;
        String nameIn = null;
        String nameNin = null;
        String timestampIn = null;
        String timestampNin = null;
        DateTime timestampLte = null;
        DateTime timestampGte = null;
        String updatedAtIn = null;
        String updatedAtNin = null;
        DateTime updatedAtLte = null;
        DateTime updatedAtGte = null;
        // FirmwareManifestPage response = api.firmwareManifestList(limit, order, after, include, filter, createdAtIn,
        // createdAtNin, createdAtLte, createdAtGte, datafileEq, datafileNeq, datafileIn, datafileNin, datafileSizeEq,
        // datafileSizeNeq, datafileSizeIn, datafileSizeNin, descriptionEq, descriptionNeq, descriptionIn,
        // descriptionNin, deviceClassEq, deviceClassNeq, deviceClassIn, deviceClassNin, idEq, idNeq, idIn, idNin,
        // nameEq, nameNeq, nameIn, nameNin, timestampIn, timestampNin, timestampLte, timestampGte, updatedAtIn,
        // updatedAtNin, updatedAtLte, updatedAtGte);

        // TODO: test validations
    }

    /**
     * Get a manifest
     *
     * Retrieve a firmware manifest. &lt;br&gt; **Usage example:** &#x60;&#x60;&#x60; curl -X GET
     * https://api.us-east-1.mbedcloud.com/v3/firmware-manifests/12345678901234567890123456789012 \\ -H
     * &#39;Authorization: &lt;valid access token&gt;&#39; &#x60;&#x60;&#x60;
     */
    @Test
    public void firmwareManifestRetrieveTest() {
        String manifestId = null;
        // FirmwareManifest response = api.firmwareManifestRetrieve(manifestId);

        // TODO: test validations
    }
}
