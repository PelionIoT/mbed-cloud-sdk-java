package com.arm.mbed.cloud.sdk.devicedirectory.adapters;

import java.util.HashMap;
import java.util.Map;

import com.arm.mbed.cloud.sdk.annotations.Internal;
import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.common.GenericAdapter.Mapper;
import com.arm.mbed.cloud.sdk.common.listing.ListResponse;
import com.arm.mbed.cloud.sdk.common.listing.filtering.FilterMarshaller;
import com.arm.mbed.cloud.sdk.devicedirectory.model.Device;
import com.arm.mbed.cloud.sdk.internal.devicedirectory.model.DeviceData;
import com.arm.mbed.cloud.sdk.internal.devicedirectory.model.DeviceDataPatchRequest;
import com.arm.mbed.cloud.sdk.internal.devicedirectory.model.DeviceDataPostRequest;
import com.arm.mbed.cloud.sdk.internal.devicedirectory.model.DevicePage;

@Preamble(description = "Adapter for device model")
@Internal
public class DeviceAdapter {
    public static final FilterMarshaller FILTERS_MARSHALLER = getFilterMarshaller();

    private static FilterMarshaller getFilterMarshaller() {
        Map<String, String> filterMapping = new HashMap<>(4);
        filterMapping.put("alias", "endpoint_name");
        filterMapping.put("bootstrapCertificateExpiration", "bootstrap_expiration_date");
        filterMapping.put("certificateFingerprint", "device_key");
        filterMapping.put("certificateIssuerId", "ca_id");
        filterMapping.put("connectorCertificateExpiration", "connector_expiration_date");
        return new FilterMarshaller(filterMapping);
    }

    public DeviceAdapter() {
        // TODO Auto-generated constructor stub
    }

    public static Mapper<DevicePage, ListResponse<Device>> getListMapper() {
        // TODO Auto-generated method stub
        return null;
    }

    public static Mapper<DeviceData, Device> getMapper() {
        // TODO Auto-generated method stub
        return null;
    }

    public static DeviceDataPostRequest reverseMapAdd(Device device) {
        // TODO Auto-generated method stub
        return null;
    }

    public static DeviceDataPatchRequest reverseMapUpdate(Device finalDevice) {
        // TODO Auto-generated method stub
        return null;
    }

}
