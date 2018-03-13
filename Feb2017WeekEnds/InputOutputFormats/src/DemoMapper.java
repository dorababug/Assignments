import java.io.IOException;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class DemoMapper extends Mapper<Text, Text, Text, Text>{

	
	@Override
	protected void map(Text key, Text value, Mapper<Text, Text, Text, Text>.Context context)
			throws IOException, InterruptedException {
		context.write(new Text(key.toString()+"_$$$$"), value);
		
	}
	
	
}
