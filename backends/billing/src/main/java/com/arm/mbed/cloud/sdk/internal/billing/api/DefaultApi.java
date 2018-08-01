package com.arm.mbed.cloud.sdk.internal.billing.api;

import com.arm.mbed.cloud.sdk.internal.billing.CollectionFormats.*;

import retrofit2.Call;
import retrofit2.http.*;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import okhttp3.MultipartBody;

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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface DefaultApi {
  /**
   * Get billing report.
   * Fetch generated billing report for the currently authenticated commercial non-subtenant account. Billing reports for subtenant accounts are included in their aggregator&#39;s billing report response.
   * @param month Queried year and month of billing report (required)
   * @return Call&lt;ReportResponse&gt;
   */
  @GET("v3/billing-report")
  Call<ReportResponse> getBillingReport(
    @retrofit2.http.Query("month") String month
  );

  /**
   * Get raw active devices billing data for the month.
   * Fetch raw active devices billing data for the currently authenticated commercial non-subtenant account. They are supplementary data for billing report. The raw active devices billing data for subtenant accounts are included in their aggregator&#39;s raw active devices billing data. Endpoint returns the URL to download the gzipped csv file. First line of the file is the header which describes information of active devices included, e.g. active device ID.
   * @param month Queried year and month of billing report (required)
   * @return Call&lt;BillingReportRawDataResponse&gt;
   */
  @GET("v3/billing-report-active-devices")
  Call<BillingReportRawDataResponse> getBillingReportActiveDevices(
    @retrofit2.http.Query("month") String month
  );

  /**
   * Get raw firmware updates billing data for the month.
   * Fetch raw firmware updates billing data for the currently authenticated commercial non-subtenant account. They are supplementary data for billing report. The raw firmware updates billing data for subtenant accounts are included in their aggregator&#39;s raw firmware updates billing data. Endpoint returns the URL to download the gzipped csv file. First line of the file is the header which describes information of firmware updates included, e.g. firmware update device ID.
   * @param month Queried year and month of billing report (required)
   * @return Call&lt;BillingReportRawDataResponse&gt;
   */
  @GET("v3/billing-report-firmware-updates")
  Call<BillingReportRawDataResponse> getBillingReportFirmwareUpdates(
    @retrofit2.http.Query("month") String month
  );

  /**
   * Service package quota
   * Get the available firmware update quota for the currently authenticated commercial acount.
   * @return Call&lt;ServicePackageQuota&gt;
   */
  @GET("v3/service-packages-quota")
  Call<ServicePackageQuota> getServicePackageQuota();
    

  /**
   * Service package quota history
   * Get your quota usage history. This API is available for commercial accounts. Aggregator accounts can see own and subtenant quota usage data. History data is ordered in ascending order based on the added timestamp. 
   * @param limit Maximum amount of quota history entries contained in one paged response. (optional)
   * @param after To fetch after which quota history ID. The results will contain entries after specified entry. (optional)
   * @return Call&lt;ServicePackageQuotaHistoryResponse&gt;
   */
  @GET("v3/service-packages-quota-history")
  Call<ServicePackageQuotaHistoryResponse> getServicePackageQuotaHistory(
    @retrofit2.http.Query("limit") Integer limit, @retrofit2.http.Query("after") String after
  );

  /**
   * Get all service packages.
   * Get information of all service packages for currently authenticated commercial account. The response is returned with descending order by service package created timestamp, listing first pending service package, then active service package, and previous service packages at last.
   * @return Call&lt;ServicePackagesResponse&gt;
   */
  @GET("v3/service-packages")
  Call<ServicePackagesResponse> getServicePackages();
    

}
