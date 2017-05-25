import java.io.IOException;
import java.util.StringTokenizer;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class WordCountMapper extends Mapper<LongWritable, Text,Text, IntWritable>{

	@Override
	protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, Text, IntWritable>.Context context)
			throws IOException, InterruptedException {
	
		System.out.println("======= Inside Mapper map:::"+value.toString());
		
		
		/*String[] words = value.toString().split(" ");
		
		 for (int i = 0; i < words.length; i++) {
			 
			 context.write(new Text(words[i]), new IntWritable(1));
			
		}*/
		
		
		StringTokenizer words=new StringTokenizer(value.toString(), " ");
		while(words.hasMoreTokens()){
			context.write(new Text(words.nextToken()), new IntWritable(1));
		}
	}
	
	
}
