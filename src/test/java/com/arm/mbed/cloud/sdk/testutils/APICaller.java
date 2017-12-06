package com.arm.mbed.cloud.sdk.testutils;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.common.ApiUtils;
import com.arm.mbed.cloud.sdk.common.ConnectionOptions;

@Preamble(description = "Mechanism to call API methods by reflection")
public class APICaller {
    private SDK sdk;
    private ConnectionOptions connectionOptions;

    public APICaller(SDK sdk, ConnectionOptions connectionOptions) {
        super();
        this.sdk = sdk;
        this.connectionOptions = connectionOptions;
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
    public APIMethodResult callAPI(String module, String method, Map<String, Object> parameters)
            throws UnknownAPIException, APICallException {
        if (module == null || method == null || sdk == null) {
            throwUnknownAPI(module, method);
        }
        APIModule moduleObj = sdk.getModule(module);
        if (moduleObj == null) {
            throwUnknownAPI(module, method);
        }
        List<APIMethod> methodObjs = moduleObj.getMethod(method);
        if (methodObjs == null) {
            throwUnknownAPI(module, method);
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
                result = api.call(parameters);
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

    private static void throwUnknownAPI(String module, String method) throws UnknownAPIException {
        throw new UnknownAPIException(
                "method [" + String.valueOf(method) + "] not found on module [" + String.valueOf(module) + "]");
    }

    private static void throwAPICallException(APIModule module, APIMethod method, Exception e) throws APICallException {
        throw new APICallException("Error occurred when calling method [" + String.valueOf(method.getName())
                + "] on module [" + String.valueOf(module.getSimpleName()) + "]. " + String.valueOf((e == null)
                        ? "Unknown reason" : (e.getMessage() == null) ? "Type: " + e.toString() : e.getMessage()));
    }

    private static class API {
        private ConnectionOptions connectionOptions;
        private APIModule module;
        private APIMethod method;

        public API(ConnectionOptions connectionOptions, APIModule module, APIMethod method) {
            super();
            this.connectionOptions = connectionOptions;
            this.module = module;
            this.method = method;
        }

        public APIMethodResult call(Map<String, Object> parameters) throws APICallException {
            Map<String, Map<String, Object>> argDescription = determineArgumentJsonValues(parameters);
            try {
                return method.invokeAPI(module.fetchInstance(connectionOptions), argDescription);
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
                        String argName = argument.getName();
                        String paramName = ApiUtils.convertCamelToSnake(argName);
                        Object subMap = testParameters.get(paramName);
                        if (subMap != null) {
                            argDescription.put(argName, determineParameterValue(paramName, subMap));
                        } else {
                            unfoundArguments.add(argument);
                        }
                    }
                    if (!unfoundArguments.isEmpty()) {
                        if (testParameters.hasUnusedParameters()) {// In case, some parameters were specified with
                                                                   // different names
                            for (APIMethodArgument argument : unfoundArguments) {
                                Entry<String, Object> unusedEntry = testParameters.pop();
                                Map<String, Object> guessedSubMap = (unusedEntry == null) ? new HashMap<>()
                                        : determineParameterValue(unusedEntry.getKey(), unusedEntry.getValue());
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
        private Map<String, Object> determineParameterValue(String paramName, Object subMap) throws APICallException {
            if (!(subMap instanceof Map)) {
                if (!(subMap instanceof String)) {
                    throwAPICallException(module, method,
                            new Exception("Incorrect argument type [" + String.valueOf(subMap) + "]."));
                }
                String value = String.valueOf(subMap);
                Map<String, Object> fields = new HashMap<>();
                fields.put(paramName, value);
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
