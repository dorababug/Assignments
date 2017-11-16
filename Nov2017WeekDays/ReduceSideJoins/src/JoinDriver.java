import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.compress.GzipCodec;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.MultipleInputs;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;

public class JoinDriver extends Configured implements Tool {
		
	@Override
	public int run(String[] arg0) throws Exception {
		
		//command line args::/home/hadoop/inputFiles/input/emp  /home/hadoop/inputFiles/input/dept  /home/hadoop/inputFiles/input/ReduceSideJoinOutput
		for (int i = 0; i < arg0.length; i++) {
			System.out.println("Arguemnts in RUN are ="+arg0[i]);

		}
		Configuration conf=this.getConf();
		conf.set("mapreduce.output.textoutputformat.separator", ",");
		
		Job job=Job.getInstance(conf,"Reduce Side Joins");
		
		job.setJarByClass(JoinDriver.class);
		//job.setMapperClass(WordCountMapper.class);
		job.setReducerClass(JoinReducer.class);
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(Text.class);
		
		//FileInputFormat.addInputPath(job, new Path(arg0[0]));
		//EMp data set is first arg
		MultipleInputs.addInputPath(job, new Path(arg0[0]), TextInputFormat.class, EmpMapper.class);
		MultipleInputs.addInputPath(job, new Path(arg0[1]), TextInputFormat.class, DeptMapper.class);
		
		FileOutputFormat.setOutputPath(job, new Path(arg0[2]));
		return job.waitForCompletion(true)?0:1;
			
	}
	
	public static void main(String[] args) throws Exception {
		for (int i = 0; i < args.length; i++) {
			System.out.println("Arguemnts in MAIN are ="+args[i]);

		}
		
		int status=ToolRunner.run(new JoinDriver(), args);
		System.exit(status);
		
	}

	
}
