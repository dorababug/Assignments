import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;

public class WordCountDriver extends Configured implements Tool{

	@Override
	public int run(String[] arg0) throws Exception {
		
		
		//Configuration conf=new Configuration();
		Configuration conf=this.getConf();
		//conf.set("sword",args[0]);
		//conf.set("sword","apache1");
		
		System.out.println("++++++Lenght"+arg0.length);
		for (int i = 0; i < arg0.length; i++) {
			System.out.println(i+"th property in RUN method::"+arg0[i]);
		}
		
		Job job=Job.getInstance(conf);
		
		job.setJobName("Word Count");
		
		job.setJarByClass(WordCountDriver.class);
		job.setMapperClass(WordCountMapper.class);
		job.setReducerClass(WordCountReducer.class);
		
		//job.setNumReduceTasks(0);
		//job.setCombinerClass(WordCountReducer.class);
		
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(NullWritable.class);
		
		FileInputFormat.addInputPath(job, new Path(arg0[0]));
		FileOutputFormat.setOutputPath(job, new Path(arg0[1]));
		
		//boolean status=job.waitForCompletion(true);
		
		return job.waitForCompletion(true)?0:1;
		
		
		
	}
	
	
	
	public static void main(String[] args) throws Exception {
		
		System.out.println("++++++Lenght"+args.length);
		for (int i = 0; i < args.length; i++) {
			System.out.println(i+"th property in Main::"+args[i]);
		}
		
		int result=ToolRunner.run(new WordCountDriver(), args);
		
		System.exit(result);
				
		
	}

	
}
