import java.io.IOException;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.KeyValueTextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.SequenceFileOutputFormat;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;

public class DemoDriver extends Configured implements Tool{
	@Override
	public int run(String[] db) throws Exception {
		for (int i = 0; i < db.length; i++) {
			System.out.println("++++ In RUN METHOD arugements are:::"+db[i]);
		}
		
		
	//Configuration conf=new Configuration();
		Configuration conf=this.getConf();
		//conf.set("mapreduce.input.keyvaluelinerecordreader.key.value.separator", " ");
		//conf.set("mapreduce.output.textoutputformat.separator", "#");
		
		Job job=Job.getInstance(conf);
		job.setJobName("Demo Input Output Formats");
		//mapreduce.job.name
		//mapreduce.job.reduces
		
		job.setJarByClass(DemoDriver.class);
		job.setMapperClass(DemoMapper.class);
		job.setNumReduceTasks(0);
		
		//Use other than TextInputFormat
		job.setInputFormatClass(KeyValueTextInputFormat.class);
		
		job.setOutputFormatClass(SequenceFileOutputFormat.class);
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(Text.class);
		
		
		
		FileInputFormat.addInputPath(job, new Path(db[0]));
		FileOutputFormat.setOutputPath(job, new Path(db[1]));
		
		return job.waitForCompletion(true)?0:1;
	}
	public static void main(String[] args) throws Exception {
		
		for (int i = 0; i < args.length; i++) {
			System.out.println("++++ In MAIN arugements are:::"+args[i]);
		}
		
		int res=ToolRunner.run(new DemoDriver(), args);
		System.exit(res);
		
	}
	
}








