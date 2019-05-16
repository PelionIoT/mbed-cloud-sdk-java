package com.arm.mbed.cloud.sdk.testserver.internal.model;

import java.io.Serializable;
import java.util.Date;

import io.vertx.core.shareddata.Shareable;

import com.arm.mbed.cloud.sdk.common.ConnectionOptions;

public interface TestedItemInstance<T extends TestedItem> extends Serializable, Shareable {

    /**
     * @return the id
     */
    String getId();

    /**
     * @return the createdAt
     */
    Date getCreatedAt();

    /**
     * @return the options
     */
    ConnectionOptions getOptions();

    String getReference();

    /**
     * 
     * @return the host in use
     */
    String getHostInUse();

    boolean isValid();

    Object getInstance();

    @Override
    String toString();

    T getDescription();

}
