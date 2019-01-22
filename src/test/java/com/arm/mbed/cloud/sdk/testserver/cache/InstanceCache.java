package com.arm.mbed.cloud.sdk.testserver.cache;

import java.util.ArrayList;
import java.util.List;

import com.arm.mbed.cloud.sdk.testserver.internal.model.AbstractInstance;
import com.arm.mbed.cloud.sdk.testserver.internal.model.ModuleInstance;

import io.vertx.core.shareddata.LocalMap;
import io.vertx.core.shareddata.SharedData;

public class InstanceCache {

    private final LocalMap<String, ModuleInstance> map;
    private final String moduleId;

    public InstanceCache(String module, SharedData cache) throws ServerCacheException {
        if (cache == null) {
            throw new ServerCacheException("Instance cache is empty");
        }
        if (module == null) {
            throw new ServerCacheException("Module cannot be Null");
        }
        map = cache.getLocalMap(module);
        moduleId = module;
    }

    AbstractInstance fetchInstance(String id) throws MissingInstanceException {
        if (id == null) {
            throw new MissingInstanceException("An instance id cannot be NULL");
        }
        AbstractInstance instance = map.get(id);
        if (instance == null) {
            throw new MissingInstanceException("No instance [" + id + "] was found in the cache for module [" + moduleId
                                               + "]");
        }
        return instance;
    }

    List<ModuleInstance> fetchAllInstances() {
        return new ArrayList<>(map.values());
    }

    void storeModuleInstance(ModuleInstance instance) throws ServerCacheException {
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

    /**
     * @return the moduleId
     */
    public String getModuleId() {
        return moduleId;
    }

    void clear() {
        map.clear();
    }

}
