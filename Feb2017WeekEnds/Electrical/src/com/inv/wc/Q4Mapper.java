package com.inv.wc;

import java.io.IOException;
import java.util.StringTokenizer;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class Q4Mapper extends Mapper<LongWritable, Text, Text, Text>{
	
	int min=99999;
	int max=-99999;
	
	String minYear="";
	String maxYear="";
	
	
	@Override
	protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, Text, Text>.Context context)
			throws IOException, InterruptedException {
		String[] val=value.toString().split(",");
		
		//Leave year, last value which is average
		for (int i = 1; i < val.length-1; i++) {
			
			if(min > Integer.parseInt(val[i])){
				min=Integer.parseInt(val[i]);
				minYear=val[0];
			}
			if(max < Integer.parseInt(val[i])){
				max=Integer.parseInt(val[i]);
				maxYear=val[0];
			}
			
		}
	
	}	
	
	@Override
	protected void cleanup(Mapper<LongWritable, Text, Text, Text>.Context context)
			throws IOException, InterruptedException {
		context.write(new Text("Min Temp"), new Text(min+"\t"+minYear));
		context.write(new Text("Max Temp"), new Text(max+"\t"+maxYear));
	}
	
	
	
}










