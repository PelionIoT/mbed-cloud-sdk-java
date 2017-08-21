package com.arm.mbed.cloud.sdk.update.adapters;

import com.arm.mbed.cloud.sdk.annotations.Internal;
import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.update.model.ManifestContents;

@Preamble(description = "Adapter for manifest contents object")
@Internal
public class ManifestContentsAdapter {

    public static ManifestContents map(com.arm.mbed.cloud.sdk.internal.updateservice.model.ManifestContents contents) {
        if (contents == null) {
            return null;
        }
        // TODO
        return null;
    }

}
