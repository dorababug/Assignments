package com.inv.movielens;

import java.net.URI;

import javax.swing.tree.FixedHeightLayoutCache;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;

public class MovieLensDriver extends Configured implements Tool{

	@Override
	public int run(String[] arg0) throws Exception {
		Configuration conf=this.getConf();
		conf.set("mapreduce.output.textoutputformat.separator", "@");
		
		Job job1=Job.getInstance(conf, "MovieLens");
		job1.setJarByClass(MovieLensDriver.class);
		job1.setMapperClass(MovieMapper.class);
		//job1.setReducerClass(Q1Reducer.class);
		job1.setNumReduceTasks(0);
		job1.setOutputKeyClass(Text.class);
		job1.setOutputValueClass(IntWritable.class);
		
		FileInputFormat.addInputPath(job1,new Path(arg0[0]));
		FileOutputFormat.setOutputPath(job1, new Path(arg0[1]));
		
		 return job1.waitForCompletion(true)?0:1;
		
			
	}
	public static void main(String[] args) throws Exception {
		System.exit(ToolRunner.run(new MovieLensDriver(), args));
	}
	

}
