package com.arm.mbed.cloud.sdk.common.listing;

import com.arm.mbed.cloud.sdk.annotations.Internal;
import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.common.MbedCloudException;

@Preamble(description = "Generic page requester in pagination process")
@Internal
public interface GenericPageRequester<T, U extends AbstractListResponse<T>> {
    U requestNewPage(ListOptions options) throws MbedCloudException;
}
