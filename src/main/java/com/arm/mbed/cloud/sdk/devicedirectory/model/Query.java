package com.arm.mbed.cloud.sdk.devicedirectory.model;

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

@Preamble(description = "Query model")
public class Query implements SdkModel {
    /**
     * Tag of filter by vendor id.
     */
    public static final String FILTER_VENDOR_ID = "vendorId";
    /**
     * Tag of filter by updatedAt.
     */
    public static final String FILTER_UPDATED_AT = "updatedAt";

    /**
     * Tag of filter by state.
     */
    public static final String FILTER_STATE = "state";
    /**
     * Tag of filter by serial number.
     */
    public static final String FILTER_SERIAL_NUMBER = "serialNumber";
    /**
     * Tag of filter by name.
     */
    public static final String FILTER_NAME = "name";
    /**
     * Tag of filter by mechanism URL.
     */
    public static final String FILTER_MECHANISM_URL = "mechanismUrl";
    /**
     * Tag of filter by mechanism.
     */
    public static final String FILTER_MECHANISM = "mechanism";
    /**
     * Tag of filter by manifest timestamp.
     */
    public static final String FILTER_MANIFEST_TIMESTAMP = "manifestTimestamp";
    /**
     * Tag of filter by firmware checksum.
     */
    public static final String FILTER_FIRMWARE_CHECKSUM = "firmwareChecksum";
    /**
     * Tag of filter by alias.
     */
    public static final String FILTER_ALIAS = "alias";
    /**
     * Tag of filter by certificate fingerprint.
     */
    public static final String FILTER_CERTIFICATE_FINGERPRINT = "certificateFingerprint";
    /**
     * Tag of filter by device class.
     */
    public static final String FILTER_DEVICE_CLASS = "deviceClass";
    /**
     * Tag of filter by description.
     */
    public static final String FILTER_DESCRIPTION = "description";
    /**
     * Tag of filter by creation date.
     */
    public static final String FILTER_CREATED_AT = "createdAt";
    /**
     * Tag of filter by connector certificate expiry date.
     */
    public static final String FILTER_CONNECTOR_CERTIFICATE_EXPIRATION = "connectorCertificateExpiration";
    /**
     * Tag of filter by certificate issuer id.
     */
    public static final String FILTER_CERTIFICATE_ISSUER_ID = "certificateIssuerId";
    /**
     * Tag of filter by bootstrap timestamp.
     */
    public static final String FILTER_BOOTSTRAPPED_TIMESTAMP = "bootstrappedTimestamp";
    /**
     * Tag of filter by account id.
     */
    public static final String FILTER_ACCOUNT_ID = "accountId";
    /**
     * Tag of filter by bootstrap certificate expiry date.
     */
    public static final String FILTER_BOOTSTRAP_CERTIFICATE_EXPIRATION = "bootstrapCertificateExpiration";
    /**
     * Tag of filter by device type.
     */
    public static final String FILTER_DEVICE_TYPE = "deviceType";
    /**
     * Tag of filter by host gateway.
     */
    public static final String FILTER_HOST_GATEWAY = "hostGateway";
    /**
     * Serialisation id.
     */
    private static final long serialVersionUID = -262399232521895478L;
    /**
     * The ID of the query.
     */
    private String id;
    /**
     * The time the query was created.
     */
    @DefaultValue(value = "now()")
    private final Date createdAt;
    /**
     * The time the query was updated.
     */
    @DefaultValue(value = "now()")
    private final Date updatedAt;
    /**
     * The name of the query.
     */
    @Required
    private String name;
    /**
     * The device filter.
     */
    @Required
    private Filters filter;

    /**
     * Internal constructor.
     * <p>
     * Note: Should not be used. Use {@link #Query()} or {@link #Query(String, Filters)} instead.
     *
     * @param id
     *            id
     * @param createdAt
     *            creation date
     * @param updatedAt
     *            last update date
     */
    @Internal
    public Query(String id, Date createdAt, Date updatedAt) {
        this(id, createdAt, updatedAt, null, null);
    }

    /**
     * Internal constructor.
     * <p>
     * Note: Should not be used. Use {@link #Query()} or {@link #Query(String, Filters)} instead.
     *
     * @param id
     *            id
     * @param createdAt
     *            creation date
     * @param updatedAt
     *            last update date
     * @param name
     *            name
     * @param filter
     *            filter
     */
    @Internal
    public Query(String id, Date createdAt, Date updatedAt, String name, Filters filter) {
        super();
        setId(id);
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        setName(name);
        setFilter(filter);
    }

    /**
     * Constructor.
     */
    public Query() {
        this(null, new Date(), new Date());
    }

    /**
     * Constructor.
     *
     * @param name
     *            Name of query
     * @param filter
     *            Filter properties to apply
     */
    public Query(String name, Filters filter) {
        this();
        setName(name);
        setFilter(filter);
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id
     *            the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Sets id.
     * <p>
     * similar to {@link #setId(String)}
     *
     * @param id
     *            the id to set
     */
    @Internal
    public void setQueryId(String id) {
        setId(id);
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name.
     *
     * @param name
     *            the name to set
     */
    @Required
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Sets filter.
     *
     * @param filter
     *            the filter to set
     */
    @Required
    public void setFilter(Filters filter) {
        this.filter = filter;
    }

    /**
     * Gets filter.
     *
     * @return the filters
     */
    public Filters fetchFilter() {
        return filter;
    }

    /**
     * Gets filter as "Json object".
     * <p>
     * Note: avoid using.
     *
     * @return the filters as a "Json object"
     */
    @Internal
    public Map<String, Object> getFilter() {
        return FilterMarshaller.toJsonObject(fetchFilter());
    }

    /**
     * Gets the filter as Json String.
     *
     * @return the filters as a Json string
     */
    public String retrieveFilterAsJson() {
        return FilterMarshaller.toJson(fetchFilter());
    }

    /**
     * Sets filter as a Json string.
     *
     * @param jsonString
     *            Json string defining filter
     */
    public void setFilterFromJson(String jsonString) {
        setFilter(FilterMarshaller.fromJson(jsonString));
    }

    /**
     * Gets creation date.
     *
     * @return the createdAt
     */
    public Date getCreatedAt() {
        return createdAt;
    }

    /**
     * Gets last update date.
     *
     * @return the updatedAt
     */
    public Date getUpdatedAt() {
        return updatedAt;
    }

    /**
     * Adds a custom filter.
     *
     * @param fieldName
     *            field name to apply the filter on
     * @param operator
     *            filter operator
     * @param value
     *            the value of the filter to apply
     */
    public void addCustomFilter(String fieldName, FilterOperator operator, Object value) {
        addFilter(new CustomFilter(fieldName, operator, value));
    }

    /**
     * Adds a device filter based on account id field.
     *
     * @param accountId
     *            filter to apply
     * @param operator
     *            filter operator
     */
    public void addAccountIdFilter(String accountId, FilterOperator operator) {
        addFilter(FILTER_ACCOUNT_ID, operator, accountId);
    }

    /**
     * Adds a device filter based on bootstrap certificate expiry date field.
     *
     * @param bootstrapCertificateExpiration
     *            filter to apply
     * @param operator
     *            filter operator
     */
    public void addBootstrapCertificateExpirationFilter(Date bootstrapCertificateExpiration, FilterOperator operator) {
        addFilter(FILTER_BOOTSTRAP_CERTIFICATE_EXPIRATION, operator, bootstrapCertificateExpiration);
    }

    /**
     * Adds a device filter based on bootstrapped timestamp field.
     *
     * @param bootstrappedTimestamp
     *            filter to apply
     * @param operator
     *            filter operator
     */
    public void addBootstrappedTimestampFilter(Date bootstrappedTimestamp, FilterOperator operator) {
        addFilter(FILTER_BOOTSTRAPPED_TIMESTAMP, operator, bootstrappedTimestamp);
    }

    /**
     * Adds a device filter based on certificate issuer id field.
     *
     * @param certificateIssuerId
     *            filter to apply
     * @param operator
     *            filter operator
     */
    public void addCertificateIssuerIdFilter(String certificateIssuerId, FilterOperator operator) {
        addFilter(FILTER_CERTIFICATE_ISSUER_ID, operator, certificateIssuerId);
    }

    /**
     * Adds a device filter based on connector certificate expiry date field.
     *
     * @param connectorCertificateExpiration
     *            filter to apply
     * @param operator
     *            filter operator
     */
    public void addConnectorCertificateExpirationFilter(Date connectorCertificateExpiration, FilterOperator operator) {
        addFilter(FILTER_CONNECTOR_CERTIFICATE_EXPIRATION, operator, connectorCertificateExpiration);
    }

    /**
     * Adds a device filter based on createdAt field.
     *
     * @param createdAtDate
     *            filter to apply
     * @param operator
     *            filter operator
     */
    public void addCreatedAtFilter(Date createdAtDate, FilterOperator operator) {
        addFilter(FILTER_CREATED_AT, operator, createdAtDate);
    }

    /**
     * Adds a device filter based on description field.
     *
     * @param description
     *            filter to apply
     * @param operator
     *            filter operator
     */
    public void addDescriptionFilter(String description, FilterOperator operator) {
        addFilter(FILTER_DESCRIPTION, operator, description);
    }

    /**
     * Adds a device filter based on device class field.
     *
     * @param deviceClass
     *            filter to apply
     * @param operator
     *            filter operator
     */
    public void addDeviceClassFilter(String deviceClass, FilterOperator operator) {
        addFilter(FILTER_DEVICE_CLASS, operator, deviceClass);
    }

    /**
     * Adds a device filter based on certificate fingerprint field.
     *
     * @param certificateFingerprint
     *            filter to apply
     * @param operator
     *            filter operator
     */
    public void addCertificateFingerprintFilter(String certificateFingerprint, FilterOperator operator) {
        addFilter(FILTER_CERTIFICATE_FINGERPRINT, operator, certificateFingerprint);
    }

    /**
     * Adds a device filter based on alias field.
     *
     * @param alias
     *            filter to apply
     * @param operator
     *            filter operator
     */
    public void addAliasFilter(String alias, FilterOperator operator) {
        addFilter(FILTER_ALIAS, operator, alias);
    }

    /**
     * Adds a device filter based on firmware checksum field.
     *
     * @param firmwareChecksum
     *            filter to apply
     * @param operator
     *            filter operator
     */
    public void addFirmwareChecksumFilter(String firmwareChecksum, FilterOperator operator) {
        addFilter(FILTER_FIRMWARE_CHECKSUM, operator, firmwareChecksum);
    }

    /**
     * Adds a device filter based on manifest timestamp field.
     *
     * @param manifestTimestamp
     *            filter to apply
     * @param operator
     *            filter operator
     */
    public void addManifestTimestampFilter(Date manifestTimestamp, FilterOperator operator) {
        addFilter(FILTER_MANIFEST_TIMESTAMP, operator, manifestTimestamp);
    }

    /**
     * Adds a device filter based on mechanism field.
     *
     * @param mechanism
     *            filter to apply
     * @param operator
     *            filter operator
     */
    public void addMechanismFilter(MechanismType mechanism, FilterOperator operator) {
        addFilter(FILTER_MECHANISM, operator, mechanism);
    }

    /**
     * Adds a device filter based on mechanism URl field.
     *
     * @param mechanismUrl
     *            filter to apply
     * @param operator
     *            filter operator
     */
    public void addMechanismUrlFilter(URL mechanismUrl, FilterOperator operator) {
        addFilter(FILTER_MECHANISM_URL, operator, mechanismUrl);
    }

    /**
     * Adds a device filter based on name field.
     *
     * @param queryName
     *            filter to apply
     * @param operator
     *            filter operator
     */
    public void addNameFilter(String queryName, FilterOperator operator) {
        addFilter(FILTER_NAME, operator, queryName);
    }

    /**
     * Adds a device filter based on serial number field.
     *
     * @param serialNumber
     *            filter to apply
     * @param operator
     *            filter operator
     */
    public void addSerialNumberFilter(String serialNumber, FilterOperator operator) {
        addFilter(FILTER_SERIAL_NUMBER, operator, serialNumber);
    }

    /**
     * Adds a device filter based on state field.
     *
     * @param state
     *            filter to apply
     * @param operator
     *            filter operator
     */
    public void addStateFilter(DeviceState state, FilterOperator operator) {
        addFilter(FILTER_STATE, operator, state);
    }

    /**
<<<<<<< HEAD
=======
     * Adds a device filter based on trust level field.
     *
     * @param trustLevel
     *            filter to apply
     * @param operator
     *            filter operator
     */
    public void addTrustLevelFilter(String trustLevel, FilterOperator operator) {
        addFilter(FILTER_TRUST_LEVEL, operator, trustLevel);
    }

    /**
>>>>>>> Suggested edits
     * Adds a device filter based on updatedAt field.
     *
     * @param updatedAtDate
     *            filter to apply
     * @param operator
     *            filter operator
     */
    public void addUpdatedAtFilter(Date updatedAtDate, FilterOperator operator) {
        addFilter(FILTER_UPDATED_AT, operator, updatedAtDate);
    }

    /**
     * Adds a device filter based on vendorId field.
     *
     * @param vendorId
     *            filter to apply
     * @param operator
     *            filter operator
     */
    public void addVendorIdFilter(String vendorId, FilterOperator operator) {
        addFilter(FILTER_VENDOR_ID, operator, vendorId);
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
        addFilter(FILTER_DEVICE_TYPE, operator, deviceType);
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
        addFilter(FILTER_HOST_GATEWAY, operator, hostGateway);
    }

    private void addFilter(String fieldName, FilterOperator operator, Object value) {
        addFilter(new Filter(fieldName, operator, value));
    }

    private void addFilter(Filter afilter) {
        if (afilter == null || !afilter.isValid()) {
            return;
        }
        if (filter == null) {
            filter = new Filters();
        }
        filter.add(afilter);
    }

    /**
     * Gets a clone.
     *
     * @return a clone
     *
     * @see java.lang.Object#clone()
     */
    @Override
    public Query clone() throws CloneNotSupportedException {
        return new Query(id, createdAt, updatedAt, name, filter);
    }

    /**
     * Determines whether all required fields have been set and therefore if the model instance is valid.
     *
     * @return true if instance is valid. False otherwise.
     */
    @Override
    public boolean isValid() {
        return name != null && filter != null;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "Query [id=" + id + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + ", name=" + name
                + ", filter=" + retrieveFilterAsJson() + "]";
    }

}
