package com.inv;

import java.io.IOException;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class JoinReducer extends Reducer<Text, Text, Text, Text>{
	String deptName="";
	String deptDeptid="";
	@Override
	protected void reduce(Text key, Iterable<Text> values,
			Reducer<Text, Text, Text, Text>.Context context)
			throws IOException, InterruptedException {
		//002_dept, hive
		//002_emp ,<emprec1,emprec2>
		
		if(key.toString().contains("dept")){
			deptDeptid=key.toString().split("_")[0];//003_dept
			for (Text val : values) {
				deptName=val.toString();				
			}
		}//id is 003, name pig
		
		//002_emp ,<emprec1,emprec2>
		if(key.toString().contains("emp")){
			//for 004_emp <emp5,emp6>
			if(!key.toString().contains(deptDeptid)){
				deptName="NotFound";
			}
			for (Text val : values) {
				context.write(val, new Text(deptName));				
			}
		}
		
		
	}

}
