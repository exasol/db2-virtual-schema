<!-- @formatter:off -->
# Dependencies

## Compile Dependencies

| Dependency                      | License          |
| ------------------------------- | ---------------- |
| [Virtual Schema Common JDBC][0] | [MIT License][1] |
| [error-reporting-java][2]       | [MIT License][3] |

## Test Dependencies

| Dependency                                      | License                                              |
| ----------------------------------------------- | ---------------------------------------------------- |
| [Virtual Schema Common JDBC][0]                 | [MIT License][1]                                     |
| [udf-debugging-java][4]                         | [MIT License][5]                                     |
| [Hamcrest][6]                                   | [BSD-3-Clause][7]                                    |
| [JUnit Jupiter (Aggregator)][8]                 | [Eclipse Public License v2.0][9]                     |
| [mockito-junit-jupiter][10]                     | [MIT][11]                                            |
| [Test containers for Exasol on Docker][12]      | [MIT License][13]                                    |
| [Testcontainers :: JUnit Jupiter Extension][14] | [MIT][15]                                            |
| [Testcontainers :: JDBC :: DB2][14]             | [MIT][15]                                            |
| [Matcher for SQL Result Sets][16]               | [MIT License][17]                                    |
| [Test Database Builder for Java][18]            | [MIT License][19]                                    |
| IBM Data Server Driver for JDBC and SQLJ        | [International Program License Agreement (IPLA)][20] |
| [SLF4J JDK14 Provider][21]                      | [MIT][22]                                            |
| [JaCoCo :: Agent][23]                           | [EPL-2.0][24]                                        |

## Runtime Dependencies

| Dependency                    | License                                                                                                        |
| ----------------------------- | -------------------------------------------------------------------------------------------------------------- |
| [JSON-P Default Provider][25] | [Eclipse Public License 2.0][26]; [GNU General Public License, version 2 with the GNU Classpath Exception][27] |

## Plugin Dependencies

| Dependency                                              | License                                     |
| ------------------------------------------------------- | ------------------------------------------- |
| [Apache Maven Clean Plugin][28]                         | [Apache-2.0][29]                            |
| [Apache Maven Install Plugin][30]                       | [Apache-2.0][29]                            |
| [Apache Maven Resources Plugin][31]                     | [Apache-2.0][29]                            |
| [Apache Maven Site Plugin][32]                          | [Apache-2.0][29]                            |
| [SonarQube Scanner for Maven][33]                       | [GNU LGPL 3][34]                            |
| [Apache Maven Toolchains Plugin][35]                    | [Apache-2.0][29]                            |
| [Apache Maven Compiler Plugin][36]                      | [Apache-2.0][29]                            |
| [Apache Maven Enforcer Plugin][37]                      | [Apache-2.0][29]                            |
| [Maven Flatten Plugin][38]                              | [Apache Software Licenese][29]              |
| [org.sonatype.ossindex.maven:ossindex-maven-plugin][39] | [ASL2][40]                                  |
| [Maven Surefire Plugin][41]                             | [Apache-2.0][29]                            |
| [Versions Maven Plugin][42]                             | [Apache License, Version 2.0][29]           |
| [duplicate-finder-maven-plugin Maven Mojo][43]          | [Apache License 2.0][44]                    |
| [Apache Maven Artifact Plugin][45]                      | [Apache-2.0][29]                            |
| [Apache Maven Assembly Plugin][46]                      | [Apache-2.0][29]                            |
| [Apache Maven JAR Plugin][47]                           | [Apache-2.0][29]                            |
| [Artifact reference checker and unifier][48]            | [MIT License][49]                           |
| [Project Keeper Maven plugin][50]                       | [The MIT License][51]                       |
| [Apache Maven Dependency Plugin][52]                    | [Apache-2.0][29]                            |
| [Maven Failsafe Plugin][53]                             | [Apache-2.0][29]                            |
| [JaCoCo :: Maven Plugin][54]                            | [EPL-2.0][24]                               |
| [Quality Summarizer Maven Plugin][55]                   | [MIT License][56]                           |
| [error-code-crawler-maven-plugin][57]                   | [MIT License][58]                           |
| [Git Commit Id Maven Plugin][59]                        | [GNU Lesser General Public License 3.0][60] |

[0]: https://github.com/exasol/virtual-schema-common-jdbc/
[1]: https://github.com/exasol/virtual-schema-common-jdbc/blob/main/LICENSE
[2]: https://github.com/exasol/error-reporting-java/
[3]: https://github.com/exasol/error-reporting-java/blob/main/LICENSE
[4]: https://github.com/exasol/udf-debugging-java/
[5]: https://github.com/exasol/udf-debugging-java/blob/main/LICENSE
[6]: http://hamcrest.org/JavaHamcrest/
[7]: https://raw.githubusercontent.com/hamcrest/JavaHamcrest/master/LICENSE
[8]: https://junit.org/junit5/
[9]: https://www.eclipse.org/legal/epl-v20.html
[10]: https://github.com/mockito/mockito
[11]: https://opensource.org/licenses/MIT
[12]: https://github.com/exasol/exasol-testcontainers/
[13]: https://github.com/exasol/exasol-testcontainers/blob/main/LICENSE
[14]: https://java.testcontainers.org
[15]: http://opensource.org/licenses/MIT
[16]: https://github.com/exasol/hamcrest-resultset-matcher/
[17]: https://github.com/exasol/hamcrest-resultset-matcher/blob/main/LICENSE
[18]: https://github.com/exasol/test-db-builder-java/
[19]: https://github.com/exasol/test-db-builder-java/blob/main/LICENSE
[20]: https://www.ibm.com/support/customer/csol/terms/?ref=L-AJVM-KLN94L-01-11-2023-zz-en
[21]: http://www.slf4j.org
[22]: https://opensource.org/license/mit
[23]: https://www.eclemma.org/jacoco/index.html
[24]: https://www.eclipse.org/legal/epl-2.0/
[25]: https://github.com/eclipse-ee4j/jsonp
[26]: https://projects.eclipse.org/license/epl-2.0
[27]: https://projects.eclipse.org/license/secondary-gpl-2.0-cp
[28]: https://maven.apache.org/plugins/maven-clean-plugin/
[29]: https://www.apache.org/licenses/LICENSE-2.0.txt
[30]: https://maven.apache.org/plugins/maven-install-plugin/
[31]: https://maven.apache.org/plugins/maven-resources-plugin/
[32]: https://maven.apache.org/plugins/maven-site-plugin/
[33]: http://docs.sonarqube.org/display/PLUG/Plugin+Library/sonar-scanner-maven/sonar-maven-plugin
[34]: http://www.gnu.org/licenses/lgpl.txt
[35]: https://maven.apache.org/plugins/maven-toolchains-plugin/
[36]: https://maven.apache.org/plugins/maven-compiler-plugin/
[37]: https://maven.apache.org/enforcer/maven-enforcer-plugin/
[38]: https://www.mojohaus.org/flatten-maven-plugin/
[39]: https://sonatype.github.io/ossindex-maven/maven-plugin/
[40]: http://www.apache.org/licenses/LICENSE-2.0.txt
[41]: https://maven.apache.org/surefire/maven-surefire-plugin/
[42]: https://www.mojohaus.org/versions/versions-maven-plugin/
[43]: https://basepom.github.io/duplicate-finder-maven-plugin
[44]: http://www.apache.org/licenses/LICENSE-2.0.html
[45]: https://maven.apache.org/plugins/maven-artifact-plugin/
[46]: https://maven.apache.org/plugins/maven-assembly-plugin/
[47]: https://maven.apache.org/plugins/maven-jar-plugin/
[48]: https://github.com/exasol/artifact-reference-checker-maven-plugin/
[49]: https://github.com/exasol/artifact-reference-checker-maven-plugin/blob/main/LICENSE
[50]: https://github.com/exasol/project-keeper/
[51]: https://github.com/exasol/project-keeper/blob/main/LICENSE
[52]: https://maven.apache.org/plugins/maven-dependency-plugin/
[53]: https://maven.apache.org/surefire/maven-failsafe-plugin/
[54]: https://www.jacoco.org/jacoco/trunk/doc/maven.html
[55]: https://github.com/exasol/quality-summarizer-maven-plugin/
[56]: https://github.com/exasol/quality-summarizer-maven-plugin/blob/main/LICENSE
[57]: https://github.com/exasol/error-code-crawler-maven-plugin/
[58]: https://github.com/exasol/error-code-crawler-maven-plugin/blob/main/LICENSE
[59]: https://github.com/git-commit-id/git-commit-id-maven-plugin
[60]: http://www.gnu.org/licenses/lgpl-3.0.txt
