package com.arm.mbed.cloud.sdk.update.model;

import java.net.URL;
import java.util.Date;

import com.arm.mbed.cloud.sdk.annotations.DefaultValue;
import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.common.SDKModel;
import com.arm.mbed.cloud.sdk.common.listing.filtering.Filter;
import com.arm.mbed.cloud.sdk.common.listing.filtering.FilterOperator;
import com.arm.mbed.cloud.sdk.common.listing.filtering.Filters;
import com.arm.mbed.cloud.sdk.update.adapters.CampaignAdapter;

@Preamble(description = "Campaign")
public class Campaign implements SDKModel {

    /**
     * 
     */
    private static final long serialVersionUID = -5242091156121971819L;
    public static final String FILTER_BOOTSTRAPPED_TIMESTAMP = "bootstrappedTimestamp";
    public static final String FILTER_BOOTSTRAP_CERTIFICATE_EXPIRATION = "bootstrapCertificateExpiration";
    public static final String FILTER_ACCOUNT_ID = "accountId";
    public static final String FILTER_CERTIFICATE_ISSUER_ID = "certificateIssuerId";
    public static final String FILTER_CONNECTOR_CERTIFICATE_EXPIRATION = "connectorCertificateExpiration";
    public static final String FILTER_CREATED_AT = "createdAt";
    public static final String FILTER_DEPLOYED_STATE = "deployedState";
    public static final String FILTER_LAST_DEPLOYMENT = "lastDeployment";
    public static final String FILTER_DESCRIPTION = "description";
    public static final String FILTER_DEVICE_CLASS = "deviceClass";
    public static final String FILTER_CERTIFICATE_FINGERPRINT = "certificateFingerprint";
    public static final String FILTER_ALIAS = "alias";
    public static final String FILTER_FIRMWARE_CHECKSUM = "firmwareChecksum";
    public static final String FILTER_MANIFEST_URL = "manifestUrl";
    public static final String FILTER_MANIFEST_TIMESTAMP = "manifestTimestamp";
    public static final String FILTER_MECHANISM = "mechanism";
    public static final String FILTER_MECHANISM_URL = "mechanismUrl";
    public static final String FILTER_NAME = "name";
    public static final String FILTER_SERIAL_NUMBER = "serialNumber";
    public static final String FILTER_STATE = "state";
    public static final String FILTER_TRUST_LEVEL = "trustLevel";
    public static final String FILTER_UPDATED_AT = "updatedAt";
    public static final String FILTER_VENDOR_ID = "vendorId";
    /**
     * The ID of the campaign
     */
    private String id;
    /**
     * The state of the campaign
     */
    private CampaignState state;
    /**
     * URl of the manifest used
     */
    private final URL manifestUrl;
    /**
     * The time the object was created
     */
    @DefaultValue(value = "now()")
    private final Date createdAt;
    /**
     * The timestamp at which update campaign scheduled to start
     */
    @DefaultValue(value = "now()")
    private final Date startedAt;
    /**
     * The timestamp when the update campaign finished
     */
    @DefaultValue(value = "now()")
    private final Date finishedAt;
    /**
     * A name for this campaign
     */
    private String name;
    /**
     * An optional description of the campaign
     */
    private String description;
    /**
     * ID of the manifest to use for update
     */
    private String manifestId;

    /**
     * The timestamp at which update campaign scheduled to start
     */
    @DefaultValue(value = "now()")
    private Date scheduledAt;
    /**
     * filters
     */
    private Filters filters;

    public Campaign(String id, URL manifestUrl, Date createdAt, Date startedAt, Date finishedAt) {
        super();
        setId(id);
        this.manifestUrl = manifestUrl;
        this.createdAt = createdAt;
        this.startedAt = startedAt;
        this.finishedAt = finishedAt;
        setDescription(null);
        setManifestId(null);
        setName(null);
        setScheduledAt(new Date());
        setState(CampaignState.getDefault());
        setFilters(null);
    }

    public Campaign() {
        this(null);
    }

    public Campaign(String id) {
        this(id, null, new Date(), new Date(), new Date());
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id
     *            the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the state
     */
    public CampaignState getState() {
        return state;
    }

    /**
     * @param state
     *            the state to set
     */
    public void setState(CampaignState state) {
        this.state = state;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     *            the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description
     *            the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the manifestId
     */
    public String getManifestId() {
        return manifestId;
    }

    /**
     * @param manifestId
     *            the manifestId to set
     */
    public void setManifestId(String manifestId) {
        this.manifestId = manifestId;
    }

    /**
     * @return the scheduledAt
     */
    public Date getScheduledAt() {
        return scheduledAt;
    }

    /**
     * @param scheduledAt
     *            the scheduledAt to set
     */
    public void setScheduledAt(Date scheduledAt) {
        this.scheduledAt = scheduledAt;
    }

    /**
     * @return the manifestUrl
     */
    public URL getManifestUrl() {
        return manifestUrl;
    }

    /**
     * @return the createdAt
     */
    public Date getCreatedAt() {
        return createdAt;
    }

    /**
     * @return the startedAt
     */
    public Date getStartedAt() {
        return startedAt;
    }

    /**
     * @return the finishedAt
     */
    public Date getFinishedAt() {
        return finishedAt;
    }

    /**
     * @return the filters
     */
    public Filters getFilters() {
        return filters;
    }

    public String getFiltersAsString() {
        return CampaignAdapter.FILTERS_MARSHALLER.encode(filters);
    }

    /**
     * @param filters
     *            the filters to set
     */
    public void setFilters(Filters filters) {
        this.filters = filters;
    }

    /**
     * Adds a custom device filter
     * 
     * @param fieldName
     *            field name to apply the filter on
     * @param operator
     *            filter operator
     * @param value
     *            the value of the filter to apply
     */
    public void addDeviceFilter(String fieldName, FilterOperator operator, Object value) {
        Filter filter = new Filter(fieldName, operator, value);
        if (!filter.isValid()) {
            return;
        }
        if (filters == null) {
            filters = new Filters();
        }
        filters.add(filter);
    }

    /**
     * Adds a device filter
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
     * Adds a device filter
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
     * Adds a device filter
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
     * Adds a device filter
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
     * Adds a device filter
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
     * Adds a device filter
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
     * Adds a device filter
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
     * Adds a device filter
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
     * Adds a device filter
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
     * Adds a device filter
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
     * Adds a device filter
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
     * Adds a device filter
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
     * Adds a device filter
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
     * Adds a device filter
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
     * Adds a device filter
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
     * Adds a device filter
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
     * Adds a device filter
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
     * Adds a device filter
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
     * Adds a device filter
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
     * Adds a device filter
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
     * Adds a device filter
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
     * Adds a device filter
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
     * Adds a device filter
     * 
     * @param vendorIdFilter
     *            filter to apply
     * @param operator
     *            filter operator
     */
    public void addVendorIdFilter(String vendorIdFilter, FilterOperator operator) {
        addDeviceFilter(FILTER_VENDOR_ID, operator, vendorIdFilter);
    }

}
