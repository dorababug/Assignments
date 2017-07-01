import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.MultipleInputs;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class JoinDriver {

	public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
		
		Configuration conf=new Configuration();
		conf.set("mapreduce.output.textoutputformat.separator", ",");
		Job job=Job.getInstance(conf, "WordCount");
		
		job.setJarByClass(JoinDriver.class);
		//job.setMapperClass(WordCountMapper.class);
		job.setReducerClass(JoinReducer.class);
		
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(Text.class);
		
		
		MultipleInputs.addInputPath(job, new Path(args[0]), TextInputFormat.class,EmpMapper.class);
		MultipleInputs.addInputPath(job, new Path(args[1]), TextInputFormat.class,DeptMapper.class);
		
		//FileInputFormat.addInputPath(job, new Path(args[0]));
		FileOutputFormat.setOutputPath(job, new Path(args[2]));
		
		boolean result=job.waitForCompletion(true);
		
		System.exit(result?0:1);
		
	}
	
}
