# DB2 Virtual Schemas 2.0.0, released 2021-??-??

Code name:

## Summary

The `SQL_DIALECT` property used when executing a `CREATE VIRTUAL SCHEMA` from the Exasol database is obsolete from this version. Please, do not provide this property anymore.

## Features / Enhancements

* 3: Unified error messages with `error-reporting-java` 

## Dependency Updates

### Compile Dependency Updates

* Updated `com.exasol:error-reporting-java:0.2.0` to 0.2.2
* Updated `com.exasol:virtual-schema-common-jdbc:8.0.0` to 9.0.1

### Runtime Dependency Updates

* Added `org.jacoco:org.jacoco.agent:0.8.6`

### Test Dependency Updates

* Added `com.exasol:exasol-testcontainers:3.5.1`
* Added `com.exasol:hamcrest-resultset-matcher:1.4.0`
* Added `com.exasol:test-db-builder-java:3.1.1`
* Added `com.exasol:udf-debugging-java:0.3.0`
* Updated `com.exasol:virtual-schema-common-jdbc:8.0.0` to 9.0.1
* Added `com.ibm.db2:jcc:11.5.5.0`
* Updated `org.junit.jupiter:junit-jupiter:5.7.0` to 5.7.1
* Updated `org.mockito:mockito-junit-jupiter:3.6.28` to 3.8.0
* Added `org.testcontainers:db2:1.15.2`
* Added `org.testcontainers:junit-jupiter:1.15.2`

### Plugin Dependency Updates

* Added `com.exasol:error-code-crawler-maven-plugin:0.1.1`
* Updated `com.exasol:project-keeper-maven-plugin:0.4.2` to 0.6.0
* Added `org.apache.maven.plugins:maven-dependency-plugin:2.8`
* Added `org.apache.maven.plugins:maven-failsafe-plugin:3.0.0-M3`