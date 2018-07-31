#!/usr/bin/python
import sdk_common
import slackclient


# Block in charge of notifying of a new release
class ReleaseNotifier(sdk_common.BuildStep):
    def __init__(self, logger=None):
        super(ReleaseNotifier, self).__init__('Release notification', logger)
        self.token = self.common_config.get_config().get_slack_token()
        self.channel = self.common_config.get_config().get_slack_channel()
        self.version = self.common_config.get_config().get_version()
        self.should_notify_a_new_release = self.common_config.get_config().is_for_release() and not self.common_config.get_config().is_from_private()
        self.message = ":checkered_flag: New version of :java: Java SDK released: *{version}*"

    def execute(self):
        self.print_title()
        try:
            if self.should_notify_a_new_release:
                if not self.version:
                    raise Exception("The version is missing")
                if not self.token or not self.channel:
                    self.log_warning(
                        "Slack token or channel is not specified and therefore, no notification will be sent")
                    return True
                self.log_info("Announcing release [%s] on channel %s" % (str(self.version), str(self.channel)))
                payload = self.message.format(version=str(self.version))
                sc = slackclient.SlackClient(self.token)
                sc.api_call('chat.postMessage',
                            channel=str(self.channel),
                            text=payload, )
            else:
                self.log_info("This is not a new release")
        except:
            self.log_error('Failed to notify of a new release')
            return False
        self.log_info("Done.")
        return True

    def check_if_artifactory_is_accessible(self):
        return self.ping_host(self.host)
