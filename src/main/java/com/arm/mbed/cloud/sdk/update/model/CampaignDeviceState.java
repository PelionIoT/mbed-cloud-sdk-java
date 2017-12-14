package com.arm.mbed.cloud.sdk.update.model;

import java.net.URL;
import java.util.Date;

import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.common.SdkModel;

@Preamble(description = "Campaign device state")
public class CampaignDeviceState implements SdkModel {

    /**
     * Serialisation Id.
     */
    private static final long serialVersionUID = 4469467987598300648L;
    /**
     * The id of the metadata record.
     */
    private final String id;
    /**
     * The id of the device.
     */
    private final String deviceId;
    /**
     * The id of the campaign the device is in.
     */
    private final String campaignId;
    /**
     * The state of the update campaign on the device.
     */
    private final DeviceState state;
    /**
     * The name of the device.
     */
    private final String name;
    /**
     * Description of the device.
     */
    private final String description;
    /**
     * This time the record was created in the database.
     */
    private final Date createdAt;
    /**
     * This time this record was modified in the database format: date-time.
     */
    private final Date updatedAt;
    /**
     * The mechanism used to deliver the firmware (connector or direct).
     */
    private final String mechanism;
    /**
     * The url of cloud connect used.
     */
    private final URL mechanismUrl;

    /**
     * Constructor.
     *
     * @param id
     *            id
     * @param deviceId
     *            deviceId
     * @param campaignId
     *            campaignId
     * @param state
     *            state
     * @param name
     *            name
     * @param description
     *            description
     * @param createdAt
     *            createdAt
     * @param updatedAt
     *            updatedAt
     * @param mechanism
     *            mechanism
     * @param mechanismUrl
     *            mechanism URL
     */
    public CampaignDeviceState(String id, String deviceId, String campaignId, DeviceState state, String name,
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
     * Gets when the campaign was created.
     *
     * @return the createdAt
     */
    public Date getCreatedAt() {
        return createdAt;
    }

    /**
     * Gets when campaign was last updated.
     *
     * @return the updatedAt
     */
    public Date getUpdatedAt() {
        return updatedAt;
    }

    /**
     * Gets the Id.
     *
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * Gets the device Id.
     *
     * @return the deviceId
     */
    public String getDeviceId() {
        return deviceId;
    }

    /**
     * Gets the campaign Id.
     *
     * @return the campaignId
     */
    public String getCampaignId() {
        return campaignId;
    }

    /**
     * Gets the state.
     *
     * @return the state
     */
    public DeviceState getState() {
        return state;
    }

    /**
     * Gets the name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the description.
     *
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Gets the mechanism.
     *
     * @return the mechanism
     */
    public String getMechanism() {
        return mechanism;
    }

    /**
     * Gets the mechanism URL.
     *
     * @return the mechanismUrl
     */
    public URL getMechanismUrl() {
        return mechanismUrl;
    }

    /**
     * Gets a clone.
     *
     * @return a clone
     * @see java.lang.Object#clone()
     */
    @Override
    public CampaignDeviceState clone() throws CloneNotSupportedException {
        return new CampaignDeviceState(id, deviceId, campaignId, state, name, description, createdAt, updatedAt,
                mechanism, mechanismUrl);
    }

    /**
     * Determines whether all required fields have been set and therefore if the model instance is valid.
     *
     * @return true if instance is valid. False otherwise.
     */
    @Override
    public boolean isValid() {
        return true;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "CampaignDeviceState [id=" + id + ", deviceId=" + deviceId + ", campaignId=" + campaignId + ", state="
                + state + ", name=" + name + ", description=" + description + ", createdAt=" + createdAt
                + ", updatedAt=" + updatedAt + ", mechanism=" + mechanism + ", mechanismUrl=" + mechanismUrl + "]";
    }

}
