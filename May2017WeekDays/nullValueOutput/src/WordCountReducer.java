import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class WordCountReducer extends Reducer<Text, IntWritable, Text, NullWritable>{

	
	@Override
	protected void setup(Context context)
			throws IOException, InterruptedException {
		
	}
	
	@Override
	protected void reduce(Text key, Iterable<IntWritable> values,
			Context context) throws IOException, InterruptedException {
		int sum=0;
		
		for(IntWritable val:values){
			sum=sum+val.get();
					
		}
		context.write(key,NullWritable.get());
	
	
	}
	
	
	
}
