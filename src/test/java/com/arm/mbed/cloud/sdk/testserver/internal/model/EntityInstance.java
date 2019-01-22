/**
 * 
 */
package com.arm.mbed.cloud.sdk.testserver.internal.model;

import java.time.ZoneOffset;

import com.arm.mbed.cloud.sdk.common.ApiUtils;
import com.arm.mbed.cloud.sdk.common.ConnectionOptions;

public class EntityInstance extends AbstractTestedItemInstance<Entity> {

    private static final long serialVersionUID = -7969420249932760494L;

    public EntityInstance(String entityName, ConnectionOptions options, Entity entityDescription) {
        super(entityName, options, entityDescription);
    }

    public com.arm.mbed.cloud.sdk.testserver.model.FoundationInstance toInstance() {
        com.arm.mbed.cloud.sdk.testserver.model.FoundationInstance value = new com.arm.mbed.cloud.sdk.testserver.model.FoundationInstance();
        value.setId(id);
        value.setEntity(ApiUtils.convertCamelToSnake(getReference()));
        value.setCreatedAt(createdAt.toInstant().atOffset(ZoneOffset.UTC));
        return value;
    }
}
