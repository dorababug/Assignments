import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.conf.Configured;
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
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;


public class BiGramDriver extends Configured implements Tool{

		@Override
		public int run(String[] arg0) throws Exception {
			Configuration conf=this.getConf();// Configuration();
			
			Job job=Job.getInstance(conf, " Sample BiGram prog");
			
			job.setJarByClass(BiGramDriver.class);
			job.setMapperClass(BiGramMapper.class);
			job.setReducerClass(BiGramReducer.class);
			
		//	job.setCombinerClass(WordCountCombiner.class);
			
			//job.setNumReduceTasks(0);
			//job.setPartitionerClass(MyPart.class);
			job.setMapOutputKeyClass(TextPair.class);
			job.setMapOutputValueClass(IntWritable.class);
			
			job.setOutputKeyClass(Text.class);
			job.setOutputValueClass(IntWritable.class);
			
			FileInputFormat.addInputPath(job, new Path(arg0[0]));
			FileOutputFormat.setOutputPath(job, new Path(arg0[1]));
			
			/*FileOutputFormat.setCompressOutput(job, true);
			FileOutputFormat.setOutputCompressorClass(job, GzipCodec.class);
			*/
			 return job.waitForCompletion(true)?0:1;
		}
		
	
	public static void main(String[] args) throws Exception {
		
		int res=ToolRunner.run(new BiGramDriver(), args);
		
		System.exit(res);
		
		
		
	}
	
}
