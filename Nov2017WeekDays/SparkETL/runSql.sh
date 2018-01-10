export HADOOP_CONF_DIR=$HADOOP_HOME/etc/hadoop

spark-sql \
--master yarn \
--name 	"movies 2000" \
-f /home/hadoop/SparkETL/top200.hql
