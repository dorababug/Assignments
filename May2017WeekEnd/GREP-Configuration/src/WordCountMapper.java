import java.io.IOException;
import java.util.StringTokenizer;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class WordCountMapper extends Mapper<LongWritable, Text, Text, NullWritable>{

	String searchword="";
	
	@Override
	protected void setup(Context context)
			throws IOException, InterruptedException {
		
		Configuration conf=context.getConfiguration();
		
		System.out.println("My job name is:: "+ conf.get("mapreduce.job.name"));
		System.out.println("Number of reducers:: "+ conf.get("mapreduce.job.reduces"));
		
		System.out.println("search word "+ conf.get("sword"));
		System.out.println("search word1 "+ conf.get("sword1"));
		System.out.println("search word2 "+ conf.get("sword2","I am default value"));
		
		searchword=conf.get("sword").toLowerCase();
		
		
	}
	
	@Override
	protected void map(LongWritable key, Text value, Context context)
			throws IOException, InterruptedException {

		
		String line=value.toString().toLowerCase();
		
		if(line.contains(searchword)){
			context.write(value, NullWritable.get());
		}
	
	}	
	
}
