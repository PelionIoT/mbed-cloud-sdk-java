package com.arm.mbed.cloud.sdk.enrollment.model;

import java.util.Date;

import com.arm.mbed.cloud.sdk.annotations.DefaultValue;
import com.arm.mbed.cloud.sdk.annotations.Internal;
import com.arm.mbed.cloud.sdk.annotations.Required;
import com.arm.mbed.cloud.sdk.common.SdkModel;

public class EnrollmentClaim implements SdkModel {

    /**
     * Serialisation Id.
     */
    private static final long serialVersionUID = -3305384234791887844L;
    /**
     * Id of the enrolment claim.
     */
    private String id;
    /**
     * The time of the enrolment identity creation.
     */
    @DefaultValue(value = "now()")
    private final Date createdAt;
    /**
     * The time when a device is assigned to the account.
     */
    @DefaultValue(value = "now()")
    private final Date claimedAt;
    /**
     * The enrolment claim expiration time. If the device does not connect to Mbed Cloud before the expiration, the
     * claim is removed without a separate notice.
     */
    @DefaultValue(value = "now()")
    private final Date expiresAt;
    /**
     * Enrollment identity. Pattern: ^A-[A-Za-z0-9:]{95}$.
     * <p>
     * For example, A-35:e7:72:8a:07:50:3b:3d:75:96:57:52:72:41:0d:78:cc:c6:e5:53:48:c6:65:58:5b:fa:af:4d:2d:73:95:c5
     */
    @Required
    private String claimId;
    /**
     * Id of the account the claim relates to.
     */
    private final String accountId;
    /**
     * The ID of the enrolled device once it has been registered.
     */
    private final String deviceId;

    /**
     * Internal constructor.
     * <p>
     * Note: Should not be used. Use {@link #EnrollmentClaim()} instead.
     *
     * @param id
     *            id
     * @param createdAt
     *            createdAt
     * @param claimedAt
     *            claimedAt
     * @param expiresAt
     *            expiresAt
     * @param accountId
     *            accountId
     * @param deviceId
     *            deviceId
     * @param identity
     *            identity
     */
    @Internal
    public EnrollmentClaim(String id, Date createdAt, Date claimedAt, Date expiresAt, String accountId, String deviceId,
                           String identity) {
        this(id, createdAt, claimedAt, expiresAt, accountId, deviceId);
        setClaimId(identity);
    }

    /**
     * Internal constructor.
     * <p>
     * Note: Should not be used. Use {@link #EnrollmentClaim()} instead.
     * 
     * @param id
     *            id
     * @param createdAt
     *            createdAt
     * @param claimedAt
     *            claimedAt
     * @param expiresAt
     *            expiresAt
     * @param accountId
     *            accountId
     * @param deviceId
     *            deviceId
     */
    @Internal
    public EnrollmentClaim(String id, Date createdAt, Date claimedAt, Date expiresAt, String accountId,
                           String deviceId) {
        super();
        setId(id);
        this.createdAt = createdAt;
        this.claimedAt = claimedAt;
        this.expiresAt = expiresAt;
        this.accountId = accountId;
        this.deviceId = deviceId;
        setClaimId(null);
    }

    /**
     * Constructor for an enrollment claim.
     * <p>
     * Other constructors with 'Internal' annotation are for internal usage only.
     */
    public EnrollmentClaim() {
        this(null, new Date(), new Date(), new Date(), null, null);
    }

    /**
     * Constructor for an enrollment claim.
     * <p>
     * Other constructors with 'Internal' annotation are for internal usage only.
     * 
     * @param claimId
     *            the identity to set. Pattern: ^A-[A-Za-z0-9:]{95}$. For example,
     *            A-35:e7:72:8a:07:50:3b:3d:75:96:57:52:72:41:0d:78:cc:c6:e5:53:48:c6:65:58:5b:fa:af:4d:2d:73:95:c5
     */
    public EnrollmentClaim(String claimId) {
        this();
        setClaimId(claimId);
    }

    /**
     * Gets the claim identity (token present on the device).
     * 
     * @return the claim identity
     */
    public String getClaimId() {
        return claimId;
    }

    /**
     * Sets the claim identity (token present on the device).
     * 
     * @param claimId
     *            the identity to set. Pattern: ^A-[A-Za-z0-9:]{95}$. For example,
     *            A-35:e7:72:8a:07:50:3b:3d:75:96:57:52:72:41:0d:78:cc:c6:e5:53:48:c6:65:58:5b:fa:af:4d:2d:73:95:c5
     */
    @Required
    public void setClaimId(String claimId) {
        this.claimId = claimId;
    }

    /**
     * Gets claim creation time.
     * 
     * @return the createdAt
     */
    public Date getCreatedAt() {
        return createdAt;
    }

    /**
     * Gets when a device enrolled.
     * 
     * @return the claimedAt
     */
    public Date getClaimedAt() {
        return claimedAt;
    }

    /**
     * Gets enrolment claim expiration time. If the device does not connect to Mbed Cloud before the expiration, the
     * claim is removed without a separate notice.
     * 
     * @return the expiresAt
     */
    public Date getExpiresAt() {
        return expiresAt;
    }

    /**
     * Gets the account id the claim relates to.
     * 
     * @return the accountId
     */
    public String getAccountId() {
        return accountId;
    }

    /**
     * Gets the id of the device which enrolled.
     * 
     * @return the deviceId of the enrolled device
     */
    public String getDeviceId() {
        return deviceId;
    }

    /**
     * Sets the id of the enrolment claim.
     * <p>
     * Note: this is different from {@link #setClaimId(String)} which corresponds to the claim token.
     * 
     * @param id
     *            the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Gets the id of the enrolment claim.
     * <p>
     * Note: this is different from {@link #getClaimId()} which corresponds to the claim token.
     */
    @Override
    public String getId() {
        return id;
    }

    /**
     * Determines whether all required fields have been set and therefore if the model instance is valid.
     *
     * @return true if instance is valid. False otherwise.
     */
    @Override
    public boolean isValid() {
        return claimId != null && !claimId.isEmpty();
    }

    /**
     * Gets clone.
     *
     * @return clone
     *
     * @see java.lang.Object#clone()
     */
    @Override
    public SdkModel clone() {
        return new EnrollmentClaim(id, createdAt, claimedAt, expiresAt, claimId, accountId, deviceId);
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "EnrollmentClaim [id=" + id + ", createdAt=" + createdAt + ", claimedAt=" + claimedAt + ", expiresAt="
               + expiresAt + ", claimId=" + claimId + ", accountId=" + accountId + ", deviceId=" + deviceId + "]";
    }

}
