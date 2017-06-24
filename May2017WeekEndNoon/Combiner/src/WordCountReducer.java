import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class WordCountReducer extends Reducer<Text, IntWritable, Text, Text>{
	
	@Override
	protected void setup(Reducer<Text, IntWritable, Text, Text>.Context context)
			throws IOException, InterruptedException {
	
	}
	@Override
	protected void reduce(Text key, Iterable<IntWritable> values,
			Reducer<Text, IntWritable, Text, Text>.Context context) throws IOException, InterruptedException {
		
		int sum=0;
		
		//short hand for loop
		for (IntWritable val : values) {
			sum = sum + val.get();
			
		}
		context.write(key, new Text(sum+""));
	
	
	
	}

}
