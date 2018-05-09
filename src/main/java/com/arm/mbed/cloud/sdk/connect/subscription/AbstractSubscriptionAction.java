package com.arm.mbed.cloud.sdk.connect.subscription;

import com.arm.mbed.cloud.sdk.Connect;
import com.arm.mbed.cloud.sdk.annotations.Internal;
import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.common.AbstractApi;
import com.arm.mbed.cloud.sdk.subscribe.model.FirstValue;
import com.arm.mbed.cloud.sdk.subscribe.store.SubscriptionAction;

@Preamble(description = "Generic definition of subscription action")
@Internal
public abstract class AbstractSubscriptionAction implements SubscriptionAction {

    protected final Connect api;
    protected FirstValue mode;

    public AbstractSubscriptionAction(AbstractApi api, FirstValue mode) {
        super();
        this.api = (Connect) api;
        this.mode = mode;
    }

    /**
     * Sets the first value mode.
     *
     * @see {@link FirstValue}
     * @param mode
     *            the mode to set
     */
    @Override
    public void setMode(FirstValue mode) {
        this.mode = mode;
    }

    /**
     * Sets the first value mode.
     *
     * @see {@link FirstValue}
     * @param aMode
     *            the mode to set
     */
    @Override
    public SubscriptionAction mode(FirstValue aMode) {
        setMode(aMode);
        return this;
    }

    /**
     * States whether a connection to the Cloud was set up or not.
     *
     * @return true if a cloud connection was set up. False otherwise.
     */
    public boolean hasCloudConnection() {
        return api != null;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#clone()
     */
    @Override
    public abstract SubscriptionAction clone();

}
