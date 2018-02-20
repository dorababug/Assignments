package com.inv;

import java.io.IOException;
import java.util.StringTokenizer;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class WordCountMapper  extends Mapper<LongWritable, Text, Text, IntWritable>{
	// source-> override implement methods
	@Override
	protected void map(LongWritable key, Text value, Context context)
			throws IOException, InterruptedException {
		//Control+D to remove line in eclipse
		
		//(key=0,value=hi welcome to class)
		String line=value.toString(); //convert hadoop types to java types
		StringTokenizer words=new StringTokenizer(line," ");
		
		//Take one word and send (word,1) to output using contex.write
		while(words.hasMoreTokens()){
			String word=words.nextToken();
			//Context can only send kout,valueout types you have defined 
			//in Mapper signature
			System.out.println("********* hash code of "+word+"==="+new Text(word).hashCode());
			context.write(new Text(word), new IntWritable(1));
		}
		
	}

}











