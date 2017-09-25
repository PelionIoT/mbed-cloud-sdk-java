#!/usr/bin/python
import sdk_common


# Block in charge of deploying artifacts
class ArtifactDeployer(sdk_common.BuildStepUsingGradle):
    def __init__(self, logger=None):
        super(ArtifactDeployer, self).__init__('Artifact deployment', logger)
        self.username = self.common_config.get_config().get_artifactory_username()

    def execute(self):
        self.print_title()
        try:
            self.log_info("Pushing artifacts to artifactory as [" + str(self.username) + "]")
            self.execute_gradle_task('artifactoryPublish')
        except:
            self.log_error('Failed to deploy artifacts')
            return False
        self.log_info("Done.")
        return True
