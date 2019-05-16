/**
 * 
 */
package com.arm.mbed.cloud.sdk.devices.model;

import java.io.File;
import java.net.URL;

import com.arm.mbed.cloud.sdk.annotations.Internal;
import com.arm.mbed.cloud.sdk.annotations.Nullable;
import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.common.ApiClientWrapper;
import com.arm.mbed.cloud.sdk.common.FileDownload;
import com.arm.mbed.cloud.sdk.common.MbedCloudException;

@Preamble(description = "Utilities for devices entities")
@Internal
public final class Utils {

    private Utils() {
        // Nothing to do.
    }

    /**
     * Downloads a file from a URL.
     * 
     * @param destination
     *            destination file
     * @param source
     *            URL source
     * @param client
     *            client to use.
     * @return downloaded file.
     * @throws MbedCloudException
     *             if an error occurs during the process.
     */
    public static FileDownload downloadFile(@Nullable File destination, @Nullable URL source,
                                            @Nullable ApiClientWrapper client) throws MbedCloudException {
        final FileDownload file = destination == null ? new FileDownload(source)
                                                      : new FileDownload(source, destination);
        file.setClient(client);
        file.download();
        return file;
    }
}
