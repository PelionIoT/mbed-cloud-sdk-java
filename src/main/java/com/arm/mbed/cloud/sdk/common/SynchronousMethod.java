package com.arm.mbed.cloud.sdk.common;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeoutException;

import com.arm.mbed.cloud.sdk.annotations.Internal;
import com.arm.mbed.cloud.sdk.annotations.Preamble;

@Preamble(description = "Object to wait for an asynchronous method to complete")
@Internal
public class SynchronousMethod {

    private SynchronousMethod() {
        super();
    }

    public interface AsynchronousMethod<T> {
        Future<T> submit() throws MbedCloudException;
    }

    public static <T> T waitForCompletion(AsynchronousMethod<T> asyncMethod, TimePeriod timeout)
            throws MbedCloudException {
        final Future<T> future = asyncMethod.submit();
        if (future == null) {
            return null;
        }
        try {
            if (timeout == null) {
                return future.get();
            }
            return future.get(timeout.getDuration(), timeout.getUnit());
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            throw new MbedCloudException(e);
        }

    }

}
