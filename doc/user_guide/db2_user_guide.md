# DB2 SQL Dialect User Guide

[DB2](https://www.ibm.com/analytics/db2) is an IBM database product. It is a Relational Database Management System (RDBMS). DB2 is extended with the support of Object-Oriented features and non-relational structures with XML.

## Telemetry

This virtual schema uses `telemetry-java` to send anonymous feature-usage events.

For details on what is collected and how to disable telemetry, see the [documentation](https://github.com/exasol/telemetry-java/blob/main/doc/app-user-guide.md).

## Uploading the JDBC Driver to Exasol BucketFS

1. Download the [DB2 JDBC driver](https://www.ibm.com/support/pages/db2-jdbc-driver-versions-and-downloads).
2. Upload the driver to BucketFS, see the [BucketFS documentation](https://docs.exasol.com/db/latest/administration/on-premise/bucketfs/accessfiles.htm) for details.

    Hint: Put the driver into folder `default/drivers/jdbc/` to register it for [ExaLoader](#registering-the-jdbc-driver-for-exaloader), too.

## Registering the JDBC driver for ExaLoader

In order to enable the ExaLoader to fetch data from the external database you must register the driver for ExaLoader as described in the [Installation procedure for JDBC drivers](https://github.com/exasol/docker-db/#installing-custom-jdbc-drivers).
1. ExaLoader expects the driver in BucketFS folder `default/drivers/jdbc`.

    If you uploaded the driver for UDF to a different folder, then you need to [upload](#uploading-the-jdbc-driver-to-exasol-bucketfs) the driver again.
2. Additionally you need to create file `settings.cfg` and [upload](#uploading-the-jdbc-driver-to-exasol-bucketfs) it to the same folder in BucketFS:

```properties
DRIVERNAME=DB2
JAR=jcc.jar
DRIVERMAIN=com.ibm.db2.jcc.DB2Driver
PREFIX=jdbc:db2:
NOSECURITY=YES
FETCHSIZE=100000
INSERTSIZE=-1

```

Ensure to add a trailing newline to `settings.cfg`.

## Installing the Adapter Script

Upload the latest available release of [DB2 Virtual Schema](https://github.com/exasol/db2-virtual-schema/releases) to Bucket FS.

Then create a schema to hold the adapter script.

```sql
CREATE SCHEMA ADAPTER;
```

The SQL statement below creates the adapter script, defines the Java class that serves as entry point and tells the UDF framework where to find the libraries (JAR files) for Virtual Schema and database driver.

### For Regular DB2 Servers

```sql
CREATE OR REPLACE JAVA ADAPTER SCRIPT ADAPTER.JDBC_ADAPTER AS
  %scriptclass com.exasol.adapter.RequestDispatcher;
  %jar /buckets/<BFS service>/<bucket>/virtual-schema-dist-14.0.4-db2-4.0.1.jar;
  %jar /buckets/<BFS service>/<bucket>/db2jcc4.jar;
  %jar /buckets/<BFS service>/<bucket>/db2jcc_license_cu.jar;
/
;
```

### For Mainframes

```sql
CREATE OR REPLACE JAVA ADAPTER SCRIPT ADAPTER.JDBC_ADAPTER AS
  %scriptclass com.exasol.adapter.RequestDispatcher;
  %jar /buckets/<BFS service>/<bucket>/virtual-schema-dist-14.0.4-db2-4.0.1.jar;
  %jar /buckets/<BFS service>/<bucket>/db2jcc4.jar;
  %jar /buckets/<BFS service>/<bucket>/db2jcc_license_cu.jar;
  %jar /buckets/<BFS service>/<bucket>/db2jcc_license_cisuz.jar;
/
```

## Defining a Named Connection

Define the connection to DB2 as shown below.

```sql
CREATE OR REPLACE CONNECTION DB2_CONNECTION
TO 'jdbc:db2://<host>:<port>/<database name>'
USER '<user>'
IDENTIFIED BY '<password>';
```

## Creating a Virtual Schema

Below you see how a DB2 Virtual Schema is created.

```sql
CREATE VIRTUAL SCHEMA <virtual schema name>
    USING ADAPTER.JDBC_ADAPTER
    WITH
	CONNECTION_NAME = 'DB2_CONNECTION'
	SCHEMA_NAME = '<schema name>'
;
```

## Data Types Conversion

| DB2 Data Type | Supported | Converted Exasol Data Type | Known limitations
|-------------- |-----------|----------------------------|-------------------
| BIGINT        | ✓         | DECIMAL(19,0)              |
| BINARY        | ×         |                            |
| BLOB          | ×         |                            |
| BOOLEAN       | ✓         | BOOLEAN                    |
| CHARACTER     | ✓         | CHAR                       |
| CLOB          | ×         |                            |
| DATE          | ✓         | DATE                       |
| DBCLOB        | ×         |                            |
| DECIMAL       | ✓         | DECIMAL                    |
| DECFLOAT      | ×         |                            |
| DOUBLE        | ✓         | DOUBLE PRECISION           |
| GRAPHIC       | ×         |                            |
| INTEGER       | ✓         | DECIMAL(10,0)              |
| SMALLINT      | ✓         | DECIMAL(5,0)               |
| TIME          | ✓         | VARCHAR(100)               |
| TIMESTAMP     | ✓         | TIMESTAMP *                |
| REAL          | ✓         | DOUBLE PRECISION           |
| VARCHAR       | ✓         | VARCHAR                    |
| VARBINARY     | ×         |                            |
| VARGRAPHIC    | ×         |                            |
| XML           | ✓         | VARCHAR(2000000)           |

* TIMESTAMP with fractional second precision are mapped to TIMESTAMP with milliseconds precision
for Exasol versions up to 8.31. Starting with Exasol 8.32 they are mapped with the same specified precision up to 
nanosecond (9). Precisions greater than nanoseconds will be truncated to nanoseconds.

## Casting of Functions

* `LIMIT` is replaced by `FETCH FIRST x ROWS ONLY`
* `OFFSET` is currently not supported as only DB2 V11 support this natively
* `ADD_DAYS`, `ADD_WEEKS` ... will be replaced by `COLUMN + DAYS`, `COLUMN + ....`

## Testing Information

In the following matrix you find combinations of JDBC driver and dialect version that we tested.

| Virtual Schema Version | DB2 Version                | Driver Name | Driver Version |
|------------------------|----------------------------|-------------|----------------|
| 2.0.0                  | ibmcom/db2:11.5.7.0a       | db2jcc      | 11.5.7.0a      |
| 2.1.0                  | ibmcom/db2:11.5.8.0        | db2jcc      | 11.5.8.0       |
| 3.1.0                  | db2_community/db2:12.1.1.0 | db2jcc      | 12.1.0.0       |
| 4.0.0                  | db2_community/db2:12.1.4.0 | db2jcc      | 12.1.4.0       |
