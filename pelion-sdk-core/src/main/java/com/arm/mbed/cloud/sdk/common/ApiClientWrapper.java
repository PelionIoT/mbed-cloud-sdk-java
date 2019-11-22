package com.arm.mbed.cloud.sdk.common;

import java.io.Closeable;
import java.io.IOException;
import java.net.InetAddress;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.arm.mbed.cloud.sdk.annotations.Internal;
import com.arm.mbed.cloud.sdk.annotations.NonNull;
import com.arm.mbed.cloud.sdk.annotations.Nullable;
import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.internal.mbedcloudcommon.ApiClient;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Converter;

@Preamble(description = "Client wrapper")
@Internal
public class ApiClientWrapper implements Cloneable, Closeable {
    private static final String DEFAULT_AUTH_NAME = "Bearer";
    private final UserAgent userAgent;
    protected final ApiClient client;
    private final ConnectionOptions connectionOptions;

    public static final String USER_AGENT_HEADER = "User-Agent";
    public static final String AUTHORISATION_HEADER = "Authorization";
    private static final TimePeriod TERMINATION_PERIOD = new TimePeriod(1);

    /**
     * Cloud client constructor.
     *
     * @param options
     *            connection options @see {@link ConnectionOptions}
     */
    public ApiClientWrapper(ConnectionOptions options) {
        this(options, new UserAgent());
    }

    /**
     *
     * Cloud client constructor.
     *
     * @param options
     *            connection options @see {@link ConnectionOptions}
     * @param userAgentExtensions
     *            extension list for the user agent: module name - module version
     */
    public ApiClientWrapper(ConnectionOptions options, Map<String, String> userAgentExtensions) {
        this(options, generateUserAgent(userAgentExtensions));
    }

    /**
     * Cloud client constructor.
     *
     * @param anotherClient
     *            another client
     */
    public ApiClientWrapper(ApiClientWrapper anotherClient) {
        this(anotherClient == null ? null : anotherClient.connectionOptions,
             anotherClient == null ? null : anotherClient.userAgent);
    }

    private ApiClientWrapper(ConnectionOptions options, UserAgent userAgent) {
        super();
        connectionOptions = options == null ? ConnectionOptions.newConfiguration() : options;
        this.client = createClient(connectionOptions);
        setLogging(connectionOptions.getClientLogLevel());
        setRequestTimeout(connectionOptions.getRequestTimeout());
        this.userAgent = userAgent == null ? new UserAgent() : userAgent;
        setUserAgent();
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
        this.connectionOptions.setClientLogLevel(level);
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
        this.connectionOptions.setRequestTimeout(timeout);
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
     * Shares instance underlying network layer and serialiser/deserialiser i.e. request pooling, disk cache, routing
     * logic, etc. <a href=
     * "https://futurestud.io/tutorials/retrofit-2-share-okhttp-client-and-converters-between-retrofit-instances">See
     * sharing network layer in Retrofit</a>
     * <p>
     * <a href="https://github.com/square/okhttp/wiki/Connections">See connection pool</a>
     * 
     * @param otherInstance
     *            an other client instance to share the network layer with.
     */
    public void shareNetworkLayer(ApiClientWrapper otherInstance) {
        if (otherInstance == null) {
            return;
        }
        client.configureFromOkclient(otherInstance.client.getOkBuilder().build());
        final List<Converter.Factory> converters = otherInstance.client.getAdapterBuilder().build()
                                                                       .converterFactories();
        if (converters == null) {
            return;
        }
        for (Converter.Factory factory : converters) {
            client.getAdapterBuilder().addConverterFactory(factory);
        }
    }

    /**
     * Gets a new websocket client establishing a connection via the connection endpoint.
     * 
     * @param connectionEndpoint
     *            endpoint to use to establish the connection
     * @param listener
     *            a notification listener
     * @param logger
     *            a logger
     * @return a websocket client.
     * @throws MbedCloudException
     *             if an error arises
     */
    @Internal
    public WebsocketClient getNewWebsocketClient(@NonNull String connectionEndpoint,
                                                 @NonNull NotificationListener listener,
                                                 SdkLogger logger) throws MbedCloudException {
        ApiUtils.checkNotNull(logger, connectionEndpoint, "connectionEndpoint");
        ApiUtils.checkNotNull(logger, listener, "listener");
        return new WebsocketClient(client, connectionOptions, connectionEndpoint, listener, logger);
    }

    /**
     * Pings the host to find if it is reachable.
     * 
     * @param timeout
     *            ping timeout. If null, the default timeout is considered {@link TimePeriod#TimePeriod()}
     * @return true if the host is reachable. False otherwise.
     */
    public boolean ping(@Nullable TimePeriod timeout) {

        try {
            final TimePeriod finalTimeout = timeout == null ? new TimePeriod() : timeout;
            final InetAddress address = InetAddress.getByName(connectionOptions.getHostUrl().getHost());
            if (address.isReachable(finalTimeout.toSeconds())) {
                return true;
            }
        } catch (@SuppressWarnings("unused") IOException exception) {
            // Nothing to do
        }
        return false;
    }

    /**
     * Gets the connection options used.
     *
     * @return the connectionOptions.
     */
    public ConnectionOptions getConnectionOptions() {
        return connectionOptions;
    }

    /**
     * Gets the Authorisation Token in use.
     * 
     * @return the token in use.
     */
    public String getAuthorisationToken() {
        return getAuthorisationToken(connectionOptions);
    }

    private static String getAuthorisationToken(ConnectionOptions options) {
        return formatApiKey(options == null ? null : options.getApiKey());
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((connectionOptions == null) ? 0 : connectionOptions.hashCode());
        result = prime * result + ((userAgent == null) ? 0 : userAgent.hashCode());
        return result;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof ApiClientWrapper)) {
            return false;
        }
        final ApiClientWrapper other = (ApiClientWrapper) obj;
        if (connectionOptions == null) {
            if (other.connectionOptions != null) {
                return false;
            }
        } else if (!connectionOptions.equals(other.connectionOptions)) {
            return false;
        }
        if (userAgent == null) {
            if (other.userAgent != null) {
                return false;
            }
        } else if (!userAgent.equals(other.userAgent)) {
            return false;
        }
        return true;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#clone()
     */
    @Override
    public ApiClientWrapper clone() {
        return new ApiClientWrapper(this);
    }

    private static UserAgent generateUserAgent(Map<String, String> userAgentExtensions) {
        if (userAgentExtensions == null || userAgentExtensions.isEmpty()) {
            return null;
        }
        final UserAgent userAgent = new UserAgent();
        for (Entry<String, String> entry : userAgentExtensions.entrySet()) {
            userAgent.addExtension(entry.getKey(), entry.getValue());
        }
        return userAgent;
    }

    private static ApiClient createClient(ConnectionOptions options) {
        final ApiClient apiClient = options.isApiKeyEmpty() ? new ApiClient()
                                                            : new ApiClient(DEFAULT_AUTH_NAME,
                                                                            getAuthorisationToken(options));
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

        /*
         * (non-Javadoc)
         *
         * @see java.lang.Object#hashCode()
         */
        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + ((userAgentString == null) ? 0 : userAgentString.hashCode());
            return result;
        }

        /*
         * (non-Javadoc)
         *
         * @see java.lang.Object#equals(java.lang.Object)
         */
        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null) {
                return false;
            }
            if (!(obj instanceof UserAgent)) {
                return false;
            }
            final UserAgent other = (UserAgent) obj;
            if (userAgentString == null) {
                if (other.userAgentString != null) {
                    return false;
                }
            } else if (!userAgentString.equals(other.userAgentString)) {
                return false;
            }
            return true;
        }
    }

    private static class UserAgentInterceptor implements Interceptor {

        private final UserAgent userAgent;

        public UserAgentInterceptor(UserAgent userAgent) {
            super();
            this.userAgent = userAgent;
        }

        @Override
        public Response intercept(Chain chain) throws IOException {
            final Request originRequest = chain.request();
            final Request requestWithUserAgent = userAgent == null ? originRequest.newBuilder().build()
                                                                   : originRequest.newBuilder()
                                                                                  .addHeader(USER_AGENT_HEADER,
                                                                                             generateUserAgent())
                                                                                  .build();

            return chain.proceed(requestWithUserAgent);
        }

        private String generateUserAgent() {
            return userAgent.getUserAgentString();
        }

    }

    @Override
    public void close() {
        okhttp3.Dispatcher dispatcher = client.getOkBuilder().build().dispatcher();
        dispatcher.cancelAll();
        dispatcher.executorService().shutdown();
        try {
            if (!dispatcher.executorService().awaitTermination(TERMINATION_PERIOD.getDuration(),
                                                               TERMINATION_PERIOD.getUnit())) {
                dispatcher.executorService().shutdownNow();
            }
        } catch (@SuppressWarnings("unused") InterruptedException exception) {
            dispatcher.executorService().shutdownNow();
        }
    }

}
