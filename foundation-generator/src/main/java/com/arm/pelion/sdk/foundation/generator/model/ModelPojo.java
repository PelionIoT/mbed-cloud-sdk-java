package com.arm.pelion.sdk.foundation.generator.model;

public class ModelPojo extends Model {

    public ModelPojo() {
        super();
    }

    public ModelPojo(String packageName, String name, String group, String description, String longDescription,
                     boolean isAbstract, boolean needsCustomCode, boolean containsCustomCode, boolean isInternal) {
        super(packageName, name, group, description, longDescription, isAbstract, needsCustomCode, containsCustomCode,
              isInternal);
    }

    public ModelPojo(String packageName, String name, String group, String description, String longDescription,
                     boolean needsCustomCode, boolean isInternal) {
        super(packageName, name, group, description, longDescription, needsCustomCode, isInternal);
    }

    public ModelPojo(String packageName, String name, String group) {
        super(packageName, name, group);
    }

    public ModelPojo(Class<?> clazz) {
        super(clazz);
    }

    public ModelPojo(Class<?> clazz, TypeParameter genericType) {
        super(clazz, genericType);
    }

    @Override
    protected Model generateEmptyChildModel() {
        return new ModelPojo(packageName, name, group, description, longDescription, false, false, true, isInternal);
    }

    @Override
    protected Model generateEmptyAbstractModel() {
        return new ModelPojo(packageName, name, group, description, longDescription, true, false, false, isInternal);
    }

    @Override
    protected void addSpecificAbstractMethods(final Model abstractModel) {
        abstractModel.addMethod(new MethodCloneAbstractModel());
    }

    @Override
    protected void modifyChildMethod(Method m) {
        super.modifyChildMethod(m);
        if (!(m instanceof MethodGetter || m instanceof MethodSetter)) {
            m.setAsOverride(true);
        }
    }

}
