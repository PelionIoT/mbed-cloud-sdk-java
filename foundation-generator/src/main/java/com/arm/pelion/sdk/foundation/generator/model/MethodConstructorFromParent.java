package com.arm.pelion.sdk.foundation.generator.model;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class MethodConstructorFromParent extends AbstractMethodConstructor {

    private List<Parameter> constructorParameters = null;

    public MethodConstructorFromParent(Constructor<?> parentConstructor, Model currentModel) {
        super(currentModel, null, null, null, false);
        exceptions.addAll(Arrays.asList(parentConstructor.getExceptionTypes()));
        constructorParameters = determineListOfParameters(parentConstructor);
        addConstructorParameters();
    }

    @Override
    protected void addConstructorParameters() {
        if (constructorParameters != null) {
            constructorParameters.forEach(p -> addParameter(p));
        }
    }

    @Override
    protected void translateCode() {
        code.addStatement("super(" + String.join(", ", constructorParameters.stream().map(p -> p.getName())
                                                                            .collect(Collectors.toList()))
                          + ")");
    }

    /*
     * (non-Javadoc)
     *
     * @see com.arm.pelion.sdk.foundation.generator.model.AbstractMethodConstructor#getSignature()
     */
    @Override
    public List<String> getSignature() {
        return constructorParameters.stream().map(p -> p.getType().getShortName()).collect(Collectors.toList());

    }

    protected List<Parameter> determineListOfParameters(Constructor<?> parentConstructor) {
        if (parentConstructor.getParameterCount() > 0) {
            return Arrays.asList(parentConstructor.getParameters()).stream().map(p -> new Parameter(p))
                         .collect(Collectors.toList());
        }
        return new LinkedList<>();
    }

    @Override
    public List<Field> getFieldList() {
        return new ArrayList<>();
    }

    @Override
    public String getIdentifier() {
        return MethodOverloaded.generateIdentifier(super.getIdentifier(),
                                                   MethodOverloaded.generateOverloadSuffix(constructorParameters));
    }

}
