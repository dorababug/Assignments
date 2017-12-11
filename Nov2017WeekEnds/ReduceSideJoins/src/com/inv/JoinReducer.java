package com.inv;

import java.io.IOException;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class JoinReducer extends Reducer<Text, Text, Text, Text>{
	
	String deptname="";
	String deptid="";
	
	@Override
	protected void reduce(Text key, Iterable<Text> values, 
			Reducer<Text, Text, Text, Text>.Context context)
			throws IOException, InterruptedException {
		//001_dept,,hadoop
		//extract dept name
		if(key.toString().contains("dept")){
			deptid=key.toString().split("_")[0];
			for (Text val : values) {
				deptname=val.toString();
				
			}
		}
		
		//001_emp, < 7,name7,4000,002   , 2,name2,4000,002 >
		//for every employee, print emp rec and dept name
		if(key.toString().contains("emp")){
			String emp_deptid=key.toString().split("_")[0];
			deptname=(emp_deptid.equalsIgnoreCase(deptid))?deptname:"Not-Found";
			for (Text val : values) {
				context.write(val, new Text(deptname));				
			}
		}
	
	}

}
