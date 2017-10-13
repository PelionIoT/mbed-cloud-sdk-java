#!/usr/bin/python
import sdk_common


# Block in charge of fetching SDK test runner
class SDKTestRunnerFetcher(sdk_common.BuildStep):
    def __init__(self, logger=None):
        super(SDKTestRunnerFetcher, self).__init__('SDK test runner fetch', logger)

    def execute(self):
        self.print_title()
        try:
            self.log_info("Logging to docker images repository")
            # self.check_shell_command_output("$(aws ecr get-login --no-include-email)")
            command = "aws ecr get-login --no-include-email"
            result = self.execute_command_output(command)
            if not result or not ("Login Succeeded" in result):
                raise Exception('Login Error', result)
            self.log_info("Fetching SDK test runner")
            arguments = ["docker", "pull", self.common_config.get_config().get_testrunner_docker_image()]
            return_code = self.call_command(arguments, None, True)
            if return_code != 0:
                raise Exception('Error code', return_code)
        except:
            self.log_error('Failed to fetch SDK test runner')
            return False
        self.log_info("Done.")
        return True
