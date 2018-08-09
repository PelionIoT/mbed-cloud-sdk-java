package com.arm.pelion.sdk.foundation.generator.model;

import java.util.List;
import java.util.stream.Collectors;

public class MethodConstructorAllFields extends AbstractMethodConstructorWithFieldParameters {

    private boolean callSuperConstructor;

    public MethodConstructorAllFields(Model currentModel, Model parentModel) {
        super(currentModel, parentModel, null, null, true);
        callSuperConstructor = true;
    }

    @Override
    protected void translateCode() {
        if (callSuperConstructor) {
            if (hasParentModel()) {
                final List<Field> parentFields = parentModel.getFieldList();
                code.addStatement("super(" + String.join("," + System.lineSeparator(),
                                                         parentFields.stream().map(f -> f.toParameter().getName())
                                                                     .collect(Collectors.toList()))
                                  + ")");
            } else {
                code.addStatement("super()");
            }
        }
        if (hasCurrentModel()) {
            currentModel.getFieldList().stream().filter(f -> f.isReadOnly() && !f.isIdentifier())
                        .forEach(f -> code.addStatement("this.$L = $L", f.getName(), f.toParameter().getName()));
            currentModel.getFieldList().stream().filter(f -> !f.isReadOnly() || f.isIdentifier())
                        .forEach(f -> code.addStatement("$L($L)", (new MethodSetter(f)).getName(),
                                                        f.toParameter().getName()));
        }
    }

    @Override
    protected void setFields() {
        setFields(this.getFieldList(false, false, true, false));

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

    public <T extends MethodConstructorAllFields> T callSuperConstructor(boolean callSuperConstructor) {
        setCallSuperConstructor(callSuperConstructor);
        return (T) this;
    }
}
