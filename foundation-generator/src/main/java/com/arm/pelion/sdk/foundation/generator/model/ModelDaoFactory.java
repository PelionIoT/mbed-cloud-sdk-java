package com.arm.pelion.sdk.foundation.generator.model;

import com.arm.mbed.cloud.sdk.common.MbedCloudException;
import com.arm.mbed.cloud.sdk.common.SdkContext;
import com.arm.mbed.cloud.sdk.common.dao.AbstractCloudDao;
import com.arm.mbed.cloud.sdk.common.dao.DaoProvider;
import com.arm.pelion.sdk.foundation.generator.util.Utils;

public class ModelDaoFactory extends Model {

    private static final String FIELD_NAME_CONTEXT = "context";

    public ModelDaoFactory() {
        super();
        setShouldBeSorted(true);
    }

    public ModelDaoFactory(String packageName) {
        super(packageName, "DaoFactory", null, "Factory for SDK DAOs",
              "Utility for fetching DAOs similar to " + DaoProvider.class.getSimpleName()
                                                                       + " but without using reflection",
              false, false, false, true);

        addFields();
    }

    private void addFields() {
        Field context = new Field(true, TypeFactory.getCorrespondingType(SdkContext.class), FIELD_NAME_CONTEXT,
                                  "Context.", null, null, false, false, true, true, null, false);

        addField(context);

    }

    @Override
    protected void addConstructor(AbstractMethodConstructor constructor) {
        if (constructor != null) {
            constructor.changeInternalStatus(false);
        }
        super.addConstructor(constructor);
    }

    @Override
    protected Class<?> getSuperInterface() {
        return Cloneable.class;
    }

    @Override
    protected boolean isSerialisable() {
        return false;
    }

    @Override
    protected void generateIsValid(Model theParent) {
        // Nothing to do
    }

    public void addDao(ModelDao dao) {
        if (dao == null) {
            return;
        }
        final Method daoGetter = new Method(false,
                                            MethodGetter.getCorrespondingGetterMethodName(dao.getName(), false, false),
                                            "Gets " + Utils.generateDocumentationString(dao.getName()), null, false,
                                            true, false, false, false, false, false, false);
        daoGetter.addException(MbedCloudException.class);
        TypeParameter daoType = dao.toType();
        try {
            daoType.translate();
        } catch (Exception exception) {
            // Nothing to do
            exception.printStackTrace();
        }
        daoGetter.setReturnType(daoType);
        daoGetter.setReturnDescription(Utils.generateDocumentationString(dao.getName()));
        daoGetter.initialiseCodeBuilder();
        daoGetter.getCode().addStatement("return new $T().$L($L)",
                                         daoType.hasClass() ? daoType.getClazz() : daoType.getTypeName(),
                                         AbstractCloudDao.METHOD_CONFIGURE_AND_GET, FIELD_NAME_CONTEXT);
        addMethod(daoGetter);
    }

    @Override
    protected void generateOtherMethods() {
        super.generateOtherMethods();
        final Method daoProviderGetter = new Method(false,
                                                    MethodGetter.getCorrespondingGetterMethodName(DaoProvider.class.getSimpleName(),
                                                                                                  false, false),
                                                    "Gets " + Utils.generateDocumentationString(DaoProvider.class.getSimpleName()),
                                                    null, false, true, false, false, false, false, false, false);
        TypeParameter daoProviderType = TypeFactory.getCorrespondingType(DaoProvider.class);
        try {
            daoProviderType.translate();
        } catch (Exception exception) {
            // Nothing to do
            exception.printStackTrace();
        }
        daoProviderGetter.setReturnType(daoProviderType);
        daoProviderGetter.setReturnDescription(Utils.generateDocumentationString(DaoProvider.class.getSimpleName()));
        daoProviderGetter.initialiseCodeBuilder();
        daoProviderGetter.getCode().addStatement("return new $T($L)",
                                                 daoProviderType.hasClass() ? daoProviderType.getClazz()
                                                                            : daoProviderType.getTypeName(),
                                                 FIELD_NAME_CONTEXT);
        addMethod(daoProviderGetter);
    }

}
