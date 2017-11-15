import java.io.IOException;
import java.util.StringTokenizer;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

// Provide key in /value in and k/v out data types
// Generics 
public class WordCountMapper extends 
	Mapper<LongWritable, Text, Text, IntWritable>{
	@Override
	protected void map(LongWritable key, Text value, Context context)
			throws IOException, InterruptedException {
		//System.out.println("++++++++++++++++Inside Mapper Map Method");
		//(0, line )
		//String[] words=value.toString().split(" ");
		
		StringTokenizer words=new StringTokenizer(value.toString(), " ");
		while(words.hasMoreTokens()){
			String word=words.nextToken();
			
			//Send word,1 , convert them into writables
			context.write(new Text(word), new IntWritable(1));
		}
	
	}

}
