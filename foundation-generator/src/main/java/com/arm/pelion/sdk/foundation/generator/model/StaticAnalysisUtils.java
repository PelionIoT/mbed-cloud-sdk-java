package com.arm.pelion.sdk.foundation.generator.model;

import com.squareup.javapoet.AnnotationSpec;

public class StaticAnalysisUtils {
    public static final int FIELD_LIMIT_FOR_IGNORING_WARNINGS = 16;

    private StaticAnalysisUtils() {
        // Nothing to do
    }

    public static AnnotationSpec ignoreCyclomaticComplexity() {
        return AnnotationSpec.builder(SuppressWarnings.class).addMember("value", "\"PMD.CyclomaticComplexity\"")
                             .build();
    }

    public static AnnotationSpec ignoreExcessiveMethodLength() {
        return AnnotationSpec.builder(SuppressWarnings.class)
                             .addMember("value", "{\"PMD.ExcessiveMethodLength\", \"PMD.NcssMethodCount\"}").build();
    }

    public static AnnotationSpec ignoreUselessParentheses() {
        return AnnotationSpec.builder(SuppressWarnings.class).addMember("value", "\"PMD.UselessParentheses\"").build();
    }

    public static AnnotationSpec ignoreAvoidDuplicateLiterals() {
        return AnnotationSpec.builder(SuppressWarnings.class).addMember("value", "\"PMD.AvoidDuplicateLiterals\"")
                             .build();
    }

}
