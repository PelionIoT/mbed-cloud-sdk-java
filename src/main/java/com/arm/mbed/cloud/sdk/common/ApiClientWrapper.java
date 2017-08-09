package com.arm.mbed.cloud.sdk.common;

import com.arm.mbed.cloud.sdk.annotations.Internal;
import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.internal.ApiClient;

import okhttp3.logging.HttpLoggingInterceptor;

@Preamble(description = "Client wrapper")
@Internal
public class ApiClientWrapper {
    private static final String DEFAULT_AUTH_NAME = "Bearer";
    protected final ApiClient client;

    public ApiClientWrapper(ConnectionOptions options) {
        super();
        this.client = createClient(options);
        setLogging(options.getClientLogLevel());
    }

    private ApiClient createClient(ConnectionOptions options) {
        ApiClient apiClient = (options.isApiKeyEmpty()) ? new ApiClient()
                : new ApiClient(DEFAULT_AUTH_NAME, formatApiKey(options.getApiKey()));
        if (!options.isHostEmpty()) {
            apiClient.setAdapterBuilder(apiClient.getAdapterBuilder().baseUrl(options.getHost()));
        }
        return apiClient;
    }

    private String formatApiKey(String apiKey) {
        return DEFAULT_AUTH_NAME + " " + apiKey;
    }

    public void setLogging(CallLogLevel level) {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        HttpLoggingInterceptor.Level logLevel = null;
        switch (level) {
            case BASIC:
                logLevel = HttpLoggingInterceptor.Level.BASIC;
                break;
            case BODY:
                logLevel = HttpLoggingInterceptor.Level.BODY;
                break;
            case HEADERS:
                logLevel = HttpLoggingInterceptor.Level.HEADERS;
                break;
            case NONE:
                logLevel = HttpLoggingInterceptor.Level.NONE;
                break;
            default:
                logLevel = HttpLoggingInterceptor.Level.NONE;
                break;

        }
        interceptor.setLevel(logLevel);
        this.client.getOkBuilder().addInterceptor(interceptor);
    }

    public <S> S createService(Class<S> serviceClass) {
        return client.createService(serviceClass);
    }

}
