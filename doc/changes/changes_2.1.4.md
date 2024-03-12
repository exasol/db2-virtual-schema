# Virtual Schema for DB2 2.1.4, released 2024-03-12

Code name: Fixed vulnerabilities CVE-2024-25710 and CVE-2024-26308 in test dependencies

## Summary

This is a security release in which we updated test dependency `com.exasol:udf-debugging-java` to fix vulnerabilities CVE-2024-25710 and CVE-2024-26308 in its transitive dependencies.

## Security

* #32: Fixed vulnerabilities CVE-2024-25710 and CVE-2024-26308 in test dependency `org.apache.commons:commons-compress`

## Dependency Updates

### Compile Dependency Updates

* Updated `com.exasol:virtual-schema-common-jdbc:11.0.2` to `12.0.0`

### Test Dependency Updates

* Updated `com.exasol:exasol-testcontainers:6.6.2` to `7.0.1`
* Updated `com.exasol:hamcrest-resultset-matcher:1.6.1` to `1.6.5`
* Updated `com.exasol:test-db-builder-java:3.5.1` to `3.5.3`
* Updated `com.exasol:udf-debugging-java:0.6.11` to `0.6.12`
* Updated `com.exasol:virtual-schema-common-jdbc:11.0.2` to `12.0.0`
* Updated `com.ibm.db2:jcc:11.5.8.0` to `11.5.9.0`
* Updated `org.jacoco:org.jacoco.agent:0.8.10` to `0.8.11`
* Updated `org.junit.jupiter:junit-jupiter:5.10.0` to `5.10.2`
* Updated `org.mockito:mockito-junit-jupiter:5.5.0` to `5.11.0`
* Updated `org.slf4j:slf4j-jdk14:2.0.9` to `2.0.12`
* Updated `org.testcontainers:db2:1.19.0` to `1.19.7`
* Updated `org.testcontainers:junit-jupiter:1.19.0` to `1.19.7`

### Plugin Dependency Updates

* Updated `com.exasol:error-code-crawler-maven-plugin:1.3.0` to `2.0.1`
* Updated `com.exasol:project-keeper-maven-plugin:2.9.12` to `4.2.0`
* Updated `org.apache.maven.plugins:maven-compiler-plugin:3.11.0` to `3.12.1`
* Updated `org.apache.maven.plugins:maven-enforcer-plugin:3.4.0` to `3.4.1`
* Updated `org.apache.maven.plugins:maven-failsafe-plugin:3.1.2` to `3.2.5`
* Updated `org.apache.maven.plugins:maven-surefire-plugin:3.1.2` to `3.2.5`
* Added `org.apache.maven.plugins:maven-toolchains-plugin:3.1.0`
* Updated `org.codehaus.mojo:flatten-maven-plugin:1.5.0` to `1.6.0`
* Updated `org.codehaus.mojo:versions-maven-plugin:2.16.0` to `2.16.2`
* Updated `org.jacoco:jacoco-maven-plugin:0.8.10` to `0.8.11`
* Updated `org.sonarsource.scanner.maven:sonar-maven-plugin:3.9.1.2184` to `3.10.0.2594`
