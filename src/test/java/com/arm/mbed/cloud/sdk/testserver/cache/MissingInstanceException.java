package com.arm.mbed.cloud.sdk.testserver.cache;

public class MissingInstanceException extends ServerCacheException {

    private static final long serialVersionUID = 376805978862275408L;

    public MissingInstanceException() {
        super();
    }

    public MissingInstanceException(String arg0) {
        super(arg0);
    }

    public MissingInstanceException(Throwable arg0) {
        super(arg0);
    }

    public MissingInstanceException(String arg0, Throwable arg1) {
        super(arg0, arg1);
    }

}
