package com.arm.pelion.sdk.foundation.generator.model;

import java.util.List;

import com.arm.pelion.sdk.foundation.generator.model.ValueGenerator.Values;

public class MethodConstructorRequired extends AbstractMethodConstructorWithFieldParameters {
    private static final String CONSTRUCTOR_DESCRIPTION = "Constructor based on required fields.";

    public MethodConstructorRequired(Model currentModel, Model parentModel) {
        super(CONSTRUCTOR_DESCRIPTION, currentModel, parentModel, null, null, false);
    }

    /*
     * (non-Javadoc)
     *
     * @see com.arm.pelion.sdk.foundation.generator.model.AbstractMethodConstructorWithFieldParameters#setFields()
     */
    @Override
    protected void setFields() {
        setFields(getFieldList());
    }

    @Override
    public List<Field> getFieldList() {
        return this.getFieldList(false, true, false, false, false);
    }

    @Override
    protected void translateCode() {
        final List<Field> allFields = getAllFields();
        final Values values = new Values();
        allFields.forEach(f -> {
            if (f.isRequired()) {
                values.addToFormat("$L");
                values.addValue(f.toParameter().getName());
            } else {
                values.add(f.getJavaDefaultValue());
            }
        });
        code.addStatement("this(" + String.join("," + System.lineSeparator(), values.getFormats()) + ")",
                          values.getValuesArray());
    }
}
