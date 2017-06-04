import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;

public class JoinDriver extends Configured implements Tool{
	 @Override
	public int run(String[] arg0) throws Exception {
		 Configuration conf=this.getConf();// Configuration();
			//conf.set("mapreduce.output.textoutputformat.separator", ",");
			Job job=Job.getInstance(conf, "Map Side joins");
			
			//job.addCacheFile(new URI("file:///home/hadoop/YARNBOX/WORKSPACES/Sept2016WEBatch_GitRepo/SET2/MapReduceCode/Joins-MapReduce/input/dept"));
			//job.addCacheFile(new URI("file:///home/hadoop/YARNBOX/WORKSPACES/Sept2016WEBatch_GitRepo/SET2/MapReduceCode/Joins-MapReduce/input/emp"));

			
			job.setJarByClass(JoinDriver.class);
			job.setMapperClass(EmpMapper.class);
			job.setNumReduceTasks(0);
			
			job.setOutputKeyClass(Text.class);
			job.setOutputValueClass(Text.class);
			
			Date now=new Date();
			SimpleDateFormat date=new SimpleDateFormat("hh_mm_ss");
			String time=date.format(now);
			
			FileInputFormat.addInputPath(job, new Path(arg0[0]));
			FileOutputFormat.setOutputPath(job, new Path(arg0[1]+"_"+time));
			
			return job.waitForCompletion(true)?0:1;
	}
	public static void main(String[] args) throws Exception {
		
		
		int result=ToolRunner.run(new JoinDriver(), args);
		System.exit(result);
		
		
	}
	
}






