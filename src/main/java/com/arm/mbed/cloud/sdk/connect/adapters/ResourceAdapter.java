package com.arm.mbed.cloud.sdk.connect.adapters;

import java.io.IOException;
import java.util.List;

import com.arm.mbed.cloud.sdk.annotations.Internal;
import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.common.GenericAdapter;
import com.arm.mbed.cloud.sdk.common.GenericAdapter.Mapper;
import com.arm.mbed.cloud.sdk.common.TranslationUtils;
import com.arm.mbed.cloud.sdk.connect.model.Resource;
import com.arm.mbed.cloud.sdk.internal.mds.model.AsyncID;
import com.arm.mbed.cloud.sdk.internal.mds.model.DeviceRequest;

import okhttp3.Request;
import retrofit2.Call;
import retrofit2.Response;

@Preamble(description = "Adapter for resource model")
public final class ResourceAdapter {

    private static final String RESOURCE_GET_METHOD = "GET";

    private ResourceAdapter() {
        super();
    }

    /**
     * Maps a resource.
     * 
     * @param deviceId
     *            device id of the device containing the resource
     * @param apiResource
     *            resource to map
     * @return mapped resource
     */
    public static Resource map(String deviceId, com.arm.mbed.cloud.sdk.internal.mds.model.Resource apiResource) {
        if (apiResource == null || deviceId == null || deviceId.isEmpty()) {
            return null;
        }
        return new Resource(deviceId, apiResource.getUri(), apiResource.getRt(), apiResource.getType(),
                TranslationUtils.toBool(apiResource.isObs(), false));
    }

    /**
     * Gets a mapper.
     * 
     * @param deviceId
     *            device id of the device containing the resource
     * @return a mapper for this device.
     */
    public static Mapper<com.arm.mbed.cloud.sdk.internal.mds.model.Resource, Resource> getMapper(String deviceId) {
        final String immutableDeviceId = deviceId;
        return new Mapper<com.arm.mbed.cloud.sdk.internal.mds.model.Resource, Resource>() {

            @Override
            public Resource map(com.arm.mbed.cloud.sdk.internal.mds.model.Resource toBeMapped) {
                return ResourceAdapter.map(immutableDeviceId, toBeMapped);
            }
        };
    }

    /**
     * Maps a list of resources.
     * 
     * @param deviceId
     *            device id of the device containing the resources
     * @param list
     *            resource page
     * @return list of resources
     */
    public static List<Resource> mapList(String deviceId,
            List<com.arm.mbed.cloud.sdk.internal.mds.model.Resource> list) {
        return GenericAdapter.mapList(list, getMapper(deviceId));
    }

    /**
     * Gets list mapper.
     * 
     * @param deviceId
     *            device id of the device containing the resources
     * @return a list mapper
     */
    public static Mapper<List<com.arm.mbed.cloud.sdk.internal.mds.model.Resource>, List<Resource>> getListMapper(
            String deviceId) {
        final String immutableDeviceId = deviceId;
        return new Mapper<List<com.arm.mbed.cloud.sdk.internal.mds.model.Resource>, List<Resource>>() {

            @Override
            public List<Resource> map(List<com.arm.mbed.cloud.sdk.internal.mds.model.Resource> toBeMapped) {
                return ResourceAdapter.mapList(immutableDeviceId, toBeMapped);
            }

        };
    }

    /**
     * Calls get method on a resource.
     * 
     * @param resourcePath
     *            resource to call get method on.
     * @return Request body.
     */
    public static DeviceRequest callGetFunctionOnResource(String resourcePath) {
        if (resourcePath == null) {
            return null;
        }
        DeviceRequest request = new DeviceRequest();
        request.setMethod(RESOURCE_GET_METHOD);
        request.setUri(resourcePath);
        return request;
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

        @Override
        public Response<AsyncID> execute() throws IOException {
            final Response<Void> response = call.execute();
            if (response.isSuccessful()) {
                return Response.success(new AsyncID().asyncResponseId(uuid));
            }
            return Response.error(response.code(), response.errorBody());
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
