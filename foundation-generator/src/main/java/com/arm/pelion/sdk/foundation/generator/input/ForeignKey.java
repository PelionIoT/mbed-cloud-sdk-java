package com.arm.pelion.sdk.foundation.generator.input;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ForeignKey {
    @JsonProperty(InputSchema.FOREIGN_ENTITY_REFERENCE_TAG)
    private String entityRef;
    @JsonProperty(InputSchema.GROUP_ID_REFERENCE_TAG)
    private List<String> groupId;

    public ForeignKey() {
        super();
        entityRef = null;
        groupId = null;
    }

    public String getEntityRef() {
        return entityRef;
    }

    public void setEntityRef(String entityRef) {
        this.entityRef = Utils.getKey(entityRef, false);
    }

    public List<String> getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = Utils.getGroupId(groupId);
    }

    @Override
    public String toString() {
        return "ForeignKey [entityRef=" + entityRef + ", groupId=" + groupId + "]";
    }

}
