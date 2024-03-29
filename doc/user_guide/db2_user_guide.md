# DB2 SQL Dialect User Guide

[DB2](https://www.ibm.com/analytics/db2) is an IBM database product. It is a Relational Database Management System (RDBMS). DB2 is extended with the support of Object-Oriented features and non-relational structures with XML.

## Registering the JDBC Driver in EXAOperation

First download the [DB2 JDBC driver](http://www-01.ibm.com/support/docview.wss?uid=swg21363866).

Now register the driver in EXAOperation:

1. Click "Software"
1. Switch to tab "JDBC Drivers"
1. Click "Browse..."
1. Select JDBC driver file
1. Click "Upload"
1. Click "Add"
1. In dialog "Add EXACluster JDBC driver" configure the JDBC driver (see below)

You need to specify the following settings when adding the JDBC driver via EXAOperation.

| Parameter | Value                         |
|-----------|-------------------------------|
| Name      | `DB2`                         |
| Main      | `com.ibm.db2.jcc.DB2Driver`   |
| Prefix    | `jdbc:db2:`                   |
| Files     | `db2jcc4.jar` + license files |

Additionally, there are 2 files for the DB2 Driver:

* `db2jcc_license_cu.jar` - License File for DB2 on Linux Unix and Windows
* `db2jcc_license_cisuz.jar` - License File for DB2 on zOS (Mainframe)

Make sure that you upload the necessary license file for the target platform you want to connect to.

## Uploading the JDBC Driver to BucketFS

1. [Create a bucket in BucketFS](https://docs.exasol.com/administration/on-premise/bucketfs/create_new_bucket_in_bucketfs_service.htm)
1. Upload the driver and the license to BucketFS

This step is necessary since the UDF container the adapter runs in has no access to the JDBC drivers installed via EXAOperation but it can access BucketFS.

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
  %jar /buckets/<BFS service>/<bucket>/virtual-schema-dist-12.0.0-db2-3.0.0.jar;
  %jar /buckets/<BFS service>/<bucket>/db2jcc4.jar;
  %jar /buckets/<BFS service>/<bucket>/db2jcc_license_cu.jar;
/
;
```

### For Mainframes

```sql
CREATE OR REPLACE JAVA ADAPTER SCRIPT ADAPTER.JDBC_ADAPTER AS
  %scriptclass com.exasol.adapter.RequestDispatcher;
  %jar /buckets/<BFS service>/<bucket>/virtual-schema-dist-12.0.0-db2-3.0.0.jar;
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
| TIMESTAMP     | ✓         | TIMESTAMP                  |
| REAL          | ✓         | DOUBLE PRECISION           |
| VARCHAR       | ✓         | VARCHAR                    |
| VARBINARY     | ×         |                            |
| VARGRAPHIC    | ×         |                            |
| XML           | ✓         | VARCHAR(2000000)           |

## Casting of Functions

* `LIMIT` is replaced by `FETCH FIRST x ROWS ONLY`
* `OFFSET` is currently not supported as only DB2 V11 support this natively
* `ADD_DAYS`, `ADD_WEEKS` ... will be replaced by `COLUMN + DAYS`, `COLUMN + ....`

## Testing Information

In the following matrix you find combinations of JDBC driver and dialect version that we tested.

| Virtual Schema Version | DB2 Version           | Driver Name | Driver Version |
|------------------------|---------------------- |-------------|----------------|
| 2.0.0                  | ibmcom/db2:11.5.7.0a  | db2jcc      | 11.5.7.0a      |
| 2.1.0                  | ibmcom/db2:11.5.8.0   | db2jcc      | 11.5.8.0       |
