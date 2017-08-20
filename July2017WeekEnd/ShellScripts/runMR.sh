#scriptname  mrjar entrypoint i/p o/p
# example run::::::  sh runMR.sh ~/Desktop/wordcount.jar com.inv.WordCountDriver /sample.txt /wcout

#hadoop jar ~/Desktop/wordcount.jar com.inv.WordCountDriver /sample.txt /wcout_`date +%Y_%m_%d_%H_%M_%S`

echo "Usage is scriptname  mrjar entrypoint i/p o/p"
echo "removing op location:::$4" 
hadoop fs -test -e $4 
res=$?
if [ $res -eq 0 ]
then 
	echo "inside IF condition"
	hadoop fs -rm -r $4
fi

if [ $? -eq 0 ]
then
 echo "$4 file removed successfully"
 hadoop fs -ls /
fi

echo "Running Jar file $1"
hadoop jar $1 $2 $3 $4
if [ $? -eq 0]
then
 echo "job successfully completed"
 echo "*************************"
 hadoop fs -cat $4/*
 exit 0
else 
 exit 1 
fi


