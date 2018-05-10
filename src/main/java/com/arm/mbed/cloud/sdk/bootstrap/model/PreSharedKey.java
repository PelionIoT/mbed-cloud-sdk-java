package com.arm.mbed.cloud.sdk.bootstrap.model;

import com.arm.mbed.cloud.sdk.annotations.Internal;
import com.arm.mbed.cloud.sdk.annotations.Required;
import com.arm.mbed.cloud.sdk.common.SdkModel;
import com.mbed.lwm2m.utils.HexArray;

public class PreSharedKey implements SdkModel {

    private static final String IDENTIFIER_VALIDATION_REGEX = "^[ -~]{16,64}$";
    private static final String SECRET_VALIDATION_REGEX = "^(0[xX])?[0-9a-fA-F]{16,64}$";
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
     * Constructor.
     *
     * @param id
     *            preshared key identifier.
     * @param secret
     *            hexadecimal secret.
     */
    public PreSharedKey(String id, String secret) {
        super();
        setId(id);
        setSecret(secret);
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
     * (non-control) ASCII characters.
     * <p>
     * for instance "myEndpoint.host.com"
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
     * minimum length of the secret is 64 bits and maximum 256 bits.
     * <p>
     * for instance, "4a4a4a4a4a4a4a4a4a4a4a4a4a4a4a4a"
     *
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
        setSecret(HexArray.toHex(secret));
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
        return new PreSharedKey(id, secret);
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
        return "PreSharedKey [id=" + id + ", secret=" + secret + "]";
    }

}
