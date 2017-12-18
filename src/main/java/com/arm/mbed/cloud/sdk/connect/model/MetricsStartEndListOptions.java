package com.arm.mbed.cloud.sdk.connect.model;

import java.util.Date;

import com.arm.mbed.cloud.sdk.annotations.Preamble;

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
        setStart(null);
        setEnd(null);
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

}
