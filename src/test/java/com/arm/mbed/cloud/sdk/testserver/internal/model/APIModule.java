package com.arm.mbed.cloud.sdk.testserver.internal.model;

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
        return createAModuleInstance(connectionOptions, name);
    }

    public static Object createAModuleInstance(ConnectionOptions connectionOptions, String className) {
        if (className == null) {
            return null;
        }
        try {
            Class<?> moduleClass = Class.forName(className);
            return Utils.invokeConstructor(moduleClass, connectionOptions);
        } catch (ClassNotFoundException | SecurityException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public TestedItemType getType() {
        return TestedItemType.MODULE;
    }

}
