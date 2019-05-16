package com.arm.pelion.sdk.foundation.generator.model;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import com.arm.pelion.sdk.foundation.generator.util.TranslationException;

public class MethodIsValid extends AbstractMethodBasedOnModel {

    public static final String IDENTIFIER = "isValid";

    public MethodIsValid(Model currentModel, Model parentModel) {
        super(currentModel, parentModel, false, IDENTIFIER, "Checks whether the model is valid or not",
              "@see SdkModel#isValid()", false, true, false, false,
              currentModel == null ? false : currentModel.needsFieldCustomisation(), false, false,
              findWhetherOverriding(currentModel, parentModel));
        setReturnType(TypeFactory.getCorrespondingType(boolean.class));
        setReturnDescription("true if the model is valid; false otherwise.");
        initialiseCodeBuilder();
    }

    private static boolean findWhetherOverriding(Model currentModel, Model parentModel) {
        return parentModel != null || (currentModel != null && currentModel.hasParent());
    }

    /*
     * (non-Javadoc)
     *
     * @see com.arm.pelion.sdk.foundation.generator.model.Method#translateCode()
     */
    @Override
    protected void translateCode() throws TranslationException {
        super.translateCode();
        List<String> validationMethodList = hasCurrentModel() ? currentModel.getMethodList().stream()
                                                                            .filter(m -> m instanceof MethodIsFieldValid)
                                                                            .map(m -> m.getName() + "()")
                                                                            .collect(Collectors.toList())
                                                              : null;
        if (hasParentModel() || (hasCurrentModel() && currentModel.hasParent())) {
            if (validationMethodList == null) {
                validationMethodList = new LinkedList<>();
            }
            validationMethodList.add("super." + getName() + "()");
        } else if (validationMethodList == null) {
            code.addStatement("return true");
            return;
        }
        if (validationMethodList.isEmpty()) {
            code.addStatement("return true");
            return;
        }
        shouldTest(true);
        String methodValue = String.join(System.lineSeparator() + "&& ", validationMethodList);
        code.addStatement("return " + methodValue);
    }

}
