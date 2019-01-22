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
import com.arm.mbed.cloud.sdk.testserver.cache.TestedItemCache;
import com.arm.mbed.cloud.sdk.testserver.internal.model.APIMethod;
import com.arm.mbed.cloud.sdk.testserver.internal.model.APIMethodResult;
import com.arm.mbed.cloud.sdk.testserver.internal.model.APIModule;
import com.arm.mbed.cloud.sdk.testserver.internal.model.AbstractInstance;
import com.arm.mbed.cloud.sdk.testserver.internal.model.ModuleInstance;
import com.arm.mbed.cloud.sdk.testserver.internal.model.SDK;
import com.arm.mbed.cloud.sdk.testserver.internal.model.UnknownAPIException;
import com.arm.mbed.cloud.sdk.testutils.APICallException;
import com.arm.mbed.cloud.sdk.testutils.APICaller;
import com.arm.mbed.cloud.sdk.testutils.APIMappingGenerator;

public class Engine {

    private final Logger logger;
    private final TestedItemCache cache;

    public Engine(Logger logger, TestedItemCache cache) {
        this.logger = logger;
        this.cache = cache;
    }

    public void initialise() throws ServerCacheException {
        logger.logInfo("Initialising Java SDK modules... (" + new Date().toString() + ")");
        SDK sdk = APIMappingGenerator.getSDK();
        logger.logDebug(JsonObject.mapFrom(sdk).encodePrettily());
        cache.storeSDK(sdk);
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
        SDK sdk = cache.fetchSDK();
        if (sdk == null) {
            return null;
        }
        return new ArrayList<>(sdk.fetchModuleSet());
    }

    public List<ModuleInstance> listModuleInstances(String moduleId) throws ServerCacheException {
        logger.logInfo("Retrieving the list of module [" + moduleId + "] instances");
        return cache.listModuleInstances(ApiUtils.convertSnakeToCamel(moduleId, true));
    }

    public List<ModuleInstance> listAllModuleInstances() throws ServerCacheException {
        logger.logInfo("Retrieving the list of all module instances");
        return cache.listAllModuleInstances();
    }

    public List<APIMethod> listInstanceMethods(String instanceId) throws ServerCacheException {
        APIModule module = cache.fetchModuleFromInstance(instanceId);
        return (module == null) ? null : module.fetchAllMethod();
    }

    public ModuleInstance createInstance(String moduleId, ConnectionOptions config) throws ServerCacheException,
                                                                                    UnknownAPIException {
        logger.logInfo("Creating an instance of SDK module [" + moduleId + "]");
        String javaModuleId = ApiUtils.convertSnakeToCamel(moduleId, true);
        ModuleInstance instance = new ModuleInstance(javaModuleId,
                                                     createAnApiCaller().retrieveModuleDescription(javaModuleId),
                                                     config);
        logger.logInfo("Host in use: " + instance.getHostInUse());
        checkInstanceValidity(instance);
        cache.storeModuleInstance(instance);
        logger.logInfo("Module [" + moduleId + "] instance [" + instance.getId() + "] was created.");
        return instance;
    }

    public ModuleInstance fetchInstance(String instanceId) throws ServerCacheException {
        logger.logInfo("Fetching SDK module instance [" + instanceId + "]");
        return retrieveInstance(instanceId);
    }

    public boolean deleteInstance(String instanceId) throws ServerCacheException {
        logger.logInfo("Deleting SDK module instance [" + instanceId + "]");
        stopInstanceDaemons(instanceId);
        cache.deleteModuleInstance(instanceId);
        return true;
    }

    public APIMethodResult callAPIOnInstance(String instanceId, String methodId,
                                             Map<String, Object> params) throws ServerCacheException,
                                                                         UnknownAPIException, APICallException {
        logger.logInfo("CALLING " + String.valueOf(methodId) + " ON " + String.valueOf(instanceId) + " USING "
                       + String.valueOf(toString(params)));
        return createAnApiCaller().callAPIOnModuleInstance(retrieveInstance(instanceId),
                                                           ApiUtils.convertSnakeToCamel(methodId, false), params);
    }

    private void stopInstanceDaemons(String instanceId) throws ServerCacheException, MissingInstanceException {
        APIModule module = cache.fetchModuleFromInstance(instanceId);
        if (module != null) {
            if (module.hasDaemonControlMethods()) {
                ModuleInstance instance = retrieveInstance(instanceId);
                APICaller caller = createAnApiCaller();
                logger.logInfo("Stopping SDK module instance [" + instanceId + "] daemon threads");
                List<APIMethod> stoppingMethods = module.getStopDaemonMethods();
                if (stoppingMethods != null) {
                    stoppingMethods.forEach(m -> {
                        try {
                            caller.callAPIOnModuleInstance(instance, m.getName(), null);
                        } catch (UnknownAPIException | APICallException e) {
                            e.printStackTrace();
                        }
                    });
                }
                logger.logInfo("Shutting down SDK module instance [" + instanceId + "] daemon executor service");
                List<APIMethod> shuttingdownMethods = module.getShutdownDaemonMethods();
                if (shuttingdownMethods != null) {
                    shuttingdownMethods.forEach(m -> {
                        try {
                            caller.callAPIOnModuleInstance(instance, m.getName(), null);
                        } catch (UnknownAPIException | APICallException e) {
                            e.printStackTrace();
                        }
                    });
                }
            }
        }
    }

    private ModuleInstance retrieveInstance(String instanceId) throws ServerCacheException, InvalidInstanceException {
        ModuleInstance instance = cache.fetchModuleInstance(instanceId);
        checkInstanceValidity(instance);
        return instance;
    }

    private void checkInstanceValidity(AbstractInstance instance) throws InvalidInstanceException {
        if (!instance.isValid()) {
            throw new InvalidInstanceException("Current module instance is invalid (" + instance + ")");
        }
    }

    private APICaller createAnApiCaller() {
        return new APICaller(cache.fetchSDK());
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
