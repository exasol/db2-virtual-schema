# DB2 Virtual Schemas 2.0.0, released 2021-05-12

Code name: Removed `SQL_DIALECT` property, JOIN pushdown

## Summary

In this release we have enabled pushdown for the JOIN. It means the JOIN queries with a lot of data should work much faster from now on.
Also, the `SQL_DIALECT` property used when executing a `CREATE VIRTUAL SCHEMA` from the Exasol database is obsolete from this version. Please, do not provide this property anymore.

## Features

* #3: Unified error messages with `error-reporting-java`. 
* #10: Enabled JOIN capabilities for the pushdown.
* #6: Added additional capabilities for scalar function: HOUR, INITCAP.

## Dependency Updates

### Compile Dependency Updates

* Updated `com.exasol:error-reporting-java:0.2.0` to `0.2.2`
* Updated `com.exasol:virtual-schema-common-jdbc:8.0.0` to `9.0.2`

### Runtime Dependency Updates

* Added `org.jacoco:org.jacoco.agent:0.8.7`

### Test Dependency Updates

* Added `com.exasol:exasol-testcontainers:3.5.1`
* Added `com.exasol:hamcrest-resultset-matcher:1.4.0`
* Added `com.exasol:test-db-builder-java:3.1.1`
* Added `com.exasol:udf-debugging-java:0.3.0`
* Updated `com.exasol:virtual-schema-common-jdbc:8.0.0` to `9.0.2`
* Added `com.ibm.db2:jcc:11.5.5.0`
* Updated `org.junit.jupiter:junit-jupiter:5.7.0` to `5.7.1`
* Updated `org.mockito:mockito-junit-jupiter:3.6.28` to `3.9.0`
* Added `org.testcontainers:db2:1.15.3`
* Added `org.testcontainers:junit-jupiter:1.15.3`

### Plugin Dependency Updates

* Added `com.exasol:error-code-crawler-maven-plugin:0.4.0`
* Updated `com.exasol:project-keeper-maven-plugin:0.4.2` to `0.7.0`
* Added `io.github.zlika:reproducible-build-maven-plugin:0.13`
* Updated `org.apache.maven.plugins:maven-clean-plugin:2.5` to `3.1.0`
* Added `org.apache.maven.plugins:maven-dependency-plugin:3.1.2`
* Updated `org.apache.maven.plugins:maven-deploy-plugin:2.7` to `2.8.2`
* Added `org.apache.maven.plugins:maven-failsafe-plugin:3.0.0-M3`
* Updated `org.apache.maven.plugins:maven-install-plugin:2.4` to `2.5.2`
* Updated `org.apache.maven.plugins:maven-jar-plugin:2.4` to `3.2.0`
* Updated `org.apache.maven.plugins:maven-resources-plugin:2.6` to `3.2.0`
* Updated `org.apache.maven.plugins:maven-site-plugin:3.3` to `3.9.1`
* Updated `org.codehaus.mojo:versions-maven-plugin:2.7` to `2.8.1`
* Updated `org.jacoco:jacoco-maven-plugin:0.8.5` to `0.8.7`
