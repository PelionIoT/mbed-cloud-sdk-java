#!/usr/bin/python
import sdk_common


# Block in charge of print sdk version
class SDKNewsAndTag(sdk_common.BuildStep):
    def __init__(self, logger=None):
        super(SDKNewsAndTag, self).__init__('SDK News & Tag', logger)
        self.should_tag = self.common_config.get_config().is_for_release() and not self.common_config.get_config().is_from_private()
        self.branch_name = self.common_config.get_config().get_branch_name()
        self.version = self.common_config.get_config().get_version()
        self.news_folder = self.common_config.get_config().get_news_folder()
        self.changelog = self.common_config.get_config().get_changelog_file()

    def execute(self):
        self.print_title()
        try:
            self.log_info("Generating the changelog")
            if self.news_folder:
                self.check_shell_command_output("towncrier --yes --name="" --version=%s" % self.version,
                                                self.news_folder)
        except:
            self.log_error('Failed to generate the changelog file')
            return False
        try:
            if not self.should_tag:
                self.log_info("No need for tagging.")
                return True
            self.log_info("Committing the changelog")
            if not self.common_config.get_config().get_user_name():
                self.check_shell_command_output("git config --global user.name monty-bot")
            if not self.common_config.get_config().get_user_email():
                self.check_shell_command_output("git config --global user.email monty-bot@arm.com")
            if self.news_folder:
                files = self.news_folder.strip()
                if not files.endswith("/"):
                    files += "/"
                files += "*"
                self.check_shell_command_output("git add %s" % files)
            if self.changelog:
                self.check_shell_command_output("git add %s" % self.changelog.strip())
            self.check_shell_command_output(
                "git commit -m 'Updated changelog file for release %s [skip ci]'" % self.version)
            self.check_shell_command_output("git push --set-upstream origin %s" % self.branch_nam)
            self.log_info("Tagging the project in GitHub")
            self.check_shell_command_output("git tag -a %s -m 'SDK Release'" % self.version)
            self.check_shell_command_output("git push --tags")
            self.check_shell_command_output("git tag -f latest")
            self.check_shell_command_output("git push -f origin --tags")
        except:
            self.log_error('Failed to tag the repository')
            return False
        self.log_info("Done.")
        return True

        self.check_command_output(arguments, self.gradle_directory)
        self.log_info(self.common_config.get_config().get_version(), True)

        return True
