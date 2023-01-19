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
| [udf-debugging-java][4]                         | [MIT][5]                                             |
| [Hamcrest][6]                                   | [BSD License 3][7]                                   |
| [JUnit Jupiter (Aggregator)][8]                 | [Eclipse Public License v2.0][9]                     |
| [mockito-junit-jupiter][10]                     | [The MIT License][11]                                |
| [exasol-test-setup-abstraction-java][12]        | [MIT License][13]                                    |
| [Testcontainers :: JUnit Jupiter Extension][14] | [MIT][15]                                            |
| [Testcontainers :: JDBC :: DB2][14]             | [MIT][15]                                            |
| [Matcher for SQL Result Sets][16]               | [MIT License][17]                                    |
| [Test Database Builder for Java][18]            | [MIT License][19]                                    |
| IBM Data Server Driver for JDBC and SQLJ        | [International Program License Agreement (IPLA)][20] |
| [JaCoCo :: Agent][21]                           | [Eclipse Public License 2.0][22]                     |

## Runtime Dependencies

| Dependency                    | License                                                                                                        |
| ----------------------------- | -------------------------------------------------------------------------------------------------------------- |
| [JSON-P Default Provider][23] | [Eclipse Public License 2.0][24]; [GNU General Public License, version 2 with the GNU Classpath Exception][25] |

## Plugin Dependencies

| Dependency                                              | License                                        |
| ------------------------------------------------------- | ---------------------------------------------- |
| [SonarQube Scanner for Maven][26]                       | [GNU LGPL 3][27]                               |
| [Apache Maven Compiler Plugin][28]                      | [Apache License, Version 2.0][29]              |
| [Apache Maven Enforcer Plugin][30]                      | [Apache License, Version 2.0][29]              |
| [Maven Flatten Plugin][31]                              | [Apache Software Licenese][29]                 |
| [org.sonatype.ossindex.maven:ossindex-maven-plugin][32] | [ASL2][33]                                     |
| [Maven Surefire Plugin][34]                             | [Apache License, Version 2.0][29]              |
| [Versions Maven Plugin][35]                             | [Apache License, Version 2.0][29]              |
| [Apache Maven Assembly Plugin][36]                      | [Apache License, Version 2.0][29]              |
| [Apache Maven JAR Plugin][37]                           | [Apache License, Version 2.0][29]              |
| [Artifact reference checker and unifier][38]            | [MIT License][39]                              |
| [Project keeper maven plugin][40]                       | [The MIT License][41]                          |
| [Apache Maven Dependency Plugin][42]                    | [Apache License, Version 2.0][29]              |
| [Maven Failsafe Plugin][43]                             | [Apache License, Version 2.0][29]              |
| [JaCoCo :: Maven Plugin][44]                            | [Eclipse Public License 2.0][22]               |
| [error-code-crawler-maven-plugin][45]                   | [MIT License][46]                              |
| [Reproducible Build Maven Plugin][47]                   | [Apache 2.0][33]                               |
| [Maven Clean Plugin][48]                                | [The Apache Software License, Version 2.0][33] |
| [Maven Resources Plugin][49]                            | [The Apache Software License, Version 2.0][33] |
| [Maven Install Plugin][50]                              | [The Apache Software License, Version 2.0][33] |
| [Maven Deploy Plugin][51]                               | [The Apache Software License, Version 2.0][33] |
| [Maven Site Plugin 3][52]                               | [The Apache Software License, Version 2.0][33] |

[0]: https://github.com/exasol/virtual-schema-common-jdbc/
[1]: https://github.com/exasol/virtual-schema-common-jdbc/blob/main/LICENSE
[2]: https://github.com/exasol/error-reporting-java/
[3]: https://github.com/exasol/error-reporting-java/blob/main/LICENSE
[4]: https://github.com/exasol/udf-debugging-java/
[5]: https://opensource.org/licenses/MIT
[6]: http://hamcrest.org/JavaHamcrest/
[7]: http://opensource.org/licenses/BSD-3-Clause
[8]: https://junit.org/junit5/
[9]: https://www.eclipse.org/legal/epl-v20.html
[10]: https://github.com/mockito/mockito
[11]: https://github.com/mockito/mockito/blob/main/LICENSE
[12]: https://github.com/exasol/exasol-test-setup-abstraction-java/
[13]: https://github.com/exasol/exasol-test-setup-abstraction-java/blob/main/LICENSE
[14]: https://testcontainers.org
[15]: http://opensource.org/licenses/MIT
[16]: https://github.com/exasol/hamcrest-resultset-matcher/
[17]: https://github.com/exasol/hamcrest-resultset-matcher/blob/main/LICENSE
[18]: https://github.com/exasol/test-db-builder-java/
[19]: https://github.com/exasol/test-db-builder-java/blob/main/LICENSE
[20]: https://www.ibm.com/support/customer/csol/terms/?ref=L-KHAI-CASRX7-01-10-2022-zz-en
[21]: https://www.eclemma.org/jacoco/index.html
[22]: https://www.eclipse.org/legal/epl-2.0/
[23]: https://github.com/eclipse-ee4j/jsonp
[24]: https://projects.eclipse.org/license/epl-2.0
[25]: https://projects.eclipse.org/license/secondary-gpl-2.0-cp
[26]: http://sonarsource.github.io/sonar-scanner-maven/
[27]: http://www.gnu.org/licenses/lgpl.txt
[28]: https://maven.apache.org/plugins/maven-compiler-plugin/
[29]: https://www.apache.org/licenses/LICENSE-2.0.txt
[30]: https://maven.apache.org/enforcer/maven-enforcer-plugin/
[31]: https://www.mojohaus.org/flatten-maven-plugin/
[32]: https://sonatype.github.io/ossindex-maven/maven-plugin/
[33]: http://www.apache.org/licenses/LICENSE-2.0.txt
[34]: https://maven.apache.org/surefire/maven-surefire-plugin/
[35]: https://www.mojohaus.org/versions-maven-plugin/
[36]: https://maven.apache.org/plugins/maven-assembly-plugin/
[37]: https://maven.apache.org/plugins/maven-jar-plugin/
[38]: https://github.com/exasol/artifact-reference-checker-maven-plugin/
[39]: https://github.com/exasol/artifact-reference-checker-maven-plugin/blob/main/LICENSE
[40]: https://github.com/exasol/project-keeper/
[41]: https://github.com/exasol/project-keeper/blob/main/LICENSE
[42]: https://maven.apache.org/plugins/maven-dependency-plugin/
[43]: https://maven.apache.org/surefire/maven-failsafe-plugin/
[44]: https://www.jacoco.org/jacoco/trunk/doc/maven.html
[45]: https://github.com/exasol/error-code-crawler-maven-plugin/
[46]: https://github.com/exasol/error-code-crawler-maven-plugin/blob/main/LICENSE
[47]: http://zlika.github.io/reproducible-build-maven-plugin
[48]: http://maven.apache.org/plugins/maven-clean-plugin/
[49]: http://maven.apache.org/plugins/maven-resources-plugin/
[50]: http://maven.apache.org/plugins/maven-install-plugin/
[51]: http://maven.apache.org/plugins/maven-deploy-plugin/
[52]: http://maven.apache.org/plugins/maven-site-plugin/
