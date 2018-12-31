package com.arm.mbed.cloud.sdk;

import java.io.File;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.arm.mbed.cloud.sdk.annotations.API;
import com.arm.mbed.cloud.sdk.annotations.Module;
import com.arm.mbed.cloud.sdk.annotations.NonNull;
import com.arm.mbed.cloud.sdk.annotations.Nullable;
import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.billing.adapters.BillingEntityAdapter;
import com.arm.mbed.cloud.sdk.billing.adapters.BillingReportAdapter;
import com.arm.mbed.cloud.sdk.billing.model.EndPoints;
import com.arm.mbed.cloud.sdk.billing.model.QuotaHistory;
import com.arm.mbed.cloud.sdk.billing.model.ServicePackage;
import com.arm.mbed.cloud.sdk.billing.model.ServicePackageQuotaListOptions;
import com.arm.mbed.cloud.sdk.common.AbstractModule;
import com.arm.mbed.cloud.sdk.common.ApiUtils;
import com.arm.mbed.cloud.sdk.common.CloudCaller;
import com.arm.mbed.cloud.sdk.common.CloudRequest.CloudCall;
import com.arm.mbed.cloud.sdk.common.ConnectionOptions;
import com.arm.mbed.cloud.sdk.common.FileDownload;
import com.arm.mbed.cloud.sdk.common.GenericAdapter;
import com.arm.mbed.cloud.sdk.common.MbedCloudException;
import com.arm.mbed.cloud.sdk.common.SdkContext;
import com.arm.mbed.cloud.sdk.common.TranslationUtils;
import com.arm.mbed.cloud.sdk.common.listing.ListOptions;
import com.arm.mbed.cloud.sdk.common.listing.ListResponse;
import com.arm.mbed.cloud.sdk.common.listing.PageRequester;
import com.arm.mbed.cloud.sdk.common.listing.Paginator;
import com.arm.mbed.cloud.sdk.internal.billing.model.BillingReportRawDataResponse;
import com.arm.mbed.cloud.sdk.internal.billing.model.ReportResponse;
import com.arm.mbed.cloud.sdk.internal.billing.model.ServicePackageQuota;
import com.arm.mbed.cloud.sdk.internal.billing.model.ServicePackageQuotaHistoryResponse;
import com.arm.mbed.cloud.sdk.internal.billing.model.ServicePackagesResponse;

import retrofit2.Call;

@Preamble(description = "Specifies Billing API")
@Module
/**
 * API exposing functionality for dealing with billing.
 */
public class Billing extends AbstractModule {

    private static final String REPORT_MONTH_FORMAT = "^\\d{4}-\\d{2}$";
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
        endpoint = new EndPoints(this.serviceRegistry);
    }

    /**
     * Constructor.
     * 
     * @param context
     *            SDK context
     */
    public Billing(SdkContext context) {
        super(context);
        endpoint = new EndPoints(this.serviceRegistry);
    }

    @Override
    public Billing clone() {
        return new Billing(this);
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
        final ServicePackageQuota remainingQuota = CloudCaller.call(this, "getQuotaRemaining()",
                                                                    GenericAdapter.identityMapper(ServicePackageQuota.class),
                                                                    new CloudCall<ServicePackageQuota>() {

                                                                        @Override
                                                                        public Call<ServicePackageQuota> call() {
                                                                            return endpoint.getBilling()
                                                                                           .getServicePackageQuota();
                                                                        }
                                                                    });
        return (remainingQuota == null) ? 0L : TranslationUtils.toLong(remainingQuota.getQuota());
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
     * @return quota history
     * @throws MbedCloudException
     *             if a problem occurred during request processing.
     */
    @API
    public ListResponse<QuotaHistory>
           getQuotaHistory(@Nullable ServicePackageQuotaListOptions options) throws MbedCloudException {
        final ServicePackageQuotaListOptions finalOptions = (options == null) ? new ServicePackageQuotaListOptions()
                                                                              : options;
        return CloudCaller.call(this, "getQuotaHistory()", BillingEntityAdapter.getHistoryQuotaListMapper(),
                                new CloudCall<ServicePackageQuotaHistoryResponse>() {

                                    @Override
                                    public Call<ServicePackageQuotaHistoryResponse> call() {
                                        return endpoint.getBilling()
                                                       .getServicePackageQuotaHistory(finalOptions.getPageSize(),
                                                                                      finalOptions.getAfter());
                                    }
                                });
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
    public @Nullable Paginator<QuotaHistory>
           getAllQuotaHistory(@Nullable ServicePackageQuotaListOptions options) throws MbedCloudException {
        return new Paginator<>((options == null) ? new ServicePackageQuotaListOptions() : options,
                               new PageRequester<QuotaHistory>() {

                                   @Override
                                   public ListResponse<QuotaHistory>
                                          requestNewPage(ListOptions opt) throws MbedCloudException {
                                       return getQuotaHistory((ServicePackageQuotaListOptions) opt);
                                   }
                               });
    }

    /**
     * Downloads a report overview.
     *
     *
     * @param month
     *            month for which the report is requested. If null, the current month will be considered.
     * @param destination
     *            destination file. If null, a temporary file will be created.
     * @return downloaded file if there is a report. Null otherwise.
     * @throws MbedCloudException
     *             if a problem occurred during request processing.
     */
    @API
    public @Nullable FileDownload getReportOverview(@Nullable File destination,
                                                    @Nullable Calendar month) throws MbedCloudException {
        return getReportOverview(destination, TranslationUtils.toDate(month));
    }

    /**
     *
     * Downloads a report overview.
     *
     *
     * @param month
     *            month for which the report is requested. If null, the current month will be considered.
     * @param filePath
     *            path of the destination file. If null, a temporary file will be created.
     * @return downloaded file if there is a report. Null otherwise.
     * @throws MbedCloudException
     *             if a problem occurred during request processing.
     */
    @API
    public @Nullable FileDownload getReportOverview(@Nullable String filePath,
                                                    @Nullable Calendar month) throws MbedCloudException {
        return getReportOverview(filePath, TranslationUtils.toDate(month));
    }

    /**
     *
     * Downloads a report overview.
     *
     *
     * @param month
     *            month for which the report is requested.If null, the current month will be considered.
     * @param filePath
     *            path of the destination file. If null, a temporary file will be created.
     * @return downloaded file if there is a report. Null otherwise.
     * @throws MbedCloudException
     *             if a problem occurred during request processing.
     */
    @API
    public @Nullable FileDownload getReportOverview(@Nullable String filePath,
                                                    @Nullable Date month) throws MbedCloudException {
        return getReportOverview(month, generateFileDownload(filePath));
    }

    /**
     *
     * Downloads a report overview.
     *
     *
     * @param month
     *            month for which the report is requested. If null, the current month will be considered.
     * @param destination
     *            destination file. If null, a temporary file will be created.
     * @return downloaded file if there is a report. Null otherwise.
     * @throws MbedCloudException
     *             if a problem occurred during request processing.
     */
    @API
    public @Nullable FileDownload getReportOverview(@Nullable File destination,
                                                    @Nullable Date month) throws MbedCloudException {
        return getReportOverview(month, generateFileDowload(destination));
    }

    /**
     * Downloads a report overview.
     *
     *
     * @param month
     *            month for which the report is requested
     * @param year
     *            year for which the report is requested
     * @param filePath
     *            path of the destination file. If null, a temporary file will be created.
     * @return downloaded file if there is a report. Null otherwise.
     * @throws MbedCloudException
     *             if a problem occurred during request processing.
     */
    @API
    public @Nullable FileDownload getReportOverview(@Nullable String filePath, int month,
                                                    int year) throws MbedCloudException {
        return getReportOverview(generateReportReference(year, month), generateFileDownload(filePath));
    }

    /**
     * Downloads a report overview.
     *
     *
     * @param month
     *            month for which the report is requested
     * @param year
     *            year for which the report is requested
     * @param destination
     *            Destination file. If null, a temporary file will be created.
     * @return downloaded file if there is a report. Null otherwise.
     * @throws MbedCloudException
     *             if a problem occurred during request processing.
     */
    @API
    public @Nullable FileDownload getReportOverview(@Nullable File destination, int month,
                                                    int year) throws MbedCloudException {
        return getReportOverview(generateReportReference(year, month), generateFileDowload(destination));
    }

    /**
     *
     * Downloads a report overview.
     *
     *
     * @param month
     *            month for which the report is requested. If null, the current month will be considered. It must be
     *            either an RFC3339 date/time string or following the format: YYYY-MM
     * @param filePath
     *            path of the destination file. If null, a temporary file will be created.
     * @return downloaded file if there is a report. Null otherwise.
     * @throws MbedCloudException
     *             if a problem occurred during request processing.
     */
    @API
    public @Nullable FileDownload getReportOverview(@Nullable String filePath,
                                                    @Nullable String month) throws MbedCloudException {
        return getReportOverview(month, generateFileDownload(filePath));
    }

    private FileDownload getReportOverview(Date month, FileDownload destination) throws MbedCloudException {
        ApiUtils.checkNotNull(logger, destination, TAG_DESTINATION);
        return getReportOverview(generateReportReferenceFromDate(month), destination);
    }

    private FileDownload getReportOverview(String month, FileDownload destination) throws MbedCloudException {
        ApiUtils.checkNotNull(logger, month, TAG_MONTH);
        ApiUtils.checkNotNull(logger, destination, TAG_DESTINATION);
        if (!month.matches(REPORT_MONTH_FORMAT)) {
            return getReportOverview(TranslationUtils.convertStringToDate(month), destination);
        }
        final String finalMonth = month;
        final String bodyContent = CloudCaller.callRaw(this, "getReportOverview()", new CloudCall<ReportResponse>() {

            @Override
            public Call<ReportResponse> call() {
                return endpoint.getBilling().getBillingReport(finalMonth);
            }
        }, false);
        if (bodyContent == null || bodyContent.isEmpty()) {
            logger.logWarn("Requested billing report [" + finalMonth + "] is empty");
            return null;
        }
        destination.download(bodyContent.trim());
        return destination;
    }

    /**
     * Downloads a report regarding active devices billing data.
     *
     *
     * @param month
     *            month for which the report is requested. If null, the current month will be considered.
     * @param destination
     *            destination file. If null, a temporary file will be created.
     * @return downloaded file if there is a report. Null otherwise.
     * @throws MbedCloudException
     *             if a problem occurred during request processing.
     */
    @API
    public @Nullable FileDownload getReportActiveDevices(@Nullable File destination,
                                                         @Nullable Calendar month) throws MbedCloudException {
        return getReportActiveDevices(destination, TranslationUtils.toDate(month));
    }

    /**
     *
     * Downloads a report regarding active devices billing data.
     *
     *
     * @param month
     *            month for which the report is requested. If null, the current month will be considered.
     * @param filePath
     *            path of the destination file. If null, a temporary file will be created.
     * @return downloaded file if there is a report. Null otherwise.
     * @throws MbedCloudException
     *             if a problem occurred during request processing.
     */
    @API
    public @Nullable FileDownload getReportActiveDevices(@Nullable String filePath,
                                                         @Nullable Calendar month) throws MbedCloudException {
        return getReportActiveDevices(filePath, TranslationUtils.toDate(month));
    }

    /**
     *
     * Downloads a report regarding active devices billing data.
     *
     *
     * @param month
     *            month for which the report is requested.If null, the current month will be considered.
     * @param filePath
     *            path of the destination file. If null, a temporary file will be created.
     * @return downloaded file if there is a report. Null otherwise.
     * @throws MbedCloudException
     *             if a problem occurred during request processing.
     */
    @API
    public @Nullable FileDownload getReportActiveDevices(@Nullable String filePath,
                                                         @Nullable Date month) throws MbedCloudException {
        return getReportActiveDevices(month, filePath);
    }

    /**
     *
     * Downloads a report regarding active devices billing data.
     *
     *
     * @param month
     *            month for which the report is requested. If null, the current month will be considered.
     * @param destination
     *            destination file. If null, a temporary file will be created.
     * @return downloaded file if there is a report. Null otherwise.
     * @throws MbedCloudException
     *             if a problem occurred during request processing.
     */
    @API
    public @Nullable FileDownload getReportActiveDevices(@Nullable File destination,
                                                         @Nullable Date month) throws MbedCloudException {
        return getReportActiveDevices(month, destination == null ? null : destination.toString());
    }

    /**
     * Downloads a report regarding active devices billing data.
     *
     *
     * @param month
     *            month for which the report is requested
     * @param year
     *            year for which the report is requested
     * @param filePath
     *            path of the destination file. If null, a temporary file will be created.
     * @return downloaded file if there is a report. Null otherwise.
     * @throws MbedCloudException
     *             if a problem occurred during request processing.
     */
    @API
    public @Nullable FileDownload getReportActiveDevices(@Nullable String filePath, int month,
                                                         int year) throws MbedCloudException {
        return getReportActiveDevices(generateReportReference(year, month), filePath);
    }

    /**
     * Downloads a report regarding active devices billing data.
     *
     *
     * @param month
     *            month for which the report is requested
     * @param year
     *            year for which the report is requested
     * @param destination
     *            Destination file. If null, a temporary file will be created.
     * @return downloaded file if there is a report. Null otherwise.
     * @throws MbedCloudException
     *             if a problem occurred during request processing.
     */
    @API
    public @Nullable FileDownload getReportActiveDevices(@Nullable File destination, int month,
                                                         int year) throws MbedCloudException {
        return getReportActiveDevices(generateReportReference(year, month),
                                      destination == null ? null : destination.toString());
    }

    /**
     *
     * Downloads a report regarding active devices billing data.
     *
     *
     * @param month
     *            month for which the report is requested. If null, the current month will be considered. It must be
     *            either an RFC3339 date/time string or following the format: YYYY-MM
     * @param filePath
     *            path of the destination directory or full path to the file. If null, a temporary file will be created.
     * @return downloaded file if there is a report. Null otherwise.
     * @throws MbedCloudException
     *             if a problem occurred during request processing.
     */
    @API
    public @Nullable FileDownload getReportActiveDevices(@Nullable String month,
                                                         @Nullable String filePath) throws MbedCloudException {
        ApiUtils.checkNotNull(logger, month, TAG_MONTH);
        if (!month.matches(REPORT_MONTH_FORMAT)) {
            return getReportActiveDevices(TranslationUtils.convertStringToDate(month), filePath);
        }
        final String finalMonth = month;
        final BillingReportRawDataResponse response = CloudCaller.call(this, "getReportActiveDevices()",
                                                                       GenericAdapter.identityMapper(BillingReportRawDataResponse.class),
                                                                       new CloudCall<BillingReportRawDataResponse>() {

                                                                           @Override
                                                                           public Call<BillingReportRawDataResponse>
                                                                                  call() {
                                                                               return endpoint.getBilling()
                                                                                              .getBillingReportActiveDevices(finalMonth);
                                                                           }
                                                                       });
        return downloadReport(filePath, response);
    }

    private FileDownload getReportActiveDevices(Date month, String destination) throws MbedCloudException {
        return getReportActiveDevices(generateReportReferenceFromDate(month), destination);
    }

    /**
     * Downloads a report regarding firmware updates billing data.
     *
     *
     * @param month
     *            month for which the report is requested. If null, the current month will be considered.
     * @param destination
     *            destination file. If null, a temporary file will be created.
     * @return downloaded file if there is a report. Null otherwise.
     * @throws MbedCloudException
     *             if a problem occurred during request processing.
     */
    @API
    public @Nullable FileDownload getReportFirmwareUpdates(@Nullable File destination,
                                                           @Nullable Calendar month) throws MbedCloudException {
        return getReportFirmwareUpdates(destination, TranslationUtils.toDate(month));
    }

    /**
     *
     * Downloads a report regarding firmware updates billing data.
     *
     *
     * @param month
     *            month for which the report is requested. If null, the current month will be considered.
     * @param filePath
     *            path of the destination file. If null, a temporary file will be created.
     * @return downloaded file if there is a report. Null otherwise.
     * @throws MbedCloudException
     *             if a problem occurred during request processing.
     */
    @API
    public @Nullable FileDownload getReportFirmwareUpdates(@Nullable String filePath,
                                                           @Nullable Calendar month) throws MbedCloudException {
        return getReportFirmwareUpdates(filePath, TranslationUtils.toDate(month));
    }

    /**
     *
     * Downloads a report regarding firmware updates billing data.
     *
     *
     * @param month
     *            month for which the report is requested.If null, the current month will be considered.
     * @param filePath
     *            path of the destination file. If null, a temporary file will be created.
     * @return downloaded file if there is a report. Null otherwise.
     * @throws MbedCloudException
     *             if a problem occurred during request processing.
     */
    @API
    public @Nullable FileDownload getReportFirmwareUpdates(@Nullable String filePath,
                                                           @Nullable Date month) throws MbedCloudException {
        return getReportFirmwareUpdates(month, filePath);
    }

    /**
     *
     * Downloads a report regarding firmware updates billing data.
     *
     *
     * @param month
     *            month for which the report is requested. If null, the current month will be considered.
     * @param destination
     *            destination file. If null, a temporary file will be created.
     * @return downloaded file if there is a report. Null otherwise.
     * @throws MbedCloudException
     *             if a problem occurred during request processing.
     */
    @API
    public @Nullable FileDownload getReportFirmwareUpdates(@Nullable File destination,
                                                           @Nullable Date month) throws MbedCloudException {
        return getReportFirmwareUpdates(month, destination == null ? null : destination.toString());
    }

    /**
     * Downloads a report regarding firmware updates billing data.
     *
     *
     * @param month
     *            month for which the report is requested
     * @param year
     *            year for which the report is requested
     * @param filePath
     *            path of the destination file. If null, a temporary file will be created.
     * @return downloaded file if there is a report. Null otherwise.
     * @throws MbedCloudException
     *             if a problem occurred during request processing.
     */
    @API
    public @Nullable FileDownload getReportFirmwareUpdates(@Nullable String filePath, int month,
                                                           int year) throws MbedCloudException {
        return getReportFirmwareUpdates(generateReportReference(year, month), filePath);
    }

    /**
     * Downloads a report regarding firmware updates billing data.
     *
     *
     * @param month
     *            month for which the report is requested
     * @param year
     *            year for which the report is requested
     * @param destination
     *            Destination file. If null, a temporary file will be created.
     * @return downloaded file if there is a report. Null otherwise.
     * @throws MbedCloudException
     *             if a problem occurred during request processing.
     */
    @API
    public @Nullable FileDownload getReportFirmwareUpdates(@Nullable File destination, int month,
                                                           int year) throws MbedCloudException {
        return getReportFirmwareUpdates(generateReportReference(year, month),
                                        destination == null ? null : destination.toString());
    }

    /**
     *
     * Downloads a report regarding firmware updates billing data.
     *
     *
     * @param month
     *            month for which the report is requested. If null, the current month will be considered. It must be
     *            either an RFC3339 date/time string or following the format: YYYY-MM
     * @param filePath
     *            path of the destination directory or full path to the file. If null, a temporary file will be created.
     * @return downloaded file if there is a report. Null otherwise.
     * @throws MbedCloudException
     *             if a problem occurred during request processing.
     */
    @API
    public @Nullable FileDownload getReportFirmwareUpdates(@Nullable String month,
                                                           @Nullable String filePath) throws MbedCloudException {
        ApiUtils.checkNotNull(logger, month, TAG_MONTH);
        if (!month.matches(REPORT_MONTH_FORMAT)) {
            return getReportActiveDevices(TranslationUtils.convertStringToDate(month), filePath);
        }
        final String finalMonth = month;
        final BillingReportRawDataResponse response = CloudCaller.call(this, "getReportFirmwareUpdates()",
                                                                       GenericAdapter.identityMapper(BillingReportRawDataResponse.class),
                                                                       new CloudCall<BillingReportRawDataResponse>() {

                                                                           @Override
                                                                           public Call<BillingReportRawDataResponse>
                                                                                  call() {
                                                                               return endpoint.getBilling()
                                                                                              .getBillingReportFirmwareUpdates(finalMonth);
                                                                           }
                                                                       });
        return downloadReport(filePath, response);
    }

    private FileDownload getReportFirmwareUpdates(Date month, String destination) throws MbedCloudException {
        return getReportFirmwareUpdates(generateReportReferenceFromDate(month), destination);
    }

    private FileDownload downloadReport(String filePath,
                                        final BillingReportRawDataResponse response) throws MbedCloudException {
        final FileDownload file = BillingReportAdapter.map(response, filePath);
        if (file == null) {
            return null;
        }
        file.download();
        return file;
    }

    private FileDownload generateFileDowload(File destination) throws MbedCloudException {
        return destination == null ? new FileDownload(FileDownload.Extension.JSON) : new FileDownload(destination);
    }

    private FileDownload generateFileDownload(String filePath) throws MbedCloudException {
        return filePath == null ? new FileDownload(FileDownload.Extension.JSON) : new FileDownload(filePath);
    }

    protected String generateReportReferenceFromDate(Date month) {
        final Date finalDate = month == null ? new Date() : month;
        final Calendar cal = Calendar.getInstance();
        cal.setTime(finalDate);
        final int dateYear = cal.get(Calendar.YEAR);
        final int dateMonth = cal.get(Calendar.MONTH) + 1;
        return generateReportReference(dateYear, dateMonth);
    }

    protected String generateReportReference(int dateYear, int dateMonth) {
        final String monthString = dateMonth < 10 && dateMonth > 0 ? "0" + dateMonth : String.valueOf(dateMonth);
        return dateYear + "-" + monthString;
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
