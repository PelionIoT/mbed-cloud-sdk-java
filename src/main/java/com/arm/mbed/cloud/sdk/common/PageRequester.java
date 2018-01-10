package com.arm.mbed.cloud.sdk.common;

import com.arm.mbed.cloud.sdk.annotations.Internal;
import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.common.listing.ListOptions;
import com.arm.mbed.cloud.sdk.common.listing.ListResponse;

@Preamble(description = "Page requester in pagination process")
@Internal
public interface PageRequester<T extends SdkModel> {
    ListResponse<T> requestNewPage(ListOptions options) throws MbedCloudException;
}
