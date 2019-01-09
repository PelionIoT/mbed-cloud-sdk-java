package com.arm.pelion.sdk.foundation.generator.model;

import com.arm.pelion.sdk.foundation.generator.util.TranslationException;

public class MethodCanEqual extends AbstractMethodBasedOnModel {

    public static final String IDENTIFIER = "canEqual";
    private static final String PARAMETER_NAME = "other";

    public MethodCanEqual(Model currentModel, Model parentModel) {
        super(currentModel, parentModel, false, IDENTIFIER, " Method to ensure {@link #equals(Object)} is correct.",
              " Note: see this article: <a href=\"https://www.artima.com/lejava/articles/equality.html\">canEqual()</a>",
              false, false, false, false, false, false, false, false);
        setReturnType(TypeFactory.getCorrespondingType(boolean.class));
        addParameter(new Parameter(PARAMETER_NAME, "another object", null,
                                   TypeFactory.getCorrespondingType(Object.class), null));
        setReturnDescription("true if the other object is an instance of the class in which canEqual is (re)defined, false otherwise.");
        initialiseCodeBuilder();
        shouldTest(true);
    }

    /*
     * (non-Javadoc)
     *
     * @see com.arm.pelion.sdk.foundation.generator.model.Method#translateCode()
     */
    @Override
    protected void translateCode() throws TranslationException {
        super.translateCode();
        code.addStatement("return $L instanceof $L", PARAMETER_NAME, currentModel.getName());
    }

}
