
import java.io.IOException;
import java.util.StringTokenizer;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class WordCountMapper extends Mapper<LongWritable, Text, Text, IntWritable>{
	
	IntWritable ONE=new IntWritable(1);
	@Override
	protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, Text, IntWritable>.Context context)
			throws IOException, InterruptedException {
			StringTokenizer words=new StringTokenizer(value.toString()," ");
			
/*//			String[] words1=value.toString().split(" ");
//			for (int i = 0; i < words1.length; i++) {
//				context.write(new Text(words1[i]), new IntWritable(1));
//			}
*/			
			while(words.hasMoreTokens()){
				String word=words.nextToken();
				context.write(new Text(word), ONE);
			}
			
	}

}
