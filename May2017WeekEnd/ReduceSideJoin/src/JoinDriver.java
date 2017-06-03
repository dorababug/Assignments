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
		
		Job job=Job.getInstance(conf, "Reduce Side joins");
		
		job.setJarByClass(JoinDriver.class);
		//job.setMapperClass(WordCountMapper.class);
		job.setReducerClass(JoinReducer.class);
		
		
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(Text.class);
		
		//FileInputFormat.addInputPath(job, new Path(args[0]));
	
		MultipleInputs.addInputPath(job, new Path(args[0]), TextInputFormat.class, EmpMapper.class);
		MultipleInputs.addInputPath(job, new Path(args[1]), TextInputFormat.class, DeptMapper.class);
		
		FileOutputFormat.setOutputPath(job, new Path(args[2]));
		
		boolean status=job.waitForCompletion(true);
		int result=status?0:1;
		System.exit(result);
		
		
	}
	
}






