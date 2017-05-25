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
import org.apache.hadoop.mapreduce.lib.input.MultipleInputs;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;

public class JoinDriver extends Configured implements Tool{

	@Override
	public int run(String[] arg0) throws Exception {
		
		Configuration conf=this.getConf();
		conf.set("mapreduce.output.textoutputformat.separator", ",");
		Job job=Job.getInstance(conf);
			
		job.setJarByClass(JoinDriver.class);
		//job.setMapperClass(WordCountMapper.class);
		job.setReducerClass(JoinReducer.class);
		
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(Text.class);
			
		
		Date now = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("hh_mm_ss");
		String time = dateFormat.format(now);
		
		//FileInputFormat.addInputPath(job, new Path(arg0[0]));
		
		
		MultipleInputs.addInputPath(job, new Path(arg0[0]), TextInputFormat.class, EmpMapper.class);
		MultipleInputs.addInputPath(job, new Path(arg0[1]), TextInputFormat.class, DeptMapper.class);

		FileOutputFormat.setOutputPath(job, new Path(arg0[2]+"_"+time));
			
		return job.waitForCompletion(true)?0:1;
	}
		
	public static void main(String[] args) throws Exception {
		
		int res=ToolRunner.run(new JoinDriver(), args);
		System.exit(res);
		
		
	}

	
}








