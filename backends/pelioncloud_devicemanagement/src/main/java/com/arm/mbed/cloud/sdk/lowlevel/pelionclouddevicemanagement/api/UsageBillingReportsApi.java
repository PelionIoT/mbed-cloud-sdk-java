package com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api;

import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.CollectionFormats.*;

import retrofit2.Call;
import retrofit2.http.*;

import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.BillingReportRawDataResponse;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.ReportResponse;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.ServicePackageQuota;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.ServicePackagesResponse;

public interface UsageBillingReportsApi {
    /**
     * Get billing report. Fetch the billing report generated for the currently authenticated commercial account. The
     * billing reports for tenant accounts are also included in their aggregator&#39;s billing report response. The
     * response contains below additional counters when the account&#39;s business model is set to &#x60;API calls&#x60;
     * by the account administrator. - rest_api_requests_with_user_token - rest_api_requests_with_api_key_token -
     * pelion_to_webapp_notifications - device_to_pelion_messages - pelion_to_device_messages **Example:**
     * &#x60;&#x60;&#x60; curl -X GET https://api.us-east-1.mbedcloud.com/v3/billing-report?month&#x3D;2018-07 \\ -H
     * &#39;Authorization: Bearer &lt;access_key&gt;&#39; &#x60;&#x60;&#x60;
     * 
     * @param month
     *            Queried year and month of billing report. (required)
     * @return Call&lt;ReportResponse&gt;
     */
    @GET("v3/billing-report")
    Call<ReportResponse> getBillingReport(@retrofit2.http.Query("month") String month);

    /**
     * Get raw billing data of the active devices for the month. Fetch raw billing data for active devices for the
     * currently authenticated commercial account. This is supplementary data for the billing report. The raw billing
     * data of the active devices for tenant accounts are included in their aggregator&#39;s raw billing data of the
     * active devices. The endpoint returns the URL to download the gzipped CSV file. The first line is the header
     * providing information on active devices, for example, the ID of an active device. **Example:** &#x60;&#x60;&#x60;
     * curl -X GET https://api.us-east-1.mbedcloud.com/v3/billing-report-active-devices?month&#x3D;2018-07 \\ -H
     * &#39;Authorization: Bearer &lt;access_key&gt;&#39; &#x60;&#x60;&#x60;
     * 
     * @param month
     *            Queried year and month of billing report. (required)
     * @return Call&lt;BillingReportRawDataResponse&gt;
     */
    @GET("v3/billing-report-active-devices")
    Call<BillingReportRawDataResponse> getBillingReportActiveDevices(@retrofit2.http.Query("month") String month);

    /**
     * Get raw billing data of the firmware updates for the month. Fetch raw billing data for firmware updates for the
     * currently authenticated commercial account. This is supplementary data for the billing report. The raw billing
     * data of the firmware updates for tenant accounts are also included in their aggregator&#39;s raw billing data of
     * the firmware updates. The endpoint returns the URL to download the gzipped CSV file. The first line is the header
     * providing information on the firmware updates, for example, the ID of a firmware update. **Example:**
     * &#x60;&#x60;&#x60; curl -X GET
     * https://api.us-east-1.mbedcloud.com/v3/billing-report-firmware-updates?month&#x3D;2018-07 \\ -H
     * &#39;Authorization: Bearer &lt;access_key&gt;&#39; &#x60;&#x60;&#x60;
     * 
     * @param month
     *            Queried year and month of billing report. (required)
     * @return Call&lt;BillingReportRawDataResponse&gt;
     */
    @GET("v3/billing-report-firmware-updates")
    Call<BillingReportRawDataResponse> getBillingReportFirmwareUpdates(@retrofit2.http.Query("month") String month);

    /**
     * Service package quota. Get the available firmware update quota for the current authenticated commercial account.
     * **Example:** &#x60;&#x60;&#x60; curl -X GET https://api.us-east-1.mbedcloud.com/v3/service-packages-quota \\ -H
     * &#39;Authorization: Bearer &lt;access_key&gt;&#39; &#x60;&#x60;&#x60;
     * 
     * @return Call&lt;ServicePackageQuota&gt;
     */
    @GET("v3/service-packages-quota")
    Call<ServicePackageQuota> getServicePackageQuota();

    /**
     * Get all service packages. Get information for all service packages for the current authenticated commercial
     * account. The response is returned in descending order by service package created timestamp: first the pending
     * service package, then the active service package, then the previous service packages. **Example:**
     * &#x60;&#x60;&#x60; curl -X GET https://api.us-east-1.mbedcloud.com/v3/service-packages \\ -H &#39;Authorization:
     * Bearer &lt;access_key&gt;&#39; &#x60;&#x60;&#x60;
     * 
     * @return Call&lt;ServicePackagesResponse&gt;
     */
    @GET("v3/service-packages")
    Call<ServicePackagesResponse> getServicePackages();

}
