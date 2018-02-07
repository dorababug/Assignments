import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class GrepMapper extends Mapper<LongWritable, Text, Text, NullWritable>{
	@Override
	protected void map(LongWritable key, Text value, 
			Mapper<LongWritable, Text, Text, NullWritable>.Context context)
			throws IOException, InterruptedException {

		String swrod="Hadoop".toLowerCase();
		String line=value.toString().toLowerCase(); 
		//convert search word and the text to same case
		if(line.contains(swrod)){
			context.write(value, NullWritable.get());
		}
	}

}
