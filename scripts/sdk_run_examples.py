#!/usr/bin/python
import sdk_common


# Block in charge of running SDK examples
class SDKExamplesRunner(sdk_common.BuildStepUsingGradle):
    def __init__(self, logger=None):
        super(SDKExamplesRunner, self).__init__('SDK examples runner', logger)
        self.gradle_directory = self.common_config.get_config().get_sdk_example_directory()
        self.reset()

    def execute(self):
        self.print_title()
        try:
            self.log_info("Running examples")
            self.execute_gradle_task("test")
            self.log_info("Generating examples documentation")
            self.execute_gradle_task("javadoc")
            # TODO copy the generated doc to the right place
        except:
            self.log_error("An exception was raised while running the examples")
            return False
        self.log_info("Done.")
        return True
