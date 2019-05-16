package com.arm.mbed.cloud.sdk.testserver.internal.model;

import java.util.List;
import java.util.Map;

public abstract class Foundation extends AbstractTestedItem {

    public Foundation(String name, String simpleName, Map<String, List<APIMethod>> methods) {
        super(name, simpleName, methods);
    }

    public Foundation(String name, String simpleName) {
        super(name, simpleName);
    }

    public Foundation(String name) {
        super(name);
    }

    public Foundation() {
        super();
    }

}
