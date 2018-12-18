package com.arm.pelion.sdk.foundation.generator.util;

import java.util.List;
import java.util.Locale;

import com.arm.mbed.cloud.sdk.common.ApiUtils;
import com.arm.pelion.sdk.foundation.generator.model.MergeableArtifact;

public class Utils {
    private static final String HYPHEN = "-";
    private static final String WHITE_SPACE = " ";
    private static final String UNDERSCORE = "_";
    public static final String SERIALISATION_UUID = "serialVersionUID";

    public static <T extends MergeableArtifact> T merge(T artifact1, T artifact2) {
        if (artifact1 == null) {
            return artifact2 == null ? null : artifact2;
        }
        artifact1.merge(artifact2);
        return artifact1;
    }

    public static <T extends MergeableArtifact> T merge(List<T> otherArtifacts) {
        if (otherArtifacts == null || otherArtifacts.isEmpty()) {
            return null;
        }
        T mergedElement = null;
        for (T element : otherArtifacts) {
            mergedElement = merge(mergedElement, element);
        }
        return mergedElement;
    }

    public static String generateConstantName(String prefix, String constantName) {
        if (constantName == null || constantName.isEmpty()) {
            return null;
        }
        if (prefix == null && SERIALISATION_UUID.toLowerCase(Locale.UK).equals(constantName.toLowerCase(Locale.UK))) {
            return SERIALISATION_UUID;
        }
        final StringBuilder builder = new StringBuilder();
        if (prefix != null && !prefix.isEmpty()) {
            builder.append(prefix.toUpperCase(Locale.UK).equals(prefix) ? prefix
                                                                        : ApiUtils.convertCamelToSnake(prefix));
            builder.append(UNDERSCORE);
        }
        builder.append(constantName.toUpperCase(Locale.UK)
                                   .equals(constantName) ? constantName : ApiUtils.convertCamelToSnake(constantName));
        return builder.toString().toUpperCase(Locale.UK);
    }

    public static String generateDocumentationString(String modelName) {
        if (modelName == null) {
            return null;
        }
        return ApiUtils.convertCamelToSnake(modelName).replace(HYPHEN, UNDERSCORE).replace(UNDERSCORE, WHITE_SPACE)
                       .trim();
    }
}
