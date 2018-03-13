import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class MoviesMapper extends Mapper<LongWritable, Text, Text, Text>{

	@Override
	protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, Text, Text>.Context context)
			throws IOException, InterruptedException {
		
		String movieRec=value.toString().replace('#', ' ').replaceAll("::", "#");
		//String[] movieRec=value.toString().split("::");
		
		
		//int beginIndex=movieRec.indexOf('(');
		//int endIndex=movieRec.indexOf(')');
		
		int beginIndex=movieRec.lastIndexOf('(');
		int endIndex=movieRec.lastIndexOf(')');
		
		String year=movieRec.substring(beginIndex+1, endIndex);
		
		
		
		context.write(new Text(movieRec), new Text(year));
		
	}
	
}
