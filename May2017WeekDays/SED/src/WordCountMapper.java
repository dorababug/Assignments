import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class WordCountMapper extends Mapper<LongWritable, Text,Text, NullWritable>{

	@Override
	protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, Text, NullWritable>.Context context)
			throws IOException, InterruptedException {
	//If any line that contains hadoop Hadoop HADOOP , output the line
		//else dont print
		if(value.toString().toLowerCase().contains("hadoop")){
			
				
			context.write(new Text(value.toString().replaceAll("Hadoop", "SPARK")), NullWritable.get());
		}else
			context.write(value, NullWritable.get());
		
	}
	
	
}
