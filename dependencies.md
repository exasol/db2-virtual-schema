<!-- @formatter:off -->
# Dependencies

## Compile Dependencies

| Dependency                      | License  |
| ------------------------------- | -------- |
| [Virtual Schema Common JDBC][0] | [MIT][1] |
| [error-reporting-java][2]       | [MIT][1] |

## Test Dependencies

| Dependency                                      | License                                              |
| ----------------------------------------------- | ---------------------------------------------------- |
| [JaCoCo :: Agent][4]                            | [Eclipse Public License 2.0][5]                      |
| [Virtual Schema Common JDBC][0]                 | [MIT][1]                                             |
| [udf-debugging-java][8]                         | [MIT][1]                                             |
| [Hamcrest][10]                                  | [BSD License 3][11]                                  |
| [JUnit Jupiter (Aggregator)][12]                | [Eclipse Public License v2.0][13]                    |
| [mockito-junit-jupiter][14]                     | [The MIT License][15]                                |
| [Test containers for Exasol on Docker][16]      | [MIT][1]                                             |
| [Testcontainers :: JUnit Jupiter Extension][18] | [MIT][19]                                            |
| [Testcontainers :: JDBC :: DB2][18]             | [MIT][19]                                            |
| [Matcher for SQL Result Sets][22]               | [MIT][1]                                             |
| [Test Database Builder for Java][24]            | [MIT License][25]                                    |
| IBM Data Server Driver for JDBC and SQLJ        | [International Program License Agreement (IPLA)][26] |

## Runtime Dependencies

| Dependency                    | License                                                                                                        |
| ----------------------------- | -------------------------------------------------------------------------------------------------------------- |
| [JSON-P Default Provider][27] | [Eclipse Public License 2.0][28]; [GNU General Public License, version 2 with the GNU Classpath Exception][29] |

## Plugin Dependencies

| Dependency                                              | License                           |
| ------------------------------------------------------- | --------------------------------- |
| [SonarQube Scanner for Maven][30]                       | [GNU LGPL 3][31]                  |
| [Apache Maven Compiler Plugin][32]                      | [Apache License, Version 2.0][33] |
| [Apache Maven Enforcer Plugin][34]                      | [Apache License, Version 2.0][33] |
| [Maven Flatten Plugin][36]                              | [Apache Software Licenese][37]    |
| [org.sonatype.ossindex.maven:ossindex-maven-plugin][38] | [ASL2][37]                        |
| [Reproducible Build Maven Plugin][40]                   | [Apache 2.0][37]                  |
| [Maven Surefire Plugin][42]                             | [Apache License, Version 2.0][33] |
| [Versions Maven Plugin][44]                             | [Apache License, Version 2.0][33] |
| [Apache Maven Assembly Plugin][46]                      | [Apache License, Version 2.0][33] |
| [Apache Maven JAR Plugin][48]                           | [Apache License, Version 2.0][33] |
| [Artifact reference checker and unifier][50]            | [MIT][1]                          |
| [Apache Maven Dependency Plugin][52]                    | [Apache License, Version 2.0][33] |
| [Maven Failsafe Plugin][54]                             | [Apache License, Version 2.0][33] |
| [JaCoCo :: Maven Plugin][56]                            | [Eclipse Public License 2.0][5]   |
| [Project keeper maven plugin][58]                       | [The MIT License][59]             |
| [error-code-crawler-maven-plugin][60]                   | [MIT][1]                          |
| [Apache Maven Clean Plugin][62]                         | [Apache License, Version 2.0][33] |
| [Apache Maven Resources Plugin][64]                     | [Apache License, Version 2.0][33] |
| [Apache Maven Install Plugin][66]                       | [Apache License, Version 2.0][37] |
| [Apache Maven Deploy Plugin][68]                        | [Apache License, Version 2.0][37] |
| [Apache Maven Site Plugin][70]                          | [Apache License, Version 2.0][33] |

[4]: https://www.eclemma.org/jacoco/index.html
[2]: https://github.com/exasol/error-reporting-java
[24]: https://github.com/exasol/test-db-builder-java/
[37]: http://www.apache.org/licenses/LICENSE-2.0.txt
[42]: https://maven.apache.org/surefire/maven-surefire-plugin/
[26]: https://www-40.ibm.com/software/sla/sladb.nsf/lilookup/1024954E51C94B03002587A4003CB520?OpenDocument
[1]: https://opensource.org/licenses/MIT
[14]: https://github.com/mockito/mockito
[54]: https://maven.apache.org/surefire/maven-failsafe-plugin/
[44]: http://www.mojohaus.org/versions-maven-plugin/
[58]: https://github.com/exasol/project-keeper/
[11]: http://opensource.org/licenses/BSD-3-Clause
[32]: https://maven.apache.org/plugins/maven-compiler-plugin/
[19]: http://opensource.org/licenses/MIT
[64]: https://maven.apache.org/plugins/maven-resources-plugin/
[0]: https://github.com/exasol/virtual-schema-common-jdbc
[25]: https://github.com/exasol/test-db-builder-java/blob/main/LICENSE
[62]: https://maven.apache.org/plugins/maven-clean-plugin/
[5]: https://www.eclipse.org/legal/epl-2.0/
[31]: http://www.gnu.org/licenses/lgpl.txt
[16]: https://github.com/exasol/exasol-testcontainers
[56]: https://www.jacoco.org/jacoco/trunk/doc/maven.html
[15]: https://github.com/mockito/mockito/blob/main/LICENSE
[22]: https://github.com/exasol/hamcrest-resultset-matcher
[40]: http://zlika.github.io/reproducible-build-maven-plugin
[52]: https://maven.apache.org/plugins/maven-dependency-plugin/
[59]: https://github.com/exasol/project-keeper/blob/main/LICENSE
[70]: https://maven.apache.org/plugins/maven-site-plugin/
[28]: https://projects.eclipse.org/license/epl-2.0
[30]: http://sonarsource.github.io/sonar-scanner-maven/
[33]: https://www.apache.org/licenses/LICENSE-2.0.txt
[34]: https://maven.apache.org/enforcer/maven-enforcer-plugin/
[8]: https://github.com/exasol/udf-debugging-java/
[13]: https://www.eclipse.org/legal/epl-v20.html
[66]: http://maven.apache.org/plugins/maven-install-plugin/
[12]: https://junit.org/junit5/
[38]: https://sonatype.github.io/ossindex-maven/maven-plugin/
[18]: https://testcontainers.org
[36]: https://www.mojohaus.org/flatten-maven-plugin/flatten-maven-plugin
[27]: https://github.com/eclipse-ee4j/jsonp
[10]: http://hamcrest.org/JavaHamcrest/
[29]: https://projects.eclipse.org/license/secondary-gpl-2.0-cp
[68]: http://maven.apache.org/plugins/maven-deploy-plugin/
[50]: https://github.com/exasol/artifact-reference-checker-maven-plugin
[60]: https://github.com/exasol/error-code-crawler-maven-plugin
[48]: https://maven.apache.org/plugins/maven-jar-plugin/
[46]: https://maven.apache.org/plugins/maven-assembly-plugin/
