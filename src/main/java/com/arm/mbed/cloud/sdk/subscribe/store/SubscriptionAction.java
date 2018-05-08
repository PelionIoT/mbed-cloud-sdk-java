package com.arm.mbed.cloud.sdk.subscribe.store;

import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.common.CallbackWithException;
import com.arm.mbed.cloud.sdk.common.MbedCloudException;
import com.arm.mbed.cloud.sdk.common.listing.FilterOptions;
import com.arm.mbed.cloud.sdk.subscribe.model.FirstValue;

@Preamble(description = "Action performed during the subscription process")
public interface SubscriptionAction extends CallbackWithException<FilterOptions, MbedCloudException>, Cloneable {
    /**
     * Clones this action.
     *
     * @return a clone of this action
     */
    SubscriptionAction clone();

    /**
     * Sets the first value mode.
     *
     * @see {@link FirstValue}
     * @param aMode
     *            the mode to set
     * @return this action
     */
    SubscriptionAction mode(FirstValue aMode);

    /**
     * Sets the first value mode.
     *
     * @see {@link FirstValue}
     * @param aMode
     *            the mode to set
     */
    void setMode(FirstValue mode);

}
