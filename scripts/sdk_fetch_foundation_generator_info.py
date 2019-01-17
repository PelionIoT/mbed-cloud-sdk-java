#!/usr/bin/python
import sdk_common


# Block in charge of getting information about the generator
class SDKFoundationGeneratorInfo(sdk_common.BuildStepUsingGradle):
    def __init__(self, logger=None):
        super(SDKFoundationGeneratorInfo, self).__init__('Foundation generator info', logger)
        self.gradle_directory = self.common_config.get_config().get_sdk_foundation_generation_directory()
        self.reset()

    def execute(self):
        self.print_title()
        try:
            self.log_info("Fetching key information about the foundation SDK generator")
            self.execute_gradle_task('info')
        except:
            self.log_error('Failed to get foundation generator info')
            return False
        self.log_info("Done.")
        return True
