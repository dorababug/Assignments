import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.compress.GzipCodec;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;

public class GrepDriver extends Configured implements Tool{
	
	@Override
	public int run(String[] arg0) throws Exception {
		for (int i = 0; i < arg0.length; i++) {
		System.out.println("+++++++++ in Run Method   "+   i+"th Arg is::::"+arg0[i]);
		}		
		Configuration conf=this.getConf();
		
		
		conf.set("mapreduce.output.fileoutputformat.compress", "true");
		conf.set("mapreduce.output.fileoutputformat.compress.codec", "org.apache.hadoop.io.compress.GzipCodec");
		
		conf.set("mapreduce.map.output.compress", "true");
		//conf.set("mapreduce.output.fileoutputformat.compress.codec", "org.apache.hadoop.io.compress.GzipCodec");
		
		
		
		Job job=Job.getInstance(conf);
		
		job.setJarByClass(GrepDriver.class);
		job.setMapperClass(GrepMapper.class);
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(NullWritable.class);
				
		FileInputFormat.addInputPath(job, new Path(arg0[0]));
		FileOutputFormat.setOutputPath(job, new Path(arg0[1]));
		
		//FileOutputFormat.setCompressOutput(job, true);
		//FileOutputFormat.setOutputCompressorClass(job, GzipCodec.class);
		
		boolean result=job.waitForCompletion(true);
		return result?0:1;
	}
	public static void main(String[] args) throws Exception {
	
		for (int i = 0; i < args.length; i++) {
			System.out.println("+++++++++ in Main method   "+   i+"th Arg is::::"+args[i]);
		}
		int res=ToolRunner.run(new GrepDriver(), args);
		System.exit(res);
		
	}

	
	
}
