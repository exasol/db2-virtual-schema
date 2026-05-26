package com.exasol.adapter.dialects.db2;

import static com.exasol.adapter.dialects.db2.IntegrationTestConfiguration.EXASOL_VERSION;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.instanceOf;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.exasol.ExaMetadata;
import com.exasol.ExaMetadataStub;
import com.exasol.adapter.AdapterProperties;
import com.exasol.adapter.dialects.JDBCAdapterContext;

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
    void testGetAdapterProjectShortTag() {
        assertThat(this.factory.getAdapterProjectShortTag(), equalTo("VSDB2"));
    }

    @Test
    void testGetSqlDialectVersion() {
        // Only works in built artifact
        assertThat(this.factory.getSqlDialectVersion(), equalTo("UNKNOWN"));
    }

    @Test
    void testCreateDialect() {
        final ExaMetadata metadata = ExaMetadataStub.builder().databaseVersion(EXASOL_VERSION).build();
        assertThat(this.factory.createSqlDialect(JDBCAdapterContext.builder().properties(AdapterProperties.emptyProperties()).metadata(metadata).build()),
                instanceOf(DB2SqlDialect.class));
    }
}
