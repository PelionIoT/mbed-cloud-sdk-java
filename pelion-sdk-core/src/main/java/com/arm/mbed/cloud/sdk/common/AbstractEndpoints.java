package com.arm.mbed.cloud.sdk.common;

import com.arm.mbed.cloud.sdk.annotations.Internal;
import com.arm.mbed.cloud.sdk.annotations.Preamble;

@Preamble(description = "Generic endpoints")
@Internal
public abstract class AbstractEndpoints implements Cloneable {

    private final ServiceStore serviceStore;

    /**
     * Constructor.
     * 
     * 
     * @param serviceStore
     *            store of created services {@link ServiceStore}
     */
    public AbstractEndpoints(ServiceStore serviceStore) {
        super();
        this.serviceStore = serviceStore;
    }

    /**
     * Gets the store of created services.
     * 
     * @return the store
     */
    public ServiceStore getServiceStore() {
        return serviceStore;
    }

    protected <S> S initialiseService(Class<S> serviceClass) {
        try {
            return serviceStore == null ? null : serviceStore.getService(serviceClass);
        } catch (MbedCloudException exception) {
            return null;
        }
    }

    protected ConnectionOptions getConfiguration() {
        final ApiClientWrapper client = serviceStore.getClient();
        return client == null ? null : client.getConnectionOptions();
    }

    protected ServiceStore getServicesClone() {
        return serviceStore == null ? null : serviceStore.clone();
    }
}
