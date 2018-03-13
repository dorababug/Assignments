package com.inv.wc;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;


public class WordCountDriver {
		
	public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
		Configuration conf=new Configuration();
		
		Job job=Job.getInstance(conf, "WC Program");
		
		job.setJarByClass(WordCountDriver.class);
		job.setMapperClass(WordCountMapper.class);
		job.setReducerClass(WordCountReducer.class);
		
		job.setCombinerClass(WordCountReducer.class);
		
		//job.setNumReduceTasks(0);
		
		//job.setMapOutputKeyClass(theClass);
		
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(IntWritable.class);
		
		FileInputFormat.addInputPath(job, new Path(args[0]));
	//	FileInputFormat.addInputPath(job, new Path(args[1]));
	//	FileInputFormat.addInputPath(job, new Path(args[2]));
		FileOutputFormat.setOutputPath(job, new Path(args[1]));
		
		boolean status=job.waitForCompletion(true);
		
		System.exit(status?0:1);
		
		
	}

}








