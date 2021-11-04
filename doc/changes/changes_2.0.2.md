# Virtual Schema for DB2 2.0.2, released 2021-11-??

Code name: Fix quries error when selecting from non-default schema

## Summary

In this release we have fixed a problem when SELECT from a non-default schema returned an exception.

## Bug Fixes

* #15: Fixed a problem when SELECT from a non-default schema returned an exception.

## Dependency Updates

### Runtime Dependency Updates

* Removed `org.jacoco:org.jacoco.agent:0.8.7`

### Test Dependency Updates

* Added `org.jacoco:org.jacoco.agent:0.8.7`
* Updated `org.junit.jupiter:junit-jupiter:5.7.2` to `5.8.1`
* Updated `org.mockito:mockito-junit-jupiter:3.11.2` to `4.0.0`
* Updated `org.testcontainers:db2:1.16.0` to `1.16.2`
* Updated `org.testcontainers:junit-jupiter:1.16.0` to `1.16.2`

### Plugin Dependency Updates

* Updated `com.exasol:error-code-crawler-maven-plugin:0.5.1` to `0.4.0`
* Updated `com.exasol:project-keeper-maven-plugin:0.10.0` to `1.3.1`
