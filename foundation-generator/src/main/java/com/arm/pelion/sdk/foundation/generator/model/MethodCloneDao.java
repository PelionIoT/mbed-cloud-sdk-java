package com.arm.pelion.sdk.foundation.generator.model;

import com.arm.mbed.cloud.sdk.common.MbedCloudException;
import com.arm.mbed.cloud.sdk.common.dao.AbstractCloudDao;

public class MethodCloneDao extends MethodClone {

    private final String shortName;

    public MethodCloneDao(Model currentModel, Model parentModel) {
        super(currentModel, parentModel);
        shortName = determineClassShortName(currentModel);
        initialiseCodeBuilder();
    }

    @Override
    protected String generateStatement(String shortName) {
        return null;
    }

    @Override
    protected void addAnnotations() {
        super.addAnnotations();
    }

    @Override
    protected void translateCode() {
        code.beginControlFlow("try");
        code.addStatement("return new " + shortName + "()." + AbstractCloudDao.METHOD_CONFIGURE_AND_GET + "("
                          + AbstractCloudDao.FIELD_NAME_MODULE + "==null? null: " + AbstractCloudDao.FIELD_NAME_MODULE
                          + ".clone())");
        code.endControlFlow();
        code.beginControlFlow("catch($T exception)", MbedCloudException.class);
        code.addStatement("return null");
        code.endControlFlow();
    }

}
