#!/usr/bin/python
import sdk_common
import shutil
import os


# Block in charge of gathering all code coverage files
class SDKCoverageFileGatherer(sdk_common.BuildStepUsingGradle):
    def __init__(self, logger=None):
        super(SDKCoverageFileGatherer, self).__init__('SDK Coverage files fetch', logger)
        self.file_destination = self.common_config.get_config().get_code_coverage_file_directory()

    def execute(self):
        self.print_title()
        try:
            if not self.file_destination:
                raise Exception("The directory where to put all the files was not specified")
            self.log_info("Gathering all code coverage information")
            coverage_files = sdk_common.ProjectBrowser(self,
                                                       self.common_config.get_config().get_sdk_top_directory()).find_all_files(
                '.exec')
            if not coverage_files or len(coverage_files) == 0:
                self.log_warning(
                    "No code coverage files were found in the project. Please run unit tests or integration tests with instrumentation first.")
                return True
            else:
                self.log_info("The following instrumentation files were found: " + str(coverage_files))
            if not os.path.exists(self.file_destination):
                os.makedirs(self.file_destination)
            for f in coverage_files:
                shutil.copyfile(f, os.path.join(self.file_destination, self.generate_destination_new_name(f)))
            self.log_info("All coverage files were copied to : " + str(self.file_destination))
        except:
            self.log_error('Failed to gather code coverage files')
            return False
        self.log_info("Done.")
        return True

    def generate_destination_new_name(self, current_path):
        if not current_path:
            return None
        common_prefix = os.path.commonprefix([self.file_destination, current_path])
        relative_path = os.path.relpath(current_path, common_prefix)
        extension = os.path.splitext(os.path.basename(current_path))[1][1:].strip().lower()
        new_name = relative_path.replace(os.sep, "_").replace(".", "")
        return '%s.%s' % (new_name, extension)
