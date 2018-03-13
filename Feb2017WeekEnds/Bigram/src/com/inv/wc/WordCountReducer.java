package com.inv.wc;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class WordCountReducer extends Reducer<TextPair, IntWritable, Text, Text>{

		
	
	@Override
	protected void reduce(TextPair key, Iterable<IntWritable> values,
			Reducer<TextPair, IntWritable, Text, Text>.Context context) throws IOException, InterruptedException {

			int sum=0;
			
		
			for(IntWritable val:values){
				sum=sum+val.get();
			}
			context.write(new Text(key.toString()), new Text(sum+""));
			//System.out.println("+++++I am inside Reduce reduce method");
	
	}
	
}




