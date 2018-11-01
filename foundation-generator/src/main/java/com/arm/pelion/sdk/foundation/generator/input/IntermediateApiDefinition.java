package com.arm.pelion.sdk.foundation.generator.input;

import java.util.List;

public class IntermediateApiDefinition {

    private List<Entity> entities;
    private List<Enumerator> enums;

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
    }

    @Override
    public String toString() {
        return "IntermediateApiDefinition [entities=" + entities + ", enums=" + enums + "]";
    }

}
