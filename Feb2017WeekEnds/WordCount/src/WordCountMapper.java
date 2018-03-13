import java.io.IOException;
import java.util.StringTokenizer;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;


public class WordCountMapper extends Mapper<LongWritable, Text, Text, IntWritable> {

	String sword="";
	@Override
	protected void setup(Mapper<LongWritable, Text, Text, IntWritable>.Context context)
			throws IOException, InterruptedException {
		
		Configuration conf=context.getConfiguration();
		 sword=conf.get("searchword");//searchword
		String sword1=conf.get("searchword1");
		String sword2=conf.get("searchword2","I am def value");
		
		System.out.println("====== sword:: "+sword);
		System.out.println("====== sword1:: "+sword1);
		System.out.println("====== sword2:: "+sword2);
		
		System.out.println("====== fs.defaultFS:: "+conf.get("fs.defaultFS"));
		System.out.println("====== map container size:: "+conf.get("mapreduce.map.memory.mb"));
		//mapreduce.map.memory.mb
	}
	
	
	enum RECORDS{
		GOOD_REC,
		BAD_REC		
	}
	
	
	@Override
	protected void map(LongWritable key, Text value, Context context)
			throws IOException, InterruptedException {
	
		//Convert Hadoop type to Javatype
			String line=value.toString();
			
			if(line.contains("[")){
				context.getCounter(RECORDS.BAD_REC).increment(1);
			}else
				context.getCounter(RECORDS.GOOD_REC).increment(1);
				
			context.getCounter("TotalRec", "numLines").increment(1);
			
			
			
			if(line.toLowerCase().contains(sword.toLowerCase())){
				context.write(value, new IntWritable(1));
			}
			
			/*StringTokenizer words=new StringTokenizer(line, " ");
			
			while(words.hasMoreTokens()){
				String word=words.nextToken();
				
				context.write(new Text(word), new IntWritable(1));
			}*/
	}
	
}


