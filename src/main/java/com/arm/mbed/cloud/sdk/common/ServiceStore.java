package com.arm.mbed.cloud.sdk.common;

import java.util.concurrent.ConcurrentHashMap;

import com.arm.mbed.cloud.sdk.annotations.Internal;
import com.arm.mbed.cloud.sdk.annotations.Preamble;

@Preamble(description = "Store of created services")
@Internal
public class ServiceStore {

    private final ConcurrentHashMap<Class<?>, Object> store;
    private final ApiClientWrapper client;

    /**
     * Constructor.
     *
     * @param client
     *            client to use.
     */
    public ServiceStore(ApiClientWrapper client) {
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

    protected <S> void createService(Class<S> serviceClass) {
        final S service = client.createService(serviceClass);
        if (service != null) {
            store.putIfAbsent(serviceClass, service);
        }
    }

    @SuppressWarnings("unchecked")
    protected <S> S getServiceFromStore(Class<S> serviceClass) {
        return (S) store.get(serviceClass);
    }

}
