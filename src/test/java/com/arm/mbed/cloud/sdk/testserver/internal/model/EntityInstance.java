/**
 * 
 */
package com.arm.mbed.cloud.sdk.testserver.internal.model;

import java.time.ZoneOffset;

import com.arm.mbed.cloud.sdk.common.ApiUtils;
import com.arm.mbed.cloud.sdk.common.ConnectionOptions;

public class EntityInstance extends AbstractInstance {

    /**
     * 
     */
    private static final long serialVersionUID = -7969420249932760494L;
    final Entity entityDescription;

    public EntityInstance(String moduleName, Entity entityDescription, ConnectionOptions options) {
        super(moduleName, options);
        this.entityDescription = entityDescription;

    }

    /**
     * @return the module description
     */
    public Entity getEntityDescription() {
        return entityDescription;
    }

    /**
     * @return the module instance
     */
    public Object getInstance() {
        return entityDescription.build(options);
    }

    /**
     * @return the entity
     */
    public String getEntity() {
        return getReference();
    }

    @Override
    public boolean isValid() {
        return super.isValid() && entityDescription != null;
    }

    public com.arm.mbed.cloud.sdk.testserver.model.FoundationInstance toInstance() {
        com.arm.mbed.cloud.sdk.testserver.model.FoundationInstance value = new com.arm.mbed.cloud.sdk.testserver.model.FoundationInstance();
        value.setId(id);
        value.setEntity(ApiUtils.convertCamelToSnake(getEntity()));
        value.setCreatedAt(createdAt.toInstant().atOffset(ZoneOffset.UTC));
        return value;
    }
}
