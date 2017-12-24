echo No of args $#
echo No of args $@
echo first arg is the scrpt name $0
echo first arg is the scrpt name $1

print_comments ( ){
	echo "**************************************"
	echo $message
	echo "**************************************"
	}


export path=`pwd`
message="the current directory is $path"
print_comments
cd ~
export path=`pwd`
echo After cd command the current directory is $path
if [ -f $1 ] ; then
	export path=`pwd`
	message="the file $1 is preset in $path"
	print_comments
else 
	touch $1
	echo the file $1 is created in $path
fi



