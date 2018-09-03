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
   * Fetch the billing report generated for the currently authenticated commercial non-subtenant account. Billing reports for subtenant accounts are included in their aggregator&#39;s billing report response.  **Example usage:**      curl -X GET https://api.us-east-1.mbedcloud.com/v3/billing-report?month&#x3D;2018-07 -H &#39;authorization: Bearer {api-key}&#39;
   * @param month Queried year and month of billing report. (required)
   * @return Call&lt;ReportResponse&gt;
   */
  @GET("v3/billing-report")
  Call<ReportResponse> getBillingReport(
    @retrofit2.http.Query("month") String month
  );

  /**
   * Get raw billing data of the active devices for the month.
   * Fetch the raw billing data of the active devices for the currently authenticated commercial non-subtenant account. This is supplementary data for the billing report. The raw billing data of the active devices for subtenant accounts are included in their aggregator&#39;s raw billing data of the active devices. The endpoint returns the URL to download the gzipped CSV file. The first line is the header providing information on the active devices. For example, the ID of an active device.  **Example usage:**      curl -X GET https://api.us-east-1.mbedcloud.com/v3/billing-report-active-devices?month&#x3D;2018-07 -H &#39;authorization: Bearer {api-key}&#39;
   * @param month Queried year and month of billing report. (required)
   * @return Call&lt;BillingReportRawDataResponse&gt;
   */
  @GET("v3/billing-report-active-devices")
  Call<BillingReportRawDataResponse> getBillingReportActiveDevices(
    @retrofit2.http.Query("month") String month
  );

  /**
   * Get raw billing data of the firmware updates for the month.
   * Fetch raw billing data of the firmware updates for the currently authenticated commercial non-subtenant account. This is supplementary data for the billing report. The raw billing data of the firmware updates for subtenant accounts are included in their aggregator&#39;s raw billing data of the firmware updates. The endpoint returns the URL to download the gzipped CSV file. The first line is the header providing information on the firmware updates. For example, the ID of an firmware update.  **Example usage:**      curl -X GET https://api.us-east-1.mbedcloud.com/v3/billing-report-firmware-updates?month&#x3D;2018-07 -H &#39;authorization: Bearer {api-key}&#39;
   * @param month Queried year and month of billing report. (required)
   * @return Call&lt;BillingReportRawDataResponse&gt;
   */
  @GET("v3/billing-report-firmware-updates")
  Call<BillingReportRawDataResponse> getBillingReportFirmwareUpdates(
    @retrofit2.http.Query("month") String month
  );

  /**
   * Service package quota.
   * Get the available firmware update quota for the currently authenticated commercial account.  **Example usage:**      curl -X GET https://api.us-east-1.mbedcloud.com/v3/service-packages-quota -H &#39;authorization: Bearer {api-key}&#39; 
   * @return Call&lt;ServicePackageQuota&gt;
   */
  @GET("v3/service-packages-quota")
  Call<ServicePackageQuota> getServicePackageQuota();
    

  /**
   * Service package quota history.
   * Get your quota usage history. This API is available for commercial accounts. Aggregator accounts can see own and subtenant quota usage data. History data is ordered in ascending order based on the added timestamp.  **Example usage:**      curl -X GET https://api.us-east-1.mbedcloud.com/v3/service-packages-quota-history -H &#39;authorization: Bearer {api-key}&#39; 
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
   * Get information of all service packages for the currently authenticated commercial account. The response is returned in descending order by service package created timestamp, listing first the pending service package, then the active service package and finally the previous service packages.  **Example usage:**      curl -X GET https://api.us-east-1.mbedcloud.com/v3/service-packages -H &#39;authorization: Bearer {api-key}&#39;
   * @return Call&lt;ServicePackagesResponse&gt;
   */
  @GET("v3/service-packages")
  Call<ServicePackagesResponse> getServicePackages();
    

}
