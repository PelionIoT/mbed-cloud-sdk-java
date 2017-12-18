package com.arm.mbed.cloud.sdk.common;

import java.io.Serializable;

import com.arm.mbed.cloud.sdk.annotations.Preamble;

@Preamble(description = "SDK Model object")
public interface SdkModel extends Serializable, Cloneable {
    /**
     * Clones the model object.
     * 
     * @return a clone.
     * @throws CloneNotSupportedException
     *             is raised if an error occurs during cloning.
     */
    Object clone() throws CloneNotSupportedException;

    /**
     * Determines whether the model instance is valid i.e. all required fields have been set.
     * 
     * @return true if instance is valid. False otherwise.
     */
    boolean isValid();

}
