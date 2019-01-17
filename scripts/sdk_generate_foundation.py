#!/usr/bin/python
import sdk_common
import os


# Block in charge of generating the Foundation SDK
class SDKFoundationGeneration(sdk_common.BuildStepUsingGradle):
    def __init__(self, logger=None):
        super(SDKFoundationGeneration, self).__init__('SDK foundation generation', logger)
        self.gradle_directory = self.common_config.get_config().get_sdk_foundation_generation_directory()
        self.reset()
        self.artifacts_parser = self.common_config.get_config().get_new_artifact_log_parser(self)
        self.branch_name = self.common_config.get_config().get_branch_name()
        self.github_token = self.common_config.get_config().get_github_token()
        self.url_with_token = self.common_config.get_config().get_origin_url_combined_with_token()

    def execute(self):
        self.print_title()
        try:
            self.log_info("Generating SDK Foundation code")
            if not self.check_whether_api_config_has_changed():
                self.log_info("Cloud API specifications have not changed. No need to regenerate the Foundation SDK")
                return True
            self.generate_code()
        except:
            self.log_error('Failed to generate the Foundation SDK')
            return False
        try:
            self.log_info("Committing generated code to the repository")
            self.commit_generated_code()
        except:
            self.log_error('Failed to commit the Foundation SDK back to the repository')
            return False
        self.log_info("Done.")
        return True

    def retrieve_folder_location(self, key):
        if not key:
            return None
        self.artifacts_parser.load()
        return self.clean_path(
            self.artifacts_parser.get_property(key),
            False)

    def check_whether_api_config_has_changed(self):
        api_config = self.retrieve_folder_location('SDK_API_DEFINITION_DIR')
        if not api_config or not os.path.exists(api_config):
            self.log_warning("The folder where API specifications are store does not exist [%s]" % api_config)
            return False
        api_config = os.path.realpath(api_config)
        api_config = os.path.relpath(api_config, os.path.commonprefix([api_config, self.top_directory]))
        current_hash = self.git_commit_hash()
        previous_hash = self.git_previous_commit_hash(current_hash)
        changes = self.git_changes_list('m', previous_hash, current_hash,
                                        api_config)
        changes.extend(self.git_changes_list('a', previous_hash, current_hash,
                                             api_config))
        self.log_info("%s changes were made in the API specifications [%s] since last commit [%s]" % (
            len(changes), api_config, previous_hash))
        return changes and len(changes) > 0

    def get_list_folders_to_commit(self):
        folders = self.retrieve_folder_location('SDK_GENERATED_SOURCE_DIRS')
        if not folders:
            return []
        folders_list = folders.split(os.pathsep)
        return [os.path.realpath(folder) for folder in folders_list if os.path.exists(folder) and os.path.isdir(folder)]

    def commit_generated_code(self):
        if not self.common_config.get_config().get_user_name() or not self.common_config.get_config().get_user_email():
            self.git_setup_env()
        commit_hash = self.git_commit_hash()
        folders = self.get_list_folders_to_commit()
        if not folders or len(folders) == 0:
            self.log_warning(
                "The folders which contain code which may need to be committed back could not be determined")
            return
        for folder in folders:
            self.git_add_folder(os.path.relpath(folder, os.path.commonprefix([folder, self.top_directory])))
        current_changes = self.git_current_changes_list('a')
        current_changes.extend(self.git_current_changes_list('m'))
        current_changes.extend(self.git_current_changes_list('d'))
        if len(current_changes) == 0:
            self.log_info("Nothing to commit")
            return
        self.git_commit("New foundation SDK for API change [%s]" % commit_hash)
        if not self.url_with_token:
            if not self.github_token:
                raise Exception("The GitHub token has not been set properly")
            else:
                raise Exception("The remote URL could not be resolved")
        self.git_set_remote_url(self.url_with_token)
        self.git_set_upstream_branch(self.branch_name)
        self.git_push_and_follow_tags()

    def generate_code(self):
        self.execute_gradle_task('build', ['--rerun-tasks'])
        self.execute_gradle_task('run')
        gradle_dir = self.gradle_directory
        self.gradle_directory = self.common_config.get_config().get_sdk_top_directory()
        self.reset()
        self.execute_gradle_task('spotlessApply')
        self.gradle_directory = gradle_dir
        self.reset()
