package com.arm.mbed.cloud.sdk.common;

import com.arm.mbed.cloud.sdk.annotations.Internal;
import com.arm.mbed.cloud.sdk.annotations.Preamble;

@Preamble(description = "Generic endpoints")
@Internal
public abstract class AbstractEndpoints implements Cloneable {
    public static final String METHOD_INITIALISE_SERVICE = "initialiseService";
    public static final String METHOD_CLONE_SERVICE_STORE = "getServicesClone";
    private final ServiceRegistry serviceRegistry;

    /**
     * Constructor.
     * 
     * 
     * @param serviceStore
     *            store of created services {@link ServiceRegistry}
     */
    public AbstractEndpoints(ServiceRegistry serviceStore) {
        super();
        this.serviceRegistry = serviceStore;
    }

    /**
     * Gets the store of created services.
     * 
     * @return the store
     */
    public ServiceRegistry getServiceRegistry() {
        return serviceRegistry;
    }

    protected <S> S initialiseService(Class<S> serviceClass) {
        try {
            return serviceRegistry == null ? null : serviceRegistry.getService(serviceClass);
        } catch (MbedCloudException exception) {
            return null;
        }
    }

    protected ConnectionOptions getConfiguration() {
        final ApiClientWrapper client = serviceRegistry.getClient();
        return client == null ? null : client.getConnectionOptions();
    }

    protected ServiceRegistry getRegistryClone() {
        return serviceRegistry == null ? null : serviceRegistry.clone();
    }
}
