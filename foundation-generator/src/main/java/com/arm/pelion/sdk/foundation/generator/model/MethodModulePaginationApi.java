package com.arm.pelion.sdk.foundation.generator.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import com.arm.mbed.cloud.sdk.common.listing.ListResponse;
import com.arm.mbed.cloud.sdk.common.listing.PageRequester;
import com.arm.mbed.cloud.sdk.common.listing.Paginator;
import com.arm.pelion.sdk.foundation.generator.util.TranslationException;
import com.arm.pelion.sdk.foundation.generator.util.Utils;
import com.squareup.javapoet.TypeSpec;

public class MethodModulePaginationApi extends MethodModuleListApi {
    private static final String PAGINATOR_METHOD_IDENTIFIER = "All";
    private static final String PREFIX_LIST_METHOD = "list";
    private final MethodModuleListApi correspondingMethod;

    public MethodModulePaginationApi(MethodModuleListApi listMethod, boolean needsCustomCode) {
        super(listMethod.currentModel, generatePaginatorName(listMethod), generateDescription(listMethod.currentModel),
              generateLongDescription(listMethod), needsCustomCode, false, listMethod.fetcher,
              listMethod.adapterFetcher, listMethod.endpoints, listMethod.endpointVariableName,
              listMethod.lowLevelModule, listMethod.methodParameters, listMethod.allParameters,
              listMethod.parameterRenames, listMethod.lowLevelMethod, listMethod.enforceModelValidity);
        this.correspondingMethod = listMethod;
    }

    public static String generateLongDescription(MethodModuleCloudApi listMethod) {
        return "Gets an iterator over all " + generateModelDescription(listMethod.currentModel)
               + " matching filter options.";
    }

    public static String generateDescription(Model listedModels) {
        return "Creates a {@link Paginator} for the list of " + generateModelDescription(listedModels)
               + " matching filter options.";
    }

    private static String generateModelDescription(Model currentModel) {
        return Utils.generateDocumentationString(currentModel.getName(), true);
    }

    public static String generatePaginatorName(MethodModuleCloudApi listMethod) {
        final String oldName = listMethod.getName();
        return generatePaginatorName(oldName);
    }

    public static String generatePaginatorName(final String oldName) {
        if (oldName == null || oldName.trim().isEmpty()) {
            return oldName;
        }
        final String newName = oldName.replace(PREFIX_LIST_METHOD, PREFIX_LIST_METHOD + PAGINATOR_METHOD_IDENTIFIER);
        return oldName.equals(newName) ? Utils.combineNames(false, PAGINATOR_METHOD_IDENTIFIER, newName) : newName;
    }

    @Override
    protected boolean shouldCheckModelValidity(Parameter p) {
        return false;
    }

    @Override
    protected List<Parameter> extendParameterList(List<Parameter> methodParameters, List<Parameter> allParameters,
                                                  Method lowLevelMethod, Renames parameterRenames, Model currentModel) {
        return extendParameterList(methodParameters);
    }

    public static List<Parameter> extendParameterList(List<Parameter> methodParameters) {
        final List<Parameter> clonedMethodParameters = new ArrayList<>(methodParameters.size());
        methodParameters.forEach(p -> clonedMethodParameters.add(p.clone()));
        return clonedMethodParameters;
    }

    @Override
    protected void determineReturnType(Model returnModel, Method lowLevelMethod) {
        setReturnType(this, returnModel);
    }

    public static void setReturnType(Method method, Model returnModel) {
        TypePaginator returnType = new TypePaginator();
        returnType.setContentType(returnModel.toType());
        method.setReturnType(returnType);
        method.setReturnDescription("paginator over the list of " + generateModelDescription(returnModel));
    }

    @Override
    protected void generateMethodCode() throws TranslationException {
        generateMethodCode(currentModel, this, correspondingMethod, false);
    }

    public static void generateMethodCode(Model returnModel, MethodModuleCloudApi method,
                                          MethodModuleCloudApi correspondingMethod,
                                          boolean useThisFinalVariableMethod) throws TranslationException {
        final TypeParameter paginatorType = TypeFactory.getCorrespondingType(Paginator.class, returnModel.toType());
        paginatorType.translate();
        method.code.addStatement((method.hasReturn() ? "return " : "") + "new $T($L, $L)",
                                 paginatorType.hasClass() ? paginatorType.getClazz() : paginatorType.getTypeName(),
                                 getOptionLocalVariable(method),
                                 generateOnePageRequest(returnModel, method, correspondingMethod,
                                                        useThisFinalVariableMethod));

    }

    private static Object generateOnePageRequest(Model returnModel, MethodModuleCloudApi thisMethod,
                                                 MethodModuleCloudApi correspondingMethod,
                                                 boolean useThisFinalVariableMethod) throws TranslationException {
        final TypeSpec.Builder pageRequest = TypeSpec.anonymousClassBuilder("");
        final TypeParameter pageRequestType = TypeFactory.getCorrespondingType(PageRequester.class,
                                                                               returnModel.toType());
        pageRequestType.translate();
        if (pageRequestType.hasClass()) {
            pageRequest.addSuperinterface(pageRequestType.getClazz());
        } else {
            pageRequest.addSuperinterface(pageRequestType.getTypeName());
        }
        for (java.lang.reflect.Method m : Arrays.asList(PageRequester.class.getMethods())) {
            // Use for loop for exception reasons
            final Method method = new Method(m, "Makes one page request", null, true, true);
            method.setAbstract(false);
            method.setReturnType(TypeFactory.getCorrespondingType(ListResponse.class, returnModel.toType()));
            method.setReturnDescription("Corresponding page requester");
            method.initialiseCodeBuilder();
            final List<Object> callElements = new LinkedList<>();
            final StringBuilder builder = new StringBuilder();
            builder.append("return $L(");
            callElements.add(correspondingMethod.getName());
            boolean start = true;
            for (Parameter p : correspondingMethod.methodParameters) {
                if (start) {
                    start = false;
                } else {
                    builder.append(", ");
                }
                if (checkIfParameterListOptions(p)) {
                    initialiseListOptionsParameters(method, callElements, builder, p);
                } else {
                    builder.append("$L");
                    callElements.add((useThisFinalVariableMethod ? thisMethod
                                                                 : correspondingMethod).generateFinalVariable(p.getName()));
                }
            }
            builder.append(")");
            method.getCode().addStatement(builder.toString(), callElements.toArray());
            method.translate();
            pageRequest.addMethod(method.getSpecificationBuilder().build());

        }

        return pageRequest.build();

    }

    public static void initialiseListOptionsParameters(final Method method, final List<Object> callElements,
                                                       final StringBuilder builder,
                                                       Parameter p) throws TranslationException {
        builder.append("($T) $L");
        final Parameter parameter = method.getParameters().stream().findFirst().get();
        final TypeParameter pType = p.getType();
        pType.translate();
        callElements.add(pType.hasClass() ? pType.getClazz() : pType.getTypeName());
        callElements.add(parameter == null ? "null" : parameter.getName());
    }

    @Override
    public String toString() {
        return "MethodModulePaginationApi [correspondingMethod=" + correspondingMethod + "]";
    }

}
