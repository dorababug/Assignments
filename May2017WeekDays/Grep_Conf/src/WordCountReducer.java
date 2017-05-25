import java.io.IOException;

import org.apache.commons.lang.ObjectUtils.Null;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class WordCountReducer extends Reducer<Text, NullWritable, Text, NullWritable>{

	
	@Override
	protected void setup(Context context)
			throws IOException, InterruptedException {
		
	}
	
	@Override
	protected void reduce(Text key, Iterable<NullWritable> values,
			Context context) throws IOException, InterruptedException {
		int sum=0;
		
		for(NullWritable val:values){
			context.write(key,val);
					
		}
		
	
	
	}
	
	
	
}
