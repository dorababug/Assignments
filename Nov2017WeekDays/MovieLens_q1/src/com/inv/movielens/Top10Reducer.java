package com.inv.movielens;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.util.HashMap;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.Mapper.Context;

public class Top10Reducer extends Reducer<IntWritable, Text, Text,IntWritable>{
	
	int i=0;	
	
	@Override
	protected void reduce(IntWritable key, Iterable<Text> values,
			Context context) throws IOException, InterruptedException {
		if(i<10){
			for (Text val : values) {
			
				
				context.write(val, new IntWritable(key.get()*-1));
				i=i+1;
			}
			
		}
	}

}
