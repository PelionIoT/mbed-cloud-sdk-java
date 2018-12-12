package com.arm.pelion.sdk.foundation.generator.model;

public class ModelMergeable extends Model implements MergeableArtifact {

    public ModelMergeable() {
        super();
    }

    public ModelMergeable(Class<?> clazz, TypeParameter genericType) {
        super(clazz, genericType);
    }

    public ModelMergeable(Class<?> clazz) {
        super(clazz);
    }

    public ModelMergeable(String packageName, String name, String group, String description, String longDescription,
                          boolean isAbstract, boolean needsCustomCode, boolean containsCustomCode, boolean isInternal) {
        super(packageName, name, group, description, longDescription, isAbstract, needsCustomCode, containsCustomCode,
              isInternal);
    }

    public ModelMergeable(String packageName, String name, String group, String description, String longDescription,
                          boolean needsCustomCode, boolean isInternal) {
        super(packageName, name, group, description, longDescription, needsCustomCode, isInternal);
    }

    public ModelMergeable(String packageName, String name, String group) {
        super(packageName, name, group);
    }

    @Override
    public <T extends MergeableArtifact> void merge(T otherArtifact) {
        if (otherArtifact == null || this == otherArtifact || !getClass().isAssignableFrom(otherArtifact.getClass())) {
            return;
        }
        final ModelMergeable otherEndpoints = (ModelMergeable) otherArtifact;
        if (otherEndpoints.methods != null) {
            otherEndpoints.methods.values().forEach(m -> addMethod(m));
        }
        if (otherEndpoints.fields != null) {
            otherEndpoints.fields.values().forEach(f -> addField(f));
        }
    }

}
