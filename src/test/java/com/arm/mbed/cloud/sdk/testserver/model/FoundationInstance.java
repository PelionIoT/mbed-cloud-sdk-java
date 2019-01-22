package com.arm.mbed.cloud.sdk.testserver.model;

import java.time.OffsetDateTime;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Description of an Foundation SDK instance
 **/
@JsonInclude(JsonInclude.Include.NON_NULL)
public class FoundationInstance {
    @JsonProperty("id")
    private String id = null;
    @JsonProperty("entity")
    private String entity = null;
    @JsonProperty("created_at")
    private OffsetDateTime createdAt = null;

    public FoundationInstance() {

    }

    public FoundationInstance(String id, String entity, OffsetDateTime createdAt) {
        this.id = id;
        this.entity = entity;
        this.createdAt = createdAt;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEntity() {
        return entity;
    }

    public void setEntity(String entity) {
        this.entity = entity;
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
        FoundationInstance foundationInstance = (FoundationInstance) o;
        return Objects.equals(id, foundationInstance.id) && Objects.equals(entity, foundationInstance.entity)
               && Objects.equals(createdAt, foundationInstance.createdAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, entity, createdAt, super.hashCode());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class FoundationInstance {\n");

        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    entity: ").append(toIndentedString(entity)).append("\n");
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
