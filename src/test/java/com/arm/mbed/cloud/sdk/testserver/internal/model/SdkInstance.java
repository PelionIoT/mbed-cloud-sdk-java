/**
 * 
 */
package com.arm.mbed.cloud.sdk.testserver.internal.model;

import com.arm.mbed.cloud.sdk.common.ConnectionOptions;

public class SdkInstance extends FoundationInstance<Sdk> {

    public static final String REFERENCE = Sdk.class.getSimpleName();
    private static final long serialVersionUID = -7909813791507995423L;

    public SdkInstance(ConnectionOptions options, Sdk description) {
        super(REFERENCE, options, description);
    }

}
