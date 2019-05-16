package com.arm.mbed.cloud.sdk.connect.subscription;

import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.common.AbstractModule;
import com.arm.mbed.cloud.sdk.common.MbedCloudException;
import com.arm.mbed.cloud.sdk.common.listing.FilterOptions;
import com.arm.mbed.cloud.sdk.subscribe.model.FirstValue;

@Preamble(description = "Object in charge of performing all necessary actions for unsubscribing all resources")
public class ResourceUnsubscriberAll extends AbstractSubscriptionAction {

    public ResourceUnsubscriberAll(AbstractModule module, FirstValue mode) {
        super(module, mode);
    }

    @Override
    public void execute(FilterOptions arg) throws MbedCloudException {
        if (!hasCloudConnection()) {
            return;
        }
        module.deletePresubscriptions();
        // FIXME Subscriptions are not deleted because it is currently a potentially really expensive process.
        // if (mode == FirstValue.IMMEDIATELY) {
        // module.deleteSubscriptions();
        // }
    }

    @Override
    public ResourceUnsubscriberAll clone() {
        return new ResourceUnsubscriberAll(module, mode);
    }
}
