package com.arm.mbed.cloud.sdk.internal.billing.api;

import com.arm.mbed.cloud.sdk.internal.billing.ApiClient;
import com.arm.mbed.cloud.sdk.internal.billing.model.ForbiddenErrorResponse;
import com.arm.mbed.cloud.sdk.internal.billing.model.InternalServerErrorResponse;
import com.arm.mbed.cloud.sdk.internal.billing.model.ServicePackageQuota;
import com.arm.mbed.cloud.sdk.internal.billing.model.ServicePackageQuotaHistoryResponse;
import com.arm.mbed.cloud.sdk.internal.billing.model.ServicePackagesResponse;
import com.arm.mbed.cloud.sdk.internal.billing.model.UnauthorizedErrorResponse;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for DefaultApi
 */
public class DefaultApiTest {

    private DefaultApi api;

    @Before
    public void setup() {
        api = new ApiClient().createService(DefaultApi.class);
    }

    /**
     * Service package quota
     *
     * Get the available firmware update quota for the currently authenticated commercial acount.
     */
    @Test
    public void getServicePackageQuotaTest() {
        // ServicePackageQuota response = api.getServicePackageQuota();

        // TODO: test validations
    }
    /**
     * Service package quota history
     *
     * Get your quota usage history. This API is available for commercial accounts. Aggregator accounts can see own and subtenant quota usage data. History data is ordered in ascending order based on the added timestamp. 
     */
    @Test
    public void getServicePackageQuotaHistoryTest() {
        Integer limit = null;
        String after = null;
        // ServicePackageQuotaHistoryResponse response = api.getServicePackageQuotaHistory(limit, after);

        // TODO: test validations
    }
    /**
     * Get all service packages.
     *
     * Get information of all service packages for currently authenticated commercial account. The response is returned with descending order by service package created timestamp, listing first pending service package, then active service package, and previous service packages at last.
     */
    @Test
    public void getServicePackagesTest() {
        // ServicePackagesResponse response = api.getServicePackages();

        // TODO: test validations
    }
}
