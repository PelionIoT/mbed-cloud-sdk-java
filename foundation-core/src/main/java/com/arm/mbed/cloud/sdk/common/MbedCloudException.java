package com.arm.mbed.cloud.sdk.common;

import com.arm.mbed.cloud.sdk.annotations.Preamble;

@Preamble(description = "A Pelion cloud exception")
public class MbedCloudException extends Exception {

    private static final long serialVersionUID = 3176049212952952513L;

    public MbedCloudException() {
        super();
    }

    public MbedCloudException(String message) {
        super(message);
    }

    public MbedCloudException(Throwable cause) {
        super("An exception occurred while calling Arm Pelion cloud API", cause);
    }

    public MbedCloudException(String message, Throwable cause) {
        super(message, cause);
    }

}
