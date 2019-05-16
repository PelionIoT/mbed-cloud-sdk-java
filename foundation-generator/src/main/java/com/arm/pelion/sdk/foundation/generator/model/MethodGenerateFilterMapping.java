package com.arm.pelion.sdk.foundation.generator.model;

import java.util.Hashtable;
import java.util.Map;
import java.util.Map.Entry;

import com.arm.mbed.cloud.sdk.common.listing.filtering.Filters;
import com.arm.pelion.sdk.foundation.generator.util.TranslationException;
import com.arm.pelion.sdk.foundation.generator.util.Utils;

public class MethodGenerateFilterMapping extends MethodOverloaded {

    public static final String METHOD_NAME = "generateFilterMapping";
    private final Renames renames;

    public MethodGenerateFilterMapping(Renames renames) {
        super(true, METHOD_NAME, "Method generating the mapping needed for encoding or decoding filters.",
              "Filters are used when listing models. See {@link " + Filters.class.getName() + "}", true, false, false,
              false, false, true, false, false, null);
        setReadOnly(true);
        initialiseCodeBuilder();
        setReturnDescription("the mapping table");
        setReturnType(new TypeHashtable(String.class));
        this.renames = renames;
    }

    @SuppressWarnings("boxing")
    @Override
    protected void translateCode() throws TranslationException {
        if (renames == null) {
            return;
        }
        final String localVariable = "filterMapping";
        code.addStatement("final $T<$T,$T> $L = new $T<>($L)", Map.class, String.class, String.class, localVariable,
                          Hashtable.class, renames.numberOfRenames());

        for (Entry<String, String> entry : renames.getToFrom().entrySet()) {
            code.addStatement("$L.put($S, $S)", localVariable, entry.getKey(),
                              Utils.generateCloudFieldName(entry.getValue()));
        }
        code.addStatement("return $L", localVariable);
    }

}
