#!/usr/bin/python
import sdk_common
import sdk_fetch_coverage_tools
import os


# Block in charge of reporting code coverage results
class SDKCoverageReporter(sdk_common.BuildStepUsingGradle):
    def __init__(self, logger=None):
        super(SDKCoverageReporter, self).__init__('SDK Coverage tools fetch', logger)
        self.is_code_coverage = self.common_config.get_config().should_perform_code_coverage()
        self.coverage_tools = sdk_fetch_coverage_tools.SDKCoverageToolsFetcher(self.logger)
        self.artifacts_parser = self.common_config.get_config().get_new_artifact_log_parser(self)
        self.jacoco_cli_names = ['jacococli.jar', 'org.jacoco.cli']
        self.report_name = "\"" + 'Java SDK Code coverage' + "\""

    def _generate_argument_from_string(self, key, argument_option):
        files_string = self.artifacts_parser.get_property(key)
        if not files_string:
            return None
        files = files_string.split(os.pathsep)
        file_argument = []
        for file in files:
            if file:
                file_path = self.clean_path(file, False)
                if os.path.exists(file_path):
                    file_argument.append(argument_option)
                    file_argument.append(self.clean_path(file_path, True))
        return file_argument

    def generate_class_files_command_arguments(self):
        return self._generate_argument_from_string('SDK_PROJECT_CLASS_FILES', '--classfiles')

    def generate_foundation_class_files_command_arguments(self):
        return self._generate_argument_from_string('SDK_PROJECT_FOUNDATION_CLASS_FILES', '--classfiles')

    def generate_source_files_command_arguments(self):
        return self._generate_argument_from_string('SDK_PROJECT_SOURCE_FILES', '--sourcefiles')

    def generate_execfiles_command_arguments(self, coverage_files):
        files_list = []
        for file in coverage_files:
            files_list.append(self.clean_path(file, True))
        return files_list

    def generate_report_command(self, coverage_files, class_files, code_coverage_result_destination):
        code_coverage_tools = self.clean_path(self.artifacts_parser.get_property('SDK_COVERAGE_TOOLS_DIR'),
                                              False)
        if not code_coverage_tools or not code_coverage_result_destination:
            self.log_warning(
                "Code coverage tools could not be found. No code coverage reporting will be done.")
            return None
        cli_jar = None
        for file in os.listdir(code_coverage_tools):
            for potential_name in self.jacoco_cli_names:
                if potential_name in file:
                    cli_jar = file
        if not cli_jar:
            self.log_error_without_getting_cause(
                "Jacoco CLI could not be found. No code coverage reporting will be done.")
            return None
        cli_path = self.clean_path(code_coverage_tools + cli_jar, True)
        arguments = ['java', '-jar', cli_path, 'report']
        arguments.extend(
            self.generate_execfiles_command_arguments(coverage_files))
        if not os.path.exists(code_coverage_result_destination):
            os.makedirs(code_coverage_result_destination)
        csv_file = os.path.join(code_coverage_result_destination, 'coverage.csv')
        xml_file = os.path.join(code_coverage_result_destination, 'coverage.xml')
        arguments.extend(
            ['--name', self.report_name, '--html', self.clean_path(code_coverage_result_destination, True), '--csv',
             self.clean_path(csv_file, True), '--xml', self.clean_path(xml_file, True)])
        src_file_args = self.generate_source_files_command_arguments()
        if class_files:
            arguments.extend(class_files)
        if src_file_args:
            arguments.extend(src_file_args)
        return arguments

    def execute(self):
        self.print_title()
        try:
            if self.is_code_coverage:
                self.log_info("Gathering all code coverage information")
                coverage_files = sdk_common.ProjectBrowser(self,
                                                           self.common_config.get_config().get_sdk_top_directory()).find_all_files(
                    '.exec')
                if not coverage_files or len(coverage_files) == 0:
                    self.log_warning(
                        "No code coverage files were found in the project. Please run unit tests or integration tests with instrumentation first.")
                    return True
                else:
                    self.log_info("The following instrumentation files were found: " + str(coverage_files))
                self.execute_gradle_task("reportCoverage")
                success = self.coverage_tools.execute()
                if not success:
                    raise Exception("Could not fetch coverage tools")
                self.log_info("Generating code coverage report with Jacoco CLI")
                self.artifacts_parser.load()

                # Generate coverage results for all classes
                class_files = self.generate_class_files_command_arguments()
                result_destination = self.clean_path(self.artifacts_parser.get_property('SDK_PROJECT_COVERAGE_REPORT_DIR'), False)
                arguments = self.generate_report_command(coverage_files, class_files, result_destination)
                if not arguments:
                    raise Exception('Incorrect command', arguments)

                return_code = self.call_command(arguments, None, True)
         
                if return_code != 0:
                    raise Exception('Error code', return_code)

                # Generate coverage results for just the foundation classes
                class_files = self.generate_foundation_class_files_command_arguments()
                result_destination = self.clean_path(self.artifacts_parser.get_property('SDK_PROJECT_COVERAGE_FOUNDATION_REPORT_DIR'), False)
                arguments = self.generate_report_command(coverage_files, class_files, result_destination)
                if not arguments:
                    raise Exception('Incorrect command', arguments)

                return_code = self.call_command(arguments, None, True)
         
                if return_code != 0:
                    raise Exception('Error code', return_code)
        except:
            self.log_error('Failed to generate code coverage report')
            return False 
        self.log_info("Done.")
        return True
