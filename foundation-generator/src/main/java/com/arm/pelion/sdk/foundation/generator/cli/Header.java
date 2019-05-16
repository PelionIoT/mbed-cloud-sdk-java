package com.arm.pelion.sdk.foundation.generator.cli;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.arm.pelion.sdk.foundation.generator.Configuration;
import com.github.dtmo.jfiglet.FigFontResources;
import com.github.dtmo.jfiglet.FigletRenderer;

public class Header {

    private static final String LINE_SEPARATOR = "\n";

    public final static String[] CLI_HEADER = getHeader().getCliHeaderText();

    private final String headerText;

    private Header() {
        headerText = generateText();
    }

    public String generateText() {
        FigletRenderer figletRenderer = null;
        StringBuilder builder = new StringBuilder();
        try {
            figletRenderer = new FigletRenderer(FigFontResources.loadFigFontResource(FigFontResources.BIG_FLF));
        } catch (@SuppressWarnings("unused") IOException exception) {
            // Nothing to do
        }
        if (figletRenderer == null) {
            builder.append(Configuration.TOOL_NAME);
        } else {
            builder.append(figletRenderer.renderText(Configuration.TOOL_NAME.replace(" ", "\n")));
        }
        return builder.toString();
    }

    public String[] getCliHeaderText() {
        final List<String> lines = new ArrayList<>(Arrays.asList(headerText.split(LINE_SEPARATOR))).stream()
                                                                                                   .map(l -> "@|green"
                                                                                                             + l + "|@")
                                                                                                   .collect(Collectors.toList());
        return lines.toArray(new String[0]);// String.join(System.lineSeparator(), lines);

    }

    public static Header getHeader() {
        return HeaderHolder.INSTANCE;
    }

    public String getHeaderText() {
        return headerText;
    }

    private static class HeaderHolder {
        public static final Header INSTANCE = new Header();
    }

}
