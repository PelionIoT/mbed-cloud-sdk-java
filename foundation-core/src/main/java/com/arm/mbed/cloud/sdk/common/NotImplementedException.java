package com.arm.mbed.cloud.sdk.common;

import com.arm.mbed.cloud.sdk.annotations.Preamble;

@Preamble(description = "Exception thrown when a feature/functionality is not yet implemented")
/**
 * Exception indicating that a block of code or method has not yet been implemented.
 * <p>
 * * It is similar to same exception defined in Apache commons lang3 and aims at achieving the same role:
 * <code>NotImplementedException</code> represents the case where the author has yet to implement the logic at this
 * point in the program.
 *
 */
public class NotImplementedException extends UnsupportedOperationException {

    private static final long serialVersionUID = 3393453445061909305L;

    public NotImplementedException() {
        super();
    }

    public NotImplementedException(String message) {
        super(message);
    }

    public NotImplementedException(Throwable cause) {
        super(cause);
    }

    public NotImplementedException(String message, Throwable cause) {
        super(message, cause);
    }

}
