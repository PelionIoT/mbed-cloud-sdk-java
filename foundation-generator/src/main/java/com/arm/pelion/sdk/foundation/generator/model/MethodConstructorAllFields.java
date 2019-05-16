package com.arm.pelion.sdk.foundation.generator.model;

import java.util.List;
import java.util.stream.Collectors;

public class MethodConstructorAllFields extends AbstractMethodConstructorWithFieldParameters {
    private static final String CONSTRUCTOR_DESCRIPTION = "Constructor based on all fields.";
    public static final String IDENTIFIER = new MethodConstructorAllFields(null, null).getIdentifier();
    private boolean callSuperConstructor;

    public MethodConstructorAllFields(Model currentModel, Model parentModel) {
        super(CONSTRUCTOR_DESCRIPTION, currentModel, parentModel, null, null, hasFields(currentModel, parentModel));
        callSuperConstructor = true;
    }

    private static boolean hasFields(Model currentModel, Model parentModel) {
        if (currentModel == null) {
            return false;
        }
        if (currentModel.hasFields()) {
            return true;
        }
        return parentModel == null ? false : parentModel.hasFields();
    }

    @Override
    protected void translateCode() {
        if (callSuperConstructor) {
            if (hasParentModel()) {
                final List<Field> parentFields = parentModel.getFieldList();
                code.addStatement("super(" + String.join("," + System.lineSeparator(),
                                                         parentFields.stream().filter(f -> !f.isAlreadyDefined())
                                                                     .map(f -> f.toParameter().getName())
                                                                     .collect(Collectors.toList()))
                                  + ")");
            } else {
                code.addStatement("super()");
            }
        }
        if (hasCurrentModel()) {
            currentModel.getFieldList().stream()
                        .filter(f -> (f.isReadOnly() && !f.isIdentifier()) || f.isAlreadyDefined())
                        .forEach(f -> code.addStatement("this.$L = $L", f.getName(), f.toParameter().getName()));
            currentModel.getFieldList().stream()
                        .filter(f -> (!f.isReadOnly() || f.isIdentifier()) && !f.isAlreadyDefined())
                        .forEach(f -> code.addStatement("$L($L)", (new MethodSetter(f)).getName(),
                                                        f.toParameter().getName()));
        }
    }

    @Override
    protected void setFields() {
        setFields(getFieldList());

    }

    @Override
    public List<Field> getFieldList() {
        return getAllFields();
    }

    /**
     * @return the callSuperConstructor
     */
    public boolean isCallSuperConstructor() {
        return callSuperConstructor;
    }

    /**
     * @param callSuperConstructor
     *            the callSuperConstructor to set
     */
    public void setCallSuperConstructor(boolean callSuperConstructor) {
        this.callSuperConstructor = callSuperConstructor;
    }

    @SuppressWarnings("unchecked")
    public <T extends MethodConstructorAllFields> T callSuperConstructor(boolean callSuperConstructor) {
        setCallSuperConstructor(callSuperConstructor);
        return (T) this;
    }
}
