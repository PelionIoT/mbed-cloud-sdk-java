package com.arm.mbed.cloud.sdk.billing.model;

import com.arm.mbed.cloud.sdk.annotations.Internal;
import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.common.SdkModel;

@Preamble(description = "An abstract model describing a billing entity")
@Internal
public abstract class BillingEntity implements SdkModel {

    /**
     * Serialisation id.
     */
    private static final long serialVersionUID = -3502564898448216026L;
    protected String id;

    /**
     * Constructor.
     *
     * @param id
     *            id
     */
    public BillingEntity(String id) {
        super();
        setId(id);
    }

    @Override
    public boolean isValid() {
        return true;
    }

    /**
     * Gets the billing entity identifier.
     */
    @Override
    public String getId() {
        return id;
    }

    /**
     * Sets the billing entity ID
     *
     * @param id
     *            the id to set
     */
    public void setId(String id) {
        this.id = id;
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
        result = prime * result + ((id == null) ? 0 : id.hashCode());
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
        final BillingEntity other = (BillingEntity) obj;
        if (id == null) {
            if (other.id != null) {
                return false;
            }
        } else if (!id.equals(other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public abstract BillingEntity clone();

}
