/**
 * 
 */
package com.arm.mbed.cloud.sdk.common;

/**
 * Defines a callback.
 * 
 * @param <T>
 *            callback argument type
 */
public interface Callback<T> {
    /**
     * Callback execution action.
     * 
     * @param arg
     *            function argument
     */
    void execute(T arg);

}
