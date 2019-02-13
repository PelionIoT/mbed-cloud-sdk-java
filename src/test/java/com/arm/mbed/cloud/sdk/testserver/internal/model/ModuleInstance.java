/**
 * 
 */
package com.arm.mbed.cloud.sdk.testserver.internal.model;

import java.time.ZoneOffset;

import com.arm.mbed.cloud.sdk.common.ApiUtils;
import com.arm.mbed.cloud.sdk.common.ConnectionOptions;

public class ModuleInstance extends AbstractTestedItemInstance<APIModule> {

    private static final long serialVersionUID = -6035590462107194421L;

    public ModuleInstance(String moduleName, ConnectionOptions options, APIModule moduleDescription) {
        super(moduleName, options, moduleDescription);
    }

    public com.arm.mbed.cloud.sdk.testserver.model.ModuleInstance toInstance() {
        com.arm.mbed.cloud.sdk.testserver.model.ModuleInstance value = new com.arm.mbed.cloud.sdk.testserver.model.ModuleInstance();
        value.setId(id);
        value.setModule(ApiUtils.convertCamelToSnake(getReference()));
        value.setCreatedAt(createdAt.toInstant().atOffset(ZoneOffset.UTC));
        return value;
    }
}
