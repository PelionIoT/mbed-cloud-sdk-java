#!/usr/bin/python
import sdk_common


# Block in charge of printing the help
class SDKHelp(sdk_common.BuildStep):
    def __init__(self, logger=None):
        super(SDKHelp, self).__init__('Help for Arm Mbed Cloud Java SDK', logger)
        self.action_list = []

    def set_action_list(self, action_list):
        self.action_list = action_list
        if self.action_list and 'sort' in dir(self.action_list):
            self.action_list.sort()

    def execute(self):
        self.print_title()
        self.log_info('Scripts to build the Java SDK')
        self.log_info('Please call one of the following build steps to be performed: ')
        self.log_info('             python sdk.py <build step>')
        for action in self.action_list:
            self.log_info('- ' + str(action))
        return True
