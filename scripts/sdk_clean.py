#!/usr/bin/python
import sdk_common
import os
from functools import reduce


# Block in charge of cleaning SDK build
class SDKCleaner(sdk_common.BuildStepUsingGradle):
    def __init__(self, logger=None):
        super(SDKCleaner, self).__init__('SDK Cleaning', logger)

    def execute(self):
        self.print_title()
        try:
            directory = self.top_directory
            self.log_info("Cleaning SDK")
            self.execute_gradle_task('clean')
            self.log_info("Cleaning distribution folder")
            self.clean_directory(reduce(lambda x, y: os.path.join(x, y), [self.top_directory, 'src', 'main', 'dist']),
                                 True)
        except:
            self.log_error('Failed to clean SDK')
            return False
        self.log_info("Done.")
        return True
