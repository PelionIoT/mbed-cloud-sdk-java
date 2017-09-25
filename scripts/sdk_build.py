#!/usr/bin/python
import sdk_common
import os
import shutil
from functools import reduce


# Block in charge of building SDK and running unittests as well as running quality checks
class SDKBuilder(sdk_common.BuildStepUsingGradle):
    def __init__(self, logger=None):
        super(SDKBuilder, self).__init__('SDK build', logger)
        self.distribution_directory = reduce(lambda x, y: os.path.join(x, y),
                                             [self.build_directory, 'distributions'])

    def execute(self):
        self.print_title()
        try:
            self.log_info("Building sdk")
            self.execute_gradle_task('build')
            self.execute_gradle_task('shadowJar')
            self.log_info("Determining code coverage")
            self.execute_gradle_task('jacocoTestReport')
            self.log_info("Generating Javadoc")
            self.execute_gradle_task('javadoc')
            self.log_info("Packaging distribution")
            self.zip_distribution_artififacts()
        except:
            self.log_error('Failed to build SDK')
            return False
        self.log_info("Done.")
        return True

    def zip_distribution_artififacts(self):
        self.zip_directory_content(self.distribution_directory, 'sdk')
        zip_file = os.path.join(os.getcwd(), 'sdk.zip')
        shutil.move(zip_file, self.distribution_directory)
