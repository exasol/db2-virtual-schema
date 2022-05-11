# Virtual Schema for DB2 2.0.3, released 2022-05-11

Code name: 2.0.3: Upgraded dependencies compared to 2.0.2

## Bugfixes

* #17: Upgraded dependencies to fix [CVE-2022-21724](https://ossindex.sonatype.org/vulnerability/0f319d1b-e964-4471-bded-db3aeb3c3a29?component-type=maven&component-name=org.postgresql.postgresql&utm_source=ossindex-client&utm_medium=integration&utm_content=1.1.1) in the PostgreSQL JDBC driver.

## Dependency Updates

### Compile Dependency Updates

* Updated `com.exasol:error-reporting-java:0.4.0` to `0.4.1`
* Updated `com.exasol:virtual-schema-common-jdbc:9.0.3` to `9.0.4`

### Runtime Dependency Updates

* Added `org.glassfish:jakarta.json:2.0.1`

### Test Dependency Updates

* Updated `com.exasol:exasol-testcontainers:4.0.0` to `6.1.1`
* Updated `com.exasol:hamcrest-resultset-matcher:1.4.1` to `1.5.1`
* Updated `com.exasol:test-db-builder-java:3.2.0` to `3.3.2`
* Updated `com.exasol:udf-debugging-java:0.4.0` to `0.6.1`
* Updated `com.exasol:virtual-schema-common-jdbc:9.0.3` to `9.0.4`
* Updated `com.ibm.db2:jcc:11.5.6.0` to `11.5.7.0`
* Updated `org.jacoco:org.jacoco.agent:0.8.7` to `0.8.8`
* Updated `org.junit.jupiter:junit-jupiter:5.8.1` to `5.8.2`
* Updated `org.mockito:mockito-junit-jupiter:4.0.0` to `4.5.1`
* Updated `org.testcontainers:db2:1.16.2` to `1.17.1`
* Updated `org.testcontainers:junit-jupiter:1.16.2` to `1.17.1`

### Plugin Dependency Updates

* Updated `com.exasol:artifact-reference-checker-maven-plugin:0.3.1` to `0.4.1`
* Updated `com.exasol:error-code-crawler-maven-plugin:0.4.0` to `1.1.1`
* Updated `com.exasol:project-keeper-maven-plugin:1.3.1` to `2.3.2`
* Updated `io.github.zlika:reproducible-build-maven-plugin:0.13` to `0.15`
* Updated `org.apache.maven.plugins:maven-clean-plugin:3.1.0` to `3.2.0`
* Updated `org.apache.maven.plugins:maven-compiler-plugin:3.8.1` to `3.10.1`
* Updated `org.apache.maven.plugins:maven-dependency-plugin:3.1.2` to `3.3.0`
* Updated `org.apache.maven.plugins:maven-enforcer-plugin:3.0.0-M3` to `3.0.0`
* Updated `org.apache.maven.plugins:maven-failsafe-plugin:3.0.0-M3` to `3.0.0-M6`
* Updated `org.apache.maven.plugins:maven-jar-plugin:3.2.0` to `3.2.2`
* Updated `org.apache.maven.plugins:maven-site-plugin:3.9.1` to `3.12.0`
* Updated `org.apache.maven.plugins:maven-surefire-plugin:3.0.0-M3` to `3.0.0-M6`
* Added `org.codehaus.mojo:flatten-maven-plugin:1.2.7`
* Updated `org.codehaus.mojo:versions-maven-plugin:2.8.1` to `2.10.0`
* Updated `org.jacoco:jacoco-maven-plugin:0.8.7` to `0.8.8`
* Added `org.sonarsource.scanner.maven:sonar-maven-plugin:3.9.1.2184`
* Updated `org.sonatype.ossindex.maven:ossindex-maven-plugin:3.1.0` to `3.2.0`
