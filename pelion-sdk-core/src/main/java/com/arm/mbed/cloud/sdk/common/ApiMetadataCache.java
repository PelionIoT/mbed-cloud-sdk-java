package com.arm.mbed.cloud.sdk.common;

import com.arm.mbed.cloud.sdk.annotations.Internal;
import com.arm.mbed.cloud.sdk.annotations.Preamble;

@Preamble(description = "Cache storing API Metadata")
@Internal
public class ApiMetadataCache {

    private ApiMetadata lastMetadata;

    public ApiMetadataCache() {
        super();
        lastMetadata = null;
    }

    public synchronized void storeMetadata(ApiMetadata metadata) {
        lastMetadata = metadata;
    }

    public synchronized void clearMetadata() {
        lastMetadata = null;
    }

    public synchronized ApiMetadata getLastApiMetadata() {
        return lastMetadata;
    }
}
