import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class BiGramMapper  extends Mapper<LongWritable, Text, TextPair, IntWritable>{

		List<String> ls=new ArrayList<String>();
	
		@Override
		protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, TextPair, IntWritable>.Context context)
				throws IOException, InterruptedException {
		
			StringTokenizer words=new StringTokenizer(value.toString().toLowerCase()," ");
			
			while (words.hasMoreElements()) {
				 ls.add((String) words.nextElement());
			}			
		}
	@Override
	protected void cleanup(Mapper<LongWritable, Text, TextPair, IntWritable>.Context context)
		throws IOException, InterruptedException {
	
	  for (int i=1;i<ls.size()-1;i++) {
		  //String pair=ls.get(i)+" "+ls.get(i+1);
		context.write(new TextPair(ls.get(i),ls.get(i+1)), new IntWritable(1));
		
	}
		
	}
	
}
