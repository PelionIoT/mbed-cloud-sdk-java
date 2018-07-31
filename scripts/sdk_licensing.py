#!/usr/bin/python
import sdk_common
import shutil
import os
import glob
from functools import reduce
import json
import csv
from collections import OrderedDict


# Block in charge of licensing
class LicenceSetter(sdk_common.BuildStepUsingGradle):
    def __init__(self, logger=None):
        super(LicenceSetter, self).__init__('Licensing', logger)
        self.distribution_directory = reduce(lambda x, y: os.path.join(x, y),
                                             [self.top_directory, 'src', 'main', 'dist'])
        self.third_party_licences = os.path.join(self.distribution_directory, 'ThirdParty-Licences')
        self.tpip_csv_format = self.get_csv_format()

    def execute(self):
        self.print_title()
        try:
            self.log_info("Generating 3rd party licence documents")
            self.execute_gradle_task('jar')
            self.execute_gradle_task('dependencyLicenseReport')
            self.execute_gradle_task('downloadLicenses')
            self.log_info("Generating 3rd party reports")
            self.generating_tpip_reports()
            self.log_info("Integrating 3rd party licence documents")
            self.copy_third_party_directory()
            self.log_info("Integrating SDK distribution documentation and licence")
            self.copy_distribution_documentation()

        except:
            self.log_error('Failed to generate licence documentation')
            return False
        self.log_info("Done.")
        return True

    def copy_distribution_documentation(self):
        for filename in glob.glob(os.path.join(self.top_directory, '*.md')):
            shutil.copy2(filename, self.distribution_directory)
        licence_file = os.path.join(self.top_directory, 'LICENCE')
        if os.path.exists(licence_file):
            shutil.copy2(licence_file, self.distribution_directory)

    def copy_third_party_directory(self):
        licenses = reduce(lambda x, y: os.path.join(x, y), [self.build_directory, 'reports', 'dependency-license'])
        tpip_report = reduce(lambda x, y: os.path.join(x, y), [self.build_directory, 'reports', 'license'])
        if os.path.exists(self.third_party_licences):
            self.remove_path(self.third_party_licences, True)
        shutil.copytree(licenses, self.third_party_licences)
        for file in os.listdir(tpip_report):
            shutil.copy2(os.path.join(tpip_report, file), self.third_party_licences)
        for filename in glob.glob(os.path.join(self.third_party_licences, '*.jar')):
            self.remove_path(filename, True)

    def generating_tpip_reports(self):
        tpip_report = reduce(lambda x, y: os.path.join(x, y), [self.build_directory, 'reports', 'license'])
        for filename in glob.glob(os.path.join(tpip_report, '*.json')):
            self.generate_tpip_csv(filename)

    def generate_tpip_csv(self, file):
        with open(file, 'r') as json_data:
            data = json.load(json_data)
            if data.get('dependencies'):
                csv_file = os.path.join(os.path.dirname(file), os.path.splitext(os.path.basename(file))[0] + '.csv')
                columns = self.tpip_csv_format.keys()
                with open(csv_file, 'w') as tpip_csv:
                    csv_w = csv.writer(tpip_csv)
                    csv_w.writerow(columns)
                    used_packages = data.get('dependencies')
                    for used_package in used_packages:
                        csv_entries = self.fetch_csv_entries(used_package)
                        csv_w.writerow(map(lambda x: csv_entries.get(x, ""), columns))

    def fetch_csv_entries(self, package_json):
        csv_data = {}
        for key in self.tpip_csv_format.keys():
            csv_data[key] = self.tpip_csv_format[key](package_json) if self.tpip_csv_format[key] else None
        return csv_data

    def get_csv_format(self):
        return OrderedDict([('PkgName', lambda x: x['name'].split(':')[1]),
                            ('PkgType', lambda x: x['file']),
                            ('PkgOriginator', lambda x: x['name'].split(':')[0]),
                            ('PkgVersion', lambda x: x['name'].split(':')[2]),
                            ('PkgSummary', None),
                            ('PkgHomePageURL', None),
                            ('PkgLicense', lambda x: x['licenses'][0]['name']),
                            ('PkgLicenseURL', lambda x: x['licenses'][0]['url']),
                            ('PkgMgrURL', None)]
                           )
