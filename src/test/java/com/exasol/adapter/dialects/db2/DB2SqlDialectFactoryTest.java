package com.exasol.adapter.dialects.db2;

import static com.exasol.adapter.dialects.db2.IntegrationTestConfiguration.EXASOL_VERSION;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.instanceOf;

import com.exasol.ExaMetadata;
import com.exasol.ExaMetadataStub;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.exasol.adapter.AdapterProperties;

class DB2SqlDialectFactoryTest {
    private DB2SqlDialectFactory factory;

    @BeforeEach
    void beforeEach() {
        this.factory = new DB2SqlDialectFactory();
    }

    @Test
    void testGetName() {
        assertThat(this.factory.getSqlDialectName(), equalTo("DB2"));
    }

    @Test
    void testCreateDialect() {
        final ExaMetadata metadata = ExaMetadataStub.builder().databaseVersion(EXASOL_VERSION).build();
        assertThat(this.factory.createSqlDialect(null, AdapterProperties.emptyProperties(), metadata),
                instanceOf(DB2SqlDialect.class));
    }
}