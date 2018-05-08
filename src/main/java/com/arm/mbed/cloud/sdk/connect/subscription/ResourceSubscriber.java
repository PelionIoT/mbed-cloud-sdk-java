package com.arm.mbed.cloud.sdk.connect.subscription;

import java.util.List;

import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.common.AbstractApi;
import com.arm.mbed.cloud.sdk.common.MbedCloudException;
import com.arm.mbed.cloud.sdk.common.listing.FilterOptions;
import com.arm.mbed.cloud.sdk.common.listing.Paginator;
import com.arm.mbed.cloud.sdk.connect.adapters.PresubscriptionAdapter;
import com.arm.mbed.cloud.sdk.connect.model.Presubscription;
import com.arm.mbed.cloud.sdk.devicedirectory.adapters.DeviceAdapter;
import com.arm.mbed.cloud.sdk.devicedirectory.model.Device;
import com.arm.mbed.cloud.sdk.subscribe.model.FirstValue;
import com.arm.mbed.cloud.sdk.subscribe.model.SubscriptionFilterOptions;

@Preamble(description = "Object in charge of performing all necessary action to take place when subscribing to a resource")
public class ResourceSubscriber extends AbstractSubscriptionAction {

    public ResourceSubscriber(AbstractApi api, FirstValue mode) {
        super(api, mode);
    }

    @Override
    public void execute(FilterOptions arg) throws MbedCloudException {
        final SubscriptionFilterOptions filters = (SubscriptionFilterOptions) arg;
        // Setting pre-subscriptions
        final List<Presubscription> correspondingPresubscriptions = PresubscriptionAdapter
                .mapSubscriptionFilter(filters);
        api.addSomePresubscriptions(correspondingPresubscriptions);
        // Subscribe to currently connected devices
        if (mode == FirstValue.ON_VALUE_UPDATE) {
            Paginator<Device> iterator = api.listAllConnectedDevices(DeviceAdapter.mapSubscriptionOptions(filters));
            if (iterator == null) {
                return;
            }
            while (iterator.hasNext()) {
                api.addResourcesSubscription(filters.getVerifiedResources(api.listResources(iterator.next())));
            }
        }

    }

    @Override
    public ResourceSubscriber clone() {
        return new ResourceSubscriber(api, mode);
    }

}
