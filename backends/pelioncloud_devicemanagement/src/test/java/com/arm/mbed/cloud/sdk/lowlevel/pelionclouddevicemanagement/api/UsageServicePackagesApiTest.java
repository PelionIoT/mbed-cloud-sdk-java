package com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api;

import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
import org.junit.Before;
import org.junit.Test;

/**
 * API tests for UsageServicePackagesApi
 */
public class UsageServicePackagesApiTest {

    private UsageServicePackagesApi api;

    @Before
    public void setup() {
        api = new ApiClient().createService(UsageServicePackagesApi.class);
    }

    /**
     * Service package quota history.
     *
     * Get your quota usage history. This API is available only for commercial accounts. Aggregator accounts can see
     * their own and tenant quota usage data. Data is in ascending order based on creation time. **Example:**
     * &#x60;&#x60;&#x60; curl -X GET https://api.us-east-1.mbedcloud.com/v3/service-packages-quota-history \\ -H
     * &#39;Authorization: Bearer &lt;access_key&gt;&#39; &#x60;&#x60;&#x60;
     */
    @Test
    public void getServicePackageQuotaHistoryTest() {
        Integer limit = null;
        String after = null;
        String order = null;
        // ServicePackageQuotaHistoryResponse response = api.getServicePackageQuotaHistory(limit, after, order);

        // TODO: test validations
    }
}
