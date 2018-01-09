package com.arm.mbed.cloud.sdk.devicedirectory.model;

import java.net.URL;
import java.util.Date;

import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.common.listing.ListOptions;
import com.arm.mbed.cloud.sdk.common.listing.filtering.FilterOperator;

@Preamble(description = "Options to use when listing devices")
public class DeviceListOptions extends ListOptions {
    /**
     * Tag of filter by vendor id.
     */
    public static final String FILTER_VENDOR_ID = "vendorId";
    /**
     * Tag of filter by state.
     */
    public static final String FILTER_STATE = "state";
    /**
     * Tag of filter by serial number.
     */
    public static final String FILTER_SERIAL_NUMBER = "serialNumber";
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
     * Tag of filter by connector certification expiry date.
     */
    public static final String FILTER_CONNECTOR_CERTIFICATE_EXPIRATION = "connectorCertificateExpiration";
    /**
     * Tag of filter by certificate issuer id.
     */
    public static final String FILTER_CERTIFICATE_ISSUER_ID = "certificateIssuerId";
    /**
     * Tag of filter by bootstrapped timestamp.
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
     * Tag of filter by name.
     */
    public static final String FILTER_NAME = "name";
    /**
     * Tag of filter by creation date.
     */
    public static final String FILTER_CREATED_AT = "createdAt";
    /**
     * Tag of filter by last update date.
     */
    public static final String FILTER_UPDATED_AT = "updatedAt";
    /**
     * Tag of filter by device type.
     */
    public static final String FILTER_DEVICE_TYPE = "deviceType";
    /**
     * Tag of filter by host gateway.
     */
    public static final String FILTER_HOST_GATEWAY = "hostGateway";

    /**
     * Constructor.
     */
    public DeviceListOptions() {
        super();
    }

    /**
     * Adds a device filter based on accountId field.
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
     * Adds a device filter based on bootstra[ certificate expiry date field.
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
     * Adds a device filter based on issuer id field.
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
     * Adds a device filter based on mechanism URL field.
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
     * Adds a device filter based on vendor id field.
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

    /*
     * (non-Javadoc)
     * 
     * @see com.arm.mbed.cloud.sdk.common.listing.ListOptions#clone()
     */
    @Override
    public DeviceListOptions clone() {
        final DeviceListOptions opt = new DeviceListOptions();
        opt.setOptions(this);
        return opt;
    }
}
