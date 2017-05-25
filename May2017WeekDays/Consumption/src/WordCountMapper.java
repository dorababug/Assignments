import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class WordCountMapper extends Mapper<LongWritable, Text,IntWritable, Text>{

	@Override
	protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, IntWritable, Text>.Context context)
			throws IOException, InterruptedException {
	
		//1979,23,23,2,43,24,25,26,26,26,26,25,26,25
		
		String[] words = value.toString().split(",");
		int year=Integer.parseInt(words[0].trim());
		
		int mintemp=9999;
		int maxtemp=-9999;
		
		 for (int i = 1; i < words.length-1; i++) {
			 int val=Integer.parseInt(words[i].trim());
			 
			 if (mintemp > val){
				 mintemp=val;
			 }
			 if (maxtemp < val){
				 maxtemp=val;
			 }
			 
			 		
		}
		context.write(new IntWritable(year), new Text(mintemp+"\t"+maxtemp));
	
	}
	
	
}
