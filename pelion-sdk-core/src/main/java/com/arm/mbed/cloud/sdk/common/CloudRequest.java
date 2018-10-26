package com.arm.mbed.cloud.sdk.common;

import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.common.listing.ListOptions;
import com.arm.mbed.cloud.sdk.common.listing.ListResponse;

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
     * Request definition for list endpoints/APIs.
     *
     * @param <T>
     *            type of the model being listed.
     * @param <S>
     *            service defining the API.
     * @param <O>
     *            list options.
     */
    interface CloudListRequest<T extends SdkModel, S, O extends ListOptions> {
        /**
         * Defines how to create a request to Pelion Cloud based on parameters;
         *
         * @param service
         *            service defining the API.
         * @param options
         *            list options
         * @param extraParameters
         *            request parameters
         * @return request definition
         * @throws MbedCloudException
         *             if the parameters are invalid.
         */
        CloudCall<ListResponse<T>> defineCall(S service, O options,
                                              Object... extraParameters) throws MbedCloudException;
    }

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
