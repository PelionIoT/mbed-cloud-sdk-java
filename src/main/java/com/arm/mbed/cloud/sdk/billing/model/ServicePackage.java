package com.arm.mbed.cloud.sdk.billing.model;

import java.util.Date;

import com.arm.mbed.cloud.sdk.annotations.Internal;
import com.arm.mbed.cloud.sdk.annotations.Preamble;

@Preamble(description = "Model for billing service packages")
/**
 * A Service package that allows the customer to do a certain number of firmware updates to customer's devices. A
 * service package has a validity period of 1 year. Customers can only have one active service package at a time.
 *
 */
@SuppressWarnings("PMD.CyclomaticComplexity")
public class ServicePackage extends AbstractBillingEntity {
    /**
     * Serialisation Id.
     */
    private static final long serialVersionUID = -1798436673224523170L;
    private final Date createdAt;
    private final Date startsAt;
    private final Date expiresAt;
    private final Date endsAt;
    private final Date modifiedAt;
    private final boolean gracePeriod;
    private final long firmwareUpdateCount;
    private final String previousId;
    private final String nextId;
    private final String reason;
    private final ServicePackageState state;

    /**
     * Internal Constructor.
     *
     * @param id
     *            id.
     * @param createdAt
     *            createdAt.
     * @param startsAt
     *            startsAt
     * @param expiresAt
     *            expiresAt
     * @param endsAt
     *            endsAt
     * @param modifiedAt
     *            modifiedAt
     * @param gracePeriod
     *            gracePeriod
     * @param firmwareUpdateCount
     *            firmwareUpdateCount
     * @param previousId
     *            previousId
     * @param nextId
     *            nextId
     * @param reason
     *            reason
     * @param state
     *            state
     */
    @Internal
    public ServicePackage(String id, Date createdAt, Date startsAt, Date expiresAt, Date endsAt, Date modifiedAt,
                          boolean gracePeriod, long firmwareUpdateCount, String previousId, String nextId,
                          String reason, ServicePackageState state) {
        super(id);
        this.createdAt = createdAt;
        this.startsAt = startsAt;
        this.expiresAt = expiresAt;
        this.modifiedAt = modifiedAt;
        this.endsAt = endsAt;
        this.gracePeriod = gracePeriod;
        this.firmwareUpdateCount = firmwareUpdateCount;
        this.previousId = previousId;
        this.nextId = nextId;
        this.reason = reason;
        this.state = state;
    }

    /**
     * Constructor.
     */
    public ServicePackage() {
        this(null, new Date(), new Date(), new Date(), new Date(), new Date(), false, 0, null, null, null,
             ServicePackageState.getDefault());
    }

    /**
     * Gets when the package was created.
     *
     * @return the createdAt
     */
    public Date getCreatedAt() {
        return createdAt;
    }

    /**
     * Gets when the service package starts.
     *
     * @return the startsAt
     */
    public Date getStartsAt() {
        return startsAt;
    }

    /**
     * Gets when the service package expires.
     * <p>
     * Service package expiration drops the customer's quota to zero and prevents starting of new firmware update
     * campaigns. Customer enters a grace period before the usage is fully blocked.
     *
     * @return the expiresAt
     */
    public Date getExpiresAt() {
        return expiresAt;
    }

    /**
     * Gets when the service package was last modified.
     *
     * @return the modifiedAt
     */
    public Date getModifiedAt() {
        return modifiedAt;
    }

    /**
     * Gets when the service package ends.
     * <p>
     * After the service package has ended the grace period the service package is considered terminated.
     *
     * @return the endsAt
     */
    public Date getEndsAt() {
        return endsAt;
    }

    /**
     * States whether the service package is in grace period or not.
     * <P>
     * When service package has expired customer moves to 60 day grace period. It prevents immediately blocking or
     * terminating any ongoing firmware update campaigns and ensures the customer can still update their devices using
     * the firmware updates they have paid for. After the 60 day grace period the firmware update functionality will be
     * fully blocked.
     *
     * @return the gracePeriod
     */
    public boolean isGracePeriod() {
        return gracePeriod;
    }

    /**
     * Gets firmware update count for this service package.
     * <p>
     * Customer's firmware update quota determines how many times the customer can update device's firmware. Quota can
     * be split into multiple firmware update campaigns and when customer starts a new firmware update campaign it
     * reduces the quota by the size of the campaign. Quota can be increased by ending ongoing campaigns or by buying a
     * new service package.
     *
     * @return the firmwareUpdateCount
     */
    public long getFirmwareUpdateCount() {
        return firmwareUpdateCount;
    }

    /**
     * Gets the ID of previous service package in the sequence.
     *
     * @return the previousId
     */
    public String getPreviousId() {
        return previousId;
    }

    /**
     * Gets the ID of next service package in the sequence.
     *
     * @return the nextId
     */
    public String getNextId() {
        return nextId;
    }

    /**
     * Gets the reason why this service package was ended.
     *
     * @return the reason
     */
    public String getReason() {
        return reason;
    }

    /**
     * Gets the service package state.
     *
     * @return the state
     */
    public ServicePackageState getState() {
        return state;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((createdAt == null) ? 0 : createdAt.hashCode());
        result = prime * result + ((endsAt == null) ? 0 : endsAt.hashCode());
        result = prime * result + ((expiresAt == null) ? 0 : expiresAt.hashCode());
        result = prime * result + (int) (firmwareUpdateCount ^ (firmwareUpdateCount >>> 32));
        result = prime * result + (gracePeriod ? 1231 : 1237);
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((modifiedAt == null) ? 0 : modifiedAt.hashCode());
        result = prime * result + ((nextId == null) ? 0 : nextId.hashCode());
        result = prime * result + ((previousId == null) ? 0 : previousId.hashCode());
        result = prime * result + ((reason == null) ? 0 : reason.hashCode());
        result = prime * result + ((startsAt == null) ? 0 : startsAt.hashCode());
        result = prime * result + ((state == null) ? 0 : state.hashCode());
        return result;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ServicePackage other = (ServicePackage) obj;
        if (createdAt == null) {
            if (other.createdAt != null) {
                return false;
            }
        } else if (!createdAt.equals(other.createdAt)) {
            return false;
        }
        if (endsAt == null) {
            if (other.endsAt != null) {
                return false;
            }
        } else if (!endsAt.equals(other.endsAt)) {
            return false;
        }
        if (expiresAt == null) {
            if (other.expiresAt != null) {
                return false;
            }
        } else if (!expiresAt.equals(other.expiresAt)) {
            return false;
        }
        if (firmwareUpdateCount != other.firmwareUpdateCount) {
            return false;
        }
        if (gracePeriod != other.gracePeriod) {
            return false;
        }
        if (id == null) {
            if (other.id != null) {
                return false;
            }
        } else if (!id.equals(other.id)) {
            return false;
        }
        if (modifiedAt == null) {
            if (other.modifiedAt != null) {
                return false;
            }
        } else if (!modifiedAt.equals(other.modifiedAt)) {
            return false;
        }
        if (nextId == null) {
            if (other.nextId != null) {
                return false;
            }
        } else if (!nextId.equals(other.nextId)) {
            return false;
        }
        if (previousId == null) {
            if (other.previousId != null) {
                return false;
            }
        } else if (!previousId.equals(other.previousId)) {
            return false;
        }
        if (reason == null) {
            if (other.reason != null) {
                return false;
            }
        } else if (!reason.equals(other.reason)) {
            return false;
        }
        if (startsAt == null) {
            if (other.startsAt != null) {
                return false;
            }
        } else if (!startsAt.equals(other.startsAt)) {
            return false;
        }
        if (state != other.state) {
            return false;
        }
        return true;
    }

    @Override
    public ServicePackage clone() {
        return new ServicePackage(id, createdAt, startsAt, expiresAt, endsAt, modifiedAt, gracePeriod,
                                  firmwareUpdateCount, previousId, nextId, reason, state);
    }

    @Override
    public String toString() {
        return "ServicePackage [createdAt=" + createdAt + ", startsAt=" + startsAt + ", expiresAt=" + expiresAt
               + ", endsAt=" + endsAt + ", modifiedAt=" + modifiedAt + ", gracePeriod=" + gracePeriod
               + ", firmwareUpdateCount=" + firmwareUpdateCount + ", previousId=" + previousId + ", nextId=" + nextId
               + ", reason=" + reason + ", state=" + state + "]";
    }

}
