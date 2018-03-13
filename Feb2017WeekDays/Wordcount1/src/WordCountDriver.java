import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.compress.GzipCodec;
import org.apache.hadoop.io.compress.BZip2Codec;
import org.apache.hadoop.io.compress.Lz4Codec;
import org.apache.hadoop.io.compress.SnappyCodec;

import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;


public class WordCountDriver {

	public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
		Configuration conf=new Configuration();
		
		/*conf.set("mapreduce.output.fileoutputformat.compress", "true");
		conf.set("mapreduce.output.fileoutputformat.compress.codec", "org.apache.hadoop.io.compress.GzipCodec");
		*/
		
		/*conf.set("mapreduce.map.output.compress", "true");
		conf.set("mapreduce.map.output.compress.codec", "org.apache.hadoop.io.compress.GzipCodec");
		*/
		//conf.set(Job.MAP_OUTPUT_COMPRESS, "true");
		

		Job job=Job.getInstance(conf, " Sample WC prog");
		
		job.setJarByClass(WordCountDriver.class);
		job.setMapperClass(WordCountMapper.class);
		job.setReducerClass(WordCountReducer.class);
		
	//	job.setCombinerClass(WordCountCombiner.class);
		
		//job.setNumReduceTasks(27);
		//job.setPartitionerClass(MyPart.class);
		
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(IntWritable.class);
		
		FileInputFormat.addInputPath(job, new Path(args[0]));
		FileOutputFormat.setOutputPath(job, new Path(args[1]));
		
		/*FileOutputFormat.setCompressOutput(job, true);
		FileOutputFormat.setOutputCompressorClass(job, GzipCodec.class);
		*/
		boolean res=job.waitForCompletion(true);
		System.exit(res?0:1);
		
		
		
	}
	
}
