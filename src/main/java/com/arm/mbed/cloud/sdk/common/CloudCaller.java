package com.arm.mbed.cloud.sdk.common;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Date;

import com.arm.mbed.cloud.sdk.annotations.Internal;
import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.common.GenericAdapter.Mapper;

import okhttp3.Headers;
import okhttp3.Request;
import retrofit2.Call;
import retrofit2.Response;

@Preamble(description = "Utility in charge of calling arm Mbed Cloud APIs")
@Internal
public class CloudCaller<T, U> {

    public static interface CloudCall<T> {
        Call<T> call();
    }

    private final CloudCall<T> caller;
    private final Mapper<T, U> mapper;
    private final SDKLogger logger;
    private final String apiName;
    private final AbstractAPI module;

    private CloudCaller(String apiName, CloudCall<T> caller, Mapper<T, U> mapper, AbstractAPI module) {
        super();
        this.caller = caller;
        this.mapper = mapper;
        this.logger = module.logger;
        this.apiName = apiName;
        this.module = module;
    }

    public static <T, U> U call(AbstractAPI module, String functionName, Mapper<T, U> mapper, CloudCall<T> caller)
            throws MbedCloudException {
        return new CloudCaller<>(functionName, caller, mapper, module).execute();
    }

    public U execute() throws MbedCloudException {
        try {
            logger.logInfo("Calling arm Mbed Cloud API: " + apiName);
            Response<T> response = caller.call().execute();
            storeApiMetadata(response);
            checkResponse(response);
            return (mapper == null) ? null : mapper.map(response.body());
        } catch (Exception e) {
            logger.throwSDKException("An error occurred when calling SDK function [" + apiName + "]", e);
        }
        return null;
    }

    private void storeApiMetadata(Response<T> response) {
        if (response == null) {
            return;
        }
        ApiMetadata metadata = new ApiMetadata();

        Request request = response.raw().request();
        if (request != null) {
            metadata.setMethod(request.method());
            metadata.setUrl(request.url().url());
        }

        metadata.setStatusCode(response.code());
        Headers headers = response.headers();
        if (headers != null) {
            metadata.setHeaders(headers.toMultimap());
            metadata.setRequestId(headers.get("x-request-id"));
            try {
                metadata.setDateFromString(headers.get("date"));
            } catch (Exception e) {
                logger.logError("Error occurred when trying to fetch API metadata", e);
                metadata.setDate(new Date());
            }
        }
        T body = response.body();
        if (body != null) {
            metadata.setObject(body.getClass());
            metadata.setEtag(fetchEtagField(body));
        }
        module.metadataCache.storeMetadata(metadata);
    }

    private String fetchEtagField(T body) {
        try {
            Method getEtagMethod = body.getClass().getMethod("getEtag");
            if (getEtagMethod != null) {
                return (String) getEtagMethod.invoke(body);
            }
        } catch (SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
            logger.logError("Error occurred when trying to fetch etag from API metadata", e);
        } catch (NoSuchMethodException e) {
            return null;
        }
        return null;
    }

    private void checkResponse(Response<T> response) throws MbedCloudException {
        if (response == null) {
            logger.throwSDKException("An error occurred when calling Mbed Cloud: no response was received");
        }
        if (response != null && !response.isSuccessful()) {
            logger.throwSDKException(
                    "An error occurred when calling Mbed Cloud: [" + response.code() + "] " + response.message());
        }
    }

}
