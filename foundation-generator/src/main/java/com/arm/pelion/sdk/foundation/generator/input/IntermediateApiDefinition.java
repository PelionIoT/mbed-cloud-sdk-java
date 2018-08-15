package com.arm.pelion.sdk.foundation.generator.input;

import java.util.List;

public class IntermediateApiDefinition {

    private List<Entity> entities;

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

    public void clear() {
        if (entities != null) {
            entities.clear();
        }
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "IntermediateApiDefinition [entities=" + entities + "]";
    }

}
