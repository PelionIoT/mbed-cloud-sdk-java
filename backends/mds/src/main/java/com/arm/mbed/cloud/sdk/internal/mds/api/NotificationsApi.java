package com.arm.mbed.cloud.sdk.internal.mds.api;

import com.arm.mbed.cloud.sdk.internal.CollectionFormats.*;


import retrofit2.Call;
import retrofit2.http.*;

import okhttp3.RequestBody;

import com.arm.mbed.cloud.sdk.internal.mds.model.NotificationMessage;
import com.arm.mbed.cloud.sdk.internal.mds.model.Webhook;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public interface NotificationsApi {
  /**
   * Register a callback URL
   * Register a URL to which the server should deliver notifications of the subscribed resource changes. To get notifications pushed you need to also place the subscriptions.  The maximum length of URL, header keys and values, all combined, is 400 characters.  Notifications are delivered as PUT messages to the HTTP server defined by the client with a subscription server message.  The given URL should be accessible and respond to the PUT request with response code of 200 or 204. mbed Cloud Connect  tests the callback URL with an empty payload when the URL is registered. For more information on callback notification, see [NotificationMessage](/docs/v1.2/api-references/connect-api.html#notificationmessage).  **Note**: Only one callback URL per an API key can be active. If you register a new URL while another one is already active,  it replaces the active one. There can be only one notification channel at a time. If the Long Poll notification is already present  you need to delete it before setting the callback URL.  **Expiration of a callback URL:**   A callback can expire when mbed DS cannot deliver a notification due to a connection timeout or  error response (4xx or 5xx). After each delivery failure, mbed DS sets an exponential back off time and makes a retry attempt  after that. The first retry delay is 1 second, then 2s, 4s, 8s, ..., 2min, 2min. The maximum retry delay is 2 minutes.  The callback URL will be removed if all retries fail withing 24 hours. More about [notification sending logic](/docs/v1.2/device-dev/developer-guide-to-mbed-cloud-connect.html#notification-sending-logic). 
   * @param webhook A json object that contains the optional headers and the URL to which the notifications need to be sent.  (required)
   * @return Call&lt;Void&gt;
   */
  
  @Headers({
  	"Content-Type:application/json" 
  })
  @PUT("v2/notification/callback")
  Call<Void> v2NotificationCallbackPut(
    @retrofit2.http.Body Webhook webhook
  );

  /**
   * Delete notification Long Poll channel
   * To delete a notification Long Poll channel. This is required to change the channel from Long Poll to a callback. 
   * @return Call&lt;Void&gt;
   */
  
  @DELETE("v2/notification/pull")
  Call<Void> v2NotificationPullDelete();
    

  /**
   * Get notifications using Long Poll
   * In this case, notifications are delivered through HTTP long poll requests. The HTTP request is kept open until an event notification or a batch of event notifications are delivered to the client or the request times out  (response code 204). In both cases, the client should open a new polling connection after the previous one closes. Only a single long polling connection per API key can be ongoing at any given time. You must have a persistent connection (Connection keep-alive header in the request) to avoid excess  TLS handshakes.  **Note:** If it is not possible to have a public facing callback URL, for example when developing on your local machine, you can use long polling to check for new messages. However, long polling is deprecated and will likely be replaced in future. It is meant only for experimentation and not for commercial usage. The proper method to receive notifications is via [Notification Callback](/docs/v1.2/api-references/connect-api.html#v2-notification-callback). Only a single notification channel per API key can exist in mbed Cloud Connect at a time. If a callback notification channel already exists, you need to delete it before creating a long poll notification channel, and vice-versa. 
   * @return Call&lt;NotificationMessage&gt;
   */
  
  @GET("v2/notification/pull")
  Call<NotificationMessage> v2NotificationPullGet();
    

}
