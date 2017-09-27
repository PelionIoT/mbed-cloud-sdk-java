#!/usr/bin/python
import sdk_common
import shutil
import os
import glob
from functools import reduce


# Block in charge of licensing
class LicenceSetter(sdk_common.BuildStepUsingGradle):
    def __init__(self, logger=None):
        super(LicenceSetter, self).__init__('Licensing', logger)
        self.distribution_directory = reduce(lambda x, y: os.path.join(x, y),
                                             [self.top_directory, 'src', 'main', 'dist'])
        self.third_party_licences = os.path.join(self.distribution_directory, 'ThirdParty-Licences')

    def execute(self):
        self.print_title()
        try:
            self.log_info("Generating 3rd party licence documents")
            self.execute_gradle_task('dependencyLicenseReport')
            self.log_info("Integrating 3rd party licence documents")
            self.copy_third_party_directory()
            self.log_info("Integrating SDK distribution documentation and licence")
            self.copy_distribution_documentation()

        except:
            self.log_error('Failed to generate licence documentation')
            return False
        self.log_info("Done.")
        return True

    def copy_distribution_documentation(self):
        for filename in glob.glob(os.path.join(self.top_directory, '*.md')):
            shutil.copy2(filename, self.distribution_directory)
        licence_file = os.path.join(self.top_directory, 'LICENCE')
        if os.path.exists(licence_file):
            shutil.copy2(licence_file, self.distribution_directory)

    def copy_third_party_directory(self):
        licenses = reduce(lambda x, y: os.path.join(x, y), [self.build_directory, 'reports', 'dependency-license'])
        if os.path.exists(self.third_party_licences):
            self.remove_path(self.third_party_licences, True)
        shutil.copytree(licenses, self.third_party_licences)
        for filename in glob.glob(os.path.join(self.third_party_licences, '*.jar')):
            self.remove_path(filename, True)
