mport java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class Reducer1 extends Reducer<LongWritable, Text, Text, Text>{
	@Override
	protected void reduce(LongWritable key, Iterable<Text> values, Reducer<LongWritable, Text, Text, Text>.Context context)
			throws IOException, InterruptedException {
		
		for (Text val : values) {
			context.write(new Text(key.get()+"++++"),val);
		}
		
		
	}

}
