package com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api;

import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
import org.joda.time.LocalDate;
import org.junit.Before;
import org.junit.Test;

/**
 * API tests for StatisticsApi
 */
public class StatisticsApiTest {

    private StatisticsApi api;

    @Before
    public void setup() {
        api = new ApiClient().createService(StatisticsApi.class);
    }

    /**
     * Provides account-specific statistics for other cloud services.
     *
     * This REST API is used to get account-specific statistics.
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
