import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.MultipleInputs;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;

public class JoinDriver {

	public static void main(String[] args) throws ClassNotFoundException, IOException, InterruptedException {
		Configuration conf=new Configuration();
		
		conf.set("mapreduce.output.textoutputformat.separator", ",");
		conf.set("mapreduce.output.fileoutputformat.compress", "true");
		
		Job job=Job.getInstance(conf, "Reduce Side Joins");
		
		job.setJarByClass(JoinDriver.class);
		//job.setMapperClass(Em);
		job.setReducerClass(JoinReducer.class);
		
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(Text.class);
		
		MultipleInputs.addInputPath(job, new Path(args[0]), TextInputFormat.class, EmpMapper.class);
		MultipleInputs.addInputPath(job, new Path(args[1]), TextInputFormat.class, DeptMapper.class);
		
		FileOutputFormat.setOutputPath(job, new Path(args[2]));
		
		
		
		System.exit(job.waitForCompletion(true)?0:1);
		
		
	}
	
}
