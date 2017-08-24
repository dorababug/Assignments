package com.inv;

import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class EmpMapper extends Mapper<LongWritable, Text, Text,Text>{
	@Override
	protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, Text, Text>.Context context)
			throws IOException, InterruptedException {
			//1,name,2000,001
		String deptid=value.toString().split(",")[3];
		context.write(new Text(deptid+"_emp"), value);
	//001_emp ,   1,name,2000,001
	
	}

}
