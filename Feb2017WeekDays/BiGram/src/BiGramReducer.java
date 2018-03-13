import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class BiGramReducer extends Reducer<TextPair, IntWritable, Text, IntWritable> {

	@Override
	protected void reduce(TextPair key, Iterable<IntWritable> values,
			Reducer<TextPair, IntWritable, Text, IntWritable>.Context context) throws IOException, InterruptedException {
		
		int sum=0;
		for(IntWritable value:values){
			sum=sum+value.get();		
		}
		
		context.write(new Text(key.toString()), new IntWritable(sum));
	
	}
	
	

	
	
}
