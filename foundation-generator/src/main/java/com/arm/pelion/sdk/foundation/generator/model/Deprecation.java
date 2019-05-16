package com.arm.pelion.sdk.foundation.generator.model;

import java.net.URL;
import java.util.Date;
import java.util.List;

import com.arm.pelion.sdk.foundation.generator.util.Utils;

public class Deprecation {

    private final boolean isField;
    private final Date since;
    private final Date when;
    private final String description;
    private final List<URL> links;

    public Deprecation(boolean isField, Date since, Date when, String description, List<URL> links) {
        super();
        this.isField = isField;
        this.since = since == null ? new Date() : since;
        this.when = when == null ? new Date() : when;
        this.description = description;
        this.links = links;
    }

    public String getNotice() {
        final StringBuilder builder = new StringBuilder();
        builder.append("@deprecated This ").append(isField ? "field" : "method").append(" has been deprecated since ")
               .append(since).append(" and will be removed by ").append(when).append(".")
               .append(System.lineSeparator());
        if (description != null && !description.isEmpty()) {
            builder.append(description).append(System.lineSeparator());
        }
        if (links != null && !links.isEmpty()) {
            builder.append(Utils.generateNewDocumentationLine()).append("For more information:")
                   .append(System.lineSeparator()).append("<ul>");
            for (URL link : links) {
                builder.append("<li>").append("<a href=\"").append(link.toString()).append("\">")
                       .append(link.toString()).append("</a>").append("</li>");
            }
            builder.append("</ul>");
        }
        return builder.toString();
    }

}
