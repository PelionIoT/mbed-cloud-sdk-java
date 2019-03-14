#!/usr/bin/python
import sdk_common
import os


# Block in charge of fetching SDK test runner (Docker container)
class SDKTestRunnerFetcher(sdk_common.BuildStep):
    def __init__(self, logger=None):
        super(SDKTestRunnerFetcher, self).__init__('SDK test runner fetch', logger)
        self.image_to_fetch = str(self.common_config.get_config().get_testrunner_docker_image())
        self.fallback_image_to_fetch = str(self.common_config.get_config().get_default_testrunner_docker_image())

    def pull_image(self, image, image_tag):

        arguments = ["docker", "pull", image]
        return_code = self.call_command(arguments, None, True)
        if return_code == 0:
            arguments = ["docker", "tag", image, image_tag]
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
            self.log_info("Fetching SDK test runner:")
            self.log_info("[%s]" % self.image_to_fetch)
            return_code = self.pull_image(self.image_to_fetch, self.image_to_fetch)
            if return_code != 0:
                self.log_warning("Failed fetching testrunner image [%s]" % self.image_to_fetch)
                self.log_info("Fetching default image instead [%s]" % self.fallback_image_to_fetch)
                return_code = self.pull_image(self.fallback_image_to_fetch, self.image_to_fetch)
                if return_code != 0:
                    raise Exception('Error code', return_code)
        except:
            self.log_error('Failed to fetch SDK test runner')
            return False
        self.log_info("Done.")
        return True
