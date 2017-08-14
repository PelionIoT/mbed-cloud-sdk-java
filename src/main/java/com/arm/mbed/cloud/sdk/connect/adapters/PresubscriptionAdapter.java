package com.arm.mbed.cloud.sdk.connect.adapters;

import java.util.LinkedList;
import java.util.List;

import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.connect.model.Presubscription;
import com.arm.mbed.cloud.sdk.internal.mds.model.ResourcePath;

@Preamble(description = "Adapter for presubscription model")
public class PresubscriptionAdapter {

    public static Presubscription map(com.arm.mbed.cloud.sdk.internal.mds.model.Presubscription apiPresubscription) {
        if (apiPresubscription == null) {
            return null;
        }
        Presubscription presubscription = new Presubscription();
        presubscription.setDeviceId(apiPresubscription.getEndpointName());
        presubscription.setDeviceType(apiPresubscription.getEndpointType());
        presubscription.setResourcePaths(convertResourcePathList(apiPresubscription.getResourcePath()));
        return presubscription;
    }

    private static List<String> convertResourcePathList(List<ResourcePath> paths) {
        List<String> pathStrings = null;
        if (paths != null) {
            for (ResourcePath path : paths) {
                if (pathStrings == null) {
                    pathStrings = new LinkedList<>();
                }
                pathStrings.add(path.toString());
            }
        }
        return pathStrings;
    }

}
