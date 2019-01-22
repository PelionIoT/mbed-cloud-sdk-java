package com.arm.mbed.cloud.sdk.testserver.cache;

import java.util.ArrayList;
import java.util.List;

import io.vertx.core.shareddata.LocalMap;
import io.vertx.core.shareddata.SharedData;

import com.arm.mbed.cloud.sdk.testserver.internal.model.AbstractInstance;

public class InstanceCache<T extends AbstractInstance> {

    private final LocalMap<String, T> map;
    private final String reference;

    public InstanceCache(String reference, SharedData cache) throws ServerCacheException {
        if (cache == null) {
            throw new ServerCacheException("Instance cache is empty");
        }
        if (reference == null) {
            throw new ServerCacheException("Instance reference cannot be NULL");
        }
        map = cache.getLocalMap(reference);
        this.reference = reference;
    }

    public T fetchInstance(String id) throws MissingInstanceException {
        if (id == null) {
            throw new MissingInstanceException("An instance id cannot be NULL");
        }
        T instance = map.get(id);
        if (instance == null) {
            throw new MissingInstanceException("No instance [" + id
                                               + "] was found in the cache for instance reference [" + reference + "]");
        }
        return instance;
    }

    List<T> fetchAllInstances() {
        return new ArrayList<>(map.values());
    }

    void storeModuleInstance(T instance) throws ServerCacheException {
        if (instance == null || !instance.isValid()) {
            throw new ServerCacheException("Instance [" + instance + "] cannot be stored as invalid");
        }
        map.put(instance.getId(), instance);
    }

    void deleteInstance(String id) throws MissingInstanceException {
        if (id == null) {
            throw new MissingInstanceException("An instance id cannot be NULL");
        }
        map.remove(id);
    }

    public String getReference() {
        return reference;
    }

    void clear() {
        map.clear();
    }

}
