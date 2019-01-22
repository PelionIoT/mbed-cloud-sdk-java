package com.arm.mbed.cloud.sdk.testserver.internal.model;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

import io.vertx.core.shareddata.Shareable;

import com.arm.mbed.cloud.sdk.common.ConnectionOptions;

public abstract class AbstractInstance implements Serializable, Shareable {

    private static final long serialVersionUID = 4289384392713073294L;

    protected final String id;
    protected final String reference;
    protected final Date createdAt;
    protected final ConnectionOptions options;

    public AbstractInstance(String reference, ConnectionOptions options) {
        super();
        this.reference = reference;
        this.createdAt = new Date();
        this.options = options;
        this.id = reference + "-" + UUID.randomUUID();
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @return the createdAt
     */
    public Date getCreatedAt() {
        return createdAt;
    }

    /**
     * @return the options
     */
    public ConnectionOptions getOptions() {
        return options;
    }

    public String getReference() {
        return reference;
    }

    /**
     * 
     * @return the host in use
     */
    public String getHostInUse() {
        return (options == null) ? null : options.getHost();
    }

    public boolean isValid() {
        return (id != null && reference != null && options != null && options.isValid());
    }

    public abstract Object getInstance();

    @Override
    public String toString() {
        return "Instance [id=" + id + ", reference=" + reference + ", createdAt=" + createdAt + ", hostInUse="
               + getHostInUse() + "]";
    }

}
