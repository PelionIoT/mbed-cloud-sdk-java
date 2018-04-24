/**
 *
 */
package com.arm.mbed.cloud.sdk.common;

/**
 * Defines a callback.
 * <p>
 * Similar to @link {@link Callback} but the action may throw an exception.
 *
 * @param <T>
 *            callback argument type
 */
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
