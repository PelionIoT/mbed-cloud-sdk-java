/**
 * 
 */
package com.arm.mbed.cloud.sdk.testserver.internal.model;

import java.time.ZoneOffset;

import com.arm.mbed.cloud.sdk.common.ApiUtils;
import com.arm.mbed.cloud.sdk.common.ConnectionOptions;

public class ModuleInstance extends AbstractInstance {

    private static final long serialVersionUID = -6035590462107194421L;
    final APIModule moduleDescription;

    public ModuleInstance(String moduleName, APIModule moduleDescription, ConnectionOptions options) {
        super(moduleName, options);
        this.moduleDescription = moduleDescription;

    }

    /**
     * @return the module description
     */
    public APIModule getModuleDescription() {
        return moduleDescription;
    }

    /**
     * @return the module instance
     */
    public Object getInstance() {
        return moduleDescription.build(options);
    }

    /**
     * @return the module
     */
    public String getModule() {
        return getReference();
    }

    @Override
    public boolean isValid() {
        return super.isValid() && moduleDescription != null;
    }

    public com.arm.mbed.cloud.sdk.testserver.model.ModuleInstance toInstance() {
        com.arm.mbed.cloud.sdk.testserver.model.ModuleInstance value = new com.arm.mbed.cloud.sdk.testserver.model.ModuleInstance();
        value.setId(id);
        value.setModule(ApiUtils.convertCamelToSnake(getModule()));
        value.setCreatedAt(createdAt.toInstant().atOffset(ZoneOffset.UTC));
        return value;
    }
}
