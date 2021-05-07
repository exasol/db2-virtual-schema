# DB2 Virtual Schema

[![Build Status](https://api.travis-ci.com/exasol/db2-virtual-schema.svg?branch=main)](https://travis-ci.com/exasol/db2-virtual-schema)

SonarCloud results:

[![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=com.exasol%3Adb2-virtual-schema&metric=alert_status)](https://sonarcloud.io/dashboard?id=com.exasol%3Adb2-virtual-schema)

[![Security Rating](https://sonarcloud.io/api/project_badges/measure?project=com.exasol%3Adb2-virtual-schema&metric=security_rating)](https://sonarcloud.io/dashboard?id=com.exasol%3Adb2-virtual-schema)
[![Reliability Rating](https://sonarcloud.io/api/project_badges/measure?project=com.exasol%3Adb2-virtual-schema&metric=reliability_rating)](https://sonarcloud.io/dashboard?id=com.exasol%3Adb2-virtual-schema)
[![Maintainability Rating](https://sonarcloud.io/api/project_badges/measure?project=com.exasol%3Adb2-virtual-schema&metric=sqale_rating)](https://sonarcloud.io/dashboard?id=com.exasol%3Adb2-virtual-schema)
[![Technical Debt](https://sonarcloud.io/api/project_badges/measure?project=com.exasol%3Adb2-virtual-schema&metric=sqale_index)](https://sonarcloud.io/dashboard?id=com.exasol%3Adb2-virtual-schema)

[![Code Smells](https://sonarcloud.io/api/project_badges/measure?project=com.exasol%3Adb2-virtual-schema&metric=code_smells)](https://sonarcloud.io/dashboard?id=com.exasol%3Adb2-virtual-schema)
[![Coverage](https://sonarcloud.io/api/project_badges/measure?project=com.exasol%3Adb2-virtual-schema&metric=coverage)](https://sonarcloud.io/dashboard?id=com.exasol%3Adb2-virtual-schema)
[![Duplicated Lines (%)](https://sonarcloud.io/api/project_badges/measure?project=com.exasol%3Adb2-virtual-schema&metric=duplicated_lines_density)](https://sonarcloud.io/dashboard?id=com.exasol%3Adb2-virtual-schema)
[![Lines of Code](https://sonarcloud.io/api/project_badges/measure?project=com.exasol%3Adb2-virtual-schema&metric=ncloc)](https://sonarcloud.io/dashboard?id=com.exasol%3Adb2-virtual-schema)

# Overview

The **DB2 Virtual Schema** provides an abstraction layer that makes an external [DB2](https://www.ibm.com/db2/) accessible from an Exasol database through regular SQL commands. The contents of the external DB2 database are mapped to virtual tables which look like and can be queried as any regular Exasol table.

If you want to set up a Virtual Schema for a different database system, please head over to the [Virtual Schemas Repository][virtual-schemas].

## Features

* Access a DB2 database in read only mode from an Exasol database, using a Virtual Schema.

## Table of Contents

### Information for Users

* [Virtual Schemas User Guide][virtual-schemas-user-guide]
* [DB2 Dialect User Guide](doc/user_guide/db2_user_guide.md)
* [Changelog](doc/changes/changelog.md)
* [Dependencies](dependencies.md)

Find all the documentation in the [Virtual Schemas project][vs-doc].

## Information for Developers 

* [Virtual Schema API Documentation][vs-api]