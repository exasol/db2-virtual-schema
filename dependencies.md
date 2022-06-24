<!-- @formatter:off -->
# Dependencies

## Compile Dependencies

| Dependency                      | License          |
| ------------------------------- | ---------------- |
| [Virtual Schema Common JDBC][0] | [MIT License][1] |
| [error-reporting-java][2]       | [MIT][3]         |

## Test Dependencies

| Dependency                                      | License                                              |
| ----------------------------------------------- | ---------------------------------------------------- |
| [JaCoCo :: Agent][4]                            | [Eclipse Public License 2.0][5]                      |
| [Virtual Schema Common JDBC][0]                 | [MIT License][1]                                     |
| [udf-debugging-java][8]                         | [MIT][3]                                             |
| [Hamcrest][10]                                  | [BSD License 3][11]                                  |
| [JUnit Jupiter (Aggregator)][12]                | [Eclipse Public License v2.0][13]                    |
| [mockito-junit-jupiter][14]                     | [The MIT License][15]                                |
| [Test containers for Exasol on Docker][16]      | [MIT][3]                                             |
| [exasol-test-setup-abstraction-java][18]        | [MIT License][19]                                    |
| [Testcontainers :: JUnit Jupiter Extension][20] | [MIT][21]                                            |
| [Testcontainers :: JDBC :: DB2][20]             | [MIT][21]                                            |
| [Matcher for SQL Result Sets][24]               | [MIT][3]                                             |
| [Test Database Builder for Java][26]            | [MIT License][27]                                    |
| IBM Data Server Driver for JDBC and SQLJ        | [International Program License Agreement (IPLA)][28] |

## Runtime Dependencies

| Dependency                    | License                                                                                                        |
| ----------------------------- | -------------------------------------------------------------------------------------------------------------- |
| [JSON-P Default Provider][29] | [Eclipse Public License 2.0][30]; [GNU General Public License, version 2 with the GNU Classpath Exception][31] |

## Plugin Dependencies

| Dependency                                              | License                                        |
| ------------------------------------------------------- | ---------------------------------------------- |
| [SonarQube Scanner for Maven][32]                       | [GNU LGPL 3][33]                               |
| [Apache Maven Compiler Plugin][34]                      | [Apache License, Version 2.0][35]              |
| [Apache Maven Enforcer Plugin][36]                      | [Apache License, Version 2.0][35]              |
| [Maven Flatten Plugin][38]                              | [Apache Software Licenese][39]                 |
| [org.sonatype.ossindex.maven:ossindex-maven-plugin][40] | [ASL2][39]                                     |
| [Reproducible Build Maven Plugin][42]                   | [Apache 2.0][39]                               |
| [Maven Surefire Plugin][44]                             | [Apache License, Version 2.0][35]              |
| [Versions Maven Plugin][46]                             | [Apache License, Version 2.0][35]              |
| [Apache Maven Assembly Plugin][48]                      | [Apache License, Version 2.0][35]              |
| [Apache Maven JAR Plugin][50]                           | [Apache License, Version 2.0][35]              |
| [Artifact reference checker and unifier][52]            | [MIT][3]                                       |
| [Project keeper maven plugin][54]                       | [The MIT License][55]                          |
| [Apache Maven Dependency Plugin][56]                    | [Apache License, Version 2.0][35]              |
| [Maven Failsafe Plugin][58]                             | [Apache License, Version 2.0][35]              |
| [JaCoCo :: Maven Plugin][60]                            | [Eclipse Public License 2.0][5]                |
| [error-code-crawler-maven-plugin][62]                   | [MIT][3]                                       |
| [Maven Clean Plugin][64]                                | [The Apache Software License, Version 2.0][39] |
| [Maven Resources Plugin][66]                            | [The Apache Software License, Version 2.0][39] |
| [Maven Install Plugin][68]                              | [The Apache Software License, Version 2.0][39] |
| [Maven Deploy Plugin][70]                               | [The Apache Software License, Version 2.0][39] |
| [Maven Site Plugin 3][72]                               | [The Apache Software License, Version 2.0][39] |

[4]: https://www.eclemma.org/jacoco/index.html
[2]: https://github.com/exasol/error-reporting-java
[39]: http://www.apache.org/licenses/LICENSE-2.0.txt
[44]: https://maven.apache.org/surefire/maven-surefire-plugin/
[64]: http://maven.apache.org/plugins/maven-clean-plugin/
[3]: https://opensource.org/licenses/MIT
[14]: https://github.com/mockito/mockito
[38]: https://www.mojohaus.org/flatten-maven-plugin/
[46]: http://www.mojohaus.org/versions-maven-plugin/
[54]: https://github.com/exasol/project-keeper/
[11]: http://opensource.org/licenses/BSD-3-Clause
[34]: https://maven.apache.org/plugins/maven-compiler-plugin/
[27]: https://github.com/exasol/test-db-builder-java/blob/main/LICENSE
[5]: https://www.eclipse.org/legal/epl-2.0/
[18]: https://github.com/exasol/exasol-test-setup-abstraction-java/
[33]: http://www.gnu.org/licenses/lgpl.txt
[60]: https://www.jacoco.org/jacoco/trunk/doc/maven.html
[15]: https://github.com/mockito/mockito/blob/main/LICENSE
[24]: https://github.com/exasol/hamcrest-resultset-matcher
[42]: http://zlika.github.io/reproducible-build-maven-plugin
[19]: https://github.com/exasol/exasol-test-setup-abstraction-java/blob/main/LICENSE
[32]: http://sonarsource.github.io/sonar-scanner-maven/
[8]: https://github.com/exasol/udf-debugging-java/
[12]: https://junit.org/junit5/
[0]: https://github.com/exasol/virtual-schema-common-jdbc/
[29]: https://github.com/eclipse-ee4j/jsonp
[10]: http://hamcrest.org/JavaHamcrest/
[31]: https://projects.eclipse.org/license/secondary-gpl-2.0-cp
[66]: http://maven.apache.org/plugins/maven-resources-plugin/
[52]: https://github.com/exasol/artifact-reference-checker-maven-plugin
[50]: https://maven.apache.org/plugins/maven-jar-plugin/
[26]: https://github.com/exasol/test-db-builder-java/
[28]: https://www-40.ibm.com/software/sla/sladb.nsf/lilookup/1024954E51C94B03002587A4003CB520?OpenDocument
[58]: https://maven.apache.org/surefire/maven-failsafe-plugin/
[21]: http://opensource.org/licenses/MIT
[16]: https://github.com/exasol/exasol-testcontainers
[55]: https://github.com/exasol/project-keeper/blob/main/LICENSE
[56]: https://maven.apache.org/plugins/maven-dependency-plugin/
[30]: https://projects.eclipse.org/license/epl-2.0
[35]: https://www.apache.org/licenses/LICENSE-2.0.txt
[36]: https://maven.apache.org/enforcer/maven-enforcer-plugin/
[13]: https://www.eclipse.org/legal/epl-v20.html
[1]: https://github.com/exasol/virtual-schema-common-jdbc/blob/main/LICENSE
[68]: http://maven.apache.org/plugins/maven-install-plugin/
[40]: https://sonatype.github.io/ossindex-maven/maven-plugin/
[20]: https://testcontainers.org
[70]: http://maven.apache.org/plugins/maven-deploy-plugin/
[72]: http://maven.apache.org/plugins/maven-site-plugin/
[62]: https://github.com/exasol/error-code-crawler-maven-plugin
[48]: https://maven.apache.org/plugins/maven-assembly-plugin/
