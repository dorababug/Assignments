package com.inv;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class WordCountReducer extends Reducer<Text, IntWritable, Text, Text>{
	@Override
	protected void setup(Context context)
			throws IOException, InterruptedException {
		context.write(new Text("WORD"), new Text("Count"));
	}
	
	@Override
	protected void reduce(Text key, Iterable<IntWritable> values,
			Context context) throws IOException, InterruptedException {
		
		// hi,<1,1,1,1,1>
		// mapreduce,<1,1,1>
		
		int sum=0;
		// values <1,1,1,1> 
		for(IntWritable val:values){
			sum=sum+val.get();
		}
		context.write(key, new Text(sum+""));
		
	}
}








