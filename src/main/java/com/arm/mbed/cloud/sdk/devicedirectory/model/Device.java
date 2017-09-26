package com.arm.mbed.cloud.sdk.devicedirectory.model;

import java.net.URL;
import java.util.Date;
import java.util.Map;

import com.arm.mbed.cloud.sdk.annotations.DefaultValue;
import com.arm.mbed.cloud.sdk.annotations.Internal;
import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.common.SdkModel;

@Preamble(description = "Device model")
public class Device implements SdkModel {

    private static final String NULL = "null";
    /**
     * serialisation id.
     */
    private static final long serialVersionUID = -8965559644581108099L;
    /**
     * The ID of the device.
     */
    private String id;

    /**
     * The owning IAM account ID.
     */
    private final String accountId;
    /**
     * The time the device was created.
     */
    @DefaultValue(value = "now()")
    private final Date createdAt;
    /**
     * The time the device was updated.
     */
    @DefaultValue(value = "now()")
    private final Date updatedAt;
    /**
     * The timestamp of the current manifest version.
     */
    @DefaultValue(value = "now()")
    private final Date manifestTimestamp;
    /**
     * ID of the issuer of the certificate.
     */
    private String certificateIssuerId;
    /**
     * Fingerprint of the device certificate.
     */
    private String certificateFingerprint;
    /**
     * The name of the device.
     */
    private String name;
    /**
     * The alias of the device.
     */
    private String alias;
    /**
     * The description of the device.
     */
    private String description;
    /**
     * The type of the device - e.g. if the device is a gateway.
     */
    private String deviceType;
    /**
     * The device name of the host gateway, if appropriate.
     */
    private String hostGateway;
    /**
     * Up to 5 custom attributes.
     */
    Map<String, String> customAttributes;
    /**
     * The current state of the device.
     */
    private DeviceState state;
    /**
     * The device class.
     */
    private String deviceClass;
    /**
     * The device class.
     */
    @DefaultValue(value = NULL)
    private Integer deviceExecutionMode;
    /**
     * The serial number of the device.
     */
    private String serialNumber;
    /**
     * The device vendor ID.
     */
    private String vendorId;
    /**
     * Expiration date of the certificate used to connect to connector server.
     */
    @DefaultValue(value = NULL)
    private Date connectorCertificateExpiration;
    /**
     * Expiration date of the certificate used to connect to bootstrap server.
     */
    @DefaultValue(value = NULL)
    private Date bootstrapCertificateExpiration;
    /**
     * The time the device was bootstrapped.
     */
    @DefaultValue(value = NULL)
    private Date bootstrappedTimestamp;
    /**
     * The ID of the channel used to communicate with the device.
     */
    private MechanismType mechanism;
    /**
     * The address of the connector to use.
     */
    private URL mechanismUrl;
    /**
     * The SHA256 checksum of the current firmware image.
     */
    private String firmwareChecksum;

    /**
     * Internal constructor.
     * <p>
     * Note: Should not be used. Use {@link #Device()} instead.
     * 
     * @param id
     *            id
     * @param accountId
     *            accountId
     * @param createdAt
     *            createdAt
     * @param updatedAt
     *            updatedAt
     * @param manifestTimestamp
     *            manifest timestamp
     */
    @Internal
    public Device(String id, String accountId, Date createdAt, Date updatedAt, Date manifestTimestamp) {
        this(id, accountId, createdAt, updatedAt, manifestTimestamp, null, null, null, null, null, null, null, null,
                null, null, null, null, null, null, null, null, null, null, null);

    }

    /**
     * Internal constructor.
     * <p>
     * Note: Should not be used. Use {@link #Device()} instead.
     * 
     * @param id
     *            id
     * @param accountId
     *            account id
     * @param createdAt
     *            creation date
     * @param updatedAt
     *            last update date
     * @param manifestTimestamp
     *            manifest timestamp
     * @param certificateIssuerId
     *            certificate issuer id
     * @param certificateFingerprint
     *            certificate fingerprint
     * @param name
     *            name
     * @param alias
     *            alias
     * @param description
     *            description
     * @param deviceType
     *            device type
     * @param hostGateway
     *            host gateway
     * @param customAttributes
     *            custom attributes
     * @param state
     *            state
     * @param deviceClass
     *            device class
     * @param deviceExecutionMode
     *            device execution mode
     * @param serialNumber
     *            serial number
     * @param vendorId
     *            vendor id
     * @param connectorCertificateExpiration
     *            connector certificate expiry date
     * @param bootstrapCertificateExpiration
     *            bootstrap certificate expiry date
     * @param bootstrappedTimestamp
     *            bootstrapped timestamp
     * @param mechanism
     *            mechanism
     * @param mechanismUrl
     *            mechanism URL
     * @param firmwareChecksum
     *            firmware checksum
     * @param trustLevel
     *            trust level
     */
    @Internal
    public Device(String id, String accountId, Date createdAt, Date updatedAt, Date manifestTimestamp,
            String certificateIssuerId, String certificateFingerprint, String name, String alias, String description,
            String deviceType, String hostGateway, Map<String, String> customAttributes, DeviceState state,
            String deviceClass, Integer deviceExecutionMode, String serialNumber, String vendorId,
            Date connectorCertificateExpiration, Date bootstrapCertificateExpiration, Date bootstrappedTimestamp,
            MechanismType mechanism, URL mechanismUrl, String firmwareChecksum) {
        super();
        this.id = id;
        this.accountId = accountId;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.manifestTimestamp = manifestTimestamp;
        setCertificateIssuerId(certificateIssuerId);
        setCertificateFingerprint(certificateFingerprint);
        setName(name);
        setAlias(alias);
        setDescription(description);
        setDeviceType(deviceType);
        setHostGateway(hostGateway);
        setCustomAttributes(customAttributes);
        setState(state);
        setDeviceClass(deviceClass);
        setDeviceExecutionMode(deviceExecutionMode);
        setSerialNumber(serialNumber);
        setVendorId(vendorId);
        setConnectorCertificateExpiration(connectorCertificateExpiration);
        setBootstrapCertificateExpiration(bootstrapCertificateExpiration);
        setBootstrappedTimestamp(bootstrappedTimestamp);
        setMechanismUrl(mechanismUrl);
        setFirmwareChecksum(firmwareChecksum);
        setMechanism(mechanism);
    }

    /**
     * Constructor.
     */
    public Device() {
        this(null, null, new Date(), new Date(), new Date());
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
     * Similar to {@link #setId(String)}
     * 
     * @param id
     *            the id to set
     */
    @Internal
    public void setDeviceId(String id) {
        setId(id);
    }

    /**
     * Gets certificate issuer id.
     * 
     * @return the certificateIssuerId
     */
    public String getCertificateIssuerId() {
        return certificateIssuerId;
    }

    /**
     * Sets certificate issuer id.
     * 
     * @param certificateIssuerId
     *            the certificateIssuerId to set
     */
    public void setCertificateIssuerId(String certificateIssuerId) {
        this.certificateIssuerId = certificateIssuerId;
    }

    /**
     * Gets certificate fingerprint.
     * 
     * @return the certificateFingerprint
     */
    public String getCertificateFingerprint() {
        return certificateFingerprint;
    }

    /**
     * Sets certificate fingerprint.
     * 
     * @param certificateFingerprint
     *            the certificateFingerprint to set
     */
    public void setCertificateFingerprint(String certificateFingerprint) {
        this.certificateFingerprint = certificateFingerprint;
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
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets alias.
     * 
     * @return the alias
     */
    public String getAlias() {
        return alias;
    }

    /**
     * Sets alias.
     * 
     * @param alias
     *            the alias to set
     */
    public void setAlias(String alias) {
        this.alias = alias;
    }

    /**
     * Gets description.
     * 
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets description.
     * 
     * @param description
     *            the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Gets device type.
     * 
     * @return the deviceType
     */
    public String getDeviceType() {
        return deviceType;
    }

    /**
     * Sets device type.
     * 
     * @param deviceType
     *            the deviceType to set
     */
    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    /**
     * Gets host gateway.
     * 
     * @return the hostGateway
     */
    public String getHostGateway() {
        return hostGateway;
    }

    /**
     * Sets host gateway.
     * 
     * @param hostGateway
     *            the hostGateway to set
     */
    public void setHostGateway(String hostGateway) {
        this.hostGateway = hostGateway;
    }

    /**
     * Gets custom attributes.
     * 
     * @return the customAttributes
     */
    public Map<String, String> getCustomAttributes() {
        return customAttributes;
    }

    /**
     * Sets custom attributes.
     * 
     * @param customAttributes
     *            the customAttributes to set
     */
    public void setCustomAttributes(Map<String, String> customAttributes) {
        this.customAttributes = customAttributes;
    }

    /**
     * Gets state.
     * 
     * @return the state
     */
    public DeviceState getState() {
        return state;
    }

    /**
     * Sets state.
     * 
     * @param state
     *            the state to set
     */
    public void setState(DeviceState state) {
        this.state = state;
    }

    /**
     * Gets device class.
     * 
     * @return the deviceClass
     */
    public String getDeviceClass() {
        return deviceClass;
    }

    /**
     * Sets device class.
     * 
     * @param deviceClass
     *            the deviceClass to set
     */
    public void setDeviceClass(String deviceClass) {
        this.deviceClass = deviceClass;
    }

    /**
     * Gets device execution mode.
     * 
     * @return the deviceExecutionMode
     */
    public Integer getDeviceExecutionMode() {
        return deviceExecutionMode;
    }

    /**
     * Set device execution mode.
     * 
     * @param deviceExecutionMode
     *            the deviceExecutionMode to set
     */
    public void setDeviceExecutionMode(Integer deviceExecutionMode) {
        this.deviceExecutionMode = deviceExecutionMode;
    }

    /**
     * Gets serial number.
     * 
     * @return the serialNumber
     */
    public String getSerialNumber() {
        return serialNumber;
    }

    /**
     * Sets serial number.
     * 
     * @param serialNumber
     *            the serialNumber to set
     */
    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    /**
     * Gets vendor id.
     * 
     * @return the vendorId
     */
    public String getVendorId() {
        return vendorId;
    }

    /**
     * Sets vendor id.
     * 
     * @param vendorId
     *            the vendorId to set
     */
    public void setVendorId(String vendorId) {
        this.vendorId = vendorId;
    }

    /**
     * Gets connector certificate expiry date.
     * 
     * @return the connectorCertificateExpiration
     */
    public Date getConnectorCertificateExpiration() {
        return connectorCertificateExpiration;
    }

    /**
     * Set connector certificate expiry date.
     * 
     * @param connectorCertificateExpiration
     *            the connectorCertificateExpiration to set
     */
    public void setConnectorCertificateExpiration(Date connectorCertificateExpiration) {
        this.connectorCertificateExpiration = connectorCertificateExpiration;
    }

    /**
     * Gets bootstrap certificate expiry date.
     * 
     * @return the bootstrapCertificateExpiration
     */
    public Date getBootstrapCertificateExpiration() {
        return bootstrapCertificateExpiration;
    }

    /**
     * Sets bootstrap certificate expiry date.
     * 
     * @param bootstrapCertificateExpiration
     *            the bootstrapCertificateExpiration to set
     */
    public void setBootstrapCertificateExpiration(Date bootstrapCertificateExpiration) {
        this.bootstrapCertificateExpiration = bootstrapCertificateExpiration;
    }

    /**
     * Gets bootstrapped timestamp.
     * 
     * @return the bootstrappedTimestamp
     */
    public Date getBootstrappedTimestamp() {
        return bootstrappedTimestamp;
    }

    /**
     * Sets bootstrapped timestamp.
     * 
     * @param bootstrappedTimestamp
     *            the bootstrappedTimestamp to set
     */
    public void setBootstrappedTimestamp(Date bootstrappedTimestamp) {
        this.bootstrappedTimestamp = bootstrappedTimestamp;
    }

    /**
     * Gets mechanism URL.
     * 
     * @return the mechanismUrl
     */
    public URL getMechanismUrl() {
        return mechanismUrl;
    }

    /**
     * Sets mechanism URL.
     * 
     * @param mechanismUrl
     *            the mechanismUrl to set
     */
    public void setMechanismUrl(URL mechanismUrl) {
        this.mechanismUrl = mechanismUrl;
    }

    /**
     * Gets firmware checksum.
     * 
     * @return the firmwareChecksum
     */
    public String getFirmwareChecksum() {
        return firmwareChecksum;
    }

    /**
     * Set firmware checksum.
     * 
     * @param firmwareChecksum
     *            the firmwareChecksum to set
     */
    public void setFirmwareChecksum(String firmwareChecksum) {
        this.firmwareChecksum = firmwareChecksum;
    }

    /**
     * Gets account id.
     * 
     * @return the accountId
     */
    public String getAccountId() {
        return accountId;
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
     * Sets manifest timestamp.
     * 
     * @return the manifestTimestamp
     */
    public Date getManifestTimestamp() {
        return manifestTimestamp;
    }

    /**
     * Gets mechanism.
     * 
     * @return the mechanism
     */
    public MechanismType getMechanism() {
        return mechanism;
    }

    /**
     * Sets mechanism.
     * 
     * @param mechanism
     *            the mechanism to set
     */
    public void setMechanism(MechanismType mechanism) {
        this.mechanism = mechanism;
    }

    /**
     * Gets clone.
     * 
     * @return clone
     * 
     * @see java.lang.Object#clone()
     */
    @Override
    public Device clone() throws CloneNotSupportedException {
        return new Device(id, accountId, createdAt, updatedAt, manifestTimestamp, certificateIssuerId,
                certificateFingerprint, name, alias, description, deviceType, hostGateway, customAttributes, state,
                deviceClass, deviceExecutionMode, serialNumber, vendorId, connectorCertificateExpiration,
                bootstrapCertificateExpiration, bootstrappedTimestamp, mechanism, mechanismUrl, firmwareChecksum);
    }

}
