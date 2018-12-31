package com.arm.pelion.sdk.foundation.generator.model;

import com.arm.mbed.cloud.sdk.annotations.Nullable;
import com.arm.mbed.cloud.sdk.common.dao.AbstractCloudDao;

public class MethodDaoClone extends MethodClone {

    private final String shortName;

    public MethodDaoClone(Model currentModel, Model parentModel) {
        super(currentModel, parentModel);
        shortName = determineClassShortName(currentModel);
        initialiseBuilder();

    }

    @Override
    protected String generateStatement(String shortName) {
        return null;
    }

    @Override
    protected void addAnnotations() {
        super.addAnnotations();
        specificationBuilder.addAnnotation(Nullable.class);
    }

    @Override
    protected void translateCode() {
        code.beginControlFlow("try");
        code.addStatement("return new " + shortName + "()." + AbstractCloudDao.METHOD_CONFIGURE_AND_GET + "("
                          + AbstractCloudDao.FIELD_NAME_MODULE + "==null? null: " + AbstractCloudDao.FIELD_NAME_MODULE
                          + ".clone())");
        code.beginControlFlow("catch(Exception exception)");
        code.addStatement("return null");
        code.endControlFlow();
    }

}
