package com.arm.mbed.cloud.sdk;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.arm.mbed.cloud.sdk.annotations.API;
import com.arm.mbed.cloud.sdk.annotations.Module;
import com.arm.mbed.cloud.sdk.annotations.Nullable;
import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.common.AbstractModule;
import com.arm.mbed.cloud.sdk.common.ConnectionOptions;
import com.arm.mbed.cloud.sdk.common.MbedCloudException;
import com.arm.mbed.cloud.sdk.common.SdkContext;

@Preamble(description = "Specifies test stub API")
@Module
/**
 * This stub is used to validate the test infrastructure itself.
 */
public class TestStub extends AbstractModule {
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
     * Test API that returns the arguments it received, some connection options and adds a day to the date argument it
     * received. I also returns a field 'success': true
     * 
     * @throws MbedCloudException
     *             an exception
     */
    @SuppressWarnings("boxing")
    @API
    public Map<String, Object> success(String testArgument0, int testArgument1, String testArgument2,
                                       Date testArgument3) throws MbedCloudException {
        Map<String, Object> obj = new HashMap<>(10);
        obj.put("testArgument0", testArgument0);
        obj.put("testArgument1", testArgument1);
        obj.put("testArgument2", testArgument2);
        // Adding a day to testArgument3
        Calendar c = Calendar.getInstance();
        c.setTime(testArgument3);
        c.add(Calendar.DATE, 1);
        obj.put("testArgument3", c.getTime());
        obj.put("success", true);
        obj.put("apiKey", opt.getApiKey());
        obj.put("host", opt.getHost());
        return obj;
    }

    @Override
    public SdkContext clone() {
        return null;
    }

}
