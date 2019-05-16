package com.arm.mbed.cloud.sdk.testserver.internal.model;

import java.util.Date;
import java.util.UUID;

import com.arm.mbed.cloud.sdk.common.ConnectionOptions;

public abstract class AbstractTestedItemInstance<T extends TestedItem> implements TestedItemInstance<T> {

    private static final long serialVersionUID = 4289384392713073294L;

    protected final String id;
    protected final String reference;
    protected final Date createdAt;
    protected final ConnectionOptions options;
    protected final T description;

    public AbstractTestedItemInstance(String reference, ConnectionOptions options, T description) {
        super();
        this.reference = reference;
        this.createdAt = new Date();
        this.options = options;
        this.id = reference + "-" + UUID.randomUUID();
        this.description = description;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.arm.mbed.cloud.sdk.testserver.internal.model.TestedItemInstance#getId()
     */
    @Override
    public String getId() {
        return id;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.arm.mbed.cloud.sdk.testserver.internal.model.TestedItemInstance#getCreatedAt()
     */
    @Override
    public Date getCreatedAt() {
        return createdAt;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.arm.mbed.cloud.sdk.testserver.internal.model.TestedItemInstance#getOptions()
     */
    @Override
    public ConnectionOptions getOptions() {
        return options;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.arm.mbed.cloud.sdk.testserver.internal.model.TestedItemInstance#getReference()
     */
    @Override
    public String getReference() {
        return reference;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.arm.mbed.cloud.sdk.testserver.internal.model.TestedItemInstance#getHostInUse()
     */
    @Override
    public String getHostInUse() {
        return (options == null) ? null : options.getHost();
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.arm.mbed.cloud.sdk.testserver.internal.model.TestedItemInstance#isValid()
     */
    @Override
    public boolean isValid() {
        return (id != null && description != null && reference != null && options != null && options.isValid());
    }

    @Override
    public T getDescription() {
        return description;
    }

    /**
     * @return the module instance
     */
    @Override
    public Object getInstance() {
        return getDescription().build(options);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.arm.mbed.cloud.sdk.testserver.internal.model.TestedItemInstance#toString()
     */
    @Override
    public String toString() {
        return "Instance [id=" + id + ", reference=" + reference + ", createdAt=" + createdAt + ", hostInUse="
               + getHostInUse() + "]";
    }

}
