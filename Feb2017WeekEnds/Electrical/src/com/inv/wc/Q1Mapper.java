package com.inv.wc;

import java.io.IOException;
import java.util.StringTokenizer;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class Q1Mapper extends Mapper<LongWritable, Text, Text, Text>{
	@Override
	protected void setup(Mapper<LongWritable, Text, Text, Text>.Context context)
			throws IOException, InterruptedException {
		context.write(new Text("YEAR"), new Text("Min \t Max"));
	}
	
	@Override
	protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, Text, Text>.Context context)
			throws IOException, InterruptedException {
		String[] val=value.toString().split(",");
		String year=val[0];
		
		int min=99999;
		int max=-99999;
		//Leave year, last value which is average
		for (int i = 1; i < val.length-1; i++) {
			
			if(min > Integer.parseInt(val[i])){
				min=Integer.parseInt(val[i]);
			}
			if(max < Integer.parseInt(val[i])){
				max=Integer.parseInt(val[i]);
			}
			
		}
		
		context.write(new Text(year), new Text(min+"\t"+max));
		
		
	}
	
	
	@Override
	protected void cleanup(Mapper<LongWritable, Text, Text, Text>.Context context)
			throws IOException, InterruptedException {
		context.write(new Text("YEAR"), new Text("Min \t Max"));
	}
	
	
	
}










