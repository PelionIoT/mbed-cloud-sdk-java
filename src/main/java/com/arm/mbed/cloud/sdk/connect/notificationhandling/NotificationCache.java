package com.arm.mbed.cloud.sdk.connect.notificationhandling;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;

import com.arm.mbed.cloud.sdk.common.MbedCloudException;
import com.arm.mbed.cloud.sdk.common.TranslationUtils;
import com.arm.mbed.cloud.sdk.connect.model.EndPoints;
import com.arm.mbed.cloud.sdk.internal.model.AsyncIDResponse;
import com.arm.mbed.cloud.sdk.internal.model.NotificationData;
import com.arm.mbed.cloud.sdk.internal.model.NotificationMessage;
import com.mbed.lwm2m.DecodingException;
import com.mbed.lwm2m.EncodingType;
import com.mbed.lwm2m.base64.Base64Decoder;

import retrofit2.Response;

public class NotificationCache {

    private static final int CACHE_INITIAL_CAPACITY = 10;

    private final Logger logger;
    private final ExecutorService pollingThreads;
    private Future<?> pollingHandle;
    private final EndPoints endpoint;
    private final ConcurrentHashMap<String, AsyncResponse> responseCache;
    private final ConcurrentHashMap<String, ResourceSubscription> subscriptionCache;

    public NotificationCache(Logger logger, ExecutorService pollingThread, EndPoints endpoint) {
        super();
        this.pollingThreads = pollingThread;
        this.endpoint = endpoint;
        this.logger = logger;
        pollingHandle = null;
        responseCache = new ConcurrentHashMap<>(CACHE_INITIAL_CAPACITY);
        subscriptionCache = new ConcurrentHashMap<>(CACHE_INITIAL_CAPACITY);
    }

    private void logError(String message) {
        logger.error(message);
    }

    public void startPolling() {
        final Runnable cachingSingleAction = createCachingSingleAction();
        pollingHandle = null;
        if (pollingThreads instanceof ScheduledExecutorService) {
            pollingHandle = ((ScheduledExecutorService) pollingThreads).scheduleWithFixedDelay(cachingSingleAction, 0,
                    50, TimeUnit.MILLISECONDS);
        } else {
            pollingHandle = pollingThreads.submit(new Runnable() {

                @Override
                public void run() {
                    while (true) {
                        cachingSingleAction.run();
                    }

                }
            });
        }

    }

    public void stopPolling() {
        if (pollingHandle != null) {
            if (!pollingHandle.isDone() && !pollingHandle.isCancelled()) {
                pollingHandle.cancel(true);
            }
        }
        pollingHandle = null;
    }

    public boolean isPollingActive() {
        return (pollingHandle != null);
    }

    public void shutdown() {
        if (pollingThreads != null) {
            pollingThreads.shutdown();
        }
    }

    public Future<Object> fetchAsyncResponse(ExecutorService executor, String id) throws MbedCloudException {
        if (executor == null || id == null || id.isEmpty()) {
            throw new MbedCloudException(new IllegalArgumentException());
        }
        final String responseId = id;
        return executor.submit(new Callable<Object>() {

            @Override
            public Object call() throws Exception {
                while (!responseCache.containsKey(responseId)) {
                    Thread.sleep(10);
                }
                AsyncResponse response = responseCache.get(responseId);
                responseCache.remove(responseId);
                if (response == null) {
                    return null;
                }
                if (response.statusCode != 200) {
                    String errorMessage = response.errorMessage;
                    return (errorMessage != null) ? errorMessage
                            : "Async error (" + responseId + "). Status code: " + response.statusCode;
                }
                return response.payload;
            }

        });
    }

    private Runnable createCachingSingleAction() {
        return new Runnable() {
            @Override
            public void run() {
                try {
                    Response<NotificationMessage> notification = endpoint.getNotifications().v2NotificationPullGet()
                            .execute();
                    NotificationMessage notificationMessage = (notification == null) ? null : notification.body();
                    if (notificationMessage == null) {
                        return;
                    }
                    cacheResponses(notificationMessage.getAsyncResponses());
                    cacheSubscription(notificationMessage.getNotifications());

                } catch (IOException e) {
                    logError("An error occurred during long polling: " + e.getMessage());
                }
            }
        };
    }

    private void cacheSubscription(List<NotificationData> notifications) {
        if (notifications == null) {
            return;
        }
        for (NotificationData notification : notifications) {
            if (notification == null) {
                continue;
            }
            try {
                ResourceSubscription subscription = new ResourceSubscription(notification);
                subscriptionCache.put(subscription.getKey(), subscription);
            } catch (DecodingException e) {
                logError("An error occurred during long polling: " + e.getMessage());
            }

        }
    }

    private void cacheResponses(List<AsyncIDResponse> asyncResponses) {
        if (asyncResponses == null) {
            return;
        }
        for (AsyncIDResponse response : asyncResponses) {
            if (response == null) {
                continue;
            }

            try {
                AsyncResponse asyncResponse = new AsyncResponse(response);
                responseCache.put(asyncResponse.getKey(), asyncResponse);
            } catch (DecodingException e) {
                logError("An error occurred during long polling: " + e.getMessage());
            }

        }
    }

    private static Object decodePayload(String payload, String ct) throws DecodingException {
        EncodingType encodingType = EncodingType.getType(ct);
        if (encodingType == EncodingType.UNKNOWN) {
            return Base64Decoder.decodeToUtf8(payload);
        }
        byte[] bytes = payload.getBytes(StandardCharsets.UTF_8);
        ByteBuffer buffer = ByteBuffer.wrap(bytes);
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
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            if (getClass() != obj.getClass())
                return false;
            AsyncResponse other = (AsyncResponse) obj;
            if (errorMessage == null) {
                if (other.errorMessage != null)
                    return false;
            } else if (!errorMessage.equals(other.errorMessage))
                return false;
            if (payload == null) {
                if (other.payload != null)
                    return false;
            } else if (!payload.equals(other.payload))
                return false;
            if (statusCode != other.statusCode)
                return false;
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

        private ResourceSubscription(NotificationData data) throws DecodingException {
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
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            if (getClass() != obj.getClass())
                return false;
            ResourceSubscription other = (ResourceSubscription) obj;
            if (deviceId == null) {
                if (other.deviceId != null)
                    return false;
            } else if (!deviceId.equals(other.deviceId))
                return false;
            if (uriPath == null) {
                if (other.uriPath != null)
                    return false;
            } else if (!uriPath.equals(other.uriPath))
                return false;
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
