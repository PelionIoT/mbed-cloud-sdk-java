package com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api;

import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.CollectionFormats.*;

import retrofit2.Call;
import retrofit2.http.*;

import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.BillingReportRawDataResponse;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.ReportResponse;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.ServicePackageQuota;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.ServicePackageQuotaHistoryResponse;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.ServicePackagesResponse;

public interface DefaultApi {
    /**
     * Get billing report. Fetch the billing report generated for the currently authenticated commercial non-subtenant
     * account. Billing reports for subtenant accounts are included in their aggregator&#39;s billing report response.
     * **Example:** &#x60;&#x60;&#x60; curl -X GET
     * https://api.us-east-1.mbedcloud.com/v3/billing-report?month&#x3D;2018-07 \\ -H &#39;Authorization: Bearer
     * &lt;api_key&gt;&#39; &#x60;&#x60;&#x60;
     * 
     * @param month
     *            Queried year and month of billing report. (required)
     * @return Call&lt;ReportResponse&gt;
     */
    @GET("v3/billing-report")
    Call<ReportResponse> getBillingReport(@retrofit2.http.Query("month") String month);

    /**
     * Get raw billing data of the active devices for the month. Fetch raw billing data for active devices for the
     * currently authenticated commercial non-subtenant account. This is supplementary data for the billing report. The
     * raw billing data of the active devices for subtenant accounts are included in their aggregator&#39;s raw billing
     * data of the active devices. The endpoint returns the URL to download the gzipped CSV file. The first line is the
     * header providing information on active devices, for example, the ID of an active device. **Example:**
     * &#x60;&#x60;&#x60; curl -X GET
     * https://api.us-east-1.mbedcloud.com/v3/billing-report-active-devices?month&#x3D;2018-07 \\ -H &#39;Authorization:
     * Bearer &lt;api_key&gt;&#39; &#x60;&#x60;&#x60;
     * 
     * @param month
     *            Queried year and month of billing report. (required)
     * @return Call&lt;BillingReportRawDataResponse&gt;
     */
    @GET("v3/billing-report-active-devices")
    Call<BillingReportRawDataResponse> getBillingReportActiveDevices(@retrofit2.http.Query("month") String month);

    /**
     * Get raw billing data of the firmware updates for the month. Fetch raw billing data for firmware updates for the
     * currently authenticated commercial non-subtenant account. This is supplementary data for the billing report. The
     * raw billing data of the firmware updates for subtenant accounts are included in their aggregator&#39;s raw
     * billing data of the firmware updates. The endpoint returns the URL to download the gzipped CSV file. The first
     * line is the header providing information on the firmware updates, for example, the ID of a firmware update.
     * **Example:** &#x60;&#x60;&#x60; curl -X GET
     * https://api.us-east-1.mbedcloud.com/v3/billing-report-firmware-updates?month&#x3D;2018-07 \\ -H
     * &#39;Authorization: Bearer &lt;api_key&gt;&#39; &#x60;&#x60;&#x60;
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
     * &#39;Authorization: Bearer &lt;api_key&gt;&#39; &#x60;&#x60;&#x60;
     * 
     * @return Call&lt;ServicePackageQuota&gt;
     */
    @GET("v3/service-packages-quota")
    Call<ServicePackageQuota> getServicePackageQuota();

    /**
     * Service package quota history. Get your quota usage history. This API is available only for commercial accounts.
     * Aggregator accounts can see their own and subtenant quota usage data. Data is in ascending order based on the
     * added timestamp. **Example:** &#x60;&#x60;&#x60; curl -X GET
     * https://api.us-east-1.mbedcloud.com/v3/service-packages-quota-history \\ -H &#39;Authorization: Bearer
     * &lt;api_key&gt;&#39; &#x60;&#x60;&#x60;
     * 
     * @param limit
     *            Maximum number of quota history entries contained in one paged response. (optional)
     * @param after
     *            Results after specified entry ID. (optional)
     * @return Call&lt;ServicePackageQuotaHistoryResponse&gt;
     */
    @GET("v3/service-packages-quota-history")
    Call<ServicePackageQuotaHistoryResponse> getServicePackageQuotaHistory(@retrofit2.http.Query("limit") Integer limit,
                                                                           @retrofit2.http.Query("after") String after);

    /**
     * Get all service packages. Get information for all service packages for the current authenticated commercial
     * account. The response is returned in descending order by service package created timestamp: first the pending
     * service package, then the active service package, then the previous service packages. **Example:**
     * &#x60;&#x60;&#x60; curl -X GET https://api.us-east-1.mbedcloud.com/v3/service-packages \\ -H &#39;Authorization:
     * Bearer &lt;api_key&gt;&#39; &#x60;&#x60;&#x60;
     * 
     * @return Call&lt;ServicePackagesResponse&gt;
     */
    @GET("v3/service-packages")
    Call<ServicePackagesResponse> getServicePackages();

}
