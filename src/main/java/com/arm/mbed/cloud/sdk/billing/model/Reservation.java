package com.arm.mbed.cloud.sdk.billing.model;

import com.arm.mbed.cloud.sdk.annotations.Internal;
import com.arm.mbed.cloud.sdk.annotations.Preamble;

@Preamble(description = "Model for billing reservation")
/**
 * Before a firmware update campaign can be started, the customer has to have enough quota. Firmware update service
 * tries to do a quota reservation to mbed-billing service with the campaign size. Quota reservation reserves some
 * number of firmware updates for that particular campaign and subtracts it from the customer's available quota. Only
 * after successful reservation the firmware update campaign can start. Customer can have multiple firmware update
 * campaigns simultaneously and thus have multiple reservations.
 *
 */
public class Reservation extends BillingEntity {
    /**
     * Serialisation Id.
     */
    private static final long serialVersionUID = -1798436673224523170L;

    private final String accountId;
    private final String campaignName;

    /**
     * Internal constructor.
     *
     * @param id
     *            id
     * @param campaignName
     *            campaignName
     * @param accountId
     *            accountID
     */
    @Internal
    public Reservation(String id, String campaignName, String accountId) {
        super(id);
        this.accountId = accountId;
        this.campaignName = campaignName;
    }

    /**
     * Constructor.
     */
    public Reservation() {
        this(null, null, null);
    }

    /**
     * Gets corresponding account ID.
     *
     * @return the accountId
     */
    public String getAccountId() {
        return accountId;
    }

    /**
     * Gets corresponding campaign name.
     * <p>
     * Textual campaign name for this reservation
     *
     * @return the campaignName
     */
    public String getCampaignName() {
        return campaignName;
    }

    @Override
    public Reservation clone() {
        return new Reservation(accountId, campaignName, accountId);
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
        result = prime * result + ((accountId == null) ? 0 : accountId.hashCode());
        result = prime * result + ((campaignName == null) ? 0 : campaignName.hashCode());
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
        final Reservation other = (Reservation) obj;
        if (accountId == null) {
            if (other.accountId != null) {
                return false;
            }
        } else if (!accountId.equals(other.accountId)) {
            return false;
        }
        if (campaignName == null) {
            if (other.campaignName != null) {
                return false;
            }
        } else if (!campaignName.equals(other.campaignName)) {
            return false;
        }
        return true;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "Reservation [accountId=" + accountId + ", campaignName=" + campaignName + "]";
    }

}
