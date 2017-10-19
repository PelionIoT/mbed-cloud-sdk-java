#!/usr/bin/python
import sdk_common
import sdk_fetch_coverage_tools
import os


# Block in charge of Launching SDK Test server
class SDKTestServerLauncher(sdk_common.BuildStepUsingGradle):
    def __init__(self, logger=None):
        super(SDKTestServerLauncher, self).__init__('SDK test server launch', logger)
        # self.logger.is_debug_enabled = True
        self.artifacts_parser = sdk_common.PropertyFileParser(self,
                                                              self.common_config.get_config().get_sdk_top_directory(),
                                                              "artifacts.properties", "=", "#")
        self.is_code_coverage = self.common_config.get_config().should_perform_code_coverage()
        self.coverage_tools = sdk_fetch_coverage_tools.SDKCoverageToolsFetcher(self.logger)

    def generate_launch_command_with_instrumentation(self, test_jar_argument):
        code_coverage_tools = self.clean_path(self.artifacts_parser.get_property('SDK_COVERAGE_TOOLS_DIR'),
                                              False)
        code_coverage_result_destination = self.clean_path(
            self.artifacts_parser.get_property('SDK_COVERAGE_RESULTS_DIR'), False)
        if not code_coverage_tools or not code_coverage_result_destination:
            self.log_warning(
                "Code coverage tools could not be found. No code coverage instrumentation will be performed")
            return None
        tools_dir = code_coverage_tools.replace('\\', '/')
        agent_jar = None
        for file in os.listdir(tools_dir):
            if 'agent' in file:
                agent_jar = file
        agent_path = code_coverage_tools + agent_jar
        jacoco_agent_command = '-javaagent:' + "\"" + str(agent_path) + "\"" + '=output=file'
        if code_coverage_result_destination:
            jacoco_agent_command += ',destfile=' + "\"" + str(
                code_coverage_result_destination) + 'jacoco-int.exec' + "\""
        arguments = ['java', jacoco_agent_command, '-jar', test_jar_argument]
        return arguments

    def execute(self):
        self.print_title()
        try:
            self.log_info("Launching SDK test server")
            success = self.coverage_tools.execute()
            if not success:
                raise Exception("Could not fetch coverage tools")
            self.artifacts_parser.load()
            test_jar_argument = self.clean_path(self.artifacts_parser.get_property('TEST_FULL_JAR'))
            arguments = ['java', '-jar', test_jar_argument]
            if self.is_code_coverage:
                arguments_with_agent = self.generate_launch_command_with_instrumentation(test_jar_argument)
                if arguments_with_agent:
                    arguments = arguments_with_agent
            return_code = self.call_command(arguments, None, True)
            if return_code != 0:
                raise Exception('Error code', return_code)
        except:
            self.log_error('Failed to launch SDK test server')
            return False
        self.log_info("Done.")
        return True
