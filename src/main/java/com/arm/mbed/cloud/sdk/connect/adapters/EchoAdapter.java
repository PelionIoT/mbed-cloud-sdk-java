package com.arm.mbed.cloud.sdk.connect.adapters;

import java.util.List;

import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.common.GenericAdapter;
import com.arm.mbed.cloud.sdk.common.GenericAdapter.Mapper;
import com.arm.mbed.cloud.sdk.connect.model.EchoDevice;
import com.arm.mbed.cloud.sdk.connect.model.EchoResource;
import com.arm.mbed.cloud.sdk.connect.model.EchoResourceDesired;
import com.arm.mbed.cloud.sdk.connect.model.EchoResourceReported;

@Preamble(description = "Adapter for echo model")
public final class EchoAdapter {

    private EchoAdapter() {
        super();
    }

    /**
     * Maps a echo device.
     *
     * @param deviceId
     *            device id of the device containing the echoDevice
     * @param apiEchoDevice
     *            echoDevice to map
     * @return mapped echoDevice
     */
    public static EchoDevice
           map(String deviceId,
               com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.EchoDevice apiEchoDevice) {
        if (apiEchoDevice == null || deviceId == null || deviceId.isEmpty()) {
            return null;
        }
        return new EchoDevice(apiEchoDevice.getCreatedAt(), apiEchoDevice.getDeviceId(),
                              apiEchoDevice.getEndpointName(), apiEchoDevice.getLastDesiredAt(),
                              apiEchoDevice.getLastReportedAt(), apiEchoDevice.getObject(),
                              mapResourceList(deviceId, apiEchoDevice.getResources()), apiEchoDevice.getUpdatedAt());
    }

    /**
     * Maps a echo resource.
     *
     * @param deviceId
     *            device id of the device containing the echoResource
     * @param apiEchoResource
     *            echo resource to map
     * @return mapped EchoResource
     */
    public static EchoResource
           mapResource(String deviceId,
                       com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.EchoResource apiEchoResource) {
        if (apiEchoResource == null || deviceId == null || deviceId.isEmpty()) {
            return null;
        }

        return new EchoResource(mapResourceDesired(deviceId, apiEchoResource.getDesired()),
                                mapResourceReported(deviceId, apiEchoResource.getReported()),
                                apiEchoResource.getResourcePath(), apiEchoResource.isSubscribed());
    }

    /**
     * Maps a EchoResourceDesired.
     *
     * @param deviceId
     *            device id of the device containing the echoResourceDesired
     * @param apiEchoResourceDesired
     *            echoResourceDesired to map
     * @return mapped EchoResourceDesired
     */
    public static EchoResourceDesired
           mapResourceDesired(String deviceId,
                              com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.EchoResourceDesired apiEchoResourceDesired) {
        if (apiEchoResourceDesired == null || deviceId == null || deviceId.isEmpty()) {
            return null;
        }

        return new EchoResourceDesired(apiEchoResourceDesired.getDesiredAt(), apiEchoResourceDesired.getStatus(),
                                       apiEchoResourceDesired.getStatusUpdatedAt(), apiEchoResourceDesired.getValue());
    }

    /**
     * Maps a EchoResourceReported.
     *
     * @param deviceId
     *            device id of the device containing the EchoResourceReported
     * @param apiEchoResourceReported
     *            EchoResourceReported to map
     * @return mapped EchoResourceReported
     */
    public static EchoResourceReported
           mapResourceReported(String deviceId,
                               com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.EchoResourceReported apiEchoResourceReported) {
        if (apiEchoResourceReported == null || deviceId == null || deviceId.isEmpty()) {
            return null;
        }

        return new EchoResourceReported(apiEchoResourceReported.getContentType(),
                                        apiEchoResourceReported.getExpiresAt(), apiEchoResourceReported.getReportedAt(),
                                        apiEchoResourceReported.getValue());
    }

    /**
     * Gets a mapper.
     *
     * @param deviceId
     *            device id of the device containing the echoDevice
     * @return a mapper for this device.
     */
    public static Mapper<com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.EchoDevice, EchoDevice>
           getMapper(String deviceId) {
        final String immutableDeviceId = deviceId;
        return new Mapper<com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.EchoDevice, EchoDevice>() {

            @Override
            public EchoDevice
                   map(com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.EchoDevice toBeMapped) {
                return EchoAdapter.map(immutableDeviceId, toBeMapped);
            }
        };
    }

    /**
     * Gets a resource mapper.
     *
     * @param deviceId
     *            device id of the device containing the echoResource
     * @return a resource mapper for this device.
     */
    public static Mapper<com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.EchoResource, EchoResource>
           getResourceMapper(String deviceId) {
        final String immutableDeviceId = deviceId;
        return new Mapper<com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.EchoResource,
                          EchoResource>() {

            @Override
            public EchoResource
                   map(com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.EchoResource toBeMapped) {
                return EchoAdapter.mapResource(immutableDeviceId, toBeMapped);
            }
        };
    }

    /**
     * Maps a list of echoDevices.
     *
     * @param deviceId
     *            device id of the device containing the echoDevices
     * @param list
     *            echoDevice page
     * @return list of echoDevices
     */
    public static List<EchoDevice>
           mapList(String deviceId,
                   List<com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.EchoDevice> list) {
        return GenericAdapter.mapList(list, getMapper(deviceId));
    }

    public static List<EchoResource>
           mapResourceList(String deviceId,
                           List<com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.EchoResource> list) {
        return GenericAdapter.mapList(list, getResourceMapper(deviceId));
    }

    /**
     * Gets list mapper.
     *
     * @param deviceId
     *            device id of the device containing the echoDevices
     * @return a list mapper
     */
    public static
           Mapper<List<com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.EchoDevice>, List<EchoDevice>>
           getListMapper(String deviceId) {
        final String immutableDeviceId = deviceId;
        return new Mapper<List<com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.EchoDevice>,
                          List<EchoDevice>>() {

            @Override
            public List<EchoDevice>
                   map(List<com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.EchoDevice> toBeMapped) {
                return EchoAdapter.mapList(immutableDeviceId, toBeMapped);
            }

        };
    }

}
