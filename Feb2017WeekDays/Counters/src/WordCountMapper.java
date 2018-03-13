import java.io.IOException;
import java.util.StringTokenizer;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class WordCountMapper  extends Mapper<LongWritable, Text, Text, IntWritable>{

		enum RECORDS{
			BAD_RECORDS,
			GOOD_RECORDS
		}
	
	
		@Override
		protected void map(LongWritable key, Text value, Context context)
				throws IOException, InterruptedException {
			

			context.getCounter("TotalLines", "noOfLines").increment(1);

			
			
			if(value.toString().contains("[")){
				context.getCounter(RECORDS.BAD_RECORDS).increment(1);
			}else
				context.getCounter(RECORDS.GOOD_RECORDS).increment(1);
			
			
			
			StringTokenizer tokens=new StringTokenizer(value.toString(), " ");
			while(tokens.hasMoreElements()){
				context.write(new Text(tokens.nextToken()), new IntWritable(1));
			}
			
			System.out.println("================I am in Map method");
			
		
		}
	
	
}
