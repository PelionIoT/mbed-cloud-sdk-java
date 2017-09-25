#!/usr/bin/python
import os
import re
import shutil
import subprocess
import sys
#import zipfile
from collections import OrderedDict

import sdk_logger


# Generic class defining an action e.g. process spawning...
class Action(object):
    def __init__(self, name, logger=None):
        self.module_name = name
        self.logger = logger if logger else sdk_logger.DefaultLogger(name).getLogger()

    def get_module_name(self):
        return self.module_name

    def log_error(self, message):
        self.logger.output_error(
            "ERROR [Module: " + str(self.module_name) + "]: " + str(message) + ". Reason: " + str(sys.exc_info()[1]))

    def log_error_without_getting_cause(self, message):
        self.logger.output_error(
            "ERROR [Module: " + str(self.module_name) + "]: " + str(message))

    def log_warning(self, message):
        self.logger.output_warning("WARNING [Module: " + str(self.module_name) + "]: " + str(message))

    def log_info(self, message):
        self.logger.output_message(message)

    def log_debug(self, message):
        self.logger.output_debug_message("DEBUG [Module: " + str(self.module_name) + "]: " + str(message))

    def log_success(self, message):
        self.logger.output_success_message("SUCCESS [Module: " + str(self.module_name) + "]: " + str(message))

    def _spawn(self, debug, args, **kwargs):
        process = subprocess.Popen(args, stdout=subprocess.PIPE, shell=True, universal_newlines=True, **kwargs)
        output, err = process.communicate()
        retcode = process.poll()
        if debug:
            if output:
                self.log_debug('Command output: ' + output)
            if err:
                self.log_debug('Command error message: ' + err)
        return retcode

    def call_command(self, args, directory):
        return self._spawn_command(True, args, directory)

    # The following method was introduced in order to work using either python 2.7 or python 3 and above
    def _spawn_command(self, debug, args, directory):
        if args:
            return_code = 1
            # Convert args list to single string (required for any commands using pipes or shell builtins)
            args = ' '.join(args)
            if not directory:
                directory = os.getcwd()
            if debug:
                self.log_debug("Executing: " + args + " in directory [" + str(directory) + "]")
            try:
                proc = subprocess.run(args, shell=True, stdout=subprocess.PIPE, timeout=None, check=False,
                                      stderr=subprocess.STDOUT, universal_newlines=True, cwd=directory)
                return_code = proc.returncode
                output = proc.stdout
                err = proc.stderr
                if debug:
                    if output:
                        self.log_debug('Command output: ' + output)
                    if err:
                        self.log_debug('Command error message: ' + err)

            except AttributeError:
                return_code = self._spawn(debug, args, stderr=subprocess.STDOUT, cwd=directory)
            if debug:
                self.log_debug("Command return code: " + str(return_code))
            return return_code
        return None

    def check_command_output(self, args, directory=None):
        if not directory:
            directory = os.getcwd()
        if args:
            self.log_debug("Executing: " + str(args) + " in directory [" + str(directory) + "]")
            result = subprocess.check_output(args, stderr=subprocess.STDOUT, universal_newlines=True, cwd=directory)
            self.log_debug("Command Output: " + str(result))
            return result
        return None

    def check_shell_command_output(self, command, directory=None):
        if not directory:
            directory = os.getcwd()
        if command:
            self.log_debug("Executing: " + str(command) + " in directory [" + str(directory) + "]")
            result = subprocess.check_output(command, stderr=subprocess.STDOUT, shell=True, universal_newlines=True,
                                             cwd=directory)
            self.log_debug("Command Output: " + str(result))
            return result
        return None

    def get_command_output(self, args):
        result = None
        if args:
            try:
                self.log_debug("Executing: " + str(args))
                result = subprocess.Popen(args, stdout=subprocess.PIPE, universal_newlines=True).communicate()[0]
                self.log_debug("Command Output: " + str(result))
            except subprocess.CalledProcessError as e:
                self.log_error_without_getting_cause(e.output)
        return result


# Note: Each build action to perform during Sdk distribution build or deployment is defined as a separate object (e.g. release configuration, distribution build, deployment, etc)
# Generic class defining a build step block part of SDK build
class BuildStep(Action):
    def __init__(self, name, logger):
        super(BuildStep, self).__init__(name, logger)
        self.common_config = CommonConfig()
        self.top_directory = self.common_config.get_config().get_sdk_top_directory()
        self.build_directory = self.common_config.get_config().get_sdk_build_directory()

    # Override this method. All build step blocks should have an 'execute' method
    def execute(self):
        return True

    def print_title(self):
        self.logger.print_banner("|         " + str(self.module_name) + " build step           |")

    def remove_path(self, path, throw_on_error):
        self.log_debug("Removing: " + str(path))
        if not path or len(path) == 0:
            return True
        if not os.path.exists(path):
            return True
        try:
            if os.path.isfile(path):
                os.remove(path)
            elif os.path.isdir(path):
                shutil.rmtree(path)
            elif os.path.islink(path):
                os.unlink(path)
        except Exception as e:
            self.log_error(str(path) + " was not removed properly")
            if throw_on_error:
                raise e
            return False

        # Test removal worked as intended
        if os.path.exists(path):
            self.log_error_without_getting_cause(str(path) + " was not removed properly")
            if throw_on_error:
                raise Exception(str(path) + " still exists")
            return False
        return True

    def clean_directory(self, path, throw_on_error):
        if not path:
            return True
        if self.remove_path(path, throw_on_error):
            os.makedirs(path)
        return True

    def zip_directory_content(self, path, zip_name):
        shutil.make_archive(zip_name, 'zip', path)
        # with zipfile.ZipFile(zip_name, 'w', zipfile.ZIP_DEFLATED) as zf:
        #     for root, dirs, files in os.walk(path):
        #         for file in files:
        #             zf.write(os.path.join(root, file))


class BuildStepUsingGradle(BuildStep):
    def __init__(self, name, logger):
        super(BuildStepUsingGradle, self).__init__(name, logger)
        self.gradle_directory = os.path.normpath(os.path.realpath(self.top_directory))
        self.graddle_command = self.get_gradle_script_to_use()

    def get_gradle_script_to_use(self):
        gradle_command = None
        if self.common_config.get_config().should_use_gradle_wrapper():
            if self.common_config.get_config().is_running_on_windows():
                gradle_command = os.path.join(self.gradle_directory, 'gradlew.bat')
            else:
                gradle_command = os.path.join(self.gradle_directory, 'gradlew')
        else:
            gradle_command = 'gradle'
        return gradle_command

    def execute_gradle_task(self, task):
        arguments = [self.graddle_command, task]
        self.check_command_output(arguments, self.gradle_directory)


# Generic class defining an object which finds a configuration file
class ConfigurationFileFinder(object):
    def __init__(self, module, top_dir, file_name):
        self.module = module
        self.file_name = file_name
        self.found_file = None
        self.found_directory = None
        self.top_dir = top_dir

    def trim_line(self, line):
        if line:
            line = line.strip('\n')
            line = line.strip('\r')
            line = line.strip('\n')
        return line

    def find_file(self):
        if self.file_name:
            if self.top_dir and os.path.exists(self.top_dir):
                for root, dirs, files in os.walk(self.top_dir):
                    for file in files:
                        if file == self.file_name:
                            self.found_file = file
                            self.found_directory = root
                            return True
        return False


# Generic class to parse property files.
class PropertyFileParser(ConfigurationFileFinder):
    def __init__(self, module, top_dir, file_name, separator, comment_string):
        super(PropertyFileParser, self).__init__(module, top_dir, file_name)
        self.properties = OrderedDict()
        self.separator = separator
        self.comment_string = comment_string

    def reset(self):
        if self.properties:
            self.properties.clear()
        else:
            self.properties = OrderedDict()

    def load(self):
        self.reset()
        self.find_file()
        if self.found_file:
            with open(os.path.join(self.found_directory, self.found_file), 'r') as f:
                for line in f:
                    line = self.trim_line(line)
                    if line:
                        if self.comment_string and line.startswith(self.comment_string):
                            continue
                        property = line.split(self.separator)
                        self.properties[property[0].strip()] = property[1].strip() if len(property) > 1 else None

    def get_properties(self):
        return self.properties


# Generic (abstract) class defining an object which changes some configuration files
# The way it works is simple. The script reads the file to change and writes each line as well as modifications in a temporary file.
# The file is then granted with the same permission rights as the file to change. The file to change is then replaced with the temporary file containing modifications
class ConfigurationFileModifier(ConfigurationFileFinder):
    def __init__(self, module, top_dir, file_name):
        super(ConfigurationFileModifier, self).__init__(module, top_dir, file_name)
        self.file_to_modify = None
        self.file_to_modify_tmp = None
        self.read_file = None
        self.write_file = None

    def find_file(self):
        super(ConfigurationFileModifier, self).find_file()
        if self.found_file:
            self.file_to_modify = os.path.join(self.found_directory, self.found_file)
            self.file_to_modify_tmp = os.path.join(self.found_directory, str(self.found_file) + '-tmp')

    def replace(self):
        if self.file_to_modify and os.path.exists(
                self.file_to_modify) and self.file_to_modify_tmp and os.path.exists(self.file_to_modify_tmp):
            self.copy_permissions()
            self.module.remove_path(self.file_to_modify, False)
            os.rename(self.file_to_modify_tmp, self.file_to_modify)

    def copy_permissions(self):
        permissions = os.stat(self.file_to_modify)
        os.chmod(self.file_to_modify_tmp, permissions.st_mode)

    def modify(self):
        self.module.log_debug('Modifying file ' + str(self.file_name))
        self.find_file()
        self.module.log_debug('file path: ' + str(self.file_to_modify))
        try:
            self.generate_new_file_with_modifications()
            self.append_new_lines()
            self.close_files()
            self.replace()
            self.module.log_debug('File ' + str(self.file_name) + ' was successfully modified')
        except:
            raise IOError("A problem occurred while modifying file: " + str(self.file_name) + ". Reason: " + str(
                sys.exc_info()[1]))
        finally:
            self.close_files()

    def close_files(self):
        if self.read_file:
            self.read_file.close()
            self.read_file = None
        if self.write_file:
            self.write_file.close()
            self.write_file = None

    def generate_new_file_with_modifications(self):
        if self.file_to_modify and os.path.exists(self.file_to_modify):
            self.read_file = open(self.file_to_modify, "r")
            self.write_file = open(self.file_to_modify_tmp, "w")
            if self.write_file:
                for line in self.read_file.readlines():
                    line = self.trim_line(line)
                    self.write_new_line(line)

    def _write_new_line_to_file(self, newline):
        if newline and self.write_file:
            self.write_file.write(newline)

    def _write_new_line_to_file_with_end_character(self, newline):
        if newline:
            newline = self.trim_line(newline)
            if newline:
                self._write_new_line_to_file(newline + os.linesep)

    # Method to Override : write a new line depending on read line
    def write_new_line(self, read_line):
        pass

    # Method to Override : append new line to the configuration file
    def append_new_lines(self):
        pass


# Generic class to modify specific properties in property files. If properties are found, they will be modified with new value. Otherwise, they will be appended at the end of the configuration file
# After the file is modified, all modifications are checked using grep
class PropertyFileModifier(ConfigurationFileModifier):
    def __init__(self, module, top_dir, file_name, separator, properties_to_modify):
        super(PropertyFileModifier, self).__init__(module, top_dir, file_name)
        self.properties = properties_to_modify
        self.properties_status = OrderedDict()
        self.separator = separator
        self.initialise_properties_status()

    def initialise_properties_status(self):
        if self.properties_status:
            self.properties_status.clear()
        else:
            self.properties_status = OrderedDict()
        if self.properties:
            for key, value in self.properties.items():
                self.properties_status[key] = False

    def write_new_line(self, read_line):
        if read_line:
            found = False
            if self.properties:
                for property, value in self.properties.items():
                    if str(property) in str(read_line):
                        # checking it is exactly the property we are looking for and not a substring
                        extended_str = str(property) + str(self.separator)
                        if extended_str in str(read_line):
                            found = True
                            self.write_property(property)
            if not found:
                self._write_new_line_to_file(read_line)

    def write_property(self, property):
        if property:
            value = self.properties.get(property, None)
            newline = str(property) + self.separator + str(value)
            self._write_new_line_to_file_with_end_character(newline)
            self.module.log_debug('Adding line: ' + str(newline))
            self.properties_status[property] = True

    def has_lines_to_append(self):
        for property, status in self.properties_status.items():
            if not status:
                return True
        return False

    def append_new_lines(self):
        for property, status in self.properties_status.items():
            if not status:
                self.write_property(property)

    def check_property_was_modified(self, property):
        self.module.log_debug(
            'Checking property [' + str(property) + '] has been correctly added to file [' + str(
                self.file_to_modify) + ']')
        value = self.properties.get(property, None)
        command = 'grep "' + str(property) + '" "' + str(self.file_to_modify) + '" | grep "' + str(value) + '"'
        found = False
        try:
            response = self.module.check_shell_command_output(command)
            if response:
                found = True
        except:
            found = False
        if not found:
            self.module.log_debug(
                'Property [' + str(property) + '] was not found in file [' + str(self.file_to_modify) + ']')
        return found

    def check_properties_were_correctly_modified(self):
        if self.properties:
            incorrect = False
            for property, value in self.properties.items():
                if not self.check_property_was_modified(property):
                    incorrect = True
            if incorrect:
                raise IOError(
                    "A problem occurred while modifying file: " + str(
                        self.file_name) + ". Reason: some properties have not been modified correctly")

    def modify(self):
        super(PropertyFileModifier, self).modify()
        self.check_properties_were_correctly_modified()


# Generic class to modify specific properties in property files. If file is missing, it gets created
class PropertyFileModifierOrCreatorIfMissing(PropertyFileModifier):
    def __init__(self, module, top_dir, file_name, separator, properties_to_modify):
        super(PropertyFileModifierOrCreatorIfMissing, self).__init__(module, top_dir, file_name, separator,
                                                                     properties_to_modify)
        self.create_file()

    def create_file(self):
        path = os.path.join(self.top_dir, self.file_name)
        if not os.path.exists(path):
            open(path, 'a').close()


# Configuration Singleton shared between all modules
class CommonConfig:
    instance = None

    def __init__(self):
        if not CommonConfig.instance:
            CommonConfig.instance = Config()
            CommonConfig.instance.load()

    def get_config(self):
        return CommonConfig.instance


# SDK distribution configuration
class Config(Action):
    def __init__(self):
        super(Config, self).__init__("Release Configuration")

        self.version = None
        self.is_release = False
        self.publishing_repo = None
        self.artifactory_user = None
        self.artifactory_password = None
        self.sdk_top_dir = None
        self.sdk_build_dir = None
        self.use_gradle_wrapper = False
        self.on_windows = False
        self.properties = OrderedDict()

    def get_sdk_top_directory(self):
        if not self.sdk_top_dir:
            self.log_debug("Determining SDK top directory")
            script_loc = os.path.realpath(__file__)
            if not script_loc:
                script_loc = os.path.realpath(os.path.dirname(sys.argv[0]))
            else:
                script_loc = os.path.dirname(script_loc)
                self.sdk_top_dir = os.path.realpath(os.path.join(script_loc, '..'))
        return self.sdk_top_dir

    def get_sdk_build_directory(self):
        if not self.sdk_build_dir:
            self.log_debug("Determining SDK build directory")
            self.sdk_build_dir = os.path.realpath(os.path.join(self.sdk_top_dir, 'build'))
        return self.sdk_build_dir

    def should_use_gradle_wrapper(self):
        return self.use_gradle_wrapper

    def check_if_graddle_wrapper_exists(self):
        self.log_debug("Determining whether gradlew should be used")
        script_name = 'gradlew.bat' if self.is_running_on_windows() else 'gradlew'
        self.use_gradle_wrapper = ConfigurationFileFinder(self, self.get_sdk_top_directory(),
                                                          script_name).find_file()

    def get_publishing_repo(self):
        if not self.publishing_repo:
            self.log_debug("Determining the repository to pusblish artifacts to")
            if self.is_release:
                self.publishing_repo = self.properties['artifactory_deployment_release_repository']
            else:
                self.publishing_repo = self.properties['artifactory_deployment_snapshot_repository']
        return self.publishing_repo

    def is_release(self):
        return self.is_release

    def is_running_on_windows(self):
        return self.on_windows

    def check_platform(self):
        self.on_windows = sys.platform.startswith('win')

    def get_version(self):
        if not self.version:
            self.log_debug("Determining SDK version")
            version_pattern = r"(\d+\.)?(\d+\.)?(\d+)(-\w+)?"  # see https://docs.oracle.com/middleware/1212/core/MAVEN/maven_version.htm#MAVEN8855 for more information
            tmp_version = self.properties['SDKVersion']
            build_number = os.getenv("CIRCLE_BUILD_NUM", 0)
            branch_name = self.check_shell_command_output("git rev-parse --abbrev-ref HEAD")
            if branch_name and re.match(version_pattern, branch_name):
                self.is_release = True
                if tmp_version:
                    self.version = tmp_version
                else:
                    self.version = branch_name
            else:
                snapshot_version_pattern = r"(\d+\.)?(\d+\.)?(\d+)(-\w+)?(-\d+)"
                if tmp_version and re.match(snapshot_version_pattern, tmp_version):
                    self.version = tmp_version
                else:
                    if tmp_version and re.match(version_pattern, tmp_version):
                        self.version = tmp_version + '-' + str(build_number)
                    else:
                        self.version = '0.0.0-' + str(build_number)
        return self.version

    def get_artifactory_username(self):
        if not self.artifactory_user:
            self.log_debug("Determining artifactory username")
            self.artifactory_user = os.getenv("ARTIFACTORY_USERNAME", "monty-bot")
        return self.artifactory_user

    def get_artifactory_api_key(self):
        if not self.artifactory_password:
            self.log_debug("Determining artifactory API key")
            self.artifactory_password = os.getenv("ARTIFACTORY_KEY", "")
        return self.artifactory_password

    def get_configuration_as_dictionary(self):
        return self.properties

    def load(self):
        self.log_debug("Loading SDK distribution configuration")
        property_file = PropertyFileParser(self, self.get_sdk_top_directory(), "gradle.properties", "=", "#")
        self.get_sdk_build_directory()
        property_file.load()
        self.check_platform()
        self.check_if_graddle_wrapper_exists()
        self.properties = property_file.get_properties()
        self.properties['SDKVersion'] = self.get_version()
        self.properties['artifactory_user'] = self.get_artifactory_username()
        self.properties['artifactory_password'] = self.get_artifactory_api_key()
        self.properties['artifactory_deployment_repository'] = self.get_publishing_repo()
