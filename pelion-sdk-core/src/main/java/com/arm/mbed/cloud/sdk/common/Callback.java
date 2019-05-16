/**
 *
 */
package com.arm.mbed.cloud.sdk.common;

import com.arm.mbed.cloud.sdk.annotations.Preamble;

/**
 * Defines a callback.
 *
 * @param <T>
 *            callback argument type
 */
@Preamble(description = "Callback")
public interface Callback<T> {
    /**
     * Callback execution action.
     *
     * @param arg
     *            function argument
     */
    void execute(T arg);

}
