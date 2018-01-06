package com.inv;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Partitioner;

public class AlphaPartitioner extends Partitioner<Text, IntWritable>{

	@Override
	public int getPartition(Text key, IntWritable arg1, int noOfReducers) {
		char ch=key.toString().toLowerCase().charAt(0);
		//for proper resulsts set reduce tasks to 27
		if(ch>=97 && ch<=122){ //A-z
			return (ch-97)%noOfReducers;
		}else return 26%noOfReducers;
	}

	/*@Override
	public int getPartition(Text key, IntWritable value, int noOfReducers) {
		char ch=key.toString().toLowerCase().charAt(0);
		if(ch>=97 && ch<=109){
			return 0;
		}
		else if(ch>109 && ch<=122){
			return 1;
		}else return 2;
	}*/
	

}
