#!/usr/bin/python
import sdk_common


# Block in charge of running quality checks
class SDKBuilder(sdk_common.BuildStepUsingGradle):
    def __init__(self, logger=None):
        super(SDKBuilder, self).__init__('SDK Static analysis', logger)

    def execute(self):
        self.print_title()
        try:
            self.log_info("Prettifying the SDK code")
            self.execute_gradle_task('spotlessApply')
            self.log_info("Performing static analysis on the SDK code")
            self.execute_gradle_task('check', ['-x', 'test'])
        except:
            self.log_error('Failed to analyse statically SDK\'s code')
            return False
        self.log_info("Done.")
        return True
