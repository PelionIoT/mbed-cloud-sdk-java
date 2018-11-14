package com.mbed.lwm2m;

/**
 * Exception occurring during message payload encoding
 */
public class DecodingException extends Exception {

    private static final long serialVersionUID = 7523416232311682667L;

    public DecodingException() {
        super();
    }

    /**
     *
     * @param message
     *            exception message
     */
    public DecodingException(String message) {
        super(message);
    }

    /**
     * @param message
     *            exception message
     * @param e
     *            cause of the exception
     */
    public DecodingException(String message, Exception e) {
        super(message, e);
    }

}
