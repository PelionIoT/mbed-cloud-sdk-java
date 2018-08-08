package com.arm.pelion.sdk.foundation.generator.model;

import com.arm.pelion.sdk.foundation.generator.Entity;

public interface ModelEntity extends Entity {

    void setContainsCustomCode(boolean containsCustomCode);

    boolean containsCustomCode();

    void setAbstract(boolean isAbstract);

    boolean isAbstract();

    void setNeedsCustomCode(boolean needsCustomCode);

    void setDescription(String description);

    void setName(String name);

    boolean needsCustomCode();

    String getDescription();

    String getName();

    String getIdentifier();

    boolean isAccessible();

    boolean isReadOnly();

    void setAccessible(boolean isAccessible);

    boolean isStatic();

    void setReadOnly(boolean isReadOnly);

    void setStatic(boolean isStatic);

    boolean hasName();

    boolean isInternal();

    void setInternal(boolean isInternal);

    void setLongDescription(String longDescription);

    String getLongDescription();

    boolean hasLongDescription();

    boolean hasDescription();

    <T extends ModelEntity> T needsCustomCode(boolean needsCustomCode);

}
