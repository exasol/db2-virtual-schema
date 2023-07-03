# Virtual Schema for DB2 2.1.2, released 2023-07-04

Code name: Dependency Upgrade

## Summary

This release fixes vulnerability CVE-2023-34462 regarding allocation of resources without limits or throttling by updating test dependency `io.netty:netty-handler`.

## Changes

* #26: Updated dependencies
## Dependency Updates

### Test Dependency Updates

* Updated `com.exasol:exasol-test-setup-abstraction-java:2.0.1` to `2.0.2`
* Updated `org.mockito:mockito-junit-jupiter:5.3.1` to `5.4.0`
* Updated `org.testcontainers:db2:1.18.0` to `1.18.3`
* Updated `org.testcontainers:junit-jupiter:1.18.0` to `1.18.3`
