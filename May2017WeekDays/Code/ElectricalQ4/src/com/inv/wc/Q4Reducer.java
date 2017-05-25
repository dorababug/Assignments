package com.inv.wc;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class Q4Reducer extends Reducer<IntWritable, IntWritable, Text, Text>{

	int min;
	int i=0;
	StringBuffer minYears=new StringBuffer();
	int max;
	StringBuffer maxYears;
	
	
	@Override
	protected void reduce(IntWritable key, Iterable<IntWritable> values,
			Reducer<IntWritable, IntWritable, Text, Text>.Context context) throws IOException, InterruptedException {
		System.out.println("++++++++"+key.toString());
		if(i==0){
			i++;
			min=key.get();
			for(IntWritable val:values){
				minYears.append(val).append(",");
			}
		}
		
		max=key.get();
		maxYears=new StringBuffer();
		for(IntWritable val:values){
			maxYears.append(val).append(",");
		}
		
	}
	@Override
	protected void cleanup(Reducer<IntWritable, IntWritable, Text, Text>.Context context)
			throws IOException, InterruptedException {
		context.write(new Text("Min Temp"), new Text(min+"\t"+minYears));
		context.write(new Text("Max Temp"), new Text(max+"\t"+maxYears));
	}
	
}
