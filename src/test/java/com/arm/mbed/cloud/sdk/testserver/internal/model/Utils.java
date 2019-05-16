package com.arm.mbed.cloud.sdk.testserver.internal.model;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import com.arm.mbed.cloud.sdk.common.ConnectionOptions;

public final class Utils {

    private Utils() {
        // Nothing to do
    }

    public static Object invokeConstructor(Class<?> clazz, ConnectionOptions connectionOptions) {
        final Object constructorInstance = invokeContructorWithConnectionOptions(clazz, connectionOptions);
        if (constructorInstance != null) {
            return constructorInstance;
        }
        return invokeEmptyContructor(clazz);

    }

    public static Object invokeContructorWithConnectionOptions(Class<?> clazz, ConnectionOptions connectionOptions) {
        try {
            Constructor<?> constructor = clazz.getConstructor(ConnectionOptions.class);
            return constructor.newInstance(connectionOptions);
        } catch (NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException
                 | IllegalArgumentException | InvocationTargetException e) {
            e.printStackTrace();
            return null;

        }
    }

    public static Object invokeEmptyContructor(Class<?> clazz) {
        try {
            Constructor<?> constructor = clazz.getConstructor();
            return constructor.newInstance();
        } catch (NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException
                 | IllegalArgumentException | InvocationTargetException e) {
            e.printStackTrace();
            return null;

        }
    }

}
