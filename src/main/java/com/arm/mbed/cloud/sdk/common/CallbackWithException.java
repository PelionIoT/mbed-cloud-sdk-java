/**
 *
 */
package com.arm.mbed.cloud.sdk.common;

import com.arm.mbed.cloud.sdk.annotations.Preamble;

/**
 * Defines a callback.
 * <p>
 * Similar to @link {@link Callback} but the action may throw an exception.
 *
 * @param <T>
 *            callback argument type
 */
@Preamble(description = "Callback which can throw an exception if an error occurs during its execution")
public interface CallbackWithException<T, U extends Exception> {
    /**
     * Callback execution action.
     *
     * @param arg
     *            function argument
     * @param <U>
     *            type of the exception thrown.
     */
    void execute(T arg) throws U;

}
