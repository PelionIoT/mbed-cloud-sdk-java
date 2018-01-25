package com.arm.mbed.cloud.sdk.testserver.cache;

public class InvalidInstanceException extends ServerCacheException {

    private static final long serialVersionUID = 376805978862275408L;

    public InvalidInstanceException() {
        super();
    }

    public InvalidInstanceException(String arg0) {
        super(generateMessage(arg0));
    }

    public InvalidInstanceException(Throwable arg0) {
        super(arg0);
    }

    public InvalidInstanceException(String arg0, Throwable arg1) {
        super(generateMessage(arg0), arg1);
    }

    private static String generateMessage(String message) {
        return "INVALID: " + message;
    }
}
