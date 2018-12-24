package com.arm.mbed.cloud.sdk.common;

import java.util.concurrent.ConcurrentHashMap;

import com.arm.mbed.cloud.sdk.annotations.Internal;
import com.arm.mbed.cloud.sdk.annotations.Preamble;

@Preamble(description = "Store of created services")
@Internal
public class ServiceRegistry implements Cloneable {

    private final ConcurrentHashMap<Class<?>, Object> store;
    private final ApiClientWrapper client;

    /**
     * Constructor.
     *
     * @param client
     *            client to use.
     */
    public ServiceRegistry(ApiClientWrapper client) {
        store = new ConcurrentHashMap<>();
        this.client = client;
    }

    /**
     * Instantiates a service based on its class definition.
     *
     * @param serviceClass
     *            service definition
     * @param <S>
     *            type of the service to call
     * @return corresponding service.
     * @throws MbedCloudException
     *             if parameters are incorrect.
     */
    public <S> S getService(Class<S> serviceClass) throws MbedCloudException {
        if (serviceClass == null) {
            throw new MbedCloudException(new IllegalArgumentException("serviceClass is null"));
        }

        final S service = getServiceFromStore(serviceClass);
        if (service != null) {
            return service;
        }
        createService(serviceClass);
        return getService(serviceClass);

    }

    private <S> void createService(Class<S> serviceClass) throws MbedCloudException {
        if (serviceClass == null) {
            return;
        }
        if (client == null) {
            throw new MbedCloudException("Client was not set properly", new Exception("Cloud client cannot be Null"));
        }
        final S service = client.createService(serviceClass);
        registerService(serviceClass, service);
    }

    /**
     * Registers a service.
     * 
     * @param service
     *            service to register.
     */
    @SuppressWarnings("unchecked")
    public <S> void registerService(S service) {
        registerService((Class<S>) service.getClass(), service);
    }

    /**
     * Registers a service.
     * 
     * @param serviceClass
     *            class of the service to register.
     * @param service
     *            service to register
     */
    public <S> void registerService(Class<S> serviceClass, S service) {
        if (service != null || serviceClass != null) {
            store.putIfAbsent(serviceClass, service);
        }
    }

    /**
     * Clears the service registry.
     */
    public void clear() {
        store.clear();
    }

    @SuppressWarnings("unchecked")
    protected <S> S getServiceFromStore(Class<S> serviceClass) {
        return (S) store.get(serviceClass);
    }

    public ApiClientWrapper getClient() {
        return client;
    }

    @Override
    public ServiceRegistry clone() {
        return new ServiceRegistry(new ApiClientWrapper(getClient()));
    }

}
