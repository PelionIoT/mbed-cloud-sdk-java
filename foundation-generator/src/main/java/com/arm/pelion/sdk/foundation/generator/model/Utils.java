package com.arm.pelion.sdk.foundation.generator.model;

import java.util.List;

public class Utils {
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

}
