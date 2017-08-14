package com.arm.mbed.cloud.sdk.testutils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

public class APIMethod {
    private String name;
    private APIMethodArgument returnArgument;
    private List<APIMethodArgument> arguments;

    public APIMethod(String name, APIMethodArgument returnArgument, List<APIMethodArgument> arguments) {
        super();
        setName(name);
        setReturnArgument(returnArgument);
        setArguments(arguments);
    }

    public APIMethod(String name) {
        this(name, null, null);
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

    public Object invokeMethod(Object moduleInstance, Map<String, Map<String, Object>> argsDescription)
            throws NoSuchMethodException, SecurityException, ClassNotFoundException, IllegalAccessException,
            IllegalArgumentException, InvocationTargetException, APICallException {
        if (moduleInstance == null) {
            throw new NoSuchElementException();
        }
        Method m = fetchMethod(moduleInstance.getClass());
        if (m == null) {
            throw new NoSuchMethodException();
        }
        Object[] args = fetchArgsValues(argsDescription);
        return (args == null) ? m.invoke(moduleInstance) : m.invoke(moduleInstance, args);
    }

    private Method fetchMethod(Class<?> moduleClass)
            throws NoSuchMethodException, SecurityException, ClassNotFoundException {
        if (moduleClass == null || name == null || name.isEmpty()) {
            return null;
        }
        Class<?>[] argTypes = fetchArgsType();
        return (argTypes == null) ? moduleClass.getDeclaredMethod(name) : moduleClass.getDeclaredMethod(name, argTypes);

    }

    private Class<?>[] fetchArgsType() throws ClassNotFoundException {
        int argsNumber = determineNumberOfArguments();
        if (argsNumber == 0) {
            return null;
        }
        List<Class<?>> argsTypeArray = new ArrayList<Class<?>>(argsNumber);
        for (APIMethodArgument arg : arguments) {
            argsTypeArray.add(arg.determineClass());
        }
        return argsTypeArray.toArray(new Class[] {});
    }

    private Object[] fetchArgsValues(Map<String, Map<String, Object>> argsDescription)
            throws ClassNotFoundException, APICallException {
        int argsNumber = determineNumberOfArguments();
        if (argsNumber == 0 || argsDescription == null || argsDescription.isEmpty()) {
            return null;
        }
        List<Object> argValuesArray = new ArrayList<>(argsNumber);
        for (APIMethodArgument arg : arguments) {
            argValuesArray.add(arg.determineValue(arg.determineClass(), argsDescription.get(arg.getName())));
        }
        return argValuesArray.toArray();
    }

}
