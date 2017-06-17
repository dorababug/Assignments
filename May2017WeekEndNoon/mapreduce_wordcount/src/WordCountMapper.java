import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;


public class WordCountMapper extends Mapper<LongWritable, Text, Text, IntWritable>{

	@Override
	protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, Text, IntWritable>.Context context)
			throws IOException, InterruptedException {

			String line=value.toString();  // Convert Text to String
			String[] words=line.split(" ");
			for (int i = 0; i < words.length; i++) {
				
				String word=words[i];
				context.write(new Text(word),new IntWritable( 1));
			}
			
			
	
	}

	
}
