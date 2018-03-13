package com.inv.hadoop;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class GrepMapper extends Mapper<LongWritable, Text, Text, NullWritable> {

		String searchWord;
	
	@Override
	protected void setup(Mapper<LongWritable, Text, Text, NullWritable>.Context context)
			throws IOException, InterruptedException {
		Configuration	conf1=context.getConfiguration();
		 searchWord=conf1.get("sword").toLowerCase();
		 
		 System.out.println(" ++++++ name node addres::"+conf1.get("fs.defaultFS"));
		 System.out.println("++++++ COLOR value::"+conf1.get("COLOR"));
		 System.out.println("++++++ COLOR1 value::"+conf1.get("COLOR1"));
		 System.out.println("++++++ COLOR2 value::"+conf1.get("COLOR2","I am Def color"));


	}
	
	
	@Override
	protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, Text, NullWritable>.Context context)
			throws IOException, InterruptedException {
		
		String line=value.toString().toLowerCase();
		//String searchWord="HADOOP".toLowerCase();
		//String searchWord=conf1.get("sword1").toLowerCase();
		
		if(line.contains(searchWord)){
			context.write(value, NullWritable.get());
		}
		
	
	}

	
	
}
