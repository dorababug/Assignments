package com.inv;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class Q1Mapper extends Mapper<LongWritable, Text, Text, Text>{
	@Override
	protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, Text, Text>.Context context)
			throws IOException, InterruptedException {
		//1@1@1193@One Flew Over the Cuckoo's Nest (1975)@5
		//2. Top twenty rated movies 
		//(Condition : The movie should be rated/viewed by at least 40 users)
	
		//get mvid,name,rating-> kout and vout -> mvid,  rating,mvname
		//Reducer 
		// Loop all the movies -> get the no elements and sum of rating
		// if the no elememnts > 40 -> find average and send it out.
		
		String[] record=value.toString().split("@");
		//movieid, rating, moviename
		context.write(new Text(record[2]), new Text(record[4]+"@"+record[3]));
		
	}

}
