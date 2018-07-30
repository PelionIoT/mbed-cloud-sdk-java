#!/usr/bin/python
import sdk_common


# Block in charge of running integration tests (using Docker compose)
class SDKTestServerImageBuilder(sdk_common.BuildStepUsingGradle):
    def __init__(self, logger=None):
        super(SDKTestServerImageBuilder, self).__init__('SDK Test server Docker image builder', logger)
        self.test_server_image = self.common_config.get_config().get_testserver_docker_image()

    def execute(self):
        self.print_title()
        try:
            self.log_info("Building test server docker image")
            arguments = ["docker", "build", "-t", self.test_server_image,
                         "."]
            return_code_int = self.call_command(arguments, None, True, True)
            if return_code_int != 0:
                raise Exception('Building test server image has failed', return_code_int)
        except:
            self.log_error('Failed to successfully build test server image has failed')
            return False
        self.log_info("Done.")
        return True
