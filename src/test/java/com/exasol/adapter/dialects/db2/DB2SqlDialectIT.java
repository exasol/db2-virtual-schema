package com.exasol.adapter.dialects.db2;

import static com.exasol.adapter.dialects.db2.IntegrationTestConfiguration.*;
import static com.exasol.dbbuilder.dialects.exasol.AdapterScript.Language.JAVA;
import static com.exasol.matcher.ResultSetStructureMatcher.table;
import static com.exasol.matcher.TypeMatchMode.NO_JAVA_TYPE_CHECK;
import static org.hamcrest.MatcherAssert.assertThat;

import java.io.FileNotFoundException;
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
import org.testcontainers.utility.DockerMachineClient;

import com.exasol.bucketfs.Bucket;
import com.exasol.bucketfs.BucketAccessException;
import com.exasol.containers.ExasolContainer;
import com.exasol.dbbuilder.dialects.DatabaseObject;
import com.exasol.dbbuilder.dialects.exasol.*;
import com.exasol.udfdebugging.UdfTestSetup;

@Tag("integration")
@Testcontainers
class DB2SqlDialectIT {
    private static final String SOURCE_SCHEMA = "TEST_SCHEMA";
    @Container
    private static final ExasolContainer<? extends ExasolContainer<?>> EXASOL = new ExasolContainer<>(
            EXASOL_DOCKER_REFERENCE).withReuse(true);
    @Container
    private static final Db2Container DB2 = new Db2Container(DB2_DOCKER_REFERENCE);
    private static Connection exasolConnection;
    private static Connection db2Connection;
    private static ExasolObjectFactory objectFactory;
    private static ExasolSchema adapterSchema;
    private static AdapterScript adapterScript;
    private static ConnectionDefinition jdbcConnectionDefinition;

    @BeforeAll
    static void beforeAll() throws BucketAccessException, InterruptedException, TimeoutException,
            JdbcDatabaseContainer.NoDriverFoundException, SQLException, FileNotFoundException {
        exasolConnection = EXASOL.createConnection("");
        final UdfTestSetup udfTestSetup = new UdfTestSetup(getTestHostIpAddress(), EXASOL.getDefaultBucket(),
                exasolConnection);
        db2Connection = DB2.createConnection("");
        try (final Statement statement = db2Connection.createStatement()) {
            statement.execute("CREATE SCHEMA " + SOURCE_SCHEMA);
        }
        objectFactory = new ExasolObjectFactory(exasolConnection,
                ExasolObjectConfiguration.builder().withJvmOptions(udfTestSetup.getJvmOptions()).build());
        adapterSchema = objectFactory.createSchema("ADAPTER_SCHEMA");
        uploadDriverToBucket();
        adapterScript = installVirtualSchemaAdapter(adapterSchema);
        jdbcConnectionDefinition = createAdapterConnectionDefinition();
    }

    private static String getTestHostIpAddress() {
        if (DockerMachineClient.instance().isInstalled()) {
            return EXASOL.getHost();
        } else {
            return EXASOL.getHostIp();
        }
    }

    private static AdapterScript installVirtualSchemaAdapter(final ExasolSchema adapterSchema)
            throws InterruptedException, BucketAccessException, TimeoutException, FileNotFoundException {
        final Bucket bucket = EXASOL.getDefaultBucket();
        bucket.uploadFile(PATH_TO_VIRTUAL_SCHEMAS_JAR, VIRTUAL_SCHEMAS_JAR_NAME_AND_VERSION);
        return adapterSchema.createAdapterScriptBuilder("EXASOL_ADAPTER").language(JAVA)
                .bucketFsContent("com.exasol.adapter.RequestDispatcher", //
                        "/buckets/bfsdefault/default/" + VIRTUAL_SCHEMAS_JAR_NAME_AND_VERSION, //
                        "/buckets/bfsdefault/default/drivers/jdbc/" + JDBC_DRIVER_NAME)
                .build();

    }

    private static ConnectionDefinition createAdapterConnectionDefinition() {
        final String jdbcUrl = "jdbc:db2://" + EXASOL.getHostIp() + ":" + DB2.getMappedPort(DB2_PORT) + "/test";
        return objectFactory.createConnectionDefinition("JDBC_CONNECTION", jdbcUrl, DB2.getUsername(),
                DB2.getPassword());
    }

    private static void uploadDriverToBucket() throws BucketAccessException, TimeoutException, FileNotFoundException {
        final Bucket bucket = EXASOL.getDefaultBucket();
        final Path pathToSettingsFile = Path.of("src", "test", "resources", JDBC_DRIVER_CONFIGURATION_FILE_NAME);
        bucket.uploadFile(JDBC_DRIVER_PATH, "drivers/jdbc/" + JDBC_DRIVER_NAME);
        bucket.uploadFile(pathToSettingsFile, "drivers/jdbc/" + JDBC_DRIVER_CONFIGURATION_FILE_NAME);
    }

    @AfterAll
    static void afterAll() throws SQLException {
        dropAll(adapterScript, adapterSchema);
        adapterScript = null;
        adapterSchema = null;
        if (exasolConnection != null) {
            exasolConnection.close();
        }
        if (db2Connection != null) {
            db2Connection.close();
        }
    }

    private static void dropAll(final DatabaseObject... databaseObjects) {
        for (final DatabaseObject databaseObject : databaseObjects) {
            if (databaseObject != null) {
                databaseObject.drop();
            }
        }
    }

    @Test
    void testSmallintMapping() throws SQLException {
        final String table = createSingleColumnTable("SMALLINT", List.of("-32768", "32767"));
        assertVirtualTableContents(table, table().row(-32768).row(32767).matches());
    }

    @Test
    void testIntegerMapping() throws SQLException {
        final String table = createSingleColumnTable("INT", List.of("-2147483648", "2147483647"));
        assertVirtualTableContents(table, table().row(-2147483648).row(2147483647).matches(NO_JAVA_TYPE_CHECK));
    }

    @Test
    void testBigintMapping() throws SQLException {
        final String table = createSingleColumnTable("BIGINT", List.of("-9223372036854775808", "9223372036854775807"));
        assertVirtualTableContents(table,
                table().row(-9223372036854775808L).row(9223372036854775807L).matches(NO_JAVA_TYPE_CHECK));
    }

    @Test
    void testDecimalMapping() throws SQLException {
        final String table = createSingleColumnTable("DECIMAL(31, 5)", List.of("-123.456", "123.456"), "DECIMAL");
        assertVirtualTableContents(table, table().row(-123.456).row(123.456).matches(NO_JAVA_TYPE_CHECK));
    }

    @Test
    void testRealMapping() throws SQLException {
        final String table = createSingleColumnTable("REAL", List.of("-123.457", "0.0001245"));
        assertVirtualTableContents(table,
                table().row(-123.45700073242188).row(1.2450000212993473E-4).matches(NO_JAVA_TYPE_CHECK));
    }

    @Test
    void testDoubleMapping() throws SQLException {
        final String table = createSingleColumnTable("DOUBLE", List.of("-1000", "14.568001"));
        assertVirtualTableContents(table, table().row(-1000).row(14.568001).matches(NO_JAVA_TYPE_CHECK));
    }

    @Test
    void testCharMapping() throws SQLException {
        final String table = createSingleColumnTable("CHAR(15)", List.of("'This is a test'", "'Hello'"), "CHAR");
        assertVirtualTableContents(table, table().row("This is a test ").row("Hello          ").matches());
    }

    @Test
    void testVarcharMapping() throws SQLException {
        final String table = createSingleColumnTable("VARCHAR(32672)", List.of("'This is a test'", "'Hello'"),
                "VARCHAR");
        assertVirtualTableContents(table, table().row("This is a test").row("Hello").matches());
    }

    @Test
    void testDateMapping() throws SQLException {
        final String table = createSingleColumnTable("DATE", List.of("'2018-10-27'", "'2021-12-12'"));
        assertVirtualTableContents(table,
                table().row(Date.valueOf("2018-10-27")).row(Date.valueOf("2021-12-12")).matches());
    }

    @Test
    void testTimeMapping() throws SQLException {
        final String table = createSingleColumnTable("TIME", List.of("'00.00.00'", "'23.59.59'"));
        assertVirtualTableContents(table, table().row("00.00.00").row("23.59.59").matches());
    }

    @Test
    void testTimestampMapping() throws SQLException {
        final String table = createSingleColumnTable("TIMESTAMP",
                List.of("'1900-01-01 00.00.00'", "'9999-12-31 23.59.59'"));
        assertVirtualTableContents(table,
                table().row("1900-01-01-00.00.00.000000").row("9999-12-31-23.59.59.000000").matches());
    }

    @Test
    void testXMLMapping() throws SQLException {
        final String table = createSingleColumnTable("XML",
                List.of("'<?xml version=\"1.0\" encoding=\"UTF-8\"?><note><heading>Test</heading></note>'"));
        assertVirtualTableContents(table, table()
                .row("<?xml version=\"1.0\" encoding=\"UTF-8\"?><note><heading>Test</heading></note>").matches());
    }

    @Test
    void testBooleanMapping() throws SQLException {
        final String table = createSingleColumnTable("BOOLEAN", List.of("TRUE", "FALSE"));
        assertVirtualTableContents(table, table().row(true).row(false).matches());
    }

    @Test
    void testLeftJoin() throws SQLException {
        createTablesForJoinTest();
        assertVsQuery("SELECT * FROM TL LEFT JOIN TR ON TL.C1 = TR.C1 ORDER BY TL.C1", //
                table() //
                        .row("K1", "L1", "K1", "R1") //
                        .row("K3", "L3", null, null) //
                        .row(null, "L2", null, null) //
                        .matches());
    }

    @Test
    void testLeftJoinWithProjection() throws SQLException {
        createTablesForJoinTest();
        assertVsQuery("SELECT TL.C1, TL.C2, TR.C2 FROM TL LEFT JOIN TR ON TL.C1 = TR.C1 ORDER BY TL.C1", //
                table() //
                        .row("K1", "L1", "R1") //
                        .row("K3", "L3", null) //
                        .row(null, "L2", null) //
                        .matches());
    }

    @Test
    void testRightJoin() throws SQLException {
        createTablesForJoinTest();
        assertVsQuery("SELECT * FROM TL RIGHT JOIN TR ON TL.C1 = TR.C1 ORDER BY TL.C1, TR.C1", //
                table() //
                        .row("K1", "L1", "K1", "R1") //
                        .row(null, null, "K2", "R2") //
                        .row(null, null, null, "R3") //
                        .matches());
    }

    @Test
    void testInnerJoin() throws SQLException {
        createTablesForJoinTest();
        assertVsQuery("SELECT * FROM TL INNER JOIN TR ON TL.C1 = TR.C1 ORDER BY TL.C1", //
                table().row("K1", "L1", "K1", "R1").matches());
    }

    @Test
    void testFullOuterJoin() throws SQLException {
        createTablesForJoinTest();
        assertVsQuery("SELECT * FROM TL FULL OUTER JOIN TR ON TL.C1 = TR.C1 ORDER BY TL.C1, TL.C2, TR.C1, TR.C2", //
                table() //
                        .row("K1", "L1", "K1", "R1") //
                        .row("K3", "L3", null, null) //
                        .row(null, "L2", null, null) //
                        .row(null, null, "K2", "R2") //
                        .row(null, null, null, "R3") //
                        .matches());
    }

    @Test
    void testScalarFunctionHour() throws SQLException {
        final String table = createSingleColumnTable("TIMESTAMP", List.of("'9999-12-31 23.59.59'"), "HOUR");
        assertVsQuery("SELECT HOUR(C1) FROM " + table, //
                table() //
                        .row(23) //
                        .matches(NO_JAVA_TYPE_CHECK));
    }

    @Test
    void testScalarFunctionInitcap() throws SQLException {
        final String table = createSingleColumnTable("VARCHAR(32672)", List.of("'ExAsOl is here'"), "INITCAP");
        assertVsQuery("SELECT INITCAP(C1) FROM " + table, //
                table() //
                        .row("Exasol Is Here") //
                        .matches());
    }

    @Test
    void testLeftJoinWithTableAliases() throws SQLException {
        createTablesForJoinTest();
        assertVsQuery("SELECT * FROM TL AS LT LEFT JOIN TR AS RT ON LT.C1 = RT.C1 ORDER BY LT.C1", //
                table() //
                        .row("K1", "L1", "K1", "R1") //
                        .row("K3", "L3", null, null) //
                        .row(null, "L2", null, null) //
                        .matches());
    }

    private String createSingleColumnTable(final String sourceType, final List<String> values) throws SQLException {
        return createSingleColumnTable(sourceType, values, sourceType);
    }

    private String createSingleColumnTable(final String sourceType, final List<String> values, final String suffix)
            throws SQLException {
        final String tableName = "SINGLE_COLUMN_TABLE_" + suffix;
        try (final Statement statement = db2Connection.createStatement()) {
            statement.execute("CREATE TABLE " + SOURCE_SCHEMA + "." + tableName + "(C1 " + sourceType + ")");
            for (final String value : values) {
                statement.execute("INSERT INTO " + SOURCE_SCHEMA + "." + tableName + " VALUES (" + value + ")");
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

    private void createTablesForJoinTest() throws SQLException {
        try (final Statement statement = db2Connection.createStatement()) {
            statement.execute("DROP TABLE TEST_SCHEMA.TL IF EXISTS");
            statement.execute("CREATE TABLE TEST_SCHEMA.TL (C1 VARCHAR(2), C2 VARCHAR(2))");
            statement.execute("INSERT INTO TEST_SCHEMA.TL VALUES ('K1', 'L1')");
            statement.execute("INSERT INTO TEST_SCHEMA.TL VALUES (null, 'L2')");
            statement.execute("INSERT INTO TEST_SCHEMA.TL VALUES ('K3', 'L3')");
            statement.execute("DROP TABLE TEST_SCHEMA.TR IF EXISTS");
            statement.execute("CREATE TABLE TEST_SCHEMA.TR (C1 VARCHAR(2), C2 VARCHAR(2))");
            statement.execute("INSERT INTO TEST_SCHEMA.TR VALUES ('K1', 'R1')");
            statement.execute("INSERT INTO TEST_SCHEMA.TR VALUES ('K2', 'R2')");
            statement.execute("INSERT INTO TEST_SCHEMA.TR VALUES (null, 'R3')");
        }
    }

    private void assertVsQuery(final String sql, final Matcher<ResultSet> matcher) {
        final VirtualSchema virtualSchema = createVirtualSchema();
        try {
            assertThat(query(sql), matcher);
        } catch (final SQLException exception) {
            Assertions.fail("Unable to execute assertion query. Caused by: " + exception.getMessage());
        } finally {
            virtualSchema.drop();
        }
    }
}