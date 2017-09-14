package com.arm.mbed.cloud.sdk.connect.notificationhandling;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import com.arm.mbed.cloud.sdk.common.AbstractApi;
import com.arm.mbed.cloud.sdk.common.CloudCaller;
import com.arm.mbed.cloud.sdk.common.CloudCaller.CallFeedback;
import com.arm.mbed.cloud.sdk.common.CloudCaller.CloudCall;
import com.arm.mbed.cloud.sdk.common.ConnectionOptions;
import com.arm.mbed.cloud.sdk.common.GenericAdapter.Mapper;
import com.arm.mbed.cloud.sdk.common.MbedCloudException;
import com.arm.mbed.cloud.sdk.common.TimePeriod;
import com.arm.mbed.cloud.sdk.common.TranslationUtils;
import com.arm.mbed.cloud.sdk.connect.model.EndPoints;
import com.arm.mbed.cloud.sdk.internal.mds.model.AsyncID;
import com.arm.mbed.cloud.sdk.internal.mds.model.AsyncIDResponse;
import com.arm.mbed.cloud.sdk.internal.mds.model.NotificationData;
import com.arm.mbed.cloud.sdk.internal.mds.model.NotificationMessage;
import com.mbed.lwm2m.DecodingException;
import com.mbed.lwm2m.EncodingType;
import com.mbed.lwm2m.base64.Base64Decoder;

import retrofit2.Call;

public class NotificationCache {

    private static final TimePeriod REQUEST_TIMEOUT = new TimePeriod(50);

    private static final int CACHE_INITIAL_CAPACITY = 10;

    private final AbstractApi api;
    private final ExecutorService pullThreads;
    private Future<?> pullHandle;
    private final EndPoints endpoint;
    private final ConcurrentHashMap<String, AsyncResponse> responseCache;
    // private final ConcurrentHashMap<String, ResourceSubscription> subscriptionCache;

    public NotificationCache(AbstractApi api, ExecutorService pullingThread, EndPoints endpoint) {
        super();
        this.pullThreads = pullingThread;
        this.endpoint = createNotificationPull(endpoint);
        this.api = api;
        pullHandle = null;
        responseCache = new ConcurrentHashMap<>(CACHE_INITIAL_CAPACITY);
        // subscriptionCache = new ConcurrentHashMap<>(CACHE_INITIAL_CAPACITY);
    }

    private EndPoints createNotificationPull(EndPoints endpoint2) {
        final ConnectionOptions options = endpoint2.getConnectionOptions();
        options.setRequestTimeout(REQUEST_TIMEOUT);
        return new EndPoints(options);
    }

    public void startNotificationPull() {
        if (isPullingActive()) {
            api.getLogger().logInfo("Notification pull is already working.");
            return;
        }
        final Runnable cachingSingleAction = createCachingSingleAction();
        pullHandle = null;
        if (pullThreads instanceof ScheduledExecutorService) {
            pullHandle = ((ScheduledExecutorService) pullThreads).scheduleWithFixedDelay(cachingSingleAction, 0, 50,
                    TimeUnit.MILLISECONDS);
        } else {
            pullHandle = pullThreads.submit(new Runnable() {

                @Override
                public void run() {
                    while (true) {
                        cachingSingleAction.run();
                    }

                }
            });
        }

    }

    public void stopNotificationPull() {
        if (pullHandle != null && !(pullHandle.isDone() || pullHandle.isCancelled())) {
            pullHandle.cancel(true);
        }
        pullHandle = null;
    }

    public boolean isPullingActive() {
        return pullHandle != null;
    }

    public void shutdown() {
        if (pullThreads != null) {
            pullThreads.shutdown();
        }
    }

    public Future<Object> fetchAsyncResponse(ExecutorService executor, String functionName, CloudCall<AsyncID> caller)
            throws MbedCloudException {
        if (!isPullingActive()) {
            api.getLogger().throwSDKException("startNotifications() needs to be called before setting resource value.");
        }
        final String asyncResponseId = CloudCaller.call(api, functionName, getResponseIdMapper(), caller);
        return fetchAsyncResponse(executor, asyncResponseId);
    }

    private static Mapper<AsyncID, String> getResponseIdMapper() {
        return new Mapper<AsyncID, String>() {

            @Override
            public String map(AsyncID toBeMapped) {
                return toBeMapped.getAsyncResponseId();
            }

        };
    }

    @SuppressWarnings("null")
    private Future<Object> fetchAsyncResponse(ExecutorService executor, String id) throws MbedCloudException {
        if (executor == null || id == null || id.isEmpty()) {
            api.getLogger().throwSDKException(new IllegalArgumentException());
        }
        final String responseId = id;
        return executor.submit(new Callable<Object>() {

            @Override
            public Object call() throws InterruptedException {
                while (!responseCache.containsKey(responseId)) {
                    Thread.sleep(10);
                }
                final AsyncResponse response = responseCache.get(responseId);
                responseCache.remove(responseId);
                if (response == null) {
                    return null;
                }
                if (response.statusCode != 200) {
                    final String errorMessage = response.errorMessage;
                    return errorMessage == null
                            ? "Async error (" + responseId + "). Status code: " + response.statusCode : errorMessage;
                }
                return response.payload;
            }

        });
    }

    private static Mapper<NotificationMessage, NotificationMessage> getIdentityMapper() {
        return new Mapper<NotificationMessage, NotificationMessage>() {

            @Override
            public NotificationMessage map(NotificationMessage toBeMapped) {
                return toBeMapped;
            }
        };
    }

    private Runnable createCachingSingleAction() {
        return new Runnable() {
            @Override
            public void run() {
                try {
                    final CallFeedback<NotificationMessage> feedback = CloudCaller.callWithFeedback(api,
                            "NotificationPullGet()", getIdentityMapper(), new CloudCall<NotificationMessage>() {

                                @Override
                                public Call<NotificationMessage> call() {
                                    return endpoint.getNotifications().v2NotificationPullGet();
                                }
                            }, false);
                    final NotificationMessage notificationMessage = feedback.getResult();
                    if (notificationMessage == null) {
                        api.getLogger().logInfo(
                                "Notification pull did not receive any notification during last call. Call information: "
                                        + feedback.getMetadata());
                        return;
                    }
                    cacheResponses(notificationMessage.getAsyncResponses());
                    // cacheSubscription(notificationMessage.getNotifications());

                } catch (MbedCloudException e) {
                    api.getLogger().logError("An error occurred during Notification pull", e);
                }
            }
        };
    }

    // private void cacheSubscription(List<NotificationData> notifications) {
    // if (notifications == null) {
    // return;
    // }
    // for (NotificationData notification : notifications) {
    // if (notification == null) {
    // continue;
    // }
    // try {
    // ResourceSubscription subscription = new ResourceSubscription(notification);
    // subscriptionCache.put(subscription.getKey(), subscription);
    // } catch (DecodingException e) {
    // api.getLogger().logError("An error occurred during Notification pull", e);
    // }
    //
    // }
    // }

    private void cacheResponses(List<AsyncIDResponse> asyncResponses) {
        if (asyncResponses == null) {
            return;
        }
        for (final AsyncIDResponse response : asyncResponses) {
            if (response == null) {
                continue;
            }

            try {
                final AsyncResponse asyncResponse = new AsyncResponse(response);
                responseCache.put(asyncResponse.getKey(), asyncResponse);
            } catch (DecodingException e) {
                api.getLogger().logError("An error occurred during Notification pull", e);
            }

        }
    }

    private static Object decodePayload(String payload, String ct) throws DecodingException {
        final EncodingType encodingType = EncodingType.getType(ct);
        if (encodingType == EncodingType.UNKNOWN) {
            return Base64Decoder.decodeToUtf8(payload);
        }
        final byte[] bytes = payload.getBytes(StandardCharsets.UTF_8);
        final ByteBuffer buffer = ByteBuffer.wrap(bytes);
        return Base64Decoder.decodeBase64(buffer, encodingType);
    }

    public static class AsyncResponse {
        private final String id;
        private final int statusCode;
        private final String errorMessage;
        private final Object payload;

        public AsyncResponse(String id, int statusCode, String errorMessage, Object payload) {
            super();
            this.id = id;
            this.statusCode = statusCode;
            this.errorMessage = errorMessage;
            this.payload = payload;
        }

        public AsyncResponse(AsyncIDResponse response) throws DecodingException {
            this(response.getId(), TranslationUtils.toInt(response.getStatus(), 200), response.getError(),
                    decodePayload(response.getPayload(), response.getCt()));
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
            result = prime * result + ((errorMessage == null) ? 0 : errorMessage.hashCode());
            result = prime * result + ((payload == null) ? 0 : payload.hashCode());
            result = prime * result + statusCode;
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
            if (getClass() != obj.getClass()) {
                return false;
            }
            final AsyncResponse other = (AsyncResponse) obj;
            if (errorMessage == null) {
                if (other.errorMessage != null) {
                    return false;
                }
            } else if (!errorMessage.equals(other.errorMessage)) {
                return false;
            }
            if (payload == null) {
                if (other.payload != null) {
                    return false;
                }
            } else if (!payload.equals(other.payload)) {
                return false;
            }
            if (statusCode != other.statusCode) {
                return false;
            }
            return true;
        }

        /*
         * (non-Javadoc)
         * 
         * @see java.lang.Object#toString()
         */
        @Override
        public String toString() {
            return "AsyncResponse [statusCode=" + statusCode + ", errorMessage=" + errorMessage + ", payload=" + payload
                    + "]";
        }

        public String getKey() {
            return id;
        }

    }

    public static class ResourceSubscription {
        private final String deviceId;
        private final String uriPath;
        private final Object payload;

        public ResourceSubscription(String deviceId, String uriPath, Object payload) {
            super();
            this.deviceId = deviceId;
            this.uriPath = uriPath;
            this.payload = payload;
        }

        protected ResourceSubscription(NotificationData data) throws DecodingException {
            this(data.getEp(), data.getPath(), decodePayload(data.getPayload(), data.getCt()));
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
            result = prime * result + ((deviceId == null) ? 0 : deviceId.hashCode());
            result = prime * result + ((uriPath == null) ? 0 : uriPath.hashCode());
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
            if (getClass() != obj.getClass()) {
                return false;
            }
            final ResourceSubscription other = (ResourceSubscription) obj;
            if (deviceId == null) {
                if (other.deviceId != null) {
                    return false;
                }
            } else if (!deviceId.equals(other.deviceId)) {
                return false;
            }
            if (uriPath == null) {
                if (other.uriPath != null) {
                    return false;
                }
            } else if (!uriPath.equals(other.uriPath)) {
                return false;
            }
            return true;
        }

        public String getKey() {
            return deviceId + uriPath;
        }

        /*
         * (non-Javadoc)
         * 
         * @see java.lang.Object#toString()
         */
        @Override
        public String toString() {
            return "ResourceSubscription [deviceId=" + deviceId + ", uriPath=" + uriPath + ", payload=" + payload + "]";
        }

    }

}
