package com.arm.pelion.sdk.foundation.generator.model;

import java.util.Arrays;

import com.arm.mbed.cloud.sdk.annotations.API;
import com.arm.mbed.cloud.sdk.annotations.Nullable;
import com.arm.mbed.cloud.sdk.common.CloudCaller;
import com.arm.mbed.cloud.sdk.common.CloudRequest.CloudCall;
import com.arm.mbed.cloud.sdk.common.MbedCloudException;
import com.arm.pelion.sdk.foundation.generator.util.TranslationException;
import com.squareup.javapoet.TypeSpec;

import retrofit2.Call;

public class MethodModuleCloudApi extends Method {
    protected final Model currentModel;
    protected final ModelAdapterFetcher adapterFetcher;
    protected final TypeParameter lowLevelCallReturnType;
    protected final String endpointVariableName;

    public MethodModuleCloudApi(Model currentModel, ModelAdapterFetcher adapterFetcher, String name, String description,
                                String longDescription, boolean needsCustomCode, TypeParameter lowLevelCallReturnType,
                                String endpointVariableName) {
        super(false, name, description, longDescription, false, true, false, false, needsCustomCode, false, false,
              false);
        this.currentModel = currentModel;
        this.adapterFetcher = adapterFetcher;
        this.lowLevelCallReturnType = lowLevelCallReturnType;
        this.endpointVariableName = endpointVariableName;
        initialiseCodeBuilder();
        determineReturnType(currentModel);
    }

    protected void determineReturnType(Model currentModel) {
        // Nothing to do

    }

    @Override
    protected void addAnnotations() {
        super.addAnnotations();
        specificationBuilder.addAnnotation(API.class);
        if (hasReturn()) {
            specificationBuilder.addAnnotation(Nullable.class);
        }
    }

    @Override
    protected void addExceptions() {
        super.addExceptions();
        specificationBuilder.addException(MbedCloudException.class);
    }

    @Override
    protected void translateCode() throws TranslationException {
        super.translateCode();
        generateParameterChecks();
        generateVariableInitialisation();
        code.addStatement((hasReturn() ? "return " : "") + "$T.$L(this, $S,"
                          + (hasReturn() ? "$T." + getMappingMethod() + "()" : "$L") + ",$L )", CloudCaller.class,
                          CloudCaller.METHOD_CALL_CLOUD_API, name + "()", hasReturn() ? getAdapter() : "null",
                          generateCloudCallCode());
    }

    protected void generateVariableInitialisation() throws TranslationException {
        // TODO Auto-generated method stub

    }

    protected String getMappingMethod() {
        return ModelAdapter.FUNCTION_NAME_GET_MAPPER;
    }

    protected void generateParameterChecks() {
        // TODO Auto-generated method stub

    }

    protected Object generateCloudCallCode() throws TranslationException {
        final TypeSpec.Builder cloudCall = TypeSpec.anonymousClassBuilder("");
        final TypeParameter cloudCallType = TypeFactory.getCorrespondingType(CloudCall.class, lowLevelCallReturnType);
        cloudCallType.translate();
        if (cloudCallType.hasClass()) {
            cloudCall.addSuperinterface(cloudCallType.getClazz());
        } else {
            cloudCall.addSuperinterface(cloudCallType.getTypeName());
        }
        for (java.lang.reflect.Method m : Arrays.asList(CloudCall.class.getDeclaredMethods())) {
            // Use for loop for exception reason
            final Method method = new Method(m, "Makes the low level call to the Cloud", null, true);
            method.setAbstract(false);
            method.setReturnType(TypeFactory.getCorrespondingType(Call.class, lowLevelCallReturnType));
            method.setReturnDescription("Corresponding Retrofit2 Call object");
            method.initialiseCodeBuilder();
            generateLowLevelCallCode(method);
            method.translate();
            cloudCall.addMethod(method.getSpecificationBuilder().build());

        }

        return cloudCall.build();

    }

    protected void generateLowLevelCallCode(final Method callMethod) {
        // TODO
    }

    protected Object getAdapter() throws TranslationException {
        final ModelAdapter adapter = adapterFetcher.fetchAdapter(currentModel.getIdentifier());
        TypeParameter type = adapter == null ? null : adapter.toType();
        if (type == null) {
            return null;
        }
        type.translate();
        return type.hasClass() ? type.getClazz() : type.getTypeName();
    }

    @Override
    public String toString() {
        return "MethodModuleCloudApi [currentModel=" + currentModel + "]";
    }

}
