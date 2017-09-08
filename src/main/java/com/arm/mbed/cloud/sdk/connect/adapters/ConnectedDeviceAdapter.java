package com.arm.mbed.cloud.sdk.connect.adapters;

import java.util.List;

import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.common.GenericAdapter;
import com.arm.mbed.cloud.sdk.common.GenericAdapter.Mapper;
import com.arm.mbed.cloud.sdk.common.TranslationUtils;
import com.arm.mbed.cloud.sdk.connect.model.ConnectedDevice;
import com.arm.mbed.cloud.sdk.internal.mds.model.Endpoint;

@Preamble(description = "Adapter for connected device model")
public class ConnectedDeviceAdapter {

    private ConnectedDeviceAdapter() {
        super();
    }

    public static ConnectedDevice map(Endpoint endpoint) {
        if (endpoint == null) {
            return null;
        }
        return new ConnectedDevice(endpoint.getName(), TranslationUtils.toBool(endpoint.getQ(), false),
                endpoint.getType());

    }

    public static Mapper<Endpoint, ConnectedDevice> getMapper() {
        return new Mapper<Endpoint, ConnectedDevice>() {

            @Override
            public ConnectedDevice map(Endpoint toBeMapped) {
                return ConnectedDeviceAdapter.map(toBeMapped);
            }

        };
    }

    public static List<ConnectedDevice> mapList(List<Endpoint> endpoints) {
        return GenericAdapter.mapList(endpoints, getMapper());
    }

    public static Mapper<List<Endpoint>, List<ConnectedDevice>> getListMapper() {
        return new Mapper<List<Endpoint>, List<ConnectedDevice>>() {

            @Override
            public List<ConnectedDevice> map(List<Endpoint> toBeMapped) {
                return ConnectedDeviceAdapter.mapList(toBeMapped);
            }
        };
    }
}
