package com.inv.wc;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Partitioner;

public class AlphaPartitioner extends Partitioner<Text, IntWritable>{

	@Override
	public int getPartition(Text key, IntWritable value, int noOfPartitons) {
		
		
		//if(key.toString().length()>0){
			
			char ch=key.toString().toLowerCase().charAt(0);
			if(ch>=97 && ch<=109){
				return 0%noOfPartitons;
			}else if(ch>=110 && ch<=122){
				return 1%noOfPartitons;
			}else 
				return 2%noOfPartitons;
		
		
		/*}else
			return 2%noOfPartitons;
			*/
		
			
	}

}
