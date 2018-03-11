package com.inv;

import java.io.IOException;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class JoinReducer extends Reducer<Text, Text, Text, Text> {
	
	//String deptId="";
	String deptName="";
	String dept_deptid="";
	
	@Override
	protected void reduce(Text key, Iterable<Text> value,Context context)
			throws IOException, InterruptedException {
		
		//002_dept < hive >
		//002_emp <2,name2,4000,002  7,name7,4000,002 >
		if(key.toString().contains("dept")){
			for (Text val : value) {
				deptName=val.toString();
				dept_deptid=key.toString().split("_")[0];
				//003
			}
		}
		
		if(key.toString().contains("emp")){
			//004_emp
			if(!key.toString().contains(dept_deptid))
			{
				deptName="NotFound";
			}
			for (Text val : value) {
				//2,name2,4000,002 hive    7,name7,4000,002 hive
				context.write(val, new Text(deptName));
			}
		}
		
	}
}
