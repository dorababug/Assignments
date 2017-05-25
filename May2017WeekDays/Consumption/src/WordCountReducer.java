import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class WordCountReducer extends Reducer<IntWritable, Text, Text, Text>{
	
	@Override
	protected void setup(Reducer<IntWritable, Text, Text, Text>.Context context)
			throws IOException, InterruptedException {
		context.write(new Text("Year"), new Text("MinTem \t MaxTemp"));
	}
	@Override
	protected void reduce(IntWritable key, Iterable<Text> values, Reducer<IntWritable, Text, Text, Text>.Context context)
			throws IOException, InterruptedException {
		
		for (Text val : values) {
			context.write(new Text(key.get()+""),val);
		}
		

	}
	
}
	
	
	
	

