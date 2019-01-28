package com.arm.mbed.cloud.sdk.testserver.internal.model;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

import com.arm.mbed.cloud.sdk.common.ApiMetadata;
import com.arm.mbed.cloud.sdk.common.ApiUtils;
import com.arm.mbed.cloud.sdk.common.MbedCloudException;
import com.arm.mbed.cloud.sdk.common.SdkContext;
import com.arm.mbed.cloud.sdk.common.dao.ModelListDao;
import com.arm.mbed.cloud.sdk.common.listing.Paginator;
import com.arm.mbed.cloud.sdk.testserver.model.SdkMethodInfo;
import com.arm.mbed.cloud.sdk.testutils.APICallException;

public class APIMethod {
    private String name;
    private APIMethodArgument returnArgument;
    private List<APIMethodArgument> arguments;
    private DaemonControl daemonControl;
    private APIMethod subMethod;

    public APIMethod(String name, APIMethodArgument returnArgument, List<APIMethodArgument> arguments,
                     DaemonControl daemonControl) {
        super();
        setName(name);
        setReturnArgument(returnArgument);
        setArguments(arguments);
        setDaemonControl(daemonControl);
        setSubMethod(null);
    }

    public APIMethod(String name) {
        this(name, null, null, DaemonControl.NONE);
    }

    public APIMethod() {
        this(null);
    }

    public static APIMethod getApiMetadata() {
        return new APIMethod(SdkContext.METHOD_GET_API_METADATA);
    }

    public static APIMethod getClose() {
        return new APIMethod("close");
    }

    public static APIMethod getCorrespondingDao() {
        return new APIMethod(ModelListDao.METHOD_GET_CORRESPONDING_MODEL_DAO_INSTANCE);
    }

    /**
     * @return the daemonControl
     */
    public DaemonControl getDaemonControl() {
        return daemonControl;
    }

    /**
     * @param daemonControl
     *            the daemonControl to set
     */
    public void setDaemonControl(DaemonControl daemonControl) {
        this.daemonControl = daemonControl;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     *            the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    public APIMethod getSubMethod() {
        return subMethod;
    }

    public void setSubMethod(APIMethod subMethod) {
        this.subMethod = subMethod;
    }

    /**
     * @return the returnArgument
     */
    public APIMethodArgument getReturnArgument() {
        return returnArgument;
    }

    /**
     * @param returnArgument
     *            the returnArgument to set
     */
    public void setReturnArgument(APIMethodArgument returnArgument) {
        this.returnArgument = returnArgument;
    }

    /**
     * @return the arguments
     */
    public List<APIMethodArgument> getArguments() {
        return arguments;
    }

    /**
     * @param arguments
     *            the arguments to set
     */
    public void setArguments(List<APIMethodArgument> arguments) {
        this.arguments = arguments;
    }

    public void addArgument(APIMethodArgument argument) {
        if (argument == null) {
            return;
        }
        if (arguments == null) {
            arguments = new LinkedList<>();
        }
        arguments.add(argument);
    }

    public int determineNumberOfArguments() {
        return (arguments == null) ? 0 : arguments.size();
    }

    public APIMethodResult
           invokeAPI(Object instance,
                     Map<String, Map<String, Object>> argsDescription) throws NoSuchMethodException, SecurityException,
                                                                       ClassNotFoundException, IllegalAccessException,
                                                                       IllegalArgumentException, APICallException,
                                                                       InvocationTargetException {

        APIMethodResult result = new APIMethodResult();
        Object instanceToCallTheAPIOn = null;
        try {
            instanceToCallTheAPIOn = subMethod == null ? instance : subMethod.invokeMethod(instance, null);
        } catch (InvocationTargetException e) {
            result.setException(e);
            return result;
        }
        try {
            Object resultObject = invokeMethod(instanceToCallTheAPIOn, argsDescription);
            if (resultObject instanceof Paginator<?>) {
                try {
                    resultObject = ((Paginator<?>) resultObject).all();
                } catch (MbedCloudException exception) {
                    exception.printStackTrace();
                    result.setException(new InvocationTargetException(exception,
                                                                      "Failed calling method all() on a paginator"));
                }
            }
            result.setResult(resultObject);
        } catch (InvocationTargetException e) {
            e.printStackTrace();
            result.setException(e);
        }
        APIMethod lastMetadataMethod = getApiMetadata();
        result.setMetadata((ApiMetadata) lastMetadataMethod.invokeMethod(instanceToCallTheAPIOn, null));
        return result;
    }

    private Object
            invokeMethod(Object instance,
                         Map<String, Map<String, Object>> argsDescription) throws NoSuchMethodException,
                                                                           SecurityException, ClassNotFoundException,
                                                                           IllegalAccessException,
                                                                           IllegalArgumentException,
                                                                           InvocationTargetException, APICallException {
        if (instance == null) {
            throw new NoSuchElementException();
        }
        Method m = fetchMethod(instance.getClass());
        if (m == null) {
            throw new NoSuchMethodException();
        }
        Object[] args = fetchArgsValues(argsDescription);
        return (args == null) ? m.invoke(instance) : m.invoke(instance, args);

    }

    private Method fetchMethod(Class<?> clazz) throws NoSuchMethodException, SecurityException, ClassNotFoundException {
        if (clazz == null || name == null || name.isEmpty()) {
            return null;
        }
        Class<?>[] argTypes = fetchArgsType();
        return (argTypes == null) ? clazz.getMethod(name) : clazz.getMethod(name, argTypes);

    }

    private Class<?>[] fetchArgsType() throws ClassNotFoundException {
        int argsNumber = determineNumberOfArguments();
        if (argsNumber == 0) {
            return null;
        }
        List<Class<?>> argsTypeArray = new ArrayList<>(argsNumber);
        for (APIMethodArgument arg : arguments) {
            argsTypeArray.add(arg.determineClass());
        }
        return argsTypeArray.toArray(new Class[] {});
    }

    private Object[] fetchArgsValues(Map<String, Map<String, Object>> argsDescription) throws ClassNotFoundException,
                                                                                       APICallException {
        int argsNumber = determineNumberOfArguments();
        if (argsNumber == 0 || argsDescription == null || argsDescription.isEmpty()) {
            return null;
        }
        List<Object> argValuesArray = new ArrayList<>(argsNumber);
        for (APIMethodArgument arg : arguments) {
            argValuesArray.add(arg.determineValue(arg.determineClass(), arg.determineContentClass(),
                                                  argsDescription.get(arg.getName())));
        }
        return argValuesArray.toArray();
    }

    public SdkMethodInfo toSdkApi() {
        SdkMethodInfo api = new SdkMethodInfo();
        api.setName(ApiUtils.convertCamelToSnake(name));
        if (arguments == null) {
            return api;
        }
        arguments.forEach(arg -> api.put("arg" + api.size(), arg.toString()));
        return api;
    }

    @Override
    public String toString() {
        return "APIMethod [name=" + name + ", returnArgument=" + returnArgument + ", arguments=" + arguments
               + ", daemonControl=" + daemonControl + ", subMethod=" + subMethod + "]";
    }

}
