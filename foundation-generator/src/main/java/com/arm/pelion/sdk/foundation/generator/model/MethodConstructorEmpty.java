package com.arm.pelion.sdk.foundation.generator.model;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class MethodConstructorEmpty extends AbstractMethodConstructor {

    public MethodConstructorEmpty(Model currentModel, Model parentModel) {
        super(currentModel, parentModel, null, null, false);
    }

    @Override
    protected void addConstructorParameters() {
        // Nothing to do

    }

    @Override
    protected void translateCode() {
        final List<Field> fields = this.getFieldList(false, false, true, false);
        code.addStatement("this("
                          + String.join("," + System.lineSeparator(),
                                        fields.stream().map(f -> f.getJavaDefaultValue()).collect(Collectors.toList()))
                          + ")");
    }

    /*
     * (non-Javadoc)
     *
     * @see com.arm.pelion.sdk.foundation.generator.model.AbstractMethodConstructor#getSignature()
     */
    @Override
    public List<String> getSignature() {
        return new LinkedList<>();
    }

}
