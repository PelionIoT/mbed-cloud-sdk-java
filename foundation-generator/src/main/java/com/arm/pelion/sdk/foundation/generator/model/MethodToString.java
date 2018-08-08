package com.arm.pelion.sdk.foundation.generator.model;

import java.util.List;
import java.util.stream.Collectors;

import com.squareup.javapoet.CodeBlock;

public class MethodToString extends AbstractMethodBasedOnModel {

    public MethodToString(Model currentModel, Model parentModel) {
        super(currentModel, parentModel, false, "toString", "Returns a string representation of the object.",
              "@see java.lang.Object#toString()", false, true, false, false,
              currentModel == null ? false : currentModel.needsFieldCustomisation(), false, false, true);
        setReturnType(new ParameterType(String.class));
        setReturnDescription("the string reprensation");
        setCode(CodeBlock.builder());
    }

    /*
     * (non-Javadoc)
     *
     * @see com.arm.pelion.sdk.foundation.generator.model.Method#translateCode()
     */
    @Override
    protected void translateCode() {
        super.translateCode();
        code.addStatement("return " + generateFullString(currentModel, parentModel));
    }

    private static String generateFullString(Model currentModel, Model parentModel) {
        if (currentModel == null) {
            return "";
        }
        StringBuilder builder = new StringBuilder();
        builder.append("\"").append(currentModel.getName()).append(" [")
               .append(generateFlattenedListOfElements(currentModel.getFieldList()));
        if (parentModel != null && parentModel.hasFields()) {
            builder.append(" + \", ").append(generateFlattenedListOfElements(parentModel.getFieldList()));
        }
        builder.append(" + \"]\"");
        return builder.toString();

    }

    private static String generateFlattenedListOfElements(List<Field> fields) {
        return fields == null ? "" : String.join(System.lineSeparator() + "+ \", ", fields.stream().map(f -> {
            return f.getName() + "=\" + " + f.getName();
        }).collect(Collectors.toList()));

    }
}
