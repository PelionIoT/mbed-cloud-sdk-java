package com.arm.mbed.cloud.sdk.billing.model;

import java.util.Date;

import com.arm.mbed.cloud.sdk.annotations.Internal;
import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.common.SdkModel;

@Preamble(description = "Billing report content")
public class ReportContent implements SdkModel {

    /**
     * Serialisation Id.
     */
    private static final long serialVersionUID = -286197791975216144L;

    private final long activeDevices;

    private final long firmwareUpdates;

    private final Date generated;

    private final Date periodEnd;

    private final Date periodStart;

    /**
     * Internal constructor.
     *
     * @param activeDevices
     *            activeDevices
     * @param firmwareUpdates
     *            firmwareUpdates
     * @param generated
     *            generated
     * @param periodEnd
     *            periodEnd
     * @param periodStart
     *            periodStart
     */
    @Internal
    public ReportContent(long activeDevices, long firmwareUpdates, Date generated, Date periodEnd, Date periodStart) {
        super();
        this.activeDevices = activeDevices;
        this.firmwareUpdates = firmwareUpdates;
        this.generated = generated;
        this.periodEnd = periodEnd;
        this.periodStart = periodStart;
    }

    /**
     * Constructor.
     */
    public ReportContent() {
        this(0, 0, new Date(), new Date(), new Date());
    }

    @Override
    public SdkModel clone() {
        return new ReportContent(activeDevices, firmwareUpdates, generated, periodEnd, periodStart);
    }

    @Override
    public boolean isValid() {
        return true;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (activeDevices ^ (activeDevices >>> 32));
        result = prime * result + (int) (firmwareUpdates ^ (firmwareUpdates >>> 32));
        result = prime * result + ((generated == null) ? 0 : generated.hashCode());
        result = prime * result + ((periodEnd == null) ? 0 : periodEnd.hashCode());
        result = prime * result + ((periodStart == null) ? 0 : periodStart.hashCode());
        return result;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ReportContent other = (ReportContent) obj;
        if (activeDevices != other.activeDevices) {
            return false;
        }
        if (firmwareUpdates != other.firmwareUpdates) {
            return false;
        }
        if (generated == null) {
            if (other.generated != null) {
                return false;
            }
        } else if (!generated.equals(other.generated)) {
            return false;
        }
        if (periodEnd == null) {
            if (other.periodEnd != null) {
                return false;
            }
        } else if (!periodEnd.equals(other.periodEnd)) {
            return false;
        }
        if (periodStart == null) {
            if (other.periodStart != null) {
                return false;
            }
        } else if (!periodStart.equals(other.periodStart)) {
            return false;
        }
        return true;
    }

    @Override
    public String getId() {
        return String.valueOf(hashCode());
    }

}
