// This file was generated by the Pelion SDK foundation code generator.
// This model class was autogenerated on Wed Jun 05 19:22:52 UTC 2019. Feel free to change its contents as you wish.
package com.arm.mbed.cloud.sdk.branding.model;

import com.arm.mbed.cloud.sdk.annotations.Internal;
import com.arm.mbed.cloud.sdk.annotations.NotImplemented;
import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.common.NotImplementedException;
import java.util.Date;

/**
 * Model for a dark theme color.
 */
@Preamble(description = "Model for a dark theme color.")
public class DarkThemeColor extends AbstractDarkThemeColor {
    /**
     * Serialisation Id.
     */
    private static final long serialVersionUID = 1509900627411811L;

    /**
     * Internal constructor.
     *
     * <p>
     * Constructor based on all fields.
     * <p>
     * Note: Should not be used. Use {@link #DarkThemeColor()} instead.
     * 
     * @param color
     *            The color given as name (purple) or as a hex code.
     * @param reference
     *            Color name.
     * @param updatedAt
     *            Last update time in UTC.
     */
    @Internal
    public DarkThemeColor(String color, DarkThemeColorReference reference, Date updatedAt) {
        super(color, reference, updatedAt);
    }

    /**
     * Internal constructor.
     *
     * <p>
     * Constructor based on a similar object.
     * <p>
     * Note: Should not be used. Use {@link #DarkThemeColor()} instead.
     * 
     * @param darkThemeColor
     *            a dark theme color.
     */
    @Internal
    public DarkThemeColor(DarkThemeColor darkThemeColor) {
        this(darkThemeColor == null ? (String) null : darkThemeColor.color,
             darkThemeColor == null ? DarkThemeColorReference.getDefault() : darkThemeColor.reference,
             darkThemeColor == null ? new Date() : darkThemeColor.updatedAt);
    }

    /**
     * Constructor.
     */
    public DarkThemeColor() {
        this((String) null, DarkThemeColorReference.getDefault(), new Date());
    }

    /**
     * Internal constructor.
     *
     * <p>
     * Constructor based on read-only fields.
     * <p>
     * Note: Should not be used. Use {@link #DarkThemeColor()} instead.
     * 
     * @param updatedAt
     *            Last update time in UTC.
     */
    @Internal
    public DarkThemeColor(Date updatedAt) {
        this((String) null, DarkThemeColorReference.getDefault(), updatedAt);
    }

    /**
     * Executes setId.
     * 
     * @param id
     *            a string.
     */
    @Override
    @NotImplemented
    public void setId(String id) throws NotImplementedException {
        // TODO Auto-generated method stub.;
        throw new NotImplementedException();
    }

    /**
     * Executes getId.
     * 
     * @return something
     */
    @Override
    @NotImplemented
    public String getId() throws NotImplementedException {
        // TODO Auto-generated method stub.;
        throw new NotImplementedException();
    }

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
        return "DarkThemeColor [color=" + color + ", reference=" + reference + ", updatedAt=" + updatedAt + "]";
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
    @Override
    protected boolean canEqual(Object other) {
        return other instanceof DarkThemeColor;
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
        if (!super.equals(obj)) {
            return false;
        }
        if (!(obj instanceof DarkThemeColor)) {
            return false;
        }
        final DarkThemeColor other = (DarkThemeColor) obj;
        if (!other.canEqual(this)) {
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
        return super.isValid();
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
    public DarkThemeColor clone() {
        return new DarkThemeColor(this);
    }
}
