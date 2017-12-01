package com.inv.movielens;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class MovieMapper extends Mapper<LongWritable, Text, Text,Text>{
	@Override
	protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, Text, Text>.Context context)
				throws IOException, InterruptedException {
		
		String line=value.toString().replaceAll("::", "@");
		String year=line.substring(line.lastIndexOf("(")+1, line.lastIndexOf(")"));
		//System.out.println("year=="+year);
		context.write(new Text(line), new Text(year));
		
	}
	
	
}
