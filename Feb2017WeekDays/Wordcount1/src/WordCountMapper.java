import java.io.IOException;
import java.util.StringTokenizer;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class WordCountMapper  extends Mapper<LongWritable, Text, Text, IntWritable>{

		@Override
		protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, Text, IntWritable>.Context context)
				throws IOException, InterruptedException {
			
			/*String[] words=value.toString().split(" ");
			
			for (int i = 0; i < words.length; i++) {
				context.write(new Text(words[i]), new IntWritable(1));
			}*/
			
			StringTokenizer tokens=new StringTokenizer(value.toString(), " ");
			while(tokens.hasMoreElements()){
				context.write(new Text(tokens.nextToken()), new IntWritable(1));
			}
			
			System.out.println("================I am in Map method");
			
		
		}
	
	
}
