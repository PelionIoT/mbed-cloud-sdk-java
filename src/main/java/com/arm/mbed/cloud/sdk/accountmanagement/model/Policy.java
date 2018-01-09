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
     * Gets policy Id.
     * 
     * @return the policy id.
     */
    @Internal
    @Override
    public String getId() {
        return getFeature();
    }

    /**
     * States whether an action is allowed or not.
     * 
     * @return True is action is allowed. False otherwise.
     */
    public boolean isAllow() {
        return allow;
    }

    /**
     * Controls whether an action is allowed or not.
     * 
     * @param allow
     *            True is action is allowed. False otherwise.
     */
    public void setAllow(boolean allow) {
        this.allow = allow;
    }

    /**
     * Gets comma separated list of actions related to this policy.
     * <p>
     * Empty string represents all actions.
     * 
     * @return comma separated list of actions
     */
    public String getAction() {
        return action;
    }

    /**
     * Gets the resource that is protected by this policy.
     * 
     * @return the resource
     */
    public String getResource() {
        return resource;
    }

    /**
     * Gets the feature name corresponding to this policy.
     * 
     * @return the feature name.
     */
    public String getFeature() {
        return feature;
    }

    /**
     * Gets a clone.
     *
     * @return a clone of this policy.
     *
     * @see java.lang.Object#clone()
     */
    @Override
    public Policy clone() {
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
