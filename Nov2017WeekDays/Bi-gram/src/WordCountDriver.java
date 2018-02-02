import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.SequenceFile.CompressionType;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.SequenceFileAsBinaryInputFormat;
import org.apache.hadoop.mapreduce.lib.input.SequenceFileAsTextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.SequenceFileOutputFormat;

public class WordCountDriver {
	public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
		
		Configuration conf=new Configuration();
		Job job=Job.getInstance(conf,"Word Count");
		
		job.setJarByClass(WordCountDriver.class);
		job.setMapperClass(WordCountMapper.class);
		//job.setNumReduceTasks(0);
		job.setReducerClass(WordCountReducer.class);
		
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(IntWritable.class);
		
		FileInputFormat.addInputPath(job, new Path(args[0]));
		FileOutputFormat.setOutputPath(job, new Path(args[1]));
		boolean result=job.waitForCompletion(true);
		int status=result?0:1;		
		System.exit(status);	
		
		
	}
}
