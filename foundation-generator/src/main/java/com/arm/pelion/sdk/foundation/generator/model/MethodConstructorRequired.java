package com.arm.pelion.sdk.foundation.generator.model;

import java.util.List;
import java.util.stream.Collectors;

public class MethodConstructorRequired extends AbstractMethodConstructorWithFieldParameters {
    public MethodConstructorRequired(Model currentModel, Model parentModel) {
        super(currentModel, parentModel, null, null, false);
    }

    /*
     * (non-Javadoc)
     *
     * @see com.arm.pelion.sdk.foundation.generator.model.AbstractMethodConstructorWithFieldParameters#setFields()
     */
    @Override
    protected void setFields() {
        setFields(this.getFieldList(false, true, false, false, false));
    }

    @Override
    protected void translateCode() {
        final List<Field> allFields = getAllFields();
        code.addStatement("this(" + String.join("," + System.lineSeparator(),
                                                allFields.stream()
                                                         .map(f -> f.isRequired() ? f.toParameter().getName()
                                                                                  : f.getJavaDefaultValue())
                                                         .collect(Collectors.toList()))
                          + ")");
    }
}
