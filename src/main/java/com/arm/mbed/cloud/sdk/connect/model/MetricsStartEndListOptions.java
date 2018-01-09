package com.arm.mbed.cloud.sdk.connect.model;

import java.util.Date;

import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.common.listing.ListOptions;

@Preamble(description = "Options to use when listing metrics within a period")
public class MetricsStartEndListOptions extends AbstractMetricsListOptions {
    /**
     * Start date.
     */
    private Date start;
    /**
     * End date.
     */
    private Date end;

    /**
     * Constructor.
     */
    public MetricsStartEndListOptions() {
        super();
        setDefault();
    }

    /**
     * Gets start date.
     * 
     * @return the start
     */
    public Date getStart() {
        return start;
    }

    /**
     * Sets start date.
     * 
     * @param start
     *            the start to set
     */
    public void setStart(Date start) {
        this.start = start;
    }

    /**
     * Gets end date.
     * 
     * @return the end
     */
    public Date getEnd() {
        return end;
    }

    /**
     * Sets end date.
     * 
     * @param end
     *            the end to set
     */
    public void setEnd(Date end) {
        this.end = end;
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
        setStart(null);
        setEnd(null);
    }

    @Override
    protected <T extends ListOptions> void setOptions(T options) {
        if (options == null) {
            setDefault();
            return;
        }
        super.setOptions(options);
        if (MetricsStartEndListOptions.class.isAssignableFrom(options.getClass())) {
            final MetricsStartEndListOptions opt = (MetricsStartEndListOptions) options;
            setStart(opt.getStart());
            setEnd(opt.getEnd());
        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.arm.mbed.cloud.sdk.common.listing.ListOptions#clone()
     */
    @Override
    public MetricsStartEndListOptions clone() {
        final MetricsStartEndListOptions opt = new MetricsStartEndListOptions();
        opt.setOptions(this);
        return opt;
    }
}
