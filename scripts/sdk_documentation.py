#!/usr/bin/python
import sdk_common


# Block in charge of generating documentation
class SDKDocumentationBuilder(sdk_common.BuildStepUsingGradle):
    def __init__(self, logger=None):
        super(SDKDocumentationBuilder, self).__init__('SDK documentation', logger)

    def execute(self):
        self.print_title()
        try:
            self.log_info("Generating Javadoc")
            self.execute_gradle_task('javadoc')
            # self.execute_gradle_task('aggregateJavadocs') #FIXME uncomment when javadoc works accross all the backends
        except:
            self.log_error('Failed to check SDK\'s documentation')
            return False
        self.log_info("Done.")
        return True
