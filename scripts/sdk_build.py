#!/usr/bin/python
import sdk_common
import os
import shutil
from functools import reduce


# Block in charge of building SDK
class SDKBuilder(sdk_common.BuildStepUsingGradle):
    def __init__(self, logger=None):
        super(SDKBuilder, self).__init__('SDK build', logger)
        self.distribution_directory = reduce(lambda x, y: os.path.join(x, y),
                                             [self.build_directory, 'distributions'])

    def execute(self):
        self.print_title()
        try:
            self.log_info("Building sdk")
            self.execute_gradle_task('build', ['-x', 'check', '-x', 'test'])
            self.log_info("Building the fat jar")
            self.execute_gradle_task('shadowJar')
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
        zip_file_destination = os.path.join(self.distribution_directory, 'sdk.zip')
        if os.path.exists(zip_file_destination):
            self.remove_path(zip_file_destination, True)
        self.zip_directory_content(self.distribution_directory, 'sdk')
        zip_file = os.path.join(os.getcwd(), 'sdk.zip')
        shutil.move(zip_file, self.distribution_directory)
