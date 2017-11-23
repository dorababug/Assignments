package com.inv.movielens;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.util.HashMap;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer.Context;

public class InvertMapper extends Mapper<LongWritable, Text,IntWritable, Text>{

	HashMap<String, String> moviesMap=new HashMap<String,String>();
	@Override
	protected void setup(Context context)
			throws IOException, InterruptedException {
		
	//the file will be copied to pwd where the Mapper or reducer runs
	URI[] paths=context.getCacheFiles();
	for (int i = 0; i < paths.length; i++) {
		System.out.println("---------added files are"+paths[i].toString());
		
	}
	
	File f=new File("movies.dat");
	BufferedReader reader=new BufferedReader(new FileReader(f));
	try{	
		String line="";
		while((line=reader.readLine())!=null){
			//001,hadoop
			String mvid=line.split("::")[0];
			String mvname=line.split("::")[1];
			moviesMap.put(mvid, mvname);
		}
	}finally{
		if(reader!=null){
			reader.close();
		}
	}
	
	
	}
	
	
		
	
@Override
protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, IntWritable, Text>.Context context)
		throws IOException, InterruptedException {
	String mvId=value.toString().split("\t")[0];
	int count=Integer.parseInt(value.toString().split("\t")[1]);
	
	String mvname=moviesMap.get(mvId.toString());
	System.out.println("*******MovieID is =="+mvname.toString());
	
	
	context.write(new IntWritable(count*-1), new Text(mvId+"#"+mvname));


}
}
