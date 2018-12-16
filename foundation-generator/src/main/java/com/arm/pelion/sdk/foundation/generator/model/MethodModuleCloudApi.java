package com.arm.pelion.sdk.foundation.generator.model;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import com.arm.mbed.cloud.sdk.annotations.API;
import com.arm.mbed.cloud.sdk.annotations.Nullable;
import com.arm.mbed.cloud.sdk.common.ApiUtils;
import com.arm.mbed.cloud.sdk.common.CloudCaller;
import com.arm.mbed.cloud.sdk.common.CloudRequest.CloudCall;
import com.arm.mbed.cloud.sdk.common.MbedCloudException;
import com.arm.pelion.sdk.foundation.generator.util.TranslationException;
import com.squareup.javapoet.TypeSpec;

import retrofit2.Call;

public class MethodModuleCloudApi extends Method {
    protected final Model currentModel;
    protected final ModelAdapterFetcher adapterFetcher;
    protected final String endpointVariableName;
    protected final Renames parameterRenames;
    protected final Method lowLevelMethod;
    protected List<Parameter> methodParameters;

    public MethodModuleCloudApi(Model currentModel, ModelAdapterFetcher adapterFetcher, String name, String description,
                                String longDescription, boolean needsCustomCode, String endpointVariableName,
                                List<Parameter> methodParameters, Renames parameterRenames, Method lowLevelMethod) {
        super(false, name, description, longDescription, false, true, false, false, needsCustomCode, false, false,
              false);
        this.currentModel = currentModel;
        this.adapterFetcher = adapterFetcher;
        this.endpointVariableName = endpointVariableName;
        this.lowLevelMethod = lowLevelMethod;
        this.parameterRenames = parameterRenames;
        this.methodParameters = methodParameters;
    }

    public void initialise() {
        initialiseCodeBuilder();
        methodParameters = extendParameterList(methodParameters);
        determineParameters(methodParameters);
        determineReturnType(currentModel);
    }

    protected void determineParameters(List<Parameter> methodParameters) {
        if (methodParameters == null || methodParameters.isEmpty()) {
            return;
        }
        methodParameters.forEach(p -> addParameter(p));
    }

    protected void determineReturnType(Model currentModel) {
        // Nothing to do

    }

    protected List<Parameter> extendParameterList(List<Parameter> methodParameters) {
        return methodParameters;
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
        generateVariableInitialisation(methodParameters);
        code.addStatement((hasReturn() ? "return " : "") + "$T.$L(this, $S,"
                          + (hasReturn() ? "$T." + getMappingMethod() + "()" : "$L") + ",$L )", CloudCaller.class,
                          CloudCaller.METHOD_CALL_CLOUD_API, name + "()", hasReturn() ? getAdapter() : "null",
                          generateCloudCallCode());
    }

    protected void generateVariableInitialisation(List<Parameter> methodParameters) throws TranslationException {
        if (methodParameters == null || methodParameters.isEmpty()) {
            return;
        }
        for (Parameter p : methodParameters) {
            generateParameterInitialisation(p);
        }
    }

    protected void generateParameterInitialisation(Parameter p) throws TranslationException {
        if (p == null) {
            return;
        }
        TypeParameter type = p.getType();
        type.translate();
        code.addStatement("final $T $L = $L", type.hasClass() ? type.getClazz() : type.getTypeName(),
                          generateFinalVariable(p.getName()), p.getName());
    }

    protected String generateFinalVariable(String variableName) {
        return ApiUtils.convertSnakeToCamel("final_" + ApiUtils.convertCamelToSnake(variableName), false);
    }

    protected String getMappingMethod() {
        return ModelAdapter.FUNCTION_NAME_GET_MAPPER;
    }

    protected void generateParameterChecks() {
        // TODO Auto-generated method stub

    }

    protected Object generateCloudCallCode() throws TranslationException {
        final TypeSpec.Builder cloudCall = TypeSpec.anonymousClassBuilder("");
        final TypeParameter cloudCallType = TypeFactory.getCorrespondingType(CloudCall.class,
                                                                             lowLevelMethod.getReturnType());
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
            method.setReturnType(TypeFactory.getCorrespondingType(Call.class, lowLevelMethod.getReturnType()));
            method.setReturnDescription("Corresponding Retrofit2 Call object");
            method.initialiseCodeBuilder();
            generateLowLevelCallCode(endpointVariableName, method, lowLevelMethod, parameterRenames);
            method.translate();
            cloudCall.addMethod(method.getSpecificationBuilder().build());

        }

        return cloudCall.build();

    }

    protected void generateLowLevelCallCode(String endpointVariableName, Method callMethod, Method lowLevelMethod,
                                            Renames parameterRenames) {
        final List<Object> callElements = new LinkedList<>(Arrays.asList(endpointVariableName));
        StringBuilder builder = new StringBuilder();
        builder.append("return $L");
        // TODO add bit about endpoint low level module getter
        // Adding method name
        builder.append(".$L(");
        callElements.add(lowLevelMethod.getName());
        boolean start = true;
        if (lowLevelMethod.hasParameters()) {
            for (Parameter p : lowLevelMethod.getParameters()) {
                if (!start) {
                    builder.append(", ");
                } else {
                    start = false;
                }
                final String parameterName = parameterRenames.containsMappingFor(p.getIdentifier()) ? parameterRenames.getRenamedField(p.getIdentifier())
                                                                                                    : p.getName();
                String variableName = parameterName;
                boolean isExternalParameter = false;
                if (methodParameters.stream().anyMatch(a -> a.getIdentifier().equals(parameterName))) {
                    variableName = generateFinalVariable(parameterName);
                    isExternalParameter = true;
                }
                translateParameter(variableName, p.getType(), builder, callElements, isExternalParameter);
            }
        }
        builder.append(")");
        callMethod.getCode().addStatement(builder.toString(), callElements.toArray());
    }

    protected void translateParameter(String parameterName, TypeParameter type, StringBuilder builder,
                                      List<Object> callElements, boolean isExternalParameter) {
        builder.append("$L");
        if (isExternalParameter) {
            callElements.add(parameterName);
        } else {
            callElements.add("null");
        }
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
        return "MethodModuleCloudApi [Method=" + super.toString() + ", currentModel=" + currentModel + "]";
    }

}
