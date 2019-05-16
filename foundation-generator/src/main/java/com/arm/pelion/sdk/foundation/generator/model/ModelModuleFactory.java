package com.arm.pelion.sdk.foundation.generator.model;

import com.arm.mbed.cloud.sdk.annotations.Module;
import com.arm.mbed.cloud.sdk.common.SdkContext;
import com.arm.pelion.sdk.foundation.generator.util.Utils;

public class ModelModuleFactory extends Model {

    private static final String FIELD_NAME_CONTEXT = "context";
    private static final String FIELD_NAME_CONNECT_MODULE = "connectModule";

    public ModelModuleFactory(String packageName) {
        super(packageName, "ModuleFactory", null, "Factory for SDK modules",
              "Utility for fetching " + Utils.generateLinkToClass(Module.class), false, false, false, true);
        setShouldBeSorted(true);
        setIgnoreLiteralDuplicate(true);
        addFields();
        addBillingModule();
    }

    private void addFields() {
        Field context = new Field(true, TypeFactory.getCorrespondingType(SdkContext.class), FIELD_NAME_CONTEXT,
                                  "Context.", null, null, false, false, true, true, null, false);

        addField(context);
        Field connectModule = new Field(true, new TypeConnect(), FIELD_NAME_CONNECT_MODULE, "Connect.", null, null,
                                        false, false, true, true, null, false);
        addField(connectModule);
    }

    private void addBillingModule() {
        TypeBilling billing = new TypeBilling();
        addModule(new ModelModule(billing.getShortName(), billing.getPackageName(), null, null, null, null));
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

    public void addModule(ModelModule module) {
        if (module == null) {
            return;
        }
        final Method moduleGetter = new Method(false,
                                               MethodGetter.getCorrespondingGetterMethodName(module.getName(), false,
                                                                                             false),
                                               "Gets " + Utils.generateDocumentationString(module.getName()), null,
                                               false, true, false, false, false, false, false, false);
        moduleGetter.setIgnoreResourceClosure(true);
        TypeParameter moduleType = module.toType();
        try {
            moduleType.translate();
        } catch (Exception exception) {
            // Nothing to do
            exception.printStackTrace();
        }
        moduleGetter.setReturnType(moduleType);
        moduleGetter.setReturnDescription(Utils.generateDocumentationString(module.getName()));
        moduleGetter.initialiseCodeBuilder();
        moduleGetter.getCode().addStatement("return new $T($L)",
                                            moduleType.hasClass() ? moduleType.getClazz() : moduleType.getTypeName(),
                                            FIELD_NAME_CONTEXT);
        addMethod(moduleGetter);
    }

}
