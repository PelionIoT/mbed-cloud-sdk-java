package com.arm.mbed.cloud.sdk.connect.subscription;

import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.common.CallbackWithException;
import com.arm.mbed.cloud.sdk.common.MbedCloudException;

@Preamble(description = "Action to perform on a resource")
public interface ResourceAction extends CallbackWithException<ResourceActionParameters, MbedCloudException> {

}
