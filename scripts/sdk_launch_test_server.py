#!/usr/bin/python
import sdk_common
import sdk_fetch_coverage_tools
import os


# Block in charge of Launching SDK Test server
class SDKTestServerLauncher(sdk_common.BuildStepUsingGradle):
    def __init__(self, logger=None):
        super(SDKTestServerLauncher, self).__init__('SDK test server launch', logger)
        # self.logger.is_debug_enabled = True
        self.artifacts_parser = self.common_config.get_config().get_new_artifact_log_parser(self)

        self.is_code_coverage = self.common_config.get_config().should_perform_code_coverage()
        self.coverage_tools = sdk_fetch_coverage_tools.SDKCoverageToolsFetcher(self.logger)
        self.result_dir = None
        self.exec_file_name = 'jacoco-int.exec'
        self.register_callback_on_exit(self._perform_action_on_exit)

    def _perform_action_on_exit(self):
        if self.result_dir and os.path.exists(self.result_dir):
            try:
                for file in os.listdir(self.result_dir):
                    if self.exec_file_name in file:
                        exec_file_path = os.path.join(self.result_dir, file)
                        self.log_info("Code coverage exec file was generated [" + str(exec_file_path) + "]")
                        exec_size = os.path.getsize(exec_file_path)
                        if exec_size == 0:
                            self.log_warning("It is however currently empty! Something may have gone wrong.")
                        else:
                            self.log_info("It has the following size: " + str(exec_size))
            except Exception as e:
                self.log_error_without_getting_cause("An error occurred: " + str(e))
                pass
        else:
            if self.is_code_coverage:
                self.log_warning("No directory for code coverage results was specified [" + str(self.result_dir) + "]")

    def determine_java_executable(self):
        # if os.name == 'nt':
        #     return 'java'
        # java_loc = self.get_command_output(['which', 'java'])
        # if java_loc:
        #     return self.clean_path(java_loc, False)
        # else:
        return 'java'

    def generate_launch_command_with_instrumentation(self, test_jar_argument):
        code_coverage_tools = self.clean_path(self.artifacts_parser.get_property('SDK_COVERAGE_TOOLS_DIR'),
                                              False, False)
        code_coverage_result_destination = self.clean_path(
            self.artifacts_parser.get_property('SDK_COVERAGE_RESULTS_DIR'), False, False)
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
        jacoco_agent_command = '-javaagent:' + self.clean_path(agent_path, False, False) + '=output=file'
        if code_coverage_result_destination:
            self.result_dir = self.clean_path(code_coverage_result_destination, False, True)
            jacoco_agent_command += ',destfile=' + self.clean_path(str(
                code_coverage_result_destination) + self.exec_file_name, False, False)
        arguments = [self.determine_java_executable(), jacoco_agent_command, '-jar', test_jar_argument]
        return arguments

    def execute(self):
        self.print_title()
        try:
            self.log_info("Launching SDK test server")
            success = self.coverage_tools.execute()
            if not success:
                raise Exception("Could not fetch coverage tools")
            self.artifacts_parser.load()
            test_jar_argument = self.clean_path(self.artifacts_parser.get_property('TEST_FULL_JAR'), False, True)
            arguments = [self.determine_java_executable(), '-jar', test_jar_argument]
            if self.is_code_coverage:
                arguments_with_agent = self.generate_launch_command_with_instrumentation(test_jar_argument)
                if arguments_with_agent:
                    arguments = arguments_with_agent
            return_code = self.call_command(arguments, None, True, False)
            if not (return_code in [0, 130, 143]):
                raise Exception('Error code', return_code)
        except:
            self.log_error('Failed to launch SDK test server')
            return False
        self.log_info("Done.")
        return True
