package com.arm.mbed.cloud.sdk.common;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.arm.mbed.cloud.sdk.annotations.Internal;
import com.arm.mbed.cloud.sdk.annotations.Nullable;
import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.internal.ApiClient;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;

@Preamble(description = "Client wrapper")
@Internal
public class ApiClientWrapper {
    private static final String DEFAULT_AUTH_NAME = "Bearer";
    private final UserAgent userAgent;
    protected final ApiClient client;
    private final ConnectionOptions connectionOptions;

    /**
     * Arm Mbed Cloud client constructor.
     *
     * @param options
     *            connection options @see {@link ConnectionOptions}
     */
    public ApiClientWrapper(ConnectionOptions options) {
        this(options, null);
    }

    /**
     *
     * Arm Mbed Cloud client constructor.
     *
     * @param options
     *            connection options @see {@link ConnectionOptions}
     * @param userAgentExtensions
     *            extension list for the user agent: module name -> module version
     */
    public ApiClientWrapper(ConnectionOptions options, Map<String, String> userAgentExtensions) {
        super();
        this.client = createClient(options);
        setLogging(options.getClientLogLevel());
        setRequestTimeout(options.getRequestTimeout());
        this.userAgent = new UserAgent();
        if (userAgentExtensions != null && !userAgentExtensions.isEmpty()) {
            for (Entry<String, String> entry : userAgentExtensions.entrySet()) {
                userAgent.addExtension(entry.getKey(), entry.getValue());
            }
        }
        setUserAgent();
        this.connectionOptions = options;
    }

    /**
     * Sets logging level to apply.
     *
     * @param level
     *            logging level @see {@link CallLogLevel}
     */
    public void setLogging(CallLogLevel level) {
        final HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
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

    /**
     * Sets the http request timeout.
     *
     * @param timeout
     *            request timeout. By default, retrofit2 default setting is used.
     */
    public void setRequestTimeout(@Nullable TimePeriod timeout) {
        if (timeout == null) {
            return;
        }
        this.client.getOkBuilder().readTimeout(timeout.getDuration(), timeout.getUnit());
    }

    /**
     * Gets the http user agent in place.
     *
     * @return the userAgent
     */
    public UserAgent getUserAgent() {
        return userAgent;
    }

    private void setUserAgent() {
        this.client.getOkBuilder().addInterceptor(new UserAgentInterceptor(this.userAgent));
    }

    /**
     * Creates a service.
     *
     * @param serviceClass
     *            class of the service.
     * @param <S>
     *            service type
     * @return corresponding service.
     */
    public <S> S createService(Class<S> serviceClass) {
        return client.createService(serviceClass);
    }

    /**
     * Gets the connection options used.
     *
     * @return the connectionOptions.
     */
    public ConnectionOptions getConnectionOptions() {
        return connectionOptions;
    }

    private static ApiClient createClient(ConnectionOptions options) {
        final ApiClient apiClient = options.isApiKeyEmpty() ? new ApiClient()
                : new ApiClient(DEFAULT_AUTH_NAME, formatApiKey(options.getApiKey()));
        if (!options.isHostEmpty()) {
            apiClient.setAdapterBuilder(apiClient.getAdapterBuilder().baseUrl(options.getHost()));
        }
        return apiClient;
    }

    private static String formatApiKey(String apiKey) {
        return DEFAULT_AUTH_NAME + " " + apiKey;
    }

    /**
     * User Agent.
     */
    @Preamble(description = "User Agent")
    public static final class UserAgent {

        public static final String MBED_CLOUD_SDK_IDENTIFIER = "mbed-cloud-sdk-java";
        private final SdkInformation defaultInformation;
        private final Map<String, String> extensions;
        private boolean regenerate;
        private String userAgentString;

        /**
         * Constructor.
         */
        public UserAgent() {
            super();
            defaultInformation = SdkInformation.getInstance();
            extensions = new LinkedHashMap<>();
            regenerate = true;
            userAgentString = null;
        }

        /**
         * Adds an extension to the user agent.
         *
         * @param name
         *            product name.
         * @param version
         *            product version.
         */
        public void addExtension(String name, String version) {
            final String finalVersion = version == null ? "0.0" : version;
            extensions.put(name, finalVersion);
            regenerate = true;
        }

        /**
         * Clears user agent extension.
         */
        public void clear() {
            extensions.clear();
            regenerate = true;
        }

        /**
         * Gets user agent string.
         *
         * @return string describing user agent header.
         */
        public String getUserAgentString() {
            if (regenerate) {
                userAgentString = generateUserAgent();
            }
            return userAgentString;
        }

        private String generateUserAgent() {
            final StringBuilder builder = new StringBuilder(50);
            builder.append(MBED_CLOUD_SDK_IDENTIFIER).append('/');
            if (defaultInformation.getSdkVersion() == null) {
                builder.append("unknown-version");
            } else {
                builder.append(defaultInformation.getSdkVersion());
            }
            builder.append(" (").append(defaultInformation.getOs()).append("; ")
                    .append(defaultInformation.getOsVersion()).append("; ")
                    .append(defaultInformation.getOsArchitecture()).append("; ").append(defaultInformation.getLocale())
                    .append(") Java/").append(defaultInformation.getJavaVersion());
            builder.append(" (").append(defaultInformation.getJavaVendor()).append("; ")
                    .append(defaultInformation.getJavaVendorUrl()).append("; ")
                    .append(defaultInformation.getSdkDescription()).append("; ")
                    .append(defaultInformation.getSdkLicence()).append(')');

            if (!extensions.isEmpty()) {
                for (final Entry<String, String> entry : extensions.entrySet()) {
                    builder.append(' ').append(entry.getKey()).append('/').append(entry.getValue());
                }
            }
            regenerate = false;
            return builder.toString();
        }

    }

    private static class UserAgentInterceptor implements Interceptor {

        private static final String USER_AGENT_HEADER = "User-Agent";
        private final UserAgent userAgent;

        public UserAgentInterceptor(UserAgent userAgent) {
            super();
            this.userAgent = userAgent;
        }

        @Override
        public Response intercept(Chain chain) throws IOException {
            final Request originRequest = chain.request();
            final Request requestWithUserAgent = userAgent == null ? originRequest.newBuilder().build()
                    : originRequest.newBuilder().addHeader(USER_AGENT_HEADER, generateUserAgent()).build();

            return chain.proceed(requestWithUserAgent);
        }

        private String generateUserAgent() {
            return userAgent.getUserAgentString();
        }

    }

}
