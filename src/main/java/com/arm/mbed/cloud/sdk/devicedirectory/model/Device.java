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
     * 
     */
    private static final long serialVersionUID = -8965559644581108099L;
    /**
     * The ID of the device
     */
    private String id;

    /**
     * The owning IAM account ID
     */
    private final String accountId;
    /**
     * The time the device was created
     */
    @DefaultValue(value = "now()")
    private final Date createdAt;
    /**
     * The time the device was updated
     */
    @DefaultValue(value = "now()")
    private final Date updatedAt;
    /**
     * The timestamp of the current manifest version
     */
    @DefaultValue(value = "now()")
    private final Date manifestTimestamp;
    /**
     * ID of the issuer of the certificate
     */
    private String certificateIssuerId;
    /**
     * Fingerprint of the device certificate
     */
    private String certificateFingerprint;
    /**
     * The name of the device
     */
    private String name;
    /**
     * The alias of the device
     */
    private String alias;
    /**
     * The description of the device
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
     * Up to 5 custom attributes
     */
    Map<String, String> customAttributes;
    /**
     * The current state of the device
     */
    private DeviceState state;
    /**
     * The device class
     */
    private String deviceClass;
    /**
     * The device class
     */
    @DefaultValue(value = NULL)
    private Integer deviceExecutionMode;
    /**
     * The serial number of the device
     */
    private String serialNumber;
    /**
     * The device vendor ID
     */
    private String vendorId;
    /**
     * Expiration date of the certificate used to connect to connector server
     */
    @DefaultValue(value = NULL)
    private Date connectorCertificateExpiration;
    /**
     * Expiration date of the certificate used to connect to bootstrap server
     */
    @DefaultValue(value = NULL)
    private Date bootstrapCertificateExpiration;
    /**
     * The time the device was bootstrapped
     */
    @DefaultValue(value = NULL)
    private Date bootstrappedTimestamp;
    /**
     * The ID of the channel used to communicate with the device
     */
    private MechanismType mechanism;
    /**
     * The address of the connector to use
     */
    private URL mechanismUrl;
    /**
     * The SHA256 checksum of the current firmware image
     */
    private String firmwareChecksum;
    /**
     * The device trust level
     */
    @DefaultValue(value = NULL)
    private Integer trustLevel;

    @Internal
    public Device(String id, String accountId, Date createdAt, Date updatedAt, Date manifestTimestamp) {
        this(id, accountId, createdAt, updatedAt, manifestTimestamp, null, null, null, null, null, null, null, null,
                null, null, null, null, null, null, null, null, null, null, null, null);

    }

    @Internal
    public Device(String id, String accountId, Date createdAt, Date updatedAt, Date manifestTimestamp,
            String certificateIssuerId, String certificateFingerprint, String name, String alias, String description,
            String deviceType, String hostGateway, Map<String, String> customAttributes, DeviceState state,
            String deviceClass, Integer deviceExecutionMode, String serialNumber, String vendorId,
            Date connectorCertificateExpiration, Date bootstrapCertificateExpiration, Date bootstrappedTimestamp,
            MechanismType mechanism, URL mechanismUrl, String firmwareChecksum, Integer trustLevel) {
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
        setTrustLevel(trustLevel);
        setMechanism(mechanism);
    }

    public Device() {
        this(null, null, new Date(), new Date(), new Date());
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
     * similar to setId()
     * 
     * @param id
     *            the id to set
     */
    @Internal
    public void setDeviceId(String id) {
        setId(id);
    }

    /**
     * @return the certificateIssuerId
     */
    public String getCertificateIssuerId() {
        return certificateIssuerId;
    }

    /**
     * @param certificateIssuerId
     *            the certificateIssuerId to set
     */
    public void setCertificateIssuerId(String certificateIssuerId) {
        this.certificateIssuerId = certificateIssuerId;
    }

    /**
     * @return the certificateFingerprint
     */
    public String getCertificateFingerprint() {
        return certificateFingerprint;
    }

    /**
     * @param certificateFingerprint
     *            the certificateFingerprint to set
     */
    public void setCertificateFingerprint(String certificateFingerprint) {
        this.certificateFingerprint = certificateFingerprint;
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
     * @return the alias
     */
    public String getAlias() {
        return alias;
    }

    /**
     * @param alias
     *            the alias to set
     */
    public void setAlias(String alias) {
        this.alias = alias;
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
     * @return the deviceType
     */
    public String getDeviceType() {
        return deviceType;
    }

    /**
     * @param deviceType
     *            the deviceType to set
     */
    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    /**
     * @return the hostGateway
     */
    public String getHostGateway() {
        return hostGateway;
    }

    /**
     * @param hostGateway
     *            the hostGateway to set
     */
    public void setHostGateway(String hostGateway) {
        this.hostGateway = hostGateway;
    }

    /**
     * @return the customAttributes
     */
    public Map<String, String> getCustomAttributes() {
        return customAttributes;
    }

    /**
     * @param customAttributes
     *            the customAttributes to set
     */
    public void setCustomAttributes(Map<String, String> customAttributes) {
        this.customAttributes = customAttributes;
    }

    /**
     * @return the state
     */
    public DeviceState getState() {
        return state;
    }

    /**
     * @param state
     *            the state to set
     */
    public void setState(DeviceState state) {
        this.state = state;
    }

    /**
     * @return the deviceClass
     */
    public String getDeviceClass() {
        return deviceClass;
    }

    /**
     * @param deviceClass
     *            the deviceClass to set
     */
    public void setDeviceClass(String deviceClass) {
        this.deviceClass = deviceClass;
    }

    /**
     * @return the deviceExecutionMode
     */
    public Integer getDeviceExecutionMode() {
        return deviceExecutionMode;
    }

    /**
     * @param deviceExecutionMode
     *            the deviceExecutionMode to set
     */
    public void setDeviceExecutionMode(Integer deviceExecutionMode) {
        this.deviceExecutionMode = deviceExecutionMode;
    }

    /**
     * @return the serialNumber
     */
    public String getSerialNumber() {
        return serialNumber;
    }

    /**
     * @param serialNumber
     *            the serialNumber to set
     */
    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    /**
     * @return the vendorId
     */
    public String getVendorId() {
        return vendorId;
    }

    /**
     * @param vendorId
     *            the vendorId to set
     */
    public void setVendorId(String vendorId) {
        this.vendorId = vendorId;
    }

    /**
     * @return the connectorCertificateExpiration
     */
    public Date getConnectorCertificateExpiration() {
        return connectorCertificateExpiration;
    }

    /**
     * @param connectorCertificateExpiration
     *            the connectorCertificateExpiration to set
     */
    public void setConnectorCertificateExpiration(Date connectorCertificateExpiration) {
        this.connectorCertificateExpiration = connectorCertificateExpiration;
    }

    /**
     * @return the bootstrapCertificateExpiration
     */
    public Date getBootstrapCertificateExpiration() {
        return bootstrapCertificateExpiration;
    }

    /**
     * @param bootstrapCertificateExpiration
     *            the bootstrapCertificateExpiration to set
     */
    public void setBootstrapCertificateExpiration(Date bootstrapCertificateExpiration) {
        this.bootstrapCertificateExpiration = bootstrapCertificateExpiration;
    }

    /**
     * @return the bootstrappedTimestamp
     */
    public Date getBootstrappedTimestamp() {
        return bootstrappedTimestamp;
    }

    /**
     * @param bootstrappedTimestamp
     *            the bootstrappedTimestamp to set
     */
    public void setBootstrappedTimestamp(Date bootstrappedTimestamp) {
        this.bootstrappedTimestamp = bootstrappedTimestamp;
    }

    /**
     * @return the mechanismUrl
     */
    public URL getMechanismUrl() {
        return mechanismUrl;
    }

    /**
     * @param mechanismUrl
     *            the mechanismUrl to set
     */
    public void setMechanismUrl(URL mechanismUrl) {
        this.mechanismUrl = mechanismUrl;
    }

    /**
     * @return the firmwareChecksum
     */
    public String getFirmwareChecksum() {
        return firmwareChecksum;
    }

    /**
     * @param firmwareChecksum
     *            the firmwareChecksum to set
     */
    public void setFirmwareChecksum(String firmwareChecksum) {
        this.firmwareChecksum = firmwareChecksum;
    }

    /**
     * @return the trustLevel
     */
    public Integer getTrustLevel() {
        return trustLevel;
    }

    /**
     * @param trustLevel
     *            the trustLevel to set
     */
    public void setTrustLevel(Integer trustLevel) {
        this.trustLevel = trustLevel;
    }

    /**
     * @return the accountId
     */
    public String getAccountId() {
        return accountId;
    }

    /**
     * @return the createdAt
     */
    public Date getCreatedAt() {
        return createdAt;
    }

    /**
     * @return the updatedAt
     */
    public Date getUpdatedAt() {
        return updatedAt;
    }

    /**
     * @return the manifestTimestamp
     */
    public Date getManifestTimestamp() {
        return manifestTimestamp;
    }

    /**
     * @return the mechanism
     */
    public MechanismType getMechanism() {
        return mechanism;
    }

    /**
     * @param mechanism
     *            the mechanism to set
     */
    public void setMechanism(MechanismType mechanism) {
        this.mechanism = mechanism;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#clone()
     */
    @Override
    public Device clone() throws CloneNotSupportedException {
        return new Device(id, accountId, createdAt, updatedAt, manifestTimestamp, certificateIssuerId,
                certificateFingerprint, name, alias, description, deviceType, hostGateway, customAttributes, state,
                deviceClass, deviceExecutionMode, serialNumber, vendorId, connectorCertificateExpiration,
                bootstrapCertificateExpiration, bootstrappedTimestamp, mechanism, mechanismUrl, firmwareChecksum,
                trustLevel);
    }

}
