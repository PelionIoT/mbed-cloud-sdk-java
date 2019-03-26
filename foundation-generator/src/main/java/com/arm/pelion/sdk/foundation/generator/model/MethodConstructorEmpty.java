package com.arm.pelion.sdk.foundation.generator.model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import com.arm.pelion.sdk.foundation.generator.model.ValueGenerator.Values;

public class MethodConstructorEmpty extends AbstractMethodConstructor {

    private boolean useParent;

    public MethodConstructorEmpty(Model currentModel, Model parentModel) {
        super(currentModel, parentModel, null, null, false);
        setUseParent(false);
    }

    @Override
    protected void addConstructorParameters() {
        // Nothing to do

    }

    public boolean isUseParent() {
        return useParent;
    }

    public void setUseParent(boolean useParent) {
        this.useParent = useParent;
    }

    public MethodConstructorEmpty useParent(boolean useParent) {
        setUseParent(useParent);
        return this;
    }

    @Override
    protected void translateCode() {
        final List<Field> fields = getAllFields();
        final Values values = new Values();
        fields.forEach(f -> values.add(f.getJavaDefaultValue()));
        if (useParent) {
            code.addStatement("super(" + String.join("," + System.lineSeparator(), values.getFormats()) + ")",
                              values.getValuesArray());
            code.addStatement("// Nothing to do");
        } else {
            code.addStatement("this(" + String.join("," + System.lineSeparator(), values.getFormats()) + ")",
                              values.getValuesArray());
        }
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

    @Override
    public List<Field> getFieldList() {
        return new ArrayList<>();
    }

}
