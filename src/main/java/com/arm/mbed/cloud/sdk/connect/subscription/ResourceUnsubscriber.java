package com.arm.mbed.cloud.sdk.connect.subscription;

import java.util.List;

import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.common.AbstractModule;
import com.arm.mbed.cloud.sdk.common.MbedCloudException;
import com.arm.mbed.cloud.sdk.common.listing.FilterOptions;
import com.arm.mbed.cloud.sdk.connect.adapters.PresubscriptionAdapter;
import com.arm.mbed.cloud.sdk.connect.model.Presubscription;
import com.arm.mbed.cloud.sdk.subscribe.model.FirstValue;
import com.arm.mbed.cloud.sdk.subscribe.model.SubscriptionFilterOptions;

@Preamble(description = "Object in charge of performing all necessary action to take place when unsubscribing to a resource")
public class ResourceUnsubscriber extends AbstractSubscriptionAction {

    public ResourceUnsubscriber(AbstractModule module, FirstValue mode) {
        super(module, mode);
    }

    @Override
    public void execute(FilterOptions arg) throws MbedCloudException {
        if (!hasCloudConnection()) {
            return;
        }
        final SubscriptionFilterOptions filters = (SubscriptionFilterOptions) arg;
        // deleting pre-subscriptions
        final List<Presubscription> correspondingPresubscriptions = PresubscriptionAdapter.mapSubscriptionFilter(filters);
        module.deleteSomePresubscriptions(correspondingPresubscriptions);
        // Subscriptions are not deleted because other observers may be subscribing to similar resources

    }

    @Override
    public ResourceUnsubscriber clone() {
        return new ResourceUnsubscriber(module, mode);
    }
}
