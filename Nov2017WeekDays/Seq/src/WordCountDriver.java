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
		
		//Job object
		//We create job obeject by passing configuration
		Configuration conf=new Configuration();
		//Create Job obejct
		//Job job=new Job();
		Job job=Job.getInstance(conf,"Word Count");
		
		//Entry point
		job.setJarByClass(WordCountDriver.class);
		//what is the mapper
		//job.setMapperClass(SeqMapper.class);
		//What is reducer
		//job.setReducerClass(WordCountReducer.class);
	job.setNumReduceTasks(0);
		//when job ip types and o/p types are diff
		//we need to specify the data types which job emits.
		
		job.setMapOutputKeyClass(Text.class);
		job.setMapOutputValueClass(IntWritable.class);
		//job.setOutputKeyClass(Text.class);
		//job.setOutputValueClass(IntWritable.class);
		
		//job.setOutputFormatClass(SequenceFileOutputFormat.class);
		job.setInputFormatClass(SequenceFileAsTextInputFormat.class);
		FileInputFormat.addInputPath(job, new Path(args[0]));
		
		FileOutputFormat.setOutputPath(job, new Path(args[1]));
		//SequenceFileOutputFormat.setOutputCompressionType(job, CompressionType.BLOCK);
	
		
		//FileInputFormat<K, V>
		//Start MR job
		//wait for the progress
		boolean result=job.waitForCompletion(true);
		int status=result?0:1;		
		System.exit(status);	
		
		
	}
}
