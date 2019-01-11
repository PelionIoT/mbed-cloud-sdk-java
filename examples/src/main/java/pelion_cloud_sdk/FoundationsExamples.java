package pelion_cloud_sdk;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.util.stream.StreamSupport;

import com.arm.mbed.cloud.sdk.Sdk;
import com.arm.mbed.cloud.sdk.accounts.model.AccountDao;
import com.arm.mbed.cloud.sdk.accounts.model.SubtenantUser;
import com.arm.mbed.cloud.sdk.accounts.model.SubtenantUserDao;
import com.arm.mbed.cloud.sdk.common.MbedCloudException;

import utils.AbstractExample;
import utils.Configuration;
import utils.Example;

public class FoundationsExamples extends AbstractExample {

    /**
     * Creates and manages a sub-tenant account.
     */

    @Example
    public void manageSubtenants() {
        // an example: creating and managing a subtenant account
        try (Sdk sdk = Sdk.createSdk(Configuration.get())) {
            // Fetch my account
            AccountDao myAccountDao = sdk.daos().getAccountDao();
            myAccountDao.me(null, null);
            // Create a new User
            SubtenantUser user = new SubtenantUser();
            user.setAccountId(myAccountDao.getId());
            user.setFullName("tommi the wombat");
            user.setEmail("tommi_the_wombat@email.com");
            user.setUsername("tommi_wombat");
            user.setPhoneNumber("0800001066");
            SubtenantUserDao userDao = sdk.daos().getSubtenantUserDao();
            // cloak
            // Perform some account cleanup
            performAccountCleanup(myAccountDao, user, userDao);
            // uncloak
            userDao.create(user);
            // Find this added user in my account user list.
            String createdId = userDao.getId();
            // cloak
            assertNotNull(createdId);
            // uncloak
            // Fetch latest details of the current sub-tenant user.
            userDao.read();
            // Fetching a user from the list of account users
            SubtenantUser correspondingUser = StreamSupport.stream(myAccountDao.allUsers(null, null, null, null, null,
                                                                                         null)
                                                                               .spliterator(),
                                                                   false)
                                                           .filter(u -> u.getId().equals(createdId)).findFirst().get();
            // cloak
            assertEquals(userDao.getModel(), correspondingUser);
            // uncloak
            // Delete the created user.
            userDao.delete();

        } catch (MbedCloudException exception) {
            // TODO do something with the exception
            exception.printStackTrace();
            // cloak
            fail(exception.getMessage());
            // uncloak
        }
        // end of example
    }

    private void performAccountCleanup(AccountDao myAccountDao, SubtenantUser user,
                                       SubtenantUserDao userDao) throws MbedCloudException {
        StreamSupport.stream(myAccountDao.allUsers(null, null, null, null, null, null).spliterator(), false)
                     .filter(u -> user.getUsername().equals(u.getUsername())).forEach(u -> {
                         try {
                             userDao.delete(u);
                         } catch (MbedCloudException exception) {
                             exception.printStackTrace();
                         }
                     });
    }

}
