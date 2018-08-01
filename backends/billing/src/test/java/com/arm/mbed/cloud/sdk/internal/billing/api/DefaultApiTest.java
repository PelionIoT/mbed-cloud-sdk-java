package com.arm.mbed.cloud.sdk.internal.billing.api;

import com.arm.mbed.cloud.sdk.internal.billing.ApiClient;
import com.arm.mbed.cloud.sdk.internal.billing.model.BadRequestErrorResponse;
import com.arm.mbed.cloud.sdk.internal.billing.model.BillingReportRawDataResponse;
import com.arm.mbed.cloud.sdk.internal.billing.model.ForbiddenErrorResponse;
import com.arm.mbed.cloud.sdk.internal.billing.model.InternalServerErrorResponse;
import com.arm.mbed.cloud.sdk.internal.billing.model.ReportNotFoundErrorResponse;
import com.arm.mbed.cloud.sdk.internal.billing.model.ReportResponse;
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
     * Get billing report.
     *
     * Fetch generated billing report for the currently authenticated commercial non-subtenant account. Billing reports for subtenant accounts are included in their aggregator&#39;s billing report response.
     */
    @Test
    public void getBillingReportTest() {
        String month = null;
        // ReportResponse response = api.getBillingReport(month);

        // TODO: test validations
    }
    /**
     * Get raw active devices billing data for the month.
     *
     * Fetch raw active devices billing data for the currently authenticated commercial non-subtenant account. They are supplementary data for billing report. The raw active devices billing data for subtenant accounts are included in their aggregator&#39;s raw active devices billing data. Endpoint returns the URL to download the gzipped csv file. First line of the file is the header which describes information of active devices included, e.g. active device ID.
     */
    @Test
    public void getBillingReportActiveDevicesTest() {
        String month = null;
        // BillingReportRawDataResponse response = api.getBillingReportActiveDevices(month);

        // TODO: test validations
    }
    /**
     * Get raw firmware updates billing data for the month.
     *
     * Fetch raw firmware updates billing data for the currently authenticated commercial non-subtenant account. They are supplementary data for billing report. The raw firmware updates billing data for subtenant accounts are included in their aggregator&#39;s raw firmware updates billing data. Endpoint returns the URL to download the gzipped csv file. First line of the file is the header which describes information of firmware updates included, e.g. firmware update device ID.
     */
    @Test
    public void getBillingReportFirmwareUpdatesTest() {
        String month = null;
        // BillingReportRawDataResponse response = api.getBillingReportFirmwareUpdates(month);

        // TODO: test validations
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
