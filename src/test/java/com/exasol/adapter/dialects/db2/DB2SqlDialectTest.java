package com.exasol.adapter.dialects.db2;

import static com.exasol.adapter.AdapterProperties.CATALOG_NAME_PROPERTY;
import static com.exasol.adapter.AdapterProperties.SCHEMA_NAME_PROPERTY;
import static com.exasol.adapter.capabilities.AggregateFunctionCapability.*;
import static com.exasol.adapter.capabilities.LiteralCapability.*;
import static com.exasol.adapter.capabilities.MainCapability.*;
import static com.exasol.adapter.capabilities.PredicateCapability.*;
import static com.exasol.adapter.capabilities.ScalarFunctionCapability.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.collection.IsIterableContainingInAnyOrder.containsInAnyOrder;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.exasol.adapter.AdapterProperties;
import com.exasol.adapter.capabilities.Capabilities;
import com.exasol.adapter.dialects.SqlDialect;
import com.exasol.adapter.jdbc.ConnectionFactory;
import com.exasol.adapter.jdbc.RemoteMetadataReaderException;
import com.exasol.adapter.properties.PropertyValidationException;

@ExtendWith(MockitoExtension.class)
class DB2SqlDialectTest {
    private DB2SqlDialect dialect;
    private Map<String, String> rawProperties;
    @Mock
    private ConnectionFactory connectionFactoryMock;

    @BeforeEach
    void beforeEach() {
        this.rawProperties = new HashMap<>();
        this.dialect = new DB2SqlDialect(this.connectionFactoryMock, AdapterProperties.emptyProperties());
    }

    @Test
    void testGetCapabilities() {
        final Capabilities capabilities = this.dialect.getCapabilities();
        assertAll(
                () -> assertThat(capabilities.getMainCapabilities(),
                        containsInAnyOrder(SELECTLIST_PROJECTION, SELECTLIST_EXPRESSIONS, FILTER_EXPRESSIONS,
                                AGGREGATE_SINGLE_GROUP, AGGREGATE_GROUP_BY_COLUMN, AGGREGATE_GROUP_BY_EXPRESSION,
                                AGGREGATE_GROUP_BY_TUPLE, AGGREGATE_HAVING, ORDER_BY_COLUMN, ORDER_BY_EXPRESSION, LIMIT,
                                JOIN, JOIN_TYPE_INNER, JOIN_TYPE_LEFT_OUTER, JOIN_TYPE_RIGHT_OUTER,
                                JOIN_TYPE_FULL_OUTER, JOIN_CONDITION_EQUI)),
                () -> assertThat(capabilities.getLiteralCapabilities(),
                        containsInAnyOrder(NULL, DATE, TIMESTAMP, TIMESTAMP_UTC, DOUBLE, EXACTNUMERIC, STRING,
                                INTERVAL)),
                () -> assertThat(capabilities.getPredicateCapabilities(),
                        containsInAnyOrder(AND, OR, NOT, EQUAL, NOTEQUAL, LESS, LESSEQUAL, LIKE, LIKE_ESCAPE, BETWEEN,
                                IN_CONSTLIST, IS_NULL, IS_NOT_NULL)),
                () -> assertThat(capabilities.getAggregateFunctionCapabilities(),
                        containsInAnyOrder(COUNT, COUNT_STAR, COUNT_DISTINCT, GROUP_CONCAT, GROUP_CONCAT_SEPARATOR,
                                GROUP_CONCAT_ORDER_BY, SUM, SUM_DISTINCT, MIN, MAX, AVG, AVG_DISTINCT, MEDIAN,
                                FIRST_VALUE, LAST_VALUE, STDDEV, STDDEV_POP, STDDEV_SAMP, VARIANCE, VARIANCE_DISTINCT,
                                VAR_POP, VAR_SAMP)),
                () -> assertThat(capabilities.getScalarFunctionCapabilities(),
                        containsInAnyOrder(CEIL, DIV, FLOOR, SIGN, ADD, SUB, MULT, FLOAT_DIV, NEG, ABS, ACOS, ASIN,
                                ATAN, ATAN2, COS, COSH, COT, DEGREES, EXP, GREATEST, LEAST, LN, LOG, MOD, POWER,
                                RADIANS, SIN, SINH, SQRT, TAN, TANH, ASCII, CHR, INSTR, LENGTH, LOCATE, LOWER, LPAD,
                                LTRIM, REPEAT, REPLACE, RIGHT, RPAD, RTRIM, SOUNDEX, SUBSTR, TRANSLATE, TRIM, UPPER,
                                ADD_DAYS, ADD_HOURS, ADD_MINUTES, ADD_MONTHS, ADD_SECONDS, ADD_WEEKS, ADD_YEARS,
                                CURRENT_DATE, CURRENT_TIMESTAMP, LOCALTIMESTAMP, SYSDATE, SYSTIMESTAMP, CAST, TO_CHAR,
                                TO_DATE, TO_NUMBER, TO_TIMESTAMP, CASE, CURRENT_SCHEMA, CURRENT_USER, NULLIFZERO,
                                ZEROIFNULL, HOUR, INITCAP)));
    }

    @Test
    void testMetadataReaderClass() {
        assertThat(this.dialect.createRemoteMetadataReader(), instanceOf(DB2MetadataReader.class));
    }

    @Test
    void testCreateRemoteMetadataReaderConnectionFails() throws SQLException {
        when(this.connectionFactoryMock.getConnection()).thenThrow(new SQLException("mock"));
        final RemoteMetadataReaderException exception = assertThrows(RemoteMetadataReaderException.class,
                this.dialect::createRemoteMetadataReader);
        assertThat(exception.getMessage(), equalTo("E-VSDB2-1: Unable to create DB2 remote metadata reader. Caused by: mock"));
    }

    @Test
    void testValidateCatalogProperty() {
        setMandatoryProperties();
        this.rawProperties.put(CATALOG_NAME_PROPERTY, "MY_CATALOG");
        final AdapterProperties adapterProperties = new AdapterProperties(this.rawProperties);
        final SqlDialect sqlDialect = new DB2SqlDialect(null, adapterProperties);
        final PropertyValidationException exception = assertThrows(PropertyValidationException.class,
                sqlDialect::validateProperties);
        assertThat(exception.getMessage(), equalTo(
                "E-VSCJDBC-13: This dialect does not support property 'CATALOG_NAME'. Please, do not set this property."));
    }

    private void setMandatoryProperties() {
        this.rawProperties.put(AdapterProperties.CONNECTION_NAME_PROPERTY, "MY_CONN");
    }

    @Test
    void testValidateSchemaProperty() throws PropertyValidationException {
        setMandatoryProperties();
        this.rawProperties.put(SCHEMA_NAME_PROPERTY, "MY_SCHEMA");
        final AdapterProperties adapterProperties = new AdapterProperties(this.rawProperties);
        final SqlDialect sqlDialect = new DB2SqlDialect(null, adapterProperties);
        sqlDialect.validateProperties();
    }

    @Test
    void testSupportsJdbcCatalogs() {
        assertThat(this.dialect.supportsJdbcCatalogs(), equalTo(SqlDialect.StructureElementSupport.NONE));
    }

    @Test
    void testSupportsJdbcSchemas() {
        assertThat(this.dialect.supportsJdbcSchemas(), equalTo(SqlDialect.StructureElementSupport.MULTIPLE));
    }

    @CsvSource({ "tableName, \"tableName\"", //
            "\"tableName, \"\"\"tableName\"" //
    })
    @ParameterizedTest
    void testApplyQuote(final String unquoted, final String quoted) {
        assertThat(this.dialect.applyQuote(unquoted), equalTo(quoted));
    }

    @ValueSource(strings = { "ab:'ab'", "a'b:'a''b'", "a''b:'a''''b'", "'ab':'''ab'''" })
    @ParameterizedTest
    void testGetLiteralString(final String definition) {
        assertThat(this.dialect.getStringLiteral(definition.substring(0, definition.indexOf(':'))),
                equalTo(definition.substring(definition.indexOf(':') + 1)));
    }

    @Test
    void testGetLiteralStringNull() {
        assertThat(this.dialect.getStringLiteral(null), CoreMatchers.equalTo("NULL"));
    }

    @Test
    void testRequiresCatalogQualifiedTableNames() {
        assertThat(this.dialect.requiresCatalogQualifiedTableNames(null), equalTo(false));
    }

    @Test
    void testRequiresSchemaQualifiedTableNames() {
        assertThat(this.dialect.requiresSchemaQualifiedTableNames(null), equalTo(true));
    }

    @Test
    void testGetSqlGenerator() {
        assertThat(this.dialect.getSqlGenerator(null), CoreMatchers.instanceOf(DB2SqlGenerationVisitor.class));
    }

    @Test
    void testGetDefaultNullSorting() {
        assertThat(this.dialect.getDefaultNullSorting(), equalTo(SqlDialect.NullSorting.NULLS_SORTED_AT_END));
    }
}