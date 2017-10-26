#!/usr/bin/python
import sdk_common
import os
from xml.etree import ElementTree
from collections import OrderedDict
import json


# Block in charge of reporting general results
class SDKQualityReportBuilder(sdk_common.BuildStep):
    def __init__(self, logger=None):
        super(SDKQualityReportBuilder, self).__init__('SDK code quality summary', logger)
        self.artifacts_parser = sdk_common.PropertyFileParser(self,
                                                              self.common_config.get_config().get_sdk_top_directory(),
                                                              "artifacts.properties", "=", "#")

    def determine_coverage_result(self, path):
        if not path or not os.path.exists(path):
            return None
        tree = ElementTree.parse(path)
        ns = {'html': 'http://www.w3.org/1999/xhtml'}
        try:
            summary = tree.getroot().find('html:body', ns).find('html:table', ns).find('html:tfoot', ns).find('html:tr',
                                                                                                              ns)
        except:
            return None
        if len(summary) == 0:
            return None
        results = OrderedDict()
        for element in summary.findall('html:td', ns):
            if element.get('class') == "bar":
                results['Missed Instructions'] = element.text
            if element.get('class') == "ctr2":
                results['Coverage'] = element.text
            if len(results) == 2:
                return results
        return None

    def determine_unittest_result(self, path):
        if not path or not os.path.exists(path):
            return None
        tree = ElementTree.parse(path)
        try:
            summary = tree.getroot().find('body').find('div').find('div').find('table').find('tr')
            if len(summary) == 0:
                return None
            results = OrderedDict()
            for element in summary.findall('td'):
                for info in element.iter():
                    if info.get('class') and info.get('id'):
                        results[info.get('id')] = info[0].text
            return results if len(results) > 0 else None
        except:
            return None

    def determine_integration_test_result(self, path):
        if not path or not os.path.exists(path):
            return None
        tree = ElementTree.parse(path)
        try:
            summary = tree.getroot().attrib
            if not summary:
                return None
            results = OrderedDict()
            for k in summary:
                results[k] = summary[k]
            return results if len(results) > 0 else None
        except:
            return None

    def get_coverage_report_path(self):
        code_coverage_dir = self.clean_path(self.artifacts_parser.get_property('SDK_PROJECT_COVERAGE_REPORT_DIR'),
                                            False)
        if code_coverage_dir and os.path.exists(code_coverage_dir):
            return os.path.join(code_coverage_dir, "index.html")
        return None

    def get_unittest_report_path(self):
        unittest_dir = self.clean_path(self.artifacts_parser.get_property('SDK_UNITTEST_REPORT_DIR'),
                                       False)
        if unittest_dir and os.path.exists(unittest_dir):
            return os.path.join(unittest_dir, "index.html")
        return None

    def get_integration_report_path(self):
        test_report_files = sdk_common.ProjectBrowser(self,
                                                      self.common_config.get_config().get_sdk_top_directory()).find_all_files(
            'results.xml')
        if not test_report_files or len(test_report_files) == 0:
            return None
        return test_report_files[0]

    def determine_report_destination_path(self):
        report_name = "raw.json"
        report_dir = self.clean_path(self.artifacts_parser.get_property('SDK_REPORT_DIR'),
                                     False)
        if report_dir and os.path.exists(report_dir):
            return os.path.join(report_dir, report_name)
        else:
            return os.path.join(os.getcwd(), report_name)

    def execute(self):
        self.print_title()
        try:
            self.artifacts_parser.load()
            results = OrderedDict()
            self.log_info("Determining code coverage summary")
            coverage_path = self.get_coverage_report_path()
            code_coverage = self.determine_coverage_result(coverage_path)
            if code_coverage:
                results['Code coverage'] = code_coverage
            else:
                self.log_warning("No code coverage results were found at [" + str(coverage_path) + "]")
            self.log_info("Determining unit tests summary")
            test_path = self.get_unittest_report_path()
            unittests = self.determine_unittest_result(test_path)
            if unittests:
                results['Unit tests'] = unittests
            else:
                self.log_warning("No unit tests results were found at [" + str(test_path) + "]")
            self.log_info("Determining integration tests summary")
            test_path = self.get_integration_report_path()
            integrationtests = self.determine_integration_test_result(test_path)
            if integrationtests:
                results['Integration tests'] = integrationtests
            else:
                self.log_warning("No integration tests results were found at [" + str(test_path) + "]")

            jsonResults = json.dumps(results)
            dest = self.determine_report_destination_path()
            self.log_info("Generating report file [" + str(dest) + "]")
            with open(dest, 'w') as f:
                f.write(jsonResults)

        except:
            self.log_error('Failed to generate quality report')
            return False
        self.log_info("Done.")
        return True
