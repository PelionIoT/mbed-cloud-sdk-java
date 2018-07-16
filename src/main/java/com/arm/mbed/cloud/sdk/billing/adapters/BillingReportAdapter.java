package com.arm.mbed.cloud.sdk.billing.adapters;

import java.net.MalformedURLException;

import com.arm.mbed.cloud.sdk.annotations.Internal;
import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.common.FileDownload;
import com.arm.mbed.cloud.sdk.common.MbedCloudException;
import com.arm.mbed.cloud.sdk.internal.billing.model.BillingReportRawDataResponse;

@Preamble(description = "Adapter for Billing reports")
@Internal
public final class BillingReportAdapter {

    private BillingReportAdapter() {
        super();
    }

    /**
     * Maps billing reports.
     *
     * @param toBeMapped
     *            billing report from Mbed Cloud.
     * @param destination
     *            destination path
     * @return corresponding service package.
     * @throws MbedCloudException
     *             if an error occurred during the process
     */
    public static FileDownload map(BillingReportRawDataResponse toBeMapped,
                                   String destination) throws MbedCloudException {
        if (toBeMapped == null) {
            return null;
        }
        try {
            return new FileDownload(toBeMapped.getUrl(), destination, toBeMapped.getFilename());
        } catch (MalformedURLException exception) {
            throw new MbedCloudException(exception);
        }
    }

}
