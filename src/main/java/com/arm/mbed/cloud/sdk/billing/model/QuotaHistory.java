package com.arm.mbed.cloud.sdk.billing.model;

import java.util.Date;

import com.arm.mbed.cloud.sdk.annotations.Internal;
import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.common.SdkModel;

@Preamble(description = "An audit history entry for billing entities")
public class QuotaHistory implements SdkModel {
    /**
     * Serialisation Id.
     */
    private static final long serialVersionUID = -3797353685003557513L;
    private String id;
    private final Date createdAt;
    private final long delta;
    private final String reason;
    private final BillingEntity reference;

    /**
     * Internal Constructor.
     *
     * @param id
     *            id
     * @param createdAt
     *            createdAt
     * @param delta
     *            delta
     * @param reason
     *            reason
     * @param ref
     *            reference
     */
    @Internal
    public QuotaHistory(String id, Date createdAt, long delta, String reason, BillingEntity ref) {
        super();
        this.id = id;
        this.createdAt = createdAt;
        this.delta = delta;
        this.reason = reason;
        this.reference = ref;

    }

    /**
     * Constructor.
     */
    public QuotaHistory() {
        this(null, new Date(), 0l, null, null);
    }

    /**
     * Gets the ID;
     *
     * @return the id
     */
    @Override
    public String getId() {
        return id;
    }

    /**
     * Gets when this entry was created.
     *
     * @return the createdAt
     */
    public Date getCreatedAt() {
        return createdAt;
    }

    /**
     * Gets the change in remaining value, at the time this entry was created
     * <p>
     * Note: Negative values mean the remaining amount has been reduced.
     * <p>
     * for example, a reservation caused by starting a campaign.
     *
     * @return the delta
     */
    public long getDelta() {
        return delta;
    }

    /**
     * Gets the reason why this entry was created.
     *
     * @return the reason
     */
    public String getReason() {
        return reason;
    }

    /**
     * Gets the campaign reservation that this entry refers to
     *
     * @return the reservation
     */
    public Reservation getReservation() {
        return reference instanceof Reservation ? (Reservation) reference : null;
    }

    /**
     * Gets the service package that this entry refers to
     *
     * @return the servicePackage
     */
    public ServicePackage getServicePackage() {
        return reference instanceof ServicePackage ? (ServicePackage) reference : null;
    }

    /**
     * Gets the reference of this quota action.
     *
     * @return the reference
     */
    public BillingEntity getReference() {
        return reference;
    }

    /**
     * Sets the ID.
     *
     * @param id
     *            the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    @Override
    public QuotaHistory clone() {
        return new QuotaHistory(id, createdAt, delta, reason, reference == null ? null : reference.clone());
    }

    @Override
    public boolean isValid() {
        return true;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "QuotaHistory [id=" + id + ", createdAt=" + createdAt + ", delta=" + delta + ", reason=" + reason
                + ", reference=" + reference + "]";
    }

}
