#!/usr/bin/python
import sdk_common


# Block in charge of building SDK Test server
class SDKTestServerBuilder(sdk_common.BuildStepUsingGradle):
    def __init__(self, logger=None):
        super(SDKTestServerBuilder, self).__init__('SDK test server build', logger)

    def execute(self):
        self.print_title()
        try:
            self.log_info("Building SDK test server")
            self.execute_gradle_task('shadowTestJar')
        except:
            self.log_error('Failed to build SDK test server')
            return False
        self.log_info("Done.")
        return True
