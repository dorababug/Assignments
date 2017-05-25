import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class WordCountMapper extends Mapper<LongWritable, Text,Text, NullWritable>{

	String searchword="";
	
	
	@Override
	protected void setup(Mapper<LongWritable, Text, Text, NullWritable>.Context context)
			throws IOException, InterruptedException {
		Configuration conf=context.getConfiguration();
		
		 searchword=conf.get("sword");
		String word1=conf.get("color1");
		String word2=conf.get("color2","I am def color");
		
		System.out.println("searchword:::"+searchword);
		System.out.println("word1:::"+word1);
		System.out.println("word2:::"+word2);
		
	}
	
	@Override
	protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, Text, NullWritable>.Context context)
			throws IOException, InterruptedException {
		
		
	//If any line that contains hadoop Hadoop HADOOP , output the line
		//else dont print
		if(value.toString().toLowerCase().contains(searchword.toLowerCase())){
			context.write(value, NullWritable.get());
		}
		
	}
	
	
}
