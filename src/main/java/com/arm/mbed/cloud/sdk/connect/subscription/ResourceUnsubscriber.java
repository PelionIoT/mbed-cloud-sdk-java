package com.arm.mbed.cloud.sdk.connect.subscription;

import java.util.List;

import com.arm.mbed.cloud.sdk.common.AbstractApi;
import com.arm.mbed.cloud.sdk.common.MbedCloudException;
import com.arm.mbed.cloud.sdk.common.listing.FilterOptions;
import com.arm.mbed.cloud.sdk.connect.adapters.PresubscriptionAdapter;
import com.arm.mbed.cloud.sdk.connect.model.Presubscription;
import com.arm.mbed.cloud.sdk.subscribe.model.SubscriptionFilterOptions;

public class ResourceUnsubscriber extends AbstractSubscriptionAction {

    public ResourceUnsubscriber(AbstractApi api) {
        super(api);
    }

    @Override
    public void execute(FilterOptions arg) throws MbedCloudException {
        final SubscriptionFilterOptions filters = (SubscriptionFilterOptions) arg;
        // deleting pre-subscriptions
        final List<Presubscription> correspondingPresubscriptions = PresubscriptionAdapter
                .mapSubscriptionFilter(filters);
        api.deleteSomePresubscriptions(correspondingPresubscriptions);

    }
}
