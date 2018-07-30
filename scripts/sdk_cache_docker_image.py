#!/usr/bin/python
import os

import sdk_common


class SDKImageCacheExecuter(sdk_common.BuildStepUsingGradle):
    def __init__(self, image_filename, image_name, name, logger=None):
        super(SDKImageCacheExecuter, self).__init__(name, logger)
        self.artifacts_parser = self.common_config.get_config().get_new_artifact_log_parser(self)
        self.image_filename = image_filename
        self.image_name = image_name

    def get_image_cached_file(self):
        self.artifacts_parser.load()
        image_cache_absolute_path = self.clean_path(
            self.artifacts_parser.get_property('SDK_PROJECT_CACHE_DIR'),
            False)
        if not image_cache_absolute_path:
            raise Exception('missing cache directory')
        project_root = self.clean_path(
            self.artifacts_parser.get_property('SDK_PROJECT_ROOT_DIR'),
            False)
        if project_root:
            common_prefix = os.path.commonprefix([project_root, image_cache_absolute_path])
        image_cache_dir = os.path.relpath(image_cache_absolute_path,
                                          common_prefix) if common_prefix else image_cache_absolute_path
        image_destination = os.path.join(image_cache_dir, self.image_filename)
        return image_destination


# Block in charge of caching docker image
class SDKImageCacher(SDKImageCacheExecuter):
    def __init__(self, image_filename, image_name, name, logger=None):
        super(SDKImageCacher, self).__init__(image_filename, image_name, name, logger)

    def execute(self):
        self.print_title()
        try:
            self.log_info('Creating cache folder')
            self.execute_gradle_task('projectInitialisation')
            self.log_info('Caching %s image' % self.image_name)
            testrunner_destination = self.get_image_cached_file()
            self.check_shell_command_output("docker save -o %s %s" % (testrunner_destination, self.image_name))
        except:
            self.log_error('Failed to cache %s image' % self.image_name)
            return False
        self.log_info("Done.")
        return True


# Block in charge of retrieving docker images from the cache
class SDKImageRetriever(SDKImageCacheExecuter):
    def __init__(self, image_filename, image_name, name, logger=None):
        super(SDKImageRetriever, self).__init__(image_filename, image_name, name, logger)

    def execute(self):
        self.print_title()
        try:
            self.log_info('Retrieving %s image' % self.image_name)
            image_location = self.get_image_cached_file()
            self.check_shell_command_output("docker load -i %s" % image_location)
        except:
            self.log_error('Failed to retrieve  %s image' % self.image_name)
            return False
        self.log_info("Done.")
        return True


class SDKImageCacheManager(sdk_common.BuildStep):
    def __init__(self, image_filename, image_name, name, logger=None):
        super(SDKImageCacheManager, self).__init__(name, logger)
        self.image_filename = image_filename
        self.image_name = image_name
        self.logger = logger
        self.name = name

    def get_image_cacher(self):
        return SDKImageCacher(self.image_filename, self.image_name, self.name, self.logger)

    def get_image_retriever(self):
        return SDKImageRetriever(self.image_filename, self.image_name, self.name, self.logger)


class SDKTestRunnerImageManager(SDKImageCacheManager):
    def __init__(self, logger=None):
        super(SDKTestRunnerImageManager, self).__init__(None, None, 'SDK testrunner image management', logger)
        self.image_filename = self.common_config.get_config().get_cached_testrunner_filename()
        self.image_name = self.common_config.get_config().get_testrunner_docker_image()


class SDKTestServerImageManager(SDKImageCacheManager):
    def __init__(self, logger=None):
        super(SDKTestServerImageManager, self).__init__(None, None, 'SDK testserver image management', logger)
        self.image_filename = self.common_config.get_config().get_cached_testserver_filename()
        self.image_name = self.common_config.get_config().get_testserver_docker_image()
