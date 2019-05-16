/**
 * 
 */
package com.arm.mbed.cloud.sdk.testutils;

public class NotAllowedAPICallException extends Exception {

    /**
     * 
     */
    private static final long serialVersionUID = -7760245804136605697L;

    /**
     * 
     */
    public NotAllowedAPICallException() {
        super("Call was not allowed");
    }

    /**
     * @param arg0
     */
    public NotAllowedAPICallException(String arg0) {
        super(arg0);
    }

    /**
     * @param arg0
     */
    public NotAllowedAPICallException(Throwable arg0) {
        super(arg0);
    }

    /**
     * @param arg0
     * @param arg1
     */
    public NotAllowedAPICallException(String arg0, Throwable arg1) {
        super(arg0, arg1);
    }

    /**
     * @param arg0
     * @param arg1
     * @param arg2
     * @param arg3
     */
    public NotAllowedAPICallException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
        super(arg0, arg1, arg2, arg3);
    }

}
