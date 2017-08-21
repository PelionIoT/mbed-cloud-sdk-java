package com.arm.mbed.cloud.sdk.update.model;

import java.util.Date;

import com.arm.mbed.cloud.sdk.annotations.Preamble;

@Preamble(description = "Manifest contents")
public class ManifestContents {

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
    private final int version;
    /**
     * A short description of the update.
     */
    private final String description;
    /**
     * A 128-bit random field
     */
    private final String nonce;
    /**
     * The date the manifest was created.
     */
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
    private final boolean applyImmediately;
    /**
     * Hex representation of the 128-bit RFC4122 GUID that uniquely identifies the device. Only applies to a manifest
     * targeted at a specific device.
     */
    private final String deviceId;
    /**
     * Format of the manifest payload. Can be: 1: raw-binary 2: cbor 3: hex-location-length-data 4: elf
     */
    private final ManifestPayloadFormat payloadFormat;
    /**
     * An identifier for where the payload is to be located.
     */
    private final String payloadStorageIdentifier;
    /**
     * Hex representation of the SHA-256 hash of the payload
     */
    private final String payloadHash;
    /**
     * The URI of the payload.
     */
    private final String payloadUri;
    /**
     * Size of the payload in bytes
     */
    private final long payloadSize;

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
     * @return the classId
     */
    public String getClassId() {
        return classId;
    }

    /**
     * @return the vendorId
     */
    public String getVendorId() {
        return vendorId;
    }

    /**
     * @return the version
     */
    public int getVersion() {
        return version;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @return the nonce
     */
    public String getNonce() {
        return nonce;
    }

    /**
     * @return the createdAt
     */
    public Date getCreatedAt() {
        return createdAt;
    }

    /**
     * @return the encryptionMode
     */
    public ManifestEncryptionMode getEncryptionMode() {
        return encryptionMode;
    }

    /**
     * @return the applyImmediately
     */
    public boolean isApplyImmediately() {
        return applyImmediately;
    }

    /**
     * @return the deviceId
     */
    public String getDeviceId() {
        return deviceId;
    }

    /**
     * @return the payloadFormat
     */
    public ManifestPayloadFormat getPayloadFormat() {
        return payloadFormat;
    }

    /**
     * @return the payloadStorageIdentifier
     */
    public String getPayloadStorageIdentifier() {
        return payloadStorageIdentifier;
    }

    /**
     * @return the payloadHash
     */
    public String getPayloadHash() {
        return payloadHash;
    }

    /**
     * @return the payloadUri
     */
    public String getPayloadUri() {
        return payloadUri;
    }

    /**
     * @return the payloadSize
     */
    public long getPayloadSize() {
        return payloadSize;
    }

}
