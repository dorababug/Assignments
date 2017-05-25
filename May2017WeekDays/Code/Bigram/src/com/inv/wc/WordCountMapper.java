package com.inv.wc;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import org.apache.avro.generic.GenericData.StringType;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class WordCountMapper extends Mapper<LongWritable, Text, TextPair, IntWritable>{

	List<String> ls = new ArrayList<String>();
	
	@Override
	protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, TextPair, IntWritable>.Context context)
			throws IOException, InterruptedException {
		StringTokenizer words=new StringTokenizer(value.toString(), " ");

		while(words.hasMoreTokens()){
			ls.add(words.nextToken());
		}
		
	}
	
	@Override
	protected void cleanup(Mapper<LongWritable, Text, TextPair, IntWritable>.Context context)
			throws IOException, InterruptedException {
		
		for (int i=0;i<ls.size()-1;i++) {
			//String pair=ls.get(i)+" "+ls.get(i+1);
			
			TextPair tp=new TextPair(ls.get(i),ls.get(i+1));
			
			context.write(tp, new IntWritable(1));
			
		}
		
		
	}
	
	
	
	
	
	
	
	
}
