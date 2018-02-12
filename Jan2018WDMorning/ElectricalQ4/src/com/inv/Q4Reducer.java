package com.inv;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class Q4Reducer extends Reducer<IntWritable, Text, Text, Text>{
	int minConsumption;
	int maxConsumption;
	String minYears="";
	String maxYears="";
	int i=0;
	@Override
	protected void reduce(IntWritable key, Iterable<Text> values, Reducer<IntWritable, Text, Text, Text>.Context context)
			throws IOException, InterruptedException {
		//0,<2000,1985>
			if(i==0){
				minConsumption=key.get();
				for (Text val:values){
					minYears=minYears+val.toString();
					minYears=minYears+",";
					i=1;
				}
			}
			
			 maxYears="";
			if(i!=0){
				maxConsumption=key.get();
				for (Text val:values){
					maxYears=maxYears+val.toString();
					maxYears=maxYears+",";
				}
			}
	}
	@Override 
	protected void cleanup(Reducer<IntWritable, Text, Text, Text>.Context context)
			throws IOException, InterruptedException {
		context.write(new Text("Min Consumption"), new Text(minConsumption+"\t"+minYears));
		context.write(new Text("Max Consumption"), new Text(maxConsumption+"\t"+maxYears));
	}
	

}
