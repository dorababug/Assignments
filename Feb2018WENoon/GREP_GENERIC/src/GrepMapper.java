import java.io.IOException;
import java.util.StringTokenizer;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class GrepMapper extends Mapper<LongWritable, Text, Text,NullWritable>{
	String sword="";
	@Override
	protected void setup(Mapper<LongWritable, Text, Text, NullWritable>.Context context)
			throws IOException, InterruptedException {
		Configuration conf=context.getConfiguration();
		 sword=conf.get("searchword");
	   System.out.println("+++++++Inside setup method::=="+sword);
	}
	
	@Override
	protected void map(LongWritable key, Text value, Context context)
			throws IOException, InterruptedException {
		
		
		if(value.toString().toLowerCase().contains(sword.toLowerCase())){
			context.write(value, NullWritable.get());
		}	
	
	}
	
}
