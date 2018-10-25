package pelion_cloud_sdk;

import static org.junit.Assert.fail;

import java.util.List;

import com.arm.mbed.cloud.sdk.accountmanagement.model.User;
import com.arm.mbed.cloud.sdk.common.CloudRequest;
import com.arm.mbed.cloud.sdk.common.GenericClient;
import com.arm.mbed.cloud.sdk.common.MbedCloudException;
import com.arm.mbed.cloud.sdk.common.SdkModel;

import retrofit2.Call;
import retrofit2.http.GET;
import utils.AbstractExample;
import utils.Configuration;
import utils.Example;

public class GenericClientExamples extends AbstractExample {

    /**
     * Uses the generic client to list users.
     */

    @Example
    public void useTheGenericClient() {
        // example: custom api call
        // Create a generic client
        GenericClient client = GenericClient.newClient(Configuration.get());
        // Define how to generate the request based on a set of parameters
        CloudRequest<UserListResponse, PelionApi> requestDefinition = new CloudRequest<UserListResponse, PelionApi>() {

            @Override
            public com.arm.mbed.cloud.sdk.common.CloudRequest.CloudCall<UserListResponse>
                   defineCall(PelionApi service, Object... parameters) throws MbedCloudException {

                return new CloudCall<GenericClientExamples.UserListResponse>() {

                    @Override
                    public Call<UserListResponse> call() {
                        return service.listAllUsers((Integer) parameters[0]);
                    }

                };
            }

        };
        // cloak
        try {

            @SuppressWarnings("boxing")
            // uncloak
            // Make the call with the following set of parameters. here, limit = 2.
            UserListResponse response = client.callApi(requestDefinition, 2);
            for (User user : response.getData()) {
                // Do something with users
                System.out.println(user);
            }
            // cloak
        } catch (Exception e) {
            // Logs information about the last API call.
            logError("last API Metadata", client.getLastApiMetadata());
            fail(e.getMessage());
        }
        // uncloak
    }

    /**
     * Definition of the REST endpoint.
     * <p>
     * See the documentation from <a href="https://square.github.io/retrofit/">Retrofit</a> to see how to defined a
     * service.
     */
    private interface PelionApi {
        @GET("v3/users")
        Call<UserListResponse> listAllUsers(@retrofit2.http.Query("limit") Integer limit);
    }

    /**
     * Definition of the response object.
     * <p>
     * Note: the response object has to be an entity and hence, should implement {@link SdkModel}.
     *
     */
    private static class UserListResponse implements SdkModel {
        /**
         *
         */
        private static final long serialVersionUID = 1L;
        List<User> data;

        /**
         * @param data
         */
        public UserListResponse(List<User> data) {
            super();
            this.data = data;
        }

        public List<User> getData() {
            return data;
        }

        public void setData(List<User> data) {
            this.data = data;
        }

        @Override
        public UserListResponse clone() {
            return new UserListResponse(data);
        }

        @Override
        public boolean isValid() {
            return true;
        }

        @Override
        public String getId() {
            return null;
        }

    }
    // end of example
}
