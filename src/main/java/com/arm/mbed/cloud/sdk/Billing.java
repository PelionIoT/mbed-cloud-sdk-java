package com.arm.mbed.cloud.sdk;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.arm.mbed.cloud.sdk.annotations.API;
import com.arm.mbed.cloud.sdk.annotations.Module;
import com.arm.mbed.cloud.sdk.annotations.NonNull;
import com.arm.mbed.cloud.sdk.annotations.Nullable;
import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.billing.adapters.BillingEntityAdapter;
import com.arm.mbed.cloud.sdk.billing.model.EndPoints;
import com.arm.mbed.cloud.sdk.billing.model.QuotaHistory;
import com.arm.mbed.cloud.sdk.billing.model.ServicePackage;
import com.arm.mbed.cloud.sdk.billing.model.ServicePackageQuotaListOptions;
import com.arm.mbed.cloud.sdk.common.AbstractApi;
import com.arm.mbed.cloud.sdk.common.ApiUtils;
import com.arm.mbed.cloud.sdk.common.CloudCaller;
import com.arm.mbed.cloud.sdk.common.CloudCaller.CloudCall;
import com.arm.mbed.cloud.sdk.common.ConnectionOptions;
import com.arm.mbed.cloud.sdk.common.FileDownload;
import com.arm.mbed.cloud.sdk.common.GenericAdapter;
import com.arm.mbed.cloud.sdk.common.MbedCloudException;
import com.arm.mbed.cloud.sdk.common.PageRequester;
import com.arm.mbed.cloud.sdk.common.TranslationUtils;
import com.arm.mbed.cloud.sdk.common.listing.ListOptions;
import com.arm.mbed.cloud.sdk.common.listing.ListResponse;
import com.arm.mbed.cloud.sdk.common.listing.Paginator;
import com.arm.mbed.cloud.sdk.internal.billing.model.ServicePackageQuotaHistoryResponse;
import com.arm.mbed.cloud.sdk.internal.billing.model.ServicePackagesResponse;

import retrofit2.Call;

@Preamble(description = "Specifies Billing API")
@Module
/**
 * API exposing functionality for dealing with billing.
 */
public class Billing extends AbstractApi {

    private static final String TAG_DESTINATION = "destination";
    private static final String TAG_MONTH = "month";
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
     * Gets the remaining value of firmware updates for the currently authenticated commercial account.
     *
     * @return remaining quota for firmware update
     * @throws MbedCloudException
     *             if a problem occurs during processing
     */
    @API
    public @Nullable long getQuotaRemaining() throws MbedCloudException {
        final com.arm.mbed.cloud.sdk.internal.billing.model.ServicePackageQuota remainingQuota = CloudCaller.call(this,
                "getQuotaRemaining()",
                GenericAdapter.identityMapper(com.arm.mbed.cloud.sdk.internal.billing.model.ServicePackageQuota.class),
                new CloudCall<com.arm.mbed.cloud.sdk.internal.billing.model.ServicePackageQuota>() {

                    @Override
                    public Call<com.arm.mbed.cloud.sdk.internal.billing.model.ServicePackageQuota> call() {
                        return endpoint.getBilling().getServicePackageQuota();
                    }
                }, false);
        return (remainingQuota == null) ? 0l : TranslationUtils.toLong(remainingQuota.getQuota());
    }

    /**
     * Get all service packages.
     *
     * @return all the service packages
     * @throws MbedCloudException
     *             if a problem occurs during processing
     */
    @API
    public @Nullable List<ServicePackage> getServicePackages() throws MbedCloudException {
        return CloudCaller.call(this, "getServicePackages", BillingEntityAdapter.getListMapper(),
                new CloudCall<ServicePackagesResponse>() {

                    @Override
                    public Call<ServicePackagesResponse> call() {
                        return endpoint.getBilling().getServicePackages();
                    }
                });
    }

    /**
     * Gets quota usage history.
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
    public ListResponse<QuotaHistory> getQuotaHistory(@Nullable ServicePackageQuotaListOptions options)
            throws MbedCloudException {
        final ServicePackageQuotaListOptions finalOptions = (options == null) ? new ServicePackageQuotaListOptions()
                : options;
        return CloudCaller.call(this, "getQuotaHistory()", BillingEntityAdapter.getHistoryQuotaListMapper(),
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
    public @Nullable Paginator<QuotaHistory> getAllQuotaHistory(@Nullable ServicePackageQuotaListOptions options)
            throws MbedCloudException {
        return new Paginator<>((options == null) ? new ServicePackageQuotaListOptions() : options,
                new PageRequester<QuotaHistory>() {

                    @Override
                    public ListResponse<QuotaHistory> requestNewPage(ListOptions opt) throws MbedCloudException {
                        return getQuotaHistory((ServicePackageQuotaListOptions) opt);
                    }
                });
    }

    @API
    public void getReportOverview(@Nullable Calendar month, FileDownload destination) throws MbedCloudException {
        getReportOverview(TranslationUtils.toDate(month), destination);
    }

    @API
    public void getReportOverview(@Nullable Date month, @Nullable String filePath) throws MbedCloudException {
        try {
            getReportOverview(month, filePath == null ? new FileDownload() : new FileDownload(filePath));
        } catch (IOException | URISyntaxException exception) {
            throw new MbedCloudException(exception);
        }
    }

    @API
    public void getReportOverview(@Nullable String month, @Nullable String filePath) throws MbedCloudException {
        try {
            getReportOverview(month, filePath == null ? new FileDownload() : new FileDownload(filePath));
        } catch (IOException | URISyntaxException exception) {
            throw new MbedCloudException(exception);
        }
    }

    @API
    public void getReportOverview(@Nullable Date month, FileDownload destination) throws MbedCloudException {
        final Date finalDate = month == null ? new Date() : month;
        Calendar cal = Calendar.getInstance();
        cal.setTime(finalDate);
        final int dateYear = cal.get(Calendar.YEAR);
        final int dateMonth = cal.get(Calendar.MONTH);
        getReportOverview(dateYear + "-" + dateMonth, destination);
    }

    @API
    public void getReportOverview(@NonNull String month, @NonNull FileDownload destination) throws MbedCloudException {
        ApiUtils.checkNotNull(logger, month, TAG_MONTH);
        ApiUtils.checkNotNull(logger, destination, TAG_DESTINATION);
        final String bodyContent = null;// TODO
        destination.download(bodyContent);
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
