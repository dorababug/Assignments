package com.inv.wc;

import java.io.IOException;
import java.util.StringTokenizer;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class WordCountMapper extends Mapper<LongWritable, Text, Text, IntWritable>{

	int i=0;
	
	
	@Override
	protected void setup(Mapper<LongWritable, Text, Text, IntWritable>.Context context)
			throws IOException, InterruptedException {
		System.out.println("**************I am inside MAP setup method"+i);
	}
	
	@Override
	protected void cleanup(Mapper<LongWritable, Text, Text, IntWritable>.Context context)
			throws IOException, InterruptedException {
		System.out.println("**************I am inside MAP cleanup method"+i);
	}
	
	@Override
	protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, Text, IntWritable>.Context context)
			throws IOException, InterruptedException {
	
		System.out.println("+++++++ Inside map method  == "+i);
		i++;
		
		StringTokenizer words=new StringTokenizer(value.toString(), " ");
		
		while(words.hasMoreTokens()){
			
			context.write(new Text(words.nextToken()), new IntWritable(1));
		}
		
	}
	
	
	
	
	
	
	
}
