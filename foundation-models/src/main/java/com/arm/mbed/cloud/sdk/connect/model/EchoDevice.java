package com.arm.mbed.cloud.sdk.connect.model;

import java.util.Date;
import java.util.List;
import java.util.Objects;

import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.common.SdkModel;

/**
 * The Device Echo object representing the device.
 */
@Preamble(description = "EchoDevice")
public class EchoDevice implements SdkModel {

    private static final long serialVersionUID = 1L;

    private Date createdAt;

    private String deviceId;

    private String endpointName;

    private Date lastDesiredAt;

    private Date lastReportedAt;

    private String object;

    private List<EchoResource> resources;

    private Date updatedAt;

    /**
     * @param createdAt
     *            Response creation UTC time.
     * @param deviceId
     *            The device ID.
     * @param endpointName
     *            The endpoint name.
     * @param lastDesiredAt
     *            The last time a write command was initiated on a resource.
     * @param lastReportedAt
     *            The last time any resource&#39;s reported value was updated.
     * @param object
     *            API Resource name
     * @param resources
     *            The list of device resources stored in Device Echo.
     * @param updatedAt
     *            The time of last registration event of a Device Echo object.
     */
    public EchoDevice(Date createdAt, String deviceId, String endpointName, Date lastDesiredAt, Date lastReportedAt,
                      String object, List<EchoResource> resources, Date updatedAt) {
        super();
        this.createdAt = createdAt;
        this.deviceId = deviceId;
        this.endpointName = endpointName;
        this.lastDesiredAt = lastDesiredAt;
        this.lastReportedAt = lastReportedAt;
        this.object = object;
        this.resources = resources;
        this.updatedAt = updatedAt;
    }

    public EchoDevice() {
        this(null, null, null, null, null, null, null, null);
    }

    @Override
    public EchoDevice clone() {
        return new EchoDevice(createdAt, deviceId, endpointName, lastDesiredAt, lastReportedAt, object, resources,
                              updatedAt);
    }

    @Override
    public boolean isValid() {
        return true;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getEndpointName() {
        return endpointName;
    }

    public void setEndpointName(String endpointName) {
        this.endpointName = endpointName;
    }

    public Date getLastDesiredAt() {
        return lastDesiredAt;
    }

    public void setLastDesiredAt(Date lastDesiredAt) {
        this.lastDesiredAt = lastDesiredAt;
    }

    public Date getLastReportedAt() {
        return lastReportedAt;
    }

    public void setLastReportedAt(Date lastReportedAt) {
        this.lastReportedAt = lastReportedAt;
    }

    public String getObject() {
        return object;
    }

    public void setObject(String object) {
        this.object = object;
    }

    public List<EchoResource> getResources() {
        return resources;
    }

    public void setResources(List<EchoResource> resources) {
        this.resources = resources;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    @Override
    public String getId() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setId(String id) {
        // TODO Auto-generated method stub

    }

    @Override
    public int hashCode() {
        return Objects.hash(createdAt, deviceId, endpointName, lastDesiredAt, lastReportedAt, object, resources,
                            updatedAt);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final EchoDevice other = (EchoDevice) obj;
        return Objects.equals(createdAt, other.createdAt) && Objects.equals(deviceId, other.deviceId)
               && Objects.equals(endpointName, other.endpointName) && Objects.equals(lastDesiredAt, other.lastDesiredAt)
               && Objects.equals(lastReportedAt, other.lastReportedAt) && Objects.equals(object, other.object)
               && Objects.equals(resources, other.resources) && Objects.equals(updatedAt, other.updatedAt);
    }

    @Override
    public String toString() {
        return "{\"EchoDevice\": {\"createdAt\":\"" + createdAt + "\", \"deviceId\":\"" + deviceId
               + "\", \"endpointName\":\"" + endpointName + "\", \"lastDesiredAt\":\"" + lastDesiredAt
               + "\", \"lastReportedAt\":\"" + lastReportedAt + "\", \"object\":\"" + object + "\", \"resources\":"
               + resources + ", \"updatedAt\":\"" + updatedAt + "\"}}";
    }

}
