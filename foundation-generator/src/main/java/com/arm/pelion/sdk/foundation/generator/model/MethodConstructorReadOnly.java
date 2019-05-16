package com.arm.pelion.sdk.foundation.generator.model;

import java.util.List;

import com.arm.pelion.sdk.foundation.generator.model.ValueGenerator.Values;

public class MethodConstructorReadOnly extends AbstractMethodConstructorWithFieldParameters {

    public static final String IDENTIFIER = new MethodConstructorReadOnly(null, null).getIdentifier();
    private static final String CONSTRUCTOR_DESCRIPTION = "Constructor based on read-only fields.";

    public MethodConstructorReadOnly(Model currentModel, Model parentModel) {
        super(CONSTRUCTOR_DESCRIPTION, currentModel, parentModel, null, null, true);
    }

    @Override
    protected void translateCode() {
        final List<Field> allFields = getAllFields();
        final Values values = new Values();
        allFields.forEach(f -> {
            if (f.isReadOnly()) {
                values.addToFormat("$L");
                values.addValue(f.toParameter().getName());

            } else {
                values.add(f.getJavaDefaultValue());
            }
        });

        code.addStatement("this(" + String.join("," + System.lineSeparator(), values.getFormats())

                          + ")", values.getValuesArray());
    }

    @Override
    protected void setFields() {
        setFields(getFieldList());

    }

    @Override
    public List<Field> getFieldList() {
        return this.getFieldList(true, false, false, false, false);
    }

}
