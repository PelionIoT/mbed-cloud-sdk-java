#!/usr/bin/python
import sdk_common


# import json


# This module just dumps all distribution information into gradle.properties so that the build can later proceed with correct versioning and deployment repository

class SDKBuildPropertiesModifier(sdk_common.PropertyFileModifierOrCreatorIfMissing):
    def __init__(self, module, top_dir, properties_to_modify):
        super(SDKBuildPropertiesModifier, self).__init__(module, top_dir, 'gradle.properties', "=",
                                                         properties_to_modify)


class SDKDistributionSetter(sdk_common.BuildStep):
    def __init__(self, logger=None):
        super(SDKDistributionSetter, self).__init__("Distribution Setup", logger)

    def execute(self):
        return self.modify_sdk_property_file()

    def modify_sdk_property_file(self):
        self.print_title()
        try:
            configuration_values = self.common_config.get_config().get_configuration_as_dictionary()
            # print("configuration_values", json.dumps(configuration_values, indent=4))
            config_modifier = SDKBuildPropertiesModifier(self, self.top_directory, configuration_values)
            config_modifier.modify()
        except:
            self.log_error('Failed to modify SDK distribution information')
            return False
        return True
