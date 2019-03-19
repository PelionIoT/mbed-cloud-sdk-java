package com.arm.pelion.sdk.foundation.generator.input;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DeprecationNotice {

    @JsonProperty(InputSchema.SINCE_DEPRECATION_TAG)
    private String since;
    @JsonProperty(InputSchema.WHEN_DEPRECATION_TAG)
    private String when;
    @JsonProperty(InputSchema.DESCRIPTION_DEPRECATION_TAG)
    private String description;
    @JsonProperty(InputSchema.LINKS_DEPRECATION_TAG)
    private List<String> links;

    public DeprecationNotice() {
        since = null;
        when = null;
        description = null;
        links = null;
    }

    public String getSince() {
        return since;
    }

    public void setSince(String since) {
        this.since = since;
    }

    public String getWhen() {
        return when;
    }

    public void setWhen(String when) {
        this.when = when;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getLinks() {
        return links;
    }

    public void setLinks(List<String> links) {
        this.links = links;
    }

    public boolean hasLinks() {
        return links != null && !links.isEmpty();
    }

}
