package com.arm.pelion.sdk.foundation.generator.model;

import java.util.List;
import java.util.stream.Collectors;

public class MethodConstructorReadOnly extends AbstractMethodConstructorWithFieldParameters {

    public MethodConstructorReadOnly(Model currentModel, Model parentModel) {
        super(currentModel, parentModel, null, null, true);
    }

    @Override
    protected void translateCode() {
        final List<Field> allFields = this.getFieldList(false, false, true, false);
        code.addStatement("this("
                          + String.join("," + System.lineSeparator(),
                                        allFields.stream()
                                                 .map(f -> f.isReadOnly() ? f.toParameter().getName()
                                                                          : f.getJavaDefaultValue())
                                                 .collect(Collectors.toList()))
                          + ")");
    }

    @Override
    protected void setFields() {
        setFields(this.getFieldList(true, false, false, false));

    }
}
