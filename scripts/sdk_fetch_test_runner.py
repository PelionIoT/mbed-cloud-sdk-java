#!/usr/bin/python
import sdk_common
import os


# Block in charge of fetching SDK test runner (Docker container)
class SDKTestRunnerFetcher(sdk_common.BuildStep):
    def __init__(self, logger=None):
        super(SDKTestRunnerFetcher, self).__init__('SDK test runner fetch', logger)

    def do_docker(self, branch):
        image = os.getenv("TESTRUNNER_DOCKER_IMAGE")

        full_image_name = image + ":" + branch
        fallback_image_name = image + ":latest"

        arguments = ["docker", "pull", full_image_name]
        return_code = self.call_command(arguments, None, True)

        if return_code == 0:
            arguments = ["docker", "tag", full_image_name, fallback_image_name]
            self.call_command(arguments, None, True)

        return return_code

    def execute(self):
        self.print_title()
        try:
            self.log_info("Logging to docker images repository")
            command = "aws ecr get-login"
            result = self.execute_command_output(command)
            if not result or not ("Login Succeeded" in result):
                command = "aws ecr get-login --no-include-email"
                result = self.execute_command_output(command)
            if not result or not ("Login Succeeded" in result):
                raise Exception('Login Error', result)
            self.log_info("Fetching SDK test runner")

            branch = os.getenv("CIRCLE_BRANCH")
            return_code = self.do_docker(branch)

            if return_code != 0:
                return_code = self.do_docker("master")
                if return_code != 0:
                    raise Exception('Error code', return_code)
        except:
            self.log_error('Failed to fetch SDK test runner')
            return False
        self.log_info("Done.")
        return True
