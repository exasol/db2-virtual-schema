package com.exasol.adapter.dialects.db2;

import static com.exasol.adapter.dialects.db2.IntegrationTestConfiguration.*;
import static com.exasol.dbbuilder.dialects.exasol.AdapterScript.Language.JAVA;
import static com.exasol.matcher.ResultSetStructureMatcher.table;
import static org.hamcrest.MatcherAssert.assertThat;

import java.nio.file.Path;
import java.sql.*;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeoutException;

import org.hamcrest.Matcher;
import org.junit.jupiter.api.*;
import org.testcontainers.containers.Db2Container;
import org.testcontainers.containers.JdbcDatabaseContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import com.exasol.bucketfs.Bucket;
import com.exasol.bucketfs.BucketAccessException;
import com.exasol.containers.ExasolContainer;
import com.exasol.dbbuilder.dialects.DatabaseObject;
import com.exasol.dbbuilder.dialects.exasol.*;

@Tag("integration")
@Testcontainers
class DB2SqlDialectIT {
    private static final String SOURCE_SCHEMA = "DB2INST1";
    @Container
    private static final ExasolContainer<? extends ExasolContainer<?>> EXASOL = new ExasolContainer<>(
            EXASOL_DOCKER_REFERENCE).withReuse(true);
    @Container
    private static final Db2Container DB2 = new Db2Container(EDB2_DOCKER_REFERENCE);
    private static Connection exasolConnection;
    private static Connection db2Connection;
    private static ExasolObjectFactory objectFactory;
    private static ExasolSchema adapterSchema;
    private static AdapterScript adapterScript;
    private static ConnectionDefinition jdbcConnectionDefinition;

    @BeforeAll
    static void beforeAll() throws BucketAccessException, InterruptedException, TimeoutException,
            JdbcDatabaseContainer.NoDriverFoundException, SQLException {
        exasolConnection = EXASOL.createConnection("");
        db2Connection = DB2.createConnection("");
        objectFactory = new ExasolObjectFactory(exasolConnection);
        adapterSchema = objectFactory.createSchema("ADAPTER_SCHEMA");
        uploadDriverToBucket();
        adapterScript = installVirtualSchemaAdapter(adapterSchema);
        jdbcConnectionDefinition = createAdapterConnectionDefinition();
    }

    private static AdapterScript installVirtualSchemaAdapter(final ExasolSchema adapterSchema)
            throws InterruptedException, BucketAccessException, TimeoutException {
        final Bucket bucket = EXASOL.getDefaultBucket();
        bucket.uploadFile(PATH_TO_VIRTUAL_SCHEMAS_JAR, VIRTUAL_SCHEMAS_JAR_NAME_AND_VERSION);
        final String content = "%scriptclass com.exasol.adapter.RequestDispatcher;\n" //
                + "%jar /buckets/bfsdefault/default/" + VIRTUAL_SCHEMAS_JAR_NAME_AND_VERSION + ";\n" //
                + "%jar /buckets/bfsdefault/default/drivers/jdbc/" + JDBC_DRIVER_NAME + ";\n";
        return adapterSchema.createAdapterScript("EXASOL_ADAPTER", JAVA, content);
    }

    private static ConnectionDefinition createAdapterConnectionDefinition() {
        final String jdbcUrl = "jdbc:db2://" + DOCKER_IP_ADDRESS + ":" + DB2.getMappedPort(DB2_PORT) + "/test";
        return objectFactory.createConnectionDefinition("JDBC_CONNECTION", jdbcUrl, DB2.getUsername(),
                DB2.getPassword());
    }

    private static void uploadDriverToBucket() throws InterruptedException, BucketAccessException, TimeoutException {
        final Bucket bucket = EXASOL.getDefaultBucket();
        final Path pathToSettingsFile = Path.of("src", "test", "resources", JDBC_DRIVER_CONFIGURATION_FILE_NAME);
        bucket.uploadFile(JDBC_DRIVER_PATH, "drivers/jdbc/" + JDBC_DRIVER_NAME);
        bucket.uploadFile(pathToSettingsFile, "drivers/jdbc/" + JDBC_DRIVER_CONFIGURATION_FILE_NAME);
    }

//    @BeforeEach
//    void beforeEach() {
//    }

    @AfterAll
    static void afterAll() throws SQLException {
        dropAll(adapterScript, adapterSchema);
        adapterScript = null;
        adapterSchema = null;
        exasolConnection.close();
        db2Connection.close();
    }

    private static void dropAll(final DatabaseObject... databaseObjects) {
        for (final DatabaseObject databaseObject : databaseObjects) {
            if (databaseObject != null) {
                databaseObject.drop();
            }
        }
    }

    @Test
    void testVarcharMappingUtf8() throws SQLException {
        final String table = createSingleColumnTable("SMALLINT", List.of("-32768", "32767"));
        assertVirtualTableContents(table, table("SMALLINT").row(-32768).row(32767).matches());
    }

    private String createSingleColumnTable(final String sourceType, final List<String> values) throws SQLException {
        final String tableName = "SINGLE_COLUMN_TABLE_" + sourceType;
        try (final Statement statement = db2Connection.createStatement()) {
            statement.execute("CREATE TABLE " + tableName + "(C1 " + sourceType + ")");
            for (final String value : values) {
                statement.execute("INSERT INTO " + tableName + " VALUES (" + value + ")");
            }
        }
        return tableName;
    }

    private void assertVirtualTableContents(final String table, final Matcher<ResultSet> matcher) {
        final VirtualSchema virtualSchema = createVirtualSchema();
        try {
            assertThat(selectAllFromCorrespondingVirtualTable(virtualSchema, table), matcher);
        } catch (final SQLException exception) {
            Assertions.fail("Unable to execute assertion query. Caused by: " + exception.getMessage());
        } finally {
            virtualSchema.drop();
        }
    }

    private VirtualSchema createVirtualSchema() {
        return objectFactory.createVirtualSchemaBuilder("THE_VS") //
                .adapterScript(adapterScript) //
                .connectionDefinition(jdbcConnectionDefinition) //
                .properties(Map.of("SCHEMA_NAME", SOURCE_SCHEMA)) //
                .build();
    }

    private ResultSet selectAllFromCorrespondingVirtualTable(final VirtualSchema virtualSchema, final String table)
            throws SQLException {
        return selectAllFrom(getVirtualTableName(virtualSchema, table));
    }

    private String getVirtualTableName(final VirtualSchema virtualSchema, final String table) {
        return virtualSchema.getFullyQualifiedName() + ".\"" + table + "\"";
    }

    private ResultSet selectAllFrom(final String tableName) throws SQLException {
        return query("SELECT * FROM " + tableName);
    }

    private ResultSet query(final String sql) throws SQLException {
        return exasolConnection.createStatement().executeQuery(sql);
    }
}