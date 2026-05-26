package com.exasol.adapter.dialects.db2;

import com.exasol.adapter.dialects.*;
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
    public SqlDialect createSqlDialect(final JDBCAdapterContext context) {
        return new DB2SqlDialect(context);
    }

    @Override
    public String getSqlDialectVersion() {
        final VersionCollector versionCollector = new VersionCollector(
                "META-INF/maven/com.exasol/db2-virtual-schema/pom.properties");
        return versionCollector.getVersionNumber();
    }

    @Override
    public String getAdapterProjectShortTag() {
        return "VSDB2";
    }
}
