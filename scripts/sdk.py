#!/usr/bin/python

import sys

import sdk_build
import sdk_clean
import sdk_deploy
import sdk_distribution_config
import sdk_fetch_coverage_tools
import sdk_fetch_test_runner
import sdk_report_code_coverage
import sdk_help
import sdk_launch_test_server
import sdk_licensing
import sdk_logger
import sdk_build_test_server
import sdk_version
import sdk_generate_quality_summary
import sdk_run_integration_tests
import sdk_unit_tests
import sdk_static_analysis
import sdk_run_examples
import sdk_news_and_tags
import sdk_versioning
import sdk_versioning_release
import sdk_check_dependencies
import sdk_documentation
import sdk_cache_docker_image
import sdk_build_test_server_image
import sdk_gather_code_coverage_files


# Entry point for executing SDK build steps
class SDKBuild:
    def __init__(self):
        self.logger = self.get_logger('SDK Distribution Build')

        self.steps = {'configure': sdk_distribution_config.SDKDistributionSetter(self.logger),
                      'license': sdk_licensing.LicenceSetter(self.logger),
                      'build': sdk_build.SDKBuilder(self.logger),
                      'unit_tests': sdk_unit_tests.SDKUnitTests(self.logger),
                      'static_analysis': sdk_static_analysis.SDKBuilder(self.logger),
                      'build_test_server': sdk_build_test_server.SDKTestServerBuilder(self.logger),
                      'buid_test_server_image': sdk_build_test_server_image.SDKTestServerImageBuilder(self.logger),
                      'deploy': sdk_deploy.ArtifactDeployer(self.logger),
                      'clean': sdk_clean.SDKCleaner(self.logger),
                      'version': sdk_version.SDKVersion(self.logger),
                      'launch_test_server': sdk_launch_test_server.SDKTestServerLauncher(self.logger),
                      'run_integration_tests': sdk_run_integration_tests.SDKIntegrationTestRunner(self.logger),
                      'fetch_test_runner': sdk_fetch_test_runner.SDKTestRunnerFetcher(self.logger),
                      'fetch_code_coverage_tools': sdk_fetch_coverage_tools.SDKCoverageToolsFetcher(self.logger),
                      'gather_code_coverage_files': sdk_gather_code_coverage_files.SDKCoverageFileGatherer(self.logger),
                      'report_code_coverage': sdk_report_code_coverage.SDKCoverageReporter(self.logger),
                      'generate_quality_summary': sdk_generate_quality_summary.SDKQualityReportBuilder(self.logger),
                      'run_examples': sdk_run_examples.SDKExamplesRunner(self.logger),
                      'changelog': sdk_news_and_tags.SDKNewsAndTag(self.logger),
                      'versioning': sdk_versioning.SDKVersioning(self.logger),
                      'versioning_release': sdk_versioning_release.SDKVersioningRelease(self.logger),
                      'dependencies': sdk_check_dependencies.SDKDependenciesChecker(self.logger),
                      'documentation': sdk_documentation.SDKDocumentationBuilder(self.logger),
                      'cache_testrunner': sdk_cache_docker_image.SDKTestRunnerImageManager(
                          self.logger).get_image_cacher(),
                      'retrieve_testrunner': sdk_cache_docker_image.SDKTestRunnerImageManager(
                          self.logger).get_image_retriever(),
                      'cache_testserver': sdk_cache_docker_image.SDKTestServerImageManager(
                          self.logger).get_image_cacher(),
                      'retrieve_testserver': sdk_cache_docker_image.SDKTestServerImageManager(
                          self.logger).get_image_retriever(),
                      'help': sdk_help.SDKHelp(self.logger)
                      }
        self.steps['help'].set_action_list(self.steps.keys())
        self.print_info = True

    def get_logger(self, action):
        return sdk_logger.DefaultLogger(action).getLogger()

    # Method executing a build step (e.g. configure, add_licences_documentation, build, build_test_server, deploy)
    def execute(self, module):
        if module:
            success = module.execute()
            if success:
                if self.print_info:
                    self.logger.output_success_message(str(module.get_module_name()) + ' build step has succeeded')
            else:
                if self.print_info:
                    self.logger.output_error(str(module.get_module_name()) + ' has failed')
                sys.exit(1)

    def run(self):
        step = None
        step_name = None
        if len(sys.argv) > 1:
            step_name = sys.argv[1]
            step_name = step_name.strip()
            if step_name == 'version' or step_name == 'help':
                self.print_info = False
            if step_name in self.steps:
                step = self.steps[step_name]
        if not step:
            self.logger.output_error('SDK build step [' + str(step_name) + '] was not recognised')
            self.execute(self.steps['help'])
            sys.exit(1)
        try:
            if self.print_info:
                self.logger.output_message('Executing build step [' + str(step_name) + ']')
            self.execute(step)
            if self.print_info:
                self.logger.output_debug_message(str(sys.argv) + ' succeeded')
        except:
            raise Exception(
                "A problem occurred while executing sdk build step. Reason: " + str(sys.exc_info()[1]))
        finally:
            if self.print_info:
                self.logger.print_log_file_location()


if __name__ == "__main__":
    SDKBuild().run()
