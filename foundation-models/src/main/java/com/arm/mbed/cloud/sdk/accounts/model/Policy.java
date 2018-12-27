// This file was generated by the Pelion SDK foundation code generator.
// This model class was autogenerated on Thu Dec 27 16:49:07 GMT 2018. Feel free to change its contents as you wish.
package com.arm.mbed.cloud.sdk.accounts.model;

import com.arm.mbed.cloud.sdk.annotations.Internal;
import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.common.NotImplementedException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;

/**
 * Model for a policy. */
@Preamble(
    description = "Model for a policy."
)
public class Policy extends AbstractPolicy {
  /**
   * Serialisation Id. */
  private static final long serialVersionUID = -169110117416151L;

  /**
   * Internal constructor.
   * <p>
   * Note: Should not be used. Use {@link #Policy()} instead.
   * @param action Comma separated list of actions, empty string represents all actions.
   * @param allow True or false controlling whether an action is allowed or not.
   * @param feature Feature name corresponding to this policy.
   * @param inherited Flag indicating whether this feature is inherited or overwritten specifically.
   * @param resource Resource that is protected by this policy.
   */
  @Internal
  public Policy(String action, boolean allow, String feature, boolean inherited, String resource) {
    super(action,
        allow,
        feature,
        inherited,
        resource);
  }

  /**
   * Internal constructor.
   * <p>
   * Note: Should not be used. Use {@link #Policy()} instead.
   * @param policy a policy.
   */
  @Internal
  public Policy(Policy policy) {
    this(policy == null ? (String) null : policy.action,
        policy == null ? false : policy.allow,
        policy == null ? (String) null : policy.feature,
        policy == null ? false : policy.inherited,
        policy == null ? (String) null : policy.resource);
  }

  /**
   * Constructor.
   */
  public Policy() {
    this((String) null,
        false,
        (String) null,
        false,
        (String) null);
  }

  /**
   * @return something
   */
  @Override
  public String getId() throws NotImplementedException {
    // TODO Auto-generated method stub.;
    throw new NotImplementedException();
  }

  /**
   * @param id a string.
   */
  @Override
  public void setId(String id) throws NotImplementedException {
    // TODO Auto-generated method stub.;
    throw new NotImplementedException();
  }

  /**
   * Indicates whether some other object is "equal to" this one.
   * <p>
   * @see java.lang.Object#equals(java.lang.Object)
   * @param obj an object to compare with this instance.
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
    if (getClass() != obj.getClass())  {
      return false;
    }
    if (!super.equals(obj))  {
      return false;
    }
    return true;
  }

  /**
   * Returns a string representation of the object.
   * <p>
   * @see java.lang.Object#toString()
   * @return the string representation
   */
  @Override
  public String toString() {
    return "Policy [action=" + action
        + ", allow=" + allow
        + ", feature=" + feature
        + ", inherited=" + inherited
        + ", resource=" + resource + "]";
  }

  /**
   * Checks whether the model is valid or not.
   * <p>
   * @see SdkModel#isValid()
   * @return true if the model is valid; false otherwise.
   */
  @Override
  public boolean isValid() {
    return super.isValid();
  }

  /**
   * Clones this instance.
   * <p>
   * @see java.lang.Object#clone()
   * @return a cloned instance
   */
  @Override
  public Policy clone() {
    return new Policy(this);
  }
}
