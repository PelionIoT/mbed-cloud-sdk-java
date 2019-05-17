package com.arm.mbed.cloud.sdk.common;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import com.arm.mbed.cloud.sdk.common.CloudRequest.CloudCall;
import com.arm.mbed.cloud.sdk.common.listing.ListOptions;
import com.arm.mbed.cloud.sdk.common.listing.ListResponse;
import com.arm.mbed.cloud.sdk.common.listing.Paginator;
import com.squareup.okhttp.HttpUrl;
import com.squareup.okhttp.mockwebserver.MockResponse;
import com.squareup.okhttp.mockwebserver.MockWebServer;
import com.squareup.okhttp.mockwebserver.RecordedRequest;

import retrofit2.Call;
import retrofit2.http.GET;

public class TestGenericClient {

    private static final int TOTAL_RESULT_NUMBER = 9;
    private static final String SOME_FAKE_USER_DATA = "{\"object\":\"list\",\"limit\":2,\"after\":null,\"order\":\"ASC\",\"totalCount\":"
                                                      + TOTAL_RESULT_NUMBER
                                                      + ",\"hasMore\":false,\"data\":[{\"accountId\":\"015a9e3ac83502420a01500a00000000\",\"loginProfiles\":[{\"id\":\"016290940a005e1b17c358ff00000000\",\"name\":\"Pelion Cloud\",\"type\":\"NATIVE\"}],\"status\":\"RESET\",\"username\":null,\"password\":null,\"fullName\":\"Rob Moran\",\"email\":\"rob.moran@itisatest.com\",\"address\":null,\"phoneNumber\":null,\"groups\":[\"0157d765ebc502420a010f0d00000000\",\"015a9e3ac86802420a01400a00000000\",\"015a9e3ac86102420a01400a00000000\"],\"areTermsAccepted\":true,\"isMarketingAccepted\":true,\"creationTime\":1488713336000,\"lastLoginTime\":1517679475125,\"passwordChangedTime\":1521112093416,\"twoFactorAuthentication\":false,\"object\":\"user\",\"id\":\"0157d80ee2db02420a010f0d00000000\",\"etag\":\"1\",\"createdAt\":\"2017-03-05T11:28:56Z\",\"updatedAt\":null},{\"accountId\":\"015a9e3ac83502420a01400a00000000\",\"loginProfiles\":[{\"id\":\"0162909c0a005e1b17c358ff00000000\",\"name\":\"Pelion Cloud\",\"type\":\"NATIVE\"}],\"status\":\"ACTIVE\",\"username\":\"joea\",\"password\":null,\"fullName\":\"joea\",\"email\":\"joe.alderson@test.com\",\"address\":null,\"phoneNumber\":null,\"groups\":[\"015a9e3ac86102420a01400a00000000\",\"015a9e3ac86802420a01400a00000000\"],\"areTermsAccepted\":false,\"isMarketingAccepted\":false,\"creationTime\":1488713336000,\"lastLoginTime\":1522858931763,\"passwordChangedTime\":1522858921732,\"twoFactorAuthentication\":false,\"object\":\"user\",\"id\":\"015a9e3ac85a02420a01400a00000000\",\"etag\":\"1\",\"createdAt\":\"2017-03-05T11:28:56Z\",\"updatedAt\":null}]}";
    private static final String AN_ENDPOINT_PATH = "v3/users/";
    private static final String QUERY_PARAMETER = "limit";

    /**
     * Tests that the HTTP client wrapper works as expected by spawning a mock server and checking received requests.
     */
    @Test
    public void testClient() {
        try {
            MockWebServer server = new MockWebServer();
            server.enqueue(new MockResponse().setBody(SOME_FAKE_USER_DATA));
            server.start();
            HttpUrl baseUrl = server.url("");
            GenericClient client = GenericClient.newClient(ConnectionOptions.newConfiguration("apikey")
                                                                            .host(baseUrl.toString()));
            CloudRequest<UserListResponse,
                         PelionApi> requestDefinition = new CloudRequest<UserListResponse, PelionApi>() {

                             @Override
                             public com.arm.mbed.cloud.sdk.common.CloudRequest.CloudCall<UserListResponse>
                                    defineCall(final PelionApi service,
                                               final Object... parameters) throws MbedCloudException {

                                 return new CloudCall<UserListResponse>() {

                                     @Override
                                     public Call<UserListResponse> call() {
                                         return service.listAllUsers((Integer) parameters[0]);
                                     }

                                 };
                             }

                         };

            int queryParameter = 2;
            try {
                @SuppressWarnings("boxing")
                UserListResponse response = client.callApi(requestDefinition, queryParameter);
                assertNotNull(response);
                assertNotNull(response.getData());
                assertEquals(queryParameter, response.getData().size());
                for (User user : response.getData()) {
                    assertNotNull(user);
                    assertTrue(user.isValid());
                    System.out.println(user);
                }
            } catch (Exception e) {
                // Logs information about the last API call.
                System.err.println("last API Metadata: " + client.getLastApiMetadata());
                fail(e.getMessage());
            }
            RecordedRequest request = server.takeRequest();
            assertEquals("GET", request.getMethod());
            assertEquals("/" + AN_ENDPOINT_PATH + "?" + QUERY_PARAMETER + "=" + queryParameter, request.getPath());
            assertNotNull(request.getHeader("Authorization"));
            assertTrue(request.getHeader("Authorization").contains("Bearer"));
            assertNotNull(request.getHeader("User-Agent"));
            assertTrue(request.getHeader("User-Agent").contains(ApiClientWrapper.UserAgent.MBED_CLOUD_SDK_IDENTIFIER));
            server.shutdown();
        } catch (IOException | InterruptedException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testClientWithPagination() {
        try {
            MockWebServer server = new MockWebServer();
            server.enqueue(new MockResponse().setBody(SOME_FAKE_USER_DATA));
            server.start();
            HttpUrl baseUrl = server.url("");
            GenericClient client = GenericClient.newClient(ConnectionOptions.newConfiguration("apikey")
                                                                            .host(baseUrl.toString()));

            CloudRequest.CloudListRequest<User, PelionListApi,
                                          ListOptions> requestDefinition = new CloudRequest.CloudListRequest<User,
                                                                                                             PelionListApi,
                                                                                                             ListOptions>() {

                                              @Override
                                              public CloudCall<ListResponse<User>>
                                                     defineCall(final PelionListApi service, final ListOptions options,
                                                                Object... extraParameters) throws MbedCloudException {
                                                  return new CloudCall<ListResponse<User>>() {

                                                      @Override
                                                      public Call<ListResponse<User>> call() {
                                                          return service.listAllUsers(options.getPageSize());
                                                      }
                                                  };
                                              }

                                          };
            int queryParameter = 2;
            try {

                Paginator<User> paginatedResponse = client.callPaginatedApi(requestDefinition,
                                                                            new ListOptions().pageSize(queryParameter));

                assertTrue(paginatedResponse.first().isValid());
                assertEquals(TOTAL_RESULT_NUMBER, paginatedResponse.count());
            } catch (Exception e) {
                // Logs information about the last API call.
                System.err.println("last API Metadata: " + client.getLastApiMetadata());
                fail(e.getMessage());
            }
            RecordedRequest request = server.takeRequest();
            assertEquals("GET", request.getMethod());
            assertEquals("/" + AN_ENDPOINT_PATH + "?" + QUERY_PARAMETER + "=" + queryParameter, request.getPath());
            assertNotNull(request.getHeader("Authorization"));
            assertTrue(request.getHeader("Authorization").contains("Bearer"));
            assertNotNull(request.getHeader("User-Agent"));
            assertTrue(request.getHeader("User-Agent").contains(ApiClientWrapper.UserAgent.MBED_CLOUD_SDK_IDENTIFIER));
            server.shutdown();
        } catch (IOException |

                 InterruptedException e) {
            fail(e.getMessage());
        }
    }

    private interface PelionApi {

        @GET(AN_ENDPOINT_PATH)
        Call<UserListResponse> listAllUsers(@retrofit2.http.Query(QUERY_PARAMETER) Integer limit);
    }

    private interface PelionListApi {
        @GET(AN_ENDPOINT_PATH)
        Call<ListResponse<User>> listAllUsers(@retrofit2.http.Query(QUERY_PARAMETER) Integer limit);
    }

    private static class User implements SdkModel {

        private static final long serialVersionUID = -8312844598163698961L;

        public String id;

        public String accountId;

        public String fullName;

        public String username;

        public String password;

        public String email;

        public String phoneNumber;

        public String address;

        public boolean areTermsAccepted;

        public boolean isMarketingAccepted;

        public List<String> groups;

        public Date createdAt;

        public boolean twoFactorAuthentication;

        public long creationTime;

        public long passwordChangedTime;

        public long lastLoginTime;

        @Override
        public String toString() {
            return "User [id=" + id + ", accountId=" + accountId + ", fullName=" + fullName + ", username=" + username
                   + ", password=" + password + ", email=" + email + ", phoneNumber=" + phoneNumber + ", address="
                   + address + ", areTermsAccepted=" + areTermsAccepted + ", isMarketingAccepted=" + isMarketingAccepted
                   + ", groups=" + groups + ", createdAt=" + createdAt + ", twoFactorAuthentication="
                   + twoFactorAuthentication + ", creationTime=" + creationTime + ", passwordChangedTime="
                   + passwordChangedTime + ", lastLoginTime=" + lastLoginTime + "]";
        }

        @Override
        public boolean isValid() {
            return id != null;
        }

        @Override
        public String getId() {
            return id;
        }

        @Override
        public void setId(String id) {
            this.id = id;

        }

        @Override
        public User clone() {
            return this;
        }

    }

    /**
     * Definition of the response object.
     */
    private static class UserListResponse {
        List<User> data;

        public List<User> getData() {
            return data;
        }

        @SuppressWarnings("unused")
        public void setData(List<User> data) {
            this.data = data;
        }

    }

}
