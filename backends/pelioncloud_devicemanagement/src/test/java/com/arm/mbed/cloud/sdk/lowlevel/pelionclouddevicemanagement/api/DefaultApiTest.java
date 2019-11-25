package com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api;

import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
import org.junit.Before;
import org.junit.Test;

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
     * Fetch the billing report generated for the currently authenticated commercial non-subtenant account. Billing
     * reports for subtenant accounts are included in their aggregator&#39;s billing report response. **Example:**
     * &#x60;&#x60;&#x60; curl -X GET https://api.us-east-1.mbedcloud.com/v3/billing-report?month&#x3D;2018-07 \\ -H
     * &#39;Authorization: Bearer &lt;api_key&gt;&#39; &#x60;&#x60;&#x60;
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
     * Fetch raw billing data for active devices for the currently authenticated commercial non-subtenant account. This
     * is supplementary data for the billing report. The raw billing data of the active devices for subtenant accounts
     * are included in their aggregator&#39;s raw billing data of the active devices. The endpoint returns the URL to
     * download the gzipped CSV file. The first line is the header providing information on active devices, for example,
     * the ID of an active device. **Example:** &#x60;&#x60;&#x60; curl -X GET
     * https://api.us-east-1.mbedcloud.com/v3/billing-report-active-devices?month&#x3D;2018-07 \\ -H &#39;Authorization:
     * Bearer &lt;api_key&gt;&#39; &#x60;&#x60;&#x60;
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
     * Fetch raw billing data for firmware updates for the currently authenticated commercial non-subtenant account.
     * This is supplementary data for the billing report. The raw billing data of the firmware updates for subtenant
     * accounts are included in their aggregator&#39;s raw billing data of the firmware updates. The endpoint returns
     * the URL to download the gzipped CSV file. The first line is the header providing information on the firmware
     * updates, for example, the ID of a firmware update. **Example:** &#x60;&#x60;&#x60; curl -X GET
     * https://api.us-east-1.mbedcloud.com/v3/billing-report-firmware-updates?month&#x3D;2018-07 \\ -H
     * &#39;Authorization: Bearer &lt;api_key&gt;&#39; &#x60;&#x60;&#x60;
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
     * Get the available firmware update quota for the current authenticated commercial account. **Example:**
     * &#x60;&#x60;&#x60; curl -X GET https://api.us-east-1.mbedcloud.com/v3/service-packages-quota \\ -H
     * &#39;Authorization: Bearer &lt;api_key&gt;&#39; &#x60;&#x60;&#x60;
     */
    @Test
    public void getServicePackageQuotaTest() {
        // ServicePackageQuota response = api.getServicePackageQuota();

        // TODO: test validations
    }

    /**
     * Service package quota history.
     *
     * Get your quota usage history. This API is available only for commercial accounts. Aggregator accounts can see
     * their own and subtenant quota usage data. Data is in ascending order based on the added timestamp. **Example:**
     * &#x60;&#x60;&#x60; curl -X GET https://api.us-east-1.mbedcloud.com/v3/service-packages-quota-history \\ -H
     * &#39;Authorization: Bearer &lt;api_key&gt;&#39; &#x60;&#x60;&#x60;
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
     * Get information for all service packages for the current authenticated commercial account. The response is
     * returned in descending order by service package created timestamp: first the pending service package, then the
     * active service package, then the previous service packages. **Example:** &#x60;&#x60;&#x60; curl -X GET
     * https://api.us-east-1.mbedcloud.com/v3/service-packages \\ -H &#39;Authorization: Bearer &lt;api_key&gt;&#39;
     * &#x60;&#x60;&#x60;
     */
    @Test
    public void getServicePackagesTest() {
        // ServicePackagesResponse response = api.getServicePackages();

        // TODO: test validations
    }
}
