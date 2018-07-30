#!/usr/bin/python
import sdk_common


# Block in charge of checking the SDK's dependencies
class SDKDependenciesChecker(sdk_common.BuildStepUsingGradle):
    def __init__(self, logger=None):
        super(SDKDependenciesChecker, self).__init__('SDK dependencies check', logger)

    def execute(self):
        self.print_title()
        try:
            self.log_info("Checking dependencies")
            self.execute_gradle_task_with_retries(2, 'dependencies')
        except:
            self.log_error('Failed to check SDK\'s dependencies')
            return False
        self.log_info("Done.")
        return True
