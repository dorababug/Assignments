import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class Q1Reducer extends Reducer<Text, IntWritable, Text	, IntWritable>{
	//from map we have sent movieid , 1
	//all values for given movieid are grouped(based on key)
	// find movieid, count
	@Override
	protected void reduce(Text key, Iterable<IntWritable> values,
			Reducer<Text, IntWritable, Text, IntWritable>.Context context) throws IOException, InterruptedException {
		
			int sum=0;
			for (IntWritable val : values) {
				sum=sum+val.get();
			}
			context.write(key, new IntWritable(sum));
			//mvid, count
	}

}
