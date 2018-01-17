package com.arm.mbed.cloud.sdk.testserver.internal.model;

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

    public APIModule() {
        this(null);
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

    public List<APIMethod> fetchAllMethod() {
        if (methods == null) {
            return null;
        }
        List<APIMethod> list = new LinkedList<>();
        for (String methodName : methods.keySet()) {
            list.addAll(methods.get(methodName));
        }
        if (list.isEmpty()) {
            return null;
        }
        return list;
    }

    public List<APIMethod> getMethod(String methodName) {
        if (methodName == null || methods == null) {
            return null;
        }
        return methods.get(methodName);
    }

    public Object build(ConnectionOptions connectionOptions) {
        synchronized (this) {
            if (instance == null) {
                instance = createInstance(connectionOptions);
            }
        }
        return getInstance();
    }

    private Object createInstance(ConnectionOptions connectionOptions) {
        if (name == null) {
            return null;
        }
        try {
            Class<?> moduleClass = Class.forName(name);
            return invokeConstructor(moduleClass, connectionOptions);
        } catch (ClassNotFoundException | SecurityException e) {
            e.printStackTrace();
            return null;
        }
    }

    private Object invokeConstructor(Class<?> moduleClass, ConnectionOptions connectionOptions) {
        final Object constructorInstance = invokeContructorWithConnectionOptions(moduleClass, connectionOptions);
        if (constructorInstance != null) {
            return constructorInstance;
        }
        return invokeEmptyContructor(moduleClass);

    }

    private Object invokeContructorWithConnectionOptions(Class<?> moduleClass, ConnectionOptions connectionOptions) {
        try {
            Constructor<?> constructor = moduleClass.getConstructor(ConnectionOptions.class);
            return constructor.newInstance(connectionOptions);
        } catch (NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException
                | IllegalArgumentException | InvocationTargetException e) {
            e.printStackTrace();
            return null;

        }
    }

    private Object invokeEmptyContructor(Class<?> moduleClass) {
        try {
            Constructor<?> constructor = moduleClass.getConstructor();
            return constructor.newInstance();
        } catch (NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException
                | IllegalArgumentException | InvocationTargetException e) {
            e.printStackTrace();
            return null;

        }
    }

}
