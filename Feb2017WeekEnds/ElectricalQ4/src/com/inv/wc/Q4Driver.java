package com.inv.wc;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;


public class Q4Driver {
		
	public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
		
		/*if(args.length<2){
			System.out.println("Wrong no of args");
			System.out.println("usage is jar mainclass ip op");
			System.exit(1);
		}*/
		
		Configuration conf=new Configuration();
		
		Job job=Job.getInstance(conf);
		job.setJobName("Electrical Q1");
		
		job.setJarByClass(Q4Driver.class);
		job.setMapperClass(Q4Mapper.class);
		job.setReducerClass(Q4Reducer.class);
		//job.setNumReduceTasks(0);
		
		job.setMapOutputKeyClass(IntWritable.class);
		job.setMapOutputValueClass(IntWritable.class);
		
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(Text.class);
		
		/*FileSystem fs=FileSystem.get(conf);
		if(fs.exists(new Path(args[1]))){
			fs.delete(new Path(args[1]), true);
			//fs.delete(args[1]);
		}*/
		
		
		Date now = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("hh_mm_ss");
		String time = dateFormat.format(now);
		
		FileInputFormat.addInputPath(job, new Path(args[0]));
		FileOutputFormat.setOutputPath(job, new Path(args[1]+"_"+time));
		
		boolean status=job.waitForCompletion(true);
		
		System.exit(status?0:1);
		
		
	}

}








