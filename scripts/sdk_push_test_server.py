#!/usr/bin/python
import sdk_common


# Block in charge of fetching SDK test runner (Docker container)
class SDKTestServerPusher(sdk_common.BuildStepUsingAWS):
    def __init__(self, logger=None):
        super(SDKTestServerPusher, self).__init__('SDK test server push', logger)
        self.test_server_image = self.common_config.get_config().get_testserver_docker_image()
        self.test_server_images = self.common_config.get_config().get_testserver_docker_images()

    def push_image(self, image, image_tag):
        arguments = ["docker", "tag", image, image_tag]
        return_code = self.call_command(arguments, None, True)
        if return_code == 0:
            arguments = ["docker", "push", image_tag]
            return_code = self.call_command(arguments, None, True)
        return return_code

    def execute(self):
        self.print_title()
        try:
            self.log_info("Logging to docker images repository")
            self.login()
            self.log_info("Pushing SDK test server:")
            for image_to_push in self.test_server_images:
                self.log_info("- [%s]" % image_to_push)
                return_code = self.push_image(self.test_server_image, image_to_push)
                if return_code != 0:
                    self.log_warning("Failed pushing test server image [%s]" % image_to_push)
        except:
            self.log_error('Failed to push SDK test server')
            return False
        self.log_info("Done.")
        return True
