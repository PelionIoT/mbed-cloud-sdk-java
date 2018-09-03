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
     * Fetch the billing report generated for the currently authenticated commercial non-subtenant account. Billing reports for subtenant accounts are included in their aggregator&#39;s billing report response.  **Example usage:**      curl -X GET https://api.us-east-1.mbedcloud.com/v3/billing-report?month&#x3D;2018-07 -H &#39;authorization: Bearer {api-key}&#39;
     */
    @Test
    public void getBillingReportTest() {
        String month = null;
        // ReportResponse response = api.getBillingReport(month);

        // TODO: test validations
    }
    /**
     * Get raw billing data of the active devices for the month.
     *
     * Fetch the raw billing data of the active devices for the currently authenticated commercial non-subtenant account. This is supplementary data for the billing report. The raw billing data of the active devices for subtenant accounts are included in their aggregator&#39;s raw billing data of the active devices. The endpoint returns the URL to download the gzipped CSV file. The first line is the header providing information on the active devices. For example, the ID of an active device.  **Example usage:**      curl -X GET https://api.us-east-1.mbedcloud.com/v3/billing-report-active-devices?month&#x3D;2018-07 -H &#39;authorization: Bearer {api-key}&#39;
     */
    @Test
    public void getBillingReportActiveDevicesTest() {
        String month = null;
        // BillingReportRawDataResponse response = api.getBillingReportActiveDevices(month);

        // TODO: test validations
    }
    /**
     * Get raw billing data of the firmware updates for the month.
     *
     * Fetch raw billing data of the firmware updates for the currently authenticated commercial non-subtenant account. This is supplementary data for the billing report. The raw billing data of the firmware updates for subtenant accounts are included in their aggregator&#39;s raw billing data of the firmware updates. The endpoint returns the URL to download the gzipped CSV file. The first line is the header providing information on the firmware updates. For example, the ID of an firmware update.  **Example usage:**      curl -X GET https://api.us-east-1.mbedcloud.com/v3/billing-report-firmware-updates?month&#x3D;2018-07 -H &#39;authorization: Bearer {api-key}&#39;
     */
    @Test
    public void getBillingReportFirmwareUpdatesTest() {
        String month = null;
        // BillingReportRawDataResponse response = api.getBillingReportFirmwareUpdates(month);

        // TODO: test validations
    }
    /**
     * Service package quota.
     *
     * Get the available firmware update quota for the currently authenticated commercial account.  **Example usage:**      curl -X GET https://api.us-east-1.mbedcloud.com/v3/service-packages-quota -H &#39;authorization: Bearer {api-key}&#39; 
     */
    @Test
    public void getServicePackageQuotaTest() {
        // ServicePackageQuota response = api.getServicePackageQuota();

        // TODO: test validations
    }
    /**
     * Service package quota history.
     *
     * Get your quota usage history. This API is available for commercial accounts. Aggregator accounts can see own and subtenant quota usage data. History data is ordered in ascending order based on the added timestamp.  **Example usage:**      curl -X GET https://api.us-east-1.mbedcloud.com/v3/service-packages-quota-history -H &#39;authorization: Bearer {api-key}&#39; 
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
     * Get information of all service packages for the currently authenticated commercial account. The response is returned in descending order by service package created timestamp, listing first the pending service package, then the active service package and finally the previous service packages.  **Example usage:**      curl -X GET https://api.us-east-1.mbedcloud.com/v3/service-packages -H &#39;authorization: Bearer {api-key}&#39;
     */
    @Test
    public void getServicePackagesTest() {
        // ServicePackagesResponse response = api.getServicePackages();

        // TODO: test validations
    }
}
