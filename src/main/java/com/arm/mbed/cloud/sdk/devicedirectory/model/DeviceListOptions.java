package com.arm.mbed.cloud.sdk.devicedirectory.model;

import java.net.URL;
import java.util.Date;

import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.common.listing.ListOptions;
import com.arm.mbed.cloud.sdk.common.listing.filtering.FilterOperator;

@Preamble(description = "Options to use when listing devices")
public class DeviceListOptions extends ListOptions {
    public static final String FILTER_VENDOR_ID = "vendorId";
    public static final String FILTER_TRUST_LEVEL = "trustLevel";
    public static final String FILTER_STATE = "state";
    public static final String FILTER_SERIAL_NUMBER = "serialNumber";
    public static final String FILTER_MECHANISM_URL = "mechanismUrl";
    public static final String FILTER_MECHANISM = "mechanism";
    public static final String FILTER_MANIFEST_TIMESTAMP = "manifestTimestamp";
    public static final String FILTER_FIRMWARE_CHECKSUM = "firmwareChecksum";
    public static final String FILTER_ALIAS = "alias";
    public static final String FILTER_CERTIFICATE_FINGERPRINT = "certificateFingerprint";
    public static final String FILTER_DEVICE_CLASS = "deviceClass";
    public static final String FILTER_DESCRIPTION = "description";
    public static final String FILTER_CONNECTOR_CERTIFICATE_EXPIRATION = "connectorCertificateExpiration";
    public static final String FILTER_CERTIFICATE_ISSUER_ID = "certificateIssuerId";
    public static final String FILTER_BOOTSTRAPPED_TIMESTAMP = "bootstrappedTimestamp";
    public static final String FILTER_ACCOUNT_ID = "accountId";
    public static final String FILTER_BOOTSTRAP_CERTIFICATE_EXPIRATION = "bootstrapCertificateExpiration";
    public static final String FILTER_NAME = "name";
    public static final String FILTER_CREATED_AT = "createdAt";
    public static final String FILTER_UPDATED_AT = "updatedAt";

    public DeviceListOptions() {
        super();
    }

    /**
     * Adds a device filter
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
     * Adds a device filter
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
     * Adds a device filter
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
     * Adds a device filter
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
     * Adds a device filter
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
     * Adds a device filter
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
     * Adds a device filter
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
     * Adds a device filter
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
     * Adds a device filter
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
     * Adds a device filter
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
     * Adds a device filter
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
     * Adds a device filter
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
     * Adds a device filter
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
     * Adds a device filter
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
     * Adds a device filter
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
     * Adds a device filter
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
     * Adds a device filter
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
     * Adds a device filter
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
     * Adds a device filter
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
     * Adds a device filter
     * 
     * @param vendorId
     *            filter to apply
     * @param operator
     *            filter operator
     */
    public void addVendorIdFilter(String vendorId, FilterOperator operator) {
        addFilter(FILTER_VENDOR_ID, operator, vendorId);
    }

}
