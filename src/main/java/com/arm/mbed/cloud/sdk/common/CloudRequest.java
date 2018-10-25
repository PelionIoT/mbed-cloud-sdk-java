package com.arm.mbed.cloud.sdk.common;

import com.arm.mbed.cloud.sdk.annotations.Preamble;

import retrofit2.Call;

/**
 * Request definition.
 *
 * @param <T>
 *            type of response object.
 * @param <S>
 *            service defining the API.
 */
@Preamble(description = "Generic cloud request definition")
public interface CloudRequest<T, S> {
    /**
     * Defines how to create a request to Pelion Cloud based on parameters;
     *
     * @param service
     *            service defining the API.
     * @param parameters
     *            request parameters
     * @return request definition
     * @throws MbedCloudException
     *             if the parameters are invalid.
     */
    CloudCall<T> defineCall(S service, Object... parameters) throws MbedCloudException;

    /**
     * Defines a call to Pelion Cloud.
     *
     * @param <T>
     *            type of response object.
     */
    @Preamble(description = "Definition of a call to Pelion Cloud")
    interface CloudCall<T> {
        /**
         * Defines a low level call.
         *
         * @return low level call definition.
         */
        Call<T> call();
    }
}
