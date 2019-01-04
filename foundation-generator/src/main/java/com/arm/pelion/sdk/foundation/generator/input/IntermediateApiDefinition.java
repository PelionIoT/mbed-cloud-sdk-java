package com.arm.pelion.sdk.foundation.generator.input;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class IntermediateApiDefinition {
    @JsonProperty(InputSchema.ENTITIES_TAG)
    private List<Entity> entities;
    @JsonProperty(InputSchema.ENUMS_TAG)
    private List<Enumerator> enums;
    @JsonProperty(InputSchema.GROUPS_TAG)
    private List<Group> groups;

    public IntermediateApiDefinition() {
    }

    /**
     * @return the entities
     */
    public List<Entity> getEntities() {
        return entities;
    }

    public boolean hasEntities() {
        return entities != null && !entities.isEmpty();
    }

    public boolean hasGroups() {
        return groups != null && !entities.isEmpty();
    }

    public List<Group> getGroups() {
        return groups;
    }

    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }

    /**
     * @param entities
     *            the entities to set
     */
    public void setEntities(List<Entity> entities) {
        this.entities = entities;
    }

    public List<Enumerator> getEnums() {
        return enums;
    }

    public void setEnums(List<Enumerator> enums) {
        this.enums = enums;
    }

    public boolean hasEnums() {
        return enums != null && !enums.isEmpty();
    }

    public void clear() {
        if (entities != null) {
            entities.clear();
        }
        if (enums != null) {
            enums.clear();
        }
        if (groups != null) {
            groups.clear();
        }
    }

    @Override
    public String toString() {
        return "IntermediateApiDefinition [entities=" + entities + ", enums=" + enums + ", groups=" + groups + "]";
    }

}
