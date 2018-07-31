#!/usr/bin/python
import sdk_versioning


# Block in charge of versioning the SDK
class SDKVersioningRelease(sdk_versioning.SDKVersioning):
    def __init__(self, logger=None):
        super(SDKVersioningRelease, self).__init__(logger)
        self.should_bump = True
        self.set_value = self.common_config.get_config().get_forced_version_number()
