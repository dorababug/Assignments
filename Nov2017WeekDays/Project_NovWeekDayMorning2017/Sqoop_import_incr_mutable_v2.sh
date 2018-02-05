#for table creation
echo "Check the temp table location present and remove from home directory of hdfs"

hdfs dfs -test -e usstates
if [ $? -eq 0 ];
then 
hdfs dfs -rm -r usstates
echo 'temp location removed successfully'
fi
#sqoop import -Dmapreduce.job.name="create hive table" \
#--connect jdbc:mysql://localhost:3306/complaints_db \
#--username root \
#--password root \
#--table usstates \
#--hive-import \
#--create-hive-table  \
#--hive-table dl_usstates \
#--null-string '\\N' \
#--null-non-string '\\N' 

export sysdate=`date +'%Y-%m-%d %H:%M:%S'`
echo $sysdate

sqoop import -Dmapreduce.job.name="create hive table" \
--connect jdbc:mysql://localhost:3306/complaints_db \
--username root \
--password root \
--table usstates \
--incremental lastmodified \
#--last-value  \
--hive-import \
--hive-database hdpdlake \
--hive-table dl_usstates \
--null-string '\\N' \
--null-non-string '\\N' \
--target-dir warehousedir/dl_usstates_incr





insert into usstates(State,StandardAbbreviation,PostalCode,CapitalCity,created_date,modified_date) values ('aaaa','aaaa','aaaa','aaaa',DEFAULT,DEFAULT) ;

update:::






