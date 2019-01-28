/**
 * 
 */
package com.arm.mbed.cloud.sdk.testserver.internal.model;

import java.time.ZoneOffset;

import com.arm.mbed.cloud.sdk.common.ConnectionOptions;

public class FoundationInstance<T extends Foundation> extends AbstractTestedItemInstance<T> {

    private static final long serialVersionUID = 4847952200241046401L;

    public FoundationInstance(String entityName, ConnectionOptions options, T description) {
        super(entityName, options, description);
    }

    public com.arm.mbed.cloud.sdk.testserver.model.FoundationInstance toInstance() {
        com.arm.mbed.cloud.sdk.testserver.model.FoundationInstance value = new com.arm.mbed.cloud.sdk.testserver.model.FoundationInstance();
        value.setId(id);
        value.setEntity(getReference());
        value.setCreatedAt(createdAt.toInstant().atOffset(ZoneOffset.UTC));
        return value;
    }
}
