package com.arm.pelion.sdk.foundation.generator.model;

import com.arm.mbed.cloud.sdk.common.ApiUtils;

public class ListOptionModel extends Model {

    public ListOptionModel(Model model, String description, boolean needsCustomCode) {
        super(model.getPackageName(), generateName(model.getName()), model.getGroup(),
              generateDescription(model.getName(), description), null, needsCustomCode, false);
    }

    private static String generateDescription(String name, String description) {
        return description == null ? "Options to use when listing "
                                     + ApiUtils.convertCamelToSnake(name).replace("_", " ").trim() + "s"
                                   : description;
    }

    private static String generateName(String name) {
        return ApiUtils.convertSnakeToCamel(ApiUtils.convertCamelToSnake(name) + "_list_options", true);
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
    protected void generateMethodsDependingOnParents(Model theParent) {
        super.generateMethodsDependingOnParents(theParent);
        generateSetDefault(theParent);
        generateSetOptions(theParent);
    }

    private void generateSetOptions(Model theParent) {
        if (hasFields()) {
            overrideMethodIfExist(new MethodListOptionsSetOptions(this, theParent));
        }

    }

    private void generateSetDefault(Model theParent) {
        if (hasFields()) {
            overrideMethodIfExist(new MethodListOptionsSetDefault(this, theParent));
        }
    }

    @Override
    protected void generateToString(Model theParent) {
        overrideMethodIfExist(new MethodListOptionsToString(this, theParent));
    }

    @Override
    protected MethodClone instantiateCloneMethod(Model theParent) {
        return new MethodListOptionsClone(this, theParent);
    }
}
