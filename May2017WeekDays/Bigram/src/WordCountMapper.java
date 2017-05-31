import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class WordCountMapper extends Mapper<LongWritable, Text,TextPair, IntWritable>{

	ArrayList<String> list=new ArrayList<String>();
	
	@Override
	protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, TextPair, IntWritable>.Context context)
			throws IOException, InterruptedException {
	
		String[] words = value.toString().split(" ");
		
		 for (int i = 0; i < words.length; i++) {
			 
			 list.add(words[i]);
			
		}
	
	}
	@Override
	protected void cleanup(Mapper<LongWritable, Text, TextPair, IntWritable>.Context context)
			throws IOException, InterruptedException {
		for(int i=0;i<list.size()-1;i++){
			
			TextPair tp=new TextPair(list.get(i),list.get(i+1));
			
			context.write(tp, new IntWritable(1));
		}
	}
	
	
}
