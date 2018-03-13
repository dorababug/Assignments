package com.inv.wc;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class WordCountReducer extends Reducer<Text, IntWritable, Text, Text>{

	@Override
	protected void setup(Reducer<Text, IntWritable, Text, Text>.Context context)
			throws IOException, InterruptedException {
		System.out.println("**************I am inside Reduce setup method");
		context.write(new Text("WORD"), new Text("COUNT"));
	}
	
	
	@Override
	protected void cleanup(Reducer<Text, IntWritable, Text, Text>.Context context)
			throws IOException, InterruptedException {
		System.out.println("========I am inside Reduce CLeanup method");
	}
	
	int sum=0;
	@Override
	protected void reduce(Text key, Iterable<IntWritable> values,
			Reducer<Text, IntWritable, Text, Text>.Context context) throws IOException, InterruptedException {

			sum=0;
			
			for(IntWritable val:values){
				sum=sum+val.get();
			}
			context.write(key, new Text(sum+""));
			//System.out.println("+++++I am inside Reduce reduce method");
	
	}
	
}




