echo number of args $#
echo args $*
echo shell script name is $0
echo arg1 is $1
echo arg1 is $2
echo arg1 is $3
echo arg1 is $4

hdfs dfs -test -e /$1/$2

if [ $? -eq 0 ] ;
then
	echo the foder $1 and the file $2 are present
	exit 0
else
	echo the foder $1 and the file $2 are not present
	echo 1
	#hdfs dfs -touchz /$1/$2
	#hdfs dfs -touchz /$1/$3
	#hdfs dfs -touchz /$1/$4
fi

