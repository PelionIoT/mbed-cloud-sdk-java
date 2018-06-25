package com.arm.mbed.cloud.sdk.billing.model;

import java.util.Date;

import com.arm.mbed.cloud.sdk.annotations.Internal;
import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.common.SdkModel;

@Preamble(description = "Model for firmware update quota")
public class ServicePackageQuota implements SdkModel {
    /**
     * Serialisation Id.
     */
    private static final long serialVersionUID = -3797353685003557513L;
    private String id;
    private final Date addedAt;
    private final long amount;

    /**
     * Internal constructor.
     *
     * @param id
     *            id
     * @param addedAt
     *            addedAt
     * @param amount
     *            amount
     */
    @Internal
    public ServicePackageQuota(String id, Date addedAt, long amount) {
        super();
        setId(id);
        this.addedAt = addedAt;
        this.amount = amount;
    }

    /**
     * Internal constructor
     *
     * @param amount
     *            quota amount
     */
    @Internal
    public ServicePackageQuota(long amount) {
        this(null, new Date(), amount);
    }

    /**
     * Constructor.
     */
    public ServicePackageQuota() {
        this(0);
    }

    /**
     * Gets when the quota was added.
     *
     * @return the addedAt
     */
    public Date getAddedAt() {
        return addedAt;
    }

    /**
     * Gets the quota amount.
     *
     * @return the amount
     */
    public long getAmount() {
        return amount;
    }

    /**
     * Sets the Id.
     *
     * @param id
     *            the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    @Override
    public SdkModel clone() {
        return new ServicePackageQuota(id, addedAt, amount);
    }

    @Override
    public boolean isValid() {
        return true;
    }

    @Override
    public String getId() {
        return id;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "ServicePackageQuota [id=" + id + ", addedAt=" + addedAt + ", amount=" + amount + "]";
    }

}
