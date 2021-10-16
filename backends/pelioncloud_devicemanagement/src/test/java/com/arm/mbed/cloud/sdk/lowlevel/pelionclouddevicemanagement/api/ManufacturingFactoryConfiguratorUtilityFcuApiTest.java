package com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api;

import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
import org.junit.Before;
import org.junit.Test;

/**
 * API tests for ManufacturingFactoryConfiguratorUtilityFcuApi
 */
public class ManufacturingFactoryConfiguratorUtilityFcuApiTest {

    private ManufacturingFactoryConfiguratorUtilityFcuApi api;

    @Before
    public void setup() {
        api = new ApiClient().createService(ManufacturingFactoryConfiguratorUtilityFcuApi.class);
    }

    /**
     * Download the Factory Configurator Utility archive.
     *
     * Downloads the Factory Configurator Utility (FCU) archive .zip file for the account ID associated with the access
     * token. &lt;br&gt; **Example:** &lt;br&gt; &#x60;&#x60;&#x60; curl -X GET
     * https://api.us-east-1.mbedcloud.com/downloads/fcu/factory_configurator_utility.zip \\ -H &#39;Authorization:
     * Bearer &lt;access_key&gt;&#39; &#x60;&#x60;&#x60;
     */
    @Test
    public void downloadFactoryToolTest() {
        // Void response = api.downloadFactoryTool();

        // TODO: test validations
    }

    /**
     * Download information about the Factory Configurator Utility archive.
     *
     * Returns information about the Factory Configurator Utility (FCU) archive. &lt;br&gt; **Example:** &lt;br&gt;
     * &#x60;&#x60;&#x60; curl -X GET https://api.us-east-1.mbedcloud.com/downloads/fcu/inf \\ -H &#39;Authorization:
     * Bearer &lt;access_key&gt;&#39; &#x60;&#x60;&#x60;
     */
    @Test
    public void getFactoryToolInfoTest() {
        // ArchiveInfoResponse response = api.getFactoryToolInfo();

        // TODO: test validations
    }

    /**
     * Download Factory Configurator Utility release notes.
     *
     * Downloads the Factory Configurator Utility (FCU) release notes. &lt;br&gt; **Example:** &lt;br&gt;
     * &#x60;&#x60;&#x60; curl -X GET https://api.us-east-1.mbedcloud.com/downloads/fcu/release_notes \\ -H
     * &#39;Authorization: Bearer &lt;access_key&gt;&#39; &#x60;&#x60;&#x60;
     */
    @Test
    public void getFactoryToolReleaseNotesTest() {
        // Void response = api.getFactoryToolReleaseNotes();

        // TODO: test validations
    }
}
