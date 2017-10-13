#!/usr/bin/python

import sys
import sdk_logger
import sdk_distribution_config
import sdk_deploy
import sdk_licensing
import sdk_build
import sdk_test
import sdk_clean
import sdk_version
import sdk_help
import sdk_launch_test_server
import sdk_fetch_test_runner


# Entry point for executing SDK build steps
class SDKBuild:
    def __init__(self):
        self.logger = self.get_logger('SDK Distribution Build')

        self.steps = {'configure': sdk_distribution_config.SDKDistributionSetter(self.logger),
                      'license': sdk_licensing.LicenceSetter(self.logger),
                      'build': sdk_build.SDKBuilder(self.logger),
                      'build_test_server': sdk_test.SDKTestServerBuilder(self.logger),
                      'deploy': sdk_deploy.ArtifactDeployer(self.logger),
                      'clean': sdk_clean.SDKCleaner(self.logger),
                      'version': sdk_version.SDKVersion(self.logger),
                      'launch_test_server': sdk_launch_test_server.SDKTestServerLauncher(self.logger),
                      'fetch_test_runner': sdk_fetch_test_runner.SDKTestRunnerFetcher(self.logger),
                      'help': sdk_help.SDKHelp(self.logger)
                      }
        self.steps['help'].set_action_list(self.steps.keys())
        self.print_info = True

    def get_logger(self, action):
        return sdk_logger.DefaultLogger(action).getLogger()

    # Method carrying out the configuration of one block (e.g. configure, add_licences_documentation, build, build_test_server, deploy)
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
