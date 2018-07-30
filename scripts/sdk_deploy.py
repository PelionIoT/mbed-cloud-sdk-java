#!/usr/bin/python
import sdk_common


# Block in charge of deploying artifacts
class ArtifactDeployer(sdk_common.BuildStepUsingGradle):
    def __init__(self, logger=None):
        super(ArtifactDeployer, self).__init__('Artifact deployment', logger)
        self.username = self.common_config.get_config().get_artifactory_username()
        self.release_username = self.common_config.get_config().get_bintray_username()
        self.maven_username = self.common_config.get_config().get_maven_central_username()
        self.host = self.common_config.get_config().get_artifactory_host()
        self.should_push_to_bintray = self.common_config.get_config().is_for_release() and not self.common_config.get_config().is_from_private()

    def execute(self):
        self.print_title()
        try:
            self.log_info("Generate Pom file")
            self.execute_gradle_task('generatePomFileForMavenJavaPublication')
            if self.check_if_artifactory_is_accessible():
                self.log_info("Pushing artifacts to artifactory as [" + str(self.username) + "]")
                self.execute_gradle_task('artifactoryPublish', ['-x', 'javadoc'])
            else:
                self.log_error_without_getting_cause("Artifactory is not accessible [" + str(self.host) + "]")
                self.log_info("SDK artifacts will not be automatically uploaded to such a repository")
            if self.should_push_to_bintray:
                self.log_info("Pushing artifacts to bintray as [" + str(self.release_username) + "]")
                if self.maven_username:
                    self.log_info("Maven Central will be synchronised with bintray repository using [" + str(
                        self.maven_username) + "] account")
                self.execute_gradle_task('bintrayUpload', ['--info', '-x', 'javadoc'])
        except:
            self.log_error('Failed to deploy artifacts')
            return False
        self.log_info("Done.")
        return True

    def check_if_artifactory_is_accessible(self):
        return self.ping_host(self.host)
