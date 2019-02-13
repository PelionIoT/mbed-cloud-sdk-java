package com.arm.mbed.cloud.sdk.testserver.internal.model;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;

import com.arm.mbed.cloud.sdk.common.ConnectionOptions;
import com.arm.mbed.cloud.sdk.common.dao.CloudDao;

public class Entity extends Foundation {

    public Entity(String name, String simpleName, Map<String, List<APIMethod>> methods) {
        super(name, simpleName, methods);
    }

    public Entity(String name, String simpleName) {
        super(name, simpleName);
    }

    public Entity(String name) {
        super(name);
    }

    public Entity() {
        super();
    }

    @Override
    public TestedItemType getType() {
        return TestedItemType.ENTITY;
    }

    @Override
    protected Object createInstance(ConnectionOptions connectionOptions) {
        // FIXME: Change when dao can be instantiated using ConnectionOptions
        if (name == null) {
            return null;
        }
        try {
            Class<?> entity = Class.forName(name);
            Method m = entity.getMethod(CloudDao.METHOD_CONFIGURE_AND_GET, ConnectionOptions.class);
            Object instance = Utils.invokeEmptyContructor(entity);
            return m.invoke(instance, connectionOptions);
        } catch (ClassNotFoundException | SecurityException | NoSuchMethodException | IllegalAccessException
                 | IllegalArgumentException | InvocationTargetException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public String toString() {
        return "Entity [name=" + name + ", simpleName=" + simpleName + ", instance=" + instance + ", methods=" + methods
               + "]";
    }

}
