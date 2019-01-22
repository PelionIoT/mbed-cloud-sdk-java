package com.arm.mbed.cloud.sdk.testserver.model;

import java.time.OffsetDateTime;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Description of an SDK module instance
 **/
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ModuleInstance {
    @JsonProperty("id")
    private String id = null;
    @JsonProperty("module")
    private String module = null;
    @JsonProperty("created_at")
    private OffsetDateTime createdAt = null;

    public ModuleInstance() {

    }

    public ModuleInstance(String id, String module, OffsetDateTime createdAt) {
        this.id = id;
        this.module = module;
        this.createdAt = createdAt;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }

    public OffsetDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(OffsetDateTime createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ModuleInstance moduleInstance = (ModuleInstance) o;
        return Objects.equals(id, moduleInstance.id) && Objects.equals(module, moduleInstance.module)
               && Objects.equals(createdAt, moduleInstance.createdAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, module, createdAt, super.hashCode());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ModuleInstance {\n");

        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    module: ").append(toIndentedString(module)).append("\n");
        sb.append("    createdAt: ").append(toIndentedString(createdAt)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces (except the first line).
     */
    private String toIndentedString(Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }
}
