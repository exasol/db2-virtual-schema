package com.exasol.adapter.dialects.db2;

import com.exasol.adapter.AdapterProperties;
import com.exasol.adapter.dialects.SqlDialect;
import com.exasol.adapter.dialects.SqlDialectFactory;
import com.exasol.adapter.jdbc.ConnectionFactory;
import com.exasol.logging.VersionCollector;

/**
 * Factory for the DB2 SQL dialect.
 */
public class DB2SqlDialectFactory implements SqlDialectFactory {
    @Override
    public String getSqlDialectName() {
        return DB2SqlDialect.NAME;
    }

    @Override
    public SqlDialect createSqlDialect(final ConnectionFactory connectionFactory, final AdapterProperties properties) {
        return new DB2SqlDialect(connectionFactory, properties);
    }

    @Override
    public String getSqlDialectVersion() {
        final VersionCollector versionCollector = new VersionCollector(
                "META-INF/maven/com.exasol/db2-virtual-schema/pom.properties");
        return versionCollector.getVersionNumber();
    }
}