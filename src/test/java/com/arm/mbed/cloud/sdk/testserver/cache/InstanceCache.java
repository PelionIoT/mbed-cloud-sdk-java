package com.arm.mbed.cloud.sdk.testserver.cache;

import java.util.LinkedList;
import java.util.List;

import com.arm.mbed.cloud.sdk.testserver.internal.model.APIMethod;
import com.arm.mbed.cloud.sdk.testserver.internal.model.APIModule;
import com.arm.mbed.cloud.sdk.testserver.internal.model.ModuleInstance;
import com.arm.mbed.cloud.sdk.testserver.internal.model.SDK;

import io.vertx.core.Vertx;
import io.vertx.core.json.JsonObject;
import io.vertx.core.shareddata.LocalMap;
import io.vertx.core.shareddata.SharedData;

public class InstanceCache {

    private static final String MODULES_MAP = "modules";
    private static final String SDK_CACHE = "sdk";
    private static final String INSTANCES_REGISTRY = "instances";
    /**
     * 
     */
    private final SharedData cache;

    public InstanceCache(Vertx vertx) {
        cache = vertx.sharedData();
    }

    public SDK fetchSDK() {
        JsonObject sdkJson = fetchSdkCache().get(SDK_CACHE);
        if (sdkJson == null) {
            return null;
        }
        return sdkJson.mapTo(SDK.class);
    }

    public void storeSDK(SDK sdk) throws ServerCacheException {
        if (sdk == null) {
            throw new ServerCacheException("SDK mapping has failed");
        }
        fetchSdkCache().put(SDK_CACHE, JsonObject.mapFrom(sdk));
    }

    public ModuleInstance fetchInstance(String moduleId, String id) throws ServerCacheException {
        return fetchModuleCache(moduleId).fetchInstance(id);
    }

    public ModuleInstance fetchInstance(String id) throws ServerCacheException {
        String moduleId = fetchInstancesRegistry().get(id);
        return fetchInstance(moduleId, id);
    }

    public List<APIMethod> listInstanceMethods(String instanceId) throws ServerCacheException {
        String moduleId = fetchInstancesRegistry().get(instanceId);
        SDK sdk = fetchSDK();
        if (sdk == null) {
            throw new ServerCacheException("SDK mapping has failed");
        }
        if (moduleId == null) {
            throw new MissingInstanceException("Instance [" + instanceId + "] is invalid");
        }

        APIModule module = sdk.getModule(moduleId);
        if (module == null) {
            return null;
        }
        return module.fetchAllMethod();

    }

    public void storeInstance(ModuleInstance instance) throws ServerCacheException {
        if (instance == null || !instance.isValid()) {
            throw new ServerCacheException("Instance [" + instance + "] cannot be stored, as invalid");
        }
        fetchModuleCache(instance.getModule()).storeModuleInstance(instance);
        fetchModulesCache().put(instance.getModule(), "");
        System.out.println(instance.getId());
        fetchInstancesRegistry().put(instance.getId(), instance.getModule());
    }

    public void deleteInstance(String id) throws ServerCacheException {
        System.out.println(id);
        String moduleId = fetchInstancesRegistry().get(id);
        System.out.println(moduleId);
        deleteInstance(moduleId, id);
    }

    public void deleteInstance(String moduleId, String id) throws ServerCacheException {
        fetchModuleCache(moduleId).deleteInstance(id);
        fetchInstancesRegistry().remove(id);
    }

    public void clearModuleCache(String moduleId) throws ServerCacheException {
        fetchModuleCache(moduleId).clear();
        fetchModulesCache().remove(moduleId);
    }

    public void clear() throws ServerCacheException {
        for (Object moduleId : fetchModulesCache().keySet()) {
            clearModuleCache(moduleId.toString());
        }
        fetchModulesCache().clear();
        fetchInstancesRegistry().clear();
    }

    public List<ModuleInstance> listModuleInstances(String moduleId) throws ServerCacheException {
        return fetchModuleCache(moduleId).fetchAllInstances();
    }

    public List<ModuleInstance> listAllModuleInstances() throws ServerCacheException {
        List<ModuleInstance> list = new LinkedList<>();
        for (Object moduleId : fetchModulesCache().keySet()) {
            final List<ModuleInstance> sublist = listModuleInstances(moduleId.toString());
            list.addAll(sublist);
        }
        System.out.println(list);
        return list;
    }

    private ModuleCache fetchModuleCache(String moduleId) throws ServerCacheException {
        if (moduleId == null) {
            throw new MissingInstanceException("A module cannot be NULL");
        }

        ModuleCache moduleCache = new ModuleCache(moduleId, cache);
        return moduleCache;
    }

    private LocalMap<Object, Object> fetchModulesCache() {
        return cache.getLocalMap(MODULES_MAP);
    }

    private LocalMap<String, String> fetchInstancesRegistry() {
        return cache.getLocalMap(INSTANCES_REGISTRY);
    }

    private LocalMap<Object, JsonObject> fetchSdkCache() {
        return cache.getLocalMap(SDK_CACHE);
    }

}
