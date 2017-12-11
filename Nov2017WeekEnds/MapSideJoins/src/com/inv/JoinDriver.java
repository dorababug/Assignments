package com.inv;

import java.net.URI;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.MultipleInputs;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;


public class JoinDriver extends Configured implements Tool{

	@Override
	public int run(String[] arg0) throws Exception {
		Configuration conf=this.getConf();
		conf.set("mapreduce.output.textoutputformat.separator", ",");
		Job job=Job.getInstance(conf,"Q1");
		job.addCacheFile(
		   new URI("/home/hadoop/YARNBOX/WORKSPACES/Sept2016WEBatch_GitRepo/SET2/MapReduceCode/Joins-MapReduce/input/dept"));
		
		job.setJarByClass(JoinDriver.class);
		job.setMapperClass(EmpMapper.class);
		//job.setReducerClass(JoinReducer.class);
		job.setNumReduceTasks(0);
		
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(Text.class);
		
		FileInputFormat.addInputPath(job, new Path(arg0[0]));
		
		//MultipleInputs.addInputPath(job, new Path(arg0[0]), TextInputFormat.class, EmpMapper.class);
		//MultipleInputs.addInputPath(job, new Path(arg0[1]), TextInputFormat.class, DeptMapper.class);
		
		FileOutputFormat.setOutputPath(job, new Path(arg0[1]));
		
		return job.waitForCompletion(true)?0:1;
		
		
		
	}
	public static void main(String[] args) throws Exception {
		System.exit(ToolRunner.run(new JoinDriver(), args));
	}

}
