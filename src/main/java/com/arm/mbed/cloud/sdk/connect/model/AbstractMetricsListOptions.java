/**
 * 
 */
package com.arm.mbed.cloud.sdk.connect.model;

import com.arm.mbed.cloud.sdk.annotations.DefaultValue;
import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.common.TimePeriod;
import com.arm.mbed.cloud.sdk.common.listing.ListOptions;

@Preamble(description = "Options to use when listing metrics")
public abstract class AbstractMetricsListOptions extends ListOptions {
    /**
     * Group data by this interval, defaults to 1 day
     */
    @DefaultValue(value = "1 day")
    private TimePeriod interval;

    public AbstractMetricsListOptions() {
        super();
        setInterval(new TimePeriod());
    }

    /**
     * @return the interval
     */
    public TimePeriod getInterval() {
        return interval;
    }

    /**
     * @param interval
     *            the interval to set
     */
    public void setInterval(TimePeriod interval) {
        this.interval = interval;
    }

    /**
     * @param interval
     *            the interval to set
     */
    public void setInterval(String interval) {
        setInterval(new TimePeriod(interval));
    }
}
