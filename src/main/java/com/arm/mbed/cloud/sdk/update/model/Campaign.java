package com.arm.mbed.cloud.sdk.update.model;

import java.net.URL;
import java.util.Date;
import java.util.Map;

import com.arm.mbed.cloud.sdk.annotations.DefaultValue;
import com.arm.mbed.cloud.sdk.annotations.Internal;
import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.annotations.Required;
import com.arm.mbed.cloud.sdk.common.SdkModel;
import com.arm.mbed.cloud.sdk.common.listing.filtering.CustomFilter;
import com.arm.mbed.cloud.sdk.common.listing.filtering.Filter;
import com.arm.mbed.cloud.sdk.common.listing.filtering.FilterMarshaller;
import com.arm.mbed.cloud.sdk.common.listing.filtering.FilterOperator;
import com.arm.mbed.cloud.sdk.common.listing.filtering.Filters;
import com.arm.mbed.cloud.sdk.devicedirectory.model.Query;

@Preamble(description = "Campaign")
public class Campaign implements SdkModel {

    private static final String NOW = "now()";

    /**
     * Serialisation Id.
     */
    private static final long serialVersionUID = -5242091156121971819L;

    /**
     * Tag of filter by bootstrap timestamp.
     */
    public static final String FILTER_BOOTSTRAPPED_TIMESTAMP = "bootstrappedTimestamp";
    /**
     * Tag of filter by bootstrap certificate expiry date.
     */
    public static final String FILTER_BOOTSTRAP_CERTIFICATE_EXPIRATION = "bootstrapCertificateExpiration";
    /**
     * Tag of filter by account id.
     */
    public static final String FILTER_ACCOUNT_ID = "accountId";
    /**
     * Tag of filter by certificate issuer id.
     */
    public static final String FILTER_CERTIFICATE_ISSUER_ID = "certificateIssuerId";
    /**
     * Tag of filter by connector certificate expiry date.
     */
    public static final String FILTER_CONNECTOR_CERTIFICATE_EXPIRATION = "connectorCertificateExpiration";
    /**
     * Tag of filter by creation date.
     */
    public static final String FILTER_CREATED_AT = "createdAt";
    /**
     * Tag of filter by deployment state.
     */
    public static final String FILTER_DEPLOYED_STATE = "deployedState";
    /**
     * Tag of filter by last deployment.
     */
    public static final String FILTER_LAST_DEPLOYMENT = "lastDeployment";
    /**
     * Tag of filter by description.
     */
    public static final String FILTER_DESCRIPTION = "description";
    /**
     * Tag of filter by device class.
     */
    public static final String FILTER_DEVICE_CLASS = "deviceClass";
    /**
     * Tag of filter by certificate fingerprint.
     */
    public static final String FILTER_CERTIFICATE_FINGERPRINT = "certificateFingerprint";
    /**
     * Tag of filter by alias.
     */
    public static final String FILTER_ALIAS = "alias";
    /**
     * Tag of filter by firmware checksum.
     */
    public static final String FILTER_FIRMWARE_CHECKSUM = "firmwareChecksum";
    /**
     * Tag of filter by manifest URL.
     */
    public static final String FILTER_MANIFEST_URL = "manifestUrl";
    /**
     * Tag of filter by manifest timestamp.
     */
    public static final String FILTER_MANIFEST_TIMESTAMP = "manifestTimestamp";
    /**
     * Tag of filter by mechanism.
     */
    public static final String FILTER_MECHANISM = "mechanism";
    /**
     * Tag of filter by mechanism URL.
     */
    public static final String FILTER_MECHANISM_URL = "mechanismUrl";
    /**
     * Tag of filter by name.
     */
    public static final String FILTER_NAME = "name";
    /**
     * Tag of filter by serial number.
     */
    public static final String FILTER_SERIAL_NUMBER = "serialNumber";
    /**
     * Tag of filter by state.
     */
    public static final String FILTER_STATE = "state";
    /**
     * Tag of filter by trust level.
     */
    public static final String FILTER_TRUST_LEVEL = "trustLevel";
    /**
     * Tag of filter by last update date.
     */
    public static final String FILTER_UPDATED_AT = "updatedAt";
    /**
     * Tag of filter by vendor Id.
     */
    public static final String FILTER_VENDOR_ID = "vendorId";
    /**
     * Tag of filter by device type.
     */
    public static final String FILTER_DEVICE_TYPE = "deviceType";
    /**
     * Tag of filter by host gateway.
     */
    public static final String FILTER_HOST_GATEWAY = "hostGateway";
    /**
     * The ID of the campaign.
     */
    private String id;
    /**
     * The state of the campaign.
     */
    private CampaignState state;
    /**
     * URl of the manifest used.
     */
    private final URL manifestUrl;
    /**
     * The time the object was created.
     */
    @DefaultValue(value = NOW)
    private final Date createdAt;
    /**
     * The time the object was updated.
     */
    @DefaultValue(value = NOW)
    private final Date updatedAt;
    /**
     * The timestamp at which update campaign scheduled to start.
     */
    @DefaultValue(value = NOW)
    private final Date startedAt;
    /**
     * The timestamp when the update campaign finished.
     */
    @DefaultValue(value = NOW)
    private final Date finishedAt;
    /**
     * A name for this campaign.
     */
    @Required
    private String name;
    /**
     * An optional description of the campaign.
     */
    private String description;
    /**
     * ID of the manifest to use for update.
     */
    @Required
    private String manifestId;

    /**
     * The timestamp at which update campaign scheduled to start.
     */
    @DefaultValue(value = "null")
    private Date scheduledAt;
    /**
     * filters.
     */
    @Required
    private Filters deviceFilter;

    /**
     * Internal constructor.
     * <p>
     * Note: Should not be used. Use {@link #Campaign()} or {@link #Campaign(String, String, Filters)} instead.
     *
     * @param id
     *            id
     * @param manifestUrl
     *            manifest URL
     * @param createdAt
     *            date when campaign was created.
     * @param startedAt
     *            date when campaign was started.
     * @param finishedAt
     *            date when campaign finishes.
     * @param updatedAt
     *            date when campaign was updated.
     */
    @Internal
    public Campaign(String id, URL manifestUrl, Date createdAt, Date startedAt, Date finishedAt, Date updatedAt) {
        this(id, CampaignState.getDefault(), manifestUrl, createdAt, startedAt, finishedAt, updatedAt, null, null, null,
                null, null);

    }

    /**
     * Internal constructor.
     * <p>
     * Note: Should not be used. Use {@link #Campaign()} or {@link #Campaign(String, String, Filters)} instead.
     *
     * @param id
     *            id
     * @param state
     *            state
     * @param manifestUrl
     *            manifest URL
     * @param createdAt
     *            date when campaign was created.
     * @param startedAt
     *            date when campaign was started.
     * @param finishedAt
     *            date when campaign finishes.
     * @param updatedAt
     *            date when campaign was updated.
     * @param name
     *            name
     * @param description
     *            description
     * @param manifestId
     *            manifest id
     * @param scheduledAt
     *            date when campaign is scheduled at.
     * @param deviceFilter
     *            device filter
     */
    @Internal
    public Campaign(String id, CampaignState state, URL manifestUrl, Date createdAt, Date startedAt, Date finishedAt,
            Date updatedAt, String name, String description, String manifestId, Date scheduledAt,
            Filters deviceFilter) {
        super();
        setId(id);
        this.manifestUrl = manifestUrl;
        this.createdAt = createdAt;
        this.startedAt = startedAt;
        this.finishedAt = finishedAt;
        this.updatedAt = updatedAt;
        setDescription(description);
        setManifestId(manifestId);
        setName(name);
        setScheduledAt(scheduledAt);
        setState(state);
        setDeviceFilter(deviceFilter);
    }

    /**
     * Constructor.
     * <p>
     * Note: Should not be used. Use {@link #Campaign()} or {@link #Campaign(String, String, Filters)} instead.
     *
     * @param id
     *            campaign id
     */
    @Internal
    public Campaign(String id) {
        this(id, null, new Date(), new Date(), new Date(), new Date());
    }

    /**
     * Constructor.
     */
    public Campaign() {
        this(null);
    }

    /**
     * Constructor.
     *
     * @param name
     *            Name of the update campaign
     * @param manifestId
     *            ID of the manifest with description of the update
     * @param deviceFilter
     *            The device filter to use
     */
    public Campaign(String name, String manifestId, Filters deviceFilter) {
        this();
        setName(name);
        setManifestId(manifestId);
        setDeviceFilter(deviceFilter);
    }

    /**
     * Constructor.
     *
     * @param name
     *            Name of the update campaign
     * @param manifest
     *            the manifest with description of the update
     * @param deviceFilter
     *            The device filter to use
     */
    public Campaign(String name, FirmwareManifest manifest, Filters deviceFilter) {
        this(name, (manifest == null) ? null : manifest.getId(), deviceFilter);
    }

    /**
     * Constructor.
     *
     * @param name
     *            Name of the update campaign
     * @param manifest
     *            the manifest with description of the update
     * @param query
     *            The query to use
     */
    public Campaign(String name, FirmwareManifest manifest, Query query) {
        this(name, manifest, (query == null) ? null : query.fetchFilter());
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
     * Sets the Id.
     *
     * @param id
     *            the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Gets the campaign state.
     *
     * @see CampaignState
     * @return the state
     */
    public CampaignState getState() {
        return state;
    }

    /**
     * Sets the campaign state.
     *
     * @see CampaignState
     * @param state
     *            the state to set
     */
    public void setState(CampaignState state) {
        this.state = state;
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
     * Sets the name.
     *
     * @param name
     *            the name to set
     */
    @Required
    public void setName(String name) {
        this.name = name;
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
     * Sets the description.
     *
     * @param description
     *            the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Gets the manifest Id.
     *
     * @return the manifestId
     */
    public String getManifestId() {
        return manifestId;
    }

    /**
     * Sets the manifest id.
     *
     * @param manifestId
     *            the manifestId to set
     */
    @Required
    public void setManifestId(String manifestId) {
        this.manifestId = manifestId;
    }

    /**
     * Gets when the campaign is scheduled at.
     *
     * @return the scheduledAt
     */
    public Date getScheduledAt() {
        return scheduledAt;
    }

    /**
     * Sets when the campaign should be scheduled for.
     *
     * @param scheduledAt
     *            the scheduledAt to set
     */
    public void setScheduledAt(Date scheduledAt) {
        this.scheduledAt = scheduledAt;
    }

    /**
     * Gets manifest URL.
     *
     * @return the manifestUrl
     */
    public URL getManifestUrl() {
        return manifestUrl;
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
     * Gets when the campaign was started.
     *
     * @return the startedAt
     */
    public Date getStartedAt() {
        return startedAt;
    }

    /**
     * Gets when the campaign finishes.
     *
     * @return the finishedAt
     */
    public Date getFinishedAt() {
        return finishedAt;
    }

    /**
     * Gets the filter.
     *
     * @return the filters
     */
    public Filters getFilter() {
        return deviceFilter;
    }

    /**
     * Gets the filter as a "Json object".
     *
     * @return the filters as a Json object
     */
    @Internal
    public Map<String, Object> getDeviceFilter() {
        return FilterMarshaller.toJsonObject(getFilter());
    }

    /**
     * Set the device filter.
     *
     * @param deviceFilter
     *            the device filter to set
     */
    @Required
    public void setDeviceFilter(Filters deviceFilter) {
        this.deviceFilter = deviceFilter;
    }

    /**
     * Sets the device filter from a Json string.
     * 
     * @see FilterMarshaller#fromJson(String)
     * 
     * @param jsonString
     *            Json string defining the device filter to set
     */
    public void setDeviceFilterFromJson(String jsonString) {
        setDeviceFilter(FilterMarshaller.fromJson(jsonString));
    }

    /**
     * Gets the device filter as Json String.
     * 
     * @see FilterMarshaller#toJson(Filters)
     * 
     * @return the filters as a Json string
     */
    public String retrieveDeviceFilterAsJson() {
        return FilterMarshaller.toJson(getFilter());
    }

    /**
     * Adds a custom device filter.
     *
     * @param fieldName
     *            field name to apply the filter on
     * @param operator
     *            filter operator
     * @param value
     *            the value of the filter to apply
     */
    public void addCustomDeviceFilter(String fieldName, FilterOperator operator, Object value) {
        addDeviceFilter(new CustomFilter(fieldName, operator, value));
    }

    /**
     * Adds a device filter based on account Id field.
     *
     * @param accountIdFilter
     *            filter to apply
     * @param operator
     *            filter operator
     */
    public void addAccountIdFilter(String accountIdFilter, FilterOperator operator) {
        addDeviceFilter(FILTER_ACCOUNT_ID, operator, accountIdFilter);
    }

    /**
     * Adds a device filter based on bootstrap certificate expiry date field.
     *
     * @param bootstrapCertificateExpirationFilter
     *            filter to apply
     * @param operator
     *            filter operator
     */
    public void addBootstrapCertificateExpirationFilter(Date bootstrapCertificateExpirationFilter,
            FilterOperator operator) {
        addDeviceFilter(FILTER_BOOTSTRAP_CERTIFICATE_EXPIRATION, operator, bootstrapCertificateExpirationFilter);
    }

    /**
     * Adds a device filter based on timestamp field.
     *
     * @param bootstrappedTimestampFilter
     *            filter to apply
     * @param operator
     *            filter operator
     */
    public void addBootstrappedTimestampFilter(Date bootstrappedTimestampFilter, FilterOperator operator) {
        addDeviceFilter(FILTER_BOOTSTRAPPED_TIMESTAMP, operator, bootstrappedTimestampFilter);
    }

    /**
     * Adds a device filter based on certificate issuer field.
     *
     * @param certificateIssuerIdFilter
     *            filter to apply
     * @param operator
     *            filter operator
     */
    public void addCertificateIssuerIdFilter(String certificateIssuerIdFilter, FilterOperator operator) {
        addDeviceFilter(FILTER_CERTIFICATE_ISSUER_ID, operator, certificateIssuerIdFilter);
    }

    /**
     * Adds a device filter based on connector certificate expiry date field.
     *
     * @param connectorCertificateExpirationFilter
     *            filter to apply
     * @param operator
     *            filter operator
     */
    public void addConnectorCertificateExpirationFilter(Date connectorCertificateExpirationFilter,
            FilterOperator operator) {
        addDeviceFilter(FILTER_CONNECTOR_CERTIFICATE_EXPIRATION, operator, connectorCertificateExpirationFilter);
    }

    /**
     * Adds a device filter based on creation date field.
     *
     * @param createdAtFilter
     *            filter to apply
     * @param operator
     *            filter operator
     */
    public void addCreatedAtFilter(Date createdAtFilter, FilterOperator operator) {
        addDeviceFilter(FILTER_CREATED_AT, operator, createdAtFilter);
    }

    /**
     * Adds a device filter based on deployment state field.
     *
     * @param deployedStateFilter
     *            filter to apply
     * @param operator
     *            filter operator
     */
    public void addDeployedStateFilter(DeviceState deployedStateFilter, FilterOperator operator) {
        addDeviceFilter(FILTER_DEPLOYED_STATE, operator, deployedStateFilter);
    }

    /**
     * Adds a device filter based on last deployment date field.
     *
     * @param lastDeploymentFilter
     *            filter to apply
     * @param operator
     *            filter operator
     */
    public void addLastDeploymentFilter(Date lastDeploymentFilter, FilterOperator operator) {
        addDeviceFilter(FILTER_LAST_DEPLOYMENT, operator, lastDeploymentFilter);
    }

    /**
     * Adds a device filter based on description field.
     *
     * @param descriptionFilter
     *            filter to apply
     * @param operator
     *            filter operator
     */
    public void addDescriptionFilter(String descriptionFilter, FilterOperator operator) {
        addDeviceFilter(FILTER_DESCRIPTION, operator, descriptionFilter);
    }

    /**
     * Adds a device filter based on device class field.
     *
     * @param deviceClassFilter
     *            filter to apply
     * @param operator
     *            filter operator
     */
    public void addDeviceClassFilter(String deviceClassFilter, FilterOperator operator) {
        addDeviceFilter(FILTER_DEVICE_CLASS, operator, deviceClassFilter);
    }

    /**
     * Adds a device filter based on certificate fingerprint field.
     *
     * @param certificateFingerprintFilter
     *            filter to apply
     * @param operator
     *            filter operator
     */
    public void addCertificateFingerprintFilter(String certificateFingerprintFilter, FilterOperator operator) {
        addDeviceFilter(FILTER_CERTIFICATE_FINGERPRINT, operator, certificateFingerprintFilter);
    }

    /**
     * Adds a device filter based on alias field.
     *
     * @param aliasFilter
     *            filter to apply
     * @param operator
     *            filter operator
     */
    public void addAliasFilter(String aliasFilter, FilterOperator operator) {
        addDeviceFilter(FILTER_ALIAS, operator, aliasFilter);
    }

    /**
     * Adds a device filter based on firmware checksum field.
     *
     * @param firmwareChecksumFilter
     *            filter to apply
     * @param operator
     *            filter operator
     */
    public void addFirmwareChecksumFilter(String firmwareChecksumFilter, FilterOperator operator) {
        addDeviceFilter(FILTER_FIRMWARE_CHECKSUM, operator, firmwareChecksumFilter);
    }

    /**
     * Adds a device filter based on manifest URL field.
     *
     * @param manifestUrlFilter
     *            filter to apply
     * @param operator
     *            filter operator
     */
    public void addManifestUrlFilter(URL manifestUrlFilter, FilterOperator operator) {
        addDeviceFilter(FILTER_MANIFEST_URL, operator, manifestUrlFilter);
    }

    /**
     * Adds a device filter based on manifest timestamp field.
     *
     * @param manifestTimestampFilter
     *            filter to apply
     * @param operator
     *            filter operator
     */
    public void addManifestTimestampFilter(Date manifestTimestampFilter, FilterOperator operator) {
        addDeviceFilter(FILTER_MANIFEST_TIMESTAMP, operator, manifestTimestampFilter);
    }

    /**
     * Adds a device filter based on mechanism field.
     *
     * @param mechanismFilter
     *            filter to apply
     * @param operator
     *            filter operator
     */
    public void addMechanismFilter(String mechanismFilter, FilterOperator operator) {
        addDeviceFilter(FILTER_MECHANISM, operator, mechanismFilter);
    }

    /**
     * Adds a device filter based on mechanism URL field.
     *
     * @param mechanismUrlFilter
     *            filter to apply
     * @param operator
     *            filter operator
     */
    public void addMechanismUrlFilter(URL mechanismUrlFilter, FilterOperator operator) {
        addDeviceFilter(FILTER_MECHANISM_URL, operator, mechanismUrlFilter);
    }

    /**
     * Adds a device filter based on name field.
     *
     * @param nameFilter
     *            filter to apply
     * @param operator
     *            filter operator
     */
    public void addNameFilter(String nameFilter, FilterOperator operator) {
        addDeviceFilter(FILTER_NAME, operator, nameFilter);
    }

    /**
     * Adds a device filter based on serial number field.
     *
     * @param serialNumberFilter
     *            filter to apply
     * @param operator
     *            filter operator
     */
    public void addSerialNumberFilter(String serialNumberFilter, FilterOperator operator) {
        addDeviceFilter(FILTER_SERIAL_NUMBER, operator, serialNumberFilter);
    }

    /**
     * Adds a device filter based on state field.
     *
     * @param stateFilter
     *            filter to apply
     * @param operator
     *            filter operator
     */
    public void addStateFilter(String stateFilter, FilterOperator operator) {
        addDeviceFilter(FILTER_STATE, operator, stateFilter);
    }

    /**
     * Adds a device filter based on trust level field.
     *
     * @param trustLevelFilter
     *            filter to apply
     * @param operator
     *            filter operator
     */
    public void addTrustLevelFilter(String trustLevelFilter, FilterOperator operator) {
        addDeviceFilter(FILTER_TRUST_LEVEL, operator, trustLevelFilter);
    }

    /**
     * Adds a device filter based on last update date field.
     *
     * @param updatedAtFilter
     *            filter to apply
     * @param operator
     *            filter operator
     */
    public void addUpdatedAtFilter(Date updatedAtFilter, FilterOperator operator) {
        addDeviceFilter(FILTER_UPDATED_AT, operator, updatedAtFilter);
    }

    /**
     * Adds a device filter based on vendor Id field.
     *
     * @param vendorIdFilter
     *            filter to apply
     * @param operator
     *            filter operator
     */
    public void addVendorIdFilter(String vendorIdFilter, FilterOperator operator) {
        addDeviceFilter(FILTER_VENDOR_ID, operator, vendorIdFilter);
    }

    /**
     * Adds a device filter based on device type field.
     *
     * @param deviceType
     *            filter to apply
     * @param operator
     *            filter operator
     */
    public void addDeviceTypeFilter(String deviceType, FilterOperator operator) {
        addDeviceFilter(FILTER_DEVICE_TYPE, operator, deviceType);
    }

    /**
     * Adds a device filter based on host gateway type field.
     *
     * @param hostGateway
     *            filter to apply
     * @param operator
     *            filter operator
     */
    public void addGatewayFilter(String hostGateway, FilterOperator operator) {
        addDeviceFilter(FILTER_HOST_GATEWAY, operator, hostGateway);
    }

    private void addDeviceFilter(String fieldName, FilterOperator operator, Object value) {
        addDeviceFilter(new Filter(fieldName, operator, value));
    }

    private void addDeviceFilter(Filter filter) {
        if (filter == null || !filter.isValid()) {
            return;
        }
        if (deviceFilter == null) {
            deviceFilter = new Filters();
        }
        deviceFilter.add(filter);
    }

    /**
     * Gets a clone.
     *
     * @return a clone.
     *
     * @see java.lang.Object#clone()
     */
    @Override
    public Campaign clone() throws CloneNotSupportedException {
        return new Campaign(id, state, manifestUrl, createdAt, startedAt, finishedAt, updatedAt, name, description,
                manifestId, scheduledAt, deviceFilter);
    }

    /**
     * Determines whether all required fields have been set and therefore if the model instance is valid.
     *
     * @return true if instance is valid. False otherwise.
     */
    @Override
    public boolean isValid() {
        return name != null && manifestId != null && deviceFilter != null;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "Campaign [id=" + id + ", state=" + state + ", manifestUrl=" + manifestUrl + ", createdAt=" + createdAt
                + ", updatedAt=" + updatedAt + ", startedAt=" + startedAt + ", finishedAt=" + finishedAt + ", name="
                + name + ", description=" + description + ", manifestId=" + manifestId + ", scheduledAt=" + scheduledAt
                + ", deviceFilter=" + deviceFilter + "]";
    }

}
