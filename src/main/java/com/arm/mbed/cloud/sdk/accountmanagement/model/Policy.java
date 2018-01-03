package com.arm.mbed.cloud.sdk.accountmanagement.model;

import com.arm.mbed.cloud.sdk.annotations.DefaultValue;
import com.arm.mbed.cloud.sdk.annotations.Internal;
import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.common.SdkModel;

@Preamble(description = "Feature policy")
public class Policy implements SdkModel {

    /**
     * Serialisation Id.
     */
    private static final long serialVersionUID = -505337926801785611L;

    /**
     * 
     * Comma separated list of actions, empty string represents all actions.
     * 
     */

    private final String action;

    /**
     * 
     * Resource that is protected by this policy.
     * 
     */

    public final String resource;

    /**
     * 
     * Feature name corresponding to this policy.
     * 
     */

    public final String feature;

    /**
     * 
     * True or false controlling whether an action is allowed or not.
     * 
     */
    @DefaultValue(value = "false")
    public boolean allow;

    /**
     * Internal constructor.
     * <p>
     * Note: Should not be used. Use {@link #Policy()} instead.
     * 
     * @param action
     *            action
     * @param resource
     *            resource
     * @param feature
     *            feature
     * @param allow
     *            allow
     */
    @Internal
    public Policy(String action, String resource, String feature, boolean allow) {
        super();
        this.action = action;
        this.resource = resource;
        this.feature = feature;
        this.allow = allow;
    }

    /**
     * Constructor.
     */
    public Policy() {
        this(null, null, null, false);
    }

    /**
     * Gets a clone.
     *
     * @return a clone of this policy.
     *
     * @see java.lang.Object#clone()
     */
    @Override
    public Policy clone() throws CloneNotSupportedException {
        return new Policy(action, resource, feature, allow);
    }

    /**
     * Determines whether all required fields have been set and therefore if the model instance is valid.
     *
     * @return true if instance is valid. False otherwise.
     */
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
        return "Policy [action=" + action + ", resource=" + resource + ", feature=" + feature + ", allow=" + allow
                + "]";
    }

}
