import java.io.IOException;
import java.util.StringTokenizer;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

// Provide key in /value in and k/v out data types
// Generics 
public class SeqMapper extends 
	Mapper<Text,IntWritable, Text, Text>{
	@Override
	protected void map(Text key, IntWritable value, Context context)
			throws IOException, InterruptedException {
		System.out.println("key is =="+key.toString()+"***** Value is "+value.get());
		//context.write(key, value);
	}

}
