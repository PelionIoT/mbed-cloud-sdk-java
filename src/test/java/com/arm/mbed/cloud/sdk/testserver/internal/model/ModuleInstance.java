/**
 * 
 */
package com.arm.mbed.cloud.sdk.testserver.internal.model;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

import org.joda.time.DateTime;

import com.arm.mbed.cloud.sdk.common.ApiUtils;
import com.arm.mbed.cloud.sdk.common.ConnectionOptions;
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
    private final APIModule moduleDescription;
    private final Date createdAt;
    private final String moduleName;
    private final ConnectionOptions options;

    public ModuleInstance(String moduleName, APIModule moduleDescription, ConnectionOptions options) {
        super();
        this.moduleDescription = moduleDescription;
        this.moduleName = moduleName;
        this.createdAt = new Date();
        this.options = options;
        this.id = moduleName + "-" + UUID.randomUUID();
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
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
     * @return the createdAt
     */
    public Date getCreatedAt() {
        return createdAt;
    }

    /**
     * @return the module
     */
    public String getModule() {
        return moduleName;
    }

    /**
     * @return the options
     */
    public ConnectionOptions getOptions() {
        return options;
    }

    /**
     * 
     * @return the host in use
     */
    public String getHostInUse() {
        return (options == null) ? null : options.getHost();
    }

    public boolean isValid() {
        return (id != null && moduleName != null && moduleDescription != null && options != null && options.isValid());
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "ModuleInstance [id=" + id + ", createdAt=" + createdAt + ", module=" + moduleName + ", hostInUse="
               + getHostInUse() + "]";
    }

    public Instance toInstance() {
        Instance value = new Instance();
        value.setId(id);
        value.setModule(ApiUtils.convertCamelToSnake(moduleName));
        value.setCreatedAt(new DateTime(createdAt));
        return value;
    }
}
