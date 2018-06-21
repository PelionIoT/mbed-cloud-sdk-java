package com.arm.mbed.cloud.sdk;

import com.arm.mbed.cloud.sdk.annotations.API;
import com.arm.mbed.cloud.sdk.annotations.Module;
import com.arm.mbed.cloud.sdk.annotations.NonNull;
import com.arm.mbed.cloud.sdk.annotations.Nullable;
import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.billing.adapters.ServicePackageQuotaAdapter;
import com.arm.mbed.cloud.sdk.billing.model.EndPoints;
import com.arm.mbed.cloud.sdk.billing.model.ServicePackageQuota;
import com.arm.mbed.cloud.sdk.billing.model.ServicePackageQuotaListOptions;
import com.arm.mbed.cloud.sdk.common.AbstractApi;
import com.arm.mbed.cloud.sdk.common.CloudCaller;
import com.arm.mbed.cloud.sdk.common.CloudCaller.CloudCall;
import com.arm.mbed.cloud.sdk.common.ConnectionOptions;
import com.arm.mbed.cloud.sdk.common.MbedCloudException;
import com.arm.mbed.cloud.sdk.common.PageRequester;
import com.arm.mbed.cloud.sdk.common.listing.ListOptions;
import com.arm.mbed.cloud.sdk.common.listing.ListResponse;
import com.arm.mbed.cloud.sdk.common.listing.Paginator;
import com.arm.mbed.cloud.sdk.internal.billing.model.ServicePackageQuotaHistoryResponse;

import retrofit2.Call;

@Preamble(description = "Specifies Billing API")
@Module
/**
 * API exposing functionality for dealing with billing.
 */
public class Billing extends AbstractApi {

    private final EndPoints endpoint;

    /**
     * Billing module constructor.
     *
     * @param options
     *            connection options @see {@link ConnectionOptions}.
     */
    public Billing(@NonNull ConnectionOptions options) {
        super(options);
        endpoint = new EndPoints(this.client);
    }

    /**
     * Gets the available firmware update quota for the currently authenticated commercial account.
     *
     * @return current quota for firmware update
     * @throws MbedCloudException
     *             if a problem occurs during processing
     */
    @API
    public @Nullable ServicePackageQuota getServicePackageQuota() throws MbedCloudException {
        return CloudCaller.call(this, "getServicePackageQuota()", ServicePackageQuotaAdapter.getMapper(),
                new CloudCall<com.arm.mbed.cloud.sdk.internal.billing.model.ServicePackageQuota>() {

                    @Override
                    public Call<com.arm.mbed.cloud.sdk.internal.billing.model.ServicePackageQuota> call() {
                        return endpoint.getBilling().getServicePackageQuota();
                    }
                }, false);
    }

    /**
     * Lists service package quota usage history.
     * <p>
     * This API is available for commercial accounts. Aggregator accounts can see their own and subtenant's quota usage
     * data. History data is ordered in ascending order based on the time of their addition.
     *
     * @param options
     *            filter options
     * @throws MbedCloudException
     *             if a problem occurred during request processing.
     */
    @API
    public ListResponse<ServicePackageQuota> listServicePackageQuotaHistory(
            @Nullable ServicePackageQuotaListOptions options) throws MbedCloudException {
        final ServicePackageQuotaListOptions finalOptions = (options == null) ? new ServicePackageQuotaListOptions()
                : options;
        return CloudCaller.call(this, "listServicePackageQuotaHistory()", ServicePackageQuotaAdapter.getListMapper(),
                new CloudCall<ServicePackageQuotaHistoryResponse>() {

                    @Override
                    public Call<ServicePackageQuotaHistoryResponse> call() {
                        return endpoint.getBilling().getServicePackageQuotaHistory(finalOptions.getPageSize(),
                                finalOptions.getAfter());
                    }
                }, false);
    }

    /**
     * Gets an iterator over all historical service package quota depending on filter options.
     *
     * @param options
     *            filter options.
     * @return paginator @see {@link Paginator} for the service package quota matching filter options.
     * @throws MbedCloudException
     *             if a problem occurred during request processing.
     */
    @API
    public @Nullable Paginator<ServicePackageQuota> listAllServicePackageQuotaHistory(
            @Nullable ServicePackageQuotaListOptions options) throws MbedCloudException {
        return new Paginator<>((options == null) ? new ServicePackageQuotaListOptions() : options,
                new PageRequester<ServicePackageQuota>() {

                    @Override
                    public ListResponse<ServicePackageQuota> requestNewPage(ListOptions opt) throws MbedCloudException {
                        return listServicePackageQuotaHistory((ServicePackageQuotaListOptions) opt);
                    }
                });
    }

    /**
     * Retrieves module name.
     *
     * @return module name.
     */
    @Override
    public String getModuleName() {
        return "Billing";
    }
}
