package com.arm.mbed.cloud.sdk.connect.subscription;

import java.util.List;

import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.common.AbstractApi;
import com.arm.mbed.cloud.sdk.common.MbedCloudException;
import com.arm.mbed.cloud.sdk.common.listing.FilterOptions;
import com.arm.mbed.cloud.sdk.connect.adapters.PresubscriptionAdapter;
import com.arm.mbed.cloud.sdk.connect.model.Presubscription;
import com.arm.mbed.cloud.sdk.subscribe.model.FirstValue;
import com.arm.mbed.cloud.sdk.subscribe.model.SubscriptionFilterOptions;

@Preamble(description = "Object in charge of performing all necessary action to take place when unsubscribing to a resource")
public class ResourceUnsubscriber extends AbstractSubscriptionAction {

    public ResourceUnsubscriber(AbstractApi api, FirstValue mode) {
        super(api, mode);
    }

    @Override
    public void execute(FilterOptions arg) throws MbedCloudException {
        final SubscriptionFilterOptions filters = (SubscriptionFilterOptions) arg;
        // deleting pre-subscriptions
        final List<Presubscription> correspondingPresubscriptions = PresubscriptionAdapter
                .mapSubscriptionFilter(filters);
        api.deleteSomePresubscriptions(correspondingPresubscriptions);
        // Subscriptions are not deleted because other observers may be subscribing to similar resources

    }

    @Override
    public ResourceUnsubscriber clone() {
        return new ResourceUnsubscriber(api, mode);
    }
}
