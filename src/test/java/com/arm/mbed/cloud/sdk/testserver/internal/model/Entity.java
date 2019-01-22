package com.arm.mbed.cloud.sdk.testserver.internal.model;

import java.util.List;
import java.util.Map;

import com.arm.mbed.cloud.sdk.common.ConnectionOptions;

public class Entity extends AbstractTestedItem {

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
        // TODO
        return null;
    }

}
