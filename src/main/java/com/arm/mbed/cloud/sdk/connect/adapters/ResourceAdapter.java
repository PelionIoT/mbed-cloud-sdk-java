package com.arm.mbed.cloud.sdk.connect.adapters;

import java.util.List;

import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.common.GenericAdapter;
import com.arm.mbed.cloud.sdk.common.GenericAdapter.Mapper;
import com.arm.mbed.cloud.sdk.common.TranslationUtils;
import com.arm.mbed.cloud.sdk.connect.model.Resource;

@Preamble(description = "Adapter for resource model")
public class ResourceAdapter {

    private ResourceAdapter() {
        super();
    }

    public static Resource map(String deviceId, com.arm.mbed.cloud.sdk.internal.mds.model.Resource apiResource) {
        if (apiResource == null || deviceId == null || deviceId.isEmpty()) {
            return null;
        }
        return new Resource(deviceId, apiResource.getUri(), apiResource.getRt(), apiResource.getType(),
                TranslationUtils.toBool(apiResource.getObs(), false));
    }

    public static Mapper<com.arm.mbed.cloud.sdk.internal.mds.model.Resource, Resource> getMapper(String deviceId) {
        final String immutableDeviceId = deviceId;
        return new Mapper<com.arm.mbed.cloud.sdk.internal.mds.model.Resource, Resource>() {

            @Override
            public Resource map(com.arm.mbed.cloud.sdk.internal.mds.model.Resource toBeMapped) {
                return ResourceAdapter.map(immutableDeviceId, toBeMapped);
            }
        };
    }

    public static List<Resource> mapList(String deviceId,
            List<com.arm.mbed.cloud.sdk.internal.mds.model.Resource> list) {
        return GenericAdapter.mapList(list, getMapper(deviceId));
    }

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

}
