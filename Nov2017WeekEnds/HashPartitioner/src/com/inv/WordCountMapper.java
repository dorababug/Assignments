package com.inv;

import java.io.IOException;
import java.util.StringTokenizer;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class WordCountMapper extends 
	Mapper<LongWritable, Text, IntWritable	, IntWritable>{
	@Override
	protected void map(LongWritable key, Text value, 
				Mapper<LongWritable, Text, IntWritable, IntWritable>.Context context)
			throws IOException, InterruptedException {
	
		StringTokenizer words=new StringTokenizer(value.toString(), " ");
		while(words.hasMoreTokens()){
			String word=words.nextToken();
			System.out.println("Hashcode of --"+word+"-- is="+word.hashCode());
			Integer i=100;
			System.out.println("Hashcode of --"+i+"-- is="+i.hashCode());
			System.out.println("Hashcode of --"+"100"+"-- is="+"100".hashCode());

			
			context.write(new IntWritable(Integer.parseInt(word)), new IntWritable(1));
		}
		
		
	}

}
