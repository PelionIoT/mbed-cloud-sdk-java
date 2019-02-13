package com.arm.mbed.cloud.sdk.testserver.internal.model;

import java.lang.reflect.InvocationTargetException;

import com.arm.mbed.cloud.sdk.common.ApiMetadata;
import com.arm.mbed.cloud.sdk.common.MbedCloudException;
import com.arm.mbed.cloud.sdk.common.NotImplementedException;

public class APIMethodResult {

    private Object result;
    private ApiMetadata metadata;
    private boolean allowed;
    private Exception exception;

    public APIMethodResult() {
        super();
        result = null;
        metadata = null;
        exception = null;
        allowed = true;
    }

    /**
     * @return the result
     */
    public Object getResult() {
        return result;
    }

    /**
     * @param result
     *            the result to set
     */
    public void setResult(Object result) {
        this.result = result;
    }

    /**
     * @return the metadata
     */
    public ApiMetadata getMetadata() {
        return metadata;
    }

    /**
     * @param metadata
     *            the metadata to set
     */
    public void setMetadata(ApiMetadata metadata) {
        this.metadata = metadata;

    }

    /**
     * @return the exception
     */
    public Exception getException() {
        return exception;
    }

    /**
     * @param exception
     *            the exception to set
     */
    public void setException(InvocationTargetException exception) {
        this.exception = exception;
    }

    public boolean wasExceptionRaised() {
        return exception != null;
    }

    public void setAllowed(boolean allowed) {
        this.allowed = allowed;
    }

    public boolean wasAllowed() {
        return allowed;
    }

    public boolean isCloudException() {
        return wasExceptionRaised()
               && (exception instanceof MbedCloudException || exception.getCause() instanceof MbedCloudException);
    }

    public boolean isNotImplementedException() {
        return wasExceptionRaised() && (exception instanceof NotImplementedException
                                        || exception.getCause() instanceof NotImplementedException);
    }

}
