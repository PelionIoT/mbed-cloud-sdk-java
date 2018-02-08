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
     * Group data by this interval, defaults to 1 day.
     */
    @DefaultValue(value = "1 day")
    private TimePeriod interval;

    /**
     * Constructor.
     */
    public AbstractMetricsListOptions() {
        super();
        setDefault();
    }

    /**
     * Gets the interval to consider.
     * 
     * @return the interval
     */
    public TimePeriod getInterval() {
        return interval;
    }

    /**
     * Sets the interval to consider.
     * 
     * @param interval
     *            the interval to set
     */
    public void setInterval(TimePeriod interval) {
        this.interval = interval;
    }

    /**
     * Sets the interval from a string.
     * <p>
     * 
     * @see TimePeriod#fromString(String) for more information about expected string format
     * 
     * @param interval
     *            the interval to set
     */
    public void setInterval(String interval) {
        setInterval(new TimePeriod(interval));
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.arm.mbed.cloud.sdk.common.listing.ListOptions#setOptions(com.arm.mbed.cloud.sdk.common.listing.ListOptions)
     */
    /*
     * (non-Javadoc)
     * 
     * @see com.arm.mbed.cloud.sdk.common.listing.ListOptions#setDefault()
     */
    @Override
    protected void setDefault() {
        super.setDefault();
        setInterval(new TimePeriod());
    }

    @Override
    protected <T extends ListOptions> void setOptions(T options) {
        if (options == null) {
            setDefault();
            return;
        }
        super.setOptions(options);
        if (AbstractMetricsListOptions.class.isAssignableFrom(options.getClass())) {
            final AbstractMetricsListOptions abstractMetrics = (AbstractMetricsListOptions) options;
            setInterval(abstractMetrics.getInterval());
        }
    }

}
