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
		
		Job job1=Job.getInstance(conf, "MovieLens");
		job1.setJarByClass(MovieLensDriver.class);
		job1.setMapperClass(MovieMapper.class);
		job1.setReducerClass(Q1Reducer.class);
		job1.setOutputKeyClass(Text.class);
		job1.setOutputValueClass(IntWritable.class);
		
		FileInputFormat.addInputPath(job1,new Path(arg0[0]));
		FileOutputFormat.setOutputPath(job1, new Path(arg0[1]));
		
		if( job1.waitForCompletion(true)){
			conf.set("mapreduce.output.textoutputformat.separator", "#");
			Job job2=Job.getInstance(conf, "MovieLens");
			job2.setJarByClass(MovieLensDriver.class);
			job2.setMapperClass(InvertMapper.class);
			job2.setReducerClass(Top10Reducer.class);
			job2.setOutputKeyClass(Text.class);
			job2.setOutputValueClass(IntWritable.class);
			
			job2.setMapOutputKeyClass(IntWritable.class);
			job2.setMapOutputValueClass(Text.class);
			FileInputFormat.addInputPath(job2,new Path(arg0[1]));
			FileOutputFormat.setOutputPath(job2, new Path(arg0[2]));
			
			job2.addCacheFile(new URI("/home/hadoop/Music/Classes/MovieLens-Work/ml-1m/movies.dat"));
			
			return job2.waitForCompletion(true)?0:1;
					
		}else {
			return 1;
		}
		
			
	}
	public static void main(String[] args) throws Exception {
		System.exit(ToolRunner.run(new MovieLensDriver(), args));
	}
	

}
