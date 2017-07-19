package com.arm.mbed.cloud.sdk.common;

import com.arm.mbed.cloud.sdk.annotations.Preamble;

@Preamble(description = "A mbed cloud exception")
public class MbedCloudException extends Exception {

	public MbedCloudException() {
		super();
	}

	public MbedCloudException(String message) {
		super(message);
	}

	public MbedCloudException(Throwable cause) {
		super("An exception occurred while calling mbed cloud API", cause);
	}

	public MbedCloudException(String message, Throwable cause) {
		super(message, cause);
	}

}
