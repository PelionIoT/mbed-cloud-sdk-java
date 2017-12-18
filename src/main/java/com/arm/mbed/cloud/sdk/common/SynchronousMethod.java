package com.arm.mbed.cloud.sdk.common;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeoutException;

import com.arm.mbed.cloud.sdk.annotations.Internal;
import com.arm.mbed.cloud.sdk.annotations.Nullable;
import com.arm.mbed.cloud.sdk.annotations.Preamble;

@Preamble(description = "Object to wait for an asynchronous method to complete")
@Internal
public class SynchronousMethod {

    private SynchronousMethod() {
        super();
    }

    @Preamble(description = "Asynchronous method")
    public interface AsynchronousMethod<T> {
        /**
         * Gets a future task.
         * 
         * @return future task.
         * @throws MbedCloudException
         *             if an error happens during submission.
         */
        Future<T> submit() throws MbedCloudException;
    }

    /**
     * Waits for the completion of an asynchronous call method.
     * 
     * @see AsynchronousMethod
     * @param asyncMethod
     *            asynchronous method to call.
     * @param timeout
     *            timeout to set. If null, it will wait indefinitely.
     * @param <T>
     *            type of the result
     * @return call result
     * @throws MbedCloudException
     *             if an error occurred during the call or the wait.
     */
    public static <T> T waitForCompletion(AsynchronousMethod<T> asyncMethod, @Nullable TimePeriod timeout)
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
        } catch (InterruptedException | ExecutionException | TimeoutException exception) {
            throw new MbedCloudException(exception);
        }

    }

}
