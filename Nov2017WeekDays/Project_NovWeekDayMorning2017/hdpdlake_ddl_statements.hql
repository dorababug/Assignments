set hive.metastore.warehouse.location=/users/hive/;
create database  hdpdlake 
comment "datalake database"
location "/users/hive/hdpdlake";

Error:::
FAILED: ParseException line 3:0 missing EOF at 'comment' near ''/users/hive/hdpdlake''

Reason:: used comment after location, 
comment clause should come before location clause.

show create database hdpdlake;

CREATE DATABASE `hdpdlake`
COMMENT
  'datalake database'
LOCATION
  'hdfs://localhost:9000/users/hive/hdpdlake';


CREATE TABLE hdpdlake.dl_usstates(
  `state` string, 
  `standardabbreviation` string, 
  `postalcode` string, 
  `capitalcity` string, 
  `created_date` string, 
  `modified_date` string, 
  `id` bigint)
COMMENT 'Imported by sqoop into data lake hdpdlake'
STORED AS PARQUET
LOCATION
  'hdfs://localhost:9000/user/hive/warehouse/dl_usstates'



