package com.arm.mbed.cloud.sdk.connect.adapters;

import java.util.List;

import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.common.GenericListAdapter;
import com.arm.mbed.cloud.sdk.common.GenericListAdapter.Mapper;
import com.arm.mbed.cloud.sdk.common.TranslationUtils;
import com.arm.mbed.cloud.sdk.connect.model.ConnectedDevice;
import com.arm.mbed.cloud.sdk.internal.model.Endpoint;

@Preamble(description = "Adapter for connected device model")
public class ConnectedDeviceAdapter {

    public static ConnectedDevice map(Endpoint endpoint) {
        if (endpoint == null) {
            return null;
        }
        ConnectedDevice device = new ConnectedDevice();
        device.setId(endpoint.getName());
        device.setQueueMode(TranslationUtils.toBool(endpoint.getQ(), false));
        device.setType(endpoint.getType());
        return device;
    }

    public static List<ConnectedDevice> mapList(List<Endpoint> endpoints) {
        Mapper<ConnectedDevice, Endpoint> mapper = new Mapper<ConnectedDevice, Endpoint>() {

            @SuppressWarnings("unchecked")
            @Override
            public <T, U> T map(U toBeMapped) {
                return (T) ConnectedDeviceAdapter.map((Endpoint) toBeMapped);
            }
        };
        return GenericListAdapter.mapList(endpoints, mapper);
    }
}
