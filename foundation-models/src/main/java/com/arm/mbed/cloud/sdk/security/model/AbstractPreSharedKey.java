// This file was generated by the Pelion SDK foundation code generator.
// This is an autogenerated abstract class. Do not modify its contents.
// Code customisation should happen in the child class [PreSharedKey]
package com.arm.mbed.cloud.sdk.security.model;

import com.arm.mbed.cloud.sdk.annotations.Internal;
import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.common.SdkModel;
import java.util.Date;

/**
 * Model for a pre shared key.
 */
@Preamble(description = "Model for a pre shared key.")
public abstract class AbstractPreSharedKey implements SdkModel {
    /**
     * Serialisation Id.
     */
    private static final long serialVersionUID = -115042717712192L;

    /**
     * The date-time (RFC3339) when this PSK was uploaded to Device Management.
     */
    protected final Date createdAt;

    /**
     * Internal constructor.
     *
     * <p>
     * Constructor based on all fields.
     * <p>
     * Note: Should not be used. Use {@link #AbstractPreSharedKey()} instead.
     * 
     * @param createdAt
     *            The date-time (RFC3339) when this PSK was uploaded to Device Management.
     */
    @Internal
    public AbstractPreSharedKey(Date createdAt) {
        super();
        this.createdAt = createdAt;
    }

    /**
     * Internal constructor.
     *
     * <p>
     * Constructor based on a similar object.
     * <p>
     * Note: Should not be used. Use {@link #AbstractPreSharedKey()} instead.
     * 
     * @param abstractPreSharedKey
     *            an abstract pre shared key.
     */
    @Internal
    public AbstractPreSharedKey(AbstractPreSharedKey abstractPreSharedKey) {
        this(abstractPreSharedKey == null ? new Date() : abstractPreSharedKey.createdAt);
    }

    /**
     * Constructor.
     */
    public AbstractPreSharedKey() {
        this(new Date());
    }

    /**
     * Gets the date-time (rfc3339) when this psk was uploaded to device management.
     * 
     * @return createdAt
     */
    public Date getCreatedAt() {
        return createdAt;
    }

    /**
     * Method to ensure {@link #equals(Object)} is correct.
     *
     * <p>
     * Note: see this article: <a href="https://www.artima.com/lejava/articles/equality.html">canEqual()</a>
     * 
     * @param other
     *            another object.
     * @return true if the other object is an instance of the class in which canEqual is (re)defined, false otherwise.
     */
    protected boolean canEqual(Object other) {
        return other instanceof AbstractPreSharedKey;
    }

    /**
     * Clones this instance.
     *
     * <p>
     * 
     * @see java.lang.Object#clone()
     * @return a cloned instance
     */
    @Override
    public abstract Object clone();

    /**
     * Returns a string representation of the object.
     *
     * <p>
     * 
     * @see java.lang.Object#toString()
     * @return the string representation
     */
    @Override
    public String toString() {
        return "AbstractPreSharedKey [createdAt=" + createdAt + "]";
    }

    /**
     * Calculates the hash code of this instance based on field values.
     *
     * <p>
     * 
     * @see java.lang.Object#hashCode()
     * @return hash code
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((createdAt == null) ? 0 : createdAt.hashCode());
        return result;
    }

    /**
     * Indicates whether some other object is "equal to" this one.
     *
     * <p>
     * 
     * @see java.lang.Object#equals(java.lang.Object)
     * @param obj
     *            an object to compare with this instance.
     * @return true if this object is the same as the obj argument; false otherwise.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof AbstractPreSharedKey)) {
            return false;
        }
        final AbstractPreSharedKey other = (AbstractPreSharedKey) obj;
        if (!other.canEqual(this)) {
            return false;
        }
        if (createdAt == null) {
            if (other.createdAt != null) {
                return false;
            }
        } else if (!createdAt.equals(other.createdAt)) {
            return false;
        }
        return true;
    }

    /**
     * Checks whether the model is valid or not.
     *
     * <p>
     * 
     * @see SdkModel#isValid()
     * @return true if the model is valid; false otherwise.
     */
    @Override
    public boolean isValid() {
        return true;
    }
}
