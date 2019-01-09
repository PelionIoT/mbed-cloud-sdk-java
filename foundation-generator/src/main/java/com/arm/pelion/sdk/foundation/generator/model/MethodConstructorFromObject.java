package com.arm.pelion.sdk.foundation.generator.model;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

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
        code.addStatement("this(" + String.join("," + System.lineSeparator(), fields.stream().map(f -> {
            if (f.getType().isBoolean() && f.getJavaDefaultBooleanValue() == false) {
                return parameterName + " != null && " + parameterName + "." + f.getName();
            }
            return parameterName + " == null ? " + f.getJavaDefaultValue() + " : " + parameterName + "." + f.getName();
        }).collect(Collectors.toList())) + ")");
    }

    @Override
    public List<String> getSignature() {
        final List<String> list = new LinkedList<>();
        list.add(parameter.getType().getShortName());
        return list;
    }
}
