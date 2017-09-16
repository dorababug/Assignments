package com.inv;

import java.io.IOException;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class JoinReducer extends Reducer<Text, Text, Text, Text>{
	
	
	String deptName="";
	String deptId="";
	
	@Override
	protected void setup(Reducer<Text, Text, Text, Text>.Context context) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		context.write(new Text("EmpID,EmpName,EmpSal,EmpDept"), new Text("DeptName"));
	}
	
	@Override
	protected void reduce(Text key, Iterable<Text> values, Reducer<Text, Text, Text, Text>.Context context)
			throws IOException, InterruptedException {
		//001_dept,hadoop
		//001_emp, <1,name,2000,001 >
		//002_dept ,<hive>
		//002_emp,<2,name2,4000,002    ,7,name7,4000,002  >
		
		//Get dept name
		if(key.toString().contains("dept")){
			for (Text val : values) {
				deptName=val.toString();
				deptId=key.toString().split("_")[0];
			}
		}
		if(key.toString().contains("emp")){
			for (Text val : values) {
				String emp_deptId=key.toString().split("_")[0];
				if(!deptId.equals(emp_deptId)){
					deptName="Not-Found";
				}
				//Emp rec and the dept for that employee
				context.write(val, new Text(deptName));
			}
		}
		
		
	}

}
