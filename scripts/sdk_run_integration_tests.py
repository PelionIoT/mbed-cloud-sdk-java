#!/usr/bin/python
import sdk_common
import yaml
import re
import uuid
import random
import os
import time


# Block in charge of running integration tests (using Docker compose)
class SDKIntegrationTestRunner(sdk_common.BuildStepUsingGradle):
    def __init__(self, logger=None):
        super(SDKIntegrationTestRunner, self).__init__('SDK integration tests runner', logger)
        self.pattern_environment_variable = re.compile(r"\$[\t ]*\{[\t ]*(?P<VALUE>[^\}\t ]+)[\t ]*\}")
        self.pattern_shell_command = re.compile(r"(?P<VALUE>\$[\t ]*\{[\t ]*[^\}\t ]+[\t ]*\})")
        self.environment_values = self.common_config.get_config().get_testing_parameters()
        self.docker_compose_file = self.common_config.get_config().get_docker_compose_file()

    def execute(self):
        self.print_title()
        try:
            self.log_info("Configure the docker compose file for this environment")
            self.modifying_docker_compose_file()
            # self.log_info("Building test server docker image")
            # arguments = ["docker-compose", "build"]
            # return_code = self.call_command(arguments, None, True)
            # if return_code != 0:
            #     raise Exception('Error code', return_code)
            starting_time = time.time()
            return_code_int = self.run_integration_tests(starting_time, 0)
            if return_code_int != 0:
                self.log_info("Trying to run the tests a second time")
                return_code_int = self.run_integration_tests(starting_time, return_code_int, False, True)
            if return_code_int != 0:
                self.log_info("Trying to run the tests a third time")
                return_code_int = self.run_integration_tests(starting_time, return_code_int)
            if return_code_int != 0:
                raise Exception('Integration tests have failed', return_code_int)
        except:
            self.log_error('Failed to successfully run all integration tests')
            return False
        self.log_info("Done.")
        return True

    def run_integration_tests(self, starting_time, previous_return_code_int, clean_at_the_end=True,
                              restart_services_at_the_end=False):
        if time.time() < starting_time + 80:
            self.gather_docker_information()
            self.log_info("Running integration tests")
            return_code_int = self.call_command(["docker-compose", "up", "--build", "--no-recreate", "--exit-code-from",
                                                 "testrunner"], None, True, True)
            self.gather_docker_information()
            if clean_at_the_end:
                self.log_info("Stopping any running containers")
                self.call_command(["docker-compose", "down", "--remove-orphans"], None, True, True)
                self.call_command(["docker-compose", "kill"], None, True, True)
            if restart_services_at_the_end:
                self.call_command(["docker-compose", "restart"], None, True, True)
            return return_code_int
        # The failure of the command comes from genuine test errors rather than docker issues
        else:
            return previous_return_code_int

    def gather_docker_information(self):
        self.log_info("Gathering information about docker images and containers")
        self.call_command(["docker", "ps"], None, True, True)
        self.call_command(["docker", "image", "ls"], None, True, True)
        self.call_command(["docker-compose", "top"], None, True, True)

    def modifying_docker_compose_file(self):
        if not self.docker_compose_file or not os.path.exists(self.docker_compose_file):
            raise Exception("Missing docker compose file [%s]" % str(self.docker_compose_file))
        with open(self.docker_compose_file, 'r') as f:
            cleansed_content = self.replace_environment_value(yaml.load(f))
            named_containers = self.name_containers(cleansed_content)
        if named_containers:
            with open(self.docker_compose_file, 'w') as f:
                f.write(yaml.dump(named_containers))

    def find_environment_variable_value(self, env_variable):
        command = '${%s}' % str(env_variable)
        if self.environment_values:
            replacement = self.environment_values.get(env_variable)
            if not replacement and type(replacement) is str:
                replacement = "''"
            return replacement if replacement  else command
        return command

    def replace_environment_value(self, obj):
        if not obj:
            return None
        if type(obj) is str:
            result = self.pattern_environment_variable.search(obj)
            replacement = str(obj)
            if result:
                for m in self.pattern_shell_command.finditer(obj):
                    command = m.group(0)
                    env_result = self.pattern_environment_variable.search(command)
                    env_variable = env_result.group('VALUE')
                    replacement = replacement.replace(command,
                                                      self.find_environment_variable_value(env_variable))
            return replacement
        elif type(obj) is list:
            return [self.replace_environment_value(a) for a in obj]
        elif type(obj) is dict:
            return {k: self.replace_environment_value(v) for k, v in obj.items()}
        else:
            return obj

    def add_name(self, ref, description):
        if type(description) is not dict:
            return description
        container_name = '%s_%s%s_%s' % (
            (str(ref)).strip().lower(), str(uuid.uuid1())[-4:].replace('-', ''),
            str(uuid.uuid4())[-4:].replace('-', ''), str(random.randint(1, 20)))
        description.update({'container_name': container_name})
        return description

    def name_containers(self, obj):
        if not obj:
            return None
        if type(obj) is not dict:
            return obj
        if not obj.get('version') and not obj.get('services'):
            # docker compose v1
            return {k: self.add_name(k, v) for k, v in obj.items()}
        else:  # docker compose v1 or v3
            obj['services'] = {k: self.add_name(k, v) for k, v in obj.get('services').items()}
            return obj
