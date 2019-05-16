/**
 * 
 */
package com.arm.mbed.cloud.sdk.testserver.internal.model;

import com.arm.mbed.cloud.sdk.common.ConnectionOptions;

public class EntityInstance extends FoundationInstance<Entity> {

    private static final long serialVersionUID = -7969420249932760494L;

    public EntityInstance(String entityName, ConnectionOptions options, Entity entityDescription) {
        super(entityName, options, entityDescription);
    }

}
