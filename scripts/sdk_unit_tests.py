#!/usr/bin/python
import sdk_common


# Block in charge of running unit tests
class SDKUnitTests(sdk_common.BuildStepUsingGradle):
    def __init__(self, logger=None):
        super(SDKUnitTests, self).__init__('SDK Unit tests', logger)

    def execute(self):
        self.print_title()
        try:
            self.log_info("Executing unit tests")
            self.execute_gradle_task_with_retries(3, 'test', ['-x', 'check'])
            self.log_info("Generating single test report")
            self.execute_gradle_task('unitTestReport', ['-x', 'test'])
            self.log_info("Determining code coverage")
            self.execute_gradle_task('jacocoTestReport')
        except:
            self.log_error('Failed to run unit tests')
            return False
        self.log_info("Done.")
        return True
