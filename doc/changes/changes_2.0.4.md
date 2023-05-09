# Virtual Schema for DB2 2.0.4, released 2022-06-24

Code name: Update dependencies

## Summary

This release updates dependencies to fix the following vulnerabilities in transitive test dependencies:

* io.netty:netty-common:jar:4.1.72.Final:test
  * CVE-2022-24823
* io.netty:netty-handler:jar:4.1.72.Final:test
  * sonatype-2020-0026
* org.apache.xmlrpc:xmlrpc-common:jar:3.1.3:test
  * CVE-2016-5003
  * CVE-2016-5002
* commons-codec:commons-codec:jar:1.11:test
  * sonatype-2012-0050
* org.apache.xmlrpc:xmlrpc-client:jar:3.1.3:test
  * CVE-2016-5004

## Features

* #19: Updated dependencies

## Dependency Updates

### Compile Dependency Updates

* Updated `com.exasol:virtual-schema-common-jdbc:9.0.4` to `9.0.5`

### Test Dependency Updates

* Added `com.exasol:exasol-test-setup-abstraction-java:0.3.2`
* Updated `com.exasol:exasol-testcontainers:6.1.1` to `6.1.2`
* Updated `com.exasol:test-db-builder-java:3.3.2` to `3.3.3`
* Updated `com.exasol:udf-debugging-java:0.6.1` to `0.6.3`
* Updated `com.exasol:virtual-schema-common-jdbc:9.0.4` to `9.0.5`
* Updated `org.mockito:mockito-junit-jupiter:4.5.1` to `4.6.1`
* Updated `org.testcontainers:db2:1.17.1` to `1.17.2`
* Updated `org.testcontainers:junit-jupiter:1.17.1` to `1.17.2`

### Plugin Dependency Updates

* Updated `com.exasol:artifact-reference-checker-maven-plugin:0.4.1` to `0.4.0`
* Updated `com.exasol:project-keeper-maven-plugin:2.3.2` to `2.4.6`
* Updated `org.apache.maven.plugins:maven-clean-plugin:3.2.0` to `2.5`
* Updated `org.apache.maven.plugins:maven-deploy-plugin:2.8.2` to `2.7`
* Updated `org.apache.maven.plugins:maven-failsafe-plugin:3.0.0-M6` to `3.0.0-M5`
* Updated `org.apache.maven.plugins:maven-install-plugin:2.5.2` to `2.4`
* Updated `org.apache.maven.plugins:maven-resources-plugin:3.2.0` to `2.6`
* Updated `org.apache.maven.plugins:maven-site-plugin:3.12.0` to `3.3`
* Updated `org.apache.maven.plugins:maven-surefire-plugin:3.0.0-M6` to `3.0.0-M5`
