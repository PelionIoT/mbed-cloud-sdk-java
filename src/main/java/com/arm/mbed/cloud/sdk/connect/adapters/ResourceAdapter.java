package com.arm.mbed.cloud.sdk.connect.adapters;

import java.util.List;

import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.common.GenericListAdapter;
import com.arm.mbed.cloud.sdk.common.GenericListAdapter.Mapper;
import com.arm.mbed.cloud.sdk.common.TranslationUtils;
import com.arm.mbed.cloud.sdk.connect.model.Resource;

@Preamble(description = "Adapter for resource model")
public class ResourceAdapter {

    public static Resource map(String deviceId, com.arm.mbed.cloud.sdk.internal.model.Resource apiResource) {
        if (apiResource == null || deviceId == null || deviceId.isEmpty()) {
            return null;
        }
        Resource resource = new Resource();
        resource.setContentType(apiResource.getType());
        resource.setObservable(TranslationUtils.toBool(apiResource.getObs(), false));
        resource.setType(apiResource.getRt());
        resource.setPath(apiResource.getUri());
        resource.setDeviceId(deviceId);
        return resource;
    }

    public static List<Resource> mapList(String deviceId, List<com.arm.mbed.cloud.sdk.internal.model.Resource> list) {
        final String immutableDeviceId = deviceId;
        Mapper<Resource, com.arm.mbed.cloud.sdk.internal.model.Resource> mapper = new Mapper<Resource, com.arm.mbed.cloud.sdk.internal.model.Resource>() {

            @SuppressWarnings("unchecked")
            @Override
            public <T, U> T map(U toBeMapped) {
                return (T) ResourceAdapter.map(immutableDeviceId,
                        (com.arm.mbed.cloud.sdk.internal.model.Resource) toBeMapped);
            }
        };
        return GenericListAdapter.mapList(list, mapper);
    }

}
