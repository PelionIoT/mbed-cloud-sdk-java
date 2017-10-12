#!/usr/bin/python
import sdk_common


# Block in charge of building SDK Test server
class SDKTestServerLauncher(sdk_common.BuildStepUsingGradle):
    def __init__(self, logger=None):
        super(SDKTestServerLauncher, self).__init__('SDK test server launch', logger)
        # self.logger.is_debug_enabled = True
        self.artifacts_parser = sdk_common.PropertyFileParser(self,
                                                              self.common_config.get_config().get_sdk_top_directory(),
                                                              "artifacts.properties", "=", "#")

    def execute(self):
        self.print_title()
        try:
            self.log_info("Launching SDK test server")
            self.artifacts_parser.load()
            test_jar = self.artifacts_parser.get_properties()['TEST_FULL_JAR']
            test_jar_argument = str(test_jar)
            test_jar_argument = test_jar_argument.replace("\\\\", "\\").replace("\\:", ":")
            test_jar_argument = test_jar_argument.replace("\\\\", "\\")
            test_jar_argument = "\"" + str(test_jar_argument) + "\""
            arguments = ['java', '-jar', test_jar_argument]
            return_code = self.call_command(arguments, None, True)
            if return_code == 1:
                raise Exception('Error code', return_code)
        except:
            self.log_error('Failed to launch SDK test server')
            return False
        self.log_info("Done.")
        return True
