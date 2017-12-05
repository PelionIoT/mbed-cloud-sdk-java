package com.arm.mbed.cloud.sdk.testutils;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.arm.mbed.cloud.sdk.common.ConnectionOptions;

public class APIModule {
    private String name;
    private String simpleName;
    private Object instance;

    private Map<String, List<APIMethod>> methods;

    public APIModule(String name, String simpleName, Map<String, List<APIMethod>> methods) {
        super();
        setName(name);
        setSimpleName(simpleName);
        setMethods(methods);
        setInstance(null);
    }

    public APIModule(String name, String simpleName) {
        this(name, simpleName, null);
    }

    public APIModule(String name) {
        this(name, null);
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
     * @return the simpleName
     */
    public String getSimpleName() {
        return simpleName;
    }

    /**
     * @param simpleName
     *            the simpleName to set
     */
    public void setSimpleName(String simpleName) {
        this.simpleName = simpleName;
    }

    /**
     * @return the methods
     */
    public Map<String, List<APIMethod>> getMethods() {
        return methods;
    }

    /**
     * @param methods
     *            the methods to set
     */
    public void setMethods(Map<String, List<APIMethod>> methods) {
        this.methods = methods;
    }

    /**
     * @return the instance
     */
    public Object getInstance() {
        return instance;
    }

    /**
     * @param instance
     *            the instance to set
     */
    public void setInstance(Object instance) {
        this.instance = instance;
    }

    public void addMethod(APIMethod method) {
        if (method == null) {
            return;
        }
        if (methods == null) {
            methods = new LinkedHashMap<>();
        }
        List<APIMethod> methodDescriptions = methods.get(method.getName());
        if (methodDescriptions == null) {
            methodDescriptions = new LinkedList<>();
            methods.put(method.getName(), methodDescriptions);
        }
        methodDescriptions.add(method);
    }

    public List<APIMethod> getMethod(String methodName) {
        if (methodName == null || methods == null) {
            return null;
        }
        return methods.get(methodName);
    }

    public Object fetchInstance(ConnectionOptions connectionOptions) {
        if (instance == null) {
            instance = createInstance(connectionOptions);
        }
        return getInstance();
    }

    private Object createInstance(ConnectionOptions connectionOptions) {
        if (name == null) {
            return null;
        }
        try {
            Class<?> moduleClass = Class.forName(name);
            Constructor<?> constructor = moduleClass.getConstructor(ConnectionOptions.class);
            return constructor.newInstance(connectionOptions);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | IllegalArgumentException
                | InvocationTargetException | NoSuchMethodException | SecurityException e) {
            e.printStackTrace();
            return null;
        }
    }

}
