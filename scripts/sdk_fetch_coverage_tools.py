#!/usr/bin/python
import sdk_common
import shutil
import os
import requests
import re


# Block in charge of fetching code coverage tools
class SDKCoverageToolsFetcher(sdk_common.BuildStepUsingGradle):
    def __init__(self, logger=None):
        super(SDKCoverageToolsFetcher, self).__init__('SDK Coverage tools fetch', logger)
        self.is_code_coverage = self.common_config.get_config().should_perform_code_coverage()
        self.artifacts_parser = sdk_common.PropertyFileParser(self,
                                                              self.common_config.get_config().get_sdk_top_directory(),
                                                              "artifacts.properties", "=", "#")
        self.jacoco_cli_name = 'jacococli.jar'

    def retrieve_folder_location(self, key):
        if not key:
            return None
        self.artifacts_parser.load()
        return self.clean_path(
            self.artifacts_parser.get_property(key),
            False)

    def check_whether_coverage_result_folder_has_been_created(self):
        code_coverage_result_dir = self.retrieve_folder_location('SDK_COVERAGE_RESULTS_DIR')
        return False if not code_coverage_result_dir else os.path.exists(code_coverage_result_dir)

    def check_whether_tools_have_been_copied(self):
        code_coverage_tools_dir = self.retrieve_folder_location('SDK_COVERAGE_TOOLS_DIR')
        return False if not code_coverage_tools_dir else (
            os.path.exists(code_coverage_tools_dir) and len(
                os.listdir(code_coverage_tools_dir)) >= 2)  # TODO change if fewer tools are used

    def has_already_been_run(self):
        return self.check_whether_coverage_result_folder_has_been_created() and self.check_whether_tools_have_been_copied()

    def determine_cli_tool_url(self):
        snapshot_url = 'https://oss.sonatype.org/content/repositories/snapshots/org/jacoco/org.jacoco.cli/0.7.10-SNAPSHOT/'
        res = requests.get(snapshot_url)
        if res.status_code != requests.codes.ok:
            return None
        pattern = "(" + snapshot_url + "[\\w\\\/.-]*jacoco.cli[\\w\\\/.-]*-nodeps.jar)"
        m = re.search(pattern, res.text)
        return m.group(0) if m else None

    def execute(self):
        self.print_title()
        try:
            if self.is_code_coverage:
                self.log_info("Retrieving code coverage tools")
                if not self.has_already_been_run():
                    self.execute_gradle_task("copyCoverageAgent")
                    # TODO the following should be removed when jacoco cli is actually available on official Maven central
                    self.log_info("Fetching Jacoco CLI")
                    code_coverage_tools_dir = self.retrieve_folder_location('SDK_COVERAGE_TOOLS_DIR')
                    jacococli_path = os.path.join(code_coverage_tools_dir, self.jacoco_cli_name)
                    if not os.path.exists(jacococli_path):
                        cli_url = self.determine_cli_tool_url()
                        if not cli_url:
                            cli_url = 'https://oss.sonatype.org/content/repositories/snapshots/org/jacoco/org.jacoco.cli/0.7.10-SNAPSHOT/org.jacoco.cli-0.7.10-20171021.210044-41-nodeps.jar'
                        arguments = ['wget', cli_url, '--no-check-certificate', '-O', self.jacoco_cli_name]
                        return_code = self.call_command(arguments)
                        if return_code != 0:
                            raise Exception('Error code', return_code)
                        shutil.move(self.jacoco_cli_name, code_coverage_tools_dir)
                else:
                    self.log_info("Tools are already present.")

        except:
            self.log_error('Failed to retrieving code coverage tools')
            return False
        self.log_info("Done.")
        return True
