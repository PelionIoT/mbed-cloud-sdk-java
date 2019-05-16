package com.arm.mbed.cloud.sdk.common.listing;

import com.arm.mbed.cloud.sdk.annotations.Internal;
import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.common.SdkModel;

@Preamble(description = "Page requester in pagination process for models")
@Internal
public interface PageRequester<T extends SdkModel> extends GenericPageRequester<T, ListResponse<T>> {
    // Page requester for models
}
