package com.exasol.adapter.dialects.db2;

import java.nio.file.Path;

public class IntegrationTestConfiguration {
    public static final String EXASOL_DOCKER_REFERENCE = "7.1.17";
    public static final String DB2_DOCKER_REFERENCE = "ibmcom/db2:11.5.8.0";
    public static final String VIRTUAL_SCHEMAS_JAR_NAME_AND_VERSION = "virtual-schema-dist-10.1.0-db2-2.1.0.jar";
    public static final Path PATH_TO_VIRTUAL_SCHEMAS_JAR = Path.of("target", VIRTUAL_SCHEMAS_JAR_NAME_AND_VERSION);
    public static final int DB2_PORT = 50000;
    public static final String JDBC_DRIVER_CONFIGURATION_FILE_NAME = "settings.cfg";
    public static final String JDBC_DRIVER_NAME = "jcc.jar";
    public static final Path JDBC_DRIVER_PATH = Path.of("target", "db2-driver", JDBC_DRIVER_NAME);

    private IntegrationTestConfiguration() {
        // prevent instantiation
    }
}
