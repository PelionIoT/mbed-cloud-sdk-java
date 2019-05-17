/**
 * 
 */
package com.arm.mbed.cloud.sdk.testutils;

import java.lang.reflect.InvocationTargetException;

import com.arm.mbed.cloud.sdk.testserver.internal.model.APIMethodResult;

public class APICallException extends Exception {

    /**
     * 
     */
    private static final long serialVersionUID = -7760245804136605697L;

    /**
     * 
     */
    public APICallException() {
        super();
    }

    /**
     * @param arg0
     */
    public APICallException(String arg0) {
        super(arg0);
    }

    /**
     * @param arg0
     */
    public APICallException(APIMethodResult arg0) {
        super(generateErrorMessage(arg0), generateThrowable(arg0));
    }

    private static Throwable generateThrowable(APIMethodResult arg0) {
        if (arg0 == null) {
            return null;
        }
        return arg0.getException().getCause();
    }

    private static String generateErrorMessage(APIMethodResult arg0) {
        if (arg0 == null) {
            return "Unknown reason";
        }
        if (arg0.getMetadata() == null) {
            if (arg0.getException() instanceof InvocationTargetException && arg0.getException().getCause() != null) {
                String message = arg0.getException().getCause().getMessage();
                return message == null ? arg0.getException().getCause().getClass().getSimpleName() : message;
            }
            return arg0.getException().getMessage() == null ? "Exception of type " + arg0.getException() + " was raised"
                                                            : arg0.getException().getMessage();
        }
        return "An error occurred during call (" + arg0.getMetadata().getStatusCode() + "). Call metadata: "
               + arg0.getMetadata().toString();
    }

    /**
     * @param arg0
     */
    public APICallException(Throwable arg0) {
        super(arg0);
    }

    /**
     * @param arg0
     * @param arg1
     */
    public APICallException(String arg0, Throwable arg1) {
        super(arg0, arg1);
    }

    /**
     * @param arg0
     * @param arg1
     * @param arg2
     * @param arg3
     */
    public APICallException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
        super(arg0, arg1, arg2, arg3);
    }

}
