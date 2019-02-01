package com.arm.pelion.sdk.foundation.generator.model;

import com.squareup.javapoet.AnnotationSpec;

public class StaticAnalysisUtils {
    public static final int FIELD_LIMIT_FOR_IGNORING_WARNINGS = 10;

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

    public static AnnotationSpec ignoreShortMethodName() {
        return AnnotationSpec.builder(SuppressWarnings.class).addMember("value", "\"PMD.ShortMethodName\"").build();
    }

    public static AnnotationSpec ignoreLongLines() {
        return AnnotationSpec.builder(SuppressWarnings.class).addMember("value", "\"checkstyle:LineLength\"").build();
    }

    public static AnnotationSpec ignoreResourceClosure() {
        return AnnotationSpec.builder(SuppressWarnings.class).addMember("value", "\"resource\"").build();
    }

    public static AnnotationSpec setAsUnchecked() {
        return AnnotationSpec.builder(SuppressWarnings.class).addMember("value", "\"unchecked\"").build();
    }

}
