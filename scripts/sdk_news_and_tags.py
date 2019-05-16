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

    def fetch_commit_tag(self):
        return self.common_config.get_config().get_commit_tag()

    def tag_github(self):
        self.log_info("Committing the changelog")
        if not self.common_config.get_config().get_user_name() or not self.common_config.get_config().get_user_email():
            self.git_setup_env()
        if not self.url_with_token:
            if not self.github_token:
                raise Exception("The GitHub token has not been set properly")
            else:
                raise Exception("The remote URL could not be resolved")
        self.git_set_remote_url(self.url_with_token)
        self.git_set_upstream_branch(self.branch_name)
        if self.news_folder:
            self.git_add_folder( self.news_folder)
        if self.changelog:
            self.git_add_file(self.changelog)
        if self.property_file:
            self.git_add_file(self.property_file)
        self.git_commit(':checkered_flag: Release %s' % self.version)
        self.log_info("Tagging the project")
        self.git_tag(self.version,'SDK Release')
        self.log_info("Pushing changes back to GitHub")
        self.git_push_and_follow_tags()
        self.log_info("Marking this commit as latest")
        self.git_soft_tag('latest')
        self.git_force_push_tags()
