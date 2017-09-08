package com.arm.mbed.cloud.sdk.devicedirectory.adapters;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.arm.mbed.cloud.sdk.annotations.Internal;
import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.common.GenericAdapter;
import com.arm.mbed.cloud.sdk.common.GenericAdapter.Mapper;
import com.arm.mbed.cloud.sdk.common.GenericAdapter.RespList;
import com.arm.mbed.cloud.sdk.common.TranslationUtils;
import com.arm.mbed.cloud.sdk.common.listing.ListResponse;
import com.arm.mbed.cloud.sdk.common.listing.filtering.FilterMarshaller;
import com.arm.mbed.cloud.sdk.devicedirectory.model.Device;
import com.arm.mbed.cloud.sdk.devicedirectory.model.DeviceState;
import com.arm.mbed.cloud.sdk.devicedirectory.model.MechanismType;
import com.arm.mbed.cloud.sdk.internal.devicedirectory.model.DeviceData;
import com.arm.mbed.cloud.sdk.internal.devicedirectory.model.DeviceDataPatchRequest;
import com.arm.mbed.cloud.sdk.internal.devicedirectory.model.DeviceDataPostRequest;
import com.arm.mbed.cloud.sdk.internal.devicedirectory.model.DeviceDataPostRequest.MechanismEnum;
import com.arm.mbed.cloud.sdk.internal.devicedirectory.model.DeviceDataPostRequest.StateEnum;
import com.arm.mbed.cloud.sdk.internal.devicedirectory.model.DevicePage;

@Preamble(description = "Adapter for device model")
@Internal
public class DeviceAdapter {
    public static final FilterMarshaller FILTERS_MARSHALLER = getFilterMarshaller();

    private DeviceAdapter() {
        super();
    }

    private static FilterMarshaller getFilterMarshaller() {
        Map<String, String> filterMapping = new HashMap<>(4);
        filterMapping.put("alias", "endpoint_name");
        filterMapping.put("bootstrapCertificateExpiration", "bootstrap_expiration_date");
        filterMapping.put("certificateFingerprint", "device_key");
        filterMapping.put("certificateIssuerId", "ca_id");
        filterMapping.put("connectorCertificateExpiration", "connector_expiration_date");
        return new FilterMarshaller(filterMapping);
    }

    public static Device map(DeviceData deviceData) {
        if (deviceData == null) {
            return null;
        }
        Device device = new Device(deviceData.getId(), deviceData.getAccountId(),
                TranslationUtils.toDate(deviceData.getCreatedAt()), TranslationUtils.toDate(deviceData.getUpdatedAt()),
                TranslationUtils.toDate(deviceData.getManifestTimestamp()));
        device.setBootstrappedTimestamp(TranslationUtils.toDate(deviceData.getBootstrappedTimestamp()));
        device.setCustomAttributes(deviceData.getCustomAttributes());
        device.setDescription(deviceData.getDescription());
        device.setDeviceClass(deviceData.getDeviceClass());
        device.setMechanism(toMechanismType(deviceData.getMechanism()));
        device.setMechanismUrl(TranslationUtils.toUrl(deviceData.getMechanismUrl()));
        device.setName(deviceData.getName());
        device.setSerialNumber(deviceData.getSerialNumber());
        device.setState(toState(deviceData.getState()));
        device.setTrustLevel(deviceData.getTrustLevel());
        device.setVendorId(deviceData.getVendorId());
        device.setAlias(deviceData.getEndpointName());
        device.setBootstrapCertificateExpiration(TranslationUtils.toDate(deviceData.getBootstrapExpirationDate()));
        device.setCertificateFingerprint(deviceData.getDeviceKey());
        device.setCertificateIssuerId(deviceData.getCaId());
        device.setConnectorCertificateExpiration(TranslationUtils.toDate(deviceData.getConnectorExpirationDate()));
        device.setDeviceExecutionMode(deviceData.getDeviceExecutionMode());
        device.setFirmwareChecksum(deviceData.getFirmwareChecksum());
        device.setHostGateway(deviceData.getHostGateway());
        device.setDeviceType(deviceData.getEndpointType());
        return device;
    }

    private static DeviceState toState(
            com.arm.mbed.cloud.sdk.internal.devicedirectory.model.DeviceData.StateEnum state) {
        if (state == null) {
            return DeviceState.getDefault();
        }
        switch (state) {
            case BOOTSTRAPPED:
                return DeviceState.BOOTSTRAPPED;
            case CLOUD_ENROLLING:
                return DeviceState.CLOUD_ENROLLING;
            case DEREGISTERED:
                return DeviceState.DEREGISTERED;
            case REGISTERED:
                return DeviceState.REGISTERED;
            case UNENROLLED:
                return DeviceState.UNENROLLED;
            default:
                break;

        }
        return DeviceState.getDefault();
    }

    private static MechanismType toMechanismType(
            com.arm.mbed.cloud.sdk.internal.devicedirectory.model.DeviceData.MechanismEnum mechanism) {
        if (mechanism == null) {
            return MechanismType.getDefault();
        }
        switch (mechanism) {
            case CONNECTOR:
                return MechanismType.CONNECTOR;
            case DIRECT:
                return MechanismType.DIRECT;
            default:
                break;

        }
        return MechanismType.getDefault();
    }

    public static Mapper<DeviceData, Device> getMapper() {
        return new Mapper<DeviceData, Device>() {

            @Override
            public Device map(DeviceData toBeMapped) {
                return DeviceAdapter.map(toBeMapped);
            }
        };
    }

    public static ListResponse<Device> mapList(DevicePage list) {
        final DevicePage deviceList = list;
        RespList<DeviceData> respList = new RespList<DeviceData>() {

            @Override
            public Boolean getHasMore() {
                return (deviceList == null) ? null : deviceList.getHasMore();
            }

            @Override
            public Integer getTotalCount() {
                return (deviceList == null) ? null : deviceList.getTotalCount();
            }

            @Override
            public String getAfter() {
                return (deviceList == null) ? null : deviceList.getAfter();
            }

            @Override
            public Integer getLimit() {
                return (deviceList == null) ? null : deviceList.getLimit();
            }

            @Override
            public String getOrder() {
                return (deviceList == null) ? null : deviceList.getOrder().toString();
            }

            @Override
            public List<DeviceData> getData() {
                return (deviceList == null) ? null : deviceList.getData();
            }
        };
        return GenericAdapter.mapList(respList, getMapper());
    }

    public static Mapper<DevicePage, ListResponse<Device>> getListMapper() {
        return new Mapper<DevicePage, ListResponse<Device>>() {

            @Override
            public ListResponse<Device> map(DevicePage toBeMapped) {
                return DeviceAdapter.mapList(toBeMapped);
            }

        };
    }

    public static DeviceDataPostRequest reverseMapAdd(Device device) {
        if (device == null) {
            return null;
        }
        DeviceDataPostRequest addDevice = new DeviceDataPostRequest();
        addDevice.setName(device.getName());
        addDevice.setVendorId(device.getVendorId());
        addDevice.setCustomAttributes(device.getCustomAttributes());
        addDevice.setMechanism(toAddMechanism(device.getMechanism()));
        addDevice.setDeviceClass(device.getDeviceClass());
        addDevice.setMechanismUrl(TranslationUtils.toString(device.getMechanismUrl()));
        addDevice.setSerialNumber(device.getSerialNumber());
        addDevice.setTrustLevel(device.getTrustLevel());
        addDevice.setDescription(device.getDescription());
        addDevice.setBootstrapExpirationDate(TranslationUtils.toDateTime(device.getBootstrapCertificateExpiration()));
        addDevice.setBootstrappedTimestamp(TranslationUtils.toDateTime(device.getBootstrappedTimestamp()));
        addDevice.setCaId(device.getCertificateIssuerId());
        addDevice.setConnectorExpirationDate(TranslationUtils.toDateTime(device.getConnectorCertificateExpiration()));
        addDevice.setDeviceExecutionMode(device.getDeviceExecutionMode());
        addDevice.setDeviceKey(device.getCertificateFingerprint());
        addDevice.setEndpointName(device.getAlias());
        addDevice.setFirmwareChecksum(device.getFirmwareChecksum());
        addDevice.setState(toAddState(device.getState()));
        addDevice.setHostGateway(device.getHostGateway());
        addDevice.setEndpointType(device.getDeviceType());
        return addDevice;
    }

    private static StateEnum toAddState(DeviceState state) {
        if (state == null) {
            return null;
        }
        switch (state) {
            case BOOTSTRAPPED:
                return StateEnum.BOOTSTRAPPED;
            case CLOUD_ENROLLING:
                return StateEnum.CLOUD_ENROLLING;
            case DEREGISTERED:
                return StateEnum.DEREGISTERED;
            case REGISTERED:
                return StateEnum.REGISTERED;
            case UNENROLLED:
                return StateEnum.UNENROLLED;
            default:
                break;
        }
        return null;
    }

    private static MechanismEnum toAddMechanism(MechanismType mechanism) {
        if (mechanism == null) {
            return null;
        }
        switch (mechanism) {
            case CONNECTOR:
                return MechanismEnum.CONNECTOR;
            case DIRECT:
                return MechanismEnum.DIRECT;
            default:
                break;

        }
        return null;
    }

    public static DeviceDataPatchRequest reverseMapUpdate(Device device) {
        if (device == null) {
            return null;
        }
        DeviceDataPatchRequest updateDevice = new DeviceDataPatchRequest();
        updateDevice.setName(device.getName());
        updateDevice.setCustomAttributes(device.getCustomAttributes());
        updateDevice.setDescription(device.getDescription());
        updateDevice.setCaId(device.getCertificateIssuerId());
        updateDevice.setDeviceKey(device.getCertificateFingerprint());
        updateDevice.setEndpointName(device.getAlias());
        updateDevice.setHostGateway(device.getHostGateway());
        updateDevice.setEndpointType(device.getDeviceType());
        return updateDevice;
    }

}
