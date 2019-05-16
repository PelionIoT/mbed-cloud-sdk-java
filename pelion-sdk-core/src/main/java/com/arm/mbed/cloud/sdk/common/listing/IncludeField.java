package com.arm.mbed.cloud.sdk.common.listing;

import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.common.SdkUtils;

@Preamble(description = "Possible optional fields to request when listing")
public class IncludeField implements Cloneable {
    public static final IncludeField TOTAL_COUNT = new IncludeField("total_count");

    private final String str;

    /**
     * Constructor.
     *
     * @param str
     *            field string
     */
    public IncludeField(String str) {
        this.str = str;
    }

    /**
     * Gets field string.
     *
     * @return string representation.
     */
    @Override
    public String toString() {
        return str;
    }

    /**
     * Encodes include field to snake case.
     *
     * @return processed string.
     */
    public String encode() {
        return SdkUtils.convertCamelToSnake(toString());
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
        result = prime * result + ((str == null) ? 0 : str.hashCode());
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
        if (!(obj instanceof IncludeField)) {
            return false;
        }
        final IncludeField other = (IncludeField) obj;
        if (str == null) {
            if (other.str != null) {
                return false;
            }
        } else if (!str.equals(other.str)) {
            return false;
        }
        return true;
    }

    /**
     * Clones the include field.
     *
     * @return a clone.
     */
    @Override
    public IncludeField clone() {
        return new IncludeField(str);
    }

}
