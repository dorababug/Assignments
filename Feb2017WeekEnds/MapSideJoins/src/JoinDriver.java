import java.io.IOException;
import java.net.URI;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.SequenceFile.CompressionType;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.compress.GzipCodec;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.MultipleInputs;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.SequenceFileOutputFormat;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;

public class JoinDriver extends Configured implements Tool{

	@Override
	public int run(String[] arg0) throws Exception {
		
		Configuration conf=this.getConf();
		conf.set("mapreduce.output.textoutputformat.separator", ",");
		Job job=Job.getInstance(conf);
		
		job.addCacheFile(URI.create("file:///home/hadoop/YARNBOX/WORKSPACES/Sept2016WEBatch_GitRepo/SET2/MapReduceCode/Joins-MapReduce/input/dept"));
		
		URI[] uri=job.getCacheFiles();
		for (int i = 0; i < uri.length; i++) {
			System.out.println("Addedfiles are:::"+uri[i].toString());
		}
		
		
		job.setJarByClass(JoinDriver.class);
		job.setMapperClass(EmpMapper.class);
		//job.setReducerClass(JoinReducer.class);
		
		job.setNumReduceTasks(0);
		
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(Text.class);
			
		
		job.setOutputFormatClass(SequenceFileOutputFormat.class);
		SequenceFileOutputFormat.setOutputCompressionType(job, CompressionType.BLOCK);
		Date now = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("hh_mm_ss");
		String time = dateFormat.format(now);
		
		FileInputFormat.addInputPath(job, new Path(arg0[0]));
		
		FileOutputFormat.setOutputPath(job, new Path(arg0[1]+"_"+time));
			
		return job.waitForCompletion(true)?0:1;
	}
		
	public static void main(String[] args) throws Exception {
		
		int res=ToolRunner.run(new JoinDriver(), args);
		System.exit(res);
		
		
	}

	
}








