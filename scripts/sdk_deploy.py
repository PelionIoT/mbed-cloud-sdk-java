#!/usr/bin/python
import sdk_common


# Block in charge of deploying artifacts
class ArtifactDeployer(sdk_common.BuildStepUsingGradle):
    def __init__(self, logger=None):
        super(ArtifactDeployer, self).__init__('Artifact deployment', logger)
        self.username = self.common_config.get_config().get_artifactory_username()
        self.host = self.common_config.get_config().get_artifactory_host()

    def execute(self):
        self.print_title()
        try:
            self.log_info("Launch build again to check nothing was lost")
            self.execute_gradle_task('build')
            self.log_info("Generate Pom file")
            self.execute_gradle_task('generatePomFileForMavenJavaPublication')
            if self.check_if_artifactory_is_accessible():
                self.log_info("Pushing artifacts to artifactory as [" + str(self.username) + "]")
                try:  # TODO remove this try catch. Until https://github.com/JFrogDev/build-info/issues/115 is fixed, do not consider task error code
                    self.execute_gradle_task('artifactoryPublish')
                except:
                    pass
            else:
                self.log_error_without_getting_cause("Artifactory is not accessible [" + str(self.host) + "]")
                self.log_info("SDK artifacts will not be automatically uploaded to such a repository")
        except:
            self.log_error('Failed to deploy artifacts')
            return False
        self.log_info("Done.")
        return True

    def check_if_artifactory_is_accessible(self):
        return self.ping_host(self.host)
