package com.inv;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Partitioner;

public class AlphaPartitioner extends Partitioner<Text, IntWritable>{
   // Aa -> part 0
   // zZ -> part 25
	//rest all part 26
	//set number of reduce tasks 27
	@Override
	public int getPartition(Text key, IntWritable value, int noOfReducers) {
	System.out.println("*****INSIDE PARTITIONER");
		char ch=key.toString().toLowerCase().charAt(0);
		/*if(ch >=97 && ch <=109){
			return 0;
		}
		else if(ch >109 && ch <=122){
			return 1;
		}else return 2;*/
		if(ch>=97 && ch<=122){
			return ch-97;
		}else
			return 26;
	}

}
