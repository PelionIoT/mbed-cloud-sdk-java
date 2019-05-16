/**
 * 
 */
package com.arm.pelion.sdk.foundation.generator.lowlevelapis;

public class UnknownAPIException extends Exception {

    private static final long serialVersionUID = 3251197691266466001L;

    /**
     * 
     */
    public UnknownAPIException() {
        // TODO Auto-generated constructor stub
    }

    /**
     * @param arg0
     */
    public UnknownAPIException(String message) {
        super(generateMessage(message));
        // TODO Auto-generated constructor stub
    }

    /**
     * @param arg0
     */
    public UnknownAPIException(Throwable arg0) {
        super(arg0);
        // TODO Auto-generated constructor stub
    }

    /**
     * @param generateMessage(arg0)
     * @param arg1
     */
    public UnknownAPIException(String arg0, Throwable arg1) {
        super(generateMessage(arg0), arg1);
        // TODO Auto-generated constructor stub
    }

    /**
     * @param generateMessage(arg0)
     * @param arg1
     * @param arg2
     * @param arg3
     */
    public UnknownAPIException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
        super(generateMessage(arg0), arg1, arg2, arg3);
        // TODO Auto-generated constructor stub
    }

    private static String generateMessage(String message) {
        return "NOT FOUND: " + message;
    }

}
