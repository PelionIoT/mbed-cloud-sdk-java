package com.arm.pelion.sdk.foundation.generator.model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import com.arm.pelion.sdk.foundation.generator.model.ValueGenerator.Values;

public class MethodConstructorFromObject extends AbstractMethodConstructor {
    protected Parameter parameter;

    public MethodConstructorFromObject(Model currentModel, Model parentModel) {
        super(currentModel, parentModel, null, null, true);
        setParameter();
    }

    @Override
    protected void addConstructorParameters() {
        setParameter();
        addParameter(parameter);

    }

    private void setParameter() {
        if (parameter == null && hasCurrentModel()) {
            parameter = currentModel.toParameter();
        }
    }

    @Override
    protected void translateCode() {

        final String parameterName = parameter == null ? "unknown" : parameter.getName();
        final List<Field> fields = getAllFields();
        final Values values = new Values();
        fields.forEach(f -> {
            String get = f.needsCustomCode() ? MethodGetter.getCorrespondingGetterMethodName(f.getName(),
                                                                                             f.getType().isBoolean(),
                                                                                             false)
                                               + "()"
                                             : f.getName();
            if (f.getType().isBoolean() && f.getJavaDefaultBooleanValue() == false) {
                values.addToFormat("$L != null && $L.$L");
                values.addValue(parameterName);
                values.addValue(parameterName);
                values.addValue(get);
                return;
            }
            final Values defaultValues = f.getJavaDefaultValue();
            values.addToFormat("$L  == null ? " + String.join("", defaultValues.getFormats()) + " : $L.$L");
            values.addValue(parameterName);
            values.addValue(defaultValues.getValues());
            values.addValue(parameterName);
            values.addValue(get);
        });
        code.addStatement("this(" + String.join("," + System.lineSeparator(), values.getFormats()) + ")",
                          values.getValuesArray());
    }

    @Override
    public List<String> getSignature() {
        final List<String> list = new LinkedList<>();
        list.add(parameter.getType().getShortName());
        return list;
    }

    @Override
    public List<Field> getFieldList() {
        return new ArrayList<>();
    }
}
