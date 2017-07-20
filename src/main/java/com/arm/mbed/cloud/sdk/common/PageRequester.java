package com.arm.mbed.cloud.sdk.common;

import com.arm.mbed.cloud.sdk.annotations.Preamble;

@Preamble(description = "Page requester in pagination process")
public interface PageRequester<T> {
	public ListResponse<T> requestNewPage() throws MbedCloudException;
}
