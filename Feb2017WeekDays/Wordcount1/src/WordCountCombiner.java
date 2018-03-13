import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class WordCountCombiner extends Reducer<Text, IntWritable, Text, IntWritable>{
	
	int i=0;
	
	@Override
	protected void reduce(Text key, Iterable<IntWritable> values,
			Reducer<Text, IntWritable, Text, IntWritable>.Context context)
					throws IOException, InterruptedException {
		
		int sum=0;
		for (IntWritable value : values) {
			sum=sum+value.get();
		}
		
		context.write(key, new IntWritable(sum));
	
		System.out.println("+++++++++++++");
			
	
	}
}
