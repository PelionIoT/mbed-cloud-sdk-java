package com.arm.mbed.cloud.sdk.testserver.cache;

import java.util.ArrayList;
import java.util.List;

import io.vertx.core.shareddata.LocalMap;
import io.vertx.core.shareddata.SharedData;

import com.arm.mbed.cloud.sdk.testserver.internal.model.TestedItem;
import com.arm.mbed.cloud.sdk.testserver.internal.model.TestedItemInstance;

public class AbstractInstanceCache<T extends TestedItem> implements InstanceCache<T> {

    private final LocalMap<String, TestedItemInstance<T>> map;
    private final String reference;

    public AbstractInstanceCache(String reference, SharedData cache) throws ServerCacheException {
        if (cache == null) {
            throw new ServerCacheException("Instance cache is empty");
        }
        if (reference == null) {
            throw new ServerCacheException("Instance reference cannot be NULL");
        }
        map = cache.getLocalMap(reference);
        this.reference = reference;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.arm.mbed.cloud.sdk.testserver.cache.InstanceCache#fetchInstance(java.lang.String)
     */
    @Override
    public TestedItemInstance<T> fetchInstance(String id) throws MissingInstanceException {
        if (id == null) {
            throw new MissingInstanceException("An instance id cannot be NULL");
        }
        TestedItemInstance<T> instance = map.get(id);
        if (instance == null) {
            throw new MissingInstanceException("No instance [" + id
                                               + "] was found in the cache for instance reference [" + reference + "]");
        }
        return instance;
    }

    @Override
    public List<TestedItemInstance<?>> fetchAllInstances() {
        return new ArrayList<>(map.values());
    }

    @SuppressWarnings("unchecked")
    @Override
    public void storeInstance(TestedItemInstance<?> instance) throws ServerCacheException {
        if (instance == null || !instance.isValid()) {
            throw new ServerCacheException("Instance [" + instance + "] cannot be stored as invalid");
        }
        try {
            map.put(instance.getId(), (TestedItemInstance<T>) instance);
        } catch (Exception exception) {
            throw new ServerCacheException("Instance [" + instance + "] cannot be stored as invalid", exception);
        }
    }

    @Override
    public void deleteInstance(String id) throws MissingInstanceException {
        if (id == null) {
            throw new MissingInstanceException("An instance id cannot be NULL");
        }
        map.remove(id);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.arm.mbed.cloud.sdk.testserver.cache.InstanceCache#getReference()
     */
    @Override
    public String getReference() {
        return reference;
    }

    @Override
    public void clear() {
        map.clear();
    }

}
