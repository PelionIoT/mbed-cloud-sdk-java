package com.arm.pelion.sdk.foundation.generator.model;

import com.arm.pelion.sdk.foundation.generator.util.TranslationException;

public interface Artifact {

    void translate() throws TranslationException;

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    String toString();

}
