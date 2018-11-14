package com.arm.mbed.cloud.sdk.connect.subscription.adapters;

import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.common.GenericAdapter.Mapper;
import com.arm.mbed.cloud.sdk.common.MbedCloudException;
import com.arm.mbed.cloud.sdk.connect.subscription.ResourceActionParameters;
import com.arm.mbed.cloud.sdk.internal.mds.model.DeviceRequest;

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

}
