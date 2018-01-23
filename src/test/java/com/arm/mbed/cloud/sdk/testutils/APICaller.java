package com.arm.mbed.cloud.sdk.testutils;

import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.common.ApiUtils;
import com.arm.mbed.cloud.sdk.common.ConnectionOptions;
import com.arm.mbed.cloud.sdk.common.MbedCloudException;
import com.arm.mbed.cloud.sdk.testserver.internal.model.APIMethod;
import com.arm.mbed.cloud.sdk.testserver.internal.model.APIMethodArgument;
import com.arm.mbed.cloud.sdk.testserver.internal.model.APIMethodResult;
import com.arm.mbed.cloud.sdk.testserver.internal.model.APIModule;
import com.arm.mbed.cloud.sdk.testserver.internal.model.ModuleInstance;
import com.arm.mbed.cloud.sdk.testserver.internal.model.SDK;
import com.arm.mbed.cloud.sdk.testserver.internal.model.UnknownAPIException;

@Preamble(description = "Mechanism to call API methods by reflection")
public class APICaller {
    private SDK sdk;
    private ConnectionOptions connectionOptions;

    public APICaller(SDK sdk, ConnectionOptions connectionOptions) {
        super();
        this.sdk = sdk;
        this.connectionOptions = connectionOptions;
    }

    public APICaller(SDK sdk) {
        this(sdk, null);
    }

    /**
     * @return the sdk
     */
    public SDK getSdk() {
        return sdk;
    }

    /**
     * @param sdk
     *            the sdk to set
     */
    public void setSdk(SDK sdk) {
        this.sdk = sdk;
    }

    /**
     * @return the connectionOptions
     */
    public ConnectionOptions getConnectionOptions() {
        return connectionOptions;
    }

    /**
     * @param connectionOptions
     *            the connectionOptions to set
     */
    public void setConnectionOptions(ConnectionOptions connectionOptions) {
        this.connectionOptions = connectionOptions;
    }

    @SuppressWarnings("null")
    public APIMethodResult callAPIOnModuleInstance(ModuleInstance moduleInstance, String method,
            Map<String, Object> parameters) throws UnknownAPIException, APICallException {
        if (moduleInstance == null) {
            throwMissingModule(null);
        }
        return callAPIOnInstance(moduleInstance.getInstance(), method, parameters);
    }

    @SuppressWarnings("null")
    public APIMethodResult callAPIOnInstance(APIModule moduleObj, String method, Map<String, Object> parameters)
            throws UnknownAPIException, APICallException {
        if (moduleObj == null) {
            throwMissingModule(moduleObj);
        }
        if (method == null) {
            throwUnknownAPI(moduleObj.getSimpleName(), method);
        }
        final List<APIMethod> methodObjs = moduleObj.getMethod(method);
        if (methodObjs == null) {
            throwUnknownAPI(moduleObj.getSimpleName(), method);
        }
        APICallException lastException = null;
        APIMethodResult result = null;
        // This is iterating over all methods with the same name but different signatures. If calls to all of them fail
        // then last exception is raised or the last result is returned if not null.
        for (final APIMethod methodObj : methodObjs) {
            try {
                result = null;
                lastException = null;
                API api = new API(connectionOptions, moduleObj, methodObj);
                result = api.call(moduleObj.getInstance(), parameters);
                // If the call was successful then it is returned straight away and there is no need to iterate over
                // other methods
                if (!result.wasExceptionRaised()) {
                    return result;
                }
            } catch (APICallException exception) {
                lastException = exception;
            }
        }
        // If the call was successful but an exception was raised during it then the failure is returned.
        if (result != null) {
            return result;
        }
        // If the call was not successful and hence, an exception was raised, then it is thrown.
        throw lastException;
    }

    @SuppressWarnings("null")
    public APIModule retrieveModuleInstance(String module) throws UnknownAPIException {
        if (module == null || sdk == null) {
            throwUnknownModule(module);
        }
        APIModule moduleObj = sdk.getModule(module);
        if (moduleObj == null) {
            throwUnknownModule(module);
        }
        moduleObj.build(connectionOptions);
        return moduleObj;
    }

    private static void throwUnknownAPI(String module, String method) throws UnknownAPIException {
        throw new UnknownAPIException(
                "method [" + String.valueOf(method) + "] not found on module [" + String.valueOf(module) + "]");
    }

    private static void throwUnknownModule(String module) throws UnknownAPIException {
        throw new UnknownAPIException("SDK module [" + String.valueOf(module) + "] could not be found");
    }

    private static void throwMissingModule(APIModule module) throws UnknownAPIException {
        throw new UnknownAPIException(
                "Requested SDK module was not instantiated properly [" + String.valueOf(module) + "].");
    }

    private static void throwAPICallException(APIModule module, APIMethod method, Exception e) throws APICallException {
        throw new APICallException("Error occurred when calling method [" + String.valueOf(method.getName())
                + "] on module [" + String.valueOf(module.getSimpleName()) + "]. " + String.valueOf((e == null)
                        ? "Unknown reason" : (e.getMessage() == null) ? "Type: " + e.toString() : e.getMessage()));
    }

    private static class API {
        private APIModule module;
        private APIMethod method;

        public API(ConnectionOptions connectionOptions, APIModule module, APIMethod method) {
            super();
            this.module = module;
            this.method = method;
        }

        public APIMethodResult call(Object moduleInstance, Map<String, Object> parameters) throws APICallException {
            Map<String, Map<String, Object>> argDescription = determineArgumentJsonValues(parameters);
            try {
                return method.invokeAPI(moduleInstance, argDescription);
            } catch (NoSuchMethodException | SecurityException | ClassNotFoundException | IllegalAccessException
                    | IllegalArgumentException | InvocationTargetException e) {
                // e.printStackTrace();
                throwAPICallException(module, method, e);
            }
            return null;
        }

        private Map<String, Map<String, Object>> determineArgumentJsonValues(Map<String, Object> parameters)
                throws APICallException {
            Map<String, Map<String, Object>> argDescription = null;
            TestParameters testParameters = new TestParameters(parameters);
            if (method.determineNumberOfArguments() > 0) {
                argDescription = new Hashtable<>(method.determineNumberOfArguments());
                if (method.determineNumberOfArguments() == 1) {
                    String argName = method.getArguments().get(0).getName();
                    argDescription.put(argName, testParameters.getParameters());
                } else {
                    List<APIMethodArgument> unfoundArguments = new LinkedList<>();
                    for (APIMethodArgument argument : method.getArguments()) {
                        Class<?> argumentClass = null;
                        try {
                            argumentClass = argument.determineClass();
                        } catch (ClassNotFoundException e) {
                            // DO nothing
                        }
                        String argName = argument.getName();
                        String paramName = ApiUtils.convertCamelToSnake(argName);
                        Object subMap = testParameters.get(paramName);
                        if (subMap != null) {
                            argDescription.put(argName, determineParameterValue(paramName, subMap, argumentClass));
                        } else {
                            unfoundArguments.add(argument);
                        }
                    }
                    if (!unfoundArguments.isEmpty()) {
                        if (testParameters.hasUnusedParameters()) {// In case, some parameters were specified with
                                                                   // different names
                            for (APIMethodArgument argument : unfoundArguments) {
                                Class<?> argumentClass = null;
                                try {
                                    argumentClass = argument.determineClass();
                                } catch (ClassNotFoundException e) {
                                    // DO nothing
                                }
                                Entry<String, Object> unusedEntry = testParameters.pop();
                                Map<String, Object> guessedSubMap = (unusedEntry == null) ? new HashMap<>()
                                        : determineParameterValue(unusedEntry.getKey(), unusedEntry.getValue(),
                                                argumentClass);
                                argDescription.put(argument.getName(), guessedSubMap);
                            }
                        } else {
                            for (APIMethodArgument argument : unfoundArguments) {
                                argDescription.put(argument.getName(), new HashMap<String, Object>());
                            }
                        }

                    }
                }
            }

            return argDescription;
        }

        @SuppressWarnings("unchecked")
        private Map<String, Object> determineParameterValue(String paramName, Object subMap, Class<?> paramClass)
                throws APICallException {
            if (!(subMap instanceof Map)) {
                // The parameter must be a Json primitive
                if (subMap != null && !Utils.isPrimitiveOrWrapperType(subMap.getClass())) {
                    throwAPICallException(module, method,
                            new Exception("Incorrect argument type [" + String.valueOf(subMap) + "]."));
                }
                // In the special case of dates, we try to parse the ISO String representation
                if (subMap != null && paramClass != null && paramClass.isAssignableFrom(Date.class)) {
                    try {
                        subMap = ApiUtils.convertStringToDate(subMap.toString());
                    } catch (MbedCloudException e) {
                        e.printStackTrace();
                        // Nothing to do
                    }
                }

                Map<String, Object> fields = new HashMap<>();
                fields.put(paramName, subMap);
                subMap = fields;
            }
            return (Map<String, Object>) subMap;
        }

    }

    // Class to keep track of parameters passed by tests
    private static class TestParameters {
        private final Map<String, Object> parameters;
        private final Map<String, Boolean> unused;

        @SuppressWarnings("boxing")
        public TestParameters(Map<String, Object> parameters) {
            super();
            this.parameters = (parameters == null) ? new HashMap<>() : parameters;
            this.unused = new HashMap<>();
            for (String name : this.parameters.keySet()) {
                unused.put(name, false);
            }
        }

        /**
         * @return the parameters
         */
        public Map<String, Object> getParameters() {
            return parameters;
        }

        public Object get(String parameterName) {
            if (parameterName == null) {
                return null;
            }
            Object value = parameters.get(parameterName);
            if (value != null) {
                unused.remove(parameterName);
            }
            return value;
        }

        public Entry<String, Object> pop() {
            if (unused.isEmpty()) {
                return null;
            }
            String key = unused.keySet().iterator().next();
            return new Entry<String, Object>() {

                @Override
                public String getKey() {
                    return key;
                }

                @Override
                public Object getValue() {
                    return get(key);
                }

                @Override
                public Object setValue(Object value) {
                    return null;
                }
            };
        }

        public boolean hasUnusedParameters() {
            return !unused.isEmpty();
        }
    }

}
