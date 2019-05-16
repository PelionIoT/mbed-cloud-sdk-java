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
import com.arm.mbed.cloud.sdk.common.listing.filtering.FilterOperator;
import com.arm.mbed.cloud.sdk.devicedirectory.model.Device;
import com.arm.mbed.cloud.sdk.devicedirectory.model.DeviceListOptions;
import com.arm.mbed.cloud.sdk.devicedirectory.model.DeviceState;
import com.arm.mbed.cloud.sdk.devicedirectory.model.MechanismType;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.DeviceData;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.DeviceDataPostRequest;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.DeviceDataPostRequest.MechanismEnum;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.DeviceDataPostRequest.StateEnum;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.DeviceDataPutRequest;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.DevicePage;
import com.arm.mbed.cloud.sdk.subscribe.model.SubscriptionFilterOptions;

@Preamble(description = "Adapter for device model")
@Internal
public final class DeviceAdapter {
    public static final FilterMarshaller FILTERS_MARSHALLER = getFilterMarshaller();

    private DeviceAdapter() {
        super();
    }

    private static FilterMarshaller getFilterMarshaller() {
        final Map<String, String> filterMapping = new HashMap<>(4);
        filterMapping.put(DeviceListOptions.FILTER_ALIAS, "endpoint_name");
        filterMapping.put(DeviceListOptions.FILTER_BOOTSTRAP_CERTIFICATE_EXPIRATION, "bootstrap_expiration_date");
        filterMapping.put(DeviceListOptions.FILTER_CERTIFICATE_FINGERPRINT, "device_key");
        filterMapping.put(DeviceListOptions.FILTER_CERTIFICATE_ISSUER_ID, "ca_id");
        filterMapping.put(DeviceListOptions.FILTER_CONNECTOR_CERTIFICATE_EXPIRATION, "connector_expiration_date");
        filterMapping.put(DeviceListOptions.FILTER_DEVICE_TYPE, "endpoint_type");
        return new FilterMarshaller(filterMapping);
    }

    /**
     * Maps subscription options into device list options.
     *
     * @param filters
     *            subscription filter
     * @return corresponding device list options
     */
    public static DeviceListOptions mapSubscriptionOptions(SubscriptionFilterOptions filters) {
        if (filters == null) {
            return null;
        }
        if (!filters.hasFilters(SubscriptionFilterOptions.DEVICE_ID_FILTER)) {
            return null;
        }
        boolean addedFilters = false;
        final DeviceListOptions listOptions = new DeviceListOptions();
        if (filters.hasFilter(SubscriptionFilterOptions.DEVICE_ID_FILTER, FilterOperator.EQUAL)) {
            addedFilters = true;
            listOptions.addIdFilter((String) filters.fetchSpecificFilterValue(SubscriptionFilterOptions.DEVICE_ID_FILTER,
                                                                              FilterOperator.EQUAL),
                                    FilterOperator.EQUAL);
        }
        if (filters.hasFilter(SubscriptionFilterOptions.DEVICE_ID_FILTER, FilterOperator.NOT_EQUAL)) {
            addedFilters = true;
            listOptions.addIdFilter((String) filters.fetchSpecificFilterValue(SubscriptionFilterOptions.DEVICE_ID_FILTER,
                                                                              FilterOperator.NOT_EQUAL),
                                    FilterOperator.NOT_EQUAL);
        }
        // TODO do other filters when implemented

        return addedFilters ? listOptions : null;

    }

    /**
     * Maps device data.
     *
     * @param deviceData
     *            device data to map
     * @return mapped device data
     */
    public static Device map(DeviceData deviceData) {
        if (deviceData == null) {
            return null;
        }
        final Device device = new Device(deviceData.getId(), deviceData.getAccountId(),
                                         TranslationUtils.toDate(deviceData.getCreatedAt()),
                                         TranslationUtils.toDate(deviceData.getUpdatedAt()),
                                         TranslationUtils.toDate(deviceData.getEnrolmentListTimestamp()),
                                         TranslationUtils.toDate(deviceData.getManifestTimestamp()));
        device.setCustomAttributes(deviceData.getCustomAttributes());
        device.setDescription(deviceData.getDescription());
        device.setDeviceClass(deviceData.getDeviceClass());
        device.setMechanism(toMechanismType(deviceData.getMechanism()));
        device.setMechanismUrl(TranslationUtils.toUrl(deviceData.getMechanismUrl()));
        device.setName(deviceData.getName());
        device.setSerialNumber(deviceData.getSerialNumber());
        device.setState(toState(deviceData.getState()));
        device.setVendorId(deviceData.getVendorId());
        device.setAlias(deviceData.getEndpointName());
        device.setBootstrapCertificateExpiration(TranslationUtils.toDate(deviceData.getBootstrapExpirationDate()));
        device.setCertificateFingerprint(deviceData.getDeviceKey());
        device.setCertificateIssuerId(deviceData.getCaId());
        device.setConnectorCertificateExpiration(TranslationUtils.toDate(deviceData.getConnectorExpirationDate()));
        device.setDeviceExecutionMode(deviceData.getDeviceExecutionMode());
        device.setHostGateway(deviceData.getHostGateway());
        device.setDeviceType(deviceData.getEndpointType());
        return device;
    }

    /**
     * Gets a mapper.
     *
     * @return a mapper
     */
    public static Mapper<DeviceData, Device> getMapper() {
        return new Mapper<DeviceData, Device>() {

            @Override
            public Device map(DeviceData toBeMapped) {
                return DeviceAdapter.map(toBeMapped);
            }
        };
    }

    /**
     * Maps a list of device data.
     *
     * @param list
     *            device page
     * @return a list of devices
     */
    public static ListResponse<Device> mapList(DevicePage list) {
        final DevicePage deviceList = list;
        final RespList<DeviceData> respList = new RespList<DeviceData>() {

            @Override
            public Boolean getHasMore() {
                return (deviceList == null) ? null : deviceList.isHasMore();
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

            @Override
            public String getContinuationMarker() {
                return null;
            }
        };
        return GenericAdapter.mapList(respList, getMapper());
    }

    /**
     * Gets list mapper.
     *
     * @return list mapper
     */
    public static Mapper<DevicePage, ListResponse<Device>> getListMapper() {
        return new Mapper<DevicePage, ListResponse<Device>>() {

            @Override
            public ListResponse<Device> map(DevicePage toBeMapped) {
                return DeviceAdapter.mapList(toBeMapped);
            }

        };
    }

    /**
     * Reverses the mapping of a new device.
     *
     * @param device
     *            new device
     * @return a new device data request
     */
    public static DeviceDataPostRequest reverseMapAdd(Device device) {
        if (device == null) {
            return null;
        }
        final DeviceDataPostRequest addDevice = new DeviceDataPostRequest();
        addDevice.setName(device.getName());
        addDevice.setVendorId(device.getVendorId());
        addDevice.setCustomAttributes(device.getCustomAttributes());
        addDevice.setMechanism(toAddMechanism(device.getMechanism()));
        addDevice.setDeviceClass(device.getDeviceClass());
        addDevice.setMechanismUrl(TranslationUtils.toString(device.getMechanismUrl()));
        addDevice.setSerialNumber(device.getSerialNumber());
        addDevice.setDescription(device.getDescription());
        addDevice.setBootstrapExpirationDate(TranslationUtils.toLocalDate(device.getBootstrapCertificateExpiration()));
        addDevice.setCaId(device.getCertificateIssuerId());
        addDevice.setConnectorExpirationDate(TranslationUtils.toLocalDate(device.getConnectorCertificateExpiration()));
        addDevice.setDeviceExecutionMode(device.getDeviceExecutionMode());
        addDevice.setDeviceKey(device.getCertificateFingerprint());
        addDevice.setEndpointName(device.getAlias());
        addDevice.setState(toAddState(device.getState()));
        addDevice.setHostGateway(device.getHostGateway());
        addDevice.setEndpointType(device.getDeviceType());
        return addDevice;
    }

    /**
     * Reverses the mapping of an updated device.
     *
     * @param device
     *            updated device
     * @return a device data update request
     */
    public static DeviceDataPutRequest reverseMapUpdate(Device device) {
        if (device == null) {
            return null;
        }
        final DeviceDataPutRequest updateDevice = new DeviceDataPutRequest();
        updateDevice.setName(device.getName());
        updateDevice.setCustomAttributes(device.getCustomAttributes());
        updateDevice.setDescription(device.getDescription());
        updateDevice.setCaId(device.getCertificateIssuerId());
        updateDevice.setDeviceKey(device.getCertificateFingerprint());
        updateDevice.setHostGateway(device.getHostGateway());
        updateDevice.setEndpointType(device.getDeviceType());
        return updateDevice;
    }

    private static DeviceState toState(DeviceData.StateEnum state) {
        if (state == null) {
            return DeviceState.getUnknownEnum();
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
        return DeviceState.getUnknownEnum();
    }

    private static MechanismType toMechanismType(DeviceData.MechanismEnum mechanism) {
        if (mechanism == null) {
            return MechanismType.getUnknownEnum();
        }
        switch (mechanism) {
            case CONNECTOR:
                return MechanismType.CONNECTOR;
            case DIRECT:
                return MechanismType.DIRECT;
            default:
                break;

        }
        return MechanismType.getUnknownEnum();
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

    /**
     * Maps to a foundation device
     * 
     * @param device
     * @return a device
     */
    public static com.arm.mbed.cloud.sdk.devices.model.Device mapToFoundation(Device device) {
        // TODO do properly new com.arm.mbed.cloud.sdk.devices.model.Device(device.getAccountId(), false,
        // device.getBootstrapCertificateExpiration(), device.getBootstrappedTimestamp(),
        // device.getCertificateIssuerId(), device.getConnectorCertificateExpiration(), device.getCreatedAt(),
        // device.getCustomAttributes(), null, null, device.getDescription(), device.getDeviceClass(),
        // device.getDeviceExecutionMode(), null, device.getAlias(), device.getDeviceType(), 0,
        // device.getFirmwareChecksum(), device.getHostGateway(), device.getId(), device.getCertificateFingerprint(),
        // null, device.getManifestTimestamp(), device.getMechanism(), device.getMechanismUrl(), device.getName(),
        // device.getSerialNumber(), null, device.getUpdatedAt(), device.getVendorId());
        return device == null ? null : new com.arm.mbed.cloud.sdk.devices.model.Device(device.getId());
    }

}
