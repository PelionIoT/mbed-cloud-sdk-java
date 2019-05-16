package com.arm.pelion.sdk.foundation.generator.model;

public interface MergeableArtifact {

    <T extends MergeableArtifact> void merge(T otherArtifact);
}
