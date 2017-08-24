package com.arm.mbed.cloud.sdk.common;

import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.common.listing.ListResponse;

@Preamble(description = "Page requester in pagination process")
public interface PageRequester<T> {
	public ListResponse<T> requestNewPage() throws MbedCloudException;
}
