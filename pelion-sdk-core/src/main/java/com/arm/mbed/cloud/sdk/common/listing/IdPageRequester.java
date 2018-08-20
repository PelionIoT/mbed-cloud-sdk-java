package com.arm.mbed.cloud.sdk.common.listing;

import com.arm.mbed.cloud.sdk.annotations.Internal;
import com.arm.mbed.cloud.sdk.annotations.Preamble;

@Preamble(description = "Page requester in pagination process for IDs")
@Internal
public interface IdPageRequester extends GenericPageRequester<String, IdListResponse> {
    // Page requester for IDs
}
