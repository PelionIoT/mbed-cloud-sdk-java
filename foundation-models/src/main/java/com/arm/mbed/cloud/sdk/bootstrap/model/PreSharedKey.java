package com.arm.mbed.cloud.sdk.bootstrap.model;

import java.util.Date;

import com.arm.mbed.cloud.sdk.annotations.Internal;
import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.annotations.Required;
import com.arm.mbed.cloud.sdk.common.SdkModel;
import com.arm.mbed.cloud.sdk.common.SdkUtils;

@Preamble(description = "Definition of a pre-shared key")
/**
 * Definition of a pre-shared key.
 * <p>
 * For more information about such keys, have a look at
 * <a href=" https://cloud.mbed.com/docs/latest/connecting/mbed-client-lite-security-considerations.html">corresponding
 * documentation</a>
 *
 */
public class PreSharedKey implements SdkModel {

    public static final String IDENTIFIER_VALIDATION_REGEX = "^[ -~]{16,64}$";
    public static final String SECRET_VALIDATION_REGEX = "^(0[xX])?[0-9a-fA-F]{32,64}$";
    /**
     * Serialisation Id.
     */
    private static final long serialVersionUID = 2961850962679799165L;
    /**
     * The unique identifier that this pre-shared key applies to.
     */
    @Required
    private String id;
    /**
     * The secret of the pre-shared key in hexadecimal.
     */
    private String secret;
    /**
     * the date-time when this pre-shared key was uploaded to Mbed Cloud.
     */
    private final Date createdAt;

    /**
     * Internal constructor.
     * <p>
     * Note: use {@link #PreSharedKey(String, String)} instead.
     *
     * @param id
     *            id
     * @param secret
     *            secret
     * @param createdAt
     *            createdAt
     */
    @Internal
    public PreSharedKey(String id, String secret, Date createdAt) {
        super();
        setId(id);
        setSecret(secret);
        this.createdAt = createdAt;
    }

    /**
     * Constructor.
     *
     * @param id
     *            preshared key identifier.
     * @param secret
     *            hexadecimal secret.
     */
    public PreSharedKey(String id, String secret) {
        this(id, secret, null);
    }

    /**
     * Constructor.
     *
     * @param id
     *            preshared key identifier.
     */
    public PreSharedKey(String id) {
        this(id, null);
    }

    /**
     * Internal constructor.
     * <p>
     * Note: Should not be used. Use {@link #PreSharedKey(String) or #PreSharedKey(String, String)} instead.
     */
    @Internal
    public PreSharedKey() {
        this(null);
    }

    /**
     * Gets PSK secret.
     *
     * @return the secret.
     */
    public String getSecret() {
        return secret;
    }

    /**
     * Gets PSK secret.
     * <p>
     * Note: Similar to {@link #getSecret()}
     *
     * @return the secret.
     */
    @Internal
    public String getSecretHex() {
        return getSecret();
    }

    /**
     * Sets the key identifier.
     * <p>
     * Note: It has to be 16-64 <a href="https://en.wikipedia.org/wiki/ASCII#Printable_characters">printable</a>
     * (non-control) ASCII characters. It also must be globally unique. Consider using vendor-MAC-ID-device-model.
     * <p>
     * for instance "myEndpoint.host.com"
     *
     * @see #IDENTIFIER_VALIDATION_REGEX for checking validity
     *
     * @param id
     *            the id to set
     */
    @Required
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Sets the key identifier.
     * <p>
     * Note: Similar to {@link #setId(String)}
     *
     * @param id
     *            the id to set
     */
    @Internal
    public void setEndpointName(String id) {
        setId(id);
    }

    /**
     * Gets the key identifier.
     */
    @Override
    public String getId() {
        return id;
    }

    /**
     * Gets the key identifier.
     * <p>
     * Note: Similar to {@link #getId()}
     *
     * @return the key identifier
     */
    @Internal
    public String getEndpointName() {
        return getId();
    }

    /**
     * Sets the secret.
     * <p>
     * Note: It is not case sensitive; 4a is same as 4A, and it is allowed with or without 0x in the beginning. The
     * minimum length of the secret is 128 bits and maximum 256 bits.
     * <p>
     * for instance, "4a4a4a4a4a4a4a4a4a4a4a4a4a4a4a4a"
     *
     * @see #SECRET_VALIDATION_REGEX for checking validity
     * @param secret
     *            the secret to set
     */
    public void setSecret(String secret) {
        this.secret = secret;
    }

    /**
     * Sets the secret.
     * <p>
     * Note: Similar to {@link #setSecret(String)}
     *
     * @param secret
     *            the secret to set
     */
    @Internal
    public void setSecretHex(String secret) {
        setSecret(secret);
    }

    /**
     * Sets the secret from a byte array.
     *
     * @param secret
     *            the secret to set
     */
    public void setSecretFromByteArray(byte[] secret) {
        setSecret(SdkUtils.toHex(secret));
    }

    /**
     * Gets when this pre-shared key was uploaded to Mbed Cloud.
     *
     * @return the date when this pre-shared key was uploaded to Mbed Cloud.
     */
    public Date getCreatedAt() {
        return createdAt;
    }

    /**
     * Checks whether the secret is valid or not.
     *
     * @return True if the secret is valid. False otherwise.
     */
    public boolean isSecretValid() {
        if (secret == null) {
            return true;
        }
        return secret.matches(SECRET_VALIDATION_REGEX);
    }

    /**
     * Checks whether the identifier is valid or not.
     *
     * @return True if the identifier is valid. False otherwise.
     */
    public boolean isIdentifierValid() {
        if (id == null) {
            return false;
        }
        return id.matches(IDENTIFIER_VALIDATION_REGEX);
    }

    /**
     * Gets a clone.
     *
     * @return a clone of this account.
     *
     * @see java.lang.Object#clone()
     */
    @Override
    public SdkModel clone() {
        return new PreSharedKey(id, secret, createdAt);
    }

    @Override
    public boolean isValid() {
        return isIdentifierValid() && isSecretValid();
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "PreSharedKey [id=" + id + ", secret=" + secret + ", createdAt=" + createdAt + "]";
    }

}
