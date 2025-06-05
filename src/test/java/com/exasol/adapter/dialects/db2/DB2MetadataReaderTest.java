package com.exasol.adapter.dialects.db2;

import static com.exasol.adapter.dialects.db2.IntegrationTestConfiguration.EXASOL_VERSION;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.instanceOf;

import com.exasol.ExaMetadata;
import com.exasol.ExaMetadataStub;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.exasol.adapter.AdapterProperties;
import com.exasol.adapter.jdbc.BaseTableMetadataReader;

class DB2MetadataReaderTest {
    private DB2MetadataReader db2MetadataReader;

    @BeforeEach
    void beforeEach() {
        final ExaMetadata metadata = ExaMetadataStub.builder().databaseVersion(EXASOL_VERSION).build();
        this.db2MetadataReader = new DB2MetadataReader(null, AdapterProperties.emptyProperties(), metadata);
    }

    @Test
    void testGetTableMetadataReader() {
        assertThat(this.db2MetadataReader.getTableMetadataReader(), instanceOf(BaseTableMetadataReader.class));
    }

    @Test
    void testGetColumnMetadataReader() {
        assertThat(this.db2MetadataReader.getColumnMetadataReader(), instanceOf(DB2ColumnMetadataReader.class));
    }
}
