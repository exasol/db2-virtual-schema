# Virtual Schema for DB2 3.0.0, released 2024-03-26

Code name: Char set is always `utf-8`, deprecated IMPORT_DATA_TYPES `FROM_RESULT_SET` value .

## Summary

The behaviour when it comes to character sets is now simplified,
The target char set is now always UTF-8.
The `IMPORT_DATA_TYPES` property (and value `FROM_RESULT_SET`) are now deprecated (change in vs-common-jdbc):
An exception will be thrown when users use`FROM_RESULT_SET`. The exception message warns the user that the value is no longer supported and the property itself is also deprecated.

## Refactoring

* #25: Update tests to V8 VSMYSQL / Update to vsjdbc 12.0.0

