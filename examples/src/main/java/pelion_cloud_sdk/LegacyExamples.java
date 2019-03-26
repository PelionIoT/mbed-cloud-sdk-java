package pelion_cloud_sdk;

import static org.junit.Assert.fail;

import com.arm.mbed.cloud.sdk.Billing;
import com.arm.mbed.cloud.sdk.common.MbedCloudException;

import utils.AbstractExample;
import utils.Configuration;
import utils.Example;

public class LegacyExamples extends AbstractExample {
    /**
     * Using the Billing APIs
     */
    @Example
    public void getQuotaHistory() {
        // an example: hello world legacy
        try (Billing billingApi = new Billing(Configuration.get())) {
            billingApi.getAllQuotaHistory(null)
                      .forEach(q -> log("Quota change reason: " + q.getReason() + ", delta: " + q.getDelta()));

        } catch (MbedCloudException exception) {
            // TODO do something with the exception
            exception.printStackTrace();
            // Fails if an exception happened
            // cloak
            fail(exception.getMessage());
            // uncloak
        }
        // end of example
    }

}
