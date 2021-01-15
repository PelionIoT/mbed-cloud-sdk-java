package com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api;

import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;

/**
 * API tests for FactoryManufacturingStatisticsApi
 */
public class FactoryManufacturingStatisticsApiTest {

    private FactoryManufacturingStatisticsApi api;

    @Before
    public void setup() {
        api = new ApiClient().createService(FactoryManufacturingStatisticsApi.class);
    }

    /**
     * Retrieve provisioning statistics for devices in your factories.
     *
     * Get manufacturing statistics report. **Example:** &#x60;&#x60;&#x60; curl -X GET
     * https://api.us-east-1.mbedcloud.com/v3/manufacturing/statistics?start&#x3D;2020-06-23T21:00:00.000Z&amp;end&#x3D;2020-07-01T20:59:59.999Z
     * --header &#39;Authorization: Bearer &lt;access_key&gt;&#39; &#x60;&#x60;&#x60;
     */
    @Test
    public void manufacturingStatisticsReportTest() {
        DateTime start = null;
        DateTime end = null;
        // StatisticsReportListResponse response = api.manufacturingStatisticsReport(start, end);

        // TODO: test validations
    }
}
