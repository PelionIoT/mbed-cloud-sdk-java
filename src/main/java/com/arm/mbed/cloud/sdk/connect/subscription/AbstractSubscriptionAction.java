package com.arm.mbed.cloud.sdk.connect.subscription;

import com.arm.mbed.cloud.sdk.Connect;
import com.arm.mbed.cloud.sdk.annotations.Internal;
import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.common.AbstractModule;
import com.arm.mbed.cloud.sdk.subscribe.model.FirstValue;
import com.arm.mbed.cloud.sdk.subscribe.store.SubscriptionAction;

@Preamble(description = "Generic definition of subscription action")
@Internal
public abstract class AbstractSubscriptionAction implements SubscriptionAction {

    protected final Connect module;
    protected FirstValue mode;

    /**
     * Constructor.
     *
     * @param module
     *            Connect API instance
     * @param mode
     *            mode
     */
    public AbstractSubscriptionAction(AbstractModule module, FirstValue mode) {
        super();
        this.module = (Connect) module;
        this.mode = mode;
    }

    /**
     * Sets the first value mode.
     *
     * @see FirstValue
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
     * @see FirstValue
     * @param firstValueMode
     *            the mode to set
     */
    @Override
    public SubscriptionAction mode(FirstValue firstValueMode) {
        setMode(firstValueMode);
        return this;
    }

    /**
     * States whether a connection to the Cloud was set up or not.
     *
     * @return true if a cloud connection was set up. False otherwise.
     */
    public boolean hasCloudConnection() {
        return module != null;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#clone()
     */
    @Override
    public abstract SubscriptionAction clone();

}
