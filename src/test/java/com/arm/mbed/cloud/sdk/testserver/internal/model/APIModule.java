package com.arm.mbed.cloud.sdk.testserver.internal.model;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

import com.arm.mbed.cloud.sdk.common.ConnectionOptions;

public class APIModule extends AbstractTestedItem {

    public APIModule(String name, String simpleName, Map<String, List<APIMethod>> methods) {
        super(name, simpleName, methods);
    }

    public APIModule(String name, String simpleName) {
        super(name, simpleName);
    }

    public APIModule(String name) {
        super(name);
    }

    public APIModule() {
        super();
    }

    @Override
    protected Object createInstance(ConnectionOptions connectionOptions) {
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

    private static Object invokeConstructor(Class<?> moduleClass, ConnectionOptions connectionOptions) {
        final Object constructorInstance = invokeContructorWithConnectionOptions(moduleClass, connectionOptions);
        if (constructorInstance != null) {
            return constructorInstance;
        }
        return invokeEmptyContructor(moduleClass);

    }

    private static Object invokeContructorWithConnectionOptions(Class<?> moduleClass,
                                                                ConnectionOptions connectionOptions) {
        try {
            Constructor<?> constructor = moduleClass.getConstructor(ConnectionOptions.class);
            return constructor.newInstance(connectionOptions);
        } catch (NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException
                 | IllegalArgumentException | InvocationTargetException e) {
            e.printStackTrace();
            return null;

        }
    }

    private static Object invokeEmptyContructor(Class<?> moduleClass) {
        try {
            Constructor<?> constructor = moduleClass.getConstructor();
            return constructor.newInstance();
        } catch (NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException
                 | IllegalArgumentException | InvocationTargetException e) {
            e.printStackTrace();
            return null;

        }
    }

    @Override
    public TestedItemType getType() {
        return TestedItemType.MODULE;
    }

}
