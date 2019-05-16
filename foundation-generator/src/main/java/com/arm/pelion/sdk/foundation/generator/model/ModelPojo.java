package com.arm.pelion.sdk.foundation.generator.model;

import com.arm.mbed.cloud.sdk.common.listing.filtering.Filters;
import com.arm.pelion.sdk.foundation.generator.util.TranslationException;

public class ModelPojo extends Model {
    private final Renames fieldRenames;

    public ModelPojo() {
        super();
        this.fieldRenames = null;
    }

    public ModelPojo(String packageName, String name, String group, String description, String longDescription,
                     boolean isAbstract, boolean needsCustomCode, boolean containsCustomCode, boolean isInternal,
                     Renames fieldRenames) {
        super(packageName, name, group, description, longDescription, isAbstract, needsCustomCode, containsCustomCode,
              isInternal);
        this.fieldRenames = fieldRenames;
    }

    public ModelPojo(String packageName, String name, String group, String description, String longDescription,
                     boolean needsCustomCode, boolean isInternal, Renames fieldRenames) {
        super(packageName, name, group, description, longDescription, needsCustomCode, isInternal);
        this.fieldRenames = fieldRenames;
    }

    public ModelPojo(String packageName, String name, String group, Renames fieldRenames) {
        super(packageName, name, group);
        this.fieldRenames = fieldRenames;
    }

    public ModelPojo(Class<?> clazz) {
        super(clazz);
        this.fieldRenames = null;
    }

    public ModelPojo(Class<?> clazz, TypeParameter genericType) {
        super(clazz, genericType);
        this.fieldRenames = null;
    }

    @Override
    public Field fetchField(String identifier) {
        final Field field = super.fetchField(identifier);
        return field == null ? fieldRenames == null ? null : super.fetchField(fieldRenames.getRenamedField(identifier))
                             : field;
    }

    @Override
    protected Model generateEmptyChildModel() {
        return new ModelPojo(packageName, name, group, description, longDescription, false, false, true, isInternal,
                             fieldRenames);
    }

    @Override
    protected Model generateEmptyAbstractModel() {
        return new ModelPojo(packageName, name, group, description, longDescription, true, false, false, isInternal,
                             null);
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

    @Override
    protected void generateOtherMethods() {
        super.generateOtherMethods();
        if (fieldRenames != null && !fieldRenames.isEmpty()) {
            addMethod(new MethodGenerateFilterMapping(fieldRenames));
        }
    }

    @Override
    protected void translateConstants() throws TranslationException {
        addFilterMapping();
        super.translateConstants();
    }

    private void addFilterMapping() {
        if (fieldRenames != null && !fieldRenames.isEmpty()) {
            final Field filterMapping = new Field(true, new TypeHashtable(String.class), "filterMapping",
                                                  "Mapping needed for encoding or decoding filters.",
                                                  "Filters are used when listing models. See {@link " + Filters.class.getName()
                                                                                                      + "}",
                                                  null, true, false, true, false, null, false);
            filterMapping.setAccessible(true);
            filterMapping.setInitialiser(MethodGenerateFilterMapping.METHOD_NAME + "()");
            addConstant(filterMapping);
        }
    }

}
