package com.arm.mbed.cloud.sdk.connect.subscription.adapters;

import java.io.IOException;

import com.arm.mbed.cloud.sdk.annotations.Internal;
import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.common.GenericAdapter.Mapper;
import com.arm.mbed.cloud.sdk.common.MbedCloudException;
import com.arm.mbed.cloud.sdk.connect.subscription.ResourceActionParameters;
import com.arm.mbed.cloud.sdk.internal.mds.model.AsyncID;
import com.arm.mbed.cloud.sdk.internal.mds.model.DeviceRequest;

import okhttp3.Request;
import retrofit2.Call;
import retrofit2.Response;

@Preamble(description = "Adapter for resource actions")
public final class ResourceActionAdapter {

    private static final String RESOURCE_GET_METHOD = "GET";
    private static final String RESOURCE_SET_METHOD = "PUT";
    private static final String RESOURCE_EXECUTE_METHOD = "POST";

    private ResourceActionAdapter() {
        super();
    }

    /**
     * Creates a "get" method on a resource.
     *
     * @param params
     *            parameters.
     * @return Request body.
     */
    public static DeviceRequest mapGetFunctionOnResource(ResourceActionParameters params) {
        if (params == null || params.getResourcePath() == null) {
            return null;
        }
        final DeviceRequest request = new DeviceRequest();
        request.setMethod(RESOURCE_GET_METHOD);
        request.setUri(params.getResourcePath());
        return request;
    }

    /**
     * Creates a "set" method on a resource.
     *
     * @param params
     *            parameters.
     * @return Request body.
     */
    public static DeviceRequest mapSetFunctionOnResource(ResourceActionParameters params) {
        if (params == null || params.getResourcePath() == null) {
            return null;
        }
        final DeviceRequest request = new DeviceRequest();
        try {
            request.setPayloadB64(params.marshall());
        } catch (MbedCloudException exception) {

            return null;
        }
        request.setMethod(RESOURCE_SET_METHOD);
        request.setUri(params.getResourcePath());
        request.setContentType(params.getValueType().getContentType().getContentType());
        return request;
    }

    /**
     * Creates a "execute" method on a resource.
     *
     * @param params
     *            parameters.
     * @return Request body.
     */
    public static DeviceRequest mapExecuteFunctionOnResource(ResourceActionParameters params) {
        if (params == null || params.getResourcePath() == null) {
            return null;
        }
        final DeviceRequest request = new DeviceRequest();
        try {
            request.setPayloadB64(params.marshall());
        } catch (MbedCloudException exception) {

            return null;
        }
        request.setMethod(RESOURCE_EXECUTE_METHOD);
        request.setUri(params.getResourcePath());
        request.setContentType(params.getValueType().getContentType().getContentType());
        return request;
    }

    /**
     * Gets mapper to create a get resource value request.
     * 
     * @return corresponding mapper
     */
    public static Mapper<ResourceActionParameters, DeviceRequest> getGetResourceValueMapper() {
        return new Mapper<ResourceActionParameters, DeviceRequest>() {

            @Override
            public DeviceRequest map(ResourceActionParameters toBeMapped) {
                return mapGetFunctionOnResource(toBeMapped);
            }

        };
    }

    /**
     * Gets mapper to create a set resource value request.
     * 
     * @return corresponding mapper
     */
    public static Mapper<ResourceActionParameters, DeviceRequest> getSetResourceValueMapper() {
        return new Mapper<ResourceActionParameters, DeviceRequest>() {

            @Override
            public DeviceRequest map(ResourceActionParameters toBeMapped) {
                return mapSetFunctionOnResource(toBeMapped);
            }

        };
    }

    /**
     * Gets mapper to create an execute resource value request.
     * 
     * @return corresponding mapper
     */
    public static Mapper<ResourceActionParameters, DeviceRequest> getExecuteResourceValueMapper() {
        return new Mapper<ResourceActionParameters, DeviceRequest>() {

            @Override
            public DeviceRequest map(ResourceActionParameters toBeMapped) {
                return mapExecuteFunctionOnResource(toBeMapped);
            }

        };
    }

    /**
     * Converts a call to a resouce into a asynchronous call.
     *
     * @param asyncId
     *            id of the request
     * @param call
     *            call to Mbed Cloud
     * @return converted call
     */
    @Internal
    public static Call<AsyncID> convertResourceCall(String asyncId, Call<Void> call) {
        return new AsyncCall(asyncId, call);
    }

    private static class AsyncCall implements Call<AsyncID> {

        private final String uuid;
        private final Call<Void> call;

        public AsyncCall(String uuid, Call<Void> call) {
            super();
            this.uuid = uuid;
            this.call = call;
        }

        // TODO This is a temporary implementation to transform a Response<Void> to Response<AsyncID> and ensure the
        // error message contained in the body is correctly passed. This may need change/refactoring in the future when
        // the error message changes
        @Override
        public Response<AsyncID> execute() throws IOException {
            final Response<Void> response = call.execute();
            if (response.isSuccessful()) {
                return Response.success(new AsyncID().asyncResponseId(uuid));
            }

            final StringBuilder errorMessageBuilder = new StringBuilder();
            errorMessageBuilder.append(response.message());
            try {
                final String errorMessage = response.errorBody().string();
                if (errorMessage != null && !errorMessage.isEmpty()) {
                    errorMessageBuilder.append(": ").append(errorMessage);
                }
            } catch (Exception exception) {
                // Nothing to do.
            }
            return Response.error(response.errorBody(),
                                  response.raw().newBuilder().message(errorMessageBuilder.toString()).build());
        }

        @Override
        public void enqueue(retrofit2.Callback<AsyncID> callback) {
            final Call<AsyncID> thisCall = this;
            final retrofit2.Callback<AsyncID> finalCallback = callback;
            call.enqueue(new retrofit2.Callback<Void>() {

                @Override
                public void onResponse(Call<Void> call0, Response<Void> response) {
                    finalCallback.onResponse(thisCall, Response.success(new AsyncID().asyncResponseId(uuid)));

                }

                @Override
                public void onFailure(Call<Void> call0, Throwable throwable) {
                    finalCallback.onFailure(thisCall, throwable);

                }
            });

        }

        @Override
        public boolean isExecuted() {
            return call.isExecuted();
        }

        @Override
        public void cancel() {
            call.cancel();
        }

        @Override
        public boolean isCanceled() {
            return call.isCanceled();
        }

        @Override
        public Call<AsyncID> clone() {
            return new AsyncCall(uuid, call);
        }

        @Override
        public Request request() {
            return call.request();
        }

    }

}
