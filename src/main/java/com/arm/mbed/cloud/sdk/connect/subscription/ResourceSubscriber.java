package com.arm.mbed.cloud.sdk.connect.subscription;

import java.util.List;

import io.reactivex.BackpressureStrategy;
import io.reactivex.functions.Consumer;

import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.common.AbstractModule;
import com.arm.mbed.cloud.sdk.common.MbedCloudException;
import com.arm.mbed.cloud.sdk.common.listing.FilterOptions;
import com.arm.mbed.cloud.sdk.common.listing.Paginator;
import com.arm.mbed.cloud.sdk.connect.adapters.PresubscriptionAdapter;
import com.arm.mbed.cloud.sdk.connect.model.Presubscription;
import com.arm.mbed.cloud.sdk.connect.model.Resource;
import com.arm.mbed.cloud.sdk.devices.model.Device;
import com.arm.mbed.cloud.sdk.devices.model.DeviceListDao;
import com.arm.mbed.cloud.sdk.subscribe.adapters.DeviceListOptionsAdapter;
import com.arm.mbed.cloud.sdk.subscribe.model.AsynchronousResponseNotification;
import com.arm.mbed.cloud.sdk.subscribe.model.AsynchronousResponseObserver;
import com.arm.mbed.cloud.sdk.subscribe.model.FirstValue;
import com.arm.mbed.cloud.sdk.subscribe.model.SubscriptionFilterOptions;

@Preamble(description = "Object in charge of performing all necessary actions which need to take place when subscribing to a resource")
public class ResourceSubscriber extends AbstractSubscriptionAction {
    private DeviceListDao listDao;

    public ResourceSubscriber(AbstractModule module, FirstValue mode) {
        super(module, mode);
        try {
            listDao = new DeviceListDao(module);
        } catch (@SuppressWarnings("unused") MbedCloudException exception) {
            listDao = null;
        }
    }

    @Override
    public void execute(FilterOptions arg) throws MbedCloudException {
        if (!hasCloudConnection()) {
            return;
        }
        final SubscriptionFilterOptions filters = (SubscriptionFilterOptions) arg;
        // Setting pre-subscriptions
        final List<Presubscription> correspondingPresubscriptions = PresubscriptionAdapter.mapSubscriptionFilter(filters);
        module.addSomePresubscriptions(correspondingPresubscriptions);
        // Subscribe to currently connected devices
        if (listDao == null) {
            return;
        }
        if (mode == FirstValue.ON_VALUE_UPDATE || mode == FirstValue.IMMEDIATELY) {
            final Paginator<Device> iterator = listDao.paginator(DeviceListOptionsAdapter.mapSubscriptionOptions(filters));
            while (iterator.hasNext()) {
                final List<Resource> resourcesToObserve = filters.getVerifiedResources(module.listObservableResources(iterator.next()));
                module.addResourcesSubscription(resourcesToObserve);
                if (mode == FirstValue.IMMEDIATELY) {
                    for (final Resource resourceToObserve : resourcesToObserve) {
                        requestCurrentResourceValue(resourceToObserve);
                    }
                }
            }
        }

    }

    private void requestCurrentResourceValue(final Resource resourceToObserve) {
        try {
            final AsynchronousResponseObserver observer = module.createCurrentResourceValueObserver(resourceToObserve,
                                                                                                    BackpressureStrategy.BUFFER);
            observer.singleNotification(null).doOnError(new Consumer<Throwable>() {

                @Override
                public void accept(Throwable exception) throws Exception {
                    module.getLogger().logError("Could not fetch the current value of " + resourceToObserve, exception);

                }
            }).subscribe(new Consumer<AsynchronousResponseNotification>() {

                @Override
                public void accept(AsynchronousResponseNotification notification) throws Exception {
                    module.getLogger().logDebug("The following asynchronous response was received: " + notification);
                    observer.unsubscribe();
                }
            });
        } catch (MbedCloudException exception) {
            module.getLogger().logError("Could not fetch the current value of " + resourceToObserve, exception);
        }
    }

    @Override
    public ResourceSubscriber clone() {
        return new ResourceSubscriber(module, mode);
    }

}
