package com.arm.pelion.sdk.foundation.generator;

public interface Artifact {

    void translate() throws TranslationException;

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    String toString();

}
