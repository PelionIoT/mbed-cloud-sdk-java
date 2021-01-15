package com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api;

import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
import org.joda.time.LocalDate;
import org.junit.Before;
import org.junit.Test;

/**
 * API tests for UsageServiceMetricsApi
 */
public class UsageServiceMetricsApiTest {

    private UsageServiceMetricsApi api;

    @Before
    public void setup() {
        api = new ApiClient().createService(UsageServiceMetricsApi.class);
    }

    /**
     * Provides account-specific statistics for other cloud services.
     *
     * Get account-specific statistics.
     */
    @Test
    public void getMetricsTest() {
        String include = null;
        String interval = null;
        LocalDate start = null;
        LocalDate end = null;
        String period = null;
        Integer limit = null;
        String after = null;
        String order = null;
        // SuccessfulResponse response = api.getMetrics(include, interval, start, end, period, limit, after, order);

        // TODO: test validations
    }
}
