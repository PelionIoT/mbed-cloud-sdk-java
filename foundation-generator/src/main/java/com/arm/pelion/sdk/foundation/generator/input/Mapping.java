package com.arm.pelion.sdk.foundation.generator.input;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Mapping {
    @JsonProperty(InputSchema.API_FIELDNAME_TAG)
    private String from;
    @JsonProperty(InputSchema.KEY_TAG)
    private String to;

    public Mapping() {
        super();
        from = null;
        to = null;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public String getProcessedFrom() {
        return Utils.getKey(from, true);
    }

    public String getProcessedTo() {
        return Utils.getKey(to, true);
    }

    public void setTo(String to) {
        this.to = to;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((from == null) ? 0 : from.hashCode());
        result = prime * result + ((to == null) ? 0 : to.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Mapping other = (Mapping) obj;
        if (from == null) {
            if (other.from != null)
                return false;
        } else if (!from.equals(other.from))
            return false;
        if (to == null) {
            if (other.to != null)
                return false;
        } else if (!to.equals(other.to))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Renaming [from=" + from + ", to=" + to + "]";
    }

}
