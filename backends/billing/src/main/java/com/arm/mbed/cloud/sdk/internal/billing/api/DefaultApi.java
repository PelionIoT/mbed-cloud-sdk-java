package com.arm.mbed.cloud.sdk.internal.billing.api;

import com.arm.mbed.cloud.sdk.internal.billing.model.ReportResponse;
import com.arm.mbed.cloud.sdk.internal.billing.model.ServicePackageQuota;
import com.arm.mbed.cloud.sdk.internal.billing.model.ServicePackageQuotaHistoryResponse;
import com.arm.mbed.cloud.sdk.internal.billing.model.ServicePackagesResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface DefaultApi {
    /**
     * Get billing report. Fetch generated billing report for the currently authenticated commercial non-subtenant
     * account. Billing reports for subtenant accounts are included in their aggregator&#39;s billing report response.
     *
     * @param month
     *            Queried year and month of billing report (required)
     * @return Call&lt;ReportResponse&gt;
     */
    @GET("/v3/billing-report")
    Call<ReportResponse> getBillingReport(@retrofit2.http.Query("month") String month);

    /**
     * Service package quota Get the available firmware update quota for the currently authenticated commercial acount.
     *
     * @return Call&lt;ServicePackageQuota&gt;
     */
    @GET("/v3/service-packages-quota")
    Call<ServicePackageQuota> getServicePackageQuota();

    /**
     * Service package quota history Get your quota usage history. This API is available for commercial accounts.
     * Aggregator accounts can see own and subtenant quota usage data. History data is ordered in ascending order based
     * on the added timestamp.
     *
     * @param limit
     *            Maximum amount of quota history entries contained in one paged response. (optional)
     * @param after
     *            To fetch after which quota history id. The results will contain entries after specified entry.
     *            (optional)
     * @return Call&lt;ServicePackageQuotaHistoryResponse&gt;
     */
    @GET("/v3/service-packages-quota-history")
    Call<ServicePackageQuotaHistoryResponse> getServicePackageQuotaHistory(@retrofit2.http.Query("limit") Integer limit,
            @retrofit2.http.Query("after") String after);

    /**
     * Get all service packages. Get information of all service packages for currently authenticated commercial account.
     * The response is returned with descending order by service package created timestamp, listing first pending
     * service package, then active service package, and previous service packages at last.
     *
     * @return Call&lt;ServicePackagesResponse&gt;
     */
    @GET("/v3/service-packages")
    Call<ServicePackagesResponse> getServicePackages();

}
