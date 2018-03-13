package com.inv.wc;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class WordCountReducer extends Reducer<Text, IntWritable, Text, Text>{

	@Override
	protected void setup(Reducer<Text, IntWritable, Text, Text>.Context context)
			throws IOException, InterruptedException {
		context.write(new Text("WORD \t COUNT"), NullWritable.get());
	}
	
	
	@Override
	protected void reduce(Text key, Iterable<IntWritable> values,
			Reducer<Text, IntWritable, Text, Text>.Context context) throws IOException, InterruptedException {

			int sum=0;
			
			"abc".
			
			for(IntWritable val:values){
				sum=sum+val.get();
			}
			context.write(key, new Text(sum+""));
			//System.out.println("+++++I am inside Reduce reduce method");
	
	}
	
}




