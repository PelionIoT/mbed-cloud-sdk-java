package com.arm.mbed.cloud.sdk.common;

import java.io.Serializable;

import com.arm.mbed.cloud.sdk.annotations.Preamble;

@Preamble(description = "SDK Model object")
public interface SdkModel extends Serializable, Cloneable {
    /**
     * Clones the model object.
     *
     * @return a clone.
     */
    SdkModel clone();

    /**
     * Determines whether the model instance is valid i.e. all required fields have been set.
     *
     * @return true if instance is valid. False otherwise.
     */
    boolean isValid();

    /**
     * Gets model id.
     *
     * @return the id of the object as a String.
     */
    String getId();

    /**
     * Sets the model id.
     * <p>
     * Warning: for some models, it might not be possible to set the identifier and therefore, this method may result in
     * not doing anything.
     *
     * @param id
     *            model identifier
     */
    void setId(String id);

}
