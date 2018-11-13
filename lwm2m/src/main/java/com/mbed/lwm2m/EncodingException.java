package com.mbed.lwm2m;

/**
 * Exception occurring during message payload decoding
 */
public class EncodingException extends Exception {

    private static final long serialVersionUID = 7523416232311682667L;

    public EncodingException() {
        super();
    }

    /**
     *
     * @param message
     *            exception message
     */
    public EncodingException(String message) {
        super(message);
    }

    /**
     * @param message
     *            exception message
     * @param e
     *            cause of the exception
     */
    public EncodingException(String message, Exception e) {
        super(message, e);
    }

}
