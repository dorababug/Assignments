import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.compress.GzipCodec;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.SequenceFileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;

public class MovielensDriver extends Configured implements Tool{

	@Override
	public int run(String[] arg0) throws Exception {
		
	
		//Configuration conf=new Configuration();
		Configuration conf=this.getConf();
	//conf.set("searchword", "hadoop");
		
		conf.set("mapreduce.output.textoutputformat.separator", "#");
		
		Job job=Job.getInstance(conf, "Sample MR Program");
		
		job.setJarByClass(MovielensDriver.class);
		job.setMapperClass(MoviesMapper.class);
		//job.setReducerClass(WordCountReducer.class);
		job.setNumReduceTasks(0);
	//	job.setOutputKeyClass(Text.class);
	//	job.setOutputValueClass(IntWritable.class);
		
		Date now = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("hh_mm_ss");
		String time = dateFormat.format(now);
		
		//job.setInputFormatClass(SequenceFileInputFormat.class);
		
		
		FileInputFormat.addInputPath(job, new Path("/home/hadoop/Music/Classes/MovieLens-Work/ml-1m/movies.dat"));
		FileOutputFormat.setOutputPath(job, new Path("/home/hadoop/Music/Classes/MovieLens-Work/ml-1m/mvOut"+"_"+time));
		
		
		/*FileOutputFormat.setCompressOutput(job, true);
		FileOutputFormat.setOutputCompressorClass(job, GzipCodec.class);*/		
		//boolean result=job.waitForCompletion(true);
		return job.waitForCompletion(true)?0:1;
	}
		
	public static void main(String[] args) throws Exception {
		
		for (int i = 0; i < args.length; i++) {
			System.out.println("In Main method args:"+i+"::"+args[i]);
		}
		
		int res=ToolRunner.run(new MovielensDriver(), args);
		System.exit(res);
		
		
	}

	
}








