package com.arm.mbed.cloud.sdk.common;

import java.util.Locale;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.arm.mbed.cloud.sdk.annotations.DefaultValue;
import com.arm.mbed.cloud.sdk.annotations.Internal;
import com.arm.mbed.cloud.sdk.annotations.Preamble;

@Preamble(description = "Time period")
public class TimePeriod implements Cloneable {
    @Internal
    private enum PeriodTimeUnit {
        YEARS, WEEKS, DAYS, HOURS, MINUTES, SECONDS, NANOSECONDS;
    }

    private static final Pattern STRING_PATTERN = Pattern.compile("\\s*(\\d+)\\s*([A-Za-z])\\s*");
    private static final int DEFAULT_DURATION = 1;
    private static final PeriodTimeUnit DEFAULT_UNIT = PeriodTimeUnit.DAYS;
    /**
     * The time period unit.
     */
    @DefaultValue(value = "days")
    private TimeUnit unit;
    /**
     * The unit duration.
     */
    @DefaultValue(value = "1")
    private long duration;

    /**
     * Constructor.
     *
     * @param unit
     *            time unit to apply e.g. seconds, days.
     * @param duration
     *            duration in the unit set above.
     */
    public TimePeriod(TimeUnit unit, long duration) {
        super();
        this.unit = unit;
        this.duration = duration;
    }

    /**
     * Defines a timeout in seconds.
     *
     * @param duration
     *            in seconds.
     */
    public TimePeriod(long duration) {
        this();
        setTimeout(duration);
    }

    /**
     * Constructor.
     * <p>
     * set to the default time period: 1 day.
     */
    public TimePeriod() {
        super();
        setTimePeriod(DEFAULT_DURATION, DEFAULT_UNIT);
    }

    /**
     * Sets time period from a string.
     *
     * @param value
     *            string representing the time period @see {@link #fromString(String)} for more information.
     *
     */
    public TimePeriod(String value) {
        fromString(value);
    }

    /**
     * Gets the time unit in use.
     *
     * @see TimeUnit
     * @return the unit.
     */
    public TimeUnit getUnit() {
        return unit;
    }

    /**
     * Sets the time unit.
     *
     * @see TimeUnit
     * @param unit
     *            the unit to set.
     */
    public void setUnit(TimeUnit unit) {
        this.unit = unit;
    }

    /**
     * Gets the duration.
     *
     * @return the duration
     */
    public long getDuration() {
        return duration;
    }

    /**
     * Sets the duration.
     *
     * @param duration
     *            the duration to set.
     */
    public void setDuration(long duration) {
        this.duration = duration;
    }

    /**
     * Sets as a timeout in second.
     *
     * @param timeout
     *            timeout in second
     */
    public void setTimeout(long timeout) {
        setUnit(TimeUnit.SECONDS);
        setDuration(timeout);
    }

    /**
     * Gets time period string representation.
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        if (unit == null || duration == 0) {
            setTimePeriod(DEFAULT_DURATION, DEFAULT_UNIT);
        }
        final StringBuilder builder = new StringBuilder();
        switch (unit) {
            case DAYS:
                toStringAsDays(builder);
                break;
            case HOURS:
                toStringAsHours(builder);
                break;
            case MINUTES:
                toStringAsMinutes(builder);
                break;
            case NANOSECONDS:
                toStringAsNanoSeconds(builder);
                break;
            case SECONDS:
                toStringAsSeconds(builder);
                break;
            default:
                break;
        }

        return builder.toString();
    }

    private StringBuilder toStringAsSeconds(StringBuilder builder) {
        if (duration >= 60 && duration % 60 == 0) {
            builder.append(duration / 60).append('m');
        } else {
            builder.append(duration).append('s');
        }
        return builder;
    }

    private StringBuilder toStringAsNanoSeconds(StringBuilder builder) {
        if (duration >= 1000000000 && duration % 1000000000 == 0) {
            builder.append(duration / 1000000000).append('s');
        } else {
            builder.append(duration).append('n');
        }
        return builder;
    }

    private StringBuilder toStringAsMinutes(StringBuilder builder) {
        if (duration >= 60 && duration % 60 == 0) {
            builder.append(duration / 60).append('h');
        } else {
            builder.append(duration).append('m');
        }
        return builder;
    }

    private StringBuilder toStringAsHours(StringBuilder builder) {
        if (duration >= 24 && duration % 24 == 0) {
            builder.append(duration / 24).append('d');
        } else {
            builder.append(duration).append('h');
        }
        return builder;
    }

    private StringBuilder toStringAsDays(StringBuilder builder) {
        if (duration >= 366 && duration % 366 == 0) { // This case should not happen
            builder.append(duration / 366).append('y');
        } else if (duration >= 7 && duration % 7 == 0) {
            builder.append(duration / 7).append('w');
        } else {
            builder.append(duration).append('d');
        }
        return builder;
    }

    /**
     * Sets time period from a string.
     *
     * @param value
     *            string value specifying the period in nanoseconds, seconds, minutes, hours, days or weeks. Sample
     *            values: 10000n, 50s, 5m, 2h, 3d, 4w. The maximum period cannot exceed one year (365 days). The allowed
     *            ranges are 5m-525600m/1h-8760h/1d-365d/1w-53w.
     */
    public void fromString(String value) {
        setTimePeriod(DEFAULT_DURATION, DEFAULT_UNIT);
        if (value == null || value.isEmpty()) {
            return;
        }
        final Matcher matcher = STRING_PATTERN.matcher(value);
        if (matcher.matches()) {
            setTimePeriod(Long.parseLong(matcher.group(1)), getUnitFromChar(matcher.group(2)));
        }
    }

    private void setTimePeriod(long duration, PeriodTimeUnit unit) {
        switch (unit) {
            case DAYS:
                setUnit(TimeUnit.DAYS);
                setDuration(duration);
                break;
            case HOURS:
                setUnit(TimeUnit.HOURS);
                setDuration(duration);
                break;
            case MINUTES:
                setUnit(TimeUnit.MINUTES);
                setDuration(duration);
                break;
            case NANOSECONDS:
                setUnit(TimeUnit.NANOSECONDS);
                setDuration(duration);
                break;
            case SECONDS:
                setUnit(TimeUnit.SECONDS);
                setDuration(duration);
                break;
            case WEEKS:
                setUnit(TimeUnit.DAYS);
                setDuration(7L * duration);
                break;
            case YEARS:// This case should not happen.
                setUnit(TimeUnit.DAYS);
                setDuration(366L * duration);
                break;
            default:
                break;
        }
    }

    private static PeriodTimeUnit getUnitFromChar(String string) {
        if (string == null || string.isEmpty()) {
            return DEFAULT_UNIT;
        }
        final String trimmedString = string.toLowerCase(Locale.getDefault()).trim();
        if (trimmedString.length() != 1) {
            return DEFAULT_UNIT;
        }
        switch (trimmedString) {
            case "y":// This case should not happen
                return PeriodTimeUnit.YEARS;
            case "w":
                return PeriodTimeUnit.WEEKS;
            case "d":
                return PeriodTimeUnit.DAYS;
            case "h":
                return PeriodTimeUnit.HOURS;
            case "m":
                return PeriodTimeUnit.MINUTES;
            case "s":
                return PeriodTimeUnit.SECONDS;
            case "n":
                return PeriodTimeUnit.NANOSECONDS;
            default:
                break;
        }
        return DEFAULT_UNIT;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#clone()
     */
    @Override
    public TimePeriod clone() {
        return new TimePeriod(unit, duration);
    }

}
