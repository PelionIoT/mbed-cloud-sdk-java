package com.arm.mbed.cloud.sdk.testserver.internal.model;

import java.util.List;
import java.util.Map;

import com.arm.mbed.cloud.sdk.common.ConnectionOptions;

public class Sdk extends Foundation {

    public Sdk(String name, String simpleName, Map<String, List<APIMethod>> methods) {
        super(name, simpleName, methods);
    }

    public Sdk(String name, String simpleName) {
        super(name, simpleName);
    }

    public Sdk(String name) {
        super(name);
    }

    public Sdk() {
        super();
    }

    public static Sdk clone(TestedItem item) {
        Sdk entryPoint = new Sdk();
        entryPoint.copy(item);
        return entryPoint;
    }

    @Override
    public TestedItemType getType() {
        return TestedItemType.SDK;
    }

    @Override
    protected Object createInstance(ConnectionOptions connectionOptions) {
        return APIModule.createAModuleInstance(connectionOptions, name);
    }

    @Override
    public String toString() {
        return "Sdk [name=" + name + ", simpleName=" + simpleName + ", instance=" + instance + ", methods=" + methods
               + "]";
    }

}
