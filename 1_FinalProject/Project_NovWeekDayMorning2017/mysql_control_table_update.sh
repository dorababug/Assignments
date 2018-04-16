mysql_control_table_update

tblname=usstates
export sysdate=`date +'%Y-%m-%d %H:%M:%S'`
echo $sysdate

sql="insert into etl.mysql_ctrl_sqoop(job_run_date,table_name,created_by) values('$sysdate','$tblname','sqoop script')"

echo $sql
mysql --user=root --password=root  -e  "$sql"

last_run_time=`mysql --user=root --password=root --skip-column-names  -e "select max(job_run_date) from etl.mysql_ctrl_sqoop where job_run_date!=(select max(job_run_date) from etl.mysql_ctrl_sqoop where table_name='usstates');"`
echo $last_run_time






