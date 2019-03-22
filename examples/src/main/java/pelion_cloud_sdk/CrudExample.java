package pelion_cloud_sdk;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.util.Arrays;

import com.arm.mbed.cloud.Sdk;
import com.arm.mbed.cloud.sdk.accounts.model.User;
import com.arm.mbed.cloud.sdk.accounts.model.UserListOptions;
import com.arm.mbed.cloud.sdk.accounts.model.UserStatus;
import com.arm.mbed.cloud.sdk.common.MbedCloudException;
import com.arm.mbed.cloud.sdk.common.Order;
import com.arm.mbed.cloud.sdk.common.listing.Paginator;

import utils.AbstractExample;
import utils.Configuration;
import utils.Example;

public class CrudExample extends AbstractExample {
    /**
     * CRUD example on a User
     */
    @Example
    public void dealWithUsers() {

        try (Sdk sdk = new Sdk(Configuration.get())) {
            // an example: create an entity
            User newUser = new User();
            newUser.setEmail("java.sdk.user@arm.com");
            sdk.foundation().getUserDao().create(newUser);
            // end of example

            User user = sdk.foundation().getUserListDao()
                           .list(new UserListOptions().equalToEmail("java.sdk.user@arm.com")).first();
            assertNotNull(user);
            log("fetching the created user", user);
            String userId = user.getId();

            // an example: read an entity
            User userOne = sdk.foundation().getUserDao().read(userId);
            // cloak
            assertNotNull(userOne);
            // uncloak
            System.out.println(userOne.getEmail());
            // end of example
            assertEquals("java.sdk.user@arm.com", userOne.getEmail());

            // an example: update an entity
            User userTwo = sdk.foundation().getUserDao().read(userId);
            // cloak
            assertNotNull(userTwo);
            // uncloak
            userTwo.setFullName("Java SDK User");
            sdk.foundation().getUserDao().update(userTwo);
            // end of example
            User updatedUser = sdk.foundation().getUserDao().read(userId);
            assertNotNull(updatedUser);
            assertEquals("Java SDK User", userOne.getFullName());
            // an example: delete an entity
            User userThree = sdk.foundation().getUserDao().read(userId);
            // cloak
            assertNotNull(userThree);
            // uncloak

            sdk.foundation().getUserDao().delete(userThree);
            // end of example
            // an example: list entities
            Paginator<User> paginator = sdk.foundation().getUserListDao()
                                           .list(new UserListOptions().maxResults(10).pageSize(5).order(Order.ASC)
                                                                      .includeTotalCount());

            paginator.forEach(u -> System.out.println(user.getFullName() + " (" + user.getId() + "): " + u.getEmail()));
            System.out.println("Total count: " + paginator.getElementsTotal());
            // end of example
            // an example: list entities with filters
            Paginator<User> paginatorWithFilters = sdk.foundation().getUserListDao()
                                                      .list(new UserListOptions().equalToEmail("java.sdk.user@arm.com")
                                                                                 .inStatuses(Arrays.asList(UserStatus.ACTIVE,
                                                                                                           UserStatus.ENROLLING))
                                                                                 .maxResults(10).pageSize(5)
                                                                                 .order(Order.ASC).includeTotalCount());

            paginatorWithFilters.forEach(u -> System.out.println(user.getFullName() + " (" + user.getId() + "): "
                                                                 + u.getEmail()));
            System.out.println("Total count: " + paginatorWithFilters.getElementsTotal());
            // end of example

        } catch (MbedCloudException exception) {
            // TODO do something with the exception
            exception.printStackTrace();
            // Fails if an exception happened
            fail(exception.getMessage());
        }
    }

}
