#mysql control table creation
create database etl;
drop table etl.mysql_ctrl_sqoop;
create table etl.mysql_ctrl_sqoop(
id BIGINT NOT NULL AUTO_INCREMENT,
job_run_date datetime,
table_name varchar(256),
created_by varchar(256),
created_date datetime DEFAULT CURRENT_TIMESTAMP,
PRIMARY KEY(id)) ;
select * from etl.mysql_ctrl_sqoop;
mysql --user=root --password=root  -e 'insert into etl.mysql_ctrl_sqoop(job_run_date,table_name,created_by) values("1900-01-01 00:00:00","usstates","sqoop script")'

#################################################
drop table etl.mysql_ctrl_hive;
create table etl.mysql_ctrl_hive(
id BIGINT NOT NULL AUTO_INCREMENT,
job_run_date datetime,
table_name varchar(256),
created_by varchar(256),
created_date datetime DEFAULT CURRENT_TIMESTAMP,
PRIMARY KEY(id)) ;

select * from etl.mysql_ctrl_hive;
mysql --user=root --password=root  -e 'insert into etl.mysql_ctrl_sqoop(job_run_date,table_name,created_by) values("1900-01-01 00:00:00","hive query 1","sqoop script")'

