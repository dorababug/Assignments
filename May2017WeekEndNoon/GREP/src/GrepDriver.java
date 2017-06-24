import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class GrepDriver {

	public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
		
		Configuration conf=new Configuration();
		Job job=Job.getInstance(conf, "GREP");
		
		job.setJarByClass(GrepDriver.class);
		job.setMapperClass(GrepMapper.class);
		//job.setReducerClass(WordCountReducer.class);
		
		job.setNumReduceTasks(0);
		
	job.setOutputKeyClass(Text.class);
	job.setOutputValueClass(NullWritable.class);
		
		Date dt=new Date();
		SimpleDateFormat format=new SimpleDateFormat("YYYY_M_DD_H_m_S");
		String ts=format.format(dt);
		System.out.println("++++++++ Time Stamp is::"+ts);	
				
		FileInputFormat.addInputPath(job, new Path(args[0]));
		FileOutputFormat.setOutputPath(job, new Path(args[1]+ts));
		
		boolean result=job.waitForCompletion(true);
		
		System.exit(result?0:1);
		
	}
	
}
