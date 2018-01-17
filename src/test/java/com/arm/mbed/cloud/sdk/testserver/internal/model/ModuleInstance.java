/**
 * 
 */
package com.arm.mbed.cloud.sdk.testserver.internal.model;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

import org.joda.time.DateTime;

import com.arm.mbed.cloud.sdk.testserver.model.Instance;

import io.vertx.core.shareddata.Shareable;

public class ModuleInstance implements Serializable, Shareable {

    /**
     * 
     */
    private static final long serialVersionUID = 3738811659962499603L;
    /**
     * 
     */
    private final String id;
    private final APIModule instance;
    private final Date createdAt;
    private final String module;

    public ModuleInstance(String module, APIModule instance) {
        super();
        this.instance = instance;
        this.module = module;
        this.createdAt = new Date();
        this.id = module + "-" + UUID.randomUUID();

    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @return the instance
     */
    public APIModule getInstance() {
        return instance;
    }

    /**
     * @return the createdAt
     */
    public Date getCreatedAt() {
        return createdAt;
    }

    /**
     * @return the module
     */
    public String getModule() {
        return module;
    }

    public boolean isValid() {
        return (id != null && module != null && instance != null);
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "ModuleInstance [id=" + id + ", createdAt=" + createdAt + ", module=" + module + "]";
    }

    public Instance toInstance() {
        Instance value = new Instance();
        value.setId(id);
        value.setModule(module);
        value.setCreatedAt(new DateTime(createdAt));
        return value;
    }
}
