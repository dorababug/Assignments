import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class WordCountMapper extends Mapper<LongWritable, Text, TextPair, IntWritable>{

	ArrayList<String> ls=new ArrayList<String>();
	
	@Override
	protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, TextPair, IntWritable>.Context context)
			throws IOException, InterruptedException {

		// Convert Text into String
		String line=value.toString();
		
	/*	String[] words=line.split(" ");
		for (int i = 0; i < words.length; i++) {
			context.write(new Text(words[i]), new IntWritable(1));
		}*/
		
		
		//Convert line into words
		StringTokenizer words=new StringTokenizer(line, " ");
		
		//Take each word and send out of mapper (words,1)
		while(words.hasMoreTokens()){
			String word=words.nextToken();
			
			//String to Text 
			ls.add(word);
		}
	
	}
	
	@Override
	protected void cleanup(Mapper<LongWritable, Text, TextPair, IntWritable>.Context context)
			throws IOException, InterruptedException {
		for(int i=0;i<ls.size()-1;i++){
			context.write(new TextPair(ls.get(i),ls.get(i+1)), new IntWritable(1));
		}
	}

	
	
	
}
