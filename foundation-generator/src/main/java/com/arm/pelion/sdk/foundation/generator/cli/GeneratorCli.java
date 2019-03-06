package com.arm.pelion.sdk.foundation.generator.cli;

import java.io.File;
import java.nio.file.FileSystems;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.arm.pelion.sdk.foundation.generator.util.FoundationGeneratorException;

import picocli.CommandLine.Command;
import picocli.CommandLine.Help;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

@Command(description = "Generates Pelion SDK foundation classes", name = GeneratorCli.COMMAND_TITLE,
         optionListHeading = "@|bold %nOptions|@:%n", versionProvider = GeneratorVersion.class,
         footer = { "", "@|cyan If you would like to contribute or report an issue|@",
                    "@|cyan go to github: https://github.com/ARMmbed/mbed-cloud-sdk-java|@", "" })
public class GeneratorCli implements Runnable {

    static final String COMMAND_TITLE = "foundation-generator";

    private static final String OUTPUT_PROJECT = null;
    @Option(names = { "-c", "--config" }, paramLabel = "<GENERATOR_CONFIG>",
            description = "generator configuration file")
    private File config;
    @Option(names = { "-i", "--input" }, paramLabel = "<INTERMEDIATE_CONFIG>", required = true,
            description = "input files defining Pelion APIs i.e. intermediate configuration")
    private File[] files;

    @Option(names = { "-h", "--help" }, usageHelp = true, description = "displays this help message")
    private boolean helpRequested = false;

    @Option(names = { "-f", "--forceUniTestGeneration" }, description = "forces unit test regeneration")
    private boolean forceUniTestRegeneration = false;

    @Option(names = { "-v", "--version" }, versionHelp = true, description = "displays tool version information")
    boolean versionInfoRequested;

    @Option(names = { "-o", "--output" }, paramLabel = "<PROJECT_NAME>",
            description = "name of the project where generated classes will be put (default: ${DEFAULT-VALUE})")
    private String output = OUTPUT_PROJECT;

    @Option(names = { "-m", "--output-models" }, paramLabel = "<PROJECT_NAME>",
            description = "name of the project where generated models will be put into (default: ${DEFAULT-VALUE})")
    private String outputModels = null;

    @Parameters(paramLabel = "<TOP>", description = "project top directory (default: ${DEFAULT-VALUE})", arity = "*")
    private File top = FileSystems.getDefault().getPath(".").toFile();

    public GeneratorCli() {
        // Nothing to do.
    }

    @Override
    public void run() {
        // Nothing to do.

    }

    public File getConfig() {
        return config;
    }

    public void setConfig(File config) {
        this.config = config;
    }

    public List<File> getFiles() throws FoundationGeneratorException {
        final List<File> inputs = Arrays.asList(files);
        if (inputs.stream().anyMatch(f -> !f.exists())) {
            throw new FoundationGeneratorException(new IllegalArgumentException("The following input files do not exist: "
                                                                                + String.join(", ",
                                                                                              inputs.stream()
                                                                                                    .filter(f -> !f.exists())
                                                                                                    .map(f -> f.toString())
                                                                                                    .collect(Collectors.toList()))));
        }
        return inputs;
    }

    public void setFiles(File[] files) {
        this.files = files;
    }

    public boolean isHelpRequested() {
        return helpRequested;
    }

    public void setHelpRequested(boolean helpRequested) {
        this.helpRequested = helpRequested;
    }

    public boolean isVersionInfoRequested() {
        return versionInfoRequested;
    }

    public void setVersionInfoRequested(boolean versionInfoRequested) {
        this.versionInfoRequested = versionInfoRequested;
    }

    public boolean isForceUniTestRegeneration() {
        return forceUniTestRegeneration;
    }

    public void setForceUniTestRegeneration(boolean forceUniTestRegeneration) {
        this.forceUniTestRegeneration = forceUniTestRegeneration;
    }

    public boolean forceRegenerateUnitTests() {
        return isForceUniTestRegeneration();
    }

    public String getOutput() {
        return output;
    }

    public void setOutput(String output) {
        this.output = output;
    }

    public String getOutputModels() {
        return outputModels;
    }

    public boolean hasOutputModels() {
        return getOutputModels() != null;
    }

    public void setOutputModels(String outputModels) {
        this.outputModels = outputModels;
    }

    public File getTop() {
        return top;
    }

    public void setTop(File top) {
        this.top = top;
    }

    public File getFoundationSourceOuputDirectory() throws FoundationGeneratorException {
        return generateClassDirectory(getTop(), getOutput(), true);
    }

    public File getFoundationModelSourceOuputDirectory() throws FoundationGeneratorException {
        return generateClassDirectory(getTop(), hasOutputModels() ? getOutputModels() : getOutput(), true);
    }

    public File getFoundationTestOuputDirectory() throws FoundationGeneratorException {
        return generateClassDirectory(getTop(), getOutput(), false);
    }

    public File getFoundationModelTestOuputDirectory() throws FoundationGeneratorException {
        return generateClassDirectory(getTop(), hasOutputModels() ? getOutputModels() : getOutput(), false);
    }

    private static File generateClassDirectory(File top, String projectName,
                                               boolean source) throws FoundationGeneratorException {
        if (top == null || !top.exists() || !top.isDirectory()) {
            throw new FoundationGeneratorException(new IllegalArgumentException("Project top directory is invalid: "
                                                                                + top));
        }

        final File project = projectName == null ? top : new File(top, projectName);
        if (!project.exists() || !project.isDirectory()) {
            throw new FoundationGeneratorException(new IllegalArgumentException("Project directory is invalid: "
                                                                                + project));
        }
        final File outputDirectory = new File(new File(new File(project, "src"), source ? "main" : "test"), "java");
        return outputDirectory;
    }

    public String generateHelp(int width) {
        final Help help = new Help(this);
        final StringBuilder sb = new StringBuilder().append(help.headerHeading())
                                                    .append(Help.join(help.ansi(), width, Header.CLI_HEADER,
                                                                      new StringBuilder())
                                                                .toString())
                                                    .append(help.synopsisHeading()) // e.g. Usage:
                                                    .append(help.synopsis(help.synopsisHeadingLength())) // e.g.
                                                                                                         // &lt;main
                                                                                                         // class&gt;
                                                                                                         // [OPTIONS]
                                                                                                         // &lt;command&gt;
                                                                                                         // [COMMAND-OPTIONS]
                                                                                                         // [ARGUMENTS]
                                                    .append(help.descriptionHeading()) // e.g. %nDescription:%n%n
                                                    .append(help.description()) // e.g. {"Converts foos to bars.", "Use
                                                                                // options to control conversion mode."}
                                                    .append(help.parameterListHeading()) // e.g. %nPositional
                                                                                         // parameters:%n%n
                                                    .append(help.parameterList()) // e.g. [FILE...] the files to convert
                                                    .append(help.optionListHeading()) // e.g. %nOptions:%n%n
                                                    .append(help.optionList()) // e.g. -h, --help displays this help and
                                                                               // exits
                                                    .append(help.commandListHeading()) // e.g. %nCommands:%n%n
                                                    .append(help.commandList()) // e.g. add adds the frup to the frooble
                                                    .append(help.footerHeading()).append(help.footer());
        return sb.toString();
    }

    @Override
    public String toString() {
        return "GeneratorCli [config=" + config + ", files=" + Arrays.toString(files) + ", helpRequested="
               + helpRequested + ", versionInfoRequested=" + versionInfoRequested + ", output=" + output
               + ", outputModels=" + outputModels + ", top=" + top + "]";
    }

}
