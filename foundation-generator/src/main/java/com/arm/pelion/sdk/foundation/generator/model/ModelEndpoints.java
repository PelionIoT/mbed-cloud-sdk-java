package com.arm.pelion.sdk.foundation.generator.model;

import com.arm.mbed.cloud.sdk.common.AbstractEndpoints;
import com.arm.pelion.sdk.foundation.generator.util.Utils;

public class ModelEndpoints extends ModelMergeable {

    public ModelEndpoints(Model model, String description, boolean needsCustomCode) {
        super(model.getPackageName(), generateName(model.getGroup()), model.getGroup(),
              generateDescription(model.getGroup(), description), null, false, true);
        setSuperClassType(TypeFactory.getCorrespondingType(AbstractEndpoints.class));
    }

    private static String generateDescription(String group, String description) {
        return description == null ? "Endpoints for " + group + " APIs module" : description;
    }

    public static String generateName(String group) {
        return group == null ? null : Utils.combineNames(true, group, "endpoints");
    }

    @Override
    protected boolean hasSuperInterface() {
        return false;
    }

    @Override
    protected boolean isSerialisable() {
        return false;
    }

    @Override
    protected void generateHashCodeAndEquals() {
        // Do not generate anything
    }

    @Override
    protected void generateMethodsDependingOnParents(Model theParent) {
        addConstructor(new MethodEndpointsConstructorFromServiceStore(this, theParent));
        overrideMethodIfExist(new MethodEndpointsClone(this, theParent));
    }

    public void addModule(Class<?> moduleClazz) {
        if (moduleClazz != null) {
            addField(generateCorrespondingField(moduleClazz));
        }

    }

    public static Field generateCorrespondingField(Class<?> moduleClazz) {
        return new Field(true, TypeFactory.getCorrespondingType(moduleClazz), moduleClazz.getSimpleName(),
                         "Low level endpoints for " + Utils.generateDocumentationString(moduleClazz.getSimpleName(),
                                                                                        true),
                         null, null, null, null, false, false, true, false, null, false);
    }

}
