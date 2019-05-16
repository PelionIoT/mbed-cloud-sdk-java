package com.arm.pelion.sdk.foundation.generator.input;

import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Group {

    @JsonProperty(InputSchema.KEY_TAG)
    private List<String> groupId;

    @JsonProperty(InputSchema.ENTITIES_TAG)
    private List<String> entities;

    @JsonProperty(InputSchema.ENUMS_TAG)
    private List<String> enums;

    public Group() {
        groupId = null;
        entities = null;
        enums = null;
    }

    /**
     * @param groupId
     *            the groupId to set
     */
    public void setGroupId(String groupId) {
        this.groupId = Utils.getGroupId(groupId);
    }

    public List<String> getGroupId() {
        return groupId;
    }

    public void setGroupId(List<String> groupId) {
        this.groupId = groupId;
    }

    public boolean hasEntities() {
        return entities != null && !entities.isEmpty();
    }

    public boolean hasEnums() {
        return enums != null && !enums.isEmpty();
    }

    public List<String> getEntities() {
        return entities;
    }

    public List<String> getEnums() {
        return enums;
    }

    public void setEnums(List<String> enums) {
        this.enums = enums == null ? null
                                   : enums.stream().map(e -> Utils.getKey(e, false)).collect(Collectors.toList());
    }

    public void setEntities(List<String> entities) {
        this.entities = entities == null ? null : entities.stream().map(e -> Utils.getKey(e, false))
                                                          .collect(Collectors.toList());
    }

}
