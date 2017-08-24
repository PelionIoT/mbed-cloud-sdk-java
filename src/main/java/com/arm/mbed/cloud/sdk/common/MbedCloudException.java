package com.arm.mbed.cloud.sdk.common;

import com.arm.mbed.cloud.sdk.annotations.Preamble;

@Preamble(description = "An Arm Mbed cloud exception")
public class MbedCloudException extends Exception {

    private static final long serialVersionUID = 3176049212952952513L;

    public MbedCloudException() {
        super();
    }

    public MbedCloudException(String message) {
        super(message);
    }

    public MbedCloudException(Throwable cause) {
        super("An exception occurred while calling Arm Mbed cloud API", cause);
    }

    public MbedCloudException(String message, Throwable cause) {
        super(message, cause);
    }

}
