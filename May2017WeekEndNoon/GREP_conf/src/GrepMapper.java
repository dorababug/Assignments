import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class GrepMapper extends Mapper<LongWritable, Text, Text,NullWritable>{
	
	IntWritable one=new IntWritable(1);
	
	String sword="";
	
	@Override
	protected void setup(Mapper<LongWritable, Text, Text, NullWritable>.Context context)
			throws IOException, InterruptedException {
	
		Configuration conf=context.getConfiguration();
		 sword=conf.get("searchWord");
		
		System.out.println("+++++++ Search word is::"+sword);
		System.out.println("+++++++ Search word1 is::"+conf.get("searchWord1"));
		System.out.println("+++++++ Search word2 is::"+conf.get("searchWord2","I am Def value"));
		
	}
	
	@Override
	protected void map(LongWritable key, Text value, Context context)
			throws IOException, InterruptedException {
			
		
		if(value.toString().toLowerCase().contains(sword.toLowerCase())){
			context.write(value, NullWritable.get());
		}
	}

}
