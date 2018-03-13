package com.inv.hadoop;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration; 
import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;

public class GrepDriver extends Configured implements Tool {
	
	@Override
	public int run(String[] arg0) throws Exception {
		
		for (int i = 0; i < arg0.length; i++) {
			System.out.println("+++ Argument:"+i+"=  "+arg0[i]);
		}
		
		Configuration conf=this.getConf();//  Configuration();
		Job job=Job.getInstance(conf, "Grep Code");
				
			
			job.setJarByClass(GrepDriver.class);
			job.setMapperClass(GrepMapper.class);
			
			job.setNumReduceTasks(0);
			
			job.setOutputKeyClass(Text.class);
			job.setOutputValueClass(NullWritable.class);
			//FileInputFormat.addInputPat
			
			
		/*	FileSystem fs=FileSystem.get(conf);
			if(fs.exists(new Path(args[1]))){
				fs.delete(new Path(args[1]),true);
			} */
			
			
			
			FileInputFormat.addInputPath(job, new Path(arg0[0]));
			//FileInputFormat.addInputPath(job, new Path(args[1]));
			FileOutputFormat.setOutputPath(job, new Path(arg0[1]));
			
			
			boolean res=job.waitForCompletion(true);
			
			return res?0:1;
			
	}
	
	
	public static void main(String[] args) throws Exception {
		
		for (int i = 0; i < args.length; i++) {
			System.out.println("+++ Argument:"+i+"=  "+args[i]);
		}
		
		
		int status=ToolRunner.run(new GrepDriver(), args);
		System.exit(status);
	}

}
