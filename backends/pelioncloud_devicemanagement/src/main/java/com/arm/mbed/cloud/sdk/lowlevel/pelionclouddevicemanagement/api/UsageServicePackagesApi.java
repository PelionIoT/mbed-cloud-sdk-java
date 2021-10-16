package com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api;

import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.CollectionFormats.*;

import retrofit2.Call;
import retrofit2.http.*;

import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.ServicePackageQuotaHistoryResponse;

public interface UsageServicePackagesApi {
    /**
     * Service package quota history. Get your quota usage history. This API is available only for commercial accounts.
     * Aggregator accounts can see their own and tenant quota usage data. Data is in ascending order based on creation
     * time. **Example:** &#x60;&#x60;&#x60; curl -X GET
     * https://api.us-east-1.mbedcloud.com/v3/service-packages-quota-history \\ -H &#39;Authorization: Bearer
     * &lt;access_key&gt;&#39; &#x60;&#x60;&#x60;
     * 
     * @param limit
     *            Maximum number of quota history entries in one paged response. (optional)
     * @param after
     *            Results after specified entry ID. (optional)
     * @param order
     *            Record order. Acceptable values: ASC, DESC. Default: ASC. (optional)
     * @return Call&lt;ServicePackageQuotaHistoryResponse&gt;
     */
    @GET("v3/service-packages-quota-history")
    Call<ServicePackageQuotaHistoryResponse> getServicePackageQuotaHistory(@retrofit2.http.Query("limit") Integer limit,
                                                                           @retrofit2.http.Query("after") String after,
                                                                           @retrofit2.http.Query("order") String order);

}
