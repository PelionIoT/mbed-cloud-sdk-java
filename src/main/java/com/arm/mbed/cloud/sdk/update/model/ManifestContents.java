package com.arm.mbed.cloud.sdk.update.model;

import java.util.Date;

import com.arm.mbed.cloud.sdk.annotations.DefaultValue;
import com.arm.mbed.cloud.sdk.annotations.Internal;
import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.common.SDKModel;

@Preamble(description = "Manifest contents")
public class ManifestContents implements SDKModel {

    /**
     * Serialisation ID.
     */
    private static final long serialVersionUID = 2013553030849979521L;
    /**
     * Hex representation of the 128-bit RFC4122 GUID that represents the device class that the update targets.
     */
    private final String classId;
    /**
     * Hex representation of the 128-bit RFC4122 GUID that represents the vendor.
     */
    private final String vendorId;
    /**
     * Manifest version.
     */
    @DefaultValue(value = "0")
    private final int version;
    /**
     * A short description of the update.
     */
    private final String description;
    /**
     * A 128-bit random field.
     */
    private final String nonce;
    /**
     * The date the manifest was created.
     */
    @DefaultValue(value = "now()")
    private final Date createdAt;
    /**
     * The encryption mode describing the kind of hashing, signing and, encryption in use. The following modes are
     * available: 1: none-ecc-secp256r1-sha256: SHA-256 hashing, ECDSA signatures, using the secp256r1 curve. No payload
     * encryption is used. 2: aes-128-ctr-ecc-secp256r1-sha256: SHA-256 hashing, ECDSA signatures, using the secp256r1
     * curve. The payload is encrypted with AES-128 in CTR-mode. 3: none-none-sha256: SHA-256 hashing. No signature is
     * used. No payload encryption is used. This mode is not recommended except over existing, trusted connections.
     */
    private final ManifestEncryptionMode encryptionMode;
    /**
     * A flag that indicates that the update described by the manifest should be applied as soon as possible.
     */
    @DefaultValue(value = "false")
    private final boolean applyImmediately;
    /**
     * Hex representation of the 128-bit RFC4122 GUID that uniquely identifies the device. Only applies to a manifest
     * targeted at a specific device.
     */
    private final String deviceId;
    /**
     * Format of the manifest payload. Can be: 1: raw-binary 2: cbor 3: hex-location-length-data 4: elf.
     */
    private final ManifestPayloadFormat payloadFormat;
    /**
     * An identifier for where the payload is to be located.
     */
    private final String payloadStorageIdentifier;
    /**
     * Hex representation of the SHA-256 hash of the payload.
     */
    private final String payloadHash;
    /**
     * The URI of the payload.
     */
    private final String payloadUri;
    /**
     * Size of the payload in bytes.
     */
    @DefaultValue(value = "0")
    private final long payloadSize;

    /**
     * Internal constructor.
     * <p>
     * Please use {@link #ManifestContents()} instead.
     * 
     */
    @Internal
    public ManifestContents(String classId, String vendorId, int version, String description, String nonce,
            Date createdAt, ManifestEncryptionMode encryptionMode, boolean applyImmediately, String deviceId,
            ManifestPayloadFormat payloadFormat, String payloadStorageIdentifier, String payloadHash, String payloadUri,
            long payloadSize) {
        super();
        this.classId = classId;
        this.vendorId = vendorId;
        this.version = version;
        this.description = description;
        this.nonce = nonce;
        this.createdAt = createdAt;
        this.encryptionMode = encryptionMode;
        this.applyImmediately = applyImmediately;
        this.deviceId = deviceId;
        this.payloadFormat = payloadFormat;
        this.payloadStorageIdentifier = payloadStorageIdentifier;
        this.payloadHash = payloadHash;
        this.payloadUri = payloadUri;
        this.payloadSize = payloadSize;
    }

    /**
     * Constructor.
     */
    public ManifestContents() {
        this(null, null, 0, null, null, new Date(), ManifestEncryptionMode.getDefault(), false, null,
                ManifestPayloadFormat.getDefault(), null, null, null, 0);
    }

    /**
     * Gets class Id.
     * 
     * @return the classId.
     */
    public String getClassId() {
        return classId;
    }

    /**
     * Gets vendor Id.
     * 
     * @return the vendorId.
     */
    public String getVendorId() {
        return vendorId;
    }

    /**
     * Gets the version.
     * 
     * @return the version.
     */
    public int getVersion() {
        return version;
    }

    /**
     * Gets the description.
     * 
     * @return the description.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Gets the nonce.
     * 
     * @return the nonce.
     */
    public String getNonce() {
        return nonce;
    }

    /**
     * Gets the date of when this manifest was created at.
     * 
     * @return the createdAt.
     */
    public Date getCreatedAt() {
        return createdAt;
    }

    /**
     * Gets the encryption mode.
     * 
     * @return the encryptionMode.
     */
    public ManifestEncryptionMode getEncryptionMode() {
        return encryptionMode;
    }

    /**
     * States whether this manifest should be applied immediately.
     * 
     * @return the applyImmediately.
     */
    public boolean isApplyImmediately() {
        return applyImmediately;
    }

    /**
     * Gets the device Id.
     * 
     * @return the deviceId.
     */
    public String getDeviceId() {
        return deviceId;
    }

    /**
     * Gets the payload format.
     * 
     * @return the payloadFormat.
     */
    public ManifestPayloadFormat getPayloadFormat() {
        return payloadFormat;
    }

    /**
     * Gets the payload storage identifier.
     * 
     * @return the payloadStorageIdentifier.
     */
    public String getPayloadStorageIdentifier() {
        return payloadStorageIdentifier;
    }

    /**
     * Gets the payload hash.
     * 
     * @return the payloadHash.
     */
    public String getPayloadHash() {
        return payloadHash;
    }

    /**
     * Gets the payload URI.
     * 
     * @return the payloadUri.
     */
    public String getPayloadUri() {
        return payloadUri;
    }

    /**
     * Gets the payload size.
     * 
     * @return the payloadSize.
     */
    public long getPayloadSize() {
        return payloadSize;
    }

    /**
     * Clones the object.
     * 
     * @return a clone.
     */
    @Override
    public ManifestContents clone() throws CloneNotSupportedException {
        return new ManifestContents(classId, vendorId, version, description, nonce, createdAt, encryptionMode,
                applyImmediately, deviceId, payloadFormat, payloadStorageIdentifier, payloadHash, payloadUri,
                payloadSize);
    }

}
