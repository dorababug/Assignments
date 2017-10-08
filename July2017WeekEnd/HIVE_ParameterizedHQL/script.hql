set dbname;
source prod.ini;
set dbname;
create database if not exists ${hiveconf:dbname};
create table ${hiveconf:dbname}.table1(id string);

