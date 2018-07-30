#!/usr/bin/python
import sdk_common


# Block in charge of tagging the release
class SDKNewsAndTag(sdk_common.BuildStep):
    def __init__(self, logger=None):
        super(SDKNewsAndTag, self).__init__('SDK News & Tag', logger)
        self.branch_name = self.common_config.get_config().get_branch_name()
        self.github_token = self.common_config.get_config().get_github_token()
        self.url_with_token = self.common_config.get_config().get_origin_url_combined_with_token()
        self.version = self.common_config.get_config().get_version()
        self.is_commit_already_tagged = self.common_config.get_config().is_commit_tagged()
        self.should_tag = (
                              not self.is_commit_already_tagged) and self.common_config.get_config().is_for_release() and (
                              not self.common_config.get_config().is_from_private())
        self.news_folder = self.common_config.get_config().get_news_folder()
        self.changelog = self.common_config.get_config().get_changelog_file()
        self.property_file = self.common_config.get_config().get_project_property_file()

    def execute(self):
        print('> is commit already tagged: ' + str(self.is_commit_already_tagged))
        self.print_title()
        try:
            self.log_info("Generating the changelog")
            if self.is_commit_already_tagged:
                self.log_info(
                    "The commit was already tagged [%s]. No need to generate the changelog file" % self.fetch_commit_tag())
                return True
            if self.news_folder:
                self.check_shell_command_output("towncrier --yes --name="" --version=%s" % self.version,
                                                self.news_folder)
        except:
            self.log_error('Failed to generate the changelog file')
            return False
        try:
            if not self.should_tag:
                self.log_info("No need for tagging.")
                if self.is_commit_already_tagged:
                    self.log_info(
                        "The commit was already tagged [%s]" % self.fetch_commit_tag())
                return True
            self.tag_github()
        except:
            self.log_error('Failed to tag the repository')
            return False
        self.log_info("Done.")
        return True

        self.check_command_output(arguments, self.gradle_directory)
        self.log_info(self.common_config.get_config().get_version(), True)

        return True

    def fetch_commit_tag(self):
        return self.common_config.get_config().get_commit_tag()

    def tag_github(self):
        self.log_info("Committing the changelog")
        if not self.common_config.get_config().get_user_name():
            self.check_shell_command_output("git config --global user.name monty-bot")
        if not self.common_config.get_config().get_user_email():
            self.check_shell_command_output("git config --global user.email monty-bot@arm.com")
        if not self.url_with_token:
            if not self.github_token:
                raise Exception("The GitHub token has not been set properly")
            else:
                raise Exception("The remote URL could not be resolved")
        self.check_shell_command_output("git remote set-url origin %s" % self.url_with_token)
        self.check_shell_command_output("git branch --set-upstream-to origin/%s" % self.branch_name)
        if self.news_folder:
            files = self.news_folder.strip()
            if not files.endswith("/"):
                files += "/"
            files += "*"
            self.check_shell_command_output("git add %s" % files)
        if self.changelog:
            self.check_shell_command_output("git add %s" % self.changelog.strip())
        if self.property_file:
            self.check_shell_command_output("git add %s" % self.property_file.strip())
        self.check_shell_command_output(
            "git commit -m ':checkered_flag: Release %s'" % self.version)
        self.log_info("Tagging the project")
        self.check_shell_command_output("git tag -a %s -m 'SDK Release'" % self.version)
        self.log_info("Pushing changes back to GitHub")
        self.check_shell_command_output("git push --follow-tags")
        self.log_info("Marking this commit as latest")
        self.check_shell_command_output("git tag -f latest")
        self.check_shell_command_output("git push -f --tags")
