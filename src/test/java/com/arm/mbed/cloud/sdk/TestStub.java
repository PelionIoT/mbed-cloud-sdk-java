package com.arm.mbed.cloud.sdk;

import java.util.Calendar;
import java.util.Date;

import com.arm.mbed.cloud.sdk.annotations.API;
import com.arm.mbed.cloud.sdk.annotations.Module;
import com.arm.mbed.cloud.sdk.annotations.Nullable;
import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.common.AbstractApi;
import com.arm.mbed.cloud.sdk.common.ConnectionOptions;
import com.arm.mbed.cloud.sdk.common.MbedCloudException;

@Preamble(description = "Specifies test stub API")
@Module
/**
 * This stub is used to validate the test infrastructure itself.
 */
public class TestStub extends AbstractApi {
    private final ConnectionOptions opt;

    /**
     * Test Stub module constructor.
     * 
     * @param options
     *            connection options @see {@link ConnectionOptions}.
     */
    public TestStub(ConnectionOptions options) {
        super(options);
        opt = options;
    }

    @Override
    public String getModuleName() {
        return "test_stub";
    }

    /**
     * Test API that raises an exception
     * 
     * @throws MbedCloudException
     *             an exception
     */
    @API
    public @Nullable void exception() throws MbedCloudException {
        throw new MbedCloudException("just a test");
    }

    /**
     * Test API that does nothing and hence should be successful
     * 
     * @throws MbedCloudException
     *             an exception
     */
    @API
    public void success() throws MbedCloudException {
        // Nothing to do
    }

    /**
     * Test API that appends a day to a date object
     * 
     * @throws MbedCloudException
     *             an exception
     */
    @API
    public @Nullable Date handleDateAndAddADay(Date aDate) throws MbedCloudException {
        if (aDate == null) {
            return null;
        }
        Calendar dateWithOneDayAhead = Calendar.getInstance();
        dateWithOneDayAhead.setTime(aDate);
        dateWithOneDayAhead.set(Calendar.DAY_OF_MONTH, dateWithOneDayAhead.get(Calendar.DAY_OF_MONTH) + 1);
        return dateWithOneDayAhead.getTime();
    }

    /**
     * Test API that receives a None value and returns it
     * 
     * @throws MbedCloudException
     *             an exception
     */
    @API
    public @Nullable Object handleNone(Object aNoneObject) throws MbedCloudException {
        return aNoneObject;
    }
}
