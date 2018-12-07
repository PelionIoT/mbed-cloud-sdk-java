package com.arm.pelion.sdk.foundation.generator.translator;

import java.util.List;

import com.arm.pelion.sdk.foundation.generator.input.ForeignKey;
import com.arm.pelion.sdk.foundation.generator.model.ModelEnum;
import com.arm.pelion.sdk.foundation.generator.model.Model;
import com.arm.pelion.sdk.foundation.generator.model.ParameterType;

public class CommonTranslator {

    public static final String PACKAGE_SEPARATOR = ".";

    public static String generateGoup(List<String> groupId) {
        return groupId == null ? null : String.join(PACKAGE_SEPARATOR, groupId);
    }

    public static ParameterType FetchNestedEntityType(String packageName, ForeignKey key) {
        if (key == null) {
            return null;
        }
        final Model refModel = new Model(packageName, key.getEntityRef(),
                                         CommonTranslator.generateGoup(key.getGroupId()));
        return fetchNestedType(refModel);
    }

    public static ParameterType FetchNestedEnumType(String packageName, String enumRef, String group) {
        if (enumRef == null) {
            return null;
        }
        final ModelEnum enumerator = new ModelEnum(packageName, enumRef, group);
        return fetchNestedType(enumerator);
    }

    protected static ParameterType fetchNestedType(final Model model) {
        if (PelionModelDefinitionStore.get().has(model)) {
            return PelionModelDefinitionStore.get().get(model).toType();
        }
        return model.toType();
    }
}
