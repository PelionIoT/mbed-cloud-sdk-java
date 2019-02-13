package com.arm.mbed.cloud.sdk.testserver;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import io.vertx.core.json.JsonObject;

import com.arm.mbed.cloud.sdk.common.ApiUtils;
import com.arm.mbed.cloud.sdk.common.ConnectionOptions;
import com.arm.mbed.cloud.sdk.testserver.cache.InvalidInstanceException;
import com.arm.mbed.cloud.sdk.testserver.cache.MissingInstanceException;
import com.arm.mbed.cloud.sdk.testserver.cache.ServerCacheException;
import com.arm.mbed.cloud.sdk.testserver.cache.TestedItemRegistry;
import com.arm.mbed.cloud.sdk.testserver.internal.model.APIMethod;
import com.arm.mbed.cloud.sdk.testserver.internal.model.APIMethodResult;
import com.arm.mbed.cloud.sdk.testserver.internal.model.APIModule;
import com.arm.mbed.cloud.sdk.testserver.internal.model.Entity;
import com.arm.mbed.cloud.sdk.testserver.internal.model.EntityInstance;
import com.arm.mbed.cloud.sdk.testserver.internal.model.FoundationInstance;
import com.arm.mbed.cloud.sdk.testserver.internal.model.ModuleInstance;
import com.arm.mbed.cloud.sdk.testserver.internal.model.Sdk;
import com.arm.mbed.cloud.sdk.testserver.internal.model.SdkDefinition;
import com.arm.mbed.cloud.sdk.testserver.internal.model.SdkInstance;
import com.arm.mbed.cloud.sdk.testserver.internal.model.TestedItem;
import com.arm.mbed.cloud.sdk.testserver.internal.model.TestedItemInstance;
import com.arm.mbed.cloud.sdk.testserver.internal.model.TestedItemType;
import com.arm.mbed.cloud.sdk.testserver.internal.model.UnknownAPIException;
import com.arm.mbed.cloud.sdk.testutils.APICallException;
import com.arm.mbed.cloud.sdk.testutils.APICaller;
import com.arm.mbed.cloud.sdk.testutils.APIMappingGenerator;

public class Engine {

    private final Logger logger;
    private final TestedItemRegistry cache;

    public Engine(Logger logger, TestedItemRegistry cache) {
        this.logger = logger;
        this.cache = cache;
    }

    public void initialise() throws ServerCacheException {
        logger.logInfo("Determining a definition of the Java SDK... (" + new Date().toString() + ")");
        SdkDefinition sdk = APIMappingGenerator.getSDK();
        logger.logDebug(JsonObject.mapFrom(sdk).encodePrettily());
        cache.storeSDKDefinition(sdk);
    }

    public String hello() {
        logger.logInfo("Hello !");
        return "Hello. I am Java Pelion SDK Test server. How can I help?";
    }

    public String ping() {
        logger.logInfo("Received a Ping!  -------------->");
        logger.logInfo("Sending a Pong!   <--------------");
        return "pong";
    }

    public boolean reset() throws ServerCacheException {
        logger.logInfo("Resetting SDK instance cache");
        cache.clear();
        return true;
    }

    public void shutdown() {
        logger.logInfo("Shutting down");
        logger.logInfo("Good bye!");
    }

    public List<String> listModules() {
        logger.logInfo("Retrieving the list of SDK modules");
        SdkDefinition sdk = cache.fetchSDKDefinition();
        if (sdk == null) {
            return null;
        }
        return new ArrayList<>(sdk.fetchItemSet(TestedItemType.MODULE));
    }

    public List<String> listEntities() {
        logger.logInfo("Retrieving the list of SDK entities");
        SdkDefinition sdk = cache.fetchSDKDefinition();
        if (sdk == null) {
            return null;
        }
        return new ArrayList<>(sdk.fetchItemSet(TestedItemType.ENTITY));
    }

    public List<TestedItemInstance<?>> listModuleInstances(String moduleName) throws ServerCacheException {
        logger.logInfo("Retrieving the list of module [" + moduleName + "] instances");
        return cache.listInstances(TestedItemType.MODULE, ApiUtils.convertSnakeToCamel(moduleName, true));
    }

    public List<TestedItemInstance<?>> listEntityInstances(String entityName) throws ServerCacheException {
        logger.logInfo("Retrieving the list of entity [" + entityName + "] instances");
        return cache.listInstances(TestedItemType.ENTITY, ApiUtils.convertSnakeToCamel(entityName, true));
    }

    public List<TestedItemInstance<?>> listSdkInstances() throws ServerCacheException {
        logger.logInfo("Retrieving the list of SDK instances");
        return cache.listInstances(TestedItemType.SDK, ApiUtils.convertSnakeToCamel(SdkInstance.REFERENCE, true));
    }

    public List<TestedItemInstance<?>> listAllLowLevelInstances() throws ServerCacheException {
        logger.logInfo("Retrieving the list of all module instances");
        return cache.listAllInstances(TestedItemType.MODULE);
    }

    public List<TestedItemInstance<?>> listAllFoundationInstances() throws ServerCacheException {
        logger.logInfo("Retrieving the list of all entity instances");
        return cache.listAllInstances(TestedItemType.ENTITY);
    }

    public List<APIMethod> listLowLevelInstanceMethods(String instanceId) throws ServerCacheException {
        TestedItem module = cache.fetchFromInstance(TestedItemType.MODULE, instanceId);
        return (module == null) ? null : module.fetchAllMethod();
    }

    public List<APIMethod> listFoundationInstanceMethods(String instanceId) throws ServerCacheException {
        TestedItem entity = cache.fetchFromInstance(TestedItemType.ENTITY, instanceId);
        return (entity == null) ? null : entity.fetchAllMethod();
    }

    public ModuleInstance createModuleInstance(String moduleName, ConnectionOptions config) throws ServerCacheException,
                                                                                            UnknownAPIException {
        logger.logInfo("Creating an instance of SDK module [" + moduleName + "]");
        String javaModuleId = ApiUtils.convertSnakeToCamel(moduleName, true);
        ModuleInstance instance = new ModuleInstance(javaModuleId, config,
                                                     (APIModule) createAnApiCaller().retrieveDescription(TestedItemType.MODULE,
                                                                                                         javaModuleId));
        logger.logInfo("Host in use: " + instance.getHostInUse());
        checkInstanceValidity(instance);
        cache.storeInstance(TestedItemType.MODULE, instance);
        logger.logInfo("Module [" + moduleName + "] instance [" + instance.getId() + "] was created.");
        return instance;
    }

    public EntityInstance createEntityInstance(String entityName, ConnectionOptions config) throws ServerCacheException,
                                                                                            UnknownAPIException {
        logger.logInfo("Creating an instance of SDK entity [" + entityName + "]");
        String javaModuleId = ApiUtils.convertSnakeToCamel(entityName, true);
        EntityInstance instance = new EntityInstance(javaModuleId, config,
                                                     (Entity) createAnApiCaller().retrieveDescription(TestedItemType.ENTITY,
                                                                                                      javaModuleId));
        logger.logInfo("Host in use: " + instance.getHostInUse());
        checkInstanceValidity(instance);
        cache.storeInstance(TestedItemType.ENTITY, instance);
        logger.logInfo("Entity [" + entityName + "] instance [" + instance.getId() + "] was created.");
        return instance;
    }

    public SdkInstance createSdkInstance(ConnectionOptions config) throws ServerCacheException, UnknownAPIException {
        logger.logInfo("Creating an instance of an SDK");
        SdkInstance instance = new SdkInstance(config,
                                               Sdk.clone(createAnApiCaller().retrieveDescription(TestedItemType.MODULE,
                                                                                                 SdkInstance.REFERENCE)));
        logger.logInfo("Host in use: " + instance.getHostInUse());
        checkInstanceValidity(instance);
        cache.storeInstance(TestedItemType.SDK, instance);
        logger.logInfo("SDK instance [" + instance.getId() + "] was created.");
        return instance;
    }

    public ModuleInstance fetchLowLevelInstance(String instanceId) throws ServerCacheException {
        logger.logInfo("Fetching SDK module instance [" + instanceId + "]");
        return (ModuleInstance) retrieveInstance(TestedItemType.MODULE, instanceId);
    }

    public FoundationInstance<?> fetchFoundationInstance(String instanceId) throws ServerCacheException {
        logger.logInfo("Fetching SDK foundation instance [" + instanceId + "]");
        return (FoundationInstance<?>) retrieveInstance(TestedItemType.ENTITY, instanceId);
    }

    public boolean deleteLowLevelInstance(String instanceId) throws ServerCacheException {
        logger.logInfo("Deleting SDK module instance [" + instanceId + "]");
        stopInstance(TestedItemType.MODULE, instanceId);
        cache.deleteInstance(TestedItemType.MODULE, instanceId);
        return true;
    }

    public boolean deleteFoundationInstance(String instanceId) throws ServerCacheException {
        logger.logInfo("Deleting SDK entity instance [" + instanceId + "]");
        stopInstance(TestedItemType.ENTITY, instanceId);
        cache.deleteInstance(TestedItemType.ENTITY, instanceId);
        return true;
    }

    public APIMethodResult callAPIOnLowLevelInstance(String instanceId, String methodId,
                                                     Map<String, Object> params) throws ServerCacheException,
                                                                                 UnknownAPIException, APICallException {
        return callAPIOnInstance(TestedItemType.MODULE, instanceId, methodId, params);
    }

    public APIMethodResult callAPIOnFoundationInstance(String instanceId, String methodId,
                                                       Map<String, Object> params) throws ServerCacheException,
                                                                                   UnknownAPIException,
                                                                                   APICallException {
        return callAPIOnInstance(TestedItemType.ENTITY, instanceId, methodId, params);
    }

    private APIMethodResult callAPIOnInstance(TestedItemType type, String instanceId, String methodId,
                                              Map<String, Object> params) throws ServerCacheException,
                                                                          UnknownAPIException, APICallException {
        logger.logInfo("CALLING " + String.valueOf(methodId) + "() ON " + String.valueOf(type) + " ["
                       + String.valueOf(instanceId) + "] USING " + String.valueOf(toString(params)));
        return createAnApiCaller().callAPIOnInstance(retrieveInstance(type, instanceId),
                                                     ApiUtils.convertSnakeToCamel(methodId, false), params);
    }

    private void stopInstance(TestedItemType type, String instanceId) throws ServerCacheException,
                                                                      MissingInstanceException {

        TestedItemInstance<?> instance = retrieveInstance(type, instanceId);
        APIMethod closeMethod = APIMethod.getClose();
        APICaller caller = createAnApiCaller();
        logger.logInfo("Closing SDK instance [" + instanceId + "]");
        try {
            caller.callAPIOnInstance(instance, closeMethod.getName(), null);
        } catch (UnknownAPIException | APICallException e) {
            logger.logError("Failed closing the instance: " + e.getMessage());
        }
    }

    private TestedItemInstance<?> retrieveInstance(TestedItemType type, String instanceId) throws ServerCacheException,
                                                                                           InvalidInstanceException {
        TestedItemInstance<?> instance = cache.fetchInstance(type, instanceId);
        checkInstanceValidity(instance);
        return instance;
    }

    private void checkInstanceValidity(TestedItemInstance<?> instance) throws InvalidInstanceException {
        if (!instance.isValid()) {
            throw new InvalidInstanceException("Current instance is invalid (" + instance + ")");
        }
    }

    private APICaller createAnApiCaller() {
        return new APICaller(cache.fetchSDKDefinition());
    }

    private static String toString(Map<String, Object> params) {
        if (params == null) {
            return null;
        }
        StringBuilder builder = new StringBuilder();
        builder.append("{");
        boolean start = true;
        for (Entry<String, Object> pair : params.entrySet()) {
            if (!start) {
                builder.append(", ");
            }
            builder.append(String.valueOf(pair.getKey())).append("=");
            String value = String.valueOf(pair.getValue());
            if (value.length() > 70) {
                value = value.substring(0, 70) + "...";
            }
            builder.append(value);
            start = false;
        }

        builder.append("}");
        return builder.toString();
    }

}
