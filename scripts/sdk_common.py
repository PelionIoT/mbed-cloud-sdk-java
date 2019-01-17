#!/usr/bin/python
import os
import re
import shutil
import subprocess
import sys
# import zipfile
from collections import OrderedDict

import sdk_logger
import signal


# Generic class defining an action e.g. process spawning...
class Action(object):
    def __init__(self, name, logger=None):
        self.module_name = name
        self.logger = logger if logger else sdk_logger.DefaultLogger(name).getLogger()
        self.last_spawned_subprocess = None

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

    def log_info(self, message, no_colour=False):
        self.logger.output_message(message, no_colour)

    def log_debug(self, message):
        self.logger.output_debug_message("DEBUG [Module: " + str(self.module_name) + "]: " + str(message))

    def log_success(self, message):
        self.logger.output_success_message("SUCCESS [Module: " + str(self.module_name) + "]: " + str(message))

    def register_callback_on_exit(self, callback):
        this = self

        def notify_subprocess_exit(signum, frame):
            this.log_info("The following signal was received: [" + str(signal.Signals(signum).name) + "]")
            this.log_info("Telling spawned subprocesses to die if any")
            if this.last_spawned_subprocess:
                this.log_info("Terminating subprocess [" + str(this.last_spawned_subprocess.pid) + "]")
                try:
                    this.last_spawned_subprocess.terminate()
                except:
                    this.log_warning("Failed terminating subprocess [" + str(this.last_spawned_subprocess.pid) + "]")
                    try:
                        this.last_spawned_subprocess.kill()
                    except:
                        this.log_warning("Failed killing subprocess [" + str(this.last_spawned_subprocess.pid) + "]")
                this.last_spawned_subprocess = None
            if callback:
                callback()

        signal.signal(signal.SIGINT, notify_subprocess_exit)
        signal.signal(signal.SIGILL, notify_subprocess_exit)
        signal.signal(signal.SIGTERM, notify_subprocess_exit)
        signal.signal(signal.SIGABRT, notify_subprocess_exit)
        signal.signal(signal.SIGFPE, notify_subprocess_exit)
        signal.signal(signal.SIGSEGV, notify_subprocess_exit)

    def call_command(self, args, directory=None, show_output_asap=False, use_shell=True, env=None):
        return self._spawn_command(True, args, directory, show_output_asap, use_shell, env)

    def call_command_with_retries(self, retries, args, directory=None, show_output_asap=False, use_shell=True,
                                  env=None):
        remaining_retries = retries
        return_code_int = 0
        while (remaining_retries > 0):
            try:
                return_code_int = self.call_command(args, directory, show_output_asap, use_shell, env)
                if return_code_int != 0:
                    raise Exception('Failure', return_code_int)
                else:
                    break
            except:
                self.log_error(
                    'Attempt [%s] to execute %s failed' % (str(retries - remaining_retries + 1), str(args)))
                if remaining_retries == 0:
                    return return_code_int
                remaining_retries -= 1
                self.log_info("Remaining attempts: %s" % str(remaining_retries))
        return return_code_int

    def _spawn(self, debug, args, use_shell=True, env=None, **kwargs):
        if not env:
            env = os.environ
        process = subprocess.Popen(args, stdout=subprocess.PIPE, shell=use_shell, universal_newlines=True, env=env,
                                   **kwargs)
        self.last_spawned_subprocess = process
        output, err = process.communicate()
        retcode = process.poll()
        if debug:
            if output:
                self.log_debug('Command output: ' + output)
            if err:
                self.log_debug('Command error message: ' + err)
        return retcode

    def _spawn_command_with_output_alternative(self, args, directory, use_shell=True, env=None):
        if not env:
            env = os.environ
        p = subprocess.Popen(args, shell=use_shell, stdout=subprocess.PIPE, stderr=subprocess.STDOUT,
                             universal_newlines=True, cwd=directory, bufsize=1, env=env)
        self.last_spawned_subprocess = p
        while True:
            line = p.stdout.readline()
            if line == '' and p.poll() is not None:
                break
            if line:
                self.log_info(line)
        rc = p.poll()
        return rc

    def _spawn_command_with_output(self, args, directory, use_shell=True, env=None):
        if not env:
            env = os.environ
        try:
            with subprocess.Popen(args, shell=use_shell, stdout=subprocess.PIPE, stderr=subprocess.STDOUT,
                                  universal_newlines=True, cwd=directory, bufsize=1, env=env) as p:
                self.last_spawned_subprocess = p
                for line in p.stdout:
                    self.log_info(line)
            return p.returncode if 'returncode' in dir(p) else p.poll()
        except:
            return self._spawn_command_with_output_alternative(args, directory, use_shell, env)

    # The following method was introduced in order to work using either python 2.7 or python 3 and above
    def _spawn_command(self, debug, args, directory, show_output_asap, use_shell=True, env=None):
        if args:
            return_code = 1
            # Convert args list to single string (required for any commands using pipes or shell builtins)
            if use_shell:
                args = ' '.join(args)
            if not directory:
                directory = os.getcwd()
            if not env:
                env = os.environ
            if debug:
                self.log_debug("Executing: " + str(args) + " in directory [" + str(directory) + "]")
            try:
                if show_output_asap:
                    return_code = self._spawn_command_with_output(args, directory, use_shell, env)
                else:
                    proc = subprocess.run(args, shell=use_shell, stdout=subprocess.PIPE, timeout=None, check=False,
                                          stderr=subprocess.STDOUT, universal_newlines=True, cwd=directory, env=env)
                    return_code = proc.returncode
                    output = proc.stdout
                    err = proc.stderr
                    if debug:
                        if output:
                            self.log_debug('Command output: ' + output)
                        if err:
                            self.log_debug('Command error message: ' + err)

            except AttributeError:
                return_code = self._spawn(debug, args, use_shell, stderr=subprocess.STDOUT, cwd=directory, env=env)
            if debug:
                self.log_debug("Command return code: " + str(return_code))
            self.last_spawned_subprocess = None
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

    def check_command_output_with_retries(self, retries, args, directory=None):
        remaining_retries = retries
        while (remaining_retries > 0):
            try:
                self.check_command_output(args, directory)
                break
            except:
                self.log_error(
                    'Attempt [%s] to execute %s failed' % (str(retries - remaining_retries + 1), str(args)))
                if remaining_retries == 0:
                    raise Exception()
                remaining_retries -= 1
                self.log_info("Remaining attempts: %s" % str(remaining_retries))

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

    def execute_command_output(self, command, directory=None):
        if not directory:
            directory = os.getcwd()
        if command:
            try:
                self.log_debug("Executing: " + str(command) + " in directory [" + str(directory) + "]")
                result = \
                    subprocess.Popen(command, stdout=subprocess.PIPE, universal_newlines=True, stderr=subprocess.STDOUT,
                                     shell=True, cwd=directory).communicate()[0]
                result = subprocess.check_output(result, stderr=subprocess.STDOUT, shell=True, universal_newlines=True,
                                                 cwd=directory)
                self.log_debug("Command Output: " + str(result))
                return result
            except subprocess.CalledProcessError as e:
                self.log_error_without_getting_cause(e.output)
        return None


class GitAction(Action):
    def __init__(self, name, logger=None):
        super(GitAction, self).__init__(name, logger)

    def __clean_git_command_result(self, result):
        return result.strip().strip(os.linesep) if result else None

    def git_fetch_a_commit_attached_tag(self, hash):
        if not hash:
            return None
        try:
            if not self.fetched_all_tags:
                try:
                    self.fetched_all_tags = True
                    self.check_shell_command_output(
                        "git fetch --tags --force")
                except:
                    pass
            return self.__clean_git_command_result(self.check_shell_command_output(
                "git describe --tags --exact-match %s" % hash))
        except:
            return None

    def git_origin_url(self):
        return self.check_shell_command_output("git remote get-url origin")

    def git_email(self):
        return self.check_shell_command_output("git config --get user.email")

    def git_username(self):
        return self.check_shell_command_output("git config --get user.name")

    def git_branch_name(self):
        return self.__clean_git_command_result(self.check_shell_command_output("git rev-parse --abbrev-ref HEAD"))

    def git_commit_hash(self):
        return self.__clean_git_command_result(self.check_shell_command_output("git rev-parse HEAD"))

    def git_commit_count(self):
        return self.__clean_git_command_result(self.check_shell_command_output("git rev-list --count HEAD"))

    def git_merge(self, branch):
        self.execute_command_output(['git', 'merge', branch])

    def git_previous_commit_hash(self, current_hash):
        return self.__clean_git_command_result(self.check_shell_command_output(
            "git rev-list --parents -n 1 %s" % str(current_hash))).split(" ")[0]

    def git_branch_point(self, commit1, commit2):
        return self.__clean_git_command_result(self.check_shell_command_output(
            "git merge-base %s %s" % (str(commit1), str(commit2))))

    # the output of the git command looks like:
    # 'A       docs/news/789.feature'
    def git_changes(self, commit1, commit2, dir=None):
        diff_command = "git diff %s...%s --name-status" % (commit1, commit2)
        if dir:
            diff_command = "%s %s" % (diff_command, dir)
        return self.check_shell_command_output(diff_command)

    def git_changes_list(self, change_type, commit1, commit2, dir=None):
        file_diff = self.get_changes(commit1, commit2, dir)
        return [(line.strip()[len(change_type):]).strip() for line in file_diff.splitlines() if
                line.lower().strip().startswith(change_type)]

    def git_current_changes(self):
        return self.check_shell_command_output("git status --porcelain")

    def git_current_changes_list(self, change_type):
        changes = self.git_current_changes()
        return [(line.strip()[len(change_type):]).strip() for line in changes.splitlines() if
                line.lower().strip().startswith(change_type)]

    def git_setup_env(self):
        self.check_shell_command_output("git config --global user.name monty-bot")
        self.check_shell_command_output("git config --global user.email monty-bot@arm.com")

    def git_set_remote_url(self, url):
        self.check_shell_command_output("git remote set-url origin %s" % url)

    def git_set_upstream_branch(self, branch_name):
        self.check_shell_command_output("git branch --set-upstream-to origin/%s" % branch_name)

    def git_add_file(self, file):
        if file:
            self.check_shell_command_output("git add %s" % file.strip())

    def git_add_folder(self, folder):
        if folder:
            folder = folder.strip()
            if not folder.endswith("/"):
                folder += "/"
            folder += "*"
            self.git_add_file(folder)

    def git_commit(self, message):
        self.check_shell_command_output("git commit -m '%s'" % message)

    def git_tag(self, tag, message):
        self.check_shell_command_output("git tag -a %s -m '%s'" % (tag, message))

    def git_soft_tag(self, tag):
        self.check_shell_command_output("git tag -f %s" % tag)

    def git_push_and_follow_tags(self):
        self.check_shell_command_output("git push --follow-tags")

    def git_force_push_tags(self):
        self.check_shell_command_output("git push -f --tags")


# Note: Each build action to perform during Sdk distribution build or deployment is defined as a separate object (e.g. release configuration, distribution build, deployment, etc)
# Generic class defining a build step block part of SDK build
class BuildStep(GitAction):
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

    def ping_host(self, host):
        if not host:
            return False
        arguments = ['ping', '-w', '2', host]
        try:
            return self.call_command(arguments) == 0
        except:
            return False

    def zip_directory_content(self, path, zip_name):
        shutil.make_archive(zip_name, 'zip', path)
        # with zipfile.ZipFile(zip_name, 'w', zipfile.ZIP_DEFLATED) as zf:
        #     for root, dirs, files in os.walk(path):
        #         for file in files:
        #             zf.write(os.path.join(root, file))

    def clean_path(self, path_value, with_quotes=True, replace_separator=True):
        if not path_value:
            return None
        path = str(path_value)
        path = path.replace("\\\\", "\\").replace("\\:", ":")
        path = path.replace("\\\\", "\\")
        path = path.replace('\n', '')
        path = path.replace('\r', '')
        if replace_separator:
            path = path.replace('\\', '/')
        if with_quotes:
            path = "\"" + str(path) + "\""
        return path


class BuildStepUsingGradle(BuildStep):
    def __init__(self, name, logger, dir=None):
        super(BuildStepUsingGradle, self).__init__(name, logger)
        self.gradle_directory = os.path.normpath(os.path.realpath(self.top_directory)) if not dir else dir
        self.reset()

    def reset(self):
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

    def execute_gradle_task(self, task, params=None):
        arguments = [self.graddle_command, task]
        if self.common_config.get_config().is_running_on_windows():
            # Disabling the daemon on windows
            arguments = arguments + ['--no-daemon']
        if params:
            arguments = arguments + params
        self.check_command_output(arguments, self.gradle_directory)

    def execute_gradle_task_with_retries(self, retries, task, params=None):
        remaining_retries = retries
        while (remaining_retries >= 0):
            try:
                self.execute_gradle_task(task, params)
                break
            except:
                self.log_error(
                    'Attempt [%s] to execute %s failed' % (str(retries - remaining_retries + 1), task))
                if remaining_retries == 0:
                    raise Exception()
                remaining_retries -= 1
                self.log_info("Remaining attempts: %s" % str(remaining_retries))

    def execute_gradle_task_overriding_variable(self, task, variable_name, variable_value):
        arguments = [self.graddle_command, "-P" + str(variable_name) + "=" + str(variable_value), task]
        self.check_command_output(arguments, self.gradle_directory)


# Generic class looking for files in project
class ProjectBrowser(object):
    def __init__(self, module, top_dir):
        self.top_dir = top_dir
        self.module = module

    def find_all_files(self, pattern):
        if not pattern:
            return []
        list = []
        if self.top_dir and os.path.exists(self.top_dir):
            for root, dirs, files in os.walk(self.top_dir):
                for file in files:
                    if pattern in file:
                        list.append(os.path.join(root, file))
        return list


# Generic class defining an object which finds a configuration file
class ConfigurationFileFinder(ProjectBrowser):
    def __init__(self, module, top_dir, file_name):
        super(ConfigurationFileFinder, self).__init__(module, top_dir)
        self.file_name = file_name
        self.found_file = None
        self.found_directory = None

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

    def get_property(self, key):
        if not key:
            return None
        try:
            return self.get_properties()[key]
        except:
            return None


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
class Config(GitAction):
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
        self.from_private = False
        self.artifactory_url = None
        self.artifactory_host = None
        self.testrunner_image = None
        self.origin_url = None
        self.code_coverage = None
        self.disable_artifactory = None
        self.branch_name = None
        self.cloud_host = None
        self.lab_api_key = None
        self.prod_api_key = None
        self.sdk_example_dir = None
        self.sdk_foundation_generator_dir = None
        self.bintray_user = None
        self.bintray_password = None
        self.maven_central_user = None
        self.maven_central_password = None
        self.user_name = None
        self.user_email = None
        self.commit_hash = None
        self.previous_commit_hash = None
        self.commit_tag = None
        self.forced_version_number = None
        self.testing_parameters = None
        self.code_coverage_files_directory = None
        self.github_token = None
        self.git_url_with_token = None
        self.fetched_all_tags = False
        self.slack_token = None
        self.slack_channel = None
        self.generated_code_dirs = None
        self.api_configuration_dir = None
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

    def get_sdk_foundation_generation_directory(self):
        if not self.sdk_foundation_generator_dir:
            self.log_debug("Determining SDK foundation generator directory")
            top_dir = self.get_sdk_top_directory()
            if top_dir:
                generator_dir = os.path.normpath(os.path.realpath(os.path.join(top_dir, 'foundation-generator')))
            if os.path.exists(generator_dir) and os.path.isdir(generator_dir):
                self.sdk_foundation_generator_dir = generator_dir
        return self.sdk_foundation_generator_dir

    def get_sdk_example_directory(self):
        if not self.sdk_example_dir:
            self.log_debug("Determining SDK examples directory")
            top_dir = self.get_sdk_top_directory()
            if top_dir:
                example_dir = os.path.normpath(os.path.realpath(os.path.join(top_dir, 'examples')))
                if os.path.exists(example_dir) and os.path.isdir(example_dir):
                    self.sdk_example_dir = example_dir
        return self.sdk_example_dir

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

    def get_news_folder(self):
        return self.properties['newsFolder']

    def get_changelog_file(self):
        return self.properties['changelogFile']

    def get_docker_compose_file(self):
        return self.properties['dockerComposeFile']

    def get_project_property_file(self):
        return "gradle.properties"

    def is_for_release(self):
        return self.is_release

    def is_from_private(self):
        self.get_origin_url()
        return self.from_private

    def is_running_on_windows(self):
        return self.on_windows

    def check_platform(self):
        self.on_windows = sys.platform.startswith('win')

    def get_branch_name(self):
        if not self.branch_name:
            self.log_debug("Determining branch name")
            try:
                self.branch_name = self.git_branch_name()
            except:
                self.branch_name = None
        return self.branch_name

    def get_commit_hash(self):
        if not self.commit_hash:
            self.log_debug("Determining commit hash")
            try:
                self.commit_hash = self.git_commit_hash()
            except:
                self.commit_hash = None
        return self.commit_hash

    def get_previous_commit_hash(self):
        if not self.previous_commit_hash:
            self.log_debug("Determining previous commit hash")
            current_hash = self.get_commit_hash()
            if current_hash:
                try:
                    self.previous_commit_hash = self.git_previous_commit_hash(current_hash)
                except:
                    self.previous_commit_hash = None
        return self.previous_commit_hash

    def get_commit_tag(self):
        if not self.commit_tag:
            self.log_debug("Determining commit tag")
            hash = self.get_commit_hash()
            if hash:
                self.commit_tag = self.git_fetch_a_commit_attached_tag(hash)
        return self.commit_tag

    def is_commit_tagged(self):
        return self.get_commit_tag() is not None

    def get_user_name(self):
        if not self.user_name:
            self.log_debug("Determining user name")
            try:
                self.user_name = self.git_username()
            except:
                self.user_name = None
        return self.user_name

    def get_user_email(self):
        if not self.user_email:
            self.log_debug("Determining user email")
            try:
                self.user_email = self.git_email()
            except:
                self.user_email = None
        return self.user_email

    def get_origin_url(self):
        if not self.origin_url:
            self.log_debug("Determining remote repository URL")
            try:
                self.origin_url = self.git_origin_url()
                if self.origin_url and "private" in self.origin_url.strip().lower():
                    self.from_private = True
            except:
                self.origin_url = None
        return self.origin_url

    def get_origin_url_combined_with_token(self):
        if not self.git_url_with_token:
            self.log_debug("Determining remote repository URL with token")
            url = self.get_origin_url()
            token = self.get_github_token()
            if not url or not token:
                return None
            path = url.split('github.com', 1)[1][1:].strip()
            new = 'https://{GITHUB_TOKEN}@github.com/%s' % path
            self.git_url_with_token = new.format(GITHUB_TOKEN=token)
        return self.git_url_with_token

    def get_version(self):
        if not self.version:
            self.log_debug("Determining SDK version")
            version_pattern = r"^(\d+\.)?(\d+\.)?(\d+)$"  # see https://docs.oracle.com/middleware/1212/core/MAVEN/maven_version.htm#MAVEN8855 for more information
            tmp_version = self.properties['SDKVersion']
            branch_name = self.get_branch_name()
            self.is_release = False
            if branch_name and branch_name.lower().strip() != "master":
                if tmp_version:
                    snapshot_version = r"(\d+\.)?(\d+\.)?(\d+)(-\w+)(_\w*)"
                    if re.match(snapshot_version, tmp_version):
                        self.version = tmp_version
                    else:
                        self.version = tmp_version + "_" + branch_name.lower().strip().replace("-", "_")
                        if self.is_from_private():
                            self.version += "_private"
                else:
                    self.version = branch_name
            else:
                self.version = tmp_version
                if tmp_version and re.match(version_pattern, tmp_version):
                    self.is_release = True
                else:
                    if self.is_from_private():
                        self.version += "_private"
        return self.version

    def get_cached_testrunner_filename(self):
        return 'testrunner.tar'

    def get_cached_testserver_filename(self):
        return 'testserver.tar'

    def get_github_token(self):
        if not self.github_token:
            self.log_debug("Determining the GitHub token")
            self.github_token = os.getenv("GITHUB_TOKEN")
        return self.github_token

    def get_artifactory_username(self):
        if not self.artifactory_user:
            self.log_debug("Determining artifactory username")
            self.artifactory_user = os.getenv("ARTIFACTORY_USERNAME", "monty-bot")
        return self.artifactory_user

    def get_bintray_username(self):
        if not self.bintray_user:
            self.log_debug("Determining bintray username")
            self.bintray_user = os.getenv("BINTRAY_USERNAME", "monty-bot")
        return self.bintray_user

    def get_maven_central_username(self):
        if not self.maven_central_user:
            self.log_debug("Determining Maven Central username")
            self.maven_central_user = os.getenv("MAVEN_CENTRAL_USERNAME", "monty-bot")
        return self.maven_central_user

    def get_slack_token(self):
        if not self.slack_token:
            self.log_debug("Determining Slack token")
            # ways to generate tokens: https://api.slack.com/custom-integrations/legacy-tokens
            self.slack_token = os.getenv("SLACK_API_TOKEN")
        return self.slack_token

    def get_slack_channel(self):
        if not self.slack_channel:
            self.log_debug("Determining Slack channel")
            self.slack_channel = os.getenv("SLACK_CHANNEL", "#mbed-cloud-sdk")
        return self.slack_channel

    def get_artifactory_url(self):
        if not self.artifactory_url:
            self.log_debug("Determining artifactory url")
            tmp_url = self.properties['artifactory_contextUrl']
            self.artifactory_url = os.getenv("ARTIFACTORY_URL", tmp_url)
        return self.artifactory_url

    def get_artifactory_host(self):
        if not self.artifactory_host:
            url = self.get_artifactory_url()
            url_pattern = r"(https?\:\/\/)?([\w.]+)(\/\w+)*"
            if url and re.match(url_pattern, url):
                host_search = re.search(url_pattern, url)
                if host_search:
                    self.artifactory_host = host_search.group(2)
        return self.artifactory_host

    def get_artifactory_api_key(self):
        if not self.artifactory_password:
            self.log_debug("Determining artifactory API key")
            self.artifactory_password = os.getenv("ARTIFACTORY_KEY", "")
        return self.artifactory_password

    def get_bintray_api_key(self):
        if not self.bintray_password:
            self.log_debug("Determining bintray API key")
            self.bintray_password = os.getenv("BINTRAY_KEY", "")
        return self.bintray_password

    def get_maven_central_api_key(self):
        if not self.maven_central_password:
            self.log_debug("Determining Maven Central API key")
            self.maven_central_password = os.getenv("MAVEN_CENTRAL_KEY", "")
        return self.maven_central_password

    def get_testserver_docker_image(self):
        return 'sdk_test_server'

    def get_testrunner_docker_image(self):
        if not self.testrunner_image:
            self.log_debug("Determining test runner docker image")
            image = os.getenv("TESTRUNNER_DOCKER_IMAGE")
            # If the code correspond to a specific version (i.e. is tagged)
            # then the testrunner used for this version is retrieved.
            # Otherwise, the latest testrunner is used
            if image and not self.is_commit_tagged():
                self.testrunner_image = image
            else:
                container_path = self.properties['testrunner_container']
                testrunner_hash = self.properties['SDKTestrunnerVersion']
                if container_path and testrunner_hash:
                    self.testrunner_image = str(container_path) + ':' + str(testrunner_hash)
                else:
                    self.log_error_without_getting_cause(
                        "Information regarding the test runner image to use is missing")
                    self.log_info(
                        "Test runner image name [%s] | Test runner version [%s]" % (
                            str(container_path), str(testrunner_hash)))
        return self.testrunner_image

    def get_new_artifact_log_parser(self, module):
        return PropertyFileParser(module,
                                  self.get_sdk_top_directory(),
                                  "artifacts.properties", "=", "#")

    def should_perform_code_coverage(self):
        if not self.code_coverage:
            self.log_debug("Determining if code coverage should be performed")
            tmp_property = self.properties['codeCoverageOn']
            if not tmp_property or 'false' in tmp_property.lower():
                self.code_coverage = False
            else:
                self.code_coverage = True
        return self.code_coverage

    def get_code_coverage_file_directory(self):
        if not self.code_coverage_files_directory:
            self.code_coverage_files_directory = os.getenv("TEST_COVERAGE_DIR",
                                                           os.path.join(self.get_sdk_top_directory(), "coverage_files"))
        return self.code_coverage_files_directory

    def get_configuration_as_dictionary(self):
        return self.properties

    def is_testing_against_production(self):
        return os.getenv("IS_PRODUCTION_TESTING") is not None

    def get_testing_parameters(self, prod=False):
        if not self.testing_parameters:
            self.testing_parameters = {
                'MBED_CLOUD_SDK_API_KEY': self.get_apikey_prod() if self.is_testing_against_production() or prod else self.get_apikey_lab(),
                'MBED_CLOUD_SDK_HOST': '' if self.is_testing_against_production() or prod else self.get_host(),
                'TESTRUNNER_DOCKER_IMAGE': self.get_testrunner_docker_image() if len(
                    self.get_testrunner_docker_image()) > 0 else None
            }
        return self.testing_parameters

    def get_apikey_lab(self):
        if not self.lab_api_key:
            self.lab_api_key = os.getenv("MBED_CLOUD_SDK_API_KEY")
        return self.lab_api_key

    def get_apikey_prod(self):
        if not self.prod_api_key:
            self.prod_api_key = os.getenv("MBED_CLOUD_SDK_API_KEY_PROD")
        return self.prod_api_key

    def get_host(self):
        if not self.cloud_host:
            self.cloud_host = os.getenv("MBED_CLOUD_SDK_HOST")
        return self.cloud_host

    # Set the following environment variable if you want the SDK to have this specific version
    def get_forced_version_number(self):
        if not self.forced_version_number:
            self.forced_version_number = os.getenv("MBED_CLOUD_SDK_VERSION_TO_SET")
        return self.forced_version_number

    # Set the following to disable deployment to Artifactory
    def disable_artifactory_deployment(self):
        if not self.disable_artifactory:
            self.log_debug("Determining if code should be deployed to artifactory")
            tmp_property = self.properties['artifactory_disable_deploy']
            if not tmp_property or 'false' in tmp_property.lower():
                self.disable_artifactory = os.getenv("DISABLE_ARTIFACTORY") is not None
            else:
                self.disable_artifactory = True
        return self.disable_artifactory

    def load(self):
        self.log_debug("Loading SDK distribution configuration")
        property_file = PropertyFileParser(self, self.get_sdk_top_directory(), self.get_project_property_file(), "=",
                                           "#")
        self.get_sdk_build_directory()
        property_file.load()
        self.check_platform()
        self.check_if_graddle_wrapper_exists()
        self.properties = property_file.get_properties()
        self.properties['branch_name'] = self.get_branch_name()
        self.properties['SDKVersion'] = self.get_version()
        self.properties['artifactory_user'] = self.get_artifactory_username()
        self.properties['artifactory_password'] = self.get_artifactory_api_key()
        self.properties['bintray_user'] = self.get_bintray_username()
        self.properties['bintray_password'] = self.get_bintray_api_key()
        self.properties['maven_central_user'] = self.get_maven_central_username()
        self.properties['maven_central_password'] = self.get_maven_central_api_key()
        self.properties['artifactory_deployment_repository'] = self.get_publishing_repo()
        self.properties['artifactory_contextUrl'] = self.get_artifactory_url()
