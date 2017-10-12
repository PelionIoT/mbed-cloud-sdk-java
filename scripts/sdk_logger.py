import time
import os

# Logger: messages are ouput to stdout  as well as logged in a file

# print colour schemes
NORMAL_COLOUR = '\033[0m'
ERROR_COLOUR = '\033[91;1m'
WARNING_COLOUR = '\033[93;1m'
SUCCESS_COLOUR = '\033[32m'
INFO_COLOUR = '\033[94m'


class DefaultLogger:
    instance = None

    def __init__(self, action):
        if (not DefaultLogger.instance) or (DefaultLogger.instance.action != action):
            DefaultLogger.instance = Logger(False, True, None, action)

    def getLogger(self):
        return DefaultLogger.instance


class Logger:
    def __init__(self, show_debug, print_messages, log_filename, action):
        self.is_debug_enabled = show_debug
        self.log_file_name = log_filename if log_filename else self._get_default_log_file(
            self.convert_to_snake(action))
        self.log_file = open(self.log_file_name, 'w+', 1)
        self.are_messages_printed = print_messages
        self.action = action

    def convert_to_snake(self, name):
        if not name:
            return name
        return name.lower().replace(" ", "_")

    def _get_default_log_folder(self):
        log_folder = os.path.join(os.getcwd(), 'build_logs')
        if not (os.path.exists(log_folder)):
            os.makedirs(log_folder)
        return log_folder

    def _get_default_log_file(self, action):
        log_date = time.strftime('%Y-%m-%d_%H-%M-%S')
        log_file_name_prefix = 'sdk_build'
        if action:
            log_file_name_prefix = action
        extension = 'log'
        log_file_name = str(log_file_name_prefix) + '_' + str(log_date) + '.' + str(extension)
        log_folder = self._get_default_log_folder()
        self._remove_previous_log_files_if_any(log_folder, log_file_name_prefix, extension)
        return os.path.join(log_folder, log_file_name)

    def _remove_previous_log_files_if_any(self, file_folder, file_name, ext):
        if file_name and file_folder and ext:
            for root, dirs, files in os.walk(file_folder):
                for file in files:
                    if (file_name in file) and (ext in file):
                        os.remove(os.path.join(root, file))

    def _log_to_file(self, msg):
        if msg and self.log_file:
            self.log_file.write(str(msg) + os.linesep)

    def _log_and_print(self, msg_colour, msg, show, no_colour=False):
        if msg:
            self._log_to_file(msg)
            if show:
                if self.are_messages_printed:
                    self._print_to_console(msg_colour, msg, no_colour)

    def _remove_carriage_return(self, msg):
        if msg:
            msg = msg.rstrip('\r\n')
            msg = msg.rstrip('\n')
            msg = msg.rstrip('\r')
            msg = msg.rstrip('\n')
        return msg

    def _print_to_console(self, msg_colour, msg, no_colour=False):
        msg = self._remove_carriage_return(msg)
        if no_colour:
            print(str(msg))
        else:
            colour = msg_colour if msg_colour else NORMAL_COLOUR
            print(colour + str(msg) + NORMAL_COLOUR)

    def print_log_file_location(self):
        self._print_to_console(INFO_COLOUR, 'Arm Mbed Cloud SDK build log file: ' + str(self.log_file_name))

    def print_info_to_console(self, message):
        self._print_to_console(INFO_COLOUR, message)

    def print_message_to_console(self, message):
        self._print_to_console(NORMAL_COLOUR, message)

    # Stop Logger
    def stop(self):
        if self.log_file:
            self.log_file.close()
            self.log_file = None

    # Output a banner around a message
    def print_banner(self, msg):
        self.output_message("--------------------------------------------------")
        self.output_message(msg)
        self.output_message("--------------------------------------------------")

    # Output an error message
    def output_error(self, msg, no_colour=False):
        self._log_and_print(ERROR_COLOUR, msg, True, no_colour)

    # Output a success message
    def output_success_message(self, msg, no_colour=False):
        self._log_and_print(SUCCESS_COLOUR, msg, True, no_colour)

    # Output a warning message
    def output_warning(self, msg, no_colour=False):
        self._log_and_print(WARNING_COLOUR, msg, True, no_colour)

    # Output a message
    def output_message(self, msg, no_colour=False):
        self._log_and_print(NORMAL_COLOUR, msg, True, no_colour)

    # Output a debug message, if enabled
    def output_debug_message(self, msg, no_colour=False):
        self._log_and_print(NORMAL_COLOUR, msg, self.is_debug_enabled, no_colour)
