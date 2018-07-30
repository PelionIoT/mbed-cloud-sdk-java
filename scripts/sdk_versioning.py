#!/usr/bin/python
import os
import sdk_common
from auto_version.auto_version_tool import main


# Block in charge of versioning the SDK
class SDKVersioning(sdk_common.BuildStep):
    def __init__(self, logger=None):
        super(SDKVersioning, self).__init__('SDK Versioning', logger)
        self.testrunner_image = self.common_config.get_config().get_testrunner_docker_image()
        self.version_config = os.path.join(self.common_config.get_config().get_sdk_top_directory(), 'version.toml')
        self.is_tagged_commit = self.common_config.get_config().is_commit_tagged()
        self.should_bump = False
        self.set_value = None

    def execute(self):
        self.print_title()
        try:
            if not self.testrunner_image:
                raise Exception('Test runner image name is unset')
            self.log_info("Getting test runner version [%s]" % self.testrunner_image)
            test_runner_version = self.check_shell_command_output(
                "docker run %s python -m trunner --version" % self.testrunner_image)
            self.log_info('Test runner version is: %s' % test_runner_version)
            self.log_info("Versioning the SDK")
            if self.is_tagged_commit:
                self.log_info("This is a release build")
            else:
                main(SDKTestrunnerVersion=test_runner_version, config_path=self.version_config,
                     file_triggers=self.should_bump, release=self.should_bump, set_to=self.set_value)
        except:
            self.log_error('Failed to version the SDK')
            return False
        self.log_info("Done.")
        return True
