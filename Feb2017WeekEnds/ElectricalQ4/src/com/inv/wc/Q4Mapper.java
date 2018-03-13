package com.inv.wc;

import java.io.IOException;
import java.util.StringTokenizer;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class Q4Mapper extends Mapper<LongWritable, Text, IntWritable, IntWritable>{
	
	@Override
	protected void map(LongWritable key, Text value,
			Mapper<LongWritable, Text, IntWritable, IntWritable>.Context context)
					throws IOException, InterruptedException {
		
		String[] val=value.toString().split(",");
		
		for (int i = 1; i < val.length-1; i++) {
			context.write(new IntWritable(Integer.parseInt(val[i])), new IntWritable(Integer.parseInt(val[0])));
		}
		
		
	}
	
	
	
	
	
}










