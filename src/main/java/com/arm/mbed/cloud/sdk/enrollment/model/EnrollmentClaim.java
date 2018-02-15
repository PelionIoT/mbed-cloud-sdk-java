package com.arm.mbed.cloud.sdk.enrollment.model;

import java.util.Date;

import com.arm.mbed.cloud.sdk.annotations.Required;
import com.arm.mbed.cloud.sdk.common.SdkModel;

public class EnrollmentClaim implements SdkModel {

    /**
     * Serialisation Id.
     */
    private static final long serialVersionUID = -3305384234791887844L;
    private String id;
    private final Date createdAt;
    private final Date claimedAt;
    private final Date expiresAt;
    @Required
    private String identity;
    private final String accountId;
    private final String deviceId;

    public EnrollmentClaim(String id, Date createdAt, Date claimedAt, Date expiresAt, String accountId, String deviceId,
            String identity) {
        this(id, createdAt, claimedAt, expiresAt, accountId, deviceId);
        setIdentity(identity);
    }

    public EnrollmentClaim(String id, Date createdAt, Date claimedAt, Date expiresAt, String accountId,
            String deviceId) {
        super();
        setId(id);
        this.createdAt = createdAt;
        this.claimedAt = claimedAt;
        this.expiresAt = expiresAt;
        this.accountId = accountId;
        this.deviceId = deviceId;
        setIdentity(null);
    }

    public EnrollmentClaim() {
        this(null, new Date(), new Date(), new Date(), null, null);
    }

    /**
     * @return the identity
     */
    public String getIdentity() {
        return identity;
    }

    /**
     * @param identity
     *            the identity to set
     */
    @Required
    public void setIdentity(String identity) {
        this.identity = identity;
    }

    /**
     * @return the createdAt
     */
    public Date getCreatedAt() {
        return createdAt;
    }

    /**
     * @return the claimedAt
     */
    public Date getClaimedAt() {
        return claimedAt;
    }

    /**
     * @return the expiresAt
     */
    public Date getExpiresAt() {
        return expiresAt;
    }

    /**
     * @return the accountId
     */
    public String getAccountId() {
        return accountId;
    }

    /**
     * @return the deviceId
     */
    public String getDeviceId() {
        return deviceId;
    }

    /**
     * @param id
     *            the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public SdkModel clone() {
        return new EnrollmentClaim(id, createdAt, claimedAt, expiresAt, identity, accountId, deviceId);
    }

    @Override
    public boolean isValid() {
        return identity != null && !identity.isEmpty();
    }

}
