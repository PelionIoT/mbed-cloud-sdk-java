package com.arm.mbed.cloud.sdk.testutils;

import java.lang.reflect.InvocationTargetException;

import com.arm.mbed.cloud.sdk.common.ApiMetadata;

public class APIMethodResult {

    private Object result;
    private ApiMetadata metadata;
    private InvocationTargetException exception;

    public APIMethodResult() {
        super();
        result = null;
        metadata = null;
        exception = null;
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
    public InvocationTargetException getException() {
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
}
