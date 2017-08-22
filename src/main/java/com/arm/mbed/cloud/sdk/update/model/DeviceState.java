package com.arm.mbed.cloud.sdk.update.model;

import java.net.URL;
import java.util.Date;

import com.arm.mbed.cloud.sdk.annotations.Preamble;

@Preamble(description = "Device State")
public class DeviceState {

    /**
     * The id of the metadata record
     */
    private final String id;
    /**
     * The id of the device
     */
    private final String deviceId;
    /**
     * The id of the campaign the device is in
     */
    private final String campaignId;
    /**
     * The state of the update campaign on the device
     */
    private final CampaignState state;
    /**
     * The name of the device
     */
    private final String name;
    /**
     * Description of the device
     */
    private final String description;
    /**
     * This time the record was created in the database
     */
    private Date createdAt;
    /**
     * This time this record was modified in the database format: date-time
     */
    private Date updatedAt;
    /**
     * The mechanism used to deliver the firmware (connector or direct)
     */
    private final String mechanism;
    /**
     * The url of cloud connect used
     */
    private final URL mechanismUrl;

    public DeviceState(String id, String deviceId, String campaignId, CampaignState state, String name,
            String description, Date createdAt, Date updatedAt, String mechanism, URL mechanismUrl) {
        super();
        this.id = id;
        this.deviceId = deviceId;
        this.campaignId = campaignId;
        this.state = state;
        this.name = name;
        this.description = description;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.mechanism = mechanism;
        this.mechanismUrl = mechanismUrl;
    }

    /**
     * @return the createdAt
     */
    public Date getCreatedAt() {
        return createdAt;
    }

    /**
     * @param createdAt
     *            the createdAt to set
     */
    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * @return the updatedAt
     */
    public Date getUpdatedAt() {
        return updatedAt;
    }

    /**
     * @param updatedAt
     *            the updatedAt to set
     */
    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @return the deviceId
     */
    public String getDeviceId() {
        return deviceId;
    }

    /**
     * @return the campaignId
     */
    public String getCampaignId() {
        return campaignId;
    }

    /**
     * @return the state
     */
    public CampaignState getState() {
        return state;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @return the mechanism
     */
    public String getMechanism() {
        return mechanism;
    }

    /**
     * @return the mechanismUrl
     */
    public URL getMechanismUrl() {
        return mechanismUrl;
    }

}
